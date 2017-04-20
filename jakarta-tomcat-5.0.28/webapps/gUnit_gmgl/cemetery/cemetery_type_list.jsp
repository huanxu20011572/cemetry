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
        <td height="31" align="left" valign="middle" style="background:url(../images/right-3.jpg)"><img src="../images/right-4.jpg" width="9" height="8" align="absmiddle" /> 当前位置 &gt; 墓区管理 &gt; 墓型管理</td>
      </tr>
      <tr>
        <td bgcolor="#FFFFFF" style="font-size:12px;">&nbsp;</td>
      </tr>
    </table>
    <form action="cemeteryTypeController.fj?method=getCemeteryTypeList" id="queryForm" method="post">
	<table width="98%" cellpadding="0" cellspacing="1" bgcolor="#a6c6da">
        
        <tr>
          <td width="15%" height="35" align="right" bgcolor="#D4E5F4">业务分类：</td>
          <td width="35%" align="left" bgcolor="#FFFFFF">
          <select name="businessName" id="businessName" style="width:184px;" >
	            <option value="-1">---请选择---</option>
	            <c:forEach  var="en" items="${businessDataList}" varStatus="status">
				     <c:choose>
		          		<c:when test="${param.businessName==en.businessName}">
				            <option value="<c:out value='${en.businessName}'/>" selected="selected"><c:out value='${en.businessName}'/></option>
			            </c:when>
			            <c:otherwise>
				            <option value="<c:out value='${en.businessName}'/>"><c:out value='${en.businessName}'/></option>
			            </c:otherwise>
			         </c:choose>
				</c:forEach>
            </select>
          </td>
          <td width="15%" align="right" bgcolor="#D4E5F4">墓型名称：</td>
          <td width="35%" align="left" bgcolor="#FFFFFF">
          <input name="cemeteryTypeName" type="text" id="cemeteryTypeName" class="input-1"  value="<c:out value='${param.cemeteryTypeName}'/>"/></td>
        </tr>
        <tr>
          <td width="15%" height="35" align="right" bgcolor="#D4E5F4">墓型类别：</td>
          <td width="35%" align="left" bgcolor="#FFFFFF">
          <ft:select name="cemeteryProperty" type="mxlb" selected="${param.cemeteryProperty}" style="width:190px"></ft:select>
          <td width="15%" align="right" bgcolor="#D4E5F4">穴别：</td>
          <td width="35%" align="left" bgcolor="#FFFFFF">
          <select name="cave" id="cave" style="width:184px;" >
	            <option value="-1" selected="selected">---请选择---</option>
	            <c:choose>
	          		<c:when test="${param.cave=='1'}">
			            <option value="1" selected="selected">单穴</option>
			            <option value="2">双穴</option>
			            <option value="3">多穴</option>
		            </c:when>
		            <c:when test="${param.cave=='2'}">
			            <option value="1">单穴</option>
			            <option value="2" selected="selected">双穴</option>
			            <option value="3">多穴</option>
		            </c:when>
		            <c:when test="${param.cave=='3'}">
			            <option value="1">单穴</option>
			            <option value="2">双穴</option>
			            <option value="3" selected="selected">多穴</option>
		            </c:when>
		            <c:otherwise>
			            <option value="1">单穴</option>
			            <option value="2">双穴</option>
			            <option value="3">多穴</option>
		            </c:otherwise>
		         </c:choose>
            </select>
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
      <form action="cemeteryTypeController.fj?method=editCemeteryType" id="addForm" method="post">
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
			<td align="center" bgcolor="#D4E5F4">墓型编号</td>
			<td align="center" bgcolor="#D4E5F4">业务分类</td>
			<td align="center" bgcolor="#D4E5F4">墓型名称</td>
			<td align="center" bgcolor="#D4E5F4">墓型类别</td>
			<td align="center" bgcolor="#D4E5F4">穴别</td>
			<td align="center" bgcolor="#D4E5F4">墓型面积</td>
			<td align="center" bgcolor="#D4E5F4">护盒尺寸</td>
			<td align="center" bgcolor="#D4E5F4">墓穴总价格</td>
			<td align="center" bgcolor="#D4E5F4">操作</td>
		</tr>
		<c:forEach  var="en" items="${list}" varStatus="status">
		<tr>
			<td height="30" align="center" bgcolor="#FFFFFF"><c:out value='${status.count}'/></td>
			<td align="center" bgcolor="#FFFFFF"><c:out value='${en.cemeteryTypeCode}'/></td>
			<td align="center" bgcolor="#FFFFFF"><c:out value='${en.businessData.businessName}'/></td>
			<td align="center" bgcolor="#FFFFFF"><c:out value='${en.cemeteryTypeName}'/></td>
			<td align="center" bgcolor="#FFFFFF"><ft:dict value='${en.cemeteryProperty}'/></td>
			<td align="center" bgcolor="#FFFFFF">
			<c:choose>
	          <c:when test="${en.cave=='1'}">单穴</c:when>
	          <c:when test="${en.cave=='2'}">双穴</c:when>
	          <c:when test="${en.cave=='3'}">多穴</c:when>
			</c:choose>
			</td>
			<td align="center" bgcolor="#FFFFFF">
				<fmt:formatNumber var="a" value="${en.area}" pattern="#.00"/>   
				<c:out value="${a}" />
			</td>
			<td align="center" bgcolor="#FFFFFF"><c:out value='${en.boxsize}'/></td>
			<td align="center" bgcolor="#FFFFFF">
				<fmt:formatNumber var="p" value="${en.totalPrice}" pattern="#.00"/>   
				<c:out value="${p}" />
			</td>
			<td align="center" bgcolor="#FFFFFF" class="word-7">
			<a href="cemeteryTypeController.fj?method=showCemeteryType&id=<c:out value='${en.id}'/>">查看</a>&nbsp;&nbsp;
			<a href="cemeteryTypeController.fj?method=editCemeteryType&id=<c:out value='${en.id}'/>">编辑</a>&nbsp;&nbsp;
			<a href="#" onclick="confirmDelete(<c:out value='${en.id}'/>)">删除</a></td>
		</tr>
		</c:forEach>
	</table>
	<table width="98%" border="0" cellspacing="0" cellpadding="10" class="word-4">
		<tr align="right" >
			<td >
			<ft:page action="cemeteryTypeController.fj?method=getCemeteryTypeList" page="${page}">
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
				var url="cemeteryTypeController.fj?method=deleteCemeteryType&id="+id ;
				$("#isdelform").attr("action",url);
			    $("#isdelform").submit();  
			}
		 }
	</script>
</body>
</html>
