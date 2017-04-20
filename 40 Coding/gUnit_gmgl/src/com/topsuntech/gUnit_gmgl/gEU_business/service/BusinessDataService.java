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

public class BusinessDataService extends HibernateBaseService {
	
	
	/**
	 * 查询机构分类列表
	 * @param page
	 * @param businessType
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<BusinessData> getBusinessDataList(Page page, BusinessData businessData) {
		logger.debug("page list param:" + businessData);
		StringBuffer querySql = new StringBuffer(" FROM BusinessData bt WHERE 1=1");
		List<Type> typelist = new ArrayList<Type>();
		List<Object> objlist = new ArrayList<Object>();
		
		if(StringUtils.isNotEmpty(businessData.getBusinessName())){
			querySql.append(" and bt.businessName like ? ");
			objlist.add("%" + businessData.getBusinessName() + "%");
			typelist.add(Hibernate.STRING);
		}
		
		if(StringUtils.isNotEmpty(businessData.getBusinessType()) && !"-1".equals(businessData.getBusinessType())){
			querySql.append(" and bt.businessType like ? ");
			objlist.add("%" + businessData.getBusinessType() + "%");
			typelist.add(Hibernate.STRING);
		}
		
		if(businessData.getCreateOrgId()!=null){
			querySql.append(" and bt.createOrgId = ? ");
			objlist.add(businessData.getCreateOrgId());
			typelist.add(Hibernate.LONG);
		}

		querySql.append(" ORDER BY bt.sort");

		StringBuffer countSql = new StringBuffer();
		countSql.append(" SELECT COUNT(bt.id) ").append(querySql);
		Type[] type = new Type[typelist.size()];
		System.arraycopy(typelist.toArray(), 0, type, 0, type.length);

		return (List<BusinessData>) getPageList(page, querySql.toString(), countSql.toString(), objlist.toArray(), type);
	}
	
	/**
	 * 添加或修改
	 * @param command
	 */
	public void saveBusinessData(BusinessData command) {
		BusinessData type = null;
		if(command.getId()!=null && command.getId().longValue()> 0){
			//id>0编辑
			type = load(BusinessData.class, command.getId());
		}else{
			//新增
			type = new BusinessData();
			type.setCreateDate(new Date());
			type.setCreateUserId(command.getCreateUserId());
			type.setCreateOrgId(command.getCreateOrgId());
		}
		type.setBusinessName(command.getBusinessName());
		type.setBusinessType(command.getBusinessType());
		type.setSort(command.getSort());
		type.setIsValidate(command.getIsValidate());
		type.setRemark(command.getRemark());
		saveOrUpdate(type);
	}
	
//	/**
//	 * 根据ID获取分类
//	 * @param pid
//	 * @return
//	 */
	public BusinessData getBusinessData(Long id) {
		BusinessData  businessData= load(BusinessData.class, id);
		if(businessData !=null){
			return businessData;
		}else{
			return null;
		}
	}
	
	/**
	 * 根据ID删除分类
	 * @param id
	 */
	public void deleteBusinessData(Long id) {
		BusinessData businessData = load(BusinessData.class, id);
		delete(businessData);
	}

}
