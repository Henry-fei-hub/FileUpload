package com.file.utils;

public class CommonUtils {

	public static Integer getFileType(String fileExtension) {
		if (null == fileExtension)
			return null;
		fileExtension = fileExtension.toLowerCase();
		switch (fileExtension) {
		case "xlsx":
		case "xlsm":
		case "xlsb":
		case "xls":
		case "xltx":
		case "xltm":
		case "xlt":
		case "csv":
		case "xlam":
		case "xla":
			return StaticUtils.FILE_TYPE_EXCEL;
		case "docx":
		case "docm":
		case "doc":
		case "dotx":
		case "dotm":
		case "dot":
			return StaticUtils.FILE_TYPE_WORD;
		case "pdf":
			return StaticUtils.FILE_TYPE_PDF;
		case "txt":
			return StaticUtils.FILE_TYPE_TXT;
		case "jpg":
		case "jpeg":
		case "png":
		case "gif":
		case "bmp":
			return StaticUtils.FILE_TYPE_IMAGE;
		case "mp3":
			return StaticUtils.FILE_TYPE_VOICE;
		case "ppt":
		case "pptx":
		case "pptm":
		case "potx":
		case "potm":
		case "pot":
		case "ppsx":
		case "ppsm":
		case "pps":
		case "ppam":
		case "ppa":
			return StaticUtils.FILE_TYPE_PPT;
		case "dwg":
		case "dwt":
		case "dxf":
		case "dws":
			return StaticUtils.FILE_TYPE_CAD;
		case "exe":
			return StaticUtils.FILE_TYPE_EXE;
		case "zip":
		case "rar":
		case "7z":
		case "bzip2":
		case "gzip":
		case "tar":
		case "wim":
		case "xz":
		case "arj":
		case "z":
			return StaticUtils.FILE_TYPE_ZIP;
		case "aiff":
		case "avi":
		case "mov":
		case "mpeg":
		case "mpg":
		case "qt":
		case "ram":
		case "viv":
		case "dat":
		case "ra":
		case "rm":
		case "rmvb":
		case "wmv":
		case "asf":
		case "vob":
		case "mp4":
		case "flv":
			return StaticUtils.FILE_TYPE_VIDEO;
		default:
			return StaticUtils.FILE_TYPE_UNKNOWN;
		}
	}

}
