package com.kool.system.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.kool.system.bean.SyErrorInfoBean;

/**
 * @AUTHOR LUYU
 */
@Repository(value="BaseSyErrorInfoDao")
public interface BaseSyErrorInfoDao {

	public SyErrorInfoBean selectByPK(SyErrorInfoBean syErrorInfo);

	public List<SyErrorInfoBean> select(SyErrorInfoBean syErrorInfo);

	public void delete(SyErrorInfoBean syErrorInfo);

	public void deletes(SyErrorInfoBean syErrorInfo);

	public void update(SyErrorInfoBean syErrorInfo);

	public void updates(@Param("value") SyErrorInfoBean value,
			@Param("condition") SyErrorInfoBean condition);

	public void insert(SyErrorInfoBean syErrorInfo);
	
	public List<SyErrorInfoBean> selectPage(@Param("syErrorInfo") SyErrorInfoBean syErrorInfo, @Param("offset") int offset, @Param("pageSize") int pageSize);
	
	public int selectTotal(SyErrorInfoBean syErrorInfo);
	
	public void insertBatch(List<SyErrorInfoBean> syErrorInfo);
	
	public List<Map<String,Object>> selectBySql(String sql);
	
	public int selectTotalBySql(String sql);
}
