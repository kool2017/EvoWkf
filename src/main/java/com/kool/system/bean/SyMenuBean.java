package com.kool.system.bean;

import java.util.HashMap;
import java.util.Map;
import com.kool.core.base.BaseBean;

/**
 * @AUTHOR LUYU
 */
public class SyMenuBean extends BaseBean {
	protected String smeMenuCode;
	protected boolean isInitSmeMenuCode;
	protected String smeTitle;
	protected boolean isInitSmeTitle;
	protected String smeFatMenu;
	protected boolean isInitSmeFatMenu;
	protected String smeRootMenu;
	protected boolean isInitSmeRootMenu;
	protected int smeDeep;
	protected boolean isInitSmeDeep;
	protected int smeSeq;
	protected boolean isInitSmeSeq;
	protected String smeIndex;
	protected boolean isInitSmeIndex;
	protected String smeState;
	protected boolean isInitSmeState;
	protected String smeIcon;
	protected boolean isInitSmeIcon;

	public boolean getIsInitSmeMenuCode() {
		return this.isInitSmeMenuCode;
	}

	public boolean getIsInitSmeTitle() {
		return this.isInitSmeTitle;
	}

	public boolean getIsInitSmeFatMenu() {
		return this.isInitSmeFatMenu;
	}

	public boolean getIsInitSmeRootMenu() {
		return this.isInitSmeRootMenu;
	}

	public boolean getIsInitSmeDeep() {
		return this.isInitSmeDeep;
	}

	public boolean getIsInitSmeSeq() {
		return this.isInitSmeSeq;
	}

	public boolean getIsInitSmeIndex() {
		return this.isInitSmeIndex;
	}

	public boolean getIsInitSmeState() {
		return this.isInitSmeState;
	}

	public boolean getIsInitSmeIcon() {
		return this.isInitSmeIcon;
	}

	public String getSmeMenuCode() {
		return smeMenuCode;
	}

	public void setSmeMenuCode(String smeMenuCode) {
		this.smeMenuCode = smeMenuCode;
		this.isInitSmeMenuCode = true;
	}

	public String getSmeTitle() {
		return smeTitle;
	}

	public void setSmeTitle(String smeTitle) {
		this.smeTitle = smeTitle;
		this.isInitSmeTitle = true;
	}

	public String getSmeFatMenu() {
		return smeFatMenu;
	}

	public void setSmeFatMenu(String smeFatMenu) {
		this.smeFatMenu = smeFatMenu;
		this.isInitSmeFatMenu = true;
	}

	public String getSmeRootMenu() {
		return smeRootMenu;
	}

	public void setSmeRootMenu(String smeRootMenu) {
		this.smeRootMenu = smeRootMenu;
		this.isInitSmeRootMenu = true;
	}

	public int getSmeDeep() {
		return smeDeep;
	}

	public void setSmeDeep(int smeDeep) {
		this.smeDeep = smeDeep;
		this.isInitSmeDeep = true;
	}

	public int getSmeSeq() {
		return smeSeq;
	}

	public void setSmeSeq(int smeSeq) {
		this.smeSeq = smeSeq;
		this.isInitSmeSeq = true;
	}

	public String getSmeIndex() {
		return smeIndex;
	}

	public void setSmeIndex(String smeIndex) {
		this.smeIndex = smeIndex;
		this.isInitSmeIndex = true;
	}

	public String getSmeState() {
		return smeState;
	}

	public void setSmeState(String smeState) {
		this.smeState = smeState;
		this.isInitSmeState = true;
	}

	public String getSmeIcon() {
		return smeIcon;
	}

	public void setSmeIcon(String smeIcon) {
		this.smeIcon = smeIcon;
		this.isInitSmeIcon = true;
	}

	public Map<String, String> toMap() {
		Map<String, String> map = new HashMap<String, String>();
		if (isInitSmeMenuCode) {
			map.put("smeMenuCode", formatString(smeMenuCode));
		}
		if (isInitSmeTitle) {
			map.put("smeTitle", formatString(smeTitle));
		}
		if (isInitSmeFatMenu) {
			map.put("smeFatMenu", formatString(smeFatMenu));
		}
		if (isInitSmeRootMenu) {
			map.put("smeRootMenu", formatString(smeRootMenu));
		}
		if (isInitSmeDeep) {
			map.put("smeDeep", formatString(smeDeep));
		}
		if (isInitSmeSeq) {
			map.put("smeSeq", formatString(smeSeq));
		}
		if (isInitSmeIndex) {
			map.put("smeIndex", formatString(smeIndex));
		}
		if (isInitSmeState) {
			map.put("smeState", formatString(smeState));
		}
		if (isInitSmeIcon) {
			map.put("smeIcon", formatString(smeIcon));
		}

		return map;
	}

	public static SyMenuBean DBResultToBean(Map<String, Object> map) {
		if (null == map) {
			return null;
		}
		SyMenuBean reqDef = new SyMenuBean();
		reqDef.setSmeMenuCode((String) map.get("SME_MENU_CODE"));
		reqDef.setSmeTitle((String) map.get("SME_TITLE"));
		reqDef.setSmeFatMenu((String) map.get("SME_FAT_MENU"));
		reqDef.setSmeRootMenu((String) map.get("SME_ROOT_MENU"));
		reqDef.setSmeDeep((int) map.get("SME_DEEP"));
		reqDef.setSmeSeq((int) map.get("SME_SEQ"));
		reqDef.setSmeIndex((String) map.get("SME_INDEX"));
		reqDef.setSmeState((String) map.get("SME_STATE"));
		reqDef.setSmeIcon((String) map.get("SME_ICON"));
		return reqDef;
	}
}