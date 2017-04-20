package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.topsuntech.gOS.user.session.*;
import com.topsuntech.gOS.user.en.user.*;
import com.topsuntech.gOS.user.en.office.Office;
import com.topsuntech.gOS.config.user.userXuewei.dao.UserXueweiFactory;
import com.topsuntech.gOS.config.user.userZhicheng.dao.UserZhichengFactory;
import java.util.Collection;

public final class top_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n\n\n\n\n\n\n<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n<html xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n<title>北京公墓管理系统</title>\n<link href=\"css/style.css\" rel=\"stylesheet\" type=\"text/css\" />\n</head>\n");

	User user = UserSession.getUser(request);
	long creatorId = 2;
	String creatorName = "root";
	if (user!=null) {
		creatorId = user.getId().longValue();		
		creatorName = user.getName();
		
	}
	
	Office off = UserSession.getUserDept(request); 	
	long regionId = off.getRegionid();		

      out.write("\n<body>\n<div class=\"topdiv word-1\">\n<div class=\"topdiv-1\">\n<div class=\"topdiv-2\">\n  <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n    <tr>\n      <td width=\"1%\" height=\"83\">&nbsp;</td>\n      <td width=\"45%\">&nbsp;</td>\n      <td width=\"34%\">&nbsp;</td>\n      <td width=\"20%\">&nbsp;</td>\n    </tr>\n    <tr>\n      <td height=\"26\">&nbsp;</td>\n      <td><img src=\"images/ico-1.jpg\" width=\"13\" height=\"15\" align=\"absmiddle\" />&nbsp;[");
      out.print(creatorName);
      out.write("]&nbsp;欢迎您登录</td>\n      <td align=\"right\" valign=\"middle\"><img src=\"images/ico-2.jpg\" width=\"16\" height=\"16\" align=\"absmiddle\" /><a href=\"frame/default.html\" target=\"frame1\">首页</a></td>\n      <td align=\"right\"><img src=\"images/ico-2.jpg\" width=\"16\" height=\"16\" align=\"absmiddle\" />&nbsp;修改密码&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src=\"images/ico-2.jpg\" width=\"16\" height=\"16\" align=\"absmiddle\" />&nbsp;退出&nbsp;&nbsp;&nbsp;&nbsp;</td>\n    </tr>\n  </table>\n  \n</div>\n</div>\n</div>\n</body>\n</html>\n");
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
