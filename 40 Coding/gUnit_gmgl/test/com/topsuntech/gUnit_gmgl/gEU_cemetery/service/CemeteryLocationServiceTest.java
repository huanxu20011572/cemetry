package com.topsuntech.gUnit_gmgl.gEU_cemetery.service;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.topsuntech.gOS.user.en.user.User;
import com.topsuntech.gUnit_gmgl.core.Page;
import com.topsuntech.gUnit_gmgl.core.test.AbstractTestCase;
import com.topsuntech.gUnit_gmgl.gEU_cemetery.entity.CemeteryLocation;
import com.topsuntech.gUnit_gmgl.gEU_cemetery.entity.CemeteryType;

public class CemeteryLocationServiceTest extends AbstractTestCase {

	CemeteryLocationService cemeteryLocationService;

	protected void setUp() throws Exception {
		cemeteryLocationService = (CemeteryLocationService) applicationContext.getBean("cemeteryLocationService");

		super.setUp();
	}

	public void testGetCemeteryLocationList() {
		Page page = new Page();
		CemeteryLocation cemeteryLocation = new CemeteryLocation();
		cemeteryLocation.setCreateOrgId(Long.valueOf(2000));
		List<CemeteryLocation> list = cemeteryLocationService.getCemeteryLocationList(page, cemeteryLocation,Long.getLong("0"));
		assertEquals(true, list.size()>0);
	}

	public void testGetBusinessDataList() {
		// fail("Not yet implemented");
	}

	public void testGetCemeteryZoneTreeByPID() {
		// fail("Not yet implemented");
	}

	public void testGetCemeteryTypeJSonByBusinessDataId() {
		User user = new User();
		user.setDeptid(1800);
		List<CemeteryType> list = cemeteryLocationService.getCemeteryTypeJSonByBusinessDataId(Long.valueOf(1050),user);

//		for (CemeteryType cemeteryType : list) {
//			System.out.println(cemeteryType);
//		}
		 String json = JSON.toJSONString(list, true);
		 System.out.println(json);
	}

	public void testGetCemeteryTypeJSonByCemeteryTypeId() {
		// fail("Not yet implemented");
	}

	public void testSaveCemeteryLocation() {
		// fail("Not yet implemented");
	}

	public void testGetCemeteryLocationSerial() {
		// fail("Not yet implemented");
	}

	public void testDeleteCemeteryLocation() {
		// fail("Not yet implemented");
	}

	public void testFilterCemeteryType() {
		fail("Not yet implemented");
	}

	public CemeteryLocationService getCemeteryLocationService() {
		return cemeteryLocationService;
	}

}
