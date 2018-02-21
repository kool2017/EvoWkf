package com.kool.evowkf.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.kool.evowkf.bean.SyWkfNodeBean;


@Repository(value="BaseSyWkfNodeDao")
public interface BaseSyWkfNodeDao {

	public SyWkfNodeBean selectByPK(SyWkfNodeBean syWkfNode);

	public List<SyWkfNodeBean> select(SyWkfNodeBean syWkfNode);

	public void delete(SyWkfNodeBean syWkfNode);

	public void deletes(SyWkfNodeBean syWkfNode);

	public void update(SyWkfNodeBean syWkfNode);

	public void updates(@Param("value") SyWkfNodeBean value,
			@Param("condition") SyWkfNodeBean condition);

	public void insert(SyWkfNodeBean syWkfNode);
	
	public List<SyWkfNodeBean> selectPage(@Param("syWkfNode") SyWkfNodeBean syWkfNode, @Param("offset") int offset, @Param("pageSize") int pageSize);
	
	public int selectTotal(SyWkfNodeBean syWkfNode);
	
	public void insertBatch(List<SyWkfNodeBean> syWkfNode);
	
	public List<Map<String,Object>> selectBySql(String sql);
	
	public int selectTotalBySql(String sql);
}
