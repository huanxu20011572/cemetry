<%@ page contentType="text/html; charset=GBK" %>
<%@ include file="../../../common/taglibs.jsp"%>

<html>
<head>
<title>tree_test</title>
<meta http-equiv="content-type" content="text/html; charset=GBK">
<meta http-equiv="Cache-Control" content="no-store"/>
<meta http-equiv="Pragma" content="no-cache"/>
<meta http-equiv="Expires" content="0"/>
<style>
</style>
<link href="<c:url value='/css/css.css' />" rel="stylesheet" type="text/css">

<link rel="stylesheet" type="text/css" href="assets/skins/sam/treeview.css" />
<link rel="stylesheet" type="text/css" href="assets/folders/tree.css" />


<script type="text/javascript" src="lib/yahoo-dom-event.js"></script>
<script type="text/javascript" src="lib/treeview-min.js"></script>
<script type="text/javascript" src="lib/jquery-1.2.6.min.js"></script>
<script type="text/javascript" src="lib/edit-tree.js"></script>

<script src='<c:url value="/script/publics.js" />'></script>
<!--style>
    #treeDiv1 {background: #fff; padding:1em;}
</style-->


</head>


<body   leftmargin="2" topmargin="5">

<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="11" background="<c:url value='/images/images_32.jpg' />"><img src="<c:url value='/images/content_left.gif' />" width="11" height="51"></td>
    <td height="51" background="<c:url value='/images/images_32.jpg' />">
	    <table width="70%" border="0" cellspacing="0" cellpadding="0">
	      <tr>
	        <td width="22" height="16" align="center"><img src="<c:url value='/images/d.gif' />" width="14" height="14"></td>
	        <td valign="bottom"> 当前位置：本子机构管理</td>
	      </tr>
	    </table>
    </td>
  </tr>
  <tr>
    <td background="<c:url value='/images/images_481.jpg' />">&nbsp;</td>
    <td valign="top">
		<table>
			<tr><td><div id="treeDiv1" style="font-size:13px"></div></td></tr>
			<tr><td><div id="treeDiv2" style="font-size:13px"></div></td></tr>
			<tr><td><div id="treeDiv3" style="font-size:13px"></div></td></tr>
		</table>
     </td>
  </tr>
 </table> 
</body>  
<script type="text/javascript">


function drawTree() {
	var tree = new Topsuntech.TreeView();
	tree.divId = "treeDiv1";
	tree.rootNodeName = "机构";
	tree.rootNodeLink = [{href: 'javascript:addChildDept();', target: '_self', name: '增加下级'}];
	tree.preloadUrl = '<c:url value="/main/system/zxt_mgm/treeView.do?type=dept&treeViewCreator=userOfficeTreeCreator&doMethod=getPreloadNodes"/>';
	tree.getChildUrl = '<c:url value="/main/system/zxt_mgm/treeView.do?type=dept&treeViewCreator=userOfficeTreeCreator&doMethod=getChildNodes"/>';

	tree.createNode = function(nodeData, parentNode){
		var linksNode = new Topsuntech.LinksNode("l" + nodeData.id, parentNode, false);
  	linksNode.id = nodeData.id;
  	linksNode.name = nodeData.name;
	  	linksNode.links = [	{id: nodeData.id + '_a', href: 'javascript:', onclick: 'addDept(this);return false;', target: '_self', name: '添加下级', style: 'color: blue'} ];
	  	if(!nodeData.region){
			linksNode.links[linksNode.links.length] = {id: nodeData.id + '_u', href: 'javascript:', onclick: 'updateDept(this);return false;', target: '_self', name: '修改', style: 'color: blue'};
	  		linksNode.links[linksNode.links.length] = {id: nodeData.id + '_d', href: 'javascript:', onclick: "deleteDept(this);return false;", target: '_self', name: '删除', style: 'color: blue'};	 
	  	}
  	return linksNode;
	};
	tree.drawTree();
	
}

$(document).ready(drawTree);

function addChildDept(){
	window.location="../../../tree/toAddDept.do?method=toAdd&inputPath=subDept";	
}	

function updateDept(deptId){
	window.location="../../../tree/toUpdateDept.do?method=toUpdate&deptId=" + deptId + "&inputPath=subDept";								
}	
function deleteDept(deptId){
	var strUrl = "../../../tree/doDeleteDept.do?method=delete&inputPath=subDept";
	
	if(confirm("你确定要删除当前机构吗？")){
		strUrl += "&deptId=" + deptId;
		strUrl += "&useFlag=2" ;
		
		window.location=strUrl;
	}								
}

</script>
	


</html>

