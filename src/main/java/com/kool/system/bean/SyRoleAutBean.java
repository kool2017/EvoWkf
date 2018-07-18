package com.kool.system.bean;

import java.util.HashMap;
import java.util.Map;
import com.kool.core.base.BaseBean;

/**
 * @AUTHOR LUYU
 */
public class SyRoleAutBean extends BaseBean {
	protected String sraRoleCode;
	protected boolean isInitSraRoleCode;
	protected String sraAutCode;
	protected boolean isInitSraAutCode;
	protected String sraCmt;
	protected boolean isInitSraCmt;

	public boolean getIsInitSraRoleCode() {
		return this.isInitSraRoleCode;
	}

	public boolean getIsInitSraAutCode() {
		return this.isInitSraAutCode;
	}

	public boolean getIsInitSraCmt() {
		return this.isInitSraCmt;
	}

	public String getSraRoleCode() {
		return sraRoleCode;
	}

	public void setSraRoleCode(String sraRoleCode) {
		this.sraRoleCode = sraRoleCode;
		this.isInitSraRoleCode = true;
	}

	public String getSraAutCode() {
		return sraAutCode;
	}

	public void setSraAutCode(String sraAutCode) {
		this.sraAutCode = sraAutCode;
		this.isInitSraAutCode = true;
	}

	public String getSraCmt() {
		return sraCmt;
	}

	public void setSraCmt(String sraCmt) {
		this.sraCmt = sraCmt;
		this.isInitSraCmt = true;
	}

	public Map<String, String> toMap() {
		Map<String, String> map = new HashMap<String, String>();
		if (isInitSraRoleCode) {
			map.put("sraRoleCode", formatString(sraRoleCode));
		}
		if (isInitSraAutCode) {
			map.put("sraAutCode", formatString(sraAutCode));
		}
		if (isInitSraCmt) {
			map.put("sraCmt", formatString(sraCmt));
		}

		return map;
	}

	public static SyRoleAutBean DBResultToBean(Map<String, Object> map) {
		if (null == map) {
			return null;
		}
		SyRoleAutBean reqDef = new SyRoleAutBean();
		reqDef.setSraRoleCode((String) map.get("SRA_ROLE_CODE"));
		reqDef.setSraAutCode((String) map.get("SRA_AUT_CODE"));
		reqDef.setSraCmt((String) map.get("SRA_CMT"));
		return reqDef;
	}
}