/**
 * @PROJECT 
 * @DATE 2018年2月17日 下午3:31:08
 * @AUTHOR LUYU
 */
package com.kool.evowkf.engine;

import com.kool.core.exception.BusException;
import com.kool.evowkf.WKFConstants;
import com.kool.evowkf.bean.vo.WkfEventResult;

/**
 * @DESCRIBE 审批
 * @AUTHOR LUYU
 * @DATE 2018年2月17日 下午3:31:08
 *
 */
public class E2EventHandler extends EventHandler {

	/**
	 * @DESCRIBE 审批
	 * @DATE 2018年2月17日 下午3:51:23
	 *
	 * @param event
	 * @throws BusException
	 */
	@Override
	public WkfEventResult wkfEvent(NodeEvent event) throws BusException {
		WKFContext wkfInfo = event.getWkfInfo();
		String approveFlag = wkfInfo.getApproveFlag();
		String dsp = wkfInfo.getDescription();

		boolean forward = false;
		// 如果审批通过
		if (WKFConstants.SRD_EVENT_FLAG_AGREE.equals(approveFlag)) {
			forward = true;
		} else if (WKFConstants.SRD_EVENT_FLAG_REJECT.equals(approveFlag)) {
			forward = false;
		} else {
			throw new BusException("审批标志错误");
		}

		WkfEventResult result = new WkfEventResult();
		result.setForward(forward);
		result.setEventFlag(approveFlag);
		result.setEventDsp(dsp);
		return result;
	}
}
