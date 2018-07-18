/**
 * @PROJECT 
 * @DATE 2018年2月18日 下午8:18:36
 * @AUTHOR LUYU
 */
package com.kool.evowkf.api;

import com.kool.core.exception.AppException;
import com.kool.evowkf.bean.vo.BusinessEvent;

/**
 * @DESCRIBE
 * @AUTHOR LUYU
 * @DATE 2018年2月18日 下午8:18:36
 *
 */
public interface IBusinessEventHandler {
	public void handle(BusinessEvent event) throws AppException;
}
