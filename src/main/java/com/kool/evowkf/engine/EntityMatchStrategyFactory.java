/**
 * @PROJECT 
 * @DATE 2018年2月16日 上午11:49:40
 * @AUTHOR LUYU
 */
package com.kool.evowkf.engine;

import com.kool.core.exception.AppException;
import com.kool.core.util.StringUtils;
import com.kool.core.validate.DefineValidator;
import com.kool.evowkf.WKFConstants;
import com.kool.evowkf.bean.SyWkfEntityBusinessBean;

/**
 * @DESCRIBE
 * @AUTHOR LUYU
 * @DATE 2018年2月16日 上午11:49:40
 *
 */
public class EntityMatchStrategyFactory {

	/**
	 * @DESCRIBE
	 * @DATE 2018年2月16日 上午11:49:46
	 *
	 * @param entityBusiness
	 * @return
	 * @throws BusException 
	 */
	public static IEntityMatchStrategy getStrategy(SyWkfEntityBusinessBean entityBusiness) throws AppException {
		if (null == entityBusiness) {
			throw new AppException("工作流实例-业务控制配置不能为空");// 工作流实例-业务控制配置不能为空
		}
		// 是否单实例标志
		String isSingle = entityBusiness.getSebIsSingle();
		if (StringUtils.isEmpty(isSingle)) {
			throw new AppException("是否单实例标志不能为空");
		}
		DefineValidator.validate("SEB_IS_SINGLE", isSingle);

		//多实例匹配策略
		String matchStrategy = entityBusiness.getSebMatchStrategy();
		DefineValidator.validate("SEB_MATCH_STRATEGY", matchStrategy);
		
		IEntityMatchStrategy strategy = null;
		if (WKFConstants.SEB_IS_SINGLE_YES.equals(isSingle)) {
			// 如果是单实例
			strategy = new SingleEntityMatchStrategy();
		} else if (WKFConstants.SEB_IS_SINGLE_NO.equals(isSingle) && WKFConstants.SEB_MATCH_STRATEGY_SIMPLE.equals(matchStrategy)) {
			//如果是多实例吗，简单模式
			strategy = new S1EntityMatchStrategy();
		} else if (WKFConstants.SEB_IS_SINGLE_NO.equals(isSingle) && WKFConstants.SEB_MATCH_STRATEGY_SELFDEFINE.equals(matchStrategy)) {
			//如果是多实例，自定义
			strategy = new S2EntityMatchStrategy();
		}
		return strategy;
	}

}
