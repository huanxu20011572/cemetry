<%@ page contentType="text/html; charset=GBK" %>
<html>
<head>
<title>北京市安全生产监督管理平台</title>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
</head>

<%
	String userId = (String)request.getAttribute("userId");
	String prios  = (String)request.getAttribute("prios");
%>

<frameset rows="*" cols="329,*" framespacing="0" frameborder="NO" border="10" bordercolor="#FF9900">  
  <%if(prios==null){%>
  <frame src="userChoose.do?action=listActor&userId=<%=userId%>" name="leftFrame" target="basefrm" scrolling="YES" noresize>
  <%}else{%>
  <frame src="userChoose.do?action=listActor&prios=<%=prios%>" name="leftFrame" target="basefrm" scrolling="YES" noresize>
  <%}%>
  <%if(prios==null){%>
  <frame src="userSelect.do?action=getPriority&id=<%=userId%>" name="basefrm" target="basefrm" scrolling="YES" noresize>  
  <%}else{%>
  <frame src="userChoose.do?action=priority&prios=<%=prios%>" name="basefrm" target="basefrm" scrolling="YES" noresize>  
  <%}%>
</frameset>
<noframes><body>

</body></noframes>
</html>

