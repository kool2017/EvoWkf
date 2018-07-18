/**
 * @PROJECT 
 * @DATE 2018年6月30日 下午11:51:01
 * @AUTHOR LUYU
 */
package com.kool.test;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kool.core.CoreConstants;
import com.kool.core.cache.KCache;
import com.kool.core.exception.AppException;

/**
 * @DESCRIBE
 * @AUTHOR LUYU
 * @DATE 2018年6月30日 下午11:51:01
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-hisaas.xml" })
public class ExceptionTest {
	@Test
	public void test() throws AppException {
//		KCache.put(CoreConstants.KCACHE_ERRCOD, "SY000001", "错误A");
//		KCache.put(CoreConstants.KCACHE_ERRCOD, "SY000002", "错误B");
//		KCache.put(CoreConstants.KCACHE_ERRCOD, "SY000003", "错误C");
		KCache.refresh(CoreConstants.KCACHE_ERRCOD);
		try {
			try {
				try {
					throw new AppException("SY000003");
				} catch (AppException e1) {
					System.out.println("e1");
					ArrayList<String> list = e1.getAllMessages();
					if (list != null) {
						for (String errMsg : list) {
							System.out.println(errMsg);
						}
					}
					AppException ex = new AppException("SY000002", e1);
					throw ex;
				}
			} catch (AppException e2) {
				ArrayList<String> list = e2.getAllMessages();
				System.out.println("e2");
				if (list != null) {
					for (String errMsg : list) {
						System.out.println(errMsg);
					}
				}
				AppException ex = new AppException("SY000001", e2);
				throw ex;
			}
		} catch (AppException e3) {
			System.out.println("e3");
			ArrayList<String> list = e3.getAllMessages();
			if (list != null) {
				for (String errMsg : list) {
					System.out.println(errMsg);
				}
			}
		}
	}

}
