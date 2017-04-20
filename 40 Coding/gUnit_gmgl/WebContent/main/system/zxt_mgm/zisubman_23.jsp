<%@ page contentType="text/html; charset=GBK" %>
<%@ include file="../../../common/taglibs.jsp"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="http://www.topsuntech.com/jsptags/newtree-taglib" prefix="newtree" %>
<link href="../../../css/css.css" rel="stylesheet" type="text/css">
<html>
<head>


<!-- Code for browser detection -->
<script src="../../../script/ua_office.js"></script>

<!-- Infrastructure code for the tree -->
<script src="../../../script/ftiens4.js"></script>
<%
	String priority = (String)request.getAttribute("priority");
	System.out.println("----------priority in jsp: " + priority);
%>
<script>
// Decide if the names are links or just the icons
USETEXTLINKS = 1  //replace 0 with 1 for hyperlinks

// Decide if the tree is to start all open or just showing the root folders
STARTALLOPEN = 1 //replace 0 with 1 to show the whole tree

HIGHLIGHT = 1
USEFRAMES = 0
USEICONS = 0

<newtree:priorityTree type="checkbox" all="${priority}"/>



function onSubmit() {    
	var queryStr = generateQueryString();	
	if (queryStr==",") {
		window.alert("必须首先选择权限！");
	} else {
		document.myform.choosed.value=queryStr;
		myform.submit();
	}
}
</script>

</head>

<body topmargin="16" marginheight="16">


<form action="../zxt_mgm/UserextNewCreate.do?action=step23" name="myform" method="post">
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="11" height="31" valign="top" class="td-bg"><img src="../../../images/right-1.jpg" /></td>
    <td align="center" valign="top" ><table width="100%" border="0" cellpadding="0" cellspacing="0" class="word-8">
      <tr>
        <td height="31" align="left" valign="middle" style="background:url(../../../images/right-3.jpg)"><img src="../../../images/right-4.jpg" width="9" height="8" align="absmiddle" /> 当前位置 &gt; 子系统管理 &gt; 子管理员管理</td>
      </tr>
    </table>
	</td>
  </tr>
  <tr>
    <td >&nbsp;</td>
    <td valign="top">
	<table border="0" cellspacing="0" cellpadding="0" width="100%">
		<tr>
			<td>&nbsp;</td>
		</tr>		
	</table>
	<input name="choosed" type="hidden" value="">

  <table width="90%" border="0" align="right" cellpadding="0" cellspacing="0" class="table10">
    <tr>
    <td valign="top" class="td18">
      
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table7">
        <tr>
			 	  <td width="600" align="left">
						第三步：请选择权限
				  </td>
				  <td align="center">
				  【<a href="javascript:history.back()">上一步</a>】
				  【<a href="javascript:onSubmit()">下一步</a>】
				  【<a href="UserextNewCreate.do?action=cancel">取消</a>】
				  </td>
        </tr>
      </table>
            
      	
      <br> 
      
      <TABLE border=5 width="300" align="center" borderColor=#11B1EE borderlight="green">
        <TBODY>
          <TR>
            <TD align="center">
            	<FONT size=2 face="Arial, Helvetica, sans-serif">权限列表</FONT>
            </td>
           </tr>
           </tr>
           <td align="center">
	      	&nbsp;【<a href="#" onClick="location.reload();">刷新</a>】
	       	&nbsp;【<a href="#" onClick="expandTree(foldersTree);">展开</a>】
	       	&nbsp;【<a href="#" onClick="collapseTree(1);">收缩</a>】</TD>

          </TR>
          <TR>
            <TD height="95" align=center valign="top">
              <!-- By making any changes to this code you are violating your user agreement.
     Corporate users or any others that want to remove the link should check
	 the online FAQ for instructions on how to obtain a version without the link -->
              <!-- Removing this link will make the script stop from working -->

              <div style="position:opposite; top:0; left:0; ">
                <table border=0>
                  <tr>
                    <td><font size=-2> <a style="font-size:7pt;text-decoration:none;color:silver" href="http://www.treemenu.net/" target=_blank></a></font>
                    </td>
                  </tr>
                </table>
              </div>
              <!-- Build the browser's objects and display default view of the
     tree. -->
              <script>initializeDocument()</script> <noscript>
              A tree for site navigation will open here if you enable JavaScript
              in your browser. </noscript> </TD>
          </TR>
        </TBODY>
      </TABLE>
    </td>
  </tr>
</table>
    </td>
  </tr>
</table>
</form>
</body>
</html>
