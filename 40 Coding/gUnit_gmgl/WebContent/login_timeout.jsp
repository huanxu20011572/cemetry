<%@ page contentType="text/html; charset=GBK" %>
<%@ include file="/common/taglibs.jsp"%>
<script language="javascript">	
	function toMessage(){
		alert("用户登录超时，请重新登陆！");
		top.frames.location = "/gUnit_gmgl";
	}
</script>
<html>
<body onLoad="toMessage()">
<form action="" method="post">
</form>
</body>		
</html>	

