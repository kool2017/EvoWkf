package com.kool.system.cache;

import java.util.List;

import com.kool.core.CoreConstants;
import com.kool.core.bean.SyGlobalDefineBean;
import com.kool.core.cache.KCache;
import com.kool.core.cache.KCacheLoader;
import com.kool.core.dao.SyGlobalDefineDao;
import com.kool.core.util.SpringContextUtil;

/**
 * 
 * @DESCRIBE 预定义缓存加载类
 * @AUTHOR LUYU
 * @DATE 2018年7月6日 下午3:29:45
 *
 */
public class GlobalDefineLoader implements KCacheLoader {

	/**
	 * 
	 * @DESCRIBE 
	 * @DATE 2018年7月6日 下午3:29:53
	 *
	 */
	@Override
	public void load() {
		SyGlobalDefineDao gdDao = (SyGlobalDefineDao) SpringContextUtil.getBean("SyGlobalDefineDao");
		List<SyGlobalDefineBean> listGd = gdDao.select(new SyGlobalDefineBean());
		if (listGd != null && listGd.size() > 0) {
			for (SyGlobalDefineBean gd : listGd) {
				KCache.put(CoreConstants.KCACHE_GLOBAL_DEFINE, gd.getSgdField()+gd.getSgdValue(), gd.getSgdDsp());
			}
		}
	}

}
