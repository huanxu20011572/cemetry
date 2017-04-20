<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ include file="../common/head.jsp"%>
<head>
	<script type="text/javascript">
	 
	function doSubmit() {
		var chargeTypeName = $.trim($("#chargeTypeName").val());
		if ("" == chargeTypeName) {
			alert("费用分类不能为空");
			return;
		}  
		if(chargeTypeName.length>20){
			alert("费用分类的最大长度为20个字符");
			return;
		}
		var chargeTypeDict=$("#chargeTypeDict").val();
		if("0"==chargeTypeDict){
			alert("请选择具体分类！");
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
	
		<table width="98%" cellpadding="0" cellspacing="1" bgcolor="#a6c6da">
			<tr>
				<td height="35" align="right" bgcolor="#D4E5F4">费用分类：</td>
				<td width="220" align="left" bgcolor="#FFFFFF"><input name="chargeTypeName"
					type="text" id="chargeTypeName" class="input-1" />
		    </td>
			  <td width="132" align="right" bgcolor="#D4E5F4">大分类：</td>
				<td width="266" align="left" bgcolor="#FFFFFF">
			    <ft:select name="chargeTypeDict" type="fyfl"  style="width:190px"></ft:select>
		 
			  </td>
			</tr>
			<tr>
				<td align="right" bgcolor="#D4E5F4">是否有效：</td>
				<td align="left" bgcolor="#FFFFFF">
			     <input name="isValidate" type="radio"  value='1'checked="checked"  />是
				<input name="isValidate" type="radio"   value='0'/>否  
				
				</td>
			  <td height="35" align="right" bgcolor="#D4E5F4">排序：</td>
				<td align="left" bgcolor="#FFFFFF"><input name="sort"
					type="text" id="sort" class="input-1" value='1' />
				</td>

			</tr>
			<tr>
				<td height="35" align="right" bgcolor="#D4E5F4">创建人：</td>
		    <td align="left" bgcolor="#FFFFFF"><gOS_shjz:shjzUser key="${cemeteryLocation.createUserId}"/>
		    </td>
			  <td height="35" align="right" bgcolor="#D4E5F4">创建时间：</td>
			  <td align="left" bgcolor="#FFFFFF"><c:out value='${currentTime}'/></td>
			</tr>
			<tr>
				<td width="137" height="35" align="right" bgcolor="#D4E5F4">备注：</td>
				<td colspan="3" align="left" bgcolor="#FFFFFF"><textarea
						name="remark" id="remark" style='height: 40px; width: 90%'
						class="input-1"></textarea>
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