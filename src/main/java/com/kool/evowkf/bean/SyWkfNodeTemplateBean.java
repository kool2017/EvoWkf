package com.kool.evowkf.bean;

import java.util.HashMap;
import java.util.Map;
import com.kool.core.base.BaseBean;

public class SyWkfNodeTemplateBean extends BaseBean {
	protected String sntTemplateCid;
	protected boolean isInitSntTemplateCid;
	protected String sntTemplateName;
	protected boolean isInitSntTemplateName;
	protected String sntEntityCid;
	protected boolean isInitSntEntityCid;
	protected String sntEventType;
	protected boolean isInitSntEventType;
	protected String sntEventRule;
	protected boolean isInitSntEventRule;
	protected String sntEventExt;
	protected boolean isInitSntEventExt;
	protected String sntRecordType;
	protected boolean isInitSntRecordType;
	protected String sntRouteStrategy;
	protected boolean isInitSntRouteStrategy;
	protected String sntRouteStrategyClazz;
	protected boolean isInitSntRouteStrategyClazz;
	protected String sntRouteType;
	protected boolean isInitSntRouteType;
	protected String sntBranchStrategy;
	protected boolean isInitSntBranchStrategy;
	protected String sntBranchStrategyClazz;
	protected boolean isInitSntBranchStrategyClazz;
	protected String sntIsAuto;
	protected boolean isInitSntIsAuto;
	protected String sntViewUrl;
	protected boolean isInitSntViewUrl;

	public boolean getIsInitSntTemplateCid() {
		return this.isInitSntTemplateCid;
	}

	public boolean getIsInitSntTemplateName() {
		return this.isInitSntTemplateName;
	}

	public boolean getIsInitSntEntityCid() {
		return this.isInitSntEntityCid;
	}

	public boolean getIsInitSntEventType() {
		return this.isInitSntEventType;
	}

	public boolean getIsInitSntEventRule() {
		return this.isInitSntEventRule;
	}

	public boolean getIsInitSntEventExt() {
		return this.isInitSntEventExt;
	}

	public boolean getIsInitSntRecordType() {
		return this.isInitSntRecordType;
	}

	public boolean getIsInitSntRouteStrategy() {
		return this.isInitSntRouteStrategy;
	}

	public boolean getIsInitSntRouteStrategyClazz() {
		return this.isInitSntRouteStrategyClazz;
	}

	public boolean getIsInitSntRouteType() {
		return this.isInitSntRouteType;
	}

	public boolean getIsInitSntBranchStrategy() {
		return this.isInitSntBranchStrategy;
	}

	public boolean getIsInitSntBranchStrategyClazz() {
		return this.isInitSntBranchStrategyClazz;
	}

	public boolean getIsInitSntIsAuto() {
		return this.isInitSntIsAuto;
	}

	public boolean getIsInitSntViewUrl() {
		return this.isInitSntViewUrl;
	}

	public String getSntTemplateCid() {
		return sntTemplateCid;
	}

	public void setSntTemplateCid(String sntTemplateCid) {
		this.sntTemplateCid = sntTemplateCid;
		this.isInitSntTemplateCid = true;
	}

	public String getSntTemplateName() {
		return sntTemplateName;
	}

	public void setSntTemplateName(String sntTemplateName) {
		this.sntTemplateName = sntTemplateName;
		this.isInitSntTemplateName = true;
	}

	public String getSntEntityCid() {
		return sntEntityCid;
	}

	public void setSntEntityCid(String sntEntityCid) {
		this.sntEntityCid = sntEntityCid;
		this.isInitSntEntityCid = true;
	}

	public String getSntEventType() {
		return sntEventType;
	}

	public void setSntEventType(String sntEventType) {
		this.sntEventType = sntEventType;
		this.isInitSntEventType = true;
	}

	public String getSntEventRule() {
		return sntEventRule;
	}

	public void setSntEventRule(String sntEventRule) {
		this.sntEventRule = sntEventRule;
		this.isInitSntEventRule = true;
	}

	public String getSntEventExt() {
		return sntEventExt;
	}

	public void setSntEventExt(String sntEventExt) {
		this.sntEventExt = sntEventExt;
		this.isInitSntEventExt = true;
	}

	public String getSntRecordType() {
		return sntRecordType;
	}

	public void setSntRecordType(String sntRecordType) {
		this.sntRecordType = sntRecordType;
		this.isInitSntRecordType = true;
	}

	public String getSntRouteStrategy() {
		return sntRouteStrategy;
	}

	public void setSntRouteStrategy(String sntRouteStrategy) {
		this.sntRouteStrategy = sntRouteStrategy;
		this.isInitSntRouteStrategy = true;
	}

	public String getSntRouteStrategyClazz() {
		return sntRouteStrategyClazz;
	}

	public void setSntRouteStrategyClazz(String sntRouteStrategyClazz) {
		this.sntRouteStrategyClazz = sntRouteStrategyClazz;
		this.isInitSntRouteStrategyClazz = true;
	}

	public String getSntRouteType() {
		return sntRouteType;
	}

	public void setSntRouteType(String sntRouteType) {
		this.sntRouteType = sntRouteType;
		this.isInitSntRouteType = true;
	}

	public String getSntBranchStrategy() {
		return sntBranchStrategy;
	}

	public void setSntBranchStrategy(String sntBranchStrategy) {
		this.sntBranchStrategy = sntBranchStrategy;
		this.isInitSntBranchStrategy = true;
	}

	public String getSntBranchStrategyClazz() {
		return sntBranchStrategyClazz;
	}

	public void setSntBranchStrategyClazz(String sntBranchStrategyClazz) {
		this.sntBranchStrategyClazz = sntBranchStrategyClazz;
		this.isInitSntBranchStrategyClazz = true;
	}

	public String getSntIsAuto() {
		return sntIsAuto;
	}

	public void setSntIsAuto(String sntIsAuto) {
		this.sntIsAuto = sntIsAuto;
		this.isInitSntIsAuto = true;
	}

	public String getSntViewUrl() {
		return sntViewUrl;
	}

	public void setSntViewUrl(String sntViewUrl) {
		this.sntViewUrl = sntViewUrl;
		this.isInitSntViewUrl = true;
	}

	public Map<String, String> toMap() {
		Map<String, String> map = new HashMap<String, String>();
		if (isInitSntTemplateCid) {
			map.put("sntTemplateCid", formatString(sntTemplateCid));
		}
		if (isInitSntTemplateName) {
			map.put("sntTemplateName", formatString(sntTemplateName));
		}
		if (isInitSntEntityCid) {
			map.put("sntEntityCid", formatString(sntEntityCid));
		}
		if (isInitSntEventType) {
			map.put("sntEventType", formatString(sntEventType));
		}
		if (isInitSntEventRule) {
			map.put("sntEventRule", formatString(sntEventRule));
		}
		if (isInitSntEventExt) {
			map.put("sntEventExt", formatString(sntEventExt));
		}
		if (isInitSntRecordType) {
			map.put("sntRecordType", formatString(sntRecordType));
		}
		if (isInitSntRouteStrategy) {
			map.put("sntRouteStrategy", formatString(sntRouteStrategy));
		}
		if (isInitSntRouteStrategyClazz) {
			map.put("sntRouteStrategyClazz", formatString(sntRouteStrategyClazz));
		}
		if (isInitSntRouteType) {
			map.put("sntRouteType", formatString(sntRouteType));
		}
		if (isInitSntBranchStrategy) {
			map.put("sntBranchStrategy", formatString(sntBranchStrategy));
		}
		if (isInitSntBranchStrategyClazz) {
			map.put("sntBranchStrategyClazz", formatString(sntBranchStrategyClazz));
		}
		if (isInitSntIsAuto) {
			map.put("sntIsAuto", formatString(sntIsAuto));
		}
		if (isInitSntViewUrl) {
			map.put("sntViewUrl", formatString(sntViewUrl));
		}

		return map;
	}
}
