package com.kool.system.bean;

import java.util.HashMap;
import java.util.Map;
import com.kool.core.base.BaseBean;

/**
 * @AUTHOR LUYU
 */
public class SyReqDefBean extends BaseBean {
	protected String srdReqUrl;
	protected boolean isInitSrdReqUrl;
	protected String srdName;
	protected boolean isInitSrdName;
	protected String srdDbpoolType;
	protected boolean isInitSrdDbpoolType;
	protected String srdDbpoolCode;
	protected boolean isInitSrdDbpoolCode;
	protected String srdMsgType;
	protected boolean isInitSrdMsgType;
	protected String srdSignFlag;
	protected boolean isInitSrdSignFlag;
	protected String srdEncrypt;
	protected boolean isInitSrdEncrypt;
	protected String srdChannel;
	protected boolean isInitSrdChannel;
	protected String srdState;
	protected boolean isInitSrdState;

	public boolean getIsInitSrdReqUrl() {
		return this.isInitSrdReqUrl;
	}

	public boolean getIsInitSrdName() {
		return this.isInitSrdName;
	}

	public boolean getIsInitSrdDbpoolType() {
		return this.isInitSrdDbpoolType;
	}

	public boolean getIsInitSrdDbpoolCode() {
		return this.isInitSrdDbpoolCode;
	}

	public boolean getIsInitSrdMsgType() {
		return this.isInitSrdMsgType;
	}

	public boolean getIsInitSrdSignFlag() {
		return this.isInitSrdSignFlag;
	}

	public boolean getIsInitSrdEncrypt() {
		return this.isInitSrdEncrypt;
	}

	public boolean getIsInitSrdChannel() {
		return this.isInitSrdChannel;
	}

	public boolean getIsInitSrdState() {
		return this.isInitSrdState;
	}

	public String getSrdReqUrl() {
		return srdReqUrl;
	}

	public void setSrdReqUrl(String srdReqUrl) {
		this.srdReqUrl = srdReqUrl;
		this.isInitSrdReqUrl = true;
	}

	public String getSrdName() {
		return srdName;
	}

	public void setSrdName(String srdName) {
		this.srdName = srdName;
		this.isInitSrdName = true;
	}

	public String getSrdDbpoolType() {
		return srdDbpoolType;
	}

	public void setSrdDbpoolType(String srdDbpoolType) {
		this.srdDbpoolType = srdDbpoolType;
		this.isInitSrdDbpoolType = true;
	}

	public String getSrdDbpoolCode() {
		return srdDbpoolCode;
	}

	public void setSrdDbpoolCode(String srdDbpoolCode) {
		this.srdDbpoolCode = srdDbpoolCode;
		this.isInitSrdDbpoolCode = true;
	}

	public String getSrdMsgType() {
		return srdMsgType;
	}

	public void setSrdMsgType(String srdMsgType) {
		this.srdMsgType = srdMsgType;
		this.isInitSrdMsgType = true;
	}

	public String getSrdSignFlag() {
		return srdSignFlag;
	}

	public void setSrdSignFlag(String srdSignFlag) {
		this.srdSignFlag = srdSignFlag;
		this.isInitSrdSignFlag = true;
	}

	public String getSrdEncrypt() {
		return srdEncrypt;
	}

	public void setSrdEncrypt(String srdEncrypt) {
		this.srdEncrypt = srdEncrypt;
		this.isInitSrdEncrypt = true;
	}

	public String getSrdChannel() {
		return srdChannel;
	}

	public void setSrdChannel(String srdChannel) {
		this.srdChannel = srdChannel;
		this.isInitSrdChannel = true;
	}

	public String getSrdState() {
		return srdState;
	}

	public void setSrdState(String srdState) {
		this.srdState = srdState;
		this.isInitSrdState = true;
	}

	public Map<String, String> toMap() {
		Map<String, String> map = new HashMap<String, String>();
		if (isInitSrdReqUrl) {
			map.put("srdReqUrl", formatString(srdReqUrl));
		}
		if (isInitSrdName) {
			map.put("srdName", formatString(srdName));
		}
		if (isInitSrdDbpoolType) {
			map.put("srdDbpoolType", formatString(srdDbpoolType));
		}
		if (isInitSrdDbpoolCode) {
			map.put("srdDbpoolCode", formatString(srdDbpoolCode));
		}
		if (isInitSrdMsgType) {
			map.put("srdMsgType", formatString(srdMsgType));
		}
		if (isInitSrdSignFlag) {
			map.put("srdSignFlag", formatString(srdSignFlag));
		}
		if (isInitSrdEncrypt) {
			map.put("srdEncrypt", formatString(srdEncrypt));
		}
		if (isInitSrdChannel) {
			map.put("srdChannel", formatString(srdChannel));
		}
		if (isInitSrdState) {
			map.put("srdState", formatString(srdState));
		}

		return map;
	}

	public static SyReqDefBean DBResultToBean(Map<String, Object> map) {
		if (null == map) {
			return null;
		}
		SyReqDefBean reqDef = new SyReqDefBean();
		reqDef.setSrdReqUrl((String) map.get("SRD_REQ_URL"));
		reqDef.setSrdName((String) map.get("SRD_NAME"));
		reqDef.setSrdDbpoolType((String) map.get("SRD_DBPOOL_TYPE"));
		reqDef.setSrdDbpoolCode((String) map.get("SRD_DBPOOL_CODE"));
		reqDef.setSrdMsgType((String) map.get("SRD_MSG_TYPE"));
		reqDef.setSrdSignFlag((String) map.get("SRD_SIGN_FLAG"));
		reqDef.setSrdEncrypt((String) map.get("SRD_ENCRYPT"));
		reqDef.setSrdChannel((String) map.get("SRD_CHANNEL"));
		reqDef.setSrdState((String) map.get("SRD_STATE"));
		return reqDef;
	}
}