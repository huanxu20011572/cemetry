<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib uri="/WEB-INF/tld/gTaglib-gOS.tld" prefix="gOS" %>
<html>
<head>
<title>Untitled Document</title>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<gOS:skin />
<script src="../../../script/action.js" language="JScript"></script>
<script src="../../../script/toolbar-ie5.js" language="JScript"></script>
<link href="../../../script/toolbar-ie5.css" type="text/css" rel="stylesheet">
<xml id="xsl" src="../../../script/toolbar-ie5.xsl"></xml>

<script src="../../../script/ua.js"></script>
<script language="JavaScript">
function onSubmitPrio(){
	var prios=",";
	if(myform.prioritys.value!=""){
		prios=myform.prioritys.value;
	}
	windowWithoutToolbar('userChoose.do?action=actorChoose&prios='+prios,600, 500);
	
}
function doCancel(action){
	myform.action = action;
	myform.submit();
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
<body bgcolor="#FFFFFF" text="#000000" leftmargin="0" topmargin="0">

<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table10">
  <tr> 
    <td valign="top"> 
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table7">
        <tr> 
          <td width="4%" align="right" class="list_title">&nbsp;</td>
          <td width="30%" align="left" class="list_title"><input name="Submit" type="submit" class="input_btn" onClick="javascript:myform.submit();" value="确定">
            <input name="Submit2" type="submit" class="input_btn" onClick="doCancel('<%=backurl%>')" value="取消"></td>
          <td width="66%" align="right" class="list_title"><table width="300" border="0" cellpadding="0" cellspacing="0">
              <tr class="td16"> 
                <td width="10" class="list_title">&nbsp;</td>
                <td width="10" class="list_title">&nbsp;</td>
                <td width="10" class="list_title">&nbsp; </td>
                <td width="162" class="list_title"><label>新的权限:</label></td>
                <td width="108" class="list_title"><label><a href="javascript:onSubmitPrio();"><img src="../../../images/config/zoom_small.gif" width="13" height="13" border="0">设置新的权限</a> </label></td>
              </tr>
          </table></td>
        </tr>
      </table>
      <p>&nbsp;</p>
      <form action="userDeleteAll.do?action=changeAll" name="myform" method="post">
      <input name="prioritys" type="hidden" value=",">   
      <input type="hidden" name="sDeptId" value="<%=sDeptId%>">   
      <table width="100%" border="0" cellpadding="1" class="ConfigTable">
        <tr class="tr2"> 
          <td width="15%" class="list_title"><div align="center">所属部门</div></td>
          <td width="14%" class="list_title"><div align="center"><font face="宋体">ID</font></div></td>
          <td width="17%" class="list_title"><div align="center">权限</div></td>
          <td width="16%" class="list_title"><div align="center">姓名</div></td>
          <td width="8%" class="list_title"><div align="center">性别</div></td>
          <td width="15%" class="list_title"><div align="center">职务</div></td>
          <td width="15%" class="list_title"><div align="center">出生年月</div></td>
        </tr>
         <% int i = 1; %>
        <c:forEach var="user" items="${userList}" >
			<% if (i++ % 2 == 1) {%>
        <tr class="tr1" >
			<% } else {%>
        <tr class="tr3" >
			<% }%>           
	  <input name="ids" type="hidden" value="<c:out value="${user.id}"/>">      
          <td width="15%" height="21"><div align="center"><a href="../office_mgm/officeSelect.do?action=detail&id=<c:out value="${user.deptid}"/>"><c:out value="${user.deptname}" /></a></div></td>
          <td width="14%"><div align="center"><a href="userSelect.do?action=detail&id=<c:out value="${user.id}"/>"><c:out value="${user.loginid}" /></a></div></td>
          <td width="17%"><div align="center"><a href="userSelect.do?action=getPriority&id=<c:out value="${user.id}"/>&showOnly=true">查看</a></div></td>
          <td width="16%"><div align="center"><c:out value="${user.name}" /></div></td>
          <td width="8%"><div align="center"><c:out value="${user.gender}" /></div></td>
          <td width="15%"><div align="center"><c:out value="${user.callname}" /></div></td>
          <td width="15%"><div align="center"><font color="#000000"><fmt:formatDate value="${user.birthday}" pattern="yyyy-MM-dd" /></font></div></td>
        </tr>
        </c:forEach>        
      </table> 
      </form>
    </td>
  </tr>
  <tr class="tr2"> 
    <td align="left"> <font color="#FF0000">批量修改角色，将修改所有选中用户的角色。批量修改用户角色的结果是：这些用户的权限全部修改为该角色的权限。之前的权限将完全无效。</font><font color="#FF0000">对其中某些用户做过细粒度的权限修改，</font>    </td>
  </tr>
  <tr>
    <td height="22" align="left">
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table7">
        <tr>          
        </tr>
      </table></td>
  </tr>
</table>
</body>
</html>
