package com.kool.system.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.kool.system.bean.SyReqAutBean;

/**
 * @AUTHOR LUYU
 */
@Repository(value="BaseSyReqAutDao")
public interface BaseSyReqAutDao {

	public SyReqAutBean selectByPK(SyReqAutBean syReqAut);

	public List<SyReqAutBean> select(SyReqAutBean syReqAut);

	public void delete(SyReqAutBean syReqAut);

	public void deletes(SyReqAutBean syReqAut);

	public void update(SyReqAutBean syReqAut);

	public void updates(@Param("value") SyReqAutBean value,
			@Param("condition") SyReqAutBean condition);

	public void insert(SyReqAutBean syReqAut);
	
	public List<SyReqAutBean> selectPage(@Param("syReqAut") SyReqAutBean syReqAut, @Param("offset") int offset, @Param("pageSize") int pageSize);
	
	public int selectTotal(SyReqAutBean syReqAut);
	
	public void insertBatch(List<SyReqAutBean> syReqAut);
	
	public List<Map<String,Object>> selectBySql(String sql);
	
	public int selectTotalBySql(String sql);
}
