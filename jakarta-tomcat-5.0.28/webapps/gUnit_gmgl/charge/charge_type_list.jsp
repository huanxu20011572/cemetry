<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ include file="../common/head.jsp"%>
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
				<form action="chargeTypeController.fj?method=getChargeTypeList" method='post' id="isqueryform">
				<table width="98%" cellpadding="0" cellspacing="1" bgcolor="#a6c6da">

					<tr>
						<td width="15%" height="35" align="right" bgcolor="#D4E5F4">费用分类：</td>
						<td width="35%" align="left" bgcolor="#FFFFFF"><input
							name="chargeTypeName" type="text" id="chargeTypeName"
							class="input-1"  value="<c:out value='${chargetype.chargeTypeName}'/>"/>
						</td>
						<td width="15%" align="right" bgcolor="#D4E5F4">大分类：</td>
						<td align="left" bgcolor="#FFFFFF">
						<ft:select name="chargeTypeDict" type="fyfl" selected="${chargetype.chargeTypeDict}" style="width:190px"></ft:select>
						</td>
					</tr>
					<tr>
						<td height="35" colspan="4" align="center" bgcolor="#FFFFFF">
							
							<input name="button" type="submit" class="button-z" id="button"
							value="查询" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
							name="button2" type="button" class="button-z" id="button2" onclick="chargeTypeReset()"
							value="重置" />
							</td>
					</tr>
				</table>
				</form>
	            <table width="98%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td height="35" colspan="4" align="left">
							<input name="button" type="button" onclick="javascript:location.href='chargeTypeController.fj?method=getCreateChargeType';" 
									class="button-z" id="button" value="增加" />
						</td>
					</tr>
				</table>

				<table width="98%" cellpadding="0" cellspacing="1" bgcolor="#a6c6da">

					<tr>
						<td width="4%" height="30" align="center" bgcolor="#D4E5F4">序号</td>

						<td width="15%" align="center" bgcolor="#D4E5F4">费用分类</td>
						<td align="center" bgcolor="#D4E5F4">大分类</td>
						<td align="center" bgcolor="#D4E5F4">排序</td>
						<td align="center" bgcolor="#D4E5F4">是否生效</td>
						<td align="center" bgcolor="#D4E5F4">备注</td>
						<td align="center" bgcolor="#D4E5F4">创建人</td>
						<td align="center" bgcolor="#D4E5F4">创建日期</td>
						<td align="center" bgcolor="#D4E5F4">操作</td>
					</tr>
					<c:forEach var="en" items="${list}" varStatus="status">
						<tr>
							<td width='4%' height='30' align='center' bgcolor='#FFFFFF'><c:out value='${status.count}' /></td>
							<td align='center' bgcolor='#FFFFFF'><c:out value='${en.chargeTypeName}' /></td>
							<td align='center' bgcolor='#FFFFFF'><ft:dict value='${en.chargeTypeDict}'/></td>
							<td align='center' bgcolor='#FFFFFF'><c:out value='${en.sort}' /></td>
							<td align='center' bgcolor='#FFFFFF'>
							<c:choose>
										<c:when  test="${en.isValidate == '1'}">  是
                                        </c:when>
										<c:otherwise>否  
                                        </c:otherwise>
									</c:choose></td>
							<td align='center' bgcolor='#FFFFFF'><c:out value='${en.remark}' /></td>
							<td align='center' bgcolor='#FFFFFF'><gOS_shjz:shjzUser key="${en.createUserId}"/></td>
							<td align='center' bgcolor='#FFFFFF'>
							<fmt:formatDate value='${en.createDate}' pattern="yyyy-MM-dd"/></td>
							<td align="center" bgcolor="#FFFFFF" class="word-7">
							<a href="chargeTypeController.fj?method=getChargeTypeView&id=<c:out value='${en.id}'/> ">查看</a>&nbsp;&nbsp;
							<a href="chargeTypeController.fj?method=editChargeType&id=<c:out value='${en.id}'/> ">编辑</a>&nbsp;&nbsp;
							<a href="#" onclick="confirmDelete(<c:out value='${en.id}'/>)">删除</a></td>
						</tr>
					</c:forEach>

				 </table>
			<!-- 	 <form  action ="chargeTypeController.fj?method=deleteChargeType" id="isdelform" method="post"> </form> -->
				 <table width="98%" border="0" cellspacing="0" cellpadding="10" class="word-4">
					<tr align="right" >
						<td >
						<ft:page action="chargeTypeController.fj?method=getCemeteryCommodityList" page="${page}">
						</ft:page> 
						</td >
						<td width="120"><ft:pageInfo page="${page}"/></td>
					</tr>
				</table>   
			</td>
		</tr>
	</table>
	<form  action ="chargeTypeController.fj?method=deleteChargeType" id="isdelform" method="post"> </form>

	<script type="text/javascript">
	function chargeTypeReset(){
		 $("#chargeTypeName").val("");
		 $('#chargeTypeDict').attr('value','0');
	 }
	function formateDate(para){
		return str.fromat("yyyy-MM-dd");
	}
	function confirmDelete(id){
		if(confirm("确定要删除？"))
		{
			var chargeTypeName=$.trim($("#chargeTypeName").val());
			var chargeTypeDict=$.trim($("#chargeTypeDict").val());
			var url="chargeTypeController.fj?method=deleteChargeType&id="+id ;
			if(""!=chargeTypeDict)
			   url=url+"&chargeTypeDict="+chargeTypeDict;
			if(""!=chargeTypeName)
			   url=url+"&chargeTypeName="+chargeTypeName;
			$("#isdelform").attr("action",url);
		    $("#isdelform").submit();  
		}
		 
	 }
	</script>
</body>
</html>
