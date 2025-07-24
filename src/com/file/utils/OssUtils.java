package com.file.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Formatter;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aliyun.oss.ClientBuilderConfiguration;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.common.utils.BinaryUtil;
import com.aliyun.oss.common.utils.IOUtils;
import com.aliyun.oss.internal.OSSHeaders;
import com.aliyun.oss.model.CannedAccessControlList;
import com.aliyun.oss.model.GenericResult;
import com.aliyun.oss.model.GetObjectRequest;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.ProcessObjectRequest;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.StorageClass;
import com.file.db.bean.BaseSystemConfig;
import com.file.db.dao.SystemConfig;

import delicacy.common.BaseHelpUtils;
import delicacy.common.JsonParser;

@SuppressWarnings("unused")
public class OssUtils {

    
	private static final OssUtils instance = new OssUtils();

    private static String endpoint;
    private static String accessKeyId;
    private static String accessKeySecret;
    private static String bucketName;
    public static String filePref;

    private static Logger logger = LoggerFactory.getLogger(OssUtils.class);

    private OssUtils() {
        try {
            SystemConfig scDao = new SystemConfig();
            scDao.setConditionConfigType("=", 27);
            BaseSystemConfig systemConfig = scDao.executeQueryOneRow();
            if (!BaseHelpUtils.isNullOrEmpty(systemConfig)) {
                endpoint = systemConfig.getHostName();
                accessKeyId = systemConfig.getCorpId();
                accessKeySecret = systemConfig.getCorpSecret();
                bucketName = systemConfig.getFromTitle();
                filePref = systemConfig.getImagePath();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    /**
     * 上传本地图片
     *
     * @param inputStream
     * @param objectName
     * @return
     */
    @SuppressWarnings("finally")
	public static boolean uploadFileByStream(InputStream inputStream, String objectName) {
        OSS ossClient = null;
        boolean isSuccess = true;
        try {
            ClientBuilderConfiguration conf = new ClientBuilderConfiguration();
            conf.setCrcCheckEnabled(false);

            // 创建OSSClient实例。


            ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret,conf);
            // 填写本地文件的完整路径。如果未指定本地路径，则默认从示例程序所属项目对应本地路径中上传文件流。
//        InputStream inputStream = new FileInputStream("D:\\localpath\\examplefile.txt");
            // 依次填写Bucket名称（例如examplebucket）和Object完整路径（例如exampledir/exampleobject.txt）。Object完整路径中不能包含Bucket名称。

            //设置md5校验
            ObjectMetadata meta = new ObjectMetadata();
            byte[] fileByte = IOUtils.readStreamAsByteArray(inputStream);
            String md5 = BinaryUtil.toBase64String(BinaryUtil.calculateMd5(fileByte));
            meta.setContentMD5(md5);
            ossClient.putObject(bucketName, objectName, new ByteArrayInputStream(fileByte), meta);

//            ossClient.putObject(bucketName, objectName, inputStream);

            //设置权限
            ossClient.setObjectAcl(bucketName, objectName, CannedAccessControlList.PublicRead);

            // 关闭OSSClient。
        } catch (OSSException e) {
            e.printStackTrace();
            isSuccess = false;
        } finally {
            // 关闭OSSClient。
            ossClient.shutdown();
            return isSuccess;
        }

    }


    public static InputStream getFileInputStream(String fileName) throws IOException {
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        OSSObject ossObject = ossClient.getObject(bucketName, getObjectName(fileName));
        try {
            InputStream out = ossObject.getObjectContent();
            byte[] bytes = toByteArray(out);
            return new ByteArrayInputStream(bytes);
        }finally {
            ossClient.shutdown();
        }
    }

    /**
     * InputStream流转byte数组
     *
     * @param input
     * @return
     * @throws IOException
     */
    public static byte[] toByteArray(InputStream input) throws IOException {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        byte[] buffer = new byte[input.available()];
        int n = 0;
        while (-1 != (n = input.read(buffer))) {
            output.write(buffer, 0, n);
        }
        return output.toByteArray();
    }

    /**
     * 获取图片压缩路径
     *
     * @param url
     * @return
     */
    public static String getCompressUrl(String url, String type) {
        if (BaseHelpUtils.isNullOrEmpty(url)) {
            return "";
        }

        if (url.contains("/Material/")) {
            url = url.replace("/Material/", "Material/");
        }

        int index = url.lastIndexOf(".");
        String subfix = "";
        if (index >= 0 && !url.contains("_" + type + ".")) {
            subfix = url.substring(0, index) + "_" + type + url.substring(index);
            return subfix;
        }
        return url;
    }


    public static String getObjectName(String url) {
        if (url.contains("/Material/")) {
            url = url.replace("/Material/", "Material/");
        }
        return url;
    }


    /**
     * 压缩图片
     *
     * @param param
     * @return
     */
    @SuppressWarnings({ "resource", "unchecked" })
	public static long compressImg(Map<String, String> param) {

        String type = param.get("type");
        String sourceImage = param.get("source");
        String width = param.get("width");
        String height = param.get("height");

        long fileSize = 0;

        String targetImage = getCompressUrl(sourceImage, type);

//        String sourceImage  = "Material/2021-10-12/1a4269be1dd94773863f3fb88cdeab25_standard.jpg";
//        String targetImage = "Material/2021-10-12/1a4269be1dd94773863f3fb88cdeab25_matrix.jpg";

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        try {
            // 将图片缩放为固定宽高100 px。
            StringBuilder sbStyle = new StringBuilder();
            Formatter styleFormatter = new Formatter(sbStyle);
            String styleType = "image/resize,m_fixed,w_" + width + ",h_" + height;
            // 将处理后的图片命名为example-resize.png并保存到当前Bucket。
            // 填写Object完整路径。Object完整路径中不能包含Bucket名称。

            styleFormatter.format("%s|sys/saveas,o_%s,b_%s", styleType,
                    BinaryUtil.toBase64String(targetImage.getBytes()),
                    BinaryUtil.toBase64String(bucketName.getBytes()));
            System.out.println(sbStyle.toString());
            ProcessObjectRequest request = new ProcessObjectRequest(bucketName, sourceImage, sbStyle.toString());

//            // 如果需要上传时设置存储类型和访问权限，请参考以下示例代码。
//            ObjectMetadata metadata = new ObjectMetadata();
//            metadata.setHeader(OSSHeaders.OSS_STORAGE_CLASS, StorageClass.Standard.toString());
//            metadata.setObjectAcl(CannedAccessControlList.PublicRead);
//            request.setMetadata(metadata);

            GenericResult processResult = ossClient.processObject(request);
            String json = IOUtils.readStreamAsString(processResult.getResponse().getContent(), "UTF-8");
            Map<String, Object> resultMap = (Map<String, Object>) JsonParser.parse(json);
            fileSize = BaseHelpUtils.getLongValue(resultMap.get("fileSize"));
            processResult.getResponse().getContent().close();
            System.out.println(json);

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("fileUrl:"+sourceImage+", 异常信息:",e);
        } finally {
            //设置权限
            ossClient.setObjectAcl(bucketName, targetImage, CannedAccessControlList.PublicRead);
            // 关闭OSSClient。
            ossClient.shutdown();
        }


        return fileSize;

    }


    /**
     * 上传网络图片
     */
    public synchronized static boolean uploadWebFile(String fileUrl, String objectName) {
        boolean isSuccess = false;

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        HttpURLConnection htpcon = null;
        InputStream inputStream = null;
        try {
            // 填写网络流地址。
//            InputStream inputStream = new URL("https://erp.jaid.cn/Material/2021-10-12/1a4269be1dd94773863f3fb88cdeab25_standard.jpg").openStream();


            URL url = new URL(fileUrl);
            htpcon = (HttpURLConnection) url.openConnection();
            htpcon.setRequestMethod("GET");
            htpcon.setDoOutput(true);
            htpcon.setDoInput(true);
            htpcon.setUseCaches(false);
            htpcon.setConnectTimeout(10000);
            htpcon.setReadTimeout(10000);
            inputStream = htpcon.getInputStream();

//            InputStream inputStream =  returnBitMap("https://erp.jaid.cn/Material/2021-10-12/1a4269be1dd94773863f3fb88cdeab25_standard.jpg");


            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, objectName, inputStream);


            // 如果需要上传时设置存储类型和访问权限，请参考以下示例代码。
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setHeader(OSSHeaders.OSS_STORAGE_CLASS, StorageClass.Standard.toString());
            metadata.setObjectAcl(CannedAccessControlList.PublicRead);
            putObjectRequest.setMetadata(metadata);

            // 依次填写Bucket名称（例如examplebucket）和Object完整路径（例如exampledir/exampleobject.txt）。Object完整路径中不能包含Bucket名称。
            ossClient.putObject(putObjectRequest);
            isSuccess = true;


        } catch (OSSException | IOException e) {
            e.printStackTrace();
            logger.error("fileUrl:"+fileUrl+",  异常信息:",e);
            isSuccess = false;
        } finally {
            // 关闭OSSClient。
            ossClient.shutdown();
            if(inputStream!=null){

                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    logger.error("fileUrl:"+fileUrl+",  异常信息:",e);
                }
            }
            if (htpcon != null) {
                try {
                    htpcon.disconnect();
                } catch (Exception e) {
                    e.printStackTrace();
                    logger.error("fileUrl:"+fileUrl+",  异常信息:",e);
                }
            }
        }
        return isSuccess;

    }

    /**
     * 文件简单下载
     * @param objectName 下载的文件路径 Material/2021-11-01/1968ab33bab5462f9eb92f0cb1d59fb6.jpg
     * @param filePath  保存文件路径 D:\test\
     * @param fileName 保存文件名 1.jpg
     */
    public static void downFile( String objectName, String filePath, String fileName) {
        try {

            // 创建OSSClient实例。
            OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

            // 下载Object到本地文件，并保存到指定的本地路径中。如果指定的本地文件存在会覆盖，不存在则新建。
            // 如果未指定本地路径，则下载后的文件默认保存到示例程序所属项目对应本地路径中。
            if(BaseHelpUtils.isNullOrEmpty(filePath) || BaseHelpUtils.isNullOrEmpty(fileName))
                ossClient.getObject(new GetObjectRequest(bucketName, objectName), new File(filePath + fileName));
            else
                ossClient.getObject(new GetObjectRequest(bucketName, objectName));
            // 关闭OSSClient。
            ossClient.shutdown();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 浏览器下载
     * @param objectName
     * @param fileName
     * @param response
     */

    public static void downFileByStream(String objectName, String fileName, HttpServletResponse response) {


        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        // ossObject包含文件所在的存储空间名称、文件名称、文件元信息以及一个输入流。
        OSSObject ossObject = ossClient.getObject(bucketName, objectName);

        if (ossObject != null) {
            InputStream inputStream = ossObject.getObjectContent();
            int buffer = 1024 * 10;
            byte data[] = new byte[buffer];
            try {
                response.setContentType("application/octet-stream");
                // 文件名能够任意指定
                response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));//将文件名转为ASCLL编码
                int read;
                while ((read = inputStream.read(data)) != -1) {
                    response.getOutputStream().write(data, 0, read);
                }
                response.getOutputStream().flush();
                response.getOutputStream().close();
                ossObject.close();
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
//            // 读取文件内容。
//            System.out.println("Object content:");
//            BufferedReader reader = new BufferedReader(new InputStreamReader(ossObject.getObjectContent()));
//            while (true) {
//                String line = reader.readLine();
//                if (line == null) break;
//
//                System.out.println("\n" + line);
//            }
//            // 数据读取完成后，获取的流必须关闭，否则会造成连接泄漏，导致请求无连接可用，程序无法正常工作。
//            reader.close();
//
//            // 关闭OSSClient。
//            ossClient.shutdown();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }







}
