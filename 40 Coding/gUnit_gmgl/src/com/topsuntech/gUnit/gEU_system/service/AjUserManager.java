package com.topsuntech.gUnit.gEU_system.service;

import com.topsuntech.gOS.identity.user.service.UserManagerImpl;
import com.topsuntech.gOS.user.actions.AESUtil;

import com.topsuntech.gUnit.gEU_util.entity.AjDept;
import com.topsuntech.gUnit.gEU_util.entity.AjUser;

public class AjUserManager extends UserManagerImpl {

	/* 
	 * ϵͳ������õķ���
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
		//���� userCode ��һ�� user
		UserService service=new UserService();
//		int orderItem=service.getMaxOrderItem();
		int userSize=service.getUserCodeSize(userCode);
		int finalSize=1000+userSize+1;//��ǰ��+1����һ��
    	String finalSizeCode=String.valueOf(finalSize); 
    	//��ʱ�����ɵĺ���1xxx ����Ҫ��1ȥ��������XXX
    	String finalDeptCode=finalSizeCode.substring(1, 4);
    	String finaluserCode=userCode+finalDeptCode;//�����û�����
    	user.setNum(finaluserCode);
    	String cardNum=null;
    	if(user.getIdentitynum()!=null&&!user.getIdentitynum().equals(""))
           cardNum="GWY"+user.getIdentitynum();
    	user.setCanumber(cardNum);
//    	user.setOrderByItem(orderItem+1);     	
    	//�������    	
    	user.setPassword(AESUtil.encrypt(user.getPassword()));
		return super.doSaveInAction(entity);
	}
	
	/* 
	 * ϵͳ�޸ĵ��õķ���
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
//		//���� userCode ��һ�� user
		UserService service=new UserService();
//		int orderItem=service.getMaxOrderItem();
//		int userSize=service.getUserCodeSize(userCode);
//		int finalSize=1000+userSize+1;//��ǰ��+1����һ��
//    	String finalSizeCode=String.valueOf(finalSize); 
//    	//��ʱ�����ɵĺ���1xxx ����Ҫ��1ȥ��������XXX
//    	String finalDeptCode=finalSizeCode.substring(1, 4);
//    	String finaluserCode=userCode+finalDeptCode;//�����û�����
//    	user.setNum(finaluserCode);	
		AjUser queryuser=service.queryAjUserById(String.valueOf(user.getId()));
		user.setCreatedate(queryuser.getCreatedate());
		user.setCreatorid(queryuser.getCreatorid());
		user.setCreatorname(queryuser.getCreatorname());
	//	user.setCanumber(queryuser.getCanumber());
//		user.setOrderByItem(queryuser.getOrderByItem());
		//user.setSfzf(queryuser.getSfzf());
		//�������    	
    //	user.setPassword(AESUtil.encrypt(user.getPassword()));
		return super.doUpdateInAction(user);
	}

}
