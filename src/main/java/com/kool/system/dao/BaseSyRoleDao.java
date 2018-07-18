package com.kool.system.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.kool.system.bean.SyRoleBean;

/**
 * @AUTHOR LUYU
 */
@Repository(value="BaseSyRoleDao")
public interface BaseSyRoleDao {

	public SyRoleBean selectByPK(SyRoleBean syRole);

	public List<SyRoleBean> select(SyRoleBean syRole);

	public void delete(SyRoleBean syRole);

	public void deletes(SyRoleBean syRole);

	public void update(SyRoleBean syRole);

	public void updates(@Param("value") SyRoleBean value,
			@Param("condition") SyRoleBean condition);

	public void insert(SyRoleBean syRole);
	
	public List<SyRoleBean> selectPage(@Param("syRole") SyRoleBean syRole, @Param("offset") int offset, @Param("pageSize") int pageSize);
	
	public int selectTotal(SyRoleBean syRole);
	
	public void insertBatch(List<SyRoleBean> syRole);
	
	public List<Map<String,Object>> selectBySql(String sql);
	
	public int selectTotalBySql(String sql);
}
