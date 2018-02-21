package com.kool.system.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.kool.system.bean.SyGlobalDefineBean;


@Repository(value="BaseSyGlobalDefineDao")
public interface BaseSyGlobalDefineDao {

	public SyGlobalDefineBean selectByPK(SyGlobalDefineBean syGlobalDefine);

	public List<SyGlobalDefineBean> select(SyGlobalDefineBean syGlobalDefine);

	public void delete(SyGlobalDefineBean syGlobalDefine);

	public void deletes(SyGlobalDefineBean syGlobalDefine);

	public void update(SyGlobalDefineBean syGlobalDefine);

	public void updates(@Param("value") SyGlobalDefineBean value,
			@Param("condition") SyGlobalDefineBean condition);

	public void insert(SyGlobalDefineBean syGlobalDefine);
	
	public List<SyGlobalDefineBean> selectPage(@Param("syGlobalDefine") SyGlobalDefineBean syGlobalDefine, @Param("offset") int offset, @Param("pageSize") int pageSize);
	
	public int selectTotal(SyGlobalDefineBean syGlobalDefine);
	
	public void insertBatch(List<SyGlobalDefineBean> syGlobalDefine);
	
	public List<Map<String,Object>> selectBySql(String sql);
	
	public int selectTotalBySql(String sql);
}
