package com.kool.system.bean;

import java.util.HashMap;
import java.util.Map;
import com.kool.core.base.BaseBean;

/**
 * @AUTHOR LUYU
 */
public class SyUserTradeBean extends BaseBean {
	protected String sutTradeUid;
	protected boolean isInitSutTradeUid;
	protected String sutTradeType;
	protected boolean isInitSutTradeType;
	protected java.sql.Timestamp sutTradeTime;
	protected boolean isInitSutTradeTime;
	protected String sutOprUserCid;
	protected boolean isInitSutOprUserCid;
	protected String sutOprName;
	protected boolean isInitSutOprName;
	protected String sutLoginName;
	protected boolean isInitSutLoginName;
	protected String sutPhone;
	protected boolean isInitSutPhone;
	protected String sutMail;
	protected boolean isInitSutMail;
	protected String sutFace;
	protected boolean isInitSutFace;
	protected String sutWkfNbr;
	protected boolean isInitSutWkfNbr;
	protected String sutHasKey;
	protected boolean isInitSutHasKey;
	protected String sutKeyUid;
	protected boolean isInitSutKeyUid;
	protected String sutStaffCid;
	protected boolean isInitSutStaffCid;
	protected String sutState;
	protected boolean isInitSutState;

	public boolean getIsInitSutTradeUid() {
		return this.isInitSutTradeUid;
	}

	public boolean getIsInitSutTradeType() {
		return this.isInitSutTradeType;
	}

	public boolean getIsInitSutTradeTime() {
		return this.isInitSutTradeTime;
	}

	public boolean getIsInitSutOprUserCid() {
		return this.isInitSutOprUserCid;
	}

	public boolean getIsInitSutOprName() {
		return this.isInitSutOprName;
	}

	public boolean getIsInitSutLoginName() {
		return this.isInitSutLoginName;
	}

	public boolean getIsInitSutPhone() {
		return this.isInitSutPhone;
	}

	public boolean getIsInitSutMail() {
		return this.isInitSutMail;
	}

	public boolean getIsInitSutFace() {
		return this.isInitSutFace;
	}

	public boolean getIsInitSutWkfNbr() {
		return this.isInitSutWkfNbr;
	}

	public boolean getIsInitSutHasKey() {
		return this.isInitSutHasKey;
	}

	public boolean getIsInitSutKeyUid() {
		return this.isInitSutKeyUid;
	}

	public boolean getIsInitSutStaffCid() {
		return this.isInitSutStaffCid;
	}

	public boolean getIsInitSutState() {
		return this.isInitSutState;
	}

	public String getSutTradeUid() {
		return sutTradeUid;
	}

	public void setSutTradeUid(String sutTradeUid) {
		this.sutTradeUid = sutTradeUid;
		this.isInitSutTradeUid = true;
	}

	public String getSutTradeType() {
		return sutTradeType;
	}

	public void setSutTradeType(String sutTradeType) {
		this.sutTradeType = sutTradeType;
		this.isInitSutTradeType = true;
	}

	public java.sql.Timestamp getSutTradeTime() {
		return sutTradeTime;
	}

	public void setSutTradeTime(java.sql.Timestamp sutTradeTime) {
		this.sutTradeTime = sutTradeTime;
		this.isInitSutTradeTime = true;
	}

	public String getSutOprUserCid() {
		return sutOprUserCid;
	}

	public void setSutOprUserCid(String sutOprUserCid) {
		this.sutOprUserCid = sutOprUserCid;
		this.isInitSutOprUserCid = true;
	}

	public String getSutOprName() {
		return sutOprName;
	}

	public void setSutOprName(String sutOprName) {
		this.sutOprName = sutOprName;
		this.isInitSutOprName = true;
	}

	public String getSutLoginName() {
		return sutLoginName;
	}

	public void setSutLoginName(String sutLoginName) {
		this.sutLoginName = sutLoginName;
		this.isInitSutLoginName = true;
	}

	public String getSutPhone() {
		return sutPhone;
	}

	public void setSutPhone(String sutPhone) {
		this.sutPhone = sutPhone;
		this.isInitSutPhone = true;
	}

	public String getSutMail() {
		return sutMail;
	}

	public void setSutMail(String sutMail) {
		this.sutMail = sutMail;
		this.isInitSutMail = true;
	}

	public String getSutFace() {
		return sutFace;
	}

	public void setSutFace(String sutFace) {
		this.sutFace = sutFace;
		this.isInitSutFace = true;
	}

	public String getSutWkfNbr() {
		return sutWkfNbr;
	}

	public void setSutWkfNbr(String sutWkfNbr) {
		this.sutWkfNbr = sutWkfNbr;
		this.isInitSutWkfNbr = true;
	}

	public String getSutHasKey() {
		return sutHasKey;
	}

	public void setSutHasKey(String sutHasKey) {
		this.sutHasKey = sutHasKey;
		this.isInitSutHasKey = true;
	}

	public String getSutKeyUid() {
		return sutKeyUid;
	}

	public void setSutKeyUid(String sutKeyUid) {
		this.sutKeyUid = sutKeyUid;
		this.isInitSutKeyUid = true;
	}

	public String getSutStaffCid() {
		return sutStaffCid;
	}

	public void setSutStaffCid(String sutStaffCid) {
		this.sutStaffCid = sutStaffCid;
		this.isInitSutStaffCid = true;
	}

	public String getSutState() {
		return sutState;
	}

	public void setSutState(String sutState) {
		this.sutState = sutState;
		this.isInitSutState = true;
	}

	public Map<String, String> toMap() {
		Map<String, String> map = new HashMap<String, String>();
		if (isInitSutTradeUid) {
			map.put("sutTradeUid", formatString(sutTradeUid));
		}
		if (isInitSutTradeType) {
			map.put("sutTradeType", formatString(sutTradeType));
		}
		if (isInitSutTradeTime) {
			map.put("sutTradeTime", formatString(sutTradeTime));
		}
		if (isInitSutOprUserCid) {
			map.put("sutOprUserCid", formatString(sutOprUserCid));
		}
		if (isInitSutOprName) {
			map.put("sutOprName", formatString(sutOprName));
		}
		if (isInitSutLoginName) {
			map.put("sutLoginName", formatString(sutLoginName));
		}
		if (isInitSutPhone) {
			map.put("sutPhone", formatString(sutPhone));
		}
		if (isInitSutMail) {
			map.put("sutMail", formatString(sutMail));
		}
		if (isInitSutFace) {
			map.put("sutFace", formatString(sutFace));
		}
		if (isInitSutWkfNbr) {
			map.put("sutWkfNbr", formatString(sutWkfNbr));
		}
		if (isInitSutHasKey) {
			map.put("sutHasKey", formatString(sutHasKey));
		}
		if (isInitSutKeyUid) {
			map.put("sutKeyUid", formatString(sutKeyUid));
		}
		if (isInitSutStaffCid) {
			map.put("sutStaffCid", formatString(sutStaffCid));
		}
		if (isInitSutState) {
			map.put("sutState", formatString(sutState));
		}

		return map;
	}

	public static SyUserTradeBean DBResultToBean(Map<String, Object> map) {
		if (null == map) {
			return null;
		}
		SyUserTradeBean reqDef = new SyUserTradeBean();
		reqDef.setSutTradeUid((String) map.get("SUT_TRADE_UID"));
		reqDef.setSutTradeType((String) map.get("SUT_TRADE_TYPE"));
		reqDef.setSutTradeTime((java.sql.Timestamp) map.get("SUT_TRADE_TIME"));
		reqDef.setSutOprUserCid((String) map.get("SUT_OPR_USER_CID"));
		reqDef.setSutOprName((String) map.get("SUT_OPR_NAME"));
		reqDef.setSutLoginName((String) map.get("SUT_LOGIN_NAME"));
		reqDef.setSutPhone((String) map.get("SUT_PHONE"));
		reqDef.setSutMail((String) map.get("SUT_MAIL"));
		reqDef.setSutFace((String) map.get("SUT_FACE"));
		reqDef.setSutWkfNbr((String) map.get("SUT_WKF_NBR"));
		reqDef.setSutHasKey((String) map.get("SUT_HAS_KEY"));
		reqDef.setSutKeyUid((String) map.get("SUT_KEY_UID"));
		reqDef.setSutStaffCid((String) map.get("SUT_STAFF_CID"));
		reqDef.setSutState((String) map.get("SUT_STATE"));
		return reqDef;
	}
}