<%@ page language="java" contentType="text/html; charset=GBK" %>
<%@ page import="java.util.*,java.io.*,java.lang.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<script lanaguage="javascripte" >
	var roleId = "<c:out value='${param.id}' />";
	alert(roleId);
	
</script>	
 
	<c:redirect url="updateRoles.do?method=updateRoles&roleId=${param.id}" />

 	
<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
</head>

			
</html>
