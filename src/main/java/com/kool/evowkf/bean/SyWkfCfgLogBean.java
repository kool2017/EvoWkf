package com.kool.evowkf.bean;

import java.util.HashMap;
import java.util.Map;
import com.kool.core.base.BaseBean;

public class SyWkfCfgLogBean extends BaseBean {
	protected String sclLogId;
	protected boolean isInitSclLogId;
	protected java.sql.Timestamp sclLogTime;
	protected boolean isInitSclLogTime;
	protected String sclUserId;
	protected boolean isInitSclUserId;
	protected String sclLoginName;
	protected boolean isInitSclLoginName;
	protected String sclTable;
	protected boolean isInitSclTable;
	protected String sclOprType;
	protected boolean isInitSclOprType;
	protected String sclField;
	protected boolean isInitSclField;
	protected String sclOldValue;
	protected boolean isInitSclOldValue;
	protected String sclNewValue;
	protected boolean isInitSclNewValue;

	public boolean getIsInitSclLogId() {
		return this.isInitSclLogId;
	}

	public boolean getIsInitSclLogTime() {
		return this.isInitSclLogTime;
	}

	public boolean getIsInitSclUserId() {
		return this.isInitSclUserId;
	}

	public boolean getIsInitSclLoginName() {
		return this.isInitSclLoginName;
	}

	public boolean getIsInitSclTable() {
		return this.isInitSclTable;
	}

	public boolean getIsInitSclOprType() {
		return this.isInitSclOprType;
	}

	public boolean getIsInitSclField() {
		return this.isInitSclField;
	}

	public boolean getIsInitSclOldValue() {
		return this.isInitSclOldValue;
	}

	public boolean getIsInitSclNewValue() {
		return this.isInitSclNewValue;
	}

	public String getSclLogId() {
		return sclLogId;
	}

	public void setSclLogId(String sclLogId) {
		this.sclLogId = sclLogId;
		this.isInitSclLogId = true;
	}

	public java.sql.Timestamp getSclLogTime() {
		return sclLogTime;
	}

	public void setSclLogTime(java.sql.Timestamp sclLogTime) {
		this.sclLogTime = sclLogTime;
		this.isInitSclLogTime = true;
	}

	public String getSclUserId() {
		return sclUserId;
	}

	public void setSclUserId(String sclUserId) {
		this.sclUserId = sclUserId;
		this.isInitSclUserId = true;
	}

	public String getSclLoginName() {
		return sclLoginName;
	}

	public void setSclLoginName(String sclLoginName) {
		this.sclLoginName = sclLoginName;
		this.isInitSclLoginName = true;
	}

	public String getSclTable() {
		return sclTable;
	}

	public void setSclTable(String sclTable) {
		this.sclTable = sclTable;
		this.isInitSclTable = true;
	}

	public String getSclOprType() {
		return sclOprType;
	}

	public void setSclOprType(String sclOprType) {
		this.sclOprType = sclOprType;
		this.isInitSclOprType = true;
	}

	public String getSclField() {
		return sclField;
	}

	public void setSclField(String sclField) {
		this.sclField = sclField;
		this.isInitSclField = true;
	}

	public String getSclOldValue() {
		return sclOldValue;
	}

	public void setSclOldValue(String sclOldValue) {
		this.sclOldValue = sclOldValue;
		this.isInitSclOldValue = true;
	}

	public String getSclNewValue() {
		return sclNewValue;
	}

	public void setSclNewValue(String sclNewValue) {
		this.sclNewValue = sclNewValue;
		this.isInitSclNewValue = true;
	}

	public Map<String, String> toMap() {
		Map<String, String> map = new HashMap<String, String>();
		if (isInitSclLogId) {
			map.put("sclLogId", formatString(sclLogId));
		}
		if (isInitSclLogTime) {
			map.put("sclLogTime", formatString(sclLogTime));
		}
		if (isInitSclUserId) {
			map.put("sclUserId", formatString(sclUserId));
		}
		if (isInitSclLoginName) {
			map.put("sclLoginName", formatString(sclLoginName));
		}
		if (isInitSclTable) {
			map.put("sclTable", formatString(sclTable));
		}
		if (isInitSclOprType) {
			map.put("sclOprType", formatString(sclOprType));
		}
		if (isInitSclField) {
			map.put("sclField", formatString(sclField));
		}
		if (isInitSclOldValue) {
			map.put("sclOldValue", formatString(sclOldValue));
		}
		if (isInitSclNewValue) {
			map.put("sclNewValue", formatString(sclNewValue));
		}

		return map;
	}
}
