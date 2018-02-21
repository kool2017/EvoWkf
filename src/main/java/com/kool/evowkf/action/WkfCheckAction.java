/**
 * @PROJECT 
 * @DATE 2018年2月20日 上午9:59:33
 * @AUTHOR LUYU
 */
package com.kool.evowkf.action;

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
import com.kool.evowkf.bean.io.SYCHECKXBean;
import com.kool.evowkf.service.WkfService;

/**
 * @DESCRIBE
 * @AUTHOR LUYU
 * @DATE 2018年2月20日 上午9:59:33
 *
 */
@Controller
public class WkfCheckAction implements IBaseAction {
	@Autowired
	private WkfService service;

	/**
	 * @DESCRIBE
	 * @DATE 2018年2月20日 上午10:00:05
	 *
	 * @param sInput
	 * @return
	 * @throws BusException
	 * @throws AppException
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	@ResponseBody
	@RequestMapping(value = "/wkf/wkfCheck.json", method = RequestMethod.POST)
	public JSONObject doAction(@RequestBody String sInput) throws BusException, AppException {
		JSONObject pkgIn = JSONObject.parseObject(sInput);
		JSONArray sectionIn = pkgIn.getJSONArray("SYCHECKX");
		JSONObject propIn = sectionIn.getJSONObject(0);
		SYCHECKXBean checkInfo = JSONObject.toJavaObject(propIn, SYCHECKXBean.class);
		
		service.check(checkInfo);
		
		return new JSONObject();
	}
}
