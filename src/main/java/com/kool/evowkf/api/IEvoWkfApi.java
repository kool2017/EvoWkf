/**
 * @PROJECT 
 * @DATE 2018年2月13日 上午11:08:08
 * @AUTHOR LUYU
 */
package com.kool.evowkf.api;

import com.kool.core.exception.AppException;
import com.kool.core.exception.BusException;
import com.kool.evowkf.engine.WKFContext;
import com.kool.system.bean.io.SYPAGEINFOYBean;
import com.kool.system.bean.vo.PageResult;

/**
 * @DESCRIBE api for out system,contains init,start,query,check,nextStep,operation service......
 * @AUTHOR LUYU
 * @DATE 2018年2月13日 上午11:08:08
 *
 */
public interface IEvoWkfApi {
	/**
	 * 
	 * @DESCRIBE 初始化工作流引擎，通常在服务启动时调用。 
	 * @DATE 2018年2月13日 上午11:21:25
	 *
	 */
	public void resetEngine();
	
	public String start(WKFContext wkfInfo) throws AppException, BusException;
	
	public PageResult querySchedule(String recordId, String businessType, String userId, String loginName, SYPAGEINFOYBean pageInfo);
	
	public void check(String recordId, String scheduleId, String userId, String loginName) throws BusException;
	
	public void nextStep(WKFContext wkfInfo) throws BusException, AppException;
	
	public void executeNodeByOperations(WKFContext wkfInfo);
	
	public void stopFlowByOperations(WKFContext wkfInfo);
	
}
