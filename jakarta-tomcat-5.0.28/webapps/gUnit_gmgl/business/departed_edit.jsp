<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ include file="../common/head.jsp"%>
<head>
<title>逝者</title>
 
<script type="text/javascript">
function doSave(){
	var name=$.trim($("#name").val());
	if(name == "" || name.length>20){
		alert("请填写正确逝者姓名");
		return;
	}
	var age=$.trim($("#age").val());
	if(age!=""&&!/^[0-9]+$/g.test(age)){
		alert("年龄字段为数字");
		return;
	}
	if(age.length>3){
		alert("年龄不能超过3位");
		return;
	}
	var idCardNum=$.trim($("#idCardNum").val());
	if(idCardNum == "" || idCardNum.length > 18){
		alert("请填写正确身份证号");
		return;
	}
	if($("#cardType").val() == "-1"){
		alert("请选择证件类型");
		return;
	}
	if($("#cardType").val() == "-1"){
		alert("请选择证件类型");
		return;
	}
	var funeral=$.trim($("#funeral").val());
	if(funeral == "" ){
		alert("请填写火化殡仪馆");
		return;
	}
	var deadDate=$.trim($("#deadDate").val());
	if(deadDate == "" ){
		alert("请填写辞世日期");
		return;
	}
		
	if($("#putGoods").val() == '-1'){
		alert("请选择安放物");
		return;
	}
	var remark=$.trim($("#remark").val());
	if(remark.length>200){
		alert("备注的最大长度为200个字符");
		return;
	}
	$("#saveDepartForm").submit();
	
}

function doBack(){
	var redirect_url = $.base64.decode('${param.redirect_url}');
	location.href=redirect_url;
}
</script>
</head>
<body>

<table width="100%" border="0" cellspacing="0" cellpadding="0" height="100%">
  <tr>
    <td width="11" valign="top" class="td-bg"><img src="../images/right-1.jpg" /></td>
    <td align="center" valign="top" >
	    <table width="100%" border="0" cellspacing="0" cellpadding="0">
	      <tr>
	        <td height="31" align="left" valign="middle" style="background:url(../images/right-3.jpg)"><img src="../images/right-4.jpg" width="9" height="8" align="absmiddle" /> 当前位置 &gt; 租用登记 &gt; 逝者信息登记</td>
	      </tr>
	      <tr>
	        <td bgcolor="#FFFFFF" style="font-size:12px;">&nbsp;</td>
	      </tr>
	    </table>
	  <form id='saveDepartForm' action="departedController.fj?method=saveDeparted" method='post'>     
				  <input  type="hidden" id="id"  name="id" value="<c:out value='${entity.id}'/>"></input>
				  <input  type="hidden" id="regeditId"  name="regeditId" value="<c:out value='${param.regeditId}'/>"></input>
				  <input  type="hidden" id="redirect_url"  name="redirect_url" value="${param.redirect_url}"></input>
			     
			      <table width="98%" cellpadding="0" cellspacing="1" bgcolor="#a6c6da">
			        <tr>
			          <td width="15%" height="35" align="right" bgcolor="#D4E5F4">逝者姓名：</td>
			          <td width="35%" align="left" bgcolor="#FFFFFF">
			            <input name="name" type="text" id="name" class="input-1" value="${entity.name}"/>	
			            <span class="word-7">*</span>
					  </td>
			          <td width="15%" align="right" bgcolor="#D4E5F4">性别：</td>
			          <td width="35%" align="left" bgcolor="#FFFFFF"><ft:radiosex name="sex" checked="${entity.sex}" />
					  </td>
			        </tr>
					<tr>
					  <td bgcolor='#d4e5f4' height='35' align='right'>年龄：</td>
					  <td bgcolor='#ffffff' align='left'><input id='age' class='input-1' name='age'  value="${entity.age}" /></td>
					 <td width="15%" height="35" align="right" bgcolor="#D4E5F4">身份证号：</td>
			          <td width="35%" align="left" bgcolor="#FFFFFF" colspan='3'>
			            <input name="idCardNum" type="text" id="idCardNum" class="input-1"  value="${entity.idCardNum}"/>
			            <span class="word-7">* (无身份证号请填0)</span>		    
					  </td>
			 
			        </tr>
			        <tr>
			          <td height="35" align="right" bgcolor="#D4E5F4">证件类别：</td>
			          <td align="left" bgcolor="#FFFFFF"><ft:select name="cardType" type="zjlx" selected="${entity.cardType}"  style="width:190px"></ft:select>
			            <span class="word-7">*</span></td>
			          <td width="15%" height="35" align="right" bgcolor="#D4E5F4">证件编号：</td>
			          <td width="35%" align="left" bgcolor="#FFFFFF"><input name="cardNum" type="text" id="cardNum" class="input-1"  value="${entity.cardNum}"/></td>      
			        </tr>
					<tr>
					  <td align="right" bgcolor="#D4E5F4" height="35">民族：</td>
			          <td align="left" bgcolor="#FFFFFF">
			            	<ft:select name="nation" type="mz" selected="${entity.nation}"   style="width:190px"></ft:select>
					  </td>
			          <td align="right" bgcolor="#D4E5F4">国籍：</td>
			          <td align="left" bgcolor="#FFFFFF"><ft:select name="nationality" type="gj"  selected="${entity.nationality}"  style="width:190px"></ft:select></td>
		            </tr>
					<tr>
			      
				      <td bgColor='#d4e5f4' align='right'>与承租人关系：</td>
				      <td bgColor='#ffffff' align='left'> 
							   <ft:select name="rentrelation" type="zcrgx"  selected="${entity.rentrelation}"  style="width:190px"></ft:select>
					  </td>
					   <td bgColor='#d4e5f4' height='35' align='right'>出生日期：</td>
			          <td bgColor='#ffffff' align='left'> 
			             <input id='birthDate' class='input-1' name='birthDate' onClick="WdatePicker()"  value="<fmt:formatDate value='${entity.birthDate}' pattern="yyyy-MM-dd"/>" /></td>
			    </tr>
			    <tr>
			         <td bgColor='#d4e5f4' height='35' align='right'>火化殡仪馆：</td>
				      <td bgColor='#ffffff' align='left'> 
							<input id='funeral' class='input-1' name='funeral'  value="${entity.funeral}" /> <span class="word-7">*</span>  
					  </td>
			      <td bgColor='#d4e5f4' align='right'>辞世日期：</td>
			      <td bgColor='#ffffff' align='left'> 
			        <input id='deadDate' class='input-1' name='deadDate' onClick="WdatePicker()"  value="<fmt:formatDate value='${entity.deadDate}' pattern="yyyy-MM-dd"/>" />
			        <span class="word-7">*</span>
			        </td>
			    </tr>
			        <tr>
			      <td bgColor='#d4e5f4' height='35' align='right'>预约安放日期：</td>
			      <td bgColor='#ffffff' align='left'> 
			        <input id='orderBuryDate' class='input-1' name='orderBuryDate' onClick="WdatePicker()"  value="<fmt:formatDate value='${entity.orderBuryDate}' pattern="yyyy-MM-dd"/>" /></td>
			      <td bgColor='#d4e5f4' align='right'>实际安放日期：</td>
			      <td bgColor='#ffffff' align='left'> 
			        <input id='factBuryDate' class='input-1' name='factBuryDate' onClick="WdatePicker()"  value="<fmt:formatDate value='${entity.factBuryDate}' pattern="yyyy-MM-dd"/>" /></td>
			    </tr>
			        <tr>
			      <td bgColor='#d4e5f4' height='35' align='right'>安放物：</td>
			      <td bgColor='#ffffff' align='left'> 
						 <ft:select name="putGoods" type="afw" selected="${entity.putGoods}"  style="width:190px"></ft:select>
						 <span class="word-7">*</span>
					</td>
			      <td bgColor='#d4e5f4' align='right'>施工人：</td>
			      <td bgColor='#ffffff' align='left'> 
			        <input id='worker' class='input-1' name='worker'  value="${entity.worker}"/></td>
			    </tr>
			        <tr>
			      <td bgColor='#d4e5f4' height='35' align='right'>登记人：</td>
			      <td bgColor='#ffffff' align='left'><gOS_shjz:shjzUser key="${entity.createUserId}"/> </td>
			      <td bgColor='#d4e5f4' align='right'>登记日期：</td>
			      <td bgColor='#ffffff' align='left'><fmt:formatDate value='${entity.createDate}' pattern="yyyy-MM-dd"/></td>
			    </tr>
			        <tr>
			      <td bgColor='#d4e5f4' height='35' align='right'>备注：</td>
			      <td colspan='3' bgColor='#ffffff'align='left'><textarea name="remark"  id="remark" style="width:600px;height:60px">${entity.remark}</textarea> 
			      </td>
			    </tr>
			        <tr>
			          <table>
					    <tr>
			               <td height="35"  >			    
						      <input name="saveDepartedBtn" type="button" onclick="doSave();"class="button-z" id="button" value="保存" />
						      &nbsp;&nbsp;
						      <input name="button2" type="button" onclick="javascirpt:doBack();" class="button-z" id="button2" value="返回" />
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
</html>