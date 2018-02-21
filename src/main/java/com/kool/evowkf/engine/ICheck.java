/**
 * @PROJECT 
 * @DATE 2018年2月15日 下午8:01:30
 * @AUTHOR LUYU
 */
package com.kool.evowkf.engine;

import com.kool.core.exception.BusException;

/**
 * @DESCRIBE
 * @AUTHOR LUYU
 * @DATE 2018年2月15日 下午8:01:30
 *
 */
public interface ICheck {
	public void check(String recordId, String scheduleId, String userId, String loginName) throws BusException;
}
