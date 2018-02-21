/**
 * @PROJECT 
 * @DATE 2018年2月20日 上午11:09:17
 * @AUTHOR LUYU
 */
package com.kool.system.bean.io;

/**
 * @DESCRIBE
 * @AUTHOR LUYU
 * @DATE 2018年2月20日 上午11:09:17
 *
 */
public class SYPAGEINFOYBean {
	private Integer pageSize;
	private Integer total;
	private Integer pageCount;
	private Integer currentPage;

	/**
	 * @return the pageSize
	 */
	public Integer getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize
	 *            the pageSize to set
	 */
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @return the total
	 */
	public Integer getTotal() {
		return total;
	}

	/**
	 * @param total
	 *            the total to set
	 */
	public void setTotal(Integer total) {
		this.total = total;
	}

	/**
	 * @return the pageCount
	 */
	public Integer getPageCount() {
		return pageCount;
	}

	/**
	 * @param pageCount
	 *            the pageCount to set
	 */
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	/**
	 * @return the currentPage
	 */
	public Integer getCurrentPage() {
		return currentPage;
	}

	/**
	 * @param currentPage
	 *            the currentPage to set
	 */
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

}
