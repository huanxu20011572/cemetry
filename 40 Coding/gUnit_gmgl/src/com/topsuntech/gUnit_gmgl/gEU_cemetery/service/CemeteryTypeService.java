package com.topsuntech.gUnit_gmgl.gEU_cemetery.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Hibernate;
import org.hibernate.type.Type;

import com.topsuntech.gUnit_gmgl.core.HibernateBaseService;
import com.topsuntech.gUnit_gmgl.core.Page;
import com.topsuntech.gUnit_gmgl.gEU_business.entity.BusinessData;
import com.topsuntech.gUnit_gmgl.gEU_cemetery.entity.CemeteryFile;
import com.topsuntech.gUnit_gmgl.gEU_cemetery.entity.CemeteryType;

public class CemeteryTypeService extends HibernateBaseService {
	
	/**
	 * 获得墓型列表
	 * @param page
	 * @param cemeteryType
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<CemeteryType> getCemeteryTypeList(Page page, CemeteryType cemeteryType) {
		logger.debug("page list param:" + cemeteryType);
		
		StringBuffer querySql = new StringBuffer(" FROM CemeteryType bt WHERE 1=1 ");
		List<Type> typelist = new ArrayList<Type>();
		List<Object> objlist = new ArrayList<Object>();
		if(StringUtils.isNotEmpty(cemeteryType.getBusinessData().getBusinessName()) && !"-1".equals(cemeteryType.getBusinessData().getBusinessName())){
			querySql.append(" and bt.businessData.businessName like ? ");
			objlist.add("%" + cemeteryType.getBusinessData().getBusinessName() + "%");
			typelist.add(Hibernate.STRING);
		}
		if(StringUtils.isNotEmpty(cemeteryType.getCemeteryProperty()) && !"-1".equals(cemeteryType.getCemeteryProperty())){
			querySql.append(" and bt.cemeteryProperty like ? ");
			objlist.add("%" + cemeteryType.getCemeteryProperty() + "%");
			typelist.add(Hibernate.STRING);
		}
		if(StringUtils.isNotEmpty(cemeteryType.getCemeteryTypeName()) && !"-1".equals(cemeteryType.getCemeteryTypeName())){
			querySql.append(" and bt.cemeteryTypeName like ? ");
			objlist.add("%" + cemeteryType.getCemeteryTypeName() + "%");
			typelist.add(Hibernate.STRING);
		}
		if(cemeteryType.getCave()!=null  && cemeteryType.getCave().intValue() >0){
			querySql.append(" and bt.cave = ? ");
			objlist.add(cemeteryType.getCave());
			typelist.add(Hibernate.INTEGER);
		}
		if(cemeteryType.getCreateOrgId()!=null){
			querySql.append(" and bt.createOrgId = ? ");
			objlist.add(cemeteryType.getCreateOrgId());
			typelist.add(Hibernate.LONG);
		}

		querySql.append(" ORDER BY bt.createDate desc ");

		StringBuffer countSql = new StringBuffer();
		countSql.append(" SELECT COUNT(bt.id) ").append(querySql);
		Type[] type = new Type[typelist.size()];
		System.arraycopy(typelist.toArray(), 0, type, 0, type.length);
		
		return (List<CemeteryType>) getPageList(page, querySql.toString(), countSql.toString(), objlist.toArray(), type);
	}
	
//	/**
//	 * 根据ID获取墓型信息
//	 * @param id
//	 * @return
//	 */
	public CemeteryType getCemeteryType(Long id) {
		CemeteryType  cemeteryType= load(CemeteryType.class, id);
		if(cemeteryType !=null){
			return cemeteryType;
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
	 * 添加或修改
	 * @param command
	 */
	public void saveCemeteryType(CemeteryType command) {
		 CemeteryType type = null;
		if(command.getId()!=null && command.getId().longValue()> 0){
			//id>0编辑
			type = load(CemeteryType.class, command.getId());
		}else{
			//新增
			type = new CemeteryType();
			type.setCreateUserId(command.getCreateUserId());
			type.setCreateOrgId(command.getCreateOrgId());
			type.setCreateDate(new Date());
		}
		
		//设置业务分类
		BusinessData businessData = load(BusinessData.class, command.getBusinessDataId());
		type.setBusinessData(businessData);
		
		type.setCemeteryTypeCode(command.getCemeteryTypeCode());
		type.setCemeteryTypeName(command.getCemeteryTypeName());
		type.setCemeteryProperty(command.getCemeteryProperty());
		type.setSpecification(command.getSpecification());
		type.setArea(command.getArea());
		type.setCave(command.getCave());
		type.setBoxsize(command.getBoxsize());
		type.setTotalPrice(command.getTotalPrice());
		type.setStoneprovider(command.getStoneprovider());
		type.setRemark(command.getRemark());
		type.setGroundPrice(command.getGroundPrice());
		type.setManagePrice(command.getManagePrice());
		type.setConstructionPrice(command.getConstructionPrice());
		//如果上传文件设置图片
		if(command.getCemeteryFileId() != null && command.getCemeteryFileId().longValue() >0){
			type.setCemeteryFile(load(CemeteryFile.class,command.getCemeteryFileId()));
		}
		saveOrUpdate(type);

	}

	/**
	 * 根据ID删除商品
	 * @param id
	 */
	public void deleteCemeteryType(Long id) {
		CemeteryType cemeteryType = load(CemeteryType.class, id);
		delete(cemeteryType);
	}
}
