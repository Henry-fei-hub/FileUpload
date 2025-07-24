package com.file.business;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.log4j.Logger;

import com.file.db.bean.BaseFileManage;
import com.file.db.bean.BaseImageConfig;
import com.file.db.dao.FileManage;
import com.file.db.dao.ImageConfig;
import com.file.utils.CommonUtils;
import com.file.utils.OssUtils;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.connection.ThreadUtil;
import delicacy.date.util.DateUtil;
import net.coobird.thumbnailator.Thumbnails;
import sun.misc.BASE64Encoder;

@WebServlet(name = "FileUploadByOSS", loadOnStartup = 1, urlPatterns = {"/FileUploadByOSS"})
@MultipartConfig(location = "/tmp", fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 1024 * 5 * 10)
public class FileUploadByOSS extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(FileUploadByOSS.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @SuppressWarnings({ "unused", "null" })
	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        resp.addHeader("Access-Control-Allow-Origin", "*");
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/plain;charset=gb2312");
        logger.info("文件上传任务开始");
        System.out.println("文件上传任务开始");

        PrintWriter  out = resp.getWriter();
        BaseCollection<BaseFileManage> bc = new BaseCollection<>();
        try {
            req.setCharacterEncoding("UTF-8");
            resp.setContentType("text/plain;charset=gb2312");
            Collection<Part> collection = req.getParts();
            if (null != collection && !collection.isEmpty()) {
                int uploader = BaseHelpUtils.getIntValue(req.getParameter("uploader"));
                int applicationId = BaseHelpUtils.getIntValue(req.getParameter("applicationId"));
                System.out.println("uploader:" + uploader);
                System.out.println("applicationId:" + applicationId);
                String basePath = ThreadUtil.getRealPath();
                if (basePath == null) {
                    basePath = "/temp";
                }
                Date date = new Date();
                String relativePath = "OSS/" + DateUtil.formatDateString(date) ;
//                basePath = basePath + relativePath;
//                File baseFile = new File(basePath);
//                if (!baseFile.exists()) {
//                    baseFile.mkdirs();
//                }
                List<BaseFileManage> list = new ArrayList<>();
                ImageConfig imgConfigDao = new ImageConfig();
                imgConfigDao.setConditionApplicationId("=", applicationId);
                BaseImageConfig imgConfigBean = null;
                if (imgConfigDao.countRows() > 0) {
                    imgConfigBean = imgConfigDao.executeQueryOneRow();
                } else {
                    imgConfigDao.setConditionApplicationId("=", 0);
                    imgConfigBean = imgConfigDao.executeQueryOneRow();
                }
                for (Part obj : collection) {
                    if (obj.getName().equals("Filedata")) {
                        String fileName = obj.getSubmittedFileName();
                        String fileExt = obj.getSubmittedFileName().substring(obj.getSubmittedFileName().lastIndexOf(".") + 1).toLowerCase();
                        BaseFileManage fileBean = new BaseFileManage();
                        fileBean.setUploader(uploader);
                        fileBean.setFileName(fileName);
                        fileBean.setFileExtension(fileExt);
                        fileBean.setFileSize(obj.getSize());
                        fileBean.setFileType(CommonUtils.getFileType(fileExt));
                        String UUIDCode = UUID.randomUUID().toString().replaceAll("-", "");
                        String url = relativePath + "/" + UUIDCode + "." + fileExt;

                        long startUploadTime = System.currentTimeMillis();
                        logger.info("原始文件上传开始");

                        InputStream in = obj.getInputStream();
                        Boolean isSuccess = OssUtils.uploadFileByStream(in, url);

                        logger.info("原始文件上传结束");
                        long endUploadTime = System.currentTimeMillis();
                        logger.info("原始文件上传耗时：" + (endUploadTime-startUploadTime) );

                        if (!isSuccess) {
                            out.write(bc.toJSON(-1, "上传失败"));
                            return ;
                        }
                        
                        

                        fileBean.setFileUrl(OssUtils.filePref+"/" + url);
                        if(applicationId ==2) {
                        	String base64 = image2Base64(fileBean.getFileUrl());
                        	if(!BaseHelpUtils.isNullOrEmpty(base64)) {
                        		fileBean.setVideoImage(base64);
                        	}
                        }
                        list.add(fileBean);

                    }
                }
                FileManage fileDao = new FileManage();
                fileDao.save(list);
                bc.setCollections(list);
               
                out.write(bc.toJSON());
            }
        } catch (Exception e) {
            e.printStackTrace();
            out.write(bc.toJSON(-1, "上传失败"));
        } finally {
            if (null != out) {
                out.close();
            }
        }
    }

    public void uploadImg(Integer width, Integer height, File originImgFile, File targetImgFile) throws IOException {
        width = BaseHelpUtils.getIntValue(width);
        height = BaseHelpUtils.getIntValue(height);
        if (width.intValue() > 0 && height.intValue() > 0) {
            Thumbnails.of(originImgFile).size(width, height).toFile(targetImgFile);
        }
    }
    
    public static String image2Base64(String imgUrl) {
        //String suffix = imgUrl.substring(imgUrl.lastIndexOf(".") + 1);

        URL url = null;
        InputStream is = null;
        ByteArrayOutputStream outStream = null;
        HttpURLConnection httpUrl = null;
        try{
            url = new URL(imgUrl);
            httpUrl = (HttpURLConnection) url.openConnection();
            httpUrl.connect();
            httpUrl.getInputStream();
            is = httpUrl.getInputStream();
            outStream = new ByteArrayOutputStream();
            //创建一个Buffer字符串
            byte[] buffer = new byte[1024];
            //每次读取的字符串长度，如果为-1，代表全部读取完毕
            int len = 0;
            //使用一个输入流从buffer里把数据读取出来
            while( (len=is.read(buffer)) != -1 ){
                //用输出流往buffer里写入数据，中间参数代表从哪个位置开始读，len代表读取的长度
                outStream.write(buffer, 0, len);
            }
            // 对字节数组Base64编码
            return encode(outStream.toByteArray());
//            return encode(outStream.toByteArray(),suffix);
        }catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            if(is != null)
            {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(outStream != null)
            {
                try {
                    outStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(httpUrl != null)
            {
                httpUrl.disconnect();
            }
        }
        return imgUrl;
    }
 
    public static String encode(byte[] image){
    	BASE64Encoder decoder = new BASE64Encoder();
    	return replaceEnter(decoder.encode(image));
    }
    
 	public static String replaceEnter(String str){
		String reg ="[\n-\r]";
		Pattern p = Pattern.compile(reg);
		Matcher m = p.matcher(str);
		return m.replaceAll("");
	}
}



//|5 | 首次登录 点击跳往消息详情页面   |
//|6 | 材料上架 点击跳往材料详情页 objectId值为材料id   |
//|7 | 案例上架 点击跳往案例详情页 objectId值为案例id  **（待开发）** |
//|8 | 材料册生成成功 点击跳转项目详情页 objectId值为项目id   |
//|9 | 样品订单审核成功 点击跳转样品订单详情页 objectId值为订单id  **（待开发）** |
//|10 | 样品订单已发货 点击跳转样品订单详情页 objectId值为订单id  **（待开发）** |