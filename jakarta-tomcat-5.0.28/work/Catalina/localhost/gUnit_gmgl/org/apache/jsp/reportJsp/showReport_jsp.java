package org.apache.jsp.reportJsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.*;
import java.util.*;
import com.runqian.report4.usermodel.Context;

public final class showReport_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(1);
    _jspx_dependants.add("/WEB-INF/tld/runqianReport4.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_report_param_params_paramFileName_needSubmit_name;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_report_html_width_reportFileName_params_needPageMark_needLinkStyle_name_generateParamForm_funcBarLocation_exceptionPage;

  public java.util.List getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_report_param_params_paramFileName_needSubmit_name = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_report_html_width_reportFileName_params_needPageMark_needLinkStyle_name_generateParamForm_funcBarLocation_exceptionPage = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_report_param_params_paramFileName_needSubmit_name.release();
    _jspx_tagPool_report_html_width_reportFileName_params_needPageMark_needLinkStyle_name_generateParamForm_funcBarLocation_exceptionPage.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    JspFactory _jspxFactory = null;
    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;


    try {
      _jspxFactory = JspFactory.getDefaultFactory();
      response.setContentType("text/html;charset=GBK");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n\n\n\n\n\n<html>\n<body topmargin=0 leftmargin=0 rightmargin=0 bottomMargin=0>\n");

	request.setCharacterEncoding( "GBK" );
	String report = request.getParameter( "raq" );
	String reportFileHome=Context.getInitCtx().getMainDir();
	StringBuffer param=new StringBuffer();

	session.setAttribute("user_id","111111");

	//保证报表名称的完整性
	int iTmp = 0;
	if( (iTmp = report.lastIndexOf(".raq")) <= 0 ){
		report = report + ".raq";
		iTmp = 0;
	}
	
	Enumeration paramNames = request.getParameterNames();
	if(paramNames!=null){
		while(paramNames.hasMoreElements()){
			String paramName = (String) paramNames.nextElement();
			String paramValue=request.getParameter(paramName);
			if(paramValue!=null){
				//把参数拼成name=value;name2=value2;.....的形式
				param.append(paramName).append("=").append(paramValue).append(";");
			}
		}
	}

	//以下代码是检测这个报表是否有相应的参数模板
	String paramFile = report.substring(0,iTmp)+"_arg.raq";
	File f=new File(application.getRealPath(reportFileHome+ File.separator +paramFile));


      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "toolbar.jsp", out, false);
      out.write("\n<table id=rpt align=center><tr><td>\n");
	//如果参数模板存在，则显示参数模板
	if( f.exists() ) {
	
      out.write("\n\t<table id=param_tbl><tr><td>\n\t\t");
      //  report:param
      com.runqian.report4.tag.ParamTag _jspx_th_report_param_0 = (com.runqian.report4.tag.ParamTag) _jspx_tagPool_report_param_params_paramFileName_needSubmit_name.get(com.runqian.report4.tag.ParamTag.class);
      _jspx_th_report_param_0.setPageContext(pageContext);
      _jspx_th_report_param_0.setParent(null);
      _jspx_th_report_param_0.setName("form1");
      _jspx_th_report_param_0.setParamFileName(paramFile);
      _jspx_th_report_param_0.setNeedSubmit("no");
      _jspx_th_report_param_0.setParams(param.toString());
      int _jspx_eval_report_param_0 = _jspx_th_report_param_0.doStartTag();
      if (_jspx_th_report_param_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      _jspx_tagPool_report_param_params_paramFileName_needSubmit_name.reuse(_jspx_th_report_param_0);
      out.write("\n\t</td>\n\t<td><a href=\"javascript:_submit( form1 )\"><img src=\"../images/query.jpg\" border=no style=\"vertical-align:middle\"></a></td>\n\t</tr></table>\n\t");
 }

      out.write("\n\n<table align=center>\n\t<tr><td>\n\t\t");
      //  report:html
      com.runqian.report4.tag.HtmlTag _jspx_th_report_html_0 = (com.runqian.report4.tag.HtmlTag) _jspx_tagPool_report_html_width_reportFileName_params_needPageMark_needLinkStyle_name_generateParamForm_funcBarLocation_exceptionPage.get(com.runqian.report4.tag.HtmlTag.class);
      _jspx_th_report_html_0.setPageContext(pageContext);
      _jspx_th_report_html_0.setParent(null);
      _jspx_th_report_html_0.setName("report1");
      _jspx_th_report_html_0.setReportFileName(report);
      _jspx_th_report_html_0.setFuncBarLocation("");
      _jspx_th_report_html_0.setNeedPageMark("yes");
      _jspx_th_report_html_0.setGenerateParamForm("no");
      _jspx_th_report_html_0.setNeedLinkStyle("yes");
      _jspx_th_report_html_0.setParams(param.toString());
      _jspx_th_report_html_0.setWidth("-1");
      _jspx_th_report_html_0.setExceptionPage("/reportJsp/myError2.jsp");
      int _jspx_eval_report_html_0 = _jspx_th_report_html_0.doStartTag();
      if (_jspx_th_report_html_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      _jspx_tagPool_report_html_width_reportFileName_params_needPageMark_needLinkStyle_name_generateParamForm_funcBarLocation_exceptionPage.reuse(_jspx_th_report_html_0);
      out.write("\n\t</td></tr>\n</table>\n\n<script language=\"javascript\">\n\t//设置分页显示值\n\tdocument.getElementById( \"t_page_span\" ).innerHTML=report1_getTotalPage();\n\tdocument.getElementById( \"c_page_span\" ).innerHTML=report1_getCurrPage();\n\tfunction show_detail(orderId){\n\t\twindow.open(\"showReport.jsp?raq=order_detail.raq&orderid=\"+orderId,\"_blank\");\n\t}\n</script>\n</body>\n</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (pageContext != null) pageContext.handlePageException(t);
      }
    } finally {
      if (_jspxFactory != null) _jspxFactory.releasePageContext(pageContext);
    }
  }
}
