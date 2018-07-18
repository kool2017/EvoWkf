/**
 * @PROJECT 
 * @DATE 2017年12月31日 下午12:23:44
 * @AUTHOR LUYU
 */
package com.kool.system.bean.io;

import com.kool.core.base.BaseBean;

/**
 * @DESCRIBE
 * @AUTHOR LUYU
 * @DATE 2017年12月31日 下午12:23:44
 *
 */
public class SYUSRINFZBean extends BaseBean {
	protected String suiUserCid;
	protected String suiLoginName;
	protected String suiPhone;
	protected String suiMail;
	protected String suiPwd;
	protected String suiSalt;
	protected String suiNewSalt;
	protected int suiHashTimes;
	protected String suiFace;
	protected String suiStatus;
	protected int suiErrorTimes;
	protected java.sql.Timestamp suiRegisterTime;

	/**
	 * @return the suiUserCid
	 */
	public String getSuiUserCid() {
		return suiUserCid;
	}

	/**
	 * @param suiUserCid
	 *            the suiUserCid to set
	 */
	public void setSuiUserCid(String suiUserCid) {
		this.suiUserCid = suiUserCid;
	}

	/**
	 * @return the suiLoginName
	 */
	public String getSuiLoginName() {
		return suiLoginName;
	}

	/**
	 * @param suiLoginName
	 *            the suiLoginName to set
	 */
	public void setSuiLoginName(String suiLoginName) {
		this.suiLoginName = suiLoginName;
	}

	/**
	 * @return the suiPhone
	 */
	public String getSuiPhone() {
		return suiPhone;
	}

	/**
	 * @param suiPhone
	 *            the suiPhone to set
	 */
	public void setSuiPhone(String suiPhone) {
		this.suiPhone = suiPhone;
	}

	/**
	 * @return the suiMail
	 */
	public String getSuiMail() {
		return suiMail;
	}

	/**
	 * @param suiMail
	 *            the suiMail to set
	 */
	public void setSuiMail(String suiMail) {
		this.suiMail = suiMail;
	}

	/**
	 * @return the suiPwd
	 */
	public String getSuiPwd() {
		return suiPwd;
	}

	/**
	 * @param suiPwd
	 *            the suiPwd to set
	 */
	public void setSuiPwd(String suiPwd) {
		this.suiPwd = suiPwd;
	}

	/**
	 * @return the suiSalt
	 */
	public String getSuiSalt() {
		return suiSalt;
	}

	/**
	 * @param suiSalt
	 *            the suiSalt to set
	 */
	public void setSuiSalt(String suiSalt) {
		this.suiSalt = suiSalt;
	}

	/**
	 * @return the suiNewSalt
	 */
	public String getSuiNewSalt() {
		return suiNewSalt;
	}

	/**
	 * @param suiNewSalt
	 *            the suiNewSalt to set
	 */
	public void setSuiNewSalt(String suiNewSalt) {
		this.suiNewSalt = suiNewSalt;
	}

	/**
	 * @return the suiHashTimes
	 */
	public int getSuiHashTimes() {
		return suiHashTimes;
	}

	/**
	 * @param suiHashTimes
	 *            the suiHashTimes to set
	 */
	public void setSuiHashTimes(int suiHashTimes) {
		this.suiHashTimes = suiHashTimes;
	}

	/**
	 * @return the suiFace
	 */
	public String getSuiFace() {
		return suiFace;
	}

	/**
	 * @param suiFace
	 *            the suiFace to set
	 */
	public void setSuiFace(String suiFace) {
		this.suiFace = suiFace;
	}

	/**
	 * @return the suiStatus
	 */
	public String getSuiStatus() {
		return suiStatus;
	}

	/**
	 * @param suiStatus
	 *            the suiStatus to set
	 */
	public void setSuiStatus(String suiStatus) {
		this.suiStatus = suiStatus;
	}

	/**
	 * @return the suiErrorTimes
	 */
	public int getSuiErrorTimes() {
		return suiErrorTimes;
	}

	/**
	 * @param suiErrorTimes
	 *            the suiErrorTimes to set
	 */
	public void setSuiErrorTimes(int suiErrorTimes) {
		this.suiErrorTimes = suiErrorTimes;
	}

	/**
	 * @return the suiRegisterTime
	 */
	public java.sql.Timestamp getSuiRegisterTime() {
		return suiRegisterTime;
	}

	/**
	 * @param suiRegisterTime
	 *            the suiRegisterTime to set
	 */
	public void setSuiRegisterTime(java.sql.Timestamp suiRegisterTime) {
		this.suiRegisterTime = suiRegisterTime;
	}

}
