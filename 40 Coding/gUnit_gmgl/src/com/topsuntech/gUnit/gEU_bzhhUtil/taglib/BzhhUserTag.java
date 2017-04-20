package com.topsuntech.gUnit.gEU_bzhhUtil.taglib;

import java.util.Map;

import com.topsuntech.gOS.gTaglib.html.KeyValueTag;
import com.topsuntech.gUnit.gEU_util.tools.Dicts;

/**
 * @author Lixirong
 *	
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

public class BzhhUserTag extends KeyValueTag {

   /**
    * 获取'用户姓名'
    * @param param1		'useID'
    * @param param2
    */
    public Object getValue(Object param1, Map param2) {
        String ctValue = "";
        if(param1 == null){
            return null;
        }
        
        try {
            ctValue = Dicts.getUserNameById(Long.parseLong(param1.toString()));
        } catch (Exception e) {
            e.printStackTrace();
        }               
        return ctValue;        
    }
  
}
