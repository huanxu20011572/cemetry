<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib uri="http://www.topsuntech.com/jsptags/tree-taglib" prefix="topsuntech" %>
<%@ taglib uri="/WEB-INF/tld/gTaglib-gOS.tld" prefix="gOS" %>
<html>
<head>
<title>Untitled Document</title>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<link href="../../../css/css.css" rel="stylesheet" type="text/css">
<style type="text/css">
     A {
         font-family:Verdana, Arial,Helvetica;
         font-size:11px;
         font-weight:normal;
         color:blue;
         text-decoration:none;
     }

     A:hover {
         font-family:Verdana, Arial,Helvetica;
         font-size:11px;
         font-weight:normal;
         color:blue;
         text-decoration:underline;
     }
</style>
<script language="JavaScript">
<!--



function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}
//-->
</script>
<!-- Code for browser detection -->
<script src="../../../script/ua.js"></script>

<!-- Infrastructure code for the tree -->
<script src="../../../script/ftiens4.js"></script>

<script>
// Decide if the names are links or just the icons
USETEXTLINKS = 1  //replace 0 with 1 for hyperlinks

// Decide if the tree is to start all open or just showing the root folders
STARTALLOPEN = 0 //replace 0 with 1 to show the whole tree

HIGHLIGHT = 1
USEFRAMES = 0

<topsuntech:customePriorityTree>
	<c:out value="${actor.priority}" />
</topsuntech:customePriorityTree>

function doDelete(){
 myform.submit();
}
function doCancel(){
	myform.action="../../../tree/roleList.do?method=getRolelist";
	myform.submit();
}
</script>
</head>

<body leftmargin="0" topmargin="0" onLoad="javascript:expandTree(foldersTree)">
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="11" background="../../../images/images_32.jpg"><img src="../../../images/content_left.gif" width="11" height="51"></td>
    <td height="51" background="../../../images/images_32.jpg"><table width="70%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="22" height="16" align="center"><img src="../../../images/d.gif" width="14" height="14"></td>
          <td valign="bottom"> 当前位置：角色维护→ <b>修改角色</b></td>
      </tr>
    </table>
    </td>
  </tr>
  <tr>
    <td background="../../../images/images_481.jpg">&nbsp;</td>
    <td valign="top">
<form name="myform" action="actorDelete.do?action=delete&id=<c:out value="${actor.id}"/>" method="post">
<table width="100%" border="0" align="right" cellpadding="0" cellspacing="0" class="table1">
  <tr>
       <td height="459" align="right" valign="top" class="td18">
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list_title" >
        <tr>
          
          <td width="54%" height="20" align="left"><table border="0" cellpadding="0" cellspacing="0">
            <tr class="td16">
              <td  class="td16" align="right"colspan="2"><strong>确定要删除如下角色？</strong>
                 
              </td>
            </tr>
            <tr class="td16">
              <td  class="td16" align="center"><input name="button3" type="button" class="input_btn" onClick="doDelete();" value="确定">
                  </input>
              </td>
              <td  class="td16" align="center"><input name="button3" type="button" class="input_btn" onClick="doCancel();" value="取消">
                  </input>
              </td>
            </tr>
          </table></td>
         
        </tr>
      </table>
      <table width="100%" border="0" class="table5">
        <tr align="center">
          <td height="14"  class="td8">创建人：<c:out value="${actor.creatorname}" /> 创建日期：<fmt:formatDate value="${actor.createdate}" pattern="yyyy-MM-dd" /></td>
        </tr>
      </table>
      <table width="100%" border="0" cellpadding="1" cellspacing="0" class="table1">
        <tr> 
          <td width="50%" height="22" align="right">编号：</td>
          <td width="50" height="22" align="left"><c:out value="${actor.id}" /></td>
        </tr>
        <tr> 
          <td width="50%" height="22" align="right">名称：</td>
          <td width="50%" height="22" align="left"><c:out value="${actor.name}" /></td>
        </tr>
       <tr> 
          <td width="50%" height="33" align="right">描述：</td>
          <td width="50%" align="left"><c:out value="${actor.description}" /></td>
        </tr>
        <tr> 
          <td height="33" colspan="2" valign="top" class="td22" align="center" ><strong>权限列表</strong></td>
        </tr>
        <tr>
          <td class="td23" colspan="2" align="center">
<TABLE  border=0 class="table1" borderlight="green">
              <TBODY>
                <TR>
                  <TD align=middle><FONT face="Arial, Helvetica, sans-serif" color=#000000
      size=2>请选择：权限</FONT></TD>
                </TR>
                <TR>
                  <TD align=center> <form>
                      <input name="button" type=button class=input_btn onClick="javascript:expandTree(foldersTree)" value="展开">
                      <input name="button2" type=button class=input_btn onClick="javascript:collapseTree(1)" value="收缩">
                    </form>
                    <div style="position:absolute; top:0; left:0; ">
                      <table border=0>
                        <tr>
                          <td><font size=-2> <a style="font-size:7pt;text-decoration:none;color:silver" href="http://www.treemenu.net/" target=_blank></a></font>
                          </td>
                        </tr>
                      </table>
                    </div>
                    <script>initializeDocument()</script> <noscript>
                    A tree for site navigation will open here if you enable JavaScript
                    in your browser. </noscript> </TD>
                </TR>
              </TBODY>
            </TABLE></td>
        </tr>
      </table>
      </td>
  </tr>
</table>
</form>
 </td>
  </tr>
</table>
</body>
</html>
