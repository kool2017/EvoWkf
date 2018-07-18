package com.kool.system.bean;

import java.util.HashMap;
import java.util.Map;
import com.kool.core.base.BaseBean;

/**
 * @AUTHOR LUYU
 */
public class SyUserAutBean extends BaseBean {
	protected String suaUserCid;
	protected boolean isInitSuaUserCid;
	protected String suaAutCode;
	protected boolean isInitSuaAutCode;
	protected String suaCmt;
	protected boolean isInitSuaCmt;

	public boolean getIsInitSuaUserCid() {
		return this.isInitSuaUserCid;
	}

	public boolean getIsInitSuaAutCode() {
		return this.isInitSuaAutCode;
	}

	public boolean getIsInitSuaCmt() {
		return this.isInitSuaCmt;
	}

	public String getSuaUserCid() {
		return suaUserCid;
	}

	public void setSuaUserCid(String suaUserCid) {
		this.suaUserCid = suaUserCid;
		this.isInitSuaUserCid = true;
	}

	public String getSuaAutCode() {
		return suaAutCode;
	}

	public void setSuaAutCode(String suaAutCode) {
		this.suaAutCode = suaAutCode;
		this.isInitSuaAutCode = true;
	}

	public String getSuaCmt() {
		return suaCmt;
	}

	public void setSuaCmt(String suaCmt) {
		this.suaCmt = suaCmt;
		this.isInitSuaCmt = true;
	}

	public Map<String, String> toMap() {
		Map<String, String> map = new HashMap<String, String>();
		if (isInitSuaUserCid) {
			map.put("suaUserCid", formatString(suaUserCid));
		}
		if (isInitSuaAutCode) {
			map.put("suaAutCode", formatString(suaAutCode));
		}
		if (isInitSuaCmt) {
			map.put("suaCmt", formatString(suaCmt));
		}

		return map;
	}

	public static SyUserAutBean DBResultToBean(Map<String, Object> map) {
		if (null == map) {
			return null;
		}
		SyUserAutBean reqDef = new SyUserAutBean();
		reqDef.setSuaUserCid((String) map.get("SUA_USER_CID"));
		reqDef.setSuaAutCode((String) map.get("SUA_AUT_CODE"));
		reqDef.setSuaCmt((String) map.get("SUA_CMT"));
		return reqDef;
	}
}