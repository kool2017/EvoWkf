package com.kool.system.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.kool.system.bean.SyFileInfoBean;

/**
 * @AUTHOR LUYU
 */
@Repository(value="BaseSyFileInfoDao")
public interface BaseSyFileInfoDao {

	public SyFileInfoBean selectByPK(SyFileInfoBean syFileInfo);

	public List<SyFileInfoBean> select(SyFileInfoBean syFileInfo);

	public void delete(SyFileInfoBean syFileInfo);

	public void deletes(SyFileInfoBean syFileInfo);

	public void update(SyFileInfoBean syFileInfo);

	public void updates(@Param("value") SyFileInfoBean value,
			@Param("condition") SyFileInfoBean condition);

	public void insert(SyFileInfoBean syFileInfo);
	
	public List<SyFileInfoBean> selectPage(@Param("syFileInfo") SyFileInfoBean syFileInfo, @Param("offset") int offset, @Param("pageSize") int pageSize);
	
	public int selectTotal(SyFileInfoBean syFileInfo);
	
	public void insertBatch(List<SyFileInfoBean> syFileInfo);
	
	public List<Map<String,Object>> selectBySql(String sql);
	
	public int selectTotalBySql(String sql);
}
