package com.kool.evowkf.bean;

import java.util.HashMap;
import java.util.Map;
import com.kool.core.base.BaseBean;

public class SyWkfRecordDataBean extends BaseBean {
	protected String srtWkfNbr;
	protected boolean isInitSrtWkfNbr;
	protected String srtDetailUid;
	protected boolean isInitSrtDetailUid;
	protected Object srtBusPkg;
	protected boolean isInitSrtBusPkg;

	public boolean getIsInitSrtWkfNbr() {
		return this.isInitSrtWkfNbr;
	}

	public boolean getIsInitSrtDetailUid() {
		return this.isInitSrtDetailUid;
	}

	public boolean getIsInitSrtBusPkg() {
		return this.isInitSrtBusPkg;
	}

	public String getSrtWkfNbr() {
		return srtWkfNbr;
	}

	public void setSrtWkfNbr(String srtWkfNbr) {
		this.srtWkfNbr = srtWkfNbr;
		this.isInitSrtWkfNbr = true;
	}

	public String getSrtDetailUid() {
		return srtDetailUid;
	}

	public void setSrtDetailUid(String srtDetailUid) {
		this.srtDetailUid = srtDetailUid;
		this.isInitSrtDetailUid = true;
	}

	public Object getSrtBusPkg() {
		return srtBusPkg;
	}

	public void setSrtBusPkg(Object srtBusPkg) {
		this.srtBusPkg = srtBusPkg;
		this.isInitSrtBusPkg = true;
	}

	public Map<String, String> toMap() {
		Map<String, String> map = new HashMap<String, String>();
		if (isInitSrtWkfNbr) {
			map.put("srtWkfNbr", formatString(srtWkfNbr));
		}
		if (isInitSrtDetailUid) {
			map.put("srtDetailUid", formatString(srtDetailUid));
		}
		if (isInitSrtBusPkg) {
			map.put("srtBusPkg", formatString(srtBusPkg));
		}

		return map;
	}
}
