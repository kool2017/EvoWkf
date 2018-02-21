/**
 * @PROJECT 
 * @DATE 2018年2月17日 下午8:58:59
 * @AUTHOR LUYU
 */
package com.kool.evowkf.engine;

import com.kool.evowkf.bean.SyWkfNodeBean;
import com.kool.evowkf.bean.SyWkfScheduleBean;
import com.kool.evowkf.bean.vo.RouteResult;

/**
 * @DESCRIBE
 * @AUTHOR LUYU
 * @DATE 2018年2月17日 下午8:58:59
 *
 */
public class A5RouteStrategy implements IRouteStrategy {
	private String routeClazz;

	/**
	 * @return the routeClazz
	 */
	public String getRouteClazz() {
		return routeClazz;
	}

	/**
	 * @param routeClazz
	 *            the routeClazz to set
	 */
	public void setRouteClazz(String routeClazz) {
		this.routeClazz = routeClazz;
	}

	/**
	 * @DESCRIBE
	 * @DATE 2018年2月17日 下午8:44:43
	 *
	 */
	@Override
	public RouteResult route(SyWkfScheduleBean schedule, SyWkfNodeBean node, WKFContext wkfInfo) {
		// TODO Auto-generated method stub
		return null;
	}

}
