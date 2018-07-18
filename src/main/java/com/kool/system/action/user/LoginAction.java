/**
 * @PROJECT 
 * @DATE 2018年1月1日 下午12:29:43
 * @AUTHOR LUYU
 */
package com.kool.system.action.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kool.core.base.IBaseAction;
import com.kool.core.exception.AppException;
import com.kool.system.bean.SyUserInfoBean;
import com.kool.system.bean.io.SYLOGINFXBean;
import com.kool.system.bean.io.SYLOGINFZBean;
import com.kool.system.service.UserService;

/**
 * @DESCRIBE 登录
 * 
 * @AUTHOR LUYU
 * @DATE 2018年1月1日 下午12:29:43
 *
 */
@Controller
public class LoginAction implements IBaseAction {
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
	@ResponseBody
	@RequestMapping(value = "/sys/user/login", method = RequestMethod.POST)
	public JSONObject doAction(@RequestBody String sInput) throws AppException {
		JSONObject pkgIn = JSONObject.parseObject(sInput);
		JSONArray sectionIn = pkgIn.getJSONArray("SYLOGINFX");
		JSONObject propIn = sectionIn.getJSONObject(0);
		SYLOGINFXBean logInf = JSONObject.toJavaObject(propIn, SYLOGINFXBean.class);

		JSONObject pkgOut = new JSONObject();
		JSONArray secOut = new JSONArray();

		SyUserInfoBean userInf = service.login(logInf);
		SYLOGINFZBean logInfZ = new SYLOGINFZBean();
		logInfZ.setUserCid(userInf.getSuiUserCid());
		logInfZ.setUserName(userInf.getSuiLoginName());
		logInfZ.setFace(userInf.getSuiFace());
		logInfZ.setSignKey(userInf.getSuiKeyUid());

		JSONObject propOut = JSONObject.parseObject(JSON.toJSONString(logInfZ));
		secOut.add(propOut);
		pkgOut.put("SYLOGINFZ", secOut);

		return pkgOut;
	}

}
