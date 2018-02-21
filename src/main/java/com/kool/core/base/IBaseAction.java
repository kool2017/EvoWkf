/**
 * @PROJECT 
 * @DATE 2018年1月1日 下午12:26:10
 * @AUTHOR LUYU
 */
package com.kool.core.base;

import com.alibaba.fastjson.JSONObject;
import com.kool.core.exception.AppException;
import com.kool.core.exception.BusException;

/**
 * @DESCRIBE 请求入口
 * @AUTHOR LUYU
 * @DATE 2018年1月1日 下午12:26:10
 *
 */
public interface IBaseAction {
	public JSONObject doAction(String sInput) throws BusException,AppException;
}
