package com.kool.system.bean;

import java.util.HashMap;
import java.util.Map;
import com.kool.core.base.BaseBean;

/**
 * @AUTHOR LUYU
 */
public class SyFileAutBean extends BaseBean {
	protected String sfaFileAutUid;
	protected boolean isInitSfaFileAutUid;
	protected String sfaFileUid;
	protected boolean isInitSfaFileUid;
	protected String sfaOwnerType;
	protected boolean isInitSfaOwnerType;
	protected String sfaUserCid;
	protected boolean isInitSfaUserCid;
	protected String sfaRoleCode;
	protected boolean isInitSfaRoleCode;
	protected String sfaGroupCode;
	protected boolean isInitSfaGroupCode;
	protected String sfaCmt;
	protected boolean isInitSfaCmt;

	public boolean getIsInitSfaFileAutUid() {
		return this.isInitSfaFileAutUid;
	}

	public boolean getIsInitSfaFileUid() {
		return this.isInitSfaFileUid;
	}

	public boolean getIsInitSfaOwnerType() {
		return this.isInitSfaOwnerType;
	}

	public boolean getIsInitSfaUserCid() {
		return this.isInitSfaUserCid;
	}

	public boolean getIsInitSfaRoleCode() {
		return this.isInitSfaRoleCode;
	}

	public boolean getIsInitSfaGroupCode() {
		return this.isInitSfaGroupCode;
	}

	public boolean getIsInitSfaCmt() {
		return this.isInitSfaCmt;
	}

	public String getSfaFileAutUid() {
		return sfaFileAutUid;
	}

	public void setSfaFileAutUid(String sfaFileAutUid) {
		this.sfaFileAutUid = sfaFileAutUid;
		this.isInitSfaFileAutUid = true;
	}

	public String getSfaFileUid() {
		return sfaFileUid;
	}

	public void setSfaFileUid(String sfaFileUid) {
		this.sfaFileUid = sfaFileUid;
		this.isInitSfaFileUid = true;
	}

	public String getSfaOwnerType() {
		return sfaOwnerType;
	}

	public void setSfaOwnerType(String sfaOwnerType) {
		this.sfaOwnerType = sfaOwnerType;
		this.isInitSfaOwnerType = true;
	}

	public String getSfaUserCid() {
		return sfaUserCid;
	}

	public void setSfaUserCid(String sfaUserCid) {
		this.sfaUserCid = sfaUserCid;
		this.isInitSfaUserCid = true;
	}

	public String getSfaRoleCode() {
		return sfaRoleCode;
	}

	public void setSfaRoleCode(String sfaRoleCode) {
		this.sfaRoleCode = sfaRoleCode;
		this.isInitSfaRoleCode = true;
	}

	public String getSfaGroupCode() {
		return sfaGroupCode;
	}

	public void setSfaGroupCode(String sfaGroupCode) {
		this.sfaGroupCode = sfaGroupCode;
		this.isInitSfaGroupCode = true;
	}

	public String getSfaCmt() {
		return sfaCmt;
	}

	public void setSfaCmt(String sfaCmt) {
		this.sfaCmt = sfaCmt;
		this.isInitSfaCmt = true;
	}

	public Map<String, String> toMap() {
		Map<String, String> map = new HashMap<String, String>();
		if (isInitSfaFileAutUid) {
			map.put("sfaFileAutUid", formatString(sfaFileAutUid));
		}
		if (isInitSfaFileUid) {
			map.put("sfaFileUid", formatString(sfaFileUid));
		}
		if (isInitSfaOwnerType) {
			map.put("sfaOwnerType", formatString(sfaOwnerType));
		}
		if (isInitSfaUserCid) {
			map.put("sfaUserCid", formatString(sfaUserCid));
		}
		if (isInitSfaRoleCode) {
			map.put("sfaRoleCode", formatString(sfaRoleCode));
		}
		if (isInitSfaGroupCode) {
			map.put("sfaGroupCode", formatString(sfaGroupCode));
		}
		if (isInitSfaCmt) {
			map.put("sfaCmt", formatString(sfaCmt));
		}

		return map;
	}

	public static SyFileAutBean DBResultToBean(Map<String, Object> map) {
		if (null == map) {
			return null;
		}
		SyFileAutBean reqDef = new SyFileAutBean();
		reqDef.setSfaFileAutUid((String) map.get("SFA_FILE_AUT_UID"));
		reqDef.setSfaFileUid((String) map.get("SFA_FILE_UID"));
		reqDef.setSfaOwnerType((String) map.get("SFA_OWNER_TYPE"));
		reqDef.setSfaUserCid((String) map.get("SFA_USER_CID"));
		reqDef.setSfaRoleCode((String) map.get("SFA_ROLE_CODE"));
		reqDef.setSfaGroupCode((String) map.get("SFA_GROUP_CODE"));
		reqDef.setSfaCmt((String) map.get("SFA_CMT"));
		return reqDef;
	}
}