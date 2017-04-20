<%@ page contentType="text/html; charset=GBK" %>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib uri="http://www.topsuntech.com/jsptags/tree-taglib" prefix="topsuntech" %>
<%@ taglib uri="/WEB-INF/tld/gTaglib-gOS.tld" prefix="gOS" %>
<%@page import="com.topsuntech.gOS.user.session.*" %>
<%@page import="com.topsuntech.gOS.user.en.user.*" %>
<%@ page import="com.topsuntech.gOS.user.en.region.Region" %>
<link href="../../css/css.css" rel="stylesheet" type="text/css">


<%
	User user = UserSession.getUser(request);
	
	long creatorid = 20003;
	if (user!=null) {		
		creatorid = user.getId().longValue();		
	}
	request.getRequestDispatcher("../user_mgm/PriorityDetail.do?action=getPriority&id="+creatorid).forward(request, response);
%>



	
<html>
<head>
<title></title>

</head>

			
</html>
