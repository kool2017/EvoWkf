/**
 * @PROJECT 
 * @DATE 2018年2月18日 下午8:27:06
 * @AUTHOR LUYU
 */
package com.kool.evowkf.bean.vo;

import com.kool.core.base.BaseBean;

/**
 * @DESCRIBE
 * @AUTHOR LUYU
 * @DATE 2018年2月18日 下午8:27:06
 *
 */
public class BusinessEvent extends BaseBean {
	// 关联业务流水号
	private String businessId;
	// 关联业务类型
	private String businessType;
	// 用户号
	private String userId;
	// 登录名
	private String loginName;
	// 流程概要描述、事件摘要
	private String description;
	// 执行记录编号
	private String recordId;

	// 审批标志
	private String approveFlag;
	// 复核标志
	private String checkFlag;

	// 业务数据
	private BusinessValue businessValue;
	// 附加数据
	private String extData;

	/**
	 * @return the businessId
	 */
	public String getBusinessId() {
		return businessId;
	}

	/**
	 * @param businessId
	 *            the businessId to set
	 */
	public void setBusinessId(String businessId) {
		this.businessId = businessId;
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

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the loginName
	 */
	public String getLoginName() {
		return loginName;
	}

	/**
	 * @param loginName
	 *            the loginName to set
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

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
	 * @return the checkFlag
	 */
	public String getCheckFlag() {
		return checkFlag;
	}

	/**
	 * @param checkFlag
	 *            the checkFlag to set
	 */
	public void setCheckFlag(String checkFlag) {
		this.checkFlag = checkFlag;
	}

	/**
	 * @return the businessValue
	 */
	public BusinessValue getBusinessValue() {
		return businessValue;
	}

	/**
	 * @param businessValue
	 *            the businessValue to set
	 */
	public void setBusinessValue(BusinessValue businessValue) {
		this.businessValue = businessValue;
	}

	/**
	 * @return the extData
	 */
	public String getExtData() {
		return extData;
	}

	/**
	 * @param extData
	 *            the extData to set
	 */
	public void setExtData(String extData) {
		this.extData = extData;
	}

}
