/**
 * @PROJECT 
 * @DATE 2018年2月15日 下午8:03:09
 * @AUTHOR LUYU
 */
package com.kool.evowkf.engine;

import com.kool.core.exception.AppException;

/**
 * @DESCRIBE
 * @AUTHOR LUYU
 * @DATE 2018年2月15日 下午8:03:09
 *
 */
public interface IStep {
	public void nextStep(WKFContext wkfInfo) throws AppException;
}
