/**
 * @PROJECT 
 * @DATE 2018年2月13日 下午5:55:48
 * @AUTHOR LUYU
 */
package com.kool.evowkf.api;

import com.kool.core.exception.AppException;
import com.kool.core.exception.BusException;
import com.kool.evowkf.engine.Alice;
import com.kool.evowkf.engine.WKFContext;
import com.kool.system.bean.io.SYPAGEINFOYBean;
import com.kool.system.bean.vo.PageResult;

/**
 * @DESCRIBE 对外接口实现类-通用版本
 * @AUTHOR LUYU
 * @DATE 2018年2月13日 下午5:55:48
 *
 */
public class SimpleApiImp implements IEvoWkfApi {

	/**
	 * @DESCRIBE
	 * @DATE 2018年2月13日 下午5:56:02
	 *
	 */
	@Override
	public void resetEngine() {
		Alice.getInstance().reset();
		;
	}

	/**
	 * @throws AppException
	 * @throws BusException
	 * @DESCRIBE
	 * @DATE 2018年2月13日 下午5:56:02
	 *
	 */
	@Override
	public String start(WKFContext wkfInfo) throws AppException, BusException {
		return Alice.getInstance().getStartWorker().start(wkfInfo);
	}

	/**
	 * @DESCRIBE
	 * @DATE 2018年2月13日 下午5:56:02
	 *
	 * @return
	 */
	@Override
	public PageResult querySchedule(String recordId, String businessType, String userId, String loginName,
			SYPAGEINFOYBean pageInfo) {
		return Alice.getInstance().getScheduleWorker().querySchedule(recordId, businessType, userId, loginName,
				pageInfo);
	}

	/**
	 * @throws BusException
	 * @DESCRIBE
	 * @DATE 2018年2月13日 下午5:56:02
	 *
	 */
	@Override
	public void check(String recordId, String scheduleId, String userId, String loginName) throws BusException {
		Alice.getInstance().getCheckWorker().check(recordId, scheduleId, userId, loginName);
	}

	/**
	 * @throws BusException
	 * @throws AppException
	 * @DESCRIBE
	 * @DATE 2018年2月13日 下午5:56:02
	 *
	 */
	@Override
	public void nextStep(WKFContext wkfInfo) throws BusException, AppException {
		Alice.getInstance().getStepWorker().nextStep(wkfInfo);
	}

	/**
	 * @DESCRIBE
	 * @DATE 2018年2月13日 下午5:56:02
	 *
	 */
	@Override
	public void executeNodeByOperations(WKFContext wkfInfo) {
		Alice.getInstance().getOperationWorker().executeNodeByOperations(wkfInfo);
	}

	/**
	 * @DESCRIBE
	 * @DATE 2018年2月13日 下午5:56:02
	 *
	 */
	@Override
	public void stopFlowByOperations(WKFContext wkfInfo) {
		Alice.getInstance().getOperationWorker().stopFlowByOperations(wkfInfo);
	}

}
