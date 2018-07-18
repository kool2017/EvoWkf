package com.kool.system.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kool.core.CoreConstants;
import com.kool.core.cache.KCache;
import com.kool.core.exception.AppException;
import com.kool.system.bean.SyParamBean;
import com.kool.system.bean.io.SYPAGEINFOYBean;
import com.kool.system.bean.vo.PageResult;
import com.kool.system.dao.SyParamDao;

/**
 * @AUTHOR LUYU
 */
@Service
public class ParamService {
	private static Logger logger = Logger.getLogger(ParamService.class);

	@Autowired
	private SyParamDao syParamDao;

	/**
	 * @DESCRIBE 增加
	 */
	public void add(SyParamBean syParam) throws AppException {
		if (null == syParam) {
			throw new AppException("SY000027");// 输入信息为空
		}
		// 主键冲突校验
		SyParamBean param = syParamDao.selectByPK(syParam);
		if (param != null) {
			throw new AppException("SY000041");// 参数码已经存在
		}
		logger.debug(syParam.toString());
		syParamDao.insert(syParam);

		// 刷新缓存
		KCache.refresh(CoreConstants.KCACHE_PARAM);
	}

	/**
	 * @DESCRIBE 修改
	 */
	public void update(SyParamBean syParam) throws AppException {
		if (null == syParam) {
			throw new AppException("SY000027");// 输入信息为空
		}
		logger.debug(syParam.toString());
		syParamDao.update(syParam);
		// 刷新缓存
		KCache.refresh(CoreConstants.KCACHE_PARAM);
	}

	/**
	 * @DESCRIBE 删除
	 */
	public void delete(SyParamBean syParam) throws AppException {
		if (null == syParam) {
			throw new AppException("SY000027");// 输入信息为空
		}
		logger.debug(syParam.toString());
		syParamDao.delete(syParam);
		// 刷新缓存
		KCache.refresh(CoreConstants.KCACHE_PARAM);
	}

	/**
	 * @DESCRIBE 分页查询
	 */
	public PageResult queryPage(SyParamBean syParam, SYPAGEINFOYBean pageInfo) {
		logger.debug(syParam.toString());
		int total = syParamDao.selectTotal(syParam);

		int currentPage = pageInfo.getCurrentPage();
		int pageSize = pageInfo.getPageSize();
		int offset = (currentPage - 1) * pageSize;
		int pageCount = (total + pageSize - 1) / pageSize;
		List<SyParamBean> list = syParamDao.selectPage(syParam, offset, pageInfo.getPageSize());

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
	public List<SyParamBean> query(SyParamBean syParam) throws AppException {
		if (null == syParam) {
			syParam = new SyParamBean();
		}

		logger.debug(syParam.toString());
		return syParamDao.select(syParam);
	}
}
