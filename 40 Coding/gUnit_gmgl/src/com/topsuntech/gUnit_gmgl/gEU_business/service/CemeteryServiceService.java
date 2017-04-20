package com.topsuntech.gUnit_gmgl.gEU_business.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Hibernate;
import org.hibernate.type.Type;

import com.topsuntech.gUnit_gmgl.Constant;
import com.topsuntech.gUnit_gmgl.core.HibernateBaseService;
import com.topsuntech.gUnit_gmgl.core.Page;
import com.topsuntech.gUnit_gmgl.gEU_business.entity.ArchivesCemeteryRegistry;
import com.topsuntech.gUnit_gmgl.gEU_business.entity.CemeteryService;
import com.topsuntech.gUnit_gmgl.gEU_charge.entity.ChargeData;
import com.topsuntech.gUnit_gmgl.gEU_charge.entity.ChargeType;

public class CemeteryServiceService extends HibernateBaseService {

	public List<CemeteryService> getCemeteryServicePageList(Page page, ArchivesCemeteryRegistry registry) {
		logger.debug("page list param:" + registry);

		StringBuffer querySql = new StringBuffer(" FROM CemeteryService cs WHERE 1=1 ");
		List<Type> typelist = new ArrayList<Type>();
		List<Object> objlist = new ArrayList<Object>();
		// 业务编号：
		if (StringUtils.isNotEmpty(registry.getCemeteryRegistryCode())) {
			querySql.append(" and cs.archivesCemeteryRegistry.cemeteryRegistryCode like ? ");
			objlist.add("%" + registry.getCemeteryRegistryCode() + "%");
			typelist.add(Hibernate.STRING);
		}
		// 登承租人name
		if (StringUtils.isNotEmpty(registry.getName())) {
			querySql.append(" and cs.archivesCemeteryRegistry.name like ? ");
			objlist.add("%" + registry.getName() + "%");
			typelist.add(Hibernate.STRING);
		}
		// 联系电话
		if (StringUtils.isNotEmpty(registry.getMobilePhone())) {
			querySql.append(" and cs.archivesCemeteryRegistry.mobilePhone like ? ");
			objlist.add("%" + registry.getMobilePhone() + "%");
			typelist.add(Hibernate.STRING);
		}
		// 墓位ID
		if (null != registry.getCemeteryLocationId()) {
			querySql.append(" and cs.archivesCemeteryRegistry.cemeteryLocation.id = ? ");
			objlist.add(registry.getCemeteryLocationId());
			typelist.add(Hibernate.LONG);
		}
		if (null != registry.getCreateOrgId() && 0 != registry.getCreateOrgId()) {
			querySql.append(" and cs.createOrgId = ?");
			objlist.add(registry.getCreateOrgId());
			typelist.add(Hibernate.LONG);
		}
		StringBuffer countSql = new StringBuffer();
		countSql.append(" SELECT COUNT(cs.id) ").append(querySql);
		Type[] type = new Type[typelist.size()];
		System.arraycopy(typelist.toArray(), 0, type, 0, type.length);

		return (List<CemeteryService>) getPageList(page, querySql.toString(), countSql.toString(), objlist.toArray(), type);

	}

	public void saveCemeteryService(CemeteryService cemeteryService, Long registryId) {
		logger.debug("page input list param:" + cemeteryService);
		CemeteryService cdata = null;
		if (cemeteryService.getId() != null && cemeteryService.getId().longValue() > 0) {
			// id>0编辑
			cdata = load(CemeteryService.class, cemeteryService.getId());
		} else {
			// 新增
			cdata = new CemeteryService();
			ArchivesCemeteryRegistry registry = load(ArchivesCemeteryRegistry.class, registryId);
			cdata.setArchivesCemeteryRegistry(registry);
		}

		// 是否有公共方法实现对象拷贝
		cdata.setCreateDate(new Date());
		cdata.setCreateOrgId(cemeteryService.getCreateOrgId());
		cdata.setCreateUserId(cemeteryService.getCreateUserId());
		cdata.setItem(cemeteryService.getItem());
		cdata.setBegindate(cemeteryService.getBegindate());
		cdata.setEnddate(cemeteryService.getEnddate());
		cdata.setPrice(cemeteryService.getPrice());
		cdata.setContents(cemeteryService.getContents());
		cdata.setRemark(cemeteryService.getRemark());
		saveOrUpdate(cdata);
	}

	public void deleteCemeteryService(Long id) {
		this.delete(load(CemeteryService.class, id));
	}
}
