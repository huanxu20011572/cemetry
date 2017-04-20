<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ include file="../common/head.jsp"%>
<head>
<script type="text/javascript">
	//进入墓位选择
	function gotoCemeteryLocation(){
		window.open("../cemetery/cemetery_location_fast_tree.jsp?select=select","openlocation","width=900px,height=500px,alwaysRaised=no,z-look=yes,resizable=no,location=no,status=no");
	}
	//完成登记
	function endCemeteryRegistry(id,locationId,cemeteryRegistryType){
		if(id == ''){
			alert("请先保存信息");
			return false;
		}
		 
		var departedTableLen=$("#departedTable tr").length;
		if(departedTableLen<=1){
		  alert("请录入逝者信息");
		  return false;
		}
	   	location.href="cemeteryRegistryController.fj?method=endCemeteryRegistry&cemeteryRegistryType="+cemeteryRegistryType+"&id=" + locationId;
	}
	//逝者信息增加 regeditId:业务id,id:逝者id
   function departedView(regeditId,id){
		var redirect_url =$.base64.encode('cemeteryRegistryController.fj?method=editCemeteryRegistry&cemeteryRegistryType=1&id='+regeditId);
	   	location.href="departedController.fj?method=getDepartedViewById&id=" + id + "&regeditId=" + regeditId + "&redirect_url="+redirect_url;
   }
	//逝者信息增加 regeditId:业务id,id:逝者id
   function departedEdit(regeditId,id){
		if(regeditId == ""){
			alert("请先保存信息");
			return false;
		}
		var redirect_url =$.base64.encode('cemeteryRegistryController.fj?method=editCemeteryRegistry&cemeteryRegistryType=1&id='+regeditId);
	   	location.href="departedController.fj?method=editDeparted&id=" + id + "&regeditId=" + regeditId + "&redirect_url="+redirect_url;
   }
	//逝者信息增加 regeditId:业务id,id:逝者id
   function departedDel(regeditId,id){
		var redirect_url =$.base64.encode('cemeteryRegistryController.fj?method=editCemeteryRegistry&cemeteryRegistryType=1&id='+regeditId);
	   	location.href="departedController.fj?method=deleteDepartedById&id=" + id + "&regeditId=" + regeditId + "&redirect_url="+redirect_url;
   }
	
	//费用增加
   function addCemeteryCharge(regeditId){
		if(regeditId == ""){
			alert("请先保存信息");
			return false;
		}
		var redirect_url =$.base64.encode('cemeteryRegistryController.fj?method=editCemeteryRegistry&cemeteryRegistryType=1&id='+regeditId);
		location.href = "cemeteryRegistryController.fj?method=getCemeteryChargeframe&cemeteryRegistryType=1&id="+regeditId +"&redirect_url="+redirect_url;
   }
   //上传文件
   function getCemeteryFileEdit(regeditId){
		if(regeditId == ""){
			alert("请先保存信息");
			return false;
		}
		var redirect_url =$.base64.encode('cemeteryRegistryController.fj?method=editCemeteryRegistry&cemeteryRegistryType=1&id='+regeditId);
		location.href = "cemeteryRegistryController.fj?method=getCemeteryFileEdit&cemeteryRegistryType=1&id="+regeditId +"&redirect_url="+redirect_url;
   }
   //选择墓位后回调使用获取墓型信息
   function getCemeteryType(id,locat_id,locat){
		$.getJSON("cemeteryRegistryController.fj?method=getCemeteryTypeById&cemeteryTypeId=" + id , function(data) {
			
			$("#businessName").val(data.businessData.businessName);
			$("#cemeteryLocationAddress").val(locat);
			$("#cemeteryLocationId").val(locat_id);
			$("#cemeteryTypeName").val(data.cemeteryTypeName);
			if(data.cave == 1){
				$("#cave").val("单穴");
			}
			if(data.cave == 2){
				$("#cave").val("双穴");
			}
			if(data.cave == 3){
				$("#cave").val("多穴");
			}
			$("#area").val(data.area);
			$("#boxsize").val(data.boxsize);
			$("#groundPrice").text(data.groundPrice);
			$("#constructionPrice").text(data.constructionPrice);
			$("#managePrice").text(data.managePrice);
			bulidPrice();
		});
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
	    if($("#cemeteryLocationId").val() == ""){
	    	alert("请先选择墓位");
	    	return false;
	    }
	    var discountPrice=parseFloat($("#discountPrice").val());
	    if (isNaN(discountPrice)) {
	        alert("优惠费用需要输入数字");
	        return false;
	    }
	    //租赁起止日期、租用年限、民族、国籍、性别、
	    var buydate=$.trim($("#buydate").val());
	    var enddate=$.trim($("#enddate").val());
	    if(buydate==""||enddate==""){
	    	alert("请输入租赁起止日期");
	    	return;
	    }
	    var periods=$.trim($("#periods").val());
	    if(periods=="-1"){
	    	alert("请选择租用年限");
	    	return;
	    }
	    
	    //备注
	    var remark=$.trim($("#remark").val());
	     if(remark.length>200){
	    	alert("备注的长度最大为200个字符");
	    	return false;
	    }
        //姓名	    
	    var name=$.trim($("#name").val());
	    if(name==""){
	    	alert("请录入承租人姓名");
	    	return false;
	    }
		if(name.length>20){
	    	alert("承租人姓名的长度最大为20个字符");
	    	return false;
	    }
		//民族、国籍、性别
		var nation=$.trim($("#nation").val());
	    if(nation=="-1"){
		   alert("请录入民族信息");
	    	return false;
		 }
		var nationality=$.trim($("#nationality").val());
	    if(nationality=="-1"){
		   alert("请录入国籍信息");
	    	return false;
		 }
		var sex=$("input[name='sex']:checked").val();
		if(sex==undefined){
			alert("请选择性别");
	    	return false;
		 }
	     
	    var patrn= /^(((13[0-9]{1})|(14[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
	    var patrn_num=/^[0-9]+$/;
	    
	    ///证件类型
		var cardType=$.trim($("#cardType").val());
	    if(cardType=="-1"){
		   alert("请录入证件类型");
	    	return false;
		 }
	    //  证件证号
	    var cardNum=$.trim($("#cardNum").val());
	    if(cardNum==""){
	    	alert("请录入证件证号");
	    	return false;
	    }
	    if(cardNum!=""&&!patrn_num.exec(cardNum)){
	    	alert("证件证号为数字,请重新输入");
	    	return false;
	    } 
	    //家庭地址
	    var famliyAddress=$.trim($("#famliyAddress").val());
	    if(famliyAddress==""){
	    	alert("请录入家庭地址");
	    	return false;
	    }
	    if(famliyAddress.length>200){
	    	alert("家庭地址的长度最大为200个字符");
	    	return false;
	    } 
	  //家庭邮编
	    var famliyZip=$.trim($("#famliyZip").val());
	    if(famliyZip!=""&&!patrn_num.exec(famliyZip)){
	    	alert("家庭邮编为数字,请重新输入");
	    	return false;
	    } 
	    //单位地址
	    var companyAddress=$.trim($("#companyAddress").val());
	    if(companyAddress.length>200){
	    	alert("单位地址的长度最大为200个字符");
	    	return false;
	    } 
	    
	    //单位邮编
        var companyZip=$.trim($("#companyZip").val());
	    if(companyZip!=""&&!patrn_num.exec(companyZip)){
	    	alert("单位邮编为数字,请重新输入");
	    	return false;
	    } 
	    //固定电话
	    var famliyTel=$.trim($("#famliyTel").val());
	    if(famliyTel!=""&&!patrn_num.exec(famliyTel)){
	    	alert("固定电话为数字,请重新输入");
	    	return false;
	    } 
	    //单位电话
	    var companyTel=$.trim($("#companyTel").val());
	    if(companyTel!=""&&!patrn_num.exec(companyTel)){
	    	alert("单位电话为数字,请重新输入");
	    	return false;
	    } 
	    //电子邮件
		var partn_email=/^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})$/;
	    var email=$.trim($("#email").val());
	    if(email!=""&&!partn_email.exec(email)){
	    	alert("电子邮件格式有误,请重新输入");
	    	return false;
	    } 
	    
	    //移动电话
	    var mobilePhone=$.trim($("#mobilePhone").val());
	    if(mobilePhone==""){
	    	alert("请录入移动电话");
	    	return false;
	    }
	    if(mobilePhone!=""&&!patrn.exec(mobilePhone)){
	    	alert("移动电话格式不正确,请重新输入");
	    	return false;
	    } 
	    //碑前内容
	    var tombFront=$.trim($("#tombFront").val());
	     
	    if(tombFront.length>200){
	    	alert("碑前内容的长度最大为200个字符");
	    	return false;
	    }
	    //碑后内容
	    var tombBack=$.trim($("#tombBack").val());
	   
	    if(tombBack.length>200){
	    	alert("碑后内容的长度最大为200个字符");
	    	return false;
	    }
	    //碑文说明
	    var tombRemark=$.trim($("#tombRemark").val());
	    if(tombRemark.length>200){
	    	alert("碑文说明的长度最大为200个字符");
	    	return false;
	    }
	   
	    $("#saveCemeteryRegistyForm").submit();
	 });
		 
	    
 });
</script>
</head>
<body style="background-color: transparent">
<table width="100%" border="0" cellspacing="0" cellpadding="0" height="100%">
    <tr>
  
  <td width="11" valign="top" class="td-bg"><img src="../images/right-1.jpg" /></td>
    <td align="center" valign="top">
  
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td height="31" align="left" valign="middle" 	style="background: url(../images/right-3.jpg)"><img src="../images/right-4.jpg" width="9" height="8" align="absmiddle" /> 当前位置 &gt; 业务办理 &gt; 租用登记 &gt; 登记</td>
    </tr>
    <tr>
      <td bgcolor="#FFFFFF" style="font-size: 12px;">&nbsp;</td>
    </tr>
  </table>
  <!-- 输入域 --> <!-- 隐藏域 -->
  <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td width="92%" bgcolor="#EBF4FA"><table width="200" 			border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="20" align="right"><img src="../images/tab-01.jpg" width="8" height="27" /></td>
            <td width="99" align="center" class="tab-img-01">业务登记</td>
            <td width="81" align="left" valign="bottom"><img src="../images/tab-03.jpg" /></td>
          </tr>
        </table></td>
    </tr>
  </table>
  <form id="saveCemeteryRegistyForm" action="cemeteryRegistryController.fj?method=saveCemeteryRegistry" method="post">
	<input name="isSupply" type="hidden" id="isSupply" value="0" />
	<input name="cemeteryRegistryType" type="hidden" id="cemeteryRegistryType" value="<c:out value='${entity.cemeteryRegistryType}'/>" />
	<input type="hidden" name="id" id="id" value="<c:out value='${entity.id}'/>" />
    <table width="98%" border="0" cellspacing="0" cellpadding="3">
        <tr>
	        <td bgcolor="#C4DEEE">
			      <table id="baseInfo" width="100%" cellpadding="0" cellspacing="1" bgcolor="#a6c6da">
			        <tr>
			          <td width="15%" height="35" align="right" bgcolor="#D4E5F4">业务分类：</td>
			          <td width="35%" align="left" bgcolor="#FFFFFF">
			          <input name="businessName"  type="text" id="businessName" readonly="readonly" class="input-1" 
			          value="<c:out value='${entity.cemeteryLocation.cemeteryType.businessData.businessName}'/>" /></td>
			          <td width="15%" align="right" bgcolor="#D4E5F4">业务编号：</td>
			          <td width="35%" align="left" bgcolor="#FFFFFF">
			          <input name="cemeteryRegistryCode" type="text" id="cemeteryRegistryCode" readonly="readonly" class="input-1" 
			          value="<c:out value='${entity.cemeteryRegistryCode}'/>" /></td>
			        </tr>
			        <tr>
			          <td height="35" align="right" bgcolor="#D4E5F4">选择墓位：</td>
			          <td align="left" bgcolor="#FFFFFF">
			          	<input name="cemeteryLocationAddress" id="cemeteryLocationAddress" type="text" readonly="readonly" class="input-1" 
			          		value="<c:out value='${entity.cemeteryLocation.cemeteryZone.parent.cemeteryZoneName}'/><c:out value='${entity.cemeteryLocation.cemeteryZone.cemeteryZoneName}'/><c:out value='${entity.cemeteryLocation.cemeteryLocationCode}'/>" />
			            <input name="cemeteryLocationId" id="cemeteryLocationId" type="hidden" 
			            	value="<c:out value='${entity.cemeteryLocation.id}'/>" />
				        <input name="button" type="button" class="button-z" value="选择" onclick="gotoCemeteryLocation();"/>
				        <span class="word-7">*</span> 
			          </td>
			          <td align="left" bgcolor="#FFFFFF">&nbsp;</td>
			          <td align="left" bgcolor="#FFFFFF"></td>
			        </tr>
			        <!--  </form> -->
			        <tr>
			          <td height="35" align="right" bgcolor="#D4E5F4">墓型名称：</td>
			          <td align="left" bgcolor="#FFFFFF">
			          <input name="cemeteryTypeName" type="text" readonly="readonly" class="input-1" id="cemeteryTypeName" 
			          		value="<c:out value='${entity.cemeteryLocation.cemeteryType.cemeteryTypeName}'/>" /></td>
			          <td height="35" align="right" bgcolor="#D4E5F4">穴别：</td>
			          <td align="left" bgcolor="#FFFFFF"><input name="cave" id="cave" class="input-1" readonly="readonly" 
			          		value="<c:if test="${entity.cemeteryLocation.cemeteryType.cave=='1'}">单穴</c:if><c:if test="${entity.cemeteryLocation.cemeteryType.cave=='2'}">双穴</c:if><c:if test="${entity.cemeteryLocation.cemeteryType.cave=='3'}">其它</c:if>" />
			          </td>
			        </tr>
			        <tr>
			          <td height="35" align="right" bgcolor="#D4E5F4">占地面积：</td>
			          <td align="left" bgcolor="#FFFFFF">
			            <input name="area" type="text" readonly="readonly" class="input-1" id="area" 
			            		value="<c:out value='${entity.cemeteryLocation.cemeteryType.area}'/>" /></td>
			          <td align="right" bgcolor="#D4E5F4">护盒尺寸：</td>
			          <td align="left" bgcolor="#FFFFFF"> 
			            <input name="boxsize" type="text" readonly="readonly" class="input-1" id="boxsize" 
			            		value="<c:out value='${entity.cemeteryLocation.cemeteryType.boxsize}'/>" /></td>
			        </tr>
			        <tr>
			          <td height="35" align="right" bgcolor="#D4E5F4">租赁起止日期：</td>
			          <td align="left" bgcolor="#FFFFFF">
			            <input name="buydate" type="text" class="Wdate" id="buydate" onfocus="WdatePicker()" 
			            		value="<fmt:formatDate value='${entity.buydate}' pattern="yyyy-MM-dd" />" />
			            -
			            <input name="enddate" type="text" class="Wdate" id="enddate" onfocus="WdatePicker()" 
			            		value="<fmt:formatDate value='${entity.enddate}' pattern="yyyy-MM-dd" />" />
			            <span class="word-7">*</span>
			           </td>
			          <td align="right" bgcolor="#D4E5F4">租用年限：</td>
			          <td align="left" bgcolor="#FFFFFF">
			          	<select  name="periods"  id="periods" style="width:190px">
				          	<option value="-1">---请选择---</option>
							<c:forEach var="v_periods"  begin="10" end="100" step="10" varStatus="status">
				          		<option value="${v_periods}" <c:if test="${entity.periods==v_periods}">selected</c:if> >${v_periods}</option>
				          	</c:forEach>
			          	</select>
			          	<span class="word-7">*</span>
					  </td>
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
        <td width="92%" bgcolor="#EBF4FA"><table width="200" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td width="20" align="right"><img src="../images/tab-01.jpg" width="8" height="27" /></td>
              <td width="99" align="center" class="tab-img-01">承租人信息</td>
              <td width="81" align="left" valign="bottom"><img src="../images/tab-03.jpg" /></td>
            </tr>
          </table></td>
      </tr>
    </table>
    <table width="98%" border="0" cellspacing="0" cellpadding="3">
      <tr>
        <td bgcolor="#C4DEEE"><table id="baseInfo" width="100%" cellpadding="0" cellspacing="1" bgcolor="#a6c6da">
            <tr>
              <td width="15%" height="35" align="right" bgcolor="#D4E5F4">姓名：</td>
              <td width="35%" align="left" bgcolor="#FFFFFF"><input name="name" type="text" id="name" class="input-1" value="<c:out value='${entity.name}'/>" />
                <span class="word-7">*</span></td>
              <td width="15%" align="right" bgcolor="#D4E5F4">性别：</td>
              <td width="35%" align="left" bgcolor="#FFFFFF">
                 <ft:radiosex name="sex" checked="${entity.sex}" />
                 <span class="word-7">*</span>
              </td>
            </tr>
            <tr>
              <td height="35" align="right" bgcolor="#D4E5F4">民族：</td>
              <td align="left" bgcolor="#FFFFFF">
                <ft:select	name="nation" type="mz" selected="${entity.nation}"	style="width:190px"></ft:select>
                 <span class="word-7">*</span>
              </td>
              <td height="35" align="right" bgcolor="#D4E5F4">国籍：</td>
              <td align="left" bgcolor="#FFFFFF">
                <ft:select	name="nationality" type="gj"	selected="${entity.nationality}" style="width:190px"></ft:select>
                <span class="word-7">*</span>
                </td>
            </tr>
            <tr>
              <td height="35" align="right" bgcolor="#D4E5F4">证件类型：</td>
              <td align="left" bgcolor="#FFFFFF"><ft:select	name="cardType" type="zjlx" selected="${entity.cardType}"	style="width:190px"></ft:select>
                <span class="word-7">*</span></td>
              <td height="35" align="right" bgcolor="#D4E5F4">证件证号：</td>
              <td align="left" bgcolor="#FFFFFF"><input name="cardNum" type="text" id="cardNum" class="input-1"value="<c:out value='${entity.cardNum}'/>" />
                <span class="word-7">*</span></td>
            </tr>
            <tr>
              <td height="35" align="right" bgcolor="#D4E5F4">户口所在地：</td>
              <td align="left" bgcolor="#FFFFFF" colspan='3'>
	              <ft:select name="province" type="shengfen" selected="${entity.province}" style="width:190px"></ft:select>
	              <ft:select name="county" type="shengfen" selected="${entity.county}" style="width:190px"></ft:select>
				</td>
            </tr>
            <tr>
              <td height="35" align="right" bgcolor="#D4E5F4">家庭地址：</td>
              <td align="left" bgcolor="#FFFFFF"><input name="famliyAddress" type="text" id="famliyAddress"class="input-1"value="<c:out value='${entity.famliyAddress}'/>" />
                <span class="word-7">*</span></td>
              <td align="right" bgcolor="#D4E5F4">家庭邮编：</td>
              <td align="left" bgcolor="#FFFFFF"><input name="famliyZip" type="text" id="famliyZip" class="input-1"value="<c:out value='${entity.famliyZip}'/>" /></td>
            </tr>
            <tr>
              <td height="35" align="right" bgcolor="#D4E5F4">单位地址：</td>
              <td align="left" bgcolor="#FFFFFF"><input name="companyAddress" type="text" id="companyAddress"class="input-1"value="<c:out value='${entity.companyAddress}'/>" /></td>
              <td align="right" bgcolor="#D4E5F4">单位邮编：</td>
              <td align="left" bgcolor="#FFFFFF"><input name="companyZip" type="text" id="companyZip" class="input-1"value="<c:out value='${entity.companyZip}'/>" /></td>
            </tr>
            <tr>
              <td width="15%" height="35" align="right" bgcolor="#D4E5F4">固定电话：</td>
              <td width="35%" align="left" bgcolor="#FFFFFF"><input style="height: 17px" name="famliyTel" type="text"id="famliyTel" class="input-1"value="<c:out value='${entity.famliyTel}'/>" /></td>
              <td width="15%" height="35" align="right" bgcolor="#D4E5F4">移动电话：</td>
              <td width="35%" align="left" bgcolor="#FFFFFF"><input style="height: 17px" name="mobilePhone" type="text"id="mobilePhone" class="input-1"value="<c:out value='${entity.mobilePhone}'/>" />
                <span class="word-7">*</span></td>
            </tr>
            <tr>
              <td height="35" align="right" bgcolor="#D4E5F4">单位电话：</td>
              <td align="left" bgcolor="#FFFFFF"><input name="companyTel" type="text" id="companyTel" class="input-1"value="<c:out value='${entity.companyTel}'/>" /></td>
              <td align="right" bgcolor="#D4E5F4">电子邮件：</td>
              <td align="left" bgcolor="#FFFFFF"><input name="email" type="text" id="email" class="input-1"value="<c:out value='${entity.email}'/>" /></td>
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
    <table  width="98%" border="0" align="center" cellpadding="3" cellspacing="0">
      <tr>
        <td bgcolor="#C4DEEE">
		 <table id="departedTable" width="100%" cellpadding="0" cellspacing="1"  bgcolor="#a6c6da">
            <tr>
              <td height="30" align="center" bgcolor="#D4E5F4">逝者姓名</td>
              <td align="center" bgcolor="#D4E5F4">性别</td>
              <td align="center" bgcolor="#D4E5F4">年龄</td>
              <td align="center" bgcolor="#D4E5F4">民族</td>
              <td align="center" bgcolor="#D4E5F4">国籍</td>
              <td align="center" bgcolor="#D4E5F4">与承租人关系</td>
              <td align="center" bgcolor="#D4E5F4">出生日期</td>
              <td align="center" bgcolor="#D4E5F4">辞世日期</td>
              <td align="center" bgcolor="#D4E5F4">实际安放日期</td>
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
                <td align="center" bgcolor="#FFFFFF">
                  <c:choose>
                    <c:when test="${en.nation == '-1'}"></c:when>
                    <c:otherwise><ft:dict value='${en.nation}'/> </c:otherwise>
                  </c:choose>
                </td>
                <td align="center" bgcolor="#FFFFFF">
                <c:choose>
                    <c:when test="${en.nationality == '-1'}"></c:when>
                    <c:otherwise><ft:dict value='${en.nationality}'/></c:otherwise>
                  </c:choose>
                </td>
                <td align="center" bgcolor="#FFFFFF">
                    <c:choose>
                    <c:when test="${en.rentrelation == '-1'}"></c:when>
                    <c:otherwise><ft:dict value='${en.rentrelation}'/></c:otherwise>
                  </c:choose>
                 </td>
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
	            <input name="button" type="button" onclick="endCemeteryRegistry('${entity.id}','${entity.cemeteryLocation.id}','${entity.cemeteryRegistryType}');" class="button-z4" value="完成" />&nbsp;
	            <input name="button" type="button" onclick="javascript:location.href='cemeteryRegistryController.fj?method=getCemeteryRegistryPageList&cemeteryRegistryType=1';" class="button-z4" value="返回" />
            </td>
          </tr>
        </table>
      </tr>
    </table>
  </form>
  <!--弹出域安葬位置bai 2014-07-24 end -->
  
    </td>
  
    </tr>
  
</table>
</body>
</html>
