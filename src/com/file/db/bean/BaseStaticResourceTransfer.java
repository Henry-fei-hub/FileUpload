package com.file.db.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseStaticResourceTransfer extends GenericBase implements BaseFactory<BaseStaticResourceTransfer>, Comparable<BaseStaticResourceTransfer> 
{


	public static BaseStaticResourceTransfer newInstance(){
		return new BaseStaticResourceTransfer();
	}

	@Override
	public BaseStaticResourceTransfer make(){
		BaseStaticResourceTransfer b = new BaseStaticResourceTransfer();
		return b;
	}

	public final static java.lang.String CS_STATIC_RESOURCE_TRANSFER_ID = "static_resource_transfer_id" ;
	public final static java.lang.String CS_FILE_ID = "file_id" ;
	public final static java.lang.String CS_FILE_NAME = "file_name" ;
	public final static java.lang.String CS_FILE_SIZE = "file_size" ;
	public final static java.lang.String CS_FILE_EXTENSION = "file_extension" ;
	public final static java.lang.String CS_TRANSFER_KEY = "transfer_key" ;
	public final static java.lang.String CS_RELATIVE_FILE_PATH = "relative_file_path" ;
	public final static java.lang.String CS_ABSOLUTE_FILE_PATH = "absolute_file_path" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_TRANSFER_TYPE = "transfer_type" ;
	public final static java.lang.String CS_STATUS = "status" ;
	public final static java.lang.String CS_BEGIN_TIME = "begin_time" ;
	public final static java.lang.String CS_END_TIME = "end_time" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_DELETE_FLAG = "delete_flag" ;

	public final static java.lang.String ALL_CAPTIONS = "主键,文件编码,文件名称,文件大小,文件后缀,关联file_transfer_progresses表,相对路径,绝对路径,创建时间,传输类型 1下载 2上传,状态 1新建 2处理中 3处理完成 4失败 5作废,开始时间,结束时间,备注,删除标志 0未删除 1已删除";

	public java.lang.Integer getStaticResourceTransferId() {
		return this.__static_resource_transfer_id;
	}

	public void setStaticResourceTransferId( java.lang.Integer value ) {
		this.__static_resource_transfer_id = value;
	}

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

	public java.lang.Long getFileSize() {
		return this.__file_size;
	}

	public void setFileSize( java.lang.Long value ) {
		this.__file_size = value;
	}

	public java.lang.String getFileExtension() {
		return this.__file_extension;
	}

	public void setFileExtension( java.lang.String value ) {
		this.__file_extension = value;
	}

	public java.lang.String getTransferKey() {
		return this.__transfer_key;
	}

	public void setTransferKey( java.lang.String value ) {
		this.__transfer_key = value;
	}

	public java.lang.String getRelativeFilePath() {
		return this.__relative_file_path;
	}

	public void setRelativeFilePath( java.lang.String value ) {
		this.__relative_file_path = value;
	}

	public java.lang.String getAbsoluteFilePath() {
		return this.__absolute_file_path;
	}

	public void setAbsoluteFilePath( java.lang.String value ) {
		this.__absolute_file_path = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.lang.Integer getTransferType() {
		return this.__transfer_type;
	}

	public void setTransferType( java.lang.Integer value ) {
		this.__transfer_type = value;
	}

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
	}

	public java.util.Date getBeginTime() {
		return this.__begin_time;
	}

	public void setBeginTime( java.util.Date value ) {
		this.__begin_time = value;
	}

	public java.util.Date getEndTime() {
		return this.__end_time;
	}

	public void setEndTime( java.util.Date value ) {
		this.__end_time = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.Integer getDeleteFlag() {
		return this.__delete_flag;
	}

	public void setDeleteFlag( java.lang.Integer value ) {
		this.__delete_flag = value;
	}

	public void cloneCopy(BaseStaticResourceTransfer __bean){
		__bean.setStaticResourceTransferId(getStaticResourceTransferId());
		__bean.setFileId(getFileId());
		__bean.setFileName(getFileName());
		__bean.setFileSize(getFileSize());
		__bean.setFileExtension(getFileExtension());
		__bean.setTransferKey(getTransferKey());
		__bean.setRelativeFilePath(getRelativeFilePath());
		__bean.setAbsoluteFilePath(getAbsoluteFilePath());
		__bean.setCreateTime(getCreateTime());
		__bean.setTransferType(getTransferType());
		__bean.setStatus(getStatus());
		__bean.setBeginTime(getBeginTime());
		__bean.setEndTime(getEndTime());
		__bean.setRemark(getRemark());
		__bean.setDeleteFlag(getDeleteFlag());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getStaticResourceTransferId() == null ? "" : getStaticResourceTransferId());
		sb.append(",");
		sb.append(getFileId() == null ? "" : getFileId());
		sb.append(",");
		sb.append(getFileName() == null ? "" : getFileName());
		sb.append(",");
		sb.append(getFileSize() == null ? "" : getFileSize());
		sb.append(",");
		sb.append(getFileExtension() == null ? "" : getFileExtension());
		sb.append(",");
		sb.append(getTransferKey() == null ? "" : getTransferKey());
		sb.append(",");
		sb.append(getRelativeFilePath() == null ? "" : getRelativeFilePath());
		sb.append(",");
		sb.append(getAbsoluteFilePath() == null ? "" : getAbsoluteFilePath());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getTransferType() == null ? "" : getTransferType());
		sb.append(",");
		String strStatus = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_161", String.valueOf(getStatus()));
		sb.append(strStatus == null ? "" : strStatus);
		sb.append(",");
		sb.append(getBeginTime() == null ? "" : sdf.format(getBeginTime()));
		sb.append(",");
		sb.append(getEndTime() == null ? "" : sdf.format(getEndTime()));
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getDeleteFlag() == null ? "" : getDeleteFlag());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseStaticResourceTransfer o) {
		return __static_resource_transfer_id == null ? -1 : __static_resource_transfer_id.compareTo(o.getStaticResourceTransferId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__static_resource_transfer_id);
		hash = 97 * hash + Objects.hashCode(this.__file_id);
		hash = 97 * hash + Objects.hashCode(this.__file_name);
		hash = 97 * hash + Objects.hashCode(this.__file_size);
		hash = 97 * hash + Objects.hashCode(this.__file_extension);
		hash = 97 * hash + Objects.hashCode(this.__transfer_key);
		hash = 97 * hash + Objects.hashCode(this.__relative_file_path);
		hash = 97 * hash + Objects.hashCode(this.__absolute_file_path);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__transfer_type);
		hash = 97 * hash + Objects.hashCode(this.__status);
		hash = 97 * hash + Objects.hashCode(this.__begin_time);
		hash = 97 * hash + Objects.hashCode(this.__end_time);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__delete_flag);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseStaticResourceTransfer o = (BaseStaticResourceTransfer)obj;
		if(!Objects.equals(this.__static_resource_transfer_id, o.getStaticResourceTransferId())) return false;
		if(!Objects.equals(this.__file_id, o.getFileId())) return false;
		if(!Objects.equals(this.__file_name, o.getFileName())) return false;
		if(!Objects.equals(this.__file_size, o.getFileSize())) return false;
		if(!Objects.equals(this.__file_extension, o.getFileExtension())) return false;
		if(!Objects.equals(this.__transfer_key, o.getTransferKey())) return false;
		if(!Objects.equals(this.__relative_file_path, o.getRelativeFilePath())) return false;
		if(!Objects.equals(this.__absolute_file_path, o.getAbsoluteFilePath())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__transfer_type, o.getTransferType())) return false;
		if(!Objects.equals(this.__status, o.getStatus())) return false;
		if(!Objects.equals(this.__begin_time, o.getBeginTime())) return false;
		if(!Objects.equals(this.__end_time, o.getEndTime())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__delete_flag, o.getDeleteFlag())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getStaticResourceTransferId() != null) sb.append(__wrapNumber(count++, "staticResourceTransferId", getStaticResourceTransferId()));
		if(getFileId() != null) sb.append(__wrapNumber(count++, "fileId", getFileId()));
		if(getFileName() != null) sb.append(__wrapString(count++, "fileName", getFileName()));
		if(getFileSize() != null) sb.append(__wrapNumber(count++, "fileSize", getFileSize()));
		if(getFileExtension() != null) sb.append(__wrapString(count++, "fileExtension", getFileExtension()));
		if(getTransferKey() != null) sb.append(__wrapString(count++, "transferKey", getTransferKey()));
		if(getRelativeFilePath() != null) sb.append(__wrapString(count++, "relativeFilePath", getRelativeFilePath()));
		if(getAbsoluteFilePath() != null) sb.append(__wrapString(count++, "absoluteFilePath", getAbsoluteFilePath()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getTransferType() != null) sb.append(__wrapNumber(count++, "transferType", getTransferType()));
		if(getStatus() != null) sb.append(__wrapNumber(count++, "status", getStatus()));
		if(getBeginTime() != null) sb.append(__wrapDate(count++, "beginTime", getBeginTime()));
		if(getEndTime() != null) sb.append(__wrapDate(count++, "endTime", getEndTime()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getDeleteFlag() != null) sb.append(__wrapNumber(count++, "deleteFlag", getDeleteFlag()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getStaticResourceTransferId() != null) res.put("staticResourceTransferId", getStaticResourceTransferId());
		if(getFileId() != null) res.put("fileId", getFileId());
		if(getFileName() != null) res.put("fileName", getFileName());
		if(getFileSize() != null) res.put("fileSize", getFileSize());
		if(getFileExtension() != null) res.put("fileExtension", getFileExtension());
		if(getTransferKey() != null) res.put("transferKey", getTransferKey());
		if(getRelativeFilePath() != null) res.put("relativeFilePath", getRelativeFilePath());
		if(getAbsoluteFilePath() != null) res.put("absoluteFilePath", getAbsoluteFilePath());
		if(getCreateTime() != null) res.put("createTime", getCreateTime());
		if(getTransferType() != null) res.put("transferType", getTransferType());
		if(getStatus() != null) res.put("status", getStatus());
		if(getBeginTime() != null) res.put("beginTime", getBeginTime());
		if(getEndTime() != null) res.put("endTime", getEndTime());
		if(getRemark() != null) res.put("remark", getRemark());
		if(getDeleteFlag() != null) res.put("deleteFlag", getDeleteFlag());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("staticResourceTransferId")) != null) setStaticResourceTransferId(__getInt(val)); 
		if((val = values.get("fileId")) != null) setFileId(__getInt(val)); 
		if((val = values.get("fileName")) != null) setFileName(__getString(val));
		if((val = values.get("fileSize")) != null) setFileSize(__getLong(val)); 
		if((val = values.get("fileExtension")) != null) setFileExtension(__getString(val));
		if((val = values.get("transferKey")) != null) setTransferKey(__getString(val));
		if((val = values.get("relativeFilePath")) != null) setRelativeFilePath(__getString(val));
		if((val = values.get("absoluteFilePath")) != null) setAbsoluteFilePath(__getString(val));
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("transferType")) != null) setTransferType(__getInt(val)); 
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("beginTime")) != null) setBeginTime(__getDate(val)); 
		if((val = values.get("endTime")) != null) setEndTime(__getDate(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("deleteFlag")) != null) setDeleteFlag(__getInt(val)); 
	}

	protected java.lang.Integer  __static_resource_transfer_id ;
	protected java.lang.Integer  __file_id ;
	protected java.lang.String  __file_name ;
	protected java.lang.Long  __file_size ;
	protected java.lang.String  __file_extension ;
	protected java.lang.String  __transfer_key ;
	protected java.lang.String  __relative_file_path ;
	protected java.lang.String  __absolute_file_path ;
	protected java.util.Date  __create_time ;
	protected java.lang.Integer  __transfer_type ;
	protected java.lang.Integer  __status ;
	protected java.util.Date  __begin_time ;
	protected java.util.Date  __end_time ;
	protected java.lang.String  __remark ;
	protected java.lang.Integer  __delete_flag ;
}
