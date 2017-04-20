package com.topsuntech.gUnit_gmgl.gEU_business.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Hibernate;
import org.hibernate.type.Type;

import com.topsuntech.gUnit_gmgl.core.HibernateBaseService;
import com.topsuntech.gUnit_gmgl.core.Page;
import com.topsuntech.gUnit_gmgl.gEU_business.entity.ArchivesCemeteryRegistry;
import com.topsuntech.gUnit_gmgl.gEU_business.entity.BusinessData;
import com.topsuntech.gUnit_gmgl.gEU_business.entity.CemeteryCertificate;

public class CemeteryCertificateService extends HibernateBaseService {
	
	/**
	 * 获得补证列表
	 * @param page
	 * @param cemeteryType
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<CemeteryCertificate> getCemeteryCertificateList(Page page, CemeteryCertificate cemeteryCertificate) {
		logger.debug("page list param:" + cemeteryCertificate);
		
		StringBuffer querySql = new StringBuffer(" FROM CemeteryCertificate bt WHERE 1=1  ");
		List<Type> typelist = new ArrayList<Type>();
		List<Object> objlist = new ArrayList<Object>();
		if(StringUtils.isNotEmpty(cemeteryCertificate.getArchivesCemeteryRegistry().getCemeteryRegistryCode())){
			querySql.append(" and bt.archivesCemeteryRegistry.cemeteryRegistryCode like ? ");
			objlist.add("%" + cemeteryCertificate.getArchivesCemeteryRegistry().getCemeteryRegistryCode() + "%");
			typelist.add(Hibernate.STRING);
		}
		if(StringUtils.isNotEmpty(cemeteryCertificate.getArchivesCemeteryRegistry().getName())){
			querySql.append(" and bt.archivesCemeteryRegistry.name like ? ");
			objlist.add("%" + cemeteryCertificate.getArchivesCemeteryRegistry().getName() + "%");
			typelist.add(Hibernate.STRING);
		}
		if(StringUtils.isNotEmpty(cemeteryCertificate.getArchivesCemeteryRegistry().getMobilePhone())){
			querySql.append(" and bt.archivesCemeteryRegistry.mobilePhone like ? ");
			objlist.add("%" + cemeteryCertificate.getArchivesCemeteryRegistry().getMobilePhone() + "%");
			typelist.add(Hibernate.STRING);
		}
		if(cemeteryCertificate.getArchivesCemeteryRegistry().getCemeteryLocation().getId()!=null && 
				cemeteryCertificate.getArchivesCemeteryRegistry().getCemeteryLocation().getId().longValue()!=0){
			querySql.append(" and bt.archivesCemeteryRegistry.cemeteryLocation.id = ? ");
			objlist.add(cemeteryCertificate.getArchivesCemeteryRegistry().getCemeteryLocation().getId());
			typelist.add(Hibernate.LONG);
		}
		if(cemeteryCertificate.getCreateOrgId()!=null){
			querySql.append(" and bt.createOrgId = ? ");
			objlist.add(cemeteryCertificate.getCreateOrgId());
			typelist.add(Hibernate.LONG);
		}

		querySql.append(" ORDER BY bt.createDate desc ");
		
		StringBuffer countSql = new StringBuffer();
		countSql.append(" SELECT COUNT(bt.id) ").append(querySql);
		Type[] type = new Type[typelist.size()];
		System.arraycopy(typelist.toArray(), 0, type, 0, type.length);
		
		return (List<CemeteryCertificate>) getPageList(page, querySql.toString(), countSql.toString(), objlist.toArray(), type);
	}
	
//	/**
//	 * 根据ID获取补证信息
//	 * @param id
//	 * @return
//	 */
	public CemeteryCertificate getCemeteryCertificate(Long id) {
		CemeteryCertificate  cemeteryCertificate= load(CemeteryCertificate.class, id);
		if(cemeteryCertificate !=null){
			return cemeteryCertificate;
		}else{
			return null;
		}
	}
	/**
	 * 查询业务分类
	 * @param businessData
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<BusinessData> getBusinessDataList() {

		StringBuffer querySql = new StringBuffer(" FROM BusinessData bt WHERE 1=1");

		querySql.append(" ORDER BY bt.id");


		return (List<BusinessData>) find(querySql.toString());
	}

	/**
	 * 添加或修改补证
	 * @param command
	 */
	public void saveCemeteryCertificate(CemeteryCertificate command) {
		 CemeteryCertificate type = null;
		if(command.getId()!=null && command.getId().longValue()> 0){
			//id>0编辑
			type = load(CemeteryCertificate.class, command.getId());
		}else{
			//新增
			type = new CemeteryCertificate();
			type.setCreateUserId(command.getCreateUserId());
			type.setCreateOrgId(command.getCreateOrgId());
			type.setCreateDate(new Date());
			Long archivesCemeteryRegistryId = command.getArchivesCemeteryRegistryId();
			
			ArchivesCemeteryRegistry archivesCemeteryRegistry = load(ArchivesCemeteryRegistry.class, archivesCemeteryRegistryId);
			type.setArchivesCemeteryRegistry(archivesCemeteryRegistry);
		}
		
		type.setCharge(command.getCharge());
		type.setReason(command.getReason());
		type.setRemark(command.getRemark());
		
		saveOrUpdate(type);

	}

	/**
	 * 根据ID删除补证
	 * @param id
	 */
	public void deleteCemeteryCertificate(Long id) {
		CemeteryCertificate cemeteryCertificate = load(CemeteryCertificate.class, id);
		delete(cemeteryCertificate);
	}
}
