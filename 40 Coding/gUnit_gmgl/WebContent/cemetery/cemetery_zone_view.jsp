<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ include file="../common/head.jsp"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
<header> </header>
<body style="background-color: transparent">

		 <input type="hidden" value="<c:out value='${param.id}'/>" name="id" id="id" />

		<table width="98%" cellpadding="0" cellspacing="1" bgcolor="#a6c6da">
			<tr>
				<td width="24%" height="35" align="right" bgcolor="#D4E5F4">节点名称：</td>
				<td width="29%" align="left" bgcolor="#FFFFFF"><c:out value='${zone.cemeteryZoneName}'/><input name="sort"
					type="text" id="sort" class="input-1"   style="visibility:hidden" /></td>
				<td width="24%" align="right" bgcolor="#D4E5F4">是否有效：</td>
				<td width="23%" align="left" bgcolor="#FFFFFF">
					<c:if test="${en.isValidate == '1'}">是</c:if>
					<c:if test="${en.isValidate == '0'}">否</c:if>
				</td>
			</tr>
			<tr>
				<td height="35" align="right" bgcolor="#D4E5F4">排序：</td>
				<td align="left" bgcolor="#FFFFFF"><c:out value='${zone.sort}'/> </td>
				<td height="35" align="right" bgcolor="#D4E5F4"></td>
				<td align="left" bgcolor="#FFFFFF"></td>
			</tr>
			<tr>
				<td height="35" align="right" bgcolor="#D4E5F4">创建人：</td>
				<td align="left" bgcolor="#FFFFFF"><gOS_shjz:shjzUser key="${zone.createUserId}"/></td>
				<td height="35" align="right" bgcolor="#D4E5F4">创建时间：</td>
				<td align="left" bgcolor="#FFFFFF"><c:out value='${zone.createDate}'/></td>
			</tr>
			<tr>
				<td height="35" align="right" bgcolor="#D4E5F4">备注：</td>
				<td colspan="3" align="left" bgcolor="#FFFFFF" ><c:out value='${zone.remark}' /></td>
			</tr>
			<tr>
				<td height="35" colspan="4" align="center" bgcolor="#FFFFFF"> <input  name="button" type="button"  onclick="javascirpt:location.href='cemeteryZoneController.fj?method=getCemteryZoneListByPid&pid=${param.pid}';" class="button-z2" value="返回" /></td>
			</tr>
		</table>
</body>
</html>