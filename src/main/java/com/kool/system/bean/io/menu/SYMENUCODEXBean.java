package com.kool.system.bean.io.menu;

import com.kool.core.base.BaseBean;
import com.kool.core.exception.AppException;
import com.kool.core.util.StringUtils;
import com.kool.core.validate.IIoValidate;

/**
 * @AUTHOR LUYU
 */
public class SYMENUCODEXBean extends BaseBean implements IIoValidate {
	protected String menuCode;

	public String getMenuCode() {
		return menuCode;
	}

	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}

	@Override
	public void validate() throws AppException {
		//非空校验
		if (StringUtils.isEmpty(menuCode)) {
			throw new AppException("SY000036","menuCode");//字段[%1]为空
		}
		//最大长度校验
		if (menuCode != null && menuCode.length()>8) {
			throw new AppException("SY000038","menuCode",String.valueOf(8));//字段[%1]大于最大长度[%2]
		}
	}
}