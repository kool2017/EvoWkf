package com.kool.system.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.kool.system.bean.SyFileAutBean;

/**
 * @AUTHOR LUYU
 */
@Repository(value="BaseSyFileAutDao")
public interface BaseSyFileAutDao {

	public SyFileAutBean selectByPK(SyFileAutBean syFileAut);

	public List<SyFileAutBean> select(SyFileAutBean syFileAut);

	public void delete(SyFileAutBean syFileAut);

	public void deletes(SyFileAutBean syFileAut);

	public void update(SyFileAutBean syFileAut);

	public void updates(@Param("value") SyFileAutBean value,
			@Param("condition") SyFileAutBean condition);

	public void insert(SyFileAutBean syFileAut);
	
	public List<SyFileAutBean> selectPage(@Param("syFileAut") SyFileAutBean syFileAut, @Param("offset") int offset, @Param("pageSize") int pageSize);
	
	public int selectTotal(SyFileAutBean syFileAut);
	
	public void insertBatch(List<SyFileAutBean> syFileAut);
	
	public List<Map<String,Object>> selectBySql(String sql);
	
	public int selectTotalBySql(String sql);
}
