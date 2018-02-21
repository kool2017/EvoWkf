/**
 * @PROJECT 
 * @DATE 2018年2月18日 下午6:32:20
 * @AUTHOR LUYU
 */
package com.kool.evowkf.action;

import java.util.List;

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
import com.kool.core.exception.AppException;
import com.kool.core.exception.BusException;
import com.kool.evowkf.bean.io.SYSCHEDULEXBean;
import com.kool.evowkf.service.WkfService;
import com.kool.system.bean.io.SYPAGEINFOYBean;
import com.kool.system.bean.vo.PageResult;

/**
 * @DESCRIBE 查询待办
 * @AUTHOR LUYU
 * @DATE 2018年2月18日 下午6:32:20
 *
 */
@Controller
public class WkfScheduleAction implements IBaseAction {
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
	@RequestMapping(value = "/wkf/wkfQuerySchedules.json", method = RequestMethod.POST)
	public JSONObject doAction(@RequestBody String sInput) throws BusException, AppException {
		JSONObject pkgIn = JSONObject.parseObject(sInput);
		JSONArray sectionIn = pkgIn.getJSONArray("SYSCHEDULEX");
		JSONObject propIn = sectionIn.getJSONObject(0);
		SYSCHEDULEXBean scheduleInfo = JSONObject.toJavaObject(propIn, SYSCHEDULEXBean.class);

		JSONArray sectionInPageInfo = pkgIn.getJSONArray("SYPAGEINFOY");
		JSONObject propInPageInfo = sectionInPageInfo.getJSONObject(0);
		SYPAGEINFOYBean pageInfo = JSONObject.toJavaObject(propInPageInfo, SYPAGEINFOYBean.class);
		PageResult pageResult = service.querySchedule(scheduleInfo, pageInfo);
		if (null == pageResult) {
			throw new AppException("分页查询结果为空");
		}

		JSONObject pkgOut = new JSONObject();
		JSONArray sectionSchedule = new JSONArray();
		List<BaseBean> listSchedules = pageResult.getListBusinessValue();
		if (listSchedules != null && listSchedules.size() > 0) {
			for (BaseBean schedule : listSchedules) {
				sectionSchedule.add(schedule);
			}
		}
		pkgOut.put("SYSCHEDULEZ", sectionSchedule);

		JSONArray sectionOutPageInfo = new JSONArray();
		pageInfo = pageResult.getPageInfo();
		if (null == pageInfo) {
			throw new AppException("分页信息为空");
		}
		JSONObject propOutPageInfo = JSONObject.parseObject(JSONObject.toJSONString(pageInfo));
		sectionOutPageInfo.add(propOutPageInfo);
		pkgOut.put("SYPAGEINFOY", sectionOutPageInfo);
		return pkgOut;
	}

}
