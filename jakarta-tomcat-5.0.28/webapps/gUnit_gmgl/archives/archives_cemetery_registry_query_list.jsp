<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ include file="../common/head.jsp"%>
<script type="text/javascript">
	function doReset() {
		$("#cemeteryLocationAddress").val("");
		$("#cemeteryLocationId").val("");
		$("#beginBuyDate").val("");
		$("#endBuyDate").val("");
		$("#name").val("");
		$("#mobilePhone").val("");
		$("#cemeteryRegistryCode").val("");
		$("#dealName").val("");
	}
	//进入墓位选择
	function gotoCemeteryLocation(){
		window.open("../cemetery/cemetery_location_fast_tree.jsp?select=select","openlocation","width=900px,height=500px,alwaysRaised=no,z-look=yes,resizable=no,location=no,status=no");
	}
 	//选择墓位后回调使用获取墓型信息
   function getCemeteryType(id,locat_id,locat){
		$("#cemeteryLocationId").val(locat_id);
	 	$("#cemeteryLocationAddress").val(locat);
   }
 	//返回
   function doBack(){
		var redirect_url = $.base64.decode('${param.redirect_url}');
		location.href=redirect_url;
	}
</script>
<body style="background-color: transparent">
<table width="100%" border="0" cellspacing="0" cellpadding="0" height="100%">
  <tr>
    <td width="11" valign="top" class="td-bg"><img src="../images/right-1.jpg" /></td>
    <td align="center" valign="top" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="31" align="left" valign="middle" style="background:url(../images/right-3.jpg)"><img src="../images/right-4.jpg" width="9" height="8" align="absmiddle" /> 当前位置  &gt; 档案管理 &gt; 档案查询</td>
      </tr>
      <tr>
        <td bgcolor="#FFFFFF" style="font-size:12px;">&nbsp;</td>
      </tr>
    </table>
    <form action="archivesCemeteryRegistryController.fj?method=getArchivesCemeteryRegistryQueryList" id="queryForm" method="post">
				<input type="hidden" id="redirect_url" name="redirect_url" value="${param.redirect_url}" />
				<input type="hidden" id="action_type" name="action_type" value="${param.action_type}" />
	<table width="98%" cellpadding="0" cellspacing="1" bgcolor="#a6c6da">
          <tr>
            <td height="35" align="right" bgcolor="#D4E5F4">安葬位置：</td>
            <td colspan="3" align="left" bgcolor="#FFFFFF">
              <input name="cemeteryLocationAddress" id="cemeteryLocationAddress"
								type="text" readonly="readonly" class="input-1"
								value="${param.cemeteryLocationAddress}" />
								<input name="cemeteryLocationId" id="cemeteryLocationId" type="hidden" 
								value="${param.cemeteryLocationId}" /> 
								<input name="button" type="button" class="button-z" value="选择"
								onclick="gotoCemeteryLocation();" />
            </td>
          </tr>
          <tr>
            <td height="35" align="right" bgcolor="#D4E5F4">租赁起止日期：</td>
            <td colspan="3" align="left" bgcolor="#FFFFFF">
                <input name="beginBuyDate" type="text" class="Wdate" id="beginBuyDate" onfocus="WdatePicker()" value="<c:out value='${param.beginBuyDate}'/>" />
	          	至
	          	<input name="endBuyDate" type="text" class="Wdate" id="endBuyDate" onfocus="WdatePicker()" value="<c:out value='${param.endBuyDate}'/>" />
	        </td>
          </tr>
          <tr>
            <td height="35" align="right" bgcolor="#D4E5F4">承租人：</td>
            <td align="left" bgcolor="#FFFFFF">
              <input name="name" type="text" id="name" class="input-1"  value="<c:out value='${param.name}'/>"/></td>
            <td align="right" bgcolor="#D4E5F4">联系电话：</td>
            <td align="left" bgcolor="#FFFFFF">
              <input name="mobilePhone" type="text" id="mobilePhone" class="input-1"  value="<c:out value='${param.mobilePhone}'/>"/></td>
          </tr>
        <tr>
          <td width="15%" height="35" align="right" bgcolor="#D4E5F4">业务编号：</td>
          <td width="35%" align="left" bgcolor="#FFFFFF">
            <input name="cemeteryRegistryCode" type="text" id="cemeteryRegistryCode" class="input-1"  value="<c:out value='${param.cemeteryRegistryCode}'/>"/></td>
          <td width="15%" align="right" bgcolor="#D4E5F4">逝者姓名：</td>
          <td width="35%" align="left" bgcolor="#FFFFFF">
          	<input name="dealName" type="text" id="dealName" class="input-1"  value="<c:out value='${param.dealName}'/>"/>
		  </td>
        </tr>
      		
        
        <tr bgcolor="#FFFFFF">
               <td height="35"  colspan="4" align="center"  bgcolor="#FFFFFF" >			    
			      <input name="button" type="submit" class="button-z" id="button" value="查询" /> 
				   &nbsp;&nbsp;
				  <input name="button2" type="button" onclick="javascript:doReset();" class="button-z" id="button2" value="重置" />
			   </td>
        </tr>
      </table>
      </form>
	<table width="98%" border="0" cellspacing="0" cellpadding="0">
		<tr>
            <td height="40" align="left">
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
			<td align="center" bgcolor="#D4E5F4">逝者姓名</td>
			<td align="center" bgcolor="#D4E5F4">逝者身份证号</td>
			<td align="center" bgcolor="#D4E5F4">位置信息</td>
			<td align="center" bgcolor="#D4E5F4">墓型</td>
			<td align="center" bgcolor="#D4E5F4">穴别</td>
			<td align="center" bgcolor="#D4E5F4">面积（平方米）</td>
			<td align="center" bgcolor="#D4E5F4">租赁起止日期 </td>
			<td align="center" bgcolor="#D4E5F4">归档类型 </td>
			<td align="center" bgcolor="#D4E5F4">归档员 </td>
			<td align="center" bgcolor="#D4E5F4">归档时间   </td>
			<td align="center" bgcolor="#D4E5F4">操作</td>
		</tr>
		<c:forEach  var="en" items="${list}" varStatus="status">
		<tr>
			<td height="30" align="center" bgcolor="#FFFFFF"><c:out value='${status.count}'/></td>
			<td align="center" bgcolor="#FFFFFF"><c:out value='${en.cemeteryRegistryCode}'/></td>
			<td align="center" bgcolor="#FFFFFF"><c:out value='${en.cemeteryLocation.cemeteryType.businessData.businessName}'/></td>
			<td align="center" bgcolor="#FFFFFF"><c:out value='${en.name}'/></td>
			<td align="center" bgcolor="#FFFFFF"><c:out value='${en.cardNum}'/></td>
			<td align="center" bgcolor="#FFFFFF"><c:out value='${en.mobilePhone}'/></td>
			<td align="center" bgcolor="#FFFFFF">
			<c:forEach  var="ad" items="${en.archivesDeparteds}">
			<c:out value='${ad.name}'/>,
			</c:forEach>
			</td>
			<td align="center" bgcolor="#FFFFFF">
			<c:forEach  var="ad" items="${en.archivesDeparteds}">
			<c:out value='${ad.cardNum}'/>,
			</c:forEach>
			</td>
			<%-- <td align="center" bgcolor="#FFFFFF"><c:out value='${en.cemeteryLocation.cemeteryLocationCode}'/></td> --%>
			<td align="center" bgcolor="#FFFFFF">
				<c:out value='${en.cemeteryLocation.cemeteryZone.parent.cemeteryZoneName}'/>
				<c:out value='${en.cemeteryLocation.cemeteryZone.cemeteryZoneName}'/>
				<c:out value='${en.cemeteryLocation.cemeteryLocationCode}'/>号
			</td>
			<td align="center" bgcolor="#FFFFFF"><c:out value='${en.cemeteryLocation.cemeteryType.cemeteryTypeName}'/></td>
			<%-- <td align="center" bgcolor="#FFFFFF"><c:out value='${en.cemeteryLocation.cemeteryType.cave}'/></td> --%>
			<td align="center" bgcolor="#FFFFFF">
				<c:choose>
		          <c:when test="${en.cemeteryLocation.cemeteryType.cave=='1'}">单穴</c:when>
		          <c:when test="${en.cemeteryLocation.cemeteryType.cave=='2'}">双穴</c:when>
		          <c:when test="${en.cemeteryLocation.cemeteryType.cave=='3'}">多穴</c:when>
				</c:choose>
			</td>
			<td align="center" bgcolor="#FFFFFF"><c:out value='${en.cemeteryLocation.cemeteryType.area}'/></td>
			<td align="center" bgcolor="#FFFFFF"><c:out value='${en.buydate}'/>至<c:out value='${en.enddate}'/></td>
			<td align="center" bgcolor="#FFFFFF">
			<c:choose>
		          <c:when test="${en.cemeteryRegistryType==1}">租用归档</c:when>
		          <c:when test="${en.cemeteryRegistryType==2}">续租归档</c:when>
		          <c:when test="${en.cemeteryRegistryType==3}">合葬归档</c:when>
		          <c:when test="${en.cemeteryRegistryType==4}">迁出归档</c:when>
		          <c:when test="${en.cemeteryRegistryType==5}">退墓归档</c:when>
			</c:choose>
			</td>
			<td align="center" bgcolor="#FFFFFF"><gOS_shjz:shjzUser key="${en.createUserId}"/></td>
			<td align="center" bgcolor="#FFFFFF"><c:out value='${en.createDate}' /></td>
			<td align="center" bgcolor="#FFFFFF" class="word-7">
				<a href="archivesCemeteryRegistryController.fj?method=editArchivesCemeteryRegistry&id=<c:out value='${en.id}'/>">编辑</a>
			&nbsp;&nbsp;<a href="archivesCemeteryRegistryController.fj?method=showArchivesCemeteryRegistryView&id=<c:out value='${en.id}'/>">查看</a>
			</td>
		</tr>
		</c:forEach>
	</table>
	<table width="98%" border="0" cellspacing="0" cellpadding="10" class="word-4">
		<tr align="right" >
			<td >
			<ft:page action="archivesCemeteryRegistryController.fj?method=getArchivesCemeteryRegistryQueryList" page="${page}">
				<input type="hidden" id="cemeteryLocationAddress" name="cemeteryLocationAddress" value="${param.cemeteryLocationAddress}" />
				<input type="hidden" id="cemeteryLocationId" name="cemeteryLocationId" value="${param.cemeteryLocationId}" />
				<input type="hidden" id="beginBuyDate" name="beginBuyDate" value="${param.beginBuyDate}" />
				<input type="hidden" id="endBuyDate" name="endBuyDate" value="${param.endBuyDate}" />
				<input type="hidden" id="name" name="name" value="${param.name}" />
				<input type="hidden" id="mobilePhone" name="mobilePhone" value="${param.nammobilePhonee}" />
				<input type="hidden" id="cemeteryRegistryCode" name="cemeteryRegistryCode" value="${param.cemeteryRegistryCode}" />
				<input type="hidden" id="dealName" name="dealName" value="${param.dealName}" />
				
				<input type="hidden" id="redirect_url" name="redirect_url" value="${param.redirect_url}" />
				<input type="hidden" id="action_type" name="action_type" value="${param.action_type}" />
			</ft:page> 
			</td >
			<td width="120"><ft:pageInfo page="${page}"/></td>
		</tr>
	</table>
</body>
</html>
