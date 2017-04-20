package com.topsuntech.gUnit_gmgl.gEU_charge.service;

import com.topsuntech.gUnit_gmgl.core.HibernateBaseService;
import com.topsuntech.gUnit_gmgl.core.Page;
import com.topsuntech.gUnit_gmgl.gEU_charge.entity.ChargeType;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Hibernate;
import org.hibernate.type.Type;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 费用分类管理服务类
 * </p>
 * 
 * @author javajiao
 * @date 2014-08-20
 * 
 */
public class ChargeTypeService extends HibernateBaseService {

	// /**
	// * <p>根据费用类型父编号查询对应的子费用类型列表</p>
	// * @param pid 费用类型父编号
	// * @return 当前pid所属的子费用类型列表
	// */
	// public List<ChargeType> getChargeTypeTreeByPID(Long pid) {
	//
	// ChargeType chargeType = load(ChargeType.class, pid);
	// if(chargeType !=null){
	// return chargeType.getChildren();
	// }else{
	// return null;
	// }
	// }

	@SuppressWarnings("unchecked")
	public List<ChargeType> getChargeTypeList(Page page, ChargeType chargeType) {
		logger.debug("费用类型查询参数为:" + chargeType);
	 
		StringBuffer querySQL = new StringBuffer(
				" FROM ChargeType ct WHERE 1=1 and isValidate = '1' ");
		
		List<Type> typeList = new ArrayList<Type>();
		List<Object> objectList = new ArrayList<Object>();

		if (StringUtils.isNotEmpty(chargeType.getChargeTypeName())) {
			querySQL.append(" and ct.chargeTypeName like ? ");
			objectList.add("%" + chargeType.getChargeTypeName() + "%");
			typeList.add(Hibernate.STRING);
		}
		if (StringUtils.isNotEmpty(chargeType.getChargeTypeDict())&&!"-1".equals(chargeType.getChargeTypeDict())) {
			querySQL.append(" and ct.chargeTypeDict like ?");
			objectList.add("%" + chargeType.getChargeTypeDict() + "%");
			typeList.add(Hibernate.STRING);
		}
        if(null!=chargeType.getCreateOrgId()&&0!=chargeType.getCreateOrgId()){
        	querySQL.append(" and ct.createOrgId = ?");
			objectList.add(chargeType.getCreateOrgId());
			typeList.add(Hibernate.LONG);
        }
		querySQL.append(" ORDER BY ct.sort");
		logger.debug("Query SQL: " + querySQL);

		StringBuffer countSQL = new StringBuffer();
		countSQL.append(" SELECT COUNT(ct.id) ").append(querySQL);
		Type[] type = new Type[typeList.size()];
		System.arraycopy(typeList.toArray(), 0, type, 0, type.length);

		return (List<ChargeType>) getPageList(page, querySQL.toString(),
				countSQL.toString(), objectList.toArray(), type);
	}

	public void deleteChargeType(Long id) {
		ChargeType chargeType = load(ChargeType.class, id);
		delete(chargeType);

	}
	
	public void saveOrUpdateChargeType(ChargeType chargeData) {
		 super.saveOrUpdate(chargeData);
	}

}
