<%@ page contentType="text/html; charset=GBK" %>
<%@ include file="../../../common/taglibs.jsp"%>
<c:if test="${empty param.adjustFlag}">
<c:redirect url="standardInfoList.do?method=getList" />				
</c:if>
<c:if test="${!empty param.adjustFlag}">
<c:redirect url="standardInfoList.do?method=getList&adjustFlag=true" />				
</c:if>
<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
</head>

			
</html>
