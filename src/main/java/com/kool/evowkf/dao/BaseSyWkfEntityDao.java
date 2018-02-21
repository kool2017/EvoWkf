package com.kool.evowkf.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.kool.evowkf.bean.SyWkfEntityBean;


@Repository(value="BaseSyWkfEntityDao")
public interface BaseSyWkfEntityDao {

	public SyWkfEntityBean selectByPK(SyWkfEntityBean syWkfEntity);

	public List<SyWkfEntityBean> select(SyWkfEntityBean syWkfEntity);

	public void delete(SyWkfEntityBean syWkfEntity);

	public void deletes(SyWkfEntityBean syWkfEntity);

	public void update(SyWkfEntityBean syWkfEntity);

	public void updates(@Param("value") SyWkfEntityBean value,
			@Param("condition") SyWkfEntityBean condition);

	public void insert(SyWkfEntityBean syWkfEntity);
	
	public List<SyWkfEntityBean> selectPage(@Param("syWkfEntity") SyWkfEntityBean syWkfEntity, @Param("offset") int offset, @Param("pageSize") int pageSize);
	
	public int selectTotal(SyWkfEntityBean syWkfEntity);
	
	public void insertBatch(List<SyWkfEntityBean> syWkfEntity);
	
	public List<Map<String,Object>> selectBySql(String sql);
	
	public int selectTotalBySql(String sql);
}
