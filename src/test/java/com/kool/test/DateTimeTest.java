/**
 * @PROJECT 
 * @DATE 2018年7月13日 上午10:49:36
 * @AUTHOR LUYU
 */
package com.kool.test;

import java.sql.Date;
import java.sql.Timestamp;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @DESCRIBE 
 * @AUTHOR LUYU
 * @DATE 2018年7月13日 上午10:49:36
 *
 */
public class DateTimeTest {
	private Timestamp ts;
	private Date d;
	
	/**
	 * @return the ts
	 */
	public Timestamp getTs() {
		return ts;
	}

	/**
	 * @param ts the ts to set
	 */
	public void setTs(Timestamp ts) {
		this.ts = ts;
	}

	/**
	 * @return the d
	 */
	public Date getD() {
		return d;
	}

	/**
	 * @param d the d to set
	 */
	public void setD(Date d) {
		this.d = d;
	}

	public static void main(String[] args) {
		DateTimeTest test = new DateTimeTest();
		JSONObject propIn = new JSONObject();
		long tsIn = System.currentTimeMillis();
		long dIn = System.currentTimeMillis();
//		long tIn = System.currentTimeMillis();
//		propIn.put("ts", tsIn);
//		propIn.put("d", dIn);
//		propIn.put("t", tIn);
		String tsInS = String.valueOf(tsIn);
		String dInS = String.valueOf(dIn);
		propIn.put("ts", tsInS);
		propIn.put("d", dInS);
		
		System.out.println(propIn);
		test = JSON.toJavaObject(propIn, DateTimeTest.class);
		System.out.println(test.getD());
		System.out.println(test.getTs());
		
		JSONObject propOut = (JSONObject) JSON.toJSON(test);
		System.out.println(propOut);
		propOut = JSONObject.parseObject(JSON.toJSONString(test));
		System.out.println(propOut);
				
	}
}
