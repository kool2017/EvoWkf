package com.kool.system.bean;

import java.util.HashMap;
import java.util.Map;
import com.kool.core.base.BaseBean;

/**
 * @AUTHOR LUYU
 */
public class SyErrorInfoBean extends BaseBean {
	protected String seiErrorCode;
	protected boolean isInitSeiErrorCode;
	protected String seiChnMsg;
	protected boolean isInitSeiChnMsg;
	protected String seiEngMsg;
	protected boolean isInitSeiEngMsg;

	public boolean getIsInitSeiErrorCode() {
		return this.isInitSeiErrorCode;
	}

	public boolean getIsInitSeiChnMsg() {
		return this.isInitSeiChnMsg;
	}

	public boolean getIsInitSeiEngMsg() {
		return this.isInitSeiEngMsg;
	}

	public String getSeiErrorCode() {
		return seiErrorCode;
	}

	public void setSeiErrorCode(String seiErrorCode) {
		this.seiErrorCode = seiErrorCode;
		this.isInitSeiErrorCode = true;
	}

	public String getSeiChnMsg() {
		return seiChnMsg;
	}

	public void setSeiChnMsg(String seiChnMsg) {
		this.seiChnMsg = seiChnMsg;
		this.isInitSeiChnMsg = true;
	}

	public String getSeiEngMsg() {
		return seiEngMsg;
	}

	public void setSeiEngMsg(String seiEngMsg) {
		this.seiEngMsg = seiEngMsg;
		this.isInitSeiEngMsg = true;
	}

	public Map<String, String> toMap() {
		Map<String, String> map = new HashMap<String, String>();
		if (isInitSeiErrorCode) {
			map.put("seiErrorCode", formatString(seiErrorCode));
		}
		if (isInitSeiChnMsg) {
			map.put("seiChnMsg", formatString(seiChnMsg));
		}
		if (isInitSeiEngMsg) {
			map.put("seiEngMsg", formatString(seiEngMsg));
		}

		return map;
	}

	public static SyErrorInfoBean DBResultToBean(Map<String, Object> map) {
		if (null == map) {
			return null;
		}
		SyErrorInfoBean reqDef = new SyErrorInfoBean();
		reqDef.setSeiErrorCode((String) map.get("SEI_ERROR_CODE"));
		reqDef.setSeiChnMsg((String) map.get("SEI_CHN_MSG"));
		reqDef.setSeiEngMsg((String) map.get("SEI_ENG_MSG"));
		return reqDef;
	}
}