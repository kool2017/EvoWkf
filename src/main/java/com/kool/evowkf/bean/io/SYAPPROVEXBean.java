/**
 * @PROJECT 
 * @DATE 2018年2月19日 下午2:58:24
 * @AUTHOR LUYU
 */
package com.kool.evowkf.bean.io;

import com.kool.core.base.BaseBean;

/**
 * @DESCRIBE
 * @AUTHOR LUYU
 * @DATE 2018年2月19日 下午2:58:24
 *
 */
public class SYAPPROVEXBean extends BaseBean {
	private String recordId;
	private String scheduleId;
	private String approveFlag;
	private String dsp;

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

	/**
	 * @return the approveFlag
	 */
	public String getApproveFlag() {
		return approveFlag;
	}

	/**
	 * @param approveFlag
	 *            the approveFlag to set
	 */
	public void setApproveFlag(String approveFlag) {
		this.approveFlag = approveFlag;
	}

	/**
	 * @return the dsp
	 */
	public String getDsp() {
		return dsp;
	}

	/**
	 * @param dsp
	 *            the dsp to set
	 */
	public void setDsp(String dsp) {
		this.dsp = dsp;
	}

}
