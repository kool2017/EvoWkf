/**
 * @PROJECT 
 * @DATE 2018年2月20日 下午8:15:09
 * @AUTHOR LUYU
 */
package com.kool.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

import com.alibaba.druid.filter.config.ConfigTools;
import com.kool.core.exception.AppException;
import com.kool.core.util.DateUtils;
import com.kool.core.util.FileUtils;
import com.kool.core.util.PropertyUtils;
import com.kool.core.util.StringUtils;

/**
 * @DESCRIBE 定时线程，每天还原一次数据库数据
 * @AUTHOR LUYU
 * @DATE 2018年2月20日 下午8:15:09
 *
 */
public class InitDBThread extends Thread {
	private static Logger logger = Logger.getLogger(InitDBThread.class);

	private long interval = 86400000;
	private long delay = 3600000;

	public static void main(String[] args) throws Exception {
		// InitDBThread thread = new InitDBThread();
		// thread.start();

	}

	/**
	 * @DESCRIBE
	 * @DATE 2018年2月20日 下午8:15:48
	 *
	 */
	@Override
	public void run() {
		String sInterval = PropertyUtils.getValue("INIT_DB_INTERVAL");
		if (StringUtils.isEmpty(sInterval) == false) {
			interval = Long.valueOf(sInterval);
		}
		String sDelay = PropertyUtils.getValue("INIT_DB_DELAY");
		if (StringUtils.isEmpty(sDelay) == false) {
			delay = Long.valueOf(sDelay);
		}
		// 下一执行时间
		long time = System.currentTimeMillis() + interval;
		String nextTime = PropertyUtils.getValue("INIT_DB_TIME");
		if (StringUtils.isEmpty(nextTime)) {
			Calendar cldr = Calendar.getInstance();
			Date dtTime = new Date(System.currentTimeMillis());
			cldr.setTime(dtTime);
			cldr.set(Calendar.HOUR, 1);
			cldr.set(Calendar.MINUTE, 1);
			cldr.set(Calendar.SECOND, 1);
			time = cldr.getTimeInMillis();
		} else {
			try {
				Calendar cldr = Calendar.getInstance();
				cldr.set(Integer.valueOf(nextTime.substring(0, 4)), Integer.valueOf(nextTime.substring(5, 7)),
						Integer.valueOf(nextTime.substring(8, 10)), Integer.valueOf(nextTime.substring(11, 13)),
						Integer.valueOf(nextTime.substring(14, 16)), Integer.valueOf(nextTime.substring(17, 19)));
				time = cldr.getTimeInMillis();
			} catch (Exception e) {
				logger.error("计算下一执行时间异常", e);
				time = System.currentTimeMillis() + interval;
			}
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
		try {
			while (true) {
				logger.info("[INIT_DB]当前时间：" + DateUtils.getCurrentTimeString(DateUtils.FORMAT_TIMESTAMP));
				if (System.currentTimeMillis() > time) {
					logger.info("[INIT_DB]初始化数据库");
					initDB();
					time = System.currentTimeMillis() + interval;
					logger.info("[INIT_DB]下次执行时间：" + sdf.format(new Date(time)));
				}
				DateUtils.delay(delay);
			}
		} catch (AppException e) {
			e.printStackTrace();
			logger.error("[INIT_DB]APP异常\r\n", e);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[INIT_DB]未知异常\r\n", e);
		}

	}

	/**
	 * @throws AppException
	 * @DESCRIBE
	 * @DATE 2018年2月20日 下午8:24:17
	 *
	 */
	private void initDB() throws AppException {
		Connection connection = getConnection();
		String filePath = PropertyUtils.getValue("INIT_DB_SQL_PATH");
		String sql = FileUtils.readFile(filePath, "UTF-8");
		try {
			connection.setAutoCommit(true);
			Statement statement = connection.createStatement();
			statement.execute(sql);
		} catch (SQLException e) {
			logger.error("数据库执行出错", e);
			throw new AppException("数据库执行出错", e);
		}
	}

	/**
	 * @DESCRIBE
	 * @DATE 2017-04-29 16:20:52
	 *
	 * @return
	 * @throws AppException
	 */
	private Connection getConnection() throws AppException {
		Connection connection = null;
		try {
			String sUrl = PropertyUtils.getValue("jdbc.url");
			String sNam = PropertyUtils.getValue("jdbc.username");
			String sPwd = PropertyUtils.getValue("jdbc.password");
			String sPublicKey = PropertyUtils.getValue("jdbc.publickey");
			sPwd = ConfigTools.decrypt(sPublicKey, sPwd);
			String sDriver = "com.mysql.jdbc.Driver";

			Class.forName(sDriver);

			connection = DriverManager.getConnection(sUrl, sNam, sPwd);
		} catch (ClassNotFoundException e) {
			StringUtils.debug("Create connection failed :" + e.getMessage());
			throw new AppException("Create connection failed :" + e.getMessage());
		} catch (SQLException e) {
			StringUtils.debug("Create connection failed :" + e.getMessage());
			throw new AppException("Create connection failed :" + e.getMessage());
		} catch (Exception e) {
			logger.error("数据库密码解密异常！", e);
			throw new AppException("数据库密码解密异常！", e);// 数据库密码解密异常！
		}
		return connection;
	}
}
