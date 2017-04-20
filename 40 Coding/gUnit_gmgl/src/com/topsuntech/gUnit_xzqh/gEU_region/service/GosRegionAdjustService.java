package com.topsuntech.gUnit_xzqh.gEU_region.service;

import com.topsuntech.gUnit_xzqh.gEU_region.entity.GosRegionAdjust;
import com.topsuntech.gOS.gPortal.page.Page;
import com.topsuntech.gUnit_xzqh.gEU_region.service.vo.GosRegionAdjustQueryBean;
import java.util.List;
import com.topsuntech.gOS.query.TSDBException;

public interface GosRegionAdjustService{

	public void addGosRegionAdjust(GosRegionAdjust gosRegionAdjust) throws TSDBException;

	public void updateGosRegionAdjust(GosRegionAdjust gosRegionAdjust) throws TSDBException;

	public void deleteGosRegionAdjust(GosRegionAdjust gosRegionAdjust) throws TSDBException;

	public GosRegionAdjust getGosRegionAdjustById(Long id) throws TSDBException;

	public List queryGosRegionAdjust(GosRegionAdjustQueryBean gosRegionAdjustQueryBean, Page page) throws TSDBException;

}
