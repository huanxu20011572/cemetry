<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ include file="../common/head.jsp"%>
<body style="background-color: transparent">
<table width="100%" border="0" cellspacing="0" cellpadding="0" height="100%">
  <tr>
    <td width="11" valign="top" class="td-bg"><img src="../images/right-1.jpg" /></td>
    <td align="center" valign="top" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="31" align="left" valign="middle" style="background:url(../images/right-3.jpg)"><img src="../images/right-4.jpg" width="9" height="8" align="absmiddle" /> 当前位置 &gt;商品信息 &gt; 入库信息</td>
      </tr>
      <tr>
        <td bgcolor="#FFFFFF" style="font-size:12px;">&nbsp;</td>
      </tr>
    </table>
    <form action="cemeteryCommodityController.fj?method=getCemeteryCommodityList" id="queryForm" method="post">
	<table width="98%" cellpadding="0" cellspacing="1" bgcolor="#a6c6da">
        <tr>
          <td width="18%" height="35" align="right" bgcolor="#D4E5F4">商品名称：</td>
          <td width="32%" align="left" bgcolor="#FFFFFF">
		    <input name="commodityName" type="text" class="input-1" id="commodityName" value="<c:out value='${param.commodityName}'/>"/>
		  </td>
          <td width="17%" align="right" bgcolor="#D4E5F4">商品类别：</td>
          <td width="33%" align="left" bgcolor="#FFFFFF">
          <ft:select name="commodityType" type="spfl" selected="${param.commodityType}" style="width:190px"></ft:select>
          </td>
        </tr>
        <tr bgcolor="#FFFFFF">
               <td height="35"  colspan="4" align="center"  bgcolor="#FFFFFF" >			    
			      <input name="button" type="submit" class="button-z" id="button" value="查询" /> 
				   &nbsp;&nbsp;
				  <input name="button2" type="button" class="button-z" id="button2" value="重置" onclick="doReset()"/>
			   </td>                                              
        </tr>
      </table>
      </form>
	<form action="cemeteryCommodityController.fj?method=editCemeteryCommodity" id="addForm" method="post">
	<table width="98%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="40" align="left">
			<input name="button3" type="submit" class="button-z4" id="button3" value="入库登记" />
			</td>
		</tr>
	</table>
	</form>
	<table width="98%" cellpadding="0" cellspacing="1" bgcolor="#a6c6da">
		<tr>
			<td height="30" align="center" bgcolor="#D4E5F4">序号</td>
			<td align="center" bgcolor="#D4E5F4">商品名称</td>
			<td align="center" bgcolor="#D4E5F4">商品类别</td>
			<td align="center" bgcolor="#D4E5F4">规格</td>
			<td align="center" bgcolor="#D4E5F4">进货价格（元）</td>
			<td align="center" bgcolor="#D4E5F4">销售价格（元）</td>
			<td align="center" bgcolor="#D4E5F4">库存量</td>
			<td align="center" bgcolor="#D4E5F4">备注</td>
			<td align="center" bgcolor="#D4E5F4">登记人</td>
			<td align="center" bgcolor="#D4E5F4">登记日期</td>
			<td align="center" bgcolor="#D4E5F4">操作</td>
		</tr>
		<c:forEach  var="en" items="${list}" varStatus="status">
		<tr>
			<td height="30" align="center" bgcolor="#FFFFFF"><c:out value='${status.count}'/></td>
			<td align="center" bgcolor="#FFFFFF"><c:out value='${en.commodityName}'/></td>
			<td align="center" bgcolor="#FFFFFF"><ft:dict value='${en.commodityType}'/></td>
			<td align="center" bgcolor="#FFFFFF"><c:out value='${en.specifications}'/></td>
			<td align="center" bgcolor="#FFFFFF"><c:out value='${en.inPrice}'/></td>
			<td align="center" bgcolor="#FFFFFF"><c:out value='${en.outPrice}'/></td>
			<td align="center" bgcolor="#FFFFFF"><c:out value='${en.count}'/></td>
			<td align="center" bgcolor="#FFFFFF"><c:out value='无'/></td>
			<td align="center" bgcolor="#FFFFFF"><gOS_shjz:shjzUser key="${en.createUserId}"/></td>
			<td align="center" bgcolor="#FFFFFF"><c:out value='${en.createDate}'/></td>
			<td align="center" bgcolor="#FFFFFF" class="word-7">
			<a href="cemeteryCommodityController.fj?method=showCemeteryCommodity&id=<c:out value='${en.id}'/>">查看</a>&nbsp;&nbsp;
			<a href="cemeteryCommodityController.fj?method=editCemeteryCommodity&id=<c:out value='${en.id}'/>">编辑</a>&nbsp;&nbsp;
			<a href="#" onclick="confirmDelete(<c:out value='${en.id}'/>)">删除</a></td>
		</tr>
		</c:forEach>
	</table>
	<table width="98%" border="0" cellspacing="0" cellpadding="10" class="word-4">
		<tr align="right" >
			<td >
			<ft:page action="cemeteryCommodityController.fj?method=getCemeteryCommodityList" page="${page}">
				<input name="commodityName" type="hidden" class="input-1" id="commodityName" value="<c:out value='${param.commodityName}'/>"/>
				<input name="commodityType" type="hidden" class="input-1" id="commodityType" value="<c:out value='${param.commodityType}'/>"/>
			</ft:page> 
			</td >
			<td width="120"><ft:pageInfo page="${page}"/></td>
		</tr>
	</table>
	<form  action ="" id="isdelform" method="post"> </form>
	<script type="text/javascript">
	function doReset(){
		 
		  $("#queryForm input").each(function(){
		  
		   if($(this).attr("name")=="commodityName"){
			   $(this).val("");
		   }
		  });
		 
		 $('#commodityType').attr('value','-1');
	 }
		function confirmDelete(id){
			if(confirm("确定要删除？"))
			{
				var url="cemeteryCommodityController.fj?method=deleteCemeteryCommodity&id="+id ;
				$("#isdelform").attr("action",url);
			    $("#isdelform").submit();  
			}
		 }
	</script>
</body>
</html>
