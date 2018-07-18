package com.kool.system.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.kool.system.bean.SyNtfRecordBean;

/**
 * @AUTHOR LUYU
 */
@Repository(value="BaseSyNtfRecordDao")
public interface BaseSyNtfRecordDao {

	public SyNtfRecordBean selectByPK(SyNtfRecordBean syNtfRecord);

	public List<SyNtfRecordBean> select(SyNtfRecordBean syNtfRecord);

	public void delete(SyNtfRecordBean syNtfRecord);

	public void deletes(SyNtfRecordBean syNtfRecord);

	public void update(SyNtfRecordBean syNtfRecord);

	public void updates(@Param("value") SyNtfRecordBean value,
			@Param("condition") SyNtfRecordBean condition);

	public void insert(SyNtfRecordBean syNtfRecord);
	
	public List<SyNtfRecordBean> selectPage(@Param("syNtfRecord") SyNtfRecordBean syNtfRecord, @Param("offset") int offset, @Param("pageSize") int pageSize);
	
	public int selectTotal(SyNtfRecordBean syNtfRecord);
	
	public void insertBatch(List<SyNtfRecordBean> syNtfRecord);
	
	public List<Map<String,Object>> selectBySql(String sql);
	
	public int selectTotalBySql(String sql);
}
