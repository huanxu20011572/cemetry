
/**
########################����������������ʹ�ýű�########################################
create_user:	lxr
create_date:	20100802
**/


/**
desc: 	������[ѡ����]��ֻ��ʾ��һ���ӽڵ�[���ݹ�]���������ı�����
@param: treeRootValue	���ڵ�����
@param: treeRootId		���ڵ�ID
@param: objFormName		��ǰ����Form������
@param: objIdName			��ǰ�����ID����
@param: objValueName	��ǰ�����Value����
@param: clearObjStr		��ǰ������������
[�磺����'communityId,communityName'��
		 ��ѡ����ʱ��ϵͳ��Ե�ǰҳ���е�"communityId"��"communityName"��"value"�������]
return: �������ڵ��ID,VALUE
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
desc: 	������[ѡ����]��ֻ��ʾ��һ���ӽڵ�[���ݹ�]
@param: treeRootValue	���ڵ�����
@param: treeRootId		���ڵ�ID
@param: objFormName		��ǰ����Form������
@param: objIdName			��ǰ�����ID����
@param: objValueName	��ǰ�����Value����
@param: clearObjStr		��ǰ������������
[�磺����'communityId,communityName'��
		 ��ѡ����ʱ��ϵͳ��Ե�ǰҳ���е�"communityId"��"communityName"��"value"�������]
return: �������ڵ��ID,VALUE
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
desc: 	������[ѡ����]��ֻ��ʾ��һ���ӽڵ�[���ݹ�][��ʾ����ȫ��]
@param: treeRootValue	���ڵ�����
@param: treeRootId		���ڵ�ID
@param: objFormName		��ǰ����Form������
@param: objIdName			��ǰ�����ID����
@param: objValueName	��ǰ�����Value����
@param: clearObjStr		��ǰ������������
[�磺����'communityId,communityName'��
		 ��ѡ����ʱ��ϵͳ��Ե�ǰҳ���е�"communityId"��"communityName"��"value"�������]
return: �������ڵ��ID,VALUE
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
desc: 	������[ѡ����]��ֻ��ʾ��һ���ӽڵ�[���ݹ�][��ʾ�������][��ѡ]
@param: treeRootValue	���ڵ�����
@param: treeRootId		���ڵ�ID
@param: objFormName		��ǰ����Form������
@param: objIdName			��ǰ�����ID����
@param: objValueName	��ǰ�����Value����
@param: clearObjStr		��ǰ������������
[�磺����'communityId,communityName'��
		 ��ѡ����ʱ��ϵͳ��Ե�ǰҳ���е�"communityId"��"communityName"��"value"�������]
return: �������ڵ��ID,VALUE
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
desc: 	������[ѡ����]��ֻ��ʾ��һ���ӽڵ�[���ݹ�][��ʾ�������][��ѡ]
@param: treeRootValue	���ڵ�����
@param: treeRootId		���ڵ�ID
@param: objFormName		��ǰ����Form������
@param: objIdName			��ǰ�����ID����
@param: objValueName	��ǰ�����Value����
@param: selectIdStr   ��ǰ�������ѡ�е�ID��ֵ���� "1,2"
@param: clearObjStr		��ǰ������������
[�磺����'communityId,communityName'��
		 ��ѡ����ʱ��ϵͳ��Ե�ǰҳ���е�"communityId"��"communityName"��"value"�������]
return: �������ڵ��ID,VALUE
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
desc: 	������[ѡ����]��ֻ��ʾ��һ���ӽڵ�[���ݹ�][��ʾ�������][��ѡ][֧�ֹ���������ʾ]
@param: treeRootValue	���ڵ�����
@param: treeRootId		���ڵ�ID
@param: objFormName		��ǰ����Form������
@param: objIdName			��ǰ�����ID����
@param: objValueName	��ǰ�����Value����
@param: selectIdStr   ��ǰ�������ѡ�е�ID��ֵ���� "1,2"
@param: filterIdStr   ��ǰ�������Ҫ���˵�ID��ֵ���� "3,5"
@param: filterFlag    ��ǰ����Ĺ��˱�ʶ��
                      1����filterIdStrֵ����Ӧ�Ľڵ���б�Ҳ���������filterIdStrֵ��Χ�ڣ�Ϊ��ѡ�ڵ㡣
                      2����filterIdStrֵ����ӦfilterIdStrֵ�Ľڵ㣬��ѡ��������ҡ�
@param: clearObjStr		��ǰ������������
[�磺����'communityId,communityName'��
		 ��ѡ����ʱ��ϵͳ��Ե�ǰҳ���е�"communityId"��"communityName"��"value"�������]
return: �������ڵ��ID,VALUE
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
desc: 	�ʼ��û���[ѡ����]����ʾ��һ���ӽڵ�[�ݹ�][��ѡ]
@param: treeRootValue	���ڵ�����
@param: objFormName		��ǰ����Form������
@param: objIdName			��ǰ�����ID����
@param: objValueName	��ǰ�����Value����
@param: selectIdStr   ��ǰ�������ѡ�е�ID��ֵ���� "1,2"
@param: clearObjStr		��ǰ������������
[�磺����'communityId,communityName'��
		 ��ѡ����ʱ��ϵͳ��Ե�ǰҳ���е�"communityId"��"communityName"��"value"�������]
return: �������ڵ��ID,VALUE
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
desc: 	�ʼ����û���[ѡ����]����ʾ��һ���ӽڵ�[���ݹ�][��ѡ]
@param: treeRootValue	���ڵ�����
@param: objFormName		��ǰ����Form������
@param: objIdName			��ǰ�����ID����
@param: objValueName	��ǰ�����Value����
@param: selectIdStr   ��ǰ�������ѡ�е�ID��ֵ���� "1,2"
@param: clearObjStr		��ǰ������������
[�磺����'communityId,communityName'��
		 ��ѡ����ʱ��ϵͳ��Ե�ǰҳ���е�"communityId"��"communityName"��"value"�������]
return: �������ڵ��ID,VALUE
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