package com.topsuntech.gUnit_xzqh.gEU_region.service.impl;

import com.topsuntech.gUnit_xzqh.gEU_region.service.dao.GosRegionWarnDAO;
import com.topsuntech.gUnit_xzqh.gEU_region.service.dao.impl.GosRegionWarnDAOImpl;
import com.topsuntech.gUnit_xzqh.gEU_region.entity.GosRegionWarn;
import com.topsuntech.gUnit_xzqh.gEU_region.service.GosRegionWarnService;
import com.topsuntech.gOS.gPortal.page.Page;
import com.topsuntech.gUnit_xzqh.gEU_region.service.vo.GosRegionWarnQueryBean;
import java.util.List;
import com.topsuntech.gOS.query.TSDBException;

public class GosRegionWarnServiceImpl implements GosRegionWarnService{

	private GosRegionWarnDAO gosRegionWarnDAO = new GosRegionWarnDAOImpl();

	public void addGosRegionWarn(GosRegionWarn gosRegionWarn) throws TSDBException{
		gosRegionWarnDAO.addGosRegionWarn(gosRegionWarn);
	}

	public void updateGosRegionWarn(GosRegionWarn gosRegionWarn) throws TSDBException{
		gosRegionWarnDAO.updateGosRegionWarn(gosRegionWarn);
	}

	public void deleteGosRegionWarn(GosRegionWarn gosRegionWarn) throws TSDBException{
		gosRegionWarnDAO.deleteGosRegionWarn(gosRegionWarn);
	}

	public GosRegionWarn getGosRegionWarnById(Long id) throws TSDBException{
		return (GosRegionWarn)gosRegionWarnDAO.getGosRegionWarnById(id);
	}

	public List queryGosRegionWarn(GosRegionWarnQueryBean gosRegionWarnQueryBean, Page page) throws TSDBException{
		return gosRegionWarnDAO.queryGosRegionWarn(gosRegionWarnQueryBean, page);
	}

}
