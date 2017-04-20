
/**
########################无锡社区公共树的使用脚本########################################
create_user:	lxr
create_date:	20100802
**/


/**
desc: 	区域树[选择树]：只显示下一级子节点[不递归]海淀民生的报表用
@param: treeRootValue	根节点内容
@param: treeRootId		根节点ID
@param: objFormName		当前对象Form的名称
@param: objIdName			当前对象的ID名称
@param: objValueName	当前对象的Value名称
@param: clearObjStr		当前对象的清除对象串
[如：传入'communityId,communityName'，
		 在选择树时，系统会对当前页面中的"communityId"、"communityName"的"value"进行清除]
return: 返回树节点的ID,VALUE
**/

function selectRegionTreeReport(
	treeRootValue, 
	treeRootId,
	objFormName, 
	objIdName, 
	objValueName,
	clearObjStr){
  
	var strUrl = "../../gdTree/select_region_tree.jsp";	
		
	strUrl += "?treeRootValue=" + treeRootValue;
	strUrl += "&treeRootId=" + treeRootId;
	strUrl += "&objFormName=" + objFormName;
	strUrl += "&objIdName=" + objIdName;
	strUrl += "&objValueName=" + objValueName;
	if(clearObjStr != null && trim(clearObjStr).length > 0)
		strUrl += "&clearObjStr=" + clearObjStr;
	
	
	CreateBuildBlankWindow(strUrl, 500,200);
	
			
}

/**
desc: 	区域树[选择树]：只显示下一级子节点[不递归]
@param: treeRootValue	根节点内容
@param: treeRootId		根节点ID
@param: objFormName		当前对象Form的名称
@param: objIdName			当前对象的ID名称
@param: objValueName	当前对象的Value名称
@param: clearObjStr		当前对象的清除对象串
[如：传入'communityId,communityName'，
		 在选择树时，系统会对当前页面中的"communityId"、"communityName"的"value"进行清除]
return: 返回树节点的ID,VALUE
**/

function selectRegionTree(
	treeRootValue, 
	treeRootId,
	objFormName, 
	objIdName, 
	objValueName,
	clearObjStr){
	var strUrl = "../gdTree/select_region_tree.jsp";	
		
	strUrl += "?treeRootValue=" + treeRootValue;
	strUrl += "&treeRootId=" + treeRootId;
	strUrl += "&objFormName=" + objFormName;
	strUrl += "&objIdName=" + objIdName;
	strUrl += "&objValueName=" + objValueName;
	if(clearObjStr != null && trim(clearObjStr).length > 0)
		strUrl += "&clearObjStr=" + clearObjStr;
	
	
	CreateBuildBlankWindow(strUrl, 500,200);
	
			
}


/**
desc: 	机构树[选择树]：只显示下一级子节点[不递归][显示机构全称]
@param: treeRootValue	根节点内容
@param: treeRootId		根节点ID
@param: objFormName		当前对象Form的名称
@param: objIdName			当前对象的ID名称
@param: objValueName	当前对象的Value名称
@param: clearObjStr		当前对象的清除对象串
[如：传入'communityId,communityName'，
		 在选择树时，系统会对当前页面中的"communityId"、"communityName"的"value"进行清除]
return: 返回树节点的ID,VALUE
**/

function selectDeptTree(
	treeRootValue, 
	treeRootId,
	objFormName, 
	objIdName, 
	objValueName,
	clearObjStr){
	
	var strUrl = "../gdTree/select_dept_tree.jsp";	
		
	strUrl += "?treeRootValue=" + treeRootValue;
	strUrl += "&treeRootId=" + treeRootId;
	strUrl += "&objFormName=" + objFormName;
	strUrl += "&objIdName=" + objIdName;
	strUrl += "&objValueName=" + objValueName;
	if(clearObjStr != null && Jtrim(clearObjStr).length > 0)
		strUrl += "&clearObjStr=" + clearObjStr;
	
	
	CreateBuildBlankWindow(strUrl, 650,300);
	
			
}


/**
desc: 	机构树[选择树]：只显示下一级子节点[不递归][显示机构简称][单选]
@param: treeRootValue	根节点内容
@param: treeRootId		根节点ID
@param: objFormName		当前对象Form的名称
@param: objIdName			当前对象的ID名称
@param: objValueName	当前对象的Value名称
@param: clearObjStr		当前对象的清除对象串
[如：传入'communityId,communityName'，
		 在选择树时，系统会对当前页面中的"communityId"、"communityName"的"value"进行清除]
return: 返回树节点的ID,VALUE
**/

function selectDeptShortNameTree(
	treeRootValue, 
	treeRootId,
	objFormName, 
	objIdName, 
	objValueName,
	clearObjStr){
	
	var strUrl = "/hdjz/gdTree/select_dept_short_name_tree.jsp";	
		
	strUrl += "?treeRootValue=" + treeRootValue;
	strUrl += "&treeRootId=" + treeRootId;
	strUrl += "&objFormName=" + objFormName;
	strUrl += "&objIdName=" + objIdName;
	strUrl += "&objValueName=" + objValueName;
	if(clearObjStr != null && Jtrim(clearObjStr).length > 0)
		strUrl += "&clearObjStr=" + clearObjStr;
	
	
	CreateBuildBlankWindow(strUrl, 650,300);
	
			
}


/**
desc: 	机构树[选择树]：只显示下一级子节点[不递归][显示机构简称][多选]
@param: treeRootValue	根节点内容
@param: treeRootId		根节点ID
@param: objFormName		当前对象Form的名称
@param: objIdName			当前对象的ID名称
@param: objValueName	当前对象的Value名称
@param: selectIdStr   当前对象的已选中的ID串值，如 "1,2"
@param: clearObjStr		当前对象的清除对象串
[如：传入'communityId,communityName'，
		 在选择树时，系统会对当前页面中的"communityId"、"communityName"的"value"进行清除]
return: 返回树节点的ID,VALUE
**/

function selectDeptShortNameManyTree(
	treeRootValue, 
	treeRootId,
	objFormName, 
	objIdName, 
	objValueName,
	selectIdStr,
	clearObjStr){
	
	var strUrl = "/hdjz/gdTree/select_dept_short_name_many_tree.jsp";	
		
	strUrl += "?treeRootValue=" + treeRootValue;
	strUrl += "&treeRootId=" + treeRootId;
	strUrl += "&objFormName=" + objFormName;
	strUrl += "&objIdName=" + objIdName;
	strUrl += "&objValueName=" + objValueName;
	strUrl += "&selectIdStr=" + selectIdStr;
	if(clearObjStr != null && Jtrim(clearObjStr).length > 0)
		strUrl += "&clearObjStr=" + clearObjStr;
	
	
	CreateBuildBlankWindow(strUrl, 650,300);
	
			
}



/**
desc: 	机构树[选择树]：只显示下一级子节点[不递归][显示机构简称][多选][支持过滤条件显示]
@param: treeRootValue	根节点内容
@param: treeRootId		根节点ID
@param: objFormName		当前对象Form的名称
@param: objIdName			当前对象的ID名称
@param: objValueName	当前对象的Value名称
@param: selectIdStr   当前对象的已选中的ID串值，如 "1,2"
@param: filterIdStr   当前对象的需要过滤的ID串值，如 "3,5"
@param: filterFlag    当前对象的过滤标识。
                      1，按filterIdStr值对相应的节点进行变灰操作，不在filterIdStr值范围内，为可选节点。
                      2，按filterIdStr值，对应filterIdStr值的节点，可选，其它变灰。
@param: clearObjStr		当前对象的清除对象串
[如：传入'communityId,communityName'，
		 在选择树时，系统会对当前页面中的"communityId"、"communityName"的"value"进行清除]
return: 返回树节点的ID,VALUE
**/

function selectDeptShortNameManyTreeByFilterIds(
	treeRootValue, 
	treeRootId,
	objFormName, 
	objIdName, 
	objValueName,
	selectIdStr,
	filterIdStr,
	filterFlag,
	clearObjStr){
	
	var strUrl = "/hdjz/gdTree/select_dept_short_name_many_filter_tree.jsp";	
		
	strUrl += "?treeRootValue=" + treeRootValue;
	strUrl += "&treeRootId=" + treeRootId;
	strUrl += "&objFormName=" + objFormName;
	strUrl += "&objIdName=" + objIdName;
	strUrl += "&objValueName=" + objValueName;
	strUrl += "&selectIdStr=" + selectIdStr;
	strUrl += "&filterIdStr=" + filterIdStr;
	strUrl += "&filterFlag=" + filterFlag;
	

	if(clearObjStr != null && Jtrim(clearObjStr).length > 0)
		strUrl += "&clearObjStr=" + clearObjStr;
	
	
	CreateBuildBlankWindow(strUrl, 650,300);
	
			
}



/**
desc: 	邮件用户树[选择树]：显示下一级子节点[递归][多选]
@param: treeRootValue	根节点内容
@param: objFormName		当前对象Form的名称
@param: objIdName			当前对象的ID名称
@param: objValueName	当前对象的Value名称
@param: selectIdStr   当前对象的已选中的ID串值，如 "1,2"
@param: clearObjStr		当前对象的清除对象串
[如：传入'communityId,communityName'，
		 在选择树时，系统会对当前页面中的"communityId"、"communityName"的"value"进行清除]
return: 返回树节点的ID,VALUE
**/

function selectEmailUserTree(
	treeRootValue, 
	objFormName, 
	objIdName, 
	objValueName,
	selectIdStr,
	clearObjStr){
	
	var strUrl = "/hdjz/gdTree/select_email_user_select_tree.jsp";	
		
	strUrl += "?treeRootValue=" + treeRootValue;
	strUrl += "&gdTreeType=50" ;	
	strUrl += "&treeRootId=41" ;		
	strUrl += "&objFormName=" + objFormName;
	strUrl += "&objIdName=" + objIdName;
	strUrl += "&objValueName=" + objValueName;
	strUrl += "&selectIdStr=" + selectIdStr;
	if(clearObjStr != null && Jtrim(clearObjStr).length > 0)
		strUrl += "&clearObjStr=" + clearObjStr;
	
	
	CreateBuildBlankWindow(strUrl, 650,300);
	
			
}

/**
desc: 	邮件组用户树[选择树]：显示下一级子节点[不递归][多选]
@param: treeRootValue	根节点内容
@param: objFormName		当前对象Form的名称
@param: objIdName			当前对象的ID名称
@param: objValueName	当前对象的Value名称
@param: selectIdStr   当前对象的已选中的ID串值，如 "1,2"
@param: clearObjStr		当前对象的清除对象串
[如：传入'communityId,communityName'，
		 在选择树时，系统会对当前页面中的"communityId"、"communityName"的"value"进行清除]
return: 返回树节点的ID,VALUE
**/

function selectEmailGroupUserTree(
	objFormName, 
	objIdName, 
	objValueName,
	selectIdStr,
	clearObjStr){
	
	var strUrl = "/hdjz/gdTree/select_email_group_tree.jsp";	
		
	strUrl += "?treeRootValue=0";
	strUrl += "&gdTreeType=51" ;	
	strUrl += "&treeRootId=0" ;	
	strUrl += "&objFormName=" + objFormName;
	strUrl += "&objIdName=" + objIdName;
	strUrl += "&objValueName=" + objValueName;
	strUrl += "&selectIdStr=" + selectIdStr;
	if(clearObjStr != null && Jtrim(clearObjStr).length > 0)
		strUrl += "&clearObjStr=" + clearObjStr;
	
	
	CreateBuildBlankWindow(strUrl, 650,300);
	
			
}