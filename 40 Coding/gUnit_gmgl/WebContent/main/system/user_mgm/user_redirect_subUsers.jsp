<%@ page language="java" contentType="text/html; charset=GBK" %>
<%@ page import="java.util.*,java.io.*,java.lang.*" %>
<%@ include file="../../../common/taglibs.jsp"%>
<%@page import="com.topsuntech.gOS.user.session.*" %>
<%@page import="com.topsuntech.gOS.user.en.user.*" %>
<%
	User user = UserSession.getUser(request);
	long deptid =2;
	if (user!=null) {
		deptid = user.getDeptid();
	}
%>

<script language="javascript">
	
 window.location="userQueryList.do?queryName=userList&inputPath=subUsers&deptid=<%=deptid%>";
</script>					

<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
</head>

			
</html>
