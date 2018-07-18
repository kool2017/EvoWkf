/**
 * @PROJECT 
 * @DATE 2018年7月7日 下午7:08:50
 * @AUTHOR LUYU
 */
package com.kool.core.util;

import java.util.Set;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.kool.core.base.BaseBean;
import com.kool.core.exception.AppException;

/**
 * @DESCRIBE
 * @AUTHOR LUYU
 * @DATE 2018年7月7日 下午7:08:50
 *
 */
public class BeanUtils {
	/**
	 * 
	 * @DESCRIBE 将框架规范的bean转换成io
	 * @DATE 2018年7月7日 下午7:26:15
	 *
	 * @param io
	 * @param clazz
	 * @return
	 * @throws AppException
	 */
	public static Object bean2Io(BaseBean bean,Class<?> ioClazz) throws AppException {
		if (null == bean) {
			throw new AppException("SY000015");// 数据转换错误！
		}
		JSONObject joIo = new JSONObject();
		JSONObject joBean = JSON.parseObject(JSON.toJSONString(bean));
		Set<String> set = joBean.keySet();
		for (String key : set) {
			char header = key.charAt(3);
			header = Character.toLowerCase(header);
			String beanKey = String.valueOf(header)+key.substring(4);
			joIo.put(beanKey, joBean.get(key));
		}
		return JSON.toJavaObject(joIo, ioClazz);
	}
	
	/**
	 * 
	 * @DESCRIBE 将框架规范的io转换成bean
	 * @DATE 2018年7月7日 下午7:31:36
	 *
	 * @param io
	 * @param beanClazz
	 * @param prefix
	 * @return
	 * @throws AppException
	 */
	public static Object io2Bean(BaseBean io,Class<?> beanClazz,String prefix) throws AppException {
		if (null == io) {
			throw new AppException("SY000015");// 数据转换错误！
		}

		JSONObject joBean = new JSONObject();
		JSONObject joIo = JSON.parseObject(JSON.toJSONString(io));
		Set<String> set = joIo.keySet();
		for (String key : set) {
			char header = key.charAt(0);
			header = Character.toUpperCase(header);
			String beanKey = prefix+String.valueOf(header)+key.substring(1);
			joBean.put(beanKey, joIo.get(key));
		}
		
		return JSON.toJavaObject(joBean, beanClazz);
	}
	
}
