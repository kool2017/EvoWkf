/**
 * @PROJECT 
 * @DATE 2017-04-29 16:04:09
 * @AUTHOR LUYU
 */
package com.kool.core.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import com.kool.core.exception.AppException;

/**
 * @DESCRIBE 文件处理工具
 * @AUTHOR LUYU
 * @DATE 2017-04-29 16:04:09
 *
 */
public class FileUtils {
	/**
	 * 
	 * @DESCRIBE 从文件中读取字符串，返回字符串
	 * @AUTHOR LUYU
	 * @DATE 2016-12-23 22:15:46
	 *
	 * @param sFilePath
	 *            文件路径
	 * @param sCharset
	 *            文件的编码集，为空时使用默认值UTF-8
	 * @return 文件内容字符串
	 * @throws AppException
	 */
	public static String readFile(String sFilePath, String sCharset) throws AppException {
		if (StringUtils.isEmpty(sFilePath)) {
			throw new AppException("SY000011");// 文件路径为空!
		}
		if (StringUtils.isEmpty(sCharset)) {
			sCharset = "UTF-8";
		}
		String sContext = null;
		File fInput = new File(sFilePath);

		if (fInput.exists() == false) {
			throw new AppException("SY000012");// 文件不存在
		}
		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			fis = new FileInputStream(fInput);
			isr = new InputStreamReader(fis, sCharset);
			br = new BufferedReader(isr);
			char[] cBuff = new char[1000];
			int iHasRead = 0;
			StringBuffer sbTemp = new StringBuffer();
			while ((iHasRead = br.read(cBuff)) != -1) {
				sbTemp.append(cBuff, 0, iHasRead);
			}
			sContext = sbTemp.toString();
		} catch (FileNotFoundException e) {
			throw new AppException("SY000013", e);// 读文件异常
		} catch (UnsupportedEncodingException e) {
			throw new AppException("SY000013", e);// 读文件异常
		} catch (IOException e) {
			throw new AppException("SY000013", e);// 读文件异常
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}
				if (isr != null) {
					isr.close();
				}
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				throw new AppException("SY000013", e);// 读文件异常
			}
		}

		return sContext;
	}

	/**
	 * 
	 * @DESCRIBE 将字符串写入文件
	 * @AUTHOR LUYU
	 * @DATE 2016-12-23 22:17:29
	 *
	 * @param sContext
	 *            字符串
	 * @param sFilePath
	 *            文件路径
	 * @param sCharset
	 *            文件编码集，为空时使用默认值UTF-8
	 * @param append
	 *            true末尾追加内容，false覆盖内容
	 * @throws AppException
	 */
	public static void writeFile(String sContext, String sFilePath, String sCharset, boolean append)
			throws AppException {
		if (StringUtils.isEmpty(sFilePath)) {
			throw new AppException("SY000011");// 文件路径为空!
		}
		if (StringUtils.isEmpty(sCharset)) {
			sCharset = "UTF-8";
		}

		String dirPath = sFilePath.substring(0, sFilePath.lastIndexOf(getSeparator()));
		File fDir = new File(dirPath);
		if (fDir.exists() == false) {
			fDir.mkdirs();
		}

		File fOutput = new File(sFilePath);
		FileOutputStream fos = null;
		try {
			if (fOutput.exists() == false) {
				fOutput.createNewFile();
			}
			fos = new FileOutputStream(fOutput, append);
			fos.write(sContext.getBytes(sCharset));
			fos.flush();

		} catch (FileNotFoundException e) {
			throw new AppException("SY000013", e);// 读文件异常
		} catch (UnsupportedEncodingException e) {
			throw new AppException("SY000013", e);// 读文件异常
		} catch (IOException e) {
			throw new AppException("SY000013", e);// 读文件异常
		} finally {
			try {
				if (fos != null) {
					fos.close();
				}
			} catch (IOException e) {
				throw new AppException("SY000013", e);// 读文件异常
			}
		}
	}

	/**
	 * 
	 * @DESCRIBE 获取操作系统的文件路径分隔符
	 * @DATE 2018年7月14日 下午6:04:01
	 *
	 * @return
	 */
	public static String getSeparator() {
		return System.getProperty("file.separator");
	}
}
