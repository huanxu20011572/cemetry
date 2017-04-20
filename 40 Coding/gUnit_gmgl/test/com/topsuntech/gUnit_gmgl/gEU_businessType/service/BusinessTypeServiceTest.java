//package com.topsuntech.gUnit_gmgl.gEU_businessType.service;
//
//import java.util.List;
//
//import com.topsuntech.gUnit_gmgl.core.Page;
//import com.topsuntech.gUnit_gmgl.core.test.AbstractTestCase;
//import com.topsuntech.gUnit_gmgl.gEU_business.entity.BusinessType;
//import com.topsuntech.gUnit_gmgl.gEU_business.service.BusinessTypeService;
//
//public class BusinessTypeServiceTest extends AbstractTestCase {
//
//	BusinessTypeService businessTypeService;
//	
//	protected void setUp() throws Exception {
//		super.setUp();
//		businessTypeService = (BusinessTypeService) applicationContext.getBean("businessTypeService");
//	}
//	
//	/**
//	 * 测试分页name过滤
//	 */
//	public void testGetBusinessTypeListName() {
//		Page page = new Page();
//		BusinessType businessType = new BusinessType();
//		businessType.setBusinessTypeName("businessTypeName");
//		businessType.setParent(businessTypeService.load(BusinessType.class, Long.valueOf(1)));
//		businessTypeService.save(businessType);
//		List<BusinessType> businessTypes = businessTypeService.getBusinessTypeList(page, businessType);
//		assertEquals(businessTypes.size(), page.getTotalCount());
//		assertEquals(businessType.getBusinessTypeName(), "businessTypeName");
//	}
//	
//	/**
//	 * 测试分页pid过滤
//	 */
//	public void testGetBusinessTypeListPID() {
//		Page page = new Page();
//		BusinessType businessType = new BusinessType();
//		businessType.setParent(businessTypeService.load(BusinessType.class, Long.valueOf(1)));
//		businessTypeService.save(businessType);
//		List<BusinessType> businessTypes = businessTypeService.getBusinessTypeList(page, businessType);
//		assertEquals(businessTypes.size(), page.getTotalCount());
//	}
//
//	public void testGetBusinessTypeTreeByPID(){
//		List<BusinessType> businessTypes = businessTypeService.getBusinessTypeTreeByPID(Long.valueOf(1));
//		System.out.println(businessTypes);
//	}
//	
//	public void testLoad(){
//		BusinessType type = businessTypeService.load(BusinessType.class, Long.valueOf(1));
//		System.out.println(type);
//	}
//	
//
//}
