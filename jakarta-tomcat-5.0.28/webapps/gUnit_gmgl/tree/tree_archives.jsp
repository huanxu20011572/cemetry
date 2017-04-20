<%@ page language="java" contentType="text/html; charset=GBK" %>
<%@ include file="../common/taglibs.jsp"%>  
<%@ include file="../main_bjsj/public/css.jsp"%>


<%@ page import="java.util.*,java.io.*,java.lang.*" %>
<%@ page import="com.topsuntech.gOS.user.session.UserSession" %>
<%@ page import="com.topsuntech.gOS.user.en.office.Office" %>
<%@ page import="com.topsuntech.gOS.user.en.user.User" %>
<%
	  long userId = UserSession.getUserID(request); 
	  Office off = UserSession.getUserDept(request); 
    long regionId = off.getRegionid();    					
%>

<html>
<head>
  <title>系统选择树</title>

   <style type="text/css" media="screen">
       @import url( style.css );
   </style>
   
<script type="text/javascript" src="ajax/dojo/dojo.js"></script>
<script type="text/javascript" src="<c:url value='../script/common.js'/>"></script>
<script type="text/javascript" src="<c:url value='../script/publics.js'/>"></script>	

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
 	
 if(Jtrim(objSelectEmailGroupStrId.value).length ==0){
   showNullMessage();	
   return; 
 }	
					
 if(Jtrim(objId).length  > 0)
			opener[objForm][objId].value  = objSelectEmailGroupStrId.value;
	if(Jtrim(objName).length  > 0)
			opener[objForm][objName].value  = objSelectEmailGroupStrName.value;			
				
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

	

	
	
  <div dojoType="TreeLoadingController" RPCUrl="../treeServlet" widgetId="treeController" DNDController="create"></div>
  <div dojoType="TreeSelector" widgetId="treeSelector"></div>
  <div dojoType="Tree" DNDMode="between" selector="treeSelector" widgetId="bandTree" controller="treeController">
  <div dojoType="TreeNode" title="选择机构<a href='javascript:getSelect()'>[确认添加]</a><a href='javascript:clearSelect()'>[取消添加]</a>" widgetId="root" objectId="<%=regionId%>,105,<c:out value='${param.treeType}' />" userId="<%=userId%>" isFolder="true" childIconSrc="images/comm.gif" expandLevel="1"/>
  
</form>  
</body>
</html>

	
<%

/**
外部传入参数说明：
	
	@param :[String]treeRootName 			  //根节点名称--->对象名称
---------------------------------------------------------------------------------------------------------	
	@param :[String]strFormName 				//form名称-->对象名称strFormName
---------------------------------------------------------------------------------------------------------	
	@param :[String]rootObjName 				//根节点ID-->对象名称
---------------------------------------------------------------------------------------------------------	
  @param :[String]objectId           //树节点Str
                                       格式：节点值,节点类型
                              
---------------------------------------------------------------------------------------------------------	
	@param :[long]treeType 	  //101，FROM"数字字典"(递归)，显示下级字典
	                            102，FROM"数字字典"(不递归)，显示下级字典
	                            
														  201：FROM"组织机构"(递归)；
														  202, FROM"组织机构"(不递归)； 														  
														  203，FROM"组织机构"，显示相关项目;
														  204，FROM"组织机构"(递归)， 不显示相关的项目，同时显示下级成员；
														  205，FROM"组织机构"(不递归)，不显示相关的项目，同时显示下级成员；
														  206, FROM"组织机构ID"，显示下级成员；
														  207，FROM"组织机构ID"，用于“事项受理”、“救助实施”：适用于区县用户；
														  208，FROM"组织机构ID"，用于“项目维护”：适用于市级、区县管理人员用户；
														  209，FROM"组织机构ID"，用于“公文收发”：本级；
														  210，FROM"组织机构ID"，用于“公文收发”：下级；
														  211，FROM"组织机构ID"，用于“公文收发”：本级和下级；
														  
															301, FROM"项目表",只显示项目树（通过机构ID）
															
															401，FROM"项目资源"，不显示项目，显示当前项目下所有的资源信息
															
															501, FROM"角色信息"，显示当前节点下所有的角色
															
															601, FROM"区域数据"，只显示下一级区域；用于“申请”、“救助对象维护”；
															
															601, FROM"区域数据"，只显示下一级区域；用于“申请”、“救助对象维护”；
															
															602, FROM"区域数据"，依次显示邮件组、机构、用户，用于“邮件发件箱”；
															
															602, FROM"区域数据"，依次显示机构、用户，用于““邮件分组”；
																														
---------------------------------------------------------------------------------------------------------															
	@param :[long]   chargeType				 //0：只先择子节点；1：所有节点都可以选择；
---------------------------------------------------------------------------------------------------------	
	@param :[String] strObjName      		//节点返回名称-->对象名称
---------------------------------------------------------------------------------------------------------	
	@param :[String] strObjId   				//节点返回ID-->对象名称		
---------------------------------------------------------------------------------------------------------	
	@param :[String] clearObjStr       //清除对象方法：传入相应的清除对象组合串；	
---------------------------------------------------------------------------------------------------------															
--------------------------------------**************选择树***************--------------------------------------															
---------------------------------------------------------------------------------------------------------															

内部传入参数：
  
	String strFormObj 				//forms -->对象名称
	String strObjNum 					//节点返回NUM-->对象名称
	long 	 resourceDeptId			//资源机构Id 	
	String treeRoot 					//根节点ID-->对象名称  													
	
	String resourceName				//当前节点资源名称[只对项目资源树有效]
	String canUseNum				  //可分配数目及单位[只对项目资源树有效]
	String projectStatus	    //-1，显示所有项目；1，只显示有效项目[只对项目资源树有效]
	String projectType	      //-1，显示所有项目；救助项目(0，只显示法定项目；1，只显示非法定项目;)
															 2，显示救助定义为->救助活动；3,显示所有的“救助项目”和“救助活动”[只对项目资源树有效]
	
	long 	 showType						//0,不显示；1，显示'checkbox'对象;
	String showObj						//返回选择的Id值内容串[只针对showType这个参数有效]
	String showObjValue       //返回选择的值内容串[只针对showType这个参数有效]
	String callObjName 				//1：发布公告
		
	String projectName 			 //用于预警：返回项目名称	
	String resourceNameStr 	 //用于预警：返回资源名称串
	String strNum 					 //用于预警：返回编码串
	
**/
	
%>	