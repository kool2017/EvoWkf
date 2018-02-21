/**
 * @PROJECT 
 * @DATE 2018年2月20日 上午11:11:02
 * @AUTHOR LUYU
 */
package com.kool.system.action;

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
import com.kool.core.base.BaseBean;
import com.kool.core.base.IBaseAction;
import com.kool.core.exception.BusException;
import com.kool.system.bean.SyUserInfoBean;
import com.kool.system.bean.io.SYPAGEINFOYBean;
import com.kool.system.bean.vo.PageResult;
import com.kool.system.service.UserService;

/**
 * @DESCRIBE
 * @AUTHOR LUYU
 * @DATE 2018年2月20日 上午11:11:02
 *
 */
@Controller
public class UserQueryPageAction implements IBaseAction {
	@Autowired
	private UserService service;

	@Transactional(propagation = Propagation.REQUIRED)
	@ResponseBody
	@RequestMapping(value = "/usermng/userQueryPage.json", method = RequestMethod.POST)
	public JSONObject doAction(@RequestBody String sInput) throws BusException {
		JSONObject pkgIn = JSONObject.parseObject(sInput);
		JSONArray sectionInUserInfo = pkgIn.getJSONArray("SYUSRINFQRYX");
		JSONObject propInUserInfo = sectionInUserInfo.getJSONObject(0);
		SyUserInfoBean userInfo = JSONObject.toJavaObject(propInUserInfo, SyUserInfoBean.class);

		JSONArray sectionInPageInfo = pkgIn.getJSONArray("SYPAGEINFOY");
		JSONObject propInPageInfo = sectionInPageInfo.getJSONObject(0);
		SYPAGEINFOYBean pageInfo = JSONObject.toJavaObject(propInPageInfo, SYPAGEINFOYBean.class);

		PageResult pageResult = service.queryPage(userInfo, pageInfo);
		JSONObject pkgOut = new JSONObject();
		JSONArray sectionOutUsers = new JSONArray();
		for (BaseBean user : pageResult.getListBusinessValue()) {
			JSONObject propOut = JSONObject.parseObject(JSONObject.toJSONString(user));
			sectionOutUsers.add(propOut);
		}
		pkgOut.put("SYUSRINFQRYZ", sectionOutUsers);

		JSONArray sectionOutPageInfo = new JSONArray();
		pageInfo = pageResult.getPageInfo();
		JSONObject propOutPageInfo = JSONObject.parseObject(JSONObject.toJSONString(pageInfo));
		sectionOutPageInfo.add(propOutPageInfo);
		pkgOut.put("SYPAGEINFOY", sectionOutPageInfo);
		return pkgOut;
	}

}
