package com.kool.system.bean.io.roleGroup;

import com.kool.core.base.BaseBean;
import com.kool.core.exception.AppException;
import com.kool.core.util.StringUtils;
import com.kool.core.validate.IIoValidate;

/**
 * @AUTHOR LUYU
 */
public class SYROLEGROUPINFYBean extends BaseBean implements IIoValidate {
	protected String groupCode;
	protected String name;
	protected String state;

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
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
		// 非空校验
		if (StringUtils.isEmpty(groupCode)) {
			throw new AppException("SY000036", "groupCode");// 字段[%1]为空
		}
		// 最大长度校验
		if (groupCode != null && groupCode.length() > 6) {
			throw new AppException("SY000038", "groupCode", String.valueOf(6));// 字段[%1]大于最大长度[%2]
		}
		// 非空校验
		if (StringUtils.isEmpty(name)) {
			throw new AppException("SY000036", "name");// 字段[%1]为空
		}
		// 最大长度校验
		if (name != null && name.length() > 60) {
			throw new AppException("SY000038", "name", String.valueOf(60));// 字段[%1]大于最大长度[%2]
		}
		// 非空校验
		if (StringUtils.isEmpty(state)) {
			throw new AppException("SY000036", "state");// 字段[%1]为空
		}
	}
}