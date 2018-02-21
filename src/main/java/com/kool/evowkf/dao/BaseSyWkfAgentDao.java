package com.kool.evowkf.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.kool.evowkf.bean.SyWkfAgentBean;


@Repository(value="BaseSyWkfAgentDao")
public interface BaseSyWkfAgentDao {

	public SyWkfAgentBean selectByPK(SyWkfAgentBean syWkfAgent);

	public List<SyWkfAgentBean> select(SyWkfAgentBean syWkfAgent);

	public void delete(SyWkfAgentBean syWkfAgent);

	public void deletes(SyWkfAgentBean syWkfAgent);

	public void update(SyWkfAgentBean syWkfAgent);

	public void updates(@Param("value") SyWkfAgentBean value,
			@Param("condition") SyWkfAgentBean condition);

	public void insert(SyWkfAgentBean syWkfAgent);
	
	public List<SyWkfAgentBean> selectPage(@Param("syWkfAgent") SyWkfAgentBean syWkfAgent, @Param("offset") int offset, @Param("pageSize") int pageSize);
	
	public int selectTotal(SyWkfAgentBean syWkfAgent);
	
	public void insertBatch(List<SyWkfAgentBean> syWkfAgent);
	
	public List<Map<String,Object>> selectBySql(String sql);
	
	public int selectTotalBySql(String sql);
}
