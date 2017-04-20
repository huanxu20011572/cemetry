<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ include file="../common/head.jsp"%>
<body style="background-color: transparent">
   <table width="100%" border="0" cellspacing="0" cellpadding="0"
		height="100%">
		<tr>
			<td width="11" valign="top" class="td-bg"><img
				src="../images/right-1.jpg" />
			</td>
			<td align="center" valign="top"><table width="100%" border="0"
					cellspacing="0" cellpadding="0">
					<tr>
						<td height="31" align="left" valign="middle"
							style="background: url(../images/right-3.jpg)"><img
							src="../images/right-4.jpg" width="9" height="8"
							align="absmiddle" /> 当前位置 &gt; 费用管理 &gt; 费用分类维护</td>
					</tr>
					<tr>
						<td bgcolor="#FFFFFF" style="font-size: 12px;">&nbsp;</td>
					</tr>
				</table>
	<form action="chargeTypeController.fj?method=saveChargeType"
		id="isform" method="post">
		<input type="hidden" value="<c:out value='${chargeType.id}'/>"
			name="id" id="id" />
		<table width="98%" cellpadding="0" cellspacing="1" bgcolor="#a6c6da">
			<tr>
				<td width="20%" height="35" align="right" bgcolor="#D4E5F4">费用分类：</td>
				<td width="30%" align="left" bgcolor="#FFFFFF"><c:out value='${chargeType.chargeTypeName}'/></td>
				<td width="21%" align="right" bgcolor="#D4E5F4">大分类：</td>
				<td width="29%" align="left" bgcolor="#FFFFFF" ><ft:dict value='${chargeType.chargeTypeDict}'/></td>
			</tr>
			<tr>
				<td align="right" bgcolor="#D4E5F4">是否有效：</td>
				<td align="left" bgcolor="#FFFFFF" style='width:25%'>
				   <c:if test="${chargeType.isValidate == '1'}">是</c:if>
				   <c:if test="${chargeType.isValidate != '1'}">否</c:if>
				</td>
				<td height="35" align="right" bgcolor="#D4E5F4">排序：</td>
				<td align="left" bgcolor="#FFFFFF"><c:out value='${chargeType.sort}'/></td>

			</tr>
			<tr>
				<td height="35" align="right" bgcolor="#D4E5F4">创建人：</td>
				<td align="left" bgcolor="#FFFFFF"> <c:out value='${chargeType.createUserId}'/></td>
				<td height="35" align="right" bgcolor="#D4E5F4">创建时间：</td>
				<td align="left" bgcolor="#FFFFFF"><c:out value='${chargeType.createDate}'/></td>
			</tr>
			<tr>
				<td height="35" align="right" bgcolor="#D4E5F4">备注：</td>
				<td colspan="3" align="left" bgcolor="#FFFFFF"><c:out value='${chargeType.remark}' /></td>
			</tr>
			<tr>
				<td height="35" colspan="4" align="center" bgcolor="#FFFFFF">
                   <input  name="button" type="button"  onclick="javascirpt:location.href='chargeTypeController.fj?method=getChargeTypeList';" class="button-z2" value="返回" />
		        
				</td>
			</tr>
		</table>
	</form>
		
          </td>
		</tr>
	</table>
</body>
</html>