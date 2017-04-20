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
<title>用户信息修改</title>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<gOS:skin />
<script src="../../../script/ua.js"></script>
<script src="../../../script/functionforcheck.js"></script>
<script src="../../../script/calendar.js"></script>
<script language="JavaScript">
function onSubmit() {	 
	 var IsValid=true;
	 if(myform.password.value.length<3)
	 {
	 	document.all("pwdlbl").innerHTML="<font color=\"ff0000\">密码长度太短</font>";
	 	IsValid=false;
	 }
	 else
	 document.all("pwdlbl").innerHTML="";
	 if(myform.cfmpwd.value!=myform.password.value)
	 {
	 	document.all("cfmpwdlbl").innerHTML="<font color=\"ff0000\">密码不一致</font>";
	 	IsValid=false;
	 }
	 else
	 document.all("cfmpwdlbl").innerHTML="";

	 if(myform.name.value=="")
	 {	
	 	document.all("namelbl").innerHTML="<font color=\"ff0000\">请填写姓名</font>";
	 	IsValid=false;
	 }
	 else
	 document.all("namelbl").innerHTML="";
	 
	 if(!isDate(myform.birthdaystr.value))
	 {
	 	document.all("birthlbl").innerHTML="<font color=\"ff0000\">请填写正确日期</font>";
	 	IsValid=false;
	 }
	 else
	 document.all("birthlbl").innerHTML="";
	  if(!isDate(myform.rudangshijian.value))
	 {
	 	document.all("rudanglbl").innerHTML="<font color=\"ff0000\">请填写正确日期</font>";
	 	IsValid=false;
	 }
	 else
	 document.all("rudanglbl").innerHTML="";
	 
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
</head>

<body bgcolor="#FFFFFF" text="#000000" leftmargin="0" topmargin="0">
<form action="modify.do?action=modify" name="myform" method="post">

<input name="emailid" type="hidden" value="">
<table width="102%" border="0" align="right" cellpadding="0" cellspacing="0" class="table10">
  <tr> 
       
    <td align="right" valign="top" class="td18"> 
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table7">
        <tr> 
          <td width="0%" height="20">&nbsp; </td>
          <td width="54%" height="20" align="left"> <strong>用户信息修改(*为必填项123)<font color="ff0000"><html:errors/></font></strong></td>
          <td width="46%" align="right"><table width="300" border="0" cellpadding="0" cellspacing="0">
              <tr class="td16"> 
                <td width="60" class="td16">&nbsp;</td>
                <td width="60" class="td16">&nbsp;</td>
                <td width="60" class="td16">【<a href="javascript:onSubmit();">确定</a>】</td>                
                <td width="60" class="td16">【<a href="javascript:myform.reset();">重填</a>】 </td>
                <td width="60" class="td16">【<a href="javascript:window.close();">取消</a>】</td>
              </tr>
            </table></td>
        </tr>
      </table>
      <table width="100%" border="0" class="table5">
        <tr> 
          <td></td>
        </tr>
      </table>
      <table width="100%" border="0" cellpadding="1" cellspacing="1" class="table_main">
 <%--
        <tr> 
          <td width="15%" height="22" class="td22">邮箱ID：</td>
          <td width="31%" height="22" class="td23"> <input name="emailid" type="text" size="20" width="150" height="18" value="<c:out value="${user.emailid}"/>" maxlength="15"> <label id="emaillbl" name="emaillbl"></label> </td>
          <td height="22" class="td22" colspan="2">&nbsp;</td>
        </tr>
--%>        
        <tr height="22" > 
          <td height="22" class="td22">密码：</td>
          <td height="22" class="td23"><input name="password" type="password" size="20" width="150" height="18" maxlength="15" value="<c:out value="${user.password}"/>"> 
            <label id="pwdlbl" name="pwdlbl"></label></td>
          <td height="22" class="td22">密码确认：</td>
          <td height="22" valign="top" class="td23"><input name="cfmpwd" type="password" size="20" width="150" height="18" maxlength="15" value="<c:out value="${user.password}"/>"> 
            <label id="cfmpwdlbl" name="cfmpwdlbl"></label></td>
        </tr>
        <tr> 
         	<td height="22" class="td22">姓名*：</td>
          <td height="22" class="td23"> <input name="name" type="text" value="<c:out value="${user.name}"/>" size="20" width="150" height="18" maxlength="15">
          <label id="namelbl" name="namelbl"></label></td>
          
          <td class="td22">性别：</td>
          <td class="td23"> <topsuntech:genderSelect> <c:out value="${user.gender}"/> </topsuntech:genderSelect> 
          </td>
        </tr>
        
        <tr height="22" > 
          <td height="22" class="td22">籍贯：</td>
          <td height="22" class="td23"><input name="jiguan" type="text" value="<c:out value="${user.jiguan}"/>" size="20" width="150" height="18" maxlength="50"> </td>
          <td height="22" class="td22">出生地：</td>
          <td height="22" valign="top" class="td23"><input name="birthlocation" type="text" value="<c:out value="${user.birthlocation}"/>" size="20" width="150" height="18" maxlength="50"></td>
        </tr>
        <tr> 
          <td height="22" class="td22">出生年月：</td>
          <td height="22" class="td23"> <script>
          Calendar('birthdaystr','<fmt:formatDate value="${user.birthday}" pattern="yyyy-MM-dd" />',1900,2000,null,null,null);
          </script> <label id="birthlbl" name="birthlbl"></label> </td>
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
          <td height="22" class="td23"> <input name="zhuanye" type="text" value="<c:out value="${user.zhuanye}"/>" size="20" width="150" height="18" maxlength="50"></td>
          <td class="td22">毕业院校及时间：</td>
          <td class="td23"> <input name="yuanxiao" type="text" value="<c:out value="${user.yuanxiao}"/>" size="20" width="150" height="18" maxlength="50"></td>
        </tr>
        <tr> 
          <td height="22" class="td22">政治面貌：</td>
          <td height="22" class="td23"> <input name="zhengzhimianmao" type="text" value="" size="20" width="150" height="18" maxlength="15"></td>
          <td class="td22">入党/团时间：</td>
          <td class="td23"> <script>
          Calendar('rudangshijian','<fmt:formatDate value="${user.rudangshijian}" pattern="yyyy-MM-dd" />',1940,2030,null,null,null);
          </script> <label id="rudanglbl" name="rudanglbl"></label> </td>
        </tr>
        
        <tr> 
          <td height="22" class="td22">身份证号：</td>
          <td height="22" class="td23"> <input name="identitynum" type="text" value="<c:out value="${user.identitynum}"/>" size="20" width="150" height="18" maxlength="25"></td>
          <td class="td22">工作证号：</td>
          <td class="td23"> <input name="worknum" type="text" value="<c:out value="${user.worknum}"/>" size="20" width="150" height="18" maxlength="30"></td>
        </tr>
        <tr> 
          <td height="22" class="td22">家庭居住地址：</td>
          <td height="22" class="td23"> <input name="address" type="text" value="<c:out value="${user.address}"/>" size="20" width="150" height="18" maxlength="30"></td>
          <td class="td22">住宅电话：</td>
          <td class="td23"> <input name="homephone" type="text" value="<c:out value="${user.homephone}"/>" size="20" width="150" height="18" maxlength="30"></td>
        </tr>
        <tr> 
          <td height="22" class="td22">办公电话：</td>
          <td height="22" class="td23"> <input name="officephone" type="text" value="<c:out value="${user.officephone}"/>" size="20" width="150" height="18" maxlength="30"></td>
          <td class="td22">移动电话：</td>
          <td class="td23"> <input name="mobile" type="text" value="<c:out value="${user.mobile}"/>" size="20" width="150" height="18" maxlength="30"></td>
        </tr>
      </table>
</form>
</body>
</html>
