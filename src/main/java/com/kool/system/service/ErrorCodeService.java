package com.kool.system.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kool.core.CoreConstants;
import com.kool.core.cache.KCache;
import com.kool.core.exception.AppException;
import com.kool.system.bean.SyErrorInfoBean;
import com.kool.system.bean.io.SYPAGEINFOYBean;
import com.kool.system.bean.vo.PageResult;
import com.kool.system.dao.SyErrorInfoDao;

/**
 * @AUTHOR LUYU
 */
@Service
public class ErrorCodeService {
	private static Logger logger = Logger.getLogger(ErrorCodeService.class);

	@Autowired
	private SyErrorInfoDao syErrorInfoDao;

	/**
	 * @DESCRIBE 增加
	 */
	public void add(SyErrorInfoBean syErrorInfo) throws AppException {
		if (null == syErrorInfo) {
			throw new AppException("SY000027");// 输入信息为空
		}
		SyErrorInfoBean errorInfo = syErrorInfoDao.selectByPK(syErrorInfo);
		if (errorInfo != null) {
			throw new AppException("SY000052");// 错误码已经存在
		}

		logger.debug(syErrorInfo.toString());
		syErrorInfoDao.insert(syErrorInfo);

		// 刷新缓存
		KCache.refresh(CoreConstants.KCACHE_ERRCOD);
	}

	/**
	 * @DESCRIBE 修改
	 */
	public void update(SyErrorInfoBean syErrorInfo) throws AppException {
		if (null == syErrorInfo) {
			throw new AppException("SY000027");// 输入信息为空
		}
		logger.debug(syErrorInfo.toString());
		syErrorInfoDao.update(syErrorInfo);

		// 刷新缓存
		KCache.refresh(CoreConstants.KCACHE_ERRCOD);
	}

	/**
	 * @DESCRIBE 删除
	 */
	public void delete(SyErrorInfoBean syErrorInfo) throws AppException {
		if (null == syErrorInfo) {
			throw new AppException("SY000027");// 输入信息为空
		}
		logger.debug(syErrorInfo.toString());
		syErrorInfoDao.delete(syErrorInfo);

		// 刷新缓存
		KCache.refresh(CoreConstants.KCACHE_ERRCOD);
	}

	/**
	 * @DESCRIBE 分页查询
	 */
	public PageResult queryPage(SyErrorInfoBean syErrorInfo, SYPAGEINFOYBean pageInfo) {
		logger.debug(syErrorInfo.toString());
		int total = syErrorInfoDao.selectTotal(syErrorInfo);

		int currentPage = pageInfo.getCurrentPage();
		int pageSize = pageInfo.getPageSize();
		int offset = (currentPage - 1) * pageSize;
		int pageCount = (total + pageSize - 1) / pageSize;
		List<SyErrorInfoBean> list = syErrorInfoDao.selectPage(syErrorInfo, offset, pageInfo.getPageSize());

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
	public List<SyErrorInfoBean> query(SyErrorInfoBean syErrorInfo) throws AppException {
		if (null == syErrorInfo) {
			syErrorInfo = new SyErrorInfoBean();
		}

		logger.debug(syErrorInfo.toString());
		return syErrorInfoDao.select(syErrorInfo);
	}
}
