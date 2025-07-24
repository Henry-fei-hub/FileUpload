package com.file.utils;

public class StaticUtils {
    /**
     * 文件类型：未知文件类型
     */
    public static final int FILE_TYPE_UNKNOWN = -1;
    /**
     * 文件类型：文件夹
     */
    public static final int FILE_TYPE_FOLDER = 0;
    /**
     * 文件类型：文本txt
     */
    public static final int FILE_TYPE_TXT = 1;
    /**
     * 文件类型：PDF
     */
    public static final int FILE_TYPE_PDF = 2;
    /**
     * 文件类型：表格excel
     */
    public static final int FILE_TYPE_EXCEL = 3;
    /**
     * 文件类型：文档word
     */
    public static final int FILE_TYPE_WORD = 4;   
    /**
     * 文件类型：图片
     */
    public static final int FILE_TYPE_IMAGE = 5;   
    /**
     * 文件类型：音频文件
     */
    public static final int FILE_TYPE_VOICE = 6;   
    /**
     * 文件类型：ppt
     */
    public static final int FILE_TYPE_PPT = 7;   
    /**
     * 文件类型：autoCad
     */
    public static final int FILE_TYPE_CAD = 8;  
    /**
     * 文件类型：exe
     */
    public static final int FILE_TYPE_EXE = 9;
    /**
     * 文件类型：zip
     */
    public static final int FILE_TYPE_ZIP = 10;
    /**
     * 文件类型：视频
     */
    public static final int FILE_TYPE_VIDEO = 11;


    /**
     * 流程节点类型：处理节点
     */
    public static final Integer ACTIVITY_TYPE_HANDEL = 3;


    /**
     * 公用序列号类型:项目编号和合同模块
     */
    public static final Integer SERIAL_TYPE_ONE = 1;



    /**
     * 投标立项
     */
    public static final Integer PROJECT_BASE_ON_1 = 1;

    /**
     * 合同立项
     */
    public static final Integer PROJECT_BASE_ON_2 = 2;

    /**
     * 委托函立项
     */
    public static final Integer PROJECT_BASE_ON_3 = 3;

    /**
     * 方案比选立项
     */
    public static final Integer PROJECT_BASE_ON_4 = 4;


    /**
     * 合同状态：未出结果
     */
    public static final int CONTRACT_STATUS_1 = 1;
    /**
     * 合同状态：落标项目
     */
    public static final int CONTRACT_STATUS_2 = 2;
    /**
     * 合同状态：无效项目
     */
    public static final int CONTRACT_STATUS_3 = 3;
    /**
     * 合同状态：项目缓慢
     */
    public static final int CONTRACT_STATUS_4 = 4;
    /**
     * 合同状态：项目暂停
     */
    public static final int CONTRACT_STATUS_5 = 5;
    /**
     * 合同状态：合同运行
     */
    public static final int CONTRACT_STATUS_6 = 6;
    /**
     * 合同状态：合同运行-收尾
     */
    public static final int CONTRACT_STATUS_7 = 7;
    /**
     * 合同状态：合同暂停
     */
    public static final int CONTRACT_STATUS_8 = 8;
    /**
     * 合同状态：合同缓慢
     */
    public static final int CONTRACT_STATUS_9 = 9;
    /**
     * 合同状态：合同终止-结算中
     */
    public static final int CONTRACT_STATUS_10 = 10;
    /**
     * 合同状态：合同终止
     */
    public static final int CONTRACT_STATUS_11 = 11;
    /**
     * 合同状态：合同结束
     */
    public static final int CONTRACT_STATUS_12 = 12;
    /**
     * 合同状态：项目终止-结算中
     */
    public static final int CONTRACT_STATUS_13 = 13;
    /**
     * 合同状态：项目终止
     */
    public static final int CONTRACT_STATUS_14 = 14;
    
    /** 文件传输状态: 新建 */
	public static final int TRANSFER_STATUS_NEW = 1;
	
	/** 文件传输状态: 进行中 */
	public static final int TRANSFER_STATUS_DOING = 2;
	
	/** 文件传输状态: 完成 */
	public static final int TRANSFER_STATUS_DONE = 3;
	
	/** 文件传输状态: 失败 */
	public static final int TRANSFER_STATUS_FAILURE = 4;
	
	/** 文件传输状态: 作废 */
	public static final int TRANSFER_STATUS_CANCEL = 5;
	
	/** 文件传输类型: 下载*/
	public static final int TRANSFER_TYPE_DOWNLOAD = 1;
	
	/** 文件传输类型: 上传 */
	public static final int TRANSFER_TYPE_UPLOAD = 2;
}
