package com.kool.evowkf.bean;

import java.util.HashMap;
import java.util.Map;
import com.kool.core.base.BaseBean;

public class SyWkfWorkerBean extends BaseBean {
	protected String swoWgCid;
	protected boolean isInitSwoWgCid;
	protected String swoUserCid;
	protected boolean isInitSwoUserCid;
	protected String swoLoginName;
	protected boolean isInitSwoLoginName;
	protected String swoUserState;
	protected boolean isInitSwoUserState;

	public boolean getIsInitSwoWgCid() {
		return this.isInitSwoWgCid;
	}

	public boolean getIsInitSwoUserCid() {
		return this.isInitSwoUserCid;
	}

	public boolean getIsInitSwoLoginName() {
		return this.isInitSwoLoginName;
	}

	public boolean getIsInitSwoUserState() {
		return this.isInitSwoUserState;
	}

	public String getSwoWgCid() {
		return swoWgCid;
	}

	public void setSwoWgCid(String swoWgCid) {
		this.swoWgCid = swoWgCid;
		this.isInitSwoWgCid = true;
	}

	public String getSwoUserCid() {
		return swoUserCid;
	}

	public void setSwoUserCid(String swoUserCid) {
		this.swoUserCid = swoUserCid;
		this.isInitSwoUserCid = true;
	}

	public String getSwoLoginName() {
		return swoLoginName;
	}

	public void setSwoLoginName(String swoLoginName) {
		this.swoLoginName = swoLoginName;
		this.isInitSwoLoginName = true;
	}

	public String getSwoUserState() {
		return swoUserState;
	}

	public void setSwoUserState(String swoUserState) {
		this.swoUserState = swoUserState;
		this.isInitSwoUserState = true;
	}

	public Map<String, String> toMap() {
		Map<String, String> map = new HashMap<String, String>();
		if (isInitSwoWgCid) {
			map.put("swoWgCid", formatString(swoWgCid));
		}
		if (isInitSwoUserCid) {
			map.put("swoUserCid", formatString(swoUserCid));
		}
		if (isInitSwoLoginName) {
			map.put("swoLoginName", formatString(swoLoginName));
		}
		if (isInitSwoUserState) {
			map.put("swoUserState", formatString(swoUserState));
		}

		return map;
	}
}
