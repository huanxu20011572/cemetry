package com.topsuntech.gUnit_gmgl.gEU_business.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.type.Type;

import com.topsuntech.gUnit_gmgl.core.HibernateBaseService;
import com.topsuntech.gUnit_gmgl.core.Page;
import com.topsuntech.gUnit_gmgl.gEU_business.entity.ArchivesCemeteryRegistry;
import com.topsuntech.gUnit_gmgl.gEU_business.entity.VisitReturn;
import com.topsuntech.gUnit_gmgl.gEU_cemetery.entity.CemeteryRegistry;

public class FirstPageService extends HibernateBaseService {
	
	
	/**
	 * 待回访提醒列表
	 * @param page
	 * @param visitReturn
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<VisitReturn> getVisitReturnList(Page page, VisitReturn visitReturn) {
		logger.debug("page list param:" + visitReturn);
		StringBuffer querySql = new StringBuffer(" FROM VisitReturn bt WHERE 1=1");
		List<Type> typelist = new ArrayList<Type>();
		List<Object> objlist = new ArrayList<Object>();
		if(visitReturn.getIsReturn()!=null){
			querySql.append(" and bt.isReturn = ? ");
			objlist.add(visitReturn.getIsReturn());
			typelist.add(Hibernate.LONG);
		}
		if(visitReturn.getCreateOrgId()!=null){
			querySql.append(" and bt.createOrgId = ? ");
			objlist.add(visitReturn.getCreateOrgId());
			typelist.add(Hibernate.LONG);
		}
		querySql.append(" ORDER BY bt.createDate desc");

		StringBuffer countSql = new StringBuffer();
		countSql.append(" SELECT COUNT(*) ").append(querySql);
		Type[] type = new Type[typelist.size()];
		System.arraycopy(typelist.toArray(), 0, type, 0, type.length);

		return (List<VisitReturn>) getPageList(page, querySql.toString(), countSql.toString(), objlist.toArray(), type);
	}
	
	/**
	 * 待安放提醒列表
	 * @param page
	 * @param registry
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<CemeteryRegistry> getWaitingPlaceList(Page page, CemeteryRegistry registry) {
		List<Type> typelist = new ArrayList<Type>();
		List<Object> objlist = new ArrayList<Object>();
		StringBuilder querySql = new StringBuilder(" from CemeteryRegistry cr WHERE 1=1 ");
		// 业务类型
		if (registry.getCemeteryRegistryType()!=null) {
			querySql.append(" and cr.cemeteryRegistryType = ? ");
			objlist.add(registry.getCemeteryRegistryType());
			typelist.add(Hibernate.INTEGER);
		}
		if(registry.getCreateOrgId()!=null){
			querySql.append(" and cr.createOrgId = ? ");
			objlist.add(registry.getCreateOrgId());
			typelist.add(Hibernate.LONG);
		}
		querySql.append(" ORDER BY cr.createDate desc");
		
		StringBuilder countSql = new StringBuilder("select count(*)  ");
		countSql.append(querySql);
		Type[] type = new Type[typelist.size()];
		System.arraycopy(typelist.toArray(), 0, type, 0, type.length);
		return (List<CemeteryRegistry>) getPageList(page, querySql.toString(), countSql.toString(), objlist.toArray(), type);

	}
	/**
	 * 待归档提醒列表
	 * @param page
	 * @param registry
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<CemeteryRegistry> getWaitingArchivesList(Page page, CemeteryRegistry registry) {
		List<Type> typelist = new ArrayList<Type>();
		List<Object> objlist = new ArrayList<Object>();
		StringBuilder querySql = new StringBuilder(" from CemeteryRegistry cr WHERE 1=1 ");
		// 业务类型
		if (registry.getCemeteryRegistryType()!=null) {
			querySql.append(" and cr.cemeteryRegistryType = ? ");
			objlist.add(registry.getCemeteryRegistryType());
			typelist.add(Hibernate.INTEGER);
		}
		if(registry.getCreateOrgId()!=null){
			querySql.append(" and cr.createOrgId = ? ");
			objlist.add(registry.getCreateOrgId());
			typelist.add(Hibernate.LONG);
		}
		querySql.append(" ORDER BY cr.createDate desc");
		
		StringBuilder countSql = new StringBuilder("select count(*)  ");
		countSql.append(querySql);
		Type[] type = new Type[typelist.size()];
		System.arraycopy(typelist.toArray(), 0, type, 0, type.length);
		return (List<CemeteryRegistry>) getPageList(page, querySql.toString(), countSql.toString(), objlist.toArray(), type);
		
	}
	/**
	 * 待续租提醒列表
	 * @param page
	 * @param registry
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ArchivesCemeteryRegistry> getWaitingReletList(Page page, ArchivesCemeteryRegistry registry) {
		List<Type> typelist = new ArrayList<Type>();
		List<Object> objlist = new ArrayList<Object>();
		StringBuilder querySql = new StringBuilder(" from ArchivesCemeteryRegistry cr WHERE 1=1 ");
		//=======查询30天之内到期的信息 Start=======
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -30);
		Date frond30DaysDate = cal.getTime();//当前日期之前30天的日期
		querySql.append(" and cr.enddate >= ?");
		objlist.add(frond30DaysDate);
		typelist.add(Hibernate.DATE);
		
		Date currentDate = new Date();//当前日期
		querySql.append(" and cr.enddate <= ?");
		objlist.add(currentDate);
		typelist.add(Hibernate.DATE);
		//=======查询30天之内到期的信息 End=======
			
		if(registry.getCreateOrgId()!=null){
			querySql.append(" and cr.createOrgId = ? ");
			objlist.add(registry.getCreateOrgId());
			typelist.add(Hibernate.LONG);
		}
		querySql.append(" ORDER BY cr.enddate desc");
		
		StringBuilder countSql = new StringBuilder("select count(*)  ");
		countSql.append(querySql);
		Type[] type = new Type[typelist.size()];
		System.arraycopy(typelist.toArray(), 0, type, 0, type.length);
		return (List<ArchivesCemeteryRegistry>) getPageList(page, querySql.toString(), countSql.toString(), objlist.toArray(), type);
		
	}
	
}
