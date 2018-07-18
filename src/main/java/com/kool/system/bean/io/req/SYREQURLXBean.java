package com.kool.system.bean.io.req;

import com.kool.core.base.BaseBean;
import com.kool.core.exception.AppException;
import com.kool.core.util.StringUtils;
import com.kool.core.validate.IIoValidate;

/**
 * @AUTHOR LUYU
 */
public class SYREQURLXBean extends BaseBean implements IIoValidate {
	protected String reqUrl;

	public String getReqUrl() {
		return reqUrl;
	}

	public void setReqUrl(String reqUrl) {
		this.reqUrl = reqUrl;
	}

	@Override
	public void validate() throws AppException {
		//非空校验
		if (StringUtils.isEmpty(reqUrl)) {
			throw new AppException("SY000036","reqUrl");//字段[%1]为空
		}
		//最大长度校验
		if (reqUrl != null && reqUrl.length()>60) {
			throw new AppException("SY000038","reqUrl",String.valueOf(60));//字段[%1]大于最大长度[%2]
		}
	}
}