/**
 * @PROJECT 
 * @DATE 2018年7月8日 下午2:09:52
 * @AUTHOR LUYU
 */
package com.kool.system.bean.io.user;

import com.kool.core.base.BaseBean;
import com.kool.core.exception.AppException;
import com.kool.core.util.StringUtils;
import com.kool.core.validate.IIoValidate;

/**
 * @DESCRIBE
 * @AUTHOR LUYU
 * @DATE 2018年7月8日 下午2:09:52
 *
 */
public class SYUSRINFXBean extends BaseBean implements IIoValidate {
	private String loginName;
	private String type;
	private String phone;
	private String mail;
	private String hasKey;
	private String keyUid;
	private String staffCid;
	protected String face;

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

	public String getFace() {
		return face;
	}

	public void setFace(String face) {
		this.face = face;
	}

	@Override
	public void validate() throws AppException {
		// 非空校验
		if (StringUtils.isEmpty(loginName)) {
			throw new AppException("SY000036", "loginName");// 字段[%1]为空
		}
		// 最大长度校验
		if (loginName != null && loginName.length() > 60) {
			throw new AppException("SY000038", "loginName", String.valueOf(60));// 字段[%1]大于最大长度[%2]
		}
		// 非空校验
		if (StringUtils.isEmpty(type)) {
			throw new AppException("SY000036", "type");// 字段[%1]为空
		}
		// 最大长度校验
		if (phone != null && phone.length() > 20) {
			throw new AppException("SY000038", "phone", String.valueOf(20));// 字段[%1]大于最大长度[%2]
		}
		// 最大长度校验
		if (mail != null && mail.length() > 100) {
			throw new AppException("SY000038", "mail", String.valueOf(100));// 字段[%1]大于最大长度[%2]
		}
		// 非空校验
		if (StringUtils.isEmpty(hasKey)) {
			throw new AppException("SY000036", "hasKey");// 字段[%1]为空
		}
		// 最大长度校验
		if (keyUid != null && keyUid.length() > 36) {
			throw new AppException("SY000038", "keyUid", String.valueOf(36));// 字段[%1]大于最大长度[%2]
		}
		// 最大长度校验
		if (staffCid != null && staffCid.length() > 4) {
			throw new AppException("SY000038", "staffCid", String.valueOf(4));// 字段[%1]大于最大长度[%2]
		}
		// 最大长度校验
		if (face != null && face.length() > 100) {
			throw new AppException("SY000038", "face", String.valueOf(100));// 字段[%1]大于最大长度[%2]
		}
	}
}
