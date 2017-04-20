package com.topsuntech.gUnit.gEU_bzhhUtil.taglib;

import java.sql.SQLException;
import java.util.Map;
import com.topsuntech.gOS.gTaglib.html.KeyValueTag;
import com.topsuntech.gUnit.gEU_util.tools.Dicts;

/**
 * @author Lixirong
 *	
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

public class BzhhOrgNodeValueTag extends KeyValueTag {

    private String flag;
    
    /**
     * @param flag The flag to set.
     */
    public void setFlag(String flag) {
        this.flag = flag;
    }
   /**
    * 组织机构：通过'ID'获取相应的'VALUE'
    * @param param1		'ID'
    * @param param2     'flag'
    */
    public Object getValue(Object param1, Map param2) {
        String ctValue = "";
        if(param1 == null || param1.toString().trim().length() == 0){
            return null;
        }
        
        try {
            ctValue = Dicts.getOrgNameById(Long.parseLong(param1.toString()), flag);            
        } catch (SQLException e) {
            e.printStackTrace();
        }               
        return ctValue;        
    }
  
}
