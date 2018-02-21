/**
 * @PROJECT 
 * @DATE 2018年2月17日 下午8:58:38
 * @AUTHOR LUYU
 */
package com.kool.evowkf.engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.kool.core.exception.BusException;
import com.kool.core.util.StringUtils;
import com.kool.evowkf.WKFConstants;
import com.kool.evowkf.bean.SyWkfNodeBean;
import com.kool.evowkf.bean.SyWkfRouteBean;
import com.kool.evowkf.bean.SyWkfScheduleBean;
import com.kool.evowkf.bean.vo.RouteResult;

/**
 * @DESCRIBE A2-下一结点中的随机结点
 * @AUTHOR LUYU
 * @DATE 2018年2月17日 下午8:58:38
 *
 */
public class A2RouteStrategy implements IRouteStrategy {

	/**
	 * @throws BusException
	 * @DESCRIBE
	 * @DATE 2018年2月17日 下午8:44:43
	 *
	 */
	@Override
	public RouteResult route(SyWkfScheduleBean schedule, SyWkfNodeBean node, WKFContext wkfInfo) throws BusException {
		// 执行记录状态
		String recordStatus = null;
		// 获取首结点=当前结点的路由集合
		List<SyWkfRouteBean> listRoutes = wkfInfo.getRoutes();
		List<SyWkfRouteBean> listNextRoutes = new ArrayList<>();
		for (SyWkfRouteBean route : listRoutes) {
			if (route.getSwrNodeHead().equals(node.getSwnNodeId())) {
				listNextRoutes.add(route);
			}
		}
		List<SyWkfScheduleBean> nextSchedules = new ArrayList<>();
		if (listNextRoutes.size() <= 0) {
			recordStatus = WKFConstants.SRC_RECORD_STATUS_FINISH;// 完成
		} else {
			recordStatus = WKFConstants.SRC_RECORD_STATUS_FATBRANCH;// 主干流程中
			// 获取一个路由
			SyWkfRouteBean nextRoute = listNextRoutes.get(0);
			// 获取下一结点
			Map<String, SyWkfNodeBean> nodes = wkfInfo.getNodes();
			SyWkfNodeBean nextNode = nodes.get(nextRoute.getSwrNodeTail());
			if (null == nextNode) {
				throw new BusException("路由的尾结点未配置");
			}

			// 构造一个待办
			SyWkfScheduleBean nextSchedule = new SyWkfScheduleBean();
			nextSchedule.setSwsScheduleId(StringUtils.getUUID());// 待办编号
			nextSchedule.setSwsRecordId(wkfInfo.getRecordId());// 记录编号
			nextSchedule.setSwsLastNodeId(node.getSwnNodeId());// 上一结点编号
			nextSchedule.setSwsLastNodeName(node.getSwnNodeName());// 上一结点名称
			nextSchedule.setSwsLastUserId(wkfInfo.getUserId());// 上一执行人用户编号
			nextSchedule.setSwsLastLoginName(wkfInfo.getLoginName());// 上一执行人用户登录名
			nextSchedule.setSwsScheduleNodeId(nextNode.getSwnNodeId());// 待办结点编号
			nextSchedule.setSwsScheduleNodeName(nextNode.getSwnNodeName());// 待办结点名称
			nextSchedule.setSwsWgId(nextNode.getSwnWgId());// 待办工作组ID
			nextSchedule.setSwsBranchFlag(WKFConstants.SWS_BRANCH_FLAG_NO);// 是否分支中标志
			nextSchedule.setSwsScheduleStatus(WKFConstants.SWS_SCHEDULE_STATUS_READY);// 状态=待办

			nextSchedules.add(nextSchedule);
		}

		RouteResult result = new RouteResult();
		result.setRecordStatus(recordStatus);
		result.setNextSchedules(nextSchedules);
		return result;
	}

}
