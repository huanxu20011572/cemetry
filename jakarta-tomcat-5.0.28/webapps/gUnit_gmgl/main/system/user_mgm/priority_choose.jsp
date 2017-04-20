<%@ page contentType="text/html; charset=GBK" %>
<%@ include file="../../../common/taglibs.jsp"%>
<%@page import="com.topsuntech.gOS.priority.PriorityToHTML" %>
<%
request.setAttribute("prioTree", PriorityToHTML.generateByPriority(""));
%>
<html>
<head>
<title>选择权限</title>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<meta http-equiv="Cache-Control" content="no-store"/>
<meta http-equiv="Pragma" content="no-cache"/>
<meta http-equiv="Expires" content="0"/>

<script src="../../../script/ua.js"></script>
<script src="../../../script/ftiens4.js"></script>
<script src="../../../js/jquery-1.2.6.js"></script>
<link href="../../../css/css.css" rel="stylesheet" type="text/css">
<style type="text/css">
     A {
         font-family:Verdana, Arial,Helvetica;
         font-size:11px;
         font-weight:normal;
         text-decoration:none;
         color: black;
     }
</style>

<script>
// Decide if the names are links or just the icons
USETEXTLINKS = 1  //replace 0 with 1 for hyperlinks

// Decide if the tree is to start all open or just showing the root folders
STARTALLOPEN = 0 //replace 0 with 1 to show the whole tree

HIGHLIGHT = 1
USEFRAMES = 0
USEICONS = 0

var priorityArr = [];
function generateCheckBox(parentfolderObject, itemLabel, checkBoxDOMId) {
	var newObj = insDoc(parentfolderObject, gLnk("S", itemLabel, 'javascript:setPriority(' + priorityArr.length + ')'));
	priorityArr[priorityArr.length] = {id: checkBoxDOMId, name: itemLabel}
	//newObj.prependHTML = "<td valign=middle><input type=checkbox id="+checkBoxDOMId+"></td>"
	return newObj;
}

<c:out value="${prioTree}" escapeXml="false"/>

function setPriority(index){
	opener.setPriority(priorityArr[index].id, priorityArr[index].name);
	window.close();
}
function doOnLoad(){   
	expandTree(foldersTree);
	generateExpandTreeSelectObj(foldersTree, 'expandTreeSelect');
}

</script>
</head>

<body onload="doOnLoad()">
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="11" background="../../../images/images_32.jpg"><img src="../../../images/content_left.gif" width="11" height="51"></td>
    <td height="51" background="../../../images/images_32.jpg"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="22" height="16" align="center"><img src="../../../images/d.gif" width="14" height="14"></td>
        <td valign="bottom"> <span class="text-red12">当前位置：用户管理 → <b>选择权限</b></span></td>
     
      </tr>
    </table>
    </td>
  </tr>
  <tr>
    <td background="../../../images/images_481.jpg">&nbsp;</td>
    <td valign="top" width="100%"> 
		 <table border="0" width="80%" height="100%" style="margin-left: 35px">	        
	          <tr>
	            <td>
		            <font size=2 face="Arial, Helvetica, sans-serif">选择权限列表</font>
	            </td>
	          </tr>
	          <tr>
	            <td>
		            <select id="expandTreeSelect" style="vertical-align: middle;" >
		            </select>
	            </td>
	          </tr>
	           <tr>
	           	<td height="100%" valign="top">
	           		
					<a href="http://www.treemenu.net/"></a>
		            <script>initializeDocument()</script>		
		            
				</td>
	          </tr>
	      </table>
	</td>
 </TR>
</table>
</body>
</html>

