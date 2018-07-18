/**
 * @PROJECT 
 * @DATE 2018年7月8日 下午2:18:11
 * @AUTHOR LUYU
 */
package com.kool.system.bean.io.user;

import com.kool.core.base.BaseBean;

/**
 * @DESCRIBE
 * @AUTHOR LUYU
 * @DATE 2018年7月8日 下午2:18:11
 *
 */
public class SYUSRQRYXBean extends BaseBean {
	private String userCid;
	private String loginName;
	private String type;
	private String hasKey;
	private String staffCid;
	private String state;

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
	 * @return the loginName
	 */
	public String getLoginName() {
		return loginName;
	}

	/**
	 * @param loginName
	 *            the loginName to set
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the hasKey
	 */
	public String getHasKey() {
		return hasKey;
	}

	/**
	 * @param hasKey
	 *            the hasKey to set
	 */
	public void setHasKey(String hasKey) {
		this.hasKey = hasKey;
	}

	/**
	 * @return the staffCid
	 */
	public String getStaffCid() {
		return staffCid;
	}

	/**
	 * @param staffCid
	 *            the staffCid to set
	 */
	public void setStaffCid(String staffCid) {
		this.staffCid = staffCid;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

}
