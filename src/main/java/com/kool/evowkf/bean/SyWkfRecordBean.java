package com.kool.evowkf.bean;

import java.util.HashMap;
import java.util.Map;
import com.kool.core.base.BaseBean;

public class SyWkfRecordBean extends BaseBean {
	protected String srcWkfNbr;
	protected boolean isInitSrcWkfNbr;
	protected java.sql.Timestamp srcTimeBegin;
	protected boolean isInitSrcTimeBegin;
	protected java.sql.Timestamp srcTimeEnd;
	protected boolean isInitSrcTimeEnd;
	protected String srcWkfCode;
	protected boolean isInitSrcWkfCode;
	protected String srcEntityCid;
	protected boolean isInitSrcEntityCid;
	protected String srcBusinessId;
	protected boolean isInitSrcBusinessId;
	protected String srcBusinessType;
	protected boolean isInitSrcBusinessType;
	protected String srcNodeHead;
	protected boolean isInitSrcNodeHead;
	protected String srcNodeHeadName;
	protected boolean isInitSrcNodeHeadName;
	protected String srcStartUserCid;
	protected boolean isInitSrcStartUserCid;
	protected String srcStartLoginName;
	protected boolean isInitSrcStartLoginName;
	protected String srcEndUserCid;
	protected boolean isInitSrcEndUserCid;
	protected String srcEndLoginName;
	protected boolean isInitSrcEndLoginName;
	protected String srcDescription;
	protected boolean isInitSrcDescription;
	protected String srcState;
	protected boolean isInitSrcState;

	public boolean getIsInitSrcWkfNbr() {
		return this.isInitSrcWkfNbr;
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

	public boolean getIsInitSrcEntityCid() {
		return this.isInitSrcEntityCid;
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

	public boolean getIsInitSrcStartUserCid() {
		return this.isInitSrcStartUserCid;
	}

	public boolean getIsInitSrcStartLoginName() {
		return this.isInitSrcStartLoginName;
	}

	public boolean getIsInitSrcEndUserCid() {
		return this.isInitSrcEndUserCid;
	}

	public boolean getIsInitSrcEndLoginName() {
		return this.isInitSrcEndLoginName;
	}

	public boolean getIsInitSrcDescription() {
		return this.isInitSrcDescription;
	}

	public boolean getIsInitSrcState() {
		return this.isInitSrcState;
	}

	public String getSrcWkfNbr() {
		return srcWkfNbr;
	}

	public void setSrcWkfNbr(String srcWkfNbr) {
		this.srcWkfNbr = srcWkfNbr;
		this.isInitSrcWkfNbr = true;
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

	public String getSrcEntityCid() {
		return srcEntityCid;
	}

	public void setSrcEntityCid(String srcEntityCid) {
		this.srcEntityCid = srcEntityCid;
		this.isInitSrcEntityCid = true;
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

	public String getSrcStartUserCid() {
		return srcStartUserCid;
	}

	public void setSrcStartUserCid(String srcStartUserCid) {
		this.srcStartUserCid = srcStartUserCid;
		this.isInitSrcStartUserCid = true;
	}

	public String getSrcStartLoginName() {
		return srcStartLoginName;
	}

	public void setSrcStartLoginName(String srcStartLoginName) {
		this.srcStartLoginName = srcStartLoginName;
		this.isInitSrcStartLoginName = true;
	}

	public String getSrcEndUserCid() {
		return srcEndUserCid;
	}

	public void setSrcEndUserCid(String srcEndUserCid) {
		this.srcEndUserCid = srcEndUserCid;
		this.isInitSrcEndUserCid = true;
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

	public String getSrcState() {
		return srcState;
	}

	public void setSrcState(String srcState) {
		this.srcState = srcState;
		this.isInitSrcState = true;
	}

	public Map<String, String> toMap() {
		Map<String, String> map = new HashMap<String, String>();
		if (isInitSrcWkfNbr) {
			map.put("srcWkfNbr", formatString(srcWkfNbr));
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
		if (isInitSrcEntityCid) {
			map.put("srcEntityCid", formatString(srcEntityCid));
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
		if (isInitSrcStartUserCid) {
			map.put("srcStartUserCid", formatString(srcStartUserCid));
		}
		if (isInitSrcStartLoginName) {
			map.put("srcStartLoginName", formatString(srcStartLoginName));
		}
		if (isInitSrcEndUserCid) {
			map.put("srcEndUserCid", formatString(srcEndUserCid));
		}
		if (isInitSrcEndLoginName) {
			map.put("srcEndLoginName", formatString(srcEndLoginName));
		}
		if (isInitSrcDescription) {
			map.put("srcDescription", formatString(srcDescription));
		}
		if (isInitSrcState) {
			map.put("srcState", formatString(srcState));
		}

		return map;
	}
}
