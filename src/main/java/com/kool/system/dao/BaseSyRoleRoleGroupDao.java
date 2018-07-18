package com.kool.system.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.kool.system.bean.SyRoleRoleGroupBean;

/**
 * @AUTHOR LUYU
 */
@Repository(value="BaseSyRoleRoleGroupDao")
public interface BaseSyRoleRoleGroupDao {

	public SyRoleRoleGroupBean selectByPK(SyRoleRoleGroupBean syRoleRoleGroup);

	public List<SyRoleRoleGroupBean> select(SyRoleRoleGroupBean syRoleRoleGroup);

	public void delete(SyRoleRoleGroupBean syRoleRoleGroup);

	public void deletes(SyRoleRoleGroupBean syRoleRoleGroup);

	public void update(SyRoleRoleGroupBean syRoleRoleGroup);

	public void updates(@Param("value") SyRoleRoleGroupBean value,
			@Param("condition") SyRoleRoleGroupBean condition);

	public void insert(SyRoleRoleGroupBean syRoleRoleGroup);
	
	public List<SyRoleRoleGroupBean> selectPage(@Param("syRoleRoleGroup") SyRoleRoleGroupBean syRoleRoleGroup, @Param("offset") int offset, @Param("pageSize") int pageSize);
	
	public int selectTotal(SyRoleRoleGroupBean syRoleRoleGroup);
	
	public void insertBatch(List<SyRoleRoleGroupBean> syRoleRoleGroup);
	
	public List<Map<String,Object>> selectBySql(String sql);
	
	public int selectTotalBySql(String sql);
}
