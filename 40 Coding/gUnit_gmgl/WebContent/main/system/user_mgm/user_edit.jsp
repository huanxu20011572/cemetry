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
<title>Untitled Document</title>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">

<script src="../../../script/ua.js"></script>
<script src="../../../script/functionforcheck.js"></script>
<script src="../../../script/calendar.js"></script>
<script src="../../../script/publics.js"></script>
<script src="../../../script/common.js"></script>
<script type='text/javascript' src='../../../dwr/interface/checkLognid.js'></script>
<script type='text/javascript' src='../../../dwr/engine.js'></script>
<script type='text/javascript' src='../../../dwr/util.js'></script>

<script language="JavaScript">
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
	myform.actionType.value="normal";
	 var IsValid=true;	 
	 
	 var firstErrorEle = null;
	 firstErrorEle = removeAndAddErrInfo(!checkLoginid(myform.loginid.value), 'loginid', 'label0', '�û�ID����ȷ', firstErrorEle);
	 firstErrorEle = removeAndAddErrInfo(!myform.deptid.value, 'dept', 'deptlbl', '��ѡ�����ڴ���', firstErrorEle);
	 firstErrorEle = removeAndAddErrInfo(!myform.workdeptid.value, 'workdeptName', 'workdeptlbl', '��ѡ����������', firstErrorEle);
	 firstErrorEle = removeAndAddErrInfo(!myform.name.value, 'name', 'namelbl', '����д����', firstErrorEle);
	 firstErrorEle = removeAndAddErrInfo(!checkLength(myform.memo.value, 0, 150), 'memo', 'deslbl', '�û�����������С��150�ַ���', firstErrorEle);
	 firstErrorEle = removeAndAddErrInfo(!myform.num.value, 'num', 'numlbl', '����д��Ա����', firstErrorEle);
	 if(firstErrorEle == null){
	   	myform.action = "updateUser.do?doMethod=update&idyProcessService=userManager&inputPath=<c:out value='${param.inputPath}'/>";
	 	myform.submit();
	  }else{
	  	scroll(0, 0);
	  	firstErrorEle.focus();
	  }
	  /*	
	 if(myform.dept.value=="")
	 {
	 	document.all("deptlbl").innerHTML="<font color=\"ff0000\">��ѡ����</font>";
	 	IsValid=false;
	 }
	 else
	 document.all("deptlbl").innerHTML="";
	 
	 if(!checkLength(myform.memo.value, 0, 150)){
		document.all("deslbl").innerHTML="<font color=\"ff0000\">�û�����������С��150�ַ���</font>";
		IsValid=false;
	 }
	 else 
	 document.all("deslbl").innerHTML="";
	 
	 if(myform.name.value=="")
	 {	
	 	document.all("namelbl").innerHTML="<font color=\"ff0000\">����д����</font>";
	 	IsValid=false;
	 }
	 else
	 document.all("namelbl").innerHTML="";
	 
	  if(myform.num.value=="")
	 {	
	 	document.all("numlbl").innerHTML="<font color=\"ff0000\">����д��Ա����</font>";
	 	IsValid=false;
	 }
	 else
	 document.all("numlbl").innerHTML="";
	 
	 
	 if(IsValid){
	 myform.action = "updateUser.do?doMethod=update&idyProcessService=userManager&inputPath=<c:out value='${param.inputPath}'/>";
	 myform.submit();
	}
	*/
}
function onSubmitP(){
	 myform.actionType.value="password";
	 var IsValid=true;
	 
	 var firstErrorEle = null;
	 firstErrorEle = removeAndAddErrInfo(myform.password.value.length<3, 'password', 'pwdlbl', '���볤��̫��(���ڵ���3λ)', firstErrorEle);
	 firstErrorEle = removeAndAddErrInfo(myform.newpwdconfirm.value!=myform.password.value, 'newpwdconfirm', 'cfmpwdlbl', '���벻һ��', firstErrorEle);
	 if(firstErrorEle == null){
	 	//myform.password.value="159357";
	  myform.action = "changePwd.do?doMethod=updatePwdfor&inputPath=<c:out value='${param.inputPath}'/>";
	 	myform.submit();
	 }else{
	 	scroll(0, 0);
	 	firstErrorEle.focus();
	 }
	 /*
	 if(myform.password.value.length<8)
	 {
	 	document.all("pwdlbl").innerHTML="<font color=\"ff0000\">���볤��̫��</font>";
	 	IsValid=false;
	 }
	 else
	 document.all("pwdlbl").innerHTML="";
	 if(myform.newpwdconfirm.value!=myform.password.value)
	 {
	 	document.all("cfmpwdlbl").innerHTML="<font color=\"ff0000\">���벻һ��</font>";
	 	IsValid=false;
	 }
	 else
	 document.all("cfmpwdlbl").innerHTML="";
	 if(IsValid){
	 		myform.action = "changePassword.do?doMethod=changePassword&idyProcessService=userManager&inputPath=<c:out value='${param.inputPath}'/>";
	 		myform.submit();
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
		openWinNoToolbarAndSubmit('<c:url value="/main/system/user_mgm/showChoosePriorityRole.do?doMethod=showChoosePriorityRole&fromOpener=true&usrid=${user.id}"/>', 800, 600, pForm);		
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
  	alert("������ĵ�½���Ѵ��ڣ��뻻һ����½��");
  	
  	document.getElementById('loginid').select()
  	return ;
  	}
	}); 
   
}

</script>
<link href="../../../css/css.css" rel="stylesheet" type="text/css">
</head>

<body>
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="11" height="31" valign="top" class="td-bg"><img src="../../../images/right-1.jpg" /></td>
    <td align="center" valign="top" ><table width="100%" border="0" cellpadding="0" cellspacing="0" class="word-8">
      <tr>
        <td height="31" align="left" valign="middle" style="background:url(../../../images/right-3.jpg)"><img src="../../../images/right-4.jpg" width="9" height="8" align="absmiddle" /> ��ǰλ�� &gt; ϵͳ���� &gt; �û�����</td>
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
		<tr>
			<td align="left">
			<table width="94%" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
				  
                <td height="0">&nbsp; </td>
				  
                <td height="0" align="right" valign="top">&nbsp;</td>
				</tr>
			</table>
				  
		  </td>
		</tr>
		<tr id="tag1">
			<td>
			<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td width="45" align="left" background="../../../images/images_49.jpg"><img src="../../../images/images_48.jpg" width="38" height="40"></td>
        <td background="../../../images/images_49.jpg" class="title"><strong>�޸��û���Ϣ</strong></td>
        
        <td width="16" align="right" background="../../../images/images_49.jpg"></td>
      </tr>
    </table>
   
			<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td width="16" background="../../../images/images_55.jpg">&nbsp;</td>
          <td align="center">
          	<br>
          	 <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table7">
        <tr> 
          <td width="46%" height="20" class=td-04><strong>��ʾ:��������Ϊ��λ,�޸�ϵͳ����<font color="ff0000">
            <html:errors/></font></strong>&nbsp;</td>
          <td width="54%" height="20" align="left" class=td-04>�����ˣ�<c:out value="${user.creatorname}"/> ��ά�����ڣ�<fmt:formatDate value="${user.createdate}" pattern="yyyy-MM-dd"/>
            </td>
          <td width="0%" align="right" class=td-02>&nbsp; </td>
        </tr>
      </table> 
        
      <form id="myform" name="myform" method="post">      	
      <input type="hidden" name="id" value="<c:out value="${user.id}"/>">      
      <input type="hidden" name="actionType" value="">
      <input type="hidden" name="sDeptId" value="<%=sDeptId%>">
	  <input type="hidden" name="emailid" value="<c:out value="${user.emailid}"/>">
      <input type="hidden" name="creatorid" value="<%=creatorId%>">
      <input type="hidden" name="creatorname" value="<%=creatorName%>">
      <input name="registstatus" type="hidden" value="2">      
    <TABLE width="100%" 
        border=0 cellPadding=1 cellSpacing=1 bgcolor="a8d1eb" class=table_main>          
          <tr> 
            <td height="22" class=td-01>�����룺</td>
            <td height="22" class=td-02> 
              <input name="password" type="password" maxlength="50">       
          <label id="pwdlbl" name="pwdlbl"></label>             
          </td>
        </tr>
          <tr> 
            <td height="23" class=td-01>������ȷ�ϣ�</td>
            <td height="23" class=td-02> 
              <input name="newpwdconfirm" type="password" maxlength="50">
          <label id="cfmpwdlbl" name="cfmpwdlbl"></label>
          </td>
        </tr>        
      </table>    
      <table width="300" border="0" cellpadding="0" cellspacing="0" align="center">
              <tr>
                <td width="60"><a href="javascript:onSubmitP();"><img src="../../../images/but-qd.gif" width="66" height="27" border="0" ></a>&nbsp;&nbsp;</td>
                <td width="60"><a href="javascript:history.go(-1);"><img src="../../../images/but0qx.jpg" width="66" height="27" border="0" ></a></td>
                <td width="60">&nbsp;</td>
                <td width="60">&nbsp;</td>
                <td width="60">&nbsp;</td>
              </tr>
            </table>  
      <br>
      <br>  
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table7">
        <tr> 
          <td width="46%" height="20" class=td-04><strong>�޸��û���Ϣ(*Ϊ������)<font color="ff0000">
            <html:errors/></font></strong>&nbsp;</td>
          <td width="54%" height="20" align="left" class=td-04>&nbsp; 
            </td>
          <td width="0%" align="right" class=td-02>&nbsp; </td>
        </tr>
      </table> 
     <br>          
        <TABLE width="100%" 
        border=0 cellPadding=1 cellSpacing=1 bgcolor="a8d1eb" class=table_main>
          <tr> 
            <td width="15%" height="22" class=td-01  align="right">�û�ID<span class="text-red">*</span>��</td>
          <td width="31%" height="22" class=td-02>
          	<input name="loginid" type="text" value="<c:out value="${user.loginid}"/>" maxlength="15" onchange="checkloginida()">
          	 <LABEL id=label0 name="label0"></LABEL>
          </td>
            <td width="16%" align="right" class=td-01>�û�Ȩ��:</td>
           <input type="hidden" id="priority" name="priority" value="<c:out value="${user.priority}"/>" >
          	 <input type="hidden" id="systemRole" name="systemRole" value="<c:out value="${user.systemRole}"/>" >
          <td width="38%" class=td-02>
          
          	<a href="javascript:onSubmitPrio();"><img src="../../../images/config/zoom_small.gif" width="13" height="13" border="0"></a> 
          	
          	<font color="#0000ff">����ǰ���ͼ�������û�Ȩ��</font>  <a href="../user_mgm/showUserProAll.do?doMethod=showUserProAll&usrid=<c:out value="${user.id}"/>">�û�Ȩ���б�</a>        	</td>
        </tr>
          <tr> 
          	 <td class=td-01  align="right">��������<span class="text-red">*</span>��</td>
	          <td class=td-02>
		          <input readonly name="workdeptName" type="text" value="<c:out value="${user.workdept.name}"/>" > 
		          <input name="workdeptid" type="hidden" value="<c:out value="${user.workdept.id}"/>"> 
		          <a href="javascript:" onClick="selectWorkdept()"><img src="../../../images/config/zoom_small.gif" width="13" height="13" border="0"></a> 
		          <font color="#0000ff">����ǰ���ͼ��ѡ����</font>    
		          <label id="workdeptlbl" name="workdeptlbl"></label>
	          </td> 
          
            <td height="22" class=td-01  align="right">���ڴ���<span class="text-red">*</span>��</td>
            <td height="22" class=td-02>
				<input readonly name="dept" type="text" value="<c:out value="${user.deptname}"/>">
	          	<input type="hidden" name="deptid" value="<c:out value="${user.deptid}"/>"> 
	            <a href="javascript:" onClick="selectDept()"><img src="../../../images/config/zoom_small.gif" width="13" height="13" border="0"></a> <font color="#0000ff">����ǰ���ͼ��ѡ����</font>
	            <label id="deptlbl" name="deptlbl"></label>
            </td>
        </tr>
          <tr> 
            <td height="22" class=td-01  align="right">����<span class="text-red">*</span>��</td>
            <td height="22" class=td-02>
<input name="name" type="text" size="20" width="150" height="18" value="<c:out value="${user.name}"/>" maxlength="15"><label id="namelbl" name="namelbl"></label></td>
            <td class=td-01  align="right">�Ա�</td>
            <td height="22" class=td-02> <topsuntech:genderSelect> <c:out value="${user.gender}"/> 
              </topsuntech:genderSelect> </td>
        </tr>
          <tr height="22" > 
            <td height="22" class=td-01  align="right">��Ա����<span class="text-red">*</span>��</td>
          <td height="22" class=td-02><input name="num" type="text" value="<c:out value="${user.num}"/>" size="20" width="150" height="18" maxlength="50"><label id="numlbl" name="numlbl"></label></td>
            <td height="22" class=td-01  align="right">�����أ�</td>
          <td height="22" valign="top" class=td-02><input name="birthlocation" type="text" value="<c:out value="${user.birthlocation}"/>" size="20" width="150" height="18" maxlength="50"></td>
        </tr>
          <tr> 
            <td height="22" class=td-01  align="right">�������£�</td>
            <td height="22" class=td-02>             	
            <input name="birthday" value="<c:out value="${user.birthday}" />" readonly="true" type="text" class="input"  size="16" onClick="calendar()">
				              <input name="button2" type="button" class="input_clean" onClick="javascript:birthdaystr.value='';" value=""/>          </td>
            <td class=td-01  align="right">���壺</td>
            <td class=td-02> <topsuntech:nationSelect> <c:out value="${user.nation}"/> 
              </topsuntech:nationSelect> </td>
        </tr>
        <tr> 
          <td height="22" class=td-01  align="right">ѧ����</td>
          <td height="22" class=td-02> 
          <!--
          	<topsuntech:xueliSelect> 
          		<c:out value="${user.xueli}"/> 
            </topsuntech:xueliSelect> 
          -->
          	<%
            	Collection list = UserXueweiFactory.getUserXueweiConfig().getUserXueweibyAll();
                request.setAttribute("list", list);
            %>
            <select id="xueli" name="xueli">
                <c:forEach var="xueli" items="${list}">
                    <option value='<c:out value="${xueli.name}"/>' <c:if test='${xueli.name eq user.xueli}'>selected="true"</c:if>><c:out value="${xueli.name}"/></option>                                                
                </c:forEach>
            </select>
            </td>
          <td class=td-01  align="right">ѧλ��</td>
          <td class=td-02> 
          <!--
          	<topsuntech:xueweiSelect> 
          		<c:out value="${user.xuewei}"/> 
            </topsuntech:xueweiSelect> 
          -->
            <select id="xuewei" name="xuewei">
                <c:forEach var="xueli" items="${list}">
                    <option value='<c:out value="${xueli.name}"/>' <c:if test='${xueli.name eq user.xuewei}'>selected="true"</c:if>><c:out value="${xueli.name}"/></option>                                                
                </c:forEach>
            </select>
        </tr>
          <tr> 
            <td height="22" class=td-01  align="right">��ѧרҵ��</td>
            <td height="22" class=td-02>
<input name="zhuanye" type="text" value="<c:out value="${user.zhuanye}"/>" size="20" width="150" height="18" maxlength="50"></td>
            <td class=td-01  align="right">��ҵԺУ��ʱ�䣺</td>
            <td class=td-02>
<input name="yuanxiao" type="text" value="<c:out value="${user.yuanxiao}"/>" size="20" width="150" height="18" maxlength="50"></td>
        </tr>
          <tr> 
            <td height="22" class=td-01  align="right">������ò��</td>
            <td height="22" class=td-02>
<input name="zhengzhimianmao" type="text" value="��Ա" size="20" width="150" height="18" maxlength="15"></td>
            <td class=td-01  align="right">�뵳/��ʱ�䣺</td>
            <td class=td-02>             		
           <input name="rudangshijian" value="<c:out value="${user.rudangshijian}" />" readonly="true" type="text" class="input"  size="16" onClick="calendar()">
				              <input name="button2" type="button" class="input_clean" onClick="javascript:rudangshijian.value='';" value=""/>          </td>
        </tr>
        <tr> 
          <td height="22" class=td-01  align="right">ְ�ƣ�</td>
          <td height="22" class=td-02> 
          <!--	
          	<topsuntech:callnameSelect>
          		<c:out value="${user.callname}"/>
          	</topsuntech:callnameSelect> 
          -->
          	<%
            	list = UserZhichengFactory.getUserZhichengConfig().getUserZhichengbyAll();
                request.setAttribute("list", list);
            %>
             <select id="callname" name="callname">
                <c:forEach var="xueli" items="${list}">
                    <option value='<c:out value="${xueli.name}"/>' <c:if test='${xueli.name eq user.callname}'>selected="true"</c:if>><c:out value="${xueli.name}"/></option>                                                
                </c:forEach>
            </select>
           </td>
          <td class=td-01  align="right">ְ��</td>
          <td class=td-02> <input name="positionid" value="<c:out value="${user.positionid}"/>" type="text" size="20" width="150" height="18" maxlength="50"> </td>
        </tr>
          <tr> 
            <td height="22" class=td-01  align="right">���֤�ţ�</td>
            <td height="22" class=td-02>
<input name="identitynum" type="text" value="<c:out value="${user.identitynum}"/>" size="20" width="150" height="18" maxlength="50"></td>
            <td class=td-01  align="right">����֤�ţ�</td>
            <td class=td-02>
<input name="worknum" type="text" value="<c:out value="${user.worknum}"/>" size="20" width="150" height="18" maxlength="50"></td>
        </tr>
          <tr> 
            <td height="22" class=td-01  align="right">��λ��ַ��</td>
            <td height="22" class=td-02>
<input name="address" type="text" value="<c:out value="${user.address}"/>" size="20" width="150" height="18" maxlength="50"></td>
            <td class=td-01  align="right">��ϵ�绰��</td>
            <td class=td-02>
<input name="homephone" type="text" value="<c:out value="${user.homephone}"/>" size="20" width="150" height="18" maxlength="50"></td>
        </tr>
          <tr> 
            <td height="22" class=td-01  align="right">�칫�绰��</td>
            <td height="22" class=td-02>
<input name="officephone" type="text" value="<c:out value="${user.officephone}"/>" size="20" width="150" height="18" maxlength="50"></td>
            <td class=td-01  align="right">�ƶ��绰��</td>
            <td class=td-02>
<input name="mobile" type="text" value="<c:out value="${user.mobile}"/>" size="20" width="150" height="18" maxlength="50"></td>
        </tr>
          <tr> 
            <td height="22" class=td-01  align="right">������ţ�</td>
            <td height="22" class=td-02>
<input name="publicmoneynum" type="text" value="<c:out value="${user.publicmoneynum}"/>" size="20" width="150" height="18" maxlength="50"></td>
            <td class=td-01  align="right">���ϱ��պţ�</td>
            <td class=td-02>
<input name="oldsupportnum" type="text" value="<c:out value="${user.oldsupportnum}"/>" size="20" width="150" height="18"></td>
        </tr>
          <tr> 
            <td height="22" class=td-01  align="right">ס�������ţ�</td>
            <td height="22" class=td-02>
<input name="housepaynum" type="text" value="<c:out value="${user.housepaynum}"/>" size="20" width="150" height="18" maxlength="50"></td>
            <td class=td-01  align="right">ҽ�Ʊ��պţ�</td>
            <td class=td-02>
<input name="securitynum" type="text" value="<c:out value="${user.securitynum}"/>" size="20" width="150" height="18" maxlength="50"></td>
        </tr>
          <tr> 
          <td class=td-01  align="right">���᣺</td>
            <td class=td-02>
<input name="jiguan" type="text" value="<c:out value="${user.jiguan}"/>" size="20" width="150" height="18" maxlength="15"></td>
            <td height="22" class=td-01  align="right">�μӹ���ʱ�䣺</td>
            <td height="22" class=td-02>            
          <input name="workyear" value="<c:out value="${user.workyear}" />" readonly="true" type="text" class="input"  size="16" onClick="calendar()">
				              <input name="button2" type="button" class="input_clean" onClick="javascript:workyear.value='';" value=""/>          </td>
        </tr>

		
		 <tr> 
          <td class="td-01"  align="right">֤��ţ�</td>
            <td class="td-02" colspan="3">
<input name="canumber" type="text" value="<c:out value="${user.canumber}" />" size="20" width="150" height="18" ><font color="#FF0000">֤�����GWY��ͷ�����֤��</font></td>
           
        </tr>
		
          <tr> 
            <td height="22" class=td-01  align="right">��ע��
<label id="deslbl" name="deslbl"></label></td>
            <td height="22" colspan="3" class=td-02><textarea name="memo" height = "300" width = "300" rows=5 cols=60 id="textarea2" wrap="hard"><c:out value="${user.memo}"/></textarea></td>
        </tr>
		
      </table>
	  <TABLE width="100%" 
        border=0 cellPadding=1 cellSpacing=1  >
	  <tr> 
            <td height="22" colspan="4"  align="center"  class=td-02><table width="300" border="0" cellpadding="0" cellspacing="0">
              <tr class="">
                <td width="60" ><label>
                 <a href="javascript:onSubmit();"><img src="../../../images/but-qd.gif" width="66" height="27" border="0" ></a>&nbsp;&nbsp;
                </label></td>
                <td width="60" ><label>
                  <a href="javascript:history.go(-1);"><img src="../../../images/but0qx.jpg" width="66" height="27" border="0" ></a>
                </label></td>
                <td width="60" >&nbsp;</td>
                <td width="60" >&nbsp;</td>
                <td width="60">&nbsp;</td>
              </tr>
            </table>
			</td>
           
        </tr>
      </table>
      </form>
		  
		  		
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
</body>
</html>