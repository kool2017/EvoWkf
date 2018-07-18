/**
 * @PROJECT 
 * @DATE 2018年7月17日 下午3:21:54
 * @AUTHOR LUYU
 */
package com.kool.system.cache;

import java.util.List;

import com.kool.core.CoreConstants;
import com.kool.core.cache.KCache;
import com.kool.core.cache.KCacheLoader;
import com.kool.core.util.SpringContextUtil;
import com.kool.system.bean.SyRoleGroupBean;
import com.kool.system.dao.SyRoleGroupDao;

/**
 * @DESCRIBE 角色组缓存加载类
 * @AUTHOR LUYU
 * @DATE 2018年7月17日 下午3:21:54
 *
 */
public class RoleGroupLoader implements KCacheLoader {

	/**
	 * @DESCRIBE
	 * @DATE 2018年7月17日 下午3:22:07
	 *
	 */
	@Override
	public void load() {
		SyRoleGroupDao dao = (SyRoleGroupDao) SpringContextUtil.getBean("SyRoleGroupDao");
		List<SyRoleGroupBean> list = dao.select(new SyRoleGroupBean());
		if (list != null && list.size() > 0) {
			for (SyRoleGroupBean group : list) {
				KCache.put(CoreConstants.KCACHE_ROLE_GROUP, group.getSrgGroupCode(), group);
			}
		}
	}

}
