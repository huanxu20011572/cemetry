<%@ page contentType="text/html; charset=GBK" %>
<%@ include file="/common/taglibs.jsp"%>
<script language="javascript">	
	function toMessage(){
		if(opener){
			var strForm = opener.loginForm;
			strForm.username.value = '';
			strForm.password.value = '';
		}
		alert("�û��������벻�ԣ����������룡");
		location= "/gUnit_gmgl";
	}
</script>
<html>
<body onLoad="toMessage()">
<form action="" method="post">
</form>
</body>		
</html>	

