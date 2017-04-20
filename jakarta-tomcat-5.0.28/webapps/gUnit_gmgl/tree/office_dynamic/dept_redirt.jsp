<%@ page contentType="text/html; charset=GBK" %>
<%@ include file="../../common/taglibs.jsp"%>
<link href="../../css/css.css" rel="stylesheet" type="text/css">

<%@ page import="java.util.*,java.io.*,java.lang.*" %>

<script type="text/javascript">
	 
<%
 Object objAction = request.getAttribute("action");
 String actionStr  = objAction.toString();
 if(actionStr.equals("add")){
%>
	//window.close();
	window.location ="dept_list.jsp";
<%
}else if(actionStr.equals("update")){
%>	
	//alert(“系统提示：修改成功！”);
//	window.close();
	window.location ="dept_list.jsp";
<%
}else{
%>	
	window.location ="dept_list.jsp";
<%	
}
%>	

</script>			

<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
</head>

			
</html>
