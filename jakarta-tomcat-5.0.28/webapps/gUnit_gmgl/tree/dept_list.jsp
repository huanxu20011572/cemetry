<%@ page language="java" contentType="text/html; charset=GBK" %>
<%@ include file="../common/taglibs.jsp"%>  
<link href="../css/css.css" rel="stylesheet" type="text/css">


<%@ page import="java.util.*,java.io.*,java.lang.*" %>
<%@ page import="com.topsuntech.gOS.user.session.UserSession" %>
<%@ page import="com.topsuntech.gOS.user.en.office.Office" %>
<%@ page import="com.topsuntech.gOS.user.en.user.User" %>
<%@ page import="com.topsuntech.gUnit.gEU_util.tools.Dicts" %>



<%
	  long userId = UserSession.getUserID(request);   
	  Office off = UserSession.getUserDept(request); 	
		long rootId = 0;  
		
		long ctLev = Dicts.judgeRoleById(rootId);	
		if(ctLev <2)
		  ctLev = 1;
		long treeNodeType = -1;
		if(ctLev == 1){
		 treeNodeType = 102;
		}else if(ctLev == 2 || ctLev == 3){
		    rootId = off.getRegionid();
		   
		    treeNodeType = 101;
		}    
					
%>

<html>
<head>
  <title>机构树</title>

   <style type="text/css" media="screen">
       @import url( style.css );
   </style>
   
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


function addChildDept(){
	var strForm = document.treeForm;	
	var strBuild = "toolbar=no,width=750,height=350,directories=no,status=no,scrollbars=yes,resize=no,menubar=no";
	var strUrl = "";
			
	strUrl = "toAddDept.do?method=toAdd";
	strUrl = strUrl + '&inputPath=allDept'
	//CreateWindow(strUrl, "treeWin", strBuild);
	strForm.action =strUrl;
		strForm.submit();
										
}	

function updateDept(deptId){
	var strForm = document.treeForm;	
	var strBuild = "toolbar=no,width=750,height=350,directories=no,status=no,scrollbars=yes,resize=no,menubar=no";
	var strUrl = "";
	
	strUrl = "toUpdateDept.do?method=toUpdate&deptId=" + deptId;
	strUrl = strUrl + '&inputPath=allDept'
	//CreateWindow(strUrl, "treeWin", strBuild);
		strForm.action =strUrl;
		strForm.submit();
										
}	

function stopDept(deptId){
	var strForm = document.treeForm;
	var strUrl = "doStopDept.do?method=delete&deptId=" + deptId + "&useFlag=0" ;
	
	if(confirm("你确定要停用当前机构吗？")){
		strForm.action = strUrl;
		strForm.submit();							
  }
}	

function deleteDept(deptId){
	var strForm = document.treeForm;
	var strUrl = "doDeleteDept.do?method=delete";
	
	if(confirm("你确定要删除当前机构吗？")){
		strUrl += "&deptId=" + deptId;
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
  line-height: 17px;
}  
</style>

</head>

<body background="images/body_bg.gif"  leftmargin="2" topmargin="5">
<form name="treeForm"  action="" method="post" >
<input type="hidden" name="inputPath" value='allDept'>
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="11" background="../images/images_32.jpg"><img src="../images/content_left.gif" width="11" height="51"></td>
    <td height="51" background="../images/images_32.jpg"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="22" height="16" align="center"><img src="../images/d.gif" width="14" height="14"></td>
        <td valign="bottom"> 当前位置：<b>机构维护</b></td>
        <td width="300" align=right></td>
        
        <td width="15">&nbsp;</td>
      </tr>
    </table>
    </td>
  </tr>
  <tr>
    <td background="../images/images_481.jpg">&nbsp;</td>
    <td valign="top">

	
  <div dojoType="TreeLoadingController" RPCUrl="../treeServlet" widgetId="treeController" DNDController="create"></div>
  <div dojoType="TreeSelector" widgetId="treeSelector"></div>
  <div dojoType="Tree" DNDMode="between" selector="treeSelector" widgetId="bandTree" controller="treeController">
  <div dojoType="TreeNode" title="选择机构&nbsp;<a href='javascript: addChildDept()'>增加机构</a> " widgetId="root" objectId="<%=rootId%>,<%=treeNodeType%>,700" userId="<%=userId%>" isFolder="true" childIconSrc="images/comm.gif" expandLevel="1"/>
        </td>
  </tr>
 </table> 
</form>  
</body>
</html>

	