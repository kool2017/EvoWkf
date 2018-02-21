package com.kool.evowkf.bean;

import java.util.HashMap;
import java.util.Map;
import com.kool.core.base.BaseBean;

public class SyWkfRecordDataBean extends BaseBean {
	protected String srtRecordId;
	protected boolean isInitSrtRecordId;
	protected String srtDetailId;
	protected boolean isInitSrtDetailId;
	protected Object srtBusPkg;
	protected boolean isInitSrtBusPkg;

	public boolean getIsInitSrtRecordId() {
		return this.isInitSrtRecordId;
	}

	public boolean getIsInitSrtDetailId() {
		return this.isInitSrtDetailId;
	}

	public boolean getIsInitSrtBusPkg() {
		return this.isInitSrtBusPkg;
	}

	public String getSrtRecordId() {
		return srtRecordId;
	}

	public void setSrtRecordId(String srtRecordId) {
		this.srtRecordId = srtRecordId;
		this.isInitSrtRecordId = true;
	}

	public String getSrtDetailId() {
		return srtDetailId;
	}

	public void setSrtDetailId(String srtDetailId) {
		this.srtDetailId = srtDetailId;
		this.isInitSrtDetailId = true;
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
		if (isInitSrtRecordId) {
			map.put("srtRecordId", formatString(srtRecordId));
		}
		if (isInitSrtDetailId) {
			map.put("srtDetailId", formatString(srtDetailId));
		}
		if (isInitSrtBusPkg) {
			map.put("srtBusPkg", formatString(srtBusPkg));
		}

		return map;
	}
}
