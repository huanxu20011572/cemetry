package com.topsuntech.gUnit_gmgl.gEU_business.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Hibernate;
import org.hibernate.type.Type;

import com.topsuntech.gUnit_gmgl.core.HibernateBaseService;
import com.topsuntech.gUnit_gmgl.core.Page;
import com.topsuntech.gUnit_gmgl.gEU_business.entity.BusinessData;
import com.topsuntech.gUnit_gmgl.gEU_business.entity.VisitReturn;

public class VisitReturnService extends HibernateBaseService {
	
	
	/**
	 * 来访登记列表
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
		
		if(StringUtils.isNotEmpty(visitReturn.getCustomerName())){
			querySql.append(" and bt.customerName like ? ");
			objlist.add("%" + visitReturn.getCustomerName() + "%");
			typelist.add(Hibernate.STRING);
		}
		
		if(visitReturn.getBeginCreateDate()!=null && visitReturn.getEndCreateDate()!=null){
			querySql.append(" and bt.createDate >= ?");
			objlist.add(visitReturn.getBeginCreateDate());
			typelist.add(Hibernate.DATE); 
			
			querySql.append(" and bt.createDate <= ?");
			objlist.add(visitReturn.getEndCreateDate());
			typelist.add(Hibernate.DATE); 

		}else{
			if(visitReturn.getBeginCreateDate()!=null){
				querySql.append(" and bt.createDate >= ?");
				objlist.add(visitReturn.getBeginCreateDate());
				typelist.add(Hibernate.DATE); 
			}
			if(visitReturn.getEndCreateDate()!=null){
				querySql.append(" and bt.createDate <= ?");
				objlist.add(visitReturn.getEndCreateDate());
				typelist.add(Hibernate.DATE); 
			}
		}
		
		if(visitReturn.getCreateOrgId()!=null){
			querySql.append(" and bt.createOrgId = ? ");
			objlist.add(visitReturn.getCreateOrgId());
			typelist.add(Hibernate.LONG);
		}

		querySql.append(" ORDER BY bt.id desc");

		StringBuffer countSql = new StringBuffer();
		countSql.append(" SELECT COUNT(bt.id) ").append(querySql);
		Type[] type = new Type[typelist.size()];
		System.arraycopy(typelist.toArray(), 0, type, 0, type.length);

		return (List<VisitReturn>) getPageList(page, querySql.toString(), countSql.toString(), objlist.toArray(), type);
	}
	
	/**
	 * 添加或修改来访登记信息
	 * @param command
	 */
	public void saveVisitReturn(VisitReturn command) {
		VisitReturn type = null;
		if(command.getId()!=null && command.getId().longValue()> 0){
			//id>0编辑
			type = load(VisitReturn.class, command.getId());
		}else{
			//新增
			type = new VisitReturn();
			type.setCreateDate(new Date());
			type.setCreateUserId(command.getCreateUserId());
			type.setCreateOrgId(command.getCreateOrgId());
		}
		type.setIsReturn(new Long("0"));
		type.setCustomerName(command.getCustomerName());
		type.setCustomerNum(command.getCustomerNum());
		type.setCustomerReq(command.getCustomerReq());
		type.setCustomerSource(command.getCustomerSource());
		type.setCustomerTel(command.getCustomerTel());
		type.setRemark(command.getRemark());
		saveOrUpdate(type);
	}
	
	/**
	 * 修改回访情况
	 * @param command
	 */
	public void saveVisitReturnBack(VisitReturn command) {
		VisitReturn type = null;
		if(command.getId()!=null && command.getId().longValue()> 0){
			//id>0编辑
			type = load(VisitReturn.class, command.getId());
			type.setIsReturn(new Long("1"));
			type.setReturnDate(new Date());
			type.setReturnUserId(command.getCreateUserId());
			type.setReturnRemark(command.getReturnRemark());
			saveOrUpdate(type);
		}
	}
	
//	/**
//	 * 根据ID获取来访信息
//	 * @param id
//	 * @return
//	 */
	public VisitReturn getVisitReturn(Long id) {
		VisitReturn  visitReturn= load(VisitReturn.class, id);
		if(visitReturn !=null){
			return visitReturn;
		}else{
			return null;
		}
	}
	
	/**
	 * 根据ID删除来访信息
	 * @param id
	 */
	public void deleteVisitReturn(Long id) {
		VisitReturn visitReturn = load(VisitReturn.class, id);
		delete(visitReturn);
	}

}
