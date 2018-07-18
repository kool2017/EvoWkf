package com.kool.system.bean;

import java.util.HashMap;
import java.util.Map;
import com.kool.core.base.BaseBean;

/**
 * @AUTHOR LUYU
 */
public class SyUserInfoBean extends BaseBean {
	protected String suiUserCid;
	protected boolean isInitSuiUserCid;
	protected String suiLoginName;
	protected boolean isInitSuiLoginName;
	protected String suiType;
	protected boolean isInitSuiType;
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
	protected String suiState;
	protected boolean isInitSuiState;
	protected int suiErrorTimes;
	protected boolean isInitSuiErrorTimes;
	protected java.sql.Timestamp suiRegisterTime;
	protected boolean isInitSuiRegisterTime;
	protected String suiHasKey;
	protected boolean isInitSuiHasKey;
	protected String suiKeyUid;
	protected boolean isInitSuiKeyUid;
	protected String suiStaffCid;
	protected boolean isInitSuiStaffCid;

	public boolean getIsInitSuiUserCid() {
		return this.isInitSuiUserCid;
	}

	public boolean getIsInitSuiLoginName() {
		return this.isInitSuiLoginName;
	}

	public boolean getIsInitSuiType() {
		return this.isInitSuiType;
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

	public boolean getIsInitSuiState() {
		return this.isInitSuiState;
	}

	public boolean getIsInitSuiErrorTimes() {
		return this.isInitSuiErrorTimes;
	}

	public boolean getIsInitSuiRegisterTime() {
		return this.isInitSuiRegisterTime;
	}

	public boolean getIsInitSuiHasKey() {
		return this.isInitSuiHasKey;
	}

	public boolean getIsInitSuiKeyUid() {
		return this.isInitSuiKeyUid;
	}

	public boolean getIsInitSuiStaffCid() {
		return this.isInitSuiStaffCid;
	}

	public String getSuiUserCid() {
		return suiUserCid;
	}

	public void setSuiUserCid(String suiUserCid) {
		this.suiUserCid = suiUserCid;
		this.isInitSuiUserCid = true;
	}

	public String getSuiLoginName() {
		return suiLoginName;
	}

	public void setSuiLoginName(String suiLoginName) {
		this.suiLoginName = suiLoginName;
		this.isInitSuiLoginName = true;
	}

	public String getSuiType() {
		return suiType;
	}

	public void setSuiType(String suiType) {
		this.suiType = suiType;
		this.isInitSuiType = true;
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

	public String getSuiState() {
		return suiState;
	}

	public void setSuiState(String suiState) {
		this.suiState = suiState;
		this.isInitSuiState = true;
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

	public String getSuiHasKey() {
		return suiHasKey;
	}

	public void setSuiHasKey(String suiHasKey) {
		this.suiHasKey = suiHasKey;
		this.isInitSuiHasKey = true;
	}

	public String getSuiKeyUid() {
		return suiKeyUid;
	}

	public void setSuiKeyUid(String suiKeyUid) {
		this.suiKeyUid = suiKeyUid;
		this.isInitSuiKeyUid = true;
	}

	public String getSuiStaffCid() {
		return suiStaffCid;
	}

	public void setSuiStaffCid(String suiStaffCid) {
		this.suiStaffCid = suiStaffCid;
		this.isInitSuiStaffCid = true;
	}

	public Map<String, String> toMap() {
		Map<String, String> map = new HashMap<String, String>();
		if (isInitSuiUserCid) {
			map.put("suiUserCid", formatString(suiUserCid));
		}
		if (isInitSuiLoginName) {
			map.put("suiLoginName", formatString(suiLoginName));
		}
		if (isInitSuiType) {
			map.put("suiType", formatString(suiType));
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
		if (isInitSuiState) {
			map.put("suiState", formatString(suiState));
		}
		if (isInitSuiErrorTimes) {
			map.put("suiErrorTimes", formatString(suiErrorTimes));
		}
		if (isInitSuiRegisterTime) {
			map.put("suiRegisterTime", formatString(suiRegisterTime));
		}
		if (isInitSuiHasKey) {
			map.put("suiHasKey", formatString(suiHasKey));
		}
		if (isInitSuiKeyUid) {
			map.put("suiKeyUid", formatString(suiKeyUid));
		}
		if (isInitSuiStaffCid) {
			map.put("suiStaffCid", formatString(suiStaffCid));
		}

		return map;
	}

	public static SyUserInfoBean DBResultToBean(Map<String, Object> map) {
		if (null == map) {
			return null;
		}
		SyUserInfoBean reqDef = new SyUserInfoBean();
		reqDef.setSuiUserCid((String) map.get("SUI_USER_CID"));
		reqDef.setSuiLoginName((String) map.get("SUI_LOGIN_NAME"));
		reqDef.setSuiType((String) map.get("SUI_TYPE"));
		reqDef.setSuiPhone((String) map.get("SUI_PHONE"));
		reqDef.setSuiMail((String) map.get("SUI_MAIL"));
		reqDef.setSuiPwd((String) map.get("SUI_PWD"));
		reqDef.setSuiSalt((String) map.get("SUI_SALT"));
		reqDef.setSuiNewSalt((String) map.get("SUI_NEW_SALT"));
		reqDef.setSuiHashTimes((int) map.get("SUI_HASH_TIMES"));
		reqDef.setSuiFace((String) map.get("SUI_FACE"));
		reqDef.setSuiState((String) map.get("SUI_STATE"));
		reqDef.setSuiErrorTimes((int) map.get("SUI_ERROR_TIMES"));
		reqDef.setSuiRegisterTime((java.sql.Timestamp) map.get("SUI_REGISTER_TIME"));
		reqDef.setSuiHasKey((String) map.get("SUI_HAS_KEY"));
		reqDef.setSuiKeyUid((String) map.get("SUI_KEY_UID"));
		reqDef.setSuiStaffCid((String) map.get("SUI_STAFF_CID"));
		return reqDef;
	}
}