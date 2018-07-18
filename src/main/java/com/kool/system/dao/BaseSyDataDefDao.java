package com.kool.system.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.kool.system.bean.SyDataDefBean;

/**
 * @AUTHOR LUYU
 */
@Repository(value="BaseSyDataDefDao")
public interface BaseSyDataDefDao {

	public SyDataDefBean selectByPK(SyDataDefBean syDataDef);

	public List<SyDataDefBean> select(SyDataDefBean syDataDef);

	public void delete(SyDataDefBean syDataDef);

	public void deletes(SyDataDefBean syDataDef);

	public void update(SyDataDefBean syDataDef);

	public void updates(@Param("value") SyDataDefBean value,
			@Param("condition") SyDataDefBean condition);

	public void insert(SyDataDefBean syDataDef);
	
	public List<SyDataDefBean> selectPage(@Param("syDataDef") SyDataDefBean syDataDef, @Param("offset") int offset, @Param("pageSize") int pageSize);
	
	public int selectTotal(SyDataDefBean syDataDef);
	
	public void insertBatch(List<SyDataDefBean> syDataDef);
	
	public List<Map<String,Object>> selectBySql(String sql);
	
	public int selectTotalBySql(String sql);
}
