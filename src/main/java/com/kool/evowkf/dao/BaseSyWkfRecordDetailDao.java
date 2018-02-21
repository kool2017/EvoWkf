package com.kool.evowkf.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.kool.evowkf.bean.SyWkfRecordDetailBean;


@Repository(value="BaseSyWkfRecordDetailDao")
public interface BaseSyWkfRecordDetailDao {

	public SyWkfRecordDetailBean selectByPK(SyWkfRecordDetailBean syWkfRecordDetail);

	public List<SyWkfRecordDetailBean> select(SyWkfRecordDetailBean syWkfRecordDetail);

	public void delete(SyWkfRecordDetailBean syWkfRecordDetail);

	public void deletes(SyWkfRecordDetailBean syWkfRecordDetail);

	public void update(SyWkfRecordDetailBean syWkfRecordDetail);

	public void updates(@Param("value") SyWkfRecordDetailBean value,
			@Param("condition") SyWkfRecordDetailBean condition);

	public void insert(SyWkfRecordDetailBean syWkfRecordDetail);
	
	public List<SyWkfRecordDetailBean> selectPage(@Param("syWkfRecordDetail") SyWkfRecordDetailBean syWkfRecordDetail, @Param("offset") int offset, @Param("pageSize") int pageSize);
	
	public int selectTotal(SyWkfRecordDetailBean syWkfRecordDetail);
	
	public void insertBatch(List<SyWkfRecordDetailBean> syWkfRecordDetail);
	
	public List<Map<String,Object>> selectBySql(String sql);
	
	public int selectTotalBySql(String sql);
}
