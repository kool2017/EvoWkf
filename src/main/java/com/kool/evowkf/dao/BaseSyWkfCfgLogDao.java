package com.kool.evowkf.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.kool.evowkf.bean.SyWkfCfgLogBean;


@Repository(value="BaseSyWkfCfgLogDao")
public interface BaseSyWkfCfgLogDao {

	public SyWkfCfgLogBean selectByPK(SyWkfCfgLogBean syWkfCfgLog);

	public List<SyWkfCfgLogBean> select(SyWkfCfgLogBean syWkfCfgLog);

	public void delete(SyWkfCfgLogBean syWkfCfgLog);

	public void deletes(SyWkfCfgLogBean syWkfCfgLog);

	public void update(SyWkfCfgLogBean syWkfCfgLog);

	public void updates(@Param("value") SyWkfCfgLogBean value,
			@Param("condition") SyWkfCfgLogBean condition);

	public void insert(SyWkfCfgLogBean syWkfCfgLog);
	
	public List<SyWkfCfgLogBean> selectPage(@Param("syWkfCfgLog") SyWkfCfgLogBean syWkfCfgLog, @Param("offset") int offset, @Param("pageSize") int pageSize);
	
	public int selectTotal(SyWkfCfgLogBean syWkfCfgLog);
	
	public void insertBatch(List<SyWkfCfgLogBean> syWkfCfgLog);
	
	public List<Map<String,Object>> selectBySql(String sql);
	
	public int selectTotalBySql(String sql);
}
