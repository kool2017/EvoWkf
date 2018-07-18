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
	// 加密算法
	public static final String SECURITY_METHOD_MD5 = "md5";
	public static final String SECURITY_METHOD_SHA = "sha-256";

	public static final String CURRENT_THEAD_ID = "CURRENT_THEAD_ID";
	public static final String SESSION_LOGIN_INFO = "SESSION_LOGIN_INFO";
	public static final String REQ_CONTEXT = "REQ_CONTEXT";

	/*
	 * 缓存数据类型
	 */
	public static final String KCACHE_MENU = "MENU";// 菜单
	public static final String KCACHE_REQ = "REQ";// 请求
	public static final String KCACHE_USER = "USER";// 用户身份认证信息
	public static final String KCACHE_USER_MENU = "USER_MENU";// 用户菜单关系
	public static final String KCACHE_USER_REQ = "USER_REQ";// 用户请求关系
	public static final String KCACHE_ERRCOD = "ERRCOD";// 错误码
	public static final String KCACHE_PARAM = "PARAM";// 参数
	public static final String KCACHE_GLOBAL_DEFINE = "GLOBAL_DEF";// 系统预定义
	public static final String KCACHE_AUT = "AUT";// 权限
	public static final String KCACHE_ROLE = "ROLE";// 角色
	public static final String KCACHE_ROLE_GROUP = "ROLE_GROUP";// 角色组

	/*
	 * 错误码
	 */
	public static final String ERRCOD_NONE = "00000000";// 无错误
	public static final String ERRCOD_REQ_EXCEPTION = "SYERR000";// 请求Exception异常
	public static final String ERRCOD_REQ_THROWABLE = "SYERR001";// 请求Throwable异常

	/*
	 * properties文件配置
	 */
	public static final String PROP_UPLOAD_PATH = "UPLOAD_PATH";// 上传文件保存路径
	public static final String PROP_FACE_UPLOAD_PATH="FACE_UPLOAD_PATH";// 上传头像保存路径
	public static final String PROP_FACE_URL = "FACE_URL";// 头像链接
	
	public static final String HOME_MENU_CODE = "SY000000";//首页菜单编码

}
