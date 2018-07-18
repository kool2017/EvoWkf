/**
 * @PROJECT 
 * @DATE 2018年2月15日 下午7:59:02
 * @AUTHOR LUYU
 */
package com.kool.evowkf.engine;

import com.kool.core.exception.AppException;

/**
 * @DESCRIBE
 * @AUTHOR LUYU
 * @DATE 2018年2月15日 下午7:59:02
 *
 */
public interface IStart {
	public String start(WKFContext wkfInfo) throws AppException;
}
