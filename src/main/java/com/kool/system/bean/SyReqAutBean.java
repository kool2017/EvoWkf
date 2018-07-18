package com.kool.system.bean;

import java.util.HashMap;
import java.util.Map;
import com.kool.core.base.BaseBean;

/**
 * @AUTHOR LUYU
 */
public class SyReqAutBean extends BaseBean {
	protected String sraReqUrl;
	protected boolean isInitSraReqUrl;
	protected String sraAutCode;
	protected boolean isInitSraAutCode;
	protected String sraCmt;
	protected boolean isInitSraCmt;

	public boolean getIsInitSraReqUrl() {
		return this.isInitSraReqUrl;
	}

	public boolean getIsInitSraAutCode() {
		return this.isInitSraAutCode;
	}

	public boolean getIsInitSraCmt() {
		return this.isInitSraCmt;
	}

	public String getSraReqUrl() {
		return sraReqUrl;
	}

	public void setSraReqUrl(String sraReqUrl) {
		this.sraReqUrl = sraReqUrl;
		this.isInitSraReqUrl = true;
	}

	public String getSraAutCode() {
		return sraAutCode;
	}

	public void setSraAutCode(String sraAutCode) {
		this.sraAutCode = sraAutCode;
		this.isInitSraAutCode = true;
	}

	public String getSraCmt() {
		return sraCmt;
	}

	public void setSraCmt(String sraCmt) {
		this.sraCmt = sraCmt;
		this.isInitSraCmt = true;
	}

	public Map<String, String> toMap() {
		Map<String, String> map = new HashMap<String, String>();
		if (isInitSraReqUrl) {
			map.put("sraReqUrl", formatString(sraReqUrl));
		}
		if (isInitSraAutCode) {
			map.put("sraAutCode", formatString(sraAutCode));
		}
		if (isInitSraCmt) {
			map.put("sraCmt", formatString(sraCmt));
		}

		return map;
	}

	public static SyReqAutBean DBResultToBean(Map<String, Object> map) {
		if (null == map) {
			return null;
		}
		SyReqAutBean reqDef = new SyReqAutBean();
		reqDef.setSraReqUrl((String) map.get("SRA_REQ_URL"));
		reqDef.setSraAutCode((String) map.get("SRA_AUT_CODE"));
		reqDef.setSraCmt((String) map.get("SRA_CMT"));
		return reqDef;
	}
}