/**
 * @PROJECT 
 * @DATE 2018年2月20日 上午11:15:52
 * @AUTHOR LUYU
 */
package com.kool.system.bean.vo;

import java.util.List;

import com.kool.core.base.BaseBean;
import com.kool.system.bean.io.SYPAGEINFOYBean;

/**
 * @DESCRIBE
 * @AUTHOR LUYU
 * @DATE 2018年2月20日 上午11:15:52
 *
 */
public class PageResult {
	private List<BaseBean> listBusinessValue;
	private SYPAGEINFOYBean pageInfo;

	/**
	 * @return the listBusinessValue
	 */
	public List<BaseBean> getListBusinessValue() {
		return listBusinessValue;
	}

	/**
	 * @param listBusinessValue
	 *            the listBusinessValue to set
	 */
	public void setListBusinessValue(List<BaseBean> listBusinessValue) {
		this.listBusinessValue = listBusinessValue;
	}

	/**
	 * @return the pageInfo
	 */
	public SYPAGEINFOYBean getPageInfo() {
		return pageInfo;
	}

	/**
	 * @param pageInfo
	 *            the pageInfo to set
	 */
	public void setPageInfo(SYPAGEINFOYBean pageInfo) {
		this.pageInfo = pageInfo;
	}

}
