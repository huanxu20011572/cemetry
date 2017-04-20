package org.apache.jsp.cemetery;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class cemetery_005fcharge_005fedit_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(4);
    _jspx_dependants.add("/cemetery/../common/head.jsp");
    _jspx_dependants.add("/cemetery/../common/taglib.jsp");
    _jspx_dependants.add("/WEB-INF/tld/freezer.tld");
    _jspx_dependants.add("/WEB-INF/tld/gTaglib-shjz.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_gOS_shjz_shjzUser_key;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_fmt_formatDate_value_pattern;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_out_value;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_ft_select_type_style_selected_name;

  public java.util.List getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_gOS_shjz_shjzUser_key = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_fmt_formatDate_value_pattern = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_out_value = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_ft_select_type_style_selected_name = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_gOS_shjz_shjzUser_key.release();
    _jspx_tagPool_fmt_formatDate_value_pattern.release();
    _jspx_tagPool_c_out_value.release();
    _jspx_tagPool_ft_select_type_style_selected_name.release();
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
      out.write("\n<head>\n<title>商品出库管理</title>\n<script type=\"text/javascript\">\nfunction saveOutStorehouse() {\n\tvar outStoreType = document.getElementById(\"outStoreType\").value;\n\tdocument.getElementById(\"outStorehouseType\").value=outStoreType;\n\tcemeteryChargeForm.action = \"cemeteryChargeController.fj?method=saveCemeteryChargeList\";\n\t$(\"#cemeteryChargeForm\").submit();\n}\nfunction doBack(){\n\tvar redirect_url = '../cemetery/cemeteryChargeController.fj?method=getCemeteryChargeList';\n\tlocation.href=redirect_url;\n}\n\nfunction autoIframe() {\n\tvar ifm= document.getElementById(\"iframepage\");\n\tvar subWeb = document.frames ? document.frames[\"iframepage\"].document : ifm.contentDocument;\n\tif(ifm != null && subWeb != null) {\n\t\tifm.height = subWeb.body.scrollHeight;\n\t}\n} \n\n$(document).ready(function(){\n\t//selectChargeType商品0，费用1，\n\n\tvar ifm= document.getElementById(\"iframepage\");\n\t//选择项\n    $(\"#selectChargeType\").change(function(){\n\t \tif($(\"#selectChargeType\").val() == 0){\n\t \t\tifm.src = \"../cemetery/cemeteryCommodityController.fj?method=getCemeteryCommodityList&checked=checked\";\n");
      out.write("\t \t}\n\t \tif($(\"#selectChargeType\").val() == 1){\n\t \t\tifm.src = \"../charge/chargeDataController.fj?method=getChargeDataList&checked=checked\";\n\t \t}\n    });\n\t  \n\t$(\"#queryBtn\").click(function(){\n\t\tif($(\"#selectChargeType\").val() == 0){\n\t \t\tifm.src = \"../cemetery/cemeteryCommodityController.fj?method=getCemeteryCommodityList&checked=checked&commodityName=\"+$('#commodityName').val()+\"&commodityType=\"+$('#commodityType').val();\n\t \t}\n    });\n});\n\n/**\n * 回调函数，如果页面元素没有被选择可以增加页面元素\n * row:checked元素\n * id:商品id/费用id，\n * name:商品名称/费用明细名称\n * isChargeType0商品1费用，\n * typeName商品类型/费用类型\n * price价格\n * num商品数量\n */\nfunction doAppendCharge(row,id,name,isChargeType,typeName,price,num){\n\t if(row.checked == true && checkedCharge(id,isChargeType)){\n\t\t\tvar tr=\"<tr>\";\n\t\t\ttr += \"<td height='30' align='center' bgcolor='#FFFFFF'><input  type='hidden' id='isChargeType' name='isChargeType' value='\"+isChargeType+\"' /><input  type='hidden' id='id' name='id'  value='\" + id + \"'/>\"+name+\"</td>\";\n\t\t\ttr += \"<td align='center' bgcolor='#FFFFFF'>\"+typeName+\"</td>\";\n");
      out.write("\t\t\ttr += \"<td align='center' bgcolor='#FFFFFF'>\"+price+\"</td>\";\n\t\t\ttr += \"<td align='center' bgcolor='#FFFFFF' ><input  type='text' \";\n\t\t\t\tif(isChargeType == 0){\n\t\t\t\t\ttr += \"onkeyup='javascript:bulidCommodityPrice(this,\"+id+\",\"+num+\",\"+price+\");' \";\n\t\t\t\t}else{\n\t\t\t\t\ttr += \"readonly='readonly' \";\n\t\t\t\t}\n\t\t\ttr += \"id='count' name='count' value='1'/></td>\";\n\t\t\ttr += \"<td align='center' bgcolor='#FFFFFF'><input  type='text' readonly='readonly' id='receive' name='receive'  value='\"+price+\"'/></td>\";\n\t\t\ttr += \"<td align='center' bgcolor='#FFFFFF' class='word-7' ><a href='#' onclick='deleteCharge(this)'>删除</a></td>\";\n\t\t\ttr += \"</tr>\";\n\t\t$(\"#cemeteryChargeTable\").append(tr);\n\t }\n}\n\n//删除cemeteryCharge\nfunction deleteCharge(node){\n\t$(node).parent().parent().remove(); \n}\n\n//校验内容是否被重复选中，被选择中返回false;\nfunction checkedCharge(id,isChargeType){\n\t var ids = $(\"input[name='id']\");\n\t for(var i=0; i<ids.length;i++){\n\t\t if(ids[i].value == id && $(\"input[name='isChargeType']\")[i].value == isChargeType){\n\t\t\t return false;\n\t\t }\n\t }\n\t return true;\n");
      out.write("}\n\n//计算费用金额\nfunction bulidCommodityPrice(i_input,id,num,price){\n\t if (isNaN(i_input.value) || i_input.value <1) {\n\t        alert(\"请正确输入数量\");\n\t        return false;\n\t }\n\t if (i_input.value > num) {\n\t        alert(\"收入数量不能大于库存数量\");\n\t        return false;\n\t }\n\t var ids = $(\"input[name='id']\");\n\t for(var i=0; i<ids.length;i++){\n\t\t if(ids[i].value == id){\n\t\t\t $(\"input[name='receive']\")[i].value = i_input.value * price;\n\t\t }\n\t }\n}\n</script>\n</head>\n \n<body style=\"background-color:transparent\">\n<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" height=\"100%\">\n  <tr>\n    <td width=\"11\" valign=\"top\" class=\"td-bg\"><img src=\"../images/right-1.jpg\" /></td>\n    <td align=\"center\" valign=\"top\" >\n\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n      <tr>\n        <td height=\"31\" align=\"left\" valign=\"middle\" style=\"background:url(../images/right-3.jpg)\"><img src=\"../images/right-4.jpg\" width=\"9\" height=\"8\" align=\"absmiddle\" /> 当前位置 &gt;商品管理 &gt;出库登记</td>\n      </tr>\n      <tr>\n        <td bgcolor=\"#FFFFFF\" style=\"font-size:12px;\">&nbsp;</td>\n");
      out.write("      </tr>\n    </table>\n    <table width=\"98%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\n                <tr>\n                    <td width=\"15%\" bgcolor=\"#EBF4FA\">\n                        <table width=\"200\" border=\"0\" align=\"left\" cellpadding=\"0\" cellspacing=\"0\">\n                            <tr>\n                                <td width=\"20\" align=\"right\"><img src=\"../images/tab-01.jpg\" width=\"8\" height=\"27\"/>\n                                </td>\n                                <td width=\"99\" align=\"center\" class=\"tab-img-01\">出库信息</td>\n                                <td width=\"81\" align=\"left\" valign=\"bottom\"><img src=\"../images/tab-03.jpg\"/></td>\n                            </tr>\n                        </table>\n                    </td>\n                    <td width=\"70%\" align=\"left\" bgcolor=\"#EBF4FA\">\n                    </td>\n                    <td width=\"15%\" align=\"left\" bgcolor=\"#EBF4FA\">\n                    </td>\n                </tr>\n            </table>\n            <table width=\"98%\" cellpadding=\"0\" cellspacing=\"1\" bgcolor=\"#a6c6da\">\n");
      out.write("                <!-- 表格一行两类-->\n                <tr>\n                    <td width=\"15%\" height=\"35\" align=\"right\" bgcolor=\"#D4E5F4\">出库类型：</td>\n                    <td width=\"35\" align=\"left\" bgcolor=\"#FFFFFF\">\n                        <select id=\"outStoreType\" name=\"outStoreType\" class=\"input-1\" style=\"height:20px\" >\n                            <OPTION value='1' selected=\"selected\">售卖</OPTION>\n                            <option value='2'>赠送</option>\n                            <option value='3'>损耗</option>\n                        </select>\n                    </td>\n                    <td width=\"15%\" align=\"right\" bgcolor=\"#D4E5F4\"></td>\n                    <td width=\"35\" align=\"left\" bgcolor=\"#FFFFFF\"></td>\n                </tr>\n                <tr>\n                    <td height=\"35\" align=\"right\" bgcolor=\"#D4E5F4\">登记人：</td>\n                    <td align=\"left\" bgcolor=\"#FFFFFF\">\n                    ");
      if (_jspx_meth_gOS_shjz_shjzUser_0(pageContext))
        return;
      out.write("\n                    </td>\n                    <td align=\"right\" bgcolor=\"#D4E5F4\">登记时间：</td>\n                    <td align=\"left\" bgcolor=\"#FFFFFF\">");
      if (_jspx_meth_fmt_formatDate_0(pageContext))
        return;
      out.write("\n                    </td>\n                </tr>\n            </table>\n\n            <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n                <tr>\n                    <td>&nbsp;</td>\n                </tr>\n            </table>\n    \n    <table width=\"98%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\n                <tr>\n                    <td width=\"15%\" bgcolor=\"#EBF4FA\">\n                        <table width=\"200\" border=\"0\" align=\"left\" cellpadding=\"0\" cellspacing=\"0\">\n                            <tr>\n                                <td width=\"20\" align=\"right\"><img src=\"../images/tab-01.jpg\" width=\"8\" height=\"27\"/>\n                                </td>\n                                <td width=\"99\" align=\"center\" class=\"tab-img-01\">选择商品</td>\n                                <td width=\"81\" align=\"left\" valign=\"bottom\"><img src=\"../images/tab-03.jpg\"/></td>\n                            </tr>\n                        </table>\n                    </td>\n                    <td width=\"70%\" align=\"left\" bgcolor=\"#EBF4FA\">\n");
      out.write("                    </td>\n                    <td width=\"15%\" align=\"left\" bgcolor=\"#EBF4FA\">\n                    </td>\n                </tr>\n            </table>\n      <table width=\"98%\" cellpadding=\"0\" cellspacing=\"1\" bgcolor=\"#a6c6da\">\n         <tr>\n          <td width=\"15%\" align=\"right\" bgcolor=\"#D4E5F4\">商品名称：</td>\n          <td width=\"35%\" align=\"left\" bgcolor=\"#FFFFFF\">\n          \t<input name=\"commodityName\" type=\"text\" class=\"input-1\" id=\"commodityName\" value=\"");
      if (_jspx_meth_c_out_0(pageContext))
        return;
      out.write("\"/>\n          </td>\n          <td width=\"15%\" height=\"35\" align=\"right\" bgcolor=\"#D4E5F4\">商品分类：</td>\n          <td width=\"35%\" align=\"left\" bgcolor=\"#FFFFFF\">\n            <input name=\"selectChargeType\" type=\"hidden\" class=\"input-1\" id=\"selectChargeType\" value=\"0\"/>\n            ");
      if (_jspx_meth_ft_select_0(pageContext))
        return;
      out.write("\n\t\t  </td>\n        </tr>\n        <tr>\n            <td height=\"35\" colspan=\"4\" align=\"center\" bgcolor=\"#FFFFFF\">\n\t\t      <input name=\"queryBtn\" type=\"button\" class=\"button-z\" id=\"queryBtn\" value=\"查询\" /> \n\t\t      <input name=\"resetBtn\" type=\"button\" onclick=\"javascript:$('#name').val('');\" class=\"button-z\" id=\"resetBtn\" value=\"重置\" />\n\t\t\t</td>\n        </tr>\n      </table>\n\t  <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n       <tr>\n         <td>&nbsp;</td>\n        </tr>\n      </table>\n      <iframe onLoad=\"autoIframe();\" id=\"iframepage\" name=\"iframepage\" frameBorder=0 scrolling=no width=\"98%\" \n      src=\"../cemetery/cemeteryCommodityController.fj?method=getCemeteryCommodityList&checked=checked\" ></iframe>\n\t <table width=\"98%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\n         <tr>\n\t        <td width=\"92%\" bgcolor=\"#EBF4FA\">\n\t\t\t<table width=\"200\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t          <tr>\n\t            <td width=\"20\" align=\"right\"><img src=\"../images/tab-01.jpg\" width=\"8\" height=\"27\" /></td>\n");
      out.write("\t            <td width=\"99\" align=\"center\" class=\"tab-img-01\"> 已选择费用 </td>\t\t\t\t\t\t\n\t            <td width=\"81\" align=\"left\" valign=\"bottom\"><img src=\"../images/tab-03.jpg\" /></td>\n              </tr>\n            </table>\n\t\t\t</td>\n         </tr>\n\t  </table>\n  \t<form id=\"cemeteryChargeForm\" action=\"\" method=\"post\">\n  \t  \n      <input type='hidden' name='outStorehouseType' id='outStorehouseType' value=''/>\n      <table id=\"cemeteryChargeTable\" width=\"98%\" cellpadding=\"0\" cellspacing=\"1\" bgcolor=\"#a6c6da\">\n        <tr>\n          <td   height=\"30\" align=\"center\" bgcolor=\"#D4E5F4\">商品名称</td>\n          <td   align=\"center\" bgcolor=\"#D4E5F4\">商品类别</td>\n          <td   align=\"center\" bgcolor=\"#D4E5F4\">单价</td>\n          <td   align=\"center\" bgcolor=\"#D4E5F4\">数量</td>\n          <td   align=\"center\" bgcolor=\"#D4E5F4\">费用</td>\n          <td   width='5%' align=\"center\" bgcolor=\"#D4E5F4\">操作</td>  \t\t  \n        </tr>\n       </table>\n       <table>\n         <tr>\n           <td   height=\"30\" colspan=\"8\" align=\"center\" bgcolor=\"#FFFFFF\">\n");
      out.write("           <input name=\"button\" type=\"button\" class=\"button-z\" id=\"button\" onclick=\"saveOutStorehouse();\" value=\"完成\" /> &nbsp;&nbsp; \n           <input name=\"button2\" type=\"button\" class=\"button-z\" id=\"button2\" value=\"返回\"  onclick=\"javascirpt:doBack();\" /></td>\t \t \n        </tr>\n   \t  </table>\n   \t  </form>\n\t</td>\n  </tr>\n</table>\n</body>\n</html>");
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

  private boolean _jspx_meth_gOS_shjz_shjzUser_0(PageContext pageContext)
          throws Throwable {
    JspWriter out = pageContext.getOut();
    //  gOS_shjz:shjzUser
    com.topsuntech.gUnit.gEU_bzhhUtil.taglib.BzhhUserTag _jspx_th_gOS_shjz_shjzUser_0 = (com.topsuntech.gUnit.gEU_bzhhUtil.taglib.BzhhUserTag) _jspx_tagPool_gOS_shjz_shjzUser_key.get(com.topsuntech.gUnit.gEU_bzhhUtil.taglib.BzhhUserTag.class);
    _jspx_th_gOS_shjz_shjzUser_0.setPageContext(pageContext);
    _jspx_th_gOS_shjz_shjzUser_0.setParent(null);
    _jspx_th_gOS_shjz_shjzUser_0.setKey((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cemeteryCharge.createUserId}", java.lang.String.class, (PageContext)pageContext, null, false));
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
    _jspx_th_fmt_formatDate_0.setValue((java.util.Date) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cemeteryCharge.createDate}", java.util.Date.class, (PageContext)pageContext, null, false));
    _jspx_th_fmt_formatDate_0.setPattern("yyyy-MM-dd");
    int _jspx_eval_fmt_formatDate_0 = _jspx_th_fmt_formatDate_0.doStartTag();
    if (_jspx_th_fmt_formatDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_fmt_formatDate_value_pattern.reuse(_jspx_th_fmt_formatDate_0);
    return false;
  }

  private boolean _jspx_meth_c_out_0(PageContext pageContext)
          throws Throwable {
    JspWriter out = pageContext.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_0 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_0.setPageContext(pageContext);
    _jspx_th_c_out_0.setParent(null);
    _jspx_th_c_out_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.commodityName}", java.lang.Object.class, (PageContext)pageContext, null, false));
    int _jspx_eval_c_out_0 = _jspx_th_c_out_0.doStartTag();
    if (_jspx_th_c_out_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_c_out_value.reuse(_jspx_th_c_out_0);
    return false;
  }

  private boolean _jspx_meth_ft_select_0(PageContext pageContext)
          throws Throwable {
    JspWriter out = pageContext.getOut();
    //  ft:select
    com.topsuntech.gUnit_gmgl.core.tagext.SelectTag _jspx_th_ft_select_0 = (com.topsuntech.gUnit_gmgl.core.tagext.SelectTag) _jspx_tagPool_ft_select_type_style_selected_name.get(com.topsuntech.gUnit_gmgl.core.tagext.SelectTag.class);
    _jspx_th_ft_select_0.setPageContext(pageContext);
    _jspx_th_ft_select_0.setParent(null);
    _jspx_th_ft_select_0.setName("commodityType");
    _jspx_th_ft_select_0.setType("spfl");
    _jspx_th_ft_select_0.setSelected((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.commodityType}", java.lang.Object.class, (PageContext)pageContext, null, false));
    _jspx_th_ft_select_0.setStyle("width:190px");
    int _jspx_eval_ft_select_0 = _jspx_th_ft_select_0.doStartTag();
    if (_jspx_th_ft_select_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_ft_select_type_style_selected_name.reuse(_jspx_th_ft_select_0);
    return false;
  }
}
