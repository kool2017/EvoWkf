/**
 * @PROJECT 
 * @DATE 2018年2月17日 下午3:16:14
 * @AUTHOR LUYU
 */
package com.kool.evowkf.engine;

import com.kool.evowkf.bean.SyWkfNodeBean;
import com.kool.evowkf.bean.SyWkfScheduleBean;

/**
 * @DESCRIBE
 * @AUTHOR LUYU
 * @DATE 2018年2月17日 下午3:16:14
 *
 */
public class NodeEvent {
	private SyWkfScheduleBean schedule;
	private SyWkfNodeBean node;
	private WKFContext wkfInfo;

	/**
	 * @return the schedule
	 */
	public SyWkfScheduleBean getSchedule() {
		return schedule;
	}

	/**
	 * @param schedule
	 *            the schedule to set
	 */
	public void setSchedule(SyWkfScheduleBean schedule) {
		this.schedule = schedule;
	}

	/**
	 * @return the node
	 */
	public SyWkfNodeBean getNode() {
		return node;
	}

	/**
	 * @param node
	 *            the node to set
	 */
	public void setNode(SyWkfNodeBean node) {
		this.node = node;
	}

	/**
	 * @return the wkfInfo
	 */
	public WKFContext getWkfInfo() {
		return wkfInfo;
	}

	/**
	 * @param wkfInfo
	 *            the wkfInfo to set
	 */
	public void setWkfInfo(WKFContext wkfInfo) {
		this.wkfInfo = wkfInfo;
	}

	/**
	 * @param schedule
	 * @param node
	 * @param wkfInfo
	 */
	public NodeEvent(SyWkfScheduleBean schedule, SyWkfNodeBean node, WKFContext wkfInfo) {
		this.schedule = schedule;
		this.node = node;
		this.wkfInfo = wkfInfo;
	}

}
