package com.kool.evowkf.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.kool.evowkf.bean.SyWkfRouteBean;


@Repository(value="BaseSyWkfRouteDao")
public interface BaseSyWkfRouteDao {

	public SyWkfRouteBean selectByPK(SyWkfRouteBean syWkfRoute);

	public List<SyWkfRouteBean> select(SyWkfRouteBean syWkfRoute);

	public void delete(SyWkfRouteBean syWkfRoute);

	public void deletes(SyWkfRouteBean syWkfRoute);

	public void update(SyWkfRouteBean syWkfRoute);

	public void updates(@Param("value") SyWkfRouteBean value,
			@Param("condition") SyWkfRouteBean condition);

	public void insert(SyWkfRouteBean syWkfRoute);
	
	public List<SyWkfRouteBean> selectPage(@Param("syWkfRoute") SyWkfRouteBean syWkfRoute, @Param("offset") int offset, @Param("pageSize") int pageSize);
	
	public int selectTotal(SyWkfRouteBean syWkfRoute);
	
	public void insertBatch(List<SyWkfRouteBean> syWkfRoute);
	
	public List<Map<String,Object>> selectBySql(String sql);
	
	public int selectTotalBySql(String sql);
}
