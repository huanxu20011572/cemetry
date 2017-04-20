//package com.topsuntech.gUnit_gmgl.gEU_business.service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.apache.commons.lang.StringUtils;
//import org.hibernate.Hibernate;
//import org.hibernate.type.Type;
//
//import com.topsuntech.gUnit_gmgl.core.HibernateBaseService;
//import com.topsuntech.gUnit_gmgl.core.Page;
//import com.topsuntech.gUnit_gmgl.gEU_business.entity.BusinessType;
//
//public class BusinessTypeService extends HibernateBaseService {
//	
//	
//	/**
//	 * 查询机构分类列表
//	 * @param page
//	 * @param businessType
//	 * @return
//	 */
//	@SuppressWarnings("unchecked")
//	public List<BusinessType> getBusinessTypeList(Page page, BusinessType businessType) {
//		logger.debug("page list param:" + businessType);
//
//		StringBuffer querySql = new StringBuffer(" FROM BusinessType bt WHERE 1=1");
//		List<Type> typelist = new ArrayList<Type>();
//		List<Object> objlist = new ArrayList<Object>();
//		
//		if(StringUtils.isNotEmpty(businessType.getBusinessTypeName())){
//			querySql.append(" and bt.businessTypeName like ? ");
//			objlist.add("%" + businessType.getBusinessTypeName() + "%");
//			typelist.add(Hibernate.STRING);
//		}
//		if(businessType.getParent().getId()!=null){
//			querySql.append(" and bt.parent.id = ? ");
//			objlist.add(businessType.getParent().getId());
//			typelist.add(Hibernate.LONG);
//		}
//
//		querySql.append(" ORDER BY bt.sort");
//
//		StringBuffer countSql = new StringBuffer();
//		countSql.append(" SELECT COUNT(bt.id) ").append(querySql);
//		Type[] type = new Type[typelist.size()];
//		System.arraycopy(typelist.toArray(), 0, type, 0, type.length);
//
//		return (List<BusinessType>) getPageList(page, querySql.toString(), countSql.toString(), objlist.toArray(), type);
//	}
//
//	/**
//	 * 根据PID获取业务分类树
//	 * @param pid
//	 * @return
//	 */
//	public List<BusinessType> getBusinessTypeTreeByPID(Long pid) {
//		BusinessType businessType = load(BusinessType.class, pid);
//		if(businessType !=null){
//			return businessType.getChildren();
//		}else{
//			return null;
//		}
//	}
//
//	/**
//	 * 添加或修改
//	 * @param command
//	 */
//	public void saveBusinessType(BusinessType command,Long pid) {
//		BusinessType type = null;
//		if(command.getId()!=null && command.getId().longValue()> 0){
//			//id>0编辑
//			type = load(BusinessType.class, command.getId());
//		}else  if(pid !=null && pid.longValue() > 0){
//			//新增
//			type = new BusinessType();
//			type.setParent(load(BusinessType.class, pid));
//		}
//		type.setBusinessTypeName(command.getBusinessTypeName());
//		type.setBusinessTypeCode(command.getBusinessTypeCode());
//		type.setIsValidate(command.getIsValidate());
//		type.setRemark(command.getRemark());
//		type.setSort(command.getSort());
//		saveOrUpdate(type);
//	}
//
//	public void deleteBusinessType(Long id) {
//		BusinessType businessType = load(BusinessType.class, id);
//		delete(businessType);
//		
//	}
//	
//	
//}
