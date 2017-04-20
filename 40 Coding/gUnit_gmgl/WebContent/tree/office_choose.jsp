<%@ page contentType="text/html; charset=GBK" %>
<%@ include file="../common/taglibs.jsp"%>
<html>
<head>
<title>选择机构</title>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<meta http-equiv="Cache-Control" content="no-store"/>
<meta http-equiv="Pragma" content="no-cache"/>
<meta http-equiv="Expires" content="0"/>

<link href="../css/css.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="../lib/treelib/assets/skins/sam/treeview.css" />
<link rel="stylesheet" type="text/css" href="../lib/treelib/assets/folders/tree.css" />

<script type="text/javascript" src="../js/jquery-1.2.6.js"></script>
<script type="text/javascript" src="../lib/treelib/yahoo-dom-event.js"></script>
<script type="text/javascript" src="../lib/treelib/treeview-min.js"></script>
<script type="text/javascript" src="../lib/treelib/edit-tree.js"></script>

<script>
function setOffice(link){
	<c:if test="${empty param.callback}">
		opener.setOffice(window, link.id, officeTree.getNodeById(link.id).name);
	</c:if>
	<c:if test="${not empty param.callback}">
		opener.<c:out value="${param.callback}"/>(window, link.id, officeTree.getNodeById(link.id).name);
	</c:if>
}
var officeTree;
function initOfficeTree(){
	officeTree = new Topsuntech.TreeView("officeDiv");
	//officeTree.rootNodeName = "选择机构";
	
	var idStr = '<c:out value="${param.idStr}" />';
	officeTree.preloadPostData = {type: '<c:out value="${param.type}" />', idStr: idStr};
	<c:if test="${param.type == 2}">
		officeTree.preloadUrl = '<c:url value="/main/system/zxt_mgm/treeView.do?type=dept&treeViewCreator=userOfficeTreeCreator&doMethod=getPreloadNodes"/>';
		officeTree.getChildUrl = '<c:url value="/main/system/zxt_mgm/treeView.do?type=dept&treeViewCreator=userOfficeTreeCreator&doMethod=getChildNodes"/>';
	</c:if>
	<c:if test="${param.type == 1}">
		officeTree.preloadUrl = '<c:url value="/main/system/zxt_mgm/treeView.do?treeViewCreator=officeTreeViewCreator&doMethod=getPreloadNodes"/>';
		officeTree.getChildUrl = '<c:url value="/main/system/zxt_mgm/treeView.do?treeViewCreator=officeTreeViewCreator&doMethod=getChildNodes"/>';
	</c:if>

	officeTree.createNode = function(nodeData, parentNode){
		var linksNode = new Topsuntech.LinksNode("l" + nodeData.id, parentNode, false);
	  	linksNode.name = nodeData.name;
	  	linksNode.nameLink = {id: nodeData.id, href: 'javascript:', onclick: 'setOffice(this)'};
	  
	  	return linksNode;
	};
	officeTree.preLoadNodeDataCallback = function(){
		var idArr = idStr.split(',');
		for(var i = 0; i < idArr.length; i++){
			$("#" + idArr[i]).css('color', 'blue');
			if(i == idArr.length - 1){
				$("#" + idArr[i]).focus();
			}
		}
	}
	officeTree.drawTree();
}
function doOnLoad(){
	initOfficeTree();
	
}
</script>
</head>

<body onLoad="doOnLoad()">
<form method="post" id="opForm" >
	<input id="deptId" name="deptId" type="hidden"/>
	<input id="regionId" name="regionId" type="hidden"/>
</form>

<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="11" background="../images/images_32.jpg"><img src="../images/content_left.gif" width="11" height="51"></td>
    <td height="51" background="../images/images_32.jpg">
	    <table width="70%" border="0" cellspacing="0" cellpadding="0">
	      <tr>
	        <td width="22" height="16" align="center"><img src="../images/d.gif" width="14" height="14"></td>
	        <td valign="bottom"> 当前位置：<b>选择机构</b></td>
	      </tr>		
	    </table>
    </td>
  </tr>
	<tr>
		<td background="../images/images_481.jpg">&nbsp;</td>
		<td valign="top" height="100%">
			<table width="100%" height="100%" border="0">
				<tr>
					<td valign="top">
						<!-- div style="overflow: auto; height: 97%; width: 100%" >
						</div-->
							<table>
								<tr>
									<td><div id="officeDiv" style="font-size:13px;"></div></td>
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
