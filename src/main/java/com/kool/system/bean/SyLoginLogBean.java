package com.kool.system.bean;

import java.util.HashMap;
import java.util.Map;
import com.kool.core.base.BaseBean;

/**
 * @AUTHOR LUYU
 */
public class SyLoginLogBean extends BaseBean {
	protected String sllLogUid;
	protected boolean isInitSllLogUid;
	protected String sllUserCid;
	protected boolean isInitSllUserCid;
	protected java.sql.Timestamp sllTime;
	protected boolean isInitSllTime;
	protected String sllIp;
	protected boolean isInitSllIp;

	public boolean getIsInitSllLogUid() {
		return this.isInitSllLogUid;
	}

	public boolean getIsInitSllUserCid() {
		return this.isInitSllUserCid;
	}

	public boolean getIsInitSllTime() {
		return this.isInitSllTime;
	}

	public boolean getIsInitSllIp() {
		return this.isInitSllIp;
	}

	public String getSllLogUid() {
		return sllLogUid;
	}

	public void setSllLogUid(String sllLogUid) {
		this.sllLogUid = sllLogUid;
		this.isInitSllLogUid = true;
	}

	public String getSllUserCid() {
		return sllUserCid;
	}

	public void setSllUserCid(String sllUserCid) {
		this.sllUserCid = sllUserCid;
		this.isInitSllUserCid = true;
	}

	public java.sql.Timestamp getSllTime() {
		return sllTime;
	}

	public void setSllTime(java.sql.Timestamp sllTime) {
		this.sllTime = sllTime;
		this.isInitSllTime = true;
	}

	public String getSllIp() {
		return sllIp;
	}

	public void setSllIp(String sllIp) {
		this.sllIp = sllIp;
		this.isInitSllIp = true;
	}

	public Map<String, String> toMap() {
		Map<String, String> map = new HashMap<String, String>();
		if (isInitSllLogUid) {
			map.put("sllLogUid", formatString(sllLogUid));
		}
		if (isInitSllUserCid) {
			map.put("sllUserCid", formatString(sllUserCid));
		}
		if (isInitSllTime) {
			map.put("sllTime", formatString(sllTime));
		}
		if (isInitSllIp) {
			map.put("sllIp", formatString(sllIp));
		}

		return map;
	}

	public static SyLoginLogBean DBResultToBean(Map<String, Object> map) {
		if (null == map) {
			return null;
		}
		SyLoginLogBean reqDef = new SyLoginLogBean();
		reqDef.setSllLogUid((String) map.get("SLL_LOG_UID"));
		reqDef.setSllUserCid((String) map.get("SLL_USER_CID"));
		reqDef.setSllTime((java.sql.Timestamp) map.get("SLL_TIME"));
		reqDef.setSllIp((String) map.get("SLL_IP"));
		return reqDef;
	}
}