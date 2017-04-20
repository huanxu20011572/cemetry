<%@ page contentType="text/html; charset=UTF-8" isErrorPage="true" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ include file="../common/head.jsp" %>
<body>
<div align="center" style="height:150px; width:500px; margin:0 auto;">
  <p>&nbsp;</p>
  <p><img src="../images/error.gif" width="243" height="66" /></p>
  <p><input name="button" type="button" onclick="javascript:history.back();" class="button-z2" value="返回"/></p>
</div>
<div style="height:200px; width:500px; margin:0 auto; color:#EBF4FA;">
<%=exception%>
</div>
	
</body>
</html>
