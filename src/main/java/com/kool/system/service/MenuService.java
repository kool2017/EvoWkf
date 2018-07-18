/**
 * @PROJECT 
 * @DATE 2018年6月15日 下午3:58:11
 * @AUTHOR LUYU
 */
package com.kool.system.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kool.core.CoreConstants;
import com.kool.core.cache.KCache;
import com.kool.core.exception.AppException;
import com.kool.system.bean.SyMenuAutBean;
import com.kool.system.bean.SyMenuBean;
import com.kool.system.bean.io.SYPAGEINFOYBean;
import com.kool.system.bean.vo.MenuVo;
import com.kool.system.bean.vo.PageResult;
import com.kool.system.dao.SyMenuAutDao;
import com.kool.system.dao.SyMenuDao;

/**
 * @DESCRIBE
 * @AUTHOR LUYU
 * @DATE 2018年6月15日 下午3:58:11
 *
 */
@Service("MenuServicce")
public class MenuService {
	private static Logger logger = Logger.getLogger(MenuService.class);

	@Autowired
	private SyMenuDao menuDao;

	@Autowired
	private SyMenuAutDao menuAutDao;

	/**
	 * 
	 * @DESCRIBE 获取所有菜单
	 * @DATE 2018年6月15日 下午4:27:40
	 *
	 * @return
	 * @throws AppException
	 */
	public List<MenuVo> getAllMenu() throws AppException {
		List<SyMenuBean> listMenu = menuDao.selectAllAndOrder();

		List<MenuVo> listMenuVo = new ArrayList<>();
		for (SyMenuBean menuBean : listMenu) {
			MenuVo menuVo = new MenuVo();
			menuVo.setIcon(menuBean.getSmeIcon());
			menuVo.setIndex(menuBean.getSmeIndex());
			menuVo.setTitle(menuBean.getSmeTitle());
			menuVo.setSubMenus(getSubMenus(menuBean, listMenu));
			if (menuBean.getSmeDeep() == 0) {
				listMenuVo.add(menuVo);
			}
		}
		return listMenuVo;
	}

	/**
	 * @DESCRIBE
	 * @DATE 2018年6月15日 下午4:21:47
	 *
	 * @param menuBean
	 * @param listMenu
	 * @return
	 * @throws AppException
	 */
	private List<MenuVo> getSubMenus(SyMenuBean menu, List<SyMenuBean> listMenu) throws AppException {
		if (null == menu) {
			throw new AppException("SY000010");// 加载菜单异常
		}
		List<MenuVo> listSub = null;
		for (SyMenuBean item : listMenu) {
			if (menu.getSmeMenuCode() != null && menu.getSmeMenuCode().equals(item.getSmeFatMenu())) {
				if (null == listSub) {
					listSub = new ArrayList<>();
				}
				MenuVo subMenu = new MenuVo();
				subMenu.setIcon(item.getSmeIcon());
				subMenu.setIndex(item.getSmeIndex());
				subMenu.setTitle(item.getSmeTitle());
				if (item.getSmeDeep() == 1) {
					subMenu.setItemGroups(getSubMenus(item, listMenu));
				} else if (item.getSmeDeep() == 2) {
					subMenu.setItems(getSubMenus(item, listMenu));
				}
				listSub.add(subMenu);
			}
		}
		return listSub;
	}

	/**
	 * 
	 * @DESCRIBE 查询菜单树
	 * @DATE 2018年7月6日 下午2:02:36
	 *
	 * @return
	 * @throws AppException
	 */
	public List<MenuVo> queryMenuTree() throws AppException {
		List<SyMenuBean> listMenu = menuDao.selectAllAndOrder();

		List<MenuVo> listMenuVo = new ArrayList<>();
		for (SyMenuBean menuBean : listMenu) {
			MenuVo menuVo = new MenuVo();
			menuVo.setIcon(menuBean.getSmeIcon());
			menuVo.setIndex(menuBean.getSmeIndex());
			menuVo.setTitle(menuBean.getSmeTitle());
			menuVo.setDeep(menuBean.getSmeDeep());
			menuVo.setMenuCode(menuBean.getSmeMenuCode());
			menuVo.setRootMenu(menuBean.getSmeRootMenu());
			menuVo.setSeq(menuBean.getSmeSeq());
			menuVo.setState(menuBean.getSmeState());
			menuVo.setFatMenu(menuBean.getSmeFatMenu());
			listMenuVo.add(menuVo);
		}
		return listMenuVo;
	}

	/**
	 * 
	 * @DESCRIBE 取子树
	 * @DATE 2018年7月6日 下午2:07:59
	 *
	 * @param menu
	 *            父节点
	 * @param listMenu
	 *            所有菜单
	 * @return
	 * @throws AppException
	 */
	@SuppressWarnings("unused")
	private List<MenuVo> getSubTree(SyMenuBean menu, List<SyMenuBean> listMenu) throws AppException {
		if (null == menu) {
			throw new AppException("SY000010");// 加载菜单异常
		}
		List<MenuVo> listSub = null;
		for (SyMenuBean item : listMenu) {
			if (menu.getSmeMenuCode() != null && menu.getSmeMenuCode().equals(item.getSmeFatMenu())) {
				if (null == listSub) {
					listSub = new ArrayList<>();
				}
				MenuVo subMenu = new MenuVo();
				subMenu.setIcon(item.getSmeIcon());
				subMenu.setIndex(item.getSmeIndex());
				subMenu.setTitle(item.getSmeTitle());
				subMenu.setDeep(item.getSmeDeep());
				subMenu.setMenuCode(item.getSmeMenuCode());
				subMenu.setRootMenu(item.getSmeRootMenu());
				subMenu.setSeq(item.getSmeSeq());
				subMenu.setState(item.getSmeState());
				subMenu.setFatMenu(item.getSmeFatMenu());
				subMenu.setSubMenus(getSubTree(item, listMenu));
				listSub.add(subMenu);
			}
		}

		return listSub;
	}

	/**
	 * @DESCRIBE 增加菜单
	 * @DATE 2018年7月7日 下午7:01:08
	 *
	 * @param menuInfo
	 * @throws AppException
	 */
	public void add(SyMenuBean menuInfo) throws AppException {
		if (null == menuInfo) {
			throw new AppException("SY000014");// 增加菜单出错，菜单信息为空
		}

		SyMenuBean menu = menuDao.selectByPK(menuInfo);
		if (menu != null) {
			throw new AppException("SY000043");// 菜单码已经存在
		}
		menuDao.insert(menuInfo);

		// 刷新缓存
		KCache.refresh(CoreConstants.KCACHE_MENU);
	}

	/**
	 * 
	 * @DESCRIBE 修改菜单
	 * @DATE 2018年7月7日 下午7:42:32
	 *
	 * @param menuInfo
	 * @throws AppException
	 */
	public void update(SyMenuBean menuInfo) throws AppException {
		if (null == menuInfo) {
			throw new AppException("SY000016");// 修改菜单出错，菜单信息为空
		}
		menuDao.update(menuInfo);
		// 刷新缓存
		KCache.refresh(CoreConstants.KCACHE_MENU);
	}

	/**
	 * 
	 * @DESCRIBE 删除菜单
	 * @DATE 2018年7月7日 下午7:43:44
	 *
	 * @param menuInfo
	 * @throws AppException
	 */
	public void delete(SyMenuBean menuInfo) throws AppException {
		if (null == menuInfo) {
			throw new AppException("SY000017");// 删除菜单出错，菜单信息为空
		}
		// 同时删除请求权限关联关系
		SyMenuAutBean menuAut = new SyMenuAutBean();
		menuAut.setSmaMenuCode(menuInfo.getSmeMenuCode());
		menuAutDao.deletes(menuAut);

		logger.debug(menuInfo.toString());
		menuDao.delete(menuInfo);

		// 刷新缓存
		KCache.refresh(CoreConstants.KCACHE_MENU);
		KCache.refresh(CoreConstants.KCACHE_USER_MENU);
	}

	/**
	 * @DESCRIBE 分页查询
	 */
	public PageResult queryPage(SyMenuBean syMenu, SYPAGEINFOYBean pageInfo) {
		int total = menuDao.selectTotal(syMenu);

		int currentPage = pageInfo.getCurrentPage();
		int pageSize = pageInfo.getPageSize();
		int offset = (currentPage - 1) * pageSize;
		int pageCount = (total + pageSize - 1) / pageSize;
		List<SyMenuBean> list = menuDao.selectPage(syMenu, offset, pageInfo.getPageSize());

		pageInfo.setTotal(total);
		pageInfo.setPageCount(pageCount);

		PageResult pageResult = new PageResult();
		pageResult.setListBusinessValue(new ArrayList<>(list));
		pageResult.setPageInfo(pageInfo);
		return pageResult;
	}

	/**
	 * @DESCRIBE 查询
	 */
	public List<SyMenuBean> query(SyMenuBean syMenu) throws AppException {
		if (null == syMenu) {
			syMenu = new SyMenuBean();
		}

		return menuDao.select(syMenu);
	}
}
