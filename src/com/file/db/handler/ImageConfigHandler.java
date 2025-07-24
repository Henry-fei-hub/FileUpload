package com.file.db.handler;

import org.apache.log4j.Logger;
import com.file.db.bean.BaseImageConfig;
import java.util.List;
import com.file.db.dao.ImageConfig;
import delicacy.connection.ThreadConnection;
import delicacy.common.GenericDao;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import java.io.StringReader;
import java.util.Map;
import delicacy.common.PaginationParameter;
import delicacy.common.BaseCollection;

public class ImageConfigHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ImageConfigHandler.class);

	public static BaseImageConfig getImageConfigById( 
		java.lang.Integer image_config_id
	) throws Exception
	{
		ImageConfig dao = new ImageConfig();
		dao.setImageConfigId(image_config_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isImageConfigExists( com.file.db.bean.BaseImageConfig bean, String additional ) throws Exception {

		ImageConfig dao = new ImageConfig();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countImageConfig( com.file.db.bean.BaseImageConfig bean, String additional ) throws Exception {

		ImageConfig dao = new ImageConfig();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseImageConfig> queryImageConfig( com.file.db.bean.BaseImageConfig bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ImageConfig dao = new ImageConfig();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseImageConfig> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseImageConfig> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseImageConfig addToImageConfig ( BaseImageConfig imageconfig )  throws Exception {
		return addToImageConfig ( imageconfig , false);
	}

	public static BaseImageConfig addToImageConfig ( BaseImageConfig imageconfig, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ImageConfig dao = new ImageConfig();
		dao.setDataFromBase(imageconfig);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseImageConfig addUpdateImageConfig ( BaseImageConfig imageconfig ) throws Exception {
		return addUpdateImageConfig ( imageconfig , false);
	}

	public static BaseImageConfig addUpdateImageConfig ( BaseImageConfig imageconfig, boolean singleTransaction  ) throws Exception {
		if(imageconfig.getImageConfigId() == null) return addToImageConfig(imageconfig);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ImageConfig dao = new ImageConfig();
		dao.setDataFromBase(imageconfig);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(imageconfig); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteImageConfig ( BaseImageConfig bean ) throws Exception {
		ImageConfig dao = new ImageConfig();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseImageConfig updateImageConfig ( BaseImageConfig imageconfig ) throws Exception {
		ImageConfig dao = new ImageConfig();
		dao.setImageConfigId( imageconfig.getImageConfigId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(imageconfig);
			result = dao.update();
		}
		return result == 1 ? imageconfig : null ;
	}

	public static BaseImageConfig updateImageConfigDirect( BaseImageConfig imageconfig ) throws Exception {
		ImageConfig dao = new ImageConfig();
		int result = 0;
		dao.setDataFromBase(imageconfig);
		result = dao.update();
		return result == 1 ? imageconfig : null ;
	}

	public static int setDeleteConditions(BaseImageConfig bean, ImageConfig dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getImageConfigId() != null) {
			dao.setConditionImageConfigId("=", bean.getImageConfigId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getApplicationId() != null) {
				dao.setConditionApplicationId("=", bean.getApplicationId());
				count++;
			}
			if(bean.getIconImgWidth() != null) {
				dao.setConditionIconImgWidth("=", bean.getIconImgWidth());
				count++;
			}
			if(bean.getIconImgHeight() != null) {
				dao.setConditionIconImgHeight("=", bean.getIconImgHeight());
				count++;
			}
			if(bean.getThumbnailImgWidth() != null) {
				dao.setConditionThumbnailImgWidth("=", bean.getThumbnailImgWidth());
				count++;
			}
			if(bean.getThumbnailImgHeight() != null) {
				dao.setConditionThumbnailImgHeight("=", bean.getThumbnailImgHeight());
				count++;
			}
			if(bean.getMatrixImgWidth() != null) {
				dao.setConditionMatrixImgWidth("=", bean.getMatrixImgWidth());
				count++;
			}
			if(bean.getMatrixImgHeight() != null) {
				dao.setConditionMatrixImgHeight("=", bean.getMatrixImgHeight());
				count++;
			}
			if(bean.getStandardImgWidth() != null) {
				dao.setConditionStandardImgWidth("=", bean.getStandardImgWidth());
				count++;
			}
			if(bean.getStandardImgHeight() != null) {
				dao.setConditionStandardImgHeight("=", bean.getStandardImgHeight());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseImageConfig bean, ImageConfig dao){
		int count = 0;
		if(bean.getImageConfigId() != null) {
			dao.setConditionImageConfigId("=", bean.getImageConfigId());
			count++;
		}
		if(bean.getApplicationId() != null) {
			dao.setConditionApplicationId("=", bean.getApplicationId());
			count++;
		}
		if(bean.getIconImgWidth() != null) {
			dao.setConditionIconImgWidth("=", bean.getIconImgWidth());
			count++;
		}
		if(bean.getIconImgHeight() != null) {
			dao.setConditionIconImgHeight("=", bean.getIconImgHeight());
			count++;
		}
		if(bean.getThumbnailImgWidth() != null) {
			dao.setConditionThumbnailImgWidth("=", bean.getThumbnailImgWidth());
			count++;
		}
		if(bean.getThumbnailImgHeight() != null) {
			dao.setConditionThumbnailImgHeight("=", bean.getThumbnailImgHeight());
			count++;
		}
		if(bean.getMatrixImgWidth() != null) {
			dao.setConditionMatrixImgWidth("=", bean.getMatrixImgWidth());
			count++;
		}
		if(bean.getMatrixImgHeight() != null) {
			dao.setConditionMatrixImgHeight("=", bean.getMatrixImgHeight());
			count++;
		}
		if(bean.getStandardImgWidth() != null) {
			dao.setConditionStandardImgWidth("=", bean.getStandardImgWidth());
			count++;
		}
		if(bean.getStandardImgHeight() != null) {
			dao.setConditionStandardImgHeight("=", bean.getStandardImgHeight());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseImageConfig bean = new BaseImageConfig();
		bean.setDataFromJSON(json);
		ImageConfig dao = new ImageConfig();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseImageConfig> rlist = new BaseCollection<>();
		BaseImageConfig bean = new BaseImageConfig();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ImageConfig dao = new ImageConfig();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseImageConfig> result = dao.conditionalLoad(addtion);
		rlist.setCollections(result);
		rlist.setTotalPages(dao.getTotalPages());
		rlist.setCurrentPage(dao.getCurrentPage());
		rlist.setPageLines(dao.getPageLines());
		rlist.setTotalLines(dao.getTotalLines());
		rlist.setRecordNumber(result.size());
		return rlist.toJSON(null);
	}

	@Override
	public String save(String json) throws Exception{
		BaseImageConfig bean = new BaseImageConfig();
		bean.setDataFromJSON(json);
		ImageConfig dao = new ImageConfig();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseImageConfig bean = new BaseImageConfig();
		bean.setDataFromJSON(json);
		ImageConfig dao = new ImageConfig();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseImageConfig bean = new BaseImageConfig();
		bean.setDataFromJSON(json);
		ImageConfig dao = new ImageConfig();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseImageConfig bean = new BaseImageConfig();
		bean.setDataFromJSON(json);
		ImageConfig dao = new ImageConfig();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


