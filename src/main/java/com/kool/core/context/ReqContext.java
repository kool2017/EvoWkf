/**
 * @PROJECT 
 * @DATE 2018年1月19日 下午9:01:15
 * @AUTHOR LUYU
 */
package com.kool.core.context;

import javax.servlet.http.HttpServletRequest;

/**
 * @DESCRIBE 请求上下文
 * @AUTHOR LUYU
 * @DATE 2018年1月19日 下午9:01:15
 *
 */
public class ReqContext extends BaseContext {
	private HttpServletRequest request;
	private LoginInfo loginInfo;

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
