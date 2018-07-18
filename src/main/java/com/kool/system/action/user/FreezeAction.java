/**
 * @PROJECT 
 * @DATE 2018年7月8日 下午3:55:06
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
import com.kool.system.service.UserService;

/**
 * @DESCRIBE 冻结
 * @AUTHOR LUYU
 * @DATE 2018年7月8日 下午3:55:06
 *
 */
@Controller
public class FreezeAction implements IBaseAction {
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
	@RequestMapping(value = "/sys/user/freezeUser", method = RequestMethod.POST)
	public JSONObject doAction(@RequestBody String sInput) throws AppException {
		JSONObject pkgIn = JSONObject.parseObject(sInput);
		JSONArray sectionIn = pkgIn.getJSONArray("SYUSRCIDX");
		JSONObject propIn = sectionIn.getJSONObject(0);
		String userCid = propIn.getString("userCid");

		service.freeze(userCid);

		return null;
	}

}
