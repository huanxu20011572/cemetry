package com.topsuntech.gUnit_gmgl.gEU_cemetery.service;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import com.topsuntech.gOS.user.en.user.User;
import com.topsuntech.gUnit_gmgl.core.HibernateBaseService;
import com.topsuntech.gUnit_gmgl.gEU_cemetery.entity.CemeteryFile;
import com.topsuntech.gUnit_gmgl.gEU_cemetery.entity.CemeteryRegistry;

public class CemeteryFileService extends HibernateBaseService {

	/**
	 * 添加文件上传信息
	 * 
	 * @param multipartFile
	 * @param user
	 * @param fileType
	 * @param filePath
	 * @return
	 */
	public CemeteryFile saveCemeteryFile(MultipartFile multipartFile, User user, String fileType, String filePath) {
		logger.debug("添加文件内容:" + multipartFile.getOriginalFilename() + "," + user);
		CemeteryFile cemeteryFile = new CemeteryFile();
		cemeteryFile.setFileName(multipartFile.getOriginalFilename());
		cemeteryFile.setFileSize(multipartFile.getSize());
		cemeteryFile.setFileType(fileType);
		cemeteryFile.setFilePath(filePath);
		cemeteryFile.setCreateDate(new Date());
		cemeteryFile.setCreateOrgId(user.getDeptid());
		cemeteryFile.setCreateUserId(user.getId());
		save(cemeteryFile);
		return cemeteryFile;
	}

	/**
	 * 添加业务文件
	 * 
	 * @param cemeteryRegistryId
	 *            :业务id
	 * @param fileIds
	 *            :文件id字符串,分隔
	 * @param remark
	 *            :文件备注
	 */
	public void saveCemeteryFileList(Long cemeteryRegistryId, String fileIds, String remark) {
		logger.debug("添加业务文件:" + cemeteryRegistryId + "," + fileIds);
		CemeteryRegistry cemeteryRegistry = load(CemeteryRegistry.class, cemeteryRegistryId);
		String[] file = fileIds.split(",");
		for (int i = 0; i < file.length; i++) {
			CemeteryFile cemeteryFile = load(CemeteryFile.class, Long.valueOf(file[i]));
			cemeteryFile.setCemeteryRegistry(cemeteryRegistry);
			cemeteryFile.setRemark(remark);
			update(cemeteryFile);
		}
	}

	public void deleteCemeteryFileById(Long id) {
		logger.debug("删除业务文件:" + id);
		delete(load(CemeteryFile.class, id));
	}

}
