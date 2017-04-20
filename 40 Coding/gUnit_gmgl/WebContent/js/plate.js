
/**
* desc :   系统导航
* @param: objFormName  当前Form的名字
**/
function toSubSystem(objFormName){
 var strForm = document[objFormName];
 var strUrl = "plate_navigation.jsp";
 
 strForm.action = strUrl;
 strForm.target = "mainFrame";
 strForm.submit();
}


/**
desc: 修改密码
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
desc: 返回上一页
**/
function toBack(){
	window.history.go(-1); 	
}

/**
desc: 退出
**/
function toExit(existFlag){
 if(confirm("退出前请先保存工作！您确定要退出系统？")){
		var strUrl = "logout.jsp?existFlag=" + existFlag;						
		parent.window.location.href = strUrl;
	}
	
}