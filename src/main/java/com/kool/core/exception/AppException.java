/**
 * @PROJECT 
 * @DATE 2017-04-26 22:43:35
 * @AUTHOR LUYU
 */
package com.kool.core.exception;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.kool.core.CoreConstants;
import com.kool.core.cache.KCache;
import com.kool.system.bean.SyErrorInfoBean;

/**
 * @DESCRIBE 程序异常，在请求返回前抓取
 * @AUTHOR LUYU
 * @DATE 2017-04-26 22:43:35
 *
 */
public class AppException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String errCod;// 错误码
	private String errMsg;// 错误信息
	private ArrayList<AppException> listAE;// 抓取的AppException异常栈，不包括自身

	public AppException(String errCod) {
		this.errCod = errCod;
		this.errMsg = translate(errCod, null);
	}

	public AppException(String errCod, String... args) {
		this.errCod = errCod;
		this.errMsg = translate(errCod, args);
	}

	/**
	 * 如果是抓取异常后构造AppException异常，则需要传入被抓取的异常，以此保证异常信息的完整
	 * 
	 * @param errCod
	 * @param e
	 */
	public AppException(String errCod, Exception e) {
		this.setStackTrace(e.getStackTrace());
		this.errCod = errCod;
		this.errMsg = translate(errCod, null);

		if (e instanceof AppException) {
			listAE = new ArrayList<>();
			AppException e2 = (AppException) e;
			if (e2.getListAE() != null) {
				listAE.addAll(e2.getListAE());
			}
			listAE.add(e2);
		}
	}

	public AppException(String errCod, Exception e, String... args) {
		this.setStackTrace(e.getStackTrace());
		this.errCod = errCod;
		this.errMsg = translate(errCod, args);

		if (e instanceof AppException) {
			listAE = new ArrayList<>();
			AppException e2 = (AppException) e;
			if (e2.getListAE() != null) {
				listAE.addAll(e2.getListAE());
			}
			listAE.add(e2);
		}
	}

	/**
	 * 
	 * @DESCRIBE 获取异常信息
	 * @DATE 2018年6月30日 下午11:24:12
	 *
	 * @return
	 */
	public String getMessage() {
		StringBuilder msg = new StringBuilder();
		if (errCod != null) {
			msg.append(errCod);
			msg.append(" : ");
		}
		if (errMsg != null) {
			msg.append(errMsg);
		}
		return msg.toString();
	}

	/**
	 * 
	 * @DESCRIBE 获取AppException异常栈的所有异常信息,外层的异常在组数前面
	 * @DATE 2018年6月30日 下午11:23:23
	 *
	 * @return
	 */
	public ArrayList<String> getAllMessages() {
		ArrayList<String> listMsg = new ArrayList<>();
		if (listAE != null) {
			for (AppException ae : listAE) {
				listMsg.add(ae.getMessage());
			}
		}
		listMsg.add(this.getMessage());
		return listMsg;
	}

	/**
	 * @DESCRIBE 获取异常错误码
	 * @DATE 2018年6月20日 下午2:28:00
	 *
	 * @return
	 */
	public String getErrorCode() {
		return this.errCod;
	}

	/**
	 * 
	 * @DESCRIBE 获取异常栈
	 * @DATE 2018年7月1日 上午12:04:56
	 *
	 * @return
	 */
	public ArrayList<AppException> getListAE() {
		return this.listAE;
	}

	/**
	 * 
	 * @DESCRIBE 翻译错误码。根据错误码从缓存中读取错误码信息
	 * @DATE 2018年6月30日 下午11:21:32
	 *
	 * @param errCod
	 * @param args
	 * @return
	 */
	private String translate(String errCod, String[] args) {
		String errMsg = "请登录演示系统：http://47.99.50.88";
		if (args != null) {
			int len = args.length;
			for (int i = 0; i < len; i++) {
				String arg = args[i];
				if (null == arg) {
					arg = "null";
				}
				String regex = "%" + Integer.valueOf(i + 1);
				Pattern pattern = Pattern.compile(regex);
				Matcher matcher = pattern.matcher(errMsg);
				errMsg = matcher.replaceAll(arg);
			}
		}
		return errMsg;
	}
}
