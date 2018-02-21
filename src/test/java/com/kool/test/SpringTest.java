/**
 * @PROJECT 
 * @DATE 2018年2月18日 下午2:48:12
 * @AUTHOR LUYU
 */
package com.kool.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kool.core.base.BaseBean;
import com.kool.core.context.ContextHolder;
import com.kool.core.context.LoginInfo;
import com.kool.core.context.ReqContext;
import com.kool.core.exception.AppException;
import com.kool.core.util.DateUtils;
import com.kool.core.util.SpringContextUtil;
import com.kool.core.util.StringUtils;
import com.kool.evowkf.api.IEvoWkfApi;
import com.kool.evowkf.api.SimpleApiImp;
import com.kool.evowkf.bean.io.SYSCHEDULEXBean;
import com.kool.evowkf.bean.vo.WkfSchedule;
import com.kool.evowkf.dao.SyWkfScheduleDao;
import com.kool.evowkf.engine.InitDBThread;
import com.kool.evowkf.service.WkfService;
import com.kool.system.bean.SyGlobalDefineBean;
import com.kool.system.bean.SyUserInfoBean;
import com.kool.system.bean.io.SYPAGEINFOYBean;
import com.kool.system.bean.vo.PageResult;
import com.kool.system.dao.SyGlobalDefineDao;
import com.kool.system.service.UserService;

/**
 * @DESCRIBE
 * @AUTHOR LUYU
 * @DATE 2018年2月18日 下午2:48:12
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-evowkf.xml" })
public class SpringTest {
	@Test
	public void test() throws AppException {
		LoginInfo loginInfo = new LoginInfo();
		loginInfo.setSuiId("aa709353500845aeb97be4fcdfddf8ec");
		loginInfo.setSuiLoginName("testa");
		ReqContext reqCtx = new ReqContext();
		reqCtx.setLoginInfo(loginInfo);
		ContextHolder.setReqContext(reqCtx);
		// SimpleScheduleImp ss = new SimpleScheduleImp();
		// List<SyWkfScheduleBean> list = ss.querySchedule("", "", "Alice", "Alice");
		// for (SyWkfScheduleBean schedule : list) {
		// System.out.println(schedule.toString());
		// }
		//
		// SyWkfScheduleDao scheduleDao = (SyWkfScheduleDao)
		// SpringContextUtil.getBean("SyWkfScheduleDao");
		// scheduleDao.closeOtherSchedule("ed2f59f37fda4e5baeb67a16453df90b",
		// "6d64eca9b9a64269a4c2a348b9f36f88");
		// System.out.println("FINISH");

		// WkfService service = (WkfService)
		// SpringContextUtil.getBean(WkfService.class);
		// SYSCHEDULEXBean scheduleInfo = new SYSCHEDULEXBean();
		// List<WkfSchedule> listSchedules = service.querySchedule(scheduleInfo);
		// for (WkfSchedule schedule : listSchedules) {
		// System.out.println(schedule);
		// }

//		querypage();
//		querySchedules();
//		globalDefine();
//		initDB();
	}

	/**
	 * @throws AppException 
	 * @DESCRIBE 
	 * @DATE 2018年2月20日 下午8:42:16
	 *
	 */
	private void initDB() throws AppException {
		InitDBThread thread = new InitDBThread();
		thread.start();
		while(true) {
			DateUtils.delay(3600000);
		}
	}

	/**
	 * @DESCRIBE 
	 * @DATE 2018年2月20日 下午3:44:25
	 *
	 */
	private void globalDefine() {
		SyGlobalDefineDao dao = (SyGlobalDefineDao) SpringContextUtil.getBean("SyGlobalDefineDao");
		List<SyGlobalDefineBean> listInfo = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			SyGlobalDefineBean info = new SyGlobalDefineBean();
			info.setSgdField(StringUtils.getRandomString(60));
			info.setSgdBusType("SYUSR");
			info.setSgdValue(StringUtils.getRandomString(60));
			info.setSgdDsp(String.valueOf(i));
			listInfo.add(info);
		}
//		dao.insert(listInfo.get(0));
//		dao.insertBatch(listInfo);
//		SyGlobalDefineBean delInfo = new SyGlobalDefineBean();
//		delInfo.setSgdField("856423904901231835343749377126297972344750918430036769922841");
//		dao.delete(delInfo);
//		delInfo.setSgdBusType("SYUSR");
//		dao.deletes(delInfo);
//		
		SyGlobalDefineBean selInfo = new SyGlobalDefineBean();
		selInfo.setSgdField("017473985497068923943039656531786925383025097813497064466608");
		selInfo.setSgdDsp("1");
		
//		List<SyGlobalDefineBean> listValue = dao.select(selInfo);
//		List<SyGlobalDefineBean> listValue = dao.selectPage(new SyGlobalDefineBean(), 1, 2);
//		for (SyGlobalDefineBean value : listValue) {
//			System.out.println(value.toString());
//		}
//		List<Map<String, Object>> listMap = dao.selectBySql("SELECT * FROM SY_GLOBAL_DEFINE WHERE SGD_DSP = "+ String.valueOf(3));
//		for (Map<String, Object> map : listMap) {
//			SyGlobalDefineBean value = JSONObject.toJavaObject(JSONObject.parseObject(JSONObject.toJSONString(map)), SyGlobalDefineBean.class);
//			System.out.println(value.toString());
//		}
//		SyGlobalDefineBean value = dao.selectByPK(selInfo);
//		System.out.println(value.toString());
//		int total = dao.selectTotal(new SyGlobalDefineBean());
//		int total = dao.selectTotalBySql("SELECT COUNT(*) FROM SY_GLOBAL_DEFINE") ;
//		System.out.println(total);
//
		SyGlobalDefineBean updInfo = new SyGlobalDefineBean();
//		updInfo.setSgdField("017473985497068923943039656531786925383025097813497064466608");
//		updInfo.setSgdDsp("6");
//		
//		dao.update(updInfo);
		SyGlobalDefineBean value = new SyGlobalDefineBean();
		value.setSgdDsp("10");

		SyGlobalDefineBean condition = new SyGlobalDefineBean();
		dao.updates(value, condition);
		System.out.println("FINISH");
	}

	/**
	 * @DESCRIBE 
	 * @DATE 2018年2月20日 下午2:56:31
	 *
	 */
	private void querySchedules() {
		IEvoWkfApi api = new SimpleApiImp();
		SYPAGEINFOYBean pageInfo = new SYPAGEINFOYBean();
		pageInfo.setCurrentPage(1);
		pageInfo.setPageCount(0);
		pageInfo.setPageSize(5);
		pageInfo.setTotal(0);
		PageResult pageResult = api.querySchedule("", "", "b0e403ba11034368b18bd5cc7bc86966", "bb", pageInfo);

		JSONObject pkgOut = new JSONObject();
		JSONArray sectionSchedule = new JSONArray();
		List<BaseBean> listSchedules = pageResult.getListBusinessValue();
		if (listSchedules != null && listSchedules.size() > 0) {
			for (BaseBean schedule : listSchedules) {
				sectionSchedule.add(schedule);
			}
		}
		pkgOut.put("SYSCHEDULEZ", sectionSchedule);

		JSONArray sectionOutPageInfo = new JSONArray();
		pageInfo = pageResult.getPageInfo();
		JSONObject propOutPageInfo = JSONObject.parseObject(JSONObject.toJSONString(pageInfo));
		sectionOutPageInfo.add(propOutPageInfo);
		pkgOut.put("SYPAGEINFOY", sectionOutPageInfo);
		System.out.println(pkgOut);
	}

	/**
	 * @DESCRIBE
	 * @DATE 2018年2月20日 上午11:25:29
	 *
	 */
	private void querypage() {
		SyUserInfoBean userInfo = new SyUserInfoBean();
		
		SYPAGEINFOYBean pageInfo = new SYPAGEINFOYBean();
		pageInfo.setCurrentPage(2);
		pageInfo.setPageCount(0);
		pageInfo.setPageSize(5);
		pageInfo.setTotal(0);
		
		UserService service = (UserService) SpringContextUtil.getBean(UserService.class);
		PageResult pageResult = service.queryPage(userInfo, pageInfo);

		JSONObject pkgOut = new JSONObject();
		JSONArray sectionOutUsers = new JSONArray();
		for (BaseBean user : pageResult.getListBusinessValue()) {
			JSONObject propOut = JSONObject.parseObject(JSONObject.toJSONString(user));
			sectionOutUsers.add(propOut);
		}
		pkgOut.put("SYUSRINFQRYZ", sectionOutUsers);

		JSONArray sectionOutPageInfo = new JSONArray();
		pageInfo = pageResult.getPageInfo();
		JSONObject propOutPageInfo = JSONObject.parseObject(JSONObject.toJSONString(pageInfo));
		sectionOutPageInfo.add(propOutPageInfo);
		pkgOut.put("SYPAGEINFOY", sectionOutPageInfo);
		System.out.println(pkgOut.toJSONString());
	}
}
