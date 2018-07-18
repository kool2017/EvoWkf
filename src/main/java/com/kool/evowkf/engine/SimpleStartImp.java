/**
 * @PROJECT 
 * @DATE 2018年2月15日 下午8:08:01
 * @AUTHOR LUYU
 */
package com.kool.evowkf.engine;

import java.sql.Timestamp;
import java.util.List;

import com.kool.core.exception.AppException;
import com.kool.core.util.SpringContextUtil;
import com.kool.core.util.StringUtils;
import com.kool.evowkf.WKFConstants;
import com.kool.evowkf.bean.SyWkfDefineBean;
import com.kool.evowkf.bean.SyWkfEntityBean;
import com.kool.evowkf.bean.SyWkfEntityBusinessBean;
import com.kool.evowkf.bean.SyWkfNodeBean;
import com.kool.evowkf.bean.SyWkfRecordBean;
import com.kool.evowkf.bean.SyWkfScheduleBean;
import com.kool.evowkf.dao.SyWkfDefineDao;
import com.kool.evowkf.dao.SyWkfEntityBusinessDao;
import com.kool.evowkf.dao.SyWkfEntityDao;
import com.kool.evowkf.dao.SyWkfNodeDao;
import com.kool.evowkf.dao.SyWkfRecordDao;
import com.kool.evowkf.dao.SyWkfScheduleDao;

/**
 * @DESCRIBE
 * @AUTHOR LUYU
 * @DATE 2018年2月15日 下午8:08:01
 *
 */
public class SimpleStartImp implements IStart {

	/**
	 * @DESCRIBE
	 * @DATE 2018年2月15日 下午8:08:13
	 *
	 * @param wkfInfo
	 * @return
	 * @throws AppException
	 */
	@Override
	public String start(WKFContext wkfInfo) throws AppException {
		validate(wkfInfo);
		// 查询是单实例还是多实例，如果是单实例，查询状态正常的工作流实例；如果是多实例，执行实例匹配策略得到匹配值，查询状态正常的工作流实例
		String bussinessType = wkfInfo.getBusinessType();

		// 查询工作流实例-业务控制信息
		SyWkfEntityBusinessBean entityBusinessInfo = new SyWkfEntityBusinessBean();
		entityBusinessInfo.setSebBusinessType(bussinessType);
		SyWkfEntityBusinessDao entityBusinessDao = (SyWkfEntityBusinessDao) SpringContextUtil
				.getBean("SyWkfEntityBusinessDao");
		List<SyWkfEntityBusinessBean> listEntityBusiness = entityBusinessDao.select(entityBusinessInfo);
		if (null == listEntityBusiness || listEntityBusiness.size() <= 0 || listEntityBusiness.size() > 1) {
			throw new AppException("工作流实例-业务控制表配置不正确");// 工作流实例-业务控制表配置不正确
		}

		// 查询工作流实例
		SyWkfEntityBean entityInfo = new SyWkfEntityBean();
		entityInfo.setSweBusinessType(bussinessType);
		entityInfo.setSweState(WKFConstants.SWE_STATE_ACTIVE);
		SyWkfEntityDao entityDao = (SyWkfEntityDao) SpringContextUtil.getBean("SyWkfEntityDao");
		List<SyWkfEntityBean> listEntity = entityDao.select(entityInfo);
		if (null == listEntity || listEntity.size() <= 0) {
			throw new AppException("工作流实例未配置");// 工作流实例未配置
		}

		// 获取工作流实例匹配策略
		SyWkfEntityBusinessBean entityBusiness = listEntityBusiness.get(0);
		IEntityMatchStrategy strategy = EntityMatchStrategyFactory.getStrategy(entityBusiness);
		// 获取匹配的工作流实例
		SyWkfEntityBean entity = strategy.getEntity(listEntity, wkfInfo.getMatchValue());
		
		//获取工作流定义
		SyWkfDefineBean defineInfo = new SyWkfDefineBean();
		defineInfo.setSwdWkfCode(entity.getSweWkfCode());
		SyWkfDefineDao defineDao = (SyWkfDefineDao) SpringContextUtil.getBean("SyWkfDefineDao");
		SyWkfDefineBean define = defineDao.selectByPK(defineInfo);
		if (null == define) {
			throw new AppException("工作流定义未配置");
		}
		if (WKFConstants.SWD_STATE_CLOSE.equals(define.getSwdState())) {
			throw new AppException("工作流定义已关闭，不能开始新的流程");
		}

		// 生成执行记录ID
		String recordId = StringUtils.getUUID();
		// 插入一条流程执行记录
		SyWkfRecordBean record = new SyWkfRecordBean();
		record.setSrcWkfNbr(recordId);// 记录编号
		record.setSrcTimeBegin(new Timestamp(System.currentTimeMillis()));// 流程开始时间
		record.setSrcWkfCode(entity.getSweWkfCode());// 模式代号
		record.setSrcEntityCid(entity.getSweEntityCid());// 实例编号
		record.setSrcBusinessType(wkfInfo.getBusinessType());// 关联业务类型
		record.setSrcNodeHead(entity.getSweNodeHead());// 首结点编号
		record.setSrcNodeHeadName(entity.getSweNodeHeadName());// 首结点名称
		record.setSrcStartUserCid(wkfInfo.getUserId());// 发起人用户号
		record.setSrcStartLoginName(wkfInfo.getLoginName());// 发起人登录名
		record.setSrcDescription(wkfInfo.getDescription());// 流程概要描述
		record.setSrcState(WKFConstants.SRC_STATE_FATBRANCH);// 执行状态
		SyWkfRecordDao recordDao = (SyWkfRecordDao) SpringContextUtil.getBean("SyWkfRecordDao");
		recordDao.insert(record);

		// 查询首结点信息
		SyWkfNodeBean nodeInfo = new SyWkfNodeBean();
		nodeInfo.setSwnNodeCid(entity.getSweNodeHead());
		nodeInfo.setSwnState(WKFConstants.SWN_STATE_ACTIVE);
		SyWkfNodeDao nodeDao = (SyWkfNodeDao) SpringContextUtil.getBean("SyWkfNodeDao");
		SyWkfNodeBean node = nodeDao.selectByPK(nodeInfo);
		if (null == node) {
			throw new AppException("获取首结点信息失败");
		}

		// 插入一条待办
		SyWkfScheduleBean schedule = new SyWkfScheduleBean();
		schedule.setSwsScheduleCid(StringUtils.getUUID());// 待办编号
		schedule.setSwsWkfNbr(recordId);// 记录编号
		schedule.setSwsScheduleNodeCid(node.getSwnNodeCid());// 待办结点编号
		schedule.setSwsScheduleNodeName(node.getSwnNodeName());// 待办结点名称
		schedule.setSwsWgCid(node.getSwnWgCid());// 待办工作组ID
		schedule.setSwsBranchFlag(WKFConstants.SWS_BRANCH_FLAG_NO);// 是否分支中标志
		schedule.setSwsState(WKFConstants.SWS_STATE_READY);// 状态-待办
		SyWkfScheduleDao scheduleDao = (SyWkfScheduleDao) SpringContextUtil.getBean("SyWkfScheduleDao");
		scheduleDao.insert(schedule);

		// 如果首结点自动执行，执行nextStep
		if (WKFConstants.SWN_IS_AUTO_YES.equals(node.getSwnIsAuto())) {
			String checkFlag = define.getSwdCheckFlag();
			if (WKFConstants.SWD_CHECK_FLAG_YES.equals(checkFlag)) {
				//如果流程需要签收
				Alice.getInstance().getCheckWorker().check(recordId, schedule.getSwsScheduleCid(), "Alice", "Alice");
				wkfInfo.setUserId("Alice");
				wkfInfo.setLoginName("Alice");
			}
			Alice.getInstance().getStepWorker().nextStep(wkfInfo);
		}
		return recordId;
	}

	/**
	 * @DESCRIBE
	 * @DATE 2018年2月15日 下午9:03:17
	 *
	 * @param wkfInfo
	 */
	private void validate(WKFContext wkfInfo) {
		// TODO Auto-generated method stub

	}

}
