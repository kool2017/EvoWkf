package com.kool.system.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.kool.system.bean.SyCounterBean;


/**
 * @AUTHOR LUYU
 */
@Repository(value="BaseSyCounterDao")
public interface BaseSyCounterDao {

	public SyCounterBean selectByPK(SyCounterBean syCounter);

	public List<SyCounterBean> select(SyCounterBean syCounter);

	public void delete(SyCounterBean syCounter);

	public void deletes(SyCounterBean syCounter);

	public void update(SyCounterBean syCounter);

	public void updates(@Param("value") SyCounterBean value,
			@Param("condition") SyCounterBean condition);

	public void insert(SyCounterBean syCounter);
	
	public List<SyCounterBean> selectPage(@Param("syCounter") SyCounterBean syCounter, @Param("offset") int offset, @Param("pageSize") int pageSize);
	
	public int selectTotal(SyCounterBean syCounter);
	
	public void insertBatch(List<SyCounterBean> syCounter);
	
	public List<Map<String,Object>> selectBySql(String sql);
	
	public int selectTotalBySql(String sql);
}
