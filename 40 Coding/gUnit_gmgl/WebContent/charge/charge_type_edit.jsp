<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ include file="../common/head.jsp"%>
<head>
	<script type="text/javascript">
	 
			function doSubmit() {
				var chargeTypeName = $.trim($("#chargeTypeName").val());
				if ("" == chargeTypeName || chargeTypeName.length<=0) {
					alert("费用分类不能为空");
					return;
				}  
				if(chargeTypeName.length>20){
					alert("费用分类的最大长度为20个字符");
					return;
				}
				
				var chargeTypeDict=$("#chargeTypeDict").val();
				if("-1"==chargeTypeDict){
					alert("请选择大分类！");
					return;
				}
				var sort=$.trim($("#sort").val());
				if(!/^[0-9]+$/g.test(sort)){
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
</head>
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
				<td width="113" height="35" align="right" bgcolor="#D4E5F4">费用分类：</td>
				<td width="202" align="left" bgcolor="#FFFFFF"><input name="chargeTypeName"
					type="text" id="chargeTypeName" class="input-1"
					value="<c:out value='${chargeType.chargeTypeName}'/>" />
					<span class="word-7">*</span>
				</td>
			  <td width="123" align="right" bgcolor="#D4E5F4">大分类：</td>
				<td width="194" align="left" bgcolor="#FFFFFF">
				<ft:select name="chargeTypeDict" type="fyfl" selected="${chargeType.chargeTypeDict}" style="width:190px"></ft:select>
		           <span class="word-7">*</span>
				</td>
			</tr>
			<tr>
				<td width="113" align="right" bgcolor="#D4E5F4">是否有效：</td>
				<td width="202" align="left" bgcolor="#FFFFFF">

			    <input name="isValidate" type="radio"   value='1' 
			    <c:if test="${chargeType.isValidate == '1'}">checked="true"</c:if> />是
				<input name="isValidate" type="radio"   value='0'
				<c:if test="${chargeType.isValidate == '0'}">checked="true"</c:if> />否				
	      </td>
			  <td width="123" height="35" align="right" bgcolor="#D4E5F4">排序：</td>
				<td width="194" align="left" bgcolor="#FFFFFF"><input name="sort"
					type="text" id="sort" class="input-1"
					value="<c:out value='${chargeType.sort}'/>" />
				</td>

			</tr>
			<tr>
				<td width="113" height="35" align="right" bgcolor="#D4E5F4">创建人：</td>
		    <td width="202" align="left" bgcolor="#FFFFFF"><gOS_shjz:shjzUser key="${chargeType.createUserId}"/></td>
			  <td width="123" height="35" align="right" bgcolor="#D4E5F4">创建时间：</td>
			  <td width="194" align="left" bgcolor="#FFFFFF"><c:out value='${chargeType.createDate}'/></td>
			</tr>
			<tr>
				<td width="113" height="35" align="right" bgcolor="#D4E5F4">备注：</td>
				<td colspan="3" align="left" bgcolor="#FFFFFF"><textarea
						name="remark" id="remark" style='height: 40px; width: 90%'
						class="input-1"><c:out value='${chargeType.remark}' /></textarea>
				</td>
			</tr>
			<tr>
				<td height="35" colspan="4" align="center" bgcolor="#FFFFFF"> 
				  <input  name="button" type="button"  onclick="javascript:doSubmit();" class="button-z2" value="保存" />
				  &nbsp;&nbsp;&nbsp;&nbsp;
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