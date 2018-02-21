package com.kool.evowkf.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.kool.evowkf.bean.SyWkfScheduleBean;


@Repository(value="BaseSyWkfScheduleDao")
public interface BaseSyWkfScheduleDao {

	public SyWkfScheduleBean selectByPK(SyWkfScheduleBean syWkfSchedule);

	public List<SyWkfScheduleBean> select(SyWkfScheduleBean syWkfSchedule);

	public void delete(SyWkfScheduleBean syWkfSchedule);

	public void deletes(SyWkfScheduleBean syWkfSchedule);

	public void update(SyWkfScheduleBean syWkfSchedule);

	public void updates(@Param("value") SyWkfScheduleBean value,
			@Param("condition") SyWkfScheduleBean condition);

	public void insert(SyWkfScheduleBean syWkfSchedule);
	
	public List<SyWkfScheduleBean> selectPage(@Param("syWkfSchedule") SyWkfScheduleBean syWkfSchedule, @Param("offset") int offset, @Param("pageSize") int pageSize);
	
	public int selectTotal(SyWkfScheduleBean syWkfSchedule);
	
	public void insertBatch(List<SyWkfScheduleBean> syWkfSchedule);
	
	public List<Map<String,Object>> selectBySql(String sql);
	
	public int selectTotalBySql(String sql);
}
