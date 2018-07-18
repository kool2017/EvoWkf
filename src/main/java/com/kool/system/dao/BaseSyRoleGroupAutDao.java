package com.kool.system.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.kool.system.bean.SyRoleGroupAutBean;

/**
 * @AUTHOR LUYU
 */
@Repository(value="BaseSyRoleGroupAutDao")
public interface BaseSyRoleGroupAutDao {

	public SyRoleGroupAutBean selectByPK(SyRoleGroupAutBean syRoleGroupAut);

	public List<SyRoleGroupAutBean> select(SyRoleGroupAutBean syRoleGroupAut);

	public void delete(SyRoleGroupAutBean syRoleGroupAut);

	public void deletes(SyRoleGroupAutBean syRoleGroupAut);

	public void update(SyRoleGroupAutBean syRoleGroupAut);

	public void updates(@Param("value") SyRoleGroupAutBean value,
			@Param("condition") SyRoleGroupAutBean condition);

	public void insert(SyRoleGroupAutBean syRoleGroupAut);
	
	public List<SyRoleGroupAutBean> selectPage(@Param("syRoleGroupAut") SyRoleGroupAutBean syRoleGroupAut, @Param("offset") int offset, @Param("pageSize") int pageSize);
	
	public int selectTotal(SyRoleGroupAutBean syRoleGroupAut);
	
	public void insertBatch(List<SyRoleGroupAutBean> syRoleGroupAut);
	
	public List<Map<String,Object>> selectBySql(String sql);
	
	public int selectTotalBySql(String sql);
}
