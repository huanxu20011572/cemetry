<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ include file="../common/head.jsp"%>
<header></header>
<body style="background-color: transparent">
	<form action="chargeDataController.fj?method=saveChargeData" id="isform" method="post">

		<input type="hidden" value="<c:out value='${chargeData.id}'/>" name="id" id="id" />
		<input type="hidden" value="<c:out value='${param.ctid}'/>" name="ctid" id="ctid" />

		<table width="98%" cellpadding="0" cellspacing="1" bgcolor="#a6c6da">
			<tr>
			  <td height="35" align="right" bgcolor="#D4E5F4">费用名称：</td>
			  <td align="left" bgcolor="#FFFFFF"><input name="chargeDataName" type="text" id="chargeDataName" class="input-1" value="<c:out value='${chargeData.chargeDataName}' />" />
			  <span class="word-7">*</span>
			  </td>
			  <td height="35" align="right" bgcolor="#D4E5F4">单价：</td>
				<td align="left" bgcolor="#FFFFFF">
				  <input name="chargeDataPrice" type="text" id="chargeDataPrice" class="input-1" value="<c:out value='${chargeData.chargeDataPrice}'/>" />
				  <span class="word-7">*</span>
				</td>
			</tr>
			<tr>
			  <td align="right" bgcolor="#D4E5F4">是否有效：</td>
			  <td align="left" bgcolor="#FFFFFF">
				  <select name="isValidate" class="input-1" style='height: 22px'>
				    <option value='1' <c:if test="${chargeData.isValidate == '1'}">selected</c:if> >是</option>
				    <option value='0' <c:if test="${chargeData.isValidate == '0'}">selected</c:if> >否</option>
				    </select></td>
			  <td height="35" align="right" bgcolor="#D4E5F4">排序：</td>
			  <td align="left" bgcolor="#FFFFFF"><input name="sort"
					type="text" id="sort" class="input-1"
					value="<c:out value='${chargeData.sort}'/>" /></td>
		    </tr>
			<tr>
				<td height="35" align="right" bgcolor="#D4E5F4">创建人：</td>
				<td align="left" bgcolor="#FFFFFF"><gOS_shjz:shjzUser key="${chargeData.createUserId}"/></td>
				<td height="35" align="right" bgcolor="#D4E5F4">创建时间：</td>
				<td align="left" bgcolor="#FFFFFF"><fmt:formatDate value='${chargeData.createDate}' pattern="yyyy-MM-dd"/></td>
			</tr>
			<tr>
				<td height="35" align="right" bgcolor="#D4E5F4">备注：</td>
				<td colspan="3" align="left" bgcolor="#FFFFFF"><textarea
						name="remark" id="remark" style='height: 40px; width: 90%'
						class="input-1"><c:out value='${chargeData.remark}' /></textarea></td>
			</tr>
			<tr>
				<td height="35" colspan="4" align="center" bgcolor="#FFFFFF"> 
				  <input  name="button" type="button"  onclick="javascript:doSave();" class="button-z2" value="保存" />
				  &nbsp;&nbsp;&nbsp;&nbsp;
				  <input  name="button" type="button"  onclick="javascirpt:location.href='chargeDataController.fj?method=getChargeDataList&ctid=${param.ctid}';" class="button-z2" value="返回" />
		         </td>
			 
			</tr>
		</table>
	</form>
	<script type="text/javascript">
		function doSave() {
			var chargeDataName = $.trim($("#chargeDataName").val());
			if ("" == chargeDataName) {
				alert("费用名称不能为空");
				return;
			}  
			if(chargeDataName.length>20){
				alert("费用名称的最大长度为20个字符");
				return;
			}
			var chargeDataPrice=$.trim($("#chargeDataPrice").val());
			if(chargeDataPrice==""){
				alert("单价不能为空");
				return;
			}
			var patrn=/^(([1-9]{1}\d*)|([0]{1}))(\.(\d){1,2})?$/;
			if(!patrn.exec(chargeDataPrice)){
				alert("单价只能为货币");
				return;
			}
			var sort=$.trim($("#sort").val());
			if(sort!=""&&!/^[0-9]+$/g.test(sort)){
				alert("排序字段为数字");
				return;
			}
			var remark=$.trim($("#remark").val());
			if(remark.length>20){
				alert("备注的最大长度为20个字符");
				return;
			}

			$("#isform").submit();
		}
	</script>
</body>
</html>