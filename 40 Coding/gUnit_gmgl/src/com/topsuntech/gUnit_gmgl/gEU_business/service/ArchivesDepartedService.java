package com.topsuntech.gUnit_gmgl.gEU_business.service;

import com.topsuntech.gUnit_gmgl.core.HibernateBaseService;
import com.topsuntech.gUnit_gmgl.gEU_business.entity.ArchivesCemeteryRegistry;
import com.topsuntech.gUnit_gmgl.gEU_business.entity.ArchivesDeparted;

public class ArchivesDepartedService extends HibernateBaseService {

	/**
	 * 保持逝者信息
	 * @param departed
	 */
	public void saveOrUpdate(ArchivesDeparted departed) {
		ArchivesCemeteryRegistry cr = load(ArchivesCemeteryRegistry.class, departed.getRegeditId());
		departed.getArchivesCemeteryRegistries().add(cr);
		if(departed.getId() == null || departed.getId().longValue() <=0){
			save(departed);
		}else{
			ArchivesDeparted departed2 = load(ArchivesDeparted.class, departed.getId());
			departed.setCreateDate(departed2.getCreateDate());
			departed.setCreateOrgId(departed2.getCreateOrgId());
			departed.setCreateUserId(departed2.getCreateUserId());
			merge(departed);
		}
	}

	public void deleteDeparted(Long id) {
		super.delete(load(ArchivesDeparted.class, id));
	}
}
