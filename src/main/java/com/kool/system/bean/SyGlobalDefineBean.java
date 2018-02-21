package com.kool.system.bean;

import java.util.HashMap;
import java.util.Map;
import com.kool.core.base.BaseBean;

public class SyGlobalDefineBean extends BaseBean {
	protected String sgdField;
	protected boolean isInitSgdField;
	protected String sgdBusType;
	protected boolean isInitSgdBusType;
	protected String sgdValue;
	protected boolean isInitSgdValue;
	protected String sgdDsp;
	protected boolean isInitSgdDsp;

	public boolean getIsInitSgdField() {
		return this.isInitSgdField;
	}

	public boolean getIsInitSgdBusType() {
		return this.isInitSgdBusType;
	}

	public boolean getIsInitSgdValue() {
		return this.isInitSgdValue;
	}

	public boolean getIsInitSgdDsp() {
		return this.isInitSgdDsp;
	}

	public String getSgdField() {
		return sgdField;
	}

	public void setSgdField(String sgdField) {
		this.sgdField = sgdField;
		this.isInitSgdField = true;
	}

	public String getSgdBusType() {
		return sgdBusType;
	}

	public void setSgdBusType(String sgdBusType) {
		this.sgdBusType = sgdBusType;
		this.isInitSgdBusType = true;
	}

	public String getSgdValue() {
		return sgdValue;
	}

	public void setSgdValue(String sgdValue) {
		this.sgdValue = sgdValue;
		this.isInitSgdValue = true;
	}

	public String getSgdDsp() {
		return sgdDsp;
	}

	public void setSgdDsp(String sgdDsp) {
		this.sgdDsp = sgdDsp;
		this.isInitSgdDsp = true;
	}

	public Map<String, String> toMap() {
		Map<String, String> map = new HashMap<String, String>();
		if (isInitSgdField) {
			map.put("sgdField", formatString(sgdField));
		}
		if (isInitSgdBusType) {
			map.put("sgdBusType", formatString(sgdBusType));
		}
		if (isInitSgdValue) {
			map.put("sgdValue", formatString(sgdValue));
		}
		if (isInitSgdDsp) {
			map.put("sgdDsp", formatString(sgdDsp));
		}

		return map;
	}
}
