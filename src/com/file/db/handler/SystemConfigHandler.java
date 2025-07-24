package com.file.db.handler;

import com.file.db.bean.BaseSystemConfig;
import com.file.db.dao.SystemConfig;
import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Map;

public class SystemConfigHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(SystemConfigHandler.class);

	public static BaseSystemConfig getSystemConfigById( 
		Integer system_config_id
	) throws Exception
	{
		SystemConfig dao = new SystemConfig();
		dao.setSystemConfigId(system_config_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isSystemConfigExists( BaseSystemConfig bean, String additional ) throws Exception {

		SystemConfig dao = new SystemConfig();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countSystemConfig( BaseSystemConfig bean, String additional ) throws Exception {

		SystemConfig dao = new SystemConfig();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseSystemConfig> querySystemConfig( BaseSystemConfig bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		SystemConfig dao = new SystemConfig();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		List<BaseSystemConfig> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseSystemConfig> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseSystemConfig addToSystemConfig ( BaseSystemConfig systemconfig )  throws Exception {
		return addToSystemConfig ( systemconfig , false);
	}

	public static BaseSystemConfig addToSystemConfig ( BaseSystemConfig systemconfig, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		SystemConfig dao = new SystemConfig();
		dao.setDataFromBase(systemconfig);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseSystemConfig addUpdateSystemConfig ( BaseSystemConfig systemconfig ) throws Exception {
		return addUpdateSystemConfig ( systemconfig , false);
	}

	public static BaseSystemConfig addUpdateSystemConfig ( BaseSystemConfig systemconfig, boolean singleTransaction  ) throws Exception {
		if(systemconfig.getSystemConfigId() == null) return addToSystemConfig(systemconfig);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		SystemConfig dao = new SystemConfig();
		dao.setDataFromBase(systemconfig);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(systemconfig); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteSystemConfig ( BaseSystemConfig bean ) throws Exception {
		SystemConfig dao = new SystemConfig();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseSystemConfig updateSystemConfig ( BaseSystemConfig systemconfig ) throws Exception {
		SystemConfig dao = new SystemConfig();
		dao.setSystemConfigId( systemconfig.getSystemConfigId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(systemconfig);
			result = dao.update();
		}
		return result == 1 ? systemconfig : null ;
	}

	public static BaseSystemConfig updateSystemConfigDirect( BaseSystemConfig systemconfig ) throws Exception {
		SystemConfig dao = new SystemConfig();
		int result = 0;
		dao.setDataFromBase(systemconfig);
		result = dao.update();
		return result == 1 ? systemconfig : null ;
	}

	public static int setDeleteConditions(BaseSystemConfig bean, SystemConfig dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getSystemConfigId() != null) {
			dao.setConditionSystemConfigId("=", bean.getSystemConfigId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getImagePath() != null) {
				dao.setConditionImagePath("=", bean.getImagePath());
				count++;
			}
			if(bean.getConfigType() != null) {
				dao.setConditionConfigType("=", bean.getConfigType());
				count++;
			}
			if(bean.getUserId() != null) {
				dao.setConditionUserId("=", bean.getUserId());
				count++;
			}
			if(bean.getAccount() != null) {
				dao.setConditionAccount("=", bean.getAccount());
				count++;
			}
			if(bean.getCorpId() != null) {
				dao.setConditionCorpId("=", bean.getCorpId());
				count++;
			}
			if(bean.getAgentId() != null) {
				dao.setConditionAgentId("=", bean.getAgentId());
				count++;
			}
			if(bean.getCorpSecret() != null) {
				dao.setConditionCorpSecret("=", bean.getCorpSecret());
				count++;
			}
			if(bean.getTxlCorpSecret() != null) {
				dao.setConditionTxlCorpSecret("=", bean.getTxlCorpSecret());
				count++;
			}
			if(bean.getCheckUserId() != null) {
				dao.setConditionCheckUserId("=", bean.getCheckUserId());
				count++;
			}
			if(bean.getFromTitle() != null) {
				dao.setConditionFromTitle("=", bean.getFromTitle());
				count++;
			}
			if(bean.getHostName() != null) {
				dao.setConditionHostName("=", bean.getHostName());
				count++;
			}
			if(bean.getFromEmail() != null) {
				dao.setConditionFromEmail("=", bean.getFromEmail());
				count++;
			}
			if(bean.getPassword() != null) {
				dao.setConditionPassword("=", bean.getPassword());
				count++;
			}
			if(bean.getIsCrossMonth() != null) {
				dao.setConditionIsCrossMonth("=", bean.getIsCrossMonth());
				count++;
			}
			if(bean.getIsBefore() != null) {
				dao.setConditionIsBefore("=", bean.getIsBefore());
				count++;
			}
			if(bean.getCountDay() != null) {
				dao.setConditionCountDay("=", bean.getCountDay());
				count++;
			}
			if(bean.getContentTitle() != null) {
				dao.setConditionContentTitle("=", bean.getContentTitle());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseSystemConfig bean, SystemConfig dao){
		int count = 0;
		if(bean.getSystemConfigId() != null) {
			dao.setConditionSystemConfigId("=", bean.getSystemConfigId());
			count++;
		}
		if(bean.getImagePath() != null) {
			if(bean.getImagePath().indexOf("%") >= 0)
				dao.setConditionImagePath("like", bean.getImagePath());
			else
				dao.setConditionImagePath("=", bean.getImagePath());
			count++;
		}
		if(bean.getConfigType() != null) {
			dao.setConditionConfigType("=", bean.getConfigType());
			count++;
		}
		if(bean.getUserId() != null) {
			if(bean.getUserId().indexOf("%") >= 0)
				dao.setConditionUserId("like", bean.getUserId());
			else
				dao.setConditionUserId("=", bean.getUserId());
			count++;
		}
		if(bean.getAccount() != null) {
			if(bean.getAccount().indexOf("%") >= 0)
				dao.setConditionAccount("like", bean.getAccount());
			else
				dao.setConditionAccount("=", bean.getAccount());
			count++;
		}
		if(bean.getCorpId() != null) {
			if(bean.getCorpId().indexOf("%") >= 0)
				dao.setConditionCorpId("like", bean.getCorpId());
			else
				dao.setConditionCorpId("=", bean.getCorpId());
			count++;
		}
		if(bean.getAgentId() != null) {
			if(bean.getAgentId().indexOf("%") >= 0)
				dao.setConditionAgentId("like", bean.getAgentId());
			else
				dao.setConditionAgentId("=", bean.getAgentId());
			count++;
		}
		if(bean.getCorpSecret() != null) {
			if(bean.getCorpSecret().indexOf("%") >= 0)
				dao.setConditionCorpSecret("like", bean.getCorpSecret());
			else
				dao.setConditionCorpSecret("=", bean.getCorpSecret());
			count++;
		}
		if(bean.getTxlCorpSecret() != null) {
			if(bean.getTxlCorpSecret().indexOf("%") >= 0)
				dao.setConditionTxlCorpSecret("like", bean.getTxlCorpSecret());
			else
				dao.setConditionTxlCorpSecret("=", bean.getTxlCorpSecret());
			count++;
		}
		if(bean.getCheckUserId() != null) {
			if(bean.getCheckUserId().indexOf("%") >= 0)
				dao.setConditionCheckUserId("like", bean.getCheckUserId());
			else
				dao.setConditionCheckUserId("=", bean.getCheckUserId());
			count++;
		}
		if(bean.getFromTitle() != null) {
			if(bean.getFromTitle().indexOf("%") >= 0)
				dao.setConditionFromTitle("like", bean.getFromTitle());
			else
				dao.setConditionFromTitle("=", bean.getFromTitle());
			count++;
		}
		if(bean.getHostName() != null) {
			if(bean.getHostName().indexOf("%") >= 0)
				dao.setConditionHostName("like", bean.getHostName());
			else
				dao.setConditionHostName("=", bean.getHostName());
			count++;
		}
		if(bean.getFromEmail() != null) {
			if(bean.getFromEmail().indexOf("%") >= 0)
				dao.setConditionFromEmail("like", bean.getFromEmail());
			else
				dao.setConditionFromEmail("=", bean.getFromEmail());
			count++;
		}
		if(bean.getPassword() != null) {
			if(bean.getPassword().indexOf("%") >= 0)
				dao.setConditionPassword("like", bean.getPassword());
			else
				dao.setConditionPassword("=", bean.getPassword());
			count++;
		}
		if(bean.getIsCrossMonth() != null) {
			dao.setConditionIsCrossMonth("=", bean.getIsCrossMonth());
			count++;
		}
		if(bean.getIsBefore() != null) {
			dao.setConditionIsBefore("=", bean.getIsBefore());
			count++;
		}
		if(bean.getCountDay() != null) {
			dao.setConditionCountDay("=", bean.getCountDay());
			count++;
		}
		if(bean.getContentTitle() != null) {
			if(bean.getContentTitle().indexOf("%") >= 0)
				dao.setConditionContentTitle("like", bean.getContentTitle());
			else
				dao.setConditionContentTitle("=", bean.getContentTitle());
			count++;
		}
		return count;
	}

	public String findUsingKey(String json) throws Exception{
		BaseSystemConfig bean = new BaseSystemConfig();
		bean.setDataFromJSON(json);
		SystemConfig dao = new SystemConfig();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseSystemConfig> rlist = new BaseCollection<>();
		BaseSystemConfig bean = new BaseSystemConfig();
		Map<String, Object> params = (Map<String, Object>) delicacy.common.JsonParser.parse(json);
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		SystemConfig dao = new SystemConfig();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseSystemConfig> result = dao.conditionalLoad(addtion);
		rlist.setCollections(result);
		rlist.setTotalPages(dao.getTotalPages());
		rlist.setCurrentPage(dao.getCurrentPage());
		rlist.setPageLines(dao.getPageLines());
		rlist.setTotalLines(dao.getTotalLines());
		rlist.setRecordNumber(result.size());
		return rlist.toJSON(null);
	}

	public String save(String json) throws Exception{
		BaseSystemConfig bean = new BaseSystemConfig();
		bean.setDataFromJSON(json);
		SystemConfig dao = new SystemConfig();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	public String update(String json) throws Exception{
		BaseSystemConfig bean = new BaseSystemConfig();
		bean.setDataFromJSON(json);
		SystemConfig dao = new SystemConfig();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	public String delete(String json) throws Exception{
		BaseSystemConfig bean = new BaseSystemConfig();
		bean.setDataFromJSON(json);
		SystemConfig dao = new SystemConfig();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	public String saveOrUpdate(String json) throws Exception{
		BaseSystemConfig bean = new BaseSystemConfig();
		bean.setDataFromJSON(json);
		SystemConfig dao = new SystemConfig();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


