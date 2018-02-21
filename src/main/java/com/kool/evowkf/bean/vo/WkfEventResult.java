/**
 * @PROJECT 
 * @DATE 2018年2月17日 下午9:06:24
 * @AUTHOR LUYU
 */
package com.kool.evowkf.bean.vo;

import com.kool.core.base.BaseBean;

/**
 * @DESCRIBE
 * @AUTHOR LUYU
 * @DATE 2018年2月17日 下午9:06:24
 *
 */
public class WkfEventResult extends BaseBean {
	private Boolean forward;
	private String eventFlag;
	private String eventDsp;

	/**
	 * @return the forward
	 */
	public Boolean getForward() {
		return forward;
	}

	/**
	 * @param forward
	 *            the forward to set
	 */
	public void setForward(Boolean forward) {
		this.forward = forward;
	}

	/**
	 * @return the eventFlag
	 */
	public String getEventFlag() {
		return eventFlag;
	}

	/**
	 * @param eventFlag
	 *            the eventFlag to set
	 */
	public void setEventFlag(String eventFlag) {
		this.eventFlag = eventFlag;
	}

	/**
	 * @return the eventDsp
	 */
	public String getEventDsp() {
		return eventDsp;
	}

	/**
	 * @param eventDsp
	 *            the eventDsp to set
	 */
	public void setEventDsp(String eventDsp) {
		this.eventDsp = eventDsp;
	}

}
