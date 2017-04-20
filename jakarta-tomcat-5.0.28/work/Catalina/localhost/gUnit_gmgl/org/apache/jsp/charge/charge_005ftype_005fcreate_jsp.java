package org.apache.jsp.charge;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class charge_005ftype_005fcreate_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(4);
    _jspx_dependants.add("/charge/../common/head.jsp");
    _jspx_dependants.add("/charge/../common/taglib.jsp");
    _jspx_dependants.add("/WEB-INF/tld/freezer.tld");
    _jspx_dependants.add("/WEB-INF/tld/gTaglib-shjz.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_ft_select_type_style_name;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_gOS_shjz_shjzUser_key;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_out_value;

  public java.util.List getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_ft_select_type_style_name = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_gOS_shjz_shjzUser_key = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_out_value = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_ft_select_type_style_name.release();
    _jspx_tagPool_gOS_shjz_shjzUser_key.release();
    _jspx_tagPool_c_out_value.release();
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
      out.write("\r\n<head>\r\n\t<script type=\"text/javascript\">\r\n\t \r\n\tfunction doSubmit() {\r\n\t\tvar chargeTypeName = $.trim($(\"#chargeTypeName\").val());\r\n\t\tif (\"\" == chargeTypeName) {\r\n\t\t\talert(\"费用分类不能为空\");\r\n\t\t\treturn;\r\n\t\t}  \r\n\t\tif(chargeTypeName.length>20){\r\n\t\t\talert(\"费用分类的最大长度为20个字符\");\r\n\t\t\treturn;\r\n\t\t}\r\n\t\tvar chargeTypeDict=$(\"#chargeTypeDict\").val();\r\n\t\tif(\"0\"==chargeTypeDict){\r\n\t\t\talert(\"请选择具体分类！\");\r\n\t\t\treturn;\r\n\t\t}\r\n\t\tvar sort=$.trim($(\"#sort\").val());\r\n\t\tif(!/^[0-9]+$/g.test(sort)){\r\n\t\t\talert(\"排序字段为数字\");\r\n\t\t\treturn;\r\n\t\t}\r\n\t\tvar remark=$.trim($(\"#remark\").val());\r\n\t\tif(remark.length>20){\r\n\t\t\talert(\"备注的最大长度为20个字符\");\r\n\t\t\treturn;\r\n\t\t}\r\n\t\t$(\"#isform\").submit();\r\n\t\t \r\n\t}\r\n\t</script>\t\r\n</head>\r\n<body style=\"background-color: transparent\">\r\n<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\"\r\n\t\theight=\"100%\">\r\n\t\t<tr>\r\n\t\t\t<td width=\"11\" valign=\"top\" class=\"td-bg\"><img\r\n\t\t\t\tsrc=\"../images/right-1.jpg\" />\r\n\t\t\t</td>\r\n\t\t\t<td align=\"center\" valign=\"top\"><table width=\"100%\" border=\"0\"\r\n\t\t\t\t\tcellspacing=\"0\" cellpadding=\"0\">\r\n\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td height=\"31\" align=\"left\" valign=\"middle\"\r\n\t\t\t\t\t\t\tstyle=\"background: url(../images/right-3.jpg)\"><img\r\n\t\t\t\t\t\t\tsrc=\"../images/right-4.jpg\" width=\"9\" height=\"8\"\r\n\t\t\t\t\t\t\talign=\"absmiddle\" /> 当前位置 &gt; 费用管理 &gt; 费用分类维护</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td bgcolor=\"#FFFFFF\" style=\"font-size: 12px;\">&nbsp;</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t</table>\r\n\t<form action=\"chargeTypeController.fj?method=saveChargeType\"\r\n\t\tid=\"isform\" method=\"post\">\r\n\t\r\n\t\t<table width=\"98%\" cellpadding=\"0\" cellspacing=\"1\" bgcolor=\"#a6c6da\">\r\n\t\t\t<tr>\r\n\t\t\t\t<td height=\"35\" align=\"right\" bgcolor=\"#D4E5F4\">费用分类：</td>\r\n\t\t\t\t<td width=\"220\" align=\"left\" bgcolor=\"#FFFFFF\"><input name=\"chargeTypeName\"\r\n\t\t\t\t\ttype=\"text\" id=\"chargeTypeName\" class=\"input-1\" />\r\n\t\t    </td>\r\n\t\t\t  <td width=\"132\" align=\"right\" bgcolor=\"#D4E5F4\">大分类：</td>\r\n\t\t\t\t<td width=\"266\" align=\"left\" bgcolor=\"#FFFFFF\">\r\n\t\t\t    ");
      if (_jspx_meth_ft_select_0(pageContext))
        return;
      out.write("\r\n\t\t \r\n\t\t\t  </td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td align=\"right\" bgcolor=\"#D4E5F4\">是否有效：</td>\r\n\t\t\t\t<td align=\"left\" bgcolor=\"#FFFFFF\">\r\n\t\t\t     <input name=\"isValidate\" type=\"radio\"  value='1'checked=\"checked\"  />是\r\n\t\t\t\t<input name=\"isValidate\" type=\"radio\"   value='0'/>否  \r\n\t\t\t\t\r\n\t\t\t\t</td>\r\n\t\t\t  <td height=\"35\" align=\"right\" bgcolor=\"#D4E5F4\">排序：</td>\r\n\t\t\t\t<td align=\"left\" bgcolor=\"#FFFFFF\"><input name=\"sort\"\r\n\t\t\t\t\ttype=\"text\" id=\"sort\" class=\"input-1\" value='1' />\r\n\t\t\t\t</td>\r\n\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td height=\"35\" align=\"right\" bgcolor=\"#D4E5F4\">创建人：</td>\r\n\t\t    <td align=\"left\" bgcolor=\"#FFFFFF\">");
      if (_jspx_meth_gOS_shjz_shjzUser_0(pageContext))
        return;
      out.write("\r\n\t\t    </td>\r\n\t\t\t  <td height=\"35\" align=\"right\" bgcolor=\"#D4E5F4\">创建时间：</td>\r\n\t\t\t  <td align=\"left\" bgcolor=\"#FFFFFF\">");
      if (_jspx_meth_c_out_0(pageContext))
        return;
      out.write("</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td width=\"137\" height=\"35\" align=\"right\" bgcolor=\"#D4E5F4\">备注：</td>\r\n\t\t\t\t<td colspan=\"3\" align=\"left\" bgcolor=\"#FFFFFF\"><textarea\r\n\t\t\t\t\t\tname=\"remark\" id=\"remark\" style='height: 40px; width: 90%'\r\n\t\t\t\t\t\tclass=\"input-1\"></textarea>\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td height=\"35\" colspan=\"4\" align=\"center\" bgcolor=\"#FFFFFF\"> \r\n\t\t\t\t   <input  name=\"button\" type=\"button\"  onclick=\"javascript:doSubmit();\" class=\"button-z2\" value=\"保存\" />\r\n\t\t\t\t  &nbsp;&nbsp;&nbsp;&nbsp;\r\n\t\t\t\t  <input  name=\"button\" type=\"button\"  onclick=\"javascirpt:location.href='chargeTypeController.fj?method=getChargeTypeList';\" class=\"button-z2\" value=\"返回\" />\r\n\t\t        \r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t</table>\r\n\t</form>\r\n\t\r\n </td>\r\n\t\t</tr>\r\n\t</table>\r\n</body>\r\n</html>");
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

  private boolean _jspx_meth_ft_select_0(PageContext pageContext)
          throws Throwable {
    JspWriter out = pageContext.getOut();
    //  ft:select
    com.topsuntech.gUnit_gmgl.core.tagext.SelectTag _jspx_th_ft_select_0 = (com.topsuntech.gUnit_gmgl.core.tagext.SelectTag) _jspx_tagPool_ft_select_type_style_name.get(com.topsuntech.gUnit_gmgl.core.tagext.SelectTag.class);
    _jspx_th_ft_select_0.setPageContext(pageContext);
    _jspx_th_ft_select_0.setParent(null);
    _jspx_th_ft_select_0.setName("chargeTypeDict");
    _jspx_th_ft_select_0.setType("fyfl");
    _jspx_th_ft_select_0.setStyle("width:190px");
    int _jspx_eval_ft_select_0 = _jspx_th_ft_select_0.doStartTag();
    if (_jspx_th_ft_select_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_ft_select_type_style_name.reuse(_jspx_th_ft_select_0);
    return false;
  }

  private boolean _jspx_meth_gOS_shjz_shjzUser_0(PageContext pageContext)
          throws Throwable {
    JspWriter out = pageContext.getOut();
    //  gOS_shjz:shjzUser
    com.topsuntech.gUnit.gEU_bzhhUtil.taglib.BzhhUserTag _jspx_th_gOS_shjz_shjzUser_0 = (com.topsuntech.gUnit.gEU_bzhhUtil.taglib.BzhhUserTag) _jspx_tagPool_gOS_shjz_shjzUser_key.get(com.topsuntech.gUnit.gEU_bzhhUtil.taglib.BzhhUserTag.class);
    _jspx_th_gOS_shjz_shjzUser_0.setPageContext(pageContext);
    _jspx_th_gOS_shjz_shjzUser_0.setParent(null);
    _jspx_th_gOS_shjz_shjzUser_0.setKey((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cemeteryLocation.createUserId}", java.lang.String.class, (PageContext)pageContext, null, false));
    int _jspx_eval_gOS_shjz_shjzUser_0 = _jspx_th_gOS_shjz_shjzUser_0.doStartTag();
    if (_jspx_th_gOS_shjz_shjzUser_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_gOS_shjz_shjzUser_key.reuse(_jspx_th_gOS_shjz_shjzUser_0);
    return false;
  }

  private boolean _jspx_meth_c_out_0(PageContext pageContext)
          throws Throwable {
    JspWriter out = pageContext.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_0 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_0.setPageContext(pageContext);
    _jspx_th_c_out_0.setParent(null);
    _jspx_th_c_out_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentTime}", java.lang.Object.class, (PageContext)pageContext, null, false));
    int _jspx_eval_c_out_0 = _jspx_th_c_out_0.doStartTag();
    if (_jspx_th_c_out_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_c_out_value.reuse(_jspx_th_c_out_0);
    return false;
  }
}
