/**
 * @PROJECT 
 * @DATE 2018年2月15日 下午8:00:41
 * @AUTHOR LUYU
 */
package com.kool.evowkf.engine;

import com.kool.system.bean.io.SYPAGEINFOYBean;
import com.kool.system.bean.vo.PageResult;

/**
 * @DESCRIBE
 * @AUTHOR LUYU
 * @DATE 2018年2月15日 下午8:00:41
 *
 */
public interface ISchedule {
	public PageResult querySchedule(String recordId, String businessType, String userId, String loginName, SYPAGEINFOYBean pageInfo);
}
