/**
 * @PROJECT 
 * @DATE 2018年7月8日 下午5:39:25
 * @AUTHOR LUYU
 */
package com.kool.system.bean.io.user;

import com.kool.core.base.BaseBean;

/**
 * @DESCRIBE
 * @AUTHOR LUYU
 * @DATE 2018年7月8日 下午5:39:25
 *
 */
public class SYUPDPWDXBean extends BaseBean {
	private String userCid;
	private String oldPwd;
	private String newPwd;
	private String newPwdC;

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
	 * @return the oldPwd
	 */
	public String getOldPwd() {
		return oldPwd;
	}

	/**
	 * @param oldPwd
	 *            the oldPwd to set
	 */
	public void setOldPwd(String oldPwd) {
		this.oldPwd = oldPwd;
	}

	/**
	 * @return the newPwd
	 */
	public String getNewPwd() {
		return newPwd;
	}

	/**
	 * @param newPwd
	 *            the newPwd to set
	 */
	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}

	/**
	 * @return the newPwdC
	 */
	public String getNewPwdC() {
		return newPwdC;
	}

	/**
	 * @param newPwdC
	 *            the newPwdC to set
	 */
	public void setNewPwdC(String newPwdC) {
		this.newPwdC = newPwdC;
	}

}
