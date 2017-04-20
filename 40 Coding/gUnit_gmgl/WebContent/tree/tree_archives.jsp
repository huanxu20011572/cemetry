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
  <title>ϵͳѡ����</title>

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
	alert("ϵͳ��ʾ����ǰû��ѡ�ж���������ѡ��");	
	
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
	 alert('ϵͳ��ʾ������չ����ǰ�ڵ�');
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
  font-family: "����","����";
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
  <div dojoType="TreeNode" title="ѡ�����<a href='javascript:getSelect()'>[ȷ�����]</a><a href='javascript:clearSelect()'>[ȡ�����]</a>" widgetId="root" objectId="<%=regionId%>,105,<c:out value='${param.treeType}' />" userId="<%=userId%>" isFolder="true" childIconSrc="images/comm.gif" expandLevel="1"/>
  
</form>  
</body>
</html>

	
<%

/**
�ⲿ�������˵����
	
	@param :[String]treeRootName 			  //���ڵ�����--->��������
---------------------------------------------------------------------------------------------------------	
	@param :[String]strFormName 				//form����-->��������strFormName
---------------------------------------------------------------------------------------------------------	
	@param :[String]rootObjName 				//���ڵ�ID-->��������
---------------------------------------------------------------------------------------------------------	
  @param :[String]objectId           //���ڵ�Str
                                       ��ʽ���ڵ�ֵ,�ڵ�����
                              
---------------------------------------------------------------------------------------------------------	
	@param :[long]treeType 	  //101��FROM"�����ֵ�"(�ݹ�)����ʾ�¼��ֵ�
	                            102��FROM"�����ֵ�"(���ݹ�)����ʾ�¼��ֵ�
	                            
														  201��FROM"��֯����"(�ݹ�)��
														  202, FROM"��֯����"(���ݹ�)�� 														  
														  203��FROM"��֯����"����ʾ�����Ŀ;
														  204��FROM"��֯����"(�ݹ�)�� ����ʾ��ص���Ŀ��ͬʱ��ʾ�¼���Ա��
														  205��FROM"��֯����"(���ݹ�)������ʾ��ص���Ŀ��ͬʱ��ʾ�¼���Ա��
														  206, FROM"��֯����ID"����ʾ�¼���Ա��
														  207��FROM"��֯����ID"�����ڡ�����������������ʵʩ���������������û���
														  208��FROM"��֯����ID"�����ڡ���Ŀά�������������м������ع�����Ա�û���
														  209��FROM"��֯����ID"�����ڡ������շ�����������
														  210��FROM"��֯����ID"�����ڡ������շ������¼���
														  211��FROM"��֯����ID"�����ڡ������շ������������¼���
														  
															301, FROM"��Ŀ��",ֻ��ʾ��Ŀ����ͨ������ID��
															
															401��FROM"��Ŀ��Դ"������ʾ��Ŀ����ʾ��ǰ��Ŀ�����е���Դ��Ϣ
															
															501, FROM"��ɫ��Ϣ"����ʾ��ǰ�ڵ������еĽ�ɫ
															
															601, FROM"��������"��ֻ��ʾ��һ���������ڡ����롱������������ά������
															
															601, FROM"��������"��ֻ��ʾ��һ���������ڡ����롱������������ά������
															
															602, FROM"��������"��������ʾ�ʼ��顢�������û������ڡ��ʼ������䡱��
															
															602, FROM"��������"��������ʾ�������û������ڡ����ʼ����顱��
																														
---------------------------------------------------------------------------------------------------------															
	@param :[long]   chargeType				 //0��ֻ�����ӽڵ㣻1�����нڵ㶼����ѡ��
---------------------------------------------------------------------------------------------------------	
	@param :[String] strObjName      		//�ڵ㷵������-->��������
---------------------------------------------------------------------------------------------------------	
	@param :[String] strObjId   				//�ڵ㷵��ID-->��������		
---------------------------------------------------------------------------------------------------------	
	@param :[String] clearObjStr       //������󷽷���������Ӧ�����������ϴ���	
---------------------------------------------------------------------------------------------------------															
--------------------------------------**************ѡ����***************--------------------------------------															
---------------------------------------------------------------------------------------------------------															

�ڲ����������
  
	String strFormObj 				//forms -->��������
	String strObjNum 					//�ڵ㷵��NUM-->��������
	long 	 resourceDeptId			//��Դ����Id 	
	String treeRoot 					//���ڵ�ID-->��������  													
	
	String resourceName				//��ǰ�ڵ���Դ����[ֻ����Ŀ��Դ����Ч]
	String canUseNum				  //�ɷ�����Ŀ����λ[ֻ����Ŀ��Դ����Ч]
	String projectStatus	    //-1����ʾ������Ŀ��1��ֻ��ʾ��Ч��Ŀ[ֻ����Ŀ��Դ����Ч]
	String projectType	      //-1����ʾ������Ŀ��������Ŀ(0��ֻ��ʾ������Ŀ��1��ֻ��ʾ�Ƿ�����Ŀ;)
															 2����ʾ��������Ϊ->�������3,��ʾ���еġ�������Ŀ���͡��������[ֻ����Ŀ��Դ����Ч]
	
	long 	 showType						//0,����ʾ��1����ʾ'checkbox'����;
	String showObj						//����ѡ���Idֵ���ݴ�[ֻ���showType���������Ч]
	String showObjValue       //����ѡ���ֵ���ݴ�[ֻ���showType���������Ч]
	String callObjName 				//1����������
		
	String projectName 			 //����Ԥ����������Ŀ����	
	String resourceNameStr 	 //����Ԥ����������Դ���ƴ�
	String strNum 					 //����Ԥ�������ر��봮
	
**/
	
%>	