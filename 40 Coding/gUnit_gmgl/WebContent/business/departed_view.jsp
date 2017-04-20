<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ include file="../common/head.jsp"%>
<head>
<title>逝者</title>
 
<script type="text/javascript">
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
		  <input  type="hidden" id="id"  name="id" value="<c:out value='${entity.id}'/>"></input>
		  <input  type="hidden" id="regeditId"  name="regeditId" value="<c:out value='${param.regeditId}'/>"></input>
		  <input  type="hidden" id="redirect_url"  name="redirect_url" value="${param.redirect_url}"></input>

	      <table width="98%" cellpadding="0" cellspacing="1" bgcolor="#a6c6da">
	        <tr>
	          <td width="15%" height="35" align="right" bgcolor="#D4E5F4">逝者姓名：</td>
	          <td width="35%" align="left" bgcolor="#FFFFFF">${entity.name}</td>
	          <td width="15%" align="right" bgcolor="#D4E5F4">性别：</td>
	          <td width="35%" align="left" bgcolor="#FFFFFF"><c:if test="${entity.sex=='1'}">男</c:if><c:if test="${entity.sex=='0'}">女</c:if></td>
	        </tr>
			<tr>
			  <td bgcolor='#d4e5f4' height='35' align='right'>年龄：</td>
			  <td bgcolor='#ffffff' align='left'>${entity.age}</td>
			 <td width="15%" height="35" align="right" bgcolor="#D4E5F4">身份证号：</td>
	          <td width="35%" align="left" bgcolor="#FFFFFF" colspan='3'>${entity.idCardNum}</td>
	 
	        </tr>
	        <tr>
	          <td height="35" align="right" bgcolor="#D4E5F4">证件类别：</td>
	          <td colspan='3' align="left" bgcolor="#FFFFFF"><ft:dict value='${entity.cardType}'/></td>
	           <!-- <td width="15%" height="35" align="right" bgcolor="#D4E5F4">证件编号：</td>
	          <td width="35%" align="left" bgcolor="#FFFFFF">${entity.cardNum}</td>  -->    
	        </tr>
			<tr>
			  <td align="right" bgcolor="#D4E5F4" height="35">民族：</td>
	          <td align="left" bgcolor="#FFFFFF"><ft:dict value='${entity.nation}'/></td>
	          <td align="right" bgcolor="#D4E5F4">国籍：</td>
	          <td align="left" bgcolor="#FFFFFF"><ft:dict value='${entity.nationality}'/></td>
            </tr>
			<tr>
	      
		      <td bgColor='#d4e5f4' align='right'>与承租人关系：</td>
		      <td bgColor='#ffffff' align='left'><ft:dict value='${entity.rentrelation}'/></td>
			   <td bgColor='#d4e5f4' height='35' align='right'>出生日期：</td>
	          <td bgColor='#ffffff' align='left'><fmt:formatDate value='${entity.birthDate}' pattern="yyyy-MM-dd"/></td>
	    </tr>
	    <tr>
	         <td bgColor='#d4e5f4' height='35' align='right'>火化殡仪馆：</td>
	      	<td bgColor='#ffffff' align='left'>${entity.funeral}</td>
	      <td bgColor='#d4e5f4' align='right'>辞世日期：</td>
	      <td bgColor='#ffffff' align='left'> <fmt:formatDate value='${entity.deadDate}' pattern="yyyy-MM-dd"/></td>
	    </tr>
	        <tr>
	      <td bgColor='#d4e5f4' height='35' align='right'>预约安放日期：</td>
	      <td bgColor='#ffffff' align='left'><fmt:formatDate value='${entity.orderBuryDate}' pattern="yyyy-MM-dd"/></td>
	      <td bgColor='#d4e5f4' align='right'>实际安放日期：</td>
	      <td bgColor='#ffffff' align='left'><fmt:formatDate value='${entity.factBuryDate}' pattern="yyyy-MM-dd"/></td>
	    </tr>
	        <tr>
	      <td bgColor='#d4e5f4' height='35' align='right'>安放物：</td>
	      <td bgColor='#ffffff' align='left'><ft:dict value='${entity.putGoods}'/></td>
	      <td bgColor='#d4e5f4' align='right'>施工人：</td>
	      <td bgColor='#ffffff' align='left'>${entity.worker}</td>
	    </tr>
	        <tr>
	      <td bgColor='#d4e5f4' height='35' align='right'>登记人：</td>
	      <td bgColor='#ffffff' align='left'><gOS_shjz:shjzUser key="${entity.createUserId}"/> </td>
	      <td bgColor='#d4e5f4' align='right'>登记日期：</td>
	      <td bgColor='#ffffff' align='left'><fmt:formatDate value='${entity.createDate}' pattern="yyyy-MM-dd"/></td>
	    </tr>
	        <tr>
	      <td bgColor='#d4e5f4' height='35' align='right'>备注：</td>
	      <td colspan='3' bgColor='#ffffff'align='left'>${entity.remark}</td>
	    </tr>
	        <tr>
	          <table>
			    <tr>
	               <td height="35"><input name="button2" type="button" onclick="javascirpt:doBack();" class="button-z" id="button2" value="返回" /></td>
	            </tr>
	          </table>
	        </tr>
	      </table>
	  </td>
  </tr>
</table>
</body>
</html>