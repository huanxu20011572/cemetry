package com.topsuntech.gUnit.gEU_bzhhUtil.taglib;

/**
 * @author Lixirong
 *	
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

//
//import com.topsuntech.gOS.gTaglib.provider.Parameter;
//import com.topsuntech.gUnit.common.util.Util;
import com.topsuntech.gUnit.gEU_util.forms.ListBean;
import com.topsuntech.gUnit.gEU_util.tools.Dicts;

//import java.beans.IntrospectionException;
//import java.beans.PropertyDescriptor;
import java.io.IOException;
//import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.*;
//import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.BodyTagSupport;
//import org.apache.regexp.RE;
import org.apache.taglibs.standard.lang.support.ExpressionEvaluatorManager;

public class BzhhSelectTreeTag extends BodyTagSupport
{
//    private static class PairEntity
//    {
//
//        private Object key;
//        private Object value;
//
//        private Object getKey()
//        {
//            return key;
//        }
//
//        private Object getValue()
//        {
//            return value;
//        }
//
//        public String toString()
//        {
//            String ret = "key:" + key + "\n";
//            ret = ret + "value:" + value;
//            return ret;
//        }
//
//
//
//        public PairEntity(Object key, Object value)
//        {
//            this.key = key;
//            this.value = value;
//        }
//    }


//    private static final int ITEM_TYPE_UNKNOWN = 0;
//    private static final int ITEM_TYPE_COLLECTION = 1;
//    private static final int ITEM_TYPE_ARRAY = 2;
//    private static final int ITEM_TYPE_CLASS = 3;
//    private static RE regExp;
//    private static Map classMap = new HashMap();
    private String name;
    private String style;
    private String styleClass;
//    private String keyProperty;
//    private String valueProperty;
    private String items_;
    private Object items;
    private String selected_;
    private Object selected;
    private String onchange_;
    private Object onchange;
    private List optionsList;
    //static Class class$0; /* synthetic field */

    public BzhhSelectTreeTag()
    {
        release();
    }

    public void setItems(String items_)
    {
        this.items_ = items_;
    }

    public void setSelected(String selected_)
    {
        this.selected_ = selected_;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setStyle(String style)
    {
        this.style = style;
    }

//    public void setKeyProperty(String keyProperty)
//    {
//        this.keyProperty = keyProperty;
//    }
//
//    public void setValueProperty(String valueProperty)
//    {
//        this.valueProperty = valueProperty;
//    }

    public void setOnchange(String onchange_)
    {
        this.onchange_ = onchange_;
    }

    public void setStyleClass(String styleClass)
    {
        this.styleClass = styleClass;
    }

    private void init()
        throws JspException
    {
        evaluateExpressions();
        if(items != null){
            return;           
        }else{
            throw new JspException("items object is not a collection or an array object");
        }
    }

    private void evaluateExpressions()
        throws JspException
    {
        
        if(items_ != null)
            items = ExpressionEvaluatorManager.evaluate("items", items_, java.lang.Object.class, this, pageContext);
        if(selected_ != null)
            selected = ExpressionEvaluatorManager.evaluate("selected", selected_, java.lang.Object.class, this, pageContext);
        if(onchange_ != null)
            onchange = ExpressionEvaluatorManager.evaluate("onchange", onchange_, java.lang.Object.class, this, pageContext);
        
    }

    private String generateHtml()
        throws JspException
    {
        StringBuffer buf = new StringBuffer();
        buf.append("<select name=\"" + name + "\"");
        if(style != null)
            buf.append(" style=\"" + style + "\"");
        if(styleClass != null)
            buf.append(" class=\"" + styleClass + "\"");
        if(onchange != null)
            buf.append(" onchange=\"" + onchange.toString() + "\"");
        buf.append(">\n");
       
        if(items != null)
        {   
            generateOption(buf);
        }
        buf.append("</select>\n");
        return buf.toString();
    }

    private void generateOption(StringBuffer buf)
    {
     
        try {
            optionsList = Dicts.getDictionaryList(5074);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(optionsList != null){
            for(int i =0 ; i <optionsList.size(); i++){
                ListBean bean = (ListBean)optionsList.get(i);
                if(Integer.parseInt(selected.toString()) == bean.getKey())
                	buf.append("<option value="+ bean.getKey() + " selected>" +bean.getValue()+ "</option>");
                else
                	buf.append("<option value="+ bean.getKey() + ">" +bean.getValue()+ "</option>");
            }                
        }
    }
//    private Object getObjectProperty(Object obj, String property)
//        throws JspException
//    {
//        if(obj == null)
//            return null;
//        Class cls = obj.getClass();
//        PropertyDescriptor propertyDescriptor;
//        try
//        {
//            propertyDescriptor = new PropertyDescriptor(property, cls);
//        }
//        catch(IntrospectionException ex)
//        {
//            throw new JspException("access object " + property + " property getter method error", ex);
//        }
//        Method method = propertyDescriptor.getReadMethod();
//        Object o = null;
//        try
//        {
//            o = method.invoke(obj, null);
//        }
//        catch(Exception ex)
//        {
//            throw new JspException("get object " + property + " property return value error", ex);
//        }
//        return o;
//    }

    public int doStartTag()
        throws JspException
    {
        init();
        return super.doStartTag();
    }

    public int doEndTag()
        throws JspException
    {
        String html = generateHtml();
        try
        {
            pageContext.getOut().print(html);
        }
        catch(IOException e)
        {
            throw new JspException("write to out error", e);
        }
        release();
        return 6;
    }

    public void release(){
        name = null;
        style = null;
//        keyProperty = null;
//        valueProperty = null;
        styleClass = null;
        items_ = null;
        items = null;
        selected_ = null;
        selected = null;
        onchange = null;
        onchange_ = null;
        if(optionsList != null)
            optionsList.clear();
    }
//
//    private boolean checkExpress(String exp)
//    {
//        if(exp == null || exp.length() == 0){
//            return false;
//        }else{
//            RE reg = getRegExp();
//            return reg.match(exp);
//        }
//    }
//
//    private RE getRegExp(){
//        if(regExp == null)
//            regExp = new RE("class\\{\\s*([^\\(]*)\\(([^\\)]*)\\)\\s*}");
//        return regExp;
//    }
//
//    private Parameter buildParameter(HttpServletRequest request, String param)
//    {
//        if(param == null || param.length() == 0)
//            return null;
//        Parameter parameter = new Parameter();
//        String parm[] = Util.splitString(param, ",");
//        for(int i = 0; i < parm.length; i++)
//        {
//            String p = parm[i];
//            if("$request".equalsIgnoreCase(p))
//                parameter.addParam(request);
//            else
//                parameter.addParam(p.trim());
//        }
//
//        return parameter;
//    }

}