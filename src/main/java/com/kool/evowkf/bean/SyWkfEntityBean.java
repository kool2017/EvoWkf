package com.kool.evowkf.bean;

import java.util.HashMap;
import java.util.Map;
import com.kool.core.base.BaseBean;

public class SyWkfEntityBean extends BaseBean {
	protected String sweEntityId;
	protected boolean isInitSweEntityId;
	protected String sweEntityName;
	protected boolean isInitSweEntityName;
	protected String sweWkfCode;
	protected boolean isInitSweWkfCode;
	protected String sweBusinessType;
	protected boolean isInitSweBusinessType;
	protected String sweMatchValue;
	protected boolean isInitSweMatchValue;
	protected String sweNodeHead;
	protected boolean isInitSweNodeHead;
	protected String sweNodeHeadName;
	protected boolean isInitSweNodeHeadName;
	protected String sweEntityStatus;
	protected boolean isInitSweEntityStatus;

	public boolean getIsInitSweEntityId() {
		return this.isInitSweEntityId;
	}

	public boolean getIsInitSweEntityName() {
		return this.isInitSweEntityName;
	}

	public boolean getIsInitSweWkfCode() {
		return this.isInitSweWkfCode;
	}

	public boolean getIsInitSweBusinessType() {
		return this.isInitSweBusinessType;
	}

	public boolean getIsInitSweMatchValue() {
		return this.isInitSweMatchValue;
	}

	public boolean getIsInitSweNodeHead() {
		return this.isInitSweNodeHead;
	}

	public boolean getIsInitSweNodeHeadName() {
		return this.isInitSweNodeHeadName;
	}

	public boolean getIsInitSweEntityStatus() {
		return this.isInitSweEntityStatus;
	}

	public String getSweEntityId() {
		return sweEntityId;
	}

	public void setSweEntityId(String sweEntityId) {
		this.sweEntityId = sweEntityId;
		this.isInitSweEntityId = true;
	}

	public String getSweEntityName() {
		return sweEntityName;
	}

	public void setSweEntityName(String sweEntityName) {
		this.sweEntityName = sweEntityName;
		this.isInitSweEntityName = true;
	}

	public String getSweWkfCode() {
		return sweWkfCode;
	}

	public void setSweWkfCode(String sweWkfCode) {
		this.sweWkfCode = sweWkfCode;
		this.isInitSweWkfCode = true;
	}

	public String getSweBusinessType() {
		return sweBusinessType;
	}

	public void setSweBusinessType(String sweBusinessType) {
		this.sweBusinessType = sweBusinessType;
		this.isInitSweBusinessType = true;
	}

	public String getSweMatchValue() {
		return sweMatchValue;
	}

	public void setSweMatchValue(String sweMatchValue) {
		this.sweMatchValue = sweMatchValue;
		this.isInitSweMatchValue = true;
	}

	public String getSweNodeHead() {
		return sweNodeHead;
	}

	public void setSweNodeHead(String sweNodeHead) {
		this.sweNodeHead = sweNodeHead;
		this.isInitSweNodeHead = true;
	}

	public String getSweNodeHeadName() {
		return sweNodeHeadName;
	}

	public void setSweNodeHeadName(String sweNodeHeadName) {
		this.sweNodeHeadName = sweNodeHeadName;
		this.isInitSweNodeHeadName = true;
	}

	public String getSweEntityStatus() {
		return sweEntityStatus;
	}

	public void setSweEntityStatus(String sweEntityStatus) {
		this.sweEntityStatus = sweEntityStatus;
		this.isInitSweEntityStatus = true;
	}

	public Map<String, String> toMap() {
		Map<String, String> map = new HashMap<String, String>();
		if (isInitSweEntityId) {
			map.put("sweEntityId", formatString(sweEntityId));
		}
		if (isInitSweEntityName) {
			map.put("sweEntityName", formatString(sweEntityName));
		}
		if (isInitSweWkfCode) {
			map.put("sweWkfCode", formatString(sweWkfCode));
		}
		if (isInitSweBusinessType) {
			map.put("sweBusinessType", formatString(sweBusinessType));
		}
		if (isInitSweMatchValue) {
			map.put("sweMatchValue", formatString(sweMatchValue));
		}
		if (isInitSweNodeHead) {
			map.put("sweNodeHead", formatString(sweNodeHead));
		}
		if (isInitSweNodeHeadName) {
			map.put("sweNodeHeadName", formatString(sweNodeHeadName));
		}
		if (isInitSweEntityStatus) {
			map.put("sweEntityStatus", formatString(sweEntityStatus));
		}

		return map;
	}
}
