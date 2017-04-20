<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ include file="../common/head.jsp"%>
<script type="text/javascript">
	function reset() {
		$("#cemeteryRegistryCode").val("");
		$("#cemeteryRegistryCode").val("");
		$("#name").val("");
		$("#mobilePhone").val("");
		 $("#cemeteryLocationId").val("");
		 $("#cemeteryLocationAddress").val("");
	}
	//进入墓位选择
	function gotoCemeteryLocation(){
		window.open("../cemetery/cemetery_location_fast_tree.jsp?select=select","openlocation","width=900px,height=500px,alwaysRaised=no,z-look=yes,resizable=no,location=no,status=no");
	}
	
   function archivesSelect(){
	   
		var redirect_url =$.base64.encode('cemeteryCertificateController.fj?method=getCemeteryCertificatePageList');
		action = "archivesCemeteryRegistryController.fj?method=getArchivesCemeteryRegistrySelectList";
		action += "&redirect_url="+redirect_url;
		action += "&action_type=certificate";
	   	location.href= action;
   }
	
	 //选择墓位后回调使用获取墓型信息
	   function getCemeteryType(id,locat_id,locat){
		 $("#cemeteryLocationId").val(locat_id);
		 $("#cemeteryLocationAddress").val(locat);
	   }
</script>
<body style="background-color: transparent">
<table width="100%" border="0" cellspacing="0" cellpadding="0" height="100%">
  <tr>
    <td width="11" valign="top" class="td-bg"><img src="../images/right-1.jpg" /></td>
    <td align="center" valign="top" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="31" align="left" valign="middle" style="background:url(../images/right-3.jpg)"><img src="../images/right-4.jpg" width="9" height="8" align="absmiddle" /> 当前位置 &gt; 售后管理 &gt; 补正业务登记</td>
      </tr>
      <tr>
        <td bgcolor="#FFFFFF" style="font-size:12px;">&nbsp;</td>
      </tr>
    </table>
    <form action="cemeteryCertificateController.fj?method=getCemeteryCertificatePageList" id="queryForm" method="post">
	<table width="98%" cellpadding="0" cellspacing="1" bgcolor="#a6c6da">
        <tr>
          <td width="15%" align="right" bgcolor="#D4E5F4">业务编号：</td>
          <td width="35%" align="left" bgcolor="#FFFFFF">
          <input name="cemeteryRegistryCode" type="text" id="cemeteryRegistryCode" class="input-1"  value="<c:out value='${param.cemeteryRegistryCode}'/>"/></td>
          <td width="15%" height="35" align="right" bgcolor="#D4E5F4">安葬位置：</td>
          <td width="35%" align="left" bgcolor="#FFFFFF">
          <input name="cemeteryLocationAddress" id="cemeteryLocationAddress"
								type="text" readonly="readonly" class="input-1"
								value="<c:out value='${entity.cemeteryLocation.cemeteryZone.parent.cemeteryZoneName}'/><c:out value='${entity.cemeteryLocation.cemeteryZone.cemeteryZoneName}'/><c:out value='${entity.cemeteryLocation.cemeteryLocationCode}'/>" />
								<input name="cemeteryLocationId" id="cemeteryLocationId" type="hidden" 
								value="<c:out value='${entity.cemeteryLocation.id}'/>" /> 
								<input name="button" type="button" class="button-z" value="选择"
								onclick="gotoCemeteryLocation();" />
          </td>
        </tr>
        <tr>
          <td width="15%" height="35" align="right" bgcolor="#D4E5F4">承租人：</td>
          <td width="35%" align="left" bgcolor="#FFFFFF">
          <input name="name" type="text" id="name" class="input-1"  value="<c:out value='${param.name}'/>"/>
          <td width="15%" align="right" bgcolor="#D4E5F4">电话：</td>
          <td width="35%" align="left" bgcolor="#FFFFFF">
          <input name="mobilePhone" type="text" id="mobilePhone" class="input-1"  value="<c:out value='${param.mobilePhone}'/>"/>
          </td>
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
	<table width="98%" border="0" cellspacing="0" cellpadding="0">
		<tr>
            <td height="40" align="left">
	            <input name="button3" type="button" onclick="javascript:archivesSelect();" class="button-z4" id="button3" value="补证登记" />
            </td>
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
			<td align="center" bgcolor="#D4E5F4">位置信息</td>
			<td align="center" bgcolor="#D4E5F4">补证原因</td>
			<td align="center" bgcolor="#D4E5F4">办理人 </td>
			<td align="center" bgcolor="#D4E5F4">办理日期 </td>
			<td align="center" bgcolor="#D4E5F4">操作</td>
		</tr>
		<c:forEach  var="en" items="${list}" varStatus="status">
		<tr>
			<td height="30" align="center" bgcolor="#FFFFFF"><c:out value='${status.count}'/></td>
			<td align="center" bgcolor="#FFFFFF"><c:out value='${en.archivesCemeteryRegistry.cemeteryRegistryCode}'/></td>
			<td align="center" bgcolor="#FFFFFF"><c:out value='${en.archivesCemeteryRegistry.cemeteryLocation.cemeteryType.businessData.businessName}'/></td>
			<td align="center" bgcolor="#FFFFFF"><c:out value='${en.archivesCemeteryRegistry.name}'/></td>
			<td align="center" bgcolor="#FFFFFF"><c:out value='${en.archivesCemeteryRegistry.cardNum}'/></td>
			<td align="center" bgcolor="#FFFFFF"><c:out value='${en.archivesCemeteryRegistry.mobilePhone}'/></td>
			<%-- <td align="center" bgcolor="#FFFFFF"><c:out value='${en.archivesCemeteryRegistry.cemeteryLocation.cemeteryLocationCode}'/></td> --%>
			<td align="center" bgcolor="#FFFFFF">
				<c:out value='${en.archivesCemeteryRegistry.cemeteryLocation.cemeteryZone.parent.cemeteryZoneName}'/>
				<c:out value='${en.archivesCemeteryRegistry.cemeteryLocation.cemeteryZone.cemeteryZoneName}'/>
				<c:out value='${en.archivesCemeteryRegistry.cemeteryLocation.cemeteryLocationCode}'/>号
			</td>
			<%-- <td align="center" bgcolor="#FFFFFF"><c:out value='${en.reason}'/></td> --%>
			<td align="center" bgcolor="#FFFFFF">
				<c:choose>
				          <c:when test="${en.reason=='1'}">
				          	证件丢失
				          </c:when>
				          <c:when test="${en.reason=='2'}">
				          	证件破损
				          </c:when>
				          <c:when test="${en.reason=='3'}">
				          	信息变更
				          </c:when>
				          <c:when test="${en.reason=='4'}">
				          	其他
				          </c:when>
				          <c:otherwise>
				          	其他
				          </c:otherwise>
				        </c:choose>
			</td>
			<td align="center" bgcolor="#FFFFFF"><gOS_shjz:shjzUser key="${en.createUserId}"/></td>
			<td align="center" bgcolor="#FFFFFF"><c:out value='${en.createDate}'/></td>
			<td align="center" bgcolor="#FFFFFF" class="word-7">
			<a href="cemeteryCertificateController.fj?method=showCemeteryCertificate&id=<c:out value='${en.id}'/>">查看</a>&nbsp;&nbsp;
			<a href="cemeteryCertificateController.fj?method=editCemeteryCertificate&id=<c:out value='${en.id}'/>">编辑</a>&nbsp;&nbsp;
			<a href="#" onclick="confirmDelete(<c:out value='${en.id}'/>)">删除</a></td>
		</tr>
		</c:forEach>
	</table>
	<table width="98%" border="0" cellspacing="0" cellpadding="10" class="word-4">
		<tr align="right" >
			<td >
			<ft:page action="cemeteryCertificateController.fj?method=getCemeteryCertificatePageList" page="${page}">
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
				var url="cemeteryCertificateController.fj?method=deleteCemeteryCertificate&id="+id ;
				$("#isdelform").attr("action",url);
			    $("#isdelform").submit();  
			}
		 }
	</script>
</body>
</html>
