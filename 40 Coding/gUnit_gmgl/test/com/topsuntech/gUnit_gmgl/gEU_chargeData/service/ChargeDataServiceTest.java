package com.topsuntech.gUnit_gmgl.gEU_chargeData.service;

import java.util.List;

import com.topsuntech.gUnit_gmgl.core.test.AbstractTestCase;
import com.topsuntech.gUnit_gmgl.gEU_charge.entity.ChargeData;
import com.topsuntech.gUnit_gmgl.gEU_charge.entity.ChargeType;
import com.topsuntech.gUnit_gmgl.gEU_charge.service.ChargeDataService;

public class ChargeDataServiceTest extends AbstractTestCase {

	ChargeDataService chargeDataService;
	ChargeData chargeData ;
	
	protected void setUp() throws Exception {
		super.setUp();
		chargeDataService = (ChargeDataService) applicationContext.getBean("chargeDataService");

		chargeData = new ChargeData();
		chargeData.setChargeDataPrice(Float.valueOf(2.33f));
		chargeData.setChargeDataName("heh");
		chargeData.setChargeType(null);
		chargeData.setSort(Long.valueOf(100));
		
		ChargeType chargeType = new ChargeType();
		chargeType.setId(Long.valueOf (1));
		
		chargeData.setChargeType(chargeType);
	}
	
	protected void tearDown() throws Exception{
		super.tearDown();
		chargeData = null;
		
	}
	public void testSaveChargeData(){
//		List<ChargeData> chargeDatas = chargeDataService.saveChargeData(chargeData);
//		assertEquals(chargeDatas.size() !=0 , true);
	}

}
