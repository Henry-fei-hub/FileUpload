package com.file.db.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseFileManage extends GenericBase implements BaseFactory<BaseFileManage>, Comparable<BaseFileManage> 
{


	public static BaseFileManage newInstance(){
		return new BaseFileManage();
	}

	@Override
	public BaseFileManage make(){
		BaseFileManage b = new BaseFileManage();
		return b;
	}

	public final static java.lang.String CS_FILE_ID = "file_id" ;
	public final static java.lang.String CS_FILE_NAME = "file_name" ;
	public final static java.lang.String CS_FILE_EXTENSION = "file_extension" ;
	public final static java.lang.String CS_FILE_TYPE = "file_type" ;
	public final static java.lang.String CS_FILE_SIZE = "file_size" ;
	public final static java.lang.String CS_FILE_URL = "file_url" ;
	public final static java.lang.String CS_ICON_IMG = "icon_img" ;
	public final static java.lang.String CS_ICON_IMG_SIZE = "icon_img_size" ;
	public final static java.lang.String CS_THUMBNAIL_IMG = "thumbnail_img" ;
	public final static java.lang.String CS_THUMBNAIL_IMG_SIZE = "thumbnail_img_size" ;
	public final static java.lang.String CS_MATRIX_IMG = "matrix_img" ;
	public final static java.lang.String CS_MATRIX_IMG_SIZE = "matrix_img_size" ;
	public final static java.lang.String CS_STANDARD_IMG = "standard_img" ;
	public final static java.lang.String CS_STANDARD_IMG_SIZE = "standard_img_size" ;
	public final static java.lang.String CS_CITATION_TIMES = "citation_times" ;
	public final static java.lang.String CS_UPLOADER = "uploader" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_UPDATE_TIME = "update_time" ;
	public final static java.lang.String CS_VIDEO_IMAGE = "video_image" ;
	public final static java.lang.String CS_VIDEO_IMAGE_SIZE = "video_image_size" ;
	public final static java.lang.String CS_IMG_WIDTH = "img_width" ;
	public final static java.lang.String CS_IMG_HEIGHT = "img_height" ;
	public final static java.lang.String CS_ICON_IMG_WIDTH = "icon_img_width" ;
	public final static java.lang.String CS_ICON_IMG_HEIGHT = "icon_img_height" ;
	public final static java.lang.String CS_THUMBNAIL_IMG_WIDTH = "thumbnail_img_width" ;
	public final static java.lang.String CS_THUMBNAIL_IMG_HEIGHT = "thumbnail_img_height" ;
	public final static java.lang.String CS_MATRIX_IMG_WIDTH = "matrix_img_width" ;
	public final static java.lang.String CS_MATRIX_IMG_HEIGHT = "matrix_img_height" ;
	public final static java.lang.String CS_STANDARD_IMG_WIDTH = "standard_img_width" ;
	public final static java.lang.String CS_STANDARD_IMG_HEIGHT = "standard_img_height" ;
	public final static java.lang.String CS_VIDEO_TIME = "video_time" ;
	public final static java.lang.String CS_DOMINANT_COLOR = "dominant_color" ;
	public final static java.lang.String CS_FILE_TRANSFER_KEY = "file_transfer_key" ;
	public final static java.lang.String CS_FILE_TRANSFER_STATUS = "file_transfer_status" ;
	public final static java.lang.String CS_ICON_IMG_TRANSFER_KEY = "icon_img_transfer_key" ;
	public final static java.lang.String CS_ICON_IMG_TRANSFER_STATUS = "icon_img_transfer_status" ;
	public final static java.lang.String CS_THUMBNAIL_IMG_TRANSFER_KEY = "thumbnail_img_transfer_key" ;
	public final static java.lang.String CS_THUMBNAIL_IMG_TRANSFER_STATUS = "thumbnail_img_transfer_status" ;
	public final static java.lang.String CS_MATRIX_IMG_TRANSFER_KEY = "matrix_img_transfer_key" ;
	public final static java.lang.String CS_MATRIX_IMG_TRANSFER_STATUS = "matrix_img_transfer_status" ;
	public final static java.lang.String CS_STANDARD_IMG_TRANSFER_KEY = "standard_img_transfer_key" ;
	public final static java.lang.String CS_STANDARD_IMG_TRANSFER_STATUS = "standard_img_transfer_status" ;
	public final static java.lang.String CS_VIDEO_IMAGE_TRANSFER_KEY = "video_image_transfer_key" ;
	public final static java.lang.String CS_VIDEO_IMAGE_TRANSFER_STATUS = "video_image_transfer_status" ;
	public final static java.lang.String CS_ORIGINAL_FILE_ID = "original_file_id" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,文件名,文件后缀,文件类型  system_dictionary_213,文件大小,文件路径,图标,图标文件大小,缩略图,缩略图文件大小,矩阵图,矩阵图文件大小,标准图,标准图文件大小,引用次数,上传者,创建时间,修改时间,视频截图图片,视频截图图片大小,图片宽度,图片高度,图标宽（单位像素）,图标高（单位像素）,缩略图宽（单位像素）,缩略图高（单位像素）,矩阵图宽（单位像素）,矩阵图高（单位像素）,标准图宽（单位像素）,标准图高（单位像素）,视频时间(单位 秒),主色彩,主文件传输key值, 4传输失败,图标传输key值, 4传输失败,缩略图传输key值, 4传输失败,矩阵图传输key值, 4传输失败,标准图传输key值, 4传输失败,视频截图图片传输key值, 4传输失败,原文件的编码";

	public java.lang.Integer getFileId() {
		return this.__file_id;
	}

	public void setFileId( java.lang.Integer value ) {
		this.__file_id = value;
	}

	public java.lang.String getFileName() {
		return this.__file_name;
	}

	public void setFileName( java.lang.String value ) {
		this.__file_name = value;
	}

	public java.lang.String getFileExtension() {
		return this.__file_extension;
	}

	public void setFileExtension( java.lang.String value ) {
		this.__file_extension = value;
	}

	public java.lang.Integer getFileType() {
		return this.__file_type;
	}

	public void setFileType( java.lang.Integer value ) {
		this.__file_type = value;
	}

	public java.lang.Long getFileSize() {
		return this.__file_size;
	}

	public void setFileSize( java.lang.Long value ) {
		this.__file_size = value;
	}

	public java.lang.String getFileUrl() {
		return this.__file_url;
	}

	public void setFileUrl( java.lang.String value ) {
		this.__file_url = value;
	}

	public java.lang.String getIconImg() {
		return this.__icon_img;
	}

	public void setIconImg( java.lang.String value ) {
		this.__icon_img = value;
	}

	public java.lang.Long getIconImgSize() {
		return this.__icon_img_size;
	}

	public void setIconImgSize( java.lang.Long value ) {
		this.__icon_img_size = value;
	}

	public java.lang.String getThumbnailImg() {
		return this.__thumbnail_img;
	}

	public void setThumbnailImg( java.lang.String value ) {
		this.__thumbnail_img = value;
	}

	public java.lang.Long getThumbnailImgSize() {
		return this.__thumbnail_img_size;
	}

	public void setThumbnailImgSize( java.lang.Long value ) {
		this.__thumbnail_img_size = value;
	}

	public java.lang.String getMatrixImg() {
		return this.__matrix_img;
	}

	public void setMatrixImg( java.lang.String value ) {
		this.__matrix_img = value;
	}

	public java.lang.Long getMatrixImgSize() {
		return this.__matrix_img_size;
	}

	public void setMatrixImgSize( java.lang.Long value ) {
		this.__matrix_img_size = value;
	}

	public java.lang.String getStandardImg() {
		return this.__standard_img;
	}

	public void setStandardImg( java.lang.String value ) {
		this.__standard_img = value;
	}

	public java.lang.Long getStandardImgSize() {
		return this.__standard_img_size;
	}

	public void setStandardImgSize( java.lang.Long value ) {
		this.__standard_img_size = value;
	}

	public java.lang.Integer getCitationTimes() {
		return this.__citation_times;
	}

	public void setCitationTimes( java.lang.Integer value ) {
		this.__citation_times = value;
	}

	public java.lang.Integer getUploader() {
		return this.__uploader;
	}

	public void setUploader( java.lang.Integer value ) {
		this.__uploader = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.util.Date getUpdateTime() {
		return this.__update_time;
	}

	public void setUpdateTime( java.util.Date value ) {
		this.__update_time = value;
	}

	public java.lang.String getVideoImage() {
		return this.__video_image;
	}

	public void setVideoImage( java.lang.String value ) {
		this.__video_image = value;
	}

	public java.lang.Long getVideoImageSize() {
		return this.__video_image_size;
	}

	public void setVideoImageSize( java.lang.Long value ) {
		this.__video_image_size = value;
	}

	public java.lang.Integer getImgWidth() {
		return this.__img_width;
	}

	public void setImgWidth( java.lang.Integer value ) {
		this.__img_width = value;
	}

	public java.lang.Integer getImgHeight() {
		return this.__img_height;
	}

	public void setImgHeight( java.lang.Integer value ) {
		this.__img_height = value;
	}

	public java.lang.Integer getIconImgWidth() {
		return this.__icon_img_width;
	}

	public void setIconImgWidth( java.lang.Integer value ) {
		this.__icon_img_width = value;
	}

	public java.lang.Integer getIconImgHeight() {
		return this.__icon_img_height;
	}

	public void setIconImgHeight( java.lang.Integer value ) {
		this.__icon_img_height = value;
	}

	public java.lang.Integer getThumbnailImgWidth() {
		return this.__thumbnail_img_width;
	}

	public void setThumbnailImgWidth( java.lang.Integer value ) {
		this.__thumbnail_img_width = value;
	}

	public java.lang.Integer getThumbnailImgHeight() {
		return this.__thumbnail_img_height;
	}

	public void setThumbnailImgHeight( java.lang.Integer value ) {
		this.__thumbnail_img_height = value;
	}

	public java.lang.Integer getMatrixImgWidth() {
		return this.__matrix_img_width;
	}

	public void setMatrixImgWidth( java.lang.Integer value ) {
		this.__matrix_img_width = value;
	}

	public java.lang.Integer getMatrixImgHeight() {
		return this.__matrix_img_height;
	}

	public void setMatrixImgHeight( java.lang.Integer value ) {
		this.__matrix_img_height = value;
	}

	public java.lang.Integer getStandardImgWidth() {
		return this.__standard_img_width;
	}

	public void setStandardImgWidth( java.lang.Integer value ) {
		this.__standard_img_width = value;
	}

	public java.lang.Integer getStandardImgHeight() {
		return this.__standard_img_height;
	}

	public void setStandardImgHeight( java.lang.Integer value ) {
		this.__standard_img_height = value;
	}

	public java.lang.Long getVideoTime() {
		return this.__video_time;
	}

	public void setVideoTime( java.lang.Long value ) {
		this.__video_time = value;
	}

	public java.lang.String getDominantColor() {
		return this.__dominant_color;
	}

	public void setDominantColor( java.lang.String value ) {
		this.__dominant_color = value;
	}

	public java.lang.String getFileTransferKey() {
		return this.__file_transfer_key;
	}

	public void setFileTransferKey( java.lang.String value ) {
		this.__file_transfer_key = value;
	}

	public java.lang.Integer getFileTransferStatus() {
		return this.__file_transfer_status;
	}

	public void setFileTransferStatus( java.lang.Integer value ) {
		this.__file_transfer_status = value;
	}

	public java.lang.String getIconImgTransferKey() {
		return this.__icon_img_transfer_key;
	}

	public void setIconImgTransferKey( java.lang.String value ) {
		this.__icon_img_transfer_key = value;
	}

	public java.lang.Integer getIconImgTransferStatus() {
		return this.__icon_img_transfer_status;
	}

	public void setIconImgTransferStatus( java.lang.Integer value ) {
		this.__icon_img_transfer_status = value;
	}

	public java.lang.String getThumbnailImgTransferKey() {
		return this.__thumbnail_img_transfer_key;
	}

	public void setThumbnailImgTransferKey( java.lang.String value ) {
		this.__thumbnail_img_transfer_key = value;
	}

	public java.lang.Integer getThumbnailImgTransferStatus() {
		return this.__thumbnail_img_transfer_status;
	}

	public void setThumbnailImgTransferStatus( java.lang.Integer value ) {
		this.__thumbnail_img_transfer_status = value;
	}

	public java.lang.String getMatrixImgTransferKey() {
		return this.__matrix_img_transfer_key;
	}

	public void setMatrixImgTransferKey( java.lang.String value ) {
		this.__matrix_img_transfer_key = value;
	}

	public java.lang.Integer getMatrixImgTransferStatus() {
		return this.__matrix_img_transfer_status;
	}

	public void setMatrixImgTransferStatus( java.lang.Integer value ) {
		this.__matrix_img_transfer_status = value;
	}

	public java.lang.String getStandardImgTransferKey() {
		return this.__standard_img_transfer_key;
	}

	public void setStandardImgTransferKey( java.lang.String value ) {
		this.__standard_img_transfer_key = value;
	}

	public java.lang.Integer getStandardImgTransferStatus() {
		return this.__standard_img_transfer_status;
	}

	public void setStandardImgTransferStatus( java.lang.Integer value ) {
		this.__standard_img_transfer_status = value;
	}

	public java.lang.String getVideoImageTransferKey() {
		return this.__video_image_transfer_key;
	}

	public void setVideoImageTransferKey( java.lang.String value ) {
		this.__video_image_transfer_key = value;
	}

	public java.lang.Integer getVideoImageTransferStatus() {
		return this.__video_image_transfer_status;
	}

	public void setVideoImageTransferStatus( java.lang.Integer value ) {
		this.__video_image_transfer_status = value;
	}

	public java.lang.Integer getOriginalFileId() {
		return this.__original_file_id;
	}

	public void setOriginalFileId( java.lang.Integer value ) {
		this.__original_file_id = value;
	}

	public void cloneCopy(BaseFileManage __bean){
		__bean.setFileId(getFileId());
		__bean.setFileName(getFileName());
		__bean.setFileExtension(getFileExtension());
		__bean.setFileType(getFileType());
		__bean.setFileSize(getFileSize());
		__bean.setFileUrl(getFileUrl());
		__bean.setIconImg(getIconImg());
		__bean.setIconImgSize(getIconImgSize());
		__bean.setThumbnailImg(getThumbnailImg());
		__bean.setThumbnailImgSize(getThumbnailImgSize());
		__bean.setMatrixImg(getMatrixImg());
		__bean.setMatrixImgSize(getMatrixImgSize());
		__bean.setStandardImg(getStandardImg());
		__bean.setStandardImgSize(getStandardImgSize());
		__bean.setCitationTimes(getCitationTimes());
		__bean.setUploader(getUploader());
		__bean.setCreateTime(getCreateTime());
		__bean.setUpdateTime(getUpdateTime());
		__bean.setVideoImage(getVideoImage());
		__bean.setVideoImageSize(getVideoImageSize());
		__bean.setImgWidth(getImgWidth());
		__bean.setImgHeight(getImgHeight());
		__bean.setIconImgWidth(getIconImgWidth());
		__bean.setIconImgHeight(getIconImgHeight());
		__bean.setThumbnailImgWidth(getThumbnailImgWidth());
		__bean.setThumbnailImgHeight(getThumbnailImgHeight());
		__bean.setMatrixImgWidth(getMatrixImgWidth());
		__bean.setMatrixImgHeight(getMatrixImgHeight());
		__bean.setStandardImgWidth(getStandardImgWidth());
		__bean.setStandardImgHeight(getStandardImgHeight());
		__bean.setVideoTime(getVideoTime());
		__bean.setDominantColor(getDominantColor());
		__bean.setFileTransferKey(getFileTransferKey());
		__bean.setFileTransferStatus(getFileTransferStatus());
		__bean.setIconImgTransferKey(getIconImgTransferKey());
		__bean.setIconImgTransferStatus(getIconImgTransferStatus());
		__bean.setThumbnailImgTransferKey(getThumbnailImgTransferKey());
		__bean.setThumbnailImgTransferStatus(getThumbnailImgTransferStatus());
		__bean.setMatrixImgTransferKey(getMatrixImgTransferKey());
		__bean.setMatrixImgTransferStatus(getMatrixImgTransferStatus());
		__bean.setStandardImgTransferKey(getStandardImgTransferKey());
		__bean.setStandardImgTransferStatus(getStandardImgTransferStatus());
		__bean.setVideoImageTransferKey(getVideoImageTransferKey());
		__bean.setVideoImageTransferStatus(getVideoImageTransferStatus());
		__bean.setOriginalFileId(getOriginalFileId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getFileId() == null ? "" : getFileId());
		sb.append(",");
		sb.append(getFileName() == null ? "" : getFileName());
		sb.append(",");
		sb.append(getFileExtension() == null ? "" : getFileExtension());
		sb.append(",");
		sb.append(getFileType() == null ? "" : getFileType());
		sb.append(",");
		sb.append(getFileSize() == null ? "" : getFileSize());
		sb.append(",");
		sb.append(getFileUrl() == null ? "" : getFileUrl());
		sb.append(",");
		sb.append(getIconImg() == null ? "" : getIconImg());
		sb.append(",");
		sb.append(getIconImgSize() == null ? "" : getIconImgSize());
		sb.append(",");
		sb.append(getThumbnailImg() == null ? "" : getThumbnailImg());
		sb.append(",");
		sb.append(getThumbnailImgSize() == null ? "" : getThumbnailImgSize());
		sb.append(",");
		sb.append(getMatrixImg() == null ? "" : getMatrixImg());
		sb.append(",");
		sb.append(getMatrixImgSize() == null ? "" : getMatrixImgSize());
		sb.append(",");
		sb.append(getStandardImg() == null ? "" : getStandardImg());
		sb.append(",");
		sb.append(getStandardImgSize() == null ? "" : getStandardImgSize());
		sb.append(",");
		sb.append(getCitationTimes() == null ? "" : getCitationTimes());
		sb.append(",");
		sb.append(getUploader() == null ? "" : getUploader());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getUpdateTime() == null ? "" : sdf.format(getUpdateTime()));
		sb.append(",");
		sb.append(getVideoImage() == null ? "" : getVideoImage());
		sb.append(",");
		sb.append(getVideoImageSize() == null ? "" : getVideoImageSize());
		sb.append(",");
		sb.append(getImgWidth() == null ? "" : getImgWidth());
		sb.append(",");
		sb.append(getImgHeight() == null ? "" : getImgHeight());
		sb.append(",");
		sb.append(getIconImgWidth() == null ? "" : getIconImgWidth());
		sb.append(",");
		sb.append(getIconImgHeight() == null ? "" : getIconImgHeight());
		sb.append(",");
		sb.append(getThumbnailImgWidth() == null ? "" : getThumbnailImgWidth());
		sb.append(",");
		sb.append(getThumbnailImgHeight() == null ? "" : getThumbnailImgHeight());
		sb.append(",");
		sb.append(getMatrixImgWidth() == null ? "" : getMatrixImgWidth());
		sb.append(",");
		sb.append(getMatrixImgHeight() == null ? "" : getMatrixImgHeight());
		sb.append(",");
		sb.append(getStandardImgWidth() == null ? "" : getStandardImgWidth());
		sb.append(",");
		sb.append(getStandardImgHeight() == null ? "" : getStandardImgHeight());
		sb.append(",");
		sb.append(getVideoTime() == null ? "" : getVideoTime());
		sb.append(",");
		sb.append(getDominantColor() == null ? "" : getDominantColor());
		sb.append(",");
		sb.append(getFileTransferKey() == null ? "" : getFileTransferKey());
		sb.append(",");
		sb.append(getFileTransferStatus() == null ? "" : getFileTransferStatus());
		sb.append(",");
		sb.append(getIconImgTransferKey() == null ? "" : getIconImgTransferKey());
		sb.append(",");
		sb.append(getIconImgTransferStatus() == null ? "" : getIconImgTransferStatus());
		sb.append(",");
		sb.append(getThumbnailImgTransferKey() == null ? "" : getThumbnailImgTransferKey());
		sb.append(",");
		sb.append(getThumbnailImgTransferStatus() == null ? "" : getThumbnailImgTransferStatus());
		sb.append(",");
		sb.append(getMatrixImgTransferKey() == null ? "" : getMatrixImgTransferKey());
		sb.append(",");
		sb.append(getMatrixImgTransferStatus() == null ? "" : getMatrixImgTransferStatus());
		sb.append(",");
		sb.append(getStandardImgTransferKey() == null ? "" : getStandardImgTransferKey());
		sb.append(",");
		sb.append(getStandardImgTransferStatus() == null ? "" : getStandardImgTransferStatus());
		sb.append(",");
		sb.append(getVideoImageTransferKey() == null ? "" : getVideoImageTransferKey());
		sb.append(",");
		sb.append(getVideoImageTransferStatus() == null ? "" : getVideoImageTransferStatus());
		sb.append(",");
		sb.append(getOriginalFileId() == null ? "" : getOriginalFileId());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseFileManage o) {
		return __file_id == null ? -1 : __file_id.compareTo(o.getFileId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__file_id);
		hash = 97 * hash + Objects.hashCode(this.__file_name);
		hash = 97 * hash + Objects.hashCode(this.__file_extension);
		hash = 97 * hash + Objects.hashCode(this.__file_type);
		hash = 97 * hash + Objects.hashCode(this.__file_size);
		hash = 97 * hash + Objects.hashCode(this.__file_url);
		hash = 97 * hash + Objects.hashCode(this.__icon_img);
		hash = 97 * hash + Objects.hashCode(this.__icon_img_size);
		hash = 97 * hash + Objects.hashCode(this.__thumbnail_img);
		hash = 97 * hash + Objects.hashCode(this.__thumbnail_img_size);
		hash = 97 * hash + Objects.hashCode(this.__matrix_img);
		hash = 97 * hash + Objects.hashCode(this.__matrix_img_size);
		hash = 97 * hash + Objects.hashCode(this.__standard_img);
		hash = 97 * hash + Objects.hashCode(this.__standard_img_size);
		hash = 97 * hash + Objects.hashCode(this.__citation_times);
		hash = 97 * hash + Objects.hashCode(this.__uploader);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__update_time);
		hash = 97 * hash + Objects.hashCode(this.__video_image);
		hash = 97 * hash + Objects.hashCode(this.__video_image_size);
		hash = 97 * hash + Objects.hashCode(this.__img_width);
		hash = 97 * hash + Objects.hashCode(this.__img_height);
		hash = 97 * hash + Objects.hashCode(this.__icon_img_width);
		hash = 97 * hash + Objects.hashCode(this.__icon_img_height);
		hash = 97 * hash + Objects.hashCode(this.__thumbnail_img_width);
		hash = 97 * hash + Objects.hashCode(this.__thumbnail_img_height);
		hash = 97 * hash + Objects.hashCode(this.__matrix_img_width);
		hash = 97 * hash + Objects.hashCode(this.__matrix_img_height);
		hash = 97 * hash + Objects.hashCode(this.__standard_img_width);
		hash = 97 * hash + Objects.hashCode(this.__standard_img_height);
		hash = 97 * hash + Objects.hashCode(this.__video_time);
		hash = 97 * hash + Objects.hashCode(this.__dominant_color);
		hash = 97 * hash + Objects.hashCode(this.__file_transfer_key);
		hash = 97 * hash + Objects.hashCode(this.__file_transfer_status);
		hash = 97 * hash + Objects.hashCode(this.__icon_img_transfer_key);
		hash = 97 * hash + Objects.hashCode(this.__icon_img_transfer_status);
		hash = 97 * hash + Objects.hashCode(this.__thumbnail_img_transfer_key);
		hash = 97 * hash + Objects.hashCode(this.__thumbnail_img_transfer_status);
		hash = 97 * hash + Objects.hashCode(this.__matrix_img_transfer_key);
		hash = 97 * hash + Objects.hashCode(this.__matrix_img_transfer_status);
		hash = 97 * hash + Objects.hashCode(this.__standard_img_transfer_key);
		hash = 97 * hash + Objects.hashCode(this.__standard_img_transfer_status);
		hash = 97 * hash + Objects.hashCode(this.__video_image_transfer_key);
		hash = 97 * hash + Objects.hashCode(this.__video_image_transfer_status);
		hash = 97 * hash + Objects.hashCode(this.__original_file_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseFileManage o = (BaseFileManage)obj;
		if(!Objects.equals(this.__file_id, o.getFileId())) return false;
		if(!Objects.equals(this.__file_name, o.getFileName())) return false;
		if(!Objects.equals(this.__file_extension, o.getFileExtension())) return false;
		if(!Objects.equals(this.__file_type, o.getFileType())) return false;
		if(!Objects.equals(this.__file_size, o.getFileSize())) return false;
		if(!Objects.equals(this.__file_url, o.getFileUrl())) return false;
		if(!Objects.equals(this.__icon_img, o.getIconImg())) return false;
		if(!Objects.equals(this.__icon_img_size, o.getIconImgSize())) return false;
		if(!Objects.equals(this.__thumbnail_img, o.getThumbnailImg())) return false;
		if(!Objects.equals(this.__thumbnail_img_size, o.getThumbnailImgSize())) return false;
		if(!Objects.equals(this.__matrix_img, o.getMatrixImg())) return false;
		if(!Objects.equals(this.__matrix_img_size, o.getMatrixImgSize())) return false;
		if(!Objects.equals(this.__standard_img, o.getStandardImg())) return false;
		if(!Objects.equals(this.__standard_img_size, o.getStandardImgSize())) return false;
		if(!Objects.equals(this.__citation_times, o.getCitationTimes())) return false;
		if(!Objects.equals(this.__uploader, o.getUploader())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__update_time, o.getUpdateTime())) return false;
		if(!Objects.equals(this.__video_image, o.getVideoImage())) return false;
		if(!Objects.equals(this.__video_image_size, o.getVideoImageSize())) return false;
		if(!Objects.equals(this.__img_width, o.getImgWidth())) return false;
		if(!Objects.equals(this.__img_height, o.getImgHeight())) return false;
		if(!Objects.equals(this.__icon_img_width, o.getIconImgWidth())) return false;
		if(!Objects.equals(this.__icon_img_height, o.getIconImgHeight())) return false;
		if(!Objects.equals(this.__thumbnail_img_width, o.getThumbnailImgWidth())) return false;
		if(!Objects.equals(this.__thumbnail_img_height, o.getThumbnailImgHeight())) return false;
		if(!Objects.equals(this.__matrix_img_width, o.getMatrixImgWidth())) return false;
		if(!Objects.equals(this.__matrix_img_height, o.getMatrixImgHeight())) return false;
		if(!Objects.equals(this.__standard_img_width, o.getStandardImgWidth())) return false;
		if(!Objects.equals(this.__standard_img_height, o.getStandardImgHeight())) return false;
		if(!Objects.equals(this.__video_time, o.getVideoTime())) return false;
		if(!Objects.equals(this.__dominant_color, o.getDominantColor())) return false;
		if(!Objects.equals(this.__file_transfer_key, o.getFileTransferKey())) return false;
		if(!Objects.equals(this.__file_transfer_status, o.getFileTransferStatus())) return false;
		if(!Objects.equals(this.__icon_img_transfer_key, o.getIconImgTransferKey())) return false;
		if(!Objects.equals(this.__icon_img_transfer_status, o.getIconImgTransferStatus())) return false;
		if(!Objects.equals(this.__thumbnail_img_transfer_key, o.getThumbnailImgTransferKey())) return false;
		if(!Objects.equals(this.__thumbnail_img_transfer_status, o.getThumbnailImgTransferStatus())) return false;
		if(!Objects.equals(this.__matrix_img_transfer_key, o.getMatrixImgTransferKey())) return false;
		if(!Objects.equals(this.__matrix_img_transfer_status, o.getMatrixImgTransferStatus())) return false;
		if(!Objects.equals(this.__standard_img_transfer_key, o.getStandardImgTransferKey())) return false;
		if(!Objects.equals(this.__standard_img_transfer_status, o.getStandardImgTransferStatus())) return false;
		if(!Objects.equals(this.__video_image_transfer_key, o.getVideoImageTransferKey())) return false;
		if(!Objects.equals(this.__video_image_transfer_status, o.getVideoImageTransferStatus())) return false;
		if(!Objects.equals(this.__original_file_id, o.getOriginalFileId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getFileId() != null) sb.append(__wrapNumber(count++, "fileId", getFileId()));
		if(getFileName() != null) sb.append(__wrapString(count++, "fileName", getFileName()));
		if(getFileExtension() != null) sb.append(__wrapString(count++, "fileExtension", getFileExtension()));
		if(getFileType() != null) sb.append(__wrapNumber(count++, "fileType", getFileType()));
		if(getFileSize() != null) sb.append(__wrapNumber(count++, "fileSize", getFileSize()));
		if(getFileUrl() != null) sb.append(__wrapString(count++, "fileUrl", getFileUrl()));
		if(getIconImg() != null) sb.append(__wrapString(count++, "iconImg", getIconImg()));
		if(getIconImgSize() != null) sb.append(__wrapNumber(count++, "iconImgSize", getIconImgSize()));
		if(getThumbnailImg() != null) sb.append(__wrapString(count++, "thumbnailImg", getThumbnailImg()));
		if(getThumbnailImgSize() != null) sb.append(__wrapNumber(count++, "thumbnailImgSize", getThumbnailImgSize()));
		if(getMatrixImg() != null) sb.append(__wrapString(count++, "matrixImg", getMatrixImg()));
		if(getMatrixImgSize() != null) sb.append(__wrapNumber(count++, "matrixImgSize", getMatrixImgSize()));
		if(getStandardImg() != null) sb.append(__wrapString(count++, "standardImg", getStandardImg()));
		if(getStandardImgSize() != null) sb.append(__wrapNumber(count++, "standardImgSize", getStandardImgSize()));
		if(getCitationTimes() != null) sb.append(__wrapNumber(count++, "citationTimes", getCitationTimes()));
		if(getUploader() != null) sb.append(__wrapNumber(count++, "uploader", getUploader()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getUpdateTime() != null) sb.append(__wrapDate(count++, "updateTime", getUpdateTime()));
		if(getVideoImage() != null) sb.append(__wrapString(count++, "videoImage", getVideoImage()));
		if(getVideoImageSize() != null) sb.append(__wrapNumber(count++, "videoImageSize", getVideoImageSize()));
		if(getImgWidth() != null) sb.append(__wrapNumber(count++, "imgWidth", getImgWidth()));
		if(getImgHeight() != null) sb.append(__wrapNumber(count++, "imgHeight", getImgHeight()));
		if(getIconImgWidth() != null) sb.append(__wrapNumber(count++, "iconImgWidth", getIconImgWidth()));
		if(getIconImgHeight() != null) sb.append(__wrapNumber(count++, "iconImgHeight", getIconImgHeight()));
		if(getThumbnailImgWidth() != null) sb.append(__wrapNumber(count++, "thumbnailImgWidth", getThumbnailImgWidth()));
		if(getThumbnailImgHeight() != null) sb.append(__wrapNumber(count++, "thumbnailImgHeight", getThumbnailImgHeight()));
		if(getMatrixImgWidth() != null) sb.append(__wrapNumber(count++, "matrixImgWidth", getMatrixImgWidth()));
		if(getMatrixImgHeight() != null) sb.append(__wrapNumber(count++, "matrixImgHeight", getMatrixImgHeight()));
		if(getStandardImgWidth() != null) sb.append(__wrapNumber(count++, "standardImgWidth", getStandardImgWidth()));
		if(getStandardImgHeight() != null) sb.append(__wrapNumber(count++, "standardImgHeight", getStandardImgHeight()));
		if(getVideoTime() != null) sb.append(__wrapNumber(count++, "videoTime", getVideoTime()));
		if(getDominantColor() != null) sb.append(__wrapString(count++, "dominantColor", getDominantColor()));
		if(getFileTransferKey() != null) sb.append(__wrapString(count++, "fileTransferKey", getFileTransferKey()));
		if(getFileTransferStatus() != null) sb.append(__wrapNumber(count++, "fileTransferStatus", getFileTransferStatus()));
		if(getIconImgTransferKey() != null) sb.append(__wrapString(count++, "iconImgTransferKey", getIconImgTransferKey()));
		if(getIconImgTransferStatus() != null) sb.append(__wrapNumber(count++, "iconImgTransferStatus", getIconImgTransferStatus()));
		if(getThumbnailImgTransferKey() != null) sb.append(__wrapString(count++, "thumbnailImgTransferKey", getThumbnailImgTransferKey()));
		if(getThumbnailImgTransferStatus() != null) sb.append(__wrapNumber(count++, "thumbnailImgTransferStatus", getThumbnailImgTransferStatus()));
		if(getMatrixImgTransferKey() != null) sb.append(__wrapString(count++, "matrixImgTransferKey", getMatrixImgTransferKey()));
		if(getMatrixImgTransferStatus() != null) sb.append(__wrapNumber(count++, "matrixImgTransferStatus", getMatrixImgTransferStatus()));
		if(getStandardImgTransferKey() != null) sb.append(__wrapString(count++, "standardImgTransferKey", getStandardImgTransferKey()));
		if(getStandardImgTransferStatus() != null) sb.append(__wrapNumber(count++, "standardImgTransferStatus", getStandardImgTransferStatus()));
		if(getVideoImageTransferKey() != null) sb.append(__wrapString(count++, "videoImageTransferKey", getVideoImageTransferKey()));
		if(getVideoImageTransferStatus() != null) sb.append(__wrapNumber(count++, "videoImageTransferStatus", getVideoImageTransferStatus()));
		if(getOriginalFileId() != null) sb.append(__wrapNumber(count++, "originalFileId", getOriginalFileId()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getFileId() != null) res.put("fileId", getFileId());
		if(getFileName() != null) res.put("fileName", getFileName());
		if(getFileExtension() != null) res.put("fileExtension", getFileExtension());
		if(getFileType() != null) res.put("fileType", getFileType());
		if(getFileSize() != null) res.put("fileSize", getFileSize());
		if(getFileUrl() != null) res.put("fileUrl", getFileUrl());
		if(getIconImg() != null) res.put("iconImg", getIconImg());
		if(getIconImgSize() != null) res.put("iconImgSize", getIconImgSize());
		if(getThumbnailImg() != null) res.put("thumbnailImg", getThumbnailImg());
		if(getThumbnailImgSize() != null) res.put("thumbnailImgSize", getThumbnailImgSize());
		if(getMatrixImg() != null) res.put("matrixImg", getMatrixImg());
		if(getMatrixImgSize() != null) res.put("matrixImgSize", getMatrixImgSize());
		if(getStandardImg() != null) res.put("standardImg", getStandardImg());
		if(getStandardImgSize() != null) res.put("standardImgSize", getStandardImgSize());
		if(getCitationTimes() != null) res.put("citationTimes", getCitationTimes());
		if(getUploader() != null) res.put("uploader", getUploader());
		if(getCreateTime() != null) res.put("createTime", getCreateTime());
		if(getUpdateTime() != null) res.put("updateTime", getUpdateTime());
		if(getVideoImage() != null) res.put("videoImage", getVideoImage());
		if(getVideoImageSize() != null) res.put("videoImageSize", getVideoImageSize());
		if(getImgWidth() != null) res.put("imgWidth", getImgWidth());
		if(getImgHeight() != null) res.put("imgHeight", getImgHeight());
		if(getIconImgWidth() != null) res.put("iconImgWidth", getIconImgWidth());
		if(getIconImgHeight() != null) res.put("iconImgHeight", getIconImgHeight());
		if(getThumbnailImgWidth() != null) res.put("thumbnailImgWidth", getThumbnailImgWidth());
		if(getThumbnailImgHeight() != null) res.put("thumbnailImgHeight", getThumbnailImgHeight());
		if(getMatrixImgWidth() != null) res.put("matrixImgWidth", getMatrixImgWidth());
		if(getMatrixImgHeight() != null) res.put("matrixImgHeight", getMatrixImgHeight());
		if(getStandardImgWidth() != null) res.put("standardImgWidth", getStandardImgWidth());
		if(getStandardImgHeight() != null) res.put("standardImgHeight", getStandardImgHeight());
		if(getVideoTime() != null) res.put("videoTime", getVideoTime());
		if(getDominantColor() != null) res.put("dominantColor", getDominantColor());
		if(getFileTransferKey() != null) res.put("fileTransferKey", getFileTransferKey());
		if(getFileTransferStatus() != null) res.put("fileTransferStatus", getFileTransferStatus());
		if(getIconImgTransferKey() != null) res.put("iconImgTransferKey", getIconImgTransferKey());
		if(getIconImgTransferStatus() != null) res.put("iconImgTransferStatus", getIconImgTransferStatus());
		if(getThumbnailImgTransferKey() != null) res.put("thumbnailImgTransferKey", getThumbnailImgTransferKey());
		if(getThumbnailImgTransferStatus() != null) res.put("thumbnailImgTransferStatus", getThumbnailImgTransferStatus());
		if(getMatrixImgTransferKey() != null) res.put("matrixImgTransferKey", getMatrixImgTransferKey());
		if(getMatrixImgTransferStatus() != null) res.put("matrixImgTransferStatus", getMatrixImgTransferStatus());
		if(getStandardImgTransferKey() != null) res.put("standardImgTransferKey", getStandardImgTransferKey());
		if(getStandardImgTransferStatus() != null) res.put("standardImgTransferStatus", getStandardImgTransferStatus());
		if(getVideoImageTransferKey() != null) res.put("videoImageTransferKey", getVideoImageTransferKey());
		if(getVideoImageTransferStatus() != null) res.put("videoImageTransferStatus", getVideoImageTransferStatus());
		if(getOriginalFileId() != null) res.put("originalFileId", getOriginalFileId());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("fileId")) != null) setFileId(__getInt(val)); 
		if((val = values.get("fileName")) != null) setFileName(__getString(val));
		if((val = values.get("fileExtension")) != null) setFileExtension(__getString(val));
		if((val = values.get("fileType")) != null) setFileType(__getInt(val)); 
		if((val = values.get("fileSize")) != null) setFileSize(__getLong(val)); 
		if((val = values.get("fileUrl")) != null) setFileUrl(__getString(val));
		if((val = values.get("iconImg")) != null) setIconImg(__getString(val));
		if((val = values.get("iconImgSize")) != null) setIconImgSize(__getLong(val)); 
		if((val = values.get("thumbnailImg")) != null) setThumbnailImg(__getString(val));
		if((val = values.get("thumbnailImgSize")) != null) setThumbnailImgSize(__getLong(val)); 
		if((val = values.get("matrixImg")) != null) setMatrixImg(__getString(val));
		if((val = values.get("matrixImgSize")) != null) setMatrixImgSize(__getLong(val)); 
		if((val = values.get("standardImg")) != null) setStandardImg(__getString(val));
		if((val = values.get("standardImgSize")) != null) setStandardImgSize(__getLong(val)); 
		if((val = values.get("citationTimes")) != null) setCitationTimes(__getInt(val)); 
		if((val = values.get("uploader")) != null) setUploader(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("updateTime")) != null) setUpdateTime(__getDate(val)); 
		if((val = values.get("videoImage")) != null) setVideoImage(__getString(val));
		if((val = values.get("videoImageSize")) != null) setVideoImageSize(__getLong(val)); 
		if((val = values.get("imgWidth")) != null) setImgWidth(__getInt(val)); 
		if((val = values.get("imgHeight")) != null) setImgHeight(__getInt(val)); 
		if((val = values.get("iconImgWidth")) != null) setIconImgWidth(__getInt(val)); 
		if((val = values.get("iconImgHeight")) != null) setIconImgHeight(__getInt(val)); 
		if((val = values.get("thumbnailImgWidth")) != null) setThumbnailImgWidth(__getInt(val)); 
		if((val = values.get("thumbnailImgHeight")) != null) setThumbnailImgHeight(__getInt(val)); 
		if((val = values.get("matrixImgWidth")) != null) setMatrixImgWidth(__getInt(val)); 
		if((val = values.get("matrixImgHeight")) != null) setMatrixImgHeight(__getInt(val)); 
		if((val = values.get("standardImgWidth")) != null) setStandardImgWidth(__getInt(val)); 
		if((val = values.get("standardImgHeight")) != null) setStandardImgHeight(__getInt(val)); 
		if((val = values.get("videoTime")) != null) setVideoTime(__getLong(val)); 
		if((val = values.get("dominantColor")) != null) setDominantColor(__getString(val));
		if((val = values.get("fileTransferKey")) != null) setFileTransferKey(__getString(val));
		if((val = values.get("fileTransferStatus")) != null) setFileTransferStatus(__getInt(val)); 
		if((val = values.get("iconImgTransferKey")) != null) setIconImgTransferKey(__getString(val));
		if((val = values.get("iconImgTransferStatus")) != null) setIconImgTransferStatus(__getInt(val)); 
		if((val = values.get("thumbnailImgTransferKey")) != null) setThumbnailImgTransferKey(__getString(val));
		if((val = values.get("thumbnailImgTransferStatus")) != null) setThumbnailImgTransferStatus(__getInt(val)); 
		if((val = values.get("matrixImgTransferKey")) != null) setMatrixImgTransferKey(__getString(val));
		if((val = values.get("matrixImgTransferStatus")) != null) setMatrixImgTransferStatus(__getInt(val)); 
		if((val = values.get("standardImgTransferKey")) != null) setStandardImgTransferKey(__getString(val));
		if((val = values.get("standardImgTransferStatus")) != null) setStandardImgTransferStatus(__getInt(val)); 
		if((val = values.get("videoImageTransferKey")) != null) setVideoImageTransferKey(__getString(val));
		if((val = values.get("videoImageTransferStatus")) != null) setVideoImageTransferStatus(__getInt(val)); 
		if((val = values.get("originalFileId")) != null) setOriginalFileId(__getInt(val)); 
	}

	protected java.lang.Integer  __file_id ;
	protected java.lang.String  __file_name ;
	protected java.lang.String  __file_extension ;
	protected java.lang.Integer  __file_type ;
	protected java.lang.Long  __file_size ;
	protected java.lang.String  __file_url ;
	protected java.lang.String  __icon_img ;
	protected java.lang.Long  __icon_img_size ;
	protected java.lang.String  __thumbnail_img ;
	protected java.lang.Long  __thumbnail_img_size ;
	protected java.lang.String  __matrix_img ;
	protected java.lang.Long  __matrix_img_size ;
	protected java.lang.String  __standard_img ;
	protected java.lang.Long  __standard_img_size ;
	protected java.lang.Integer  __citation_times ;
	protected java.lang.Integer  __uploader ;
	protected java.util.Date  __create_time ;
	protected java.util.Date  __update_time ;
	protected java.lang.String  __video_image ;
	protected java.lang.Long  __video_image_size ;
	protected java.lang.Integer  __img_width ;
	protected java.lang.Integer  __img_height ;
	protected java.lang.Integer  __icon_img_width ;
	protected java.lang.Integer  __icon_img_height ;
	protected java.lang.Integer  __thumbnail_img_width ;
	protected java.lang.Integer  __thumbnail_img_height ;
	protected java.lang.Integer  __matrix_img_width ;
	protected java.lang.Integer  __matrix_img_height ;
	protected java.lang.Integer  __standard_img_width ;
	protected java.lang.Integer  __standard_img_height ;
	protected java.lang.Long  __video_time ;
	protected java.lang.String  __dominant_color ;
	protected java.lang.String  __file_transfer_key ;
	protected java.lang.Integer  __file_transfer_status ;
	protected java.lang.String  __icon_img_transfer_key ;
	protected java.lang.Integer  __icon_img_transfer_status ;
	protected java.lang.String  __thumbnail_img_transfer_key ;
	protected java.lang.Integer  __thumbnail_img_transfer_status ;
	protected java.lang.String  __matrix_img_transfer_key ;
	protected java.lang.Integer  __matrix_img_transfer_status ;
	protected java.lang.String  __standard_img_transfer_key ;
	protected java.lang.Integer  __standard_img_transfer_status ;
	protected java.lang.String  __video_image_transfer_key ;
	protected java.lang.Integer  __video_image_transfer_status ;
	protected java.lang.Integer  __original_file_id ;
}
