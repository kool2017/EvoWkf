/**
 * @PROJECT 
 * @DATE 2018年7月14日 上午12:53:45
 * @AUTHOR LUYU
 */
package com.kool.system.bean.io.aut;

import com.kool.core.base.BaseBean;
import com.kool.core.exception.AppException;
import com.kool.core.validate.IIoValidate;

/**
 * @DESCRIBE
 * @AUTHOR LUYU
 * @DATE 2018年7月14日 上午12:53:45
 *
 */
public class SYBINDMENUXBean extends BaseBean implements IIoValidate {
	private String autCode;
	private String menuCode;

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

	/**
	 * @return the menuCode
	 */
	public String getMenuCode() {
		return menuCode;
	}

	/**
	 * @param menuCode
	 *            the menuCode to set
	 */
	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}

	/**
	 * @DESCRIBE 
	 * @DATE 2018年7月14日 上午12:54:45
	 *
	 * @throws AppException
	 */
	@Override
	public void validate() throws AppException {
		
	}

}
