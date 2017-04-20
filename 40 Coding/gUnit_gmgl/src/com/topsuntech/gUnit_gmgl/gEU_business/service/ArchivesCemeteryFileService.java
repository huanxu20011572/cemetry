package com.topsuntech.gUnit_gmgl.gEU_business.service;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import com.topsuntech.gOS.user.en.user.User;
import com.topsuntech.gUnit_gmgl.core.HibernateBaseService;
import com.topsuntech.gUnit_gmgl.gEU_business.entity.ArchivesCemeteryFile;
import com.topsuntech.gUnit_gmgl.gEU_business.entity.ArchivesCemeteryRegistry;

public class ArchivesCemeteryFileService extends HibernateBaseService {

	/**
	 * 添加文件上传信息
	 * 
	 * @param multipartFile
	 * @param user
	 * @param fileType
	 * @param filePath
	 * @return
	 */
	public ArchivesCemeteryFile saveCemeteryFile(MultipartFile multipartFile, User user, String fileType, String filePath) {
		logger.debug("添加文件内容:" + multipartFile.getOriginalFilename() + "," + user);
		ArchivesCemeteryFile cemeteryFile = new ArchivesCemeteryFile();
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
	 * 添加档案文件
	 * 
	 * @param archivesCemeteryRegistryId
	 *            :档案id
	 * @param fileIds
	 *            :文件id字符串,分隔
	 * @param remark
	 *            :文件备注
	 */
	public void saveCemeteryFileList(Long archivesCemeteryRegistryId, String fileIds, String remark) {
		logger.debug("添加档案文件:" + archivesCemeteryRegistryId + "," + fileIds);
		ArchivesCemeteryRegistry cemeteryRegistry = load(ArchivesCemeteryRegistry.class, archivesCemeteryRegistryId);
		String[] file = fileIds.split(",");
		for (int i = 0; i < file.length; i++) {
			ArchivesCemeteryFile cemeteryFile = load(ArchivesCemeteryFile.class, Long.valueOf(file[i]));
			cemeteryFile.setArchivesCemeteryRegistry(cemeteryRegistry);
			cemeteryFile.setRemark(remark);
			update(cemeteryFile);
		}
	}

	public void deleteCemeteryFileById(Long id) {
		logger.debug("删除档案文件:" + id);
		delete(load(ArchivesCemeteryFile.class, id));
	}

}
