package com.kool.system.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.kool.system.bean.SyUserInfoBean;

/**
 * @AUTHOR LUYU
 */
@Repository(value="BaseSyUserInfoDao")
public interface BaseSyUserInfoDao {

	public SyUserInfoBean selectByPK(SyUserInfoBean syUserInfo);

	public List<SyUserInfoBean> select(SyUserInfoBean syUserInfo);

	public void delete(SyUserInfoBean syUserInfo);

	public void deletes(SyUserInfoBean syUserInfo);

	public void update(SyUserInfoBean syUserInfo);

	public void updates(@Param("value") SyUserInfoBean value,
			@Param("condition") SyUserInfoBean condition);

	public void insert(SyUserInfoBean syUserInfo);
	
	public List<SyUserInfoBean> selectPage(@Param("syUserInfo") SyUserInfoBean syUserInfo, @Param("offset") int offset, @Param("pageSize") int pageSize);
	
	public int selectTotal(SyUserInfoBean syUserInfo);
	
	public void insertBatch(List<SyUserInfoBean> syUserInfo);
	
	public List<Map<String,Object>> selectBySql(String sql);
	
	public int selectTotalBySql(String sql);
}
