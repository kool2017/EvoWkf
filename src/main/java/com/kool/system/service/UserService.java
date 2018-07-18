/**
 * @PROJECT 
 * @DATE 2017年12月27日 下午10:55:16
 * @AUTHOR LUYU
 */
package com.kool.system.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.kool.core.CoreConstants;
import com.kool.core.cache.KCache;
import com.kool.core.context.ContextHolder;
import com.kool.core.context.LoginInfo;
import com.kool.core.exception.AppException;
import com.kool.core.util.GlobalDefineUtils;
import com.kool.core.util.SecurityUtils;
import com.kool.core.util.SpringContextUtil;
import com.kool.core.util.StringUtils;
import com.kool.evowkf.api.IEvoWkfApi;
import com.kool.evowkf.api.SimpleApiImp;
import com.kool.evowkf.bean.vo.BusinessValue;
import com.kool.evowkf.engine.WKFContext;
import com.kool.system.SystemConstants;
import com.kool.system.bean.SyAutDefBean;
import com.kool.system.bean.SyLoginLogBean;
import com.kool.system.bean.SyMenuBean;
import com.kool.system.bean.SyRoleBean;
import com.kool.system.bean.SyUserAutBean;
import com.kool.system.bean.SyUserInfoBean;
import com.kool.system.bean.SyUserRoleBean;
import com.kool.system.bean.SyUserTradeBean;
import com.kool.system.bean.io.SYLOGINFXBean;
import com.kool.system.bean.io.SYPAGEINFOYBean;
import com.kool.system.bean.io.SYREGINFXBean;
import com.kool.system.bean.io.SYUSRINFZBean;
import com.kool.system.bean.vo.PageResult;
import com.kool.system.dao.SyLoginLogDao;
import com.kool.system.dao.SyUserAutDao;
import com.kool.system.dao.SyUserInfoDao;
import com.kool.system.dao.SyUserRoleDao;
import com.kool.system.dao.SyUserTradeDao;
import com.kool.system.util.CommonUtils;

/**
 * @DESCRIBE
 * @AUTHOR LUYU
 * @DATE 2017年12月27日 下午10:55:16
 *
 */
@Service("UserService")
public class UserService {
	private static Logger logger = Logger.getLogger(UserService.class);

	@Autowired
	private CounterService cntService;

	@Autowired
	private SyUserInfoDao userDao;

	@Autowired
	private SyUserTradeDao tradeDao;

	@Autowired
	private SyLoginLogDao logDao;

	@Autowired
	private SyUserAutDao uaDao;

	@Autowired
	private SyUserRoleDao urDao;
	
	@Autowired
	private MenuService menuService;

	public void register(SYREGINFXBean regInf) throws AppException {

		String pwd = regInf.getSuiPwd();
		if (pwd != null && pwd.equals(regInf.getSuiPwdC()) == false) {
			throw new AppException("SY000004");// 密码不一致
		}
		SyUserInfoBean userInfo = queryUserInf(regInf.getSuiLoginName());
		if (userInfo != null) {
			throw new AppException("SY000005");// 用户名已经存在
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
		userInfo.setSuiUserCid(cntService.getNextNumber(SystemConstants.CNT_USER_CID));
		userInfo.setSuiLoginName(regInf.getSuiLoginName());
		userInfo.setSuiType(SystemConstants.SUI_TYPE_VISTOR);
		userInfo.setSuiPwd(encryptPwd);
		userInfo.setSuiSalt(salt);
		userInfo.setSuiNewSalt(salt);
		userInfo.setSuiHashTimes(N);
		userInfo.setSuiState(SystemConstants.SUI_STATE_ACTIVE);// 正常
		userInfo.setSuiErrorTimes(0);
		userInfo.setSuiRegisterTime(new Timestamp(System.currentTimeMillis()));
		userInfo.setSuiHasKey(SystemConstants.SUI_HAS_KEY_YES);
		userInfo.setSuiKeyUid(StringUtils.getUUID());
		userInfo.setSuiStaffCid(regInf.getSuiStaffCid());

		logger.debug(userInfo.toString());
		userDao.insert(userInfo);

		// 刷新缓存
		KCache.refresh(CoreConstants.KCACHE_USER);
		// 授权基本访问权限
		List<SyUserAutBean> listUserAut = new ArrayList<>();
		SyUserAutBean userAut = new SyUserAutBean();
		userAut.setSuaUserCid(userInfo.getSuiUserCid());
		userAut.setSuaAutCode("SYBASIC0");
		listUserAut.add(userAut);
		resetAuth(userInfo.getSuiUserCid(), listUserAut);
	}

	/**
	 * @DESCRIBE
	 * @DATE 2017年12月31日 下午4:05:56
	 *
	 * @param suiLoginName
	 * @return
	 * @throws AppException
	 */
	public SYUSRINFZBean preLogin(SYLOGINFXBean logInf) throws AppException {
		SyUserInfoBean userInf = queryUserInf(logInf.getSuiLoginName());
		if (null == userInf) {
			throw new AppException("SY000001");// 登录名不存在或密码错误
		}
		String state = userInf.getSuiState();
		if (SystemConstants.SUI_STATE_ACTIVE.equals(state) == false
				&& SystemConstants.SUI_STATE_PENDING.equals(state) == false) {
			throw new AppException("SY000063", GlobalDefineUtils.transfer("SUI_STATE", state));// 用户当前状态[%1]，无法登录，请联系管理员修改用户状态！
		}
		if (userInf.getSuiErrorTimes() >= 5) {
			throw new AppException("SY000002");// 密码错误次数达到5次，请修改密码！
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
	public SyUserInfoBean login(SYLOGINFXBean logInf) throws AppException {
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
			logger.debug(userInf.toString());
			userDao.update(userInf);
			logger.debug("密码错误");
			throw new AppException("SY000003");// 密码错误
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

		// 写登录日志
		SyLoginLogBean loginLog = new SyLoginLogBean();
		loginLog.setSllLogUid(StringUtils.getUUID());
		loginLog.setSllUserCid(userInf.getSuiUserCid());
		loginLog.setSllTime(new Timestamp(System.currentTimeMillis()));
		loginLog.setSllIp(ContextHolder.getReqContext().getIp());
		logger.debug(loginLog.toString());
		logDao.insert(loginLog);

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
		logger.debug(userInfo.toString());
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
		logger.debug(userInfo.toString());
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
	 * @throws AppException
	 * @throws AppException
	 */
//	public String addUserOpr(SyUserTradeBean tradeInfo) throws AppException {
//		tradeInfo.setSutTradeUid(StringUtils.getUUID());
//		LoginInfo loginInfo = ContextHolder.getReqContext().getLoginInfo();
//		tradeInfo.setSutOprUserCid(loginInfo.getSuiId());
//		tradeInfo.setSutOprName(loginInfo.getSuiLoginName());
//		tradeInfo.setSutTradeType("SYUSRADD01");
//		tradeInfo.setSutTradeTime(new Timestamp(System.currentTimeMillis()));
//		tradeInfo.setSutState("A");
//
//		WKFContext wkfInfo = new WKFContext();
//		wkfInfo.setBusinessType("SYUSR");
//		wkfInfo.setUserId(loginInfo.getSuiId());
//		wkfInfo.setLoginName(loginInfo.getSuiLoginName());
//
//		BusinessValue businessValue = new BusinessValue();
//		businessValue.setBusinessField1(tradeInfo.getSutTradeUid());
//		businessValue.setBusinessField2(tradeInfo.getSutTradeType());
//		businessValue.setBusinessField6(tradeInfo.getSutLoginName());
//		businessValue.setBusinessField9(tradeInfo.getSutTradeTime());
//		wkfInfo.setBusinessValue(businessValue);
//
//		IEvoWkfApi wkfApi = new SimpleApiImp();
//		String recordId = wkfApi.start(wkfInfo);
//
//		tradeInfo.setSutWkfNbr(recordId);
//		logger.debug(tradeInfo.toString());
//		tradeDao.insert(tradeInfo);
//
//		return tradeInfo.getSutTradeUid();
//	}

	/**
	 * 
	 * @DESCRIBE 冻结用户
	 * @DATE 2018年1月21日 上午12:54:43
	 *
	 * @param userInfo
	 */
	@Deprecated
	public void freezeUser(SyUserInfoBean userInfo) {
		userInfo.setSuiState(SystemConstants.SUI_STATE_PENDING);
		userDao.update(userInfo);

		KCache.refresh(CoreConstants.KCACHE_USER);
	}

	/**
	 * 
	 * @DESCRIBE 解冻用户
	 * @DATE 2018年1月21日 上午12:54:56
	 *
	 * @param userInfo
	 */
	@Deprecated
	public void unfreezeUser(SyUserInfoBean userInfo) {
		userInfo.setSuiState(SystemConstants.SUI_STATE_ACTIVE);
		userDao.update(userInfo);

		KCache.refresh(CoreConstants.KCACHE_USER);
	}

	/**
	 * 
	 * @DESCRIBE 关闭用户
	 * @DATE 2018年1月21日 上午12:58:46
	 *
	 * @param userInfo
	 */
	@Deprecated
	public void closeUser(SyUserInfoBean userInfo) {
		userInfo.setSuiState(SystemConstants.SUI_STATE_CLOSE);
		userDao.update(userInfo);

		KCache.refresh(CoreConstants.KCACHE_USER);
	}

	/**
	 * 
	 * @DESCRIBE 更新用户信息
	 * @DATE 2018年2月18日 上午10:55:19
	 *
	 * @param userInfo
	 * @throws AppException
	 */
	public void updateUser(SyUserInfoBean userInfo) throws AppException {
		if (null == userInfo) {
			throw new AppException("SY000018");// 用户信息为空
		}
		logger.debug(userInfo.toString());
		userDao.update(userInfo);

		KCache.refresh(CoreConstants.KCACHE_USER);
	}

	/**
	 * @DESCRIBE
	 * @DATE 2018年7月8日 下午2:13:28
	 *
	 * @param userInfo
	 * @throws AppException
	 */
	public void add(SyUserInfoBean userInfo) throws AppException {
		if (null == userInfo) {
			throw new AppException("SY000018");// 用户信息为空
		}
		SyUserInfoBean loginName = queryUserInf(userInfo.getSuiLoginName());
		if (loginName != null) {
			throw new AppException("SY000005");// 用户名已经存在
		}

		// 生成随机数N
		int N = 3;
		// int N = getN();
		// 生成加密盐
		String salt = getSalt();
		// 密码密文=sha(密码+|+加密盐,N)
		String encryptPwd = sha(userInfo.getSuiLoginName() + "|" + salt, N);

		userInfo.setSuiUserCid(cntService.getNextNumber(SystemConstants.CNT_USER_CID));
		userInfo.setSuiPwd(encryptPwd);
		userInfo.setSuiSalt(salt);
		userInfo.setSuiNewSalt(salt);
		userInfo.setSuiHashTimes(N);
		userInfo.setSuiState(SystemConstants.SUI_STATE_ACTIVE);// 正常
		userInfo.setSuiErrorTimes(0);
		userInfo.setSuiRegisterTime(new Timestamp(System.currentTimeMillis()));
		userInfo.setSuiHasKey(SystemConstants.SUI_HAS_KEY_YES);
		userInfo.setSuiKeyUid(StringUtils.getUUID());

		logger.debug(userInfo.toString());
		userDao.insert(userInfo);

		KCache.refresh(CoreConstants.KCACHE_USER);

		// 授权基本访问权限
		List<SyUserAutBean> listUserAut = new ArrayList<>();
		SyUserAutBean userAut = new SyUserAutBean();
		userAut.setSuaUserCid(userInfo.getSuiUserCid());
		userAut.setSuaAutCode("SYBASIC0");
		listUserAut.add(userAut);
		resetAuth(userInfo.getSuiUserCid(), listUserAut);
	}

	/**
	 * @DESCRIBE 查询用户详情
	 * @DATE 2018年7月8日 下午2:51:07
	 *
	 * @param userCid
	 * @return
	 */
	public SyUserInfoBean queryDetail(String userCid) {
		SyUserInfoBean syUserInfo = new SyUserInfoBean();
		syUserInfo.setSuiUserCid(userCid);
		logger.debug(syUserInfo.toString());
		SyUserInfoBean userDtl = userDao.selectByPK(syUserInfo);

		return userDtl;
	}

	/**
	 * @DESCRIBE
	 * @DATE 2018年7月8日 下午2:54:58
	 *
	 * @param userCid
	 * @return
	 * @throws AppException
	 */
	public List<SyLoginLogBean> queryLoginLog(String userCid) throws AppException {
		if (StringUtils.isEmpty(userCid)) {
			throw new AppException("SY000019");// 用户号为空
		}

		StringBuilder sb = new StringBuilder();
		sb.append("SELECT * FROM SY_LOGIN_LOG ");
		sb.append("WHERE SLL_USER_CID = \"");
		sb.append(userCid);
		sb.append("\" ");
		sb.append("ORDER BY SLL_TIME DESC ");
		sb.append("LIMIT 10");
		logger.debug(sb.toString());
		List<Map<String, Object>> listRet = logDao.selectBySql(sb.toString());
		List<SyLoginLogBean> list = new ArrayList<>();
		for (Map<String, Object> mapRet : listRet) {
			SyLoginLogBean log = SyLoginLogBean.DBResultToBean(mapRet);
			list.add(log);
		}
		return list;
	}

	/**
	 * @DESCRIBE 冻结
	 * @DATE 2018年7月8日 下午3:56:13
	 *
	 * @param userCid
	 * @throws AppException
	 */
	public void freeze(String userCid) throws AppException {
		if (StringUtils.isEmpty(userCid)) {
			throw new AppException("SY000019");// 用户号为空
		}
		SyUserInfoBean info = new SyUserInfoBean();
		info.setSuiUserCid(userCid);
		logger.debug(info.toString());
		SyUserInfoBean user = userDao.selectByPK(info);
		if (null == user) {
			throw new AppException("SY000020", userCid);// 用户[%1]不存在
		}
		if (SystemConstants.SUI_STATE_ACTIVE.equals(user.getSuiState()) == false) {
			throw new AppException("SY000022", GlobalDefineUtils.transfer("SUI_STATE", user.getSuiState()));// 用户状态[%1]不允许被冻结
		}
		info.setSuiState(SystemConstants.SUI_STATE_FREEZE);
		logger.debug(info.toString());
		userDao.update(info);

		KCache.refresh(CoreConstants.KCACHE_USER);
	}

	/**
	 * 
	 * @DESCRIBE 解冻
	 * @DATE 2018年7月8日 下午3:58:27
	 *
	 * @param userCid
	 * @throws AppException
	 */
	public void unfreeze(String userCid) throws AppException {
		if (StringUtils.isEmpty(userCid)) {
			throw new AppException("SY000019");// 用户号为空
		}
		SyUserInfoBean info = new SyUserInfoBean();
		info.setSuiUserCid(userCid);
		logger.debug(info.toString());
		SyUserInfoBean user = userDao.selectByPK(info);
		if (null == user) {
			throw new AppException("SY000020", userCid);// 用户[%1]不存在
		}
		if (SystemConstants.SUI_STATE_FREEZE.equals(user.getSuiState()) == false) {
			throw new AppException("SY000021", GlobalDefineUtils.transfer("SUI_STATE", user.getSuiState()));// 用户状态[%1]不允许被解冻
		}
		info.setSuiState(SystemConstants.SUI_STATE_ACTIVE);
		logger.debug(info.toString());
		userDao.update(info);

		KCache.refresh(CoreConstants.KCACHE_USER);
	}

	/**
	 * @DESCRIBE 重置密码
	 * @DATE 2018年7月8日 下午5:00:22
	 *
	 * @param userCid
	 * @throws AppException
	 */
	public void resetPwd(String userCid) throws AppException {
		if (StringUtils.isEmpty(userCid)) {
			throw new AppException("SY000019");// 用户号为空
		}
		SyUserInfoBean info = new SyUserInfoBean();
		info.setSuiUserCid(userCid);
		logger.debug(info.toString());
		SyUserInfoBean user = userDao.selectByPK(info);
		if (null == user) {
			throw new AppException("SY000020", userCid);// 用户[%1]不存在
		}
		// 生成随机数N
		int N = 3;
		// int N = getN();
		// 生成加密盐
		String salt = getSalt();
		// 密码密文=sha(密码+|+加密盐,N)
		String encryptPwd = sha(user.getSuiLoginName() + "|" + salt, N);
		user.setSuiPwd(encryptPwd);
		user.setSuiSalt(salt);
		user.setSuiNewSalt(salt);
		user.setSuiHashTimes(N);
		logger.debug(user.toString());
		userDao.update(user);
	}

	/**
	 * 
	 * @DESCRIBE 修改密码
	 * @DATE 2018年7月8日 下午5:03:47
	 *
	 * @param userCid
	 * @param oldPwd
	 * @param newPwd
	 * @param newPwdC
	 * @throws AppException
	 */
	public void updatePwd(String userCid, String oldPwd, String newPwd, String newPwdC) throws AppException {
		if (StringUtils.isEmpty(newPwd) || StringUtils.isEmpty(newPwdC) || StringUtils.isEmpty(oldPwd)) {
			throw new AppException("SY000023");// 密码格式错误
		}
		if (newPwd.equals(newPwdC) == false) {
			throw new AppException("SY000004");// 密码不一致
		}
		if (StringUtils.isEmpty(userCid)) {
			throw new AppException("SY000019");// 用户号为空
		}
		SyUserInfoBean info = new SyUserInfoBean();
		info.setSuiUserCid(userCid);
		logger.debug(info.toString());
		SyUserInfoBean user = userDao.selectByPK(info);
		if (null == user) {
			throw new AppException("SY000020", userCid);// 用户[%1]不存在
		}
		// 验证旧密码
		String shaPwd = sha(oldPwd + "|" + user.getSuiSalt(), user.getSuiHashTimes());
		if (shaPwd.equals(user.getSuiPwd()) == false) {
			throw new AppException("SY000003");// 密码错误
		}
		// 生成随机数N
		int N = 3;
		// int N = getN();
		// 生成加密盐
		String salt = getSalt();
		// 密码密文=sha(密码+|+加密盐,N)
		String encryptPwd = sha(newPwd + "|" + salt, N);
		user.setSuiPwd(encryptPwd);
		user.setSuiSalt(salt);
		user.setSuiNewSalt(salt);
		user.setSuiHashTimes(N);
		logger.debug(user.toString());
		userDao.update(user);
	}

	/**
	 * @DESCRIBE 查询用户权限列表
	 * @DATE 2018年7月8日 下午6:54:17
	 *
	 * @param userCid
	 * @return
	 * @throws AppException
	 */
	public List<SyUserAutBean> queryUserAuth(String userCid) throws AppException {
		if (StringUtils.isEmpty(userCid)) {
			throw new AppException("SY000019");// 用户号为空
		}
		SyUserAutBean syUserAut = new SyUserAutBean();
		syUserAut.setSuaUserCid(userCid);
		logger.debug(syUserAut.toString());
		List<SyUserAutBean> list = uaDao.select(syUserAut);
		return list;
	}

	/**
	 * @DESCRIBE 授权
	 * @DATE 2018年7月8日 下午7:19:59
	 *
	 * @param listIn
	 * @throws AppException
	 */
	public void resetAuth(String userCid, List<SyUserAutBean> listIn) throws AppException {
		// 验证权限类型和用户类型关系是否匹配
		for (SyUserAutBean userAut : listIn) {
			CommonUtils.validateAutType(userCid, userAut.getSuaAutCode());
		}
		SyUserAutBean info = new SyUserAutBean();
		info.setSuaUserCid(userCid);
		logger.debug(info.toString());
		uaDao.deletes(info);

		// 加备注
		SyUserInfoBean user = (SyUserInfoBean) KCache.get(CoreConstants.KCACHE_USER, userCid);
		if (listIn != null && listIn.size() > 0) {
			for (SyUserAutBean userAut : listIn) {
				SyAutDefBean aut = (SyAutDefBean) KCache.get(CoreConstants.KCACHE_AUT, userAut.getSuaAutCode());
				userAut.setSuaCmt(new StringBuilder().append(user.getSuiLoginName()).append("-")
						.append(aut.getSadName()).toString());
			}
			uaDao.insertBatch(listIn);
		}
		// 刷新缓存
		KCache.refresh(CoreConstants.KCACHE_USER_MENU);
		KCache.refresh(CoreConstants.KCACHE_USER_REQ);
	}

	/**
	 * @DESCRIBE 查询用户角色列表
	 * @DATE 2018年7月8日 下午10:36:40
	 *
	 * @param userCid
	 * @return
	 * @throws AppException
	 */
	public List<SyUserRoleBean> queryUserRole(String userCid) throws AppException {
		if (StringUtils.isEmpty(userCid)) {
			throw new AppException("SY000019");// 用户号为空
		}
		SyUserRoleBean syUserRole = new SyUserRoleBean();
		syUserRole.setSurUserCid(userCid);
		logger.debug(syUserRole.toString());
		List<SyUserRoleBean> list = urDao.select(syUserRole);
		return list;
	}

	/**
	 * 
	 * @DESCRIBE 赋予角色
	 * @DATE 2018年7月8日 下午10:39:05
	 *
	 * @param userCid
	 * @param listIn
	 * @throws AppException
	 */
	public void setRole(String userCid, List<SyUserRoleBean> listIn) throws AppException {
		SyUserRoleBean info = new SyUserRoleBean();
		info.setSurUserCid(userCid);
		logger.debug(info.toString());
		urDao.deletes(info);

		// 加备注
		SyUserInfoBean user = (SyUserInfoBean) KCache.get(CoreConstants.KCACHE_USER, userCid);
		if (listIn != null && listIn.size() > 0) {
			for (SyUserRoleBean userRole : listIn) {
				SyRoleBean role = (SyRoleBean) KCache.get(CoreConstants.KCACHE_ROLE, userRole.getSurRoleCode());
				userRole.setSurCmt(new StringBuilder().append(user.getSuiLoginName()).append("-")
						.append(role.getSroName()).toString());
			}
			urDao.insertBatch(listIn);
		}

		// 查询用户关联的所有角色的所有权限，过滤用户已有权限
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT B.SRA_AUT_CODE AS autCode FROM SY_USER_ROLE A, SY_ROLE_AUT B ");
		sb.append("WHERE A.SUR_ROLE_CODE = B.SRA_ROLE_CODE ");
		sb.append("AND A.SUR_USER_CID = \"");
		sb.append(userCid);
		sb.append("\" ");
		sb.append("AND B.SRA_AUT_CODE NOT IN (SELECT SUA_AUT_CODE FROM SY_USER_AUT WHERE SUA_USER_CID=\"");
		sb.append(userCid);
		sb.append("\")");
		logger.debug(sb.toString());
		List<Map<String, Object>> listRet = uaDao.selectBySql(sb.toString());
		// 增加用户授权
		List<SyUserAutBean> listAut = new ArrayList<>();
		if (listRet != null && listRet.size() > 0) {
			for (Map<String, Object> mapRet : listRet) {
				SyUserAutBean userAut = new SyUserAutBean();
				userAut.setSuaAutCode((String) mapRet.get("autCode"));
				userAut.setSuaUserCid(userCid);

				// 验证权限类型和用户类型关系是否匹配
				CommonUtils.validateAutType(userCid, userAut.getSuaAutCode());

				listAut.add(userAut);
			}
		}
		if (listAut.size() > 0) {
			uaDao.insertBatch(listAut);
		}
		// 刷新缓存
		KCache.refresh(CoreConstants.KCACHE_USER_MENU);
		KCache.refresh(CoreConstants.KCACHE_USER_REQ);
	}

	/**
	 * @DESCRIBE 获取用户有权限的菜单
	 * @DATE 2018年7月15日 下午9:14:48
	 *
	 * @param userCid
	 * @return
	 * @throws AppException
	 */
	public List<SyMenuBean> getUserMenu(String userCid) throws AppException {
		if (StringUtils.isEmpty(userCid)) {
			throw new AppException("SY000019");// 用户号为空
		}

		List<SyMenuBean> listMenu = menuService.query(new SyMenuBean());
		return listMenu;
	}
}
