package com.topsuntech.gUnit_gmgl.gEU_charge.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Hibernate;
import org.hibernate.type.Type;

import com.topsuntech.gUnit_gmgl.Constant;
import com.topsuntech.gUnit_gmgl.core.HibernateBaseService;
import com.topsuntech.gUnit_gmgl.core.Page;
import com.topsuntech.gUnit_gmgl.gEU_charge.entity.ChargeData;
import com.topsuntech.gUnit_gmgl.gEU_charge.entity.ChargeType;

public class ChargeDataService extends HibernateBaseService {

	public void saveChargeData(ChargeData chargeData, Long chargeTypeId) {
		logger.debug("page input list param:" + chargeData);
		ChargeData cdata = null;
		if (chargeData.getId() != null && chargeData.getId().longValue() > 0) {
			// id>0编辑
			cdata = load(ChargeData.class, chargeData.getId());
		} else {
			// 新增
			cdata = new ChargeData();
			ChargeType chargeType = load(ChargeType.class, chargeTypeId);
			cdata.setChargeType(chargeType);
			cdata.setIsValidate(Long.valueOf(Constant.YES));
		}

		// 是否有公共方法实现对象拷贝
		cdata.setChargeDataPrice(chargeData.getChargeDataPrice());
		cdata.setChargeDataName(chargeData.getChargeDataName());
		cdata.setCreateDate(new Date());
		cdata.setCreateOrgId(chargeData.getCreateOrgId());
		cdata.setCreateUserId(chargeData.getCreateUserId());
		cdata.setSort(chargeData.getSort());
		cdata.setRemark(chargeData.getRemark());
		saveOrUpdate(cdata);
	}

	public List<ChargeType> getChargeTypeTree(Long pid, Long orgId) {
		List<ChargeType> result = (List<ChargeType>) find("from ChargeType ct where ct.createOrgId=? and ct.isValidate = 1 order by sort asc", orgId);
		return result;
	}

	public List<ChargeData> getChargeDataList(Page page, ChargeData chargeData, Long ctype) {
		logger.debug("page list param:" + chargeData);
		StringBuffer querySql = new StringBuffer(" FROM ChargeData cd WHERE 1=1 ");
		List<Type> typeList = new ArrayList<Type>();
		List<Object> objectList = new ArrayList<Object>();

		if (ctype != null && ctype.longValue()>0) {
			querySql.append(" and cd.chargeType.id=?");
			objectList.add(ctype);
			typeList.add(Hibernate.LONG);
		}
		if(StringUtils.isNotEmpty(chargeData.getChargeDataName())){
			querySql.append(" and cd.chargeDataName like ?");
			objectList.add("%"+chargeData.getChargeDataName()+"%");
			typeList.add(Hibernate.STRING);
		}

		querySql.append(" and cd.createOrgId='" + chargeData.getCreateOrgId() + "' ");
		querySql.append(" ORDER BY cd.sort");

		StringBuffer countSql = new StringBuffer();
		countSql.append(" SELECT COUNT(cd.id) ").append(querySql);
		Type[] type = new Type[typeList.size()];
		System.arraycopy(typeList.toArray(), 0, type, 0, type.length);

		return (List<ChargeData>) getPageList(page, querySql.toString(), countSql.toString(), objectList.toArray(), type);

	}

	/**
	 * 根据ID删除分类
	 * 
	 * @param id
	 */
	public void deleteChargeData(Long cid) {
		ChargeData chargeData = load(ChargeData.class, cid);
		delete(chargeData);
	}
	/**
	 * 登记处查询费用明细
	 * @param command
	 * @return
	 */
	public List<ChargeData> getchargeDataByPara(ChargeData command){
		StringBuffer querySql = new StringBuffer(
				" FROM ChargeData cd WHERE 1=1 ");
		List<Type> typeList = new ArrayList<Type>();
		List<Object> objectList = new ArrayList<Object>();

		if (command != null
				&& StringUtils.isNotEmpty(command.getChargeDataName())) {
			querySql.append(" and cd.chargeDataName like '%");
			querySql.append(command.getChargeDataName()+"%'");
		}

		querySql.append(" and cd.createOrgId='" + command.getCreateOrgId()
				+ "' ");
		querySql.append(" ORDER BY cd.sort");

		Type[] type = new Type[typeList.size()];
		System.arraycopy(typeList.toArray(), 0, type, 0, type.length);
		return (List<ChargeData>)super.find(querySql.toString());
	}
}
