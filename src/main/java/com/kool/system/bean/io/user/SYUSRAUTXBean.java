/**
 * @PROJECT 
 * @DATE 2018年7月8日 下午7:12:26
 * @AUTHOR LUYU
 */
package com.kool.system.bean.io.user;

import com.kool.core.base.BaseBean;

/**
 * @DESCRIBE
 * @AUTHOR LUYU
 * @DATE 2018年7月8日 下午7:12:26
 *
 */
public class SYUSRAUTXBean extends BaseBean {
	private String userCid;
	private String autCode;

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
