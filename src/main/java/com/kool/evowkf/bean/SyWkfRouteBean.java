package com.kool.evowkf.bean;

import java.util.HashMap;
import java.util.Map;
import com.kool.core.base.BaseBean;

public class SyWkfRouteBean extends BaseBean {
	protected String swrRouteId;
	protected boolean isInitSwrRouteId;
	protected String swrEntityId;
	protected boolean isInitSwrEntityId;
	protected String swrRouteCode;
	protected boolean isInitSwrRouteCode;
	protected String swrNodeHead;
	protected boolean isInitSwrNodeHead;
	protected String swrNodeHeadName;
	protected boolean isInitSwrNodeHeadName;
	protected String swrNodeTail;
	protected boolean isInitSwrNodeTail;
	protected String swrNodeTailName;
	protected boolean isInitSwrNodeTailName;
	protected String swrRouteStatus;
	protected boolean isInitSwrRouteStatus;

	public boolean getIsInitSwrRouteId() {
		return this.isInitSwrRouteId;
	}

	public boolean getIsInitSwrEntityId() {
		return this.isInitSwrEntityId;
	}

	public boolean getIsInitSwrRouteCode() {
		return this.isInitSwrRouteCode;
	}

	public boolean getIsInitSwrNodeHead() {
		return this.isInitSwrNodeHead;
	}

	public boolean getIsInitSwrNodeHeadName() {
		return this.isInitSwrNodeHeadName;
	}

	public boolean getIsInitSwrNodeTail() {
		return this.isInitSwrNodeTail;
	}

	public boolean getIsInitSwrNodeTailName() {
		return this.isInitSwrNodeTailName;
	}

	public boolean getIsInitSwrRouteStatus() {
		return this.isInitSwrRouteStatus;
	}

	public String getSwrRouteId() {
		return swrRouteId;
	}

	public void setSwrRouteId(String swrRouteId) {
		this.swrRouteId = swrRouteId;
		this.isInitSwrRouteId = true;
	}

	public String getSwrEntityId() {
		return swrEntityId;
	}

	public void setSwrEntityId(String swrEntityId) {
		this.swrEntityId = swrEntityId;
		this.isInitSwrEntityId = true;
	}

	public String getSwrRouteCode() {
		return swrRouteCode;
	}

	public void setSwrRouteCode(String swrRouteCode) {
		this.swrRouteCode = swrRouteCode;
		this.isInitSwrRouteCode = true;
	}

	public String getSwrNodeHead() {
		return swrNodeHead;
	}

	public void setSwrNodeHead(String swrNodeHead) {
		this.swrNodeHead = swrNodeHead;
		this.isInitSwrNodeHead = true;
	}

	public String getSwrNodeHeadName() {
		return swrNodeHeadName;
	}

	public void setSwrNodeHeadName(String swrNodeHeadName) {
		this.swrNodeHeadName = swrNodeHeadName;
		this.isInitSwrNodeHeadName = true;
	}

	public String getSwrNodeTail() {
		return swrNodeTail;
	}

	public void setSwrNodeTail(String swrNodeTail) {
		this.swrNodeTail = swrNodeTail;
		this.isInitSwrNodeTail = true;
	}

	public String getSwrNodeTailName() {
		return swrNodeTailName;
	}

	public void setSwrNodeTailName(String swrNodeTailName) {
		this.swrNodeTailName = swrNodeTailName;
		this.isInitSwrNodeTailName = true;
	}

	public String getSwrRouteStatus() {
		return swrRouteStatus;
	}

	public void setSwrRouteStatus(String swrRouteStatus) {
		this.swrRouteStatus = swrRouteStatus;
		this.isInitSwrRouteStatus = true;
	}

	public Map<String, String> toMap() {
		Map<String, String> map = new HashMap<String, String>();
		if (isInitSwrRouteId) {
			map.put("swrRouteId", formatString(swrRouteId));
		}
		if (isInitSwrEntityId) {
			map.put("swrEntityId", formatString(swrEntityId));
		}
		if (isInitSwrRouteCode) {
			map.put("swrRouteCode", formatString(swrRouteCode));
		}
		if (isInitSwrNodeHead) {
			map.put("swrNodeHead", formatString(swrNodeHead));
		}
		if (isInitSwrNodeHeadName) {
			map.put("swrNodeHeadName", formatString(swrNodeHeadName));
		}
		if (isInitSwrNodeTail) {
			map.put("swrNodeTail", formatString(swrNodeTail));
		}
		if (isInitSwrNodeTailName) {
			map.put("swrNodeTailName", formatString(swrNodeTailName));
		}
		if (isInitSwrRouteStatus) {
			map.put("swrRouteStatus", formatString(swrRouteStatus));
		}

		return map;
	}
}
