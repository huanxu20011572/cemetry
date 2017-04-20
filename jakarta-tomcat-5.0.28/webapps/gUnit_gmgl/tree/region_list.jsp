<%@ page language="java" contentType="text/html; charset=GBK" %>
<%@ include file="../common/taglibs.jsp"%>
<%@ include file="../common/js_common.jsp"%>  

<%@ page import="java.util.*,java.io.*,java.lang.*" %>
<%@ page import="com.topsuntech.gOS.user.session.UserSession" %>
<%@ page import="com.topsuntech.gOS.user.en.office.Office" %>
<%@ page import="com.topsuntech.gOS.user.en.user.User" %>
<link href="style.css" rel="stylesheet" type="text/css">
<%
	  long userId = UserSession.getUserID(request);   
	  Office off = UserSession.getUserDept(request); 	
		long regionId =off.getRegionid();  							
%>

<html>
<head>
  <title>系统选择树</title>

<script type="text/javascript" src="ajax/dojo/dojo.js"></script>
<script type="text/javascript" src="<c:url value='../script/common.js'/>"></script>
<script src="<c:url value='../script/publics.js'/>"></script>
	
	

<script type="text/javascript">
dojo.require("dojo.widget.Tree");
dojo.require("dojo.widget.TreeNode");
dojo.require("dojo.widget.TreeSelector");
dojo.require("dojo.widget.TreeRPCController");
dojo.require("dojo.widget.TreeLoadingController");
dojo.require("dojo.widget.TreeContextMenu");

function createMergerWindow(url)
{
		var url = "office_dynamic/merger_info.jsp";
													
        msgWindow=window.open(url,"protypeWindow","toolbar=no,width=600,height=850,directories=no,status=no,scrollbars=no,resize=no,menubar=no,top=100,left=600");
        msgWindow.focus();
}
function createDevideWindow(url)
{
		var url = "office_dynamic/devide_info.jsp";
        msgWindow=window.open(url,"protypeWindow","toolbar=no,width=600,height=850,directories=no,status=no,scrollbars=no,resize=no,menubar=no,top=100,left=600");
        msgWindow.focus();
}

function treeSelectFired() {
    // get a reference to the treeSelector and get the selected node 
    var treeSelector = dojo.widget.manager.getWidgetById('treeSelector');
    var treeNode = treeSelector.selectedNode;
    // get a reference to the songDisplay div
    var hostDiv = document.getElementById("songDisplay");
    var isFolder = treeNode['isFolder'];
    //alert(isFolder);
    if ( !isFolder) {
       var song = treeNode['title'];
       var url = treeNode['url'];
       link(url);
    } else { 
    }
}

function link(url){
  //alert(url);
  /*
  if(url){
    parent.MainFrame.location.href=url;
  }
  */
  
}

function showNullMessage(){
	alert("系统提示：当前没有选中对象，请重新选择！");	
	
}	



function clearSelect(){
	document.treeForm.reset();
}

function addChilds(regionId,regionName,levelid){
	var strForm = document.treeForm;
	var nodeId = strForm.nodeId;
	var nodeName = strForm.nodeName;
	var nodeLevelid = strForm.nodeLevelid;
	
	var strUrl = "";
	var strBuild = "toolbar=no,width=750,height=300,directories=no,status=no,scrollbars=yes,resize=no,menubar=no";
	
	nodeId.value = regionId;
	nodeName.value = regionName;
	nodeLevelid.value = levelid;
	
	
	strUrl = "office_dynamic/region_add.jsp";
	//strUrl += "?parentId=" + regionId + "&parentName=" + regionName;
	
CreateWindow(strUrl, "treeWin", strBuild);
		//strForm.action =strUrl;
		//strForm.submit();
											
}	

function updates(regionId,regionName,levelid){
	var strForm = document.treeForm;
	var nodeId = strForm.nodeId;
	var nodeName = strForm.nodeName;
	var nodeLevelid = strForm.nodeLevelid;
	
	var strUrl = "";
	var strBuild = "toolbar=no,width=750,height=300,directories=no,status=no,scrollbars=yes,resize=no,menubar=no";
	
	nodeId.value = regionId;
	nodeName.value = regionName;
	
	
	strUrl = "toUpdate.do?method=toUpdate&regionId=" + regionId;
	
	//CreateWindow(strUrl, "treeWin", strBuild);
	strForm.action =strUrl;
	strForm.submit();
											
}	

function stops(regionId,regionName,levelid){
	var strForm = document.treeForm;
	var strUrl = "doDelete.do?method=delete&regionId=" + regionId + "&useFlag=0" ;
	
	if(confirm("你确定要停用当前区域吗？")){
		strForm.action = strUrl;
		strForm.submit();							
  }
}	

function deletes(regionId,regionName,levelid){
	var strForm = document.treeForm;
	var strUrl = "doDelete.do?method=delete";
	
	if(confirm("你确定要删除当前区域吗？")){
		strUrl += "&regionId=" + regionId;
		strUrl += "&useFlag=2" ;
		
		strForm.action = strUrl;
		strForm.submit();
	}								
}	



function init() { 

    //get a reference to the treeSelector
    var treeSelector = dojo.widget.manager.getWidgetById('treeSelector');

    //connect the select event to the function treeSelectFired()
    dojo.event.connect(treeSelector,'select','treeSelectFired'); 
}

dojo.addOnLoad(init);
</script>

<style type="text/css"> 
body {
  font-family: "宋体","黑体";
  background-color:#FFFFFF; 
  	padding: 0;
	margin: 0;
}  
div {
  font-size: 12px; 
  font-style: normal;
  font-weight: normal; 
 
}  
</style>

</head>
<body style="background-color: transparent">
<table width="100%" border="0" cellspacing="0" cellpadding="0" height="100%">
  <tr>
    <td width="11" height="31" valign="top" class="td-bg"><img src="../images/right-1.jpg" /></td>
    <td align="center" valign="top" ><table width="100%" border="0" cellpadding="0" cellspacing="0" class="word-8">
      <tr>
        <td height="31" align="left" valign="middle" style="background:url(../images/right-3.jpg)"><img src="../images/right-4.jpg" width="9" height="8" align="absmiddle" /> 当前位置 &gt; 系统管理 &gt; 区域管理</td>
      </tr>
    </table>
	
    </td>
  </tr>
  <tr>
    <td >&nbsp;</td>
    <td valign="top">
<form name="treeForm"  action="" method="post" >
	
<input type="hidden" name="nodeId" value="" >			
<input type="hidden" name="nodeName" value="" >		
<input type="hidden" name="nodeLevelid" value="" >		

	

	
			
		  <div dojoType="TreeLoadingController" RPCUrl="../treeServlet" widgetId="treeController" DNDController="create"></div>
		  <div dojoType="TreeSelector" widgetId="treeSelector"></div>
		  <div dojoType="Tree" DNDMode="between" selector="treeSelector" widgetId="bandTree" controller="treeController">
		 <div dojoType="TreeNode"  title="选择区域 <a href='javascript:createMergerWindow()'>[区划合并]</a>  <a href='javascript:createDevideWindow()'>[区划拆分]</a>" widgetId="root"   objectId="<%=regionId%>,101,600" userId="<%=userId%>" isFolder="true" childIconSrc="images/comm.gif" expandLevel="1"></div>
		  

</form>  
</td>
	</tr>
		</table>
</body>	

</html>
