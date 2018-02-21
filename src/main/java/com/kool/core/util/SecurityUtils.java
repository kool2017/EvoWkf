/**
 * @PROJECT 
 * @DATE 2017年12月27日 下午10:15:59
 * @AUTHOR LUYU
 */
package com.kool.core.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;

import com.kool.core.CoreConstants;
import com.kool.core.exception.AppException;

/**
 * @DESCRIBE 安全工具
 * @AUTHOR LUYU
 * @DATE 2017年12月27日 下午10:15:59
 *
 */
public class SecurityUtils {
	private static Logger log = Logger.getLogger(SecurityUtils.class);

	/**
	 * 
	 * @DESCRIBE
	 * @DATE 2017年12月27日 下午10:16:59
	 *
	 * @param sContent
	 * @return
	 * @throws AppException 
	 */
	public static String sha(String sContent) throws AppException {
		String encryptText = null;
		try {
			MessageDigest m = MessageDigest.getInstance(CoreConstants.SECURITY_METHOD_SHA);
			m.update(sContent.getBytes("UTF8"));
			byte s[] = m.digest();
			encryptText = hex(s);
		} catch (NoSuchAlgorithmException e) {
			log.error(e);
			throw new AppException("加密失败，无此算法",e);
		} catch (UnsupportedEncodingException e) {
			log.error(e);
			throw new AppException("加密失败，不支持的编码集",e);
		}
		return encryptText;
	}

	/**
	 * 
	 * @DESCRIBE
	 * @DATE 2017年12月27日 下午10:21:42
	 *
	 * @param sContent
	 * @return
	 * @throws AppException 
	 */
	public static String md5(String sContent) throws AppException {
		String encryptText = null;
		try {
			MessageDigest m = MessageDigest.getInstance(CoreConstants.SECURITY_METHOD_MD5);
			m.update(sContent.getBytes("UTF8"));
			byte s[] = m.digest();
			encryptText = hex(s);
		} catch (NoSuchAlgorithmException e) {
			log.error(e);
			throw new AppException("加密失败，无此算法",e);
		} catch (UnsupportedEncodingException e) {
			log.error(e);
			throw new AppException("加密失败，不支持的编码集",e);
		}
		return encryptText;
	}

	/**
	 * 
	 * @DESCRIBE
	 * @DATE 2017年12月27日 下午10:27:26
	 *
	 * @param arr
	 * @return
	 */
	private static String hex(byte[] arr) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < arr.length; ++i) {
			sb.append(Integer.toHexString((arr[i] & 0xFF) | 0x100).substring(1, 3));
		}
		return sb.toString();
	}

	/**
	 * 
	 * @DESCRIBE base64编码
	 * @DATE 2017年12月31日 下午3:12:08
	 *
	 * @param text
	 * @return
	 * @throws AppException
	 */
	public static String base64Encode(String text) throws AppException {
		String encodeText = null;
		try {
			encodeText = Base64.encodeBase64String(text.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			log.error(e);
			throw new AppException("编码失败，不支持的编码集",e);
		}
		return encodeText;
	}

	/**
	 * 
	 * @DESCRIBE base64解码
	 * @DATE 2017年12月31日 下午3:12:22
	 *
	 * @param encodeText
	 * @return
	 */
	public static String base64Decode(String encodeText) {
		String decodeText = new String(Base64.decodeBase64(encodeText));
		return decodeText;
	}

	public static void main(String[] args) throws AppException {
		String pwd = "ly";
//		System.out.println(md5(pwd));
//		System.out.println(md5(pwd).length());
//		System.out.println(sha(pwd));
//		System.out.println(sha(pwd).length());
//		long beg = System.currentTimeMillis();
//		for (int i = 0; i < 10000; i++) {
//			pwd = sha(pwd);
//		}
//		long end = System.currentTimeMillis();
//		System.out.println("cost:" + String.valueOf(end - beg));
//		System.out.println(pwd);
		
//		System.out.println(base64Encode(pwd));
//		System.out.println(base64Decode(base64Encode(pwd)));
		
		pwd = pwd+"|8c203";
		for (int i = 0; i < 1; i++) {
			pwd = sha(pwd);
		}
		System.out.println(pwd);
	}
}
