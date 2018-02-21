/**
 * @PROJECT 
 * @DATE 2018年1月19日 上午12:25:53
 * @AUTHOR LUYU
 */
package com.kool.core.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @DESCRIBE spring上下文工具
 * @AUTHOR LUYU
 * @DATE 2018年1月19日 上午12:25:53
 *
 */
@Component
public class SpringContextUtil implements ApplicationContextAware {

	// Spring应用上下文环境
	private static ApplicationContext applicationContext;

	/**
	 * 实现ApplicationContextAware接口的回调方法。设置上下文环境
	 * 
	 * @param applicationContext
	 */
	public void setApplicationContext(ApplicationContext applicationContext) {
		SpringContextUtil.applicationContext = applicationContext;
	}

	/**
	 * @return ApplicationContext
	 */
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	/**
	 * 获取对象
	 * 
	 * @param name
	 * @return Object
	 * @throws BeansException
	 */
	public static Object getBean(String name) {
		return applicationContext.getBean(name);
	}
	
	public static Object getBean(Class<?> clazz) {
		return applicationContext.getBean(clazz);
	}
}
