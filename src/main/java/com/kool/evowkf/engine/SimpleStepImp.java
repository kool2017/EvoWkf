/**
 * @PROJECT 
 * @DATE 2018年2月15日 下午8:11:30
 * @AUTHOR LUYU
 */
package com.kool.evowkf.engine;

import java.sql.Timestamp;
import java.util.List;

import com.kool.core.exception.AppException;
import com.kool.core.exception.BusException;
import com.kool.core.util.SpringContextUtil;
import com.kool.core.util.StringUtils;
import com.kool.evowkf.WKFConstants;
import com.kool.evowkf.bean.SyWkfDefineBean;
import com.kool.evowkf.bean.SyWkfEntityBean;
import com.kool.evowkf.bean.SyWkfNodeBean;
import com.kool.evowkf.bean.SyWkfRecordBean;
import com.kool.evowkf.bean.SyWkfRecordDataBean;
import com.kool.evowkf.bean.SyWkfRecordDetailBean;
import com.kool.evowkf.bean.SyWkfScheduleBean;
import com.kool.evowkf.bean.vo.BusinessValue;
import com.kool.evowkf.bean.vo.RouteResult;
import com.kool.evowkf.bean.vo.WkfEventResult;
import com.kool.evowkf.dao.SyWkfNodeDao;
import com.kool.evowkf.dao.SyWkfRecordDao;
import com.kool.evowkf.dao.SyWkfRecordDataDao;
import com.kool.evowkf.dao.SyWkfRecordDetailDao;
import com.kool.evowkf.dao.SyWkfScheduleDao;

/**
 * @DESCRIBE
 * @AUTHOR LUYU
 * @DATE 2018年2月15日 下午8:11:30
 *
 */
public class SimpleStepImp implements IStep {

	/**
	 * @DESCRIBE
	 * @DATE 2018年2月15日 下午8:11:45
	 *
	 * @param wkfInfo
	 * @throws BusException
	 * @throws AppException 
	 */
	@Override
	public void nextStep(WKFContext wkfInfo) throws BusException, AppException {
		// 查询待办信息
		String scheduleId = wkfInfo.getScheduleId();
		SyWkfScheduleBean scheduleInfo = new SyWkfScheduleBean();
		scheduleInfo.setSwsScheduleId(scheduleId);
		SyWkfScheduleDao scheduleDao = (SyWkfScheduleDao) SpringContextUtil.getBean("SyWkfScheduleDao");
		SyWkfScheduleBean schedule = scheduleDao.selectByPK(scheduleInfo);
		if (null == schedule) {
			throw new BusException("查询待办结果为空");
		}

		// 查询流程执行记录
		SyWkfRecordBean recordInfo = new SyWkfRecordBean();
		recordInfo.setSrcRecordId(schedule.getSwsRecordId());
		SyWkfRecordDao recordDao = (SyWkfRecordDao) SpringContextUtil.getBean("SyWkfRecordDao");
		SyWkfRecordBean record = recordDao.selectByPK(recordInfo);
		if (null == record) {
			throw new BusException("查询流程执行记录结果为空");
		}

		wkfInfo.setRecordId(record.getSrcRecordId());
		// 初始化上下文的工作流定义、工作流实例、实例关联的路由集合、实例关联的结点集合
		WKFContextHelper.initWkfCfg(record.getSrcEntityId(), wkfInfo);

		// 获取工作流定义
		SyWkfDefineBean define = wkfInfo.getDefine();

		// 获取工作流实例
		SyWkfEntityBean entity = wkfInfo.getEntity();

		// 检查是否可执行
		if (WKFConstants.SWD_WKF_STATUS_CLOSE.equals(define.getSwdWkfStatus())) {
			throw new BusException("工作流已关闭");
		}
		if (WKFConstants.SWE_ENTITY_STATUS_CLOSE.equals(entity.getSweEntityStatus())) {
			throw new BusException("工作流实例已关闭");
		}
		if (WKFConstants.SWD_CHECK_FLAG_YES.equals(define.getSwdCheckFlag())
				&& WKFConstants.SWS_SCHEDULE_STATUS_CHECK.equals(schedule.getSwsScheduleStatus()) == false) {
			// 如果流程签收标志=签收，待办状态非签收，报错
			throw new BusException("未签收，请先签收");
		}
		// 查询待办结点信息
		SyWkfNodeBean nodeInfo = new SyWkfNodeBean();
		nodeInfo.setSwnNodeId(schedule.getSwsScheduleNodeId());
		SyWkfNodeDao nodeDao = (SyWkfNodeDao) SpringContextUtil.getBean("SyWkfNodeDao");
		SyWkfNodeBean node = nodeDao.selectByPK(nodeInfo);
		if (null == node) {
			throw new BusException("查询待办结点信息结果为空");
		}

		// 事件类型
		String eventType = node.getSwnEventType();
		// 事件执行方式
		String eventRule = node.getSwnEventRule();
		// 事件执行扩展
		String eventExt = node.getSwnEventExt();

		// 执行事件
		NodeEvent event = new NodeEvent(schedule, node, wkfInfo);
		EventHandler handler = EventHandlerBuilder.build(eventType, eventRule, eventExt);
		WkfEventResult result = handler.handleEvent(event);

		// 查询执行记录的明细数
		SyWkfRecordDetailBean recordDtlInfo = new SyWkfRecordDetailBean();
		recordDtlInfo.setSrdRecordId(schedule.getSwsRecordId());
		SyWkfRecordDetailDao recordDtlDao = (SyWkfRecordDetailDao) SpringContextUtil.getBean("SyWkfRecordDetailDao");
		int numOfDtl = recordDtlDao.selectTotal(recordDtlInfo);
		// 补充明细业务数据
		SyWkfRecordDetailBean recordDetail = new SyWkfRecordDetailBean();
		String detailId = StringUtils.getUUID();
		wkfInfo.setRecordDetailId(detailId);
		recordDetail.setSrdDetailId(detailId);// 记录明细编号
		recordDetail.setSrdRecordId(schedule.getSwsRecordId());// 记录编号
		recordDetail.setSrdScheduleId(schedule.getSwsScheduleId());// 待办编号
		recordDetail.setSrdDetailSeq(numOfDtl + 1);// 序号
		recordDetail.setSrdDetailTime(new Timestamp(System.currentTimeMillis()));// 记录时间
		recordDetail.setSrdNodeId(schedule.getSwsScheduleNodeId());// 执行结点编号
		recordDetail.setSrdNodeName(schedule.getSwsScheduleNodeName());// 执行结点名称
		recordDetail.setSrdUserId(wkfInfo.getUserId());// 执行人用户号
		recordDetail.setSrdLoginName(wkfInfo.getLoginName());// 执行人登录名
		recordDetail.setSrdEventType(node.getSwnEventType());// 事件类型
		recordDetail.setSrdEventRule(node.getSwnEventRule());// 事件执行方式
		recordDetail.setSrdEventFlag(result.getEventFlag());// 事件选择标志
		recordDetail.setSrdEventDsp(result.getEventDsp());// 事件摘要
		if (WKFConstants.SWN_RECORD_TYPE_NONE.equals(node.getSwnRecordType())) {
			// 不记录
		} else if (WKFConstants.SWN_RECORD_TYPE_STRING.equals(node.getSwnRecordType())) {
			BusinessValue businessValue = wkfInfo.getBusinessValue();
			recordDetail.setSrdBusinessField1(businessValue.getBusinessField1());// 业务要素1
			recordDetail.setSrdBusinessField2(businessValue.getBusinessField2());// 业务要素2
			recordDetail.setSrdBusinessField3(businessValue.getBusinessField3());// 业务要素3
			recordDetail.setSrdBusinessField4(businessValue.getBusinessField4());// 业务要素4
			recordDetail.setSrdBusinessField5(businessValue.getBusinessField5());// 业务要素5
			recordDetail.setSrdBusinessField6(businessValue.getBusinessField6());// 业务要素6
			recordDetail.setSrdBusinessField7(businessValue.getBusinessField7());// 业务要素7
			recordDetail.setSrdBusinessField8(businessValue.getBusinessField8());// 业务要素8
			recordDetail.setSrdBusinessField9(businessValue.getBusinessField9());// 业务要素9
			recordDetail.setSrdBusinessField10(businessValue.getBusinessField10());// 业务要素10
		} else if (WKFConstants.SWN_RECORD_TYPE_PKG.equals(node.getSwnRecordType())) {
			// 记录附加数据
			if (StringUtils.isEmpty(wkfInfo.getExtData()) == false) {
				SyWkfRecordDataBean recordData = new SyWkfRecordDataBean();
				recordData.setSrtRecordId(schedule.getSwsRecordId());
				recordData.setSrtDetailId(recordDetail.getSrdDetailId());
				recordData.setSrtBusPkg(wkfInfo.getExtData());
				SyWkfRecordDataDao recordDataDao = (SyWkfRecordDataDao) SpringContextUtil.getBean("SyWkfRecordDataDao");
				recordDataDao.insert(recordData);
			}
		} else {
			throw new BusException("不支持的数据记录方式");
		}
		// 插入明细
		recordDetail.setSrdRecordStatus(WKFConstants.SRD_RECORD_STATUS_FINISH);// 执行后状态=完成
		recordDtlDao.insert(recordDetail);

		// 更新待办
		schedule.setSwsScheduleStatus(WKFConstants.SWS_SCHEDULE_STATUS_FINISH);// 状态= 完成
		scheduleDao.update(schedule);

		// 路由与分支处理
		RouteResult routeResult = null;
		boolean forward = result.getForward();
		// 获取路由策略
		IRouteStrategy strategy = RouteStrategyFactory.getStrategy(forward, node);
		// 路由，新建待办集合
		routeResult = strategy.route(schedule, node, wkfInfo);

		// 更新流程执行执行记录
		String recordStatus = routeResult.getRecordStatus();
		if (StringUtils.isEmpty(recordStatus)) {
			throw new BusException("执行记录状态不能为空");
		}
		record.setSrcRecordStatus(recordStatus);
		recordDao.update(record);
		if (WKFConstants.SRC_RECORD_STATUS_FINISH.equals(recordStatus)) {
			// 更新其它分支待办状态=关闭
			scheduleDao.closeOtherSchedule(record.getSrcRecordId(), scheduleId);
		} else {
			// 插入待办
			List<SyWkfScheduleBean> nextSchedules = routeResult.getNextSchedules();
			if (nextSchedules != null && nextSchedules.size() > 0) {
				scheduleDao.insertBatch(routeResult.getNextSchedules());

				// 如果下一结点是自动执行，执行nextStep
				for (SyWkfScheduleBean nextSchedule : nextSchedules) {
					SyWkfNodeBean nextNode = wkfInfo.getNodes().get(nextSchedule.getSwsScheduleNodeId());
					if (null == nextNode) {
						throw new BusException("获取待办结点信息结果为空");
					}
					if (WKFConstants.SWN_IS_AUTO_YES.equals(nextNode.getSwnIsAuto())) {
						String checkFlag = define.getSwdCheckFlag();
						if (WKFConstants.SWD_CHECK_FLAG_YES.equals(checkFlag)) {
							// 如果流程需要签收
							Alice.getInstance().getCheckWorker().check(record.getSrcRecordId(), nextSchedule.getSwsScheduleId(), "Alice",
									"Alice");
							wkfInfo.setUserId("Alice");
							wkfInfo.setLoginName("Alice");
						}
						Alice.getInstance().getStepWorker().nextStep(wkfInfo);
					}
				}
			}
		}
	}

}
