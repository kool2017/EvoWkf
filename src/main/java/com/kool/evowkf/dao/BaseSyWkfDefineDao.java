package com.kool.evowkf.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.kool.evowkf.bean.SyWkfDefineBean;


@Repository(value="BaseSyWkfDefineDao")
public interface BaseSyWkfDefineDao {

	public SyWkfDefineBean selectByPK(SyWkfDefineBean syWkfDefine);

	public List<SyWkfDefineBean> select(SyWkfDefineBean syWkfDefine);

	public void delete(SyWkfDefineBean syWkfDefine);

	public void deletes(SyWkfDefineBean syWkfDefine);

	public void update(SyWkfDefineBean syWkfDefine);

	public void updates(@Param("value") SyWkfDefineBean value,
			@Param("condition") SyWkfDefineBean condition);

	public void insert(SyWkfDefineBean syWkfDefine);
	
	public List<SyWkfDefineBean> selectPage(@Param("syWkfDefine") SyWkfDefineBean syWkfDefine, @Param("offset") int offset, @Param("pageSize") int pageSize);
	
	public int selectTotal(SyWkfDefineBean syWkfDefine);
	
	public void insertBatch(List<SyWkfDefineBean> syWkfDefine);
	
	public List<Map<String,Object>> selectBySql(String sql);
	
	public int selectTotalBySql(String sql);
}
