/**
 * @PROJECT 
 * @DATE 2018年2月17日 下午3:27:21
 * @AUTHOR LUYU
 */
package com.kool.evowkf.engine;

import com.kool.core.exception.AppException;
import com.kool.core.exception.BusException;

/**
 * @DESCRIBE
 * @AUTHOR LUYU
 * @DATE 2018年2月17日 下午3:27:21
 *
 */
public interface IEventRule {
	public void DoRule(NodeEvent event) throws AppException, BusException;
}
