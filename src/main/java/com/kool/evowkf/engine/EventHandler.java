/**
 * @PROJECT 
 * @DATE 2018年2月17日 下午3:15:21
 * @AUTHOR LUYU
 */
package com.kool.evowkf.engine;

import com.kool.core.exception.AppException;
import com.kool.core.exception.BusException;
import com.kool.evowkf.bean.vo.WkfEventResult;

/**
 * @DESCRIBE
 * @AUTHOR LUYU
 * @DATE 2018年2月17日 下午3:15:21
 *
 */
public abstract class EventHandler {
	private IEventRule eventRule;

	public abstract WkfEventResult wkfEvent(NodeEvent event) throws BusException;
	
	public WkfEventResult handleEvent(NodeEvent event) throws BusException, AppException {
		WkfEventResult result = wkfEvent(event);
		eventRule.DoRule(event);
		return result;
	}

	/**
	 * @return the eventRule
	 */
	public IEventRule getEventRule() {
		return eventRule;
	}

	/**
	 * @param eventRule
	 *            the eventRule to set
	 */
	public void setEventRule(IEventRule eventRule) {
		this.eventRule = eventRule;
	}

}
