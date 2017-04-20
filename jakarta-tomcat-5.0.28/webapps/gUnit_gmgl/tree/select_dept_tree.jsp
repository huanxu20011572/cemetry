<%@ page language="java" contentType="text/html; charset=GBK" %>
<%@ include file="../common/taglibs.jsp"%>  
<link href="../css/style_hdsj.css" rel="stylesheet" type="text/css">

<%@ page import="java.util.*,java.io.*,java.lang.*" %>
<%@ page import="com.topsuntech.gOS.user.session.UserSession" %>
<%@ page import="com.topsuntech.gOS.user.en.office.Office" %>
<%@ page import="com.topsuntech.gOS.user.en.user.User" %>
<%@ page import="com.topsuntech.gUnit.gEU_util.tools.Dicts" %>

<%
	 long userId = UserSession.getUserID(request);   
	  Office off = UserSession.getUserDept(request); 	
		long rootId = off.getId().longValue();  	
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
  <title>系统选择树</title>

   <style type="text/css" media="screen">
       @import url( style.css );
   </style>
   
<script type="text/javascript" src="ajax/dojo/dojo.js"></script>
<script type="text/javascript" src="<c:url value='../script/common.js'/>"></script>

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

function doSelected(ctId,ctName){
	

	var strForm = document.treeForm;
	var objForm = strForm.objForm.value;
	var objId = strForm.objId.value;
	var objName = strForm.objName.value;	
					
 if(Jtrim(objId).length  > 0)
			opener[objForm][objId].value  = ctId;
	if(Jtrim(objName).length  > 0)
			opener[objForm][objName].value  = ctName;			
				
	window.close();

												
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
<form name="treeForm"  >
	
<input type="hidden" name="treeRootId" value="<c:out value='${param.treeRootId}' />" >				
<input type="hidden" name="treeType" value="<c:out value='${param.treeType}' />" >			
<input type="hidden" name="objForm" value="<c:out value='${param.objForm}' />" >			
<input type="hidden" name="objId" value="<c:out value='${param.objId}' />" >		
<input type="hidden" name="objName" value="<c:out value='${param.objName}' />" >		
	

	
	
  <div dojoType="TreeLoadingController" RPCUrl="../treeServlet" widgetId="treeController" DNDController="create"></div>
  <div dojoType="TreeSelector" widgetId="treeSelector"></div>
  <div dojoType="Tree" DNDMode="between" selector="treeSelector" widgetId="bandTree" controller="treeController">
  <div dojoType="TreeNode" title="选择机构" widgetId="root" objectId="<%=rootId%>,<%=treeNodeType%>,<c:out value='${param.treeType}' />" userId="<%=userId%>" isFolder="true" childIconSrc="images/comm.gif" expandLevel="1"/>
  
</form>  
</body>
</html>
