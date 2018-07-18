package com.kool.system.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.kool.system.bean.SyReqDefBean;

/**
 * @AUTHOR LUYU
 */
@Repository(value="BaseSyReqDefDao")
public interface BaseSyReqDefDao {

	public SyReqDefBean selectByPK(SyReqDefBean syReqDef);

	public List<SyReqDefBean> select(SyReqDefBean syReqDef);

	public void delete(SyReqDefBean syReqDef);

	public void deletes(SyReqDefBean syReqDef);

	public void update(SyReqDefBean syReqDef);

	public void updates(@Param("value") SyReqDefBean value,
			@Param("condition") SyReqDefBean condition);

	public void insert(SyReqDefBean syReqDef);
	
	public List<SyReqDefBean> selectPage(@Param("syReqDef") SyReqDefBean syReqDef, @Param("offset") int offset, @Param("pageSize") int pageSize);
	
	public int selectTotal(SyReqDefBean syReqDef);
	
	public void insertBatch(List<SyReqDefBean> syReqDef);
	
	public List<Map<String,Object>> selectBySql(String sql);
	
	public int selectTotalBySql(String sql);
}
