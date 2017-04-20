<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib uri="http://www.topsuntech.com/jsptags/tree-taglib" prefix="topsuntech" %>
<%@ taglib uri="/WEB-INF/tld/gTaglib-gOS.tld" prefix="gOS" %>
<%@page import="com.topsuntech.gOS.user.session.*" %>
<%@page import="com.topsuntech.gOS.user.en.user.*" %>
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
<!-- Code for browser detection -->
<script src="../../../script/ua.js"></script>

<!-- Infrastructure code for the tree -->
<script src="../../../script/ftiens4.js"></script>
<script src="../../../script/functionforcheck.js" language="JScript"></script>
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

function onSubmit() {
	var IsValid=true;
	if(myform.name.value==""){
	document.all("namelbl").innerHTML="<font color=\"ff0000\">请填写角色名称</font>";
	IsValid=false;
	}else{
	document.all("namelbl").innerHTML="";
	}
	
	if(!checkLength(myform.description.value, 0, 150)){
		document.all("deslbl").innerHTML="<font color=\"ff0000\">角色描述过长（小于150字符）</font>";
		IsValid=false;
	} else {
		document.all("deslbl").innerHTML="";
	}	
	
	document.myform.prioritys.value=generateQueryString(); 
	if(IsValid)
	myform.submit();
}
function doCancel(){
	myform.action="actorSelect.do?action=list";
	myform.submit();
}
</script>
</head>

<body leftmargin="0" topmargin="0"  onload="javascript:expandTree(foldersTree)">
<form action="actorClone.do?action=clone" name="myform" method="post">

	<input name="prioritys" type="hidden" value="">
	<input type="hidden" name="creatorId" value="<c:out value="${loginUser.id}" />">
	<input name="creatorname" type="hidden" value="<c:out value="${loginUser.name}" />">
<table width="100%" border="0" align="right" cellpadding="0" cellspacing="0" class="table1">
  <tr>
       <td height="459" align="right" valign="top" class="td18">
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list_title">
        <tr>
          <td width="0%" height="20">&nbsp; </td>
          <td width="54%" height="20" align="left"><table  border="0" cellpadding="0" cellspacing="0">
            <tr>
              <td width="60" align="right"><input name="button2" type="button" class="input_btn" onClick="onSubmit();" value="确定">
                  </input>
              </td>
              <td width="60" align="right"><input name="button2" type="button" class="input_btn" onClick="doCancel();" value="取消">
                  </input>
              </td>
            </tr>
          </table></td>
          <td width="46%" align="right">
            <strong>克隆角色：(*为必填项)<font color="ff0000">
            <html:errors/>
            </font></strong></td>
        </tr>
      </table>
      <table width="100%" border="0" >
        <tr align="right">
          <td height="14"  class="td8">创建人：<c:out value="${loginUser.name}" /> 创建日期：<fmt:formatDate value="${actor.createdate}" pattern="yyyy-MM-dd" /></td>
        </tr>
      </table>
      <table width="100%" border="0" cellpadding="1" cellspacing="1">
        <tr>
          <td width="15%" height="22" class="td22" align="right">名称*：</td>
          <td width="86%" height="22" class="td23"> <input name="name" type="text" value="<c:out value="${actor.name}"/>"  maxlength="15">
           <label id="namelbl" name="namelbl"></label>
          </td>
        </tr>
        <tr>
          <td class="td22" align="right">描述：</td>
          <td valign="top" class="td23"> <textarea name="description" cols="60" rows="8" wrap="hard"><c:out value="${actor.description}" /></textarea>
          <label id="deslbl" name="deslbl"></label>
          </td>
        </tr>
        <tr>
          <td height="127" valign="top" class="td22" align="right">权限列表：</td>
          <td valign="top" class="td23">
            <TABLE border=0  borderlight="green">
              <TBODY>
                <TR>
                  <TD align=middle><FONT face="Arial, Helvetica, sans-serif" color=#000000
      size=2>请选择：权限</FONT></TD>
                </TR>
                <TR>
                  <TD align=center>
    <form>
                      <input name="button" type=button class=input_btn onClick="javascript:expandTree(foldersTree)" value="展开">
                      <input name="button" type=button class=input_btn onClick="javascript:collapseTree(1)" value="收缩">
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
</body>
</html>
