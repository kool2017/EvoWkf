/**
 * @PROJECT 
 * @DATE 2018年7月8日 下午6:52:05
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
import com.kool.system.bean.SyUserAutBean;
import com.kool.system.bean.io.aut.SYAUTINFYBean;
import com.kool.system.service.UserService;

/**
 * @DESCRIBE 查询用户权限列表
 * @AUTHOR LUYU
 * @DATE 2018年7月8日 下午6:52:05
 *
 */
@Controller
public class QueryUserAuthAction implements IBaseAction {
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
	@RequestMapping(value = "/sys/user/queryUserAut", method = RequestMethod.POST)
	public JSONObject doAction(@RequestBody String sInput) throws AppException {
		JSONObject pkgIn = JSONObject.parseObject(sInput);
		JSONArray sectionIn = pkgIn.getJSONArray("SYUSRCIDX");
		JSONObject propIn = sectionIn.getJSONObject(0);
		String userCid = propIn.getString("userCid");
		List<SyUserAutBean> list = service.queryUserAuth(userCid);

		JSONObject pkgOut = new JSONObject();
		JSONArray secOut = new JSONArray();
		for (SyUserAutBean aut : list) {
			SYAUTINFYBean io = (SYAUTINFYBean) BeanUtils.bean2Io(aut, SYAUTINFYBean.class);
			secOut.add(JSON.toJSON(io));
		}
		pkgOut.put("SYAUTINFY", secOut);
		return pkgOut;
	}

}
