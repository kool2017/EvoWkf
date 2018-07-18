package com.kool.system.bean;

import java.util.HashMap;
import java.util.Map;
import com.kool.core.base.BaseBean;

/**
 * @AUTHOR LUYU
 */
public class SyFileInfoBean extends BaseBean {
	protected String dfiFileUid;
	protected boolean isInitDfiFileUid;
	protected String dfiFileName;
	protected boolean isInitDfiFileName;
	protected String dfiStoreType;
	protected boolean isInitDfiStoreType;
	protected String dfiIp;
	protected boolean isInitDfiIp;
	protected int dfiPort;
	protected boolean isInitDfiPort;
	protected String dfiPath;
	protected boolean isInitDfiPath;
	protected String dfiSecurity;
	protected boolean isInitDfiSecurity;
	protected String dfiState;
	protected boolean isInitDfiState;
	protected String dfiPendingUser;
	protected boolean isInitDfiPendingUser;
	protected Object dfiVersion;
	protected boolean isInitDfiVersion;
	protected String dfiCmt;
	protected boolean isInitDfiCmt;
	protected java.sql.Timestamp dfiCreateTime;
	protected boolean isInitDfiCreateTime;
	protected String dfiCreateUser;
	protected boolean isInitDfiCreateUser;
	protected java.sql.Timestamp dfiUpdateTime;
	protected boolean isInitDfiUpdateTime;
	protected String dfiUpdateUser;
	protected boolean isInitDfiUpdateUser;

	public boolean getIsInitDfiFileUid() {
		return this.isInitDfiFileUid;
	}

	public boolean getIsInitDfiFileName() {
		return this.isInitDfiFileName;
	}

	public boolean getIsInitDfiStoreType() {
		return this.isInitDfiStoreType;
	}

	public boolean getIsInitDfiIp() {
		return this.isInitDfiIp;
	}

	public boolean getIsInitDfiPort() {
		return this.isInitDfiPort;
	}

	public boolean getIsInitDfiPath() {
		return this.isInitDfiPath;
	}

	public boolean getIsInitDfiSecurity() {
		return this.isInitDfiSecurity;
	}

	public boolean getIsInitDfiState() {
		return this.isInitDfiState;
	}

	public boolean getIsInitDfiPendingUser() {
		return this.isInitDfiPendingUser;
	}

	public boolean getIsInitDfiVersion() {
		return this.isInitDfiVersion;
	}

	public boolean getIsInitDfiCmt() {
		return this.isInitDfiCmt;
	}

	public boolean getIsInitDfiCreateTime() {
		return this.isInitDfiCreateTime;
	}

	public boolean getIsInitDfiCreateUser() {
		return this.isInitDfiCreateUser;
	}

	public boolean getIsInitDfiUpdateTime() {
		return this.isInitDfiUpdateTime;
	}

	public boolean getIsInitDfiUpdateUser() {
		return this.isInitDfiUpdateUser;
	}

	public String getDfiFileUid() {
		return dfiFileUid;
	}

	public void setDfiFileUid(String dfiFileUid) {
		this.dfiFileUid = dfiFileUid;
		this.isInitDfiFileUid = true;
	}

	public String getDfiFileName() {
		return dfiFileName;
	}

	public void setDfiFileName(String dfiFileName) {
		this.dfiFileName = dfiFileName;
		this.isInitDfiFileName = true;
	}

	public String getDfiStoreType() {
		return dfiStoreType;
	}

	public void setDfiStoreType(String dfiStoreType) {
		this.dfiStoreType = dfiStoreType;
		this.isInitDfiStoreType = true;
	}

	public String getDfiIp() {
		return dfiIp;
	}

	public void setDfiIp(String dfiIp) {
		this.dfiIp = dfiIp;
		this.isInitDfiIp = true;
	}

	public int getDfiPort() {
		return dfiPort;
	}

	public void setDfiPort(int dfiPort) {
		this.dfiPort = dfiPort;
		this.isInitDfiPort = true;
	}

	public String getDfiPath() {
		return dfiPath;
	}

	public void setDfiPath(String dfiPath) {
		this.dfiPath = dfiPath;
		this.isInitDfiPath = true;
	}

	public String getDfiSecurity() {
		return dfiSecurity;
	}

	public void setDfiSecurity(String dfiSecurity) {
		this.dfiSecurity = dfiSecurity;
		this.isInitDfiSecurity = true;
	}

	public String getDfiState() {
		return dfiState;
	}

	public void setDfiState(String dfiState) {
		this.dfiState = dfiState;
		this.isInitDfiState = true;
	}

	public String getDfiPendingUser() {
		return dfiPendingUser;
	}

	public void setDfiPendingUser(String dfiPendingUser) {
		this.dfiPendingUser = dfiPendingUser;
		this.isInitDfiPendingUser = true;
	}

	public Object getDfiVersion() {
		return dfiVersion;
	}

	public void setDfiVersion(Object dfiVersion) {
		this.dfiVersion = dfiVersion;
		this.isInitDfiVersion = true;
	}

	public String getDfiCmt() {
		return dfiCmt;
	}

	public void setDfiCmt(String dfiCmt) {
		this.dfiCmt = dfiCmt;
		this.isInitDfiCmt = true;
	}

	public java.sql.Timestamp getDfiCreateTime() {
		return dfiCreateTime;
	}

	public void setDfiCreateTime(java.sql.Timestamp dfiCreateTime) {
		this.dfiCreateTime = dfiCreateTime;
		this.isInitDfiCreateTime = true;
	}

	public String getDfiCreateUser() {
		return dfiCreateUser;
	}

	public void setDfiCreateUser(String dfiCreateUser) {
		this.dfiCreateUser = dfiCreateUser;
		this.isInitDfiCreateUser = true;
	}

	public java.sql.Timestamp getDfiUpdateTime() {
		return dfiUpdateTime;
	}

	public void setDfiUpdateTime(java.sql.Timestamp dfiUpdateTime) {
		this.dfiUpdateTime = dfiUpdateTime;
		this.isInitDfiUpdateTime = true;
	}

	public String getDfiUpdateUser() {
		return dfiUpdateUser;
	}

	public void setDfiUpdateUser(String dfiUpdateUser) {
		this.dfiUpdateUser = dfiUpdateUser;
		this.isInitDfiUpdateUser = true;
	}

	public Map<String, String> toMap() {
		Map<String, String> map = new HashMap<String, String>();
		if (isInitDfiFileUid) {
			map.put("dfiFileUid", formatString(dfiFileUid));
		}
		if (isInitDfiFileName) {
			map.put("dfiFileName", formatString(dfiFileName));
		}
		if (isInitDfiStoreType) {
			map.put("dfiStoreType", formatString(dfiStoreType));
		}
		if (isInitDfiIp) {
			map.put("dfiIp", formatString(dfiIp));
		}
		if (isInitDfiPort) {
			map.put("dfiPort", formatString(dfiPort));
		}
		if (isInitDfiPath) {
			map.put("dfiPath", formatString(dfiPath));
		}
		if (isInitDfiSecurity) {
			map.put("dfiSecurity", formatString(dfiSecurity));
		}
		if (isInitDfiState) {
			map.put("dfiState", formatString(dfiState));
		}
		if (isInitDfiPendingUser) {
			map.put("dfiPendingUser", formatString(dfiPendingUser));
		}
		if (isInitDfiVersion) {
			map.put("dfiVersion", formatString(dfiVersion));
		}
		if (isInitDfiCmt) {
			map.put("dfiCmt", formatString(dfiCmt));
		}
		if (isInitDfiCreateTime) {
			map.put("dfiCreateTime", formatString(dfiCreateTime));
		}
		if (isInitDfiCreateUser) {
			map.put("dfiCreateUser", formatString(dfiCreateUser));
		}
		if (isInitDfiUpdateTime) {
			map.put("dfiUpdateTime", formatString(dfiUpdateTime));
		}
		if (isInitDfiUpdateUser) {
			map.put("dfiUpdateUser", formatString(dfiUpdateUser));
		}

		return map;
	}

	public static SyFileInfoBean DBResultToBean(Map<String, Object> map) {
		if (null == map) {
			return null;
		}
		SyFileInfoBean reqDef = new SyFileInfoBean();
		reqDef.setDfiFileUid((String) map.get("DFI_FILE_UID"));
		reqDef.setDfiFileName((String) map.get("DFI_FILE_NAME"));
		reqDef.setDfiStoreType((String) map.get("DFI_STORE_TYPE"));
		reqDef.setDfiIp((String) map.get("DFI_IP"));
		reqDef.setDfiPort((int) map.get("DFI_PORT"));
		reqDef.setDfiPath((String) map.get("DFI_PATH"));
		reqDef.setDfiSecurity((String) map.get("DFI_SECURITY"));
		reqDef.setDfiState((String) map.get("DFI_STATE"));
		reqDef.setDfiPendingUser((String) map.get("DFI_PENDING_USER"));
		reqDef.setDfiVersion((Object) map.get("DFI_VERSION"));
		reqDef.setDfiCmt((String) map.get("DFI_CMT"));
		reqDef.setDfiCreateTime((java.sql.Timestamp) map.get("DFI_CREATE_TIME"));
		reqDef.setDfiCreateUser((String) map.get("DFI_CREATE_USER"));
		reqDef.setDfiUpdateTime((java.sql.Timestamp) map.get("DFI_UPDATE_TIME"));
		reqDef.setDfiUpdateUser((String) map.get("DFI_UPDATE_USER"));
		return reqDef;
	}
}