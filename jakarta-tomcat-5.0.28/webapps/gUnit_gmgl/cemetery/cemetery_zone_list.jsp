<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ include file="../common/head.jsp"%>
<body style="background-color: transparent">
	<table width="98%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="40" align="left"> 
				<form id='goToCreatePage' action="cemeteryZoneController.fj?method=getCemeteryZoneCreate&pid=<c:out value='${param.pid}'/>" method="post">
					<input id="save_chargeInfo_btn"  name="button" type="button"  onclick="this.form.submit()" class="button-z2" value="新建" />
				</form>
		    </td>
		</tr>
	</table>
	<table width="98%" cellpadding="0" cellspacing="1" bgcolor="#a6c6da">
		<tr>
			<td height="30" align="center" bgcolor="#D4E5F4">序号</td>
			<td align="center" bgcolor="#D4E5F4">节点名称</td>
			<td align="center" bgcolor="#D4E5F4">排序</td>
			<td align="center" bgcolor="#D4E5F4">是否有效</td>
			<td align="center" bgcolor="#D4E5F4">备注</td>
			<td align="center" bgcolor="#D4E5F4">操作</td>
		</tr>
		<c:forEach var="en" items="${list}" varStatus="status">
			<tr>
				<td height="30" align="center" bgcolor="#FFFFFF"><c:out
						value='${status.count}' /></td>
				<td align="center" bgcolor="#FFFFFF"><c:out
						value='${en.cemeteryZoneName}' /></td>
				<td align="center" bgcolor="#FFFFFF"><c:out value='${en.sort}' />
				</td>
				<td align="center" bgcolor="#FFFFFF">
					<c:if test="${en.isValidate == '1'}">是</c:if>
					<c:if test="${en.isValidate == '0'}">否</c:if>
				</td>
				<td align="center" bgcolor="#FFFFFF"><c:out
						value='${en.remark}' /></td>
				<td align="center" bgcolor="#FFFFFF" class="word-7"><a
					href="cemeteryZoneController.fj?method=getCemeteryZoneViewById&id=<c:out value='${en.id}'/>&pid=<c:out value='${param.pid}'/>">查看</a>&nbsp;&nbsp;
					<a
					href="cemeteryZoneController.fj?method=getCemeteryZoneEditById&id=<c:out value='${en.id}'/>&pid=<c:out value='${param.pid}'/>">编辑</a>&nbsp;&nbsp;
					<a	href="#" onclick="confirmDelete(<c:out value='${en.id}'/>,<c:out value='${param.pid}'/>)">删除</a></td>
			</tr>
		</c:forEach>
	</table>
	<form id="isdelform" method="post"></form>
	<table width="98%" border="0" cellspacing="0" cellpadding="10"
		class="word-4">
		<tr align="right">
			<td><ft:page
					action="cemeteryZoneController.fj?method=getCemteryZoneListByPid"
					page="${page}">
					<input type="hidden" id="pid" name="pid"
						value="<c:out value='${param.pid}'/>" />
				</ft:page>
			</td>
			<td width="120"><ft:pageInfo page="${page}" /></td>
		</tr>
	</table>
	<script type="text/javascript">
	function confirmDelete(id,pid){
		if(confirm("确定要删除？"))
		{
			var url="cemeteryZoneController.fj?method=deleteCemeteryZoneById&id="+id+"&pid="+pid;
			$("#isdelform").attr("action",url);
		    $("#isdelform").submit();  
		}
		 
	 }

	</script>
</body>
</html>
