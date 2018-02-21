package com.kool.system.bean;

import java.util.HashMap;
import java.util.Map;
import com.kool.core.base.BaseBean;

public class SyUserInfoBean extends BaseBean {
	protected String suiId;
	protected boolean isInitSuiId;
	protected String suiLoginName;
	protected boolean isInitSuiLoginName;
	protected String suiPhone;
	protected boolean isInitSuiPhone;
	protected String suiMail;
	protected boolean isInitSuiMail;
	protected String suiPwd;
	protected boolean isInitSuiPwd;
	protected String suiSalt;
	protected boolean isInitSuiSalt;
	protected String suiNewSalt;
	protected boolean isInitSuiNewSalt;
	protected int suiHashTimes;
	protected boolean isInitSuiHashTimes;
	protected String suiFace;
	protected boolean isInitSuiFace;
	protected String suiStatus;
	protected boolean isInitSuiStatus;
	protected int suiErrorTimes;
	protected boolean isInitSuiErrorTimes;
	protected java.sql.Timestamp suiRegisterTime;
	protected boolean isInitSuiRegisterTime;

	public boolean getIsInitSuiId() {
		return this.isInitSuiId;
	}

	public boolean getIsInitSuiLoginName() {
		return this.isInitSuiLoginName;
	}

	public boolean getIsInitSuiPhone() {
		return this.isInitSuiPhone;
	}

	public boolean getIsInitSuiMail() {
		return this.isInitSuiMail;
	}

	public boolean getIsInitSuiPwd() {
		return this.isInitSuiPwd;
	}

	public boolean getIsInitSuiSalt() {
		return this.isInitSuiSalt;
	}

	public boolean getIsInitSuiNewSalt() {
		return this.isInitSuiNewSalt;
	}

	public boolean getIsInitSuiHashTimes() {
		return this.isInitSuiHashTimes;
	}

	public boolean getIsInitSuiFace() {
		return this.isInitSuiFace;
	}

	public boolean getIsInitSuiStatus() {
		return this.isInitSuiStatus;
	}

	public boolean getIsInitSuiErrorTimes() {
		return this.isInitSuiErrorTimes;
	}

	public boolean getIsInitSuiRegisterTime() {
		return this.isInitSuiRegisterTime;
	}

	public String getSuiId() {
		return suiId;
	}

	public void setSuiId(String suiId) {
		this.suiId = suiId;
		this.isInitSuiId = true;
	}

	public String getSuiLoginName() {
		return suiLoginName;
	}

	public void setSuiLoginName(String suiLoginName) {
		this.suiLoginName = suiLoginName;
		this.isInitSuiLoginName = true;
	}

	public String getSuiPhone() {
		return suiPhone;
	}

	public void setSuiPhone(String suiPhone) {
		this.suiPhone = suiPhone;
		this.isInitSuiPhone = true;
	}

	public String getSuiMail() {
		return suiMail;
	}

	public void setSuiMail(String suiMail) {
		this.suiMail = suiMail;
		this.isInitSuiMail = true;
	}

	public String getSuiPwd() {
		return suiPwd;
	}

	public void setSuiPwd(String suiPwd) {
		this.suiPwd = suiPwd;
		this.isInitSuiPwd = true;
	}

	public String getSuiSalt() {
		return suiSalt;
	}

	public void setSuiSalt(String suiSalt) {
		this.suiSalt = suiSalt;
		this.isInitSuiSalt = true;
	}

	public String getSuiNewSalt() {
		return suiNewSalt;
	}

	public void setSuiNewSalt(String suiNewSalt) {
		this.suiNewSalt = suiNewSalt;
		this.isInitSuiNewSalt = true;
	}

	public int getSuiHashTimes() {
		return suiHashTimes;
	}

	public void setSuiHashTimes(int suiHashTimes) {
		this.suiHashTimes = suiHashTimes;
		this.isInitSuiHashTimes = true;
	}

	public String getSuiFace() {
		return suiFace;
	}

	public void setSuiFace(String suiFace) {
		this.suiFace = suiFace;
		this.isInitSuiFace = true;
	}

	public String getSuiStatus() {
		return suiStatus;
	}

	public void setSuiStatus(String suiStatus) {
		this.suiStatus = suiStatus;
		this.isInitSuiStatus = true;
	}

	public int getSuiErrorTimes() {
		return suiErrorTimes;
	}

	public void setSuiErrorTimes(int suiErrorTimes) {
		this.suiErrorTimes = suiErrorTimes;
		this.isInitSuiErrorTimes = true;
	}

	public java.sql.Timestamp getSuiRegisterTime() {
		return suiRegisterTime;
	}

	public void setSuiRegisterTime(java.sql.Timestamp suiRegisterTime) {
		this.suiRegisterTime = suiRegisterTime;
		this.isInitSuiRegisterTime = true;
	}

	public Map<String, String> toMap() {
		Map<String, String> map = new HashMap<String, String>();
		if (isInitSuiId) {
			map.put("suiId", formatString(suiId));
		}
		if (isInitSuiLoginName) {
			map.put("suiLoginName", formatString(suiLoginName));
		}
		if (isInitSuiPhone) {
			map.put("suiPhone", formatString(suiPhone));
		}
		if (isInitSuiMail) {
			map.put("suiMail", formatString(suiMail));
		}
		if (isInitSuiPwd) {
			map.put("suiPwd", formatString(suiPwd));
		}
		if (isInitSuiSalt) {
			map.put("suiSalt", formatString(suiSalt));
		}
		if (isInitSuiNewSalt) {
			map.put("suiNewSalt", formatString(suiNewSalt));
		}
		if (isInitSuiHashTimes) {
			map.put("suiHashTimes", formatString(suiHashTimes));
		}
		if (isInitSuiFace) {
			map.put("suiFace", formatString(suiFace));
		}
		if (isInitSuiStatus) {
			map.put("suiStatus", formatString(suiStatus));
		}
		if (isInitSuiErrorTimes) {
			map.put("suiErrorTimes", formatString(suiErrorTimes));
		}
		if (isInitSuiRegisterTime) {
			map.put("suiRegisterTime", formatString(suiRegisterTime));
		}

		return map;
	}
}
