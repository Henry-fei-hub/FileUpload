package com.file.business;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.lang3.ArrayUtils;

import com.file.business.Scalr.Mode;
import com.file.db.bean.BaseFileManage;
import com.file.db.bean.BaseImageConfig;
import com.file.db.dao.FileManage;
import com.file.db.dao.ImageConfig;
import com.file.utils.CommonUtils;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.connection.ThreadUtil;
import delicacy.date.util.DateUtil;
import net.coobird.thumbnailator.Thumbnails;

@WebServlet(name = "FileUpload", loadOnStartup = 1, urlPatterns = {"/FileUpload"})
@MultipartConfig(location = "/tmp", fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 1024 * 5 * 10)
public class FileUpload extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = null;
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
                String relativePath = "/files/" + DateUtil.formatDateString(date) + "/";
                basePath = basePath + relativePath;
                File baseFile = new File(basePath);
                if (!baseFile.exists()) {
                    baseFile.mkdirs();
                }
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
                        String url = baseFile + "/" + UUIDCode + "." + fileExt;
                        File file = new File(url);
                        fileBean.setFileUrl(relativePath + file.getName());
                        InputStream in = obj.getInputStream();
                        OutputStream os = new FileOutputStream(file);
                        byte[] buffer = new byte[1024];
                        int length = -1;
                        while ((length = in.read(buffer)) != -1) {
                            os.write(buffer, 0, length);
                        }
                        in.close();
                        os.close();
                        if (ArrayUtils.contains(ImageIO.getReaderFormatNames(), fileExt)) {
                        	BufferedImage bi =ImageIO.read(obj.getInputStream());
                        	fileBean.setImgWidth(bi.getWidth());
                        	fileBean.setImgHeight(bi.getHeight());
                        	if(null != imgConfigBean) {
	                            File toPic1 = new File(url.replace(UUIDCode, UUIDCode + "_icon"));
	                            File toPic2 = new File(url.replace(UUIDCode, UUIDCode + "_thumbnail"));
	                            File toPic3 = new File(url.replace(UUIDCode, UUIDCode + "_matrix"));
	                            File toPic4 = new File(url.replace(UUIDCode, UUIDCode + "_standard"));
	                            if (fileExt.equals("gif")) {
	                                List<File> fileList = new ArrayList<>();
	                                fileList.add(toPic1);
	                                fileList.add(toPic2);
	                                fileList.add(toPic3);
	                                fileList.add(toPic4);
	                                GifDecoder gd = new GifDecoder();
	                                int status = gd.read(new FileInputStream(file));
	                                if (status == GifDecoder.STATUS_OK) {
	                                    int width = BaseHelpUtils.getIntValue(imgConfigBean.getIconImgWidth());
	                                    int height = BaseHelpUtils.getIntValue(imgConfigBean.getIconImgHeight());
	                                    for (File toFile : fileList) {
	                                        AnimatedGifEncoder ge = new AnimatedGifEncoder();
	                                        ge.start(new FileOutputStream(toFile));
	                                        ge.setRepeat(0);
	                                        if (toFile.getName().contains("thumbnail")) {
	                                            width = BaseHelpUtils.getIntValue(imgConfigBean.getThumbnailImgWidth());
	                                            height = BaseHelpUtils.getIntValue(imgConfigBean.getThumbnailImgHeight());
	                                        } else if (toFile.getName().contains("matrix")) {
	                                            width = BaseHelpUtils.getIntValue(imgConfigBean.getMatrixImgWidth());
	                                            height = BaseHelpUtils.getIntValue(imgConfigBean.getMatrixImgHeight());
	                                        } else if (toFile.getName().contains("standard")) {
	                                            width = BaseHelpUtils.getIntValue(imgConfigBean.getStandardImgWidth());
	                                            height = BaseHelpUtils.getIntValue(imgConfigBean.getStandardImgHeight());
	                                        }
	                                        if (width > 0 && height > 0) {
	                                            for (int i = 0; i < gd.getFrameCount(); i++) {
	                                                BufferedImage frame = gd.getFrame(i);
	                                                BufferedImage rescaled = Scalr.resize(frame, Mode.AUTOMATIC, width, height);
	                                                int delay = gd.getDelay(i);
	                                                ge.setDelay(delay);
	                                                ge.addFrame(rescaled);
	                                            }
	                                            ge.finish();
	                                        }
	                                    }
	                                }
	                            } else {
	                                uploadImg(imgConfigBean.getIconImgWidth(), imgConfigBean.getIconImgHeight(), file, toPic1);
	                                uploadImg(imgConfigBean.getThumbnailImgWidth(), imgConfigBean.getThumbnailImgHeight(), file, toPic2);
	                                uploadImg(imgConfigBean.getMatrixImgWidth(), imgConfigBean.getMatrixImgHeight(), file, toPic3);
	                                uploadImg(imgConfigBean.getStandardImgWidth(), imgConfigBean.getStandardImgHeight(), file, toPic4);
	                            }
	                            fileBean.setIconImg(relativePath + toPic1.getName());
	                            fileBean.setIconImgSize(toPic1.length());
	                            fileBean.setThumbnailImg(relativePath + toPic2.getName());
	                            fileBean.setThumbnailImgSize(toPic2.length());
	                            fileBean.setMatrixImg(relativePath + toPic3.getName());
	                            fileBean.setMatrixImgSize(toPic3.length());
	                            fileBean.setStandardImg(relativePath + toPic4.getName());
	                            fileBean.setStandardImgSize(toPic4.length());
                        	}
                        }
                        list.add(fileBean);
                    }
                }
                FileManage fileDao = new FileManage();
                fileDao.save(list);
                bc.setCollections(list);
                out = resp.getWriter();
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
}
