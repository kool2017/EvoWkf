package com.kool.evowkf.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.kool.evowkf.bean.SyWkfWorkgroupBean;


@Repository(value="BaseSyWkfWorkgroupDao")
public interface BaseSyWkfWorkgroupDao {

	public SyWkfWorkgroupBean selectByPK(SyWkfWorkgroupBean syWkfWorkgroup);

	public List<SyWkfWorkgroupBean> select(SyWkfWorkgroupBean syWkfWorkgroup);

	public void delete(SyWkfWorkgroupBean syWkfWorkgroup);

	public void deletes(SyWkfWorkgroupBean syWkfWorkgroup);

	public void update(SyWkfWorkgroupBean syWkfWorkgroup);

	public void updates(@Param("value") SyWkfWorkgroupBean value,
			@Param("condition") SyWkfWorkgroupBean condition);

	public void insert(SyWkfWorkgroupBean syWkfWorkgroup);
	
	public List<SyWkfWorkgroupBean> selectPage(@Param("syWkfWorkgroup") SyWkfWorkgroupBean syWkfWorkgroup, @Param("offset") int offset, @Param("pageSize") int pageSize);
	
	public int selectTotal(SyWkfWorkgroupBean syWkfWorkgroup);
	
	public void insertBatch(List<SyWkfWorkgroupBean> syWkfWorkgroup);
	
	public List<Map<String,Object>> selectBySql(String sql);
	
	public int selectTotalBySql(String sql);
}
