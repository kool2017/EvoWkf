package com.kool.evowkf.bean;

import java.util.HashMap;
import java.util.Map;
import com.kool.core.base.BaseBean;

public class SyWkfEntityBusinessBean extends BaseBean {
	protected String sebWkfCode;
	protected boolean isInitSebWkfCode;
	protected String sebBusinessType;
	protected boolean isInitSebBusinessType;
	protected String sebIsSingle;
	protected boolean isInitSebIsSingle;
	protected String sebMatchStrategy;
	protected boolean isInitSebMatchStrategy;
	protected String sebMatchClazz;
	protected boolean isInitSebMatchClazz;

	public boolean getIsInitSebWkfCode() {
		return this.isInitSebWkfCode;
	}

	public boolean getIsInitSebBusinessType() {
		return this.isInitSebBusinessType;
	}

	public boolean getIsInitSebIsSingle() {
		return this.isInitSebIsSingle;
	}

	public boolean getIsInitSebMatchStrategy() {
		return this.isInitSebMatchStrategy;
	}

	public boolean getIsInitSebMatchClazz() {
		return this.isInitSebMatchClazz;
	}

	public String getSebWkfCode() {
		return sebWkfCode;
	}

	public void setSebWkfCode(String sebWkfCode) {
		this.sebWkfCode = sebWkfCode;
		this.isInitSebWkfCode = true;
	}

	public String getSebBusinessType() {
		return sebBusinessType;
	}

	public void setSebBusinessType(String sebBusinessType) {
		this.sebBusinessType = sebBusinessType;
		this.isInitSebBusinessType = true;
	}

	public String getSebIsSingle() {
		return sebIsSingle;
	}

	public void setSebIsSingle(String sebIsSingle) {
		this.sebIsSingle = sebIsSingle;
		this.isInitSebIsSingle = true;
	}

	public String getSebMatchStrategy() {
		return sebMatchStrategy;
	}

	public void setSebMatchStrategy(String sebMatchStrategy) {
		this.sebMatchStrategy = sebMatchStrategy;
		this.isInitSebMatchStrategy = true;
	}

	public String getSebMatchClazz() {
		return sebMatchClazz;
	}

	public void setSebMatchClazz(String sebMatchClazz) {
		this.sebMatchClazz = sebMatchClazz;
		this.isInitSebMatchClazz = true;
	}

	public Map<String, String> toMap() {
		Map<String, String> map = new HashMap<String, String>();
		if (isInitSebWkfCode) {
			map.put("sebWkfCode", formatString(sebWkfCode));
		}
		if (isInitSebBusinessType) {
			map.put("sebBusinessType", formatString(sebBusinessType));
		}
		if (isInitSebIsSingle) {
			map.put("sebIsSingle", formatString(sebIsSingle));
		}
		if (isInitSebMatchStrategy) {
			map.put("sebMatchStrategy", formatString(sebMatchStrategy));
		}
		if (isInitSebMatchClazz) {
			map.put("sebMatchClazz", formatString(sebMatchClazz));
		}

		return map;
	}
}
