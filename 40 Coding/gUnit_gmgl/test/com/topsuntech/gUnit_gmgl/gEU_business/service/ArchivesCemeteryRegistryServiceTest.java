package com.topsuntech.gUnit_gmgl.gEU_business.service;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;

import com.topsuntech.gUnit_gmgl.core.test.AbstractTestCase;
import com.topsuntech.gUnit_gmgl.gEU_business.entity.ArchivesCemeteryCharge;
import com.topsuntech.gUnit_gmgl.gEU_business.entity.ArchivesCemeteryRegistry;
import com.topsuntech.gUnit_gmgl.gEU_cemetery.entity.CemeteryCharge;
import com.topsuntech.gUnit_gmgl.gEU_cemetery.entity.CemeteryRegistry;
import com.topsuntech.gUnit_gmgl.gEU_cemetery.service.CemeteryChargeService;

public class ArchivesCemeteryRegistryServiceTest extends AbstractTestCase {

	ArchivesCemeteryRegistryService archivesCemeteryRegistryService;
	protected void setUp() throws Exception {
		super.setUp();
		archivesCemeteryRegistryService = (ArchivesCemeteryRegistryService) applicationContext.getBean("archivesCemeteryRegistryService");

	}

	public void testArchives() {
		long [] ids = {1150l,1200l};
	}

}
