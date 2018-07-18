/**
 * @PROJECT 
 * @DATE 2018年2月18日 下午8:23:51
 * @AUTHOR LUYU
 */
package com.kool.system.wkfhandler;

import java.util.List;

import com.kool.core.exception.AppException;
import com.kool.core.util.SecurityUtils;
import com.kool.core.util.SpringContextUtil;
import com.kool.evowkf.api.IBusinessEventHandler;
import com.kool.evowkf.bean.vo.BusinessEvent;
import com.kool.system.bean.SyUserTradeBean;
import com.kool.system.bean.io.SYREGINFXBean;
import com.kool.system.dao.SyUserTradeDao;
import com.kool.system.service.UserService;

/**
 * @DESCRIBE 工作流结点事件，用户管理审批
 * @AUTHOR LUYU
 * @DATE 2018年2月18日 下午8:23:51
 *
 */
public class UserManagerApproveHandler implements IBusinessEventHandler {

	/**
	 * @DESCRIBE
	 * @DATE 2018年2月18日 下午8:24:06
	 *
	 * @param event
	 * @throws AppException
	 */
	@Override
	public void handle(BusinessEvent event) throws AppException {
		String recordId = event.getRecordId();
		String approveFlag = event.getApproveFlag();
		// 根据记录编号，查询用户管理交易
		SyUserTradeBean tradeInfo = new SyUserTradeBean();
		tradeInfo.setSutWkfNbr(recordId);
		SyUserTradeDao tradeDao = (SyUserTradeDao) SpringContextUtil.getBean("SyUserTradeDao");
		List<SyUserTradeBean> listTrade = tradeDao.select(tradeInfo);
		if (listTrade == null || listTrade.size() <= 0) {
			throw new AppException("查询用户管理交易信息结果为空");
		}
		SyUserTradeBean trade = listTrade.get(0);
		if ("Y".equals(approveFlag)) {
			trade.setSutState("S");// 交易状态=成功

			// 注册新用户，初始密码=用户名
			UserService userService = (UserService) SpringContextUtil.getBean("UserService");
			SYREGINFXBean regInf = new SYREGINFXBean();
			regInf.setSuiLoginName(trade.getSutLoginName());
			regInf.setSuiPwd(SecurityUtils.base64Encode(trade.getSutLoginName()));
			regInf.setSuiPwdC(SecurityUtils.base64Encode(trade.getSutLoginName()));
//			regInf.setSuiHasKey(trade.);
			userService.register(regInf);
		} else if ("N".equals(approveFlag)) {
			trade.setSutState("F");
		} else {
			throw new AppException("审批标志错误");
		}
		tradeDao.update(trade);
	}

}
