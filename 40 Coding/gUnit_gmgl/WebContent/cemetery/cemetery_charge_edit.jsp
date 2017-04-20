<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ include file="../common/head.jsp"%>
<head>
<title>商品出库管理</title>
<script type="text/javascript">
function saveOutStorehouse() {
	var patrn=/^(([1-9]{1}\d*)|([0]{1}))(\.(\d){1,2})?$/;
	 var counts = $("input[name='count']");
	 for(var i=0; i<counts.length;i++){
		 if(!patrn.exec(counts[i].value) || counts[i].value.length<=0){
			 alert("商品数量不合法，无法出库！");
			return;
		 }
	 }
		 
	var outStoreType = document.getElementById("outStoreType").value;
	document.getElementById("outStorehouseType").value=outStoreType;
	cemeteryChargeForm.action = "cemeteryChargeController.fj?method=saveCemeteryChargeList";
	$("#cemeteryChargeForm").submit();
}
function doBack(){
	var redirect_url = '../cemetery/cemeteryChargeController.fj?method=getCemeteryChargeList';
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
	 		ifm.src = "../cemetery/cemeteryCommodityController.fj?method=getCemeteryCommodityList&checked=checked&commodityName="+$('#commodityName').val()+"&commodityType="+$('#commodityType').val();
	 	}
    });
	
	$("#resetBtn").click(function(){
		if($(this).attr("name")=="commodityName"){
			   $(this).val("");
		   }
		 $('#commodityType').attr('value','-1');
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
	var patrn=/^(([1-9]{1}\d*)|([0]{1}))(\.(\d){1,2})?$/;
	
	 if(row.checked == true && checkedCharge(id,isChargeType)){
		 if(!patrn.exec(price)){
				alert("商品价格不合法，无法出库！");
				return;
			}
			if(!patrn.exec(num)){
				alert("商品数量不合法，无法出库！");
				return;
			}
			if(num<=0){
				alert("商品数量不足，无法出库！");
				return;
			}
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
	 if (i_input.value > num) {
	        alert("输入数量不能大于库存数量");
	        return false;
	 }
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
        <td height="31" align="left" valign="middle" style="background:url(../images/right-3.jpg)"><img src="../images/right-4.jpg" width="9" height="8" align="absmiddle" /> 当前位置 &gt;商品管理 &gt;出库登记</td>
      </tr>
      <tr>
        <td bgcolor="#FFFFFF" style="font-size:12px;">&nbsp;</td>
      </tr>
    </table>
    <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                    <td width="15%" bgcolor="#EBF4FA">
                        <table width="200" border="0" align="left" cellpadding="0" cellspacing="0">
                            <tr>
                                <td width="20" align="right"><img src="../images/tab-01.jpg" width="8" height="27"/>
                                </td>
                                <td width="99" align="center" class="tab-img-01">出库信息</td>
                                <td width="81" align="left" valign="bottom"><img src="../images/tab-03.jpg"/></td>
                            </tr>
                        </table>
                    </td>
                    <td width="70%" align="left" bgcolor="#EBF4FA">
                    </td>
                    <td width="15%" align="left" bgcolor="#EBF4FA">
                    </td>
                </tr>
            </table>
            <table width="98%" cellpadding="0" cellspacing="1" bgcolor="#a6c6da">
                <!-- 表格一行两类-->
                <tr>
                    <td width="15%" height="35" align="right" bgcolor="#D4E5F4">出库类型：</td>
                    <td width="35" align="left" bgcolor="#FFFFFF">
                        <select id="outStoreType" name="outStoreType" class="input-1" style="height:20px" >
                            <OPTION value='1' selected="selected">售卖</OPTION>
                            <option value='2'>赠送</option>
                            <option value='3'>损耗</option>
                        </select>
                    </td>
                    <td width="15%" align="right" bgcolor="#D4E5F4"></td>
                    <td width="35" align="left" bgcolor="#FFFFFF"></td>
                </tr>
                <tr>
                    <td height="35" align="right" bgcolor="#D4E5F4">登记人：</td>
                    <td align="left" bgcolor="#FFFFFF">
                    <gOS_shjz:shjzUser key="${cemeteryCharge.createUserId}"/>
                    </td>
                    <td align="right" bgcolor="#D4E5F4">登记时间：</td>
                    <td align="left" bgcolor="#FFFFFF"><fmt:formatDate value='${cemeteryCharge.createDate}' pattern="yyyy-MM-dd" />
                    </td>
                </tr>
            </table>

            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <td>&nbsp;</td>
                </tr>
            </table>
    
    <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                    <td width="15%" bgcolor="#EBF4FA">
                        <table width="200" border="0" align="left" cellpadding="0" cellspacing="0">
                            <tr>
                                <td width="20" align="right"><img src="../images/tab-01.jpg" width="8" height="27"/>
                                </td>
                                <td width="99" align="center" class="tab-img-01">选择商品</td>
                                <td width="81" align="left" valign="bottom"><img src="../images/tab-03.jpg"/></td>
                            </tr>
                        </table>
                    </td>
                    <td width="70%" align="left" bgcolor="#EBF4FA">
                    </td>
                    <td width="15%" align="left" bgcolor="#EBF4FA">
                    </td>
                </tr>
            </table>
      <table width="98%" cellpadding="0" cellspacing="1" bgcolor="#a6c6da">
         <tr>
          <td width="15%" align="right" bgcolor="#D4E5F4">商品名称：</td>
          <td width="35%" align="left" bgcolor="#FFFFFF">
          	<input name="commodityName" type="text" class="input-1" id="commodityName" value="<c:out value='${param.commodityName}'/>"/>
          </td>
          <td width="15%" height="35" align="right" bgcolor="#D4E5F4">商品分类：</td>
          <td width="35%" align="left" bgcolor="#FFFFFF">
            <input name="selectChargeType" type="hidden" class="input-1" id="selectChargeType" value="0"/>
            <ft:select   name="commodityType" type="spfl" selected="${param.commodityType}" style="width:190px"></ft:select>
		  </td>
        </tr>
        <tr>
            <td height="35" colspan="4" align="center" bgcolor="#FFFFFF">
		      <input name="queryBtn" type="button" class="button-z" id="queryBtn" value="查询" /> 
		      <input name="resetBtn" type="button" class="button-z" id="resetBtn" value="重置" />
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
  	<form id="cemeteryChargeForm" action="" method="post">
  	  
      <input type='hidden' name='outStorehouseType' id='outStorehouseType' value=''/>
      <table id="cemeteryChargeTable" width="98%" cellpadding="0" cellspacing="1" bgcolor="#a6c6da">
        <tr>
          <td   height="30" align="center" bgcolor="#D4E5F4">商品名称</td>
          <td   align="center" bgcolor="#D4E5F4">商品类别</td>
          <td   align="center" bgcolor="#D4E5F4">单价</td>
          <td   align="center" bgcolor="#D4E5F4">数量</td>
          <td   align="center" bgcolor="#D4E5F4">费用</td>
          <td   width='5%' align="center" bgcolor="#D4E5F4">操作</td>  		  
        </tr>
       </table>
       <table>
         <tr>
           <td   height="30" colspan="8" align="center" bgcolor="#FFFFFF">
           <input name="button" type="button" class="button-z" id="button" onclick="saveOutStorehouse();" value="完成" /> &nbsp;&nbsp; 
           <input name="button2" type="button" class="button-z" id="button2" value="返回"  onclick="javascirpt:doBack();" /></td>	 	 
        </tr>
   	  </table>
   	  </form>
	</td>
  </tr>
</table>
</body>
</html>