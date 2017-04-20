<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ include file="../common/head.jsp"%>
<body style="background-color: transparent">
	<table width="100%" border="0" cellspacing="0" cellpadding="0" height="100%">
  <tr>
    <td width="11" valign="top" class="td-bg"><img src="../images/right-1.jpg" /></td>
    <td align="center" valign="top" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="31" align="left" valign="middle" style="background:url(../images/right-3.jpg)"><img src="../images/right-4.jpg" width="9" height="8" align="absmiddle" /> 当前位置 &gt; 售前管理 &gt; 来访登记</td>
      </tr>
      <tr>
        <td bgcolor="#FFFFFF" style="font-size:12px;">&nbsp;</td>
      </tr>
    </table>
    <form action="visitReturnController.fj?method=getVisitReturnList" id="queryForm" method="post">
      <table width="98%" cellpadding="0" cellspacing="1" bgcolor="#a6c6da">

        <tr>
          <td width="15%" height="35" align="right" bgcolor="#D4E5F4">客户姓名：</td>
          <td width="35%" align="left" bgcolor="#FFFFFF">
          <input name="customerName" type="text" id="customerName" class="input-1" value="<c:out value='${param.customerName}'/>"/></td>
          <td width="15%" align="right" bgcolor="#D4E5F4">登记时间：</td>
          <td width="35%" align="left" bgcolor="#FFFFFF">
          <input name="beginCreateDate" type="text" class="Wdate" id="beginCreateDate" onfocus="WdatePicker()" value="<c:out value='${param.beginCreateDate}'/>" />
          	至
          	<input name="endCreateDate" type="text" class="Wdate" id="endCreateDate" onfocus="WdatePicker()" value="<c:out value='${param.endCreateDate}'/>" />
          </td>
        </tr>
        <tr>
          <td height="35" colspan="4" align="center" bgcolor="#FFFFFF">
          <input name="button" type="submit" class="button-z" id="button" value="查询" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              <input name="button2" type="reset" class="button-z" id="button2" value="重置" />
          </td>
        </tr>
      </table>
	 </form>
	 <form action="visitReturnController.fj?method=editVisitReturn" id="addForm" method="post">
	<table width="98%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="40" align="left">
			<input name="button3" type="submit" class="button-z" id="button3" value="登记" />
			</td>
		</tr>
	</table>
	</form>
	<table width="98%" cellpadding="0" cellspacing="1" bgcolor="#a6c6da">
		<tr>
			<td height="30" align="center" bgcolor="#D4E5F4">序号</td>
			<td align="center" bgcolor="#D4E5F4">客户姓名</td>
			<td align="center" bgcolor="#D4E5F4">联系电话</td>
			<td align="center" bgcolor="#D4E5F4">来访人数</td>
			<td align="center" bgcolor="#D4E5F4">客户来源</td>
			<td align="center" bgcolor="#D4E5F4">来访需求</td>
			<td align="center" bgcolor="#D4E5F4">回访情况</td>
			<td align="center" bgcolor="#D4E5F4">登记时间</td>
			<td align="center" bgcolor="#D4E5F4">操作</td>
		</tr>
		<c:forEach  var="en" items="${list}" varStatus="status">
		<tr>
			<td height="30" align="center" bgcolor="#FFFFFF"><c:out value='${status.count}'/></td>
			<td align="center" bgcolor="#FFFFFF"><c:out value='${en.customerName}'/></td>
			<td align="center" bgcolor="#FFFFFF"><c:out value='${en.customerTel}'/></td>
			<td align="center" bgcolor="#FFFFFF"><c:out value='${en.customerNum}'/></td>
			<td align="center" bgcolor="#FFFFFF"><c:out value='${en.customerSource}'/></td>
			<td align="center" bgcolor="#FFFFFF"><c:out value='${en.customerReq}'/></td>
			<td align="center" bgcolor="#FFFFFF"><c:out value='${en.returnRemark}'/></td>
			<td align="center" bgcolor="#FFFFFF"><c:out value='${en.createDate}'/></td>
			<td align="center" bgcolor="#FFFFFF" class="word-7">
			<c:choose>
	          <c:when test="${en.isReturn!=1}">
				<a href="visitReturnController.fj?method=editVisitReturn&id=<c:out value='${en.id}'/>">编辑</a>&nbsp;&nbsp;
				<a href="visitReturnController.fj?method=backVisitReturn&id=<c:out value='${en.id}'/>">回访</a><br/>
	          </c:when>
			</c:choose>
			<a href="visitReturnController.fj?method=showVisitReturn&id=<c:out value='${en.id}'/>">查看</a>&nbsp;&nbsp;
			<c:choose>
	          <c:when test="${en.isReturn!=1}">
				<a href="#" onclick="confirmDelete(<c:out value='${en.id}'/>)">删除</a>
	          </c:when>
			</c:choose>
			</td>
		</tr>
		</c:forEach>
	</table>
	<table width="98%" border="0" cellspacing="0" cellpadding="10" class="word-4">
		<tr align="right" >
			<td >
			<ft:page action="visitReturnController.fj?method=getVisitReturnList" page="${page}">
			</ft:page> 
			</td >
			<td width="120"><ft:pageInfo page="${page}"/></td>
		</tr>
	</table>
	<form  action ="" id="isdelform" method="post"> </form>
	<script type="text/javascript">
		function confirmDelete(id){
			if(confirm("确定要删除？"))
			{
				var url="visitReturnController.fj?method=deleteVisitReturn&id="+id ;
				$("#isdelform").attr("action",url);
			    $("#isdelform").submit();  
			}
		 }
	</script>
</body>
</html>
