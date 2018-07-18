/**
 * @PROJECT 
 * @DATE 2018年2月16日 上午11:51:41
 * @AUTHOR LUYU
 */
package com.kool.evowkf.engine;

import java.util.List;

import com.kool.core.exception.AppException;
import com.kool.evowkf.bean.SyWkfEntityBean;
import com.kool.evowkf.bean.vo.MatchValue;

/**
 * @DESCRIBE 单实例匹配策略
 * @AUTHOR LUYU
 * @DATE 2018年2月16日 上午11:51:41
 *
 */
public class SingleEntityMatchStrategy implements IEntityMatchStrategy {

	/**
	 * @DESCRIBE
	 * @DATE 2018年2月16日 下午12:13:11
	 *
	 * @param listEntity
	 * @param matchValue
	 * @return
	 * @throws AppException 
	 */
	@Override
	public SyWkfEntityBean getEntity(List<SyWkfEntityBean> listEntity, MatchValue matchValue) throws AppException {
		if (null == listEntity || listEntity.size() != 1) {
			throw new AppException("工作流实例业务控制配置与工作流实例数不一致");// 工作流实例业务控制配置与工作流实例数不一致
		}
		return listEntity.get(0);
	}

}
