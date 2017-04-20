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

</script>
<link href="../../../css/css.css" rel="stylesheet" type="text/css">
</head>

<body bgcolor="#FFFFFF" text="#000000" leftmargin="0" topmargin="0" onLoad="javascript:expandTree(foldersTree)">
	<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="11" background="../../../images/images_32.jpg"><img src="../../../images/content_left.gif" width="11" height="51"></td>
    <td height="51" background="../../../images/images_32.jpg"><table width="70%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="22" height="16" align="center"><img src="../../../images/d.gif" width="14" height="14"></td>
        <td valign="bottom"> 当前位置：角色管理 → <b>角色查看</b></td>
      </tr></td>		
    </table>
    </td>
  </tr>
  <tr>
    <td background="../images/images_481.jpg">&nbsp;</td>
    <td valign="top">
<table width="100%" border="0" align="left" cellpadding="0" cellspacing="0" class="table10">
  <tr>
       <td height="459" align="right" valign="top" class="td18">
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list_title">
        <tr>          
          <td width="54%" height="20" align="left"><table width="300" border="0" cellpadding="0" cellspacing="0" class="list_title">
            <tr class="td16" align="left">
              <td width="60" class="td16"><input name="Submit" type="submit" class="input_btn" value="返回" onClick="javascript:history.back();"></td>

              <td width="120" class="td16"><strong>角色详细信息：</strong></td>
             
            </tr>
          </table></td>        
        </tr>
      </table>
      <table width="100%" border="0" class="table5">
        <tr>
          <td height="14"  class="td8">创建人：<c:out value="${actor.creatorname}" /> 创建日期：<fmt:formatDate value="${actor.createdate}" pattern="yyyy-MM-dd" /></td>
        </tr>
      </table>
      <table width="100%" border="0" cellpadding="1" cellspacing="1" class="table1">
        <tr> 
          <td width="15%" height="22" class="td22">编号：</td>
          <td width="86%" height="22" class="td23"><c:out value="${actor.id}" /></td>
        </tr>
        <tr> 
          <td height="22" class="td22">名称：</td>
          <td width="86%" height="22" class="td23"><c:out value="${actor.name}" /></td>
        </tr>
        <tr> 
          <td height="33" class="td22">描述：</td>
          <td class="td23"><span><c:out value="${actor.description}" /></span></td>
        </tr>
        <tr> 
          <td height="33" valign="top" class="td22">权限列表：</td>
          <td class="td23">
<TABLE border=0 >
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

</td>
  </tr>
</table>
</body>
</html>
