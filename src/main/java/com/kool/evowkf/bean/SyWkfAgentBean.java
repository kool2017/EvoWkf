package com.kool.evowkf.bean;

import java.util.HashMap;
import java.util.Map;
import com.kool.core.base.BaseBean;

public class SyWkfAgentBean extends BaseBean {
	protected String swaUserId;
	protected boolean isInitSwaUserId;
	protected String swaLoginName;
	protected boolean isInitSwaLoginName;
	protected String swaAgentUserId;
	protected boolean isInitSwaAgentUserId;
	protected String swaAgentLoginName;
	protected boolean isInitSwaAgentLoginName;
	protected String swaAgentStatus;
	protected boolean isInitSwaAgentStatus;

	public boolean getIsInitSwaUserId() {
		return this.isInitSwaUserId;
	}

	public boolean getIsInitSwaLoginName() {
		return this.isInitSwaLoginName;
	}

	public boolean getIsInitSwaAgentUserId() {
		return this.isInitSwaAgentUserId;
	}

	public boolean getIsInitSwaAgentLoginName() {
		return this.isInitSwaAgentLoginName;
	}

	public boolean getIsInitSwaAgentStatus() {
		return this.isInitSwaAgentStatus;
	}

	public String getSwaUserId() {
		return swaUserId;
	}

	public void setSwaUserId(String swaUserId) {
		this.swaUserId = swaUserId;
		this.isInitSwaUserId = true;
	}

	public String getSwaLoginName() {
		return swaLoginName;
	}

	public void setSwaLoginName(String swaLoginName) {
		this.swaLoginName = swaLoginName;
		this.isInitSwaLoginName = true;
	}

	public String getSwaAgentUserId() {
		return swaAgentUserId;
	}

	public void setSwaAgentUserId(String swaAgentUserId) {
		this.swaAgentUserId = swaAgentUserId;
		this.isInitSwaAgentUserId = true;
	}

	public String getSwaAgentLoginName() {
		return swaAgentLoginName;
	}

	public void setSwaAgentLoginName(String swaAgentLoginName) {
		this.swaAgentLoginName = swaAgentLoginName;
		this.isInitSwaAgentLoginName = true;
	}

	public String getSwaAgentStatus() {
		return swaAgentStatus;
	}

	public void setSwaAgentStatus(String swaAgentStatus) {
		this.swaAgentStatus = swaAgentStatus;
		this.isInitSwaAgentStatus = true;
	}

	public Map<String, String> toMap() {
		Map<String, String> map = new HashMap<String, String>();
		if (isInitSwaUserId) {
			map.put("swaUserId", formatString(swaUserId));
		}
		if (isInitSwaLoginName) {
			map.put("swaLoginName", formatString(swaLoginName));
		}
		if (isInitSwaAgentUserId) {
			map.put("swaAgentUserId", formatString(swaAgentUserId));
		}
		if (isInitSwaAgentLoginName) {
			map.put("swaAgentLoginName", formatString(swaAgentLoginName));
		}
		if (isInitSwaAgentStatus) {
			map.put("swaAgentStatus", formatString(swaAgentStatus));
		}

		return map;
	}
}
