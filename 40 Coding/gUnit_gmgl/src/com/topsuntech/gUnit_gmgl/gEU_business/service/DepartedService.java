package com.topsuntech.gUnit_gmgl.gEU_business.service;

import java.util.ArrayList;
import java.util.List;

import com.topsuntech.gUnit_gmgl.core.HibernateBaseService;
import com.topsuntech.gUnit_gmgl.gEU_business.entity.Departed;
import com.topsuntech.gUnit_gmgl.gEU_cemetery.entity.CemeteryRegistry;

public class DepartedService extends HibernateBaseService {

	/**
	 * 保持逝者信息
	 * @param departed
	 */
	public void saveOrUpdate(Departed departed) {
		CemeteryRegistry cr = load(CemeteryRegistry.class, departed.getRegeditId());
		departed.getCemeteryRegistries().add(cr);
		if(departed.getId() == null || departed.getId().longValue() <=0){
			save(departed);
		}else{
			Departed departed2 = load(Departed.class, departed.getId());
			departed.setCreateDate(departed2.getCreateDate());
			departed.setCreateOrgId(departed2.getCreateOrgId());
			departed.setCreateUserId(departed2.getCreateUserId());
			merge(departed);
		}
	}

	public void deleteDeparted(Long id) {
		super.delete(load(Departed.class, id));
	}
}
