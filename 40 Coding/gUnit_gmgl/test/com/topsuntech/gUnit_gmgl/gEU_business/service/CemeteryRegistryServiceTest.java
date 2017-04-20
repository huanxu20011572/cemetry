package com.topsuntech.gUnit_gmgl.gEU_business.service;

import java.util.List;

import com.topsuntech.gUnit_gmgl.core.Page;
import com.topsuntech.gUnit_gmgl.core.test.AbstractTestCase;
import com.topsuntech.gUnit_gmgl.gEU_business.entity.Departed;
import com.topsuntech.gUnit_gmgl.gEU_cemetery.entity.CemeteryRegistry;

public class CemeteryRegistryServiceTest  extends AbstractTestCase {

	CemeteryRegistryService cemeteryRegistryService;
	protected void setUp() throws Exception {
		cemeteryRegistryService = (CemeteryRegistryService) applicationContext.getBean("cemeteryRegistryService");
		super.setUp();
	}

	public void testGetCemeteryRegistryPageList() {
		Page page = new Page();
		CemeteryRegistry cemeteryRegistry = new CemeteryRegistry();
		cemeteryRegistry.setDepartedName("张1");
		List<?> list = cemeteryRegistryService.getCemeteryRegistryPageList(page, cemeteryRegistry);
		System.out.println(list.size());
		assertEquals(true, list.size()>0);
	}

	public void testGetCemeteryRegistryOtherSerial(){
		String aa = cemeteryRegistryService.getCemeteryRegistryOtherSerial(Long.valueOf(2000), "20001201411012300", 2);
		assertEquals(aa, "20002201411012301");
	}
	
	public void testGetCemeteryRegistrySerial(){
		String aa = cemeteryRegistryService.getCemeteryRegistrySerial(Long.valueOf(2000));
		System.out.println(aa);
	}
	
	public void testGetCemeteryRegistryByCode(){
		CemeteryRegistry cemeteryRegistry = cemeteryRegistryService.getCemeteryRegistryByCode("18001201501036700");
		System.out.println(cemeteryRegistry);
	}
}
