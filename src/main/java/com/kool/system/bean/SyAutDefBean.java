package com.kool.system.bean;

import java.util.HashMap;
import java.util.Map;
import com.kool.core.base.BaseBean;

/**
 * @AUTHOR LUYU
 */
public class SyAutDefBean extends BaseBean {
	protected String sadAutCode;
	protected boolean isInitSadAutCode;
	protected String sadType;
	protected boolean isInitSadType;
	protected String sadName;
	protected boolean isInitSadName;
	protected String sadState;
	protected boolean isInitSadState;

	public boolean getIsInitSadAutCode() {
		return this.isInitSadAutCode;
	}

	public boolean getIsInitSadType() {
		return this.isInitSadType;
	}

	public boolean getIsInitSadName() {
		return this.isInitSadName;
	}

	public boolean getIsInitSadState() {
		return this.isInitSadState;
	}

	public String getSadAutCode() {
		return sadAutCode;
	}

	public void setSadAutCode(String sadAutCode) {
		this.sadAutCode = sadAutCode;
		this.isInitSadAutCode = true;
	}

	public String getSadType() {
		return sadType;
	}

	public void setSadType(String sadType) {
		this.sadType = sadType;
		this.isInitSadType = true;
	}

	public String getSadName() {
		return sadName;
	}

	public void setSadName(String sadName) {
		this.sadName = sadName;
		this.isInitSadName = true;
	}

	public String getSadState() {
		return sadState;
	}

	public void setSadState(String sadState) {
		this.sadState = sadState;
		this.isInitSadState = true;
	}

	public Map<String, String> toMap() {
		Map<String, String> map = new HashMap<String, String>();
		if (isInitSadAutCode) {
			map.put("sadAutCode", formatString(sadAutCode));
		}
		if (isInitSadType) {
			map.put("sadType", formatString(sadType));
		}
		if (isInitSadName) {
			map.put("sadName", formatString(sadName));
		}
		if (isInitSadState) {
			map.put("sadState", formatString(sadState));
		}

		return map;
	}

	public static SyAutDefBean DBResultToBean(Map<String, Object> map) {
		if (null == map) {
			return null;
		}
		SyAutDefBean reqDef = new SyAutDefBean();
		reqDef.setSadAutCode((String) map.get("SAD_AUT_CODE"));
		reqDef.setSadType((String) map.get("SAD_TYPE"));
		reqDef.setSadName((String) map.get("SAD_NAME"));
		reqDef.setSadState((String) map.get("SAD_STATE"));
		return reqDef;
	}
}