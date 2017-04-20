package com.topsuntech.gUnit_gmgl.gEU_webService;

import javax.jws.WebService;

/**
 * 费用类型管理
 * 
 * @author xuh 下午09:19:44 2014-7-22
 * 
 */
@WebService
public interface IChargeTypeManage {
	/**
	 * 创建新的费用分类
	 * 
	 * @param chargeCode
	 * @param chargeName
	 * @param remark
	 * @param parentChargeCode
	 * @return
	 */
	boolean insertChargeType(String chargeCode, String chargeName, String remark, String parentChargeCode);
}
