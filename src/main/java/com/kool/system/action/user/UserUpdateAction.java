/**
 * @PROJECT 
 * @DATE 2018年1月20日 下午10:25:48
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
import com.kool.system.bean.io.user.SYUSRUPDXBean;
import com.kool.system.service.UserService;

/**
 * @DESCRIBE 修改用户信息
 * @AUTHOR LUYU
 * @DATE 2018年1月20日 下午10:25:48
 *
 */
@Controller
public class UserUpdateAction  implements IBaseAction {
	@Autowired
	private UserService service;

	@ResponseBody
	@RequestMapping(value = "/sys/user/updateUser", method = RequestMethod.POST)
	public JSONObject doAction(@RequestBody String sInput) throws AppException {
		JSONObject pkgIn = JSONObject.parseObject(sInput);
		JSONArray sectionIn = pkgIn.getJSONArray("SYUSRUPDX");
		JSONObject propIn = sectionIn.getJSONObject(0);
		SYUSRUPDXBean io = JSON.toJavaObject(propIn, SYUSRUPDXBean.class);

		SyUserInfoBean userInfo = (SyUserInfoBean) BeanUtils.io2Bean(io, SyUserInfoBean.class, "sui");
		service.updateUser(userInfo);

		return null;
	}

}
