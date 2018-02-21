/**
 * @PROJECT 
 * @DATE 2018年2月17日 下午8:42:54
 * @AUTHOR LUYU
 */
package com.kool.evowkf.engine;

import com.kool.core.exception.BusException;
import com.kool.evowkf.WKFConstants;
import com.kool.evowkf.bean.SyWkfNodeBean;

/**
 * @DESCRIBE
 * @AUTHOR LUYU
 * @DATE 2018年2月17日 下午8:42:54
 *
 */
public class RouteStrategyFactory {

	/**
	 * @DESCRIBE
	 * @DATE 2018年2月18日 上午10:39:35
	 *
	 * @param node
	 * @return
	 * @throws BusException
	 */
	public static IRouteStrategy getStrategy(boolean forward, SyWkfNodeBean node) throws BusException {
		if (null == node) {
			throw new BusException("结点不能为空");
		}
		String routeStrategy = node.getSwnRouteStrategy();
		String routeClazz = node.getSwnRouteStrategyClazz();
		String backStrategy = node.getSwnBackStrategy();
		String backClazz = node.getSwnBackStrategyClazz();
		IRouteStrategy strategy = null;
		if (forward) {
			if (WKFConstants.SWN_ROUTE_STRATEGY_VIEWCHOOSE.equals(routeStrategy)) {
				strategy = new A1RouteStrategy();
			} else if (WKFConstants.SWN_ROUTE_STRATEGY_RANDOM.equals(routeStrategy)) {
				strategy = new A2RouteStrategy();
			} else if (WKFConstants.SWN_ROUTE_STRATEGY_NEXTGROUP.equals(routeStrategy)) {
				strategy = new A4RouteStrategy();
			} else if (WKFConstants.SWN_ROUTE_STRATEGY_SELFDEFINE.equals(routeStrategy)) {
				A5RouteStrategy A5Strategy = new A5RouteStrategy();
				A5Strategy.setRouteClazz(routeClazz);
				strategy = A5Strategy;
			} else {
				throw new BusException("不支持的路由策略");
			}
		} else {
			if (WKFConstants.SWN_BACK_STRATEGY_LAST.equals(backStrategy)) {
				strategy = new C1BackStrategy();
			}else if(WKFConstants.SWN_BACK_STRATEGY_FINISH.equals(backStrategy)) {
				strategy = new C2BackStrategy();
			}else if(WKFConstants.SWN_BACK_STRATEGY_VIEWCHOOSE.equals(backStrategy)) {
				strategy = new C3BackStrategy();
			}else if(WKFConstants.SWN_BACK_STRATEGY_SELFDEFINE.equals(backStrategy)) {
				C4BackStrategy C4Strategy = new C4BackStrategy();
				C4Strategy.setBackClazz(backClazz);
				strategy = C4Strategy;
			}else {
				throw new BusException("不支持的回退策略");
			}
		}
		return strategy;
	}
}
