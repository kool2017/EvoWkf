/**
 * @PROJECT 
 * @DATE 2018年7月4日 下午8:52:30
 * @AUTHOR LUYU
 */
package com.kool.system.cache;

import java.util.List;

import com.kool.core.CoreConstants;
import com.kool.core.cache.KCache;
import com.kool.core.cache.KCacheLoader;
import com.kool.core.util.SpringContextUtil;
import com.kool.system.bean.SyReqDefBean;
import com.kool.system.dao.SyReqDefDao;

/**
 * @DESCRIBE 请求缓存加载类
 * @AUTHOR LUYU
 * @DATE 2018年7月4日 下午8:52:30
 *
 */
public class ReqLoader implements KCacheLoader {

	/**
	 * @DESCRIBE
	 * @DATE 2018年7月4日 下午8:52:40
	 *
	 */
	@Override
	public void load() {
		SyReqDefDao reqDao = (SyReqDefDao) SpringContextUtil.getBean("SyReqDefDao");
		List<SyReqDefBean> listReq = reqDao.select(new SyReqDefBean());
		if (listReq != null && listReq.size() > 0) {
			for (SyReqDefBean req : listReq) {
				KCache.put(CoreConstants.KCACHE_REQ, req.getSrdReqUrl(), req);
			}
		}
	}

}
