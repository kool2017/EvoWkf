/**
 * @PROJECT 
 * @DATE 2018年7月14日 下午2:47:15
 * @AUTHOR LUYU
 */
package com.kool.core.base;

import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.kool.core.exception.AppException;

/**
 * @DESCRIBE 文件上传请求处理接口
 * @AUTHOR LUYU
 * @DATE 2018年7月14日 下午2:47:15
 *
 */
public interface IUploadAction {
	public JSONObject doAction(MultipartFile uploadFile) throws AppException;
}
