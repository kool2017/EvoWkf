/**
 * @PROJECT 
 * @DATE 2018年7月12日 上午10:19:55
 * @AUTHOR LUYU
 */
package com.kool.system.bean.io.roleGroup;

import com.kool.core.base.BaseBean;

/**
 * @DESCRIBE
 * @AUTHOR LUYU
 * @DATE 2018年7月12日 上午10:19:55
 *
 */
public class SYAUTGROUPXBean extends BaseBean {
	private String groupCode;
	private String autCode;

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
