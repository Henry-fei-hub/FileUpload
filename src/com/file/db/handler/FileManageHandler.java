package com.file.db.handler;

import org.apache.log4j.Logger;
import com.file.db.bean.BaseFileManage;
import java.util.List;
import com.file.db.dao.FileManage;
import delicacy.connection.ThreadConnection;
import delicacy.common.GenericDao;
import java.util.Map;
import delicacy.common.PaginationParameter;
import delicacy.common.BaseCollection;

public class FileManageHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(FileManageHandler.class);

	public static BaseFileManage getFileManageById( 
		java.lang.Integer file_id
	) throws Exception
	{
		FileManage dao = new FileManage();
		dao.setFileId(file_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isFileManageExists( com.file.db.bean.BaseFileManage bean, String additional ) throws Exception {

		FileManage dao = new FileManage();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countFileManage( com.file.db.bean.BaseFileManage bean, String additional ) throws Exception {

		FileManage dao = new FileManage();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseFileManage> queryFileManage( com.file.db.bean.BaseFileManage bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		FileManage dao = new FileManage();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseFileManage> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseFileManage> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseFileManage addToFileManage ( BaseFileManage filemanage )  throws Exception {
		return addToFileManage ( filemanage , false);
	}

	public static BaseFileManage addToFileManage ( BaseFileManage filemanage, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		FileManage dao = new FileManage();
		dao.setDataFromBase(filemanage);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseFileManage addUpdateFileManage ( BaseFileManage filemanage ) throws Exception {
		return addUpdateFileManage ( filemanage , false);
	}

	public static BaseFileManage addUpdateFileManage ( BaseFileManage filemanage, boolean singleTransaction  ) throws Exception {
		if(filemanage.getFileId() == null) return addToFileManage(filemanage);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		FileManage dao = new FileManage();
		dao.setDataFromBase(filemanage);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(filemanage); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteFileManage ( BaseFileManage bean ) throws Exception {
		FileManage dao = new FileManage();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseFileManage updateFileManage ( BaseFileManage filemanage ) throws Exception {
		FileManage dao = new FileManage();
		dao.setFileId( filemanage.getFileId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(filemanage);
			result = dao.update();
		}
		return result == 1 ? filemanage : null ;
	}

	public static BaseFileManage updateFileManageDirect( BaseFileManage filemanage ) throws Exception {
		FileManage dao = new FileManage();
		int result = 0;
		dao.setDataFromBase(filemanage);
		result = dao.update();
		return result == 1 ? filemanage : null ;
	}

	public static int setDeleteConditions(BaseFileManage bean, FileManage dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getFileId() != null) {
			dao.setConditionFileId("=", bean.getFileId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getFileName() != null) {
				dao.setConditionFileName("=", bean.getFileName());
				count++;
			}
			if(bean.getFileExtension() != null) {
				dao.setConditionFileExtension("=", bean.getFileExtension());
				count++;
			}
			if(bean.getFileType() != null) {
				dao.setConditionFileType("=", bean.getFileType());
				count++;
			}
			if(bean.getFileSize() != null) {
				dao.setConditionFileSize("=", bean.getFileSize());
				count++;
			}
			if(bean.getFileUrl() != null) {
				dao.setConditionFileUrl("=", bean.getFileUrl());
				count++;
			}
			if(bean.getIconImg() != null) {
				dao.setConditionIconImg("=", bean.getIconImg());
				count++;
			}
			if(bean.getIconImgSize() != null) {
				dao.setConditionIconImgSize("=", bean.getIconImgSize());
				count++;
			}
			if(bean.getThumbnailImg() != null) {
				dao.setConditionThumbnailImg("=", bean.getThumbnailImg());
				count++;
			}
			if(bean.getThumbnailImgSize() != null) {
				dao.setConditionThumbnailImgSize("=", bean.getThumbnailImgSize());
				count++;
			}
			if(bean.getMatrixImg() != null) {
				dao.setConditionMatrixImg("=", bean.getMatrixImg());
				count++;
			}
			if(bean.getMatrixImgSize() != null) {
				dao.setConditionMatrixImgSize("=", bean.getMatrixImgSize());
				count++;
			}
			if(bean.getStandardImg() != null) {
				dao.setConditionStandardImg("=", bean.getStandardImg());
				count++;
			}
			if(bean.getStandardImgSize() != null) {
				dao.setConditionStandardImgSize("=", bean.getStandardImgSize());
				count++;
			}
			if(bean.getCitationTimes() != null) {
				dao.setConditionCitationTimes("=", bean.getCitationTimes());
				count++;
			}
			if(bean.getUploader() != null) {
				dao.setConditionUploader("=", bean.getUploader());
				count++;
			}
			if(bean.getVideoImage() != null) {
				dao.setConditionVideoImage("=", bean.getVideoImage());
				count++;
			}
			if(bean.getVideoImageSize() != null) {
				dao.setConditionVideoImageSize("=", bean.getVideoImageSize());
				count++;
			}
			if(bean.getImgWidth() != null) {
				dao.setConditionImgWidth("=", bean.getImgWidth());
				count++;
			}
			if(bean.getImgHeight() != null) {
				dao.setConditionImgHeight("=", bean.getImgHeight());
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
			if(bean.getVideoTime() != null) {
				dao.setConditionVideoTime("=", bean.getVideoTime());
				count++;
			}
			if(bean.getDominantColor() != null) {
				dao.setConditionDominantColor("=", bean.getDominantColor());
				count++;
			}
			if(bean.getFileTransferKey() != null) {
				dao.setConditionFileTransferKey("=", bean.getFileTransferKey());
				count++;
			}
			if(bean.getFileTransferStatus() != null) {
				dao.setConditionFileTransferStatus("=", bean.getFileTransferStatus());
				count++;
			}
			if(bean.getIconImgTransferKey() != null) {
				dao.setConditionIconImgTransferKey("=", bean.getIconImgTransferKey());
				count++;
			}
			if(bean.getIconImgTransferStatus() != null) {
				dao.setConditionIconImgTransferStatus("=", bean.getIconImgTransferStatus());
				count++;
			}
			if(bean.getThumbnailImgTransferKey() != null) {
				dao.setConditionThumbnailImgTransferKey("=", bean.getThumbnailImgTransferKey());
				count++;
			}
			if(bean.getThumbnailImgTransferStatus() != null) {
				dao.setConditionThumbnailImgTransferStatus("=", bean.getThumbnailImgTransferStatus());
				count++;
			}
			if(bean.getMatrixImgTransferKey() != null) {
				dao.setConditionMatrixImgTransferKey("=", bean.getMatrixImgTransferKey());
				count++;
			}
			if(bean.getMatrixImgTransferStatus() != null) {
				dao.setConditionMatrixImgTransferStatus("=", bean.getMatrixImgTransferStatus());
				count++;
			}
			if(bean.getStandardImgTransferKey() != null) {
				dao.setConditionStandardImgTransferKey("=", bean.getStandardImgTransferKey());
				count++;
			}
			if(bean.getStandardImgTransferStatus() != null) {
				dao.setConditionStandardImgTransferStatus("=", bean.getStandardImgTransferStatus());
				count++;
			}
			if(bean.getVideoImageTransferKey() != null) {
				dao.setConditionVideoImageTransferKey("=", bean.getVideoImageTransferKey());
				count++;
			}
			if(bean.getVideoImageTransferStatus() != null) {
				dao.setConditionVideoImageTransferStatus("=", bean.getVideoImageTransferStatus());
				count++;
			}
			if(bean.getOriginalFileId() != null) {
				dao.setConditionOriginalFileId("=", bean.getOriginalFileId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseFileManage bean, FileManage dao){
		int count = 0;
		if(bean.getFileId() != null) {
			dao.setConditionFileId("=", bean.getFileId());
			count++;
		}
		if(bean.getFileName() != null) {
			if(bean.getFileName().indexOf("%") >= 0)
				dao.setConditionFileName("like", bean.getFileName());
			else
				dao.setConditionFileName("=", bean.getFileName());
			count++;
		}
		if(bean.getFileExtension() != null) {
			if(bean.getFileExtension().indexOf("%") >= 0)
				dao.setConditionFileExtension("like", bean.getFileExtension());
			else
				dao.setConditionFileExtension("=", bean.getFileExtension());
			count++;
		}
		if(bean.getFileType() != null) {
			dao.setConditionFileType("=", bean.getFileType());
			count++;
		}
		if(bean.getFileSize() != null) {
			dao.setConditionFileSize("=", bean.getFileSize());
			count++;
		}
		if(bean.getFileUrl() != null) {
			if(bean.getFileUrl().indexOf("%") >= 0)
				dao.setConditionFileUrl("like", bean.getFileUrl());
			else
				dao.setConditionFileUrl("=", bean.getFileUrl());
			count++;
		}
		if(bean.getIconImg() != null) {
			if(bean.getIconImg().indexOf("%") >= 0)
				dao.setConditionIconImg("like", bean.getIconImg());
			else
				dao.setConditionIconImg("=", bean.getIconImg());
			count++;
		}
		if(bean.getIconImgSize() != null) {
			dao.setConditionIconImgSize("=", bean.getIconImgSize());
			count++;
		}
		if(bean.getThumbnailImg() != null) {
			if(bean.getThumbnailImg().indexOf("%") >= 0)
				dao.setConditionThumbnailImg("like", bean.getThumbnailImg());
			else
				dao.setConditionThumbnailImg("=", bean.getThumbnailImg());
			count++;
		}
		if(bean.getThumbnailImgSize() != null) {
			dao.setConditionThumbnailImgSize("=", bean.getThumbnailImgSize());
			count++;
		}
		if(bean.getMatrixImg() != null) {
			if(bean.getMatrixImg().indexOf("%") >= 0)
				dao.setConditionMatrixImg("like", bean.getMatrixImg());
			else
				dao.setConditionMatrixImg("=", bean.getMatrixImg());
			count++;
		}
		if(bean.getMatrixImgSize() != null) {
			dao.setConditionMatrixImgSize("=", bean.getMatrixImgSize());
			count++;
		}
		if(bean.getStandardImg() != null) {
			if(bean.getStandardImg().indexOf("%") >= 0)
				dao.setConditionStandardImg("like", bean.getStandardImg());
			else
				dao.setConditionStandardImg("=", bean.getStandardImg());
			count++;
		}
		if(bean.getStandardImgSize() != null) {
			dao.setConditionStandardImgSize("=", bean.getStandardImgSize());
			count++;
		}
		if(bean.getCitationTimes() != null) {
			dao.setConditionCitationTimes("=", bean.getCitationTimes());
			count++;
		}
		if(bean.getUploader() != null) {
			dao.setConditionUploader("=", bean.getUploader());
			count++;
		}
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
			count++;
		}
		if(bean.getUpdateTime() != null) {
			dao.setConditionUpdateTime(">=", bean.getUpdateTime());
			count++;
		}
		if(bean.getVideoImage() != null) {
			if(bean.getVideoImage().indexOf("%") >= 0)
				dao.setConditionVideoImage("like", bean.getVideoImage());
			else
				dao.setConditionVideoImage("=", bean.getVideoImage());
			count++;
		}
		if(bean.getVideoImageSize() != null) {
			dao.setConditionVideoImageSize("=", bean.getVideoImageSize());
			count++;
		}
		if(bean.getImgWidth() != null) {
			dao.setConditionImgWidth("=", bean.getImgWidth());
			count++;
		}
		if(bean.getImgHeight() != null) {
			dao.setConditionImgHeight("=", bean.getImgHeight());
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
		if(bean.getVideoTime() != null) {
			dao.setConditionVideoTime("=", bean.getVideoTime());
			count++;
		}
		if(bean.getDominantColor() != null) {
			if(bean.getDominantColor().indexOf("%") >= 0)
				dao.setConditionDominantColor("like", bean.getDominantColor());
			else
				dao.setConditionDominantColor("=", bean.getDominantColor());
			count++;
		}
		if(bean.getFileTransferKey() != null) {
			if(bean.getFileTransferKey().indexOf("%") >= 0)
				dao.setConditionFileTransferKey("like", bean.getFileTransferKey());
			else
				dao.setConditionFileTransferKey("=", bean.getFileTransferKey());
			count++;
		}
		if(bean.getFileTransferStatus() != null) {
			dao.setConditionFileTransferStatus("=", bean.getFileTransferStatus());
			count++;
		}
		if(bean.getIconImgTransferKey() != null) {
			if(bean.getIconImgTransferKey().indexOf("%") >= 0)
				dao.setConditionIconImgTransferKey("like", bean.getIconImgTransferKey());
			else
				dao.setConditionIconImgTransferKey("=", bean.getIconImgTransferKey());
			count++;
		}
		if(bean.getIconImgTransferStatus() != null) {
			dao.setConditionIconImgTransferStatus("=", bean.getIconImgTransferStatus());
			count++;
		}
		if(bean.getThumbnailImgTransferKey() != null) {
			if(bean.getThumbnailImgTransferKey().indexOf("%") >= 0)
				dao.setConditionThumbnailImgTransferKey("like", bean.getThumbnailImgTransferKey());
			else
				dao.setConditionThumbnailImgTransferKey("=", bean.getThumbnailImgTransferKey());
			count++;
		}
		if(bean.getThumbnailImgTransferStatus() != null) {
			dao.setConditionThumbnailImgTransferStatus("=", bean.getThumbnailImgTransferStatus());
			count++;
		}
		if(bean.getMatrixImgTransferKey() != null) {
			if(bean.getMatrixImgTransferKey().indexOf("%") >= 0)
				dao.setConditionMatrixImgTransferKey("like", bean.getMatrixImgTransferKey());
			else
				dao.setConditionMatrixImgTransferKey("=", bean.getMatrixImgTransferKey());
			count++;
		}
		if(bean.getMatrixImgTransferStatus() != null) {
			dao.setConditionMatrixImgTransferStatus("=", bean.getMatrixImgTransferStatus());
			count++;
		}
		if(bean.getStandardImgTransferKey() != null) {
			if(bean.getStandardImgTransferKey().indexOf("%") >= 0)
				dao.setConditionStandardImgTransferKey("like", bean.getStandardImgTransferKey());
			else
				dao.setConditionStandardImgTransferKey("=", bean.getStandardImgTransferKey());
			count++;
		}
		if(bean.getStandardImgTransferStatus() != null) {
			dao.setConditionStandardImgTransferStatus("=", bean.getStandardImgTransferStatus());
			count++;
		}
		if(bean.getVideoImageTransferKey() != null) {
			if(bean.getVideoImageTransferKey().indexOf("%") >= 0)
				dao.setConditionVideoImageTransferKey("like", bean.getVideoImageTransferKey());
			else
				dao.setConditionVideoImageTransferKey("=", bean.getVideoImageTransferKey());
			count++;
		}
		if(bean.getVideoImageTransferStatus() != null) {
			dao.setConditionVideoImageTransferStatus("=", bean.getVideoImageTransferStatus());
			count++;
		}
		if(bean.getOriginalFileId() != null) {
			dao.setConditionOriginalFileId("=", bean.getOriginalFileId());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseFileManage bean = new BaseFileManage();
		bean.setDataFromJSON(json);
		FileManage dao = new FileManage();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseFileManage> rlist = new BaseCollection<>();
		BaseFileManage bean = new BaseFileManage();
		Map<String, Object> params = (Map<String, Object>) delicacy.common.JsonParser.parse(json);
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		FileManage dao = new FileManage();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseFileManage> result = dao.conditionalLoad(addtion);
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
		BaseFileManage bean = new BaseFileManage();
		bean.setDataFromJSON(json);
		FileManage dao = new FileManage();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseFileManage bean = new BaseFileManage();
		bean.setDataFromJSON(json);
		FileManage dao = new FileManage();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseFileManage bean = new BaseFileManage();
		bean.setDataFromJSON(json);
		FileManage dao = new FileManage();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseFileManage bean = new BaseFileManage();
		bean.setDataFromJSON(json);
		FileManage dao = new FileManage();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


