package com.kool.system.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.kool.system.bean.SyMenuAutBean;

/**
 * @AUTHOR LUYU
 */
@Repository(value="BaseSyMenuAutDao")
public interface BaseSyMenuAutDao {

	public SyMenuAutBean selectByPK(SyMenuAutBean syMenuAut);

	public List<SyMenuAutBean> select(SyMenuAutBean syMenuAut);

	public void delete(SyMenuAutBean syMenuAut);

	public void deletes(SyMenuAutBean syMenuAut);

	public void update(SyMenuAutBean syMenuAut);

	public void updates(@Param("value") SyMenuAutBean value,
			@Param("condition") SyMenuAutBean condition);

	public void insert(SyMenuAutBean syMenuAut);
	
	public List<SyMenuAutBean> selectPage(@Param("syMenuAut") SyMenuAutBean syMenuAut, @Param("offset") int offset, @Param("pageSize") int pageSize);
	
	public int selectTotal(SyMenuAutBean syMenuAut);
	
	public void insertBatch(List<SyMenuAutBean> syMenuAut);
	
	public List<Map<String,Object>> selectBySql(String sql);
	
	public int selectTotalBySql(String sql);
}
