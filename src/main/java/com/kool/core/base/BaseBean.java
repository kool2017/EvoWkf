/**
 * @PROJECT 
 * @DATE 2017年12月27日 下午9:04:56
 * @AUTHOR LUYU
 */
package com.kool.core.base;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;

import com.alibaba.fastjson.JSONObject;

/**
 * @DESCRIBE bean的基类
 * @AUTHOR LUYU
 * @DATE 2017年12月27日 下午9:04:56
 *
 */
public class BaseBean {
	protected String formatString(Object data){
		String str = null;
		if (data instanceof String) {
			str = (String)data;
		}else if (data instanceof Integer||data instanceof Double) {
			str = data.toString();
		}else if (data instanceof java.sql.Date) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			str = sdf.format((java.sql.Date)data);
		}else if (data instanceof java.sql.Time) {
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			str = sdf.format((java.sql.Time)data);
		}else if (data instanceof java.sql.Timestamp) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
			str = sdf.format((java.sql.Timestamp)data);
		}else if (data instanceof BigDecimal) {
			BigDecimal bd = (BigDecimal) data;
			bd=bd.setScale(8, BigDecimal.ROUND_HALF_UP);
			str = bd.toString();
		}
		return str;
	}
	
	public String toString() {
		String s = JSONObject.toJSONString(this);
		return s;
	}
}
