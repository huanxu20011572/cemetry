<%@ page contentType="text/html; charset=GBK" %>
<%@ include file="../../common/taglibs.jsp"%>
<%@ include file="../../main_bjsj/public/css.jsp" %>


<html>

<title>用户的邮箱修改 </title>
<head></head>


<script language="javascript">
	
	function doSave(){
		var strForm = document.userForm;
		var emailid = strForm.emailid;
		
		if(Jtrim(emailid.value).length == 0){
			alert("操作提示：邮箱不能为空！");	
			return ;
		}
		
		strForm.action = "updateEmailToUser.do?method=updateEmail";
		strForm.submit();		
		
	}
	
</script>			
	
<body>
	
	
<form name="userForm" method="post" >
<input type="hidden" name="id" value="<c:out value="${updateUser.id}" />">
<table border="0">
	<tr>
		<td>邮箱：</td>
		<td>
				<input name="emailid" type="text" value="<c:out value="${updateUser.emailid}" />" 
				   size="25" width="150" height="10" maxlength="100">@mail.bjhd.gov.cn			   				   	
		</td>
	</tr>		 
	<tr>
    <td width="60" class="td16">
    	<input name="btname" type="button" class="input_btn" onClick="return doSave();" value="确定" >
    </td>
    <td width="60" class="td16">    
    	<input name="Submit2" type="submit" class="input_btn" onClick="javascript:history.back();" value="取消"></td>
	 </tr>		

</table>
</form>		
	
	
</body>		
	
</html>	