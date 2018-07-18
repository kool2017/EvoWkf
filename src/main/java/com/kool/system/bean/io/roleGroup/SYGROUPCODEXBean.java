package com.kool.system.bean.io.roleGroup;

import com.kool.core.base.BaseBean;
import com.kool.core.exception.AppException;
import com.kool.core.util.StringUtils;
import com.kool.core.validate.IIoValidate;

/**
 * @AUTHOR LUYU
 */
public class SYGROUPCODEXBean extends BaseBean implements IIoValidate {
	protected String groupCode;

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	@Override
	public void validate() throws AppException {
		//非空校验
		if (StringUtils.isEmpty(groupCode)) {
			throw new AppException("SY000036","groupCode");//字段[%1]为空
		}
		//最大长度校验
		if (groupCode != null && groupCode.length()>6) {
			throw new AppException("SY000038","groupCode",String.valueOf(6));//字段[%1]大于最大长度[%2]
		}
	}
}