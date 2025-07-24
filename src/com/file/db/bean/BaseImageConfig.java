package com.file.db.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseImageConfig extends GenericBase implements BaseFactory<BaseImageConfig>, Comparable<BaseImageConfig> 
{


	public static BaseImageConfig newInstance(){
		return new BaseImageConfig();
	}

	@Override
	public BaseImageConfig make(){
		BaseImageConfig b = new BaseImageConfig();
		return b;
	}

	public final static java.lang.String CS_IMAGE_CONFIG_ID = "image_config_id" ;
	public final static java.lang.String CS_APPLICATION_ID = "application_id" ;
	public final static java.lang.String CS_ICON_IMG_WIDTH = "icon_img_width" ;
	public final static java.lang.String CS_ICON_IMG_HEIGHT = "icon_img_height" ;
	public final static java.lang.String CS_THUMBNAIL_IMG_WIDTH = "thumbnail_img_width" ;
	public final static java.lang.String CS_THUMBNAIL_IMG_HEIGHT = "thumbnail_img_height" ;
	public final static java.lang.String CS_MATRIX_IMG_WIDTH = "matrix_img_width" ;
	public final static java.lang.String CS_MATRIX_IMG_HEIGHT = "matrix_img_height" ;
	public final static java.lang.String CS_STANDARD_IMG_WIDTH = "standard_img_width" ;
	public final static java.lang.String CS_STANDARD_IMG_HEIGHT = "standard_img_height" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码, 3Sohovita设计师平台,图标宽（单位像素）,图标高（单位像素）,缩略图宽（单位像素）,缩略图高（单位像素）,矩阵图宽（单位像素）,矩阵图高（单位像素）,标准图宽（单位像素）,标准图高（单位像素）";

	public java.lang.Integer getImageConfigId() {
		return this.__image_config_id;
	}

	public void setImageConfigId( java.lang.Integer value ) {
		this.__image_config_id = value;
	}

	public java.lang.Integer getApplicationId() {
		return this.__application_id;
	}

	public void setApplicationId( java.lang.Integer value ) {
		this.__application_id = value;
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

	public void cloneCopy(BaseImageConfig __bean){
		__bean.setImageConfigId(getImageConfigId());
		__bean.setApplicationId(getApplicationId());
		__bean.setIconImgWidth(getIconImgWidth());
		__bean.setIconImgHeight(getIconImgHeight());
		__bean.setThumbnailImgWidth(getThumbnailImgWidth());
		__bean.setThumbnailImgHeight(getThumbnailImgHeight());
		__bean.setMatrixImgWidth(getMatrixImgWidth());
		__bean.setMatrixImgHeight(getMatrixImgHeight());
		__bean.setStandardImgWidth(getStandardImgWidth());
		__bean.setStandardImgHeight(getStandardImgHeight());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getImageConfigId() == null ? "" : getImageConfigId());
		sb.append(",");
		sb.append(getApplicationId() == null ? "" : getApplicationId());
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
		return sb.toString();
	}

	@Override
	public int compareTo(BaseImageConfig o) {
		return __image_config_id == null ? -1 : __image_config_id.compareTo(o.getImageConfigId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__image_config_id);
		hash = 97 * hash + Objects.hashCode(this.__application_id);
		hash = 97 * hash + Objects.hashCode(this.__icon_img_width);
		hash = 97 * hash + Objects.hashCode(this.__icon_img_height);
		hash = 97 * hash + Objects.hashCode(this.__thumbnail_img_width);
		hash = 97 * hash + Objects.hashCode(this.__thumbnail_img_height);
		hash = 97 * hash + Objects.hashCode(this.__matrix_img_width);
		hash = 97 * hash + Objects.hashCode(this.__matrix_img_height);
		hash = 97 * hash + Objects.hashCode(this.__standard_img_width);
		hash = 97 * hash + Objects.hashCode(this.__standard_img_height);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseImageConfig o = (BaseImageConfig)obj;
		if(!Objects.equals(this.__image_config_id, o.getImageConfigId())) return false;
		if(!Objects.equals(this.__application_id, o.getApplicationId())) return false;
		if(!Objects.equals(this.__icon_img_width, o.getIconImgWidth())) return false;
		if(!Objects.equals(this.__icon_img_height, o.getIconImgHeight())) return false;
		if(!Objects.equals(this.__thumbnail_img_width, o.getThumbnailImgWidth())) return false;
		if(!Objects.equals(this.__thumbnail_img_height, o.getThumbnailImgHeight())) return false;
		if(!Objects.equals(this.__matrix_img_width, o.getMatrixImgWidth())) return false;
		if(!Objects.equals(this.__matrix_img_height, o.getMatrixImgHeight())) return false;
		if(!Objects.equals(this.__standard_img_width, o.getStandardImgWidth())) return false;
		if(!Objects.equals(this.__standard_img_height, o.getStandardImgHeight())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getImageConfigId() != null) sb.append(__wrapNumber(count++, "imageConfigId", getImageConfigId()));
		if(getApplicationId() != null) sb.append(__wrapNumber(count++, "applicationId", getApplicationId()));
		if(getIconImgWidth() != null) sb.append(__wrapNumber(count++, "iconImgWidth", getIconImgWidth()));
		if(getIconImgHeight() != null) sb.append(__wrapNumber(count++, "iconImgHeight", getIconImgHeight()));
		if(getThumbnailImgWidth() != null) sb.append(__wrapNumber(count++, "thumbnailImgWidth", getThumbnailImgWidth()));
		if(getThumbnailImgHeight() != null) sb.append(__wrapNumber(count++, "thumbnailImgHeight", getThumbnailImgHeight()));
		if(getMatrixImgWidth() != null) sb.append(__wrapNumber(count++, "matrixImgWidth", getMatrixImgWidth()));
		if(getMatrixImgHeight() != null) sb.append(__wrapNumber(count++, "matrixImgHeight", getMatrixImgHeight()));
		if(getStandardImgWidth() != null) sb.append(__wrapNumber(count++, "standardImgWidth", getStandardImgWidth()));
		if(getStandardImgHeight() != null) sb.append(__wrapNumber(count++, "standardImgHeight", getStandardImgHeight()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("imageConfigId")) != null) setImageConfigId(__getInt(val)); 
		if((val = values.get("applicationId")) != null) setApplicationId(__getInt(val)); 
		if((val = values.get("iconImgWidth")) != null) setIconImgWidth(__getInt(val)); 
		if((val = values.get("iconImgHeight")) != null) setIconImgHeight(__getInt(val)); 
		if((val = values.get("thumbnailImgWidth")) != null) setThumbnailImgWidth(__getInt(val)); 
		if((val = values.get("thumbnailImgHeight")) != null) setThumbnailImgHeight(__getInt(val)); 
		if((val = values.get("matrixImgWidth")) != null) setMatrixImgWidth(__getInt(val)); 
		if((val = values.get("matrixImgHeight")) != null) setMatrixImgHeight(__getInt(val)); 
		if((val = values.get("standardImgWidth")) != null) setStandardImgWidth(__getInt(val)); 
		if((val = values.get("standardImgHeight")) != null) setStandardImgHeight(__getInt(val)); 
	}

	protected java.lang.Integer  __image_config_id ;
	protected java.lang.Integer  __application_id ;
	protected java.lang.Integer  __icon_img_width ;
	protected java.lang.Integer  __icon_img_height ;
	protected java.lang.Integer  __thumbnail_img_width ;
	protected java.lang.Integer  __thumbnail_img_height ;
	protected java.lang.Integer  __matrix_img_width ;
	protected java.lang.Integer  __matrix_img_height ;
	protected java.lang.Integer  __standard_img_width ;
	protected java.lang.Integer  __standard_img_height ;
}
