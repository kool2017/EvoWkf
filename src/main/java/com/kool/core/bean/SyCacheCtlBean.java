package com.kool.core.bean;

import java.util.HashMap;
import java.util.Map;
import com.kool.core.base.BaseBean;

/**
 * @AUTHOR LUYU
 */
public class SyCacheCtlBean extends BaseBean {
	protected String sccCacheCode;
	protected boolean isInitSccCacheCode;
	protected String sccName;
	protected boolean isInitSccName;
	protected String sccClazz;
	protected boolean isInitSccClazz;

	public boolean getIsInitSccCacheCode() {
		return this.isInitSccCacheCode;
	}

	public boolean getIsInitSccName() {
		return this.isInitSccName;
	}

	public boolean getIsInitSccClazz() {
		return this.isInitSccClazz;
	}

	public String getSccCacheCode() {
		return sccCacheCode;
	}

	public void setSccCacheCode(String sccCacheCode) {
		this.sccCacheCode = sccCacheCode;
		this.isInitSccCacheCode = true;
	}

	public String getSccName() {
		return sccName;
	}

	public void setSccName(String sccName) {
		this.sccName = sccName;
		this.isInitSccName = true;
	}

	public String getSccClazz() {
		return sccClazz;
	}

	public void setSccClazz(String sccClazz) {
		this.sccClazz = sccClazz;
		this.isInitSccClazz = true;
	}

	public Map<String, String> toMap() {
		Map<String, String> map = new HashMap<String, String>();
		if (isInitSccCacheCode) {
			map.put("sccCacheCode", formatString(sccCacheCode));
		}
		if (isInitSccName) {
			map.put("sccName", formatString(sccName));
		}
		if (isInitSccClazz) {
			map.put("sccClazz", formatString(sccClazz));
		}

		return map;
	}

	public static SyCacheCtlBean DBResultToBean(Map<String, Object> map) {
		if (null == map) {
			return null;
		}
		SyCacheCtlBean reqDef = new SyCacheCtlBean();
		reqDef.setSccCacheCode((String) map.get("SCC_CACHE_CODE"));
		reqDef.setSccName((String) map.get("SCC_NAME"));
		reqDef.setSccClazz((String) map.get("SCC_CLAZZ"));
		return reqDef;
	}
}