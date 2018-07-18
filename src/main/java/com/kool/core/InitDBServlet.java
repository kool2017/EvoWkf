/**
 * @PROJECT 
 * @DATE 2018年2月20日 下午9:05:08
 * @AUTHOR LUYU
 */
package com.kool.core;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.kool.core.exception.AppException;
import com.kool.core.util.DateUtils;
import com.kool.core.util.PropertyUtils;
import com.kool.core.util.StringUtils;

/**
 * @DESCRIBE
 * @AUTHOR LUYU
 * @DATE 2018年2月20日 下午9:05:08
 *
 */
public class InitDBServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1823714785176116197L;

	/**
	 * @DESCRIBE
	 * @DATE 2018年2月20日 下午9:05:34
	 *
	 * @param config
	 * @throws ServletException
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		String flag = PropertyUtils.getValue("INIT_DB_FLAG");
		if (StringUtils.isEmpty(flag) == false && "N".equals(flag)) {
			return;
		}
		try {
			DateUtils.delay(60000L);
		} catch (AppException e) {
			e.printStackTrace();
		}
		InitDBThread thread = new InitDBThread();
		thread.start();
	}
}
