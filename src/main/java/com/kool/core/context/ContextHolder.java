/**
 * @PROJECT 
 * @DATE 2018年1月19日 下午9:03:36
 * @AUTHOR LUYU
 */
package com.kool.core.context;

import java.util.HashMap;
import java.util.Map;

import com.kool.core.CoreConstants;

/**
 * @DESCRIBE 上下文容器
 * @AUTHOR LUYU
 * @DATE 2018年1月19日 下午9:03:36
 *
 */
public class ContextHolder {
	private static final ThreadLocal<Map<String, Object>> local = new ThreadLocal<>();

	public static void initIfNotInit() {
		Map<String, Object> map = local.get();
		if (map == null) {
			map = new HashMap<>();
			local.set(map);
		}
	}

	public static void setReqContext(ReqContext context) {
		initIfNotInit();
		local.get().put(CoreConstants.REQ_CONTEXT, context);
	}

	public static ReqContext getReqContext() {
		initIfNotInit();
		return (ReqContext) local.get().get(CoreConstants.REQ_CONTEXT);
	}

	public static void setContext(String contextType, BaseContext context) {
		initIfNotInit();
		local.get().put(contextType, context);
	}

	public static BaseContext getContext(String contextType) {
		initIfNotInit();
		return (ReqContext) local.get().get(contextType);
	}

	public static void remove() {
		local.remove();
	}
}
