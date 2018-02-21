package com.kool.evowkf.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.kool.evowkf.bean.SyWkfNodeTemplateBean;


@Repository(value="BaseSyWkfNodeTemplateDao")
public interface BaseSyWkfNodeTemplateDao {

	public SyWkfNodeTemplateBean selectByPK(SyWkfNodeTemplateBean syWkfNodeTemplate);

	public List<SyWkfNodeTemplateBean> select(SyWkfNodeTemplateBean syWkfNodeTemplate);

	public void delete(SyWkfNodeTemplateBean syWkfNodeTemplate);

	public void deletes(SyWkfNodeTemplateBean syWkfNodeTemplate);

	public void update(SyWkfNodeTemplateBean syWkfNodeTemplate);

	public void updates(@Param("value") SyWkfNodeTemplateBean value,
			@Param("condition") SyWkfNodeTemplateBean condition);

	public void insert(SyWkfNodeTemplateBean syWkfNodeTemplate);
	
	public List<SyWkfNodeTemplateBean> selectPage(@Param("syWkfNodeTemplate") SyWkfNodeTemplateBean syWkfNodeTemplate, @Param("offset") int offset, @Param("pageSize") int pageSize);
	
	public int selectTotal(SyWkfNodeTemplateBean syWkfNodeTemplate);
	
	public void insertBatch(List<SyWkfNodeTemplateBean> syWkfNodeTemplate);
	
	public List<Map<String,Object>> selectBySql(String sql);
	
	public int selectTotalBySql(String sql);
}
