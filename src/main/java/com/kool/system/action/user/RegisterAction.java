/**
 * @PROJECT 
 * @DATE 2018年1月1日 下午12:24:53
 * @AUTHOR LUYU
 */
package com.kool.system.action.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kool.core.base.IBaseAction;
import com.kool.core.exception.AppException;
import com.kool.system.bean.io.SYREGINFXBean;
import com.kool.system.service.UserService;

/**
 * @DESCRIBE 注册
 * @AUTHOR LUYU
 * @DATE 2018年1月1日 下午12:24:53
 *
 */
@Controller
public class RegisterAction implements IBaseAction {

	@Autowired
	private UserService service;
	
	/**
	 * @DESCRIBE
	 * @DATE 2018年1月1日 下午12:26:46
	 *
	 * @param input
	 * @return
	 * @throws AppException 
	 */
	@Override
	@ResponseBody
	@RequestMapping(value = "/sys/user/register", method = RequestMethod.POST)
	public JSONObject doAction(@RequestBody String sInput) throws AppException {
		JSONObject pkgIn = JSONObject.parseObject(sInput);
		JSONArray sectionIn = pkgIn.getJSONArray("SYREGINFX");
		JSONObject propIn = sectionIn.getJSONObject(0);
		SYREGINFXBean regInf = JSONObject.toJavaObject(propIn, SYREGINFXBean.class);
		service.register(regInf);

		return new JSONObject();
	}

}
