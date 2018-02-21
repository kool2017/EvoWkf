/**
 * @PROJECT 
 * @DATE 2018年2月15日 下午9:24:07
 * @AUTHOR LUYU
 */
package com.kool.evowkf;

/**
 * @DESCRIBE
 * @AUTHOR LUYU
 * @DATE 2018年2月15日 下午9:24:07
 *
 */
public class WKFConstants {
	/////////////// 工作流定义表/////////////
	/**
	 * 流程模型A1-线型 B1-树型 C1-环型 D1-图型 E1-复合型
	 */
	public static final String SWD_WKF_TYPE_LINE = "A1";
	public static final String SWD_WKF_TYPE_TREE = "B1";
	public static final String SWD_WKF_TYPE_CYCLE = "C1";
	public static final String SWD_WKF_TYPE_GRAPH = "D1";
	public static final String SWD_WKF_TYPE_MULTI = "E1";

	/**
	 * 路由类型SI-单路串行 MU-多路并行 AL-不限
	 */
	public static final String SWD_ROUTE_TYPE_SINGLE = "SI";
	public static final String SWD_ROUTE_TYPE_MULTI = "MU";
	public static final String SWD_ROUTE_TYPE_ALL = "AL";

	/**
	 * 签收标志Y-签收 N-不签收
	 */
	public static final String SWD_CHECK_FLAG_YES = "Y";
	public static final String SWD_CHECK_FLAG_NO = "N";

	/**
	 * 工作流状态A-正常 C-关闭
	 */
	public static final String SWD_WKF_STATUS_ACTIVE = "A";
	public static final String SWD_WKF_STATUS_CLOSE = "C";

	////////////////////// 工作流实例表////////////////////////////
	/**
	 * 流程实例状态 A-正常 C-关闭 P-待关闭，如果工作流实例被关闭，则先进入待关闭状态，等所有执行记录完成后再关闭；待关闭的实例不会被新业务使用
	 */
	public static final String SWE_ENTITY_STATUS_ACTIVE = "A";
	public static final String SWE_ENTITY_STATUS_CLOSE = "C";
	public static final String SWE_ENTITY_STATUS_PADDING = "P";

	////////////////////// 工作流实例-业务控制表////////////////////////////
	/**
	 * 是否单实例"Y-是 N-否"
	 * 
	 */
	public static final String SEB_IS_SINGLE_YES = "Y";
	public static final String SEB_IS_SINGLE_NO = "N";

	/**
	 * 多实例匹配策略"S1-简单匹配，查询工作流实例的实例匹配值=业务字段值的实例 S2-自定义匹配，查询工作流实例的实例匹配值=业务自定义类执行结果的实例"
	 * 
	 */
	public static final String SEB_MATCH_STRATEGY_SIMPLE = "S1";
	public static final String SEB_MATCH_STRATEGY_SELFDEFINE = "S2";

	////////////////////// 结点信息表////////////////////////////
	/**
	 * 事件类型 "E1-执行 E2-审批 E3-复核 E4-会审"
	 * 
	 */
	public static final String SWN_EVENT_TYPE_EXECUTE = "E1";
	public static final String SWN_EVENT_TYPE_APPROVE = "E2";
	public static final String SWN_EVENT_TYPE_CHECK = "E3";
	public static final String SWN_EVENT_TYPE_JOINTTRIAL = "E4";

	/**
	 * 事件执行方式 "T1-只执行工作流 T2-调用业务，工作流与业务同步 T3-发送消息给业务，等待成功回执再继续执行 T4-发送消息给业务，直接继续执行"
	 * 
	 */
	public static final String SWN_EVENT_RULE_WKFONLY = "T1";
	public static final String SWN_EVENT_RULE_SERVICESYN = "T2";
	public static final String SWN_EVENT_RULE_MQSYN = "T3";
	public static final String SWN_EVENT_RULE_MQASYN = "T4";

	/**
	 * 数据记录方式 "R1-不记录 R2-字段 R3-报文"
	 * 
	 */
	public static final String SWN_RECORD_TYPE_NONE = "R1";
	public static final String SWN_RECORD_TYPE_STRING = "R2";
	public static final String SWN_RECORD_TYPE_PKG = "R3";

	/**
	 * 路由策略 "A1-界面选择下一结点 A2-下一结点中的随机结点  A4-多分支并行下一结点 A5-自定义
	 * 
	 */
	public static final String SWN_ROUTE_STRATEGY_VIEWCHOOSE = "A1";
	public static final String SWN_ROUTE_STRATEGY_RANDOM = "A2";
	public static final String SWN_ROUTE_STRATEGY_NEXTGROUP = "A4";
	public static final String SWN_ROUTE_STRATEGY_SELFDEFINE = "A5";

	/**
	 * 回退策略 "C1-回退到上一结点 C2-终止流程 C3-回退到指定结点 C4-自定义"
	 * 
	 */
	public static final String SWN_BACK_STRATEGY_LAST = "C1";
	public static final String SWN_BACK_STRATEGY_FINISH = "C2";
	public static final String SWN_BACK_STRATEGY_VIEWCHOOSE = "C3";
	public static final String SWN_BACK_STRATEGY_SELFDEFINE = "C4";

	/**
	 * 分支处理策略 "B1-等待所有分支完成后继续执行主干 B2-一条分支完成后继续执行主干，其它分支关闭 B3-自定义"
	 * 
	 */
	public static final String SWN_BRANCH_STRATEGY_ALLFINISH = "B1";
	public static final String SWN_BRANCH_STRATEGY_ONEFINISH = "B2";
	public static final String SWN_BRANCH_STRATEGY_SELFDEFINE = "B3";

	/**
	 * 是否自动执行 "Y-是 N-否"
	 * 
	 */
	public static final String SWN_IS_AUTO_YES = "Y";
	public static final String SWN_IS_AUTO_NO = "N";

	/**
	 * 结点状态 "A-正常 C-关闭"
	 * 
	 */
	public static final String SWN_NODE_STATUS_ACTIVE = "A";
	public static final String SWN_NODE_STATUS_CLOSE = "C";

	//////////////////////// 流程执行记录表/////////////////////////
	/**
	 * 执行状态 ERR:出错中断 FAT:主干流程中 SUB:分支流程中 FIN:完成
	 */
	public static final String SRC_RECORD_STATUS_ERROR = "ERR";
	public static final String SRC_RECORD_STATUS_FATBRANCH = "FAT";
	public static final String SRC_RECORD_STATUS_SUBBRANCE = "SUB";
	public static final String SRC_RECORD_STATUS_FINISH = "FIN";

	//////////////////////// 流程执行记录明细表/////////////////////////
	/**
	 * 事件选择标志"审批标志、复核标志 Y-通过 N-否决"
	 * 
	 */
	public static final String SRD_EVENT_FLAG_AGREE = "Y";
	public static final String SRD_EVENT_FLAG_REJECT = "N";

	/**
	 * 执行后状态 "ERR-出错中断 FAT-主干流程中 SUB-分支流程中 FIN-完成"
	 * 
	 */
	public static final String SRD_RECORD_STATUS_ERROR = "ERR";
	public static final String SRD_RECORD_STATUS_FATBRANCH = "FAT";
	public static final String SRD_RECORD_STATUS_SUBBRANCH = "SUB";
	public static final String SRD_RECORD_STATUS_FINISH = "FIN";

	///////////////// 流程待办表/////////////////////////
	/**
	 * 是否分支中标志"Y-是 N-否"
	 * 
	 */
	public static final String SWS_BRANCH_FLAG_YES = "Y";
	public static final String SWS_BRANCH_FLAG_NO = "N";

	/**
	 * 状态"RDY-待办 CHK-签收 WAT-等待 CLS-关闭 FIN-完成"
	 * 
	 * 
	 */
	public static final String SWS_SCHEDULE_STATUS_READY = "RDY";
	public static final String SWS_SCHEDULE_STATUS_CHECK = "CHK";
	public static final String SWS_SCHEDULE_STATUS_WAIT = "WAT";
	public static final String SWS_SCHEDULE_STATUS_CLOSE = "CLS";
	public static final String SWS_SCHEDULE_STATUS_FINISH = "FIN";
}
