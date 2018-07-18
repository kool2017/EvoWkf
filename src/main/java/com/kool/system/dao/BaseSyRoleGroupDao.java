package com.kool.system.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.kool.system.bean.SyRoleGroupBean;

/**
 * @AUTHOR LUYU
 */
@Repository(value="BaseSyRoleGroupDao")
public interface BaseSyRoleGroupDao {

	public SyRoleGroupBean selectByPK(SyRoleGroupBean syRoleGroup);

	public List<SyRoleGroupBean> select(SyRoleGroupBean syRoleGroup);

	public void delete(SyRoleGroupBean syRoleGroup);

	public void deletes(SyRoleGroupBean syRoleGroup);

	public void update(SyRoleGroupBean syRoleGroup);

	public void updates(@Param("value") SyRoleGroupBean value,
			@Param("condition") SyRoleGroupBean condition);

	public void insert(SyRoleGroupBean syRoleGroup);
	
	public List<SyRoleGroupBean> selectPage(@Param("syRoleGroup") SyRoleGroupBean syRoleGroup, @Param("offset") int offset, @Param("pageSize") int pageSize);
	
	public int selectTotal(SyRoleGroupBean syRoleGroup);
	
	public void insertBatch(List<SyRoleGroupBean> syRoleGroup);
	
	public List<Map<String,Object>> selectBySql(String sql);
	
	public int selectTotalBySql(String sql);
}
