package com.kool.evowkf.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.kool.evowkf.bean.SyWkfRecordBean;


@Repository(value="BaseSyWkfRecordDao")
public interface BaseSyWkfRecordDao {

	public SyWkfRecordBean selectByPK(SyWkfRecordBean syWkfRecord);

	public List<SyWkfRecordBean> select(SyWkfRecordBean syWkfRecord);

	public void delete(SyWkfRecordBean syWkfRecord);

	public void deletes(SyWkfRecordBean syWkfRecord);

	public void update(SyWkfRecordBean syWkfRecord);

	public void updates(@Param("value") SyWkfRecordBean value,
			@Param("condition") SyWkfRecordBean condition);

	public void insert(SyWkfRecordBean syWkfRecord);
	
	public List<SyWkfRecordBean> selectPage(@Param("syWkfRecord") SyWkfRecordBean syWkfRecord, @Param("offset") int offset, @Param("pageSize") int pageSize);
	
	public int selectTotal(SyWkfRecordBean syWkfRecord);
	
	public void insertBatch(List<SyWkfRecordBean> syWkfRecord);
	
	public List<Map<String,Object>> selectBySql(String sql);
	
	public int selectTotalBySql(String sql);
}
