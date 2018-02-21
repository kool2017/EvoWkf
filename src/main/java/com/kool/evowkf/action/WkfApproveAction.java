/**
 * @PROJECT 
 * @DATE 2018年2月18日 下午6:32:53
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
import com.kool.evowkf.bean.io.SYAPPROVEXBean;
import com.kool.evowkf.service.WkfService;

/**
 * @DESCRIBE
 * @AUTHOR LUYU
 * @DATE 2018年2月18日 下午6:32:53
 *
 */
@Controller
public class WkfApproveAction implements IBaseAction{
	@Autowired
	private WkfService service;

	/**
	 * @DESCRIBE
	 * @DATE 2018年2月18日 下午6:33:02
	 *
	 * @param sInput
	 * @return
	 * @throws BusException
	 * @throws AppException
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	@ResponseBody
	@RequestMapping(value = "/wkf/wkfApprove.json", method = RequestMethod.POST)
	public JSONObject doAction(@RequestBody String sInput) throws BusException, AppException {
		JSONObject pkgIn = JSONObject.parseObject(sInput);
		JSONArray sectionIn = pkgIn.getJSONArray("SYAPPROVEX");
		JSONObject propIn = sectionIn.getJSONObject(0);
		SYAPPROVEXBean approveInfo = JSONObject.toJavaObject(propIn, SYAPPROVEXBean.class);
		service.approve(approveInfo);
		
		JSONObject pkgOut = new JSONObject();
		return pkgOut;
	}

}
