/**
 * @PROJECT 
 * @DATE 2018年2月15日 下午8:03:29
 * @AUTHOR LUYU
 */
package com.kool.evowkf.engine;

/**
 * @DESCRIBE
 * @AUTHOR LUYU
 * @DATE 2018年2月15日 下午8:03:29
 *
 */
public interface IOperations {
	public void executeNodeByOperations(WKFContext wkfInfo);
	public void stopFlowByOperations(WKFContext wkfInfo);
}
