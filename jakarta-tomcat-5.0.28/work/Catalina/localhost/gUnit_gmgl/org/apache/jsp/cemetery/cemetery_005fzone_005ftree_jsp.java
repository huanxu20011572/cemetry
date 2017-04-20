package org.apache.jsp.cemetery;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class cemetery_005fzone_005ftree_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(4);
    _jspx_dependants.add("/cemetery/../common/head.jsp");
    _jspx_dependants.add("/cemetery/../common/taglib.jsp");
    _jspx_dependants.add("/WEB-INF/tld/freezer.tld");
    _jspx_dependants.add("/WEB-INF/tld/gTaglib-shjz.tld");
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write('\n');
      out.write("\n\n\n\n\n");
      out.write("\n<head>\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n<title>北京公墓管理系统</title>\n<link rel=\"icon\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)pageContext, null, false));
      out.write("/favicon.ico\" type=\"image/x-icon\" media=\"screen\" />\n<link rel=\"shortcut icon\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)pageContext, null, false));
      out.write("/favicon.ico\" type=\"image/x-icon\" media=\"screen\" />\n<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)pageContext, null, false));
      out.write("/jscript/jquery-easyui-1.3.2/themes/default/easyui.css\">\n<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)pageContext, null, false));
      out.write("/jscript/jquery-easyui-1.3.2/themes/icon.css\">\n<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)pageContext, null, false));
      out.write("/jscript/jquery-easyui-1.3.2/jquery-1.8.0.min.js\"></script>\n<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)pageContext, null, false));
      out.write("/jscript/jquery-easyui-1.3.2/jquery.easyui.min.js\"></script>\n<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)pageContext, null, false));
      out.write("/jscript/jquery-easyui-1.3.2/locale/easyui-lang-zh_CN.js\"></script>\n<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)pageContext, null, false));
      out.write("/jscript/My97DatePicker/WdatePicker.js\"></script>\n<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)pageContext, null, false));
      out.write("/jscript/jquery.base64.js\"></script>\n\n<link href=\"../css/style.css\" rel=\"stylesheet\" type=\"text/css\" />\n</head>\n");
      out.write("\r\n<body style=\"background-color: transparent\">\r\n\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\"\r\n\t\theight=\"100%\">\r\n\t\t<tr>\r\n\t\t\t<td width=\"11\" valign=\"top\" class=\"td-bg\"><img\r\n\t\t\t\tsrc=\"../images/right-1.jpg\" />\r\n\t\t\t</td>\r\n\t\t\t<td align=\"center\" valign=\"top\"><table width=\"100%\" border=\"0\"\r\n\t\t\t\t\tcellspacing=\"0\" cellpadding=\"0\">\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td height=\"31\" align=\"left\" valign=\"middle\"\r\n\t\t\t\t\t\t\tstyle=\"background: url(../images/right-3.jpg)\"><img\r\n\t\t\t\t\t\t\tsrc=\"../images/right-4.jpg\" width=\"9\" height=\"8\"\r\n\t\t\t\t\t\t\talign=\"absmiddle\" /> 当前位置 &gt; 系统维护管理 &gt; 区排管理</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td bgcolor=\"#FFFFFF\" style=\"font-size: 12px;\">&nbsp;</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t</table>\r\n\r\n\t\t\t\t<div class=\"easyui-layout\" style=\"width: 100%; height: 450px;\">\r\n\t\t\t\t\t<div data-options=\"region:'west',title:'区排管理',split:true\" style=\"width: 200px;\">\r\n\t\t\t\t\t\t<ul id=\"lefttree\"></ul>\r\n\t\t\t\t\t</div>\r\n\t\t\t\t\t<div id=\"mainPanle\" region=\"center\" style=\"padding: 10px 0 10px 10px;\">\r\n\t\t\t\t\t\t<iframe src=\"\" frameborder=\"0\" width=\"100%\" height=\"100%\" scrolling=\"auto\" id=\"treelist\" name=\"treelist\" allowtransparency=\"true\"></iframe>\r\n");
      out.write("\t\t\t\t\t\t\t<!--cemeteryZoneController.fj?method=getCemteryZoneListByPid&pid=0  -->\r\n\t\t\t\t\t</div>\r\n\r\n\t\t\t\t</div></td>\r\n\t\t</tr>\r\n\t</table>\r\n\r\n\t<script type=\"text/javascript\">\r\n\t\t$(function() {\r\n\t\t\t$('#treelist').attr(\"src\",\"cemeteryZoneController.fj?method=getCemteryZoneListByPid&pid=0\");\r\n\t\t\t\r\n\t\t\t$('#lefttree').tree({\r\n\t\t\turl : 'cemeteryZoneController.fj?method=getCemteryZoneTree',\r\n\t\t\tanimate : true,\r\n\t\t\tonClick : function(node) {\r\n\t\t\t\tvar value = \"cemeteryZoneController.fj?method=getCemteryZoneListByPid&pid=\";\r\n\t\t\t\t$('#treelist').attr(\"src\", value + node.id);\r\n\t\t\t},\r\n\t\t\tonBeforeExpand : function(node, param) {\r\n\t\t\t\tvar value = \"cemeteryZoneController.fj?method=getCemteryZoneTreeByPid&pid=\";\r\n\t\t\t\t$('#lefttree').tree('options').url = value + node.id;\r\n\t\t\t}\r\n\t\t\t});\r\n\r\n\t\t\t$('#p').panel('close');\r\n\t\t});\r\n\t</script>\r\n\r\n</body>\r\n</html>\r\n");
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
