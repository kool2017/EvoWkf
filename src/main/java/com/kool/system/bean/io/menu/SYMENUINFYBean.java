package com.kool.system.bean.io.menu;

import com.kool.core.base.BaseBean;
import com.kool.core.exception.AppException;
import com.kool.core.util.StringUtils;
import com.kool.core.validate.IIoValidate;

/**
 * @AUTHOR LUYU
 */
public class SYMENUINFYBean extends BaseBean implements IIoValidate {
	protected String menuCode;
	protected String title;
	protected String fatMenu;
	protected String rootMenu;
	protected String deep;
	protected String seq;
	protected String index;
	protected String icon;
	protected String state;

	public String getMenuCode() {
		return menuCode;
	}

	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFatMenu() {
		return fatMenu;
	}

	public void setFatMenu(String fatMenu) {
		this.fatMenu = fatMenu;
	}

	public String getRootMenu() {
		return rootMenu;
	}

	public void setRootMenu(String rootMenu) {
		this.rootMenu = rootMenu;
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

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public void validate() throws AppException {
		//非空校验
		if (StringUtils.isEmpty(menuCode)) {
			throw new AppException("SY000036","menuCode");//字段[%1]为空
		}
		//最小长度校验
		if (menuCode != null && menuCode.length()<8) {
			throw new AppException("SY000037","menuCode",String.valueOf(8));//字段[%1]小于最小长度[%2]
		}
		//最大长度校验
		if (menuCode != null && menuCode.length()>8) {
			throw new AppException("SY000038","menuCode",String.valueOf(8));//字段[%1]大于最大长度[%2]
		}
		//非空校验
		if (StringUtils.isEmpty(title)) {
			throw new AppException("SY000036","title");//字段[%1]为空
		}
		//最大长度校验
		if (title != null && title.length()>60) {
			throw new AppException("SY000038","title",String.valueOf(60));//字段[%1]大于最大长度[%2]
		}
		//最大长度校验
		if (fatMenu != null && fatMenu.length()>8) {
			throw new AppException("SY000038","fatMenu",String.valueOf(8));//字段[%1]大于最大长度[%2]
		}
		//非空校验
		if (StringUtils.isEmpty(rootMenu)) {
			throw new AppException("SY000036","rootMenu");//字段[%1]为空
		}
		//最小长度校验
		if (rootMenu != null && rootMenu.length()<8) {
			throw new AppException("SY000037","rootMenu",String.valueOf(8));//字段[%1]小于最小长度[%2]
		}
		//最大长度校验
		if (rootMenu != null && rootMenu.length()>8) {
			throw new AppException("SY000038","rootMenu",String.valueOf(8));//字段[%1]大于最大长度[%2]
		}
		//非空校验
		if (StringUtils.isEmpty(deep)) {
			throw new AppException("SY000036","deep");//字段[%1]为空
		}
		//非空校验
		if (StringUtils.isEmpty(seq)) {
			throw new AppException("SY000036","seq");//字段[%1]为空
		}
		//最大长度校验
		if (index != null && index.length()>100) {
			throw new AppException("SY000038","index",String.valueOf(100));//字段[%1]大于最大长度[%2]
		}
		//最大长度校验
		if (icon != null && icon.length()>100) {
			throw new AppException("SY000038","icon",String.valueOf(100));//字段[%1]大于最大长度[%2]
		}
		//非空校验
		if (StringUtils.isEmpty(state)) {
			throw new AppException("SY000036","state");//字段[%1]为空
		}
	}
}