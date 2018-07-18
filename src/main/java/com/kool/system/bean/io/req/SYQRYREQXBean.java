package com.kool.system.bean.io.req;

import com.kool.core.base.BaseBean;

/**
 * @AUTHOR LUYU
 */
public class SYQRYREQXBean extends BaseBean {
	protected String reqUrl;
	protected String name;
	protected String type;
	protected String signFlag;
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

	public String getSignFlag() {
		return signFlag;
	}

	public void setSignFlag(String signFlag) {
		this.signFlag = signFlag;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

}