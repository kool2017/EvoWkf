package com.kool.system.bean;

import java.util.HashMap;
import java.util.Map;
import com.kool.core.base.BaseBean;

/**
 * @AUTHOR LUYU
 */
public class SyRoleGroupAutBean extends BaseBean {
	protected String sgaGroupCode;
	protected boolean isInitSgaGroupCode;
	protected String sgaAutCode;
	protected boolean isInitSgaAutCode;
	protected String sgaCmt;
	protected boolean isInitSgaCmt;

	public boolean getIsInitSgaGroupCode() {
		return this.isInitSgaGroupCode;
	}

	public boolean getIsInitSgaAutCode() {
		return this.isInitSgaAutCode;
	}

	public boolean getIsInitSgaCmt() {
		return this.isInitSgaCmt;
	}

	public String getSgaGroupCode() {
		return sgaGroupCode;
	}

	public void setSgaGroupCode(String sgaGroupCode) {
		this.sgaGroupCode = sgaGroupCode;
		this.isInitSgaGroupCode = true;
	}

	public String getSgaAutCode() {
		return sgaAutCode;
	}

	public void setSgaAutCode(String sgaAutCode) {
		this.sgaAutCode = sgaAutCode;
		this.isInitSgaAutCode = true;
	}

	public String getSgaCmt() {
		return sgaCmt;
	}

	public void setSgaCmt(String sgaCmt) {
		this.sgaCmt = sgaCmt;
		this.isInitSgaCmt = true;
	}

	public Map<String, String> toMap() {
		Map<String, String> map = new HashMap<String, String>();
		if (isInitSgaGroupCode) {
			map.put("sgaGroupCode", formatString(sgaGroupCode));
		}
		if (isInitSgaAutCode) {
			map.put("sgaAutCode", formatString(sgaAutCode));
		}
		if (isInitSgaCmt) {
			map.put("sgaCmt", formatString(sgaCmt));
		}

		return map;
	}

	public static SyRoleGroupAutBean DBResultToBean(Map<String, Object> map) {
		if (null == map) {
			return null;
		}
		SyRoleGroupAutBean reqDef = new SyRoleGroupAutBean();
		reqDef.setSgaGroupCode((String) map.get("SGA_GROUP_CODE"));
		reqDef.setSgaAutCode((String) map.get("SGA_AUT_CODE"));
		reqDef.setSgaCmt((String) map.get("SGA_CMT"));
		return reqDef;
	}
}