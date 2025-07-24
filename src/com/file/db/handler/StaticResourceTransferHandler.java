package com.file.db.handler;

import org.apache.log4j.Logger;
import com.file.db.bean.BaseStaticResourceTransfer;
import java.util.List;
import com.file.db.dao.StaticResourceTransfer;
import delicacy.connection.ThreadConnection;
import delicacy.common.GenericDao;
import java.util.Map;
import delicacy.common.PaginationParameter;
import delicacy.common.BaseCollection;

public class StaticResourceTransferHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(StaticResourceTransferHandler.class);

	public static BaseStaticResourceTransfer getStaticResourceTransferById( 
		java.lang.Integer static_resource_transfer_id
	) throws Exception
	{
		StaticResourceTransfer dao = new StaticResourceTransfer();
		dao.setStaticResourceTransferId(static_resource_transfer_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isStaticResourceTransferExists( com.file.db.bean.BaseStaticResourceTransfer bean, String additional ) throws Exception {

		StaticResourceTransfer dao = new StaticResourceTransfer();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countStaticResourceTransfer( com.file.db.bean.BaseStaticResourceTransfer bean, String additional ) throws Exception {

		StaticResourceTransfer dao = new StaticResourceTransfer();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseStaticResourceTransfer> queryStaticResourceTransfer( com.file.db.bean.BaseStaticResourceTransfer bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		StaticResourceTransfer dao = new StaticResourceTransfer();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseStaticResourceTransfer> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseStaticResourceTransfer> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseStaticResourceTransfer addToStaticResourceTransfer ( BaseStaticResourceTransfer staticresourcetransfer )  throws Exception {
		return addToStaticResourceTransfer ( staticresourcetransfer , false);
	}

	public static BaseStaticResourceTransfer addToStaticResourceTransfer ( BaseStaticResourceTransfer staticresourcetransfer, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		StaticResourceTransfer dao = new StaticResourceTransfer();
		dao.setDataFromBase(staticresourcetransfer);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseStaticResourceTransfer addUpdateStaticResourceTransfer ( BaseStaticResourceTransfer staticresourcetransfer ) throws Exception {
		return addUpdateStaticResourceTransfer ( staticresourcetransfer , false);
	}

	public static BaseStaticResourceTransfer addUpdateStaticResourceTransfer ( BaseStaticResourceTransfer staticresourcetransfer, boolean singleTransaction  ) throws Exception {
		if(staticresourcetransfer.getStaticResourceTransferId() == null) return addToStaticResourceTransfer(staticresourcetransfer);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		StaticResourceTransfer dao = new StaticResourceTransfer();
		dao.setDataFromBase(staticresourcetransfer);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(staticresourcetransfer); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteStaticResourceTransfer ( BaseStaticResourceTransfer bean ) throws Exception {
		StaticResourceTransfer dao = new StaticResourceTransfer();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseStaticResourceTransfer updateStaticResourceTransfer ( BaseStaticResourceTransfer staticresourcetransfer ) throws Exception {
		StaticResourceTransfer dao = new StaticResourceTransfer();
		dao.setStaticResourceTransferId( staticresourcetransfer.getStaticResourceTransferId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(staticresourcetransfer);
			result = dao.update();
		}
		return result == 1 ? staticresourcetransfer : null ;
	}

	public static BaseStaticResourceTransfer updateStaticResourceTransferDirect( BaseStaticResourceTransfer staticresourcetransfer ) throws Exception {
		StaticResourceTransfer dao = new StaticResourceTransfer();
		int result = 0;
		dao.setDataFromBase(staticresourcetransfer);
		result = dao.update();
		return result == 1 ? staticresourcetransfer : null ;
	}

	public static int setDeleteConditions(BaseStaticResourceTransfer bean, StaticResourceTransfer dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getStaticResourceTransferId() != null) {
			dao.setConditionStaticResourceTransferId("=", bean.getStaticResourceTransferId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getFileId() != null) {
				dao.setConditionFileId("=", bean.getFileId());
				count++;
			}
			if(bean.getFileName() != null) {
				dao.setConditionFileName("=", bean.getFileName());
				count++;
			}
			if(bean.getFileSize() != null) {
				dao.setConditionFileSize("=", bean.getFileSize());
				count++;
			}
			if(bean.getFileExtension() != null) {
				dao.setConditionFileExtension("=", bean.getFileExtension());
				count++;
			}
			if(bean.getTransferKey() != null) {
				dao.setConditionTransferKey("=", bean.getTransferKey());
				count++;
			}
			if(bean.getRelativeFilePath() != null) {
				dao.setConditionRelativeFilePath("=", bean.getRelativeFilePath());
				count++;
			}
			if(bean.getAbsoluteFilePath() != null) {
				dao.setConditionAbsoluteFilePath("=", bean.getAbsoluteFilePath());
				count++;
			}
			if(bean.getTransferType() != null) {
				dao.setConditionTransferType("=", bean.getTransferType());
				count++;
			}
			if(bean.getStatus() != null) {
				dao.setConditionStatus("=", bean.getStatus());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
			if(bean.getDeleteFlag() != null) {
				dao.setConditionDeleteFlag("=", bean.getDeleteFlag());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseStaticResourceTransfer bean, StaticResourceTransfer dao){
		int count = 0;
		if(bean.getStaticResourceTransferId() != null) {
			dao.setConditionStaticResourceTransferId("=", bean.getStaticResourceTransferId());
			count++;
		}
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
		if(bean.getFileSize() != null) {
			dao.setConditionFileSize("=", bean.getFileSize());
			count++;
		}
		if(bean.getFileExtension() != null) {
			if(bean.getFileExtension().indexOf("%") >= 0)
				dao.setConditionFileExtension("like", bean.getFileExtension());
			else
				dao.setConditionFileExtension("=", bean.getFileExtension());
			count++;
		}
		if(bean.getTransferKey() != null) {
			if(bean.getTransferKey().indexOf("%") >= 0)
				dao.setConditionTransferKey("like", bean.getTransferKey());
			else
				dao.setConditionTransferKey("=", bean.getTransferKey());
			count++;
		}
		if(bean.getRelativeFilePath() != null) {
			if(bean.getRelativeFilePath().indexOf("%") >= 0)
				dao.setConditionRelativeFilePath("like", bean.getRelativeFilePath());
			else
				dao.setConditionRelativeFilePath("=", bean.getRelativeFilePath());
			count++;
		}
		if(bean.getAbsoluteFilePath() != null) {
			if(bean.getAbsoluteFilePath().indexOf("%") >= 0)
				dao.setConditionAbsoluteFilePath("like", bean.getAbsoluteFilePath());
			else
				dao.setConditionAbsoluteFilePath("=", bean.getAbsoluteFilePath());
			count++;
		}
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
			count++;
		}
		if(bean.getTransferType() != null) {
			dao.setConditionTransferType("=", bean.getTransferType());
			count++;
		}
		if(bean.getStatus() != null) {
			dao.setConditionStatus("=", bean.getStatus());
			count++;
		}
		if(bean.getBeginTime() != null) {
			dao.setConditionBeginTime(">=", bean.getBeginTime());
			count++;
		}
		if(bean.getEndTime() != null) {
			dao.setConditionEndTime(">=", bean.getEndTime());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
			count++;
		}
		if(bean.getDeleteFlag() != null) {
			dao.setConditionDeleteFlag("=", bean.getDeleteFlag());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseStaticResourceTransfer bean = new BaseStaticResourceTransfer();
		bean.setDataFromJSON(json);
		StaticResourceTransfer dao = new StaticResourceTransfer();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseStaticResourceTransfer> rlist = new BaseCollection<>();
		BaseStaticResourceTransfer bean = new BaseStaticResourceTransfer();
		Map<String, Object> params = (Map<String, Object>) delicacy.common.JsonParser.parse(json);
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		StaticResourceTransfer dao = new StaticResourceTransfer();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseStaticResourceTransfer> result = dao.conditionalLoad(addtion);
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
		BaseStaticResourceTransfer bean = new BaseStaticResourceTransfer();
		bean.setDataFromJSON(json);
		StaticResourceTransfer dao = new StaticResourceTransfer();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseStaticResourceTransfer bean = new BaseStaticResourceTransfer();
		bean.setDataFromJSON(json);
		StaticResourceTransfer dao = new StaticResourceTransfer();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseStaticResourceTransfer bean = new BaseStaticResourceTransfer();
		bean.setDataFromJSON(json);
		StaticResourceTransfer dao = new StaticResourceTransfer();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseStaticResourceTransfer bean = new BaseStaticResourceTransfer();
		bean.setDataFromJSON(json);
		StaticResourceTransfer dao = new StaticResourceTransfer();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


