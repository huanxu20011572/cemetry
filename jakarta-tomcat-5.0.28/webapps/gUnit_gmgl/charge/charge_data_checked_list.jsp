<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ include file="../common/head.jsp"%>
<body style="background-color: transparent">
	<table width="100%" height="100%" cellpadding="0" cellspacing="1" bgcolor="#a6c6da" >
        <tr>
          <td width="4%" height="30" align="center" bgcolor="#D4E5F4">选择</td>
          <td width="28%" align="center" bgcolor="#D4E5F4">费用明细</td>
          <td width="28%" align="center" bgcolor="#D4E5F4">费用分类</td>
          <td width="28%" align="center" bgcolor="#D4E5F4">费用大类</td>
          <td width="28%" align="center" bgcolor="#D4E5F4">价格</td>      
        </tr>
        <c:forEach  var="chargeData" items="${list}" varStatus="status">
	        <tr>
	          <td width="4%" height="30" align="center" bgcolor="#FFFFFF"><input type='checkbox' onclick="parent.doAppendCharge(this,'${chargeData.id}','${chargeData.chargeDataName}',1,'${chargeData.chargeType.chargeTypeName}','${chargeData.chargeDataPrice}',-1);"/></td>	 
	          <td width="28%" align="center" bgcolor="#FFFFFF"><c:out value='${chargeData.chargeDataName}'/></td>
	          <td width="28%" align="center" bgcolor="#FFFFFF"><c:out value='${chargeData.chargeType.chargeTypeName}'/></td>
	          <td width="28%" align="center" bgcolor="#FFFFFF"><ft:dict value='${chargeData.chargeType.chargeTypeDict}'/></td>
	          <td width="28%" align="center" bgcolor="#FFFFFF"><c:out value='${chargeData.chargeDataPrice}'/></td>   
	        </tr>
        </c:forEach>
      </table> 
	<table width="98%" border="0" cellspacing="0" cellpadding="10" class="word-4">
		<tr align="right" >
			<td>
				<ft:page action="../charge/chargeDataController.fj?method=getChargeDataList&checked=checked" page="${page}">
				      <input type='hidden' id='chargeDataName' name='chargeDataName' value="<c:out value='${param.chargeDataName}'/>"/>
				</ft:page>
			</td>
			<td width="120"><ft:pageInfo page="${page}"/></td>
		</tr>
	</table>
</body>
</html>