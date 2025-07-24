package com.file.db.dao;

import delicacy.common.AbstractTable;
import delicacy.common.JsonParser;
import delicacy.common.GenericBase;
import com.file.db.bean.BaseFileManage;


public class FileManage extends AbstractTable<BaseFileManage>
{

	public FileManage() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 45;

		initTables();

		__tableName            = "file_manages";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseFileManage.CS_FILE_ID;
		__column_names[1] = BaseFileManage.CS_FILE_NAME;
		__column_names[2] = BaseFileManage.CS_FILE_EXTENSION;
		__column_names[3] = BaseFileManage.CS_FILE_TYPE;
		__column_names[4] = BaseFileManage.CS_FILE_SIZE;
		__column_names[5] = BaseFileManage.CS_FILE_URL;
		__column_names[6] = BaseFileManage.CS_ICON_IMG;
		__column_names[7] = BaseFileManage.CS_ICON_IMG_SIZE;
		__column_names[8] = BaseFileManage.CS_THUMBNAIL_IMG;
		__column_names[9] = BaseFileManage.CS_THUMBNAIL_IMG_SIZE;
		__column_names[10] = BaseFileManage.CS_MATRIX_IMG;
		__column_names[11] = BaseFileManage.CS_MATRIX_IMG_SIZE;
		__column_names[12] = BaseFileManage.CS_STANDARD_IMG;
		__column_names[13] = BaseFileManage.CS_STANDARD_IMG_SIZE;
		__column_names[14] = BaseFileManage.CS_CITATION_TIMES;
		__column_names[15] = BaseFileManage.CS_UPLOADER;
		__column_names[16] = BaseFileManage.CS_CREATE_TIME;
		__column_names[17] = BaseFileManage.CS_UPDATE_TIME;
		__column_names[18] = BaseFileManage.CS_VIDEO_IMAGE;
		__column_names[19] = BaseFileManage.CS_VIDEO_IMAGE_SIZE;
		__column_names[20] = BaseFileManage.CS_IMG_WIDTH;
		__column_names[21] = BaseFileManage.CS_IMG_HEIGHT;
		__column_names[22] = BaseFileManage.CS_ICON_IMG_WIDTH;
		__column_names[23] = BaseFileManage.CS_ICON_IMG_HEIGHT;
		__column_names[24] = BaseFileManage.CS_THUMBNAIL_IMG_WIDTH;
		__column_names[25] = BaseFileManage.CS_THUMBNAIL_IMG_HEIGHT;
		__column_names[26] = BaseFileManage.CS_MATRIX_IMG_WIDTH;
		__column_names[27] = BaseFileManage.CS_MATRIX_IMG_HEIGHT;
		__column_names[28] = BaseFileManage.CS_STANDARD_IMG_WIDTH;
		__column_names[29] = BaseFileManage.CS_STANDARD_IMG_HEIGHT;
		__column_names[30] = BaseFileManage.CS_VIDEO_TIME;
		__column_names[31] = BaseFileManage.CS_DOMINANT_COLOR;
		__column_names[32] = BaseFileManage.CS_FILE_TRANSFER_KEY;
		__column_names[33] = BaseFileManage.CS_FILE_TRANSFER_STATUS;
		__column_names[34] = BaseFileManage.CS_ICON_IMG_TRANSFER_KEY;
		__column_names[35] = BaseFileManage.CS_ICON_IMG_TRANSFER_STATUS;
		__column_names[36] = BaseFileManage.CS_THUMBNAIL_IMG_TRANSFER_KEY;
		__column_names[37] = BaseFileManage.CS_THUMBNAIL_IMG_TRANSFER_STATUS;
		__column_names[38] = BaseFileManage.CS_MATRIX_IMG_TRANSFER_KEY;
		__column_names[39] = BaseFileManage.CS_MATRIX_IMG_TRANSFER_STATUS;
		__column_names[40] = BaseFileManage.CS_STANDARD_IMG_TRANSFER_KEY;
		__column_names[41] = BaseFileManage.CS_STANDARD_IMG_TRANSFER_STATUS;
		__column_names[42] = BaseFileManage.CS_VIDEO_IMAGE_TRANSFER_KEY;
		__column_names[43] = BaseFileManage.CS_VIDEO_IMAGE_TRANSFER_STATUS;
		__column_names[44] = BaseFileManage.CS_ORIGINAL_FILE_ID;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseFileManage b) {
		clear();
		setFileIdClear(b.getFileId());
	}

	public boolean isPrimaryKeyNull() {
		return getFileId() == null;
	}

	@Override
	public BaseFileManage generateBase(){
		BaseFileManage b = new BaseFileManage();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseFileManage b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setFileId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setFileName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setFileExtension(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setFileType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setFileSize(GenericBase.__getLong(val));
		if((val = __current_data[count++]) != null) b.setFileUrl(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setIconImg(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setIconImgSize(GenericBase.__getLong(val));
		if((val = __current_data[count++]) != null) b.setThumbnailImg(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setThumbnailImgSize(GenericBase.__getLong(val));
		if((val = __current_data[count++]) != null) b.setMatrixImg(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setMatrixImgSize(GenericBase.__getLong(val));
		if((val = __current_data[count++]) != null) b.setStandardImg(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setStandardImgSize(GenericBase.__getLong(val));
		if((val = __current_data[count++]) != null) b.setCitationTimes(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setUploader(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setUpdateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setVideoImage(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setVideoImageSize(GenericBase.__getLong(val));
		if((val = __current_data[count++]) != null) b.setImgWidth(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setImgHeight(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setIconImgWidth(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setIconImgHeight(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setThumbnailImgWidth(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setThumbnailImgHeight(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMatrixImgWidth(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMatrixImgHeight(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setStandardImgWidth(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setStandardImgHeight(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setVideoTime(GenericBase.__getLong(val));
		if((val = __current_data[count++]) != null) b.setDominantColor(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setFileTransferKey(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setFileTransferStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setIconImgTransferKey(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setIconImgTransferStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setThumbnailImgTransferKey(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setThumbnailImgTransferStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMatrixImgTransferKey(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setMatrixImgTransferStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setStandardImgTransferKey(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setStandardImgTransferStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setVideoImageTransferKey(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setVideoImageTransferStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOriginalFileId(GenericBase.__getInt(val));
	}

	public void setDataFromCSV(String csvLine){
		setDataFromCSV(csvLine, null);
	}

	public void setDataFromCSV(String csvLine, String names){
		int count = 0; String val;
		Integer num = null;
		setInputNames(names);
		String[] values = JsonParser.csvLine(csvLine, ',');
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setFileId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setFileName(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setFileExtension(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setFileType(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setFileSize(GenericBase.__getLong(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setFileUrl(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setIconImg(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setIconImgSize(GenericBase.__getLong(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setThumbnailImg(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setThumbnailImgSize(GenericBase.__getLong(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setMatrixImg(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setMatrixImgSize(GenericBase.__getLong(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setStandardImg(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setStandardImgSize(GenericBase.__getLong(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setCitationTimes(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setUploader(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setCreateTime(GenericBase.__getDate(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setUpdateTime(GenericBase.__getDate(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setVideoImage(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setVideoImageSize(GenericBase.__getLong(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setImgWidth(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setImgHeight(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setIconImgWidth(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setIconImgHeight(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setThumbnailImgWidth(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setThumbnailImgHeight(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setMatrixImgWidth(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setMatrixImgHeight(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setStandardImgWidth(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setStandardImgHeight(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setVideoTime(GenericBase.__getLong(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setDominantColor(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setFileTransferKey(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setFileTransferStatus(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setIconImgTransferKey(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setIconImgTransferStatus(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setThumbnailImgTransferKey(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setThumbnailImgTransferStatus(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setMatrixImgTransferKey(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setMatrixImgTransferStatus(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setStandardImgTransferKey(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setStandardImgTransferStatus(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setVideoImageTransferKey(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setVideoImageTransferStatus(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setOriginalFileId(GenericBase.__getInt(val));
		}
	}

	@Override
	public void setBaseToBuffer(BaseFileManage b, Object[] buff){
		int count = 0;
		buff[count++] = b.getFileId();
		buff[count++] = b.getFileName();
		buff[count++] = b.getFileExtension();
		buff[count++] = b.getFileType();
		buff[count++] = b.getFileSize();
		buff[count++] = b.getFileUrl();
		buff[count++] = b.getIconImg();
		buff[count++] = b.getIconImgSize();
		buff[count++] = b.getThumbnailImg();
		buff[count++] = b.getThumbnailImgSize();
		buff[count++] = b.getMatrixImg();
		buff[count++] = b.getMatrixImgSize();
		buff[count++] = b.getStandardImg();
		buff[count++] = b.getStandardImgSize();
		buff[count++] = b.getCitationTimes();
		buff[count++] = b.getUploader();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = generateTimestampFromDate(b.getUpdateTime());
		buff[count++] = b.getVideoImage();
		buff[count++] = b.getVideoImageSize();
		buff[count++] = b.getImgWidth();
		buff[count++] = b.getImgHeight();
		buff[count++] = b.getIconImgWidth();
		buff[count++] = b.getIconImgHeight();
		buff[count++] = b.getThumbnailImgWidth();
		buff[count++] = b.getThumbnailImgHeight();
		buff[count++] = b.getMatrixImgWidth();
		buff[count++] = b.getMatrixImgHeight();
		buff[count++] = b.getStandardImgWidth();
		buff[count++] = b.getStandardImgHeight();
		buff[count++] = b.getVideoTime();
		buff[count++] = b.getDominantColor();
		buff[count++] = b.getFileTransferKey();
		buff[count++] = b.getFileTransferStatus();
		buff[count++] = b.getIconImgTransferKey();
		buff[count++] = b.getIconImgTransferStatus();
		buff[count++] = b.getThumbnailImgTransferKey();
		buff[count++] = b.getThumbnailImgTransferStatus();
		buff[count++] = b.getMatrixImgTransferKey();
		buff[count++] = b.getMatrixImgTransferStatus();
		buff[count++] = b.getStandardImgTransferKey();
		buff[count++] = b.getStandardImgTransferStatus();
		buff[count++] = b.getVideoImageTransferKey();
		buff[count++] = b.getVideoImageTransferStatus();
		buff[count++] = b.getOriginalFileId();
	}

	@Override
	public void setDataFromBase(BaseFileManage b){
		if(b.getFileId() != null) setFileIdClear(b.getFileId());
		if(b.getFileName() != null) setFileName(b.getFileName());
		if(b.getFileExtension() != null) setFileExtension(b.getFileExtension());
		if(b.getFileType() != null) setFileType(b.getFileType());
		if(b.getFileSize() != null) setFileSize(b.getFileSize());
		if(b.getFileUrl() != null) setFileUrl(b.getFileUrl());
		if(b.getIconImg() != null) setIconImg(b.getIconImg());
		if(b.getIconImgSize() != null) setIconImgSize(b.getIconImgSize());
		if(b.getThumbnailImg() != null) setThumbnailImg(b.getThumbnailImg());
		if(b.getThumbnailImgSize() != null) setThumbnailImgSize(b.getThumbnailImgSize());
		if(b.getMatrixImg() != null) setMatrixImg(b.getMatrixImg());
		if(b.getMatrixImgSize() != null) setMatrixImgSize(b.getMatrixImgSize());
		if(b.getStandardImg() != null) setStandardImg(b.getStandardImg());
		if(b.getStandardImgSize() != null) setStandardImgSize(b.getStandardImgSize());
		if(b.getCitationTimes() != null) setCitationTimes(b.getCitationTimes());
		if(b.getUploader() != null) setUploader(b.getUploader());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getUpdateTime() != null) setUpdateTime(b.getUpdateTime());
		if(b.getVideoImage() != null) setVideoImage(b.getVideoImage());
		if(b.getVideoImageSize() != null) setVideoImageSize(b.getVideoImageSize());
		if(b.getImgWidth() != null) setImgWidth(b.getImgWidth());
		if(b.getImgHeight() != null) setImgHeight(b.getImgHeight());
		if(b.getIconImgWidth() != null) setIconImgWidth(b.getIconImgWidth());
		if(b.getIconImgHeight() != null) setIconImgHeight(b.getIconImgHeight());
		if(b.getThumbnailImgWidth() != null) setThumbnailImgWidth(b.getThumbnailImgWidth());
		if(b.getThumbnailImgHeight() != null) setThumbnailImgHeight(b.getThumbnailImgHeight());
		if(b.getMatrixImgWidth() != null) setMatrixImgWidth(b.getMatrixImgWidth());
		if(b.getMatrixImgHeight() != null) setMatrixImgHeight(b.getMatrixImgHeight());
		if(b.getStandardImgWidth() != null) setStandardImgWidth(b.getStandardImgWidth());
		if(b.getStandardImgHeight() != null) setStandardImgHeight(b.getStandardImgHeight());
		if(b.getVideoTime() != null) setVideoTime(b.getVideoTime());
		if(b.getDominantColor() != null) setDominantColor(b.getDominantColor());
		if(b.getFileTransferKey() != null) setFileTransferKey(b.getFileTransferKey());
		if(b.getFileTransferStatus() != null) setFileTransferStatus(b.getFileTransferStatus());
		if(b.getIconImgTransferKey() != null) setIconImgTransferKey(b.getIconImgTransferKey());
		if(b.getIconImgTransferStatus() != null) setIconImgTransferStatus(b.getIconImgTransferStatus());
		if(b.getThumbnailImgTransferKey() != null) setThumbnailImgTransferKey(b.getThumbnailImgTransferKey());
		if(b.getThumbnailImgTransferStatus() != null) setThumbnailImgTransferStatus(b.getThumbnailImgTransferStatus());
		if(b.getMatrixImgTransferKey() != null) setMatrixImgTransferKey(b.getMatrixImgTransferKey());
		if(b.getMatrixImgTransferStatus() != null) setMatrixImgTransferStatus(b.getMatrixImgTransferStatus());
		if(b.getStandardImgTransferKey() != null) setStandardImgTransferKey(b.getStandardImgTransferKey());
		if(b.getStandardImgTransferStatus() != null) setStandardImgTransferStatus(b.getStandardImgTransferStatus());
		if(b.getVideoImageTransferKey() != null) setVideoImageTransferKey(b.getVideoImageTransferKey());
		if(b.getVideoImageTransferStatus() != null) setVideoImageTransferStatus(b.getVideoImageTransferStatus());
		if(b.getOriginalFileId() != null) setOriginalFileId(b.getOriginalFileId());
	}

	@Override
	public BaseFileManage generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseFileManage b = new BaseFileManage();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseFileManage __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFileId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFileName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFileExtension(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFileType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFileSize(GenericBase.__getLong(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFileUrl(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIconImg(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIconImgSize(GenericBase.__getLong(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setThumbnailImg(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setThumbnailImgSize(GenericBase.__getLong(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMatrixImg(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMatrixImgSize(GenericBase.__getLong(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStandardImg(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStandardImgSize(GenericBase.__getLong(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCitationTimes(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUploader(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUpdateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setVideoImage(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setVideoImageSize(GenericBase.__getLong(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setImgWidth(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setImgHeight(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIconImgWidth(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIconImgHeight(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setThumbnailImgWidth(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setThumbnailImgHeight(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMatrixImgWidth(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMatrixImgHeight(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStandardImgWidth(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStandardImgHeight(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setVideoTime(GenericBase.__getLong(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDominantColor(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFileTransferKey(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFileTransferStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIconImgTransferKey(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIconImgTransferStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setThumbnailImgTransferKey(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setThumbnailImgTransferStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMatrixImgTransferKey(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMatrixImgTransferStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStandardImgTransferKey(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStandardImgTransferStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setVideoImageTransferKey(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setVideoImageTransferStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOriginalFileId(GenericBase.__getInt(val));
	}

	public void setFileId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getFileId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setFileIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setFileName(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getFileName() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setFileExtension(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getFileExtension() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setFileType(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getFileType() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setFileSize(java.lang.Long val) {
		setCurrentData(4, val);
	}

	public java.lang.Long getFileSize() {
		return GenericBase.__getLong(__current_data[4]);
	}

	public void setFileUrl(java.lang.String val) {
		setCurrentData(5, val);
	}

	public java.lang.String getFileUrl() {
		return GenericBase.__getString(__current_data[5]);
	}

	public void setIconImg(java.lang.String val) {
		setCurrentData(6, val);
	}

	public java.lang.String getIconImg() {
		return GenericBase.__getString(__current_data[6]);
	}

	public void setIconImgSize(java.lang.Long val) {
		setCurrentData(7, val);
	}

	public java.lang.Long getIconImgSize() {
		return GenericBase.__getLong(__current_data[7]);
	}

	public void setThumbnailImg(java.lang.String val) {
		setCurrentData(8, val);
	}

	public java.lang.String getThumbnailImg() {
		return GenericBase.__getString(__current_data[8]);
	}

	public void setThumbnailImgSize(java.lang.Long val) {
		setCurrentData(9, val);
	}

	public java.lang.Long getThumbnailImgSize() {
		return GenericBase.__getLong(__current_data[9]);
	}

	public void setMatrixImg(java.lang.String val) {
		setCurrentData(10, val);
	}

	public java.lang.String getMatrixImg() {
		return GenericBase.__getString(__current_data[10]);
	}

	public void setMatrixImgSize(java.lang.Long val) {
		setCurrentData(11, val);
	}

	public java.lang.Long getMatrixImgSize() {
		return GenericBase.__getLong(__current_data[11]);
	}

	public void setStandardImg(java.lang.String val) {
		setCurrentData(12, val);
	}

	public java.lang.String getStandardImg() {
		return GenericBase.__getString(__current_data[12]);
	}

	public void setStandardImgSize(java.lang.Long val) {
		setCurrentData(13, val);
	}

	public java.lang.Long getStandardImgSize() {
		return GenericBase.__getLong(__current_data[13]);
	}

	public void setCitationTimes(java.lang.Integer val) {
		setCurrentData(14, val);
	}

	public java.lang.Integer getCitationTimes() {
		return GenericBase.__getInt(__current_data[14]);
	}

	public void setUploader(java.lang.Integer val) {
		setCurrentData(15, val);
	}

	public java.lang.Integer getUploader() {
		return GenericBase.__getInt(__current_data[15]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(16, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[16]);
	}

	public void setUpdateTime(java.util.Date val) {
		setCurrentData(17, generateTimestampFromDate(val));
	}

	public java.util.Date getUpdateTime() {
		return GenericBase.__getDateFromSQL(__current_data[17]);
	}

	public void setVideoImage(java.lang.String val) {
		setCurrentData(18, val);
	}

	public java.lang.String getVideoImage() {
		return GenericBase.__getString(__current_data[18]);
	}

	public void setVideoImageSize(java.lang.Long val) {
		setCurrentData(19, val);
	}

	public java.lang.Long getVideoImageSize() {
		return GenericBase.__getLong(__current_data[19]);
	}

	public void setImgWidth(java.lang.Integer val) {
		setCurrentData(20, val);
	}

	public java.lang.Integer getImgWidth() {
		return GenericBase.__getInt(__current_data[20]);
	}

	public void setImgHeight(java.lang.Integer val) {
		setCurrentData(21, val);
	}

	public java.lang.Integer getImgHeight() {
		return GenericBase.__getInt(__current_data[21]);
	}

	public void setIconImgWidth(java.lang.Integer val) {
		setCurrentData(22, val);
	}

	public java.lang.Integer getIconImgWidth() {
		return GenericBase.__getInt(__current_data[22]);
	}

	public void setIconImgHeight(java.lang.Integer val) {
		setCurrentData(23, val);
	}

	public java.lang.Integer getIconImgHeight() {
		return GenericBase.__getInt(__current_data[23]);
	}

	public void setThumbnailImgWidth(java.lang.Integer val) {
		setCurrentData(24, val);
	}

	public java.lang.Integer getThumbnailImgWidth() {
		return GenericBase.__getInt(__current_data[24]);
	}

	public void setThumbnailImgHeight(java.lang.Integer val) {
		setCurrentData(25, val);
	}

	public java.lang.Integer getThumbnailImgHeight() {
		return GenericBase.__getInt(__current_data[25]);
	}

	public void setMatrixImgWidth(java.lang.Integer val) {
		setCurrentData(26, val);
	}

	public java.lang.Integer getMatrixImgWidth() {
		return GenericBase.__getInt(__current_data[26]);
	}

	public void setMatrixImgHeight(java.lang.Integer val) {
		setCurrentData(27, val);
	}

	public java.lang.Integer getMatrixImgHeight() {
		return GenericBase.__getInt(__current_data[27]);
	}

	public void setStandardImgWidth(java.lang.Integer val) {
		setCurrentData(28, val);
	}

	public java.lang.Integer getStandardImgWidth() {
		return GenericBase.__getInt(__current_data[28]);
	}

	public void setStandardImgHeight(java.lang.Integer val) {
		setCurrentData(29, val);
	}

	public java.lang.Integer getStandardImgHeight() {
		return GenericBase.__getInt(__current_data[29]);
	}

	public void setVideoTime(java.lang.Long val) {
		setCurrentData(30, val);
	}

	public java.lang.Long getVideoTime() {
		return GenericBase.__getLong(__current_data[30]);
	}

	public void setDominantColor(java.lang.String val) {
		setCurrentData(31, val);
	}

	public java.lang.String getDominantColor() {
		return GenericBase.__getString(__current_data[31]);
	}

	public void setFileTransferKey(java.lang.String val) {
		setCurrentData(32, val);
	}

	public java.lang.String getFileTransferKey() {
		return GenericBase.__getString(__current_data[32]);
	}

	public void setFileTransferStatus(java.lang.Integer val) {
		setCurrentData(33, val);
	}

	public java.lang.Integer getFileTransferStatus() {
		return GenericBase.__getInt(__current_data[33]);
	}

	public void setIconImgTransferKey(java.lang.String val) {
		setCurrentData(34, val);
	}

	public java.lang.String getIconImgTransferKey() {
		return GenericBase.__getString(__current_data[34]);
	}

	public void setIconImgTransferStatus(java.lang.Integer val) {
		setCurrentData(35, val);
	}

	public java.lang.Integer getIconImgTransferStatus() {
		return GenericBase.__getInt(__current_data[35]);
	}

	public void setThumbnailImgTransferKey(java.lang.String val) {
		setCurrentData(36, val);
	}

	public java.lang.String getThumbnailImgTransferKey() {
		return GenericBase.__getString(__current_data[36]);
	}

	public void setThumbnailImgTransferStatus(java.lang.Integer val) {
		setCurrentData(37, val);
	}

	public java.lang.Integer getThumbnailImgTransferStatus() {
		return GenericBase.__getInt(__current_data[37]);
	}

	public void setMatrixImgTransferKey(java.lang.String val) {
		setCurrentData(38, val);
	}

	public java.lang.String getMatrixImgTransferKey() {
		return GenericBase.__getString(__current_data[38]);
	}

	public void setMatrixImgTransferStatus(java.lang.Integer val) {
		setCurrentData(39, val);
	}

	public java.lang.Integer getMatrixImgTransferStatus() {
		return GenericBase.__getInt(__current_data[39]);
	}

	public void setStandardImgTransferKey(java.lang.String val) {
		setCurrentData(40, val);
	}

	public java.lang.String getStandardImgTransferKey() {
		return GenericBase.__getString(__current_data[40]);
	}

	public void setStandardImgTransferStatus(java.lang.Integer val) {
		setCurrentData(41, val);
	}

	public java.lang.Integer getStandardImgTransferStatus() {
		return GenericBase.__getInt(__current_data[41]);
	}

	public void setVideoImageTransferKey(java.lang.String val) {
		setCurrentData(42, val);
	}

	public java.lang.String getVideoImageTransferKey() {
		return GenericBase.__getString(__current_data[42]);
	}

	public void setVideoImageTransferStatus(java.lang.Integer val) {
		setCurrentData(43, val);
	}

	public java.lang.Integer getVideoImageTransferStatus() {
		return GenericBase.__getInt(__current_data[43]);
	}

	public void setOriginalFileId(java.lang.Integer val) {
		setCurrentData(44, val);
	}

	public java.lang.Integer getOriginalFileId() {
		return GenericBase.__getInt(__current_data[44]);
	}

	public void setConditionFileId(String op, java.lang.Integer val) {
		addSingleCondition(0, op, val);
	}

	public void setConditionFileId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, new Object[] { val });
	}

	public void setSelectFileId(boolean val) {
		__select_flags[0] = val;
	}

	public void setFileIdExpression(String val) {
		__dataExpressions[0] = val;
	}

	public void setConditionFileName(String op, java.lang.String val) {
		addSingleCondition(1, op, val);
	}

	public void setConditionFileName(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, new Object[] { val });
	}

	public void setSelectFileName(boolean val) {
		__select_flags[1] = val;
	}

	public void setFileNameExpression(String val) {
		__dataExpressions[1] = val;
	}

	public void setConditionFileExtension(String op, java.lang.String val) {
		addSingleCondition(2, op, val);
	}

	public void setConditionFileExtension(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, new Object[] { val });
	}

	public void setSelectFileExtension(boolean val) {
		__select_flags[2] = val;
	}

	public void setFileExtensionExpression(String val) {
		__dataExpressions[2] = val;
	}

	public void setConditionFileType(String op, java.lang.Integer val) {
		addSingleCondition(3, op, val);
	}

	public void setConditionFileType(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, new Object[] { val });
	}

	public void setSelectFileType(boolean val) {
		__select_flags[3] = val;
	}

	public void setFileTypeExpression(String val) {
		__dataExpressions[3] = val;
	}

	public void setConditionFileSize(String op, java.lang.Long val) {
		addSingleCondition(4, op, val);
	}

	public void setConditionFileSize(String op, java.lang.Long val, String relation) {
		addCondition(4, op, relation, new Object[] { val });
	}

	public void setSelectFileSize(boolean val) {
		__select_flags[4] = val;
	}

	public void setFileSizeExpression(String val) {
		__dataExpressions[4] = val;
	}

	public void setConditionFileUrl(String op, java.lang.String val) {
		addSingleCondition(5, op, val);
	}

	public void setConditionFileUrl(String op, java.lang.String val, String relation) {
		addCondition(5, op, relation, new Object[] { val });
	}

	public void setSelectFileUrl(boolean val) {
		__select_flags[5] = val;
	}

	public void setFileUrlExpression(String val) {
		__dataExpressions[5] = val;
	}

	public void setConditionIconImg(String op, java.lang.String val) {
		addSingleCondition(6, op, val);
	}

	public void setConditionIconImg(String op, java.lang.String val, String relation) {
		addCondition(6, op, relation, new Object[] { val });
	}

	public void setSelectIconImg(boolean val) {
		__select_flags[6] = val;
	}

	public void setIconImgExpression(String val) {
		__dataExpressions[6] = val;
	}

	public void setConditionIconImgSize(String op, java.lang.Long val) {
		addSingleCondition(7, op, val);
	}

	public void setConditionIconImgSize(String op, java.lang.Long val, String relation) {
		addCondition(7, op, relation, new Object[] { val });
	}

	public void setSelectIconImgSize(boolean val) {
		__select_flags[7] = val;
	}

	public void setIconImgSizeExpression(String val) {
		__dataExpressions[7] = val;
	}

	public void setConditionThumbnailImg(String op, java.lang.String val) {
		addSingleCondition(8, op, val);
	}

	public void setConditionThumbnailImg(String op, java.lang.String val, String relation) {
		addCondition(8, op, relation, new Object[] { val });
	}

	public void setSelectThumbnailImg(boolean val) {
		__select_flags[8] = val;
	}

	public void setThumbnailImgExpression(String val) {
		__dataExpressions[8] = val;
	}

	public void setConditionThumbnailImgSize(String op, java.lang.Long val) {
		addSingleCondition(9, op, val);
	}

	public void setConditionThumbnailImgSize(String op, java.lang.Long val, String relation) {
		addCondition(9, op, relation, new Object[] { val });
	}

	public void setSelectThumbnailImgSize(boolean val) {
		__select_flags[9] = val;
	}

	public void setThumbnailImgSizeExpression(String val) {
		__dataExpressions[9] = val;
	}

	public void setConditionMatrixImg(String op, java.lang.String val) {
		addSingleCondition(10, op, val);
	}

	public void setConditionMatrixImg(String op, java.lang.String val, String relation) {
		addCondition(10, op, relation, new Object[] { val });
	}

	public void setSelectMatrixImg(boolean val) {
		__select_flags[10] = val;
	}

	public void setMatrixImgExpression(String val) {
		__dataExpressions[10] = val;
	}

	public void setConditionMatrixImgSize(String op, java.lang.Long val) {
		addSingleCondition(11, op, val);
	}

	public void setConditionMatrixImgSize(String op, java.lang.Long val, String relation) {
		addCondition(11, op, relation, new Object[] { val });
	}

	public void setSelectMatrixImgSize(boolean val) {
		__select_flags[11] = val;
	}

	public void setMatrixImgSizeExpression(String val) {
		__dataExpressions[11] = val;
	}

	public void setConditionStandardImg(String op, java.lang.String val) {
		addSingleCondition(12, op, val);
	}

	public void setConditionStandardImg(String op, java.lang.String val, String relation) {
		addCondition(12, op, relation, new Object[] { val });
	}

	public void setSelectStandardImg(boolean val) {
		__select_flags[12] = val;
	}

	public void setStandardImgExpression(String val) {
		__dataExpressions[12] = val;
	}

	public void setConditionStandardImgSize(String op, java.lang.Long val) {
		addSingleCondition(13, op, val);
	}

	public void setConditionStandardImgSize(String op, java.lang.Long val, String relation) {
		addCondition(13, op, relation, new Object[] { val });
	}

	public void setSelectStandardImgSize(boolean val) {
		__select_flags[13] = val;
	}

	public void setStandardImgSizeExpression(String val) {
		__dataExpressions[13] = val;
	}

	public void setConditionCitationTimes(String op, java.lang.Integer val) {
		addSingleCondition(14, op, val);
	}

	public void setConditionCitationTimes(String op, java.lang.Integer val, String relation) {
		addCondition(14, op, relation, new Object[] { val });
	}

	public void setSelectCitationTimes(boolean val) {
		__select_flags[14] = val;
	}

	public void setCitationTimesExpression(String val) {
		__dataExpressions[14] = val;
	}

	public void setConditionUploader(String op, java.lang.Integer val) {
		addSingleCondition(15, op, val);
	}

	public void setConditionUploader(String op, java.lang.Integer val, String relation) {
		addCondition(15, op, relation, new Object[] { val });
	}

	public void setSelectUploader(boolean val) {
		__select_flags[15] = val;
	}

	public void setUploaderExpression(String val) {
		__dataExpressions[15] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		addSingleCondition(16, op, val);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(16, op, relation, new Object[] { generateTimestampFromDate(val) });
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[16] = val;
	}

	public void setCreateTimeExpression(String val) {
		__dataExpressions[16] = val;
	}

	public void setConditionUpdateTime(String op, java.util.Date val) {
		addSingleCondition(17, op, val);
	}

	public void setConditionUpdateTime(String op, java.util.Date val, String relation) {
		addCondition(17, op, relation, new Object[] { generateTimestampFromDate(val) });
	}

	public void setSelectUpdateTime(boolean val) {
		__select_flags[17] = val;
	}

	public void setUpdateTimeExpression(String val) {
		__dataExpressions[17] = val;
	}

	public void setConditionVideoImage(String op, java.lang.String val) {
		addSingleCondition(18, op, val);
	}

	public void setConditionVideoImage(String op, java.lang.String val, String relation) {
		addCondition(18, op, relation, new Object[] { val });
	}

	public void setSelectVideoImage(boolean val) {
		__select_flags[18] = val;
	}

	public void setVideoImageExpression(String val) {
		__dataExpressions[18] = val;
	}

	public void setConditionVideoImageSize(String op, java.lang.Long val) {
		addSingleCondition(19, op, val);
	}

	public void setConditionVideoImageSize(String op, java.lang.Long val, String relation) {
		addCondition(19, op, relation, new Object[] { val });
	}

	public void setSelectVideoImageSize(boolean val) {
		__select_flags[19] = val;
	}

	public void setVideoImageSizeExpression(String val) {
		__dataExpressions[19] = val;
	}

	public void setConditionImgWidth(String op, java.lang.Integer val) {
		addSingleCondition(20, op, val);
	}

	public void setConditionImgWidth(String op, java.lang.Integer val, String relation) {
		addCondition(20, op, relation, new Object[] { val });
	}

	public void setSelectImgWidth(boolean val) {
		__select_flags[20] = val;
	}

	public void setImgWidthExpression(String val) {
		__dataExpressions[20] = val;
	}

	public void setConditionImgHeight(String op, java.lang.Integer val) {
		addSingleCondition(21, op, val);
	}

	public void setConditionImgHeight(String op, java.lang.Integer val, String relation) {
		addCondition(21, op, relation, new Object[] { val });
	}

	public void setSelectImgHeight(boolean val) {
		__select_flags[21] = val;
	}

	public void setImgHeightExpression(String val) {
		__dataExpressions[21] = val;
	}

	public void setConditionIconImgWidth(String op, java.lang.Integer val) {
		addSingleCondition(22, op, val);
	}

	public void setConditionIconImgWidth(String op, java.lang.Integer val, String relation) {
		addCondition(22, op, relation, new Object[] { val });
	}

	public void setSelectIconImgWidth(boolean val) {
		__select_flags[22] = val;
	}

	public void setIconImgWidthExpression(String val) {
		__dataExpressions[22] = val;
	}

	public void setConditionIconImgHeight(String op, java.lang.Integer val) {
		addSingleCondition(23, op, val);
	}

	public void setConditionIconImgHeight(String op, java.lang.Integer val, String relation) {
		addCondition(23, op, relation, new Object[] { val });
	}

	public void setSelectIconImgHeight(boolean val) {
		__select_flags[23] = val;
	}

	public void setIconImgHeightExpression(String val) {
		__dataExpressions[23] = val;
	}

	public void setConditionThumbnailImgWidth(String op, java.lang.Integer val) {
		addSingleCondition(24, op, val);
	}

	public void setConditionThumbnailImgWidth(String op, java.lang.Integer val, String relation) {
		addCondition(24, op, relation, new Object[] { val });
	}

	public void setSelectThumbnailImgWidth(boolean val) {
		__select_flags[24] = val;
	}

	public void setThumbnailImgWidthExpression(String val) {
		__dataExpressions[24] = val;
	}

	public void setConditionThumbnailImgHeight(String op, java.lang.Integer val) {
		addSingleCondition(25, op, val);
	}

	public void setConditionThumbnailImgHeight(String op, java.lang.Integer val, String relation) {
		addCondition(25, op, relation, new Object[] { val });
	}

	public void setSelectThumbnailImgHeight(boolean val) {
		__select_flags[25] = val;
	}

	public void setThumbnailImgHeightExpression(String val) {
		__dataExpressions[25] = val;
	}

	public void setConditionMatrixImgWidth(String op, java.lang.Integer val) {
		addSingleCondition(26, op, val);
	}

	public void setConditionMatrixImgWidth(String op, java.lang.Integer val, String relation) {
		addCondition(26, op, relation, new Object[] { val });
	}

	public void setSelectMatrixImgWidth(boolean val) {
		__select_flags[26] = val;
	}

	public void setMatrixImgWidthExpression(String val) {
		__dataExpressions[26] = val;
	}

	public void setConditionMatrixImgHeight(String op, java.lang.Integer val) {
		addSingleCondition(27, op, val);
	}

	public void setConditionMatrixImgHeight(String op, java.lang.Integer val, String relation) {
		addCondition(27, op, relation, new Object[] { val });
	}

	public void setSelectMatrixImgHeight(boolean val) {
		__select_flags[27] = val;
	}

	public void setMatrixImgHeightExpression(String val) {
		__dataExpressions[27] = val;
	}

	public void setConditionStandardImgWidth(String op, java.lang.Integer val) {
		addSingleCondition(28, op, val);
	}

	public void setConditionStandardImgWidth(String op, java.lang.Integer val, String relation) {
		addCondition(28, op, relation, new Object[] { val });
	}

	public void setSelectStandardImgWidth(boolean val) {
		__select_flags[28] = val;
	}

	public void setStandardImgWidthExpression(String val) {
		__dataExpressions[28] = val;
	}

	public void setConditionStandardImgHeight(String op, java.lang.Integer val) {
		addSingleCondition(29, op, val);
	}

	public void setConditionStandardImgHeight(String op, java.lang.Integer val, String relation) {
		addCondition(29, op, relation, new Object[] { val });
	}

	public void setSelectStandardImgHeight(boolean val) {
		__select_flags[29] = val;
	}

	public void setStandardImgHeightExpression(String val) {
		__dataExpressions[29] = val;
	}

	public void setConditionVideoTime(String op, java.lang.Long val) {
		addSingleCondition(30, op, val);
	}

	public void setConditionVideoTime(String op, java.lang.Long val, String relation) {
		addCondition(30, op, relation, new Object[] { val });
	}

	public void setSelectVideoTime(boolean val) {
		__select_flags[30] = val;
	}

	public void setVideoTimeExpression(String val) {
		__dataExpressions[30] = val;
	}

	public void setConditionDominantColor(String op, java.lang.String val) {
		addSingleCondition(31, op, val);
	}

	public void setConditionDominantColor(String op, java.lang.String val, String relation) {
		addCondition(31, op, relation, new Object[] { val });
	}

	public void setSelectDominantColor(boolean val) {
		__select_flags[31] = val;
	}

	public void setDominantColorExpression(String val) {
		__dataExpressions[31] = val;
	}

	public void setConditionFileTransferKey(String op, java.lang.String val) {
		addSingleCondition(32, op, val);
	}

	public void setConditionFileTransferKey(String op, java.lang.String val, String relation) {
		addCondition(32, op, relation, new Object[] { val });
	}

	public void setSelectFileTransferKey(boolean val) {
		__select_flags[32] = val;
	}

	public void setFileTransferKeyExpression(String val) {
		__dataExpressions[32] = val;
	}

	public void setConditionFileTransferStatus(String op, java.lang.Integer val) {
		addSingleCondition(33, op, val);
	}

	public void setConditionFileTransferStatus(String op, java.lang.Integer val, String relation) {
		addCondition(33, op, relation, new Object[] { val });
	}

	public void setSelectFileTransferStatus(boolean val) {
		__select_flags[33] = val;
	}

	public void setFileTransferStatusExpression(String val) {
		__dataExpressions[33] = val;
	}

	public void setConditionIconImgTransferKey(String op, java.lang.String val) {
		addSingleCondition(34, op, val);
	}

	public void setConditionIconImgTransferKey(String op, java.lang.String val, String relation) {
		addCondition(34, op, relation, new Object[] { val });
	}

	public void setSelectIconImgTransferKey(boolean val) {
		__select_flags[34] = val;
	}

	public void setIconImgTransferKeyExpression(String val) {
		__dataExpressions[34] = val;
	}

	public void setConditionIconImgTransferStatus(String op, java.lang.Integer val) {
		addSingleCondition(35, op, val);
	}

	public void setConditionIconImgTransferStatus(String op, java.lang.Integer val, String relation) {
		addCondition(35, op, relation, new Object[] { val });
	}

	public void setSelectIconImgTransferStatus(boolean val) {
		__select_flags[35] = val;
	}

	public void setIconImgTransferStatusExpression(String val) {
		__dataExpressions[35] = val;
	}

	public void setConditionThumbnailImgTransferKey(String op, java.lang.String val) {
		addSingleCondition(36, op, val);
	}

	public void setConditionThumbnailImgTransferKey(String op, java.lang.String val, String relation) {
		addCondition(36, op, relation, new Object[] { val });
	}

	public void setSelectThumbnailImgTransferKey(boolean val) {
		__select_flags[36] = val;
	}

	public void setThumbnailImgTransferKeyExpression(String val) {
		__dataExpressions[36] = val;
	}

	public void setConditionThumbnailImgTransferStatus(String op, java.lang.Integer val) {
		addSingleCondition(37, op, val);
	}

	public void setConditionThumbnailImgTransferStatus(String op, java.lang.Integer val, String relation) {
		addCondition(37, op, relation, new Object[] { val });
	}

	public void setSelectThumbnailImgTransferStatus(boolean val) {
		__select_flags[37] = val;
	}

	public void setThumbnailImgTransferStatusExpression(String val) {
		__dataExpressions[37] = val;
	}

	public void setConditionMatrixImgTransferKey(String op, java.lang.String val) {
		addSingleCondition(38, op, val);
	}

	public void setConditionMatrixImgTransferKey(String op, java.lang.String val, String relation) {
		addCondition(38, op, relation, new Object[] { val });
	}

	public void setSelectMatrixImgTransferKey(boolean val) {
		__select_flags[38] = val;
	}

	public void setMatrixImgTransferKeyExpression(String val) {
		__dataExpressions[38] = val;
	}

	public void setConditionMatrixImgTransferStatus(String op, java.lang.Integer val) {
		addSingleCondition(39, op, val);
	}

	public void setConditionMatrixImgTransferStatus(String op, java.lang.Integer val, String relation) {
		addCondition(39, op, relation, new Object[] { val });
	}

	public void setSelectMatrixImgTransferStatus(boolean val) {
		__select_flags[39] = val;
	}

	public void setMatrixImgTransferStatusExpression(String val) {
		__dataExpressions[39] = val;
	}

	public void setConditionStandardImgTransferKey(String op, java.lang.String val) {
		addSingleCondition(40, op, val);
	}

	public void setConditionStandardImgTransferKey(String op, java.lang.String val, String relation) {
		addCondition(40, op, relation, new Object[] { val });
	}

	public void setSelectStandardImgTransferKey(boolean val) {
		__select_flags[40] = val;
	}

	public void setStandardImgTransferKeyExpression(String val) {
		__dataExpressions[40] = val;
	}

	public void setConditionStandardImgTransferStatus(String op, java.lang.Integer val) {
		addSingleCondition(41, op, val);
	}

	public void setConditionStandardImgTransferStatus(String op, java.lang.Integer val, String relation) {
		addCondition(41, op, relation, new Object[] { val });
	}

	public void setSelectStandardImgTransferStatus(boolean val) {
		__select_flags[41] = val;
	}

	public void setStandardImgTransferStatusExpression(String val) {
		__dataExpressions[41] = val;
	}

	public void setConditionVideoImageTransferKey(String op, java.lang.String val) {
		addSingleCondition(42, op, val);
	}

	public void setConditionVideoImageTransferKey(String op, java.lang.String val, String relation) {
		addCondition(42, op, relation, new Object[] { val });
	}

	public void setSelectVideoImageTransferKey(boolean val) {
		__select_flags[42] = val;
	}

	public void setVideoImageTransferKeyExpression(String val) {
		__dataExpressions[42] = val;
	}

	public void setConditionVideoImageTransferStatus(String op, java.lang.Integer val) {
		addSingleCondition(43, op, val);
	}

	public void setConditionVideoImageTransferStatus(String op, java.lang.Integer val, String relation) {
		addCondition(43, op, relation, new Object[] { val });
	}

	public void setSelectVideoImageTransferStatus(boolean val) {
		__select_flags[43] = val;
	}

	public void setVideoImageTransferStatusExpression(String val) {
		__dataExpressions[43] = val;
	}

	public void setConditionOriginalFileId(String op, java.lang.Integer val) {
		addSingleCondition(44, op, val);
	}

	public void setConditionOriginalFileId(String op, java.lang.Integer val, String relation) {
		addCondition(44, op, relation, new Object[] { val });
	}

	public void setSelectOriginalFileId(boolean val) {
		__select_flags[44] = val;
	}

	public void setOriginalFileIdExpression(String val) {
		__dataExpressions[44] = val;
	}


}

