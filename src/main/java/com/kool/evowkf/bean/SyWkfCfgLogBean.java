package com.kool.evowkf.bean;

import java.util.HashMap;
import java.util.Map;
import com.kool.core.base.BaseBean;

public class SyWkfCfgLogBean extends BaseBean {
	protected String sclLogUid;
	protected boolean isInitSclLogUid;
	protected java.sql.Timestamp sclLogTime;
	protected boolean isInitSclLogTime;
	protected String sclUserCid;
	protected boolean isInitSclUserCid;
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

	public boolean getIsInitSclLogUid() {
		return this.isInitSclLogUid;
	}

	public boolean getIsInitSclLogTime() {
		return this.isInitSclLogTime;
	}

	public boolean getIsInitSclUserCid() {
		return this.isInitSclUserCid;
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

	public String getSclLogUid() {
		return sclLogUid;
	}

	public void setSclLogUid(String sclLogUid) {
		this.sclLogUid = sclLogUid;
		this.isInitSclLogUid = true;
	}

	public java.sql.Timestamp getSclLogTime() {
		return sclLogTime;
	}

	public void setSclLogTime(java.sql.Timestamp sclLogTime) {
		this.sclLogTime = sclLogTime;
		this.isInitSclLogTime = true;
	}

	public String getSclUserCid() {
		return sclUserCid;
	}

	public void setSclUserCid(String sclUserCid) {
		this.sclUserCid = sclUserCid;
		this.isInitSclUserCid = true;
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
		if (isInitSclLogUid) {
			map.put("sclLogUid", formatString(sclLogUid));
		}
		if (isInitSclLogTime) {
			map.put("sclLogTime", formatString(sclLogTime));
		}
		if (isInitSclUserCid) {
			map.put("sclUserCid", formatString(sclUserCid));
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
