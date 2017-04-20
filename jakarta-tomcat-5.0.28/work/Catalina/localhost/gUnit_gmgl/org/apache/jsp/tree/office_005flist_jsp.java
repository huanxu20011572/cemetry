package org.apache.jsp.tree;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class office_005flist_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(5);
    _jspx_dependants.add("/tree/../common/taglibs.jsp");
    _jspx_dependants.add("/WEB-INF/tld/struts-bean.tld");
    _jspx_dependants.add("/WEB-INF/tld/struts-html.tld");
    _jspx_dependants.add("/WEB-INF/tld/gTaglib-shjz.tld");
    _jspx_dependants.add("/WEB-INF/tld/gTaglib-gOS.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_out_value;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_url_value;

  public java.util.List getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_out_value = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_url_value = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_out_value.release();
    _jspx_tagPool_c_url_value.release();
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
      out.write("\n<html>\n<head>\n<title>机构管理</title>\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=GBK\">\n<meta http-equiv=\"Cache-Control\" content=\"no-store\"/>\n<meta http-equiv=\"Pragma\" content=\"no-cache\"/>\n<meta http-equiv=\"Expires\" content=\"0\"/>\n\n<link href=\"../css/style.css\" rel=\"stylesheet\" type=\"text/css\">\n<link href=\"../css/css.css\" rel=\"stylesheet\" type=\"text/css\">\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../lib/treelib/assets/skins/sam/treeview.css\" />\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../lib/treelib/assets/folders/tree.css\" />\n\n<script type=\"text/javascript\" src=\"../js/jquery-1.2.6.js\"></script>\n<script type=\"text/javascript\" src=\"../lib/treelib/yahoo-dom-event.js\"></script>\n<script type=\"text/javascript\" src=\"../lib/treelib/treeview-min.js\"></script>\n<script type=\"text/javascript\" src=\"../lib/treelib/edit-tree.js\"></script>\n\n<script>\n\nfunction submitForm(formId, action){\n\tvar pForm = document.getElementById(formId);\n\tvar oAction = pForm.action;\n\tvar oTarget = pForm.target;\n\tpForm.action = action;\n");
      out.write("\tpForm.submit();\n\tpForm.action = oAction;\n}\nfunction populateForm(link){\n\tvar deptId = link.id.split('_')[0];\n\t$('#deptId').val(deptId);\n\t$('#regionId').val(officeTree.getNodeById(deptId).regionId);\n}\nfunction addDept(link){\n\tpopulateForm(link);\n\tsubmitForm(\"opForm\", \"toAddDept.do?method=toAdd&inputPath=allDept\");\n}\nfunction updateDept(link){\n\tpopulateForm(link);\n\tsubmitForm(\"opForm\", \"toUpdateDept.do?method=toUpdate&inputPath=allDept\");\n}\nfunction deleteDept(link){\n\tvar deptName = officeTree.getNodeById(link.id.split('_')[0]).name;\n\tif(confirm(\"你确定要删除 \" + deptName + \" 吗？\")){\n\t\tpopulateForm(link);\n\t\tsubmitForm(\"opForm\", \"doDeleteDept.do?method=delete&inputPath=allDept&useFlag=0\");\n\t}\t\t\t\t\t\t\t\t\n}\nfunction orderDept(link){\n\tpopulateForm(link);\n\tsubmitForm(\"opForm\", \"deptOrder.do?method=deptList\");\n}\n\nvar officeTree;\nfunction initOfficeTree(){\n\tofficeTree = new Topsuntech.TreeView(\"officeDiv\");\n\tofficeTree.rootNodeName = \"机构管理\";\n\t\n\tvar idStr = '");
      if (_jspx_meth_c_out_0(pageContext))
        return;
      out.write("';\n\tofficeTree.preloadPostData = {type: 1, idStr: idStr};\n\tofficeTree.preloadUrl = '");
      if (_jspx_meth_c_url_0(pageContext))
        return;
      out.write("';\n\tofficeTree.getChildUrl = '");
      if (_jspx_meth_c_url_1(pageContext))
        return;
      out.write("';\n\tofficeTree.createNode = function(nodeData, parentNode){\n\t\tvar linksNode = new Topsuntech.LinksNode(\"l\" + nodeData.id, parentNode, false);\n\t  \tlinksNode.name = nodeData.name;\n\t  \tlinksNode.regionId = nodeData.regionId;\n\t  \t//linksNode.spaceStyle = 'margin-left: 20px';\n\t  \t\n\t  \tlinksNode.links = [\t{id: nodeData.id + '_a', href: 'javascript:', onclick: 'addDept(this);return false;', target: '_self', name: '添加下级', style: 'color: blue'} ];\n\t  \tif(!nodeData.region){\n\t\t\tlinksNode.links[linksNode.links.length] = {id: nodeData.id + '_u', href: 'javascript:', onclick: 'updateDept(this);return false;', target: '_self', name: '修改', style: 'color: blue'};\n\t  \t\tlinksNode.links[linksNode.links.length] = {id: nodeData.id + '_d', href: 'javascript:', onclick: \"deleteDept(this);return false;\", target: '_self', name: '删除', style: 'color: blue'};\t \n\t  \t}\n\t  \tlinksNode.links[linksNode.links.length] = {id: nodeData.id + '_o', href: 'javascript:', onclick: \"orderDept(this);return false;\", target: '_self', name: '排序', style: 'color: blue'};\t  \t\t \t\t\n");
      out.write("\t  \treturn linksNode;\n\t};\n\tofficeTree.preLoadNodeDataCallback = function(){\n\t\tvar idArr = idStr.split(',');\n\t\tvar lastId = idArr[idArr.length - 1];\n\t\t$(\"#\" + lastId + \"_a\").focus();\n\t}\n\tofficeTree.drawTree();\n}\n\nfunction doOnLoad(){\n\tinitOfficeTree();\n\t\n}\n</script>\n</head>\n\n<body onLoad=\"doOnLoad()\">\n<table width=\"100%\" height=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n<form method=\"post\" id=\"opForm\" >\n\t<input id=\"deptId\" name=\"deptId\" type=\"hidden\"/>\n\t<input id=\"regionId\" name=\"regionId\" type=\"hidden\"/>\n</form>\n  <tr>\n    <td width=\"11\" height=\"31\" valign=\"top\" class=\"td-bg\"><img src=\"../images/right-1.jpg\" /></td>\n    <td align=\"center\" valign=\"top\" ><table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"word-8\">\n      <tr>\n        <td height=\"31\" align=\"left\" valign=\"middle\" style=\"background:url(../images/right-3.jpg)\"><img src=\"../images/right-4.jpg\" width=\"9\" height=\"8\" align=\"absmiddle\" /> 当前位置 &gt; 系统管理 &gt; 机构管理</td>\n      </tr>\n    </table>\n\t</td>\n  </tr>\n  <tr>\n    <td >&nbsp;</td>\n");
      out.write("    <td valign=\"top\">\n\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\">\n\t\t<tr>\n\t\t\t<td>&nbsp;</td>\n\t\t</tr>\t\t\n\t</table>\n\t\t\t<table width=\"95%\" height=\"100%\" border=\"0\">\n\t\t\t\t<tr>\n\t\t\t\t\t<td valign=\"top\">\n\t\t\t\t\t\t<!-- div style=\"overflow: auto; height: 97%; width: 100%\" >\n\t\t\t\t\t\t</div-->\n\t\t\t\t\t\t\t<table>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td><div id=\"officeDiv\" style=\"font-size:10px;\"></div></td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t</table>\n\t\t\t\t\t </td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t</td>\n\t</tr>\n</table>\n    \n</body>\n</html>");
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
    _jspx_th_c_out_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.idStr}", java.lang.Object.class, (PageContext)pageContext, null, false));
    int _jspx_eval_c_out_0 = _jspx_th_c_out_0.doStartTag();
    if (_jspx_th_c_out_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_c_out_value.reuse(_jspx_th_c_out_0);
    return false;
  }

  private boolean _jspx_meth_c_url_0(PageContext pageContext)
          throws Throwable {
    JspWriter out = pageContext.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_0 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_0.setPageContext(pageContext);
    _jspx_th_c_url_0.setParent(null);
    _jspx_th_c_url_0.setValue("/main/system/zxt_mgm/treeView.do?treeViewCreator=officeTreeViewCreator&doMethod=getPreloadNodes&userRegion=true");
    int _jspx_eval_c_url_0 = _jspx_th_c_url_0.doStartTag();
    if (_jspx_th_c_url_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_c_url_value.reuse(_jspx_th_c_url_0);
    return false;
  }

  private boolean _jspx_meth_c_url_1(PageContext pageContext)
          throws Throwable {
    JspWriter out = pageContext.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_1 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_1.setPageContext(pageContext);
    _jspx_th_c_url_1.setParent(null);
    _jspx_th_c_url_1.setValue("/main/system/zxt_mgm/treeView.do?treeViewCreator=officeTreeViewCreator&doMethod=getChildNodes&userRegion=true");
    int _jspx_eval_c_url_1 = _jspx_th_c_url_1.doStartTag();
    if (_jspx_th_c_url_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_c_url_value.reuse(_jspx_th_c_url_1);
    return false;
  }
}
