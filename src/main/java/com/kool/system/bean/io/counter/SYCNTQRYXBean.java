package com.kool.system.bean.io.counter;

import com.kool.core.base.BaseBean;
import com.kool.core.exception.AppException;
import com.kool.core.validate.IIoValidate;

/**
 * @AUTHOR LUYU
 */
public class SYCNTQRYXBean extends BaseBean implements IIoValidate {
	protected String counterCode;

	public String getCounterCode() {
		return counterCode;
	}

	public void setCounterCode(String counterCode) {
		this.counterCode = counterCode;
	}

	@Override
	public void validate() throws AppException {
		//最小长度校验
		if (counterCode != null && counterCode.length()<8) {
			throw new AppException("SY000037","counterCode",String.valueOf(8));//字段[%1]小于最小长度[%2]
		}
		//最大长度校验
		if (counterCode != null && counterCode.length()>8) {
			throw new AppException("SY000038","counterCode",String.valueOf(8));//字段[%1]大于最大长度[%2]
		}
	}
}