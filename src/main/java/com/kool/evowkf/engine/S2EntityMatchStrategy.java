/**
 * @PROJECT 
 * @DATE 2018年2月16日 下午12:03:39
 * @AUTHOR LUYU
 */
package com.kool.evowkf.engine;

import java.util.List;

import com.kool.core.exception.AppException;
import com.kool.core.util.StringUtils;
import com.kool.evowkf.bean.SyWkfEntityBean;
import com.kool.evowkf.bean.vo.MatchValue;

/**
 * @DESCRIBE 自定义匹配，查询工作流实例的实例匹配值=业务自定义类执行结果的实例
 * @AUTHOR LUYU
 * @DATE 2018年2月16日 下午12:03:39
 *
 */
public class S2EntityMatchStrategy implements IEntityMatchStrategy {
	private String strategyClazz;

	/**
	 * @return the strategyClazz
	 */
	public String getStrategyClazz() {
		return strategyClazz;
	}

	/**
	 * @param strategyClazz
	 *            the strategyClazz to set
	 */
	public void setStrategyClazz(String strategyClazz) {
		this.strategyClazz = strategyClazz;
	}

	/**
	 * @DESCRIBE
	 * @DATE 2018年2月16日 下午12:12:47
	 *
	 * @param listEntity
	 * @param matchValue
	 * @return
	 * @throws AppException
	 * @throws BusException 
	 */
	@Override
	public SyWkfEntityBean getEntity(List<SyWkfEntityBean> listEntity, MatchValue matchValue) throws AppException {
		if (StringUtils.isEmpty(strategyClazz)) {
			throw new AppException("自定义实例匹配策略配置不正确，缺少自定义实现类");
		}
		SyWkfEntityBean entity = null;
		try {
			IEntityMatchStrategy strategy = (IEntityMatchStrategy) Class.forName(strategyClazz).newInstance();
			entity = strategy.getEntity(listEntity, matchValue);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			throw new AppException("自定义实例匹配策略配置不正确，实现类实例化失败", e);
		}
		return entity;
	}

}
