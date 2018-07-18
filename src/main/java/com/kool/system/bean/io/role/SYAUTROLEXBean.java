/**
 * @PROJECT 
 * @DATE 2018年7月11日 下午9:23:15
 * @AUTHOR LUYU
 */
package com.kool.system.bean.io.role;

import com.kool.core.base.BaseBean;

/**
 * @DESCRIBE
 * @AUTHOR LUYU
 * @DATE 2018年7月11日 下午9:23:15
 *
 */
public class SYAUTROLEXBean extends BaseBean {
	private String roleCode;
	private String autCode;

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

	/**
	 * @return the autCode
	 */
	public String getAutCode() {
		return autCode;
	}

	/**
	 * @param autCode
	 *            the autCode to set
	 */
	public void setAutCode(String autCode) {
		this.autCode = autCode;
	}

}
