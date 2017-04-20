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
	long creatorid = -1;
	if (user!=null) {
		creatorid = user.getId().longValue();
	}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<meta http-equiv="Cache-Control" content="no-store"/>
<meta http-equiv="Pragma" content="no-cache"/>
<meta http-equiv="Expires" content="0"/>

<link href="../../css/css.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="../../../lib/treelib/assets/skins/sam/treeview.css" />
<link rel="stylesheet" type="text/css" href="../../../lib/treelib/assets/folders/tree.css" />

<script type="text/javascript" src="../../../lib/treelib/yahoo-dom-event.js"></script>
<script type="text/javascript" src="../../../lib/treelib/treeview-min.js"></script>
<script type="text/javascript" src="../../../lib/treelib/jquery-1.2.6.min.js"></script>
<script type="text/javascript" src="../../../lib/treelib/edit-tree.js"></script>


<script>
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

function drawTree() {
	
	/*inputTree = new Topsuntech.TreeView();
	inputTree.divId = "treeDiv2";
	inputTree.rootNodeName = "机构";
	// inputTree.preloadUrl ='/ajjwork/testTree.jsp'
	// inputTree.preloadUrl = 'treeView.do?treeViewCreator=officeTreeViewCreator&doMethod=getPreloadNodes&type=4&userExtId=284'
	inputTree.preloadUrl = 'treeView.do?treeViewCreator=officeTreeViewCreator&doMethod=getPreloadNodes&type=1'
	inputTree.getChildUrl = "treeView.do?treeViewCreator=officeTreeViewCreator&doMethod=getChildNodes&type=1"
	inputTree.createNode = function(nodeData, parentNode){
		var inputNode = new Topsuntech.InputNode("l" + nodeData.id, parentNode, false);
  	inputNode.id = nodeData.id;
  	inputNode.name = nodeData.name;
  	inputNode.type = 'checkbox';
  	inputNode.formName = 'treeIds';
  	inputNode.value = nodeData.id;
  	//inputNode.inputPropertys = {id:nodeData.id, onclick:"alert(this.id + '|' + this.type)"};
  	return inputNode;
	};
	inputTree.drawTree();*/
	
	var officeTree = new Topsuntech.OneSNodeCheckboxTree('treeDiv1');
	officeTree.chboxName = 'treeIds';
	officeTree.treeView.rootNodeName = "机构";
	//officeTree.treeView.preloadPostData = {idStr: '<c:out value="${deptStr}"/>'}
	officeTree.treeView.preloadUrl = "treeView.do?treeViewCreator=officeTreeViewCreator&doMethod=getPreloadNodes&type=1"
	officeTree.treeView.getChildUrl = "treeView.do?treeViewCreator=officeTreeViewCreator&doMethod=getChildNodes&type=1";
	//officeTree.checkedIds = '<c:out value="${deptStr}"/>'.split(',');
	officeTree.draw();
}

$(document).ready(drawTree);
</script>

</head>

<body topmargin="16" marginheight="16">

<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="11" background="../../../images/images_32.jpg"><img src="../../../images/content_left.gif" width="11" height="51"></td>
    <td height="51" background="../../../images/images_32.jpg"><table width="70%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="22" height="16" align="center"><img src="../../../images/d.gif" width="14" height="14"></td>
          <td valign="bottom"> 当前位置：子管理员管理</td>
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
<form action="UserextCreate.do?action=step3"  name="myform" method="post">
	<input name="choosed" type="hidden" value="">
	<input name="creatorid" type="hidden" value="<%=creatorid%>">
  <table width="90%" border="0" align="right" cellpadding="0" cellspacing="0" class="table10">
    <tr>
    <td valign="top" class="td18">
      
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table7">
		       <tr>
				 	  <td width="600" align="left">
							第二步：请选择机构
					  </td>
					  <td align="center" width="200">
					  【<a href="javascript:history.back()">上一步</a>】
					  【<a href="javascript:onSubmit()">下一步</a>】
					  【<a href="UserextCreate.do?action=cancel">取消</a>】
					  </td>
		       </tr>
		</table>
		<table>
			<tr><td><div id="treeDiv1" style="font-size:13px"></div></td></tr>
		
		</table>

    </td>
  </tr>
 </table> 
 </form>
</body>
</html>
