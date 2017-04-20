<%@ page contentType="text/html; charset=GBK" %>
<%	
request.getSession().setAttribute("logType", "mima");		
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>北京公墓管理系统</title>
<link href="css/login-style.css" rel="stylesheet" type="text/css" />
</head>
<script type="text/javascript">
function onSubmit(){
	if(document.loginform.username.value == ""){
		alert("请输入用户名！");
		return false;
	}
	if(document.loginform.password.value == ""){
		alert("请输入密码！");
		return false;
	}
	document.loginform.submit();
}

</script>
<body>
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td>
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="95" align="center" background="images/login-top-bg.jpg"><img src="images/login-top-banner1.jpg" height="80" /></td>
  </tr>
</table>
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
<form name="loginform" method="post" action="login.do" >
<input type="hidden" name="action" value="login">
<input type="hidden" name="sysTemFlag" value="tjbz" >
  <tr>
    <td height="366" align="center" background="images/login-body-bg1.jpg"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="50%" height="259" align="right" class="login-bg-5">&nbsp;</td>
        <td align="left" valign="top" class="login-bg-6"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="242" height="191">&nbsp;</td>
            <td align="left" valign="bottom"><input type="text" name="username" value=""  class="login-input-1" /></td>
          </tr>
          <tr>
            <td height="49">&nbsp;</td>
            <td align="left" valign="bottom"><input name="password"  type="password" class="login-input-1"/></td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td height="200" align="right" class="login-bg-7">&nbsp;</td>
        <td align="left" valign="top" class="login-bg-8"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="187">&nbsp;</td>
            <td width="502" height="55" align="left" valign="bottom"><img src="images/login-but-2.jpg" width="229" height="39"   style="cursor:hand" onclick="return onSubmit();"/></td>
            </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
</form>
</table>
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="105" align="center" valign="top" background="images/login-bottom-bg.jpg"><table width="100" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="20">&nbsp;</td>
      </tr>
    </table>
    版权所有</td>
  </tr>
</table>
</td>
  </tr>
</table>
</body>
</html>
