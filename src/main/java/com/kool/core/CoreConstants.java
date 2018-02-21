/**
 * @PROJECT 
 * @DATE 2018年1月19日 下午9:18:44
 * @AUTHOR LUYU
 */
package com.kool.core;

/**
 * @DESCRIBE 核心常量
 * @AUTHOR LUYU
 * @DATE 2018年1月19日 下午9:18:44
 *
 */
public class CoreConstants {
	//加密算法
	public static final String SECURITY_METHOD_MD5 = "md5";
	public static final String SECURITY_METHOD_SHA = "sha-256";
	
	public static final String CURRENT_THEAD_ID = "CURRENT_THEAD_ID";
	public static final String SESSION_LOGIN_INFO = "SESSION_LOGIN_INFO";
	public static final String REQ_CONTEXT = "REQ_CONTEXT";

	/*
	 * 状态 N-正常 E-异常 P-非工作 C-关闭
	 */
	public static final String SUI_STATUS_NORMAL = "N";
	public static final String SUI_STATUS_ERROR = "E";
	public static final String SUI_STATUS_PENDING = "P";
	public static final String SUI_STATUS_CLOSE = "C";
}
