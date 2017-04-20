<%@ page contentType="text/html; charset=GBK" %>
<%@ include file="../../common/taglibs.jsp"%>
<%@page import="com.topsuntech.gOS.user.session.*" %>
<%@page import="com.topsuntech.gOS.user.en.user.*" %>

<%
	User user = UserSession.getUser(request);
	long creatorid = -1;
	if (user != null) {
		creatorid = user.getId().longValue();
	}
	pageContext.setAttribute("creatorid", new Long(creatorid));
%>

<c:redirect url="../../main/system/zxt_mgm/UserextSelectZi.do?action=list&type=subman&creatorid=${creatorid}" />

<html>
<head>
<title></title>
<link href="/ajjwork/css/css.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<meta http-equiv="Cache-Control" content="no-store"/>
<meta http-equiv="Pragma" content="no-cache"/>
<meta http-equiv="Expires" content="0"/>

</head>

			
</html>
