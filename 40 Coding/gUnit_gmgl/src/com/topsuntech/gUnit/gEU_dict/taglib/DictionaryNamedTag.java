/*
 * Created on 2004-5-22
 *
 * To change the template for this generated file go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
package com.topsuntech.gUnit.gEU_dict.taglib;

import com.topsuntech.gOS.logger.Logger;
import com.topsuntech.gUnit.gEU_dict.service.DictionaryQuery;

/**
 * @author 邵镜泽
 * 继承了EvaluatorSupportTag 根据一个String类型的code取到 name 的名称
 * @ ApplicationDevelopment@topsunTech.com
 * @ Project No. TP200308
 * @ Version 1.0 
 */
public class DictionaryNamedTag extends EvaluatorSupportTag {
    
	/* (non-Javadoc)
	 * @see com.topsuntech.gUnit.gEU_bzCommon.taglib.NamedTag#getNameByCode(java.lang.String)
	 */
	 /**
	  * @author 邵镜泽
	  * @param code, 数据字典编码
	  * @param para2, 机构编码
	  * @return String,
	  */
	public String getResult(String code,String para2,String para3) {
		String dicName="";
		if(para2!=null && para2.length()>0 && code != null){
			try{
				dicName =  DictionaryQuery.findNameByType_Code(code,para2);
				if(dicName==null){
					dicName="";
				}
			}catch(Exception he){
				dicName=" ";
				he.printStackTrace();				
			}
		}else {			
			try{			
					if(code == null){
						dicName="";
						Logger.debug("the code is NULL!!");
					}else{
						dicName = DictionaryQuery.findNameByCode(code.trim());
					}				
				
				}catch(Exception he){
					dicName="";
					he.printStackTrace();				
				}
			}
		return dicName;		
	}


	/**
	 * @param dicCode
	 */
	public void setDicCode(String dicCode) {
		super.setArg1_(dicCode);
	}
	/**
	 * 部门id
	 * @param insititid
	 */
    public void setInsi(String insititid){
    	super.setArg2_(insititid);
    }
}
