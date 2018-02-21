/**
 * @PROJECT 
 * @DATE 2018年2月18日 下午10:22:43
 * @AUTHOR LUYU
 */
package com.kool.evowkf.service;

import org.springframework.stereotype.Service;

import com.kool.core.context.ContextHolder;
import com.kool.core.context.LoginInfo;
import com.kool.core.exception.AppException;
import com.kool.core.exception.BusException;
import com.kool.evowkf.api.IEvoWkfApi;
import com.kool.evowkf.api.SimpleApiImp;
import com.kool.evowkf.bean.io.SYAPPROVEXBean;
import com.kool.evowkf.bean.io.SYCHECKXBean;
import com.kool.evowkf.bean.io.SYSCHEDULEXBean;
import com.kool.evowkf.engine.WKFContext;
import com.kool.system.bean.io.SYPAGEINFOYBean;
import com.kool.system.bean.vo.PageResult;

/**
 * @DESCRIBE
 * @AUTHOR LUYU
 * @DATE 2018年2月18日 下午10:22:43
 *
 */
@Service
public class WkfService {

	/**
	 * @DESCRIBE
	 * @DATE 2018年2月19日 下午12:02:13
	 *
	 * @param scheduleInfo
	 * @param pageInfo
	 * @return
	 */
	public PageResult querySchedule(SYSCHEDULEXBean scheduleInfo, SYPAGEINFOYBean pageInfo) {
		String recordId = scheduleInfo.getRecordId();
		String businessType = scheduleInfo.getBusinessType();

		LoginInfo loginInfo = ContextHolder.getReqContext().getLoginInfo();

		IEvoWkfApi api = new SimpleApiImp();
		PageResult pageResult = api.querySchedule(recordId, businessType, loginInfo.getSuiId(),
				loginInfo.getSuiLoginName(), pageInfo);

		return pageResult;
	}

	/**
	 * 
	 * @DESCRIBE 审批
	 * @DATE 2018年2月19日 下午3:01:43
	 *
	 * @param approveInfo
	 * @throws AppException
	 * @throws BusException
	 */
	public void approve(SYAPPROVEXBean approveInfo) throws BusException, AppException {
		String recordId = approveInfo.getRecordId();
		String approveFlag = approveInfo.getApproveFlag();
		String scheduleId = approveInfo.getScheduleId();
		String dsp = approveInfo.getDsp();

		LoginInfo loginInfo = ContextHolder.getReqContext().getLoginInfo();

		WKFContext wkfInfo = new WKFContext();
		wkfInfo.setRecordId(recordId);
		wkfInfo.setScheduleId(scheduleId);
		wkfInfo.setApproveFlag(approveFlag);
		wkfInfo.setDescription(dsp);
		wkfInfo.setUserId(loginInfo.getSuiId());
		wkfInfo.setLoginName(loginInfo.getSuiLoginName());
		IEvoWkfApi api = new SimpleApiImp();
		api.nextStep(wkfInfo);
	}

	/**
	 * @DESCRIBE 签收
	 * @DATE 2018年2月20日 上午10:03:20
	 *
	 * @param checkInfo
	 * @throws BusException
	 */
	public void check(SYCHECKXBean checkInfo) throws BusException {
		String recordId = checkInfo.getRecordId();
		String scheduleId = checkInfo.getScheduleId();
		LoginInfo loginInfo = ContextHolder.getReqContext().getLoginInfo();
		IEvoWkfApi api = new SimpleApiImp();
		api.check(recordId, scheduleId, loginInfo.getSuiId(), loginInfo.getSuiLoginName());
	}
}
