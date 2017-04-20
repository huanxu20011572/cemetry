<%@ page contentType="text/html; charset=GBK" %>
<%@ include file="../common/taglibs.jsp"%>
<html>
<head>
<title>机构管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<meta http-equiv="Cache-Control" content="no-store"/>
<meta http-equiv="Pragma" content="no-cache"/>
<meta http-equiv="Expires" content="0"/>

<link href="../css/style.css" rel="stylesheet" type="text/css">
<link href="../css/css.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="../lib/treelib/assets/skins/sam/treeview.css" />
<link rel="stylesheet" type="text/css" href="../lib/treelib/assets/folders/tree.css" />

<script type="text/javascript" src="../js/jquery-1.2.6.js"></script>
<script type="text/javascript" src="../lib/treelib/yahoo-dom-event.js"></script>
<script type="text/javascript" src="../lib/treelib/treeview-min.js"></script>
<script type="text/javascript" src="../lib/treelib/edit-tree.js"></script>

<script>

function submitForm(formId, action){
	var pForm = document.getElementById(formId);
	var oAction = pForm.action;
	var oTarget = pForm.target;
	pForm.action = action;
	pForm.submit();
	pForm.action = oAction;
}
function populateForm(link){
	var deptId = link.id.split('_')[0];
	$('#deptId').val(deptId);
	$('#regionId').val(officeTree.getNodeById(deptId).regionId);
}
function addDept(link){
	populateForm(link);
	submitForm("opForm", "toAddDept.do?method=toAdd&inputPath=allDept");
}
function updateDept(link){
	populateForm(link);
	submitForm("opForm", "toUpdateDept.do?method=toUpdate&inputPath=allDept");
}
function deleteDept(link){
	var deptName = officeTree.getNodeById(link.id.split('_')[0]).name;
	if(confirm("你确定要删除 " + deptName + " 吗？")){
		populateForm(link);
		submitForm("opForm", "doDeleteDept.do?method=delete&inputPath=allDept&useFlag=0");
	}								
}
function orderDept(link){
	populateForm(link);
	submitForm("opForm", "deptOrder.do?method=deptList");
}

var officeTree;
function initOfficeTree(){
	officeTree = new Topsuntech.TreeView("officeDiv");
	officeTree.rootNodeName = "机构管理";
	
	var idStr = '<c:out value="${param.idStr}" />';
	officeTree.preloadPostData = {type: 1, idStr: idStr};
	officeTree.preloadUrl = '<c:url value="/main/system/zxt_mgm/treeView.do?treeViewCreator=officeTreeViewCreator&doMethod=getPreloadNodes&userRegion=true"/>';
	officeTree.getChildUrl = '<c:url value="/main/system/zxt_mgm/treeView.do?treeViewCreator=officeTreeViewCreator&doMethod=getChildNodes&userRegion=true"/>';
	officeTree.createNode = function(nodeData, parentNode){
		var linksNode = new Topsuntech.LinksNode("l" + nodeData.id, parentNode, false);
	  	linksNode.name = nodeData.name;
	  	linksNode.regionId = nodeData.regionId;
	  	//linksNode.spaceStyle = 'margin-left: 20px';
	  	
	  	linksNode.links = [	{id: nodeData.id + '_a', href: 'javascript:', onclick: 'addDept(this);return false;', target: '_self', name: '添加下级', style: 'color: blue'} ];
	  	if(!nodeData.region){
			linksNode.links[linksNode.links.length] = {id: nodeData.id + '_u', href: 'javascript:', onclick: 'updateDept(this);return false;', target: '_self', name: '修改', style: 'color: blue'};
	  		linksNode.links[linksNode.links.length] = {id: nodeData.id + '_d', href: 'javascript:', onclick: "deleteDept(this);return false;", target: '_self', name: '删除', style: 'color: blue'};	 
	  	}
// 	  	linksNode.links[linksNode.links.length] = {id: nodeData.id + '_o', href: 'javascript:', onclick: "orderDept(this);return false;", target: '_self', name: '排序', style: 'color: blue'};	  		 		
	  	return linksNode;
	};
	officeTree.preLoadNodeDataCallback = function(){
		var idArr = idStr.split(',');
		var lastId = idArr[idArr.length - 1];
		$("#" + lastId + "_a").focus();
	}
	officeTree.drawTree();
}

function doOnLoad(){
	initOfficeTree();
	
}
</script>
</head>

<body onLoad="doOnLoad()">
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
<form method="post" id="opForm" >
	<input id="deptId" name="deptId" type="hidden"/>
	<input id="regionId" name="regionId" type="hidden"/>
</form>
  <tr>
    <td width="11" height="31" valign="top" class="td-bg"><img src="../images/right-1.jpg" /></td>
    <td align="center" valign="top" ><table width="100%" border="0" cellpadding="0" cellspacing="0" class="word-8">
      <tr>
        <td height="31" align="left" valign="middle" style="background:url(../images/right-3.jpg)"><img src="../images/right-4.jpg" width="9" height="8" align="absmiddle" /> 当前位置 &gt; 系统管理 &gt; 机构管理</td>
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
			<table width="95%" height="100%" border="0">
				<tr>
					<td valign="top">
						<!-- div style="overflow: auto; height: 97%; width: 100%" >
						</div-->
							<table>
								<tr>
									<td><div id="officeDiv" style="font-size:10px;"></div></td>
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