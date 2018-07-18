package com.kool.system.bean;

import java.util.HashMap;
import java.util.Map;
import com.kool.core.base.BaseBean;

/**
 * @AUTHOR LUYU
 */
public class SyMenuAutBean extends BaseBean {
	protected String smaMenuCode;
	protected boolean isInitSmaMenuCode;
	protected String smaAutCode;
	protected boolean isInitSmaAutCode;
	protected String smaCmt;
	protected boolean isInitSmaCmt;

	public boolean getIsInitSmaMenuCode() {
		return this.isInitSmaMenuCode;
	}

	public boolean getIsInitSmaAutCode() {
		return this.isInitSmaAutCode;
	}

	public boolean getIsInitSmaCmt() {
		return this.isInitSmaCmt;
	}

	public String getSmaMenuCode() {
		return smaMenuCode;
	}

	public void setSmaMenuCode(String smaMenuCode) {
		this.smaMenuCode = smaMenuCode;
		this.isInitSmaMenuCode = true;
	}

	public String getSmaAutCode() {
		return smaAutCode;
	}

	public void setSmaAutCode(String smaAutCode) {
		this.smaAutCode = smaAutCode;
		this.isInitSmaAutCode = true;
	}

	public String getSmaCmt() {
		return smaCmt;
	}

	public void setSmaCmt(String smaCmt) {
		this.smaCmt = smaCmt;
		this.isInitSmaCmt = true;
	}

	public Map<String, String> toMap() {
		Map<String, String> map = new HashMap<String, String>();
		if (isInitSmaMenuCode) {
			map.put("smaMenuCode", formatString(smaMenuCode));
		}
		if (isInitSmaAutCode) {
			map.put("smaAutCode", formatString(smaAutCode));
		}
		if (isInitSmaCmt) {
			map.put("smaCmt", formatString(smaCmt));
		}

		return map;
	}

	public static SyMenuAutBean DBResultToBean(Map<String, Object> map) {
		if (null == map) {
			return null;
		}
		SyMenuAutBean reqDef = new SyMenuAutBean();
		reqDef.setSmaMenuCode((String) map.get("SMA_MENU_CODE"));
		reqDef.setSmaAutCode((String) map.get("SMA_AUT_CODE"));
		reqDef.setSmaCmt((String) map.get("SMA_CMT"));
		return reqDef;
	}
}