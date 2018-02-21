/**
 * @PROJECT 
 * @DATE 2018年1月18日 下午11:21:50
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
import com.kool.core.base.IBaseAction;
import com.kool.core.exception.AppException;
import com.kool.core.exception.BusException;
import com.kool.system.bean.SyUserInfoBean;
import com.kool.system.bean.SyUserTradeBean;
import com.kool.system.service.UserService;

/**
 * @DESCRIBE
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
	@Transactional(propagation = Propagation.REQUIRED)
	@ResponseBody
	@RequestMapping(value = "/usermng/userAdd.json", method = RequestMethod.POST)
	public JSONObject doAction(@RequestBody String sInput) throws BusException, AppException {
		JSONObject pkgIn = JSONObject.parseObject(sInput);
		JSONArray sectionIn = pkgIn.getJSONArray("SYUSRINFEDTX");
		JSONObject propIn = sectionIn.getJSONObject(0);
		SyUserInfoBean userInfo = JSONObject.toJavaObject(propIn, SyUserInfoBean.class);

		SyUserTradeBean tradeInfo = new SyUserTradeBean();
		tradeInfo.setSutLoginName(userInfo.getSuiLoginName());
		tradeInfo.setSutPhone(userInfo.getSuiPhone());
		tradeInfo.setSutMail(userInfo.getSuiMail());
		String id = service.addUserOpr(tradeInfo);

		JSONObject pkgOut = new JSONObject();
		JSONArray sectionOut = new JSONArray();
		JSONObject propOut = new JSONObject();
		propOut.put("SUT_ID", id);
		sectionOut.add(propOut);
		pkgOut.put("SYUSRINFEDTZ", sectionOut);

		return pkgOut;
	}

}
