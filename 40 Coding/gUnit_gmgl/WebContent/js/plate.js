
/**
* desc :   ϵͳ����
* @param: objFormName  ��ǰForm������
**/
function toSubSystem(objFormName){
 var strForm = document[objFormName];
 var strUrl = "plate_navigation.jsp";
 
 strForm.action = strUrl;
 strForm.target = "mainFrame";
 strForm.submit();
}


/**
desc: �޸�����
**/

function toUpdatePassword(flag){
	var strUrl = "";
	if(flag==1){
			strUrl = "../../main/system/user_mgm/user_password_update.jsp";
	}else{
		
		strUrl="../../main/fws_manage/fwsSqUserLogin.do?method=loginSqSprvUser&id="+flag;
	}

	CreateBuildBlankWindow(strUrl, 300,500);
	
}

/**
desc: ������һҳ
**/
function toBack(){
	window.history.go(-1); 	
}

/**
desc: �˳�
**/
function toExit(existFlag){
 if(confirm("�˳�ǰ���ȱ��湤������ȷ��Ҫ�˳�ϵͳ��")){
		var strUrl = "logout.jsp?existFlag=" + existFlag;						
		parent.window.location.href = strUrl;
	}
	
}