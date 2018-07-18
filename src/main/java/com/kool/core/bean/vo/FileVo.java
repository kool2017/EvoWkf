/**
 * @PROJECT 
 * @DATE 2018年7月14日 下午5:47:03
 * @AUTHOR LUYU
 */
package com.kool.core.bean.vo;

import com.kool.core.base.BaseBean;

/**
 * @DESCRIBE
 * @AUTHOR LUYU
 * @DATE 2018年7月14日 下午5:47:03
 *
 */
public class FileVo extends BaseBean {
	private String fileName;
	private String fileType;
	private String size;
	private String fileUrl;
	private String repositoryType;

	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @param fileName
	 *            the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * @return the fileType
	 */
	public String getFileType() {
		return fileType;
	}

	/**
	 * @param fileType
	 *            the fileType to set
	 */
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	/**
	 * @return the size
	 */
	public String getSize() {
		return size;
	}

	/**
	 * @param size
	 *            the size to set
	 */
	public void setSize(String size) {
		this.size = size;
	}

	/**
	 * @return the fileUrl
	 */
	public String getFileUrl() {
		return fileUrl;
	}

	/**
	 * @param fileUrl
	 *            the fileUrl to set
	 */
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	/**
	 * @return the repositoryType
	 */
	public String getRepositoryType() {
		return repositoryType;
	}

	/**
	 * @param repositoryType
	 *            the repositoryType to set
	 */
	public void setRepositoryType(String repositoryType) {
		this.repositoryType = repositoryType;
	}

}
