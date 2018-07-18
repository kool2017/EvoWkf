/**
 * @PROJECT 
 * @DATE 2018年7月8日 下午2:21:46
 * @AUTHOR LUYU
 */
package com.kool.system.bean.io;

import com.kool.core.base.BaseBean;

/**
 * @DESCRIBE
 * @AUTHOR LUYU
 * @DATE 2018年7月8日 下午2:21:46
 *
 */
public class SYUSRQRYZBean extends BaseBean {
	private String userCid;
	private String loginName;
	private String type;
	private String phone;
	private String mail;
	private String hasKey;
	private String keyUid;
	private String staffCid;
	private String state;
	private String face;

	/**
	 * @return the face
	 */
	public String getFace() {
		return face;
	}

	/**
	 * @param face
	 *            the face to set
	 */
	public void setFace(String face) {
		this.face = face;
	}

	/**
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * @param mail
	 *            the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * @return the keyUid
	 */
	public String getKeyUid() {
		return keyUid;
	}

	/**
	 * @param keyUid
	 *            the keyUid to set
	 */
	public void setKeyUid(String keyUid) {
		this.keyUid = keyUid;
	}

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
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone
	 *            the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
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
