package com.file.utils;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.util.List;

import com.file.db.bean.BaseFileManage;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;

public class StaticResourceServerUtils {
	
    /**
     * 上传文件
     * @param uploadUrl 上传url
     * @param applicationId	应用ID
     * @param uploader	上传人ID
     * @param filePathArr	上传文件的绝对路径
     * @return
     */
    public static String uploadFile(String uploadUrl, Integer applicationId, Integer uploader, String... filePathArr) {
    	if(BaseHelpUtils.isNullOrEmpty(uploadUrl) || null == applicationId || null == uploader || null == filePathArr || filePathArr.length == 0) {
    		return null;
    	}
        String res = "";
        HttpURLConnection conn = null;
        String BOUNDARY = "---------------------------300668"; //boundary就是request头和上传文件内容的分隔符
        try {
            URL url = new URL(uploadUrl);
            conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(30000);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 6.1; zh-CN; rv:1.9.2.6)");
            conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + BOUNDARY);

            OutputStream out = new DataOutputStream(conn.getOutputStream());
            
            StringBuffer strBuf = new StringBuffer();
            
            //应用ID
            strBuf.append("\r\n").append("--").append(BOUNDARY).append("\r\n");
            strBuf.append("Content-Disposition: form-data; name=\"applicationId\"\r\n\r\n");
            strBuf.append(applicationId);
            
            //上传者ID
            strBuf.append("\r\n").append("--").append(BOUNDARY).append("\r\n");
            strBuf.append("Content-Disposition: form-data; name=\"uploader\"\r\n\r\n");
            strBuf.append(uploader);
            
            out.write(strBuf.toString().getBytes());
            
            for(String path : filePathArr) {
            	if(BaseHelpUtils.isNullOrEmpty(path)) {
            		continue;
            	}
            	File file = new File(path);
				String filename = file.getName();
				String contentType = Files.probeContentType(file.toPath());
				
				strBuf.setLength(0);
				strBuf.append("\r\n").append("--").append(BOUNDARY).append("\r\n");
				strBuf.append("Content-Disposition: form-data; name=\"Filedata\"; filename=\"" + filename + "\"\r\n");
				strBuf.append("Content-Type:" + contentType + "\r\n\r\n");
				
				out.write(strBuf.toString().getBytes());
				
				DataInputStream in = new DataInputStream(new FileInputStream(file));
				int bytes = 0;
				byte[] bufferOut = new byte[1024];
				while ((bytes = in.read(bufferOut)) != -1) {
					out.write(bufferOut, 0, bytes);
				}
				in.close();
            }

            byte[] endData = ("\r\n--" + BOUNDARY + "--\r\n").getBytes();
            out.write(endData);
            out.flush();
            out.close();

            // 读取返回数据
            strBuf.setLength(0);
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "gbk"));
            String line = null;
            while ((line = reader.readLine()) != null) {
                strBuf.append(line).append("\n");
            }
            res = strBuf.toString();
            reader.close();
            reader = null;
        } catch (Exception e) {
            System.out.println("发送POST请求出错。" + uploadUrl);
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.disconnect();
                conn = null;
            }
        }
        return res;
    }
    
    /**
     * 上传文件并返回BaseFileManage的List集合
     * @param uploadUrl 上传url
     * @param applicationId	应用ID
     * @param uploader	上传人ID
     * @param filePathArr	上传文件的绝对路径
     * @return
     * @throws Exception
     */
    public static List<BaseFileManage> uploadFileReturnList(String uploadUrl, Integer applicationId, Integer uploader, String... filePathArr) throws Exception {
    	String str = uploadFile(uploadUrl, applicationId, uploader, filePathArr);
    	if(BaseHelpUtils.isNullOrEmpty(str)) {
    		return null;
    	}
    	BaseCollection<BaseFileManage> bc = new BaseCollection<>();
    	bc.setDataFromJSON(BaseFileManage.newInstance(), str);
    	return bc.getCollections();
    }
}
