package com.kool.system.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.kool.system.bean.SyParamBean;

/**
 * @AUTHOR LUYU
 */
@Repository(value="BaseSyParamDao")
public interface BaseSyParamDao {

	public SyParamBean selectByPK(SyParamBean syParam);

	public List<SyParamBean> select(SyParamBean syParam);

	public void delete(SyParamBean syParam);

	public void deletes(SyParamBean syParam);

	public void update(SyParamBean syParam);

	public void updates(@Param("value") SyParamBean value,
			@Param("condition") SyParamBean condition);

	public void insert(SyParamBean syParam);
	
	public List<SyParamBean> selectPage(@Param("syParam") SyParamBean syParam, @Param("offset") int offset, @Param("pageSize") int pageSize);
	
	public int selectTotal(SyParamBean syParam);
	
	public void insertBatch(List<SyParamBean> syParam);
	
	public List<Map<String,Object>> selectBySql(String sql);
	
	public int selectTotalBySql(String sql);
}
