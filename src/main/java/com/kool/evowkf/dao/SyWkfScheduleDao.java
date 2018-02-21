package com.kool.evowkf.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository(value="SyWkfScheduleDao")
public interface SyWkfScheduleDao extends BaseSyWkfScheduleDao{
	public void closeOtherSchedule(@Param("recordId")String recordId,@Param("scheduleIdExclude")String scheduleIdExclude);
}
