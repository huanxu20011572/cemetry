<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ include file="../common/head.jsp"%>
<body style="background-color: transparent">
	<script type="text/javascript">
		function businessDataChange(cemeteryTypeId) {
			var businessDataId = $("#businessDataId").val();
			$.getJSON("cemeteryLocationController.fj?method=getCemeteryTypeListByBusinessDataId&businessDataId=" + businessDataId, "", function(response) {
				$("#cemeteryTypeId option").remove();
				$("#cemeteryTypeId").append("<option value='-1'>---请选择---</option>");
				//为true不清空墓型相关输入框，为false时清空墓型相关输入框
				var isClearFlag = false;
				$.each(response, function(i) {
					if (cemeteryTypeId == response[i].id) {
						isClearFlag = true;
						$("#cemeteryTypeId").append("<option value="+response[i].id+" selected='selected'>" + response[i].cemeteryTypeName + "</option>");
					} else {
						$("#cemeteryTypeId").append("<option value="+response[i].id+">" + response[i].cemeteryTypeName + "</option>");
					}
				});
				if (!isClearFlag) {
					clearCemeteryType();
				}
			});
		}
		function cemeteryTypeChange() {
			var cemeteryTypeId = $("#cemeteryTypeId").val();
			if (cemeteryTypeId == '-1') {
				clearCemeteryType();
			} else {
				$.getJSON("cemeteryLocationController.fj?method=getCemeteryTypeById&cemeteryTypeId=" + cemeteryTypeId, function(response) {
					$("#cemeteryTypeCode").text(response.cemeteryTypeCode);
					$("#cemeteryTypeName").text(response.cemeteryTypeName);
					$("#businessName").text(response.businessData.businessName);
					$("#cemeteryProperty").text(response.cemeteryProperty);
					$("#specification").text(response.specification);
					$("#area").text(response.area);
					$("#cave").text(response.cave);
					$("#boxsize").text(response.boxsize);
					$("#totalPrice").text(response.totalPrice);
					$("#stoneprovider").text(response.stoneprovider);
					$("#remark").text(response.remark);
					$("#groundPrice").text(response.groundPrice);
					$("#managePrice").text(response.managePrice);
					$("#constructionPrice").text(response.constructionPrice);
					if(response.cemeteryFile == undefined){
						$("#cemeteryFilePic").attr('src','${pageContext.request.contextPath}/images/mx-min.jpg');
					}else{
						$("#cemeteryFilePic").attr('src','../upload/pic/'+response.cemeteryFile.filePath);
					}
				});
			}
		}

		function clearCemeteryType() {
			$("#cemeteryTypeCode").text("");
			$("#cemeteryTypeName").text("");
			$("#businessName").text("");
			$("#cemeteryProperty").text("");
			$("#specification").text("");
			$("#area").text("");
			$("#cave").text("");
			$("#boxsize").text("");
			$("#totalPrice").text("");
			$("#stoneprovider").text("");
			$("#remark").text("");
			$("#groundPrice").text("");
			$("#managePrice").text("");
			$("#constructionPrice").text("");
			$("#cemeteryFilePic").attr('src','${pageContext.request.contextPath}/images/mx-min.jpg');
		}
	</script>
	<form
		action="cemeteryLocationController.fj?method=saveCemeteryLocation"
		id="isform" method="post">
		<input type="hidden" value="<c:out value='${param.pid}'/>" name="pid"
			id="pid" /> <input type="hidden"
			value="<c:out value='${cemeteryLocation.id}'/>" name="id" id="id" />

		<table width="98%" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td width="92%" bgcolor="#EBF4FA"><table width="200" border="0"
						cellspacing="0" cellpadding="0">
						<tr>
							<td width="20" align="right"><img src="../images/tab-01.jpg"
								width="8" height="27" /></td>
							<td width="99" align="center" class="tab-img-01">基本信息</td>
							<td width="81" align="left" valign="bottom"><img
								src="../images/tab-03.jpg" /></td>
						</tr>
					</table></td>
			</tr>
		</table>

		<table width="98%" cellpadding="0" cellspacing="1" bgcolor="#a6c6da">
			<tr>
				<td width="15%" height="27" align="right" bgcolor="#D4E5F4">墓位编号：</td>
				<td width="35%" height="27" align="left" bgcolor="#FFFFFF"><input
					name="cemeteryLocationCode" type="text" class="input-1"
					id="cemeteryLocationCode"
					value="${cemeteryLocation.cemeteryLocationCode}"
					readonly="readonly" />(开始)</td>
				<td width="14%" height="27" align="right" bgcolor="#D4E5F4">墓位个数：</td>
				<td width="36%" height="27" align="left" bgcolor="#FFFFFF"><c:choose>
						<c:when test="${!empty(cemeteryLocation.id)}">
							<input name="amount" type="text" class="input-1" id="amount"
								value="1" readonly="readonly" />
						</c:when>
						<c:otherwise>
							<input name="amount" type="text" class="input-1" id="amount"
								value="1" />
						</c:otherwise>
					</c:choose></td>
			</tr>
			<tr>
				<td width="15%" height="27" align="right" bgcolor="#D4E5F4">指定分类：</td>
				<td width="35%" height="27" align="left" bgcolor="#FFFFFF"><select
					name="businessDataId" id="businessDataId" style="width: 184px;"
					onchange="businessDataChange('${cemeteryLocation.cemeteryType.id}');">
						<option value="-1">---请选择---</option>
						<c:forEach var="en" items="${businessDataList}" varStatus="status">
							<c:choose>
								<c:when
									test="${cemeteryLocation.cemeteryType.businessData.id==en.id}">
									<option value="<c:out value='${en.id}'/>" selected="selected"><c:out
											value='${en.businessName}' /></option>
									<script type="text/javascript">
										businessDataChange('${cemeteryLocation.cemeteryType.id}');
									</script>
								</c:when>
								<c:otherwise>
									<option value="<c:out value='${en.id}'/>"><c:out
											value='${en.businessName}' /></option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
				</select>
					<td height="27" align="right" bgcolor="#D4E5F4">指定墓型：</td>
					<td height="27" align="left" bgcolor="#FFFFFF"><select
						name="cemeteryTypeId" id="cemeteryTypeId" style="width: 184px;"
						onchange="cemeteryTypeChange();">
							<option value='-1'>---请选择---</option>
					</select>
			</tr>
			<tr>
				<td height="27" align="right" bgcolor="#D4E5F4">墓位状态：</td>
				<td height="27" align="left" bgcolor="#FFFFFF"><select
					name="status" id="status" style="width: 184px;">
						<option value='-1'>---请选择---</option>
						<c:choose>
							<c:when test="${cemeteryLocation.status==1}">
								<option value="1" selected="selected">开发</option>
							</c:when>
							<c:otherwise>
								<option value="1">开发</option>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${cemeteryLocation.status==2}">
								<option value="2" selected="selected">空闲</option>
							</c:when>
							<c:otherwise>
								<option value="2">空闲</option>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${cemeteryLocation.status==3}">
								<option value="3" selected="selected">锁定</option>
							</c:when>
							<c:otherwise>
								<option value="3">锁定</option>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${cemeteryLocation.status==4}">
								<option value="4" selected="selected">保留</option>
							</c:when>
							<c:otherwise>
								<option value="4">保留</option>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${cemeteryLocation.status==5}">
								<option value="5" selected="selected">预定</option>
							</c:when>
							<c:otherwise>
								<option value="5">预定</option>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${cemeteryLocation.status==6}">
								<option value="6" selected="selected">占用</option>
							</c:when>
							<c:otherwise>
								<option value="6">占用</option>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${cemeteryLocation.status==7}">
								<option value="7" selected="selected">迁出</option>
							</c:when>
							<c:otherwise>
								<option value="7">迁出</option>
							</c:otherwise>
						</c:choose>
				</select>
					<td width="14%" height="27" align="right" bgcolor="#D4E5F4">&nbsp;</td>
					<td width="36%" height="27" align="left" bgcolor="#FFFFFF">&nbsp;</td>
			</tr>
			<tr>
				<td width="15%" height="27" align="right" bgcolor="#D4E5F4">创建人：</td>
				<td width="35%" height="27" align="left" bgcolor="#FFFFFF"><gOS_shjz:shjzUser key="${cemeteryLocation.createUserId}"/></td>
				<td width="14%" height="27" align="right" bgcolor="#D4E5F4">创建时间：</td>
				<td width="36%" height="27" align="left" bgcolor="#FFFFFF"><fmt:formatDate
						value='${cemeteryLocation.createDate}' pattern="yyyy-MM-dd" /></td>
			</tr>
			<tr>
				<td align="right" bgcolor="#D4E5F4">备注：</td>
				<td height="27" colspan="3" align="left" bgcolor="#FFFFFF"><textarea
						id="remark2" name="remark2" cols="60" rows="3"></textarea></td>
			</tr>
		</table>
		<table width="98%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>&nbsp;</td>
			</tr>
		</table>
		<!-- 	联动显示墓型基本信息 -->
		<table width="98%" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td width="92%" bgcolor="#EBF4FA"><table width="200" border="0"
						cellspacing="0" cellpadding="0">
						<tr>
							<td width="20" align="right"><img src="../images/tab-01.jpg"
								width="8" height="27" /></td>
							<td width="99" align="center" class="tab-img-01">墓型信息</td>
							<td width="81" align="left" valign="bottom"><img
								src="../images/tab-03.jpg" /></td>
						</tr>
					</table></td>
			</tr>
		</table>
		<table width="98%" cellpadding="0" cellspacing="1" bgcolor="#a6c6da">
			<tr>
				<td width="15%" height="35" align="right" bgcolor="#D4E5F4">墓型编号：</td>
				<td width="35%" align="left" bgcolor="#FFFFFF"><span
					name="cemeteryTypeCode" id="cemeteryTypeCode"> <c:out
							value='${cemeteryLocation.cemeteryType.cemeteryTypeCode}' /></span></td>
				<td width="15%" rowspan="2" align="right" bgcolor="#D4E5F4">墓型图片：</td>
				<td width="35%" rowspan="2" align="left" bgcolor="#FFFFFF"><img
					id="cemeteryFilePic" name="cemeteryFilePic"
					onerror="this.src='${pageContext.request.contextPath}/images/mx-min.jpg'"
					src="../upload/pic/<c:out value='${cemeteryType.cemeteryFile.filePath}'/>"
					width="110" height="70" /></td>
			</tr>
			<tr>
				<td height="35" align="right" bgcolor="#D4E5F4">业务分类：</td>
				<td align="left" bgcolor="#FFFFFF"><span name="businessName"
					id="businessName"><c:out
							value='${cemeteryLocation.cemeteryType.businessData.businessName}' /></span></td>
			</tr>
			<tr>
				<td height="35" align="right" bgcolor="#D4E5F4">墓型名称：</td>
				<td align="left" bgcolor="#FFFFFF"><span
					name="cemeteryTypeName" id="cemeteryTypeName"><c:out
							value='${cemeteryLocation.cemeteryType.cemeteryTypeName}' /></span></td>
				<td height="35" align="right" bgcolor="#D4E5F4">墓型类别：</td>
				<td align="left" bgcolor="#FFFFFF"><span
					name="cemeteryProperty" type="text" class="input-1"
					id="cemeteryProperty"
					value="<c:out value='${cemeteryLocation.cemeteryType.cemeteryProperty}'/>" />
				</td>
			</tr>
			<tr>
				<td height="35" align="right" bgcolor="#D4E5F4">墓型规格：</td>
				<td align="left" bgcolor="#FFFFFF"><span name="specification"
					id="specification"><c:out
							value='${cemeteryLocation.cemeteryType.specification}' /></span></td>
				<td align="right" bgcolor="#D4E5F4">面积：</td>
				<td align="left" bgcolor="#FFFFFF"><span name="area" id="area">
						<c:out value='${cemeteryLocation.cemeteryType.area}' />
				</span></td>
			</tr>
			<tr>
				<td height="35" align="right" bgcolor="#D4E5F4">穴别：</td>
				<td align="left" bgcolor="#FFFFFF"><span name="cave" id="cave"><c:out
							value='${cemeteryLocation.cemeteryType.cave}' /></span></td>
				<td align="right" bgcolor="#D4E5F4">护盒尺寸：</td>
				<td align="left" bgcolor="#FFFFFF"><span name="boxsize"
					id="boxsize"><c:out
							value='${cemeteryLocation.cemeteryType.boxsize}' /></span</td>
			</tr>
			<tr>
				<td height="35" align="right" bgcolor="#D4E5F4">墓型总价格：</td>
				<td align="left" bgcolor="#FFFFFF"><span name="totalPrice"
					id="totalPrice"><c:out
							value='${cemeteryLocation.cemeteryType.totalPrice}' /></span></td>
				<td align="right" bgcolor="#D4E5F4">石料供应商：</td>
				<td align="left" bgcolor="#FFFFFF"><span name="stoneprovider"
					id="stoneprovider"><c:out
							value='${cemeteryLocation.cemeteryType.stoneprovider}' /></span></td>
			</tr>
			<tr>
				<td height="50" align="right" bgcolor="#D4E5F4">墓型说明：</td>
				<td colspan='3' align="left" bgcolor="#FFFFFF"><span
					name="remark" id="remark"><c:out
							value='${cemeteryLocation.cemeteryType.remark}' /></span></td>
			</tr>
		</table>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>&nbsp;</td>
			</tr>
		</table>
		<table width="98%" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td width="92%" bgcolor="#EBF4FA"><table width="200" border="0"
						cellspacing="0" cellpadding="0">
						<tr>
							<td width="20" align="right"><img src="../images/tab-01.jpg"
								width="8" height="27" /></td>
							<td width="99" align="center" class="tab-img-01">费用信息</td>
							<td width="81" align="left" valign="bottom"><img
								src="../images/tab-03.jpg" /></td>
						</tr>
					</table></td>
			</tr>
		</table>
		<table width="98%" cellpadding="0" cellspacing="1" bgcolor="#a6c6da">
			<tr>
				<td width="15%" height="35" align="right" bgcolor="#D4E5F4">土地租赁费：</td>
				<td width="35%" align="left" bgcolor="#FFFFFF"><span
					name="groundPrice" id="groundPrice"><c:out
							value='${cemeteryLocation.cemeteryType.groundPrice}' /></span></td>
				<td width="15%" align="right" bgcolor="#D4E5F4">管理费：</td>
				<td width="35%" align="left" bgcolor="#FFFFFF"><span
					name="managePrice" id="managePrice"><c:out
							value='${cemeteryLocation.cemeteryType.managePrice}' /></span></td>
			</tr>
			<tr>
				<td height="35" align="right" bgcolor="#D4E5F4">工程费：</td>
				<td align="left" bgcolor="#FFFFFF" colspan='3'><span
					name="constructionPrice" id="constructionPrice"><c:out
							value='${cemeteryLocation.cemeteryType.constructionPrice}' /></span></td>
			</tr>
		</table>
		<!-- 	联动显示墓型基本信息 -->

		<table width="98%" cellpadding="0" cellspacing="0">
			<tr>
				<td colspan="4" align="center" bgcolor="#FFFFFF">&nbsp;</td>
			</tr>
			<tr>
				<td colspan="4" align="center" bgcolor="#FFFFFF"><input
					class="button-z" type="button" name="saveBtn" id="saveBtn"
					value="保存" onclick="doSave();" />&nbsp;&nbsp;&nbsp; <input
					class="button-z" name="backBtn" id="backBtn" type="button"
					onclick="doBack();" value="返回" /></td>
			</tr>
		</table>
		</td>
		</tr>
		</table>
	</form>
	<script type="text/javascript">
		function doSave() {
			var businessDataId=$("#businessDataId").val();
			if("-1" == businessDataId){
				alert("请选择指定分类！");
				return;
			}
			var cemeteryTypeId=$("#cemeteryTypeId").val();
			if("-1" == cemeteryTypeId){
				alert("请选择指定墓型！");
				return;
			}
			var status=$("#status").val();
			if("-1" == status){
				alert("请选择墓位状态！");
				return;
			}
			var remark2 = $("#remark2").val();
			if (remark2.length > 200) {
				alert("备注长度不超过200个字符");
				return;
			}
			isform.action = "cemeteryLocationController.fj?method=saveCemeteryLocation";
			isform.submit();
		}
		function doBack() {
			//isform.action = "cemeteryLocationController.fj?method=getCemeteryLocationListByPID&pid=<c:out value='${param.pid}'/>";
			//isform.submit();
			JavaScript: history.back();
		}
	</script>
</body>
</html>