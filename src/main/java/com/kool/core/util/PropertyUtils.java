/**
 * @PROJECT 
 * @DATE 2017年12月27日 下午9:37:44
 * @AUTHOR LUYU
 */
package com.kool.core.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import com.kool.core.util.StringUtils;

/**
 * @DESCRIBE property处理工具
 * @AUTHOR LUYU
 * @DATE 2017年12月27日 下午9:37:44
 *
 */
public class PropertyUtils extends PropertyPlaceholderConfigurer {
	public static final String T_KEY_DEV_MODE = "DEV_MODE";
	public static final String T_KEY_DEV_LOG = "DEV_LOG";

	private static Map<String, String> propertyMap;

	@Override
	protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props)
			throws BeansException {
		super.processProperties(beanFactoryToProcess, props);
		propertyMap = new HashMap<String, String>();
		for (Object key : props.keySet()) {
			String keyStr = key.toString();
			String value = props.getProperty(keyStr);
			propertyMap.put(keyStr, value);
		}
	}

	public static String getValue(String name) {
		String value = propertyMap.get(name);
		if (StringUtils.isEmpty(value)) {
			return "";
		} else {
			return value;
		}
	}

}
