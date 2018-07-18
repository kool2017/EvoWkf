/**
 * @PROJECT 
 * @DATE 2018年7月8日 下午3:01:41
 * @AUTHOR LUYU
 */
package com.kool.system.bean.io.user;

import com.kool.core.base.BaseBean;

/**
 * @DESCRIBE
 * @AUTHOR LUYU
 * @DATE 2018年7月8日 下午3:01:41
 *
 */
public class SYLOGINLOGZBean extends BaseBean {
	private String logUid;
	private String userCid;
	private String time;
	private String ip;

	/**
	 * @return the logUid
	 */
	public String getLogUid() {
		return logUid;
	}

	/**
	 * @param logUid
	 *            the logUid to set
	 */
	public void setLogUid(String logUid) {
		this.logUid = logUid;
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
	 * @return the time
	 */
	public String getTime() {
		return time;
	}

	/**
	 * @param time
	 *            the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}

	/**
	 * @return the ip
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * @param ip
	 *            the ip to set
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

}
