/**
 * @PROJECT 
 * @DATE 2018年7月16日 下午2:58:13
 * @AUTHOR LUYU
 */
package com.kool.system.cache;

import java.util.List;

import com.kool.core.CoreConstants;
import com.kool.core.cache.KCache;
import com.kool.core.cache.KCacheLoader;
import com.kool.core.util.SpringContextUtil;
import com.kool.system.bean.SyAutDefBean;
import com.kool.system.dao.SyAutDefDao;

/**
 * @DESCRIBE 权限缓存加载类
 * @AUTHOR LUYU
 * @DATE 2018年7月16日 下午2:58:13
 *
 */
public class AutLoader implements KCacheLoader {

	/**
	 * 
	 * @DESCRIBE
	 * @DATE 2018年7月16日 下午2:58:39
	 *
	 */
	@Override
	public void load() {
		SyAutDefDao autDao = (SyAutDefDao) SpringContextUtil.getBean("SyAutDefDao");
		List<SyAutDefBean> listAut = autDao.select(new SyAutDefBean());
		if (listAut != null && listAut.size() > 0) {
			for (SyAutDefBean aut : listAut) {
				KCache.put(CoreConstants.KCACHE_AUT, aut.getSadAutCode(), aut);
			}
		}
	}

}
