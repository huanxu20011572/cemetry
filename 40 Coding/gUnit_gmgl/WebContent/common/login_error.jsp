<%@ page contentType="text/html; charset=GBK" %>
<%@ include file="/common/taglibs.jsp"%>
<script language="javascript">	
	function toMessage(){
		if(opener){
			var strForm = opener.loginForm;
			strForm.username.value = '';
			strForm.password.value = '';
		}
		alert("用户名与密码不对，请重新输入！");
		location= "/gUnit_gmgl";
	}
</script>
<html>
<body onLoad="toMessage()">
<form action="" method="post">
</form>
</body>		
</html>	

