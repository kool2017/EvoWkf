package com.kool.system.bean.io.param;

import com.kool.core.base.BaseBean;
import com.kool.core.exception.AppException;
import com.kool.core.util.StringUtils;
import com.kool.core.validate.IIoValidate;

/**
 * @AUTHOR LUYU
 */
public class SYPAMCODEXBean extends BaseBean implements IIoValidate {
	protected String paramCode;

	public String getParamCode() {
		return paramCode;
	}

	public void setParamCode(String paramCode) {
		this.paramCode = paramCode;
	}

	@Override
	public void validate() throws AppException {
		//非空校验
		if (StringUtils.isEmpty(paramCode)) {
			throw new AppException("SY000036","paramCode");//字段[%1]为空
		}
		//最小长度校验
		if (paramCode != null && paramCode.length()<8) {
			throw new AppException("SY000037","paramCode",String.valueOf(8));//字段[%1]小于最小长度[%2]
		}
		//最大长度校验
		if (paramCode != null && paramCode.length()>8) {
			throw new AppException("SY000038","paramCode",String.valueOf(8));//字段[%1]大于最大长度[%2]
		}
	}
}