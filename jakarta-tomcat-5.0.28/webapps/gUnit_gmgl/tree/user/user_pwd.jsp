<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<%@ taglib uri="/WEB-INF/tld/gTaglib-gOS.tld" prefix="gOS" %>
<%@ taglib uri="/WEB-INF/tld/gTaglib-shjz.tld" prefix="gOS_shjz" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/gTaglib-shjz.tld" prefix="shjz" %>
<%@ taglib uri="/WEB-INF/tld/gTaglib-shjz.tld" prefix="gUnit_shjz" %>
<%@ taglib uri="/WEB-INF/tld/gTaglib-mjzz.tld" prefix="gEU_mjzz" %>
<%@ taglib uri="html-el" prefix="html-el" %>



<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<meta http-equiv="Cache-Control" content="no-store"/>
<meta http-equiv="Pragma" content="no-cache"/>
<meta http-equiv="Expires" content="0"/>

<link href="/ajjwork/css/css.css" rel="stylesheet" type="text/css">

<script src="/ajjwork/script/action.js" language="JScript"></script>
<script src="/ajjwork/script/toolbar-ie5.js" language="JScript"></script>
<link href="/ajjwork/script/toolbar-ie5.css" type="text/css" rel="stylesheet">
<xml id="xsl" src="/ajjwork/script/toolbar-ie5.xsl"></xml>
<script src="/ajjwork/script/ua.js"></script>
<script src="/ajjwork/script/function.js"></script>
<script src="/ajjwork/script/publics.js"></script>
<script src="/ajjwork/script/page.js"></script>
<script type="text/javascript" src="/ajjwork/script/jquery.js"></script>
<script type="text/javascript" src="/ajjwork/script/linkageSelect.js"></script>
<script type="text/javascript" src="/ajjwork/script/location.js"></script>	
<%@page import="com.topsuntech.gOS.user.session.*" %>
<%@page import="com.topsuntech.gOS.user.en.user.*" %>
<%
	User user = UserSession.getUser(request);
	
	String thisloginId = user.getLoginid();		
				
%>
</head>

<script language="JavaScript" src="/ajjwork/script/hints.js"></script>
<!-- Link Tigra Hints configuration file to your HTML document-->
<script language="JavaScript" src="/ajjwork/script/hints_cfg.js"></script>
<script language="javascript">

	
	//查询
	function doQuery(){
		var strForm = document.myform;	
		
		strForm.action= "/ajjwork/tree/updateUserPasswordAll.do?doMethod=queryUserPwd";
		strForm.submit();
		
	}
	
	//新增
	function doAdd(){
		var strForm = document.myform;
		var strUrl = "/ajjwork/main/system/user_mgm/userAdd.do?action=showAdd&inputPath=allList";
		
		strForm.action= strUrl;
		strForm.submit();
		
		
	}	
	
	//修改用户信息
	function doEditUser(userId){
		
		var strForm = document.myform;
		var strBuild = "toolbar=no,width=800,height=500,directories=no,status=no,scrollbars=yes,resize=no,menubar=no";
		//var strUrl = "/ajjwork/main/system/user_mgm/userUpdate.do?action=showUpdate&id=" + userId;
		var strUrl = "/ajjwork/main/system/user_mgm/showUser.do?doMethod=show&idyProcessService=userManager&id=" + userId+"&inputPath=allList";
		
		//window.open(strUrl,'','');
				
		strForm.action= strUrl;
		strForm.submit();
		
		//CreateWindow(strUrl, "treeWin", strBuild);
		
	}	
	
	//删除用户
	function doDeleteUser(userId){
		var strForm = document.myform;		
		var strUrl = "/ajjwork/main/system/user_mgm/userDelete.do?action=deleteConfirm&id=" + userId+"&inputPath=allList";
						
		strForm.action= strUrl;
		strForm.submit();		
		
	}		
	
	//修改用户权限
	function doEditUserRight(userId){
		var strForm = document.myform;		
	  var strBuild = "toolbar=no,width=600,height=600,directories=no,status=no,scrollbars=yes,resize=no,menubar=no";
		var strUrl = "/ajjwork/main/system/user_mgm/userChoose.do?action=actorChoose&userId=" + userId;
						
		CreateWindow(strUrl, "treeWin", strBuild);		
		
	}		
	
	//修改用户权限通过角色
	function doEditUserRightByRole(userId){
		var strForm = document.myform;		
		
	  var strBuild = "toolbar=no,width=800,height=400,directories=no,status=no,scrollbars=yes,resize=no,menubar=no";
		var strUrl = "toUserRoleList.do?method=list&userId=" + userId;
	  
		CreateBuildBlankWindow(strUrl, 600, 800);		
		
	}			
	

		
	//编辑扩展信息--邮件用户名,邮件密码等
	function doUpdateUserEamil(userId){
		var strForm = document.myform;		
		var strUrl = "../tree/showUserEmail.do?method=userEmail&userId=" + userId;
		
    CreateBuildBlankWindowuse(strUrl, 60, 350);		
    
	}			
	
	
	
</script>
<script type="text/javascript">
$(function() {
var url='../main/system/dict_mgm/dynamicSelect.do?action=findNodes&'+new Date().getTime();
var region=$("#quId");
var childer=$("#streetId");
  region.bind("change", function(){
		var childVal=$(this).val();
		if(childVal=='' || childVal.length<1){		
		 return;
		}
	url='../main/system/dict_mgm/dynamicSelect.do?action=findChilderNodes&parentCode='+childVal+"&"+new Date().getTime();	
	childer.empty();
	childer.append('<option  value="">请选择</option>');
	 $.getJSON(url, function(data){
		$.each(data, function(i,item){
		 var option	= $('<option value="' + item.regionCode + '">' + item.name + '</option>');
			childer.append(option);
		  });
	  childer.attr('selectedIndex' , 0);	  
	});
	 	
});



})


function openTree(objForm,regionId,objId,objName) {
	/*
	var strUrl = "../public/select_email_address.jsp?userId=<c:out value="${sessionScope.loginUser.id}"/>&formName=form1&objId="+objId+"&objName="+objName;
	var strBuild = "toolbar=no,width=300,height=600,directories=no,status=no,scrollbars=yes,resize=no,menubar=no";
	CreateWindow(strUrl, "treeWin", strBuild);
	*/
	
	var strBuild = "toolbar=no,width=300,height=600,directories=no,status=no,scrollbars=yes,resize=no,menubar=no";
	var treeRootId = regionId;
	var treeType = "701";
	
	var strUrl = "../tree/select_dept_tree.jsp?objForm=" + objForm;
	    
	    strUrl += "&treeRootId=" + treeRootId; 	     
	    strUrl += "&objId=" + objId; 	     
			strUrl += "&objName=" + objName;
			strUrl += "&treeType=" + treeType;	
			
		
	CreateWindow(strUrl, "treeWin", strBuild);
	//window.open(strUrl, '','');
	
}


function checkproperty(){
    
    var strUrl = "../main/system/user_mgm/priority_choose.jsp"
    CreateBuildBlankWindow(strUrl,'600','250','yes');	
    
}
function cleara(){
var strform = document.myform;
var deptName=strform.dept;
deptName.value="";	
strform.deptid.value="";
 
}

function clearq(){
var strform = document.myform;
var quanxian=strform.quanxian;
quanxian.value="";	
strform.quanxianid.value="";
 
}
function choosePriorityRole() {
	if (checkSelected()) {
		var pForm = document.getElementById('myform');
		openWinNoToolbarAndSubmit('<c:url value="/main/system/user_mgm/showChoosePriorityRole.do?doMethod=showChoosePriorityRole"/>', 800, 600, pForm);		
	} else {
		window.alert("请选择用户！");
	}
}

function checkSelected() {
	var idDoms = document.getElementsByName("ids");
    for (var i = 0; i < idDoms.length;i++){
    	if(idDoms[i].checked){
    		 return true;
    	}
    }
    return false;
}

function checkAll(checkDomsName, checked){
	var checkDoms = document.getElementsByName(checkDomsName);
    for (var i = 0; i < checkDoms.length;i++){
    	checkDoms[i].checked = checked;
    }
}
	
</script>
<body>
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="11" background="../images/images_32.jpg"><img src="../images/content_left.gif" width="11" height="51"></td>
    <td height="51" background="../images/images_32.jpg">
    	<table width="70%" border="0" cellspacing="0" cellpadding="0">
	      <tr>
	        <td width="22" height="16" align="center"><img src="../images/d.gif" width="14" height="14"></td>
	        <td valign="bottom"> 当前位置：超级系统管理 → <b>查询密码</b></td>
	      </tr>	
    	</table>
    </td>
  </tr>
  <tr>
    <td background="../images/images_481.jpg">&nbsp;</td>
    <td valign="top">
	<table border="0" cellspacing="0" cellpadding="0" width="100%">
		
		<tr id="tag1">
			<td>
			<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td width="45" align="left" background="../images/images_49.jpg"><img src="../images/images_48.jpg" width="38" height="40"></td>
        <td background="../images/images_49.jpg" class="title"><strong>查询密码</strong></td>
        
        <td width="16" align="right" background="../images/images_49.jpg"></td>
      </tr>
    </table>
   
<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
<tr>
<td width="16" background="../images/images_55.jpg">&nbsp;</td>
<td align="center">

	<form id="myform" name="myform" method="post">
		
		<table width="100%" border="0" cellspacing="0" cellpadding="0">        
       
        <tr> 
          <td><table width="100%" border="0" cellpadding="1" cellspacing="1" bgcolor="a8d1eb">
              
										        	<tr height="22" > 
										        		<td  height="23" align="right" class="td-01">登录名称：</td>
					                      <td class="td-02"> 
					                      	<input class="input_txt" name="loginid" type="text"  value="<c:out value="${param.loginId}" />">
					                      	
					                      </td>  
												      	<td nowrap align="right" class="td-01" > 用户姓名：
												      	</td>
												      	<td class="td-02">
											          	<input class="input_txt" name="name" type="text" size="20"  value="<c:out value="${param.name}" />" >
													      </td>   
												       <td align="right" class="td-01"><a href="#" onClick="doQuery();"><img alt='查询' src='../images/but-serch.jpg ' border=nostyle='vertical-align:middle'></a>
									          </tr>	
												  				  
            </table></td>
        </tr>
        
		
      </table>
	
      <table width="100%" border="0" cellpadding="1" cellspacing="1" bgcolor="a8d1eb">
        <tr> 
        	<TD  width="4%" align="center" class="td-04">&nbsp;									        	
						        	
						     	</TD>
          <td width="4%" height="30" align="center" class="td-04">密码：</td>
          <td width="12%" align="center" class="td-04"><c:out value="${password}" /></td>
		
        </tr>

      </table>
               
			</form>
				 
			
		  </td>
          <td width="16" background="../images/images_57.jpg">&nbsp;</td>
        </tr>
        <tr>
          <td><img src="../images/images_72.jpg" width="16" height="17"></td>
          <td background="../images/images_73.jpg">&nbsp;</td>
          <td><img src="../images/images_75.jpg" width="16" height="17"></td>
        </tr>
      </table>
			</td>
		</tr>
	</table>
    </td>
  </tr>
</table>
</body>
</html>