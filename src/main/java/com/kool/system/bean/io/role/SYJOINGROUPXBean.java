/**
 * @PROJECT 
 * @DATE 2018年7月11日 下午9:00:57
 * @AUTHOR LUYU
 */
package com.kool.system.bean.io.role;

import com.kool.core.base.BaseBean;

/**
 * @DESCRIBE
 * @AUTHOR LUYU
 * @DATE 2018年7月11日 下午9:00:57
 *
 */
public class SYJOINGROUPXBean extends BaseBean {
	private String roleCode;
	private String groupCode;

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
	 * @return the groupCode
	 */
	public String getGroupCode() {
		return groupCode;
	}

	/**
	 * @param groupCode
	 *            the groupCode to set
	 */
	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

}
