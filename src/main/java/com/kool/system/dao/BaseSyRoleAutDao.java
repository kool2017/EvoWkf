package com.kool.system.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.kool.system.bean.SyRoleAutBean;

/**
 * @AUTHOR LUYU
 */
@Repository(value="BaseSyRoleAutDao")
public interface BaseSyRoleAutDao {

	public SyRoleAutBean selectByPK(SyRoleAutBean syRoleAut);

	public List<SyRoleAutBean> select(SyRoleAutBean syRoleAut);

	public void delete(SyRoleAutBean syRoleAut);

	public void deletes(SyRoleAutBean syRoleAut);

	public void update(SyRoleAutBean syRoleAut);

	public void updates(@Param("value") SyRoleAutBean value,
			@Param("condition") SyRoleAutBean condition);

	public void insert(SyRoleAutBean syRoleAut);
	
	public List<SyRoleAutBean> selectPage(@Param("syRoleAut") SyRoleAutBean syRoleAut, @Param("offset") int offset, @Param("pageSize") int pageSize);
	
	public int selectTotal(SyRoleAutBean syRoleAut);
	
	public void insertBatch(List<SyRoleAutBean> syRoleAut);
	
	public List<Map<String,Object>> selectBySql(String sql);
	
	public int selectTotalBySql(String sql);
}
