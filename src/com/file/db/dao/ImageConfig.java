package com.file.db.dao;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;
import com.file.db.bean.BaseImageConfig;


public class ImageConfig extends AbstractTable<BaseImageConfig>
{

	public ImageConfig() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 10;

		initTables();

		__tableName            = "image_config";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseImageConfig.CS_IMAGE_CONFIG_ID;
		__column_names[1] = BaseImageConfig.CS_APPLICATION_ID;
		__column_names[2] = BaseImageConfig.CS_ICON_IMG_WIDTH;
		__column_names[3] = BaseImageConfig.CS_ICON_IMG_HEIGHT;
		__column_names[4] = BaseImageConfig.CS_THUMBNAIL_IMG_WIDTH;
		__column_names[5] = BaseImageConfig.CS_THUMBNAIL_IMG_HEIGHT;
		__column_names[6] = BaseImageConfig.CS_MATRIX_IMG_WIDTH;
		__column_names[7] = BaseImageConfig.CS_MATRIX_IMG_HEIGHT;
		__column_names[8] = BaseImageConfig.CS_STANDARD_IMG_WIDTH;
		__column_names[9] = BaseImageConfig.CS_STANDARD_IMG_HEIGHT;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseImageConfig b) {
		clear();
		setImageConfigIdClear(b.getImageConfigId());
	}

	public boolean isPrimaryKeyNull() {
		return getImageConfigId() == null;
	}

	@Override
	public BaseImageConfig generateBase(){
		BaseImageConfig b = new BaseImageConfig();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseImageConfig b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setImageConfigId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setApplicationId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setIconImgWidth(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setIconImgHeight(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setThumbnailImgWidth(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setThumbnailImgHeight(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMatrixImgWidth(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMatrixImgHeight(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setStandardImgWidth(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setStandardImgHeight(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseImageConfig b, Object[] buff){
		int count = 0;
		buff[count++] = b.getImageConfigId();
		buff[count++] = b.getApplicationId();
		buff[count++] = b.getIconImgWidth();
		buff[count++] = b.getIconImgHeight();
		buff[count++] = b.getThumbnailImgWidth();
		buff[count++] = b.getThumbnailImgHeight();
		buff[count++] = b.getMatrixImgWidth();
		buff[count++] = b.getMatrixImgHeight();
		buff[count++] = b.getStandardImgWidth();
		buff[count++] = b.getStandardImgHeight();
	}

	@Override
	public void setDataFromBase(BaseImageConfig b){
		if(b.getImageConfigId() != null) setImageConfigIdClear(b.getImageConfigId());
		if(b.getApplicationId() != null) setApplicationId(b.getApplicationId());
		if(b.getIconImgWidth() != null) setIconImgWidth(b.getIconImgWidth());
		if(b.getIconImgHeight() != null) setIconImgHeight(b.getIconImgHeight());
		if(b.getThumbnailImgWidth() != null) setThumbnailImgWidth(b.getThumbnailImgWidth());
		if(b.getThumbnailImgHeight() != null) setThumbnailImgHeight(b.getThumbnailImgHeight());
		if(b.getMatrixImgWidth() != null) setMatrixImgWidth(b.getMatrixImgWidth());
		if(b.getMatrixImgHeight() != null) setMatrixImgHeight(b.getMatrixImgHeight());
		if(b.getStandardImgWidth() != null) setStandardImgWidth(b.getStandardImgWidth());
		if(b.getStandardImgHeight() != null) setStandardImgHeight(b.getStandardImgHeight());
	}

	@Override
	public BaseImageConfig generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseImageConfig b = new BaseImageConfig();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseImageConfig __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setImageConfigId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setApplicationId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIconImgWidth(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIconImgHeight(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setThumbnailImgWidth(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setThumbnailImgHeight(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMatrixImgWidth(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMatrixImgHeight(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStandardImgWidth(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStandardImgHeight(GenericBase.__getInt(val));
	}

	public void setImageConfigId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getImageConfigId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setImageConfigIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setApplicationId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getApplicationId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setIconImgWidth(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getIconImgWidth() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setIconImgHeight(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getIconImgHeight() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setThumbnailImgWidth(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getThumbnailImgWidth() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setThumbnailImgHeight(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getThumbnailImgHeight() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setMatrixImgWidth(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getMatrixImgWidth() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setMatrixImgHeight(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getMatrixImgHeight() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setStandardImgWidth(java.lang.Integer val) {
		setCurrentData(8, val);
	}

	public java.lang.Integer getStandardImgWidth() {
		return GenericBase.__getInt(__current_data[8]);
	}

	public void setStandardImgHeight(java.lang.Integer val) {
		setCurrentData(9, val);
	}

	public java.lang.Integer getStandardImgHeight() {
		return GenericBase.__getInt(__current_data[9]);
	}

	public void setConditionImageConfigId(String op, java.lang.Integer val) {
		setConditionImageConfigId(op, val, CONDITION_AND);
	}

	public void setConditionImageConfigId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectImageConfigId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionApplicationId(String op, java.lang.Integer val) {
		setConditionApplicationId(op, val, CONDITION_AND);
	}

	public void setConditionApplicationId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectApplicationId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionIconImgWidth(String op, java.lang.Integer val) {
		setConditionIconImgWidth(op, val, CONDITION_AND);
	}

	public void setConditionIconImgWidth(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectIconImgWidth(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionIconImgHeight(String op, java.lang.Integer val) {
		setConditionIconImgHeight(op, val, CONDITION_AND);
	}

	public void setConditionIconImgHeight(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectIconImgHeight(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionThumbnailImgWidth(String op, java.lang.Integer val) {
		setConditionThumbnailImgWidth(op, val, CONDITION_AND);
	}

	public void setConditionThumbnailImgWidth(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectThumbnailImgWidth(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionThumbnailImgHeight(String op, java.lang.Integer val) {
		setConditionThumbnailImgHeight(op, val, CONDITION_AND);
	}

	public void setConditionThumbnailImgHeight(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectThumbnailImgHeight(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionMatrixImgWidth(String op, java.lang.Integer val) {
		setConditionMatrixImgWidth(op, val, CONDITION_AND);
	}

	public void setConditionMatrixImgWidth(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectMatrixImgWidth(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionMatrixImgHeight(String op, java.lang.Integer val) {
		setConditionMatrixImgHeight(op, val, CONDITION_AND);
	}

	public void setConditionMatrixImgHeight(String op, java.lang.Integer val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectMatrixImgHeight(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionStandardImgWidth(String op, java.lang.Integer val) {
		setConditionStandardImgWidth(op, val, CONDITION_AND);
	}

	public void setConditionStandardImgWidth(String op, java.lang.Integer val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectStandardImgWidth(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionStandardImgHeight(String op, java.lang.Integer val) {
		setConditionStandardImgHeight(op, val, CONDITION_AND);
	}

	public void setConditionStandardImgHeight(String op, java.lang.Integer val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectStandardImgHeight(boolean val) {
		__select_flags[9] = val;
	}


}

