<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ include file="../../../common/taglibs.jsp"%>
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
	window.alert("��������ѡ��λ��");
}
function drawTree() {
	var officeTree = new Topsuntech.OneSNodeCheckboxTree('treeDiv1');
	officeTree.chboxName = 'treeIds';
	officeTree.treeView.rootNodeName = "����";
	officeTree.treeView.preloadUrl = "treeView.do?type=2&treeViewCreator=officeTreeViewCreator&doMethod=getPreloadNodes"
	officeTree.treeView.getChildUrl = "treeView.do?type=2&treeViewCreator=officeTreeViewCreator&doMethod=getChildNodes"
	officeTree.draw();
}

$(document).ready(drawTree);
</script>

</head>

<body topmargin="16" marginheight="16">
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="11" height="31" valign="top" class="td-bg"><img src="../../../images/right-1.jpg" /></td>
    <td align="center" valign="top" ><table width="100%" border="0" cellpadding="0" cellspacing="0" class="word-8">
      <tr>
        <td height="31" align="left" valign="middle" style="background:url(../../../images/right-3.jpg)"><img src="../../../images/right-4.jpg" width="9" height="8" align="absmiddle" /> ��ǰλ�� &gt; ��ϵͳ���� &gt; �ӹ���Ա����</td>
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

		<table border="0" >
			<tr>
			<td valign="top">
<form action="UserextNewCreate.do?action=step3"  name="myform" method="post">
	<input name="choosed" type="hidden" value="">
	<input name="creatorid" type="hidden" value="<%=creatorid%>">
  <table width="90%" border="0" align="right" cellpadding="0" cellspacing="0" class="table10">
    <tr>
    <td valign="top" class="td18">
      
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table7">
			<tr>
				 <td width="600" align="left">
					�ڶ�������ѡ�����
				</td>
				<td align="center"  width="200">
					��<a href="javascript:history.back()">��һ��</a>��
					��<a href="javascript:onSubmit()">��һ��</a>��
					��<a href="UserextNewCreate.do?action=cancel">ȡ��</a>��
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
