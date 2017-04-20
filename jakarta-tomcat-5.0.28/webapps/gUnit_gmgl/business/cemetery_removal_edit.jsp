<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ include file="../common/head.jsp"%>
<head>
<script type="text/javascript">
	//完成登记
	function endCemeteryRegistry(id,locationId){
		if(id == ''){
			alert("请先保存信息");
			return false;
		}
	   	location.href="cemeteryRegistryController.fj?method=endCemeteryRegistry&cemeteryRegistryType=4&id=" + locationId;
	}
	
	//费用增加
   function addCemeteryCharge(regeditId){
		if(regeditId == ""){
			alert("请先保存信息");
			return false;
		}
		var redirect_url =$.base64.encode('cemeteryRegistryController.fj?method=editCemeteryRegistry&cemeteryRegistryType=4&id='+regeditId);
		location.href = "cemeteryRegistryController.fj?method=getCemeteryChargeframe&cemeteryRegistryType=4&id="+regeditId +"&redirect_url="+redirect_url;
   }
   //上传文件
   function getCemeteryFileEdit(regeditId){
		if(regeditId == ""){
			alert("请先保存信息");
			return false;
		}
		var redirect_url =$.base64.encode('cemeteryRegistryController.fj?method=editCemeteryRegistry&cemeteryRegistryType=4&id='+regeditId);
		location.href = "cemeteryRegistryController.fj?method=getCemeteryFileEdit&cemeteryRegistryType=4&id="+regeditId +"&redirect_url="+redirect_url;
   }
	   
   function bulidPrice(){
		//墓位价格=工程费+土地租赁费+管理费
		$("#cemeteryPrice").val(parseFloat($("#groundPrice").text())+parseFloat($("#constructionPrice").text())+parseFloat($("#managePrice").text()));
		if(isNaN(parseFloat($("#cemeteryPrice").val()))){
			$("#cemeteryPrice").val(0);
		}
		
		//其他费用
	   	var charges = document.getElementsByName("charges");
	   	var v_otherPrice = 0;
	   	for(i = 0; i< charges.length; i++){
	   		
	   		if(navigator.userAgent.indexOf('Firefox') >= 0){
		   		var val = charges[i].textContent;
	   		}else{
		   		var val = charges[i].innerText;
	   		}
	   		
	   		(val == "" || isNaN(val)) ? val = 0:val;
	   		v_otherPrice = parseFloat(v_otherPrice) + parseFloat(val);
	      	}
	   	$("#otherPrice").val(v_otherPrice);

	   	// 应收费用=墓穴价格+其他费用
	   	$("#totalPrice").val(parseFloat($("#cemeteryPrice").val())+ parseFloat($("#otherPrice").val()));
		
	   	//实收费用=应收费用-优惠费用
		($("#discountPrice").val() == "" || isNaN($("#discountPrice").val())) ? $("#discountPrice").val(0) :$("#discountPrice").val(parseFloat($("#discountPrice").val()));
	   	$("#factPrice").val(parseFloat($("#totalPrice").val()) - parseFloat($("#discountPrice").val()));
		
   }
 $(document).ready(function(){
	bulidPrice();
	//保存按钮的校验
	$("#saveCemeteryRegistryBtn").click(function(){
	    var backPrice=parseFloat($("#backPrice").val());
	    if (isNaN(backPrice)) {
	        alert("退费金额需要输入数字");
	        return false;
	    }
	    $("#saveCemeteryRegistyForm").submit();
	 });
		 
	    
 });

function showinfo(){
	var is_oneself = $("input[name='isOneself']:checked").val();
	if(is_oneself == 1){
		 $("#no_oneself").hide();
		 $("#no_oneself2").hide();
		 $("#no_oneself3").hide();
	}
	if(is_oneself ==0){
		$("#no_oneself").show();
		$("#no_oneself2").show();
		$("#no_oneself3").show();
	}
}
</script>
</head>
<body style="background-color: transparent">
<table width="100%" border="0" cellspacing="0" cellpadding="0" height="100%">
    <tr>
	  <td width="11" valign="top" class="td-bg"><img src="../images/right-1.jpg" /></td>
	    <td align="center" valign="top">
	  
	  <table width="100%" border="0" cellspacing="0" cellpadding="0">
	    <tr>
	      <td height="31" align="left" valign="middle" 	style="background: url(../images/right-3.jpg)"><img src="../images/right-4.jpg" width="9" height="8" align="absmiddle" /> 当前位置 &gt; 业务办理 &gt; 续租登记</td>
	    </tr>
	    <tr>
	      <td bgcolor="#FFFFFF" style="font-size: 12px;">&nbsp;</td>
	    </tr>
	  </table>
	  <!-- 输入域 --> <!-- 隐藏域 -->
	  <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
	    <tr>
	      <td width="92%" bgcolor="#EBF4FA"><table width="200" border="0" cellspacing="0" cellpadding="0">
	          <tr>
	            <td width="20" align="right"><img src="../images/tab-01.jpg" width="8" height="27" /></td>
	            <td width="99" align="center" class="tab-img-01">迁出登记</td>
	            <td width="81" align="left" valign="bottom"><img src="../images/tab-03.jpg" /></td>
	          </tr>
	        </table></td>
	    </tr>
	  </table>
		  <form id="saveCemeteryRegistyForm" action="cemeteryRegistryController.fj?method=saveCemeteryRegistry" method="post">
		  <input name="isSupply" type="hidden" id="isSupply" value="0" />
		  <input name="cemeteryRegistryType" type="hidden" id="cemeteryRegistryType" value="<c:out value='${entity.cemeteryRegistryType}'/>" />
		  <input name="cemeteryLocationId" type="hidden" id="cemeteryLocationId" value="<c:out value='${entity.cemeteryLocation.id}'/>" />
			<input type="hidden" name="id" id="id" value="<c:out value='${entity.id}'/>" />
			<table width="98%" border="0" cellspacing="0" cellpadding="3">
			    <tr>
			        <td bgcolor="#C4DEEE">
			            <table id="baseInfo" width="100%" cellpadding="0" cellspacing="1" bgcolor="#a6c6da">
			                <tr>
			                    <td width="15%" height="35" align="right" bgcolor="#D4E5F4">承租人本人办理：</td>
			                    <td width="35%" align="left" bgcolor="#FFFFFF">
									<input name="isOneself" type="radio" id="isOneself" onclick="javascirpt:showinfo()" 
									value="1" <c:if test='${entity.isOneself == 1}'>checked="checked"</c:if> />是
						            <input name="isOneself" type="radio" id="isOneself"  onclick="javascirpt:showinfo()" 
						            value="0" <c:if test='${entity.isOneself == 0}'>checked="checked"</c:if>  />否
			                    </td>
			                    <td width="15%" align="right" bgcolor="#D4E5F4">业务编号：</td>
			                    <td width="35%" align="left" bgcolor="#FFFFFF">
			                    	<input name="cemeteryRegistryCode" type="text" id="cemeteryRegistryCode" readonly="readonly" class="input-1" 
					          		value="<c:out value='${entity.cemeteryRegistryCode}'/>" /></td>
			                </tr>
			                    <tr id="no_oneself">
					              <td width="15%"  height="35" align="right" bgcolor="#D4E5F4">代理人姓名： </td>
					              <td width="35%" align="left" bgcolor="#FFFFFF"><input name="agentName" type="text"  class="input-1" id="agentName" 
					            		value="<c:out value='${entity.agentName}'/>" /></td>
			                      <td width="15%" height="35" align="right" bgcolor="#D4E5F4">代理人电话：</td>
					              <td  width="35%" align="left" bgcolor="#FFFFFF"><input name="agentTel" type="text"  class="input-1" id="agentTel" 
					            		value="<c:out value='${entity.agentTel}'/>" /></td>
				                </tr>
			                    <tr  id="no_oneself2"> 
					              <td width="15%"  height="35" align="right" bgcolor="#D4E5F4">代理凭证：</td>
					              <td width="35%" align="left" bgcolor="#FFFFFF"><input name="agentProve" type="text"  class="input-1" id="agentProve" 
					            		value="<c:out value='${entity.agentProve}'/>" /></td>
			                      <td width="15%" height="35" align="right" bgcolor="#D4E5F4">&nbsp;</td>
					              <td  width="35%" align="left" bgcolor="#FFFFFF">&nbsp;</td>
				                </tr>
			                    <tr  id="no_oneself3">
					              <td width="15%"  height="35" align="right" bgcolor="#D4E5F4">代理原因：</td>
					              <td height="35" colspan="3" align="left" bgcolor="#FFFFFF"><textarea name="agentReason" ><c:out value='${entity.agentReason}'/></textarea></td>
			                    </tr>
					        <tr>
					          <td height="35" align="right" bgcolor="#D4E5F4">迁出原因：</td>
					          <td align="left" bgcolor="#FFFFFF"><input name="backReason" type="text" id="backReason" class="input-1" value="<c:out value='${entity.backReason}'/>" />
					           </td>
					          <td align="right" bgcolor="#D4E5F4">退费金额：</td>
					          <td align="left" bgcolor="#FFFFFF"><input name="backPrice" type="text" id="backPrice" class="input-1" value="<c:out value='${entity.backPrice}'/>" />
					            （元）</td>
					        </tr>
					        <tr>
					          <td height="35" align="right" bgcolor="#D4E5F4">业务员：</td>
					          <td align="left" bgcolor="#FFFFFF"><gOS_shjz:shjzUser key="${entity.createUserId}"/></td>
					          <td align="right" bgcolor="#D4E5F4">办理时间：</td>
					          <td align="left" bgcolor="#FFFFFF"><fmt:formatDate value='${entity.createDate}' pattern="yyyy-MM-dd" /></td>
					          </tr>
					        
					        <tr height='50px'>
					          <td align="right" bgcolor="#D4E5F4">备注：</td>
					          <td colspan='3' align="left" bgcolor="#FFFFFF"><textarea	name="remark" id="remark" class="input-1"	style='height: 40px; width: 90%'><c:out value='${entity.remark}' /></textarea></td>
					        </tr>
					      </table>
			        </td>
			    </tr>
			</table>
		    <table width="100%" border="0" cellspacing="0" cellpadding="0">
		      <tr>
		        <td>&nbsp;</td>
		      </tr>
		    </table>
		        <table>
		          <tr>
		            <td height="35">
			            <input name="button" type="button" class="button-z4" id="saveCemeteryRegistryBtn" value="保存" />&nbsp;
			            <input name="button" type="button" class="button-z4" value="打印业务单" />&nbsp;
			            <input name="button" type="button" class="button-z4" value="打印安葬证" />&nbsp;
			            <input name="button" type="button" onclick="endCemeteryRegistry('${entity.id}','${entity.cemeteryLocation.id}');" class="button-z4" value="完成" />&nbsp;
			            <input name="button" type="button" onclick="javascript:location.href='cemeteryRegistryController.fj?method=getCemeteryRegistryPageList&cemeteryRegistryType=4';" class="button-z4" value="返回" />
		            </td>
		          </tr>
		        </table>
		      </tr>
		    </table>
		  </form>
	    </td>
    </tr>
</table>
</body>
<script type="text/javascript">
	showinfo();
</script>
</html>
