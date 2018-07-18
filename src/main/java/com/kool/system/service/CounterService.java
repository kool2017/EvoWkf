package com.kool.system.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kool.core.exception.AppException;
import com.kool.core.util.StringUtils;
import com.kool.system.bean.SyCounterBean;
import com.kool.system.bean.io.SYPAGEINFOYBean;
import com.kool.system.bean.vo.PageResult;
import com.kool.system.dao.SyCounterDao;

/**
 * 
 * @DESCRIBE 
 * @AUTHOR LUYU
 * @DATE 2018年7月13日 上午9:27:26
 *
 */
@Service
public class CounterService {
	@Autowired
	private SyCounterDao syCounterDao;

	/**
	 * @DESCRIBE 增加
	 */
	public void add(SyCounterBean syCounter) throws AppException {
		if (null == syCounter) {
			throw new AppException("SY000027");// 输入信息为空
		}
		SyCounterBean counter = syCounterDao.selectByPK(syCounter);
		if (counter != null) {
			throw new AppException("SY000054");// 计数器编码已经存在
		}
		syCounterDao.insert(syCounter);
	}

	/**
	 * @DESCRIBE 修改
	 */
	public void update(SyCounterBean syCounter) throws AppException {
		if (null == syCounter) {
			throw new AppException("SY000027");// 输入信息为空
		}
		syCounterDao.update(syCounter);
	}

	/**
	 * @DESCRIBE 删除
	 */
	public void delete(SyCounterBean syCounter) throws AppException {
		if (null == syCounter) {
			throw new AppException("SY000027");// 输入信息为空
		}
		syCounterDao.delete(syCounter);
	}

	/**
	 * @DESCRIBE 分页查询
	 */
	public PageResult queryPage(SyCounterBean syCounter, SYPAGEINFOYBean pageInfo) {
		int total = syCounterDao.selectTotal(syCounter);

		int currentPage = pageInfo.getCurrentPage();
		int pageSize = pageInfo.getPageSize();
		int offset = (currentPage - 1) * pageSize;
		int pageCount = (total + pageSize - 1) / pageSize;
		List<SyCounterBean> list = syCounterDao.selectPage(syCounter, offset, pageInfo.getPageSize());

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
	public List<SyCounterBean> query(SyCounterBean syCounter) throws AppException {
		if (null == syCounter) {
			syCounter = new SyCounterBean();
		}

		return syCounterDao.select(syCounter);
	}

	public String getNextNumber(String code) throws AppException {
		// 查询并行锁
		SyCounterBean cntInfo = new SyCounterBean();
		cntInfo.setScoCounterCode(code);

		SyCounterBean cnt = syCounterDao.selectByPK(cntInfo);
		if (null == cnt) {
			throw new AppException("SY000009");// 计数器不存在
		}
		syCounterDao.update(cnt);
		// 判断状态

		// 新值=当前值+步长
		String step = cnt.getScoStep();
		String number = cnt.getScoCurValue();
		String newNumber = StringUtils.add(number, step);
		// 如果长度不足，前缀补零
		while (newNumber.length() < cnt.getScoMax().length()) {
			newNumber = "0" + newNumber;
		}
		// 如果新值>最大值，溢出
		if (isOver(newNumber, cnt.getScoMax())) {
			over(cnt);
		} else {
			// 更新计数器
			cnt.setScoCurValue(newNumber);
			syCounterDao.update(cnt);
		}
		// 解锁
		return newNumber;
	}

	/**
	 * @DESCRIBE
	 * @DATE 2018年6月23日 下午10:37:08
	 *
	 * @param cnt
	 */
	private void over(SyCounterBean cnt) {
		// TODO Auto-generated method stub

	}

	/**
	 * @DESCRIBE
	 * @DATE 2018年6月23日 下午10:36:37
	 *
	 * @param number
	 * @param newNumber
	 * @return
	 */
	private boolean isOver(String number, String newNumber) {
		return false;
	}
}
