/**
 * @PROJECT 
 * @DATE 2018年7月8日 下午7:10:58
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
import com.kool.system.bean.SyUserAutBean;
import com.kool.system.bean.io.user.SYUSRAUTXBean;
import com.kool.system.service.UserService;

/**
 * @DESCRIBE 用户授权
 * @AUTHOR LUYU
 * @DATE 2018年7月8日 下午7:10:58
 *
 */
@Controller
public class AuthUserAction implements IBaseAction {
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
	@RequestMapping(value = "/sys/user/resetAut", method = RequestMethod.POST)
	public JSONObject doAction(@RequestBody String sInput) throws AppException {
		JSONObject pkgIn = JSONObject.parseObject(sInput);
		JSONArray secUser = pkgIn.getJSONArray("SYUSRCIDX");
		JSONObject propUser = secUser.getJSONObject(0);
		String userCid = propUser.getString("userCid");

		JSONArray secAut = pkgIn.getJSONArray("SYUSRAUTX");
		List<SyUserAutBean> listIn = new ArrayList<>();
		for (int i = 0; i < secAut.size(); i++) {
			SYUSRAUTXBean io = JSON.toJavaObject(secAut.getJSONObject(i), SYUSRAUTXBean.class);
			SyUserAutBean userAutBean = (SyUserAutBean) BeanUtils.io2Bean(io, SyUserAutBean.class, "sua");
			listIn.add(userAutBean);
		}
		service.resetAuth(userCid, listIn);

		return null;
	}

}
