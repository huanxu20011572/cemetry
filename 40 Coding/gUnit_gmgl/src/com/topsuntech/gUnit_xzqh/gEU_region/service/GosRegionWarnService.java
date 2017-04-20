package com.topsuntech.gUnit_xzqh.gEU_region.service;

import com.topsuntech.gUnit_xzqh.gEU_region.entity.GosRegionWarn;
import com.topsuntech.gOS.gPortal.page.Page;
import com.topsuntech.gUnit_xzqh.gEU_region.service.vo.GosRegionWarnQueryBean;
import java.util.List;
import com.topsuntech.gOS.query.TSDBException;

public interface GosRegionWarnService{

	public void addGosRegionWarn(GosRegionWarn gosRegionWarn) throws TSDBException;

	public void updateGosRegionWarn(GosRegionWarn gosRegionWarn) throws TSDBException;

	public void deleteGosRegionWarn(GosRegionWarn gosRegionWarn) throws TSDBException;

	public GosRegionWarn getGosRegionWarnById(Long id) throws TSDBException;

	public List queryGosRegionWarn(GosRegionWarnQueryBean gosRegionWarnQueryBean, Page page) throws TSDBException;

}
