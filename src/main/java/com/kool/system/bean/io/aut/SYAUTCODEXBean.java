package com.kool.system.bean.io.aut;

import com.kool.core.base.BaseBean;
import com.kool.core.exception.AppException;
import com.kool.core.util.StringUtils;
import com.kool.core.validate.IIoValidate;

/**
 * @AUTHOR LUYU
 */
public class SYAUTCODEXBean extends BaseBean implements IIoValidate {
	protected String autCode;

	public String getAutCode() {
		return autCode;
	}

	public void setAutCode(String autCode) {
		this.autCode = autCode;
	}

	@Override
	public void validate() throws AppException {
		//非空校验
		if (StringUtils.isEmpty(autCode)) {
			throw new AppException("SY000036","autCode");//字段[%1]为空
		}
		//最大长度校验
		if (autCode != null && autCode.length()>8) {
			throw new AppException("SY000038","autCode",String.valueOf(8));//字段[%1]大于最大长度[%2]
		}
	}
}