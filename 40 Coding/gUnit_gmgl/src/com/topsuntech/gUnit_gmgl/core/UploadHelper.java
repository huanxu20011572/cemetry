package com.topsuntech.gUnit_gmgl.core;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * 处理上传文件
 * 
 * @author baiweiming
 * 
 */
public class UploadHelper {

	protected static final Log logger = LogFactory.getLog(UploadHelper.class);

	private MultipartHttpServletRequest request;

	public UploadHelper(HttpServletRequest request) {
		this.request = (MultipartHttpServletRequest) request;
	}

	/**
	 * 获取MultipartFile集合
	 * 
	 * @param maxLength
	 *            文件最大限制
	 * @param allowExtName
	 *            不允许上传的文件扩展名
	 * @return MultipartFile集合
	 */
	public List<MultipartFile> getFileMap(long maxLength, String[] allowExtName) {

		// 获得上传的文件（根据前台的name名称得到上传的文件）
		@SuppressWarnings("unchecked")
		Map<String, MultipartFile> files = request.getFileMap();
		List<MultipartFile> list = new ArrayList<MultipartFile>();
		Collection<MultipartFile> collection = files.values();
		for (Iterator<MultipartFile> iterator = collection.iterator(); iterator.hasNext();) {
			MultipartFile multipartFile = (MultipartFile) iterator.next();
			if (validateFile(multipartFile, maxLength, allowExtName)) {
				logger.debug("upload multipart files :" + multipartFile.getOriginalFilename() + "," + multipartFile.getSize());
				list.add(multipartFile);
			} else {
				logger.debug("upload multipart validate files fail:" + multipartFile.getOriginalFilename() + "," + multipartFile.getSize());
			}

		}
		return list;
	}

	/**
	 * @descrption 保存文件
	 * @param multipartFile
	 *            MultipartFile对象
	 * @param path
	 * @throws Exception
	 *             文件保存失败
	 */
	public String uploadFile(MultipartFile multipartFile, String path) throws Exception {

		if (!path.endsWith(File.separator)) {
			path = path + File.separator;
		}
		// 图片路径
		String prefix = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf(".") + 1);
		String filePath = path + UUID.randomUUID() + "." + prefix.toLowerCase();
		FileCopyUtils.copy(multipartFile.getBytes(), new File(filePath));

		logger.debug("copy upload file :" + filePath);

		return filePath;
	}

	/**
	 * 验证文件合法性
	 * 
	 * @param file
	 *            MultipartFile对象
	 * @param maxLength
	 *            最大限制
	 * @param allowExtName
	 *            不允许上传的扩展名
	 * @return 格式是否合法
	 */
	private boolean validateFile(MultipartFile file, long maxLength, String[] allowExtName) {
		if (file.getSize() < 0 || file.getSize() > maxLength)
			return false;
		String filename = file.getOriginalFilename();

		// 处理不选择文件点击上传时，也会有MultipartFile对象，在此进行过滤
		if (filename == "") {
			return false;
		}
		String extName = filename.substring(filename.lastIndexOf(".")).toLowerCase();
		if (allowExtName == null || allowExtName.length == 0 || Arrays.binarySearch(allowExtName, extName) != -1) {
			return true;
		} else {
			return false;
		}
	}

}
