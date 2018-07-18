/**
 * @PROJECT 
 * @DATE 2018年2月17日 下午3:14:49
 * @AUTHOR LUYU
 */
package com.kool.evowkf.engine;

import com.kool.core.exception.AppException;
import com.kool.evowkf.WKFConstants;

/**
 * @DESCRIBE
 * @AUTHOR LUYU
 * @DATE 2018年2月17日 下午3:14:49
 *
 */
public class EventHandlerBuilder {
	public static EventHandler build(String eventType, String eventRule, String eventExt) throws AppException {
		EventHandler handler = null;
		if (WKFConstants.SWN_EVENT_TYPE_EXECUTE.equals(eventType)) {
			handler = new E1EventHandler();
		} else if (WKFConstants.SWN_EVENT_TYPE_APPROVE.equals(eventType)) {
			handler = new E2EventHandler();
		} else if (WKFConstants.SWN_EVENT_TYPE_CHECK.equals(eventType)) {
			handler = new E3EventHandler();
		} else if (WKFConstants.SWN_EVENT_TYPE_JOINTTRIAL.equals(eventType)) {
			handler = new E4EventHandler();
		} else {
			throw new AppException("不支持的事件类型");
		}

		if (WKFConstants.SWN_EVENT_RULE_WKFONLY.equals(eventRule)) {
			handler.setEventRule(new T1EventRule());
		} else if (WKFConstants.SWN_EVENT_RULE_SERVICESYN.equals(eventRule)) {
			T2EventRule rule = new T2EventRule();
			rule.setClazz(eventExt);
			handler.setEventRule(rule);
		} else if (WKFConstants.SWN_EVENT_RULE_MQSYN.equals(eventRule)) {
			handler.setEventRule(new T3EventRule());
		} else if (WKFConstants.SWN_EVENT_RULE_MQASYN.equals(eventRule)) {
			handler.setEventRule(new T4EventRule());
		} else {
			throw new AppException("不支持的事件执行方式");

		}
		return handler;
	}
}
