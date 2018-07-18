package com.kool.system.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.kool.system.bean.SyUserTradeBean;

/**
 * @AUTHOR LUYU
 */
@Repository(value="BaseSyUserTradeDao")
public interface BaseSyUserTradeDao {

	public SyUserTradeBean selectByPK(SyUserTradeBean syUserTrade);

	public List<SyUserTradeBean> select(SyUserTradeBean syUserTrade);

	public void delete(SyUserTradeBean syUserTrade);

	public void deletes(SyUserTradeBean syUserTrade);

	public void update(SyUserTradeBean syUserTrade);

	public void updates(@Param("value") SyUserTradeBean value,
			@Param("condition") SyUserTradeBean condition);

	public void insert(SyUserTradeBean syUserTrade);
	
	public List<SyUserTradeBean> selectPage(@Param("syUserTrade") SyUserTradeBean syUserTrade, @Param("offset") int offset, @Param("pageSize") int pageSize);
	
	public int selectTotal(SyUserTradeBean syUserTrade);
	
	public void insertBatch(List<SyUserTradeBean> syUserTrade);
	
	public List<Map<String,Object>> selectBySql(String sql);
	
	public int selectTotalBySql(String sql);
}
