<%@ page contentType="text/html; charset=GBK" %>
<%@ include file="../../common/taglibs.jsp"%>
<%@ include file="../../common/js_common.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<link href="../../css/style.css" rel="stylesheet" type="text/css" />
<title>��ת��ʾ</title>
<%
	String adjustType = request.getParameter("adjustType");	
%>
<script language="javascript" type="text/javascript">
function initSuccess(){
	alert('�����ɹ���');
	var adjustType = document.getElementById("adjustType").value;
	if(adjustType == '50161'){
		location.replace('../tree/doAddAdjust.do?method=list&adjustType=50161');
	}else if (adjustType == '50162'){
		location.replace('../tree/doAddAdjust.do?method=list&adjustType=50162');
	}
	
}
</script>
</head>

<body  onload="initSuccess();">
<input type="hidden" name="adjustType" value="<c:out value='${adjustType}'/>" />
</body>
</html>
