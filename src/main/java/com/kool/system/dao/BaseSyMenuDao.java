package com.kool.system.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.kool.system.bean.SyMenuBean;

/**
 * @AUTHOR LUYU
 */
@Repository(value="BaseSyMenuDao")
public interface BaseSyMenuDao {

	public SyMenuBean selectByPK(SyMenuBean syMenu);

	public List<SyMenuBean> select(SyMenuBean syMenu);

	public void delete(SyMenuBean syMenu);

	public void deletes(SyMenuBean syMenu);

	public void update(SyMenuBean syMenu);

	public void updates(@Param("value") SyMenuBean value,
			@Param("condition") SyMenuBean condition);

	public void insert(SyMenuBean syMenu);
	
	public List<SyMenuBean> selectPage(@Param("syMenu") SyMenuBean syMenu, @Param("offset") int offset, @Param("pageSize") int pageSize);
	
	public int selectTotal(SyMenuBean syMenu);
	
	public void insertBatch(List<SyMenuBean> syMenu);
	
	public List<Map<String,Object>> selectBySql(String sql);
	
	public int selectTotalBySql(String sql);
}
