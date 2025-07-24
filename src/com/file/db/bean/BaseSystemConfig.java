package com.file.db.bean;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

import java.util.Map;
import java.util.Objects;

public class BaseSystemConfig extends GenericBase implements BaseFactory<BaseSystemConfig>, Comparable<BaseSystemConfig> 
{


	public static BaseSystemConfig newInstance(){
		return new BaseSystemConfig();
	}

	@Override
	public BaseSystemConfig make(){
		BaseSystemConfig b = new BaseSystemConfig();
		return b;
	}

	public final static String CS_SYSTEM_CONFIG_ID = "system_config_id" ;
	public final static String CS_IMAGE_PATH = "image_path" ;
	public final static String CS_CONFIG_TYPE = "config_type" ;
	public final static String CS_USER_ID = "user_id" ;
	public final static String CS_ACCOUNT = "account" ;
	public final static String CS_CORP_ID = "corp_id" ;
	public final static String CS_AGENT_ID = "agent_id" ;
	public final static String CS_CORP_SECRET = "corp_secret" ;
	public final static String CS_TXL_CORP_SECRET = "txl_corp_secret" ;
	public final static String CS_CHECK_USER_ID = "check_user_id" ;
	public final static String CS_FROM_TITLE = "from_title" ;
	public final static String CS_HOST_NAME = "host_name" ;
	public final static String CS_FROM_EMAIL = "from_email" ;
	public final static String CS_PASSWORD = "password" ;
	public final static String CS_IS_CROSS_MONTH = "is_cross_month" ;
	public final static String CS_IS_BEFORE = "is_before" ;
	public final static String CS_COUNT_DAY = "count_day" ;
	public final static String CS_CONTENT_TITLE = "content_title" ;

	public final static String ALL_CAPTIONS = ",,5手机短息配置信息),账户Id,账号,企业编码,应用编码编码,应用凭证密钥,通讯录应用凭证密钥,检测ACCESS_TOKEN是否有效的账户,发送账户标题名,发送方邮件服务器地址,发件方账户,密码,是否跨月考勤,是否是前置计算,开始计算天,内容标题";

	public Integer getSystemConfigId() {
		return this.__system_config_id;
	}

	public void setSystemConfigId( Integer value ) {
		this.__system_config_id = value;
	}

	public String getImagePath() {
		return this.__image_path;
	}

	public void setImagePath( String value ) {
		this.__image_path = value;
	}

	public Integer getConfigType() {
		return this.__config_type;
	}

	public void setConfigType( Integer value ) {
		this.__config_type = value;
	}

	public String getUserId() {
		return this.__user_id;
	}

	public void setUserId( String value ) {
		this.__user_id = value;
	}

	public String getAccount() {
		return this.__account;
	}

	public void setAccount( String value ) {
		this.__account = value;
	}

	public String getCorpId() {
		return this.__corp_id;
	}

	public void setCorpId( String value ) {
		this.__corp_id = value;
	}

	public String getAgentId() {
		return this.__agent_id;
	}

	public void setAgentId( String value ) {
		this.__agent_id = value;
	}

	public String getCorpSecret() {
		return this.__corp_secret;
	}

	public void setCorpSecret( String value ) {
		this.__corp_secret = value;
	}

	public String getTxlCorpSecret() {
		return this.__txl_corp_secret;
	}

	public void setTxlCorpSecret( String value ) {
		this.__txl_corp_secret = value;
	}

	public String getCheckUserId() {
		return this.__check_user_id;
	}

	public void setCheckUserId( String value ) {
		this.__check_user_id = value;
	}

	public String getFromTitle() {
		return this.__from_title;
	}

	public void setFromTitle( String value ) {
		this.__from_title = value;
	}

	public String getHostName() {
		return this.__host_name;
	}

	public void setHostName( String value ) {
		this.__host_name = value;
	}

	public String getFromEmail() {
		return this.__from_email;
	}

	public void setFromEmail( String value ) {
		this.__from_email = value;
	}

	public String getPassword() {
		return this.__password;
	}

	public void setPassword( String value ) {
		this.__password = value;
	}

	public Boolean getIsCrossMonth() {
		return this.__is_cross_month;
	}

	public void setIsCrossMonth( Boolean value ) {
		this.__is_cross_month = value;
	}

	public Boolean getIsBefore() {
		return this.__is_before;
	}

	public void setIsBefore( Boolean value ) {
		this.__is_before = value;
	}

	public Integer getCountDay() {
		return this.__count_day;
	}

	public void setCountDay( Integer value ) {
		this.__count_day = value;
	}

	public String getContentTitle() {
		return this.__content_title;
	}

	public void setContentTitle( String value ) {
		this.__content_title = value;
	}

	public void cloneCopy(BaseSystemConfig __bean){
		__bean.setSystemConfigId(getSystemConfigId());
		__bean.setImagePath(getImagePath());
		__bean.setConfigType(getConfigType());
		__bean.setUserId(getUserId());
		__bean.setAccount(getAccount());
		__bean.setCorpId(getCorpId());
		__bean.setAgentId(getAgentId());
		__bean.setCorpSecret(getCorpSecret());
		__bean.setTxlCorpSecret(getTxlCorpSecret());
		__bean.setCheckUserId(getCheckUserId());
		__bean.setFromTitle(getFromTitle());
		__bean.setHostName(getHostName());
		__bean.setFromEmail(getFromEmail());
		__bean.setPassword(getPassword());
		__bean.setIsCrossMonth(getIsCrossMonth());
		__bean.setIsBefore(getIsBefore());
		__bean.setCountDay(getCountDay());
		__bean.setContentTitle(getContentTitle());
	}

	public String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getSystemConfigId() == null ? "" : getSystemConfigId());
		sb.append(",");
		sb.append(getImagePath() == null ? "" : getImagePath());
		sb.append(",");
		sb.append(getConfigType() == null ? "" : getConfigType());
		sb.append(",");
		sb.append(getUserId() == null ? "" : getUserId());
		sb.append(",");
		sb.append(getAccount() == null ? "" : getAccount());
		sb.append(",");
		sb.append(getCorpId() == null ? "" : getCorpId());
		sb.append(",");
		sb.append(getAgentId() == null ? "" : getAgentId());
		sb.append(",");
		sb.append(getCorpSecret() == null ? "" : getCorpSecret());
		sb.append(",");
		sb.append(getTxlCorpSecret() == null ? "" : getTxlCorpSecret());
		sb.append(",");
		sb.append(getCheckUserId() == null ? "" : getCheckUserId());
		sb.append(",");
		sb.append(getFromTitle() == null ? "" : getFromTitle());
		sb.append(",");
		sb.append(getHostName() == null ? "" : getHostName());
		sb.append(",");
		sb.append(getFromEmail() == null ? "" : getFromEmail());
		sb.append(",");
		sb.append(getPassword() == null ? "" : getPassword());
		sb.append(",");
		sb.append(getIsCrossMonth() == null ? "" : getIsCrossMonth());
		sb.append(",");
		sb.append(getIsBefore() == null ? "" : getIsBefore());
		sb.append(",");
		sb.append(getCountDay() == null ? "" : getCountDay());
		sb.append(",");
		sb.append(getContentTitle() == null ? "" : getContentTitle());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSystemConfig o) {
		return __system_config_id == null ? -1 : __system_config_id.compareTo(o.getSystemConfigId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__system_config_id);
		hash = 97 * hash + Objects.hashCode(this.__image_path);
		hash = 97 * hash + Objects.hashCode(this.__config_type);
		hash = 97 * hash + Objects.hashCode(this.__user_id);
		hash = 97 * hash + Objects.hashCode(this.__account);
		hash = 97 * hash + Objects.hashCode(this.__corp_id);
		hash = 97 * hash + Objects.hashCode(this.__agent_id);
		hash = 97 * hash + Objects.hashCode(this.__corp_secret);
		hash = 97 * hash + Objects.hashCode(this.__txl_corp_secret);
		hash = 97 * hash + Objects.hashCode(this.__check_user_id);
		hash = 97 * hash + Objects.hashCode(this.__from_title);
		hash = 97 * hash + Objects.hashCode(this.__host_name);
		hash = 97 * hash + Objects.hashCode(this.__from_email);
		hash = 97 * hash + Objects.hashCode(this.__password);
		hash = 97 * hash + Objects.hashCode(this.__is_cross_month);
		hash = 97 * hash + Objects.hashCode(this.__is_before);
		hash = 97 * hash + Objects.hashCode(this.__count_day);
		hash = 97 * hash + Objects.hashCode(this.__content_title);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSystemConfig o = (BaseSystemConfig)obj;
		if(!Objects.equals(this.__system_config_id, o.getSystemConfigId())) return false;
		if(!Objects.equals(this.__image_path, o.getImagePath())) return false;
		if(!Objects.equals(this.__config_type, o.getConfigType())) return false;
		if(!Objects.equals(this.__user_id, o.getUserId())) return false;
		if(!Objects.equals(this.__account, o.getAccount())) return false;
		if(!Objects.equals(this.__corp_id, o.getCorpId())) return false;
		if(!Objects.equals(this.__agent_id, o.getAgentId())) return false;
		if(!Objects.equals(this.__corp_secret, o.getCorpSecret())) return false;
		if(!Objects.equals(this.__txl_corp_secret, o.getTxlCorpSecret())) return false;
		if(!Objects.equals(this.__check_user_id, o.getCheckUserId())) return false;
		if(!Objects.equals(this.__from_title, o.getFromTitle())) return false;
		if(!Objects.equals(this.__host_name, o.getHostName())) return false;
		if(!Objects.equals(this.__from_email, o.getFromEmail())) return false;
		if(!Objects.equals(this.__password, o.getPassword())) return false;
		if(!Objects.equals(this.__is_cross_month, o.getIsCrossMonth())) return false;
		if(!Objects.equals(this.__is_before, o.getIsBefore())) return false;
		if(!Objects.equals(this.__count_day, o.getCountDay())) return false;
		if(!Objects.equals(this.__content_title, o.getContentTitle())) return false;
		return true;
	}

	@Override
	public String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getSystemConfigId() != null) sb.append(__wrapNumber(count++, "systemConfigId", getSystemConfigId()));
		if(getImagePath() != null) sb.append(__wrapString(count++, "imagePath", getImagePath()));
		if(getConfigType() != null) sb.append(__wrapNumber(count++, "configType", getConfigType()));
		if(getUserId() != null) sb.append(__wrapString(count++, "userId", getUserId()));
		if(getAccount() != null) sb.append(__wrapString(count++, "account", getAccount()));
		if(getCorpId() != null) sb.append(__wrapString(count++, "corpId", getCorpId()));
		if(getAgentId() != null) sb.append(__wrapString(count++, "agentId", getAgentId()));
		if(getCorpSecret() != null) sb.append(__wrapString(count++, "corpSecret", getCorpSecret()));
		if(getTxlCorpSecret() != null) sb.append(__wrapString(count++, "txlCorpSecret", getTxlCorpSecret()));
		if(getCheckUserId() != null) sb.append(__wrapString(count++, "checkUserId", getCheckUserId()));
		if(getFromTitle() != null) sb.append(__wrapString(count++, "fromTitle", getFromTitle()));
		if(getHostName() != null) sb.append(__wrapString(count++, "hostName", getHostName()));
		if(getFromEmail() != null) sb.append(__wrapString(count++, "fromEmail", getFromEmail()));
		if(getPassword() != null) sb.append(__wrapString(count++, "password", getPassword()));
		if(getIsCrossMonth() != null) sb.append(__wrapBoolean(count++, "isCrossMonth", getIsCrossMonth()));
		if(getIsBefore() != null) sb.append(__wrapBoolean(count++, "isBefore", getIsBefore()));
		if(getCountDay() != null) sb.append(__wrapNumber(count++, "countDay", getCountDay()));
		if(getContentTitle() != null) sb.append(__wrapString(count++, "contentTitle", getContentTitle()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("systemConfigId")) != null) setSystemConfigId(__getInt(val)); 
		if((val = values.get("imagePath")) != null) setImagePath(__getString(val));
		if((val = values.get("configType")) != null) setConfigType(__getInt(val)); 
		if((val = values.get("userId")) != null) setUserId(__getString(val));
		if((val = values.get("account")) != null) setAccount(__getString(val));
		if((val = values.get("corpId")) != null) setCorpId(__getString(val));
		if((val = values.get("agentId")) != null) setAgentId(__getString(val));
		if((val = values.get("corpSecret")) != null) setCorpSecret(__getString(val));
		if((val = values.get("txlCorpSecret")) != null) setTxlCorpSecret(__getString(val));
		if((val = values.get("checkUserId")) != null) setCheckUserId(__getString(val));
		if((val = values.get("fromTitle")) != null) setFromTitle(__getString(val));
		if((val = values.get("hostName")) != null) setHostName(__getString(val));
		if((val = values.get("fromEmail")) != null) setFromEmail(__getString(val));
		if((val = values.get("password")) != null) setPassword(__getString(val));
		if((val = values.get("isCrossMonth")) != null) setIsCrossMonth(__getBoolean(val));
		if((val = values.get("isBefore")) != null) setIsBefore(__getBoolean(val));
		if((val = values.get("countDay")) != null) setCountDay(__getInt(val)); 
		if((val = values.get("contentTitle")) != null) setContentTitle(__getString(val));
	}

	protected Integer  __system_config_id ;
	protected String  __image_path ;
	protected Integer  __config_type ;
	protected String  __user_id ;
	protected String  __account ;
	protected String  __corp_id ;
	protected String  __agent_id ;
	protected String  __corp_secret ;
	protected String  __txl_corp_secret ;
	protected String  __check_user_id ;
	protected String  __from_title ;
	protected String  __host_name ;
	protected String  __from_email ;
	protected String  __password ;
	protected Boolean  __is_cross_month ;
	protected Boolean  __is_before ;
	protected Integer  __count_day ;
	protected String  __content_title ;
}
