/**
 * @PROJECT 
 * @DATE 2018年7月8日 下午10:39:50
 * @AUTHOR LUYU
 */
package com.kool.system.action.user;

import java.util.ArrayList;
import java.util.List;

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
import com.kool.system.bean.SyUserRoleBean;
import com.kool.system.bean.io.user.SYUSRROLEXBean;
import com.kool.system.service.UserService;

/**
 * @DESCRIBE 赋予角色
 * @AUTHOR LUYU
 * @DATE 2018年7月8日 下午10:39:50
 *
 */
@Controller
public class RoleUserAction implements IBaseAction {
	@Autowired
	private UserService service;

	/**
	 * 
	 * @DESCRIBE 
	 * @DATE 2018年7月8日 下午4:59:53
	 *
	 * @param sInput
	 * @return
	 * @throws AppException
	 */
	@Override
	@ResponseBody
	@RequestMapping(value = "/sys/user/setRole", method = RequestMethod.POST)
	public JSONObject doAction(@RequestBody String sInput) throws AppException {
		JSONObject pkgIn = JSONObject.parseObject(sInput);
		JSONArray secUser = pkgIn.getJSONArray("SYUSRCIDX");
		JSONObject propUser = secUser.getJSONObject(0);
		String userCid = propUser.getString("userCid");

		JSONArray secRole = pkgIn.getJSONArray("SYUSRROLEX");
		List<SyUserRoleBean> listIn = new ArrayList<>();
		for (int i = 0; i < secRole.size(); i++) {
			SYUSRROLEXBean io = JSON.toJavaObject(secRole.getJSONObject(i), SYUSRROLEXBean.class);
			SyUserRoleBean userRoleBean = (SyUserRoleBean) BeanUtils.io2Bean(io, SyUserRoleBean.class, "sur");
			listIn.add(userRoleBean);
		}
		service.setRole(userCid, listIn);

		return null;
	}

}
