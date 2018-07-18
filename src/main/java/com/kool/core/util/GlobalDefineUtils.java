package com.kool.core.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kool.core.CoreConstants;
import com.kool.core.cache.KCache;

/**
 * 
 * @DESCRIBE 预定义工具类
 * @AUTHOR LUYU
 * @DATE 2018年7月6日 下午3:03:12
 *
 */
public class GlobalDefineUtils {
	/**
	 * 
	 * @DESCRIBE 翻译预定义
	 * @DATE 2018年7月6日 下午4:11:05
	 *
	 * @param field
	 * @param value
	 * @return
	 */
	public static String transfer(String field, String value) {
		String gdValue = (String) KCache.get(CoreConstants.KCACHE_GLOBAL_DEFINE, field + value);
		if (null == gdValue) {
			return value;
		}
		return gdValue;
	}

	/**
	 * 
	 * @DESCRIBE 往JSONArray数组中添加jsonKey对应的预定义数据
	 * @DATE 2018年7月6日 下午3:17:20
	 *
	 * @param array
	 * @param jsonKey
	 * @param field
	 * @param gdKey
	 */
	public static void addTransformation(JSONArray array, String jsonKey, String field, String gdKey) {
		if (array != null && array.size() > 0) {
			for (Object object : array) {
				if (object instanceof JSONObject) {
					JSONObject jo = (JSONObject) object;
					addTransformation(jo, jsonKey, field, gdKey);
				}
			}
		}
	}

	/**
	 * 
	 * @DESCRIBE 往JSONObject中添加jsonKey对应的预定义数据
	 * @DATE 2018年7月6日 下午3:19:26
	 *
	 * @param object
	 * @param jsonKey
	 * @param field
	 * @param gdKey
	 */
	public static void addTransformation(JSONObject object, String jsonKey, String field, String gdKey) {
		if (object != null) {
			Object value = object.get(jsonKey);
			if (value instanceof String) {
				String sValue = (String) value;
				if (sValue != null) {
					String gdValue = (String) KCache.get(CoreConstants.KCACHE_GLOBAL_DEFINE, field + sValue);
					object.put(gdKey, gdValue);
				}
			}
		}
	}

	/**
	 * 
	 * @DESCRIBE 往JSONArray数组中添加jsonKey对应的预定义数据，gdKey=jsonKey+"_G"
	 * @DATE 2018年7月6日 下午3:41:46
	 *
	 * @param array
	 * @param jsonKey
	 * @param field
	 */
	public static void addTransformation(JSONArray array, String jsonKey, String field) {
		addTransformation(array, jsonKey, field, jsonKey + "_G");
	}

	/**
	 * 
	 * @DESCRIBE 往JSONObject中添加jsonKey对应的预定义数据，gdKey=jsonKey+"_G"
	 * @DATE 2018年7月6日 下午3:41:51
	 *
	 * @param object
	 * @param jsonKey
	 * @param field
	 */
	public static void addTransformation(JSONObject object, String jsonKey, String field) {
		addTransformation(object, jsonKey, field, jsonKey + "_G");
	}

}
