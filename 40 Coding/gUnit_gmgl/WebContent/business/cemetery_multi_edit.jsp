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
	   	location.href="cemeteryRegistryController.fj?method=endCemeteryRegistry&cemeteryRegistryType=3&id=" + locationId;
	}
	//逝者信息增加 regeditId:业务id,id:逝者id
   function departedView(regeditId,id){
		var redirect_url =$.base64.encode('cemeteryRegistryController.fj?method=editCemeteryRegistry&cemeteryRegistryType=3&id='+regeditId);
	   	location.href="departedController.fj?method=getDepartedViewById&id=" + id + "&regeditId=" + regeditId + "&redirect_url="+redirect_url;
   }
	//逝者信息增加 regeditId:业务id,id:逝者id
   function departedEdit(regeditId,id){
		if(regeditId == ""){
			alert("请先保存信息");
			return false;
		}
		var redirect_url =$.base64.encode('cemeteryRegistryController.fj?method=editCemeteryRegistry&cemeteryRegistryType=3&id='+regeditId);
	   	location.href="departedController.fj?method=editDeparted&id=" + id + "&regeditId=" + regeditId + "&redirect_url="+redirect_url;
   }
	//逝者信息增加 regeditId:业务id,id:逝者id
   function departedDel(regeditId,id){
		var redirect_url =$.base64.encode('cemeteryRegistryController.fj?method=editCemeteryRegistry&cemeteryRegistryType=3&id='+regeditId);
	   	location.href="departedController.fj?method=deleteDepartedById&id=" + id + "&regeditId=" + regeditId + "&redirect_url="+redirect_url;
   }
	
	//费用增加
   function addCemeteryCharge(regeditId){
		if(regeditId == ""){
			alert("请先保存信息");
			return false;
		}
		var redirect_url =$.base64.encode('cemeteryRegistryController.fj?method=editCemeteryRegistry&cemeteryRegistryType=3&id='+regeditId);
		location.href = "cemeteryRegistryController.fj?method=getCemeteryChargeframe&cemeteryRegistryType=3&id="+regeditId +"&redirect_url="+redirect_url;
   }
   //上传文件
   function getCemeteryFileEdit(regeditId){
		if(regeditId == ""){
			alert("请先保存信息");
			return false;
		}
		var redirect_url =$.base64.encode('cemeteryRegistryController.fj?method=editCemeteryRegistry&cemeteryRegistryType=3&id='+regeditId);
		location.href = "cemeteryRegistryController.fj?method=getCemeteryFileEdit&cemeteryRegistryType=3&id="+regeditId +"&redirect_url="+redirect_url;
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
	    var discountPrice=parseFloat($("#discountPrice").val());
	    if (isNaN(discountPrice)) {
	        alert("优惠费用需要输入数字");
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
	      <td height="31" align="left" valign="middle" 	style="background: url(../images/right-3.jpg)"><img src="../images/right-4.jpg" width="9" height="8" align="absmiddle" /> 当前位置 &gt; 业务办理 &gt; 合葬登记</td>
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
	            <td width="99" align="center" class="tab-img-01">合葬登记</td>
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
					          <td height="35" align="right" bgcolor="#D4E5F4">墓穴价格：</td>
					          <td align="left" bgcolor="#FFFFFF"><input name="cemeteryPrice" type="text" id="cemeteryPrice" readonly="readonly" class="input-1" value="<c:out value='${entity.cemeteryLocation.cemeteryType.managePrice+entity.cemeteryLocation.cemeteryType.constructionPrice+ntity.cemeteryLocation.cemeteryType.groundPrice}'/>" />
					            （元） </td>
					          <td align="right" bgcolor="#D4E5F4">其他费用：</td>
					          <td align="left" bgcolor="#FFFFFF"><input name="otherPrice" type="text" id="otherPrice" readonly="readonly" class="input-1" value="<c:out value='${entity.otherPrice}'/>" />
					            （元）</td>
					        </tr>
					        <tr>
					          <td width="15%" height="35" align="right" bgcolor="#D4E5F4">应收费用：</td>
					          <td width="35%" align="left" bgcolor="#FFFFFF"><input style="height: 17px" name="totalPrice" type="text" id="totalPrice" readonly="readonly" value="<c:out value='${entity.totalPrice}'/>"  class="input-1" />
					            （元） </td>
					          <td width="15%" height="35" align="right" bgcolor="#D4E5F4">优惠费用：</td>
					          <td width="35%" align="left" bgcolor="#FFFFFF"><input style="height: 17px" name="discountPrice" onkeyup="javascript:bulidPrice();" type="text"id="discountPrice" class="input-1" value="<c:out value='${entity.discountPrice}'/>" />
					            （元） </td>
					        </tr>
					        <tr>
					          <td align="right" height="35" bgcolor="#D4E5F4">实收费用：</td>
					          <td colspan='3' align="left" bgcolor="#FFFFFF"><input style="height: 17px" name="factPrice" type="text"id="factPrice" readonly="readonly"  class="input-1" value="<c:out value='${entity.factPrice}'/>" />
					            （元） </td>
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
		    <table width="98%" border="0" align="center" cellpadding="0" 	cellspacing="0">
		      <tr>
		        <td width="91%" bgcolor="#EBF4FA"><table width="200" border="0" cellspacing="0" cellpadding="0">
		            <tr>
		              <td width="20" align="right"><img src="../images/tab-01.jpg" width="8" height="27" /></td>
		              <td width="99" align="center" class="tab-img-01">逝者信息</td>
		              <td width="81" align="left" valign="bottom"><img src="../images/tab-03.jpg" /></td>
		            </tr>
		          </table></td>
		        <td width="9%" align="center" bgcolor="#EBF4FA">
		          <input id="departedAddBtn" onclick="departedEdit('${entity.id}',0);" name="button" type="button" class="button-z2" value="增加" /></td>
		      </tr>
		    </table>
		    <table width="98%" border="0" align="center" cellpadding="3" cellspacing="0">
		      <tr>
		        <td bgcolor="#C4DEEE"><table width="100%" cellpadding="0" cellspacing="1"  bgcolor="#a6c6da">
		            <tr>
		              <td height="30" align="center" bgcolor="#D4E5F4">逝者姓名</td>
		              <td align="center" bgcolor="#D4E5F4">性别</td>
		              <td align="center" bgcolor="#D4E5F4">年龄</td>
		              <td align="center" bgcolor="#D4E5F4">民族</td>
		              <td align="center" bgcolor="#D4E5F4">籍贯</td>
		              <td align="center" bgcolor="#D4E5F4">与承租人关系</td>
		              <td align="center" bgcolor="#D4E5F4">出生日期</td>
		              <td align="center" bgcolor="#D4E5F4">辞世日期</td>
		              <td align="center" bgcolor="#D4E5F4">安葬日期</td>
		              <td align="center" bgcolor="#D4E5F4">安放物</td>
		              <td align="center" bgcolor="#D4E5F4">操作</td>
		            </tr>
		            <c:forEach var="en" items="${entity.departeds}" varStatus="status">
		              <tr>
		                <td height="30" align="center" bgcolor="#FFFFFF"><c:out value='${en.name}' /></td>
		                <td align="center" bgcolor="#FFFFFF"><c:choose>
		                    <c:when test="${en.sex == '1'}">男 </c:when>
		                    <c:otherwise>女 </c:otherwise>
		                  </c:choose></td>
		                <td align="center" bgcolor="#FFFFFF"><c:out value='${en.age}' /></td>
		                <td align="center" bgcolor="#FFFFFF"><ft:dict value='${en.nation}'/></td>
		                <td align="center" bgcolor="#FFFFFF"><ft:dict value='${en.nationality}'/></td>
		                <td align="center" bgcolor="#FFFFFF"><ft:dict value='${en.rentrelation}'/></td>
		                <td align="center" bgcolor="#FFFFFF"><fmt:formatDate value='${en.birthDate}' pattern="yyyy-MM-dd" /></td>
		                <td align="center" bgcolor="#FFFFFF"><fmt:formatDate value='${en.deadDate}' pattern="yyyy-MM-dd" /></td>
		                <td align="center" bgcolor="#FFFFFF"><fmt:formatDate value='${en.factBuryDate}' pattern="yyyy-MM-dd" /></td>
		                <td align="center" bgcolor="#FFFFFF"><ft:dict value='${en.putGoods}'/></td>
		                <td align="center" bgcolor="#FFFFFF" class="word-7"	width="20%">
		          			<a	href="javascript:departedView('${entity.id}','${en.id}');">查看</a>&nbsp;&nbsp;
		          			<a	href="javascript:departedEdit('${entity.id}','${en.id}');">编辑</a>&nbsp;&nbsp;
		          			<a	href="javascript:departedDel('${entity.id}','${en.id}');">删除</a></td>
		              </tr>
		            </c:forEach>
		          </table></td>
		      </tr>
		    </table>
		    <table width="100%" border="0" cellspacing="0" cellpadding="0">
		      <tr>
		        <td>&nbsp;</td>
		      </tr>
		    </table>
		    <table width="98%" border="0" align="center" cellpadding="0" 	cellspacing="0">
		      <tr>
		        <td width="92%" bgcolor="#EBF4FA"><table width="200" border="0" cellspacing="0" cellpadding="0">
		            <tr>
		              <td width="20" align="right"><img src="../images/tab-01.jpg" width="8" height="27" /></td>
		              <td width="99" align="center" class="tab-img-01">碑文信息</td>
		              <td width="81" align="left" valign="bottom"><img src="../images/tab-03.jpg" /></td>
		            </tr>
		          </table></td>
		      </tr>
		    </table>
		    <table width="98%" border="0" cellspacing="0" cellpadding="3">
		      <tr>
		        <td bgcolor="#C4DEEE"><table id="baseInfo" width="100%" cellpadding="0" cellspacing="1" bgcolor="#a6c6da">
		            <tr>
		              <td height="35" align="right" bgcolor="#D4E5F4">碑前内容：</td>
		              <td colspan='3' align="left" bgcolor="#FFFFFF"><textarea	name="tombFront" id="tombFront"	style="width: 800px; height: 40px"><c:out value='${entity.tombFront}' /></textarea></td>
		            </tr>
		            <tr>
		              <td width="15%" height="35" align="right" bgcolor="#D4E5F4">碑后内容：</td>
		              <td colspan='3' align="left" bgcolor="#FFFFFF"><textarea	name="tombBack" id="tombBack"	style="width: 800px; height: 40px"><c:out value='${entity.tombBack}' /></textarea></td>
		            </tr>
		            <tr>
		              <td height="35" align="right" bgcolor="#D4E5F4">碑文说明：</td>
		              <td colspan='3' align="left" bgcolor="#FFFFFF"><textarea	name="tombRemark" id="tombRemark"	style="width: 800px; height: 40px"><c:out value='${entity.tombRemark}' /></textarea></td>
		            </tr>
		          </table></td>
		      </tr>
		    </table>
		    <table width="100%" border="0" cellspacing="0" cellpadding="0">
		      <tr>
		        <td>&nbsp;</td>
		      </tr>
		    </table>
		    <table width="98%" border="0" align="center" cellpadding="0" 	cellspacing="0">
		      <tr>
		        <td width="91%" bgcolor="#EBF4FA"><table width="811" border="0" align="left" cellpadding="0" cellspacing="0">
		            <tr>
		              <td width="20" align="right"><img src="../images/tab-01.jpg" width="8" height="27" /></td>
		              <td width="99" align="center" class="tab-img-01">收费信息</td>
		              <td width="148" align="left" valign="bottom"><img src="../images/tab-03.jpg" /></td>
		              <td width="433" align="left" valign="bottom">&nbsp;</td>
		            </tr>
		          </table></td>
		        <td width="9%" align="center" bgcolor="#EBF4FA">
		        	<input id="addCharge" name="button" onclick="addCemeteryCharge('<c:out value="${entity.id}"/>');" type="button" class="button-z2" value="增加" /></td>
		      </tr>
		    </table>
		    <table width="98%" border="0" cellspacing="0" cellpadding="3">
		      <tr>
		        <td height="102" bgcolor="#C4DEEE"><table width="100%" cellpadding="0" cellspacing="1" bgcolor="#a6c6da">
		            <tr>
		              <td width="13%" height="30" align="center" bgcolor="#D4E5F4">收费项目</td>
		              <td width="13%" align="center" bgcolor="#D4E5F4">单价</td>
		              <td width="13%" align="center" bgcolor="#D4E5F4">数量</td>
		              <td width="13%" align="center" bgcolor="#D4E5F4">费用</td>
		              <td width="20%" align="center" bgcolor="#D4E5F4">操作</td>
		            </tr>
		            <tr>
		              <td width="13%" height="30" align="center" bgcolor="#FFFFFF">土地租赁费</td>
		              <td width="13%" align="center" bgcolor="#FFFFFF" ><span id="groundPrice"><c:out value='${entity.cemeteryLocation.cemeteryType.groundPrice}'/></span></td>
		              <td width="13%" align="center" bgcolor="#FFFFFF">--</td>
		              <td width="13%" align="center" bgcolor="#FFFFFF">--</td>
		              <td align="center" bgcolor="#FFFFFF" width="20%">--</td>
		            </tr>
		            <tr>
		              <td width="13%" height="30" align="center" bgcolor="#FFFFFF">工程费</td>
		              <td width="13%" align="center" bgcolor="#FFFFFF" ><span id="constructionPrice"><c:out value='${entity.cemeteryLocation.cemeteryType.constructionPrice}'/></span></td>
		              <td width="13%" align="center" bgcolor="#FFFFFF" >--</td>
		              <td width="13%" align="center" bgcolor="#FFFFFF">--</td>
		              <td align="center" bgcolor="#FFFFFF" width="20%">--</td>
		            </tr>
		            <tr>
		              <td height="30" align="center" bgcolor="#FFFFFF">管理费</td>
		              <td align="center" bgcolor="#FFFFFF" ><span id="managePrice"><c:out value='${entity.cemeteryLocation.cemeteryType.managePrice}'/></span></td>
		              <td align="center" bgcolor="#FFFFFF">--</td>
		              <td align="center" bgcolor="#FFFFFF">--</td>
		              <td align="center" bgcolor="#FFFFFF" >--</td>
		            </tr>
		            <c:forEach var="cemeteryCharge" items="${entity.cemeteryCharges}" varStatus="status">
		              <tr>
		                <td width="13%" height="30" align="center" bgcolor="#FFFFFF"><c:out value="${cemeteryCharge.productName}" /></td>
		                <td width="13%" align="center" bgcolor="#FFFFFF" ><c:out value="${cemeteryCharge.price}" /></td>
		                <td width="13%" align="center" bgcolor="#FFFFFF"><c:out value="${cemeteryCharge.count}" /></td>
		                <td width="13%" align="center" bgcolor="#FFFFFF" id="charges" name="charges"><c:out value="${cemeteryCharge.receive}" /></td>
		                <td align="center" bgcolor="#FFFFFF" class="word-7"	width="20%"><a href="cemeteryRegistryController.fj?method=deleteCemeteryCharge&cemeteryRegistryType=${entity.cemeteryRegistryType}&id=${cemeteryCharge.id}&cemeteryRegistryId=${entity.id}">删除</a></td>
		              </tr>
		            </c:forEach>
		          </table></td>
		      </tr>
		    </table>
		    <table width="100%" border="0" cellspacing="0" cellpadding="0">
		      <tr>
		        <td>&nbsp;</td>
		      </tr>
		    </table>
		    <table width="98%" border="0" align="center" cellpadding="0" 	cellspacing="0">
		      <tr>
		        <td width="91%" bgcolor="#EBF4FA"><table width="200" border="0" align="left" cellpadding="0" cellspacing="0">
		            <tr>
		              <td width="20" align="right"><img src="../images/tab-01.jpg" width="8" height="27" /></td>
		              <td width="99" align="center" class="tab-img-01">附件信息</td>
		              <td width="81" align="left" valign="bottom"><img src="../images/tab-03.jpg" /></td>
		            </tr>
		          </table></td>
		        <td width="9%" align="center" bgcolor="#EBF4FA"><input id="save_chargeInfo_btn" name="button" type="button" 
		        			onclick="getCemeteryFileEdit('<c:out value='${entity.id}'/>')" class="button-z2" value="上传" /></td>
		      </tr>
		    </table>
		    <table width="98%" border="0" cellspacing="0" cellpadding="3">
		      <tr>
		        <td bgcolor="#C4DEEE"><table width="100%" cellpadding="0" cellspacing="1" bgcolor="#a6c6da">
		            <tr>
		              <td width="13%" height="30" align="center" bgcolor="#D4E5F4">附件名称</td>
		              <td width="13%" align="center" bgcolor="#D4E5F4">附件描述</td>
		              <td width="13%" align="center" bgcolor="#D4E5F4">上传人</td>
		              <td width="13%" align="center" bgcolor="#D4E5F4">上传时间</td>
		              <td width="20%" align="center" bgcolor="#D4E5F4">操作</td>
		            </tr>
		            <c:forEach var="cemeteryFile" items="${entity.cemeteryFiles}" varStatus="status">
		              <tr>
		                <td width="13%" height="30" align="center" bgcolor="#FFFFFF"><c:out value="${cemeteryFile.fileName}" /></td>
		                <td width="13%" align="center" bgcolor="#FFFFFF"><c:out value="${cemeteryFile.remark}" /></td>
		                <td width="13%" align="center" bgcolor="#FFFFFF"><c:out value="${cemeteryFile.createUserId}" /></td>
		                <td width="13%" align="center" bgcolor="#FFFFFF"><c:out value="${cemeteryFile.createDate}" /></td>
		                <td align="center" bgcolor="#FFFFFF" class="word-7"	width="20%"><a	href="cemeteryRegistryController.fj?method=deleteCemeteryFile&cemeteryRegistryType=<c:out value="${entity.cemeteryRegistryType}"/>&cemeteryRegistryId=<c:out value="${entity.id}"/>&id=<c:out value='${cemeteryFile.id}'/>">删除</a></td>
		              </tr>
		            </c:forEach>
		          </table></td>
		      </tr>
		      <tr>
		        <table>
		          <tr>
		            <td height="35">
			            <input name="button" type="button" class="button-z4" id="saveCemeteryRegistryBtn" value="保存" />&nbsp;
	            <input name="button" type="button" class="button-z4" value="打印业务单" onclick="javascript:location.href='../reprot/reprotController.fj?method=businessDetail&id=${entity.id}';" />&nbsp;
	            <input name="button" type="button" class="button-z4" value="打印安葬证" onclick="javascript:location.href='../reprot/reprotController.fj?method=burialDetail&id=${entity.id}';" />&nbsp;
			            <input name="button" type="button" onclick="endCemeteryRegistry('${entity.id}','${entity.cemeteryLocation.id}');" class="button-z4" value="完成" />&nbsp;
			            <input name="button" type="button" onclick="javascript:location.href='cemeteryRegistryController.fj?method=getCemeteryRegistryPageList&cemeteryRegistryType=3';" class="button-z4" value="返回" />
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
