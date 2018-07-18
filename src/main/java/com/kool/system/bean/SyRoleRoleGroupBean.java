package com.kool.system.bean;

import java.util.HashMap;
import java.util.Map;
import com.kool.core.base.BaseBean;

/**
 * @AUTHOR LUYU
 */
public class SyRoleRoleGroupBean extends BaseBean {
	protected String srrRoleCode;
	protected boolean isInitSrrRoleCode;
	protected String srrGroupCode;
	protected boolean isInitSrrGroupCode;
	protected String srrCmt;
	protected boolean isInitSrrCmt;

	public boolean getIsInitSrrRoleCode() {
		return this.isInitSrrRoleCode;
	}

	public boolean getIsInitSrrGroupCode() {
		return this.isInitSrrGroupCode;
	}

	public boolean getIsInitSrrCmt() {
		return this.isInitSrrCmt;
	}

	public String getSrrRoleCode() {
		return srrRoleCode;
	}

	public void setSrrRoleCode(String srrRoleCode) {
		this.srrRoleCode = srrRoleCode;
		this.isInitSrrRoleCode = true;
	}

	public String getSrrGroupCode() {
		return srrGroupCode;
	}

	public void setSrrGroupCode(String srrGroupCode) {
		this.srrGroupCode = srrGroupCode;
		this.isInitSrrGroupCode = true;
	}

	public String getSrrCmt() {
		return srrCmt;
	}

	public void setSrrCmt(String srrCmt) {
		this.srrCmt = srrCmt;
		this.isInitSrrCmt = true;
	}

	public Map<String, String> toMap() {
		Map<String, String> map = new HashMap<String, String>();
		if (isInitSrrRoleCode) {
			map.put("srrRoleCode", formatString(srrRoleCode));
		}
		if (isInitSrrGroupCode) {
			map.put("srrGroupCode", formatString(srrGroupCode));
		}
		if (isInitSrrCmt) {
			map.put("srrCmt", formatString(srrCmt));
		}

		return map;
	}

	public static SyRoleRoleGroupBean DBResultToBean(Map<String, Object> map) {
		if (null == map) {
			return null;
		}
		SyRoleRoleGroupBean reqDef = new SyRoleRoleGroupBean();
		reqDef.setSrrRoleCode((String) map.get("SRR_ROLE_CODE"));
		reqDef.setSrrGroupCode((String) map.get("SRR_GROUP_CODE"));
		reqDef.setSrrCmt((String) map.get("SRR_CMT"));
		return reqDef;
	}
}