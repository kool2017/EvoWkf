package com.kool.system.bean.io.aut;

import com.kool.core.base.BaseBean;
import com.kool.core.exception.AppException;
import com.kool.core.util.StringUtils;
import com.kool.core.validate.IIoValidate;

/**
 * @AUTHOR LUYU
 */
public class SYAUTINFYBean extends BaseBean implements IIoValidate {
	protected String autCode;
	protected String type;
	protected String name;
	protected String state;

	public String getAutCode() {
		return autCode;
	}

	public void setAutCode(String autCode) {
		this.autCode = autCode;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public void validate() throws AppException {
		//非空校验
		if (StringUtils.isEmpty(autCode)) {
			throw new AppException("SY000036","autCode");//字段[%1]为空
		}
		//最小长度校验
		if (autCode != null && autCode.length()<8) {
			throw new AppException("SY000037","autCode",String.valueOf(8));//字段[%1]小于最小长度[%2]
		}
		//最大长度校验
		if (autCode != null && autCode.length()>8) {
			throw new AppException("SY000038","autCode",String.valueOf(8));//字段[%1]大于最大长度[%2]
		}
		//非空校验
		if (StringUtils.isEmpty(type)) {
			throw new AppException("SY000036","type");//字段[%1]为空
		}
		//非空校验
		if (StringUtils.isEmpty(name)) {
			throw new AppException("SY000036","name");//字段[%1]为空
		}
		//最大长度校验
		if (name != null && name.length()>60) {
			throw new AppException("SY000038","name",String.valueOf(60));//字段[%1]大于最大长度[%2]
		}
		//非空校验
		if (StringUtils.isEmpty(state)) {
			throw new AppException("SY000036","state");//字段[%1]为空
		}
	}
}