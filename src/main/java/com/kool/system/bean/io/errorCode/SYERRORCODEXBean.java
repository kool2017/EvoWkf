package com.kool.system.bean.io.errorCode;

import com.kool.core.base.BaseBean;
import com.kool.core.exception.AppException;
import com.kool.core.util.StringUtils;
import com.kool.core.validate.IIoValidate;

/**
 * @AUTHOR LUYU
 */
public class SYERRORCODEXBean extends BaseBean implements IIoValidate {
	protected String errorCode;

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	@Override
	public void validate() throws AppException {
		//非空校验
		if (StringUtils.isEmpty(errorCode)) {
			throw new AppException("SY000036","errorCode");//字段[%1]为空
		}
		// 最大长度校验
		if (errorCode != null && errorCode.length() > 8) {
			throw new AppException("SY000038","errorCode",String.valueOf(8));//字段[%1]大于最大长度[%2]
		}
	}
}