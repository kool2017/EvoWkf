package com.kool.system.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kool.core.CoreConstants;
import com.kool.core.cache.KCache;
import com.kool.core.exception.AppException;
import com.kool.system.bean.SyReqAutBean;
import com.kool.system.bean.SyReqDefBean;
import com.kool.system.bean.io.SYPAGEINFOYBean;
import com.kool.system.bean.vo.PageResult;
import com.kool.system.dao.SyReqAutDao;
import com.kool.system.dao.SyReqDefDao;

/**
 * @AUTHOR LUYU
 */
@Service
public class ReqService {
	private static Logger logger = Logger.getLogger(ReqService.class);

	@Autowired
	private SyReqDefDao syReqDefDao;

	@Autowired
	private SyReqAutDao syReqAutDao;

	/**
	 * @DESCRIBE 增加
	 */
	public void add(SyReqDefBean syReqDef) throws AppException {
		if (null == syReqDef) {
			throw new AppException("SY000027");// 输入信息为空
		}
		SyReqDefBean req = syReqDefDao.selectByPK(syReqDef);
		if (req != null) {
			throw new AppException("SY000044");// 请求URL已经存在
		}
		logger.debug(syReqDef.toString());
		syReqDefDao.insert(syReqDef);

		// 刷新缓存
		KCache.refresh(CoreConstants.KCACHE_REQ);
	}

	/**
	 * @DESCRIBE 修改
	 */
	public void update(SyReqDefBean syReqDef) throws AppException {
		if (null == syReqDef) {
			throw new AppException("SY000027");// 输入信息为空
		}
		logger.debug(syReqDef.toString());
		syReqDefDao.update(syReqDef);

		// 刷新缓存
		KCache.refresh(CoreConstants.KCACHE_REQ);
	}

	/**
	 * @DESCRIBE 删除
	 */
	public void delete(SyReqDefBean syReqDef) throws AppException {
		if (null == syReqDef) {
			throw new AppException("SY000027");// 输入信息为空
		}
		// 同时删除请求权限关联关系
		SyReqAutBean reqAut = new SyReqAutBean();
		reqAut.setSraReqUrl(syReqDef.getSrdReqUrl());
		logger.debug(reqAut.toString());
		syReqAutDao.deletes(reqAut);

		logger.debug(syReqDef.toString());
		syReqDefDao.delete(syReqDef);

		// 刷新缓存
		KCache.refresh(CoreConstants.KCACHE_REQ);
		KCache.refresh(CoreConstants.KCACHE_USER_REQ);
	}

	/**
	 * @DESCRIBE 分页查询
	 */
	public PageResult queryPage(SyReqDefBean syReqDef, SYPAGEINFOYBean pageInfo) {
		logger.debug(syReqDef.toString());
		int total = syReqDefDao.selectTotal(syReqDef);

		int currentPage = pageInfo.getCurrentPage();
		int pageSize = pageInfo.getPageSize();
		int offset = (currentPage - 1) * pageSize;
		int pageCount = (total + pageSize - 1) / pageSize;
		List<SyReqDefBean> list = syReqDefDao.selectPage(syReqDef, offset, pageInfo.getPageSize());

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
	public List<SyReqDefBean> query(SyReqDefBean syReqDef) throws AppException {
		if (null == syReqDef) {
			syReqDef = new SyReqDefBean();
		}

		logger.debug(syReqDef.toString());
		return syReqDefDao.select(syReqDef);
	}
}
