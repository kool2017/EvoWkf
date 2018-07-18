package com.kool.system.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.kool.system.bean.SyUserRoleBean;

/**
 * @AUTHOR LUYU
 */
@Repository(value="BaseSyUserRoleDao")
public interface BaseSyUserRoleDao {

	public SyUserRoleBean selectByPK(SyUserRoleBean syUserRole);

	public List<SyUserRoleBean> select(SyUserRoleBean syUserRole);

	public void delete(SyUserRoleBean syUserRole);

	public void deletes(SyUserRoleBean syUserRole);

	public void update(SyUserRoleBean syUserRole);

	public void updates(@Param("value") SyUserRoleBean value,
			@Param("condition") SyUserRoleBean condition);

	public void insert(SyUserRoleBean syUserRole);
	
	public List<SyUserRoleBean> selectPage(@Param("syUserRole") SyUserRoleBean syUserRole, @Param("offset") int offset, @Param("pageSize") int pageSize);
	
	public int selectTotal(SyUserRoleBean syUserRole);
	
	public void insertBatch(List<SyUserRoleBean> syUserRole);
	
	public List<Map<String,Object>> selectBySql(String sql);
	
	public int selectTotalBySql(String sql);
}
