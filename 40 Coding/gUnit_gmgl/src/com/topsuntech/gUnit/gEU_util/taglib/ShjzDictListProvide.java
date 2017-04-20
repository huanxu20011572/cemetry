/*
 * Created on 2006-3-27
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.topsuntech.gUnit.gEU_util.taglib;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import com.topsuntech.gOS.gTaglib.provider.CollectionProvider;
import com.topsuntech.gOS.gTaglib.provider.Parameter;
import com.topsuntech.gOS.logger.Logger;
import com.topsuntech.gUnit.gEU_util.tools.Dicts;
/**
 * @author Lixirong
 *	decribe: 数据字典的List提供者 
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ShjzDictListProvide implements CollectionProvider {
    
    public Collection provide(Parameter param) {               
        
        String typeName = param.getParam(1).toString();
        String sysFlag = "";
        
        int paramSize =  param.getParamSize();
        if(paramSize >2 ){
            sysFlag = param.getParam(2).toString();
        }
                
        List list = null;
               
        try {
            list = Dicts.getDictsListByCodeToSystemFlag(typeName, sysFlag, null);            
        } catch (SQLException e) {
            Logger.error("fetch dict error", e);
        }
        
        return list;
    }
    
}
