/**
 * @PROJECT 
 * @DATE 2018年7月8日 下午2:49:09
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
import com.kool.system.bean.SyLoginLogBean;
import com.kool.system.bean.SyUserInfoBean;
import com.kool.system.bean.io.user.SYLOGINLOGZBean;
import com.kool.system.bean.io.user.SYUSRDTLZBean;
import com.kool.system.service.UserService;

/**
 * @DESCRIBE 查询用户详情
 * @AUTHOR LUYU
 * @DATE 2018年7月8日 下午2:49:09
 *
 */
@Controller
public class UserQueryDetailAction implements IBaseAction {
	@Autowired
	private UserService service;

	/**
	 * @DESCRIBE
	 * @DATE 2018年7月8日 下午2:49:09
	 *
	 * @param sInput
	 * @return
	 * @throws AppException
	 */
	@Override
	@ResponseBody
	@RequestMapping(value = "/sys/user/queryUserDetail", method = RequestMethod.POST)
	public JSONObject doAction(@RequestBody String sInput) throws AppException {
		JSONObject pkgIn = JSONObject.parseObject(sInput);
		JSONArray sectionIn = pkgIn.getJSONArray("SYUSRCIDX");
		JSONObject propIn = sectionIn.getJSONObject(0);
		
		String userCid = propIn.getString("userCid");
		SyUserInfoBean userInfo = service.queryDetail(userCid);
		List<SyLoginLogBean> listLog = service.queryLoginLog(userCid);
		
		JSONObject pkgOut = new JSONObject();
		JSONArray secUser = new JSONArray();
		JSONArray secLog = new JSONArray();
		secUser.add(JSON.toJSON(BeanUtils.bean2Io(userInfo, SYUSRDTLZBean.class)));

		for (SyLoginLogBean log : listLog) {
			secLog.add(JSON.toJSON(BeanUtils.bean2Io(log, SYLOGINLOGZBean.class)));
		}
		pkgOut.put("SYUSRDTLZ", secUser);
		pkgOut.put("SYLOGINLOGZ", secLog);
		return pkgOut;
	}

}
