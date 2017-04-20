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
<html>
<head>
<title>Untitled Document</title>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<gOS:skin />
<script src="../../../script/ua.js"></script>
<script src="../../../script/calendar.js"></script>
<!-- Code for browser detection -->
<script src="../../../script/ua.js"></script>

<!-- Infrastructure code for the tree -->
<script src="../../../script/ftiens4.js"></script>
<script src="../../../script/functionforcheck.js"></script>
<script>
function onSubmit() {	
	 var IsValid=true;
	 if(!checkLoginid(myform.loginid.value))
	 {
	 	document.all("label0").innerHTML="<font color=\"ff0000\">用户id不正确</font>";
	 	IsValid=false;
	 }
	 else
	 document.all("label0").innerHTML="";
	 /*if(myform.password.value.length<3)
	 {
	 	document.all("pwdlbl").innerHTML="<font color=\"ff0000\">密码长度太短</font>";
	 	IsValid=false;
	 }
	 else
	 document.all("pwdlbl").innerHTML="";*/
	 if(myform.cfmpwd.value!=myform.password.value)
	 {
	 	document.all("cfmpwdlbl").innerHTML="<font color=\"ff0000\">密码不一致</font>";
	 	IsValid=false;
	 }
	 else
	 document.all("cfmpwdlbl").innerHTML="";
	 if(myform.dept.value=="")
	 {
	 	document.all("deptlbl").innerHTML="<font color=\"ff0000\">请选择部门</font>";
	 	IsValid=false;
	 }
	 else
	 document.all("deptlbl").innerHTML="";
	 if(myform.name.value=="")
	 {	
	 	document.all("namelbl").innerHTML="<font color=\"ff0000\">请填写姓名</font>";
	 	IsValid=false;
	 }
	 else
	 document.all("namelbl").innerHTML="";
	 
	 

	 if(!checkLength(myform.memo.value, 0, 150)){
		document.all("deslbl").innerHTML="<font color=\"ff0000\">用户描述过长（小于150字符）</font>";
		IsValid=false;
	 }
	 else 
	 document.all("deslbl").innerHTML="";	 
	 
	 if(IsValid)	 		
	 myform.submit();
}
function onSubmitPrio(){
	var prios=",";
	if(myform.prioritys.value!=""){
		prios=myform.prioritys.value;
	}
	windowWithoutToolbar('userChoose.do?action=actorChoose&prios='+prios,600, 500);	
}
</script>
<link href="../../../css/css.css" rel="stylesheet" type="text/css">
</head>
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
%>
<body bgcolor="#FFFFFF" text="#000000" leftmargin="0" topmargin="0">
<form action="userClone.do?action=clone" name="myform" method="post">

	<input name="users" type="hidden" value="">	
	<input type="hidden" name="sDeptId" value="<%=sDeptId%>">
        <input type="hidden" name="creatorid" value="<%=creatorId%>">
        <input type="hidden" name="creatorname" value="<%=creatorName%>">
<table width="102%" border="0" align="right" cellpadding="0" cellspacing="0" class="table10">
  <tr> 
       
    <td align="right" valign="top" class="td18"> 
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table7">
        <tr> 
          <td width="10%" height="20" class="list_title"><label>
            <input name="Submit" type="button" onClick="onSubmit();" class="input_btn" value="确定">
          </label>
            <div align="right"></div></td>
          <td width="45%" height="20" align="left" class="list_title"><label>
            <div align="left">
              <input name="Submit2" type="button" onclick="javascript:history.back();" class="input_btn" value="取消">
              </div>
          </label></td>
          <td width="45%" align="right" class="list_title"><strong>克隆用户(*为必填项)<font color="ff0000">
            <html:errors/>
            </font></strong></td>
        </tr>
      </table>
      <table width="100%" border="0" class="table5">
        <tr> 
          <td height="14"  class="td8">创建人：<%=creatorName%> 　维护日期：<fmt:formatDate value="${user.createdate}" pattern="yyyy-MM-dd"/></td>          
        </tr>
      </table>
        <table width="100%" border="0" cellpadding="1" cellspacing="1" class="table_main">
          <tr> 
            <td width="15%" height="22" class="td22">用户ID*：</td>
          <td width="31%" height="22" class="td23"> <input name="loginid" type="text" size="20" width="150" height="18" value="<c:out value="${user.loginid}" />" maxlength="15"> 
          <label id="label0" name="label0"></label>
          </td>
            <td width="16%" align="right" class="td22"><a href="userSelect.do?action=getPriority&id=<c:out value="${user.id}"/>&showOnly=true">用户权限</a></td>  
          <input name="prioritys" type="hidden" value="<c:out value="${user.priority}"/>">
          <td width="38%" class="td23">
            <!--<a href="javascript:onSubmitPrio();"><img src="../../../images/config/zoom_small.gif" width="13" height="13" border="0"></a> <font color="#0000ff">单击前面的图标修改用户权限</font>-->
          </td>
        </tr>
          <tr height="22" > 
            <td height="22" class="td22">密码：</td>
          <td height="22" class="td23"><input name="password" type="password" size="20" width="150" height="18" maxlength="15"> 
           <label id="pwdlbl" name="pwdlbl"></label>
          </td>
            <td height="22" class="td22">密码确认：</td>
          <td height="22" valign="top" class="td23"><input name="cfmpwd" type="password" size="20" width="150" height="18" maxlength="15">
           <label id="cfmpwdlbl" name="cfmpwdlbl"></label>
          </td>
        </tr>
          <tr> 
            <td height="22" class="td22">所属部门*：</td>
            <td height="22" class="td23">
<input readonly name="dept" type="text" value="<c:out value="${user.deptname}"/>">
          <input type="hidden" name="deptid" value="<c:out value="${user.deptid}"/>"> 
            <a href="javascript:windowWithoutToolbar('userChoose.do?action=officeChoose&inputBox=dept', 400, 600)"><img src="../../../images/config/zoom_small.gif" width="13" height="13" border="0"></a>  <font color="#0000ff">单击前面的图标选择部门</font>
          <label id="deptlbl" name="deptlbl"></label>
          </td>
            <td class="td22">人员编号：</td>
            <td class="td23">
<input name="num" type="text" size="20" width="150" height="18" value="<c:out value="${user.num}" />" maxlength="15"></td>
        </tr>
          <tr> 
            <td height="22" class="td22">姓名*：</td>
            <td height="22" class="td23">
<input name="name" type="text" value="<c:out value="${user.name}" />" size="20" width="150" height="18" maxlength="15"><label id="namelbl" name="namelbl"></label></td>
            <td class="td22">性别：</td>                   
            <td class="td23"> <topsuntech:genderSelect> <c:out value="${user.gender}"/> 
              </topsuntech:genderSelect> </td>
        </tr>
          <tr height="22" > 
            <td height="22" class="td22">籍贯：</td>
          <td height="22" class="td23"><input name="jiguan" type="text" value="<c:out value="${user.jiguan}" />" size="20" width="150" height="18" maxlength="50"> 
          </td>
            <td height="22" class="td22">出生地：</td>
          <td height="22" valign="top" class="td23"><input name="birthlocation" type="text" value="<c:out value="${user.birthlocation}" />" size="20" width="150" height="18" maxlength="50"></td>
        </tr>
          <tr> 
            <td height="22" class="td22">出生年月：</td>
            <td height="22" class="td23"> 
            	<input type='hidden' name='birthdaystr' value='2007-12-01'>
            	<!--
              <script>
          Calendar('birthdaystr','<fmt:formatDate value="${user.birthday}" pattern="yyyy-MM-dd" />',1900,2000,null,null,null);
          </script>
          <label id="birthlbl" name="birthlbl"></label>
          -->
          </td>
            <td class="td22">民族：</td>
            <td class="td23"> <topsuntech:nationSelect> <c:out value="${user.nation}"/> 
              </topsuntech:nationSelect> </td>
        </tr>
          <tr> 
            <td height="22" class="td22">学历：</td>
            <td height="22" class="td23"> <topsuntech:xueliSelect> <c:out value="${user.xueli}"/> 
              </topsuntech:xueliSelect> </td>
            <td class="td22">学位：</td>
            <td class="td23"> <topsuntech:xueweiSelect> <c:out value="${user.xuewei}"/> 
              </topsuntech:xueweiSelect> </td>
        </tr>
          <tr> 
            <td height="22" class="td22">所学专业：</td>
            <td height="22" class="td23">
<input name="zhuanye" type="text" value="<c:out value="${user.zhuanye}"/>" size="20" width="150" height="18" maxlength="50"></td>
            <td class="td22">毕业院校及时间：</td>
            <td class="td23">
<input name="yuanxiao" type="text" value="<c:out value="${user.yuanxiao}"/>" size="20" width="150" height="18" maxlength="50"></td>
        </tr>
          <tr> 
            <td height="22" class="td22">政治面貌：</td>
            <td height="22" class="td23">
<input name="zhengzhimianmao" type="text" value="<c:out value="${user.zhengzhimianmao}"/>" size="20" width="150" height="18" maxlength="15"></td>
            <td class="td22">入党/团时间：</td>
            <td class="td23"> 
            	<input type='hidden' name='rudangshijian' value='2007-12-01' >
            	<!--
              <script>
          Calendar('rudangshijian','<fmt:formatDate value="${user.rudangshijian}" pattern="yyyy-MM-dd" />',1940,2030,null,null,null);
          </script>
          <label id="rudanglbl" name="rudanglbl"></label>
          -->
          </td>
        </tr>
          <tr> 
            <td height="22" class="td22">职称：</td>
            <td height="22" class="td23"> <topsuntech:callnameSelect><c:out value="${user.callname}"/></topsuntech:callnameSelect> 
            </td>
            <td class="td22">职务：</td>
            <td class="td23">
<input name="positionid" value="<c:out value="${user.positionid}"/>" type="text" size="20" width="150" height="18" maxlength="50"></td>
        </tr>
          <tr> 
            <td height="22" class="td22">身份证号：</td>
            <td height="22" class="td23">
<input name="identitynum" type="text" value="<c:out value="${user.identitynum}"/>" size="20" width="150" height="18" maxlength="50"></td>
            <td class="td22">工作证号：</td>
            <td class="td23">
<input name="worknum" type="text" value="<c:out value="${user.worknum}"/>" size="20" width="150" height="18" maxlength="50"></td>
        </tr>
          <tr> 
            <td height="22" class="td22">家庭居住地址：</td>
            <td height="22" class="td23">
<input name="address" type="text"  value="<c:out value="${user.address}"/>" size="20" width="150" height="18" maxlength="50"></td>
            <td class="td22">住宅电话：</td>
            <td class="td23">
<input name="homephone" type="text" value="<c:out value="${user.homephone}"/>" size="20" width="150" height="18" maxlength="50"></td>
        </tr>
          <tr> 
            <td height="22" class="td22">办公电话：</td>
            <td height="22" class="td23">
<input name="officephone" type="text" value="<c:out value="${user.officephone}"/>" size="20" width="150" height="18" maxlength="50"></td>
            <td class="td22">移动电话：</td>
            <td class="td23">
<input name="mobile" type="text" value="<c:out value="${user.mobile}"/>" size="20" width="150" height="18" maxlength="50"></td>
        </tr>
          <tr> 
            <td height="22" class="td22">公积金号：</td>
            <td height="22" class="td23">
<input name="publicmoneynum" type="text" value="<c:out value="${user.publicmoneynum}"/>" size="20" width="150" height="18" maxlength="50"></td>
            <td class="td22">养老保险号：</td>
            <td class="td23">
<input name="oldsupportnum" type="text" value="<c:out value="${user.oldsupportnum}"/>" size="20" width="150" height="18" maxlength="50"></td>
        </tr>
          <tr> 
            <td height="22" class="td22">住房补贴号：</td>
            <td height="22" class="td23">
<input name="housepaynum" type="text" value="<c:out value="${user.housepaynum}"/>" size="20" width="150" height="18" maxlength="50"></td>
            <td class="td22">医疗保险号：</td>
            <td class="td23">
<input name="securitynum" type="text" value="<c:out value="${user.securitynum}"/>" size="20" width="150" height="18" maxlength="50"></td>
        </tr>
          <tr> 
            <td height="22" class="td22">参加工作时间：</td>
            <td height="22" class="td23">
            	
            		<input type="hidden" name="workyear" value="2007-12-30">
            	<!--
          <script>
          Calendar('workyear','<fmt:formatDate value="${user.workyear}" pattern="yyyy-MM-dd" />',1940,2030,null,null,null);
          </script> 
          
          <label id="workyearlbl" name="workyearlbl"></label>
          -->
          </td>
          <td class="td22">工作部门：</td>
          <td class="td23">
          <input readonly name="workdept" type="text" value="<c:out value="${user.workdept.name}"/>" > 
          <input name="workdeptid" type="hidden" value="<c:out value="${user.workdept.id}"/>"> 
          <a href="javascript:windowWithoutToolbar('userChoose.do?action=officeChoose&inputBox=workdept', 400, 600)"><img src="../../../images/config/zoom_small.gif" width="13" height="13" border="0"></a> 
            <font color="#0000ff">单击前面的图标选择部门</font>
          </td> 
        </tr>
          <tr> 
            <td height="22" class="td22">备注：
<label id="deslbl" name="deslbl"></label></td>
            <td height="22" colspan="3" class="td23">
<TEXTAREA NAME="memo" height = "300" width = "300" ROWS=5 COLS=60 ID="textarea" wrap="hard"><c:out value="${user.memo}"/></TEXTAREA></td>
        </tr>
      </table>
      
    </td>
  </tr>
</table>
</form>
</body>
</html>
