package com.kool.system.bean.io;

import com.kool.core.base.BaseBean;

/**
 * @AUTHOR LUYU
 */
public class SYLOGINFZBean extends BaseBean {
	private String userCid;
	private String userName;
	private String face;
	private String signKey;
	
	/**
	 * @return the userCid
	 */
	public String getUserCid() {
		return userCid;
	}
	/**
	 * @param userCid the userCid to set
	 */
	public void setUserCid(String userCid) {
		this.userCid = userCid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFace() {
		return face;
	}
	public void setFace(String face) {
		this.face = face;
	}
	/**
	 * @return the signKey
	 */
	public String getSignKey() {
		return signKey;
	}
	/**
	 * @param signKey the signKey to set
	 */
	public void setSignKey(String signKey) {
		this.signKey = signKey;
	}
	
}
