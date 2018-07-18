/**
 * @PROJECT 
 * @DATE 2018年7月14日 上午10:57:42
 * @AUTHOR LUYU
 */
package com.kool.system.action.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.kool.core.base.IUploadAction;
import com.kool.core.bean.vo.FileVo;
import com.kool.core.exception.AppException;
import com.kool.core.file.UploadService;

/**
 * @DESCRIBE 上传头像
 * @AUTHOR LUYU
 * @DATE 2018年7月14日 上午10:57:42
 *
 */
@Controller
public class UploadFaceAction implements IUploadAction {
	@Autowired
	private UploadService service;

	/**
	 * @DESCRIBE
	 * @DATE 2018年7月14日 下午2:50:06
	 *
	 * @param sInput
	 * @param uploadFile
	 * @return
	 * @throws AppException
	 */
	@ResponseBody
	@RequestMapping(value = "/sys/user/uploadFace", method = RequestMethod.POST)
	public JSONObject doAction(@RequestParam("file") MultipartFile uploadFile) throws AppException {

		JSONObject joOut = new JSONObject();
		FileVo fileVo = service.uploadFace(uploadFile);
		if (fileVo != null) {
			joOut.put("fileName", fileVo.getFileName());
			joOut.put("fileUrl", fileVo.getFileUrl());
		}
		return joOut;
	}

}
