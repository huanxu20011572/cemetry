package com.topsuntech.gUnit.gEU_bzhhUtil.taglib;

import java.util.Map;
import javax.servlet.jsp.JspException;
import org.apache.taglibs.standard.lang.support.ExpressionEvaluatorManager;
import com.topsuntech.gOS.gTaglib.html.KeyValueTag;
import com.topsuntech.gUnit.gEU_util.tools.Dicts;

/**
 * @author Lixirong
 * 日期类：获取两日期之间的天数
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */

public class BzhhParseDateTag extends KeyValueTag {
	private String beginDate_;
	private Object beginDate;
	private Object endDate;
	private String endDate_;	
	private Long days;


    public void setBeginDate(String beginDate_) {
        this.beginDate_ = beginDate_;
    }
    public void setEndDate(String endDate_){
        this.endDate_ = endDate_;
    }    
    public void setDays(Long days) {
        this.days = days;
    }
    private void evaluateExpressions(){
        try{                
            if(beginDate_ != null){
                beginDate = ExpressionEvaluatorManager.evaluate("beginDate", beginDate_, java.lang.Object.class, this, pageContext);            
                beginDate_ = beginDate.toString();
            }
            if(endDate_ != null){
                endDate = ExpressionEvaluatorManager.evaluate("endDate", endDate_, java.lang.Object.class, this, pageContext);            
                endDate_ = endDate.toString();
            }
            
        }catch(Exception e){
            ;
        }
    }

    
    public int doStartTag() throws JspException{        
        evaluateExpressions();
        return super.doStartTag();
    }
    
	public Object getValue(Object param1, Map param2) {
	    if( param1 != null && param1.toString().equals("day")){	        
	        
            int i = beginDate_.toString().indexOf("$");
            int j = endDate_.toString().indexOf("$");
            if(i >= 0 || j >= 0)
                return null;
                        
	        long count = Dicts.getBetweenDay(beginDate_, endDate_);	        
	        if(days != null )
	            count = count - days.longValue();
	        
	        if(count > 0)
	            return Long.toString(count) ;						
	        else
	            return null;
	    }else{
	        return null;
	    }
		

	}

}
