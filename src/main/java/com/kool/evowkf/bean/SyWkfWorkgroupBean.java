package com.kool.evowkf.bean;

import java.util.HashMap;
import java.util.Map;
import com.kool.core.base.BaseBean;

public class SyWkfWorkgroupBean extends BaseBean {
	protected String swwWgCid;
	protected boolean isInitSwwWgCid;
	protected String swwWgName;
	protected boolean isInitSwwWgName;
	protected String swwWgType;
	protected boolean isInitSwwWgType;
	protected String swwWkfType;
	protected boolean isInitSwwWkfType;
	protected String swwWkfCode;
	protected boolean isInitSwwWkfCode;
	protected String swwEntityCid;
	protected boolean isInitSwwEntityCid;
	protected String swwBusType;
	protected boolean isInitSwwBusType;
	protected String swwState;
	protected boolean isInitSwwState;

	public boolean getIsInitSwwWgCid() {
		return this.isInitSwwWgCid;
	}

	public boolean getIsInitSwwWgName() {
		return this.isInitSwwWgName;
	}

	public boolean getIsInitSwwWgType() {
		return this.isInitSwwWgType;
	}

	public boolean getIsInitSwwWkfType() {
		return this.isInitSwwWkfType;
	}

	public boolean getIsInitSwwWkfCode() {
		return this.isInitSwwWkfCode;
	}

	public boolean getIsInitSwwEntityCid() {
		return this.isInitSwwEntityCid;
	}

	public boolean getIsInitSwwBusType() {
		return this.isInitSwwBusType;
	}

	public boolean getIsInitSwwState() {
		return this.isInitSwwState;
	}

	public String getSwwWgCid() {
		return swwWgCid;
	}

	public void setSwwWgCid(String swwWgCid) {
		this.swwWgCid = swwWgCid;
		this.isInitSwwWgCid = true;
	}

	public String getSwwWgName() {
		return swwWgName;
	}

	public void setSwwWgName(String swwWgName) {
		this.swwWgName = swwWgName;
		this.isInitSwwWgName = true;
	}

	public String getSwwWgType() {
		return swwWgType;
	}

	public void setSwwWgType(String swwWgType) {
		this.swwWgType = swwWgType;
		this.isInitSwwWgType = true;
	}

	public String getSwwWkfType() {
		return swwWkfType;
	}

	public void setSwwWkfType(String swwWkfType) {
		this.swwWkfType = swwWkfType;
		this.isInitSwwWkfType = true;
	}

	public String getSwwWkfCode() {
		return swwWkfCode;
	}

	public void setSwwWkfCode(String swwWkfCode) {
		this.swwWkfCode = swwWkfCode;
		this.isInitSwwWkfCode = true;
	}

	public String getSwwEntityCid() {
		return swwEntityCid;
	}

	public void setSwwEntityCid(String swwEntityCid) {
		this.swwEntityCid = swwEntityCid;
		this.isInitSwwEntityCid = true;
	}

	public String getSwwBusType() {
		return swwBusType;
	}

	public void setSwwBusType(String swwBusType) {
		this.swwBusType = swwBusType;
		this.isInitSwwBusType = true;
	}

	public String getSwwState() {
		return swwState;
	}

	public void setSwwState(String swwState) {
		this.swwState = swwState;
		this.isInitSwwState = true;
	}

	public Map<String, String> toMap() {
		Map<String, String> map = new HashMap<String, String>();
		if (isInitSwwWgCid) {
			map.put("swwWgCid", formatString(swwWgCid));
		}
		if (isInitSwwWgName) {
			map.put("swwWgName", formatString(swwWgName));
		}
		if (isInitSwwWgType) {
			map.put("swwWgType", formatString(swwWgType));
		}
		if (isInitSwwWkfType) {
			map.put("swwWkfType", formatString(swwWkfType));
		}
		if (isInitSwwWkfCode) {
			map.put("swwWkfCode", formatString(swwWkfCode));
		}
		if (isInitSwwEntityCid) {
			map.put("swwEntityCid", formatString(swwEntityCid));
		}
		if (isInitSwwBusType) {
			map.put("swwBusType", formatString(swwBusType));
		}
		if (isInitSwwState) {
			map.put("swwState", formatString(swwState));
		}

		return map;
	}
}
