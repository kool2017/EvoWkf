/**
 * @PROJECT 
 * @DATE 2018年7月4日 下午8:55:16
 * @AUTHOR LUYU
 */
package com.kool.system.cache;

import java.util.List;

import com.kool.core.CoreConstants;
import com.kool.core.cache.KCache;
import com.kool.core.cache.KCacheLoader;
import com.kool.core.util.SpringContextUtil;
import com.kool.system.bean.SyUserInfoBean;
import com.kool.system.dao.SyUserInfoDao;

/**
 * @DESCRIBE 用户信息缓存加载类
 * @AUTHOR LUYU
 * @DATE 2018年7月4日 下午8:55:16
 *
 */
public class UserInfoLoader implements KCacheLoader {

	/**
	 * @DESCRIBE
	 * @DATE 2018年7月4日 下午8:56:03
	 *
	 */
	@Override
	public void load() {
		SyUserInfoDao userDao = (SyUserInfoDao) SpringContextUtil.getBean("SyUserInfoDao");
		List<SyUserInfoBean> listUser = userDao.select(new SyUserInfoBean());
		if (listUser != null && listUser.size()>0) {
			for (SyUserInfoBean user : listUser) {
				KCache.put(CoreConstants.KCACHE_USER, user.getSuiUserCid(), user);
			}
		}
	}
	
}
