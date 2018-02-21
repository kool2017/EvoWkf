/**
 * @PROJECT 
 * @DATE 2018年2月19日 下午12:01:22
 * @AUTHOR LUYU
 */
package com.kool.evowkf.bean.io;

import com.kool.core.base.BaseBean;

/**
 * @DESCRIBE
 * @AUTHOR LUYU
 * @DATE 2018年2月19日 下午12:01:22
 *
 */
public class SYSCHEDULEXBean extends BaseBean {
	private String recordId;
	private String businessType;

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
	 * @return the businessType
	 */
	public String getBusinessType() {
		return businessType;
	}

	/**
	 * @param businessType
	 *            the businessType to set
	 */
	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

}
