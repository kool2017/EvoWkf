/**
 * @PROJECT 
 * @DATE 2018年7月14日 上午12:58:15
 * @AUTHOR LUYU
 */
package com.kool.system.bean.io.aut;

import com.kool.core.base.BaseBean;
import com.kool.core.exception.AppException;
import com.kool.core.validate.IIoValidate;

/**
 * @DESCRIBE
 * @AUTHOR LUYU
 * @DATE 2018年7月14日 上午12:58:15
 *
 */
public class SYBINDREQXBean extends BaseBean implements IIoValidate {
	private String autCode;
	private String reqUrl;

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
	 * @return the reqUrl
	 */
	public String getReqUrl() {
		return reqUrl;
	}

	/**
	 * @param reqUrl
	 *            the reqUrl to set
	 */
	public void setReqUrl(String reqUrl) {
		this.reqUrl = reqUrl;
	}

	/**
	 * @DESCRIBE
	 * @DATE 2018年7月14日 上午12:58:59
	 *
	 * @throws AppException
	 */
	@Override
	public void validate() throws AppException {

	}

}
