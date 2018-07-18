/**
 * @PROJECT 
 * @DATE 2018年7月15日 下午8:50:27
 * @AUTHOR LUYU
 */
package com.kool.system.action.user;

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
import com.kool.system.bean.SyMenuBean;
import com.kool.system.bean.io.menu.SYMENUINFYBean;
import com.kool.system.service.UserService;

/**
 * @DESCRIBE 获取用户有权限的菜单
 * @AUTHOR LUYU
 * @DATE 2018年7月15日 下午8:50:27
 *
 */
@Controller
public class QueryUserMenuAction implements IBaseAction {
	@Autowired
	private UserService service;

	/**
	 * @DESCRIBE 获取用户有权限的菜单
	 * @DATE 2018年7月15日 下午8:51:04
	 *
	 * @param sInput
	 * @return
	 * @throws AppException
	 */
	@Override
	@ResponseBody
	@RequestMapping(value = "/sys/user/queryUserMenu", method = RequestMethod.POST)
	public JSONObject doAction(@RequestBody String sInput) throws AppException {
		JSONObject pkgIn = JSONObject.parseObject(sInput);
		JSONArray secUser = pkgIn.getJSONArray("SYUSRCIDX");
		JSONObject propUser = secUser.getJSONObject(0);
		String userCid = propUser.getString("userCid");

		List<SyMenuBean> listMenu = service.getUserMenu(userCid);

		JSONObject pkgOut = new JSONObject();
		JSONArray secOut = new JSONArray();
		if (listMenu != null && listMenu.size() > 0) {
			for (SyMenuBean menu : listMenu) {
				SYMENUINFYBean out = (SYMENUINFYBean) BeanUtils.bean2Io(menu, SYMENUINFYBean.class);
				JSONObject propOut = (JSONObject) JSON.toJSON(out);
				secOut.add(propOut);
			}
		}
		pkgOut.put("SYMENUINFY", secOut);
		return pkgOut;
	}

}
