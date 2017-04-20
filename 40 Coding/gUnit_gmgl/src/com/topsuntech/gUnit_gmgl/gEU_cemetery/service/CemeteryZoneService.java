package com.topsuntech.gUnit_gmgl.gEU_cemetery.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.type.Type;

import com.topsuntech.gUnit_gmgl.core.HibernateBaseService;
import com.topsuntech.gUnit_gmgl.core.Page;
import com.topsuntech.gUnit_gmgl.gEU_cemetery.entity.CemeteryZone;

public class CemeteryZoneService extends HibernateBaseService {
	/**
	 * 根据ID查询
	 * 
	 * @param id
	 * @return
	 */
	public CemeteryZone getCemeteryZoneById(Long id) {
		return load(CemeteryZone.class, id);
	}

	/**
	 * 
	 * @param pid
	 * @return
	 */
	public List<CemeteryZone> getCemeteryZoneTreeNodeByPid(Long pid, Long createOrgid,Long level) {
		StringBuffer querySql = new StringBuffer(" FROM CemeteryZone cd WHERE cd.parent.id=? ");
		//市级用户查询所有机构信息,市级level=1
		if(level!=null && level.longValue() >1){
			querySql.append(" and cd.createOrgId = " + createOrgid);
			
		}
		querySql.append(" order by sort asc");

		return (List<CemeteryZone>) super.find(querySql.toString(), pid);

	}

	/**
	 * 根据PID获取业务分类树
	 * 
	 * @param pid
	 * @return
	 */
	public List<CemeteryZone> getCemeteryZoneListByPID(Page page, Long pid, Long createOrgid) {
		StringBuffer querySql = new StringBuffer(
				" FROM CemeteryZone cd WHERE cd.parent.id=? and cd.createOrgId=? order by sort asc");
		StringBuffer countSql = new StringBuffer();
		countSql.append(" SELECT COUNT(cd.id) ").append(querySql);
		List<Type> typelist = new ArrayList<Type>();
		typelist.add(Hibernate.LONG);
		typelist.add(Hibernate.LONG);
		List<Object> objlist = new ArrayList<Object>();
		objlist.add(pid);
		objlist.add(createOrgid);
		Type[] type = new Type[typelist.size()];
		System.arraycopy(typelist.toArray(), 0, type, 0, type.length);
		List<CemeteryZone> rs = (List<CemeteryZone>) getPageList(page, querySql.toString(), countSql.toString(), objlist.toArray(), type);
		return rs;
	}

	/**
	 * 根据ID 删除分区
	 * 
	 * @param id
	 */
	public void deleteCemeteryZoneById(Long id) {
		CemeteryZone zone = get(CemeteryZone.class, id);
		delete(zone);
	}

	/**
	 * 
	 * @param command
	 * @param pid
	 */
	public void saveCemeteryZone(CemeteryZone command, Long pid) {
		CemeteryZone type = null;
		if (command.getId() != null && command.getId().longValue() > 0) {
			// id>0编辑
			type = load(CemeteryZone.class, command.getId());
		} else if (pid != null && pid.longValue() >= 0) {
			// 新增
			type = new CemeteryZone();
			type.setParent(load(CemeteryZone.class, pid));
		}
		type.setCemeteryLocations(command.getCemeteryLocations());
		type.setCemeteryZoneName(command.getCemeteryZoneName());
		type.setCreateOrgId(command.getCreateOrgId());
		type.setCreateUserId(command.getCreateUserId());
		type.setCreateDate(command.getCreateDate());
		type.setIsValidate(command.getIsValidate());
		type.setRemark(command.getRemark());
		type.setSort(command.getSort());
		saveOrUpdate(type);
	}
}
