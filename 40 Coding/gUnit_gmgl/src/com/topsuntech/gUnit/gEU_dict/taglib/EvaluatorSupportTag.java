/*
 * Created on 2004-5-21
 *
 * To change the template for this generated file go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
package com.topsuntech.gUnit.gEU_dict.taglib;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.taglibs.standard.lang.support.ExpressionEvaluatorManager;

/**
 * 
 * 支持el语言的标签父类：必须要实现 String getResult(String arg1, String arg2, String arg3)方法；
 * 
 * 在子类中实现 标签属性的 set的方法，调用本类的 setArg1_ setArg2_ setArg2_方法；可以实现对三个以内
 * 变量的tag的支持。
 * 
 * @author 邵镜泽
 *
 * @ ApplicationDevelopment@topsunTech.com
 * @ Project No. TP200308
 * @ Version 1.0 
 */
public abstract class EvaluatorSupportTag extends TagSupport {	
	
	private Object arg1;
	private String arg1_;
	
	private Object arg2;
	private String arg2_;
	
	private Object arg3;
	private String arg3_;
	
	/**
	 * 
	 *  @throws JspException
	 */
	public int doStartTag() throws JspException{
//		Logger.debug("doStartTag ##################################### arg1_=#\n\n"+this.arg1_);
//		Logger.debug("doStartTag ##################################### arg2_=#\n\n"+this.arg2_);
//		Logger.debug("doStartTag ##################################### arg3_=#\n\n"+this.arg3_);
			doInit();
//			System.out.println("doStartTag 2 ######################################\n\n");
		    return SKIP_BODY;
		}
	
	private void doInit() throws JspException{
		evaluateExpressions();
	}
	/**
	 * 
	 * @throws JspException
	 */
	private void evaluateExpressions() throws JspException{
		//evaluate action this tag depends apache stander taglib jar
		if(arg1_ != null && arg1_.length() >1 ){
//			Logger.debug("-----------in named Tag evaluate--- befor\n---arg1_="+arg1_ +"----- arg1="+arg1);
			arg1 = ExpressionEvaluatorManager.evaluate("arg1", arg1_, java.lang.Object.class, this, pageContext);
//			Logger.debug("-----------in named Tag evaluate--- after\n---arg1_="+arg1_ +"----- arg1="+arg1);
		}
		
		if(arg2_ != null && arg2_.length() >1 ){
//			Logger.debug("-----------in named Tag evaluate--- befor\n---arg2_="+arg2_ +"----- arg2="+arg2);
			arg2 = ExpressionEvaluatorManager.evaluate("arg2", arg2_, java.lang.Object.class, this, pageContext);
//			Logger.debug("-----------in named Tag evaluate--- after\n---arg2_="+arg2_ +"----- arg2="+arg2);
		}
		if(arg3_ != null && arg3_.length() >1 ){
//			Logger.debug("-----------in named Tag evaluate--- befor\n---arg3_="+arg3_ +"----- arg3="+arg3);
			arg3 = ExpressionEvaluatorManager.evaluate("arg3", arg3_, java.lang.Object.class, this, pageContext);
//			Logger.debug("-----------in named Tag evaluate--- after\n---arg3_="+arg3_ +"----- arg3="+arg3);
		}
	}
	public void release(){
		arg1 = null;
		arg1_ = null;
		
		arg2 = null;
		arg2_ = null;
		
		arg3 = null;
		arg3_ = null;
	}
	
	/**
	 *  @throws JspException
	 */
	
    public int doEndTag() throws JspException {
		
	 try{
		    
		    String para1 = null;			
			String para2 = null;
			String para3 = null;
            if( arg1 != null){
				para1 = arg1.toString();
            }
			if( arg2 != null){
				para2 = arg2.toString();
			}
			if( arg3 != null){
				para3 = arg3.toString();
			}
						
		    String result =this.getResult(para1,para2,para3);
			
			JspWriter writer = pageContext.getOut();
			writer.print(result);
		}catch(IOException ie){
			ie.printStackTrace();
			throw new JspTagException("Error!" + ie.getClass().getName());
		}		
			
		
		return SKIP_BODY;
	}
	


	/**
	 * 为本类的第一个 String类型的arg1_赋值；
	 * @param 
	 */
	public void setArg1_(String arg1) {
		this.arg1_ = arg1;		
	}
	
	/**
	 * 为本类的 String类型的arg1_赋值；
	 * @param 
	 */
	public void setArg2_(String arg2) {
		this.arg2_ = arg2;		
	}	
	
	
	public abstract String getResult(String arg1, String arg2, String arg3);

}
