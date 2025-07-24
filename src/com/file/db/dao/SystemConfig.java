package com.file.db.dao;

import com.file.db.bean.BaseSystemConfig;
import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class SystemConfig extends AbstractTable<BaseSystemConfig>
{

	public SystemConfig() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 18;

		initTables();

		__tableName            = "system_config";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseSystemConfig.CS_SYSTEM_CONFIG_ID;
		__column_names[1] = BaseSystemConfig.CS_IMAGE_PATH;
		__column_names[2] = BaseSystemConfig.CS_CONFIG_TYPE;
		__column_names[3] = BaseSystemConfig.CS_USER_ID;
		__column_names[4] = BaseSystemConfig.CS_ACCOUNT;
		__column_names[5] = BaseSystemConfig.CS_CORP_ID;
		__column_names[6] = BaseSystemConfig.CS_AGENT_ID;
		__column_names[7] = BaseSystemConfig.CS_CORP_SECRET;
		__column_names[8] = BaseSystemConfig.CS_TXL_CORP_SECRET;
		__column_names[9] = BaseSystemConfig.CS_CHECK_USER_ID;
		__column_names[10] = BaseSystemConfig.CS_FROM_TITLE;
		__column_names[11] = BaseSystemConfig.CS_HOST_NAME;
		__column_names[12] = BaseSystemConfig.CS_FROM_EMAIL;
		__column_names[13] = BaseSystemConfig.CS_PASSWORD;
		__column_names[14] = BaseSystemConfig.CS_IS_CROSS_MONTH;
		__column_names[15] = BaseSystemConfig.CS_IS_BEFORE;
		__column_names[16] = BaseSystemConfig.CS_COUNT_DAY;
		__column_names[17] = BaseSystemConfig.CS_CONTENT_TITLE;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseSystemConfig b) {
		clear();
		setSystemConfigIdClear(b.getSystemConfigId());
	}

	public boolean isPrimaryKeyNull() {
		return getSystemConfigId() == null;
	}

	@Override
	public BaseSystemConfig generateBase(){
		BaseSystemConfig b = new BaseSystemConfig();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseSystemConfig b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setSystemConfigId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setImagePath(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setConfigType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setUserId(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setAccount(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCorpId(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setAgentId(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCorpSecret(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setTxlCorpSecret(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCheckUserId(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setFromTitle(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setHostName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setFromEmail(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setPassword(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setIsCrossMonth(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setIsBefore(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setCountDay(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setContentTitle(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseSystemConfig b, Object[] buff){
		int count = 0;
		buff[count++] = b.getSystemConfigId();
		buff[count++] = b.getImagePath();
		buff[count++] = b.getConfigType();
		buff[count++] = b.getUserId();
		buff[count++] = b.getAccount();
		buff[count++] = b.getCorpId();
		buff[count++] = b.getAgentId();
		buff[count++] = b.getCorpSecret();
		buff[count++] = b.getTxlCorpSecret();
		buff[count++] = b.getCheckUserId();
		buff[count++] = b.getFromTitle();
		buff[count++] = b.getHostName();
		buff[count++] = b.getFromEmail();
		buff[count++] = b.getPassword();
		buff[count++] = b.getIsCrossMonth();
		buff[count++] = b.getIsBefore();
		buff[count++] = b.getCountDay();
		buff[count++] = b.getContentTitle();
	}

	@Override
	public void setDataFromBase(BaseSystemConfig b){
		if(b.getSystemConfigId() != null) setSystemConfigIdClear(b.getSystemConfigId());
		if(b.getImagePath() != null) setImagePath(b.getImagePath());
		if(b.getConfigType() != null) setConfigType(b.getConfigType());
		if(b.getUserId() != null) setUserId(b.getUserId());
		if(b.getAccount() != null) setAccount(b.getAccount());
		if(b.getCorpId() != null) setCorpId(b.getCorpId());
		if(b.getAgentId() != null) setAgentId(b.getAgentId());
		if(b.getCorpSecret() != null) setCorpSecret(b.getCorpSecret());
		if(b.getTxlCorpSecret() != null) setTxlCorpSecret(b.getTxlCorpSecret());
		if(b.getCheckUserId() != null) setCheckUserId(b.getCheckUserId());
		if(b.getFromTitle() != null) setFromTitle(b.getFromTitle());
		if(b.getHostName() != null) setHostName(b.getHostName());
		if(b.getFromEmail() != null) setFromEmail(b.getFromEmail());
		if(b.getPassword() != null) setPassword(b.getPassword());
		if(b.getIsCrossMonth() != null) setIsCrossMonth(b.getIsCrossMonth());
		if(b.getIsBefore() != null) setIsBefore(b.getIsBefore());
		if(b.getCountDay() != null) setCountDay(b.getCountDay());
		if(b.getContentTitle() != null) setContentTitle(b.getContentTitle());
	}

	@Override
	public BaseSystemConfig generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseSystemConfig b = new BaseSystemConfig();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseSystemConfig __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSystemConfigId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setImagePath(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setConfigType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUserId(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAccount(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCorpId(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAgentId(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCorpSecret(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTxlCorpSecret(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCheckUserId(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFromTitle(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setHostName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFromEmail(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPassword(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsCrossMonth(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsBefore(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCountDay(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContentTitle(GenericBase.__getString(val));
	}

	public void setSystemConfigId(Integer val) {
		setCurrentData(0, val);
	}

	public Integer getSystemConfigId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setSystemConfigIdClear(Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setImagePath(String val) {
		setCurrentData(1, val);
	}

	public String getImagePath() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setConfigType(Integer val) {
		setCurrentData(2, val);
	}

	public Integer getConfigType() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setUserId(String val) {
		setCurrentData(3, val);
	}

	public String getUserId() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setAccount(String val) {
		setCurrentData(4, val);
	}

	public String getAccount() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setCorpId(String val) {
		setCurrentData(5, val);
	}

	public String getCorpId() {
		return GenericBase.__getString(__current_data[5]);
	}

	public void setAgentId(String val) {
		setCurrentData(6, val);
	}

	public String getAgentId() {
		return GenericBase.__getString(__current_data[6]);
	}

	public void setCorpSecret(String val) {
		setCurrentData(7, val);
	}

	public String getCorpSecret() {
		return GenericBase.__getString(__current_data[7]);
	}

	public void setTxlCorpSecret(String val) {
		setCurrentData(8, val);
	}

	public String getTxlCorpSecret() {
		return GenericBase.__getString(__current_data[8]);
	}

	public void setCheckUserId(String val) {
		setCurrentData(9, val);
	}

	public String getCheckUserId() {
		return GenericBase.__getString(__current_data[9]);
	}

	public void setFromTitle(String val) {
		setCurrentData(10, val);
	}

	public String getFromTitle() {
		return GenericBase.__getString(__current_data[10]);
	}

	public void setHostName(String val) {
		setCurrentData(11, val);
	}

	public String getHostName() {
		return GenericBase.__getString(__current_data[11]);
	}

	public void setFromEmail(String val) {
		setCurrentData(12, val);
	}

	public String getFromEmail() {
		return GenericBase.__getString(__current_data[12]);
	}

	public void setPassword(String val) {
		setCurrentData(13, val);
	}

	public String getPassword() {
		return GenericBase.__getString(__current_data[13]);
	}

	public void setIsCrossMonth(Boolean val) {
		setCurrentData(14, val);
	}

	public Boolean getIsCrossMonth() {
		return GenericBase.__getBoolean(__current_data[14]);
	}

	public void setIsBefore(Boolean val) {
		setCurrentData(15, val);
	}

	public Boolean getIsBefore() {
		return GenericBase.__getBoolean(__current_data[15]);
	}

	public void setCountDay(Integer val) {
		setCurrentData(16, val);
	}

	public Integer getCountDay() {
		return GenericBase.__getInt(__current_data[16]);
	}

	public void setContentTitle(String val) {
		setCurrentData(17, val);
	}

	public String getContentTitle() {
		return GenericBase.__getString(__current_data[17]);
	}

	public void setConditionSystemConfigId(String op, Integer val) {
		setConditionSystemConfigId(op, val, CONDITION_AND);
	}

	public void setConditionSystemConfigId(String op, Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectSystemConfigId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionImagePath(String op, String val) {
		setConditionImagePath(op, val, CONDITION_AND);
	}

	public void setConditionImagePath(String op, String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectImagePath(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionConfigType(String op, Integer val) {
		setConditionConfigType(op, val, CONDITION_AND);
	}

	public void setConditionConfigType(String op, Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectConfigType(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionUserId(String op, String val) {
		setConditionUserId(op, val, CONDITION_AND);
	}

	public void setConditionUserId(String op, String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectUserId(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionAccount(String op, String val) {
		setConditionAccount(op, val, CONDITION_AND);
	}

	public void setConditionAccount(String op, String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectAccount(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionCorpId(String op, String val) {
		setConditionCorpId(op, val, CONDITION_AND);
	}

	public void setConditionCorpId(String op, String val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectCorpId(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionAgentId(String op, String val) {
		setConditionAgentId(op, val, CONDITION_AND);
	}

	public void setConditionAgentId(String op, String val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectAgentId(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionCorpSecret(String op, String val) {
		setConditionCorpSecret(op, val, CONDITION_AND);
	}

	public void setConditionCorpSecret(String op, String val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectCorpSecret(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionTxlCorpSecret(String op, String val) {
		setConditionTxlCorpSecret(op, val, CONDITION_AND);
	}

	public void setConditionTxlCorpSecret(String op, String val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectTxlCorpSecret(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionCheckUserId(String op, String val) {
		setConditionCheckUserId(op, val, CONDITION_AND);
	}

	public void setConditionCheckUserId(String op, String val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectCheckUserId(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionFromTitle(String op, String val) {
		setConditionFromTitle(op, val, CONDITION_AND);
	}

	public void setConditionFromTitle(String op, String val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectFromTitle(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionHostName(String op, String val) {
		setConditionHostName(op, val, CONDITION_AND);
	}

	public void setConditionHostName(String op, String val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectHostName(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionFromEmail(String op, String val) {
		setConditionFromEmail(op, val, CONDITION_AND);
	}

	public void setConditionFromEmail(String op, String val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectFromEmail(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionPassword(String op, String val) {
		setConditionPassword(op, val, CONDITION_AND);
	}

	public void setConditionPassword(String op, String val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectPassword(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionIsCrossMonth(String op, Boolean val) {
		setConditionIsCrossMonth(op, val, CONDITION_AND);
	}

	public void setConditionIsCrossMonth(String op, Boolean val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectIsCrossMonth(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionIsBefore(String op, Boolean val) {
		setConditionIsBefore(op, val, CONDITION_AND);
	}

	public void setConditionIsBefore(String op, Boolean val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectIsBefore(boolean val) {
		__select_flags[15] = val;
	}

	public void setConditionCountDay(String op, Integer val) {
		setConditionCountDay(op, val, CONDITION_AND);
	}

	public void setConditionCountDay(String op, Integer val, String relation) {
		addCondition(16, op, relation, val);
	}

	public void setSelectCountDay(boolean val) {
		__select_flags[16] = val;
	}

	public void setConditionContentTitle(String op, String val) {
		setConditionContentTitle(op, val, CONDITION_AND);
	}

	public void setConditionContentTitle(String op, String val, String relation) {
		addCondition(17, op, relation, val);
	}

	public void setSelectContentTitle(boolean val) {
		__select_flags[17] = val;
	}


}

