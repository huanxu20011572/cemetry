<%@ page contentType="text/html; charset=GBK" %>
<%@ include file="../../../common/taglibs.jsp"%>
<style>
	<!--
	select {width:100%}
	-->
</style>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
<title>���߲����鿴</title>
<link href="../../../css/css.css" rel="stylesheet" type="text/css">
<script language="JavaScript" src="../../../script/publics.js"></script>
<script language="JavaScript" src="../../../script/calendar.js"></script>
<script language="JavaScript" src="../../../script/area.js"></script>
<style type="text/css">
<!--
body {
	background-color: #F3FBFD;
}
-->
</style></head>

<script language="javascript">
	
</script>

<body>
<form name="jzStandardInfoForm" method="post" action="">
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
	  <tr>
	    <td height="45" align="center" class="biaoti_3">�鿴���߲���</td>
	  </tr>
  </table> 
	<table width="50%" border="0" align="center" cellpadding="0" cellspacing="0">
    
    <tr>
      <td align="center" bgcolor="#FFFFFF" class="biankuang1">
      	<table width="100%" border="0" cellpadding="0" cellspacing="2" class="biankuang2">
	        <tr>
            <td width="20%" height="25" align="right" class="table_td7">���߱�׼���÷�Χ��</td>            
            <td width="30%" align="left" class="table_td7"><gOS_shjz:dictValue key='${jzStandardInfoForm.scopeId}'  typeName="BZSYFW"/></td>
          </tr> 
          <tr>
            <td width="20%" height="25" align="right" class="table_td7">�����������ƣ�</td>            
            <td width="30%" align="left" class="table_td7" id="scope1" ><gOS_shjz:regionValue key='${jzStandardInfoForm.areaId}' /></td>
          </tr> 
          <tr>
            <td width="20%" height="25" align="right" class="table_td7">���߱�׼���ͣ�</td>            
            <td width="30%" align="left" class="table_td7" id="scope1"><gOS_shjz:dictValue key='${jzStandardInfoForm.standardType}'  typeName="ZCBZZLX"/></td>
          </tr> 
          <tr>
            <td width="20%" height="25" align="right" class="table_td7">���߱�׼�����</td>            
            <td width="30%" align="left" class="table_td7" id="scope1"><gOS_shjz:dictValue key='${jzStandardInfoForm.subType}'  typeName="ZCBZZLX1"/></td>
          </tr> 
          <tr>
            <td width="20%" height="25" align="right" class="table_td7">���߱�׼��</td>            
            <td width="30%" align="left" class="table_td7" id="scope1"><c:out value='${jzStandardInfoForm.sum}' /></td>
          </tr> 
          <tr>
            <td width="20%" height="25" align="right" class="table_td7">���߱�׼��Ч���ڣ�</td>            
            <td width="30%" align="left" class="table_td7" id="scope1"><c:out value='${jzStandardInfoForm.startDateStr}'/></td>
          </tr> 
          <tr>
            <td width="20%" height="25" align="right" class="table_td7">���߱�׼ʧЧ���ڣ�</td>            
            <td width="30%" align="left" class="table_td7" id="scope1"><c:out value='${jzStandardInfoForm.stopDateStr}'/></td>
          </tr> 
          <tr>
            <td width="20%" height="25" align="right" class="table_td7">���߱�׼�Ƿ����ã�</td>            
            <td width="30%" align="left" class="table_td7" id="scope1">
            	<c:if test='${jzStandardInfoForm.stopFlag == 0}'>��</c:if>
            ��<c:if test='${jzStandardInfoForm.stopFlag == 1}'>��</c:if>          ��
            </td>
          </tr> 
          <tr>
            <td width="20%" height="25" align="right" class="table_td7">���߱�׼��˵����</td>            
            <td width="30%" align="left" class="table_td7" id="scope1"><c:out value='${jzStandardInfoForm.description}' />
            </td>
          </tr>           
	      </table>
	    </td>
    </tr>
  </table>  
  <table width="80%" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td>&nbsp;</td>
    </tr>
  </table>  
  <table width="96%" border="0" align="center" cellpadding="0" cellspacing="0">
    
    <tr>
      <td align="center" bgcolor="#FFFFFF" class="biankuang1">
      </td>
    </tr>
  </table>
  <table width="30%" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>      
      <td align="center"><label>
         <img src="../../../images/bt_back.gif"  onclick="javascript:window.history.back();" style="cursor:hand">
      </label></td>
    </tr>
  </table>
</form>    
</body>
</html>