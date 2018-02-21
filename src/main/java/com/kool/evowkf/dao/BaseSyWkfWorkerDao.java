package com.kool.evowkf.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.kool.evowkf.bean.SyWkfWorkerBean;


@Repository(value="BaseSyWkfWorkerDao")
public interface BaseSyWkfWorkerDao {

	public SyWkfWorkerBean selectByPK(SyWkfWorkerBean syWkfWorker);

	public List<SyWkfWorkerBean> select(SyWkfWorkerBean syWkfWorker);

	public void delete(SyWkfWorkerBean syWkfWorker);

	public void deletes(SyWkfWorkerBean syWkfWorker);

	public void update(SyWkfWorkerBean syWkfWorker);

	public void updates(@Param("value") SyWkfWorkerBean value,
			@Param("condition") SyWkfWorkerBean condition);

	public void insert(SyWkfWorkerBean syWkfWorker);
	
	public List<SyWkfWorkerBean> selectPage(@Param("syWkfWorker") SyWkfWorkerBean syWkfWorker, @Param("offset") int offset, @Param("pageSize") int pageSize);
	
	public int selectTotal(SyWkfWorkerBean syWkfWorker);
	
	public void insertBatch(List<SyWkfWorkerBean> syWkfWorker);
	
	public List<Map<String,Object>> selectBySql(String sql);
	
	public int selectTotalBySql(String sql);
}
