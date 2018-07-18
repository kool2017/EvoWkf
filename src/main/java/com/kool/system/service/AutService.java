package com.kool.system.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kool.core.CoreConstants;
import com.kool.core.cache.KCache;
import com.kool.core.exception.AppException;
import com.kool.core.util.StringUtils;
import com.kool.system.bean.SyAutDefBean;
import com.kool.system.bean.SyMenuAutBean;
import com.kool.system.bean.SyMenuBean;
import com.kool.system.bean.SyReqAutBean;
import com.kool.system.bean.SyReqDefBean;
import com.kool.system.bean.SyRoleAutBean;
import com.kool.system.bean.SyRoleGroupAutBean;
import com.kool.system.bean.SyUserAutBean;
import com.kool.system.bean.io.SYPAGEINFOYBean;
import com.kool.system.bean.vo.PageResult;
import com.kool.system.dao.SyAutDefDao;
import com.kool.system.dao.SyMenuAutDao;
import com.kool.system.dao.SyReqAutDao;
import com.kool.system.dao.SyRoleAutDao;
import com.kool.system.dao.SyRoleGroupAutDao;
import com.kool.system.dao.SyUserAutDao;

/**
 * @AUTHOR LUYU
 */
@Service
public class AutService {
	private static Logger logger = Logger.getLogger(AutService.class);

	@Autowired
	private SyAutDefDao syAutDefDao;

	@Autowired
	private SyUserAutDao userAutDao;

	@Autowired
	private SyRoleAutDao roleAutDao;

	@Autowired
	private SyRoleGroupAutDao groupAutDao;

	@Autowired
	private SyMenuAutDao menuAutDao;

	@Autowired
	private SyReqAutDao reqAutDao;

	/**
	 * @DESCRIBE 增加
	 */
	public void add(SyAutDefBean syAutDef) throws AppException {
		if (null == syAutDef) {
			throw new AppException("SY000027");// 输入信息为空
		}
		SyAutDefBean aut = syAutDefDao.selectByPK(syAutDef);
		if (aut != null) {
			throw new AppException("SY000053");// 权限码已经存在
		}
		logger.debug(syAutDef.toString());
		syAutDefDao.insert(syAutDef);
	}

	/**
	 * @DESCRIBE 修改
	 */
	public void update(SyAutDefBean syAutDef) throws AppException {
		if (null == syAutDef) {
			throw new AppException("SY000027");// 输入信息为空
		}
		logger.debug(syAutDef.toString());
		syAutDefDao.update(syAutDef);
	}

	/**
	 * @DESCRIBE 删除
	 */
	public void delete(SyAutDefBean syAutDef) throws AppException {
		if (null == syAutDef) {
			throw new AppException("SY000026");// 权限信息为空
		}
		String autCode = syAutDef.getSadAutCode();

		// 查询用户权限关联
		SyUserAutBean userAut = new SyUserAutBean();
		userAut.setSuaAutCode(autCode);
		int count = userAutDao.selectTotal(userAut);
		if (count > 0) {
			throw new AppException("SY000030", autCode);// 权限[%1]已使用，无法删除，请先取消用户权限关联
		}

		// 查询角色权限关联
		SyRoleAutBean roleAut = new SyRoleAutBean();
		roleAut.setSraAutCode(autCode);
		count = roleAutDao.selectTotal(roleAut);
		if (count > 0) {
			throw new AppException("SY000031", autCode);// 权限[%1]已使用，无法删除，请先取消角色权限关联
		}

		// 查询角色组权限关联
		SyRoleGroupAutBean roleGroupAut = new SyRoleGroupAutBean();
		roleGroupAut.setSgaAutCode(autCode);
		count = groupAutDao.selectTotal(roleGroupAut);
		if (count > 0) {
			throw new AppException("SY000032", autCode);// 权限[%1]已使用，无法删除，请先取消角色组权限关联
		}

		// 删除菜单权限关联
		SyMenuAutBean menuAut = new SyMenuAutBean();
		menuAut.setSmaAutCode(autCode);
		menuAutDao.deletes(menuAut);
		// 查询菜单权限关联
		// count = menuAutDao.selectTotal(menuAut);
		// if (count > 0) {
		// throw new AppException("SY000033", autCode);// 权限[%1]已使用，无法删除，请先取消菜单权限关联
		// }

		// 删除请求权限关联
		SyReqAutBean reqAut = new SyReqAutBean();
		reqAut.setSraAutCode(autCode);
		reqAutDao.deletes(reqAut);
		// 查询请求权限关联
		// count = reqAutDao.selectTotal(reqAut);
		// if (count > 0) {
		// throw new AppException("SY000034", autCode);// 权限[%1]已使用，无法删除，请先取消请求权限关联
		// }

		logger.debug(syAutDef.toString());
		syAutDefDao.delete(syAutDef);
	}

	/**
	 * @DESCRIBE 分页查询
	 */
	public PageResult queryPage(SyAutDefBean syAutDef, SYPAGEINFOYBean pageInfo) {
		logger.debug(syAutDef.toString());
		int total = syAutDefDao.selectTotal(syAutDef);

		int currentPage = pageInfo.getCurrentPage();
		int pageSize = pageInfo.getPageSize();
		int offset = (currentPage - 1) * pageSize;
		int pageCount = (total + pageSize - 1) / pageSize;
		List<SyAutDefBean> list = syAutDefDao.selectPage(syAutDef, offset, pageInfo.getPageSize());

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
	public List<SyAutDefBean> query(SyAutDefBean syAutDef) throws AppException {
		if (null == syAutDef) {
			syAutDef = new SyAutDefBean();
		}

		logger.debug(syAutDef.toString());
		return syAutDefDao.select(syAutDef);
	}

	/**
	 * @DESCRIBE 查询权限绑定的菜单
	 * @DATE 2018年7月13日 下午11:42:00
	 *
	 * @param autCode
	 * @return
	 * @throws AppException
	 */
	public List<SyMenuAutBean> queryAutMenu(String autCode) throws AppException {
		if (StringUtils.isEmpty(autCode)) {
			throw new AppException("SY000026");// 权限信息为空
		}

		SyMenuAutBean menuAut = new SyMenuAutBean();
		menuAut.setSmaAutCode(autCode);
		List<SyMenuAutBean> list = menuAutDao.select(menuAut);
		return list;
	}

	/**
	 * @DESCRIBE 查询权限绑定的请求
	 * @DATE 2018年7月14日 上午12:13:49
	 *
	 * @param autCode
	 * @return
	 * @throws AppException
	 */
	public List<SyReqAutBean> queryAutReq(String autCode) throws AppException {
		if (StringUtils.isEmpty(autCode)) {
			throw new AppException("SY000026");// 权限信息为空
		}

		SyReqAutBean reqAut = new SyReqAutBean();
		reqAut.setSraAutCode(autCode);
		List<SyReqAutBean> list = reqAutDao.select(reqAut);
		return list;
	}

	/**
	 * @DESCRIBE 绑定菜单
	 * @DATE 2018年7月14日 上午12:55:45
	 *
	 * @param autCode
	 * @param listIn
	 * @throws AppException
	 */
	public void bindMenu(String autCode, List<SyMenuAutBean> listIn) throws AppException {
		if (StringUtils.isEmpty(autCode)) {
			throw new AppException("SY000048");// 权限码为空
		}
		SyMenuAutBean info = new SyMenuAutBean();
		info.setSmaAutCode(autCode);
		menuAutDao.deletes(info);

		// 加备注，格式：权限名称-菜单名称
		SyAutDefBean aut = (SyAutDefBean) KCache.get(CoreConstants.KCACHE_AUT, autCode);
		for (SyMenuAutBean menuAut : listIn) {
			SyMenuBean menu = (SyMenuBean) KCache.get(CoreConstants.KCACHE_MENU, menuAut.getSmaMenuCode());
			menuAut.setSmaCmt(
					new StringBuilder().append(aut.getSadName()).append("-").append(menu.getSmeTitle()).toString());
		}
		if (listIn != null && listIn.size() > 0) {
			menuAutDao.insertBatch(listIn);
		}

		// 刷新缓存
		KCache.refresh(CoreConstants.KCACHE_USER_MENU);
	}

	/**
	 * @DESCRIBE 绑定请求
	 * @DATE 2018年7月14日 上午12:59:23
	 *
	 * @param autCode
	 * @param listIn
	 * @throws AppException
	 */
	public void bindReq(String autCode, List<SyReqAutBean> listIn) throws AppException {
		if (StringUtils.isEmpty(autCode)) {
			throw new AppException("SY000048");// 权限码为空
		}
		SyReqAutBean info = new SyReqAutBean();
		info.setSraAutCode(autCode);
		reqAutDao.deletes(info);

		// 加备注，格式：权限名称-请求名称
		SyAutDefBean aut = (SyAutDefBean) KCache.get(CoreConstants.KCACHE_AUT, autCode);
		if (listIn != null && listIn.size() > 0) {
			for (SyReqAutBean reqAut : listIn) {
				SyReqDefBean req = (SyReqDefBean) KCache.get(CoreConstants.KCACHE_REQ, reqAut.getSraReqUrl());
				reqAut.setSraCmt(
						new StringBuilder().append(aut.getSadName()).append("-").append(req.getSrdName()).toString());
			}
			reqAutDao.insertBatch(listIn);
		}

		// 刷新缓存
		KCache.refresh(CoreConstants.KCACHE_USER_REQ);
	}
}
