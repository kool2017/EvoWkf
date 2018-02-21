/**
 * @PROJECT 
 * @DATE 2018年2月18日 上午10:48:40
 * @AUTHOR LUYU
 */
package com.kool.evowkf.engine;

import com.kool.evowkf.bean.SyWkfNodeBean;
import com.kool.evowkf.bean.SyWkfScheduleBean;
import com.kool.evowkf.bean.vo.RouteResult;

/**
 * @DESCRIBE
 * @AUTHOR LUYU
 * @DATE 2018年2月18日 上午10:48:40
 *
 */
public class C4BackStrategy implements IRouteStrategy {
	private String backClazz;

	/**
	 * @return the backClazz
	 */
	public String getBackClazz() {
		return backClazz;
	}

	/**
	 * @param backClazz
	 *            the backClazz to set
	 */
	public void setBackClazz(String backClazz) {
		this.backClazz = backClazz;
	}

	/**
	 * @DESCRIBE
	 * @DATE 2018年2月18日 上午10:48:51
	 *
	 * @param wkfInfo
	 * @return
	 */
	@Override
	public RouteResult route(SyWkfScheduleBean schedule, SyWkfNodeBean node, WKFContext wkfInfo) {
		// TODO Auto-generated method stub
		return null;
	}

}
