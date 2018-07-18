/**
 * @PROJECT 
 * @DATE 2018年2月17日 下午3:40:11
 * @AUTHOR LUYU
 */
package com.kool.evowkf.engine;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.kool.core.exception.AppException;
import com.kool.core.util.StringUtils;
import com.kool.evowkf.api.IBusinessEventHandler;
import com.kool.evowkf.bean.vo.BusinessEvent;

/**
 * @DESCRIBE
 * @AUTHOR LUYU
 * @DATE 2018年2月17日 下午3:40:11
 *
 */
public class T2EventRule implements IEventRule{
	private Logger logger = Logger.getLogger(T2EventRule.class);
	
	private String clazz;
	
	/**
	 * @return the clazz
	 */
	public String getClazz() {
		return clazz;
	}

	/**
	 * @param clazz the clazz to set
	 */
	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	/**
	 * @throws AppException 
	 * @DESCRIBE
	 * @DATE 2018年2月17日 下午3:40:28
	 *
	 */
	@Override
	public void DoRule(NodeEvent event) throws AppException {
		if (StringUtils.isEmpty(clazz) == false) {
			try {
				IBusinessEventHandler handler = (IBusinessEventHandler) Class.forName(clazz).newInstance();
				BusinessEvent busEvent = JSONObject.toJavaObject(JSONObject.parseObject(JSONObject.toJSONString(event.getWkfInfo())), BusinessEvent.class);
				handler.handle(busEvent);
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				logger.error(e);
				throw new AppException("结点事件执行实现类配置不正确");
			}
		}
	}

}
