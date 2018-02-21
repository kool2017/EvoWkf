/**
 * @PROJECT 
 * @DATE 2018年2月3日 下午8:11:47
 * @AUTHOR LUYU
 */
package com.kool.core.exception;

/**
 * @DESCRIBE 业务异常，通常是校验不通过时的异常，在请求返回前会抓住处理成报文信息返回
 * @AUTHOR LUYU
 * @DATE 2018年2月3日 下午8:11:47
 *
 */
public class BusException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -872565237587709662L;

	private String errCod;
	private String errMsg;
	
	public BusException(String errCod){
		this.errCod = errCod;
		this.errMsg = errCod;
	}
	
	/**
	 * @param string
	 * @param e
	 */
	public BusException(String errCod, Exception e) {
		this.setStackTrace(e.getStackTrace());
		this.errCod = errCod;
		this.errMsg = errCod;
		
	}

	public String getMessage() {
		String msg = "";
		if (errCod != null && errMsg != null) {
			msg = errCod+" "+errMsg;
		}
		return msg;
	}
}
