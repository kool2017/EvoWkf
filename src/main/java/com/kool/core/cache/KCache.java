/**
 * @PROJECT 
 * @DATE 2018年6月30日 下午10:36:53
 * @AUTHOR LUYU
 */
package com.kool.core.cache;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.cache.ehcache.EhCacheCacheManager;

import com.kool.core.bean.SyCacheCtlBean;
import com.kool.core.dao.SyCacheCtlDao;
import com.kool.core.util.SpringContextUtil;
import com.kool.core.util.StringUtils;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/**
 * @DESCRIBE Ehcache缓存封装类
 * @AUTHOR LUYU
 * @DATE 2018年6月30日 下午10:36:53
 *
 */
public class KCache {
	private static Logger logger = Logger.getLogger(KCache.class);

	public static Boolean isInit = false;

	/**
	 * 
	 * @DESCRIBE 保存一条数据到缓存
	 * @DATE 2018年6月30日 下午10:38:04
	 *
	 * @param type
	 *            数据类型
	 * @param pk
	 *            主键
	 * @param value
	 *            数据
	 */
	public static void put(String type, String pk, Object value) {
		EhCacheCacheManager cm = (EhCacheCacheManager) SpringContextUtil.getBean("cacheManager");
		CacheManager cacheMng = cm.getCacheManager();
		Cache cache = cacheMng.getCache(type);
		if (cache != null) {
			Element ele = new Element(pk, value);
			cache.put(ele);
		}

	}

	/**
	 * 
	 * @DESCRIBE 根据数据类型和主键获取数据
	 * @DATE 2018年6月30日 下午10:38:17
	 *
	 * @param type
	 *            数据类型
	 * @param pk
	 *            主键
	 * @return
	 */
	public static Object get(String type, String pk) {
		if (isInit == false) {
			init();
			isInit = true;
		}
		EhCacheCacheManager cm = (EhCacheCacheManager) SpringContextUtil.getBean("cacheManager");
		CacheManager cacheMng = cm.getCacheManager();
		Cache cache = cacheMng.getCache(type);
		if (null == cache) {
			return null;
		}
		Element ele = cache.get(pk);
		if (null == ele) {
			return null;
		}
		return ele.getObjectValue();
	}

	/**
	 * 
	 * @DESCRIBE 清除一种数据类型的所有缓存数据
	 * @DATE 2018年6月30日 下午10:38:28
	 *
	 * @param type
	 *            数据类型
	 */
	public static void removeAll(String type) {
		EhCacheCacheManager cm = (EhCacheCacheManager) SpringContextUtil.getBean("cacheManager");
		CacheManager cacheMng = cm.getCacheManager();
		Cache cache = cacheMng.getCache(type);
		cache.removeAll();

	}

	/**
	 * 
	 * @DESCRIBE 根据数据类型和主键清除一条数据
	 * @DATE 2018年6月30日 下午10:38:38
	 *
	 * @param type
	 *            数据类型
	 * @param pk
	 *            主键
	 */
	public static void remove(String type, String pk) {
		EhCacheCacheManager cm = (EhCacheCacheManager) SpringContextUtil.getBean("cacheManager");
		CacheManager cacheMng = cm.getCacheManager();
		Cache cache = cacheMng.getCache(type);
		cache.remove(pk);

	}

	/**
	 * 
	 * @DESCRIBE 初始化缓存数据
	 * @DATE 2018年7月4日 下午9:54:35
	 *
	 */
	public static void init() {
		// 查询SY_CACHE_CTL表所有记录
		SyCacheCtlDao cacheDao = (SyCacheCtlDao) SpringContextUtil.getBean("SyCacheCtlDao");
		List<SyCacheCtlBean> listCache = cacheDao.select(new SyCacheCtlBean());
		if (listCache != null && listCache.size() > 0) {
			// 遍历
			for (SyCacheCtlBean cacheCtl : listCache) {
				if (StringUtils.isEmpty(cacheCtl.getSccClazz()) == false) {
					reflect(cacheCtl);
				}
			}
		}
	}

	/**
	 * @DESCRIBE
	 * @DATE 2018年7月4日 下午9:57:16
	 *
	 * @param cacheCtl
	 */
	private static void reflect(SyCacheCtlBean cacheCtl) {
		// 如果SCC_CLAZZ非空，调用
		try {
			Class<?> clazz = Class.forName(cacheCtl.getSccClazz());
			KCacheLoader cacheLoader = (KCacheLoader) clazz.newInstance();
			cacheLoader.load();
		} catch (ClassNotFoundException e) {
			logger.error("缓存加载类[" + cacheCtl.getSccClazz() + "]无法反射调用", e);
		} catch (InstantiationException e) {
			logger.error("缓存加载类[" + cacheCtl.getSccClazz() + "]无法反射调用", e);
		} catch (IllegalAccessException e) {
			logger.error("缓存加载类[" + cacheCtl.getSccClazz() + "]无法反射调用", e);
		}
	}

	/**
	 * 
	 * @DESCRIBE 刷新一种缓存数据
	 * @DATE 2018年7月4日 下午9:58:18
	 *
	 * @param type
	 */
	public static void refresh(String type) {
		logger.info("刷新缓存["+type+"]");
		SyCacheCtlDao cacheDao = (SyCacheCtlDao) SpringContextUtil.getBean("SyCacheCtlDao");
		SyCacheCtlBean cachePK = new SyCacheCtlBean();
		cachePK.setSccCacheCode(type);
		SyCacheCtlBean cacheCtl = cacheDao.selectByPK(cachePK);
		if (cacheCtl != null && StringUtils.isEmpty(cacheCtl.getSccClazz()) == false) {
			reflect(cacheCtl);
		}
	}
	
}
