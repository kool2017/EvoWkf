/**
 * @PROJECT 
 * @DATE 2018年7月12日 下午10:56:59
 * @AUTHOR LUYU
 */
package com.kool.system.bean.io.cache;

import com.kool.core.base.BaseBean;
import com.kool.core.exception.AppException;
import com.kool.core.validate.IIoValidate;

/**
 * @DESCRIBE
 * @AUTHOR LUYU
 * @DATE 2018年7月12日 下午10:56:59
 *
 */
public class SYREFRESHCACHEXBean extends BaseBean implements IIoValidate {
	private String type;

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
	 * @DESCRIBE
	 * @DATE 2018年7月12日 下午10:57:15
	 *
	 * @throws AppException
	 */
	@Override
	public void validate() throws AppException {

	}

}
