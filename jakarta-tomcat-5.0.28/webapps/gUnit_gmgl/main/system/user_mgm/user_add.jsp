<%@ page contentType="text/html; charset=GBK" %>
<%@ include file="../../../common/taglibs.jsp"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="http://www.topsuntech.com/jsptags/tree-taglib" prefix="topsuntech" %>
<%@page import="com.topsuntech.gOS.user.session.*" %>
<%@page import="com.topsuntech.gOS.user.en.user.*" %>
<%@page import="com.topsuntech.gOS.user.en.office.Office" %>
<%@page import="com.topsuntech.gOS.config.user.userXuewei.dao.UserXueweiFactory" %>
<%@page import="com.topsuntech.gOS.config.user.userZhicheng.dao.UserZhichengFactory" %>
<%@page import="java.util.Collection" %>

<% 
	request.setCharacterEncoding("GBK");	
   	String backurl="userSelect.do?";
   	String addDeptId=request.getParameter("addDeptId"); 
   	if(addDeptId==null)
   	addDeptId="";   	
        if(addDeptId=="")
        	backurl+="action=list";
        else
       	{	backurl+="action=listByDept&id=";
        	backurl+=addDeptId;
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
<title>Untitled Document</title>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<link href="../../css/css.css" rel="stylesheet" type="text/css">

<script src="../../../script/ua.js"></script>
<script src="../../../script/functionforcheck.js"></script>
<script src="../../../script/common.js"></script>

<script language="JavaScript" src="../../../script/publics.js"></script>
<script language="JavaScript" src="../../../lib/function.js"></script>
<script language="JavaScript" src="../../../script/calendar.js"></script>
<script type='text/javascript' src='../../../dwr/interface/checkLognid.js'></script>
<script type='text/javascript' src='../../../dwr/engine.js'></script>
<script type='text/javascript' src='../../../dwr/util.js'></script>

<script language="JavaScript">
	function checkNumbers(inputElement){
		var str = inputElement.value;
		var inputCode = event.keyCode;		
		if(!(inputCode>47 && inputCode<58)){
			event.returnValue=false;
		}
	}	

function selectOffice(callback, idStr){
	<c:if test="${param.inputPath eq 'allList'}">
		var type = 1;
	</c:if>
	<c:if test="${param.inputPath eq 'subUsers'}">
		var type = 2;
	</c:if>
	var url = "<c:url value="/tree/office_choose.jsp?type="/>" + type;
	url += ("&callback=" + callback + "&idStr=" + idStr );
	windowWithoutToolbar(url, 300, 600, true);
}
function setDept(win, id, name){
	document.getElementsByName('deptid')[0].value = id;
	document.getElementsByName('dept')[0].value = name;
	win.close();
}
function selectDept() {
	selectOffice("setDept", document.getElementsByName('deptid')[0].value);
}
function setWorkdept(win, id, name){
	document.getElementsByName('workdeptid')[0].value = id;
	document.getElementsByName('workdeptName')[0].value = name;
	win.close();
}
function selectWorkdept() {
	selectOffice("setWorkdept", document.getElementsByName('workdeptid')[0].value);
}

function removeAndAddErrInfo(isError, eleName, labName, info, errorEle){
	if(isError){
		document.all(labName).innerHTML = '<span style="font: 13px;color: red"> ' + info + '</span>';
		if(errorEle == null){
			return document.all(eleName);
		}
	}else{
		document.all(labName).innerHTML = '';
	}
	return errorEle;
}
function onSubmit() {	 
	 var IsValid=true;
	 var firstErrorEle = null;
	 firstErrorEle = removeAndAddErrInfo(!checkLoginid(myform.loginid.value), 'loginid', 'label0', '用户ID不正确', firstErrorEle);
	 firstErrorEle = removeAndAddErrInfo(myform.password.value.length<3, 'password', 'pwdlbl', '密码长度太短(大于等于3位)', firstErrorEle);
	 firstErrorEle = removeAndAddErrInfo(myform.cfmpwd.value!=myform.password.value, 'cfmpwd', 'cfmpwdlbl', '密码不一致', firstErrorEle);
	 firstErrorEle = removeAndAddErrInfo(!myform.deptid.value, 'dept', 'deptlbl', '请选择所在处室', firstErrorEle);
	 firstErrorEle = removeAndAddErrInfo(!myform.workdeptid.value, 'workdeptName', 'workdeptlbl', '请选择所属机构', firstErrorEle);
	 firstErrorEle = removeAndAddErrInfo(!myform.name.value, 'name', 'namelbl', '请填写姓名', firstErrorEle);
	 firstErrorEle = removeAndAddErrInfo(!checkLength(myform.memo.value, 0, 150), 'memo', 'deslbl', '用户描述过长（小于150字符）', firstErrorEle);
	 if(firstErrorEle == null){
	   	myform.submit();
	  }else{
	  	scroll(0, 0);
	  	firstErrorEle.focus();
	  }
	 /*
	 if(!checkLoginid(myform.loginid.value))
	 {
	 	document.all("label0").innerHTML='<span style="font: 14px;color: red">用户ID不正确</span>';
	 	if(firstErrorEle == null){
	 		firstErrorEle = document.all("loginid");
	 	}
	 	IsValid=false;
	 }else{
	 	document.all("label0").innerHTML="";
	 }
//		 if(myform.num.value.length<19)
//	 {
//	 	document.all("rybm").innerHTML='<span style="font: 14px;color: red">人员编码长度为19位</span>';
//	 	IsValid=false;
//	 }
//	 else
//	 document.all("rybm").innerHTML="";
	
	 if(myform.password.value.length<3)
	 {
	 	document.all("pwdlbl").innerHTML='<span style="font: 14px;color: red">密码长度太短</span>';
	 	if(firstErrorEle == null){
	 		firstErrorEle = document.all("password");
	 	}
	 	IsValid=false;
	 }
	 else
	 document.all("pwdlbl").innerHTML="";
	 if(myform.cfmpwd.value!=myform.password.value)
	 {
	 	document.all("cfmpwdlbl").innerHTML='<span style="font: 14px;color: red">密码不一致</span>';
	 	if(firstErrorEle == null){
	 		firstErrorEle = document.all("password");
	 	}
	 	IsValid=false;
	 }
	 else
	 document.all("cfmpwdlbl").innerHTML="";
	
	 if(myform.deptid.value==0)
	 {
	 	document.all("deptlbl").innerHTML='<span style="font: 14px;color: red">请选择所在处室</span>';
	 	if(firstErrorEle == null){
	 		firstErrorEle = document.all("deptid");
	 	}
	 	IsValid=false;
	 }
	 else
	 document.all("deptlbl").innerHTML="";
	 if(myform.workdeptid.value=="")
	 {
	 	document.all("workdeptlbl").innerHTML='<span style="font: 14px;color: red">请选择所属机构</span>';
	 	if(firstErrorEle == null){
	 		firstErrorEle = document.all("workdeptName");
	 	}
	 	IsValid=false;
	 }
	 else
	 document.all("workdeptlbl").innerHTML="";
	 if(myform.name.value=="")
	 {	
	 	document.all("namelbl").innerHTML='<span style="font: 14px;color: red">请填写姓名</span>';
	 	if(firstErrorEle == null){
	 		firstErrorEle = document.all("name");
	 	}
	 	IsValid=false;
	 }
	 else
	 document.all("namelbl").innerHTML="";
	 
	
	 if(!checkLength(myform.memo.value, 0, 150)){
		document.all("deslbl").innerHTML='<span style="font: 14px;color: red">用户描述过长（小于150字符）</span>';
		if(firstErrorEle == null){
	 		firstErrorEle = document.all("memo");
	 	}
		IsValid=false;
	 }
	 else 
	 document.all("deslbl").innerHTML="";
	 
	 if(myform.identitynum.value=="")
	 {	
	  //	document.all("namelbl").innerHTML='<span style="font: 14px;color: red">请填写身份证号码</span>';
	 	//IsValid=false;
	 }
	 else
	 document.all("namelbl").innerHTML="";
	 
	 if(IsValid){
	   myform.submit();
	  }else{
	  	firstErrorEle.focus();
	  	
	  }
	  */
}
function onSubmitPrio(){
	//var prios=",";
	//if(myform.prioritys.value!=""){
	//	prios=myform.prioritys.value;		
	//}
	//windowWithoutToolbar('userChoose.do?action=actorChoose&prios='+prios,600, 500);
	var pForm = document.getElementById('myform');
	<c:if test="${param.inputPath eq 'allList'}">
		openWinNoToolbarAndSubmit('<c:url value="/main/system/user_mgm/showChoosePriorityRole.do?doMethod=showChoosePriorityRole&fromOpener=true"/>', 800, 600, pForm);		
	</c:if>
	<c:if test="${param.inputPath eq 'subUsers'}">
		openWinNoToolbarAndSubmit('<c:url value="/main/system/user_mgm/showChoosePriorityRole.do?doMethod=showSubChoosePriorityRole&fromOpener=true"/>', 800, 600, pForm);		
	</c:if>
}

function checkloginida()
{  
	var loginid=myform.loginid.value
	
  checkLognid.checkUserLogid(loginid,function (result){
  	if(!result){
  	alert("您输入的登陆名已存在，请换一个登陆名");
  	
  	document.getElementById('loginid').select()
  	return ;
  	}
	}); 
   
}


</script>
</head>
<body>
	<form action="saveUser.do?doMethod=save&idyProcessService=userManager&inputPath=<c:out value='${param.inputPath}'/>" id="myform" name="myform" method="post" >

	<input type="hidden" name="creatorid" value="<%=creatorId%>">
	<input name="users" type="hidden" value="">
	<input name="emailid" type="hidden" value="">
	<input name="cansms" type="hidden" value="">
	<input name="registstatus" type="hidden" value="2">
	<input type="hidden" name="emailid" value="<c:out value="${user.emailid}"/>">
	<input type="hidden" name="parentid" value="">
	<input type="hidden" name="specifyDeptId" value="<%=addDeptId%>">
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="11" height="31" valign="top" class="td-bg"><img src="../../../images/right-1.jpg" /></td>
    <td align="center" valign="top" ><table width="100%" border="0" cellpadding="0" cellspacing="0" class="word-8">
      <tr>
        <td height="31" align="left" valign="middle" style="background:url(../../../images/right-3.jpg)"><img src="../../../images/right-4.jpg" width="9" height="8" align="absmiddle" /> 当前位置 &gt; 系统管理 &gt; 用户管理</td>
      </tr>
    </table>
	</td>
  </tr>
  <tr>
    <td >&nbsp;</td>
    <td valign="top">
	<table border="0" cellspacing="0" cellpadding="0" width="100%">
		<tr>
			<td>&nbsp;</td>
		</tr>		
	</table>
	<table border="0" cellspacing="0" cellpadding="0" width="100%">
		
		<tr id="tag1">
			<td>
			<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td width="45" align="left" background="../../../images/images_49.jpg"><img src="../../../images/images_48.jpg" width="38" height="40"></td>
                <td width="318" background="../../../images/images_49.jpg"><span class="title"> 创建新用户(<span class="text-red">*</span>为必填项)
                  </span></td>
                <td width="297" align="right" background="../../../images/images_49.jpg">创建人：<%=creatorName%> 　创建日期：<fmt:formatDate value="${user.createdate}" pattern="yyyy-MM-dd"/></td>
                <td width="16" align="right" background="../../../images/images_49.jpg"><img src="../../../images/images_52.jpg" width="16" height="40"></td>
      </tr>
    </table>
			<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td width="16" background="../../../images/images_55.jpg">&nbsp;</td>
          <td align="center"><table width="98%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td height="14">&nbsp;</td>
              </tr>
            </table>
                  <TABLE width="100%" 
        border=0 cellPadding=1 cellSpacing=1 bgcolor="a8d1eb" class=table_main>
                    <TBODY>
                      <TR>
                        <TD width="15%" height=30 align="right" class=td-01>用户ID<span class="text-red">*</span>：</TD>
                        <TD class=td-02 width="31%" height=22><input id='loginid' name="loginid" type="text" size="20" width="150" height="18" value="<c:out value="${user.loginid}"/>" maxlength="15" class="input" onblur="checkloginida()">
                            <LABEL id=label0 name="label0"></LABEL>
                         </TD>
                         <td width="16%" align="right" class=td-01>用户权限：</td>         
          	 <input type="hidden" id="priority" name="priority" value="" >
          	 <input type="hidden" id="systemRole" name="systemRole" value="" >
          <td width="38%" class=td-02>
          
          	<a href="javascript:onSubmitPrio();"><img src="../../../images/config/zoom_small.gif" width="13" height="13" border="0"></a> 
          	
          	<font color="#0000ff">单击前面的图标设置用户权限</font> 
          	</td>
                      <TR height=22>
                        <TD height=30 align="right" class=td-01>密码<span class="text-red">*</span>：</TD>
                        <TD class=td-02 height=22><input name="password" type="password" size="20" width="150" height="18" maxlength="15" class="input">
                            <LABEL id=pwdlbl 
            name="pwdlbl"></LABEL></TD>
                        <TD height=22 align="right" class=td-01>密码确认<span class="text-red">*</span>：</TD>
                        <TD class=td-02 vAlign=top height=22><input name="cfmpwd" type="password" size="20" width="150" height="18" maxlength="15" class="input">
                            <LABEL 
            id=cfmpwdlbl name="cfmpwdlbl"></LABEL></TD>
                      </TR>
                      <TR>
                      
                      <TD align="right" class=td-01>所属机构<span class="text-red">*</span>：</TD>
                       <td class=td-02 >
			            <input readonly name="workdeptName"  class="input" type="text" value="<c:out value="${user.workdept.name}"/>">
			            <input name="workdeptid" type="hidden" > 
			            <a href="javascript:" onClick="selectWorkdept();"><img src="../../../images/config/zoom_small.gif" width="13" height="13" border="0"></a> <font color="#0000ff">单击图标选择所属机构</font>
			            <label id="workdeptlbl" name="workdeptlbl"></label>
			          </td>
				          
                        <TD height=30 align="right" class=td-01>所在处室<span class="text-red">*</span>：</TD>
                        <%if(addDeptId==""){%>
				          <td height="22" class=td-02 ><input readonly name="dept" class="input" type="text" value="<c:out value="${user.deptname}"/>" >
				            <input name="deptid" type="hidden" > 
				            <a href="javascript:" onClick="selectDept();"><img src="../../../images/config/zoom_small.gif" width="13" height="13" border="0"></a> <font color="#0000ff">单击图标选择所在处室</font>
				            <%}else{
				             String thisdeptname=request.getParameter("addDeptname");             
				          %>
				          <td height="22" class=td-02 ><input readonly name="dept" type="text" value="<%=thisdeptname%>" >
				              <input name="deptid" type="hidden" value="<%=addDeptId%>">
				              <a href="javascript:windowWithoutToolbar('userChoose.do?action=officeChoose&inputBox=dept', 400, 600)"><img src="../../../images/config/zoom_small.gif" width="13" height="13" border="0"></a> <font color="#0000ff">单击图标选择所在处室</font>
				              <%}%>
				              <label id="deptlbl" name="deptlbl"></label>
				            </td>
                        
                      </TR>
                      <TR>
                        <TD height=30 align="right" class=td-01>姓名<span class="text-red">*</span>：</TD>
                        <TD class=td-02 height=22><input name="name" type="text" class="input"  value="<c:out value="${user.name}"/>" size="20" width="150" height="18" maxlength="15">
                            <LABEL id=namelbl name="namelbl"></LABEL></TD>
                        <TD align="right" class=td-01>性别：</TD>
                        <TD class=td-02><topsuntech:genderSelect>
              <c:out value="${user.gender}"/>
            </topsuntech:genderSelect>
                        </TD>
                      </TR>
                      <TR height=22>
                        <TD height=30 align="right" class=td-01>出生地：</TD>
                        <TD class=td-02 height=22><input name="birthlocation" type="text" value="<c:out value="${user.birthlocation}"/>" size="20" width="150" height="18" maxlength="50" class="input">
                        </TD>
                        <TD height=22 align="right" class=td-01></TD>
                        <TD class=td-02 vAlign=top height=22></TD>
                      </TR>
                      <TR>
                        <TD height=30 align="right" class=td-01>出生年月：</TD>
                        <TD class=td-02 height=22>
                             <input name="birthday" value="<c:out value="${param.date1}" />" readonly="true" type="text" class="input"  size="16" onClick="calendar()">
				              <input name="button2" type="button" class="input_clean" onClick="javascript:birthday.value='';" value="" TITLE="清空"/>
							
                        <TD align="right" class=td-01>民族：</TD>
                        <TD class=td-02><topsuntech:nationSelect>
              <c:out value="${user.nation}"/>
            </topsuntech:nationSelect>
                        </TD>
                      </TR>
                      <TR>
							             <TD height=30 align="right" class=td-01>学历：</TD>
							                        <TD class=td-02 height=22><%
							            	Collection list = UserXueweiFactory.getUserXueweiConfig().getUserXueweibyAll();
							                request.setAttribute("list", list);
							            %>
                                    <select id="xueli" name="xueli">
                                        <c:forEach var="xueli" items="${list}">
                                            <option value='<c:out value="${xueli.name}"/>' ><c:out value="${xueli.name}"/></option>                                                
                                        </c:forEach>
                                    </select>
							                        </TD>
							                        <td align="right" class=td-01>学位：</td>
							          <td class=td-02>
                                    <select id="xuewei" name="xueli">
                                        <c:forEach var="xueli" items="${list}">
                                            <option value='<c:out value="${xueli.name}"/>' ><c:out value="${xueli.name}"/></option>                                                
                                        </c:forEach>
                                    </select>
							              
							          </td>
                      </TR>
                      <TR>
                        <TD height=30 align="right" class=td-01>所学专业：</TD>
                        <TD class=td-02 height=22><input name="zhuanye" type="text" value="<c:out value="${user.zhuanye}"/>" size="20" width="150" height="18" maxlength="50" class="input"></TD>
                        <TD align="right" class=td-01>毕业院校及时间：</TD>
                        <TD class=td-02><input name="yuanxiao" type="text" value="<c:out value="${user.yuanxiao}"/>" size="20" width="150" height="18" maxlength="50" class="input"></TD>
                      </TR>
                      <TR>
                        <TD height=30 align="right" class=td-01>政治面貌：</TD>
                        <TD class=td-02 height=22><input name="zhengzhimianmao" type="text" value="党员" size="20" width="150" height="18" maxlength="15" class="input"></TD>
                        <TD align="right" class=td-01>入党/团时间：</TD>
                        <TD class=td-02>
            <input name="rudangshijian" value="<c:out value="${param.date1}" />" readonly="true" type="text" class="input"  size="16" onClick="calendar()">
				              <input name="button2" type="button" class="input_clean" onClick="javascript:rudangshijian.value='';" value=""/>
							
                           </TD>
                      </TR>
                      <TR>
                        <TD height=30 align="right" class=td-01>职称：</TD>
                        <TD class=td-02 height=22> <%
            	list = UserZhichengFactory.getUserZhichengConfig().getUserZhichengbyAll();
                request.setAttribute("list", list);
            %>
                            <select id="callname" name="callname">
                                <c:forEach var="xueli" items="${list}">
                                    <option value='<c:out value="${xueli.name}"/>' ><c:out value="${xueli.name}"/></option>                                                
                                </c:forEach>
                            </select>
             
                        </TD>
                        <TD align="right" class=td-01>职务：</TD>
                        <TD class=td-02><input name="positionid" value="<c:out value="${user.positionid}"/>" type="text" size="20" width="150" height="18" maxlength="50" class="input">
                        </TD>
                      </TR>
                      <TR>
                        <TD height=30 align="right" class=td-01>身份证号：</TD>
                        <TD class=td-02 height=22><input name="identitynum" type="text" value="<c:out value="${user.identitynum}"/>" size="20" width="150" height="18" maxlength="25" class="input"></TD>
                        <TD align="right" class=td-01>工作证号：</TD>
                        <TD class=td-02><input name="worknum" type="text" value="<c:out value="${user.worknum}"/>" size="20" width="150" height="18" maxlength="30" class="input"></TD>
                      </TR>
                      <TR>
                        <TD height=30 align="right" class=td-01>单位地址：</TD>
                        <TD class=td-02 height=22><input name="address" type="text" value="<c:out value="${user.address}"/>" size="20" width="150" height="18" maxlength="30" class="input"></TD>
                        <TD align="right" class=td-01>联系电话：</TD>
                        <TD class=td-02><input name="homephone" type="text" value="<c:out value="${user.homephone}"/>" size="20" width="150" height="18" maxlength="30" class="input"></TD>
                      </TR>
                      <TR>
                        <TD height=30 align="right" class=td-01>办公电话：</TD>
                        <TD class=td-02 height=22><input name="officephone" type="text" value="<c:out value="${user.officephone}"/>" size="20" width="150" height="18" maxlength="30" class="input"></TD>
                        <TD align="right" class=td-01>移动电话：</TD>
                        <TD class=td-02><input name="mobile" type="text" value="<c:out value="${user.mobile}"/>" size="20" width="150" height="18" maxlength="30" class="input"></TD>
                      </TR>
                      <TR>
                        <TD height=30 align="right" class=td-01>公积金号：</TD>
                        <TD class=td-02 height=22><input name="publicmoneynum" type="text" value="<c:out value="${user.publicmoneynum}"/>" size="20" width="150" height="18" maxlength="30" class="input"></TD>
                        <TD align="right" class=td-01>养老保险号：</TD>
                        <TD class=td-02><input name="oldsupportnum" type="text" value="<c:out value="${user.oldsupportnum}"/>" size="20" width="150" height="18" maxlength="30" class="input"></TD>
                      </TR>
                      <TR>
                        <TD height=30 align="right" class=td-01>住房补贴号：</TD>
                        <TD class=td-02 height=22><input name="housepaynum" type="text" value="<c:out value="${user.housepaynum}"/>" size="20" width="150" height="18" maxlength="30" class="input"></TD>
                        <TD align="right" class=td-01>医疗保险号：</TD>
                        <TD class=td-02><input name="securitynum" type="text" value="<c:out value="${user.securitynum}"/>" size="20" width="150" height="18" maxlength="30" class="input"></TD>
                      </TR>
                      <TR>
                        <TD height="30" align="right" class=td-01>籍贯：</TD>
                        <TD class=td-02><input name="jiguan" type="text" value="<c:out value="${user.jiguan}"/>" size="20" width="150" height="18" maxlength="15" class="input"></TD>
                        <TD height=22 align="right" class=td-01>参加工作时间：</TD>
                        <TD class=td-02 height=22>
            <input name="workyear" value="<c:out value="${param.date1}" />" readonly="true" type="text" class="input"  size="16" onClick="calendar()">
				              <input name="button2" type="button" class="input_clean" onClick="javascript:workyear.value='';" value=""/>
							
                        </TD>
                      </TR>
					   <tr> 
          <td class="td-01"  align="right">证书号：</td>
            <td class="td-02" colspan="3">
<input name="canumber" type="text" value="<c:out value="${user.canumber}" />" size="20" width="150" height="18" class="input"><font color="#FF0000">证书号用GWY开头加身份证号</font></td>
			</tr>
                      <TR>
                        <TD height=30 align="right" class=td-01>备注：
                        <LABEL id=deslbl 
          name="deslbl"></LABEL></TD>
                        <TD class=td-02 colSpan=3 height=22><textarea name="memo" height = "300" width = "300" rows=5 cols=60 id="textarea2" wrap="hard"><c:out value="${user.memo}"/></textarea></TD>
                      </TR>
					  
                    </TBODY>
                  </TABLE>
                  <table width="98%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td>&nbsp;</td>
                </tr>
				<tr>
			<td align="left"><table width="94%" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
                <td height="33">&nbsp;</td>
                <td align="center" valign="top"><a href="javascript:onSubmit();"><img src="../../../images/but-qd.gif" width="66" height="27" border="0" ></a>　<a href="javascript:history.go(-1);"><img src="../../../images/but0qx.jpg" width="66" height="27" border="0" ></a></td>
              </tr>
            </table></td>
		</tr>
            </table>
            </td>
          <td width="16" background="../../../images/images_57.jpg">&nbsp;</td>
        </tr>
        <tr>
          <td><img src="../../../images/images_72.jpg" width="16" height="17"></td>
          <td background="../../../images/images_73.jpg">&nbsp;</td>
          <td><img src="../../../images/images_75.jpg" width="16" height="17"></td>
        </tr>
      </table>
			</td>
		</tr>
	</table>
    </td>
  </tr>
 </table> 
</form>
</body>
</html>
