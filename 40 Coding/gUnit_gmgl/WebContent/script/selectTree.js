
/**
外部传入参数说明：
	
	@param :[String]treeRootName 			  //根节点名称--->对象名称
---------------------------------------------------------------------------------------------------------	
	@param :[String]strFormName 				//form名称-->对象名称strFormName
---------------------------------------------------------------------------------------------------------	
	@param :[String]rootObjName 				//根节点ID-->对象名称
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
  String salvageTypeId      //项目分类：医疗救助、教育救助等；如为null，则不过滤，显示所有；															 
	
	long 	 showType						//0,不显示；1，显示'checkbox'对象;
	String showObj						//返回选择的Id值内容串[只针对showType这个参数有效]
	String showObjValue       //返回选择的值内容串[只针对showType这个参数有效]
	String callObjName 				//1：发布公告
		
	String projectName 			 //用于预警：返回项目名称	
	String resourceNameStr 	 //用于预警：返回资源名称串
	String strNum 					 //用于预警：返回编码串
	
	String sysFlag						//用于从页面传入的系统参数
**/


function onSelectTree( 
          treeRootName,
          strFormName,
          rootObjName,
          treeType,
          chargeType,
          strObjId,
          strObjName,
          clearObjStr
          ){		
  var returnObjStr  = ","; 
  returnObjStr  += strObjId + "," + strObjName;     	

 
	onSelectTreeByObjStr( 
	          treeRootName,strFormName, rootObjName,
	          treeType,chargeType, null, returnObjStr,
	          clearObjStr,null
	          )
        	
}

/**描述：专用于“显示项目树”；
**/
function onSelectProjectTree( 
          treeRootName,
          strFormName,
          rootObjName,
          treeType,
          chargeType,
          strObjId,
          strObjName,
          salvageTypeId,
          clearObjStr          
          ){	
          	
  var returnObjStr  = ","; 
  returnObjStr  += strObjId + "," + strObjName;     	

	onSelectTreeByObjStr( 
	          treeRootName,strFormName, rootObjName,
	          treeType,chargeType, salvageTypeId, returnObjStr,
	          clearObjStr,null
	          )
}


/**描述：用于非db,zx,ls,hz项目显示树  added by jiangyi
**/
function onSelectProjectTreeByXT( 
          treeRootName,
          strFormName,
          rootObjName,
          treeType,
          chargeType,
          strObjId,
          strObjName,
          salvageTypeIdObj,
          clearObjStr,
          sysflagobj         
          ){	
          	
  var returnObjStr  = ","; 
  returnObjStr  += strObjId + "," + strObjName;     	

	var sysflag = document.all[sysflagobj].value;
	var salvageTypeId  =document.all[salvageTypeIdObj].value;

	onSelectTreeByObjStr( 
	          treeRootName,strFormName, rootObjName,
	          treeType,chargeType, salvageTypeId, returnObjStr,
	          clearObjStr,sysflag
	          )
}

/**描述：用于根据项目分类，救助分类，救助方式项目显示树  added by jiangyi
**/
function onSelectProjectTreeByJZFS( 
          treeRootName,
          strFormName,
          rootObjName,
          treeType,
          chargeType,
          strObjId,
          strObjName,
          salvageTypeIdObj,
          sendMoney,
          sysflagobj,
          sendType         
          ){	
          	
  var returnObjStr  = ","; 
  returnObjStr  += strObjId + "," + strObjName;     	

	var sysflag = document.all[sysflagobj].value;
	var salvageTypeId  =document.all[salvageTypeIdObj].value;
	var sendMoney =  document.all[sendMoney].value;
	var sendType =  document.all[sendType].value;
	onSelectTreeByJZFS( 
	          treeRootName,strFormName, rootObjName,
	          treeType,chargeType, salvageTypeId, returnObjStr,
	          sendMoney,sysflag,sendType
	          )
}
/**描述：用于根据项目分类，救助分类，救助方式项目显示树  added by jiangyi
**/
function onSelectTreeByJZFS( 
          treeRootName,
          strFormName,
          rootObjName,
          treeType,
          chargeType,
          salvageTypeId,
          returnObjStr,
          sendMoney,
          sysFlag,
          sendType
          ){	
              	
		var strForm = document[strFormName];
		var treeRoot  = strForm[rootObjName].value;
		var strUrl = "/shjz/main_bjsj/public/pubTree.jsp?strFormObj=" + strFormName;
		
		if(Jtrim(returnObjStr).length == 0){
			 alert('编码提示：请传入相应返回对象串值');
			 return ;
		}
		
		var spStr = returnObjStr.split(",");
		if(spStr.length == 1){
			strUrl += returnObjStr;
		}else{
			var sp = returnObjStr.split(",");
			for(var k=0; k < sp.length; k++){
				if(sp[3] == 1){
					if(k == 1)
					strUrl += "&showObj=" + sp[k] ;	
				  if(k == 2)			
				   strUrl += "&showObjValue=" + sp[k] ;					   
 					if(k == 3)			
			   		strUrl += "&showType=" + sp[k] ;		
			   					   
				}else{
					if(k == 1)
						strUrl += "&strObjId=" + sp[k] ;	
				  if(k == 2)			
				    strUrl += "&strObjName=" + sp[k] ;				
				}				
			}
		}

		if(Jtrim(treeRoot).length ==0 ){
			alert("请选择相应的上级节点值");
			return ; 
		}
		
		strUrl += "&treeRoot=" + treeRoot +"&treeRootName=" + treeRootName +"&treeType="+ treeType;
		strUrl += "&chargeType=" + chargeType ;
		
	
		if(salvageTypeId != null && Jtrim(salvageTypeId).length  > 0){
			strUrl += "&salvageTypeId=" + salvageTypeId ;
		}
		
		if(sysFlag != null && Jtrim(sysFlag).length  > 0){
			strUrl += "&sysFlag=" + sysFlag ;
		}		
		
		if(sendMoney != null)		
		  strUrl += "&sendMoney=" + sendMoney;
		  
		 if(sendType != null)		
		  strUrl += "&sendType=" + sendType;
		  
    //window.open(strUrl, '','');
		CreateBuildBlankWindow(strUrl,'600','300');		
}

//通用显示项目树
function onSelectTreeByObjStr( 
          treeRootName,
          strFormName,
          rootObjName,
          treeType,
          chargeType,
          salvageTypeId,
          returnObjStr,
          clearObjStr,
          sysFlag
          ){	
              	
		var strForm = document[strFormName];
		var treeRoot  = strForm[rootObjName].value;
		var strUrl = "/shjz/main_bjsj/public/pubTree.jsp?strFormObj=" + strFormName;
		
		if(Jtrim(returnObjStr).length == 0){
			 alert('编码提示：请传入相应返回对象串值');
			 return ;
		}
		
		var spStr = returnObjStr.split(",");
		if(spStr.length == 1){
			strUrl += returnObjStr;
		}else{
			var sp = returnObjStr.split(",");
			for(var k=0; k < sp.length; k++){
				if(sp[3] == 1){
					if(k == 1)
					strUrl += "&showObj=" + sp[k] ;	
				  if(k == 2)			
				   strUrl += "&showObjValue=" + sp[k] ;					   
 					if(k == 3)			
			   		strUrl += "&showType=" + sp[k] ;		
			   					   
				}else{
					if(k == 1)
						strUrl += "&strObjId=" + sp[k] ;	
				  if(k == 2)			
				    strUrl += "&strObjName=" + sp[k] ;				
				}				
			}
		}

		if(Jtrim(treeRoot).length ==0 ){
			alert("请选择相应的上级节点值");
			return ; 
		}
		
		strUrl += "&treeRoot=" + treeRoot +"&treeRootName=" + treeRootName +"&treeType="+ treeType;
		strUrl += "&chargeType=" + chargeType ;
		
	
		if(salvageTypeId != null && Jtrim(salvageTypeId).length  > 0){
			strUrl += "&salvageTypeId=" + salvageTypeId ;
		}
		
		if(sysFlag != null && Jtrim(sysFlag).length  > 0){
			strUrl += "&sysFlag=" + sysFlag ;
		}		
		
		if(clearObjStr != null)		
		  strUrl += "&clearObjStr=" + clearObjStr;
		  		   		
    //window.open(strUrl, '','');
		CreateBuildBlankWindow(strUrl,'600','300');		
}
	
//选择父树时，连动清除相应的值；	
function clearOtherSelect(strFormObj, clearObjStr){
	   var strForm  = document[strFormObj];
	   var objs = clearObjStr.split(",");
	   
	   for(var i =0; i <objs.length; i++)
	     strForm[objs[i]].value='';	   
}





//选择身份类别树
function selectCategorys(objForm,categoryIds,categoryName){

		
		var strUrl = "/shjz/main_bjsj/public/pubTree.jsp?strFormObj=" + objForm;
		var treeRoot = "2985";
		var treeRootName = "身份类别";		
			
		strUrl += "&treeRoot=" + treeRoot;
		strUrl += "&treeRootName="+treeRootName;
   	strUrl += "&showType=1" ;	
		strUrl += "&treeType=101";
		strUrl += "&chargeType=1" ;
		strUrl += "&showObj=" + categoryIds;	
	  strUrl += "&showObjValue=" + categoryName;		
				  		   		
    CreateBuildBlankWindow(strUrl,'600','300');		
		
}

//选择身份类别树：只限用于“申请”或“对象维护”中的成员信息修改
function selectCategorysForApply(objForm,categoryIds,categoryName){		
		var strUrl = "/shjz/main_bjsj/public/pubTree.jsp?strFormObj=" + objForm;
		var treeRoot = "2985";
		var treeRootName = "身份类别";		
		
			
		strUrl += "&treeRoot=" + treeRoot;
		strUrl += "&treeRootName="+treeRootName;
   	strUrl += "&showType=1" ;	
		strUrl += "&treeType=103";
		strUrl += "&chargeType=1" ;
		strUrl += "&showObj=" + categoryIds;	
	  strUrl += "&showObjValue=" + categoryName;		
	  strUrl += "&selectObjIdValue=" + document[objForm][categoryIds].value;		
				  		   		
    CreateBuildBlankWindow(strUrl,'600','300');		
		
}