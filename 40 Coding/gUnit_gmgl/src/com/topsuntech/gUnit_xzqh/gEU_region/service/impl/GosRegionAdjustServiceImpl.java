package com.topsuntech.gUnit_xzqh.gEU_region.service.impl;

import com.topsuntech.gUnit_xzqh.gEU_region.service.dao.GosRegionAdjustDAO;
import com.topsuntech.gUnit_xzqh.gEU_region.service.dao.impl.GosRegionAdjustDAOImpl;
import com.topsuntech.gUnit_xzqh.gEU_region.entity.GosRegionAdjust;
import com.topsuntech.gUnit_xzqh.gEU_region.service.GosRegionAdjustService;
import com.topsuntech.gOS.gPortal.page.Page;
import com.topsuntech.gUnit_xzqh.gEU_region.service.vo.GosRegionAdjustQueryBean;
import java.util.List;
import com.topsuntech.gOS.query.TSDBException;

public class GosRegionAdjustServiceImpl implements GosRegionAdjustService{

	private GosRegionAdjustDAO gosRegionAdjustDAO = new GosRegionAdjustDAOImpl();

	public void addGosRegionAdjust(GosRegionAdjust gosRegionAdjust) throws TSDBException{
		gosRegionAdjustDAO.addGosRegionAdjust(gosRegionAdjust);
	}

	public void updateGosRegionAdjust(GosRegionAdjust gosRegionAdjust) throws TSDBException{
		gosRegionAdjustDAO.updateGosRegionAdjust(gosRegionAdjust);
	}

	public void deleteGosRegionAdjust(GosRegionAdjust gosRegionAdjust) throws TSDBException{
		gosRegionAdjustDAO.deleteGosRegionAdjust(gosRegionAdjust);
	}

	public GosRegionAdjust getGosRegionAdjustById(Long id) throws TSDBException{
		return (GosRegionAdjust)gosRegionAdjustDAO.getGosRegionAdjustById(id);
	}

	public List queryGosRegionAdjust(GosRegionAdjustQueryBean gosRegionAdjustQueryBean, Page page) throws TSDBException{
		return gosRegionAdjustDAO.queryGosRegionAdjust(gosRegionAdjustQueryBean, page);
	}

}
