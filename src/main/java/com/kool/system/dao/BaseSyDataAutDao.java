package com.kool.system.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.kool.system.bean.SyDataAutBean;


/**
 * @AUTHOR LUYU
 */
@Repository(value="BaseSyDataAutDao")
public interface BaseSyDataAutDao {

	public SyDataAutBean selectByPK(SyDataAutBean syDataAut);

	public List<SyDataAutBean> select(SyDataAutBean syDataAut);

	public void delete(SyDataAutBean syDataAut);

	public void deletes(SyDataAutBean syDataAut);

	public void update(SyDataAutBean syDataAut);

	public void updates(@Param("value") SyDataAutBean value,
			@Param("condition") SyDataAutBean condition);

	public void insert(SyDataAutBean syDataAut);
	
	public List<SyDataAutBean> selectPage(@Param("syDataAut") SyDataAutBean syDataAut, @Param("offset") int offset, @Param("pageSize") int pageSize);
	
	public int selectTotal(SyDataAutBean syDataAut);
	
	public void insertBatch(List<SyDataAutBean> syDataAut);
	
	public List<Map<String,Object>> selectBySql(String sql);
	
	public int selectTotalBySql(String sql);
}
