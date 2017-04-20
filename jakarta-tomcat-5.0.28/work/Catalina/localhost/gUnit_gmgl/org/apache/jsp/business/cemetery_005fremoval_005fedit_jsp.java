package org.apache.jsp.business;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class cemetery_005fremoval_005fedit_jsp extends org.apache.jasper.runtime.HttpJspBase
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
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_gOS_shjz_shjzUser_key;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_fmt_formatDate_value_pattern;

  public java.util.List getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_out_value = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_gOS_shjz_shjzUser_key = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_fmt_formatDate_value_pattern = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_out_value.release();
    _jspx_tagPool_c_if_test.release();
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
      out.write("\n<head>\n<script type=\"text/javascript\">\n\t//完成登记\n\tfunction endCemeteryRegistry(id,locationId){\n\t\tif(id == ''){\n\t\t\talert(\"请先保存信息\");\n\t\t\treturn false;\n\t\t}\n\t   \tlocation.href=\"cemeteryRegistryController.fj?method=endCemeteryRegistry&cemeteryRegistryType=4&id=\" + locationId;\n\t}\n\t\n\t//费用增加\n   function addCemeteryCharge(regeditId){\n\t\tif(regeditId == \"\"){\n\t\t\talert(\"请先保存信息\");\n\t\t\treturn false;\n\t\t}\n\t\tvar redirect_url =$.base64.encode('cemeteryRegistryController.fj?method=editCemeteryRegistry&cemeteryRegistryType=4&id='+regeditId);\n\t\tlocation.href = \"cemeteryRegistryController.fj?method=getCemeteryChargeframe&cemeteryRegistryType=4&id=\"+regeditId +\"&redirect_url=\"+redirect_url;\n   }\n   //上传文件\n   function getCemeteryFileEdit(regeditId){\n\t\tif(regeditId == \"\"){\n\t\t\talert(\"请先保存信息\");\n\t\t\treturn false;\n\t\t}\n\t\tvar redirect_url =$.base64.encode('cemeteryRegistryController.fj?method=editCemeteryRegistry&cemeteryRegistryType=4&id='+regeditId);\n\t\tlocation.href = \"cemeteryRegistryController.fj?method=getCemeteryFileEdit&cemeteryRegistryType=4&id=\"+regeditId +\"&redirect_url=\"+redirect_url;\n");
      out.write("   }\n\t   \n   function bulidPrice(){\n\t\t//墓位价格=工程费+土地租赁费+管理费\n\t\t$(\"#cemeteryPrice\").val(parseFloat($(\"#groundPrice\").text())+parseFloat($(\"#constructionPrice\").text())+parseFloat($(\"#managePrice\").text()));\n\t\tif(isNaN(parseFloat($(\"#cemeteryPrice\").val()))){\n\t\t\t$(\"#cemeteryPrice\").val(0);\n\t\t}\n\t\t\n\t\t//其他费用\n\t   \tvar charges = document.getElementsByName(\"charges\");\n\t   \tvar v_otherPrice = 0;\n\t   \tfor(i = 0; i< charges.length; i++){\n\t   \t\t\n\t   \t\tif(navigator.userAgent.indexOf('Firefox') >= 0){\n\t\t   \t\tvar val = charges[i].textContent;\n\t   \t\t}else{\n\t\t   \t\tvar val = charges[i].innerText;\n\t   \t\t}\n\t   \t\t\n\t   \t\t(val == \"\" || isNaN(val)) ? val = 0:val;\n\t   \t\tv_otherPrice = parseFloat(v_otherPrice) + parseFloat(val);\n\t      \t}\n\t   \t$(\"#otherPrice\").val(v_otherPrice);\n\n\t   \t// 应收费用=墓穴价格+其他费用\n\t   \t$(\"#totalPrice\").val(parseFloat($(\"#cemeteryPrice\").val())+ parseFloat($(\"#otherPrice\").val()));\n\t\t\n\t   \t//实收费用=应收费用-优惠费用\n\t\t($(\"#discountPrice\").val() == \"\" || isNaN($(\"#discountPrice\").val())) ? $(\"#discountPrice\").val(0) :$(\"#discountPrice\").val(parseFloat($(\"#discountPrice\").val()));\n");
      out.write("\t   \t$(\"#factPrice\").val(parseFloat($(\"#totalPrice\").val()) - parseFloat($(\"#discountPrice\").val()));\n\t\t\n   }\n $(document).ready(function(){\n\tbulidPrice();\n\t//保存按钮的校验\n\t$(\"#saveCemeteryRegistryBtn\").click(function(){\n\t    var backPrice=parseFloat($(\"#backPrice\").val());\n\t    if (isNaN(backPrice)) {\n\t        alert(\"退费金额需要输入数字\");\n\t        return false;\n\t    }\n\t    $(\"#saveCemeteryRegistyForm\").submit();\n\t });\n\t\t \n\t    \n });\n\nfunction showinfo(){\n\tvar is_oneself = $(\"input[name='isOneself']:checked\").val();\n\tif(is_oneself == 1){\n\t\t $(\"#no_oneself\").hide();\n\t\t $(\"#no_oneself2\").hide();\n\t\t $(\"#no_oneself3\").hide();\n\t}\n\tif(is_oneself ==0){\n\t\t$(\"#no_oneself\").show();\n\t\t$(\"#no_oneself2\").show();\n\t\t$(\"#no_oneself3\").show();\n\t}\n}\n</script>\n</head>\n<body style=\"background-color: transparent\">\n<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" height=\"100%\">\n    <tr>\n\t  <td width=\"11\" valign=\"top\" class=\"td-bg\"><img src=\"../images/right-1.jpg\" /></td>\n\t    <td align=\"center\" valign=\"top\">\n\t  \n\t  <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n");
      out.write("\t    <tr>\n\t      <td height=\"31\" align=\"left\" valign=\"middle\" \tstyle=\"background: url(../images/right-3.jpg)\"><img src=\"../images/right-4.jpg\" width=\"9\" height=\"8\" align=\"absmiddle\" /> 当前位置 &gt; 业务办理 &gt; 续租登记</td>\n\t    </tr>\n\t    <tr>\n\t      <td bgcolor=\"#FFFFFF\" style=\"font-size: 12px;\">&nbsp;</td>\n\t    </tr>\n\t  </table>\n\t  <!-- 输入域 --> <!-- 隐藏域 -->\n\t  <table width=\"98%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\n\t    <tr>\n\t      <td width=\"92%\" bgcolor=\"#EBF4FA\"><table width=\"200\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t          <tr>\n\t            <td width=\"20\" align=\"right\"><img src=\"../images/tab-01.jpg\" width=\"8\" height=\"27\" /></td>\n\t            <td width=\"99\" align=\"center\" class=\"tab-img-01\">迁出登记</td>\n\t            <td width=\"81\" align=\"left\" valign=\"bottom\"><img src=\"../images/tab-03.jpg\" /></td>\n\t          </tr>\n\t        </table></td>\n\t    </tr>\n\t  </table>\n\t\t  <form id=\"saveCemeteryRegistyForm\" action=\"cemeteryRegistryController.fj?method=saveCemeteryRegistry\" method=\"post\">\n\t\t  <input name=\"isSupply\" type=\"hidden\" id=\"isSupply\" value=\"0\" />\n");
      out.write("\t\t  <input name=\"cemeteryRegistryType\" type=\"hidden\" id=\"cemeteryRegistryType\" value=\"");
      if (_jspx_meth_c_out_0(pageContext))
        return;
      out.write("\" />\n\t\t  <input name=\"cemeteryLocationId\" type=\"hidden\" id=\"cemeteryLocationId\" value=\"");
      if (_jspx_meth_c_out_1(pageContext))
        return;
      out.write("\" />\n\t\t\t<input type=\"hidden\" name=\"id\" id=\"id\" value=\"");
      if (_jspx_meth_c_out_2(pageContext))
        return;
      out.write("\" />\n\t\t\t<table width=\"98%\" border=\"0\" cellspacing=\"0\" cellpadding=\"3\">\n\t\t\t    <tr>\n\t\t\t        <td bgcolor=\"#C4DEEE\">\n\t\t\t            <table id=\"baseInfo\" width=\"100%\" cellpadding=\"0\" cellspacing=\"1\" bgcolor=\"#a6c6da\">\n\t\t\t                <tr>\n\t\t\t                    <td width=\"15%\" height=\"35\" align=\"right\" bgcolor=\"#D4E5F4\">承租人本人办理：</td>\n\t\t\t                    <td width=\"35%\" align=\"left\" bgcolor=\"#FFFFFF\">\n\t\t\t\t\t\t\t\t\t<input name=\"isOneself\" type=\"radio\" id=\"isOneself\" onclick=\"javascirpt:showinfo()\" \n\t\t\t\t\t\t\t\t\tvalue=\"1\" ");
      if (_jspx_meth_c_if_0(pageContext))
        return;
      out.write(" />是\n\t\t\t\t\t\t            <input name=\"isOneself\" type=\"radio\" id=\"isOneself\"  onclick=\"javascirpt:showinfo()\" \n\t\t\t\t\t\t            value=\"0\" ");
      if (_jspx_meth_c_if_1(pageContext))
        return;
      out.write("  />否\n\t\t\t                    </td>\n\t\t\t                    <td width=\"15%\" align=\"right\" bgcolor=\"#D4E5F4\">业务编号：</td>\n\t\t\t                    <td width=\"35%\" align=\"left\" bgcolor=\"#FFFFFF\">\n\t\t\t                    \t<input name=\"cemeteryRegistryCode\" type=\"text\" id=\"cemeteryRegistryCode\" readonly=\"readonly\" class=\"input-1\" \n\t\t\t\t\t          \t\tvalue=\"");
      if (_jspx_meth_c_out_3(pageContext))
        return;
      out.write("\" /></td>\n\t\t\t                </tr>\n\t\t\t                    <tr id=\"no_oneself\">\n\t\t\t\t\t              <td width=\"15%\"  height=\"35\" align=\"right\" bgcolor=\"#D4E5F4\">代理人姓名： </td>\n\t\t\t\t\t              <td width=\"35%\" align=\"left\" bgcolor=\"#FFFFFF\"><input name=\"agentName\" type=\"text\"  class=\"input-1\" id=\"agentName\" \n\t\t\t\t\t            \t\tvalue=\"");
      if (_jspx_meth_c_out_4(pageContext))
        return;
      out.write("\" /></td>\n\t\t\t                      <td width=\"15%\" height=\"35\" align=\"right\" bgcolor=\"#D4E5F4\">代理人电话：</td>\n\t\t\t\t\t              <td  width=\"35%\" align=\"left\" bgcolor=\"#FFFFFF\"><input name=\"agentTel\" type=\"text\"  class=\"input-1\" id=\"agentTel\" \n\t\t\t\t\t            \t\tvalue=\"");
      if (_jspx_meth_c_out_5(pageContext))
        return;
      out.write("\" /></td>\n\t\t\t\t                </tr>\n\t\t\t                    <tr  id=\"no_oneself2\"> \n\t\t\t\t\t              <td width=\"15%\"  height=\"35\" align=\"right\" bgcolor=\"#D4E5F4\">代理凭证：</td>\n\t\t\t\t\t              <td width=\"35%\" align=\"left\" bgcolor=\"#FFFFFF\"><input name=\"agentProve\" type=\"text\"  class=\"input-1\" id=\"agentProve\" \n\t\t\t\t\t            \t\tvalue=\"");
      if (_jspx_meth_c_out_6(pageContext))
        return;
      out.write("\" /></td>\n\t\t\t                      <td width=\"15%\" height=\"35\" align=\"right\" bgcolor=\"#D4E5F4\">&nbsp;</td>\n\t\t\t\t\t              <td  width=\"35%\" align=\"left\" bgcolor=\"#FFFFFF\">&nbsp;</td>\n\t\t\t\t                </tr>\n\t\t\t                    <tr  id=\"no_oneself3\">\n\t\t\t\t\t              <td width=\"15%\"  height=\"35\" align=\"right\" bgcolor=\"#D4E5F4\">代理原因：</td>\n\t\t\t\t\t              <td height=\"35\" colspan=\"3\" align=\"left\" bgcolor=\"#FFFFFF\"><textarea name=\"agentReason\" >");
      if (_jspx_meth_c_out_7(pageContext))
        return;
      out.write("</textarea></td>\n\t\t\t                    </tr>\n\t\t\t\t\t        <tr>\n\t\t\t\t\t          <td height=\"35\" align=\"right\" bgcolor=\"#D4E5F4\">迁出原因：</td>\n\t\t\t\t\t          <td align=\"left\" bgcolor=\"#FFFFFF\"><input name=\"backReason\" type=\"text\" id=\"backReason\" class=\"input-1\" value=\"");
      if (_jspx_meth_c_out_8(pageContext))
        return;
      out.write("\" />\n\t\t\t\t\t           </td>\n\t\t\t\t\t          <td align=\"right\" bgcolor=\"#D4E5F4\">退费金额：</td>\n\t\t\t\t\t          <td align=\"left\" bgcolor=\"#FFFFFF\"><input name=\"backPrice\" type=\"text\" id=\"backPrice\" class=\"input-1\" value=\"");
      if (_jspx_meth_c_out_9(pageContext))
        return;
      out.write("\" />\n\t\t\t\t\t            （元）</td>\n\t\t\t\t\t        </tr>\n\t\t\t\t\t        <tr>\n\t\t\t\t\t          <td height=\"35\" align=\"right\" bgcolor=\"#D4E5F4\">业务员：</td>\n\t\t\t\t\t          <td align=\"left\" bgcolor=\"#FFFFFF\">");
      if (_jspx_meth_gOS_shjz_shjzUser_0(pageContext))
        return;
      out.write("</td>\n\t\t\t\t\t          <td align=\"right\" bgcolor=\"#D4E5F4\">办理时间：</td>\n\t\t\t\t\t          <td align=\"left\" bgcolor=\"#FFFFFF\">");
      if (_jspx_meth_fmt_formatDate_0(pageContext))
        return;
      out.write("</td>\n\t\t\t\t\t          </tr>\n\t\t\t\t\t        \n\t\t\t\t\t        <tr height='50px'>\n\t\t\t\t\t          <td align=\"right\" bgcolor=\"#D4E5F4\">备注：</td>\n\t\t\t\t\t          <td colspan='3' align=\"left\" bgcolor=\"#FFFFFF\"><textarea\tname=\"remark\" id=\"remark\" class=\"input-1\"\tstyle='height: 40px; width: 90%'>");
      if (_jspx_meth_c_out_10(pageContext))
        return;
      out.write("</textarea></td>\n\t\t\t\t\t        </tr>\n\t\t\t\t\t      </table>\n\t\t\t        </td>\n\t\t\t    </tr>\n\t\t\t</table>\n\t\t    <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t\t      <tr>\n\t\t        <td>&nbsp;</td>\n\t\t      </tr>\n\t\t    </table>\n\t\t        <table>\n\t\t          <tr>\n\t\t            <td height=\"35\">\n\t\t\t            <input name=\"button\" type=\"button\" class=\"button-z4\" id=\"saveCemeteryRegistryBtn\" value=\"保存\" />&nbsp;\n\t\t\t            <input name=\"button\" type=\"button\" class=\"button-z4\" value=\"打印业务单\" />&nbsp;\n\t\t\t            <input name=\"button\" type=\"button\" class=\"button-z4\" value=\"打印安葬证\" />&nbsp;\n\t\t\t            <input name=\"button\" type=\"button\" onclick=\"endCemeteryRegistry('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${entity.id}", java.lang.String.class, (PageContext)pageContext, null, false));
      out.write('\'');
      out.write(',');
      out.write('\'');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${entity.cemeteryLocation.id}", java.lang.String.class, (PageContext)pageContext, null, false));
      out.write("');\" class=\"button-z4\" value=\"完成\" />&nbsp;\n\t\t\t            <input name=\"button\" type=\"button\" onclick=\"javascript:location.href='cemeteryRegistryController.fj?method=getCemeteryRegistryPageList&cemeteryRegistryType=4';\" class=\"button-z4\" value=\"返回\" />\n\t\t            </td>\n\t\t          </tr>\n\t\t        </table>\n\t\t      </tr>\n\t\t    </table>\n\t\t  </form>\n\t    </td>\n    </tr>\n</table>\n</body>\n<script type=\"text/javascript\">\n\tshowinfo();\n</script>\n</html>\n");
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
    _jspx_th_c_out_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${entity.cemeteryRegistryType}", java.lang.Object.class, (PageContext)pageContext, null, false));
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
    _jspx_th_c_out_1.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${entity.cemeteryLocation.id}", java.lang.Object.class, (PageContext)pageContext, null, false));
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
    _jspx_th_c_out_2.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${entity.id}", java.lang.Object.class, (PageContext)pageContext, null, false));
    int _jspx_eval_c_out_2 = _jspx_th_c_out_2.doStartTag();
    if (_jspx_th_c_out_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_c_out_value.reuse(_jspx_th_c_out_2);
    return false;
  }

  private boolean _jspx_meth_c_if_0(PageContext pageContext)
          throws Throwable {
    JspWriter out = pageContext.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(pageContext);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${entity.isOneself == 1}", java.lang.Boolean.class, (PageContext)pageContext, null, false)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("checked=\"checked\"");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }

  private boolean _jspx_meth_c_if_1(PageContext pageContext)
          throws Throwable {
    JspWriter out = pageContext.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_1.setPageContext(pageContext);
    _jspx_th_c_if_1.setParent(null);
    _jspx_th_c_if_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${entity.isOneself == 0}", java.lang.Boolean.class, (PageContext)pageContext, null, false)).booleanValue());
    int _jspx_eval_c_if_1 = _jspx_th_c_if_1.doStartTag();
    if (_jspx_eval_c_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("checked=\"checked\"");
        int evalDoAfterBody = _jspx_th_c_if_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
    return false;
  }

  private boolean _jspx_meth_c_out_3(PageContext pageContext)
          throws Throwable {
    JspWriter out = pageContext.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_3 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_3.setPageContext(pageContext);
    _jspx_th_c_out_3.setParent(null);
    _jspx_th_c_out_3.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${entity.cemeteryRegistryCode}", java.lang.Object.class, (PageContext)pageContext, null, false));
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
    _jspx_th_c_out_4.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${entity.agentName}", java.lang.Object.class, (PageContext)pageContext, null, false));
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
    _jspx_th_c_out_5.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${entity.agentTel}", java.lang.Object.class, (PageContext)pageContext, null, false));
    int _jspx_eval_c_out_5 = _jspx_th_c_out_5.doStartTag();
    if (_jspx_th_c_out_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_c_out_value.reuse(_jspx_th_c_out_5);
    return false;
  }

  private boolean _jspx_meth_c_out_6(PageContext pageContext)
          throws Throwable {
    JspWriter out = pageContext.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_6 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_6.setPageContext(pageContext);
    _jspx_th_c_out_6.setParent(null);
    _jspx_th_c_out_6.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${entity.agentProve}", java.lang.Object.class, (PageContext)pageContext, null, false));
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
    _jspx_th_c_out_7.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${entity.agentReason}", java.lang.Object.class, (PageContext)pageContext, null, false));
    int _jspx_eval_c_out_7 = _jspx_th_c_out_7.doStartTag();
    if (_jspx_th_c_out_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_c_out_value.reuse(_jspx_th_c_out_7);
    return false;
  }

  private boolean _jspx_meth_c_out_8(PageContext pageContext)
          throws Throwable {
    JspWriter out = pageContext.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_8 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_8.setPageContext(pageContext);
    _jspx_th_c_out_8.setParent(null);
    _jspx_th_c_out_8.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${entity.backReason}", java.lang.Object.class, (PageContext)pageContext, null, false));
    int _jspx_eval_c_out_8 = _jspx_th_c_out_8.doStartTag();
    if (_jspx_th_c_out_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_c_out_value.reuse(_jspx_th_c_out_8);
    return false;
  }

  private boolean _jspx_meth_c_out_9(PageContext pageContext)
          throws Throwable {
    JspWriter out = pageContext.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_9 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_9.setPageContext(pageContext);
    _jspx_th_c_out_9.setParent(null);
    _jspx_th_c_out_9.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${entity.backPrice}", java.lang.Object.class, (PageContext)pageContext, null, false));
    int _jspx_eval_c_out_9 = _jspx_th_c_out_9.doStartTag();
    if (_jspx_th_c_out_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_c_out_value.reuse(_jspx_th_c_out_9);
    return false;
  }

  private boolean _jspx_meth_gOS_shjz_shjzUser_0(PageContext pageContext)
          throws Throwable {
    JspWriter out = pageContext.getOut();
    //  gOS_shjz:shjzUser
    com.topsuntech.gUnit.gEU_bzhhUtil.taglib.BzhhUserTag _jspx_th_gOS_shjz_shjzUser_0 = (com.topsuntech.gUnit.gEU_bzhhUtil.taglib.BzhhUserTag) _jspx_tagPool_gOS_shjz_shjzUser_key.get(com.topsuntech.gUnit.gEU_bzhhUtil.taglib.BzhhUserTag.class);
    _jspx_th_gOS_shjz_shjzUser_0.setPageContext(pageContext);
    _jspx_th_gOS_shjz_shjzUser_0.setParent(null);
    _jspx_th_gOS_shjz_shjzUser_0.setKey((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${entity.createUserId}", java.lang.String.class, (PageContext)pageContext, null, false));
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
    _jspx_th_fmt_formatDate_0.setValue((java.util.Date) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${entity.createDate}", java.util.Date.class, (PageContext)pageContext, null, false));
    _jspx_th_fmt_formatDate_0.setPattern("yyyy-MM-dd");
    int _jspx_eval_fmt_formatDate_0 = _jspx_th_fmt_formatDate_0.doStartTag();
    if (_jspx_th_fmt_formatDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_fmt_formatDate_value_pattern.reuse(_jspx_th_fmt_formatDate_0);
    return false;
  }

  private boolean _jspx_meth_c_out_10(PageContext pageContext)
          throws Throwable {
    JspWriter out = pageContext.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_10 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_10.setPageContext(pageContext);
    _jspx_th_c_out_10.setParent(null);
    _jspx_th_c_out_10.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${entity.remark}", java.lang.Object.class, (PageContext)pageContext, null, false));
    int _jspx_eval_c_out_10 = _jspx_th_c_out_10.doStartTag();
    if (_jspx_th_c_out_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_c_out_value.reuse(_jspx_th_c_out_10);
    return false;
  }
}
