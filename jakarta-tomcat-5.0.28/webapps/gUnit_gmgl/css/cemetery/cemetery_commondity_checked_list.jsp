<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ include file="../common/head.jsp"%>
<body style="background-color: transparent">
	<table width="100%" cellpadding="0" cellspacing="1" bgcolor="#a6c6da" >
        <tr>
          <td width="4%" height="30" align="center" bgcolor="#D4E5F4">选择</td>
          <td width="28%" align="center" bgcolor="#D4E5F4">商品名称</td>
          <td width="28%" align="center" bgcolor="#D4E5F4">商品类别</td>
          <td width="28%" align="center" bgcolor="#D4E5F4">单价（元）</td>
          <td width="28%" align="center" bgcolor="#D4E5F4">库存量</td>      
        </tr>
        <c:forEach  var="commodity" items="${list}" varStatus="status">
	        <tr>
	          <td width="4%" height="30" align="center" bgcolor="#FFFFFF"><input type='checkbox' onclick="parent.doAppendCharge(this,'${commodity.id}','${commodity.commodityName}',0,'<ft:dict value='${commodity.commodityType}'/>','${commodity.outPrice}','${commodity.count}');"/></td>	
	          <td width="28%" align="center" bgcolor="#FFFFFF"><c:out value='${commodity.commodityName}'/></td>
	          <td width="28%" align="center" bgcolor="#FFFFFF"><ft:dict value='${commodity.commodityType}'/></td>
	          <td width="28%" align="center" bgcolor="#FFFFFF"><c:out value='${commodity.outPrice}'/></td>
	          <td width="28%" align="center" bgcolor="#FFFFFF"><c:out value='${commodity.count}'/></td>   
	        </tr>
        </c:forEach>
    </table>
	<table width="100%" border="0" cellspacing="0" cellpadding="10" class="word-4">
		<tr align="right" >
			<td>
				<ft:page action="cemeteryCommodityController.fj?method=getCemeteryCommodityList&checked=checked" page="${page}">
				      <input type='hidden' id='commodityName' name='commodityName' value="<c:out value='${param.commodityName}'/>"/>
				</ft:page>
			</td>
			<td width="120"><ft:pageInfo page="${page}"/></td>
		</tr>
	</table>
</body>
</html>
