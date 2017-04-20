<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib uri="http://www.topsuntech.com/jsptags/tree-taglib" prefix="topsuntech" %>
<%@ taglib uri="/WEB-INF/tld/gTaglib-gOS.tld" prefix="gOS" %>
<%@page import="com.topsuntech.gOS.user.session.*" %>
<%@page import="com.topsuntech.gOS.user.en.user.*" %>
<%@page import="com.topsuntech.gOS.user.en.office.Office" %>
<%@page import="com.topsuntech.gOS.config.user.userXuewei.dao.UserXueweiFactory" %>
<%@page import="com.topsuntech.gOS.config.user.userZhicheng.dao.UserZhichengFactory" %>
<%@page import="java.util.Collection" %>
<%
	String sDeptId=request.getParameter("sDeptId");
	String backurl="userSelect.do?";
	if(sDeptId==null||sDeptId.length()==0)
	{
	   backurl+="action=list";		   
	   sDeptId="";
	}else{
	   backurl+="action=listByDept&id=";
	   backurl+=sDeptId;
	}
	
%>
<%
	User user = UserSession.getUser(request);
	long creatorId = 2;
	String creatorName = "root";
	if (user!=null) {
		creatorId = user.getId().longValue();		
		creatorName = user.getName();
	}
	
	Office off = UserSession.getUserDept(request); 	
	long regionId = off.getRegionid();
%>

<html>
<head>
<title>修改密码</title>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">

<script src="../../../script/ua.js"></script>
<script src="../../../script/functionforcheck.js"></script>
<script src="../../../script/calendar.js"></script>
<script src="../../../script/publics.js"></script>
<script src="../../../script/common.js"></script>
<script type='text/javascript' src='../../../dwr/interface/checkPwd.js'></script>
<script type='text/javascript' src='../../../dwr/engine.js'></script>
<script type='text/javascript' src='../../../dwr/util.js'></script>




<script language="JavaScript">


function onSubmitP(){
	 myform.actionType.value="password";
	 var IsValid=true;
	 if(myform.oldpwd.value.length==0)
	 {
	 	document.all("oldpwdlbl").innerHTML="<font color=\"ff0000\">必须填写旧密码</font>";
	 	IsValid=false;
	 }
	 else
	 document.all("oldpwdlbl").innerHTML="";
	 if(myform.newpwdconfirm.value.length<3)
	 {
	 	document.all("pwdlbl").innerHTML="<font color=\"ff0000\">密码长度太短</font>";
	 	IsValid=false;
	 }
	 else
	 document.all("pwdlbl").innerHTML="";
	 if(myform.newpwdconfirm.value!=myform.password.value)
	 {
	 	document.all("cfmpwdlbl").innerHTML="<font color=\"ff0000\">密码不一致</font>";
	 	IsValid=false;
	 }
	 else
	 document.all("cfmpwdlbl").innerHTML="";
	 if(IsValid){
	 	
	 var ida=<%=user.getId()%>;
	var pwd=myform.oldpwd.value;
	  checkPwd.queryAjUserPwd(ida,pwd,function (result){
	  	
	  	if(!result){
	  		alert("您输入的旧密码不正确");
	  	}else{
		 		myform.action = "editMyPassword.do?method=updatePwd";
		 		myform.submit();
	  	}
		}); 
	 	
	 }
	 
}
function onSubmitPrio(){
	var prios=",";
	if(myform.prioritys.value!=""){
		prios=myform.prioritys.value;
	}
	windowWithoutToolbar('userChoose.do?action=actorChoose&prios='+prios,600, 500);	
}


function checkPwdss()
{  
	var ida=myform.id.value
	var pwd=myform.oldpwd.value;
  checkPwd.queryAjUserPwd(ida,pwd,function (result){
  	if(!result){
  	alert("您输入的旧密码不正确")
  	return ;
  	}
	}); 
   
}

</script>
<link href="../../../css/css.css" rel="stylesheet" type="text/css">
</head>

<body leftmargin="0" topmargin="0">
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="11" background="../../../images/images_32.jpg"><img src="../../../images/content_left.gif" width="11" height="51"></td>
    <td height="51" background="../../../images/images_32.jpg"><table width="70%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="22" height="16" align="center"><img src="../../../images/d.gif" width="14" height="14"></td>
          <td valign="bottom"> 当前位置：修改系统密码</td>
      </tr>
    </table>
    </td>
  </tr>
  <tr>
    <td background="../../../images/images_481.jpg">&nbsp;</td>
    <td valign="top">
 <TABLE width="100%" 
        border=0 cellPadding=1 cellSpacing=1  >
  <tr> 
       
    <td valign="top" class="td18"> 
      
      <form name="myform" method="post">
      	
      <input type="hidden" name="id" value="<c:out value="${user.id}"/>">      
      <input type="hidden" name="actionType" value="">
      <input type="hidden" name="sDeptId" value="<%=sDeptId%>">
      <input type="hidden" name="creatorid" value="<%=creatorId%>">
      <input type="hidden" name="creatorname" value="<%=creatorName%>">
      <input name="registstatus" type="hidden" value="2">
      
            <TABLE width="100%" 
        border=0 cellPadding=1 cellSpacing=1 bgcolor="a8d1eb" class=table_main>
          <tr> 
            <td width="45%" height="22" class=td-01>旧密码：</td>
            <td width="55%" height="22" class=td-02> 
              <input name="oldpwd" type="password" maxlength="15"   >&nbsp;<font color="#FF3333">*</font>
            <label id="oldpwdlbl" name="oldpwdlbl"></label>   <div id="serverResponse"></div>          </td>
        </tr>
          <tr> 
            <td height="22" class=td-01>新密码：</td>
            <td height="22" class=td-02> 
              <input name="password" type="password" maxlength="50">&nbsp;<font color="#FF3333">*</font>     
          <label id="pwdlbl" name="pwdlbl"></label>          </td>
        </tr>
          <tr> 
            <td height="23" class=td-01>新密码确认：</td>
            <td height="23" class=td-02> 
              <input name="newpwdconfirm" type="password" maxlength="50">&nbsp;<font color="#FF3333">*</font>
          <label id="cfmpwdlbl" name="cfmpwdlbl"></label>          </td>
        </tr>
      </table>  
      
      <table width="180" border="0" cellpadding="0" cellspacing="0" align="center">
             <br>
			  <tr >
                <td width="75" ><a href="javascript:onSubmitP();"><img src="../../../images/but-qd.gif" width="66" height="27" border="0" ></a></td>
				<td width="11" ></td>
                <td width="75" ><a href="javascript:window.close();"><img src="../../../images/but-colse.gif" width="66" height="27" border="0" ></a></td>                
                <td width="101" >&nbsp;</td>
              </tr>
            </table>    
      </form>    </td>
  </tr>
</table>
    </td>
  </tr>
</table>
</body>
</html>
