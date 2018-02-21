package com.kool.evowkf.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.kool.evowkf.bean.SyWkfEntityBusinessBean;


@Repository(value="BaseSyWkfEntityBusinessDao")
public interface BaseSyWkfEntityBusinessDao {

	public SyWkfEntityBusinessBean selectByPK(SyWkfEntityBusinessBean syWkfEntityBusiness);

	public List<SyWkfEntityBusinessBean> select(SyWkfEntityBusinessBean syWkfEntityBusiness);

	public void delete(SyWkfEntityBusinessBean syWkfEntityBusiness);

	public void deletes(SyWkfEntityBusinessBean syWkfEntityBusiness);

	public void update(SyWkfEntityBusinessBean syWkfEntityBusiness);

	public void updates(@Param("value") SyWkfEntityBusinessBean value,
			@Param("condition") SyWkfEntityBusinessBean condition);

	public void insert(SyWkfEntityBusinessBean syWkfEntityBusiness);
	
	public List<SyWkfEntityBusinessBean> selectPage(@Param("syWkfEntityBusiness") SyWkfEntityBusinessBean syWkfEntityBusiness, @Param("offset") int offset, @Param("pageSize") int pageSize);
	
	public int selectTotal(SyWkfEntityBusinessBean syWkfEntityBusiness);
	
	public void insertBatch(List<SyWkfEntityBusinessBean> syWkfEntityBusiness);
	
	public List<Map<String,Object>> selectBySql(String sql);
	
	public int selectTotalBySql(String sql);
}
