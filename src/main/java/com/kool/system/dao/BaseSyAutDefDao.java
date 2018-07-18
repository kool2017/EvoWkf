package com.kool.system.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.kool.system.bean.SyAutDefBean;

/**
 * @AUTHOR LUYU
 */
@Repository(value="BaseSyAutDefDao")
public interface BaseSyAutDefDao {

	public SyAutDefBean selectByPK(SyAutDefBean syAutDef);

	public List<SyAutDefBean> select(SyAutDefBean syAutDef);

	public void delete(SyAutDefBean syAutDef);

	public void deletes(SyAutDefBean syAutDef);

	public void update(SyAutDefBean syAutDef);

	public void updates(@Param("value") SyAutDefBean value,
			@Param("condition") SyAutDefBean condition);

	public void insert(SyAutDefBean syAutDef);
	
	public List<SyAutDefBean> selectPage(@Param("syAutDef") SyAutDefBean syAutDef, @Param("offset") int offset, @Param("pageSize") int pageSize);
	
	public int selectTotal(SyAutDefBean syAutDef);
	
	public void insertBatch(List<SyAutDefBean> syAutDef);
	
	public List<Map<String,Object>> selectBySql(String sql);
	
	public int selectTotalBySql(String sql);
}
