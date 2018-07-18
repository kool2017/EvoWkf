/**
 * @PROJECT 
 * @DATE 2018年7月17日 下午3:16:59
 * @AUTHOR LUYU
 */
package com.kool.system.cache;

import java.util.List;

import com.kool.core.CoreConstants;
import com.kool.core.cache.KCache;
import com.kool.core.cache.KCacheLoader;
import com.kool.core.util.SpringContextUtil;
import com.kool.system.bean.SyRoleBean;
import com.kool.system.dao.SyRoleDao;

/**
 * @DESCRIBE 角色缓存加载类
 * @AUTHOR LUYU
 * @DATE 2018年7月17日 下午3:16:59
 *
 */
public class RoleLoader implements KCacheLoader {

	/**
	 * @DESCRIBE
	 * @DATE 2018年7月17日 下午3:17:28
	 *
	 */
	@Override
	public void load() {
		SyRoleDao dao = (SyRoleDao) SpringContextUtil.getBean("SyRoleDao");
		List<SyRoleBean> list = dao.select(new SyRoleBean());
		if (list != null && list.size() > 0) {
			for (SyRoleBean role : list) {
				KCache.put(CoreConstants.KCACHE_ROLE, role.getSroRoleCode(), role);
			}
		}
	}

}
