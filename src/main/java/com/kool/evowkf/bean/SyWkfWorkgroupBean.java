package com.kool.evowkf.bean;

import java.util.HashMap;
import java.util.Map;
import com.kool.core.base.BaseBean;

public class SyWkfWorkgroupBean extends BaseBean {
	protected String swwWgId;
	protected boolean isInitSwwWgId;
	protected String swwWgName;
	protected boolean isInitSwwWgName;
	protected String swwWgType;
	protected boolean isInitSwwWgType;
	protected String swwWkfType;
	protected boolean isInitSwwWkfType;
	protected String swwWkfCode;
	protected boolean isInitSwwWkfCode;
	protected String swwEntityId;
	protected boolean isInitSwwEntityId;
	protected String swwBusType;
	protected boolean isInitSwwBusType;
	protected String swwWgStatus;
	protected boolean isInitSwwWgStatus;

	public boolean getIsInitSwwWgId() {
		return this.isInitSwwWgId;
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

	public boolean getIsInitSwwEntityId() {
		return this.isInitSwwEntityId;
	}

	public boolean getIsInitSwwBusType() {
		return this.isInitSwwBusType;
	}

	public boolean getIsInitSwwWgStatus() {
		return this.isInitSwwWgStatus;
	}

	public String getSwwWgId() {
		return swwWgId;
	}

	public void setSwwWgId(String swwWgId) {
		this.swwWgId = swwWgId;
		this.isInitSwwWgId = true;
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

	public String getSwwEntityId() {
		return swwEntityId;
	}

	public void setSwwEntityId(String swwEntityId) {
		this.swwEntityId = swwEntityId;
		this.isInitSwwEntityId = true;
	}

	public String getSwwBusType() {
		return swwBusType;
	}

	public void setSwwBusType(String swwBusType) {
		this.swwBusType = swwBusType;
		this.isInitSwwBusType = true;
	}

	public String getSwwWgStatus() {
		return swwWgStatus;
	}

	public void setSwwWgStatus(String swwWgStatus) {
		this.swwWgStatus = swwWgStatus;
		this.isInitSwwWgStatus = true;
	}

	public Map<String, String> toMap() {
		Map<String, String> map = new HashMap<String, String>();
		if (isInitSwwWgId) {
			map.put("swwWgId", formatString(swwWgId));
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
		if (isInitSwwEntityId) {
			map.put("swwEntityId", formatString(swwEntityId));
		}
		if (isInitSwwBusType) {
			map.put("swwBusType", formatString(swwBusType));
		}
		if (isInitSwwWgStatus) {
			map.put("swwWgStatus", formatString(swwWgStatus));
		}

		return map;
	}
}
