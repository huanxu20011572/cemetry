<%@ page contentType="text/html; charset=GBK" %>
<%@ include file="common/taglibs.jsp"%>
<%	
request.getSession().setAttribute("logType", "mima");		
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>ƽ̨����</title>
</head>
<body>
<form name="loginform" method="post" action="login.do" >
<input type="hidden" name="action" value="login">
<input type="hidden" name="sysTemFlag" value="tjbz" >
<table  width="50%">
	<tr height="40" >
		<td>��½����</td><td><input type="text" name="username" value="admin"/></td>
	</tr>
	<tr height="40">
		<td>���룺</td><td><input type="password" name="password" value="123456"/></td>
	</tr>
	<tr height="40">
		<td colspan="2"><input type="submit" value="ȷ��"></td>
	</tr>
	
</table>

</form>
</body>
</html>