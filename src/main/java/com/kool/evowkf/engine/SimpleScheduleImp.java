/**
 * @PROJECT 
 * @DATE 2018年2月15日 下午8:10:52
 * @AUTHOR LUYU
 */
package com.kool.evowkf.engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.kool.core.util.SpringContextUtil;
import com.kool.core.util.StringUtils;
import com.kool.evowkf.bean.SyWkfAgentBean;
import com.kool.evowkf.bean.vo.WkfSchedule;
import com.kool.evowkf.dao.SyWkfAgentDao;
import com.kool.evowkf.dao.SyWkfScheduleDao;
import com.kool.evowkf.dao.SyWkfWorkerDao;
import com.kool.system.bean.io.SYPAGEINFOYBean;
import com.kool.system.bean.vo.PageResult;

/**
 * @DESCRIBE 查询待办列表
 * @AUTHOR LUYU
 * @DATE 2018年2月15日 下午8:10:52
 *
 */
public class SimpleScheduleImp implements ISchedule {
	private static Logger logger = Logger.getLogger(SimpleScheduleImp.class);

	/**
	 * @DESCRIBE 查询待办列表，签收人是本人，或者签收人为空待办组是本人所在工作组，或代理人是本人
	 * @DATE 2018年2月15日 下午8:11:00
	 *
	 * @param recordId
	 * @param businessType
	 * @param userId
	 * @param loginName
	 * @return
	 */
	@Override
	public PageResult querySchedule(String recordId, String businessType, String userId, String loginName,
			SYPAGEINFOYBean pageInfo) {
		// 查出由本人作为代理人的被代理人
		SyWkfAgentBean agentInfo = new SyWkfAgentBean();
		agentInfo.setSwaAgentUserCid(userId);
		SyWkfAgentDao agentDao = (SyWkfAgentDao) SpringContextUtil.getBean("SyWkfAgentDao");
		List<SyWkfAgentBean> listAgent = agentDao.select(agentInfo);

		// 查询本人及被代理人所在工作组编号
		List<String> listWgId = getWorkers(userId, listAgent);
		PageResult pageResult = new PageResult();
		if (null == listWgId || listWgId.size() <= 0) {
			pageResult.setPageInfo(pageInfo);
			return pageResult;
		}

		// 查询状态为待办的相关工作组的待办信息，及状态为签收且签收人为本人或被代理人的待办信息总数
		int total = getTotalSchedules(recordId, businessType, userId, listAgent, listWgId);

		int currentPage = pageInfo.getCurrentPage();
		int pageSize = pageInfo.getPageSize();
		int offset = (currentPage - 1) * pageSize;
		int pageCount = (total + pageSize - 1) / pageSize;

		// 查询状态为待办的相关工作组的待办信息，及状态为签收且签收人为本人或被代理人的待办信息
		List<WkfSchedule> schedules = getSchedules(recordId, businessType, userId, listAgent, listWgId, offset,
				pageSize);

		pageResult.setListBusinessValue(new ArrayList<>(schedules));
		pageInfo.setTotal(total);
		pageInfo.setPageCount(pageCount);
		pageResult.setPageInfo(pageInfo);
		return pageResult;
	}

	/**
	 * @DESCRIBE 查询状态为待办的相关工作组的待办信息，及状态为签收且签收人为本人或被代理人的待办信息总数
	 * @DATE 2018年2月20日 下午2:50:06
	 *
	 * @param userId
	 * @param listAgent
	 * @param listWgId
	 * @return
	 */
	private int getTotalSchedules(String recordId, String businessType, String userId, List<SyWkfAgentBean> listAgent,
			List<String> listWgId) {
		StringBuffer sbSelectTotalSql = new StringBuffer();
		sbSelectTotalSql.append("SELECT COUNT(*) FROM ");
		sbSelectTotalSql.append(
				"(SELECT SWS_SCHEDULE_ID,SWS_RECORD_ID,SWS_LAST_NODE_ID,SWS_LAST_NODE_NAME,SWS_LAST_USER_ID,SWS_LAST_LOGIN_NAME,SWS_SCHEDULE_NODE_ID,SWS_SCHEDULE_NODE_NAME,SWS_WG_ID,SWS_WG_NAME,SWS_SCHEDULE_USER_ID,SWS_SCHEDULE_LOGIN_NAME,SWS_BRANCH_FLAG,SWS_BRANCH_HEAD_ID,SWS_BRANCH_HEAD_NAME,SWS_SCHEDULE_STATUS,SWS_CREATE_TIME FROM SY_WKF_SCHEDULE ");
		sbSelectTotalSql.append("WHERE (SWS_SCHEDULE_USER_ID IN(");
		sbSelectTotalSql.append("'" + userId + "'");
		if (listAgent != null && listAgent.size() > 0) {
			for (SyWkfAgentBean agent : listAgent) {
				sbSelectTotalSql.append(",'" + agent.getSwaUserCid() + "'");
			}
		}
		sbSelectTotalSql.append(") AND SWS_SCHEDULE_STATUS = 'CHK') ");
		sbSelectTotalSql.append("OR (SWS_WG_ID IN ('#'");
		if (listWgId != null && listWgId.size() > 0) {
			for (String wgId : listWgId) {
				sbSelectTotalSql.append(",'" + wgId + "'");
			}
		}
		sbSelectTotalSql.append(") AND SWS_SCHEDULE_STATUS = 'RDY')) AS A ");
		sbSelectTotalSql.append("LEFT OUTER JOIN SY_WKF_RECORD AS B ON A.SWS_RECORD_ID = B.SRC_RECORD_ID ");
		sbSelectTotalSql.append("WHERE 1=1 ");
		if (StringUtils.isEmpty(recordId) == false) {
			sbSelectTotalSql.append("AND A.SWS_RECORD_ID = '" + recordId + "' ");
		}
		if (StringUtils.isEmpty(businessType) == false) {
			sbSelectTotalSql.append("AND B.SRC_BUSINESS_TYPE = '" + businessType + "' ");
		}
		logger.debug(sbSelectTotalSql.toString());

		SyWkfScheduleDao scheduleDao = (SyWkfScheduleDao) SpringContextUtil.getBean("SyWkfScheduleDao");
		int total = scheduleDao.selectTotalBySql(sbSelectTotalSql.toString());
		return total;
	}

	/**
	 * @DESCRIBE 查询状态为待办的相关工作组的待办信息，及状态为签收且签收人为本人或被代理人的待办信息
	 * @DATE 2018年2月18日 下午12:45:22
	 *
	 * @param userId
	 * @param listAgent
	 * @param listWgId
	 * @param pageCount
	 * @param offset
	 * @return
	 */
	private List<WkfSchedule> getSchedules(String recordId, String businessType, String userId,
			List<SyWkfAgentBean> listAgent, List<String> listWgId, int offset, int pageCount) {

		StringBuffer sbSql = new StringBuffer();
		sbSql.append(
				"SELECT B.SRC_TIME_BEGIN,B.SRC_BUSINESS_TYPE,B.SRC_NODE_HEAD_NAME,B.SRC_START_LOGIN_NAME,B.SRC_DESCRIPTION,B.SRC_RECORD_STATUS,A.SWS_SCHEDULE_ID,A.SWS_RECORD_ID,A.SWS_LAST_NODE_ID,A.SWS_LAST_NODE_NAME,A.SWS_LAST_USER_ID,A.SWS_LAST_LOGIN_NAME,A.SWS_SCHEDULE_NODE_ID,A.SWS_SCHEDULE_NODE_NAME,A.SWS_WG_ID,A.SWS_WG_NAME,A.SWS_SCHEDULE_USER_ID,A.SWS_SCHEDULE_LOGIN_NAME,A.SWS_BRANCH_FLAG,A.SWS_BRANCH_HEAD_ID,A.SWS_BRANCH_HEAD_NAME,A.SWS_SCHEDULE_STATUS,A.SWS_CREATE_TIME FROM ");
		sbSql.append(
				"(SELECT SWS_SCHEDULE_ID,SWS_RECORD_ID,SWS_LAST_NODE_ID,SWS_LAST_NODE_NAME,SWS_LAST_USER_ID,SWS_LAST_LOGIN_NAME,SWS_SCHEDULE_NODE_ID,SWS_SCHEDULE_NODE_NAME,SWS_WG_ID,SWS_WG_NAME,SWS_SCHEDULE_USER_ID,SWS_SCHEDULE_LOGIN_NAME,SWS_BRANCH_FLAG,SWS_BRANCH_HEAD_ID,SWS_BRANCH_HEAD_NAME,SWS_SCHEDULE_STATUS,SWS_CREATE_TIME FROM SY_WKF_SCHEDULE ");
		sbSql.append("WHERE (SWS_SCHEDULE_USER_ID IN(");
		sbSql.append("'" + userId + "'");
		if (listAgent != null && listAgent.size() > 0) {
			for (SyWkfAgentBean agent : listAgent) {
				sbSql.append(",'" + agent.getSwaUserCid() + "'");
			}
		}
		sbSql.append(") AND SWS_SCHEDULE_STATUS = 'CHK') ");
		sbSql.append("OR (SWS_WG_ID IN ('#'");
		if (listWgId != null && listWgId.size() > 0) {
			for (String wgId : listWgId) {
				sbSql.append(",'" + wgId + "'");
			}
		}
		sbSql.append(") AND SWS_SCHEDULE_STATUS = 'RDY')) AS A ");
		sbSql.append("LEFT OUTER JOIN SY_WKF_RECORD AS B ON A.SWS_RECORD_ID = B.SRC_RECORD_ID ");
		sbSql.append("WHERE 1=1 ");
		if (StringUtils.isEmpty(recordId) == false) {
			sbSql.append("AND A.SWS_RECORD_ID = '" + recordId + "' ");
		}
		if (StringUtils.isEmpty(businessType) == false) {
			sbSql.append("AND B.SRC_BUSINESS_TYPE = '" + businessType + "' ");
		}
		sbSql.append("ORDER BY A.SWS_CREATE_TIME DESC ");
		sbSql.append("LIMIT " + String.valueOf(offset) + "," + String.valueOf(pageCount));
		logger.debug(sbSql.toString());

		SyWkfScheduleDao scheduleDao = (SyWkfScheduleDao) SpringContextUtil.getBean("SyWkfScheduleDao");
		List<Map<String, Object>> ListSchedules = scheduleDao.selectBySql(sbSql.toString());
		List<WkfSchedule> schedules = new ArrayList<>();
		for (Map<String, Object> mapSchedule : ListSchedules) {
			String sSchedule = JSONObject.toJSONString(mapSchedule);
			WkfSchedule schedule = JSONObject.toJavaObject(JSONObject.parseObject(sSchedule), WkfSchedule.class);
			schedules.add(schedule);
		}
		return schedules;
	}

	/**
	 * @DESCRIBE 查询本人及被代理人所在工作组编号
	 * @DATE 2018年2月18日 下午12:41:11
	 *
	 * @param userId
	 * @param listAgent
	 * @return
	 */
	private List<String> getWorkers(String userId, List<SyWkfAgentBean> listAgent) {
		StringBuffer sbSql = new StringBuffer();
		sbSql.append("SELECT SWO_WG_ID FROM SY_WKF_WORKER WHERE SWO_USER_ID IN (");
		sbSql.append("'" + userId + "'");
		if (listAgent != null && listAgent.size() > 0) {
			for (SyWkfAgentBean agent : listAgent) {
				sbSql.append(",'" + agent.getSwaUserCid() + "'");
			}
		}
		sbSql.append(") AND SWO_USER_STATUS = 'A'");
		logger.debug(sbSql.toString());

		SyWkfWorkerDao workerDao = (SyWkfWorkerDao) SpringContextUtil.getBean("SyWkfWorkerDao");
		List<Map<String, Object>> listWorkers = workerDao.selectBySql(sbSql.toString());
		List<String> listWgId = new ArrayList<>();
		for (Map<String, Object> mapWorker : listWorkers) {
			listWgId.add((String) (mapWorker.get("SWO_WG_ID")));
		}
		return listWgId;
	}

}
