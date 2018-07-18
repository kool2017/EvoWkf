package com.kool.system.bean.io.req;

import com.kool.core.base.BaseBean;
import com.kool.core.exception.AppException;
import com.kool.core.util.StringUtils;
import com.kool.core.validate.IIoValidate;

/**
 * @AUTHOR LUYU
 */
public class SYREQINFYBean extends BaseBean implements IIoValidate {
	protected String reqUrl;
	protected String name;
	protected String dbpoolType;
	protected String dbpoolCode;
	protected String msgType;
	protected String signFlag;
	protected String encrypt;
	protected String channel;
	protected String state;

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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public void validate() throws AppException {
		//非空校验
		if (StringUtils.isEmpty(reqUrl)) {
			throw new AppException("SY000036","reqUrl");//字段[%1]为空
		}
		//最大长度校验
		if (reqUrl != null && reqUrl.length()>60) {
			throw new AppException("SY000038","reqUrl",String.valueOf(60));//字段[%1]大于最大长度[%2]
		}
		//非空校验
		if (StringUtils.isEmpty(name)) {
			throw new AppException("SY000036","name");//字段[%1]为空
		}
		//最大长度校验
		if (name != null && name.length()>60) {
			throw new AppException("SY000038","name",String.valueOf(60));//字段[%1]大于最大长度[%2]
		}
		//非空校验
		if (StringUtils.isEmpty(dbpoolType)) {
			throw new AppException("SY000036","dbpoolType");//字段[%1]为空
		}
		//最大长度校验
		if (dbpoolCode != null && dbpoolCode.length()>20) {
			throw new AppException("SY000038","dbpoolCode",String.valueOf(20));//字段[%1]大于最大长度[%2]
		}
		//非空校验
		if (StringUtils.isEmpty(msgType)) {
			throw new AppException("SY000036","msgType");//字段[%1]为空
		}
		//非空校验
		if (StringUtils.isEmpty(signFlag)) {
			throw new AppException("SY000036","signFlag");//字段[%1]为空
		}
		//非空校验
		if (StringUtils.isEmpty(encrypt)) {
			throw new AppException("SY000036","encrypt");//字段[%1]为空
		}
		//非空校验
		if (StringUtils.isEmpty(channel)) {
			throw new AppException("SY000036","channel");//字段[%1]为空
		}
		//非空校验
		if (StringUtils.isEmpty(state)) {
			throw new AppException("SY000036","state");//字段[%1]为空
		}
	}
}