<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ include file="../common/head.jsp"%>
<body style="background-color: transparent">
	<table width="98%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="40" align="left">
			 <input name="button" type="button" onclick="location.href='dictController.fj?method=getDictCreateData&pid=<c:out value='${param.pid}'/>'" class="button-z" id="button" value="新建" /> 
			</td>
		</tr>
	</table>
	<table width="98%" cellpadding="0" cellspacing="1" bgcolor="#a6c6da">
		<tr>
			<td height="30" align="center" bgcolor="#D4E5F4">序号</td>
			<td align="center" bgcolor="#D4E5F4">字典名称</td>
			<td align="center" bgcolor="#D4E5F4">字典编码</td>
			<td align="center" bgcolor="#D4E5F4">排序</td>
			<td align="center" bgcolor="#D4E5F4">是否有效</td>
			<td align="center" bgcolor="#D4E5F4">备注</td>
			<td align="center" bgcolor="#D4E5F4">操作</td>
		</tr>
		<c:forEach  var="en" items="${list}" varStatus="status">
		<tr>
			<td height="30" align="center" bgcolor="#FFFFFF"><c:out value='${status.count}'/></td>
			<td align="center" bgcolor="#FFFFFF"><c:out value='${en.dictName}'/></td>
			<td align="center" bgcolor="#FFFFFF"><c:out value='${en.dictCode}'/></td>
			<td align="center" bgcolor="#FFFFFF"><c:out value='${en.sort}'/></td>
			<td align="center" bgcolor="#FFFFFF">
			<%-- <c:out value='${en.isValidate}'/> --%>
										<c:choose>
										<c:when  test="${en.isValidate == '1'}">  是
                                        </c:when>
										<c:otherwise>否  
                                        </c:otherwise>
									</c:choose>
			</td>
			<td align="center" bgcolor="#FFFFFF"><c:out value='${en.remark}'/></td>
			<td align="center" bgcolor="#FFFFFF" class="word-7">
			<a href="dictController.fj?method=getDictEditById&id=<c:out value='${en.id}'/>&pid=<c:out value='${param.pid}'/>">编辑</a>&nbsp;&nbsp;
			<a href="#" onclick="confirmDelete(<c:out value='${en.id}'/>,<c:out value='${param.pid}'/>)">删除</a></td>
		</tr>
		</c:forEach>
	</table>
    <form  id="isform" method="post"></form>
 	<table width="98%" border="0" cellspacing="0" cellpadding="10" class="word-4">
		  <tr align="right" >
			<td >
			<ft:page action="dictController.fj?method=getDictListByPID" page="${page}">
					<input type="hidden" id="pid" name="pid" value="<c:out value='${param.pid}'/>" /> 
			</ft:page>  
			</td >
			<td width="120"><ft:pageInfo page="${page}"/></td>
		</tr> 
	</table> 
	<script type="text/javascript">
	function confirmDelete(id,pid){
		if(confirm("确定要删除？"))
		{
			var url="dictController.fj?method=deleteDictById&id="+id+"&pid="+pid;
			$("#isform").attr("action",url);
		    $("#isform").submit();  
		}
		 
	 }
	</script>
</body>
</html>
