/**
 * @PROJECT 
 * @DATE 2018年2月18日 下午2:48:12
 * @AUTHOR LUYU
 */
package com.kool.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kool.core.context.ContextHolder;
import com.kool.core.context.LoginInfo;
import com.kool.core.context.ReqContext;
import com.kool.core.exception.AppException;

/**
 * @DESCRIBE
 * @AUTHOR LUYU
 * @DATE 2018年2月18日 下午2:48:12
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-hisaas.xml" })
public class SpringTest {
	@Test
	public void test() throws AppException {
		LoginInfo loginInfo = new LoginInfo();
		loginInfo.setSuiId("aa709353500845aeb97be4fcdfddf8ec");
		loginInfo.setSuiLoginName("testa");
		ReqContext reqCtx = new ReqContext();
		reqCtx.setLoginInfo(loginInfo);
		ContextHolder.setReqContext(reqCtx);
		
//		MenuServicce service  = (MenuServicce) SpringContextUtil.getBean("MenuServicce");
//		List<MenuVo> listMenu = service.getAllMenu();
		
	}

//	/**
//	 * @throws AppException 
//	 * @DESCRIBE 
//	 * @DATE 2018年2月20日 下午8:42:16
//	 *
//	 */
//	private void initDB() throws AppException {
//		InitDBThread thread = new InitDBThread();
//		thread.start();
//		while(true) {
//			DateUtils.delay(3600000);
//		}
//	}


}
