<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ include file="../common/head.jsp"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
<header> </header>
<body style="background-color: transparent">
	<form action="cemeteryZoneController.fj?method=saveCemeteryZone" id="isform"
		method="post">

		<input type="hidden" value="<c:out value='${zone.id}'/>"
			name="pid" id="pid" /> 

		<table width="98%" cellpadding="0" cellspacing="1" bgcolor="#a6c6da">
			<tr>
				<td width="16%" height="35" align="right" bgcolor="#D4E5F4">节点名称：</td>
				<td width="34%" align="left" bgcolor="#FFFFFF"><input name="cemeteryZoneName"
					type="text" id="cemeteryZoneName" class="input-1" /> <span class="word-7">*</span></td>
				<td width="17%" align="right" bgcolor="#D4E5F4">是否有效：</td>
				<td width="33%" align="left" bgcolor="#FFFFFF">
					<!-- 		<input name="isValidate" type="text" id="isValidate" class="input-1"/> -->
					<select name="isValidate" class="input-1" style='height: 22px'>
						<option value='1'
							<c:if test="${param.isValidate == '1'}">selected</c:if>>是</option>
						<option value='0'
							<c:if test="${param.isValidate == '0'}">selected</c:if>>否</option>
				</select></td>
			</tr>
			<tr>
				<td height="35" align="right" bgcolor="#D4E5F4">排序：</td>
				<td align="left" bgcolor="#FFFFFF"><input name="sort"
					type="text" id="sort" class="input-1"
					value="0" /></td>
				<td height="35" align="right" bgcolor="#D4E5F4"></td>
				<td align="left" bgcolor="#FFFFFF"></td>
			</tr>
			<tr>
				<td height="35" align="right" bgcolor="#D4E5F4">创建人：</td>
				<td align="left" bgcolor="#FFFFFF"> <gOS_shjz:shjzUser key="${zone.createUserId}"/></td>
				<td height="35" align="right" bgcolor="#D4E5F4">创建时间：</td>
				<td align="left" bgcolor="#FFFFFF"><c:out value='${zone.createDate}'/></td>
			</tr>
			<tr>
				<td height="35" align="right" bgcolor="#D4E5F4">备注：</td>
				<td colspan="3" align="left" bgcolor="#FFFFFF"><textarea
						name="remark" id="remark" style='height: 40px; width: 90%'
						class="input-1"></textarea></td>
			</tr>
			<tr>
				<td height="35" colspan="4" align="center" bgcolor="#FFFFFF"> 
				  <input  name="button" type="button"  onclick="javascript:doSave();" class="button-z2" value="保存" />
				  &nbsp;&nbsp;&nbsp;&nbsp;
				  <input  name="button" type="button"  onclick="javascirpt:location.href='cemeteryZoneController.fj?method=getCemteryZoneListByPid&pid=${param.pid}';"  class="button-z2" value="返回" />
		        </td>
			</tr>
		</table>
	</form>
	<script type="text/javascript">
	
		function doSave() {
			
			var pid = $("#pid").val();
			var cemeteryZoneName = $.trim($("#cemeteryZoneName").val());
			var sort = $("#sort").val();
			var remark = $("#remark").val();
			//TODO:验证：
			if (cemeteryZoneName.length > 20||cemeteryZoneName==0) {
				alert("节点名称长度为0至20个字符之间");
				return;
			}
			if (remark.length > 200) {
				alert("备注长度不超过200个字符");
				return;
			}
			if (!/^[0-9]+$/g.test(sort)) {
				alert("排序字段为数字");
				return;
			}
			$("#isform").submit();
		}
	</script>
</body>
</html>