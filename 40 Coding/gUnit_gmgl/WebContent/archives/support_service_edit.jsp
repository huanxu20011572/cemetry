<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ include file="../common/head.jsp"%>
<head>
<script type="text/javascript">
	function reset() {
		$("#cemeteryRegistryCode").val("");
		$("#cemeteryRegistryCode").val("");
		$("#name").val("");
		$("#mobilePhone").val("");
	}
	function doCheck(){
		var remark=$.trim($("#remark").val());
		if(remark.length>200){
			alert("备注大于200位");
			return;
		}
		var name=$.trim($("#name").val());
		if(name.length<=0 || name==''){
			alert("请输入姓名");
			return;
		}
		if(name.length>20){
			alert("姓名的最大长度为20个字符");
			return;
		}
		var nation=$.trim($("#nation").val());
		if(nation.length<=0 || nation=='-1'){
			alert("请选择民族");
			return;
		}
		var nationality=$.trim($("#nationality").val());
		if(nationality.length<=0 || nationality=='-1'){
			alert("请选择国籍");
			return;
		}
		var changeResone=$.trim($("#changeResone").val());
		if(changeResone.length<=0){
			alert("请填写变更原因");
			return;
		}
		
		var cardType=$.trim($("#cardType").val());
		if(cardType.length<=0 || cardType=='-1'){
			alert("请选择证件类型");
			return;
		}
		var cardNum=$.trim($("#cardNum").val());
		if(cardNum.length<=0 || cardNum==''){
			alert("请填写证件证号");
			return;
		}
		if(cardNum.length>20){
			alert("身份证的最大长度为20个字符");
			return;
		}
		var famliyAddress=$.trim($("#famliyAddress").val());
		if(famliyAddress.length>200){
			alert("家庭住址的最大长度为200个字符");
			return;
		}
		var companyAddress=$.trim($("#companyAddress").val());
		if(companyAddress.length>200){
			alert("公司地址的最大长度为200个字符");
			return;
		}
		//companyTel单位电话
		var companyTel=$.trim($("#companyTel").val());
		var cmccMobile = /^(((13[0-9]{1})|(14[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
		var tel = /^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})?$/;
		// /^\d{3,4}?\d{7,8}$/;
		if(companyTel.length>20){
			alert("单位电话的最大长度为20个字符");
			return;
		}
		if(companyTel.length>0&&!tel.test(companyTel)){
			alert("单位电话不合法");
			return;
		}
		//移动电话
		var mobilePhone=$.trim($("#mobilePhone").val());
		if(mobilePhone.length>20){
			alert("移动电话的最大长度为20个字符");
			return;
		}
		if(mobilePhone.length>0&&!cmccMobile.test(mobilePhone)){
			alert("移动电话不合法");
			return;
		}
       //固定电话
		var famliyTel=$.trim($("#famliyTel").val());
		if(famliyTel.length>20){
			alert("固定电话的最大长度为20个字符");
			return;
		}
		if(famliyTel.length>0&&!tel.test(famliyTel)){
			alert("固定电话不合法");
			return;
		}
		 
		//email
		var email=$.trim($("#email").val());
		if(email.length>50){
			alert("邮箱最大长度为50个字符");
			return;
		}//email
		if(email.length>0&&! /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})$/.test(email)){
			alert("邮箱不合法");
			 return;
		}
		//变更原因
		var changeResone=$.trim($("#changeResone").val());
		if(remark.length>200){
			alert("变更原因的最大长度为200个字符");
			return;
		}
		//备注
		var remark=$.trim($("#changeRemark").val());
		if(remark.length>200){
			alert("备注的最大长度为200个字符");
			return;
		}
		//家庭住址
		var famliyAddress=$.trim($("#famliyAddress").val());
		if(famliyAddress.length>200){
			alert("家庭住址的最大长度为200个字符");
			return;
		}
		//单位地址
		var companyAddress=$.trim($("#companyAddress").val());
		if(remark.length>200){
			alert("单位地址的最大长度为200个字符");
			return;
		}
		$("#saveForm").submit();
		
	}
</script>
</head>

<body style="background-color: transparent">
	<table width="100%" border="0" cellspacing="0" cellpadding="0"
		height="100%">
		<tr>
			<td width="11" valign="top" class="td-bg"><img
				src="../images/right-1.jpg" />
			</td>
			<td align="center" valign="top">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td height="31" align="left" valign="middle"
							style="background: url(../images/right-3.jpg)"><img
							src="../images/right-4.jpg" width="9" height="8"
							align="absmiddle" /> 当前位置 &gt; 售后管理 &gt; 承租人信息变更</td>
					</tr>
					<tr>
						<td bgcolor="#FFFFFF" style="font-size: 12px;">&nbsp;</td>
					</tr>
				</table> <!-- 输入域 --> <!-- Begin 承租人信息  -->
				<table width="98%" border="0" align="center" cellpadding="0"
					cellspacing="0">
					<tr>
						<td width="92%" bgcolor="#EBF4FA"><table width="200"
								border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td width="20" align="right"><img
										src="../images/tab-01.jpg" width="8" height="27" />
									</td>
									<td width="99" align="center" class="tab-img-01">承租人信息</td>
									<td width="81" align="left" valign="bottom"><img
										src="../images/tab-03.jpg" />
									</td>
								</tr>
							</table>
						</td>

					</tr>
				</table>
               <form id="saveForm" action="archivesCemeteryRegistryController.fj?method=saveArchivesCemeteryRegistryEdit" method='post'>
                <input name='id' type='hidden' value='${entity.id}'/>
				<table width="98%" border="0" cellspacing="0" cellpadding="3">
					<tr>
						<td bgcolor="#C4DEEE"><table id="baseInfo" width="100%"
								cellpadding="0" cellspacing="1" bgcolor="#a6c6da">
								<tr>
									<tr>
										<td height="35" align="right" bgcolor="#D4E5F4">姓名：</td>
										<td align="left" bgcolor="#FFFFFF">  
                                              <input name="name" type="text" id="name" class="input-1"  value="<c:out value='${entity.name}'/>"  />
										        <span class="word-7">*</span> 
										</td>
										<td align="right" bgcolor="#D4E5F4">性别：</td>
										<td align="left" bgcolor="#FFFFFF"> 
										  <input name="sex" type="radio"   <c:if test="${entity.sex=='1'}">checked='true'</c:if>  value='1' />男
		                                  <input name="sex" type="radio"   <c:if test="${entity.sex=='0'}">checked='true'</c:if>  value='0'/>女
                                         <span class="word-7">*</span> 
                                        </td>

									</tr>

									<tr>
										<td height="35" align="right" bgcolor="#D4E5F4">民族：</td>
										<td align="left" bgcolor="#FFFFFF">  
										   <ft:select name="nation" type="mz"  selected="${entity.nation}" style="width:190px"></ft:select>
										   <span class="word-7">*</span>
										</td>
										<td align="right" bgcolor="#D4E5F4">国籍：</td>
										<td align="left" bgcolor="#FFFFFF">  
										    <ft:select name="nationality" type="gj" selected="${entity.nationality}"  style="width:190px"></ft:select>
										    <span class="word-7">*</span>
										</td>
									</tr>
									<tr>
										<td height="35" align="right" bgcolor="#D4E5F4">证件类型：</td>
										<td align="left" bgcolor="#FFFFFF"> 
                                            <ft:select name="cardType" type="zjlx" selected="${entity.cardType}" style="width:190px"></ft:select>
										 <span class="word-7">*</span> 
										</td>
										<td align="right" bgcolor="#D4E5F4">证件证号：</td>
										<td align="left" bgcolor="#FFFFFF">  
                                             <input name="cardNum" type="text" id="cardNum" class="input-1" value="<c:out value='${entity.cardNum}'/>" />
										 <span class="word-7">*</span> 
										</td>
									</tr>



									<tr>
										<td height="35" align="right" bgcolor="#D4E5F4">户口所在地：</td>
										<td align="left" colspan="3" bgcolor="#FFFFFF"> 
										 <ft:select name="province" type="shengfen" selected="${entity.province}" style="width:190px"></ft:select>
										 <ft:select name="county" type="shengfen" selected="${entity.county}" style="width:190px"></ft:select>
										</td>

									</tr>
									<tr>
										<td height="35" align="right" bgcolor="#D4E5F4">家庭地址：</td>
										<td align="left" bgcolor="#FFFFFF"> 
                                             <input name="famliyAddress" type="text" id="famliyAddress" class="input-1"  value="<c:out value='${entity.famliyAddress}'/>"   />
										</td>
										<td align="right" bgcolor="#D4E5F4">家庭邮编：</td>
										<td align="left" bgcolor="#FFFFFF"> 
										 <input name="famliyZip" type="text" id="famliyZip" class="input-1" value="<c:out value='${entity.famliyZip}'/>"  />
										</td>
									</tr>
									<tr>
										<td height="35" align="right" bgcolor="#D4E5F4">单位地址：</td>
										<td align="left" bgcolor="#FFFFFF"> 
										   <input name="companyAddress" type="text" id="companyAddress" class="input-1" value="<c:out value='${entity.companyAddress}'/>" />
										</td>
										<td align="right" bgcolor="#D4E5F4">单位邮编：</td>
										<td align="left" bgcolor="#FFFFFF"> 
                                          <input name="companyZip" type="text" id="companyZip" class="input-1"  value="<c:out value='${entity.companyZip}'/>" />
										</td>
									</tr>
									<tr>
										<td height="35" align="right" bgcolor="#D4E5F4">固定电话：</td>
										<td align="left" bgcolor="#FFFFFF"> 
										   <input style="height:17px"  name="famliyTel" type="text" id="famliyTel" class="input-1"  value="<c:out value='${entity.famliyTel}'/>"/>
										</td>
										<td align="right" bgcolor="#D4E5F4">移动电话：</td>
										<td align="left" bgcolor="#FFFFFF"> 
										
										  <input style="height:17px"  name="mobilePhone" type="text" id="mobilePhone" class="input-1"  value="<c:out value='${entity.mobilePhone}'/>" />
										 <span class="word-7">*</span> 
										</td>
									</tr>
									<tr>
										<td height="35" align="right" bgcolor="#D4E5F4">单位电话：</td>
										<td align="left" bgcolor="#FFFFFF"> 
										  <input name="companyTel" type="text" id="companyTel" class="input-1" value="<c:out value='${entity.companyTel}'/>"  />
										</td>
										<td align="right" bgcolor="#D4E5F4">电子邮件：</td>
										<td align="left" bgcolor="#FFFFFF">  
										<input name="email" type="text" id="email" class="input-1" value="<c:out value='${entity.email}'/>" />
										</td>
									</tr>
									<tr>
										<td width="15%" height="35" align="right" bgcolor="#D4E5F4">变更人：</td>
										<td width="35%" align="left" bgcolor="#FFFFFF">&nbsp;&nbsp;<gOS_shjz:shjzUser key="${entity.createUserId}"/></td>
										<td width="15%" align="right" bgcolor="#D4E5F4">变更日期：</td>
										<td width="35%" align="left" bgcolor="#FFFFFF">&nbsp;&nbsp;<fmt:formatDate value='${entity.createDate}' pattern="yyyy-MM-dd"/></td>
									</tr>
									<tr>
										<td height="50px" align="right" bgcolor="#D4E5F4">变更原因：</td>
										<td colspan='3' align="left" bgcolor="#FFFFFF">
										<input name="changeResone" type="text" id="changeResone" class="input-1"
											value='<c:out value="${entity.changeResone}"/>' />
											<span class="word-7">*</span></td>
									</tr>
									<tr>
										<td height="50px" align="right" bgcolor="#D4E5F4">备注：</td>
										<td colspan='3' align="left" bgcolor="#FFFFFF"> <textarea
												name="changeRemark" class="input-1"
												style='height: 40px; width: 90%'><c:out value='${entity.changeRemark}'/></textarea>
										</td>
									</tr>
								 
							</table>
						</td>

					</tr>
				</table> <!-- End 承租人信息  --> <!-- 保存 -->
					<table width="98%" cellpadding="0" cellspacing="0">
						<tr>
							<td height="60" width="44%" align="right"></td>
							<td height="60" width="6%" align="center">&nbsp;&nbsp; <input
								name="saveBtn" type="button" onclick="doCheck()" class="button-z" id="saveBtn"
								value="保存" /></td>
							<td height="60" width="6%" align="center">&nbsp;&nbsp; <input
								name="button" type="button" class="button-z" id="doCompleteBtn"
								onclick="javascirpt:location.href='archivesCemeteryRegistryController.fj?method=getArchivesCemeteryRegistryPageList'" 
								value="返回" /></td>
							<td height="60" width="44%" align="right"></td>
						</tr>
					</table>
				</form>
				</td>
		</tr>
	</table>
</body>
</html>
