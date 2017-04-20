<%@ page contentType="text/html; charset=GBK" language="java" import="java.sql.*" errorPage="" %>
<%@ page import="com.topsuntech.gOS.user.tools.*" %>
<html>
<head>
<title>Untitled Document</title>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
</head>

<body>
<%
	String action = request.getParameter("action");
	if(action != null && action.equals("import")){
		try{
			UKeyToUser.write();
			out.print("导入成功！");
		}catch(Exception e){
			e.printStackTrace();
			//out.print(e);
		}
	}else{
		String name = request.getParameter("name");
		name = new String(name.getBytes("ISO8859_1"), "GBK");
		String canumber = request.getParameter("canumber");
		canumber = new String(canumber.getBytes("ISO8859_1"), "GBK");
		try{
			UKeyToUser.importUK(name, canumber);
			out.println("添加成功");
		}catch(Exception e){
			out.print(e);
		}
	}
	
%>
</body>
</html>
