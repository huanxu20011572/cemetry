package com.topsuntech.gUnit_gmgl.gEU_business.service;

import java.util.Date;
import java.util.List;

import com.topsuntech.gUnit_gmgl.core.Page;
import com.topsuntech.gUnit_gmgl.core.test.AbstractTestCase;
import com.topsuntech.gUnit_gmgl.core.util.DateUtils;
import com.topsuntech.gUnit_gmgl.gEU_business.entity.VisitReturn;

public class VisitReturnServiceTest extends AbstractTestCase {

	VisitReturnService visitReturnService;
	
	protected void setUp() throws Exception {
		visitReturnService = (VisitReturnService) applicationContext.getBean("visitReturnService");
		super.setUp();
	}

	public void testGetVisitReturnList() {
		Page page = new  Page();
		VisitReturn visitReturn = new VisitReturn();
		visitReturn.setBeginCreateDate(DateUtils.strToDate("2014-11-10",null));
		List<VisitReturn> list = visitReturnService.getVisitReturnList(page, visitReturn);
		assertEquals(true, list.size()>0);
	}

}
