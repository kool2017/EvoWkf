/**
 * @PROJECT 
 * @DATE 2018年2月15日 下午8:09:54
 * @AUTHOR LUYU
 */
package com.kool.evowkf.engine;

/**
 * @DESCRIBE
 * @AUTHOR LUYU
 * @DATE 2018年2月15日 下午8:09:54
 *
 */
public class SimpleOperationsImp implements IOperations {

	/**
	 * @DESCRIBE
	 * @DATE 2018年2月15日 下午8:10:06
	 *
	 * @param wkfInfo
	 */
	@Override
	public void executeNodeByOperations(WKFContext wkfInfo) {
		// TODO Auto-generated method stub
		//查询待办信息
		//查询结点信息
		//执行事件
		//记录数据
	}

	/**
	 * @DESCRIBE
	 * @DATE 2018年2月15日 下午8:10:06
	 *
	 * @param wkfInfo
	 */
	@Override
	public void stopFlowByOperations(WKFContext wkfInfo) {
		// TODO Auto-generated method stub
		//更新流程执行记录
		//更新待办
	}

}
