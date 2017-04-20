<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/gTaglib-gOS.tld" prefix="gOS" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib uri="http://www.topsuntech.com/jsptags/tree-taglib" prefix="topsuntech" %>
<%@page import="com.topsuntech.gOS.user.session.*" %>
<%@page import="com.topsuntech.gOS.user.en.user.*" %>

<%
	User user = UserSession.getUser(request);
	long deptid = 2;
	if (user!=null) {
		deptid = user.getDeptid();
	}
%>
<html>
<head>
<link href="../../css/css.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="../../../lib/treelib/assets/skins/sam/treeview.css" />
<link rel="stylesheet" type="text/css" href="../../../lib/treelib/assets/folders/tree.css" />

<script type="text/javascript" src="../../../lib/treelib/yahoo-dom-event.js"></script>
<script type="text/javascript" src="../../../lib/treelib/treeview-min.js"></script>
<script type="text/javascript" src="../../../lib/treelib/jquery-1.2.6.min.js"></script>
<script type="text/javascript" src="../../../lib/treelib/edit-tree.js"></script>

<!-- Code for browser detection -->
<script src="../../../script/ua3.js"></script>

<!-- Infrastructure code for the tree -->
<script src="../../../script/ftiens4.js"></script>
<%
	String depts = (String)request.getAttribute("depts");
	System.out.println("----------depts in jsp: " + depts);
%>
<script>
// Decide if the names are links or just the icons
USETEXTLINKS = 1  //replace 0 with 1 for hyperlinks

// Decide if the tree is to start all open or just showing the root folders
STARTALLOPEN = 1 //replace 0 with 1 to show the whole tree

HIGHLIGHT = 1
USEFRAMES = 0
USEICONS = 0





function onSubmit() {
	var checkboxs = document.getElementsByName("treeIds");		
	var checkedValueStr = ",";
	for(i = 0; i < checkboxs.length; i++){
		if(checkboxs[i].checked == true){			
			var checkedvalue = checkboxs[i].value;
			checkedValueStr += checkedvalue + ",";
		}
	}
	if(checkedValueStr != ','){
		document.myform.choosed.value = checkedValueStr;	
		myform.submit();
		//alert(checkedValueStr)
		return ;
	}
	
	window.alert("必须首先选择单位！");
}

</script>

</head>

<body topmargin="16" marginheight="16">

<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="11" background="../../../images/images_32.jpg"><img src="../../../images/content_left.gif" width="11" height="51"></td>
    <td height="51" background="../../../images/images_32.jpg"><table width="70%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="22" height="16" align="center"><img src="../../../images/d.gif" width="14" height="14"></td>
          <td valign="bottom"> 当前位置：设置下级机构管理员</td>
      </tr>
    </table>
    </td>
  </tr>
  <tr>
    <td background="../../../images/images_481.jpg">&nbsp;</td>
    <td valign="top">
		<table border="0" >
			<tr>
			<td valign="top">
<form action="UserextDeptCreate.do?action=step3"  name="myform" method="post">
	<input name="choosed" type="hidden" value="">

  <table width="90%" border="0" align="right" cellpadding="0" cellspacing="0" class="table10">
    <tr>
    <td valign="top" class="td18">
      
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table7">
        <tr>
			 	  <td width="600" align="left">
						第二步：请选择部门
				  </td>
				  <td align="center"  width="200">
				  【<a href="javascript:history.back()">上一步</a>】
				  【<a href="javascript:onSubmit()">下一步</a>】
				  【<a href="UserextCreate.do?action=cancel">取消</a>】
				  </td>
        </tr>
      </table>
            <table>
		<tr><td><div id="treeDiv1" style="font-size:13px"></div></td></tr>
		<tr><td><div id="treeDiv2" style="font-size:13px"></div></td></tr>
</table>
      	<script type="text/javascript">


function drawTree() {
	
	var inputTree = new Topsuntech.TreeView();
	inputTree.divId = "treeDiv2";
	inputTree.rootNodeName = "机构";
	inputTree.preloadUrl = "treeView.do?type=3&treeViewCreator=officeTreeViewCreator&doMethod=getPreloadNodes"
	inputTree.getChildUrl = "treeView.do?type=3&treeViewCreator=officeTreeViewCreator&doMethod=getChildNodes"
	inputTree.createNode = function(nodeData, parentNode){
		var inputNode = new Topsuntech.InputNode("l" + nodeData.id, parentNode, false);
  	inputNode.id = nodeData.id;
  	inputNode.name = nodeData.name;
  	inputNode.type = 'checkbox';
  	inputNode.formName = 'treeIds';
  	inputNode.value = nodeData.id;
  	return inputNode;
	};
	inputTree.drawTree();
}

$(document).ready(drawTree);

</script>
	
      <br> 
</form>
    </td>
  </tr>
 </table> 
</body>
</html>
