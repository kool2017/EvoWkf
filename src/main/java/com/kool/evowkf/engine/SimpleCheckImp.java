/**
 * @PROJECT 
 * @DATE 2018年2月15日 下午8:08:38
 * @AUTHOR LUYU
 */
package com.kool.evowkf.engine;

import com.kool.core.exception.BusException;
import com.kool.core.util.SpringContextUtil;
import com.kool.core.util.StringUtils;
import com.kool.evowkf.WKFConstants;
import com.kool.evowkf.bean.SyWkfDefineBean;
import com.kool.evowkf.bean.SyWkfRecordBean;
import com.kool.evowkf.bean.SyWkfScheduleBean;
import com.kool.evowkf.dao.SyWkfDefineDao;
import com.kool.evowkf.dao.SyWkfRecordDao;
import com.kool.evowkf.dao.SyWkfScheduleDao;

/**
 * @DESCRIBE 签收
 * @AUTHOR LUYU
 * @DATE 2018年2月15日 下午8:08:38
 *
 */
public class SimpleCheckImp implements ICheck {

	/**
	 * @DESCRIBE 签收
	 * @DATE 2018年2月15日 下午8:09:19
	 *
	 * @param scheduleId
	 * @param userId
	 * @param loginName
	 * @throws BusException
	 */
	@Override
	public void check(String recordId, String scheduleId, String userId, String loginName) throws BusException {
		// 获取执行记录
		SyWkfRecordBean recordInfo = new SyWkfRecordBean();
		recordInfo.setSrcRecordId(recordId);
		SyWkfRecordDao recordDao = (SyWkfRecordDao) SpringContextUtil.getBean("SyWkfRecordDao");
		SyWkfRecordBean record = recordDao.selectByPK(recordInfo);
		if (null == record) {
			throw new BusException("获取执行记录结果为空");
		}
		// 获取工作流定义
		SyWkfDefineBean defineInfo = new SyWkfDefineBean();
		defineInfo.setSwdWkfCode(record.getSrcWkfCode());
		SyWkfDefineDao defineDao = (SyWkfDefineDao) SpringContextUtil.getBean("SyWkfDefineDao");
		SyWkfDefineBean define = defineDao.selectByPK(defineInfo);
		if (null == define) {
			throw new BusException("获取工作流定义结果为空");
		}

		// 工作流定义配置的签收标志为N，则无需签收
		String checkFlag = define.getSwdCheckFlag();
		if (StringUtils.isEmpty(checkFlag)) {
			throw new BusException("签收标志不能为空");
		}
		if (WKFConstants.SWD_CHECK_FLAG_NO.equals(checkFlag)) {
			throw new BusException("工作流定义配置的签收标志为N，则无需签收");
		}
		// 更新待办签收人
		SyWkfScheduleBean scheduleInfo = new SyWkfScheduleBean();
		scheduleInfo.setSwsScheduleId(scheduleId);
		SyWkfScheduleDao scheduleDao = (SyWkfScheduleDao) SpringContextUtil.getBean("SyWkfScheduleDao");
		SyWkfScheduleBean schedule = scheduleDao.selectByPK(scheduleInfo);
		if (null == schedule) {
			throw new BusException("查询待办结果为空");
		}
		if (WKFConstants.SWS_SCHEDULE_STATUS_READY.equals(schedule.getSwsScheduleStatus()) == false) {
			throw new BusException("待办状态非'待办'，无法签收");
		}
		schedule.setSwsScheduleUserId(userId);
		schedule.setSwsScheduleLoginName(loginName);
		schedule.setSwsScheduleStatus(WKFConstants.SWS_SCHEDULE_STATUS_CHECK);// 状态=签收
		scheduleDao.update(schedule);
	}

}
