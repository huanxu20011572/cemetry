package com.topsuntech.gUnit_gmgl.gEU_cemetery.service;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.type.Type;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.topsuntech.gOS.user.en.user.User;
import com.topsuntech.gUnit_gmgl.core.HibernateBaseService;
import com.topsuntech.gUnit_gmgl.core.Page;
import com.topsuntech.gUnit_gmgl.gEU_business.entity.BusinessData;
import com.topsuntech.gUnit_gmgl.gEU_cemetery.entity.CemeteryLocation;
import com.topsuntech.gUnit_gmgl.gEU_cemetery.entity.CemeteryType;
import com.topsuntech.gUnit_gmgl.gEU_cemetery.entity.CemeteryZone;

public class CemeteryLocationService extends HibernateBaseService {

	/**
	 * 查询墓位列表
	 * 
	 * @param page
	 * @param businessType
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<CemeteryLocation> getCemeteryLocationList(Page page, CemeteryLocation cemeteryLocation,Long level) {
		logger.debug("page list param:" + cemeteryLocation);

		StringBuffer querySql = new StringBuffer(" FROM CemeteryLocation bt WHERE 1=1 ");
		
		//市级用户查询所有机构信息,市级level=1
		if(level!=null && level.longValue() >1){
			querySql.append(" and bt.createOrgId = " + cemeteryLocation.getCreateOrgId());
			
		}
			
			
		List<Type> typelist = new ArrayList<Type>();
		List<Object> objlist = new ArrayList<Object>();
		if (cemeteryLocation.getCemeteryZoneId() != null) {
			querySql.append(" and bt.cemeteryZone.id = ? ");
			objlist.add(cemeteryLocation.getCemeteryZoneId());
			typelist.add(Hibernate.LONG);
		}

		querySql.append(" ORDER BY bt.id");

		StringBuffer countSql = new StringBuffer();
		countSql.append(" SELECT COUNT(bt.id) ").append(querySql);
		Type[] type = new Type[typelist.size()];
		System.arraycopy(typelist.toArray(), 0, type, 0, type.length);

		return (List<CemeteryLocation>) getPageList(page, querySql.toString(), countSql.toString(), objlist.toArray(), type);
	}

	/**
	 * 查询业务分类
	 * 
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
	 * 根据PID获取区排分类树
	 * 
	 * @param pid
	 * @return
	 */
	public List<CemeteryZone> getCemeteryZoneTreeByPID(Long pid) {
		CemeteryZone cemeteryZone = load(CemeteryZone.class, pid);
		if (cemeteryZone != null) {
			return cemeteryZone.getChildren();
		} else {
			return null;
		}
	}

	public List<CemeteryType> getCemeteryTypeJSonByBusinessDataId(Long businessDataId,User user) {
		List<CemeteryType> list = null;
		if (businessDataId != null) {
			StringBuffer querySql = new StringBuffer(" FROM CemeteryType ct WHERE 1=1");
			querySql.append(" and ct.businessData.id = " + businessDataId);
			querySql.append(" and ct.createOrgId = " + user.getDeptid());
			querySql.append(" ORDER BY ct.id");
			list = (List<CemeteryType>) find(querySql.toString());
		}
		return list;
	}
//
//	public List<CemeteryType> getCemeteryTypeJSonByCemeteryTypeId(Long cemeteryTypeId) {
//		List<CemeteryType> list = null;
//		if (cemeteryTypeId != null) {
//			StringBuffer querySql = new StringBuffer(" FROM CemeteryType ct WHERE 1=1");
//			querySql.append(" and ct.id = " + cemeteryTypeId);
//			querySql.append(" ORDER BY ct.id");
//			list = (List<CemeteryType>) find(querySql.toString());
//		}
//		return list;
//	}

	/**
	 * 添加或修改
	 * 
	 * @param command
	 * @throws Exception
	 */
	public void saveCemeteryLocation(CemeteryLocation command) throws Exception {
		CemeteryLocation location = null;
		if (command.getId() != null && command.getId().longValue() > 0) {
			// id>0编辑
			location = load(CemeteryLocation.class, command.getId());
			// 设置区排
			CemeteryZone cemeteryZone = load(CemeteryZone.class, command.getCemeteryZoneId());
			location.setCemeteryZone(cemeteryZone);

			// 设置墓型
			CemeteryType cemeteryType = load(CemeteryType.class, command.getCemeteryTypeId());
			location.setCemeteryType(cemeteryType);
			location.setStatus(command.getStatus());
			location.setCreateDate(new Date());
			location.setCreateUserId(command.getCreateUserId());
			location.setCreateOrgId(command.getCreateOrgId());
			saveOrUpdate(location);
		} else {
			// 新增墓位
			//amount墓位个数
			long amount = command.getAmount().longValue();
			for (int i = 0; i < amount; i++) {
				// 新增
				location = new CemeteryLocation();
				// 设置区排
				location.setCemeteryZone(load(CemeteryZone.class, command.getCemeteryZoneId()));
				// 设置墓型
				location.setCemeteryType(load(CemeteryType.class, command.getCemeteryTypeId()));
				// 设置编号
				if(i == 0){
					location.setCemeteryLocationCode(command.getCemeteryLocationCode());
				}else{
					location.setCemeteryLocationCode(getCemeteryLocationSerial());
				}
				location.setStatus(command.getStatus());
				location.setCreateDate(new Date());
				location.setCreateUserId(command.getCreateUserId());
				location.setCreateOrgId(command.getCreateOrgId());
				saveOrUpdate(location);
			}
		}

	}

	/**
	 * 生成墓位流水ID
	 * 
	 * @return
	 */
	public String getCemeteryLocationSerial() {

		BigDecimal code = executeWithNativeSession(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				SQLQuery query = session.createSQLQuery("select cemetery_location_serial.nextval from dual ");

				return query.uniqueResult();
			}
		});

		return String.format("%03d", code.longValue());
	}

	public void deleteCemeteryLocation(Long id) {
		CemeteryLocation cemeteryLocation = load(CemeteryLocation.class, id);
		delete(cemeteryLocation);

	}

//	/**
//	 * 过滤墓位信息
//	 * @param list
//	 * @return
//	 */
//	public List<CemeteryType> filterCemeteryType(List<CemeteryType> list) {
//		List<CemeteryType> rlist = new ArrayList<CemeteryType>();
//		for (CemeteryType cemeteryType : list) {
//			CemeteryType rtype = new CemeteryType();
//			rtype.setId(cemeteryType.getId());
//			rtype.setCemeteryTypeCode(cemeteryType.getCemeteryTypeCode());
//			rtype.setCemeteryTypeName(cemeteryType.getCemeteryTypeName());
//			BusinessData businessData = cemeteryType.getBusinessData();
//			businessData.setCemeteryTypes(null);
//			rtype.setBusinessData(businessData);
//			rtype.setCemeteryProperty(cemeteryType.getCemeteryProperty());
//			rtype.setSpecification(cemeteryType.getSpecification());
//			rtype.setArea(cemeteryType.getArea());
//			rtype.setCave(cemeteryType.getCave());
//			rtype.setBoxsize(cemeteryType.getBoxsize());
//			rtype.setTotalPrice(cemeteryType.getTotalPrice());
//			rtype.setStoneprovider(cemeteryType.getStoneprovider());
//			rtype.setRemark(cemeteryType.getRemark());
//			rtype.setGroundPrice(cemeteryType.getGroundPrice());
//			rtype.setManagePrice(cemeteryType.getManagePrice());
//			rtype.setConstructionPrice(cemeteryType.getConstructionPrice());
//			rtype.setCemeteryFile(cemeteryType.getCemeteryFile());
//
//			rlist.add(rtype);
//		}
//		return rlist;
//	}

}
