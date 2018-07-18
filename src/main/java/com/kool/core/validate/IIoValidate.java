/**
 * @PROJECT 
 * @DATE 2018年7月12日 下午1:26:50
 * @AUTHOR LUYU
 */
package com.kool.core.validate;

import com.kool.core.exception.AppException;

/**
 * @DESCRIBE 请求接口类校验接口
 * @AUTHOR LUYU
 * @DATE 2018年7月12日 下午1:26:50
 *
 */
public interface IIoValidate {
	/**
	 * 
	 * @DESCRIBE 提供字段基本校验：是否可空；最大长度；最小长度；最大值；最小值
	 * @DATE 2018年7月12日 下午1:27:42
	 *
	 * @throws AppException
	 */
	public abstract void validate() throws AppException;
}
