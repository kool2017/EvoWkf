package com.kool.system.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.kool.system.bean.SyUserAutBean;

/**
 * @AUTHOR LUYU
 */
@Repository(value="BaseSyUserAutDao")
public interface BaseSyUserAutDao {

	public SyUserAutBean selectByPK(SyUserAutBean syUserAut);

	public List<SyUserAutBean> select(SyUserAutBean syUserAut);

	public void delete(SyUserAutBean syUserAut);

	public void deletes(SyUserAutBean syUserAut);

	public void update(SyUserAutBean syUserAut);

	public void updates(@Param("value") SyUserAutBean value,
			@Param("condition") SyUserAutBean condition);

	public void insert(SyUserAutBean syUserAut);
	
	public List<SyUserAutBean> selectPage(@Param("syUserAut") SyUserAutBean syUserAut, @Param("offset") int offset, @Param("pageSize") int pageSize);
	
	public int selectTotal(SyUserAutBean syUserAut);
	
	public void insertBatch(List<SyUserAutBean> syUserAut);
	
	public List<Map<String,Object>> selectBySql(String sql);
	
	public int selectTotalBySql(String sql);
}
