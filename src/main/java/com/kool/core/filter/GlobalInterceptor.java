/**
 * @PROJECT 
 * @DATE 2018年1月19日 下午9:14:54
 * @AUTHOR LUYU
 */
package com.kool.core.filter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.kool.core.CoreConstants;
import com.kool.core.context.ContextHolder;
import com.kool.core.context.LoginInfo;
import com.kool.core.context.ReqContext;

/**
 * @DESCRIBE 拦截器，请求处理前登录注册的请求不拦截，其它请求要验证登录状态或token，初始化上下文；请求结束后删除上下文
 * @AUTHOR LUYU
 * @DATE 2018年1月19日 下午9:14:54
 *
 */
public class GlobalInterceptor implements HandlerInterceptor {

	/**
	 * @DESCRIBE
	 * @DATE 2018年1月19日 下午9:15:06
	 *
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @param arg3
	 * @throws Exception
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		ContextHolder.remove();
	}

	/**
	 * @DESCRIBE
	 * @DATE 2018年1月19日 下午9:15:06
	 *
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @param arg3
	 * @throws Exception
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	/**
	 * @DESCRIBE
	 * @DATE 2018年1月19日 下午9:15:06
	 *
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String requestUri = request.getRequestURI();
		if (requestUri.indexOf("/user/preLogin.json") > -1 || requestUri.indexOf("/user/login.json") > -1
				|| requestUri.indexOf("/user/register.json") > -1) {
			return true;
		}

		// LoginInfo loginInfo = (LoginInfo)
		// request.getSession().getAttribute(CoreConstants.SESSION_LOGIN_INFO);
		LoginInfo loginInfo = new LoginInfo();
		Cookie[] cookies = request.getCookies();
		for (int i = 0; i < cookies.length; i++) {
			if (cookies[i].getName().equals("LOGIN_NAME")) {
				loginInfo.setSuiLoginName(cookies[i].getValue());
			} else if (cookies[i].getName().equals("ID")) {
				loginInfo.setSuiId(cookies[i].getValue());
			} else if (cookies[i].getName().equals("STATUS")) {
				loginInfo.setSuiStatus(cookies[i].getValue());
			}
		}
		if (null == loginInfo || CoreConstants.SUI_STATUS_CLOSE.equals(loginInfo.getSuiStatus())
				|| CoreConstants.SUI_STATUS_ERROR.equals(loginInfo.getSuiStatus())) {
			response.sendError(401);
			return false;
		}
		// 初始化请求上下文
		ReqContext context = new ReqContext();
		context.setRequest(request);
		context.setLoginInfo(loginInfo);
		ContextHolder.setReqContext(context);

		return true;
	}

}
