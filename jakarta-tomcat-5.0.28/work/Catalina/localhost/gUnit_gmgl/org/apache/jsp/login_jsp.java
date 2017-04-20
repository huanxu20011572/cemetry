package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(5);
    _jspx_dependants.add("/common/taglibs.jsp");
    _jspx_dependants.add("/WEB-INF/tld/struts-bean.tld");
    _jspx_dependants.add("/WEB-INF/tld/struts-html.tld");
    _jspx_dependants.add("/WEB-INF/tld/gTaglib-shjz.tld");
    _jspx_dependants.add("/WEB-INF/tld/gTaglib-gOS.tld");
  }

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
      response.setContentType("text/html; charset=GBK");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\n');
      out.write("\n\n\n\n\n\n\n\n\n\n");
      out.write('\n');
	
request.getSession().setAttribute("logType", "mima");		

      out.write("\n<html>\n<head>\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=gb2312\" />\n<title>平台管理</title>\n</head>\n<body>\n<form name=\"loginform\" method=\"post\" action=\"login.do\" >\n<input type=\"hidden\" name=\"action\" value=\"login\">\n<input type=\"hidden\" name=\"sysTemFlag\" value=\"tjbz\" >\n<table  width=\"50%\">\n\t<tr height=\"40\" >\n\t\t<td>登陆名：</td><td><input type=\"text\" name=\"username\" value=\"admin\"/></td>\n\t</tr>\n\t<tr height=\"40\">\n\t\t<td>密码：</td><td><input type=\"password\" name=\"password\" value=\"123456\"/></td>\n\t</tr>\n\t<tr height=\"40\">\n\t\t<td colspan=\"2\"><input type=\"submit\" value=\"确定\"></td>\n\t</tr>\n\t\n</table>\n\n</form>\n</body>\n</html>");
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
