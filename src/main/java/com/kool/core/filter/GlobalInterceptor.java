/**
 * @PROJECT 
 * @DATE 2018年1月19日 下午9:14:54
 * @AUTHOR LUYU
 */
package com.kool.core.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.kool.core.CoreConstants;
import com.kool.core.cache.KCache;
import com.kool.core.context.ContextHolder;
import com.kool.core.context.ReqContext;
import com.kool.core.util.SecurityUtils;
import com.kool.core.util.StringUtils;
import com.kool.system.bean.SyReqDefBean;
import com.kool.system.bean.SyUserInfoBean;

/**
 * @DESCRIBE 拦截器，请求处理前登录注册的请求不拦截，其它请求要验证登录状态或token，初始化上下文；请求结束后删除上下文
 * @AUTHOR LUYU
 * @DATE 2018年1月19日 下午9:14:54
 *
 */
public class GlobalInterceptor implements HandlerInterceptor {
	private static Logger logger = Logger.getLogger("REQ");

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
//		// 取请求参数
//		String reqId = request.getParameter("reqId");
//		String userCid = request.getParameter("userCid");
//		String time = request.getParameter("time");
//		String channelId = request.getParameter("channelId");
//		String sign = request.getParameter("sign");
//		String ip = getIpAdrress(request);
//		
//		String uri = request.getRequestURI();
//		if (StringUtils.isEmpty(reqId)) {
//			reqId = uri.replaceFirst("/evowkf", "");
//		}
//		// 请求日志
//		JSONObject log = new JSONObject();
//		log.put("reqId", reqId);
//		log.put("userCid", userCid);
//		log.put("time", time);
//		log.put("channelId", channelId);
//		log.put("ip", ip);
//		logger.info(log.toJSONString());
//		
//		// 从缓存获取请求信息
//		SyReqDefBean reqDef = (SyReqDefBean) KCache.get(CoreConstants.KCACHE_REQ, reqId);
//
//		if (null == reqDef) {
//			throw new RuntimeException("非法请求URL:" + reqId);
//		}
//		// 如果请求需要验签，则验签
//		if (isNeedValidateSign(reqDef)) {
//			// 验签
//			String vSign = SecurityUtils
//					.sha(reqId + "&" + userCid + "&" + time + "&" + channelId + "&" + getSignKey(userCid));
//			if (vSign.equals(sign) == false) {
//				response.sendError(401);
//				return false;
//			}
//		}

		// 初始化请求上下文
		ReqContext context = new ReqContext();
		context.setRequest(request);
//		context.setIp(ip);
//		context.setReqDef(reqDef);
//		context.setUserCid(userCid);
//		context.setTime(time);
//		context.setChannelId(channelId);
//		context.setSign(sign);

		ContextHolder.setReqContext(context);

		return true;
	}

	/**
	 * @DESCRIBE
	 * @DATE 2018年6月28日 下午11:42:25
	 *
	 * @param reqDef
	 * @return
	 */
	private boolean isNeedValidateSign(SyReqDefBean reqDef) {
		boolean isNeed = true;
		if (null == reqDef) {
			throw new RuntimeException("非法请求URL");
		}
		if ("Y".equals(reqDef.getSrdSignFlag())) {
			isNeed = true;
		} else if ("N".equals(reqDef.getSrdSignFlag())) {
			isNeed = false;
		} else {
			throw new RuntimeException("验签标志不正确");
		}
		return isNeed;
	}

	/**
	 * @DESCRIBE 取用户签名密钥
	 * @DATE 2018年6月28日 下午11:26:23
	 *
	 * @param userId
	 * @return
	 */
	private String getSignKey(String userId) {
		// 从缓存获取用户信息
		SyUserInfoBean user = (SyUserInfoBean) KCache.get(CoreConstants.KCACHE_USER, userId);
		if (null == user || "N".equals(user.getSuiHasKey()) || StringUtils.isEmpty(user.getSuiKeyUid())) {
			return "";
		}
		return user.getSuiKeyUid();
	}

	/**
	 * 
	 * @DESCRIBE 取请求方ip地址
	 * @DATE 2018年7月13日 下午9:52:54
	 *
	 * @param request
	 * @return
	 */
	private String getIpAdrress(HttpServletRequest request) {
		String Xip = request.getHeader("X-Real-IP");
		String XFor = request.getHeader("X-Forwarded-For");
		if (StringUtils.isEmpty(XFor) == false && !"unKnown".equalsIgnoreCase(XFor)) {
			// 多次反向代理后会有多个ip值，第一个ip才是真实ip
			int index = XFor.indexOf(",");
			if (index != -1) {
				return XFor.substring(0, index);
			} else {
				return XFor;
			}
		}
		XFor = Xip;
		if (StringUtils.isEmpty(XFor) == false && !"unKnown".equalsIgnoreCase(XFor)) {
			return XFor;
		}
		if (StringUtils.isEmpty(XFor) || "unknown".equalsIgnoreCase(XFor)) {
			XFor = request.getHeader("Proxy-Client-IP");
		}
		if (StringUtils.isEmpty(XFor) || "unknown".equalsIgnoreCase(XFor)) {
			XFor = request.getHeader("WL-Proxy-Client-IP");
		}
		if (StringUtils.isEmpty(XFor) || "unknown".equalsIgnoreCase(XFor)) {
			XFor = request.getHeader("HTTP_CLIENT_IP");
		}
		if (StringUtils.isEmpty(XFor) || "unknown".equalsIgnoreCase(XFor)) {
			XFor = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (StringUtils.isEmpty(XFor) || "unknown".equalsIgnoreCase(XFor)) {
			XFor = request.getRemoteAddr();
		}
		return XFor;
	}
}
