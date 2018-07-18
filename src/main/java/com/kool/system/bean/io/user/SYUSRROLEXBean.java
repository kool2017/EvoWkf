/**
 * @PROJECT 
 * @DATE 2018年7月8日 下午10:41:31
 * @AUTHOR LUYU
 */
package com.kool.system.bean.io.user;

import com.kool.core.base.BaseBean;

/**
 * @DESCRIBE
 * @AUTHOR LUYU
 * @DATE 2018年7月8日 下午10:41:31
 *
 */
public class SYUSRROLEXBean extends BaseBean {
	private String userCid;
	private String roleCode;

	/**
	 * @return the userCid
	 */
	public String getUserCid() {
		return userCid;
	}

	/**
	 * @param userCid
	 *            the userCid to set
	 */
	public void setUserCid(String userCid) {
		this.userCid = userCid;
	}

	/**
	 * @return the roleCode
	 */
	public String getRoleCode() {
		return roleCode;
	}

	/**
	 * @param roleCode
	 *            the roleCode to set
	 */
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

}
