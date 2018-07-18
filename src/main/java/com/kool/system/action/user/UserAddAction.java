/**
 * @PROJECT 
 * @DATE 2018年1月18日 下午11:21:50
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
import com.kool.core.util.BeanUtils;
import com.kool.system.bean.SyUserInfoBean;
import com.kool.system.bean.io.user.SYUSRINFXBean;
import com.kool.system.service.UserService;

/**
 * @DESCRIBE 增加用户
 * @AUTHOR LUYU
 * @DATE 2018年1月18日 下午11:21:50
 *
 */
@Controller
public class UserAddAction implements IBaseAction {
	@Autowired
	private UserService service;

	/**
	 * @DESCRIBE
	 * @DATE 2018年1月20日 下午9:14:09
	 *
	 * @param sInput
	 * @return
	 * @throws AppException
	 */
	@Override
	@ResponseBody
	@RequestMapping(value = "/sys/user/addUser", method = RequestMethod.POST)
	public JSONObject doAction(@RequestBody String sInput) throws AppException {
		JSONObject pkgIn = JSONObject.parseObject(sInput);
		JSONArray sectionIn = pkgIn.getJSONArray("SYUSRINFX");
		JSONObject propIn = sectionIn.getJSONObject(0);
		SYUSRINFXBean ioInfo = JSON.toJavaObject(propIn, SYUSRINFXBean.class);

		SyUserInfoBean userInfo = (SyUserInfoBean) BeanUtils.io2Bean(ioInfo, SyUserInfoBean.class, "sui");

		service.add(userInfo);

		return null;
	}

}
