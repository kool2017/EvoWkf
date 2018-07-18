package com.kool.system.bean;

import java.util.HashMap;
import java.util.Map;
import com.kool.core.base.BaseBean;

/**
 * @AUTHOR LUYU
 */
public class SyNtfRecordHisBean extends BaseBean {
	protected String snrNtfUid;
	protected boolean isInitSnrNtfUid;
	protected String snrTopic;
	protected boolean isInitSnrTopic;
	protected String snrContent;
	protected boolean isInitSnrContent;
	protected String snrType;
	protected boolean isInitSnrType;
	protected String snrSender;
	protected boolean isInitSnrSender;
	protected String snrSenderName;
	protected boolean isInitSnrSenderName;
	protected String snrReceiver;
	protected boolean isInitSnrReceiver;
	protected String snrReceiverName;
	protected boolean isInitSnrReceiverName;
	protected java.sql.Timestamp snrSendTime;
	protected boolean isInitSnrSendTime;
	protected java.sql.Timestamp snrCheckTime;
	protected boolean isInitSnrCheckTime;
	protected String snrState;
	protected boolean isInitSnrState;

	public boolean getIsInitSnrNtfUid() {
		return this.isInitSnrNtfUid;
	}

	public boolean getIsInitSnrTopic() {
		return this.isInitSnrTopic;
	}

	public boolean getIsInitSnrContent() {
		return this.isInitSnrContent;
	}

	public boolean getIsInitSnrType() {
		return this.isInitSnrType;
	}

	public boolean getIsInitSnrSender() {
		return this.isInitSnrSender;
	}

	public boolean getIsInitSnrSenderName() {
		return this.isInitSnrSenderName;
	}

	public boolean getIsInitSnrReceiver() {
		return this.isInitSnrReceiver;
	}

	public boolean getIsInitSnrReceiverName() {
		return this.isInitSnrReceiverName;
	}

	public boolean getIsInitSnrSendTime() {
		return this.isInitSnrSendTime;
	}

	public boolean getIsInitSnrCheckTime() {
		return this.isInitSnrCheckTime;
	}

	public boolean getIsInitSnrState() {
		return this.isInitSnrState;
	}

	public String getSnrNtfUid() {
		return snrNtfUid;
	}

	public void setSnrNtfUid(String snrNtfUid) {
		this.snrNtfUid = snrNtfUid;
		this.isInitSnrNtfUid = true;
	}

	public String getSnrTopic() {
		return snrTopic;
	}

	public void setSnrTopic(String snrTopic) {
		this.snrTopic = snrTopic;
		this.isInitSnrTopic = true;
	}

	public String getSnrContent() {
		return snrContent;
	}

	public void setSnrContent(String snrContent) {
		this.snrContent = snrContent;
		this.isInitSnrContent = true;
	}

	public String getSnrType() {
		return snrType;
	}

	public void setSnrType(String snrType) {
		this.snrType = snrType;
		this.isInitSnrType = true;
	}

	public String getSnrSender() {
		return snrSender;
	}

	public void setSnrSender(String snrSender) {
		this.snrSender = snrSender;
		this.isInitSnrSender = true;
	}

	public String getSnrSenderName() {
		return snrSenderName;
	}

	public void setSnrSenderName(String snrSenderName) {
		this.snrSenderName = snrSenderName;
		this.isInitSnrSenderName = true;
	}

	public String getSnrReceiver() {
		return snrReceiver;
	}

	public void setSnrReceiver(String snrReceiver) {
		this.snrReceiver = snrReceiver;
		this.isInitSnrReceiver = true;
	}

	public String getSnrReceiverName() {
		return snrReceiverName;
	}

	public void setSnrReceiverName(String snrReceiverName) {
		this.snrReceiverName = snrReceiverName;
		this.isInitSnrReceiverName = true;
	}

	public java.sql.Timestamp getSnrSendTime() {
		return snrSendTime;
	}

	public void setSnrSendTime(java.sql.Timestamp snrSendTime) {
		this.snrSendTime = snrSendTime;
		this.isInitSnrSendTime = true;
	}

	public java.sql.Timestamp getSnrCheckTime() {
		return snrCheckTime;
	}

	public void setSnrCheckTime(java.sql.Timestamp snrCheckTime) {
		this.snrCheckTime = snrCheckTime;
		this.isInitSnrCheckTime = true;
	}

	public String getSnrState() {
		return snrState;
	}

	public void setSnrState(String snrState) {
		this.snrState = snrState;
		this.isInitSnrState = true;
	}

	public Map<String, String> toMap() {
		Map<String, String> map = new HashMap<String, String>();
		if (isInitSnrNtfUid) {
			map.put("snrNtfUid", formatString(snrNtfUid));
		}
		if (isInitSnrTopic) {
			map.put("snrTopic", formatString(snrTopic));
		}
		if (isInitSnrContent) {
			map.put("snrContent", formatString(snrContent));
		}
		if (isInitSnrType) {
			map.put("snrType", formatString(snrType));
		}
		if (isInitSnrSender) {
			map.put("snrSender", formatString(snrSender));
		}
		if (isInitSnrSenderName) {
			map.put("snrSenderName", formatString(snrSenderName));
		}
		if (isInitSnrReceiver) {
			map.put("snrReceiver", formatString(snrReceiver));
		}
		if (isInitSnrReceiverName) {
			map.put("snrReceiverName", formatString(snrReceiverName));
		}
		if (isInitSnrSendTime) {
			map.put("snrSendTime", formatString(snrSendTime));
		}
		if (isInitSnrCheckTime) {
			map.put("snrCheckTime", formatString(snrCheckTime));
		}
		if (isInitSnrState) {
			map.put("snrState", formatString(snrState));
		}

		return map;
	}

	public static SyNtfRecordHisBean DBResultToBean(Map<String, Object> map) {
		if (null == map) {
			return null;
		}
		SyNtfRecordHisBean reqDef = new SyNtfRecordHisBean();
		reqDef.setSnrNtfUid((String) map.get("SNR_NTF_UID"));
		reqDef.setSnrTopic((String) map.get("SNR_TOPIC"));
		reqDef.setSnrContent((String) map.get("SNR_CONTENT"));
		reqDef.setSnrType((String) map.get("SNR_TYPE"));
		reqDef.setSnrSender((String) map.get("SNR_SENDER"));
		reqDef.setSnrSenderName((String) map.get("SNR_SENDER_NAME"));
		reqDef.setSnrReceiver((String) map.get("SNR_RECEIVER"));
		reqDef.setSnrReceiverName((String) map.get("SNR_RECEIVER_NAME"));
		reqDef.setSnrSendTime((java.sql.Timestamp) map.get("SNR_SEND_TIME"));
		reqDef.setSnrCheckTime((java.sql.Timestamp) map.get("SNR_CHECK_TIME"));
		reqDef.setSnrState((String) map.get("SNR_STATE"));
		return reqDef;
	}
}