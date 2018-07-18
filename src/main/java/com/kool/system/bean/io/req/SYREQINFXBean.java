package com.kool.system.bean.io.req;

import com.kool.core.base.BaseBean;

/**
 * @AUTHOR LUYU
 */
public class SYREQINFXBean extends BaseBean {
	protected String reqUrl;
	protected String name;
	protected String type;
	protected String dbpoolType;
	protected String dbpoolCode;
	protected String msgType;
	protected String signFlag;
	protected String encrypt;
	protected String channel;

	public String getReqUrl() {
		return reqUrl;
	}

	public void setReqUrl(String reqUrl) {
		this.reqUrl = reqUrl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDbpoolType() {
		return dbpoolType;
	}

	public void setDbpoolType(String dbpoolType) {
		this.dbpoolType = dbpoolType;
	}

	public String getDbpoolCode() {
		return dbpoolCode;
	}

	public void setDbpoolCode(String dbpoolCode) {
		this.dbpoolCode = dbpoolCode;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public String getSignFlag() {
		return signFlag;
	}

	public void setSignFlag(String signFlag) {
		this.signFlag = signFlag;
	}

	public String getEncrypt() {
		return encrypt;
	}

	public void setEncrypt(String encrypt) {
		this.encrypt = encrypt;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

}