/**
 * @PROJECT 
 * @DATE 2018年2月16日 上午11:49:57
 * @AUTHOR LUYU
 */
package com.kool.evowkf.engine;

import java.util.List;

import com.kool.core.exception.AppException;
import com.kool.core.exception.BusException;
import com.kool.evowkf.bean.SyWkfEntityBean;
import com.kool.evowkf.bean.vo.MatchValue;

/**
 * @DESCRIBE
 * @AUTHOR LUYU
 * @DATE 2018年2月16日 上午11:49:57
 *
 */
public interface IEntityMatchStrategy {

	/**
	 * @DESCRIBE 
	 * @DATE 2018年2月16日 上午11:50:04
	 *
	 * @param listEntity
	 * @param matchValue 
	 * @return
	 * @throws AppException 
	 * @throws BusException 
	 */
	public SyWkfEntityBean getEntity(List<SyWkfEntityBean> listEntity, MatchValue matchValue) throws AppException, BusException;

}
