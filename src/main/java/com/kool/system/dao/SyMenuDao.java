package com.kool.system.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.kool.system.bean.SyMenuBean;

/**
 * @AUTHOR LUYU
 */
@Repository(value="SyMenuDao")
public interface SyMenuDao extends BaseSyMenuDao{
	public List<SyMenuBean> selectAllAndOrder();
}
