/**
 * @PROJECT 
 * @DATE 2018年2月17日 下午10:22:42
 * @AUTHOR LUYU
 */
package com.kool.evowkf.engine;

import java.util.HashMap;
import java.util.List;

import com.kool.core.exception.BusException;
import com.kool.core.util.SpringContextUtil;
import com.kool.core.util.StringUtils;
import com.kool.evowkf.bean.SyWkfDefineBean;
import com.kool.evowkf.bean.SyWkfEntityBean;
import com.kool.evowkf.bean.SyWkfNodeBean;
import com.kool.evowkf.bean.SyWkfRouteBean;
import com.kool.evowkf.dao.SyWkfDefineDao;
import com.kool.evowkf.dao.SyWkfEntityDao;
import com.kool.evowkf.dao.SyWkfNodeDao;
import com.kool.evowkf.dao.SyWkfRouteDao;

/**
 * @DESCRIBE
 * @AUTHOR LUYU
 * @DATE 2018年2月17日 下午10:22:42
 *
 */
public class WKFContextHelper {
	/**
	 * 
	 * @DESCRIBE 初始化上下文的工作流定义、工作流实例、实例关联的路由集合、实例关联的结点集合
	 * @DATE 2018年2月18日 上午11:06:40
	 *
	 * @param entityId
	 * @param wkfInfo
	 * @throws BusException
	 */
	public static void initWkfCfg(String entityId, WKFContext wkfInfo) throws BusException {
		if (StringUtils.isEmpty(entityId)) {
			throw new BusException("工作流实例编号不能为空");
		}
		if (null == wkfInfo) {
			throw new BusException("工作流上下文不能为空");
		}

		// 获取工作流实例
		SyWkfEntityBean entityInfo = new SyWkfEntityBean();
		entityInfo.setSweEntityId(entityId);
		SyWkfEntityDao entityDao = (SyWkfEntityDao) SpringContextUtil.getBean("SyWkfEntityDao");
		SyWkfEntityBean entity = entityDao.selectByPK(entityInfo);
		if (null == entity) {
			throw new BusException("获取工作流实例结果为空");
		}
		wkfInfo.setEntity(entity);

		// 获取工作流定义
		SyWkfDefineBean defineInfo = new SyWkfDefineBean();
		defineInfo.setSwdWkfCode(entity.getSweWkfCode());
		SyWkfDefineDao defineDao = (SyWkfDefineDao) SpringContextUtil.getBean("SyWkfDefineDao");
		SyWkfDefineBean define = defineDao.selectByPK(defineInfo);
		if (null == define) {
			throw new BusException("获取工作流定义结果为空");
		}
		wkfInfo.setDefine(define);

		// 获取路由
		SyWkfRouteBean routeInfo = new SyWkfRouteBean();
		routeInfo.setSwrEntityId(entityId);
		SyWkfRouteDao routeDao = (SyWkfRouteDao) SpringContextUtil.getBean("SyWkfRouteDao");
		List<SyWkfRouteBean> listRoutes = routeDao.select(routeInfo);
		if (null == listRoutes || listRoutes.size() <= 0) {
			throw new BusException("获取路由结果为空");
		}
		wkfInfo.setRoutes(listRoutes);

		// 获取结点
		SyWkfNodeBean nodeInfo = new SyWkfNodeBean();
		nodeInfo.setSwnEntityId(entityId);
		SyWkfNodeDao nodeDao = (SyWkfNodeDao) SpringContextUtil.getBean("SyWkfNodeDao");
		List<SyWkfNodeBean> listNodes = nodeDao.select(nodeInfo);
		if (null == listNodes || listNodes.size() <= 0) {
			throw new BusException("获取结点结果为空");
		}
		HashMap<String, SyWkfNodeBean> mapNodes = new HashMap<>();
		for (SyWkfNodeBean node : listNodes) {
			mapNodes.put(node.getSwnNodeId(), node);
		}
		wkfInfo.setNodes(mapNodes);
	}
}
