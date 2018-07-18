/**
 * @PROJECT 
 * @DATE 2018年7月4日 下午9:48:04
 * @AUTHOR LUYU
 */
package com.kool.system.cache;

import java.util.List;

import com.kool.core.CoreConstants;
import com.kool.core.cache.KCache;
import com.kool.core.cache.KCacheLoader;
import com.kool.core.util.SpringContextUtil;
import com.kool.system.bean.SyParamBean;
import com.kool.system.dao.SyParamDao;

/**
 * @DESCRIBE
 * @AUTHOR LUYU
 * @DATE 2018年7月4日 下午9:48:04
 *
 */
public class ParamLoader implements KCacheLoader {

	/**
	 * @DESCRIBE
	 * @DATE 2018年7月4日 下午9:48:14
	 *
	 */
	@Override
	public void load() {
		SyParamDao paramDao = (SyParamDao) SpringContextUtil.getBean("SyParamDao");
		List<SyParamBean> listParam = paramDao.select(new SyParamBean());
		if (listParam != null && listParam.size() > 0) {
			for (SyParamBean param : listParam) {
				KCache.put(CoreConstants.KCACHE_PARAM, param.getSpaParamCode(), param);
			}
		}
	}

}
