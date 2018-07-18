package com.kool.system.bean.io.param;

import com.kool.core.base.BaseBean;
import com.kool.core.exception.AppException;
import com.kool.core.util.StringUtils;
import com.kool.core.validate.IIoValidate;

/**
 * @AUTHOR LUYU
 */
public class SYPAMINFYBean extends BaseBean implements IIoValidate {
	protected String paramCode;
	protected String value;
	protected String name;
	protected String rootCode;
	protected String fatCode;
	protected String deep;
	protected String seq;
	protected String cmt;

	public String getParamCode() {
		return paramCode;
	}

	public void setParamCode(String paramCode) {
		this.paramCode = paramCode;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRootCode() {
		return rootCode;
	}

	public void setRootCode(String rootCode) {
		this.rootCode = rootCode;
	}

	public String getFatCode() {
		return fatCode;
	}

	public void setFatCode(String fatCode) {
		this.fatCode = fatCode;
	}

	public String getDeep() {
		return deep;
	}

	public void setDeep(String deep) {
		this.deep = deep;
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public String getCmt() {
		return cmt;
	}

	public void setCmt(String cmt) {
		this.cmt = cmt;
	}

	@Override
	public void validate() throws AppException {
		// 非空校验
		if (StringUtils.isEmpty(paramCode)) {
			throw new AppException("SY000036", "paramCode");// 字段[%1]为空
		}
		// 最小长度校验
		if (paramCode != null && paramCode.length() < 8) {
			throw new AppException("SY000037", "paramCode", String.valueOf(8));// 字段[%1]小于最小长度[%2]
		}
		// 最大长度校验
		if (paramCode != null && paramCode.length() > 8) {
			throw new AppException("SY000038", "paramCode", String.valueOf(8));// 字段[%1]大于最大长度[%2]
		}
		// 最大长度校验
		if (value != null && value.length() > 512) {
			throw new AppException("SY000038", "value", String.valueOf(512));// 字段[%1]大于最大长度[%2]
		}
		// 最大长度校验
		if (name != null && name.length() > 60) {
			throw new AppException("SY000038", "name", String.valueOf(60));// 字段[%1]大于最大长度[%2]
		}
		// 非空校验
		if (StringUtils.isEmpty(rootCode)) {
			throw new AppException("SY000036", "rootCode");// 字段[%1]为空
		}
		// 最小长度校验
		if (rootCode != null && rootCode.length() < 8) {
			throw new AppException("SY000037", "rootCode", String.valueOf(8));// 字段[%1]小于最小长度[%2]
		}
		// 最大长度校验
		if (rootCode != null && rootCode.length() > 8) {
			throw new AppException("SY000038", "rootCode", String.valueOf(8));// 字段[%1]大于最大长度[%2]
		}
		// 最大长度校验
		if (fatCode != null && fatCode.length() > 8) {
			throw new AppException("SY000038", "fatCode", String.valueOf(8));// 字段[%1]大于最大长度[%2]
		}
		// 非空校验
		if (StringUtils.isEmpty(deep)) {
			throw new AppException("SY000036", "deep");// 字段[%1]为空
		}
		// 非空校验
		if (StringUtils.isEmpty(seq)) {
			throw new AppException("SY000036", "seq");// 字段[%1]为空
		}
		// 最大长度校验
		if (cmt != null && cmt.length() > 512) {
			throw new AppException("SY000038", "cmt", String.valueOf(512));// 字段[%1]大于最大长度[%2]
		}
	}
}