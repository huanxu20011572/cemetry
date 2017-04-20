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
        <td height="31" align="left" valign="middle" style="background:url(../images/right-3.jpg)"><img src="../images/right-4.jpg" width="9" height="8" align="absmiddle" /> 当前位置 &gt;商品管理 &gt; 出库信息</td>
      </tr>
      <tr>
        <td bgcolor="#FFFFFF" style="font-size:12px;">&nbsp;</td>
      </tr>
    </table>
    <form action="cemeteryChargeController.fj?method=getCemeteryChargeList" id="queryForm" method="post">
	<table width="98%" cellpadding="0" cellspacing="1" bgcolor="#a6c6da">
        <tr>
          <td width="18%" height="35" align="right" bgcolor="#D4E5F4">商品名称：</td>
          <td width="32%" align="left" bgcolor="#FFFFFF">
		    <input name="productName" type="text" class="input-1" id="productName" value="<c:out value='${param.productName}'/>"/>
		  </td>
          <td width="17%" align="right" bgcolor="#D4E5F4">商品分类：</td>
          <td width="33%" align="left" bgcolor="#FFFFFF">
          <ft:select name="productType" type="spfl" selected="${param.productType}" style="width:190px"></ft:select>
          </td>
        </tr>
        <tr bgcolor="#FFFFFF">
               <td height="35"  colspan="4" align="center"  bgcolor="#FFFFFF" >			    
			      <input name="button" type="submit" class="button-z" id="button" value="查询" /> 
				   &nbsp;&nbsp;
				  <input name="button2" type="reset" class="button-z" id="button2" value="重置" />
			   </td>                                              
        </tr>
      </table>
      </form>
	<form action="cemeteryChargeController.fj?method=editCemeteryCharge" id="addForm" method="post">
	<table width="98%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="40" align="left">
			<input name="button3" type="submit" class="button-z4" id="button3" value="出库登记" />
			</td>
		</tr>
	</table>
	</form>
	<table width="98%" cellpadding="0" cellspacing="1" bgcolor="#a6c6da">
		<tr>
			<td height="30" align="center" bgcolor="#D4E5F4">序号</td>
			<td align="center" bgcolor="#D4E5F4">商品名称</td>
			<td align="center" bgcolor="#D4E5F4">商品类别</td>
			<td align="center" bgcolor="#D4E5F4">单价（元）</td>
			<td align="center" bgcolor="#D4E5F4">出库数量</td>
			<td align="center" bgcolor="#D4E5F4">出库类别</td>
			<td align="center" bgcolor="#D4E5F4">登记人</td>
			<td align="center" bgcolor="#D4E5F4">登记日期</td>
			<td align="center" bgcolor="#D4E5F4">操作</td>
		</tr>
		<c:forEach  var="en" items="${list}" varStatus="status">
		<tr>
			<td height="30" align="center" bgcolor="#FFFFFF"><c:out value='${status.count}'/></td>
			<td align="center" bgcolor="#FFFFFF"><c:out value='${en.productName}'/></td>
			<td align="center" bgcolor="#FFFFFF"><c:out value='${en.productType}'/></td>
			<td align="center" bgcolor="#FFFFFF"><c:out value='${en.price}'/></td>
			<td align="center" bgcolor="#FFFFFF"><c:out value='${en.count}'/></td>
			<td align="center" bgcolor="#FFFFFF">
				<c:choose>
		          <c:when test="${en.outStorehouseType==1}">
					售卖
		          </c:when>
		          <c:when test="${en.outStorehouseType==2}">
					赠送
		          </c:when>
		          <c:when test="${en.outStorehouseType==3}">
					损耗
		          </c:when>
				</c:choose>
			</td>
			<td align="center" bgcolor="#FFFFFF"><gOS_shjz:shjzUser key="${en.createUserId}"/></td>
			<td align="center" bgcolor="#FFFFFF"><c:out value='${en.createDate}'/></td>
			<td align="center" bgcolor="#FFFFFF" class="word-7">
			<a href="cemeteryChargeController.fj?method=showCemeteryCharge&id=<c:out value='${en.id}'/>">查看</a>&nbsp;&nbsp;
			<a href="#" onclick="confirmDelete(<c:out value='${en.id}'/>)">删除</a></td>
			</td>
		</tr>
		</c:forEach>
	</table>
	<table width="98%" border="0" cellspacing="0" cellpadding="10" class="word-4">
		<tr align="right" >
			<td >
			<ft:page action="cemeteryChargeController.fj?method=getCemeteryChargeList" page="${page}">
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
				var url="cemeteryChargeController.fj?method=deleteCemeteryCharge&id="+id ;
				$("#isdelform").attr("action",url);
			    $("#isdelform").submit();  
			}
		 }
	</script>
</body>
</html>
