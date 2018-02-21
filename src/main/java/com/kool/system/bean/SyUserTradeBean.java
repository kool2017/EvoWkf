package com.kool.system.bean;

import java.util.HashMap;
import java.util.Map;
import com.kool.core.base.BaseBean;

public class SyUserTradeBean extends BaseBean {
	protected String sutTradeId;
	protected boolean isInitSutTradeId;
	protected String sutTradeType;
	protected boolean isInitSutTradeType;
	protected java.sql.Timestamp sutTradeTime;
	protected boolean isInitSutTradeTime;
	protected String sutOprUserId;
	protected boolean isInitSutOprUserId;
	protected String sutOprLoginName;
	protected boolean isInitSutOprLoginName;
	protected String sutLoginName;
	protected boolean isInitSutLoginName;
	protected String sutPhone;
	protected boolean isInitSutPhone;
	protected String sutMail;
	protected boolean isInitSutMail;
	protected String sutFace;
	protected boolean isInitSutFace;
	protected String sutRecordId;
	protected boolean isInitSutRecordId;
	protected String sutTradeStatus;
	protected boolean isInitSutTradeStatus;

	public boolean getIsInitSutTradeId() {
		return this.isInitSutTradeId;
	}

	public boolean getIsInitSutTradeType() {
		return this.isInitSutTradeType;
	}

	public boolean getIsInitSutTradeTime() {
		return this.isInitSutTradeTime;
	}

	public boolean getIsInitSutOprUserId() {
		return this.isInitSutOprUserId;
	}

	public boolean getIsInitSutOprLoginName() {
		return this.isInitSutOprLoginName;
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

	public boolean getIsInitSutRecordId() {
		return this.isInitSutRecordId;
	}

	public boolean getIsInitSutTradeStatus() {
		return this.isInitSutTradeStatus;
	}

	public String getSutTradeId() {
		return sutTradeId;
	}

	public void setSutTradeId(String sutTradeId) {
		this.sutTradeId = sutTradeId;
		this.isInitSutTradeId = true;
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

	public String getSutOprUserId() {
		return sutOprUserId;
	}

	public void setSutOprUserId(String sutOprUserId) {
		this.sutOprUserId = sutOprUserId;
		this.isInitSutOprUserId = true;
	}

	public String getSutOprLoginName() {
		return sutOprLoginName;
	}

	public void setSutOprLoginName(String sutOprLoginName) {
		this.sutOprLoginName = sutOprLoginName;
		this.isInitSutOprLoginName = true;
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

	public String getSutRecordId() {
		return sutRecordId;
	}

	public void setSutRecordId(String sutRecordId) {
		this.sutRecordId = sutRecordId;
		this.isInitSutRecordId = true;
	}

	public String getSutTradeStatus() {
		return sutTradeStatus;
	}

	public void setSutTradeStatus(String sutTradeStatus) {
		this.sutTradeStatus = sutTradeStatus;
		this.isInitSutTradeStatus = true;
	}

	public Map<String, String> toMap() {
		Map<String, String> map = new HashMap<String, String>();
		if (isInitSutTradeId) {
			map.put("sutTradeId", formatString(sutTradeId));
		}
		if (isInitSutTradeType) {
			map.put("sutTradeType", formatString(sutTradeType));
		}
		if (isInitSutTradeTime) {
			map.put("sutTradeTime", formatString(sutTradeTime));
		}
		if (isInitSutOprUserId) {
			map.put("sutOprUserId", formatString(sutOprUserId));
		}
		if (isInitSutOprLoginName) {
			map.put("sutOprLoginName", formatString(sutOprLoginName));
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
		if (isInitSutRecordId) {
			map.put("sutRecordId", formatString(sutRecordId));
		}
		if (isInitSutTradeStatus) {
			map.put("sutTradeStatus", formatString(sutTradeStatus));
		}

		return map;
	}
}
