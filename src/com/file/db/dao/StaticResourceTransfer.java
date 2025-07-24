package com.file.db.dao;

import delicacy.common.AbstractTable;
import delicacy.common.JsonParser;
import delicacy.common.GenericBase;
import com.file.db.bean.BaseStaticResourceTransfer;


public class StaticResourceTransfer extends AbstractTable<BaseStaticResourceTransfer>
{

	public StaticResourceTransfer() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 15;

		initTables();

		__tableName            = "static_resource_transfers";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseStaticResourceTransfer.CS_STATIC_RESOURCE_TRANSFER_ID;
		__column_names[1] = BaseStaticResourceTransfer.CS_FILE_ID;
		__column_names[2] = BaseStaticResourceTransfer.CS_FILE_NAME;
		__column_names[3] = BaseStaticResourceTransfer.CS_FILE_SIZE;
		__column_names[4] = BaseStaticResourceTransfer.CS_FILE_EXTENSION;
		__column_names[5] = BaseStaticResourceTransfer.CS_TRANSFER_KEY;
		__column_names[6] = BaseStaticResourceTransfer.CS_RELATIVE_FILE_PATH;
		__column_names[7] = BaseStaticResourceTransfer.CS_ABSOLUTE_FILE_PATH;
		__column_names[8] = BaseStaticResourceTransfer.CS_CREATE_TIME;
		__column_names[9] = BaseStaticResourceTransfer.CS_TRANSFER_TYPE;
		__column_names[10] = BaseStaticResourceTransfer.CS_STATUS;
		__column_names[11] = BaseStaticResourceTransfer.CS_BEGIN_TIME;
		__column_names[12] = BaseStaticResourceTransfer.CS_END_TIME;
		__column_names[13] = BaseStaticResourceTransfer.CS_REMARK;
		__column_names[14] = BaseStaticResourceTransfer.CS_DELETE_FLAG;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseStaticResourceTransfer b) {
		clear();
		setStaticResourceTransferIdClear(b.getStaticResourceTransferId());
	}

	public boolean isPrimaryKeyNull() {
		return getStaticResourceTransferId() == null;
	}

	@Override
	public BaseStaticResourceTransfer generateBase(){
		BaseStaticResourceTransfer b = new BaseStaticResourceTransfer();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseStaticResourceTransfer b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setStaticResourceTransferId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setFileId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setFileName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setFileSize(GenericBase.__getLong(val));
		if((val = __current_data[count++]) != null) b.setFileExtension(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setTransferKey(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setRelativeFilePath(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setAbsoluteFilePath(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setTransferType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBeginTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setEndTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setDeleteFlag(GenericBase.__getInt(val));
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
			if(val != null && !val.isEmpty()) setStaticResourceTransferId(GenericBase.__getInt(val));
		}
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
			if(val != null && !val.isEmpty()) setFileSize(GenericBase.__getLong(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setFileExtension(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setTransferKey(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setRelativeFilePath(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setAbsoluteFilePath(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setCreateTime(GenericBase.__getDate(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setTransferType(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setStatus(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setBeginTime(GenericBase.__getDate(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setEndTime(GenericBase.__getDate(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setRemark(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setDeleteFlag(GenericBase.__getInt(val));
		}
	}

	@Override
	public void setBaseToBuffer(BaseStaticResourceTransfer b, Object[] buff){
		int count = 0;
		buff[count++] = b.getStaticResourceTransferId();
		buff[count++] = b.getFileId();
		buff[count++] = b.getFileName();
		buff[count++] = b.getFileSize();
		buff[count++] = b.getFileExtension();
		buff[count++] = b.getTransferKey();
		buff[count++] = b.getRelativeFilePath();
		buff[count++] = b.getAbsoluteFilePath();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = b.getTransferType();
		buff[count++] = b.getStatus();
		buff[count++] = generateTimestampFromDate(b.getBeginTime());
		buff[count++] = generateTimestampFromDate(b.getEndTime());
		buff[count++] = b.getRemark();
		buff[count++] = b.getDeleteFlag();
	}

	@Override
	public void setDataFromBase(BaseStaticResourceTransfer b){
		if(b.getStaticResourceTransferId() != null) setStaticResourceTransferIdClear(b.getStaticResourceTransferId());
		if(b.getFileId() != null) setFileId(b.getFileId());
		if(b.getFileName() != null) setFileName(b.getFileName());
		if(b.getFileSize() != null) setFileSize(b.getFileSize());
		if(b.getFileExtension() != null) setFileExtension(b.getFileExtension());
		if(b.getTransferKey() != null) setTransferKey(b.getTransferKey());
		if(b.getRelativeFilePath() != null) setRelativeFilePath(b.getRelativeFilePath());
		if(b.getAbsoluteFilePath() != null) setAbsoluteFilePath(b.getAbsoluteFilePath());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getTransferType() != null) setTransferType(b.getTransferType());
		if(b.getStatus() != null) setStatus(b.getStatus());
		if(b.getBeginTime() != null) setBeginTime(b.getBeginTime());
		if(b.getEndTime() != null) setEndTime(b.getEndTime());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getDeleteFlag() != null) setDeleteFlag(b.getDeleteFlag());
	}

	@Override
	public BaseStaticResourceTransfer generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseStaticResourceTransfer b = new BaseStaticResourceTransfer();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseStaticResourceTransfer __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStaticResourceTransferId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFileId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFileName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFileSize(GenericBase.__getLong(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFileExtension(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTransferKey(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRelativeFilePath(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAbsoluteFilePath(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTransferType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBeginTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEndTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDeleteFlag(GenericBase.__getInt(val));
	}

	public void setStaticResourceTransferId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getStaticResourceTransferId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setStaticResourceTransferIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setFileId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getFileId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setFileName(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getFileName() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setFileSize(java.lang.Long val) {
		setCurrentData(3, val);
	}

	public java.lang.Long getFileSize() {
		return GenericBase.__getLong(__current_data[3]);
	}

	public void setFileExtension(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getFileExtension() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setTransferKey(java.lang.String val) {
		setCurrentData(5, val);
	}

	public java.lang.String getTransferKey() {
		return GenericBase.__getString(__current_data[5]);
	}

	public void setRelativeFilePath(java.lang.String val) {
		setCurrentData(6, val);
	}

	public java.lang.String getRelativeFilePath() {
		return GenericBase.__getString(__current_data[6]);
	}

	public void setAbsoluteFilePath(java.lang.String val) {
		setCurrentData(7, val);
	}

	public java.lang.String getAbsoluteFilePath() {
		return GenericBase.__getString(__current_data[7]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(8, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[8]);
	}

	public void setTransferType(java.lang.Integer val) {
		setCurrentData(9, val);
	}

	public java.lang.Integer getTransferType() {
		return GenericBase.__getInt(__current_data[9]);
	}

	public void setStatus(java.lang.Integer val) {
		setCurrentData(10, val);
	}

	public java.lang.Integer getStatus() {
		return GenericBase.__getInt(__current_data[10]);
	}

	public void setBeginTime(java.util.Date val) {
		setCurrentData(11, generateTimestampFromDate(val));
	}

	public java.util.Date getBeginTime() {
		return GenericBase.__getDateFromSQL(__current_data[11]);
	}

	public void setEndTime(java.util.Date val) {
		setCurrentData(12, generateTimestampFromDate(val));
	}

	public java.util.Date getEndTime() {
		return GenericBase.__getDateFromSQL(__current_data[12]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(13, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[13]);
	}

	public void setDeleteFlag(java.lang.Integer val) {
		setCurrentData(14, val);
	}

	public java.lang.Integer getDeleteFlag() {
		return GenericBase.__getInt(__current_data[14]);
	}

	public void setConditionStaticResourceTransferId(String op, java.lang.Integer val) {
		setConditionStaticResourceTransferId(op, val, CONDITION_AND);
	}

	public void setConditionStaticResourceTransferId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectStaticResourceTransferId(boolean val) {
		__select_flags[0] = val;
	}

	public void setStaticResourceTransferIdExpression(String val) {
		__dataExpressions[0] = val;
	}

	public void setConditionFileId(String op, java.lang.Integer val) {
		setConditionFileId(op, val, CONDITION_AND);
	}

	public void setConditionFileId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectFileId(boolean val) {
		__select_flags[1] = val;
	}

	public void setFileIdExpression(String val) {
		__dataExpressions[1] = val;
	}

	public void setConditionFileName(String op, java.lang.String val) {
		setConditionFileName(op, val, CONDITION_AND);
	}

	public void setConditionFileName(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectFileName(boolean val) {
		__select_flags[2] = val;
	}

	public void setFileNameExpression(String val) {
		__dataExpressions[2] = val;
	}

	public void setConditionFileSize(String op, java.lang.Long val) {
		setConditionFileSize(op, val, CONDITION_AND);
	}

	public void setConditionFileSize(String op, java.lang.Long val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectFileSize(boolean val) {
		__select_flags[3] = val;
	}

	public void setFileSizeExpression(String val) {
		__dataExpressions[3] = val;
	}

	public void setConditionFileExtension(String op, java.lang.String val) {
		setConditionFileExtension(op, val, CONDITION_AND);
	}

	public void setConditionFileExtension(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectFileExtension(boolean val) {
		__select_flags[4] = val;
	}

	public void setFileExtensionExpression(String val) {
		__dataExpressions[4] = val;
	}

	public void setConditionTransferKey(String op, java.lang.String val) {
		setConditionTransferKey(op, val, CONDITION_AND);
	}

	public void setConditionTransferKey(String op, java.lang.String val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectTransferKey(boolean val) {
		__select_flags[5] = val;
	}

	public void setTransferKeyExpression(String val) {
		__dataExpressions[5] = val;
	}

	public void setConditionRelativeFilePath(String op, java.lang.String val) {
		setConditionRelativeFilePath(op, val, CONDITION_AND);
	}

	public void setConditionRelativeFilePath(String op, java.lang.String val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectRelativeFilePath(boolean val) {
		__select_flags[6] = val;
	}

	public void setRelativeFilePathExpression(String val) {
		__dataExpressions[6] = val;
	}

	public void setConditionAbsoluteFilePath(String op, java.lang.String val) {
		setConditionAbsoluteFilePath(op, val, CONDITION_AND);
	}

	public void setConditionAbsoluteFilePath(String op, java.lang.String val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectAbsoluteFilePath(boolean val) {
		__select_flags[7] = val;
	}

	public void setAbsoluteFilePathExpression(String val) {
		__dataExpressions[7] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(8, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[8] = val;
	}

	public void setCreateTimeExpression(String val) {
		__dataExpressions[8] = val;
	}

	public void setConditionTransferType(String op, java.lang.Integer val) {
		setConditionTransferType(op, val, CONDITION_AND);
	}

	public void setConditionTransferType(String op, java.lang.Integer val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectTransferType(boolean val) {
		__select_flags[9] = val;
	}

	public void setTransferTypeExpression(String val) {
		__dataExpressions[9] = val;
	}

	public void setConditionStatus(String op, java.lang.Integer val) {
		setConditionStatus(op, val, CONDITION_AND);
	}

	public void setConditionStatus(String op, java.lang.Integer val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectStatus(boolean val) {
		__select_flags[10] = val;
	}

	public void setStatusExpression(String val) {
		__dataExpressions[10] = val;
	}

	public void setConditionBeginTime(String op, java.util.Date val) {
		setConditionBeginTime(op, val, CONDITION_AND);
	}

	public void setConditionBeginTime(String op, java.util.Date val, String relation) {
		addCondition(11, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectBeginTime(boolean val) {
		__select_flags[11] = val;
	}

	public void setBeginTimeExpression(String val) {
		__dataExpressions[11] = val;
	}

	public void setConditionEndTime(String op, java.util.Date val) {
		setConditionEndTime(op, val, CONDITION_AND);
	}

	public void setConditionEndTime(String op, java.util.Date val, String relation) {
		addCondition(12, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectEndTime(boolean val) {
		__select_flags[12] = val;
	}

	public void setEndTimeExpression(String val) {
		__dataExpressions[12] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[13] = val;
	}

	public void setRemarkExpression(String val) {
		__dataExpressions[13] = val;
	}

	public void setConditionDeleteFlag(String op, java.lang.Integer val) {
		setConditionDeleteFlag(op, val, CONDITION_AND);
	}

	public void setConditionDeleteFlag(String op, java.lang.Integer val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectDeleteFlag(boolean val) {
		__select_flags[14] = val;
	}

	public void setDeleteFlagExpression(String val) {
		__dataExpressions[14] = val;
	}


}

