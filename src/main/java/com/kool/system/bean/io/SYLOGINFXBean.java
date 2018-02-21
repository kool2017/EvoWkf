/**
 * @PROJECT 
 * @DATE 2017年12月31日 下午12:09:57
 * @AUTHOR LUYU
 */
package com.kool.system.bean.io;

/**
 * @DESCRIBE
 * @AUTHOR LUYU
 * @DATE 2017年12月31日 下午12:09:57
 *
 */
public class SYLOGINFXBean {
	protected String suiLoginName;
	protected String suiPwdA;
	protected String suiPwdB;
	protected String suiNewSalt;

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
	 * @return the suiPwdA
	 */
	public String getSuiPwdA() {
		return suiPwdA;
	}

	/**
	 * @param suiPwdA the suiPwdA to set
	 */
	public void setSuiPwdA(String suiPwdA) {
		this.suiPwdA = suiPwdA;
	}

	/**
	 * @return the suiPwdB
	 */
	public String getSuiPwdB() {
		return suiPwdB;
	}

	/**
	 * @param suiPwdB
	 *            the suiPwdB to set
	 */
	public void setSuiPwdB(String suiPwdB) {
		this.suiPwdB = suiPwdB;
	}

	/**
	 * @return the suiNewSalt
	 */
	public String getSuiNewSalt() {
		return suiNewSalt;
	}

	/**
	 * @param suiNewSalt the suiNewSalt to set
	 */
	public void setSuiNewSalt(String suiNewSalt) {
		this.suiNewSalt = suiNewSalt;
	}

}
