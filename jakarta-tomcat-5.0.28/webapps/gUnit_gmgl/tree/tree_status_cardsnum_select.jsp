<%@ page language="java" contentType="text/html; charset=GBK" %>
<%@ include file="../common/taglibs.jsp"%>  
<%@ include file="../main_bjsj/public/css.jsp"%>

<%@ page import="java.util.*,java.io.*,java.lang.*" %>
<%@ page import="com.topsuntech.gOS.user.session.UserSession" %>
<%@ page import="com.topsuntech.gOS.user.en.office.Office" %>
<%@ page import="com.topsuntech.gOS.user.en.user.User" %>
<%
	  long userId = UserSession.getUserID(request);     					
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
  
}

function showNullMessage(){
	alert("系统提示：当前没有选中对象，请重新选择！");	
	
}	

function setAllChecked(strForm,obj) {
  var form=document[strForm];
  var ids=form[obj];
  var objSelectEmailGroupStrId = strForm.objSelectEmailGroupStrId;
	var objSelectEmailGroupStrName = strForm.objSelectEmailGroupStrName;
	var selectEmailGroupStrId = "";
	var selectEmailGroupStrName = "";
  
  if(ids ==null )
     return ;
  
  if(ids.length!=null){
      for(var i=1;i<ids.length;i++){
          if(ids[i].checked==true){  
          	
          }else{
          	
          }	
      }                    
  }else{
    
  }
}	
  


function changeSelectsDept(selectObj){
		
	var strForm = document.treeForm;
	var objSelectEmailGroupStrId = strForm.objSelectEmailGroupStrId;
	var objSelectEmailGroupStrName = strForm.objSelectEmailGroupStrName;
	var selectObjValue = selectObj.value;
	var chargeStatus = selectObj.checked;
	
	if(selectObj.length >0 ){
		
		for(var i=1; i< selectObj.length; i++){
			var selectObjs = selectObj[i].value.split("|");						
			objSelectEmailGroupStrId.value = objSelectEmailGroupStrId.value.replace(selectObjs[0], ',');
			objSelectEmailGroupStrName.value = objSelectEmailGroupStrName.value.replace(selectObjs[1], ',');
			
			endBuild(objSelectEmailGroupStrId, objSelectEmailGroupStrName);
		}
				
		selectObjValue = selectObj[0].value;
	  chargeStatus = selectObj[0].checked;
		
	}else{
		selectObjValue = selectObj.value;
	  chargeStatus = selectObj.checked;
	}
	
	var selectObjs = selectObjValue.split("|");		
	if(chargeStatus == true){
		
		if(objSelectEmailGroupStrId.value.length > 0){
			var eStr = 
			    objSelectEmailGroupStrId.value.substring(objSelectEmailGroupStrId.value.length ,
			    objSelectEmailGroupStrId.value.length -1);
				 
			if(eStr == ','){
				objSelectEmailGroupStrId.value = objSelectEmailGroupStrId.value.substring(0 ,
			    objSelectEmailGroupStrId.value.length -1);
			  objSelectEmailGroupStrName.value = objSelectEmailGroupStrName.value.substring(0 ,
			    objSelectEmailGroupStrName.value.length -1);  
			  
			}   
		}
		    
		objSelectEmailGroupStrId.value = objSelectEmailGroupStrId.value + selectObjs[0];
		objSelectEmailGroupStrName.value = objSelectEmailGroupStrName.value + selectObjs[1];
	}else{
		
		objSelectEmailGroupStrId.value = objSelectEmailGroupStrId.value.replace(selectObjs[0], ',');
		objSelectEmailGroupStrName.value = objSelectEmailGroupStrName.value.replace(selectObjs[1], ',');
   }
	
	endBuild(objSelectEmailGroupStrId, objSelectEmailGroupStrName);

	
}

function endBuild(objSelectEmailGroupStrId, objSelectEmailGroupStrName){
	
	  
  //alert(objSelectEmailGroupStrId.value);		
	///alert(objSelectEmailGroupStrName.value);	
	
	
	if(objSelectEmailGroupStrId.value == ','){
	 objSelectEmailGroupStrId.value = '';
	 objSelectEmailGroupStrName.value = '';
	 return ;
	}
	
	
	if(Jtrim(objSelectEmailGroupStrId.value).length > 0 ){
			var startStr = 
				    objSelectEmailGroupStrId.value.substring(0 ,
				    1);
					 
			if(startStr != ','){
				objSelectEmailGroupStrId.value = "," + objSelectEmailGroupStrId.value ;
			  objSelectEmailGroupStrName.value = "," + objSelectEmailGroupStrName.value ;
			} 	
			
		 var endStr = 
					    objSelectEmailGroupStrId.value.substring(objSelectEmailGroupStrId.value.length ,
					    objSelectEmailGroupStrId.value.length -1);
						 
			if(endStr != ','){
				objSelectEmailGroupStrId.value = objSelectEmailGroupStrId.value + ",";
			  objSelectEmailGroupStrName.value = objSelectEmailGroupStrName.value + ",";
			} 
	}	
	
}

function getSelectedBJ(obj){
	var strForm = document.treeForm;
	var cksg = strForm[obj.name];
	var objSelectEmailGroupStrId = strForm.objSelectEmailGroupStrId;
	var objSelectEmailGroupStrName = strForm.objSelectEmailGroupStrName;

		
	if(cksg == null ){
		showNullMessage();
		return ;
	}	 
	
			  
	if(cksg.length != null ){

		if(cksg[0].checked == true){
			
	  	for(var i=0; i< cksg.length; i++){
					var selectObjs = cksg[i].value.split("|");		
					objSelectEmailGroupStrId.value = objSelectEmailGroupStrId.value.replace(selectObjs[0], ',');
					objSelectEmailGroupStrName.value = objSelectEmailGroupStrName.value.replace(selectObjs[1], ',');
	
					endBuild(objSelectEmailGroupStrId, objSelectEmailGroupStrName);
				}
	  }	
  		
		for(var i = 1; i < cksg.length; i++){
			  cksg[i].checked =cksg[0].checked;			  	
			  changeSelectsDept(cksg[i]);
		}	
	
	}else{
	 alert('系统提示：请先展开当前节点');
	 obj.checked = false;
	 return; 
		
	}	
}



function clearSelect(){
	document.treeForm.reset();
}

function getSelect(){
	var strForm = document.treeForm;
	var objForm = strForm.objForm.value;
	var objId = strForm.objId.value;
	var objName = strForm.objName.value;	
	var objSelectEmailGroupStrId = strForm.objSelectEmailGroupStrId;
	var objSelectEmailGroupStrName = strForm.objSelectEmailGroupStrName;
	var mulListName = strForm.mulListName.value;
	
 	
 if(Jtrim(objSelectEmailGroupStrId.value).length ==0){
   showNullMessage();	
   return; 
 }	
					
  if(Jtrim(objId).length  > 0)
			opener[objForm][objId].value  = objSelectEmailGroupStrId.value;
	if(Jtrim(objName).length  > 0)
			opener[objForm][objName].value  = objSelectEmailGroupStrName.value;			
	
	if(Jtrim(mulListName).length  > 0){
		  var ids = objSelectEmailGroupStrId.value.split(","); 	 
		  var names = objSelectEmailGroupStrName.value.split(","); 	 
		  
		  opener[objForm]['name'].options.length = 0;
						  	   
		  for(var j=0; j < ids.length; j++){	  
		  	if(Jtrim(ids[j]).length > 0){
		      opener['addSelectItem'](names[j],ids[j]);	 
		    }
		  }		
		  	  
		 for(var k=0; k <opener[objForm]['name'].length; k ++){
				opener[objForm]['name'][k].selected = true;	  	
		 }
	}
					
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
<input type="hidden" name="treeType" value="<c:out value='${param.treeType}' />" >			
<input type="hidden" name="objForm" value="<c:out value='${param.objForm}' />" >			
<input type="hidden" name="objId" value="<c:out value='${param.objId}' />" >		
<input type="hidden" name="objName" value="<c:out value='${param.objName}' />" >		
<input type="hidden" name="objSelectEmailGroupStrId" value="" >	
<input type="hidden" name="objSelectEmailGroupStrName" value="" >	
<input type="hidden" name="mulListName" value="<c:out value='${param.mulListName}' />" >	

	

	
	
  <div dojoType="TreeLoadingController" RPCUrl="../treeServlet" widgetId="treeController" DNDController="create"></div>
  <div dojoType="TreeSelector" widgetId="treeSelector"></div>
  <div dojoType="Tree" DNDMode="between" selector="treeSelector" widgetId="bandTree" controller="treeController">
  <div dojoType="TreeNode" title="选择身份类别<a href='javascript:getSelect()'>[确认添加]</a><a href='javascript:clearSelect()'>[取消添加]</a>" widgetId="root" objectId="2985,0,1000" userId="<%=userId%>" isFolder="true" childIconSrc="images/comm.gif" expandLevel="1"/>
  
</form>  
</body>
</html>

	
