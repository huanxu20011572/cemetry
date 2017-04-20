<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="../common/taglibs.jsp"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
<title>北京公墓管理系统</title>
<link rel="icon" href="${pageContext.request.contextPath}/favicon.ico" type="image/x-icon" media="screen" />
<link rel="shortcut icon" href="${pageContext.request.contextPath}/favicon.ico" type="image/x-icon" media="screen" />
<link href="../css/css.css" rel="stylesheet" type="text/css" />
</head>
<title>墓区信息一览</title>
<script type="text/javascript">

function autoIframe() {
	var ifm= document.getElementById("iframepage");
	var subWeb = document.frames ? document.frames["iframepage"].document : ifm.contentDocument;
	if(ifm != null && subWeb != null) {
		ifm.height = subWeb.body.scrollHeight;
	}
} 

</script>
</head>
 
<body style="background-color:transparent">
<table width="100%" border="0" cellspacing="0" cellpadding="0" height="100%">
  <tr>
    <td width="11" valign="top" class="td-bg"><img src="../images/right-1.jpg" /></td>
    <td align="center" valign="top" >
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="31" align="left" valign="middle" style="background:url(../images/right-3.jpg)"><img src="../images/right-4.jpg" width="9" height="8" align="absmiddle" /> 当前位置  &gt; 打印业务单</td>
      </tr>
      <tr>
        <td bgcolor="#FFFFFF" style="font-size:12px;">&nbsp;</td>
      </tr>
      <tr>
        <td bgcolor="#FFFFFF" style="font-size:12px;"><input name="button" class="button-z" type="button" onclick="javascript:history.go(-1);" value="返回"/></td>
      </tr>
    </table>
	<br/>
	  <iframe onLoad="autoIframe();" id="iframepage" name="iframepage" frameBorder=0 scrolling=no width="98%" 
      		src="../reportJsp/showReport.jsp?raq=/business_detail.raq&id=<c:out value="${param.id}" />&org_name=<c:out value='${param.org_name}' />" ></iframe>
</body>
</html>