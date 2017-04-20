<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ include file="../common/head.jsp"%>
<head>
<title>服务事项列表</title>
<script type="text/javascript">
	function doreset() {
		$("#cemeteryLocationAddress").val("");
		$("#cemeteryLocationId").val("");
		$("#cemeteryRegistryCode").val("");
		$("#name").val("");
		$("#mobilePhone").val("");

	}
	//进入墓位选择
	function gotoCemeteryLocation() {
		window.open("../cemetery/cemetery_location_select_tree.jsp","openlocation","width=900px,height=500px,alwaysRaised=no,z-look=yes,resizable=no,location=no,status=no");
	}
	//选择墓位后回调使用获取墓型信息
	function getCemeteryType(id, locat_id, locat) {
		$("#cemeteryLocationId").val(id);
		$("#cemeteryLocationAddress").val(locat);
	}
	  function archivesSelect(){
		   
			var redirect_url =$.base64.encode('cemeteryServiceController.fj?method=getCemeteryServiceEdit');
			action = "archivesCemeteryRegistryController.fj?method=getArchivesCemeteryRegistrySelectList";
			action += "&redirect_url="+redirect_url;
			action += "&action_type=cemeteryService";
		   	location.href= action;
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
			<td align="center" valign="top">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td height="31" align="left" valign="middle"
							style="background: url(../images/right-3.jpg)"><img
							src="../images/right-4.jpg" width="9" height="8"
							align="absmiddle" /> 当前位置: &gt; 售后管理 &gt; 服务事项</td>
					</tr>
					<tr>
						<td bgcolor="#FFFFFF" style="font-size: 12px;">&nbsp;</td>
					</tr>
				</table>
				<form id="saveForm"
					action="cemeteryServiceController.fj?method=getCemeteryServicePageList"
					method='post'>

					<table width="98%" cellpadding="0" cellspacing="1"
						bgcolor="#a6c6da">
						<!-- 表格一行两类-->
						<tr>
							<td height="35" align="right" bgcolor="#D4E5F4">业务编号：</td>
							<td align="left" bgcolor="#FFFFFF"> <input
								name="cemeteryRegistryCode" type="text"
								id="cemeteryRegistryCode" class="input-1"
								value='<c:out value='${entity.cemeteryRegistryCode}'/>' />
							</td>
							<td width="15%" height="35" align="right" bgcolor="#D4E5F4">安葬位置：</td>
							<td width="35%" align="left" bgcolor="#FFFFFF">  <input
								name="cemeteryLocationAddress" id="cemeteryLocationAddress"
								type="text" readonly="readonly" class="input-1"
								value="<c:out value='${param.cemeteryLocationAddress}'/>" />
								<input name="cemeteryLocationId" id="cemeteryLocationId"
								type="hidden"
								value="<c:out value='${param.cemeteryLocationId}'/>" /> <input
								name="button" type="button" class="button-z" value="选择"
								onclick="gotoCemeteryLocation();" /></td>
						</tr>
						<tr>
							<td width="15%" height="35" align="right" bgcolor="#D4E5F4">承租人：</td>
							<td width="35%" align="left" bgcolor="#FFFFFF"> <input
								name="name" type="text" id="name" class="input-1"
								value='<c:out value="${entity.name }"/>' /></td>
							<td width="15%" align="right" bgcolor="#D4E5F4">电话：</td>
							<td width="35%" align="left" bgcolor="#FFFFFF">  <input
								name="mobilePhone" type="text" id="mobilePhone" class="input-1"
								value='<c:out value='${entity.mobilePhone}'/>' />
							</td>
						</tr>

						<tr>
							<td height="35" colspan="4" align="center" bgcolor="#FFFFFF">
								<input name="button" type="submit" class="button-z" id="button3"
								value="查询" /> <input name="button" type="submit"
								class="button-z" onclick="javascript:doreset()" id="button4"
								value="重置" />
							</td>
						</tr>
					</table>
				</form>
				<table width="98%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td height="40" align="left"> 
								<input name="button" type="button" class="button-z4"
									id="select_renewal_bt" value="事项登记"  onclick="javascript:archivesSelect();" />
							 
						</td>
					</tr>
				</table>
 
				<table width="98%" cellpadding="0" cellspacing="1" bgcolor="#a6c6da">
					<tr>
						<td height="35" align="center" bgcolor="#D4E5F4">序号</td>
						<td align="center" bgcolor="#D4E5F4">业务编号</td>
						<td align="center" bgcolor="#D4E5F4">业务分类</td>
						<td align="center" bgcolor="#D4E5F4">承租人</td>
						<td align="center" bgcolor="#D4E5F4">身份证号</td>
						<td align="center" bgcolor="#D4E5F4">联系电话</td>
						<td align="center" bgcolor="#D4E5F4">位置信息</td>
						<td align="center" bgcolor="#D4E5F4">服务事项</td>
						<td align="center" bgcolor="#D4E5F4">服务周期</td>
						<td align="center" bgcolor="#D4E5F4">具体描述</td>
						<td align="center" bgcolor="#D4E5F4">备注</td>
						<td align="center" bgcolor="#D4E5F4">办理日期</td>
						<td align="center" bgcolor="#D4E5F4">操作</td>
					</tr>
					 <c:forEach  var="en" items="${list}" varStatus="status">
					<tr>
						<td height="30" align="center" bgcolor="#FFFFFF"><c:out value='${status.count}'/></td>
						<td align="center" bgcolor="#FFFFFF"><c:out value='${en.archivesCemeteryRegistry.cemeteryRegistryCode}'/></td>
						<td align="center" bgcolor="#FFFFFF"><c:out value='${en.archivesCemeteryRegistry.cemeteryLocation.cemeteryType.businessData.businessName}' /></td>
						<td align="center" bgcolor="#FFFFFF"><c:out value='${en.archivesCemeteryRegistry.name}'/></td>
						<td align="center" bgcolor="#FFFFFF"><c:out value='${en.archivesCemeteryRegistry.cardNum}'/></td>
						<td align="center" bgcolor="#FFFFFF"><c:out value='${en.archivesCemeteryRegistry.mobilePhone}'/></td>
						<td align="center" bgcolor="#FFFFFF"> 
						<c:out value='${en.archivesCemeteryRegistry.cemeteryLocation.cemeteryZone.parent.cemeteryZoneName}'/>
				        <c:out value='${en.archivesCemeteryRegistry.cemeteryLocation.cemeteryZone.cemeteryZoneName}'/>
				         <c:out value='${en.archivesCemeteryRegistry.cemeteryLocation.cemeteryLocationCode}'/>号
						
						</td>
					    <td align="center" bgcolor="#FFFFFF"><ft:dict value='${en.item}'/></td>
					    <td align="center" bgcolor="#FFFFFF"><c:out value='${en.begindate}'/>至<c:out value='${en.enddate}'/></td>
					    <td align="center" bgcolor="#FFFFFF"><c:out value='${en.contents}'/></td>
					    <td align="center" bgcolor="#FFFFFF"><c:out value='${en.remark}'/></td>
					    <td align="center" bgcolor="#FFFFFF"><c:out value='${en.createDate}'/></td>
			            <td align="center" bgcolor="#FFFFFF" class="word-7">
			               <a href="cemeteryServiceController.fj?method=getCemeteryServiceView&id=${en.id}">查看</a> 
			               <a href="cemeteryServiceController.fj?method=getCemeteryServiceEdit&id=${en.id}">编辑</a>
			               <a href="cemeteryServiceController.fj?method=deleteCemeteryService&id=${en.id}">删除</a>
			               </td>
					</tr>
			        </c:forEach>
				 
				</table>
				<table width="98%" border="0" cellspacing="0" cellpadding="10" class="word-4">
					<tr align="right" >
						<td >
						<ft:page action="cemeteryServiceController.fj?method=getCemeteryServicePageList" page="${page}">
						    <input
								name="cemeteryRegistryCode" type="hidden"
								id="cemeteryRegistryCode" class="input-1"
								value='<c:out value='${entity.cemeteryRegistryCode}'/>' />
							<input
								name="cemeteryLocationAddress" id="cemeteryLocationAddress"
								type="hidden" readonly="readonly" class="input-1"
								value="<c:out value='${param.cemeteryLocationAddress}'/>" />
							<input name="cemeteryLocationId" id="cemeteryLocationId"
								type="hidden"
								value="<c:out value='${param.cemeteryLocationId}'/>" />
							<input
								name="name" type="hidden" id="name" class="input-1"
								value='<c:out value="${entity.name }"/>' />
							<input
								name="mobilePhone" type="hidden" id="mobilePhone" class="input-1"
								value='<c:out value='${entity.mobilePhone}'/>' />
						</ft:page> 
						</td >
						<td width="120"><ft:pageInfo page="${page}"/></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>
