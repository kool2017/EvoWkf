package com.kool.core.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.kool.core.bean.SyCacheCtlBean;

/**
 * @AUTHOR LUYU
 */
@Repository(value="BaseSyCacheCtlDao")
public interface BaseSyCacheCtlDao {

	public SyCacheCtlBean selectByPK(SyCacheCtlBean syCacheCtl);

	public List<SyCacheCtlBean> select(SyCacheCtlBean syCacheCtl);

	public void delete(SyCacheCtlBean syCacheCtl);

	public void deletes(SyCacheCtlBean syCacheCtl);

	public void update(SyCacheCtlBean syCacheCtl);

	public void updates(@Param("value") SyCacheCtlBean value,
			@Param("condition") SyCacheCtlBean condition);

	public void insert(SyCacheCtlBean syCacheCtl);
	
	public List<SyCacheCtlBean> selectPage(@Param("syCacheCtl") SyCacheCtlBean syCacheCtl, @Param("offset") int offset, @Param("pageSize") int pageSize);
	
	public int selectTotal(SyCacheCtlBean syCacheCtl);
	
	public void insertBatch(List<SyCacheCtlBean> syCacheCtl);
	
	public List<Map<String,Object>> selectBySql(String sql);
	
	public int selectTotalBySql(String sql);
}
