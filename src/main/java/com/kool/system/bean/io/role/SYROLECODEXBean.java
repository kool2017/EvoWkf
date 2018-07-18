package com.kool.system.bean.io.role;

import com.kool.core.base.BaseBean;
import com.kool.core.exception.AppException;
import com.kool.core.util.StringUtils;
import com.kool.core.validate.IIoValidate;

/**
 * @AUTHOR LUYU
 */
public class SYROLECODEXBean extends BaseBean implements IIoValidate {
	protected String roleCode;

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	@Override
	public void validate() throws AppException {
		//非空校验
		if (StringUtils.isEmpty(roleCode)) {
			throw new AppException("SY000036","roleCode");//字段[%1]为空
		}
		//最大长度校验
		if (roleCode != null && roleCode.length()>6) {
			throw new AppException("SY000038","roleCode",String.valueOf(6));//字段[%1]大于最大长度[%2]
		}
	}
}