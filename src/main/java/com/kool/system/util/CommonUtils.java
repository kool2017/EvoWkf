/**
 * @PROJECT 
 * @DATE 2018年7月16日 下午3:24:00
 * @AUTHOR LUYU
 */
package com.kool.system.util;

import com.kool.core.CoreConstants;
import com.kool.core.cache.KCache;
import com.kool.core.exception.AppException;
import com.kool.core.util.GlobalDefineUtils;
import com.kool.system.SystemConstants;
import com.kool.system.bean.SyAutDefBean;
import com.kool.system.bean.SyUserInfoBean;

/**
 * @DESCRIBE 业务公共方法工具类
 * @AUTHOR LUYU
 * @DATE 2018年7月16日 下午3:24:00
 *
 */
public class CommonUtils {
	/**
	 * @DESCRIBE 验证权限类型和用户类型关系是否匹配
	 * @DATE 2018年7月16日 下午2:55:42
	 *
	 * @param userCid
	 * @param autCode
	 * @throws AppException
	 */
	public static void validateAutType(String userCid, String autCode) throws AppException {
		SyUserInfoBean user = (SyUserInfoBean) KCache.get(CoreConstants.KCACHE_USER, userCid);
		if (null == user) {
			throw new AppException("SY000059");// 获取用户信息失败，请刷新缓存后重试
		}
		String userType = user.getSuiType();
		SyAutDefBean aut = (SyAutDefBean) KCache.get(CoreConstants.KCACHE_AUT, autCode);
		if (null == aut) {
			throw new AppException("SY000060");// 获取权限信息失败，请刷新缓存后重试
		}
		String autType = aut.getSadType();
		// 如果用户是超管，且权限非超管、管理员、普通、游客权限，则报错
		if (SystemConstants.SUI_TYPE_SUPERADMIN.equals(userType) && SystemConstants.SAD_TYPE_S.equals(autType) == false
				&& SystemConstants.SAD_TYPE_A.equals(autType) == false
				&& SystemConstants.SAD_TYPE_B.equals(autType) == false
				&& SystemConstants.SAD_TYPE_C.equals(autType) == false) {
			throw new AppException("SY000061", aut.getSadName(), GlobalDefineUtils.transfer("SUI_TYPE", userType),
					GlobalDefineUtils.transfer("SAD_TYPE", autType));// 授权[%1]失败，用户类型[%2]无法授权权限类型[%3]的权限
		}
		// 如果用户是管理员，且权限非管理员、普通、游客权限，则报错
		if (SystemConstants.SUI_TYPE_ADMIN.equals(userType) && SystemConstants.SAD_TYPE_A.equals(autType) == false
				&& SystemConstants.SAD_TYPE_B.equals(autType) == false
				&& SystemConstants.SAD_TYPE_C.equals(autType) == false) {
			throw new AppException("SY000061", aut.getSadName(), GlobalDefineUtils.transfer("SUI_TYPE", userType),
					GlobalDefineUtils.transfer("SAD_TYPE", autType));// 授权[%1]失败，用户类型[%2]无法授权权限类型[%3]的权限
		}
		// 如果用户是普通用户，且权限非普通、游客权限，则报错
		if (SystemConstants.SUI_TYPE_USER.equals(userType) && SystemConstants.SAD_TYPE_B.equals(autType) == false
				&& SystemConstants.SAD_TYPE_C.equals(autType) == false) {
			throw new AppException("SY000061", aut.getSadName(), GlobalDefineUtils.transfer("SUI_TYPE", userType),
					GlobalDefineUtils.transfer("SAD_TYPE", autType));// 授权[%1]失败，用户类型[%2]无法授权权限类型[%3]的权限
		}
		// 如果用户是游客，且权限非游客权限，则报错
		if (SystemConstants.SUI_TYPE_VISTOR.equals(userType) && SystemConstants.SAD_TYPE_C.equals(autType) == false) {
			throw new AppException("SY000061", aut.getSadName(), GlobalDefineUtils.transfer("SUI_TYPE", userType),
					GlobalDefineUtils.transfer("SAD_TYPE", autType));// 授权[%1]失败，用户类型[%2]无法授权权限类型[%3]的权限
		}
	}

}
