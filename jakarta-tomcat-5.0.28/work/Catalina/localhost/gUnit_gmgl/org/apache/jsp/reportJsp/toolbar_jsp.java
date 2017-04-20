package org.apache.jsp.reportJsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class toolbar_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  public java.util.List getDependants() {
    return _jspx_dependants;
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

      out.write('\n');
	String appmap = request.getContextPath();
	String printImage = "<img src='" + appmap + "/images/print.gif' border=no >";
	String excelImage = "<img src='" + appmap + "/images/excel.gif' border=no >";
	String pdfImage = "<img src='" + appmap + "/images/pdf.gif' border=no >";
    String wordImage = "<img src='" + appmap + "/images/doc.gif' border=no >";
	String firstPageImage = "<img src='" + appmap + "/images/firstpage.gif' border=no >";
	String lastPageImage = "<img src='" + appmap + "/images/lastpage.gif' border=no >";
	String nextPageImage = "<img src='" + appmap + "/images/nextpage.gif' border=no >";
	String prevPageImage = "<img src='" + appmap + "/images/prevpage.gif' border=no >";
	String submitImage = "<img src='" + appmap + "/images/savedata.gif' border=no >";

      out.write("\n\n<table id=titleTable width=100% cellspacing=0 cellpadding=0 border=0 ><tr>\n\t<td height=\"25\" width=100% valign=\"middle\"  style=\"font-size:13px\" background=\"../images/toolbar-bg.gif\">\n\t\t<table width=\"100%\">\n\t\t\t<tr >\n\t\t\t\t\n\t\t\t\t<td width=\"100%\" align=\"right\" valign=\"middle\"   style=\"font-size:12px; line-height:12px; margin:3px 0 0 0 ;\" >&nbsp;\n\t\t\t\t<span style=\" margin:0 10px 0 0 ; padding:5px 0 0 0 ; background: url(../images/toolbar-line.gif) no-repeat right top;\">\n\t\t\t\t<a href=\"#\" onClick=\"report1_print();return false;\">");
      out.print(printImage);
      out.write("</a>\n\t\t\t\t<a href=\"#\" onClick=\"report1_saveAsExcel();return false;\">");
      out.print(excelImage);
      out.write("</a>\n\t\t\t\t<a href=\"#\" onClick=\"report1_saveAsPdf();return false;\">");
      out.print(pdfImage);
      out.write("</a>\n\t\t\t\t<a href=\"#\" onClick=\"report1_saveAsWord();return false;\">");
      out.print(wordImage);
      out.write("</a>\n\t\t\t\t<a href=\"#\" onClick=\"_submitTable( report1 );return false;\">");
      out.print(submitImage);
      out.write("</a>\n\t\t\t\t</span>\n\t\t\t\t<a href=\"#\" onClick=\"try{report1_toPage( 1 );}catch(e){}return false;\">");
      out.print(firstPageImage);
      out.write("</a>\n\t\t\t\t<a href=\"#\" onClick=\"try{report1_toPage(report1_getCurrPage()-1);}catch(e){}return false;\">");
      out.print(prevPageImage);
      out.write("</a>\n\t\t\t\t<a href=\"#\" onClick=\"try{report1_toPage(report1_getCurrPage()+1);}catch(e){}return false;\">");
      out.print(nextPageImage);
      out.write("</a>\n\t\t\t\t<a href=\"#\" onClick=\"try{report1_toPage(report1_getTotalPage());}catch(e){}return false;\">");
      out.print(lastPageImage);
      out.write("</a>&nbsp;&nbsp;第<span id=\"c_page_span\"></span>页/共<span id=\"t_page_span\"></span>页\t\t  </td>\n\t\t\t</tr>\n\t  </table>\n\t</td>\n</table>");
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
