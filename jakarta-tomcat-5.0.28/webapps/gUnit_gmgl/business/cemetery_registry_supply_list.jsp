<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ include file="../common/head.jsp"%>
<head>
<script type="text/javascript">
function deleteCemeteryRegistry(id,cemeteryRegistryType){
	if(confirm("确定要删除？")){
		location.href = 'cemeteryRegistryController.fj?method=deleteCemeteryRegistrySupply&cemeteryRegistryType='+cemeteryRegistryType+'&id='+id;
	}
}
function archives(){
	
	var t = 0;
	$("input[name='ids']").each(function(){
          if($(this).attr("checked") == 'checked'){
        	  t++;
          }
	});
	if(t<1){
		alert("请选择可以归档的记录！");
      	return false;
	}
 	var redirect_registry_url =$.base64.encode('../business/cemeteryRegistryController.fj?method=getCemeteryRegistryPageSupplyList&cemeteryRegistryType='+$("#cemeteryRegistryType").val());
 	$("#redirect_registry_url").val(redirect_registry_url);
}
function doRent(){
	
	location.href='cemeteryRegistryController.fj?method=editCemeteryRegistrySupply&cemeteryRegistryType='+$("#cemeteryRegistryType").val();	
}

</script>
</head>
<body style="background-color: transparent">
	
<table width="100%" border="0" cellspacing="0" cellpadding="0" height="100%">
  <tr>
    <td width="11" valign="top" class="td-bg"><img src="../images/right-1.jpg" /></td>
    <td align="center" valign="top" >
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="31" align="left" valign="middle" style="background:url(../images/right-3.jpg)"><img src="../images/right-4.jpg" width="9" height="8" align="absmiddle" /> 当前位置  &gt; 档案管理 &gt; 档案补录 &gt; 列表</td>
      </tr>
      <tr>
        <td bgcolor="#FFFFFF" style="font-size:12px;">&nbsp;</td>
      </tr>
    </table>
	<form action="cemeteryRegistryController.fj?method=getCemeteryRegistryPageSupplyList" method="post">
    	  <input name="cemeteryRegistryType" type="hidden" id="cemeteryRegistryType" value="${param.cemeteryRegistryType}" />
       <table width="98%" cellpadding="0" cellspacing="1" bgcolor="#a6c6da">

        <tr>
          <td height="35" align="right" bgcolor="#D4E5F4">承租人：</td>
          <td align="left" bgcolor="#FFFFFF"><input name="name" type="text" id="name" class="input-1" value="<c:out value='${param.name}' />" /></td>
          <td align="right" bgcolor="#D4E5F4">联系电话：</td>
          <td align="left" bgcolor="#FFFFFF"><input name="mobilePhone" type="text" id="mobilePhone" class="input-1" value="<c:out value='${param.mobilePhone}' />"/></td>
        </tr>
		 <tr>
          <td height="35" align="right" bgcolor="#D4E5F4">业务编号：</td>
          <td align="left" bgcolor="#FFFFFF">
          <input name="cemeteryRegistryCode" type="text" id="cemeteryRegistryCode" class="input-1"  value="<c:out value='${param.cemeteryRegistryCode}' />" /></td>
          <td align="right" bgcolor="#D4E5F4">逝者姓名：</td>
          <td align="left" bgcolor="#FFFFFF">
          <input name="departedName" type="text" id="departedName" class="input-1" value="<c:out value='${param.departedName}' />" /></td>
        </tr>
        <tr>
	         <td height="35" colspan="4" align="center" bgcolor="#FFFFFF">
		      <input name="button" type="submit" class="button-z" id="button" value="查询" /> 
		      <input name="button2" type="submit" class="button-z" id="button2" value="重置" />
			</td>
        </tr>
      </table>
      </form>
       <form action="../archives/archivesCemeteryRegistryController.fj?method=archives" onsubmit="return archives();" method="post">
		<input name="isSupply" type="hidden" id="isSupply" value="1" />
    	<input name="cemeteryRegistryType" type="hidden" id="cemeteryRegistryType" value="${param.cemeteryRegistryType}" />
	      <table width="98%" cellpadding="0" cellspacing="0"  >
	        <tr>
	             <td height="35" align="left">
	             <c:if test="${param.cemeteryRegistryType=='1'}">
				    <input name="button" type="button" onclick="javascript:doRent();" class="button-z2" id="button" value="补录" >
				 </c:if>
					<input name="button" type="submit" class="button-z2" id="button" value="归档" >
					<input name="redirect_registry_url" id="redirect_registry_url" type="hidden">
					
			    </td> 
	        </tr>
			</table>
		  <table width="98%" cellpadding="0" cellspacing="1" bgcolor="#a6c6da">
	        <tr>
			  <td height="30" align="center" bgcolor="#D4E5F4">选择</td>
	          <td height="30" align="center" bgcolor="#D4E5F4">序号</td>
	          <td   align="center" bgcolor="#D4E5F4">业务编号</td>
	          <td   align="center" bgcolor="#D4E5F4">业务分类</td>
	          <td   align="center" bgcolor="#D4E5F4">承租人</td>
	          <td   align="center" bgcolor="#D4E5F4">身份证号</td>
	          <td   align="center" bgcolor="#D4E5F4">联系电话</td>
	          <td   align="center" bgcolor="#D4E5F4">逝者姓名</td>
			  <td   align="center" bgcolor="#D4E5F4">位置信息</td>
			  <td   align="center" bgcolor="#D4E5F4">墓型</td>
			  <td   align="center" bgcolor="#D4E5F4">穴别</td>
			  <td   align="center" bgcolor="#D4E5F4">面积（平方米）</td>
			  <td   align="center" bgcolor="#D4E5F4">业务类型</td>
			  <td   align="center" bgcolor="#D4E5F4">业务员</td>
			  <td   align="center" bgcolor="#D4E5F4">办理时间</td>
		      <td   align="center" bgcolor="#D4E5F4">操作</td>
	        </tr>
	        <c:forEach var="en" items="${list}" varStatus="status">
	        <tr>
			  <td height="30" align="center" bgcolor="#FFFFFF">
			      <c:choose>
					   <c:when test="${en.cemeteryLocation.status == 3 || en.cemeteryLocation.status == 2}">
							<input type="checkbox" id="ids" name="ids" value="${en.id}"/>
					   </c:when>
					   <c:otherwise>
							<input type="checkbox"  name="ids" />
						</c:otherwise>
			      </c:choose>
			  </td>
	          <td   height="30" align="center" bgcolor="#FFFFFF"><c:out value='${status.count}' /></td>
	          <td   align="center" bgcolor="#FFFFFF"><c:out value='${en.cemeteryRegistryCode}' /></td>
	          <td   align="center" bgcolor="#FFFFFF"><c:out value='${en.cemeteryLocation.cemeteryType.businessData.businessName}' /></td>
	          <td   align="center" bgcolor="#FFFFFF"><c:out value='${en.name}' /></td>
	          <td   align="center" bgcolor="#FFFFFF"><c:out value='${en.cardNum}' /></td>
	          <td   align="center" bgcolor="#FFFFFF"><c:out value='${en.mobilePhone}' /></td>
	          <td   align="center" bgcolor="#FFFFFF">
		        <c:forEach var="departed" items="${en.departeds}" varStatus="status">
	          		<c:out value='${departed.name}' />,
	        	</c:forEach>
	          		</td>
			  <td   align="center" bgcolor="#FFFFFF"><c:out value='${en.cemeteryLocation.cemeteryLocationCode}' /></td>
			  <td   align="center" bgcolor="#FFFFFF"><c:out value='${en.cemeteryLocation.cemeteryType.cemeteryTypeName}' /></td>
			  <td   align="center" bgcolor="#FFFFFF">
				   <c:choose>
					   <c:when test="${en.cemeteryLocation.cemeteryType.cave=='1'}">单穴 </c:when>
					   <c:when test="${en.cemeteryLocation.cemeteryType.cave=='2'}">双穴 </c:when>
					   <c:when test="${en.cemeteryLocation.cemeteryType.cave=='3'}">多穴 </c:when>
				  </c:choose>
			  </td>
			  <td   align="center" bgcolor="#FFFFFF"><c:out value='${en.cemeteryLocation.cemeteryType.area}' /></td>
			  <td   align="center" bgcolor="#FFFFFF">
			      <c:choose>
					   <c:when test="${en.cemeteryRegistryType=='1'}">租用</c:when>
					   <c:when test="${en.cemeteryRegistryType=='2'}">续租</c:when>
					   <c:when test="${en.cemeteryRegistryType=='3'}">合葬 </c:when>
					   <c:when test="${en.cemeteryRegistryType=='4'}">迁出 </c:when>
					   <c:when test="${en.cemeteryRegistryType=='5'}">退墓 </c:when>
				  </c:choose> </td>
			  <td align="center" bgcolor="#FFFFFF"><gOS_shjz:shjzUser key="${en.createUserId}"/></td>
			  <td align="center" bgcolor="#FFFFFF"><c:out value='${en.createDate}' /></td>
	          <td align="center" bgcolor="#FFFFFF"class="word-7">
			  <a href="cemeteryRegistryController.fj?method=getCemeteryRegistryViewById&isSupply=1&id=${en.id}">查看</a>&nbsp;
			  <a href="cemeteryRegistryController.fj?method=editCemeteryRegistrySupply&cemeteryRegistryType=${en.cemeteryRegistryType}&id=${en.id}">编辑</a>&nbsp;
			  <a href="javascript:deleteCemeteryRegistry('${en.id}','${en.cemeteryRegistryType}');">删除</a>&nbsp;
	        </tr>
	        </c:forEach>
	      </table>
      </form> 
      <table width="98%" border="0" cellspacing="0" cellpadding="10" class="word-4">
			<tr align="right" >
				<td >
				<ft:page action="cemeteryRegistryController.fj?method=getCemeteryRegistryPageSupplyList" page="${page}">
					<input type="hidden" name="departedName" id="departedName" value="<c:out value='${param.departedName}' />"/>
					<input type="hidden" name="mobilePhone" id="mobilePhone" value="<c:out value='${param.mobilePhone}' />"/>
					<input type="hidden" name="cemeteryRegistryCode" id="cemeteryRegistryCode" value="<c:out value='${param.cemeteryRegistryCode}' />"/>
					<input type="hidden" name="cemeteryRegistryType" id="cemeteryRegistryType" value="<c:out value='${param.cemeteryRegistryType}' />"/>
					<input type="hidden" name="name" id="name" value="<c:out value='${param.name}' />"/>
				</ft:page> 
				</td >
				<td width="120"><ft:pageInfo page="${page}"/></td>
			</tr>
	  </table>   
	</td>
  </tr>
</table>
<script type="text/javascript">
	$(document).ready(function(){
		  $("#button2").click(function(){
			  $("#name").attr("value","");
			  $("#mobilePhone").attr("value","");
			  $("#cemeteryRegistryCode").attr("value","");
			  $("#departedName").attr("value","");
		  });
	});
</script>
</body>
</html>
