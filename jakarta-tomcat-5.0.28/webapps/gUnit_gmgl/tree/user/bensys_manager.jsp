<%@ page contentType="text/html; charset=GBK" %>
<%@ include file="../../common/taglibs.jsp"%>
<%@page import="com.topsuntech.gOS.user.session.*" %>
<%@page import="com.topsuntech.gOS.user.en.user.*" %>
<%@ page import="com.topsuntech.gOS.user.en.region.Region" %>
<link href="/ajjwork/css/css.css" rel="stylesheet" type="text/css">


<%
	User user = UserSession.getUser(request);
	
	long creatorid = 20003;
	if (user!=null) {
		
		creatorid = user.getId().longValue();
	}

%>


<c:redirect url="../../main/system/zxt_mgm/subUserQueryList.do?queryName=managedSubUsers&resetForm=true&creatorid=<%=creatorid%>&type=subman&inputPath=subUsers" />

	
<html>
<head>
<title></title>

</head>

			
</html>
