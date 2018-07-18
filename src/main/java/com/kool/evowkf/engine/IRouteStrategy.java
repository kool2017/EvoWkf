/**
 * @PROJECT 
 * @DATE 2018年2月17日 下午8:44:03
 * @AUTHOR LUYU
 */
package com.kool.evowkf.engine;

import com.kool.core.exception.AppException;
import com.kool.evowkf.bean.SyWkfNodeBean;
import com.kool.evowkf.bean.SyWkfScheduleBean;
import com.kool.evowkf.bean.vo.RouteResult;

/**
 * @DESCRIBE
 * @AUTHOR LUYU
 * @DATE 2018年2月17日 下午8:44:03
 *
 */
public interface IRouteStrategy {
	public RouteResult route(SyWkfScheduleBean schedule, SyWkfNodeBean node, WKFContext wkfInfo) throws AppException;
}
