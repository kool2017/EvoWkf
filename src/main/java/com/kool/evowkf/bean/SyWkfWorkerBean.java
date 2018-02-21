package com.kool.evowkf.bean;

import java.util.HashMap;
import java.util.Map;
import com.kool.core.base.BaseBean;

public class SyWkfWorkerBean extends BaseBean {
	protected String swoWgId;
	protected boolean isInitSwoWgId;
	protected String swoUserId;
	protected boolean isInitSwoUserId;
	protected String swoLoginName;
	protected boolean isInitSwoLoginName;
	protected String swoUserStatus;
	protected boolean isInitSwoUserStatus;

	public boolean getIsInitSwoWgId() {
		return this.isInitSwoWgId;
	}

	public boolean getIsInitSwoUserId() {
		return this.isInitSwoUserId;
	}

	public boolean getIsInitSwoLoginName() {
		return this.isInitSwoLoginName;
	}

	public boolean getIsInitSwoUserStatus() {
		return this.isInitSwoUserStatus;
	}

	public String getSwoWgId() {
		return swoWgId;
	}

	public void setSwoWgId(String swoWgId) {
		this.swoWgId = swoWgId;
		this.isInitSwoWgId = true;
	}

	public String getSwoUserId() {
		return swoUserId;
	}

	public void setSwoUserId(String swoUserId) {
		this.swoUserId = swoUserId;
		this.isInitSwoUserId = true;
	}

	public String getSwoLoginName() {
		return swoLoginName;
	}

	public void setSwoLoginName(String swoLoginName) {
		this.swoLoginName = swoLoginName;
		this.isInitSwoLoginName = true;
	}

	public String getSwoUserStatus() {
		return swoUserStatus;
	}

	public void setSwoUserStatus(String swoUserStatus) {
		this.swoUserStatus = swoUserStatus;
		this.isInitSwoUserStatus = true;
	}

	public Map<String, String> toMap() {
		Map<String, String> map = new HashMap<String, String>();
		if (isInitSwoWgId) {
			map.put("swoWgId", formatString(swoWgId));
		}
		if (isInitSwoUserId) {
			map.put("swoUserId", formatString(swoUserId));
		}
		if (isInitSwoLoginName) {
			map.put("swoLoginName", formatString(swoLoginName));
		}
		if (isInitSwoUserStatus) {
			map.put("swoUserStatus", formatString(swoUserStatus));
		}

		return map;
	}
}
