/**
 * @PROJECT 
 * @DATE 2018年2月20日 上午10:01:27
 * @AUTHOR LUYU
 */
package com.kool.evowkf.bean.io;

import com.kool.core.base.BaseBean;

/**
 * @DESCRIBE
 * @AUTHOR LUYU
 * @DATE 2018年2月20日 上午10:01:27
 *
 */
public class SYCHECKXBean extends BaseBean {
	private String recordId;
	private String scheduleId;

	/**
	 * @return the recordId
	 */
	public String getRecordId() {
		return recordId;
	}

	/**
	 * @param recordId
	 *            the recordId to set
	 */
	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}

	/**
	 * @return the scheduleId
	 */
	public String getScheduleId() {
		return scheduleId;
	}

	/**
	 * @param scheduleId
	 *            the scheduleId to set
	 */
	public void setScheduleId(String scheduleId) {
		this.scheduleId = scheduleId;
	}

}
