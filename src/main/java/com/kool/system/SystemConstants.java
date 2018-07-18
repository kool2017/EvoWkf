/**
 * @PROJECT 
 * @DATE 2017年12月27日 下午10:36:02
 * @AUTHOR LUYU
 */
package com.kool.system;

/**
 * @DESCRIBE
 * @AUTHOR LUYU
 * @DATE 2017年12月27日 下午10:36:02
 *
 */
public class SystemConstants {
	/*
	 * 用户类型 SA-超级管理员AD-管理员UR-一般用户VR-游客
	 */
	public static final String SUI_TYPE_SUPERADMIN = "SA";
	public static final String SUI_TYPE_ADMIN = "AD";
	public static final String SUI_TYPE_USER = "UR";
	public static final String SUI_TYPE_VISTOR = "VR";
	/*
	 * 用户状态 A-正常F-冻结E-异常P-非工作C-关闭
	 */
	public static final String SUI_STATE_ACTIVE = "A";
	public static final String SUI_STATE_FREEZE = "F";
	public static final String SUI_STATE_ERROR = "E";
	public static final String SUI_STATE_PENDING = "P";
	public static final String SUI_STATE_CLOSE = "C";

	/*
	 * 是否证书卡用户 Y-是N-否
	 */
	public static final String SUI_HAS_KEY_YES = "Y";
	public static final String SUI_HAS_KEY_NO = "N";
	
	/*
	 * 计数器
	 */
	public static final String CNT_USER_CID = "99USRCID";//用户ID
	/*
	 * 状态  A-正常C-关闭
	 */
	public static final String STATE_ACTIVE = "A";
	public static final String STATE_CLOSE = "C";

	/*
	 * 权限类型 S-超级管理员权限A-管理员权限B-普通权限
	 */
	public static final String SAD_TYPE_S ="S";
	public static final String SAD_TYPE_A ="A";
	public static final String SAD_TYPE_B ="B";
	public static final String SAD_TYPE_C ="C";
}
