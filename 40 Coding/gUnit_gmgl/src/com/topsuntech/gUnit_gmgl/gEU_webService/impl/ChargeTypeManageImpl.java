package com.topsuntech.gUnit_gmgl.gEU_webService.impl;

import javax.jws.WebService;

import com.topsuntech.gUnit_gmgl.gEU_webService.IChargeTypeManage;

@WebService(endpointInterface = "com.topsuntech.gUnit_gmgl.gEU_webService.IChargeTypeManage")
public class ChargeTypeManageImpl implements IChargeTypeManage {

	@Override
	public boolean insertChargeType(String chargeCode, String chargeName, String remark, String parentChargeCode) {
		// TODO Auto-generated method stub
		return false;
	}

}
