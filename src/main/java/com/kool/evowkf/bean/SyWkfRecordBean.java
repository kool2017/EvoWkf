package com.kool.evowkf.bean;

import java.util.HashMap;
import java.util.Map;
import com.kool.core.base.BaseBean;

public class SyWkfRecordBean extends BaseBean {
	protected String srcRecordId;
	protected boolean isInitSrcRecordId;
	protected java.sql.Timestamp srcTimeBegin;
	protected boolean isInitSrcTimeBegin;
	protected java.sql.Timestamp srcTimeEnd;
	protected boolean isInitSrcTimeEnd;
	protected String srcWkfCode;
	protected boolean isInitSrcWkfCode;
	protected String srcEntityId;
	protected boolean isInitSrcEntityId;
	protected String srcBusinessId;
	protected boolean isInitSrcBusinessId;
	protected String srcBusinessType;
	protected boolean isInitSrcBusinessType;
	protected String srcNodeHead;
	protected boolean isInitSrcNodeHead;
	protected String srcNodeHeadName;
	protected boolean isInitSrcNodeHeadName;
	protected String srcStartUserId;
	protected boolean isInitSrcStartUserId;
	protected String srcStartLoginName;
	protected boolean isInitSrcStartLoginName;
	protected String srcEndUserId;
	protected boolean isInitSrcEndUserId;
	protected String srcEndLoginName;
	protected boolean isInitSrcEndLoginName;
	protected String srcDescription;
	protected boolean isInitSrcDescription;
	protected String srcRecordStatus;
	protected boolean isInitSrcRecordStatus;

	public boolean getIsInitSrcRecordId() {
		return this.isInitSrcRecordId;
	}

	public boolean getIsInitSrcTimeBegin() {
		return this.isInitSrcTimeBegin;
	}

	public boolean getIsInitSrcTimeEnd() {
		return this.isInitSrcTimeEnd;
	}

	public boolean getIsInitSrcWkfCode() {
		return this.isInitSrcWkfCode;
	}

	public boolean getIsInitSrcEntityId() {
		return this.isInitSrcEntityId;
	}

	public boolean getIsInitSrcBusinessId() {
		return this.isInitSrcBusinessId;
	}

	public boolean getIsInitSrcBusinessType() {
		return this.isInitSrcBusinessType;
	}

	public boolean getIsInitSrcNodeHead() {
		return this.isInitSrcNodeHead;
	}

	public boolean getIsInitSrcNodeHeadName() {
		return this.isInitSrcNodeHeadName;
	}

	public boolean getIsInitSrcStartUserId() {
		return this.isInitSrcStartUserId;
	}

	public boolean getIsInitSrcStartLoginName() {
		return this.isInitSrcStartLoginName;
	}

	public boolean getIsInitSrcEndUserId() {
		return this.isInitSrcEndUserId;
	}

	public boolean getIsInitSrcEndLoginName() {
		return this.isInitSrcEndLoginName;
	}

	public boolean getIsInitSrcDescription() {
		return this.isInitSrcDescription;
	}

	public boolean getIsInitSrcRecordStatus() {
		return this.isInitSrcRecordStatus;
	}

	public String getSrcRecordId() {
		return srcRecordId;
	}

	public void setSrcRecordId(String srcRecordId) {
		this.srcRecordId = srcRecordId;
		this.isInitSrcRecordId = true;
	}

	public java.sql.Timestamp getSrcTimeBegin() {
		return srcTimeBegin;
	}

	public void setSrcTimeBegin(java.sql.Timestamp srcTimeBegin) {
		this.srcTimeBegin = srcTimeBegin;
		this.isInitSrcTimeBegin = true;
	}

	public java.sql.Timestamp getSrcTimeEnd() {
		return srcTimeEnd;
	}

	public void setSrcTimeEnd(java.sql.Timestamp srcTimeEnd) {
		this.srcTimeEnd = srcTimeEnd;
		this.isInitSrcTimeEnd = true;
	}

	public String getSrcWkfCode() {
		return srcWkfCode;
	}

	public void setSrcWkfCode(String srcWkfCode) {
		this.srcWkfCode = srcWkfCode;
		this.isInitSrcWkfCode = true;
	}

	public String getSrcEntityId() {
		return srcEntityId;
	}

	public void setSrcEntityId(String srcEntityId) {
		this.srcEntityId = srcEntityId;
		this.isInitSrcEntityId = true;
	}

	public String getSrcBusinessId() {
		return srcBusinessId;
	}

	public void setSrcBusinessId(String srcBusinessId) {
		this.srcBusinessId = srcBusinessId;
		this.isInitSrcBusinessId = true;
	}

	public String getSrcBusinessType() {
		return srcBusinessType;
	}

	public void setSrcBusinessType(String srcBusinessType) {
		this.srcBusinessType = srcBusinessType;
		this.isInitSrcBusinessType = true;
	}

	public String getSrcNodeHead() {
		return srcNodeHead;
	}

	public void setSrcNodeHead(String srcNodeHead) {
		this.srcNodeHead = srcNodeHead;
		this.isInitSrcNodeHead = true;
	}

	public String getSrcNodeHeadName() {
		return srcNodeHeadName;
	}

	public void setSrcNodeHeadName(String srcNodeHeadName) {
		this.srcNodeHeadName = srcNodeHeadName;
		this.isInitSrcNodeHeadName = true;
	}

	public String getSrcStartUserId() {
		return srcStartUserId;
	}

	public void setSrcStartUserId(String srcStartUserId) {
		this.srcStartUserId = srcStartUserId;
		this.isInitSrcStartUserId = true;
	}

	public String getSrcStartLoginName() {
		return srcStartLoginName;
	}

	public void setSrcStartLoginName(String srcStartLoginName) {
		this.srcStartLoginName = srcStartLoginName;
		this.isInitSrcStartLoginName = true;
	}

	public String getSrcEndUserId() {
		return srcEndUserId;
	}

	public void setSrcEndUserId(String srcEndUserId) {
		this.srcEndUserId = srcEndUserId;
		this.isInitSrcEndUserId = true;
	}

	public String getSrcEndLoginName() {
		return srcEndLoginName;
	}

	public void setSrcEndLoginName(String srcEndLoginName) {
		this.srcEndLoginName = srcEndLoginName;
		this.isInitSrcEndLoginName = true;
	}

	public String getSrcDescription() {
		return srcDescription;
	}

	public void setSrcDescription(String srcDescription) {
		this.srcDescription = srcDescription;
		this.isInitSrcDescription = true;
	}

	public String getSrcRecordStatus() {
		return srcRecordStatus;
	}

	public void setSrcRecordStatus(String srcRecordStatus) {
		this.srcRecordStatus = srcRecordStatus;
		this.isInitSrcRecordStatus = true;
	}

	public Map<String, String> toMap() {
		Map<String, String> map = new HashMap<String, String>();
		if (isInitSrcRecordId) {
			map.put("srcRecordId", formatString(srcRecordId));
		}
		if (isInitSrcTimeBegin) {
			map.put("srcTimeBegin", formatString(srcTimeBegin));
		}
		if (isInitSrcTimeEnd) {
			map.put("srcTimeEnd", formatString(srcTimeEnd));
		}
		if (isInitSrcWkfCode) {
			map.put("srcWkfCode", formatString(srcWkfCode));
		}
		if (isInitSrcEntityId) {
			map.put("srcEntityId", formatString(srcEntityId));
		}
		if (isInitSrcBusinessId) {
			map.put("srcBusinessId", formatString(srcBusinessId));
		}
		if (isInitSrcBusinessType) {
			map.put("srcBusinessType", formatString(srcBusinessType));
		}
		if (isInitSrcNodeHead) {
			map.put("srcNodeHead", formatString(srcNodeHead));
		}
		if (isInitSrcNodeHeadName) {
			map.put("srcNodeHeadName", formatString(srcNodeHeadName));
		}
		if (isInitSrcStartUserId) {
			map.put("srcStartUserId", formatString(srcStartUserId));
		}
		if (isInitSrcStartLoginName) {
			map.put("srcStartLoginName", formatString(srcStartLoginName));
		}
		if (isInitSrcEndUserId) {
			map.put("srcEndUserId", formatString(srcEndUserId));
		}
		if (isInitSrcEndLoginName) {
			map.put("srcEndLoginName", formatString(srcEndLoginName));
		}
		if (isInitSrcDescription) {
			map.put("srcDescription", formatString(srcDescription));
		}
		if (isInitSrcRecordStatus) {
			map.put("srcRecordStatus", formatString(srcRecordStatus));
		}

		return map;
	}
}
