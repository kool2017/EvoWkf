package com.kool.system.bean;

import java.util.HashMap;
import java.util.Map;
import com.kool.core.base.BaseBean;

/**
 * @AUTHOR LUYU
 */
public class SyDataDefBean extends BaseBean {
	protected String sddDataCode;
	protected boolean isInitSddDataCode;
	protected String sddName;
	protected boolean isInitSddName;
	protected String sddField;
	protected boolean isInitSddField;

	public boolean getIsInitSddDataCode() {
		return this.isInitSddDataCode;
	}

	public boolean getIsInitSddName() {
		return this.isInitSddName;
	}

	public boolean getIsInitSddField() {
		return this.isInitSddField;
	}

	public String getSddDataCode() {
		return sddDataCode;
	}

	public void setSddDataCode(String sddDataCode) {
		this.sddDataCode = sddDataCode;
		this.isInitSddDataCode = true;
	}

	public String getSddName() {
		return sddName;
	}

	public void setSddName(String sddName) {
		this.sddName = sddName;
		this.isInitSddName = true;
	}

	public String getSddField() {
		return sddField;
	}

	public void setSddField(String sddField) {
		this.sddField = sddField;
		this.isInitSddField = true;
	}

	public Map<String, String> toMap() {
		Map<String, String> map = new HashMap<String, String>();
		if (isInitSddDataCode) {
			map.put("sddDataCode", formatString(sddDataCode));
		}
		if (isInitSddName) {
			map.put("sddName", formatString(sddName));
		}
		if (isInitSddField) {
			map.put("sddField", formatString(sddField));
		}

		return map;
	}

	public static SyDataDefBean DBResultToBean(Map<String, Object> map) {
		if (null == map) {
			return null;
		}
		SyDataDefBean reqDef = new SyDataDefBean();
		reqDef.setSddDataCode((String) map.get("SDD_DATA_CODE"));
		reqDef.setSddName((String) map.get("SDD_NAME"));
		reqDef.setSddField((String) map.get("SDD_FIELD"));
		return reqDef;
	}
}