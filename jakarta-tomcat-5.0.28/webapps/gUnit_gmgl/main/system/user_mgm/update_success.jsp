<%@ page contentType="text/html; charset=GBK" %>
<%@ include file="/common/taglibs.jsp"%>
<script language="javascript">	
	function toMessage(){
		opener.location.href=opener.location.href;
    opener=null;
		alert("���³ɹ���");
    window.close(); 	
	}
</script>
<html>
<body onLoad="toMessage()">
<form action="" method="post">
</form>
</body>		
</html>	

