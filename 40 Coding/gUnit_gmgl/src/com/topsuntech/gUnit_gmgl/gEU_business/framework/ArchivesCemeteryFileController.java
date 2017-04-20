package com.topsuntech.gUnit_gmgl.gEU_business.framework;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.topsuntech.gOS.user.en.user.User;
import com.topsuntech.gOS.user.session.UserSession;
import com.topsuntech.gUnit_gmgl.Constant;
import com.topsuntech.gUnit_gmgl.core.AbstractMultiController;
import com.topsuntech.gUnit_gmgl.core.UploadHelper;
import com.topsuntech.gUnit_gmgl.gEU_business.entity.ArchivesCemeteryFile;
import com.topsuntech.gUnit_gmgl.gEU_business.service.ArchivesCemeteryFileService;

public class ArchivesCemeteryFileController extends AbstractMultiController {

	private ArchivesCemeteryFileService archivesCemeteryFileService;

	/**
	 * 上次图片最大2m
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView uploadPic(HttpServletRequest request, HttpServletResponse response) throws Exception {
		User user = UserSession.getUser(request);
		UploadHelper helper = new UploadHelper(request);
		List<ArchivesCemeteryFile> list = new ArrayList<ArchivesCemeteryFile>();
		//上传文件
		List<MultipartFile> multipartFiles = helper.getFileMap(1024 * 20, null);
		for (MultipartFile multipartFile : multipartFiles) {
			String filePath = helper.uploadFile(multipartFile, getPicServerPath());
			ArchivesCemeteryFile file = archivesCemeteryFileService.saveCemeteryFile(multipartFile, user, Constant.FILE_TYPE_PIC+"", new File(filePath).getName());
			list.add(file);
		}
		ajaxResult(response, list);
		return null;
	}

	/**
	 * 上传文件最大10m
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView uploadFile(HttpServletRequest request, HttpServletResponse response) throws Exception {
		User user = UserSession.getUser(request);
		UploadHelper helper = new UploadHelper(request);
		List<ArchivesCemeteryFile> list = new ArrayList<ArchivesCemeteryFile>();
		//上传文件
		List<MultipartFile> multipartFiles = helper.getFileMap(1024 * 1024 * 10, null);
		for (MultipartFile multipartFile : multipartFiles) {
			String filePath = helper.uploadFile(multipartFile, getFileServerPath());
			ArchivesCemeteryFile file = archivesCemeteryFileService.saveCemeteryFile(multipartFile, user, Constant.FILE_TYPE_ATT+"", new File(filePath).getName());
			list.add(file);
		}
		ajaxResult(response, list);
		return null;
	}

	@Override
	protected void preBind(HttpServletRequest request, Object command, ServletRequestDataBinder binder) {
		// TODO Auto-generated method stub

	}

	public void setArchivesCemeteryFileService(ArchivesCemeteryFileService archivesCemeteryFileService) {
		this.archivesCemeteryFileService = archivesCemeteryFileService;
	}

}
