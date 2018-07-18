package com.kool.system.bean;

import java.util.HashMap;
import java.util.Map;
import com.kool.core.base.BaseBean;

/**
 * @AUTHOR LUYU
 */
public class SyRoleGroupBean extends BaseBean {
	protected String srgGroupCode;
	protected boolean isInitSrgGroupCode;
	protected String srgName;
	protected boolean isInitSrgName;
	protected String srgState;
	protected boolean isInitSrgState;

	public boolean getIsInitSrgGroupCode() {
		return this.isInitSrgGroupCode;
	}

	public boolean getIsInitSrgName() {
		return this.isInitSrgName;
	}

	public boolean getIsInitSrgState() {
		return this.isInitSrgState;
	}

	public String getSrgGroupCode() {
		return srgGroupCode;
	}

	public void setSrgGroupCode(String srgGroupCode) {
		this.srgGroupCode = srgGroupCode;
		this.isInitSrgGroupCode = true;
	}

	public String getSrgName() {
		return srgName;
	}

	public void setSrgName(String srgName) {
		this.srgName = srgName;
		this.isInitSrgName = true;
	}

	public String getSrgState() {
		return srgState;
	}

	public void setSrgState(String srgState) {
		this.srgState = srgState;
		this.isInitSrgState = true;
	}

	public Map<String, String> toMap() {
		Map<String, String> map = new HashMap<String, String>();
		if (isInitSrgGroupCode) {
			map.put("srgGroupCode", formatString(srgGroupCode));
		}
		if (isInitSrgName) {
			map.put("srgName", formatString(srgName));
		}
		if (isInitSrgState) {
			map.put("srgState", formatString(srgState));
		}

		return map;
	}

	public static SyRoleGroupBean DBResultToBean(Map<String, Object> map) {
		if (null == map) {
			return null;
		}
		SyRoleGroupBean reqDef = new SyRoleGroupBean();
		reqDef.setSrgGroupCode((String) map.get("SRG_GROUP_CODE"));
		reqDef.setSrgName((String) map.get("SRG_NAME"));
		reqDef.setSrgState((String) map.get("SRG_STATE"));
		return reqDef;
	}
}