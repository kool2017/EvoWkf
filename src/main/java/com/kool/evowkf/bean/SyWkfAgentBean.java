package com.kool.evowkf.bean;

import java.util.HashMap;
import java.util.Map;
import com.kool.core.base.BaseBean;

public class SyWkfAgentBean extends BaseBean {
	protected String swaUserCid;
	protected boolean isInitSwaUserCid;
	protected String swaLoginName;
	protected boolean isInitSwaLoginName;
	protected String swaAgentUserCid;
	protected boolean isInitSwaAgentUserCid;
	protected String swaAgentLoginName;
	protected boolean isInitSwaAgentLoginName;
	protected String swaState;
	protected boolean isInitSwaState;

	public boolean getIsInitSwaUserCid() {
		return this.isInitSwaUserCid;
	}

	public boolean getIsInitSwaLoginName() {
		return this.isInitSwaLoginName;
	}

	public boolean getIsInitSwaAgentUserCid() {
		return this.isInitSwaAgentUserCid;
	}

	public boolean getIsInitSwaAgentLoginName() {
		return this.isInitSwaAgentLoginName;
	}

	public boolean getIsInitSwaState() {
		return this.isInitSwaState;
	}

	public String getSwaUserCid() {
		return swaUserCid;
	}

	public void setSwaUserCid(String swaUserCid) {
		this.swaUserCid = swaUserCid;
		this.isInitSwaUserCid = true;
	}

	public String getSwaLoginName() {
		return swaLoginName;
	}

	public void setSwaLoginName(String swaLoginName) {
		this.swaLoginName = swaLoginName;
		this.isInitSwaLoginName = true;
	}

	public String getSwaAgentUserCid() {
		return swaAgentUserCid;
	}

	public void setSwaAgentUserCid(String swaAgentUserCid) {
		this.swaAgentUserCid = swaAgentUserCid;
		this.isInitSwaAgentUserCid = true;
	}

	public String getSwaAgentLoginName() {
		return swaAgentLoginName;
	}

	public void setSwaAgentLoginName(String swaAgentLoginName) {
		this.swaAgentLoginName = swaAgentLoginName;
		this.isInitSwaAgentLoginName = true;
	}

	public String getSwaState() {
		return swaState;
	}

	public void setSwaState(String swaState) {
		this.swaState = swaState;
		this.isInitSwaState = true;
	}

	public Map<String, String> toMap() {
		Map<String, String> map = new HashMap<String, String>();
		if (isInitSwaUserCid) {
			map.put("swaUserCid", formatString(swaUserCid));
		}
		if (isInitSwaLoginName) {
			map.put("swaLoginName", formatString(swaLoginName));
		}
		if (isInitSwaAgentUserCid) {
			map.put("swaAgentUserCid", formatString(swaAgentUserCid));
		}
		if (isInitSwaAgentLoginName) {
			map.put("swaAgentLoginName", formatString(swaAgentLoginName));
		}
		if (isInitSwaState) {
			map.put("swaState", formatString(swaState));
		}

		return map;
	}
}
