/**
 * @PROJECT 
 * @DATE 2018年1月1日 下午12:29:43
 * @AUTHOR LUYU
 */
package com.kool.system.action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kool.core.CoreConstants;
import com.kool.core.context.LoginInfo;
import com.kool.core.exception.AppException;
import com.kool.core.exception.BusException;
import com.kool.system.bean.SyUserInfoBean;
import com.kool.system.bean.io.SYLOGINFXBean;
import com.kool.system.service.UserService;

/**
 * @DESCRIBE 登录
 *           ！！注意！！未继承IBaseAction！！无相关切面功能
 * 
 * @AUTHOR LUYU
 * @DATE 2018年1月1日 下午12:29:43
 *
 */
@Controller
public class LoginAction {
	@Autowired
	private UserService service;

	/**
	 * @DESCRIBE
	 * @DATE 2018年1月1日 下午12:29:52
	 *
	 * @param input
	 * @return
	 * @throws AppException
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	@ResponseBody
	@RequestMapping(value = "/user/login.json", method = RequestMethod.POST)
	public JSONObject doAction(@RequestBody String sInput, HttpServletRequest request, HttpServletResponse response) throws BusException, AppException {
		JSONObject pkgIn = JSONObject.parseObject(sInput);
		JSONArray sectionIn = pkgIn.getJSONArray("SYLOGINFX");
		JSONObject propIn = sectionIn.getJSONObject(0);
		SYLOGINFXBean logInf = JSONObject.toJavaObject(propIn, SYLOGINFXBean.class);

		JSONObject pkgOut = new JSONObject();
		JSONArray sectionComm = new JSONArray();
		JSONObject propComm = new JSONObject();

		SyUserInfoBean userInf = service.login(logInf);
		
		LoginInfo loginInfo = new LoginInfo();
		loginInfo.setSuiId(userInf.getSuiId());
		loginInfo.setSuiLoginName(userInf.getSuiLoginName());
		loginInfo.setSuiFace(userInf.getSuiFace());
		loginInfo.setSuiMail(userInf.getSuiMail());
		loginInfo.setSuiPhone(userInf.getSuiPhone());
		loginInfo.setSuiStatus(userInf.getSuiStatus());
		request.getSession().setAttribute(CoreConstants.SESSION_LOGIN_INFO, loginInfo);
		
		Cookie cookie = new Cookie("LOGIN_NAME", loginInfo.getSuiLoginName());
		cookie.setPath("/");
		response.addCookie(cookie);
		Cookie cookieId = new Cookie("ID", loginInfo.getSuiId());
		cookieId.setPath("/");
		response.addCookie(cookieId);
		Cookie cookieStatus = new Cookie("STATUS", loginInfo.getSuiStatus());
		cookieStatus.setPath("/");
		response.addCookie(cookieStatus);
		
		propComm.put("ERROR_CODE", "0000000");
		propComm.put("ERROR_MSG", "");
		propComm.put("TOKEN", "");
		propComm.put("LOGIN_INFO", loginInfo);
		sectionComm.add(propComm);
		pkgOut.put("SYCOMMUNZ", sectionComm);

		return pkgOut;
	}

}
