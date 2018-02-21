/**
 * @PROJECT 
 * @DATE 2018年2月17日 下午9:31:02
 * @AUTHOR LUYU
 */
package com.kool.evowkf.bean.vo;

import java.util.List;

import com.kool.core.base.BaseBean;
import com.kool.evowkf.bean.SyWkfScheduleBean;

/**
 * @DESCRIBE
 * @AUTHOR LUYU
 * @DATE 2018年2月17日 下午9:31:02
 *
 */
public class RouteResult extends BaseBean {
	private List<SyWkfScheduleBean> nextSchedules;
	private String recordStatus;

	/**
	 * @return the nextSchedules
	 */
	public List<SyWkfScheduleBean> getNextSchedules() {
		return nextSchedules;
	}

	/**
	 * @param nextSchedules
	 *            the nextSchedules to set
	 */
	public void setNextSchedules(List<SyWkfScheduleBean> nextSchedules) {
		this.nextSchedules = nextSchedules;
	}

	/**
	 * @return the recordStatus
	 */
	public String getRecordStatus() {
		return recordStatus;
	}

	/**
	 * @param recordStatus
	 *            the recordStatus to set
	 */
	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}

}
