/**
 * @PROJECT 
 * @DATE 2018年7月4日 下午9:42:02
 * @AUTHOR LUYU
 */
package com.kool.system.cache;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.kool.core.CoreConstants;
import com.kool.core.cache.KCache;
import com.kool.core.cache.KCacheLoader;
import com.kool.core.util.SpringContextUtil;
import com.kool.system.bean.SyMenuBean;
import com.kool.system.dao.SyUserAutDao;

/**
 * @DESCRIBE 用户菜单关系缓存加载类
 * @AUTHOR LUYU
 * @DATE 2018年7月4日 下午9:42:02
 *
 */
public class UserMenuLoader implements KCacheLoader {
	private static Logger logger = Logger.getLogger(UserReqLoader.class);

	/**
	 * @DESCRIBE
	 * @DATE 2018年7月4日 下午9:42:15
	 *
	 */
	@Override
	public void load() {
		//查询用户有权限的菜单
		SyUserAutDao userAutDao = (SyUserAutDao) SpringContextUtil.getBean("SyUserAutDao");
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT DISTINCT A.SUA_USER_CID,C.* ");
		sb.append("FROM SY_USER_AUT A,SY_MENU_AUT B, SY_MENU C ");
		sb.append("WHERE A.SUA_AUT_CODE=B.SMA_AUT_CODE ");
		sb.append("AND B.SMA_MENU_CODE=C.SME_MENU_CODE ");
		sb.append("ORDER BY A.SUA_USER_CID,C.SME_DEEP,C.SME_SEQ,C.SME_MENU_CODE ");
		logger.debug(sb.toString());
		List<Map<String, Object>> result = userAutDao.selectBySql(sb.toString());
		if (result != null && result.size() > 0) {
			List<SyMenuBean> listMenu = new ArrayList<>();
			String last = null;
			for (Map<String, Object> map : result) {
				String userCid = (String) map.get("SUA_USER_CID");
				SyMenuBean menu = SyMenuBean.DBResultToBean(map);
				if (null == last || userCid.equals(last)) {
					listMenu.add(menu);
					last = userCid;
				} else {
					KCache.put(CoreConstants.KCACHE_USER_MENU, last, listMenu);
					listMenu = new ArrayList<>();
					listMenu.add(menu);
					last = userCid;
				}
			}
			if (listMenu.size() > 0) {
				KCache.put(CoreConstants.KCACHE_USER_MENU, last, listMenu);
			}
		}
	}

}
