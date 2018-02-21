/**
 * @PROJECT 
 * @DATE 2018年2月13日 下午5:59:02
 * @AUTHOR LUYU
 */
package com.kool.evowkf.engine;

import java.util.List;
import java.util.Map;

import com.kool.core.context.BaseContext;
import com.kool.evowkf.bean.SyWkfDefineBean;
import com.kool.evowkf.bean.SyWkfEntityBean;
import com.kool.evowkf.bean.SyWkfNodeBean;
import com.kool.evowkf.bean.SyWkfRouteBean;
import com.kool.evowkf.bean.vo.BusinessValue;
import com.kool.evowkf.bean.vo.MatchValue;

/**
 * @DESCRIBE 工作流上下文
 * @AUTHOR LUYU
 * @DATE 2018年2月13日 下午5:59:02
 *
 */
public class WKFContext extends BaseContext {
	// 工作流定义
	private SyWkfDefineBean define;
	// 工作流实例
	private SyWkfEntityBean entity;
	// 一个实例的结点集合，key=结点编号，value=结点
	private Map<String, SyWkfNodeBean> nodes;
	// 一个实例的路由集合，key=首结点编号，value=路由
	private List<SyWkfRouteBean> routes;

	// 关联业务流水号
	private String businessId;
	// 关联业务类型 非空
	private String businessType;
	// 用户号 非空
	private String userId;
	// 登录名 非空
	private String loginName;
	// 流程概要描述、事件摘要
	private String description;
	// 工作流实例匹配值
	private MatchValue matchValue;

	// 待办编号
	private String scheduleId;
	// 执行记录编号 非空
	private String recordId;
	// 执行记录明细编号
	private String recordDetailId;

	// 审批标志
	private String approveFlag;
	// 复核标志
	private String checkFlag;

	// 业务数据
	private BusinessValue businessValue;
	// 附加数据
	private String extData;

	/**
	 * @return the define
	 */
	public SyWkfDefineBean getDefine() {
		return define;
	}

	/**
	 * @param define
	 *            the define to set
	 */
	public void setDefine(SyWkfDefineBean define) {
		this.define = define;
	}

	/**
	 * @return the entity
	 */
	public SyWkfEntityBean getEntity() {
		return entity;
	}

	/**
	 * @param entity
	 *            the entity to set
	 */
	public void setEntity(SyWkfEntityBean entity) {
		this.entity = entity;
	}

	/**
	 * @return the nodes
	 */
	public Map<String, SyWkfNodeBean> getNodes() {
		return nodes;
	}

	/**
	 * @param nodes
	 *            the nodes to set
	 */
	public void setNodes(Map<String, SyWkfNodeBean> nodes) {
		this.nodes = nodes;
	}

	/**
	 * @return the routes
	 */
	public List<SyWkfRouteBean> getRoutes() {
		return routes;
	}

	/**
	 * @param routes
	 *            the routes to set
	 */
	public void setRoutes(List<SyWkfRouteBean> routes) {
		this.routes = routes;
	}

	/**
	 * @return the businessId
	 */
	public String getBusinessId() {
		return businessId;
	}

	/**
	 * @param businessId
	 *            the businessId to set
	 */
	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}

	/**
	 * @return the businessType
	 */
	public String getBusinessType() {
		return businessType;
	}

	/**
	 * @param businessType
	 *            the businessType to set
	 */
	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the loginName
	 */
	public String getLoginName() {
		return loginName;
	}

	/**
	 * @param loginName
	 *            the loginName to set
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the matchValue
	 */
	public MatchValue getMatchValue() {
		return matchValue;
	}

	/**
	 * @param matchValue
	 *            the matchValue to set
	 */
	public void setMatchValue(MatchValue matchValue) {
		this.matchValue = matchValue;
	}

	/**
	 * @return the scheduleId
	 */
	public String getScheduleId() {
		return scheduleId;
	}

	/**
	 * @param scheduleId
	 *            the scheduleId to set
	 */
	public void setScheduleId(String scheduleId) {
		this.scheduleId = scheduleId;
	}

	/**
	 * @return the recordId
	 */
	public String getRecordId() {
		return recordId;
	}

	/**
	 * @param recordId
	 *            the recordId to set
	 */
	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}

	/**
	 * @return the recordDetailId
	 */
	public String getRecordDetailId() {
		return recordDetailId;
	}

	/**
	 * @param recordDetailId
	 *            the recordDetailId to set
	 */
	public void setRecordDetailId(String recordDetailId) {
		this.recordDetailId = recordDetailId;
	}

	/**
	 * @return the approveFlag
	 */
	public String getApproveFlag() {
		return approveFlag;
	}

	/**
	 * @param approveFlag
	 *            the approveFlag to set
	 */
	public void setApproveFlag(String approveFlag) {
		this.approveFlag = approveFlag;
	}

	/**
	 * @return the checkFlag
	 */
	public String getCheckFlag() {
		return checkFlag;
	}

	/**
	 * @param checkFlag
	 *            the checkFlag to set
	 */
	public void setCheckFlag(String checkFlag) {
		this.checkFlag = checkFlag;
	}

	/**
	 * @return the businessValue
	 */
	public BusinessValue getBusinessValue() {
		return businessValue;
	}

	/**
	 * @param businessValue
	 *            the businessValue to set
	 */
	public void setBusinessValue(BusinessValue businessValue) {
		this.businessValue = businessValue;
	}

	/**
	 * @return the extData
	 */
	public String getExtData() {
		return extData;
	}

	/**
	 * @param extData
	 *            the extData to set
	 */
	public void setExtData(String extData) {
		this.extData = extData;
	}

}
