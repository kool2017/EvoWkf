/**
 * @PROJECT 
 * @DATE 2018年2月16日 下午12:02:14
 * @AUTHOR LUYU
 */
package com.kool.evowkf.engine;

import java.util.List;

import com.kool.core.exception.BusException;
import com.kool.core.util.StringUtils;
import com.kool.evowkf.bean.SyWkfEntityBean;
import com.kool.evowkf.bean.vo.MatchValue;

/**
 * @DESCRIBE 简单匹配，查询工作流实例的实例匹配值=业务字段值的实例
 * @AUTHOR LUYU
 * @DATE 2018年2月16日 下午12:02:14
 *
 */
public class S1EntityMatchStrategy implements IEntityMatchStrategy {

	/**
	 * @DESCRIBE
	 * @DATE 2018年2月16日 下午12:12:55
	 *
	 * @param listEntity
	 * @param matchValueObj
	 * @return
	 * @throws BusException 
	 */
	@Override
	public SyWkfEntityBean getEntity(List<SyWkfEntityBean> listEntity, MatchValue matchValueObj) throws BusException {
		String matchValue = matchValueObj.getMatchValue();
		if (StringUtils.isEmpty(matchValue)) {
			throw new BusException("简单匹配，传入的工作流实例的实例匹配业务值不能为空");
		}
		SyWkfEntityBean entity = null;
		for (SyWkfEntityBean entityItem : listEntity) {
			if (matchValue.equals(entityItem.getSweMatchValue())) {
				entity = entityItem;
				break;
			}
		}
		if (null == entity) {
			throw new BusException("无匹配的工作流实例");
		}
		return entity;
	}

}
