<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ include file="../common/head.jsp"%>
<head>
<title>费用管理</title>
<script type="text/javascript">
function doBack(){
	var redirect_url = $.base64.decode('${param.redirect_url}');
	location.href=redirect_url;
}

function autoIframe() {
	var ifm= document.getElementById("iframepage");
	var subWeb = document.frames ? document.frames["iframepage"].document : ifm.contentDocument;
	if(ifm != null && subWeb != null) {
		ifm.height = subWeb.body.scrollHeight;
	}
} 

$(document).ready(function(){
	//selectChargeType商品0，费用1，

	var ifm= document.getElementById("iframepage");
	//选择项
    $("#selectChargeType").change(function(){
	 	if($("#selectChargeType").val() == 0){
	 		ifm.src = "../cemetery/cemeteryCommodityController.fj?method=getCemeteryCommodityList&checked=checked";
	 	}
	 	if($("#selectChargeType").val() == 1){
	 		ifm.src = "../charge/chargeDataController.fj?method=getChargeDataList&checked=checked";
	 	}
    });
	  
	$("#queryBtn").click(function(){
		if($("#selectChargeType").val() == 0){
	 		ifm.src = "../cemetery/cemeteryCommodityController.fj?method=getCemeteryCommodityList&checked=checked&commodityName="+$('#name').val();
	 	}
	 	if($("#selectChargeType").val() == 1){
	 		ifm.src = "../charge/chargeDataController.fj?method=getChargeDataList&checked=checked&chargeDataName="+$('#name').val();
	 	}
    });
});

/**
 * 回调函数，如果页面元素没有被选择可以增加页面元素
 * row:checked元素
 * id:商品id/费用id，
 * name:商品名称/费用明细名称
 * isChargeType0商品1费用，
 * typeName商品类型/费用类型
 * price价格
 * num商品数量
 */
function doAppendCharge(row,id,name,isChargeType,typeName,price,num){
	 if(row.checked == true && checkedCharge(id,isChargeType)){
			var tr="<tr>";
			tr += "<td height='30' align='center' bgcolor='#FFFFFF'><input  type='hidden' id='isChargeType' name='isChargeType' value='"+isChargeType+"' /><input  type='hidden' id='id' name='id'  value='" + id + "'/>"+name+"</td>";
			tr += "<td align='center' bgcolor='#FFFFFF'>"+typeName+"</td>";
			tr += "<td align='center' bgcolor='#FFFFFF'>"+price+"</td>";
			tr += "<td align='center' bgcolor='#FFFFFF' ><input  type='text' ";
				if(isChargeType == 0){
					tr += "onkeyup='javascript:bulidCommodityPrice(this,"+id+","+num+","+price+");' ";
				}else{
					tr += "readonly='readonly' ";
				}
			tr += "id='count' name='count' value='1'/></td>";
			tr += "<td align='center' bgcolor='#FFFFFF'><input  type='text' readonly='readonly' id='receive' name='receive'  value='"+price+"'/></td>";
			tr += "<td align='center' bgcolor='#FFFFFF' class='word-7' ><a href='#' onclick='deleteCharge(this)'>删除</a></td>";
			tr += "</tr>";
		$("#cemeteryChargeTable").append(tr);
	 }
}

//删除cemeteryCharge
function deleteCharge(node){
	$(node).parent().parent().remove(); 
}

//校验内容是否被重复选中，被选择中返回false;
function checkedCharge(id,isChargeType){
	 var ids = $("input[name='id']");
	 for(var i=0; i<ids.length;i++){
		 if(ids[i].value == id && $("input[name='isChargeType']")[i].value == isChargeType){
			 return false;
		 }
	 }
	 return true;
}

//计算费用金额
function bulidCommodityPrice(i_input,id,num,price){
	 if (isNaN(i_input.value) || i_input.value <1) {
	        alert("请正确输入数量");
	        return false;
	 }
	 //补录数据不验证库存数量
	 <c:if test="${param.isSupply == 0}">
	 if (i_input.value > num) {
	        alert("收入数量不能大于库存数量");
	        return false;
	 }
	 </c:if>
	 var ids = $("input[name='id']");
	 for(var i=0; i<ids.length;i++){
		 if(ids[i].value == id){
			 $("input[name='receive']")[i].value = i_input.value * price;
		 }
	 }
}
</script>
</head>
 
<body style="background-color:transparent">
<table width="100%" border="0" cellspacing="0" cellpadding="0" height="100%">
  <tr>
    <td width="11" valign="top" class="td-bg"><img src="../images/right-1.jpg" /></td>
    <td align="center" valign="top" >
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="31" align="left" valign="middle" style="background:url(../images/right-3.jpg)"><img src="../images/right-4.jpg" width="9" height="8" align="absmiddle" /> 当前位置 &gt;档案管理 &gt;收费信息登记</td>
      </tr>
      <tr>
        <td bgcolor="#FFFFFF" style="font-size:12px;">&nbsp;</td>
      </tr>
    </table>
      <table width="98%" cellpadding="0" cellspacing="1" bgcolor="#a6c6da">
         <tr>
          <td width="15%" height="35" align="right" bgcolor="#D4E5F4">收费类别：</td>
          <td width="35%" align="left" bgcolor="#FFFFFF">&nbsp;
		    <select class="input-1" style="height:20px" id="selectChargeType" name="selectChargeType">
               <option value ="0" >商品 </option>
               <option value ="1" >其他 </option>         
            </select>
		  </td>
          <td width="15%" align="right" bgcolor="#D4E5F4">收费项目名称：</td>
          <td width="35%" align="left" bgcolor="#FFFFFF">&nbsp;
          <input name="name" type="text" id="name" class="input-1" value="" /></td>
        </tr>
        <tr>
            <td height="35" colspan="4" align="center" bgcolor="#FFFFFF">
		      <input name="queryBtn" type="button" class="button-z" id="queryBtn" value="查询" /> 
		      <input name="resetBtn" type="button" onclick="javascript:$('#name').val('');" class="button-z" id="resetBtn" value="重置" />
			</td>
        </tr>
      </table>
	  <table width="100%" border="0" cellspacing="0" cellpadding="0">
       <tr>
         <td>&nbsp;</td>
        </tr>
      </table>
      <iframe onLoad="autoIframe();" id="iframepage" name="iframepage" frameBorder=0 scrolling=no width="98%" 
      src="../cemetery/cemeteryCommodityController.fj?method=getCemeteryCommodityList&checked=checked" ></iframe>
	 <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
         <tr>
	        <td width="92%" bgcolor="#EBF4FA">
			<table width="200" border="0" cellspacing="0" cellpadding="0">
	          <tr>
	            <td width="20" align="right"><img src="../images/tab-01.jpg" width="8" height="27" /></td>
	            <td width="99" align="center" class="tab-img-01"> 已选择费用 </td>						
	            <td width="81" align="left" valign="bottom"><img src="../images/tab-03.jpg" /></td>
              </tr>
            </table>
			</td>
         </tr>
	  </table>
  	<form id="cemeteryChargeForm" action="archivesCemeteryRegistryController.fj?method=saveCemeteryChargeList" method="post">
      <input type='hidden' name='cemeteryRegistryId' value="<c:out value='${cemeteryRegistry.id}'/>"/>
	  <input  type="hidden" id="isSupply"  name="isSupply" value="<c:out value='${param.isSupply}'/>" />
      <input type='hidden' name='cemeteryRegistryType' value="<c:out value='${param.cemeteryRegistryType}'/>"/>
      <table id="cemeteryChargeTable" width="98%" cellpadding="0" cellspacing="1" bgcolor="#a6c6da">
        <tr>
          <td   height="30" align="center" bgcolor="#D4E5F4">收费项目</td>
          <td   align="center" bgcolor="#D4E5F4">收费类别</td>
          <td   align="center" bgcolor="#D4E5F4">单价</td>
          <td   align="center" bgcolor="#D4E5F4">数量</td>
          <td   align="center" bgcolor="#D4E5F4">费用</td>
          <td   width='5%' align="center" bgcolor="#D4E5F4">操作</td>  		  
        </tr>
       </table>
       <table>
         <tr>
           <td   height="30" colspan="8" align="center" bgcolor="#FFFFFF">
           <input name="button" type="submit" class="button-z" id="button" value="完成" /> &nbsp;&nbsp; 
           <input name="button2" type="button" class="button-z" id="button2" value="返回"  onclick="javascirpt:doBack();" /></td>	 	 
        </tr>
   	  </table>
   	  </form>
	</td>
  </tr>
</table>
</body>
</html>