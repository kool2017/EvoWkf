package com.kool.evowkf.bean;

import java.util.HashMap;
import java.util.Map;
import com.kool.core.base.BaseBean;

public class SyWkfDefineBean extends BaseBean {
	protected String swdWkfCode;
	protected boolean isInitSwdWkfCode;
	protected String swdWkfName;
	protected boolean isInitSwdWkfName;
	protected String swdWkfType;
	protected boolean isInitSwdWkfType;
	protected String swdRouteType;
	protected boolean isInitSwdRouteType;
	protected String swdCheckFlag;
	protected boolean isInitSwdCheckFlag;
	protected String swdState;
	protected boolean isInitSwdState;

	public boolean getIsInitSwdWkfCode() {
		return this.isInitSwdWkfCode;
	}

	public boolean getIsInitSwdWkfName() {
		return this.isInitSwdWkfName;
	}

	public boolean getIsInitSwdWkfType() {
		return this.isInitSwdWkfType;
	}

	public boolean getIsInitSwdRouteType() {
		return this.isInitSwdRouteType;
	}

	public boolean getIsInitSwdCheckFlag() {
		return this.isInitSwdCheckFlag;
	}

	public boolean getIsInitSwdState() {
		return this.isInitSwdState;
	}

	public String getSwdWkfCode() {
		return swdWkfCode;
	}

	public void setSwdWkfCode(String swdWkfCode) {
		this.swdWkfCode = swdWkfCode;
		this.isInitSwdWkfCode = true;
	}

	public String getSwdWkfName() {
		return swdWkfName;
	}

	public void setSwdWkfName(String swdWkfName) {
		this.swdWkfName = swdWkfName;
		this.isInitSwdWkfName = true;
	}

	public String getSwdWkfType() {
		return swdWkfType;
	}

	public void setSwdWkfType(String swdWkfType) {
		this.swdWkfType = swdWkfType;
		this.isInitSwdWkfType = true;
	}

	public String getSwdRouteType() {
		return swdRouteType;
	}

	public void setSwdRouteType(String swdRouteType) {
		this.swdRouteType = swdRouteType;
		this.isInitSwdRouteType = true;
	}

	public String getSwdCheckFlag() {
		return swdCheckFlag;
	}

	public void setSwdCheckFlag(String swdCheckFlag) {
		this.swdCheckFlag = swdCheckFlag;
		this.isInitSwdCheckFlag = true;
	}

	public String getSwdState() {
		return swdState;
	}

	public void setSwdState(String swdState) {
		this.swdState = swdState;
		this.isInitSwdState = true;
	}

	public Map<String, String> toMap() {
		Map<String, String> map = new HashMap<String, String>();
		if (isInitSwdWkfCode) {
			map.put("swdWkfCode", formatString(swdWkfCode));
		}
		if (isInitSwdWkfName) {
			map.put("swdWkfName", formatString(swdWkfName));
		}
		if (isInitSwdWkfType) {
			map.put("swdWkfType", formatString(swdWkfType));
		}
		if (isInitSwdRouteType) {
			map.put("swdRouteType", formatString(swdRouteType));
		}
		if (isInitSwdCheckFlag) {
			map.put("swdCheckFlag", formatString(swdCheckFlag));
		}
		if (isInitSwdState) {
			map.put("swdState", formatString(swdState));
		}

		return map;
	}
}
