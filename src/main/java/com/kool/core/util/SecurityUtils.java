/**
 * @PROJECT 
 * @DATE 2017年12月27日 下午10:15:59
 * @AUTHOR LUYU
 */
package com.kool.core.util;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

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
			String errUid = StringUtils.getUUID();
			log.error(errUid, e);
			throw new AppException("SY000062", e, errUid);// 系统异常，请联系管理员！异常码：%1
		} catch (UnsupportedEncodingException e) {
			String errUid = StringUtils.getUUID();
			log.error(errUid, e);
			throw new AppException("SY000062", e, errUid);// 系统异常，请联系管理员！异常码：%1
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
			String errUid = StringUtils.getUUID();
			log.error(errUid, e);
			throw new AppException("SY000062", e, errUid);// 系统异常，请联系管理员！异常码：%1
		} catch (UnsupportedEncodingException e) {
			String errUid = StringUtils.getUUID();
			log.error(errUid, e);
			throw new AppException("SY000062", e, errUid);// 系统异常，请联系管理员！异常码：%1
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
			String errUid = StringUtils.getUUID();
			log.error(errUid, e);
			throw new AppException("SY000062", e, errUid);// 系统异常，请联系管理员！异常码：%1
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

	/**
	 * 
	 * @DESCRIBE 获取密钥对
	 * @DATE 2018年7月16日 下午3:43:54
	 *
	 * @return
	 * @throws AppException
	 */
	public static KeyPair generateRSAKey() throws AppException {
		KeyPair kp = null;
		try {
			SecureRandom secureRandom = new SecureRandom();
			KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
			kpg.initialize(1024,secureRandom);
			kp = kpg.genKeyPair();
		} catch (NoSuchAlgorithmException e) {
			String errUid = StringUtils.getUUID();
			log.error(errUid, e);
			throw new AppException("SY000062", e, errUid);// 系统异常，请联系管理员！异常码：%1
		}
		return kp;
	}

	/**
	 * 
	 * @DESCRIBE 生成密钥对文件到指定路径
	 * @DATE 2018年7月16日 下午4:47:09
	 *
	 * @param toDir
	 * @throws AppException
	 */
	public static void generateRSAKeyFile(String toDir) throws AppException {
		KeyPair kp = generateRSAKey();
		PublicKey pbKey = kp.getPublic();
		PrivateKey prKey = kp.getPrivate();
		byte[] pbByte = pbKey.getEncoded();
		byte[] prByte = prKey.getEncoded();
		String pbString = Base64.encodeBase64String(pbByte);
		String prString = Base64.encodeBase64String(prByte);
		
		if (StringUtils.isEmpty(toDir)) {
			toDir = StringUtils.getProjectRoot();
		}
		FileUtils.writeFile(pbString, new StringBuilder().append(toDir).append(FileUtils.getSeparator()).append("public.key").toString(), "UTF-8", false);
		FileUtils.writeFile(prString, new StringBuilder().append(toDir).append(FileUtils.getSeparator()).append("private.key").toString(), "UTF-8", false);
	}
	
	/**
	 * 
	 * @DESCRIBE RSA加密
	 * @DATE 2018年7月16日 下午4:51:17
	 *
	 * @param enContent
	 * @param pbKey
	 * @return
	 */
	public static byte[] encryptRSA(byte[] enContent, PublicKey pbKey) {
		// 获取公钥及参数e,n
		RSAPublicKey pbk = (RSAPublicKey) pbKey;
		BigInteger e = pbk.getPublicExponent();
		BigInteger n = pbk.getModulus();
		// 获取明文m
		BigInteger m = new BigInteger(enContent);
		// 计算密文c
		BigInteger c = m.modPow(e, n);
		return c.toByteArray();
	}

	/**
	 * 
	 * @DESCRIBE RSA解密
	 * @DATE 2018年7月16日 下午4:51:31
	 *
	 * @param deContent
	 * @param prKey
	 * @return
	 */
	public static byte[] decryptRSA(byte[] deContent, PrivateKey prKey) {
		// 读取密文
		BigInteger c = new BigInteger(deContent);
		// 读取私钥
		RSAPrivateKey prk = (RSAPrivateKey) prKey;
		BigInteger d = prk.getPrivateExponent();

		// 获取私钥参数及解密
		BigInteger n = prk.getModulus();
		BigInteger m = c.modPow(d, n);

		// 显示解密结果
		byte[] mt = m.toByteArray();
		return mt;
	}

	/**
	 * 
	 * @DESCRIBE 还原公钥
	 * @DATE 2018年7月16日 下午4:05:19
	 *
	 * @param keyBytes 未经过base64编码的公钥
	 * @return
	 * @throws AppException
	 */
	public static PublicKey getPublicKey(byte[] keyBytes) throws AppException {
		PublicKey publicKey = null;
		try {
			X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			publicKey = keyFactory.generatePublic(keySpec);
		} catch (NoSuchAlgorithmException e) {
			String errUid = StringUtils.getUUID();
			log.error(errUid, e);
			throw new AppException("SY000062", e, errUid);// 系统异常，请联系管理员！异常码：%1
		} catch (InvalidKeySpecException e) {
			String errUid = StringUtils.getUUID();
			log.error(errUid, e);
			throw new AppException("SY000062", e, errUid);// 系统异常，请联系管理员！异常码：%1
		}
		return publicKey;
	}
	
	/**
	 * 
	 * @DESCRIBE 还原公钥
	 * @DATE 2018年7月16日 下午5:03:16
	 *
	 * @param key 经过base64编码的公钥
	 * @return
	 * @throws AppException
	 */
	public static PublicKey getPublicKey(String key) throws AppException {
		return getPublicKey(Base64.decodeBase64(key));
	}
	
	/**
	 * 
	 * @DESCRIBE 还原私钥
	 * @DATE 2018年7月16日 下午4:09:03
	 *
	 * @param keyBytes 未经过base64编码的私钥
	 * @return
	 * @throws AppException
	 */
	public static PrivateKey getPrivateKey(byte[] keyBytes) throws AppException {
		PrivateKey privateKey = null;
		try {
			PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			privateKey = keyFactory.generatePrivate(keySpec);
		} catch (NoSuchAlgorithmException e) {
			String errUid = StringUtils.getUUID();
			log.error(errUid, e);
			throw new AppException("SY000062", e, errUid);// 系统异常，请联系管理员！异常码：%1
		} catch (InvalidKeySpecException e) {
			String errUid = StringUtils.getUUID();
			log.error(errUid, e);
			throw new AppException("SY000062", e, errUid);// 系统异常，请联系管理员！异常码：%1
		}
		return privateKey;
	}

	/**
	 * 
	 * @DESCRIBE 还原私钥
	 * @DATE 2018年7月16日 下午5:03:49
	 *
	 * @param key 经过base64编码的私钥
	 * @return
	 * @throws AppException
	 */
	public static PrivateKey getPrivateKey(String key) throws AppException {
		return getPrivateKey(Base64.decodeBase64(key));
	}

	public static void main(String[] args) throws AppException {
//		String pwd = "ly";
		// System.out.println(md5(pwd));
		// System.out.println(md5(pwd).length());
		// System.out.println(sha(pwd));
		// System.out.println(sha(pwd).length());
		// long beg = System.currentTimeMillis();
		// for (int i = 0; i < 10000; i++) {
		// pwd = sha(pwd);
		// }
		// long end = System.currentTimeMillis();
		// System.out.println("cost:" + String.valueOf(end - beg));
		// System.out.println(pwd);

		// System.out.println(base64Encode(pwd));
		// System.out.println(base64Decode(base64Encode(pwd)));

		// pwd = pwd + "|8c203";
		// for (int i = 0; i < 1; i++) {
		// pwd = sha(pwd);
		// }
		// System.out.println(pwd);

		KeyPair kp = generateRSAKey();
		PublicKey pbKey = kp.getPublic();
		PrivateKey prKey = kp.getPrivate();
		byte[] pbByte = pbKey.getEncoded();
		byte[] prByte = prKey.getEncoded();
		String pbString = Base64.encodeBase64String(pbByte);
		String prString = Base64.encodeBase64String(prByte);
		System.out.println(pbString);
		System.out.println(prString);

		String pkg = "123明文！@#}";
		
		PublicKey pbk = getPublicKey(Base64.decodeBase64(pbString));
		PrivateKey prk = getPrivateKey(Base64.decodeBase64(prString));
		byte[] enContent = encryptRSA(pkg.getBytes(), pbk);
		System.out.println(new String(enContent));

		byte[] deContent = decryptRSA(enContent, prk);

		System.out.println(new String(deContent));
		
//		generateRSAKeyFile("");
	}
}
