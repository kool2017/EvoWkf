/**
 * @PROJECT 
 * @DATE 2018年1月20日 下午10:26:01
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
import com.kool.core.exception.BusException;
import com.kool.system.bean.SyUserInfoBean;
import com.kool.system.service.UserService;

/**
 * @DESCRIBE
 * @AUTHOR LUYU
 * @DATE 2018年1月20日 下午10:26:01
 *
 */
@Controller
public class UserCloseAction  implements IBaseAction {
	@Autowired
	private UserService service;

	@Transactional(propagation = Propagation.REQUIRED)
	@ResponseBody
	@RequestMapping(value = "/usermng/userClose.json", method = RequestMethod.POST)
	public JSONObject doAction(@RequestBody String sInput) throws BusException {
		JSONObject pkgIn = JSONObject.parseObject(sInput);
		JSONArray sectionIn = pkgIn.getJSONArray("SYUSRINFDELX");
		JSONObject propIn = sectionIn.getJSONObject(0);

		SyUserInfoBean userInfo = JSONObject.toJavaObject(propIn, SyUserInfoBean.class);
		service.closeUser(userInfo);
		JSONObject pkgOut = new JSONObject();

		return pkgOut;
	}
}
