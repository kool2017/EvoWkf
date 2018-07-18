/**
 * @PROJECT 
 * @DATE 2018年7月4日 下午8:48:57
 * @AUTHOR LUYU
 */
package com.kool.system.cache;

import java.util.List;

import com.kool.core.CoreConstants;
import com.kool.core.cache.KCache;
import com.kool.core.cache.KCacheLoader;
import com.kool.core.util.SpringContextUtil;
import com.kool.system.bean.SyErrorInfoBean;
import com.kool.system.dao.SyErrorInfoDao;

/**
 * @DESCRIBE 错误码缓存加载类
 * @AUTHOR LUYU
 * @DATE 2018年7月4日 下午8:48:57
 *
 */
public class ErrorCodeLoader implements KCacheLoader {

	/**
	 * @DESCRIBE
	 * @DATE 2018年7月4日 下午8:49:08
	 *
	 */
	@Override
	public void load() {
		SyErrorInfoDao errDao = (SyErrorInfoDao) SpringContextUtil.getBean("SyErrorInfoDao");
		List<SyErrorInfoBean> listErr = errDao.select(new SyErrorInfoBean());
		if (listErr != null && listErr.size() > 0) {
			for (SyErrorInfoBean err : listErr) {
				KCache.put(CoreConstants.KCACHE_ERRCOD, err.getSeiErrorCode(), err);
			}
		}
	}

}
