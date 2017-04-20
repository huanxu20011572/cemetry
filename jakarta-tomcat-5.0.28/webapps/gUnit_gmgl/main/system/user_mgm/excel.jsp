<%@ page contentType="text/html; charset=GBK" %>

<% 
response.setHeader("Pragma","No-cache"); 
response.setHeader("Cache-Control","no-cache"); 
response.setDateHeader("Expires", 0); 
%> 

<%
String filename = request.getParameter("filename");

response.setHeader("Content-disposition","attachment; filename=" + filename + ".xls");
response.setContentType("application/vnd.ms-excel;charset=GBK"); 
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<meta http-equiv="pragma" content="no-cache"> 
<meta http-equiv="cache-control" content="no-cache"> 
<meta http-equiv="expires" content="0"> 
</head>
<body>
<%!
public static String replaceScript(String content){
	int a = content.indexOf("<SCRIPT>");
	int b = content.indexOf("</SCRIPT>");
	if(a!=-1){
		return replaceScript(content.substring(0,a-1)+content.substring(b+9,content.length()));
	}else{
		return content;
	}
}
%>
<%
String content = request.getParameter("CONTENT");
content = new String(content.getBytes("ISO8859-1"));
content = replaceScript(content);
out.print(content);
%>
</body>
</html>
