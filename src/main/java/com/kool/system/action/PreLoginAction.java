/**
 * @PROJECT 
 * @DATE 2018年1月1日 下午12:31:41
 * @AUTHOR LUYU
 */
package com.kool.system.action;

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
import com.kool.core.base.IBaseAction;
import com.kool.core.exception.AppException;
import com.kool.core.exception.BusException;
import com.kool.system.bean.io.SYLOGINFXBean;
import com.kool.system.bean.io.SYUSRINFZBean;
import com.kool.system.service.UserService;

/**
 * @DESCRIBE
 * @AUTHOR LUYU
 * @DATE 2018年1月1日 下午12:31:41
 *
 */
@Controller
public class PreLoginAction implements IBaseAction {
	@Autowired
	private UserService service;

	/**
	 * @DESCRIBE 登录前准备
	 * @DATE 2018年1月1日 下午12:31:49
	 *
	 * @param sInput
	 * @return
	 * @throws AppException
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	@ResponseBody
	@RequestMapping(value = "/user/preLogin.json", method = RequestMethod.POST)
	public JSONObject doAction(@RequestBody String sInput) throws BusException {
		JSONObject pkgIn = JSONObject.parseObject(sInput);
		JSONArray sectionIn = pkgIn.getJSONArray("SYLOGINFX");
		JSONObject propIn = sectionIn.getJSONObject(0);
		SYLOGINFXBean logInf = JSONObject.toJavaObject(propIn, SYLOGINFXBean.class);
		SYUSRINFZBean userInfZ = service.preLogin(logInf);

		JSONObject pkgOut = new JSONObject();
		JSONArray sectionOut = new JSONArray();
		JSONObject propOut = JSONObject.parseObject(JSONObject.toJSONString(userInfZ));
		sectionOut.add(propOut);
		pkgOut.put("SYUSRINFZ", sectionOut);

		return pkgOut;
	}

}
