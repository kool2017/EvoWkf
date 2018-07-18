package com.kool.system.bean;

import java.util.HashMap;
import java.util.Map;
import com.kool.core.base.BaseBean;

/**
 * @AUTHOR LUYU
 */
public class SyDataAutBean extends BaseBean {
	protected String sdaDataAutUid;
	protected boolean isInitSdaDataAutUid;
	protected String sdaDataCode;
	protected boolean isInitSdaDataCode;
	protected String sdaValue;
	protected boolean isInitSdaValue;
	protected String sdaOwnerType;
	protected boolean isInitSdaOwnerType;
	protected String sdaUserCid;
	protected boolean isInitSdaUserCid;
	protected String sdaRoleCode;
	protected boolean isInitSdaRoleCode;
	protected String sdaGroupCode;
	protected boolean isInitSdaGroupCode;
	protected String sdaCmt;
	protected boolean isInitSdaCmt;

	public boolean getIsInitSdaDataAutUid() {
		return this.isInitSdaDataAutUid;
	}

	public boolean getIsInitSdaDataCode() {
		return this.isInitSdaDataCode;
	}

	public boolean getIsInitSdaValue() {
		return this.isInitSdaValue;
	}

	public boolean getIsInitSdaOwnerType() {
		return this.isInitSdaOwnerType;
	}

	public boolean getIsInitSdaUserCid() {
		return this.isInitSdaUserCid;
	}

	public boolean getIsInitSdaRoleCode() {
		return this.isInitSdaRoleCode;
	}

	public boolean getIsInitSdaGroupCode() {
		return this.isInitSdaGroupCode;
	}

	public boolean getIsInitSdaCmt() {
		return this.isInitSdaCmt;
	}

	public String getSdaDataAutUid() {
		return sdaDataAutUid;
	}

	public void setSdaDataAutUid(String sdaDataAutUid) {
		this.sdaDataAutUid = sdaDataAutUid;
		this.isInitSdaDataAutUid = true;
	}

	public String getSdaDataCode() {
		return sdaDataCode;
	}

	public void setSdaDataCode(String sdaDataCode) {
		this.sdaDataCode = sdaDataCode;
		this.isInitSdaDataCode = true;
	}

	public String getSdaValue() {
		return sdaValue;
	}

	public void setSdaValue(String sdaValue) {
		this.sdaValue = sdaValue;
		this.isInitSdaValue = true;
	}

	public String getSdaOwnerType() {
		return sdaOwnerType;
	}

	public void setSdaOwnerType(String sdaOwnerType) {
		this.sdaOwnerType = sdaOwnerType;
		this.isInitSdaOwnerType = true;
	}

	public String getSdaUserCid() {
		return sdaUserCid;
	}

	public void setSdaUserCid(String sdaUserCid) {
		this.sdaUserCid = sdaUserCid;
		this.isInitSdaUserCid = true;
	}

	public String getSdaRoleCode() {
		return sdaRoleCode;
	}

	public void setSdaRoleCode(String sdaRoleCode) {
		this.sdaRoleCode = sdaRoleCode;
		this.isInitSdaRoleCode = true;
	}

	public String getSdaGroupCode() {
		return sdaGroupCode;
	}

	public void setSdaGroupCode(String sdaGroupCode) {
		this.sdaGroupCode = sdaGroupCode;
		this.isInitSdaGroupCode = true;
	}

	public String getSdaCmt() {
		return sdaCmt;
	}

	public void setSdaCmt(String sdaCmt) {
		this.sdaCmt = sdaCmt;
		this.isInitSdaCmt = true;
	}

	public Map<String, String> toMap() {
		Map<String, String> map = new HashMap<String, String>();
		if (isInitSdaDataAutUid) {
			map.put("sdaDataAutUid", formatString(sdaDataAutUid));
		}
		if (isInitSdaDataCode) {
			map.put("sdaDataCode", formatString(sdaDataCode));
		}
		if (isInitSdaValue) {
			map.put("sdaValue", formatString(sdaValue));
		}
		if (isInitSdaOwnerType) {
			map.put("sdaOwnerType", formatString(sdaOwnerType));
		}
		if (isInitSdaUserCid) {
			map.put("sdaUserCid", formatString(sdaUserCid));
		}
		if (isInitSdaRoleCode) {
			map.put("sdaRoleCode", formatString(sdaRoleCode));
		}
		if (isInitSdaGroupCode) {
			map.put("sdaGroupCode", formatString(sdaGroupCode));
		}
		if (isInitSdaCmt) {
			map.put("sdaCmt", formatString(sdaCmt));
		}

		return map;
	}

	public static SyDataAutBean DBResultToBean(Map<String, Object> map) {
		if (null == map) {
			return null;
		}
		SyDataAutBean reqDef = new SyDataAutBean();
		reqDef.setSdaDataAutUid((String) map.get("SDA_DATA_AUT_UID"));
		reqDef.setSdaDataCode((String) map.get("SDA_DATA_CODE"));
		reqDef.setSdaValue((String) map.get("SDA_VALUE"));
		reqDef.setSdaOwnerType((String) map.get("SDA_OWNER_TYPE"));
		reqDef.setSdaUserCid((String) map.get("SDA_USER_CID"));
		reqDef.setSdaRoleCode((String) map.get("SDA_ROLE_CODE"));
		reqDef.setSdaGroupCode((String) map.get("SDA_GROUP_CODE"));
		reqDef.setSdaCmt((String) map.get("SDA_CMT"));
		return reqDef;
	}
}