package com.topsuntech.gUnit.gEU_system.service;

import com.topsuntech.gOS.identity.user.service.UserManagerImpl;
import com.topsuntech.gOS.user.actions.AESUtil;

import com.topsuntech.gUnit.gEU_util.entity.AjDept;
import com.topsuntech.gUnit.gEU_util.entity.AjUser;

public class AjUserManager extends UserManagerImpl {

	/* 
	 * 系统保存调用的方法
	 * (non-Javadoc)
	 * @see com.topsuntech.gOS.identity.user.service.UserManagerImpl#doSaveInAction(java.lang.Object)
	 */
	public boolean doSaveInAction(Object entity) throws Exception {

		AjUser user = ((AjUser) entity);
		AjDept ajDept = (AjDept) getUserDao().getOfficeDao().getEntityById(
				new Long(user.getDeptid()));
		String userCode="";
		if(ajDept!=null&&ajDept.getApproveUnitCode()!=null){
			userCode=ajDept.getApproveUnitCode();
		}		
		//根据 userCode 查一下 user
		UserService service=new UserService();
//		int orderItem=service.getMaxOrderItem();
		int userSize=service.getUserCodeSize(userCode);
		int finalSize=1000+userSize+1;//当前号+1是下一个
    	String finalSizeCode=String.valueOf(finalSize); 
    	//这时候生成的号是1xxx 我需要把1去掉。留下XXX
    	String finalDeptCode=finalSizeCode.substring(1, 4);
    	String finaluserCode=userCode+finalDeptCode;//最终用户编码
    	user.setNum(finaluserCode);
    	String cardNum=null;
    	if(user.getIdentitynum()!=null&&!user.getIdentitynum().equals(""))
           cardNum="GWY"+user.getIdentitynum();
    	user.setCanumber(cardNum);
//    	user.setOrderByItem(orderItem+1);     	
    	//密码加密    	
    	user.setPassword(AESUtil.encrypt(user.getPassword()));
		return super.doSaveInAction(entity);
	}
	
	/* 
	 * 系统修改调用的方法
	 * (non-Javadoc)
	 * @see com.topsuntech.gOS.identity.user.service.UserManagerImpl#doUpdateInAction(java.lang.Object)
	 */
	public boolean doUpdateInAction(Object entity) throws Exception {
		AjUser user = ((AjUser) entity);
//		AjDept ajDept = (AjDept) getUserDao().getOfficeDao().getEntityById(
//				new Long(user.getDeptid()));
//		String userCode="";
//		if(ajDept!=null&&ajDept.getApproveUnitCode()!=null){
//			userCode=ajDept.getApproveUnitCode();
//		}		
//		//根据 userCode 查一下 user
		UserService service=new UserService();
//		int orderItem=service.getMaxOrderItem();
//		int userSize=service.getUserCodeSize(userCode);
//		int finalSize=1000+userSize+1;//当前号+1是下一个
//    	String finalSizeCode=String.valueOf(finalSize); 
//    	//这时候生成的号是1xxx 我需要把1去掉。留下XXX
//    	String finalDeptCode=finalSizeCode.substring(1, 4);
//    	String finaluserCode=userCode+finalDeptCode;//最终用户编码
//    	user.setNum(finaluserCode);	
		AjUser queryuser=service.queryAjUserById(String.valueOf(user.getId()));
		user.setCreatedate(queryuser.getCreatedate());
		user.setCreatorid(queryuser.getCreatorid());
		user.setCreatorname(queryuser.getCreatorname());
	//	user.setCanumber(queryuser.getCanumber());
//		user.setOrderByItem(queryuser.getOrderByItem());
		//user.setSfzf(queryuser.getSfzf());
		//密码加密    	
    //	user.setPassword(AESUtil.encrypt(user.getPassword()));
		return super.doUpdateInAction(user);
	}

}
