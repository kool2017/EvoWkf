/**
 * @PROJECT 
 * @DATE 2018年1月1日 上午10:40:32
 * @AUTHOR LUYU
 */
package com.kool.core.log;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.kool.core.context.ContextHolder;

/**
 * @DESCRIBE 日志切面，测试类
 * @AUTHOR LUYU
 * @DATE 2018年1月1日 上午10:40:32
 *
 */
public class MyLogger {
	public void printTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dt = new Date(System.currentTimeMillis());

		System.out.println(sdf.format(dt));
		if (ContextHolder.getReqContext() == null || ContextHolder.getReqContext().getLoginInfo() == null) {
			return;
		}
		String id = ContextHolder.getReqContext().getLoginInfo().getSuiId();
		String name = ContextHolder.getReqContext().getLoginInfo().getSuiLoginName();
		String uri = ContextHolder.getReqContext().getRequest().getRequestURI();
		System.out.println("URI: " + uri);
		System.out.println("userId: " + id);
		System.out.println("userName: " + name);
	}
}
