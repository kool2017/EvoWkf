/**
 * @PROJECT 
 * @DATE 2018年1月19日 下午9:55:47
 * @AUTHOR LUYU
 */
package com.kool.system.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kool.core.CoreConstants;
import com.kool.core.exception.AppException;
import com.kool.core.exception.BusException;
import com.kool.core.util.PropertyUtils;

/**
 * @DESCRIBE 退出登录
 * @AUTHOR LUYU
 * @DATE 2018年1月19日 下午9:55:47
 *
 */
@Controller
public class LogoutAction {
	/**
	 * 
	 * @DESCRIBE 退出登录
	 * @DATE 2018年1月19日 下午9:56:34
	 *
	 * @param request
	 * @return
	 * @throws AppException
	 * @throws IOException 
	 */
	@RequestMapping(value = "/user/logout.htm", method = RequestMethod.GET)
	public void doAction(HttpServletRequest request, HttpServletResponse response) throws BusException, AppException {
		request.getSession().removeAttribute(CoreConstants.SESSION_LOGIN_INFO);
		String homeUrl = PropertyUtils.getValue("HOME_URL");
		try {
			response.sendRedirect(homeUrl);
		} catch (IOException e) {
			throw new AppException("");//重定向时发生异常
		}
	}

}
