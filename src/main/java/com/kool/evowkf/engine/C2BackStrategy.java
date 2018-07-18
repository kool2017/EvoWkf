/**
 * @PROJECT 
 * @DATE 2018年2月18日 上午10:48:25
 * @AUTHOR LUYU
 */
package com.kool.evowkf.engine;

import com.kool.evowkf.WKFConstants;
import com.kool.evowkf.bean.SyWkfNodeBean;
import com.kool.evowkf.bean.SyWkfScheduleBean;
import com.kool.evowkf.bean.vo.RouteResult;

/**
 * @DESCRIBE C2-终止流程
 * @AUTHOR LUYU
 * @DATE 2018年2月18日 上午10:48:25
 *
 */
public class C2BackStrategy implements IRouteStrategy{

	/**
	 * @DESCRIBE 执行记录状态=完成，不新建待办
	 * @DATE 2018年2月18日 上午10:48:51
	 *
	 * @param wkfInfo
	 * @return
	 */
	@Override
	public RouteResult route(SyWkfScheduleBean schedule, SyWkfNodeBean node, WKFContext wkfInfo) {
		// 执行记录状态
		String recordStatus = WKFConstants.SRC_STATE_FINISH;//完成
		RouteResult result = new RouteResult();
		result.setRecordStatus(recordStatus);
		return result;
	}

}
