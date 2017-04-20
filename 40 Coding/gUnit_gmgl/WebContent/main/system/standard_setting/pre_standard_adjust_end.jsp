<%@ page contentType="text/html; charset=GBK" %>
<%@ include file="../../../common/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
<title>政策标准查询修改</title>
<link href="../../../css/css.css" rel="stylesheet" type="text/css">
<script language="JavaScript" src="../../../script/page.js"></script>
<style type="text/css">
<!--
body {
	background-color: #F3FBFD;
}
-->
</style></head>
<script language="javascript">
function startAdjust(){
	document.URL="standard_adjusting.jsp";
}	
</script>

<body>
  <table width="96%" border="0" align="center" cellpadding="0" cellspacing="0">    
    <tr>
	    <td height="45" align="center" class="biaoti_3">已调整的政策标准</td>
	  </tr>
  </table>
	<table width="96%" border="0" align="center" cellpadding="1" cellspacing="1" bgcolor="#CCCCCC">
    <tr>
      <td width="4%" align="center" class="tabel_td1">序号</td>
      <td width="10%" align="center" class="tabel_td1">适用范围</td>
      <td width="8%" align="center" class="tabel_td1">区域</td>
      <td width="10%" align="center" class="tabel_td1">类型</td>
      <td width="30%" align="center" class="tabel_td1">子类型</td>
      <td width="5%" align="center" class="tabel_td1">调整前金额</td>
      <td width="5%" align="center" class="tabel_td1">调整后金额</td>
    </tr>
    <c:forEach var="standardInfo" items="${standards}" varStatus="statu"> 
    	<tr height="22" nowrap class="<c:if test="${statu.count%2==0}">list_tr</c:if><c:if test="${statu.count%2!=0}">list_tr1</c:if>"> 
			  <td height="26" align="center" ><c:out value="${statu.count}"/></td>
			  <td height="26" align="center" ><gOS_shjz:dictValue key='${standardInfo.scopeId}'  typeName="BZSYFW"/></td>	  		
	  		<td align="center" ><gOS_shjz:regionValue key='${standardInfo.areaId}' /></td>
	  		<td align="center" ><gOS_shjz:dictValue key='${standardInfo.standardType}'  typeName="ZCBZZLX"/></td>	
			  <td align="center" ><gOS_shjz:dictValue key='${standardInfo.subType}'  typeName="ZCBZZLX1"/></td>	
			  <td align="left" ><c:out value='${standardInfo.sum}' /></td>		
			  <td align="left" ><c:out value='${standardInfo.adjustSum}' /></td>	
		  </tr>
    </c:forEach>  
  </table>	
	<table width="96%" border="0" align="center" cellpadding="1" cellspacing="1" bgcolor="#CCCCCC">
    <tr height="22"  class="list_tr">
      <td width="100%" align="center">
      <c:if test="${adjustStatus}">
       	<input  class="input_btn02" type="button" name="Submit1"  value="开始调标" onclick="startAdjust()" disabled>     	
      </c:if>
      <c:if test="${!adjustStatus}">
       	<input  class="input_btn02" type="button" name="Submit1"  value="开始调标" onclick="startAdjust()">     	
      </c:if>

      <input  class="input_btn02" type="Submit" name="Submit2"  value="返回修改"  onclick="history.go(-1)">	
      </td>
    </tr>
  </table>	 
</body>
</html>