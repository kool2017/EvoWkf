/**
 * @PROJECT 
 * @DATE 2018年1月19日 下午9:01:15
 * @AUTHOR LUYU
 */
package com.kool.core.context;

import javax.servlet.http.HttpServletRequest;

import com.kool.system.bean.SyReqDefBean;

/**
 * @DESCRIBE 请求上下文
 * @AUTHOR LUYU
 * @DATE 2018年1月19日 下午9:01:15
 *
 */
public class ReqContext extends BaseContext {
	private HttpServletRequest request;
	private LoginInfo loginInfo;
	private String ip;
	private SyReqDefBean reqDef;
	private String userCid;
	private String channelId;
	private String sign;
	private String time;

	/**
	 * @return the userCid
	 */
	public String getUserCid() {
		return userCid;
	}

	/**
	 * @param userCid
	 *            the userCid to set
	 */
	public void setUserCid(String userCid) {
		this.userCid = userCid;
	}

	/**
	 * @return the channelId
	 */
	public String getChannelId() {
		return channelId;
	}

	/**
	 * @param channelId
	 *            the channelId to set
	 */
	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	/**
	 * @return the sign
	 */
	public String getSign() {
		return sign;
	}

	/**
	 * @param sign
	 *            the sign to set
	 */
	public void setSign(String sign) {
		this.sign = sign;
	}

	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}

	/**
	 * @param time
	 *            the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}

	/**
	 * @return the reqDef
	 */
	public SyReqDefBean getReqDef() {
		return reqDef;
	}

	/**
	 * @param reqDef
	 *            the reqDef to set
	 */
	public void setReqDef(SyReqDefBean reqDef) {
		this.reqDef = reqDef;
	}

	/**
	 * @return the ip
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * @param ip
	 *            the ip to set
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 * @return the request
	 */
	public HttpServletRequest getRequest() {
		return request;
	}

	/**
	 * @param request
	 *            the request to set
	 */
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	/**
	 * @return the loginInfo
	 */
	public LoginInfo getLoginInfo() {
		return loginInfo;
	}

	/**
	 * @param loginInfo
	 *            the loginInfo to set
	 */
	public void setLoginInfo(LoginInfo loginInfo) {
		this.loginInfo = loginInfo;
	}

}
