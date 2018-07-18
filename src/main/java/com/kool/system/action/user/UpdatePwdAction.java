/**
 * @PROJECT 
 * @DATE 2018年7月8日 下午5:38:30
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
import com.kool.system.bean.io.user.SYUPDPWDXBean;
import com.kool.system.service.UserService;

/**
 * @DESCRIBE 修改密码
 * @AUTHOR LUYU
 * @DATE 2018年7月8日 下午5:38:30
 *
 */
@Controller
public class UpdatePwdAction implements IBaseAction {
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
	@RequestMapping(value = "/sys/user/updatePwd", method = RequestMethod.POST)
	public JSONObject doAction(@RequestBody String sInput) throws AppException {
		JSONObject pkgIn = JSONObject.parseObject(sInput);
		JSONArray sectionIn = pkgIn.getJSONArray("SYUPDPWDX");
		JSONObject propIn = sectionIn.getJSONObject(0);
		SYUPDPWDXBean io = JSON.toJavaObject(propIn, SYUPDPWDXBean.class);

		service.updatePwd(io.getUserCid(), io.getOldPwd(), io.getNewPwd(), io.getNewPwdC());

		return null;
	}

}
