/**
 * @PROJECT 
 * @DATE 2017年12月27日 下午10:55:16
 * @AUTHOR LUYU
 */
package com.kool.system.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.kool.core.context.ContextHolder;
import com.kool.core.context.LoginInfo;
import com.kool.core.exception.AppException;
import com.kool.core.exception.BusException;
import com.kool.core.util.SecurityUtils;
import com.kool.core.util.StringUtils;
import com.kool.evowkf.api.IEvoWkfApi;
import com.kool.evowkf.api.SimpleApiImp;
import com.kool.evowkf.bean.vo.BusinessValue;
import com.kool.evowkf.engine.WKFContext;
import com.kool.system.SystemConstants;
import com.kool.system.bean.SyUserInfoBean;
import com.kool.system.bean.SyUserTradeBean;
import com.kool.system.bean.io.SYLOGINFXBean;
import com.kool.system.bean.io.SYPAGEINFOYBean;
import com.kool.system.bean.io.SYREGINFXBean;
import com.kool.system.bean.io.SYUSRINFZBean;
import com.kool.system.bean.vo.PageResult;
import com.kool.system.dao.SyUserInfoDao;
import com.kool.system.dao.SyUserTradeDao;

/**
 * @DESCRIBE
 * @AUTHOR LUYU
 * @DATE 2017年12月27日 下午10:55:16
 *
 */
@Service("UserService")
public class UserService {
	private static Logger logger = Logger.getLogger("stdout");

	@Autowired
	private SyUserInfoDao userDao;

	@Autowired
	private SyUserTradeDao tradeDao;

	public void register(SYREGINFXBean regInf) throws BusException, AppException {

		String pwd = regInf.getSuiPwd();
		if (pwd != null && pwd.equals(regInf.getSuiPwdC()) == false) {
			throw new BusException("密码不一致");// 密码不一致
		}
		SyUserInfoBean userInfo = queryUserInf(regInf.getSuiLoginName());
		if (userInfo != null) {
			throw new BusException("用户名已经存在");// 用户名已经存在
		}
		pwd = SecurityUtils.base64Decode(pwd);
		// 生成随机数N
		int N = 3;
		// int N = getN();
		// 生成加密盐
		String salt = getSalt();
		// 密码密文=sha(密码+|+加密盐,N)
		String encryptPwd = sha(pwd + "|" + salt, N);

		userInfo = new SyUserInfoBean();
		userInfo.setSuiId(StringUtils.getUUID());
		userInfo.setSuiLoginName(regInf.getSuiLoginName());
		userInfo.setSuiPwd(encryptPwd);
		userInfo.setSuiSalt(salt);
		userInfo.setSuiNewSalt(salt);
		userInfo.setSuiHashTimes(N);
		userInfo.setSuiStatus(SystemConstants.SUI_STATUS_ACTIVE);// 正常
		userInfo.setSuiErrorTimes(0);
		userInfo.setSuiRegisterTime(new Timestamp(System.currentTimeMillis()));

		userDao.insert(userInfo);
	}

	/**
	 * @DESCRIBE
	 * @DATE 2017年12月31日 下午4:05:56
	 *
	 * @param suiLoginName
	 * @return
	 * @throws AppException
	 */
	public SYUSRINFZBean preLogin(SYLOGINFXBean logInf) throws BusException {
		SyUserInfoBean userInf = queryUserInf(logInf.getSuiLoginName());
		if (null == userInf) {
			throw new BusException("登录名错误");// 登录名错误
		}
		if (userInf.getSuiErrorTimes() >= 5) {
			throw new BusException("密码错误次数达到5次，请修改密码！");// 密码错误次数达到5次，请修改密码！
		}

		SYUSRINFZBean userInfZ = JSONObject.toJavaObject(JSONObject.parseObject(JSONObject.toJSONString(userInf)),
				SYUSRINFZBean.class);
		// N-1
		userInfZ.setSuiHashTimes(userInf.getSuiHashTimes() - 1);
		return userInfZ;
	}

	/**
	 * @DESCRIBE
	 * @DATE 2017年12月31日 下午12:11:07
	 *
	 * @param logInf
	 * @throws AppException
	 */
	public SyUserInfoBean login(SYLOGINFXBean logInf) throws BusException, AppException {
		// 取PwdA/PwdB
		String sPwdATmp = logInf.getSuiPwdA();
		String sPwdBTmp = logInf.getSuiPwdB();

		// 查询用户信息
		SyUserInfoBean userInf = queryUserInf(logInf.getSuiLoginName());
		// 取N
		int N = userInf.getSuiHashTimes();
		// sha加密1次
		String sPwdA = sha(sPwdATmp, 1);
		// 验证密码是否正确
		if (!sPwdA.equals(userInf.getSuiPwd())) {
			// 密码错误，更新密码错误次数
			userInf.setSuiErrorTimes(userInf.getSuiErrorTimes() + 1);
			userDao.update(userInf);
			logger.debug("密码错误");
			throw new BusException("密码错误");// 密码错误
		}

		// 更新N/新盐/旧盐/密码/密码错误次数
		if (N == 2) {
			N = getN();
			sPwdBTmp = sha(sPwdBTmp, N - 1);
		} else {
			N = N - 1;
		}
		userInf.setSuiHashTimes(N);
		userInf.setSuiSalt(userInf.getSuiNewSalt());
		userInf.setSuiNewSalt(getSalt());
		userInf.setSuiPwd(sPwdBTmp);
		userInf.setSuiErrorTimes(0);

		logger.debug("密码正确。更新N=" + String.valueOf(N) + ";salt=" + userInf.getSuiSalt() + ";newSalt="
				+ userInf.getSuiNewSalt() + ";pwd=" + userInf.getSuiPwd());
		userDao.update(userInf);

		return userInf;
	}

	/**
	 * @DESCRIBE
	 * @DATE 2017年12月31日 下午12:22:45
	 *
	 * @param suiLoginName
	 * @return
	 */
	public SyUserInfoBean queryUserInf(String suiLoginName) {
		SyUserInfoBean syUserInfo = new SyUserInfoBean();
		syUserInfo.setSuiLoginName(suiLoginName);
		List<SyUserInfoBean> listUser = userDao.select(syUserInfo);

		if (null == listUser || listUser.size() <= 0) {
			return null;
		}
		return listUser.get(0);
	}

	/**
	 * @DESCRIBE
	 * @DATE 2017年12月27日 下午10:52:01
	 *
	 * @param string
	 * @param N
	 * @return
	 * @throws AppException
	 */
	private String sha(String pwd, int N) throws AppException {
		String tmp = pwd;
		for (int i = 0; i < N; i++) {
			tmp = SecurityUtils.sha(tmp);
		}
		return tmp;
	}

	/**
	 * @DESCRIBE
	 * @DATE 2017年12月27日 下午10:46:01
	 *
	 * @return
	 */
	private String getSalt() {
		String salt = StringUtils.getUUID().substring(0, 5);
		return salt;
	}

	/**
	 * @DESCRIBE
	 * @DATE 2017年12月27日 下午10:40:28
	 * @return
	 *
	 */
	private int getN() {
		Random random = new Random(System.currentTimeMillis());
		int N = Math.abs(random.nextInt()) % 10000 + 2;
		return N;
	}

	/**
	 * 
	 * @DESCRIBE 查询用户信息列表
	 * @DATE 2018年1月20日 下午11:52:57
	 *
	 * @param userInfo
	 * @return
	 */
	public List<SyUserInfoBean> query(SyUserInfoBean userInfo) {
		return userDao.select(userInfo);
	}

	/**
	 * 
	 * @DESCRIBE 查询用户信息列表,分页
	 * @DATE 2018年2月20日 上午11:17:47
	 *
	 * @param userInfo
	 * @param pageInfo
	 * @return
	 */
	public PageResult queryPage(SyUserInfoBean userInfo, SYPAGEINFOYBean pageInfo) {
		int total = userDao.selectTotal(userInfo);

		int currentPage = pageInfo.getCurrentPage();
		int pageSize = pageInfo.getPageSize();
		int offset = (currentPage - 1) * pageSize;
		int pageCount = (total + pageSize - 1) / pageSize;
		List<SyUserInfoBean> listUsers = userDao.selectPage(userInfo, offset, pageInfo.getPageSize());

		pageInfo.setTotal(total);
		pageInfo.setPageCount(pageCount);

		PageResult pageResult = new PageResult();
		pageResult.setListBusinessValue(new ArrayList<>(listUsers));
		pageResult.setPageInfo(pageInfo);
		return pageResult;
	}

	/**
	 * 
	 * @DESCRIBE 增加用户信息经办交易
	 * @DATE 2018年1月21日 上午12:18:45
	 *
	 * @param tradeInfo
	 * @return
	 * @throws BusException
	 * @throws AppException
	 */
	public String addUserOpr(SyUserTradeBean tradeInfo) throws AppException, BusException {
		tradeInfo.setSutTradeId(StringUtils.getUUID());
		LoginInfo loginInfo = ContextHolder.getReqContext().getLoginInfo();
		tradeInfo.setSutOprUserId(loginInfo.getSuiId());
		tradeInfo.setSutOprLoginName(loginInfo.getSuiLoginName());
		tradeInfo.setSutTradeType("SYUSRADD01");
		tradeInfo.setSutTradeTime(new Timestamp(System.currentTimeMillis()));
		tradeInfo.setSutTradeStatus("A");

		WKFContext wkfInfo = new WKFContext();
		wkfInfo.setBusinessType("SYUSR");
		wkfInfo.setUserId(loginInfo.getSuiId());
		wkfInfo.setLoginName(loginInfo.getSuiLoginName());

		BusinessValue businessValue = new BusinessValue();
		businessValue.setBusinessField1(tradeInfo.getSutTradeId());
		businessValue.setBusinessField2(tradeInfo.getSutTradeType());
		businessValue.setBusinessField6(tradeInfo.getSutLoginName());
		businessValue.setBusinessField9(tradeInfo.getSutTradeTime());
		wkfInfo.setBusinessValue(businessValue);

		IEvoWkfApi wkfApi = new SimpleApiImp();
		String recordId = wkfApi.start(wkfInfo);

		tradeInfo.setSutRecordId(recordId);
		tradeDao.insert(tradeInfo);

		return tradeInfo.getSutTradeId();
	}

	/**
	 * 
	 * @DESCRIBE 冻结用户
	 * @DATE 2018年1月21日 上午12:54:43
	 *
	 * @param userInfo
	 */
	public void freezeUser(SyUserInfoBean userInfo) {
		userInfo.setSuiStatus(SystemConstants.SUI_STATUS_PENDING);
		userDao.update(userInfo);
	}

	/**
	 * 
	 * @DESCRIBE 解冻用户
	 * @DATE 2018年1月21日 上午12:54:56
	 *
	 * @param userInfo
	 */
	public void unfreezeUser(SyUserInfoBean userInfo) {
		userInfo.setSuiStatus(SystemConstants.SUI_STATUS_ACTIVE);
		userDao.update(userInfo);
	}

	/**
	 * 
	 * @DESCRIBE 关闭用户
	 * @DATE 2018年1月21日 上午12:58:46
	 *
	 * @param userInfo
	 */
	public void closeUser(SyUserInfoBean userInfo) {
		userInfo.setSuiStatus(SystemConstants.SUI_STATUS_CLOSE);
		userDao.update(userInfo);
	}

	/**
	 * 
	 * @DESCRIBE 更新用户信息
	 * @DATE 2018年2月18日 上午10:55:19
	 *
	 * @param userInfo
	 */
	public void updateUser(SyUserInfoBean userInfo) {
		userDao.update(userInfo);
	}
}
