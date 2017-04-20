<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ include file="../common/head.jsp"%>
<head>
<script type="text/javascript">
	function doreset() {
		$("#cemeteryLocationAddress").val("");
		$("#cemeteryLocationId").val("");
		$("#cemeteryRegistryCode").val("");
		$("#departedName").val("");
		$("#name").val("");
		$("#mobilePhone").val("");
		$("#buydate").val("");
		$("#enddate").val("");
	}
	//进入墓位选择
	function gotoCemeteryLocation(){
		window.open("../cemetery/cemetery_location_fast_tree.jsp?select=select","openlocation","width=900px,height=500px,alwaysRaised=no,z-look=yes,resizable=no,location=no,status=no");
	}
	 //选择墓位后回调使用获取墓型信息
	   function getCemeteryType(id,locat_id,locat){
		 $("#cemeteryLocationId").val(id);
		 $("#cemeteryLocationAddress").val(locat);
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
							align="absmiddle" /> 当前位置: &gt; 售后管理 &gt; 选择承租人变更</td>
					</tr>
					<tr>
						<td bgcolor="#FFFFFF" style="font-size: 12px;">&nbsp;</td>
					</tr>
				</table>
				<form
					action="archivesCemeteryRegistryController.fj?method=getArchivesCemeteryRegistryPageList"
					id="queryForm" method="post">

					<table width="98%" cellpadding="0" cellspacing="1"
						bgcolor="#a6c6da">
						<!-- 表格一行两类-->
						<tr>
							<td width="15%" height="35" align="right" bgcolor="#D4E5F4">安葬位置：</td>
							<td colspan="3" align="left" bgcolor="#FFFFFF"> <input
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
							<td width="15%" height="35" align="right" bgcolor="#D4E5F4">租赁起止日期：</td>
							<td colspan="3" align="left" bgcolor="#FFFFFF"> <input
								name="buydate" type="text" id="buydate" class="Wdate" 
								 <c:choose>
									   <c:when test="${entity.buydate!=''}">
									     value='<fmt:formatDate value='${entity.buydate}' pattern="yyyy-MM-dd"/>'
									   </c:when>
								  </c:choose>
								
								
								onfocus="WdatePicker()" />至<input name="enddate" type="text" 
								 <c:choose>
									   <c:when test="${entity.buydate!=''}">
									     value='<fmt:formatDate value='${entity.enddate}' pattern="yyyy-MM-dd"/>'
									   </c:when>
								  </c:choose>
								id="enddate" class="Wdate" onfocus="WdatePicker()" />
							</td>
						</tr>

						<tr>
							<td width="15%" height="35" align="right" bgcolor="#D4E5F4">承租人：</td>
							<td width="35%" align="left" bgcolor="#FFFFFF"><input
								name="name" type="text" id="name" class="input-1" value='<c:out value="${entity.name }"/>' />
							</td>
							<td width="15%" align="right" bgcolor="#D4E5F4">联系电话：</td>
							<td width="35%" align="left" bgcolor="#FFFFFF"><input
								name="mobilePhone" type="text" id="mobilePhone" class="input-1" value='<c:out value='${entity.mobilePhone}'/>' />
							</td>
						</tr>
						<tr>
							<td height="35" align="right" bgcolor="#D4E5F4">业务编号：</td>
							<td align="left" bgcolor="#FFFFFF"><input
								name="cemeteryRegistryCode" type="text"
								id="cemeteryRegistryCode" class="input-1" value='<c:out value='${entity.cemeteryRegistryCode}'/>'/>
							</td>
							<td align="right" bgcolor="#D4E5F4">逝者姓名：</td>
							<td align="left" bgcolor="#FFFFFF"> <input
								name="departedName" type="text" id="departedName" value="<c:out value='${entity.departedName }'/>"
								class="input-1" />
							</td>
						</tr>
						<tr>
							<td height="35" colspan="4" align="center" bgcolor="#FFFFFF">
								<input name="button" type="submit" class="button-z" id="button"
								value="查询" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
								name="resetbtn" type="button" class="button-z" id="resetbtn" onclick ="javascript:doreset()"
								value="重置" /></td>
						</tr>
					</table>
				</form>
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td>&nbsp;</td>
					</tr>
				</table>

				<table width="98%" cellpadding="0" cellspacing="1" bgcolor="#a6c6da">
					<tr>
						<td height="30" align="center" bgcolor="#D4E5F4">序号</td>
						<td align="center" bgcolor="#D4E5F4">业务编号</td>
						<td align="center" bgcolor="#D4E5F4">业务分类</td>
						<td align="center" bgcolor="#D4E5F4">承租人</td>
						<td align="center" bgcolor="#D4E5F4">身份证号</td>
						<td align="center" bgcolor="#D4E5F4">联系电话</td>
						<td align="center" bgcolor="#D4E5F4">逝者姓名</td>
						<td align="center" bgcolor="#D4E5F4">位置信息</td>
						<td align="center" bgcolor="#D4E5F4">墓型</td>
						<td align="center" bgcolor="#D4E5F4">穴别</td>
						<td align="center" bgcolor="#D4E5F4">面积(平方米)</td>
						<td align="center" bgcolor="#D4E5F4">租赁起止日</td>
						<td align="center" bgcolor="#D4E5F4">操作</td>
					</tr>
					<c:forEach  var="en" items="${list}" varStatus="status">
					<tr>
						<td height="30" align="center" bgcolor="#FFFFFF"><c:out value='${status.count}'/></td>
						<td align="center" bgcolor="#FFFFFF"><c:out value='${en.cemeteryRegistryCode}'/></td>
						<td align="center" bgcolor="#FFFFFF"><c:out value='${en.cemeteryLocation.cemeteryType.businessData.businessName}' /></td>
						<td align="center" bgcolor="#FFFFFF"><c:out value='${en.name}'/></td>
						<td align="center" bgcolor="#FFFFFF"><c:out value='${en.cardNum}'/></td>
						<td align="center" bgcolor="#FFFFFF"><c:out value='${en.mobilePhone}'/></td>
						<td align="center" bgcolor="#FFFFFF">
						     <c:forEach var="departed" items="${en.archivesDeparteds}" varStatus="status">
          							<c:out value='${departed.name}' />,
        					 </c:forEach>
						</td>
						<td align="center" bgcolor="#FFFFFF">
						   <c:out value='${en.cemeteryLocation.cemeteryZone.parent.cemeteryZoneName}'/>
				           <c:out value='${en.cemeteryLocation.cemeteryZone.cemeteryZoneName}'/>
				           <c:out value='${en.cemeteryLocation.cemeteryLocationCode}'/>号
				         </td>
					    <td align="center" bgcolor="#FFFFFF"><c:out value='${en.cemeteryLocation.cemeteryType.cemeteryTypeName}' /></td>
			            <td align="center" bgcolor="#FFFFFF">
                                 <c:choose>
									   <c:when test="${en.cemeteryLocation.cemeteryType.cave=='1'}">单穴 </c:when>
									   <c:when test="${en.cemeteryLocation.cemeteryType.cave=='2'}">双穴 </c:when>
									   <c:when test="${en.cemeteryLocation.cemeteryType.cave=='3'}">多穴 </c:when>
								  </c:choose>
                         </td>
			             <td align="center" bgcolor="#FFFFFF"><c:out value='${en.cemeteryLocation.cemeteryType.area}' /></td>
			            <td align="center" bgcolor="#FFFFFF"><c:out value='${en.buydate}'/>至<c:out value='${en.enddate}'/></td>
			            <td align="center" bgcolor="#FFFFFF" class="word-7">
			               <a href="archivesCemeteryRegistryController.fj?method=getArchivesCemeteryRegistryEdit&id=${en.id}">变更承办人</a> 
			               <a href="archivesCemeteryRegistryController.fj?method=getArchivesCemeteryRegistryView&id=${en.id}">查看</a></td>
					</tr>
			        </c:forEach>
				</table>
		        <table width="98%" border="0" cellspacing="0" cellpadding="10" class="word-4">
				<tr align="right" >
					<td >
					<ft:page action="archivesCemeteryRegistryController.fj?method=getArchivesCemeteryRegistryPageList" page="${page}">
						<input name="cemeteryLocationAddress" id="cemeteryLocationAddress"
								type="hidden" readonly="readonly" class="input-1"
								value="<c:out value='${param.cemeteryLocationAddress}'/>" />
						<input name="cemeteryLocationId" id="cemeteryLocationId" type="hidden" value="<c:out value='${param.cemeteryLocationId}'/>" />
						<input name="buydate" id="buydate" type="hidden" value="<c:out value='${param.buydate}'/>" />
						<input name="enddate" id="enddate" type="hidden" value="<c:out value='${param.enddate}'/>" />
						<input name="name" type="hidden" id="name" class="input-1" value='<c:out value="${entity.name }"/>' />
						<input name="mobilePhone" type="hidden" id="mobilePhone" class="input-1" value='<c:out value='${entity.mobilePhone}'/>' />
						<input name="cemeteryRegistryCode" type="hidden" id="cemeteryRegistryCode" class="input-1" value='<c:out value='${entity.cemeteryRegistryCode}'/>'/>
						<input name="departedName" type="hidden" id="departedName" value="<c:out value='${entity.departedName }'/>" class="input-1" />
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