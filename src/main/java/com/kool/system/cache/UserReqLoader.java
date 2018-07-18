/**
 * @PROJECT 
 * @DATE 2018年7月4日 下午8:59:59
 * @AUTHOR LUYU
 */
package com.kool.system.cache;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.kool.core.CoreConstants;
import com.kool.core.cache.KCache;
import com.kool.core.cache.KCacheLoader;
import com.kool.core.util.SpringContextUtil;
import com.kool.system.bean.SyReqDefBean;
import com.kool.system.dao.SyUserAutDao;

/**
 * @DESCRIBE 用户请求关系缓存加载类
 * @AUTHOR LUYU
 * @DATE 2018年7月4日 下午8:59:59
 *
 */
public class UserReqLoader implements KCacheLoader {
	private static Logger logger = Logger.getLogger(UserReqLoader.class);

	/**
	 * @DESCRIBE
	 * @DATE 2018年7月4日 下午9:00:18
	 *
	 */
	@Override
	public void load() {
		SyUserAutDao userAutDao = (SyUserAutDao) SpringContextUtil.getBean("SyUserAutDao");
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT DISTINCT A.SUA_USER_CID,C.* ");
		sb.append("FROM SY_USER_AUT A,SY_REQ_AUT B, SY_REQ_DEF C ");
		sb.append("WHERE A.SUA_AUT_CODE=B.SRA_AUT_CODE ");
		sb.append("AND B.SRA_REQ_URL=C.SRD_REQ_URL ");
		sb.append("ORDER BY A.SUA_USER_CID ");
		logger.debug(sb.toString());
		List<Map<String, Object>> result = userAutDao.selectBySql(sb.toString());
		if (result != null && result.size() > 0) {
			for (Map<String, Object> map : result) {
				String userId = (String) map.get("SUA_USER_CID");
				String reqUrl = (String) map.get("SRD_REQ_URL");
				SyReqDefBean reqDef = SyReqDefBean.DBResultToBean(map);
				KCache.put(CoreConstants.KCACHE_USER_REQ, userId+reqUrl, reqDef);
			}
//			List<SyReqDefBean> listReq = new ArrayList<>();
//			String last = null;
//			for (Map<String, Object> map : result) {
//				String userCid = (String) map.get("SUA_USER_CID");
//				SyReqDefBean reqDef = SyReqDefBean.DBResultToBean(map);
//				if (null == last || userCid.equals(last)) {
//					listReq.add(reqDef);
//					last = userCid;
//				} else {
//					KCache.put(CoreConstants.KCACHE_USER_REQ, userCid, listReq);
//					listReq = new ArrayList<>();
//					last = userCid;
//				}
//			}
//			if (listReq.size() > 0) {
//				KCache.put(CoreConstants.KCACHE_USER_REQ, last, listReq);
//			}
		}
	}
}
