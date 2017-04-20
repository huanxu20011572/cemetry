<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ include file="../common/head.jsp"%>
<body style="background-color: transparent" id="chargeDataListBody">
	<table width="98%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="40" align="left">
				<c:if test="${param.ctid != null}">
			 		<input name="button" type="button" onclick="location.href='chargeDataController.fj?method=getChargeData&ctid=${param.ctid}'" class="button-z" id="button" value="新建" /> 
				</c:if>
			</td>
		</tr>
	</table>
	<table width="98%" cellpadding="0" cellspacing="1" bgcolor="#a6c6da">

		<tr>
			<td height="30" align="center" bgcolor="#D4E5F4">序号</td>
			<td align="center" bgcolor="#D4E5F4">费用名称</td>						
			<td align="center" bgcolor="#D4E5F4">是否有效</td>
			<td align="center" bgcolor="#D4E5F4">排序</td>
			<td align="center" bgcolor="#D4E5F4">备注</td>
			<td align="center" bgcolor="#D4E5F4">操作</td>
		</tr>
		<c:if test="${!empty list}">
			<c:forEach var="item" items="${list}" varStatus="status">
				<tr>
					<td height="30" align="center" bgcolor="#FFFFFF"><c:out value='${status.count}'/></td>
					<td align="center" bgcolor="#FFFFFF">${item.chargeDataName}</td>
					<td align="center" bgcolor="#FFFFFF">
					<c:choose>
			          <c:when test="${item.isValidate==1}">是</c:when>
			          <c:otherwise>否</c:otherwise>
					</c:choose>
					</td>
					<td align="center" bgcolor="#FFFFFF">${item.sort}</td>
					<td align="center" bgcolor="#FFFFFF">${item.remark}</td>
					<td align="center" bgcolor="#FFFFFF" class="word-7">
					<a href="chargeDataController.fj?method=getChargeData&id=${item.id}&ctid=${param.ctid}">编辑</a>
					&nbsp;&nbsp;
					<a href="chargeDataController.fj?method=deleteChargeData&id=${item.id}&ctid=${param.ctid}">删除</a>
					</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>



	<script type="text/javascript">
	$(function(){
		  $('#lefttree').tree({
		    url:'data/tree_data_fyflgl.json',
		    animate:true,
			onSelect: function(node){
				  $('#p').panel('close');
			}
			
		  });
		
  });

</script>

</body>
</html>