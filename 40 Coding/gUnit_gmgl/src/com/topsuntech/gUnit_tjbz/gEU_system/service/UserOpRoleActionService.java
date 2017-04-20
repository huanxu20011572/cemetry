package com.topsuntech.gUnit_tjbz.gEU_system.service;

import java.util.Hashtable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topsuntech.gOS.query.TSDBException;
import com.topsuntech.gUnit_tjbz.gEU_system.entity.UserOpRole;
import com.topsuntech.gUnit_tjbz.gEU_system.service.dao.UserOpRoleDAO;
import com.topsuntech.gUnit_tjbz.gEU_system.service.vo.UserOpRoleQueryBean;

@Service
public class UserOpRoleActionService {
	@Autowired
	private UserOpRoleDAO userOpRoleDAO;
	public Hashtable<Long, UserOpRole> getUserOpRoleByUserId(UserOpRoleQueryBean userOpRoleQueryBean) throws TSDBException {
		return userOpRoleDAO.getUserOpRoleByUserId(userOpRoleQueryBean);
	}

}
