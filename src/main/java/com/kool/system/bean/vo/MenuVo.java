/**
 * @PROJECT 
 * @DATE 2018年6月15日 下午3:10:35
 * @AUTHOR LUYU
 */
package com.kool.system.bean.vo;

import java.util.List;

import com.kool.core.base.BaseBean;

/**
 * @DESCRIBE
 * @AUTHOR LUYU
 * @DATE 2018年6月15日 下午3:10:35
 *
 */
public class MenuVo extends BaseBean {
	private String icon;
	private String index;
	private String title;
	private List<MenuVo> subMenus;
	private List<MenuVo> itemGroups;
	private List<MenuVo> items;
	protected String menuCode;
	protected String fatMenu;
	protected String rootMenu;
	protected int deep;
	protected int seq;
	protected String state;

	/**
	 * @return the icon
	 */
	public String getIcon() {
		return icon;
	}

	/**
	 * @param icon
	 *            the icon to set
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}

	/**
	 * @return the index
	 */
	public String getIndex() {
		return index;
	}

	/**
	 * @param index
	 *            the index to set
	 */
	public void setIndex(String index) {
		this.index = index;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the subMenus
	 */
	public List<MenuVo> getSubMenus() {
		return subMenus;
	}

	/**
	 * @param subMenus
	 *            the subMenus to set
	 */
	public void setSubMenus(List<MenuVo> subMenus) {
		this.subMenus = subMenus;
	}

	/**
	 * @return the itemGroups
	 */
	public List<MenuVo> getItemGroups() {
		return itemGroups;
	}

	/**
	 * @param itemGroups the itemGroups to set
	 */
	public void setItemGroups(List<MenuVo> itemGroups) {
		this.itemGroups = itemGroups;
	}

	/**
	 * @return the items
	 */
	public List<MenuVo> getItems() {
		return items;
	}

	/**
	 * @param items the items to set
	 */
	public void setItems(List<MenuVo> items) {
		this.items = items;
	}

	public String getMenuCode() {
		return menuCode;
	}

	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
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

	public int getDeep() {
		return deep;
	}

	public void setDeep(int deep) {
		this.deep = deep;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
