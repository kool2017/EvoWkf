package com.kool.system.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.kool.system.bean.SyLoginLogBean;

/**
 * @AUTHOR LUYU
 */
@Repository(value="BaseSyLoginLogDao")
public interface BaseSyLoginLogDao {

	public SyLoginLogBean selectByPK(SyLoginLogBean syLoginLog);

	public List<SyLoginLogBean> select(SyLoginLogBean syLoginLog);

	public void delete(SyLoginLogBean syLoginLog);

	public void deletes(SyLoginLogBean syLoginLog);

	public void update(SyLoginLogBean syLoginLog);

	public void updates(@Param("value") SyLoginLogBean value,
			@Param("condition") SyLoginLogBean condition);

	public void insert(SyLoginLogBean syLoginLog);
	
	public List<SyLoginLogBean> selectPage(@Param("syLoginLog") SyLoginLogBean syLoginLog, @Param("offset") int offset, @Param("pageSize") int pageSize);
	
	public int selectTotal(SyLoginLogBean syLoginLog);
	
	public void insertBatch(List<SyLoginLogBean> syLoginLog);
	
	public List<Map<String,Object>> selectBySql(String sql);
	
	public int selectTotalBySql(String sql);
}
