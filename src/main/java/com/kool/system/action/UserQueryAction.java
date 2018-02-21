/**
 * @PROJECT 
 * @DATE 2018年1月20日 下午10:25:29
 * @AUTHOR LUYU
 */
package com.kool.system.action;

import java.util.List;

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
 * @DATE 2018年1月20日 下午10:25:29
 *
 */
@Controller
public class UserQueryAction implements IBaseAction {
	@Autowired
	private UserService service;

	@Transactional(propagation = Propagation.REQUIRED)
	@ResponseBody
	@RequestMapping(value = "/usermng/userQuery.json", method = RequestMethod.POST)
	public JSONObject doAction(@RequestBody String sInput) throws BusException {
		JSONObject pkgIn = JSONObject.parseObject(sInput);
		JSONArray sectionIn = pkgIn.getJSONArray("SYUSRINFQRYX");
		JSONObject propIn = sectionIn.getJSONObject(0);
		SyUserInfoBean userInfo = JSONObject.toJavaObject(propIn, SyUserInfoBean.class);

		List<SyUserInfoBean> listUser = service.query(userInfo);
		JSONObject pkgOut = new JSONObject();
		JSONArray sectionOut = new JSONArray();
		for (SyUserInfoBean user : listUser) {
			JSONObject propOut = JSONObject.parseObject(JSONObject.toJSONString(user));
			sectionOut.add(propOut);
		}
		pkgOut.put("SYUSRINFQRYZ", sectionOut);

		return pkgOut;
	}
}