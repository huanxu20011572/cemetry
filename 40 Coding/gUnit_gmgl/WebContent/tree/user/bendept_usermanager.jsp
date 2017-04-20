<%@ page contentType="text/html; charset=GBK" %>
<%@ include file="../../common/taglibs.jsp"%>
<%@page import="com.topsuntech.gOS.user.session.*" %>
<%@page import="com.topsuntech.gOS.user.en.user.*" %>
<%@ page import="com.topsuntech.gOS.user.en.region.Region" %>
<link href="/ajjwork/css/css.css" rel="stylesheet" type="text/css">
<%@ include file="../../../common/meta.jsp"%>

<%
	User user = UserSession.getUser(request);
	
	long creatorid = 20003;
	if (user!=null) {
		
		creatorid = user.getId().longValue();
	}

%>

<c:redirect url="../../main/system/zxt_mgm/deptUserQueryList.do?queryName=managedDeptUsers&resetForm=true&creatorid=<%=creatorid%>&type=deptman&inputPath=deptUsers" />

	
<html>
<head>
<title></title>

</head>

			
</html>
