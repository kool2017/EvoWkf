package com.kool.system.bean;

import java.util.HashMap;
import java.util.Map;
import com.kool.core.base.BaseBean;

/**
 * @AUTHOR LUYU
 */
public class SyUserRoleBean extends BaseBean {
	protected String surUserCid;
	protected boolean isInitSurUserCid;
	protected String surRoleCode;
	protected boolean isInitSurRoleCode;
	protected String surCmt;
	protected boolean isInitSurCmt;

	public boolean getIsInitSurUserCid() {
		return this.isInitSurUserCid;
	}

	public boolean getIsInitSurRoleCode() {
		return this.isInitSurRoleCode;
	}

	public boolean getIsInitSurCmt() {
		return this.isInitSurCmt;
	}

	public String getSurUserCid() {
		return surUserCid;
	}

	public void setSurUserCid(String surUserCid) {
		this.surUserCid = surUserCid;
		this.isInitSurUserCid = true;
	}

	public String getSurRoleCode() {
		return surRoleCode;
	}

	public void setSurRoleCode(String surRoleCode) {
		this.surRoleCode = surRoleCode;
		this.isInitSurRoleCode = true;
	}

	public String getSurCmt() {
		return surCmt;
	}

	public void setSurCmt(String surCmt) {
		this.surCmt = surCmt;
		this.isInitSurCmt = true;
	}

	public Map<String, String> toMap() {
		Map<String, String> map = new HashMap<String, String>();
		if (isInitSurUserCid) {
			map.put("surUserCid", formatString(surUserCid));
		}
		if (isInitSurRoleCode) {
			map.put("surRoleCode", formatString(surRoleCode));
		}
		if (isInitSurCmt) {
			map.put("surCmt", formatString(surCmt));
		}

		return map;
	}

	public static SyUserRoleBean DBResultToBean(Map<String, Object> map) {
		if (null == map) {
			return null;
		}
		SyUserRoleBean reqDef = new SyUserRoleBean();
		reqDef.setSurUserCid((String) map.get("SUR_USER_CID"));
		reqDef.setSurRoleCode((String) map.get("SUR_ROLE_CODE"));
		reqDef.setSurCmt((String) map.get("SUR_CMT"));
		return reqDef;
	}
}