package com.topsuntech.gUnit_xzqh.gEU_region.service.dao.impl;

import java.util.List;

import com.topsuntech.gOS.gPortal.page.Page;
import com.topsuntech.gOS.query.DBRegistry;
import com.topsuntech.gOS.query.DBWrapper;
import com.topsuntech.gOS.query.TSDBException;
import com.topsuntech.gUnit.gEU_util.dao.SJBaseDAO;
import com.topsuntech.gUnit_xzqh.gEU_region.entity.GosRegionAdjust;
import com.topsuntech.gUnit_xzqh.gEU_region.service.dao.GosRegionAdjustDAO;
import com.topsuntech.gUnit_xzqh.gEU_region.service.vo.GosRegionAdjustQueryBean;

public class GosRegionAdjustDAOImpl implements GosRegionAdjustDAO{
	static SJBaseDAO dao = new SJBaseDAO();
	private static DBWrapper db = DBRegistry.getDefaultDBWrapper();
	public void addGosRegionAdjust(GosRegionAdjust gosRegionAdjust) throws TSDBException{
		dao.addEntity(gosRegionAdjust); 	
	}

	public void updateGosRegionAdjust(GosRegionAdjust gosRegionAdjust) throws TSDBException{
		dao.updateEntity(gosRegionAdjust);
	}

	public void deleteGosRegionAdjust(GosRegionAdjust gosRegionAdjust) throws TSDBException{
		dao.deleteEntity(gosRegionAdjust);
	}

	public GosRegionAdjust getGosRegionAdjustById(Long id) throws TSDBException{
		return (GosRegionAdjust) dao.getEntity(GosRegionAdjust.class, id);
	}

	public List queryGosRegionAdjust(GosRegionAdjustQueryBean gosRegionAdjustQueryBean, Page page) throws TSDBException{
		StringBuffer hql = new StringBuffer();
		hql.append(" from GosRegionAdjust t where 1 = 1");
		if(gosRegionAdjustQueryBean != null){
			if(gosRegionAdjustQueryBean.getId() != null && gosRegionAdjustQueryBean.getId().longValue() != 0)
				hql.append(" and t.id = ").append(gosRegionAdjustQueryBean.getId());
			if(gosRegionAdjustQueryBean.getAdjustType() != null && gosRegionAdjustQueryBean.getAdjustType().longValue() != 0)
				hql.append(" and t.adjustType = ").append(gosRegionAdjustQueryBean.getAdjustType());
			if(gosRegionAdjustQueryBean.getAdjustLevel() != null && gosRegionAdjustQueryBean.getAdjustLevel().longValue() != 0)
				hql.append(" and t.adjustLevel = ").append(gosRegionAdjustQueryBean.getAdjustLevel());
			if(gosRegionAdjustQueryBean.getAdjustCountyIds() != null && !"".equals(gosRegionAdjustQueryBean.getAdjustCountyIds().trim()))
				hql.append(" and t.adjustCountyIds like '%").append(gosRegionAdjustQueryBean.getAdjustCountyIds()).append("%'");
			if(gosRegionAdjustQueryBean.getAdjustCountyNames() != null && !"".equals(gosRegionAdjustQueryBean.getAdjustCountyNames().trim()))
				hql.append(" and t.adjustCountyNames like '%").append(gosRegionAdjustQueryBean.getAdjustCountyNames()).append("%'");
			if(gosRegionAdjustQueryBean.getAdjustStreetIds() != null && !"".equals(gosRegionAdjustQueryBean.getAdjustStreetIds().trim()))
				hql.append(" and t.adjustStreetIds like '%").append(gosRegionAdjustQueryBean.getAdjustStreetIds()).append("%'");
			if(gosRegionAdjustQueryBean.getAdjustStreetNames() != null && !"".equals(gosRegionAdjustQueryBean.getAdjustStreetNames().trim()))
				hql.append(" and t.adjustStreetNames like '%").append(gosRegionAdjustQueryBean.getAdjustStreetNames()).append("%'");
			if(gosRegionAdjustQueryBean.getAdjustCommunityIds() != null && !"".equals(gosRegionAdjustQueryBean.getAdjustCommunityIds().trim()))
				hql.append(" and t.adjustCommunityIds like '%").append(gosRegionAdjustQueryBean.getAdjustCommunityIds()).append("%'");
			if(gosRegionAdjustQueryBean.getAdjustCommunityNames() != null && !"".equals(gosRegionAdjustQueryBean.getAdjustCommunityNames().trim()))
				hql.append(" and t.adjustCommunityNames like '%").append(gosRegionAdjustQueryBean.getAdjustCommunityNames()).append("%'");
			if(gosRegionAdjustQueryBean.getNewCountyIds() != null && !"".equals(gosRegionAdjustQueryBean.getNewCountyIds().trim()))
				hql.append(" and t.newCountyIds like '%").append(gosRegionAdjustQueryBean.getNewCountyIds()).append("%'");
			if(gosRegionAdjustQueryBean.getNewCountyNames() != null && !"".equals(gosRegionAdjustQueryBean.getNewCountyNames().trim()))
				hql.append(" and t.newCountyNames like '%").append(gosRegionAdjustQueryBean.getNewCountyNames()).append("%'");
			if(gosRegionAdjustQueryBean.getNewStreetIds() != null && !"".equals(gosRegionAdjustQueryBean.getNewStreetIds().trim()))
				hql.append(" and t.newStreetIds like '%").append(gosRegionAdjustQueryBean.getNewStreetIds()).append("%'");
			if(gosRegionAdjustQueryBean.getNewStreetNames() != null && !"".equals(gosRegionAdjustQueryBean.getNewStreetNames().trim()))
				hql.append(" and t.newStreetNames like '%").append(gosRegionAdjustQueryBean.getNewStreetNames()).append("%'");
			if(gosRegionAdjustQueryBean.getNewCommunityIds() != null && !"".equals(gosRegionAdjustQueryBean.getNewCommunityIds().trim()))
				hql.append(" and t.newCommunityIds like '%").append(gosRegionAdjustQueryBean.getNewCommunityIds()).append("%'");
			if(gosRegionAdjustQueryBean.getNewCommunityNames() != null && !"".equals(gosRegionAdjustQueryBean.getNewCommunityNames().trim()))
				hql.append(" and t.newCommunityNames like '%").append(gosRegionAdjustQueryBean.getNewCommunityNames()).append("%'");
			if(gosRegionAdjustQueryBean.getStopDate() != null)
				hql.append(" and t.stopDate = to_date('").append(gosRegionAdjustQueryBean.getStopDate()).append("','yyyy-MM-dd')");
			if(gosRegionAdjustQueryBean.getIsStop() != null && gosRegionAdjustQueryBean.getIsStop().longValue() != 0)
				hql.append(" and t.isStop = ").append(gosRegionAdjustQueryBean.getIsStop());
			if(gosRegionAdjustQueryBean.getCreateDate() != null)
				hql.append(" and t.createDate = to_date('").append(gosRegionAdjustQueryBean.getCreateDate()).append("','yyyy-MM-dd')");
			if(gosRegionAdjustQueryBean.getUseFlag() != null)
				hql.append(" and t.useFlag = ").append(gosRegionAdjustQueryBean.getUseFlag());
			if(gosRegionAdjustQueryBean.getCreateUserId() != null && gosRegionAdjustQueryBean.getCreateUserId().longValue() != 0)
				hql.append(" and t.createUserId = ").append(gosRegionAdjustQueryBean.getCreateUserId());
		}
		if(page != null){
			StringBuffer countHql = new StringBuffer("select count(*) ");
			return dao.query(hql.toString(), countHql.toString() + hql.toString(), page);
		}
		return dao.queryList(hql.toString());
	}

}
