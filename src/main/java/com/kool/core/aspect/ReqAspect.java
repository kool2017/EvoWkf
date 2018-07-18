/**
 * @PROJECT 
 * @DATE 2018年6月20日 下午1:37:30
 * @AUTHOR 
 */
package com.kool.core.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kool.core.CoreConstants;
import com.kool.core.context.ContextHolder;
import com.kool.core.exception.AppException;
import com.kool.core.util.FileUtils;
import com.kool.core.util.PropertyUtils;
import com.kool.core.util.SpringContextUtil;
import com.kool.core.util.StringUtils;
import com.kool.system.bean.SyReqDefBean;

/**
 * @DESCRIBE 请求切面，处理事务和异常
 * @AUTHOR
 * @DATE 2018年6月20日 下午1:37:31
 *
 */
public class ReqAspect {
	private static Logger logger = Logger.getLogger(ReqAspect.class);

	public void beforeAction() {
		// System.out.println("beforeAction");
	}

	public void afterAction() {
		// System.out.println("afterAction");
	}

	public JSONObject aroundAction(ProceedingJoinPoint joinPoint) {
		JSONObject pkgOut = new JSONObject();
		JSONArray jaInfo = new JSONArray();
		JSONObject joInfo = new JSONObject();


		// 手工处理事务
		DataSourceTransactionManager txManager = (DataSourceTransactionManager) SpringContextUtil
				.getBean("transactionManager");
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		TransactionStatus status = txManager.getTransaction(def);
		try {
			
//			// 如果是加密请求，数据解密
//			if (isEncrypted()) {
//				Object[] args = joinPoint.getArgs(); // 获取目标方法参数
//				if (null == args || args.length <= 0) {
//					throw new AppException("SY000055");// 获取请求参数失败
//				}
//				String input = (String) args[0];
//				// base64解码
//				byte[] enInput = Base64.decodeBase64(input);
//				// 取appId
//				String appId = "0001";
//				// 读取密钥
//				String keyFilePath = getKeyFilePath(appId);
//				String privateKey = FileUtils.readFile(keyFilePath, "UTF-8");
//				// 还原密钥
//				PrivateKey prk = SecurityUtils.getPrivateKey(privateKey);
//				// 解密报文
//				byte[] deInput = SecurityUtils.decryptRSA(enInput, prk);
//				
//				args[0] = new String(deInput);
//			}
//			SyReqDefBean reqDef = ContextHolder.getReqContext().getReqDef();
//			if (isNeedAut(reqDef)) {
//				// 取用户id
//				String userCid = ContextHolder.getReqContext().getUserCid();
//				if (StringUtils.isEmpty(userCid)) {
//					throw new AppException("SY000057");// 请求发起方信息为空，请求不通过
//				}
//				// 验证请求权限
//				SyReqDefBean userReq = (SyReqDefBean) KCache.get(CoreConstants.KCACHE_USER_REQ,
//						userCid + reqDef.getSrdReqUrl());
//				if (null == userReq) {
//					throw new AppException("SY000058", reqDef.getSrdName());// 请求发起方无请求[%1]的访问权限
//				}
//				
//			}

			Object ret = joinPoint.proceed(); // 执行目标方法
			if (ret != null) {
				pkgOut.putAll((JSONObject) ret);
			}
			txManager.commit(status);// 提交
			joInfo.put("ERROR_CODE", CoreConstants.ERRCOD_NONE);
		} catch (AppException appEx) {
			joInfo.put("ERROR_CODE", appEx.getErrorCode());
			joInfo.put("ERROR_MSG", appEx.getMessage());
			txManager.rollback(status);// 回滚
		} catch (Exception ex) {
			String errId = StringUtils.getUUID();
			logger.error("系统异常，异常码：" + errId + ex.getMessage(), ex);
			joInfo.put("ERROR_CODE", CoreConstants.ERRCOD_REQ_EXCEPTION);
			joInfo.put("ERROR_MSG", "系统异常，请联系管理员！异常码：" + errId);
			txManager.rollback(status);// 回滚
		} catch (Throwable e) {
			String errId = StringUtils.getUUID();
			logger.error("系统异常，异常码：" + errId + e.getMessage(), e);
			joInfo.put("ERROR_CODE", CoreConstants.ERRCOD_REQ_THROWABLE);
			joInfo.put("ERROR_MSG", "系统异常，请联系管理员！异常码：" + errId);
			txManager.rollback(status);// 回滚
		}
		jaInfo.add(joInfo);
		pkgOut.put("SYCOMMUNZ", jaInfo);
		return pkgOut;
	}

	/**
	 * @DESCRIBE 判断是否要验证权限，不需要验证权限的请求在此过滤
	 * @DATE 2018年7月16日 下午6:19:46
	 *
	 * @param reqDef
	 * @return
	 */
	private boolean isNeedAut(SyReqDefBean reqDef) {
		boolean is = true;
		String reqUrl = reqDef.getSrdReqUrl();
		if (reqUrl.indexOf("/sys/user/preLogin") >= 0 || reqUrl.indexOf("/sys/user/login") >= 0
				|| reqUrl.indexOf("/sys/user/register") >= 0 || reqUrl.indexOf("/refresh") >= 0
				|| reqUrl.indexOf("/test") >= 0 || reqUrl.indexOf("/sys/user/logout") >= 0) {
			is = false;
		}
		return is;
	}

	/**
	 * @DESCRIBE
	 * @DATE 2018年7月16日 下午5:25:17
	 *
	 * @param userCid
	 * @return
	 */
	private String getKeyFilePath(String userCid) {
		String dir = PropertyUtils.getValue("PRIVATE_KEY_PATH");
		String filePath = dir + FileUtils.getSeparator() + userCid;
		return filePath;
	}

	/**
	 * @DESCRIBE 请求数据是否加密
	 * @DATE 2018年7月16日 下午2:25:28
	 *
	 * @return
	 * @throws AppException
	 */
	private boolean isEncrypted() throws AppException {
		boolean is = false;
		String encrypt = ContextHolder.getReqContext().getReqDef().getSrdEncrypt();
		if ("Y".equals(encrypt)) {
			is = true;
		} else if ("N".equals(encrypt)) {
			is = false;
		} else {
			throw new AppException("SY000056");// 加密标志错误
		}
		return is;
	}
}
