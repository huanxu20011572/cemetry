<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ include file="../common/head.jsp"%>
<body style="background-color: transparent">
	<form action="" id="isform" method="post">
	<input type="hidden" value="<c:out value='${param.pid}'/>" name="pid" id="pid"/>
	<input type="hidden" value="<c:out value='${cemeteryCommodity.id}'/>" name="id" id="id"/>
	<table width="100%" border="0" cellspacing="0" cellpadding="0" height="100%">
  <tr>
    <td width="11" valign="top" class="td-bg"><img src="../images/right-1.jpg" /></td>
    <td align="center" valign="top" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="31" align="left" valign="middle" style="background:url(../images/right-3.jpg)"><img src="../images/right-4.jpg" width="9" height="8" align="absmiddle" /> 当前位置 &gt;商品管理&gt;入库登记</td>
      </tr>
      <tr>
        <td bgcolor="#FFFFFF" style="font-size:12px;">&nbsp;</td>
      </tr>
    </table>
	 
      <table width="98%" cellpadding="0" cellspacing="1" bgcolor="#a6c6da">
<tr>
          <td width="138" height="35" align="right" bgcolor="#D4E5F4">商品名称：</td>
          <td width="280" align="left" bgcolor="#FFFFFF">
              <input name="commodityName" type="text" id="commodityName" class="input-1" 
              value="<c:out value='${cemeteryCommodity.commodityName}'/>"/><span class="word-7">*</span>
		 </td>
		  <td width="124" height="35" align="right" bgcolor="#D4E5F4">商品类别：</td>
          <td width="301" align="left" bgcolor="#FFFFFF">
            <ft:select name="commodityType" type="spfl" selected="${cemeteryCommodity.commodityType}" style="width:190px"></ft:select>
            <span class="word-7">*</span>
		  </td>      
        </tr>
		 
		<tr>
		  <td width="138" align="right" bgcolor="#D4E5F4">规格：</td>
          <td width="280" align="left" bgcolor="#FFFFFF">
               <input name="specifications" type="text" id="specifications" class="input-1" 
               value="<c:out value='${cemeteryCommodity.specifications}'/>"/>
			</td>
          <td width="124" height="35" align="right" bgcolor="#D4E5F4">进货价格：</td>
          <td width="301" align="left" bgcolor="#FFFFFF">
             <input name="inPrice" type="text" id="inPrice" class="input-1" 
             value="<c:out value='${cemeteryCommodity.inPrice}'/>"/>
             <span class="word-7">*</span>
		  </td>         
        </tr> 
		<tr>
		  <td width="138" align="right" bgcolor="#D4E5F4">销售价格：</td>
          <td width="280" align="left" bgcolor="#FFFFFF">
               <input name="outPrice" type="text" id="outPrice" class="input-1" 
               value="<c:out value='${cemeteryCommodity.outPrice}'/>"/><span class="word-7">*</span>
			</td>
          <td width="124" height="35" align="right" bgcolor="#D4E5F4">库存量：</td>
          <td width="301" align="left" bgcolor="#FFFFFF">
             <input name="count" type="text" id="count" class="input-1" 
             value="<c:out value='${cemeteryCommodity.count}'/>"/><span class="word-7">*</span>
		  </td>         
        </tr> 
		<tr>
		  <td width="138" align="right" bgcolor="#D4E5F4">业务员：</td>
          <td width="280" align="left" bgcolor="#FFFFFF">
              <gOS_shjz:shjzUser key="${cemeteryCommodity.createUserId}"/>
			</td>
          <td width="124" height="35" align="right" bgcolor="#D4E5F4">登记时间：</td>
          <td width="301" align="left" bgcolor="#FFFFFF">
            <fmt:formatDate value='${cemeteryCommodity.createDate}' pattern="yyyy-MM-dd"/>
		  </td>
        </tr>
     </table>
	  <table width="98%" cellpadding="0" cellspacing="0">
		<tr>
			<td colspan="4" align="center" bgcolor="#FFFFFF">
				&nbsp;
			</td>
		</tr>
		<tr>
			<td colspan="4" align="center" bgcolor="#FFFFFF">
				<input class="button-z" type="button" name="saveBtn" id="saveBtn" value="保存"  onclick="doSave();"/>&nbsp;&nbsp;&nbsp;
				<input name="button3" type="button" onclick="javascript:location.href='cemeteryCommodityController.fj?method=getCemeteryCommodityList';" class="button-z" id="button3" value="返回" />
			</td>
	    </tr>
	</table>
	</form>
	<script type="text/javascript">
		function doSave(){
			var commodityName = $.trim($("#commodityName").val());
			if ("" == commodityName) {
				alert("商品名称不能为空");
				return;
			}  
			if(commodityName.length>20){
				alert("商品名称的最大长度为20个字符");
				return;
			}
			var commodityType=$("#commodityType").val();
			if("-1"==commodityType){
				alert("请选择商品类别！");
				return;
			}
			var specifications = $.trim($("#specifications").val());
			
			if(specifications.length>20){
				alert("规格的最大长度为20个字符!");
				return;
			}
			var inPrice=$.trim($("#inPrice").val());
			var patrn=/^(([1-9]{1}\d*)|([0]{1}))(\.(\d){1,2})?$/;
			
			if(inPrice==""){
				alert("进货价格不能为空!");
				return;
			}
			if(inPrice!=""&&!patrn.exec(inPrice)){
				alert("进货价格只能为货币!");
				return;
			}
			var outPrice=$.trim($("#outPrice").val());
			var patrn=/^(([1-9]{1}\d*)|([0]{1}))(\.(\d){1,2})?$/;
			
			if(outPrice==""){
				alert("销售价格不能为空!");
				return;
			}
			if(outPrice!=""&&!patrn.exec(outPrice)){
				alert("销售价格只能为货币!");
				return;
			}
			var count=$.trim($("#count").val());
			if(count==""){
				alert("库存量不能为空!");
				return;
			}
			if(count!=""&&!/^[0-9]+$/g.test(count)){
				alert("库存量必须为数字!");
				return;
			}
			if(confirm("确定要保存？")){
				isform.action = "cemeteryCommodityController.fj?method=saveCemeteryCommodity";
				//isform.submit();
				$("#isform").submit();
			}
		}
	</script>
</body>
</html>