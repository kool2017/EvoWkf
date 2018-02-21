package com.kool.evowkf.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.kool.evowkf.bean.SyWkfRecordDataBean;


@Repository(value="BaseSyWkfRecordDataDao")
public interface BaseSyWkfRecordDataDao {

	public SyWkfRecordDataBean selectByPK(SyWkfRecordDataBean syWkfRecordData);

	public List<SyWkfRecordDataBean> select(SyWkfRecordDataBean syWkfRecordData);

	public void delete(SyWkfRecordDataBean syWkfRecordData);

	public void deletes(SyWkfRecordDataBean syWkfRecordData);

	public void update(SyWkfRecordDataBean syWkfRecordData);

	public void updates(@Param("value") SyWkfRecordDataBean value,
			@Param("condition") SyWkfRecordDataBean condition);

	public void insert(SyWkfRecordDataBean syWkfRecordData);
	
	public List<SyWkfRecordDataBean> selectPage(@Param("syWkfRecordData") SyWkfRecordDataBean syWkfRecordData, @Param("offset") int offset, @Param("pageSize") int pageSize);
	
	public int selectTotal(SyWkfRecordDataBean syWkfRecordData);
	
	public void insertBatch(List<SyWkfRecordDataBean> syWkfRecordData);
	
	public List<Map<String,Object>> selectBySql(String sql);
	
	public int selectTotalBySql(String sql);
}
