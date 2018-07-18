package com.kool.system.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.kool.system.bean.SyNtfRecordHisBean;

/**
 * @AUTHOR LUYU
 */
@Repository(value="BaseSyNtfRecordHisDao")
public interface BaseSyNtfRecordHisDao {

	public SyNtfRecordHisBean selectByPK(SyNtfRecordHisBean syNtfRecordHis);

	public List<SyNtfRecordHisBean> select(SyNtfRecordHisBean syNtfRecordHis);

	public void delete(SyNtfRecordHisBean syNtfRecordHis);

	public void deletes(SyNtfRecordHisBean syNtfRecordHis);

	public void update(SyNtfRecordHisBean syNtfRecordHis);

	public void updates(@Param("value") SyNtfRecordHisBean value,
			@Param("condition") SyNtfRecordHisBean condition);

	public void insert(SyNtfRecordHisBean syNtfRecordHis);
	
	public List<SyNtfRecordHisBean> selectPage(@Param("syNtfRecordHis") SyNtfRecordHisBean syNtfRecordHis, @Param("offset") int offset, @Param("pageSize") int pageSize);
	
	public int selectTotal(SyNtfRecordHisBean syNtfRecordHis);
	
	public void insertBatch(List<SyNtfRecordHisBean> syNtfRecordHis);
	
	public List<Map<String,Object>> selectBySql(String sql);
	
	public int selectTotalBySql(String sql);
}
