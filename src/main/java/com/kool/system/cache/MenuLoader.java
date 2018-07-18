/**
 * @PROJECT 
 * @DATE 2018年7月4日 下午8:43:58
 * @AUTHOR LUYU
 */
package com.kool.system.cache;

import java.util.List;

import com.kool.core.CoreConstants;
import com.kool.core.cache.KCache;
import com.kool.core.cache.KCacheLoader;
import com.kool.core.util.SpringContextUtil;
import com.kool.system.bean.SyMenuBean;
import com.kool.system.dao.SyMenuDao;

/**
 * @DESCRIBE 菜单缓存加载类
 * @AUTHOR LUYU
 * @DATE 2018年7月4日 下午8:43:58
 *
 */
public class MenuLoader implements KCacheLoader {

	/**
	 * @DESCRIBE
	 * @DATE 2018年7月4日 下午8:44:10
	 *
	 */
	@Override
	public void load() {
		// 查询菜单表所有记录
		SyMenuDao menuDao = (SyMenuDao) SpringContextUtil.getBean("SyMenuDao");
		List<SyMenuBean> listMenu = menuDao.select(new SyMenuBean());
		if (listMenu != null && listMenu.size() > 0) {
			for (SyMenuBean menu : listMenu) {
				// 放入缓存
				KCache.put(CoreConstants.KCACHE_MENU, menu.getSmeMenuCode(), menu);
			}
		}
	}

}
