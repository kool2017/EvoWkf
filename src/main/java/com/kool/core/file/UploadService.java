/**
 * @PROJECT 
 * @DATE 2018年7月14日 下午5:45:08
 * @AUTHOR LUYU
 */
package com.kool.core.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kool.core.CoreConstants;
import com.kool.core.bean.vo.FileVo;
import com.kool.core.exception.AppException;
import com.kool.core.util.FileUtils;
import com.kool.core.util.PropertyUtils;
import com.kool.core.util.StringUtils;

/**
 * @DESCRIBE 文件上传业务处理类
 * @AUTHOR LUYU
 * @DATE 2018年7月14日 下午5:45:08
 *
 */
@Service
public class UploadService {
	private static Logger logger = Logger.getLogger(UploadService.class);

	/**
	 * 
	 * @DESCRIBE 上传头像
	 * @DATE 2018年7月14日 下午6:01:03
	 *
	 * @param uploadFile
	 * @return
	 * @throws AppException
	 */
	public FileVo uploadFace(MultipartFile uploadFile) throws AppException {
		FileVo fileVo = new FileVo();
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		// 新文件名
		String newFileName = StringUtils.getUUID() + ".jpg";
		try {
			// 文件类型
			String contentType = uploadFile.getContentType();
			fileVo.setFileType(contentType);
			// 头像文件存放路径
			String dirPath = PropertyUtils.getValue(CoreConstants.PROP_FACE_UPLOAD_PATH);
			File fDir = new File(dirPath);
			if (fDir.exists() == false) {
				fDir.mkdirs();
			}
			// 文件保存路径
			String filePath = new StringBuffer().append(dirPath).append(FileUtils.getSeparator()).append(newFileName)
					.toString();
			InputStream is = uploadFile.getInputStream();
			bis = new BufferedInputStream(is);
			bos = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
			byte[] buff = new byte[1024];
			int hasRead = 0;
			while ((hasRead = bis.read(buff)) != -1) {
				bos.write(buff, 0, hasRead);
			}

			bos.flush();
			bos.close();
			bis.close();
		} catch (IOException e) {
			logger.error("上传头像失败！", e);
			try {
				if (bos != null) {
					bos.close();
				}
			} catch (IOException e1) {
				logger.error("上传头像失败！", e1);
			}
			try {
				if (bis != null) {
					bis.close();
				}
			} catch (IOException e1) {
				logger.error("上传头像失败！", e1);
			}
			throw new AppException("SY000049", e);// 上传头像失败！
		}

		String faceUrl = PropertyUtils.getValue(CoreConstants.PROP_FACE_URL);
		fileVo.setFileName(newFileName);
		fileVo.setFileUrl(faceUrl + "/" + newFileName);
		return fileVo;
	}
}
