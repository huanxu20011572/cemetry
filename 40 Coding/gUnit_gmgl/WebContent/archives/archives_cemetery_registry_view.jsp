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
	   	location.href="cemeteryRegistryController.fj?method=endCemeteryRegistry&cemeteryRegistryType="+cemeteryRegistryType+"&id=" + locationId;
	}
	//逝者信息增加 regeditId:业务id,id:逝者id
   function departedView(regeditId,id){
		var redirect_url =$.base64.encode('cemeteryRegistryController.fj?method=editCemeteryRegistry&cemeteryRegistryType=1&id='+regeditId);
	   	location.href="departedController.fj?method=getDepartedViewById&id=" + id + "&regeditId=" + regeditId + "&redirect_url="+redirect_url;
   }
	//逝者信息增加 regeditId:业务id,id:逝者id
   function departedEdit(regeditId,id){
		alert(1232);
		if(regeditId == ""){
			alert("请先保存信息");
			return false;
		}
		/* var redirect_url =$.base64.encode('archivesCemeteryRegistryController.fj?method=editCemeteryRegistry&cemeteryRegistryType=1&id='+regeditId);
	   	location.href="archivesDepartedController.fj?method=editDeparted&id=" + id + "&regeditId=" + regeditId + "&redirect_url="+redirect_url; */
		var redirect_url =$.base64.encode('archivesCemeteryRegistryController.fj?method=editArchivesCemeteryRegistry&cemeteryRegistryType=1&id='+regeditId);
	   	location.href="archivesDepartedController.fj?method=editDeparted&id=" + id + "&regeditId=" + regeditId + "&redirect_url="+redirect_url;
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
		var redirect_url =$.base64.encode('archivesCemeteryRegistryController.fj?method=editArchivesCemeteryRegistry&cemeteryRegistryType=1&id='+regeditId);
		location.href = "archivesCemeteryRegistryController.fj?method=getCemeteryChargeframe&cemeteryRegistryType=1&id="+regeditId +"&redirect_url="+redirect_url;
   }
   //上传文件
   function getCemeteryFileEdit(regeditId){
		if(regeditId == ""){
			alert("请先保存信息");
			return false;
		}
		var redirect_url =$.base64.encode('cemeteryRegistryController.fj?method=editCemeteryRegistry&cemeteryRegistryType=1&id='+regeditId);
		location.href = "archivesCemeteryRegistryController.fj?method=getCemeteryFileEdit&cemeteryRegistryType=1&id="+regeditId +"&redirect_url="+redirect_url;
   }
   //选择墓位后回调使用获取墓型信息
   function getCemeteryType(id,locat_id,locat){
		$.getJSON("../business/cemeteryRegistryController.fj?method=getCemeteryTypeById&cemeteryTypeId=" + id , function(data) {
			
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
		alert(123456);
	    if($("#cemeteryLocationId").val() == ""){
	    	alert("请先选择墓位");
	    	return false;
	    }
	    var discountPrice=parseFloat($("#discountPrice").val());
	    if (isNaN(discountPrice)) {
	        alert("优惠费用需要输入数字");
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
      <td height="31" align="left" valign="middle" 	style="background: url(../images/right-3.jpg)"><img src="../images/right-4.jpg" width="9" height="8" align="absmiddle" /> 当前位置 &gt; 档案管理 &gt; 档案编辑</td>
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
  <form id="saveCemeteryRegistyForm" action="archivesCemeteryRegistryController.fj?method=saveArchivesCemeteryRegistryEditInfo" method="post">
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
			          <c:out value='${entity.cemeteryLocation.cemeteryType.businessData.businessName}'/></td>
			          <td width="15%" align="right" bgcolor="#D4E5F4">业务编号：</td>
			          <td width="35%" align="left" bgcolor="#FFFFFF">
			          <c:out value='${entity.cemeteryRegistryCode}'/></td>
			        </tr>
			        <tr>
			          <td height="35" align="right" bgcolor="#D4E5F4">选择墓位：</td>
			          <td align="left" bgcolor="#FFFFFF">
			          	<c:out value='${entity.cemeteryLocation.cemeteryZone.parent.cemeteryZoneName}'/><c:out value='${entity.cemeteryLocation.cemeteryZone.cemeteryZoneName}'/><c:out value='${entity.cemeteryLocation.cemeteryLocationCode}'/>
			          </td>
			          <td align="left" bgcolor="#FFFFFF">&nbsp;</td>
			          <td align="left" bgcolor="#FFFFFF"></td>
			        </tr>
			        <!--  </form> -->
			        <tr>
			          <td height="35" align="right" bgcolor="#D4E5F4">墓型名称：</td>
			          <td align="left" bgcolor="#FFFFFF">
			          <c:out value='${entity.cemeteryLocation.cemeteryType.cemeteryTypeName}'/></td>
			          <td height="35" align="right" bgcolor="#D4E5F4">穴别：</td>
			          <td align="left" bgcolor="#FFFFFF"><c:if test="${entity.cemeteryLocation.cemeteryType.cave=='1'}">单穴</c:if><c:if test="${entity.cemeteryLocation.cemeteryType.cave=='2'}">双穴</c:if><c:if test="${entity.cemeteryLocation.cemeteryType.cave=='3'}">其它</c:if>
			          </td>
			        </tr>
			        <tr>
			          <td height="35" align="right" bgcolor="#D4E5F4">占地面积：</td>
			          <td align="left" bgcolor="#FFFFFF">
			            <c:out value='${entity.cemeteryLocation.cemeteryType.area}'/></td>
			          <td align="right" bgcolor="#D4E5F4">护盒尺寸：</td>
			          <td align="left" bgcolor="#FFFFFF"> 
			            <c:out value='${entity.cemeteryLocation.cemeteryType.boxsize}'/></td>
			        </tr>
			        <tr>
			          <td height="35" align="right" bgcolor="#D4E5F4">租赁起止日期：</td>
			          <td align="left" bgcolor="#FFFFFF">
			            <fmt:formatDate value='${entity.buydate}' pattern="yyyy-MM-dd" />
			            -
			            <fmt:formatDate value='${entity.enddate}' pattern="yyyy-MM-dd" /></td>
			          <td align="right" bgcolor="#D4E5F4">租用年限：</td>
			          <td align="left" bgcolor="#FFFFFF">
							<c:forEach var="v_periods"  begin="10" end="100" step="10" varStatus="status">
				          		<c:if test="${entity.periods==v_periods}">${v_periods}</c:if>
				          	</c:forEach>
					  </td>
			        </tr>
			        <tr>
			          <td height="35" align="right" bgcolor="#D4E5F4">墓穴价格：</td>
			          <td align="left" bgcolor="#FFFFFF"><c:out value='${entity.cemeteryLocation.cemeteryType.managePrice+entity.cemeteryLocation.cemeteryType.constructionPrice+ntity.cemeteryLocation.cemeteryType.groundPrice}'/>
			            （元） </td>
			          <td align="right" bgcolor="#D4E5F4">其他费用：</td>
			          <td align="left" bgcolor="#FFFFFF"><c:out value='${entity.otherPrice}'/>
			            （元）</td>
			        </tr>
			        <tr>
			          <td width="15%" height="35" align="right" bgcolor="#D4E5F4">应收费用：</td>
			          <td width="35%" align="left" bgcolor="#FFFFFF"><c:out value='${entity.totalPrice}'/>
			            （元） </td>
			          <td width="15%" height="35" align="right" bgcolor="#D4E5F4">优惠费用：</td>
			          <td width="35%" align="left" bgcolor="#FFFFFF"><c:out value='${entity.discountPrice}'/>
			            （元） </td>
			        </tr>
			        <tr>
			          <td align="right" height="35" bgcolor="#D4E5F4">实收费用：</td>
			          <td colspan='3' align="left" bgcolor="#FFFFFF"><c:out value='${entity.factPrice}'/>
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
			          <td colspan='3' align="left" bgcolor="#FFFFFF"><c:out value='${entity.remark}' /></td>
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
              <td width="35%" align="left" bgcolor="#FFFFFF"><c:out value='${entity.name}'/></td>
              <td width="15%" align="right" bgcolor="#D4E5F4">性别：</td>
              <td width="35%" align="left" bgcolor="#FFFFFF">
              <c:if test="${entity.sex=='1'}">男</c:if><c:if test="${entity.sex=='0'}">女</c:if>
			 </td>
            </tr>
            <tr>
              <td height="35" align="right" bgcolor="#D4E5F4">民族：</td>
              <td align="left" bgcolor="#FFFFFF"><ft:dict value="${entity.nation}" /></td>
              <td height="35" align="right" bgcolor="#D4E5F4">国籍：</td>
              <td align="left" bgcolor="#FFFFFF"><ft:dict value="${entity.nationality}" /></td>
            </tr>
            <tr>
              <td height="35" align="right" bgcolor="#D4E5F4">证件类型：</td>
              <td align="left" bgcolor="#FFFFFF"><ft:dict value="${entity.cardType}" /></td>
              <td height="35" align="right" bgcolor="#D4E5F4">证件证号：</td>
              <td align="left" bgcolor="#FFFFFF"><c:out value='${entity.cardNum}'/></td>
            </tr>
            <tr>
              <td height="35" align="right" bgcolor="#D4E5F4">户口所在地：</td>
              <td align="left" bgcolor="#FFFFFF" colspan='3'>
	              <ft:dict value="${entity.province}" /><ft:dict value="${entity.county}" />
				</td>
            </tr>
            <tr>
              <td height="35" align="right" bgcolor="#D4E5F4">家庭地址：</td>
              <td align="left" bgcolor="#FFFFFF"><c:out value='${entity.famliyAddress}'/></td>
              <td align="right" bgcolor="#D4E5F4">家庭邮编：</td>
              <td align="left" bgcolor="#FFFFFF"><c:out value='${entity.famliyZip}'/></td>
            </tr>
            <tr>
              <td height="35" align="right" bgcolor="#D4E5F4">单位地址：</td>
              <td align="left" bgcolor="#FFFFFF"><c:out value='${entity.companyAddress}'/></td>
              <td align="right" bgcolor="#D4E5F4">单位邮编：</td>
              <td align="left" bgcolor="#FFFFFF"><c:out value='${entity.companyZip}'/></td>
            </tr>
            <tr>
              <td width="15%" height="35" align="right" bgcolor="#D4E5F4">固定电话：</td>
              <td width="35%" align="left" bgcolor="#FFFFFF"><c:out value='${entity.famliyTel}'/></td>
              <td width="15%" height="35" align="right" bgcolor="#D4E5F4">移动电话：</td>
              <td width="35%" align="left" bgcolor="#FFFFFF"><c:out value='${entity.mobilePhone}'/></td>
            </tr>
            <tr>
              <td height="35" align="right" bgcolor="#D4E5F4">单位电话：</td>
              <td align="left" bgcolor="#FFFFFF"><c:out value='${entity.companyTel}'/></td>
              <td align="right" bgcolor="#D4E5F4">电子邮件：</td>
              <td align="left" bgcolor="#FFFFFF"><c:out value='${entity.email}'/></td>
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
            </tr>
            <c:forEach var="en" items="${entity.archivesDeparteds}" varStatus="status">
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
              <td colspan='3' align="left" bgcolor="#FFFFFF"><c:out value='${entity.tombFront}' /></td>
            </tr>
            <tr>
              <td width="15%" height="35" align="right" bgcolor="#D4E5F4">碑后内容：</td>
              <td colspan='3' align="left" bgcolor="#FFFFFF"><c:out value='${entity.tombBack}' /></td>
            </tr>
            <tr>
              <td height="35" align="right" bgcolor="#D4E5F4">碑文说明：</td>
              <td colspan='3' align="left" bgcolor="#FFFFFF"><c:out value='${entity.tombRemark}' /></td>
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
            </tr>
            <tr>
              <td width="13%" height="30" align="center" bgcolor="#FFFFFF">土地租赁费</td>
              <td width="13%" align="center" bgcolor="#FFFFFF" ><span id="groundPrice"><c:out value='${entity.cemeteryLocation.cemeteryType.groundPrice}'/></span></td>
              <td width="13%" align="center" bgcolor="#FFFFFF">--</td>
              <td width="13%" align="center" bgcolor="#FFFFFF">--</td>
            </tr>
            <tr>
              <td width="13%" height="30" align="center" bgcolor="#FFFFFF">工程费</td>
              <td width="13%" align="center" bgcolor="#FFFFFF" ><span id="constructionPrice"><c:out value='${entity.cemeteryLocation.cemeteryType.constructionPrice}'/></span></td>
              <td width="13%" align="center" bgcolor="#FFFFFF" >--</td>
              <td width="13%" align="center" bgcolor="#FFFFFF">--</td>
            </tr>
            <tr>
              <td height="30" align="center" bgcolor="#FFFFFF">管理费</td>
              <td align="center" bgcolor="#FFFFFF" ><span id="managePrice"><c:out value='${entity.cemeteryLocation.cemeteryType.managePrice}'/></span></td>
              <td align="center" bgcolor="#FFFFFF">--</td>
              <td align="center" bgcolor="#FFFFFF">--</td>
            </tr>
            <c:forEach var="cemeteryCharge" items="${entity.archivesCemeteryCharges}" varStatus="status">
              <tr>
                <td width="13%" height="30" align="center" bgcolor="#FFFFFF"><c:out value="${cemeteryCharge.productName}" /></td>
                <td width="13%" align="center" bgcolor="#FFFFFF" ><c:out value="${cemeteryCharge.price}" /></td>
                <td width="13%" align="center" bgcolor="#FFFFFF"><c:out value="${cemeteryCharge.count}" /></td>
                <td width="13%" align="center" bgcolor="#FFFFFF" id="charges" name="charges"><c:out value="${cemeteryCharge.receive}" /></td>
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
            </tr>
            <c:forEach var="cemeteryFile" items="${entity.archivesCemeteryFiles}" varStatus="status">
              <tr>
                <td width="13%" height="30" align="center" bgcolor="#FFFFFF"><c:out value="${cemeteryFile.fileName}" /></td>
                <td width="13%" align="center" bgcolor="#FFFFFF"><c:out value="${cemeteryFile.remark}" /></td>
                <td width="13%" align="center" bgcolor="#FFFFFF"><gOS_shjz:shjzUser key="${cemeteryFile.createUserId}"/></td>
                <td width="13%" align="center" bgcolor="#FFFFFF"><c:out value="${cemeteryFile.createDate}" /></td>
              </tr>
            </c:forEach>
          </table></td>
      </tr>
      <tr>
        <table>
          <tr>
            <td height="35">
		        <input name="button" type="button" onclick="doBack();" class="button-z" id="backBtn" value="返回" />
            </td>
          </tr>
        </table>
      </tr>
    </table>
  </form>
      <script type="text/javascript">
		function doBack(){
			JavaScript:history.back();
		}
	</script>
  
    </td>
  
    </tr>
  
</table>
</body>
</html>