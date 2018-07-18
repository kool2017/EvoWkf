/**
 * @PROJECT 
 * @DATE 2018年1月19日 下午9:55:47
 * @AUTHOR LUYU
 */
package com.kool.system.action.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kool.core.base.IBaseAction;
import com.kool.core.exception.AppException;

/**
 * @DESCRIBE 退出登录，因为请求为无状态，退出不需要处理
 * @AUTHOR LUYU
 * @DATE 2018年1月19日 下午9:55:47
 *
 */
@Controller
public class LogoutAction implements IBaseAction {

	/**
	 * @DESCRIBE
	 * @DATE 2018年6月28日 下午8:58:51
	 *
	 * @param sInput
	 * @return
	 * @throws AppException
	 */
	@SuppressWarnings("unused")
	@Override
	@ResponseBody
	@RequestMapping(value = "/sys/user/logout", method = RequestMethod.POST)
	public JSONObject doAction(@RequestBody String sInput) throws AppException {
		JSONObject pkgIn = JSONObject.parseObject(sInput);
		JSONArray sectionIn = pkgIn.getJSONArray("SYLOGOUTX");
		JSONObject propIn = sectionIn.getJSONObject(0);
		String userId = propIn.getString("userCid");
		
		return null;
	}

}
