package com.kool.core.util;
/**
 * @PROJECT 
 * @DATE 2017-03-22 19:37:29
 * @AUTHOR LUYU
 */

import java.util.UUID;

import com.kool.core.exception.AppException;

/**
 * @DESCRIBE 字符串工具
 * @AUTHOR LUYU
 * @DATE 2017-03-22 19:37:29
 *
 */
public class StringUtils {
	public static boolean isEmpty(String string) {
		boolean isEmpty = true;
		if (null == string || string.trim().length() <= 0) {
			isEmpty = true;
		} else {
			isEmpty = false;
		}
		return isEmpty;
	}

	/**
	 * 
	 * @DESCRIBE SQL名称转驼峰名称
	 * @AUTHOR LUYU
	 * @DATE 2016-12-21 22:09:11
	 *
	 * @param sqlName
	 * @param bUpFirstChar
	 *            首字母是否大写，true：大写，false：小写
	 * @return
	 */
	public static String transferToHumpName(String sqlName, boolean bUpFirstChar) {
		if (StringUtils.isEmpty(sqlName)) {
			return sqlName;
		}

		String[] array = sqlName.split("_");
		StringBuffer sbHump = new StringBuffer();

		if (bUpFirstChar) {
			sbHump.append(array[0].substring(0, 1).toUpperCase());
			sbHump.append(array[0].substring(1, array[0].length()).toLowerCase());
		} else {
			sbHump.append(array[0].toLowerCase());
		}

		for (int i = 1; i < array.length; i++) {
			String word = array[i];
			sbHump.append(word.substring(0, 1).toUpperCase());
			sbHump.append(word.substring(1, word.length()).toLowerCase());

		}
		return sbHump.toString();

	}

	public static String getUUID() {
		UUID uuid = UUID.randomUUID();
		String id = uuid.toString();
		id = id.replaceAll("-", "");
		return id;
	}

	public static void debug(String msg) {
		String devMode = null;
		String logPath = null;
		try {
			devMode = System.getProperty("DEV_MODE");
			logPath = System.getProperty("DEV_LOG");
			if (StringUtils.isEmpty(devMode) || "NULL".equals(devMode)) {
				return;
			}

			if (isEmpty(logPath) || "NULL".equals(logPath)) {
				logPath = getProjectRoot() + "\\dev.log";
			}
			if ("DEBUG".equalsIgnoreCase(devMode)) {
				StringBuilder sbLog = new StringBuilder();
				sbLog.append("---------- DEV MODE DEBUG LOG ----------");
				sbLog.append("\r\n");
				sbLog.append("DATE:");
				String currentTime = DateUtils.getCurrentTimeString(DateUtils.FORMAT_TIMESTAMP);
				sbLog.append(currentTime);
				sbLog.append("\r\n");
				sbLog.append(">>>>>>>>>>      LOG INFO      <<<<<<<<<<");
				sbLog.append("\r\n");
				sbLog.append(msg);
				sbLog.append("\r\n\r\n");
				sbLog.append(">>>>>>>>>>       THREAD       <<<<<<<<<<");
				sbLog.append("\r\n");
				sbLog.append("THREAD NAME:");
				sbLog.append(Thread.currentThread().getName());
				sbLog.append("\r\n");
				sbLog.append("THREAD ID:");
				sbLog.append(Thread.currentThread().getId());
				sbLog.append("\r\n");
				sbLog.append(">>>>>>>>>>    RUNTIME INFO    <<<<<<<<<<");
				sbLog.append("\r\n");
				sbLog.append("AVAILABLE PROCESSORS:");
				sbLog.append(Runtime.getRuntime().availableProcessors());
				sbLog.append("\r\n");
				sbLog.append("FREE MEMORY:");
				sbLog.append(Runtime.getRuntime().freeMemory() / 1000 / 1000 + "M");
				sbLog.append("\r\n");
				sbLog.append("MAX MEMORY:");
				sbLog.append(Runtime.getRuntime().maxMemory() / 1000 / 1000 + "M");
				sbLog.append("\r\n");
				sbLog.append("TOTAL MEMORY:");
				sbLog.append(Runtime.getRuntime().totalMemory() / 1000 / 1000 + "M");
				sbLog.append("\r\n\r\n");

				FileUtils.writeFile(sbLog.toString(), logPath, "UTF-8", true);
			}
		} catch (Exception e) {
			return;
		}
	}

	public static String getRandomString(int length) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
			double rd = Math.random() * 10;
			sb.append(String.valueOf(rd).substring(0, 1));
		}
		return sb.toString();
	}

	public static String getRefId(String refId) throws AppException {
		String dt = DateUtils.getCurrentTimeString(DateUtils.FORMAT_SHORT_DATE_AND_TIME_WITHOUT_SPLIT);
		String Id = refId.substring(refId.length() - 8, refId.length()) + dt + StringUtils.getRandomString(2);
		return Id;
	}

	public static String getProjectRoot() {
		return System.getProperty("user.dir");
	}

	public static void main(String[] args) throws AppException {
		System.out.println(getUUID());
	}

	/**
	 * @DESCRIBE
	 * @DATE 2018年6月23日 下午10:03:20
	 *
	 * @param numberA
	 * @param numberB
	 * @throws AppException
	 */
	public static String add(String numberA, String numberB) throws AppException {
		if (null == numberA || null == numberB) {
			throw new AppException("SY000006");// 加数为空
		}
		int lenA = numberA.length();
		int lenB = numberB.length();
		StringBuilder sbSum = new StringBuilder();
		String sLong = null;
		String sShort = null;
		if (lenA >= lenB) {
			sLong = numberA;
			sShort = numberB;
		} else {
			sLong = numberB;
			sShort = numberA;
		}
		int plus = 0;
		for (int i = 0; i < sShort.length(); i++) {
			int C = Integer.valueOf(sLong.substring(sLong.length() - 1 - i, sLong.length() - i));
			C += Integer.valueOf(sShort.substring(sShort.length() - 1 - i, sShort.length() - i));
			C += plus;
			if (C >= 10) {
				C = C - 10;
				plus = 1;
			} else {
				plus = 0;
			}
			sbSum.insert(0, C);
		}

		int j = sShort.length();
		while (j < sLong.length()) {
			int C = Integer.valueOf(sLong.substring(sLong.length() - j - 1, sLong.length() - j));
			C += plus;
			if (C >= 10) {
				C = C - 10;
				plus = 1;
			} else {
				plus = 0;
			}
			sbSum.insert(0, C);
			j++;
		}
		if (plus == 1) {
			sbSum.insert(0, 1);
		}

		return sbSum.toString();
	}
}
