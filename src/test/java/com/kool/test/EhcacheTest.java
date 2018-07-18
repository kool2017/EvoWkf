/**
 * @PROJECT 
 * @DATE 2018年6月30日 下午9:31:02
 * @AUTHOR LUYU
 */
package com.kool.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.kool.core.util.SpringContextUtil;
import com.kool.system.bean.SyMenuBean;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/**
 * @DESCRIBE
 * @AUTHOR LUYU
 * @DATE 2018年6月30日 下午9:31:02
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-hisaas.xml" })
public class EhcacheTest {

	@Test
	public void test() {
		EhCacheCacheManager cm = (EhCacheCacheManager) SpringContextUtil.getBean("cacheManager");
		CacheManager cacheMng = cm.getCacheManager();
		System.out.println(cacheMng.getName());
		Cache cache = cacheMng.getCache("MENU");
		SyMenuBean menu = new SyMenuBean();
		menu.setSmeMenuCode("/user/login");
		Element element = new Element(menu.getSmeMenuCode(), menu);
		cache.put(element);
		
		Element elementOut = cache.get("/user/login");
		SyMenuBean menuOut = (SyMenuBean) elementOut.getObjectValue();
		System.out.println(JSON.toJSONString(menuOut));
		
	}
	
	
	
}
