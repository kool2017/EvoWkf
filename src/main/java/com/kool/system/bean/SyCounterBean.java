package com.kool.system.bean;

import java.util.HashMap;
import java.util.Map;
import com.kool.core.base.BaseBean;

/**
 * @AUTHOR LUYU
 */
public class SyCounterBean extends BaseBean {
	protected String scoCounterCode;
	protected boolean isInitScoCounterCode;
	protected String scoName;
	protected boolean isInitScoName;
	protected String scoCurValue;
	protected boolean isInitScoCurValue;
	protected String scoMin;
	protected boolean isInitScoMin;
	protected String scoMax;
	protected boolean isInitScoMax;
	protected String scoStep;
	protected boolean isInitScoStep;
	protected String scoOver;
	protected boolean isInitScoOver;
	protected String scoResetPeriod;
	protected boolean isInitScoResetPeriod;
	protected java.sql.Timestamp scoResetTime;
	protected boolean isInitScoResetTime;
	protected String scoState;
	protected boolean isInitScoState;

	public boolean getIsInitScoCounterCode() {
		return this.isInitScoCounterCode;
	}

	public boolean getIsInitScoName() {
		return this.isInitScoName;
	}

	public boolean getIsInitScoCurValue() {
		return this.isInitScoCurValue;
	}

	public boolean getIsInitScoMin() {
		return this.isInitScoMin;
	}

	public boolean getIsInitScoMax() {
		return this.isInitScoMax;
	}

	public boolean getIsInitScoStep() {
		return this.isInitScoStep;
	}

	public boolean getIsInitScoOver() {
		return this.isInitScoOver;
	}

	public boolean getIsInitScoResetPeriod() {
		return this.isInitScoResetPeriod;
	}

	public boolean getIsInitScoResetTime() {
		return this.isInitScoResetTime;
	}

	public boolean getIsInitScoState() {
		return this.isInitScoState;
	}

	public String getScoCounterCode() {
		return scoCounterCode;
	}

	public void setScoCounterCode(String scoCounterCode) {
		this.scoCounterCode = scoCounterCode;
		this.isInitScoCounterCode = true;
	}

	public String getScoName() {
		return scoName;
	}

	public void setScoName(String scoName) {
		this.scoName = scoName;
		this.isInitScoName = true;
	}

	public String getScoCurValue() {
		return scoCurValue;
	}

	public void setScoCurValue(String scoCurValue) {
		this.scoCurValue = scoCurValue;
		this.isInitScoCurValue = true;
	}

	public String getScoMin() {
		return scoMin;
	}

	public void setScoMin(String scoMin) {
		this.scoMin = scoMin;
		this.isInitScoMin = true;
	}

	public String getScoMax() {
		return scoMax;
	}

	public void setScoMax(String scoMax) {
		this.scoMax = scoMax;
		this.isInitScoMax = true;
	}

	public String getScoStep() {
		return scoStep;
	}

	public void setScoStep(String scoStep) {
		this.scoStep = scoStep;
		this.isInitScoStep = true;
	}

	public String getScoOver() {
		return scoOver;
	}

	public void setScoOver(String scoOver) {
		this.scoOver = scoOver;
		this.isInitScoOver = true;
	}

	public String getScoResetPeriod() {
		return scoResetPeriod;
	}

	public void setScoResetPeriod(String scoResetPeriod) {
		this.scoResetPeriod = scoResetPeriod;
		this.isInitScoResetPeriod = true;
	}

	public java.sql.Timestamp getScoResetTime() {
		return scoResetTime;
	}

	public void setScoResetTime(java.sql.Timestamp scoResetTime) {
		this.scoResetTime = scoResetTime;
		this.isInitScoResetTime = true;
	}

	public String getScoState() {
		return scoState;
	}

	public void setScoState(String scoState) {
		this.scoState = scoState;
		this.isInitScoState = true;
	}

	public Map<String, String> toMap() {
		Map<String, String> map = new HashMap<String, String>();
		if (isInitScoCounterCode) {
			map.put("scoCounterCode", formatString(scoCounterCode));
		}
		if (isInitScoName) {
			map.put("scoName", formatString(scoName));
		}
		if (isInitScoCurValue) {
			map.put("scoCurValue", formatString(scoCurValue));
		}
		if (isInitScoMin) {
			map.put("scoMin", formatString(scoMin));
		}
		if (isInitScoMax) {
			map.put("scoMax", formatString(scoMax));
		}
		if (isInitScoStep) {
			map.put("scoStep", formatString(scoStep));
		}
		if (isInitScoOver) {
			map.put("scoOver", formatString(scoOver));
		}
		if (isInitScoResetPeriod) {
			map.put("scoResetPeriod", formatString(scoResetPeriod));
		}
		if (isInitScoResetTime) {
			map.put("scoResetTime", formatString(scoResetTime));
		}
		if (isInitScoState) {
			map.put("scoState", formatString(scoState));
		}

		return map;
	}

	public static SyCounterBean DBResultToBean(Map<String, Object> map) {
		if (null == map) {
			return null;
		}
		SyCounterBean reqDef = new SyCounterBean();
		reqDef.setScoCounterCode((String) map.get("SCO_COUNTER_CODE"));
		reqDef.setScoName((String) map.get("SCO_NAME"));
		reqDef.setScoCurValue((String) map.get("SCO_CUR_VALUE"));
		reqDef.setScoMin((String) map.get("SCO_MIN"));
		reqDef.setScoMax((String) map.get("SCO_MAX"));
		reqDef.setScoStep((String) map.get("SCO_STEP"));
		reqDef.setScoOver((String) map.get("SCO_OVER"));
		reqDef.setScoResetPeriod((String) map.get("SCO_RESET_PERIOD"));
		reqDef.setScoResetTime((java.sql.Timestamp) map.get("SCO_RESET_TIME"));
		reqDef.setScoState((String) map.get("SCO_STATE"));
		return reqDef;
	}
}