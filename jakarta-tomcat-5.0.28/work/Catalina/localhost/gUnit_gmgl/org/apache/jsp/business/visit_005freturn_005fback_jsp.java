package org.apache.jsp.business;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class visit_005freturn_005fback_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(4);
    _jspx_dependants.add("/business/../common/head.jsp");
    _jspx_dependants.add("/business/../common/taglib.jsp");
    _jspx_dependants.add("/WEB-INF/tld/freezer.tld");
    _jspx_dependants.add("/WEB-INF/tld/gTaglib-shjz.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_out_value;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_gOS_shjz_shjzUser_key;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_fmt_formatDate_value_pattern;

  public java.util.List getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_out_value = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_gOS_shjz_shjzUser_key = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_fmt_formatDate_value_pattern = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_out_value.release();
    _jspx_tagPool_gOS_shjz_shjzUser_key.release();
    _jspx_tagPool_fmt_formatDate_value_pattern.release();
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

      out.write("\n<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n<html xmlns=\"http://www.w3.org/1999/xhtml\">\n");
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
      out.write("\n<body style=\"background-color: transparent\">\n\t<form action=\"\" id=\"isform\" method=\"post\">\n\t<input type=\"hidden\" value=\"");
      if (_jspx_meth_c_out_0(pageContext))
        return;
      out.write("\" name=\"id\" id=\"id\"/>\n\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" height=\"100%\">\n  <tr>\n    <td width=\"11\" valign=\"top\" class=\"td-bg\"><img src=\"../images/right-1.jpg\" /></td>\n    <td align=\"center\" valign=\"top\" ><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n      <tr>\n        <td height=\"31\" align=\"left\" valign=\"middle\" style=\"background:url(../images/right-3.jpg)\"><img src=\"../images/right-4.jpg\" width=\"9\" height=\"8\" align=\"absmiddle\" /> 当前位置 &gt; 售前管理  &gt; 来访登记  &gt; 回访  </td>\n      </tr>\n      <tr>\n        <td bgcolor=\"#FFFFFF\" style=\"font-size:12px;\">&nbsp;</td>\n      </tr>\n    </table>\n      <table width=\"98%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\n\t\t        <tr>\n\t\t          <td width=\"91%\" bgcolor=\"#EBF4FA\"><table width=\"200\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t\t            <tr>\n\t\t              <td width=\"20\" align=\"right\"><img src=\"../images/tab-01.jpg\" width=\"8\" height=\"27\" /></td>\n\t\t              <td width=\"99\" align=\"center\" class=\"tab-img-01\">登记信息 </td>\n");
      out.write("\t\t              <td width=\"81\" align=\"left\" valign=\"bottom\"><img src=\"../images/tab-03.jpg\" /></td>\n\t                </tr>\n\t              </table></td>\n\t\t          <td width=\"9%\" align=\"center\" bgcolor=\"#EBF4FA\">&nbsp;</td>\n\t            </tr>\n\t          </table>\n      <table width=\"98%\" cellpadding=\"0\" cellspacing=\"1\" bgcolor=\"#a6c6da\">\n\n        <tr>\n          <td width=\"15%\" height=\"35\" align=\"right\" bgcolor=\"#D4E5F4\">客户姓名：</td>\n          <td width=\"35%\" align=\"left\" bgcolor=\"#FFFFFF\">\n          ");
      if (_jspx_meth_c_out_1(pageContext))
        return;
      out.write("</td>\n          <td width=\"15%\" align=\"right\" bgcolor=\"#D4E5F4\">联系电话：</td>\n          <td width=\"35%\" align=\"left\" bgcolor=\"#FFFFFF\">\n          ");
      if (_jspx_meth_c_out_2(pageContext))
        return;
      out.write("</td>\n        </tr>\n        <tr>\n          <td width=\"15%\" height=\"35\" align=\"right\" bgcolor=\"#D4E5F4\">客户来源：</td>\n          <td width=\"35%\" align=\"left\" bgcolor=\"#FFFFFF\">\n          ");
      if (_jspx_meth_c_out_3(pageContext))
        return;
      out.write("</td>\n          <td width=\"15%\" align=\"right\" bgcolor=\"#D4E5F4\">来访人数：</td>\n          <td width=\"35%\" align=\"left\" bgcolor=\"#FFFFFF\">\n          ");
      if (_jspx_meth_c_out_4(pageContext))
        return;
      out.write("</td>\n        </tr>\n        <tr>\n          <td height=\"75px\" align=\"right\" bgcolor=\"#D4E5F4\">来访需求：</td>\n          <td  colspan='3' align=\"left\" bgcolor=\"#FFFFFF\">\n            ");
      if (_jspx_meth_c_out_5(pageContext))
        return;
      out.write("</td>\n        </tr>\n        <tr>\n          <td height=\"35\" align=\"right\" bgcolor=\"#D4E5F4\">登记人：</td>\n          <td align=\"left\" bgcolor=\"#FFFFFF\">\n\t\t      ");
      if (_jspx_meth_gOS_shjz_shjzUser_0(pageContext))
        return;
      out.write("\n\t\t  </td>\n          <td align=\"right\" bgcolor=\"#D4E5F4\">登记时间：</td>\n          <td align=\"left\" bgcolor=\"#FFFFFF\">\n\t\t    ");
      if (_jspx_meth_fmt_formatDate_0(pageContext))
        return;
      out.write("\n\t\t  </td>\n        </tr>\n        <tr>\n          <td height=\"75px\" align=\"right\" bgcolor=\"#D4E5F4\">备注：</td>\n          <td  colspan='3' align=\"left\" bgcolor=\"#FFFFFF\">\n            ");
      if (_jspx_meth_c_out_6(pageContext))
        return;
      out.write("</td>\n        </tr>\n      </table>\n      <br />\n      <table width=\"98%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\n\t\t        <tr>\n\t\t          <td width=\"91%\" bgcolor=\"#EBF4FA\"><table width=\"200\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t\t            <tr>\n\t\t              <td width=\"20\" align=\"right\"><img src=\"../images/tab-01.jpg\" width=\"8\" height=\"27\" /></td>\n\t\t              <td width=\"99\" align=\"center\" class=\"tab-img-01\">回访信息 </td>\n\t\t              <td width=\"81\" align=\"left\" valign=\"bottom\"><img src=\"../images/tab-03.jpg\" /></td>\n\t                </tr>\n\t              </table></td>\n\t\t          <td width=\"9%\" align=\"center\" bgcolor=\"#EBF4FA\">&nbsp;</td>\n\t            </tr>\n\t          </table>\n      <table width=\"98%\" cellpadding=\"0\" cellspacing=\"1\" bgcolor=\"#a6c6da\">\n\n        <tr>\n          <td width=\"15%\" height=\"35\" align=\"right\" bgcolor=\"#D4E5F4\">回访情况：</td>\n          <td height=\"50px\" colspan='3' align=\"left\" bgcolor=\"#FFFFFF\">\n                <textarea id=\"returnRemark\" name=\"returnRemark\" class=\"input-1\" style='height:60px;width:90%'>");
      if (_jspx_meth_c_out_7(pageContext))
        return;
      out.write("</textarea></td>\n        </tr>\n        <tr>\n          <td width=\"15%\" height=\"35\" align=\"right\" bgcolor=\"#D4E5F4\">登记人：</td>\n          <td width=\"35%\"  align=\"left\" bgcolor=\"#FFFFFF\">\n          ");
      if (_jspx_meth_gOS_shjz_shjzUser_1(pageContext))
        return;
      out.write("\n          </td>\n          <td width=\"15%\" align=\"right\" bgcolor=\"#D4E5F4\">登记时间：</td>\n          <td width=\"35%\" align=\"left\" bgcolor=\"#FFFFFF\">");
      if (_jspx_meth_fmt_formatDate_1(pageContext))
        return;
      out.write("</td>\n        </tr>\n      </table>\n\t  <table width=\"98%\" cellpadding=\"0\" cellspacing=\"0\">\n\t\t<tr>\n\t\t\t<td colspan=\"4\" align=\"center\" bgcolor=\"#FFFFFF\">\n\t\t\t\t&nbsp;\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td colspan=\"4\" align=\"center\" bgcolor=\"#FFFFFF\">\n\t\t\t\t<input class=\"button-z\" type=\"button\" name=\"saveBtn\" id=\"saveBtn\" value=\"保存\"  onclick=\"doSave();\"/>&nbsp;&nbsp;&nbsp;\n        \t\t<input class=\"button-z\" name=\"backBtn\" id=\"backBtn\" type=\"button\" onclick=\"doBack();\" value=\"返回\"/>\n\t\t\t</td>\n\t    </tr>\n\t</table>\n\t</td>\n  </tr>\n</table>\n\t\n\t</form>\n\t<script type=\"text/javascript\">\n\t\tfunction doSave(){\n\t\t\tvar returnRemark = $.trim($(\"#returnRemark\").val());\n\t\t\tif (\"\" == returnRemark) {\n\t\t\t\talert(\"回访情况不能为空！\");\n\t\t\t\treturn;\n\t\t\t}  \n\t\t\tif(returnRemark.length>300){\n\t\t\t\talert(\"回访情况的最大长度为300个字符！\");\n\t\t\t\treturn;\n\t\t\t}\n\t\t\tif(confirm(\"确定要保存？\")){\n\t\t\t\tisform.action = \"visitReturnController.fj?method=saveVisitReturnBack\";\n\t\t\t\t$(\"#isform\").submit();\n\t\t\t}\n\t\t}\n\t\tfunction doBack(){\n\t\t\tJavaScript:history.back();\n\t\t}\n\t</script>\n</body>\n</html>");
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

  private boolean _jspx_meth_c_out_0(PageContext pageContext)
          throws Throwable {
    JspWriter out = pageContext.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_0 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_0.setPageContext(pageContext);
    _jspx_th_c_out_0.setParent(null);
    _jspx_th_c_out_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${visitReturn.id}", java.lang.Object.class, (PageContext)pageContext, null, false));
    int _jspx_eval_c_out_0 = _jspx_th_c_out_0.doStartTag();
    if (_jspx_th_c_out_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_c_out_value.reuse(_jspx_th_c_out_0);
    return false;
  }

  private boolean _jspx_meth_c_out_1(PageContext pageContext)
          throws Throwable {
    JspWriter out = pageContext.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_1 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_1.setPageContext(pageContext);
    _jspx_th_c_out_1.setParent(null);
    _jspx_th_c_out_1.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${visitReturn.customerName}", java.lang.Object.class, (PageContext)pageContext, null, false));
    int _jspx_eval_c_out_1 = _jspx_th_c_out_1.doStartTag();
    if (_jspx_th_c_out_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_c_out_value.reuse(_jspx_th_c_out_1);
    return false;
  }

  private boolean _jspx_meth_c_out_2(PageContext pageContext)
          throws Throwable {
    JspWriter out = pageContext.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_2 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_2.setPageContext(pageContext);
    _jspx_th_c_out_2.setParent(null);
    _jspx_th_c_out_2.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${visitReturn.customerTel}", java.lang.Object.class, (PageContext)pageContext, null, false));
    int _jspx_eval_c_out_2 = _jspx_th_c_out_2.doStartTag();
    if (_jspx_th_c_out_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_c_out_value.reuse(_jspx_th_c_out_2);
    return false;
  }

  private boolean _jspx_meth_c_out_3(PageContext pageContext)
          throws Throwable {
    JspWriter out = pageContext.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_3 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_3.setPageContext(pageContext);
    _jspx_th_c_out_3.setParent(null);
    _jspx_th_c_out_3.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${visitReturn.customerSource}", java.lang.Object.class, (PageContext)pageContext, null, false));
    int _jspx_eval_c_out_3 = _jspx_th_c_out_3.doStartTag();
    if (_jspx_th_c_out_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_c_out_value.reuse(_jspx_th_c_out_3);
    return false;
  }

  private boolean _jspx_meth_c_out_4(PageContext pageContext)
          throws Throwable {
    JspWriter out = pageContext.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_4 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_4.setPageContext(pageContext);
    _jspx_th_c_out_4.setParent(null);
    _jspx_th_c_out_4.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${visitReturn.customerNum}", java.lang.Object.class, (PageContext)pageContext, null, false));
    int _jspx_eval_c_out_4 = _jspx_th_c_out_4.doStartTag();
    if (_jspx_th_c_out_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_c_out_value.reuse(_jspx_th_c_out_4);
    return false;
  }

  private boolean _jspx_meth_c_out_5(PageContext pageContext)
          throws Throwable {
    JspWriter out = pageContext.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_5 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_5.setPageContext(pageContext);
    _jspx_th_c_out_5.setParent(null);
    _jspx_th_c_out_5.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${visitReturn.customerReq}", java.lang.Object.class, (PageContext)pageContext, null, false));
    int _jspx_eval_c_out_5 = _jspx_th_c_out_5.doStartTag();
    if (_jspx_th_c_out_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_c_out_value.reuse(_jspx_th_c_out_5);
    return false;
  }

  private boolean _jspx_meth_gOS_shjz_shjzUser_0(PageContext pageContext)
          throws Throwable {
    JspWriter out = pageContext.getOut();
    //  gOS_shjz:shjzUser
    com.topsuntech.gUnit.gEU_bzhhUtil.taglib.BzhhUserTag _jspx_th_gOS_shjz_shjzUser_0 = (com.topsuntech.gUnit.gEU_bzhhUtil.taglib.BzhhUserTag) _jspx_tagPool_gOS_shjz_shjzUser_key.get(com.topsuntech.gUnit.gEU_bzhhUtil.taglib.BzhhUserTag.class);
    _jspx_th_gOS_shjz_shjzUser_0.setPageContext(pageContext);
    _jspx_th_gOS_shjz_shjzUser_0.setParent(null);
    _jspx_th_gOS_shjz_shjzUser_0.setKey((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${visitReturn.createUserId}", java.lang.String.class, (PageContext)pageContext, null, false));
    int _jspx_eval_gOS_shjz_shjzUser_0 = _jspx_th_gOS_shjz_shjzUser_0.doStartTag();
    if (_jspx_th_gOS_shjz_shjzUser_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_gOS_shjz_shjzUser_key.reuse(_jspx_th_gOS_shjz_shjzUser_0);
    return false;
  }

  private boolean _jspx_meth_fmt_formatDate_0(PageContext pageContext)
          throws Throwable {
    JspWriter out = pageContext.getOut();
    //  fmt:formatDate
    org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag _jspx_th_fmt_formatDate_0 = (org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag) _jspx_tagPool_fmt_formatDate_value_pattern.get(org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag.class);
    _jspx_th_fmt_formatDate_0.setPageContext(pageContext);
    _jspx_th_fmt_formatDate_0.setParent(null);
    _jspx_th_fmt_formatDate_0.setValue((java.util.Date) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${visitReturn.createDate}", java.util.Date.class, (PageContext)pageContext, null, false));
    _jspx_th_fmt_formatDate_0.setPattern("yyyy-MM-dd");
    int _jspx_eval_fmt_formatDate_0 = _jspx_th_fmt_formatDate_0.doStartTag();
    if (_jspx_th_fmt_formatDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_fmt_formatDate_value_pattern.reuse(_jspx_th_fmt_formatDate_0);
    return false;
  }

  private boolean _jspx_meth_c_out_6(PageContext pageContext)
          throws Throwable {
    JspWriter out = pageContext.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_6 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_6.setPageContext(pageContext);
    _jspx_th_c_out_6.setParent(null);
    _jspx_th_c_out_6.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${visitReturn.remark}", java.lang.Object.class, (PageContext)pageContext, null, false));
    int _jspx_eval_c_out_6 = _jspx_th_c_out_6.doStartTag();
    if (_jspx_th_c_out_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_c_out_value.reuse(_jspx_th_c_out_6);
    return false;
  }

  private boolean _jspx_meth_c_out_7(PageContext pageContext)
          throws Throwable {
    JspWriter out = pageContext.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_7 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_7.setPageContext(pageContext);
    _jspx_th_c_out_7.setParent(null);
    _jspx_th_c_out_7.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${visitReturn.returnRemark}", java.lang.Object.class, (PageContext)pageContext, null, false));
    int _jspx_eval_c_out_7 = _jspx_th_c_out_7.doStartTag();
    if (_jspx_th_c_out_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_c_out_value.reuse(_jspx_th_c_out_7);
    return false;
  }

  private boolean _jspx_meth_gOS_shjz_shjzUser_1(PageContext pageContext)
          throws Throwable {
    JspWriter out = pageContext.getOut();
    //  gOS_shjz:shjzUser
    com.topsuntech.gUnit.gEU_bzhhUtil.taglib.BzhhUserTag _jspx_th_gOS_shjz_shjzUser_1 = (com.topsuntech.gUnit.gEU_bzhhUtil.taglib.BzhhUserTag) _jspx_tagPool_gOS_shjz_shjzUser_key.get(com.topsuntech.gUnit.gEU_bzhhUtil.taglib.BzhhUserTag.class);
    _jspx_th_gOS_shjz_shjzUser_1.setPageContext(pageContext);
    _jspx_th_gOS_shjz_shjzUser_1.setParent(null);
    _jspx_th_gOS_shjz_shjzUser_1.setKey((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${visitReturn.returnUserId}", java.lang.String.class, (PageContext)pageContext, null, false));
    int _jspx_eval_gOS_shjz_shjzUser_1 = _jspx_th_gOS_shjz_shjzUser_1.doStartTag();
    if (_jspx_th_gOS_shjz_shjzUser_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_gOS_shjz_shjzUser_key.reuse(_jspx_th_gOS_shjz_shjzUser_1);
    return false;
  }

  private boolean _jspx_meth_fmt_formatDate_1(PageContext pageContext)
          throws Throwable {
    JspWriter out = pageContext.getOut();
    //  fmt:formatDate
    org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag _jspx_th_fmt_formatDate_1 = (org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag) _jspx_tagPool_fmt_formatDate_value_pattern.get(org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag.class);
    _jspx_th_fmt_formatDate_1.setPageContext(pageContext);
    _jspx_th_fmt_formatDate_1.setParent(null);
    _jspx_th_fmt_formatDate_1.setValue((java.util.Date) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${visitReturn.returnDate}", java.util.Date.class, (PageContext)pageContext, null, false));
    _jspx_th_fmt_formatDate_1.setPattern("yyyy-MM-dd");
    int _jspx_eval_fmt_formatDate_1 = _jspx_th_fmt_formatDate_1.doStartTag();
    if (_jspx_th_fmt_formatDate_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_fmt_formatDate_value_pattern.reuse(_jspx_th_fmt_formatDate_1);
    return false;
  }
}
