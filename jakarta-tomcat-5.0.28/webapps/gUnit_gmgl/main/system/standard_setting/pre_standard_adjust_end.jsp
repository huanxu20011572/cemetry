<%@ page contentType="text/html; charset=GBK" %>
<%@ include file="../../../common/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
<title>���߱�׼��ѯ�޸�</title>
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
	    <td height="45" align="center" class="biaoti_3">�ѵ��������߱�׼</td>
	  </tr>
  </table>
	<table width="96%" border="0" align="center" cellpadding="1" cellspacing="1" bgcolor="#CCCCCC">
    <tr>
      <td width="4%" align="center" class="tabel_td1">���</td>
      <td width="10%" align="center" class="tabel_td1">���÷�Χ</td>
      <td width="8%" align="center" class="tabel_td1">����</td>
      <td width="10%" align="center" class="tabel_td1">����</td>
      <td width="30%" align="center" class="tabel_td1">������</td>
      <td width="5%" align="center" class="tabel_td1">����ǰ���</td>
      <td width="5%" align="center" class="tabel_td1">��������</td>
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
       	<input  class="input_btn02" type="button" name="Submit1"  value="��ʼ����" onclick="startAdjust()" disabled>     	
      </c:if>
      <c:if test="${!adjustStatus}">
       	<input  class="input_btn02" type="button" name="Submit1"  value="��ʼ����" onclick="startAdjust()">     	
      </c:if>

      <input  class="input_btn02" type="Submit" name="Submit2"  value="�����޸�"  onclick="history.go(-1)">	
      </td>
    </tr>
  </table>	 
</body>
</html>