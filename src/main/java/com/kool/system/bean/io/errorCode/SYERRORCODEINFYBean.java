package com.kool.system.bean.io.errorCode;

import com.kool.core.base.BaseBean;
import com.kool.core.exception.AppException;
import com.kool.core.util.StringUtils;
import com.kool.core.validate.IIoValidate;

/**
 * @AUTHOR LUYU
 */
public class SYERRORCODEINFYBean extends BaseBean implements IIoValidate {
	protected String errorCode;
	protected String chnMsg;
	protected String engMsg;

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getChnMsg() {
		return chnMsg;
	}

	public void setChnMsg(String chnMsg) {
		this.chnMsg = chnMsg;
	}

	public String getEngMsg() {
		return engMsg;
	}

	public void setEngMsg(String engMsg) {
		this.engMsg = engMsg;
	}

	@Override
	public void validate() throws AppException {
		//非空校验
		if (StringUtils.isEmpty(errorCode)) {
			throw new AppException("SY000036","errorCode");//字段[%1]为空
		}
		// 最小长度校验
		if (errorCode != null && errorCode.length() < 8) {
			throw new AppException("SY000037","errorCode",String.valueOf(8));//字段[%1]小于最小长度[%2]
		}
		// 最大长度校验
		if (errorCode != null && errorCode.length() > 8) {
			throw new AppException("SY000038","errorCode",String.valueOf(8));//字段[%1]大于最大长度[%2]
		}
		// 最大长度校验
		if (chnMsg != null && chnMsg.length() > 100) {
			throw new AppException("SY000038","chnMsg",String.valueOf(100));//字段[%1]大于最大长度[%2]
		}
		// 最大长度校验
		if (engMsg != null && engMsg.length() > 100) {
			throw new AppException("SY000038","engMsg",String.valueOf(100));//字段[%1]大于最大长度[%2]
		}
	}
}