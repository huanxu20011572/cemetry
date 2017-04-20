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
<title>政策参数查看</title>
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
	    <td height="45" align="center" class="biaoti_3">查看政策参数</td>
	  </tr>
  </table> 
	<table width="50%" border="0" align="center" cellpadding="0" cellspacing="0">
    
    <tr>
      <td align="center" bgcolor="#FFFFFF" class="biankuang1">
      	<table width="100%" border="0" cellpadding="0" cellspacing="2" class="biankuang2">
	        <tr>
            <td width="20%" height="25" align="right" class="table_td7">政策标准适用范围：</td>            
            <td width="30%" align="left" class="table_td7"><gOS_shjz:dictValue key='${jzStandardInfoForm.scopeId}'  typeName="BZSYFW"/></td>
          </tr> 
          <tr>
            <td width="20%" height="25" align="right" class="table_td7">所属区域名称：</td>            
            <td width="30%" align="left" class="table_td7" id="scope1" ><gOS_shjz:regionValue key='${jzStandardInfoForm.areaId}' /></td>
          </tr> 
          <tr>
            <td width="20%" height="25" align="right" class="table_td7">政策标准类型：</td>            
            <td width="30%" align="left" class="table_td7" id="scope1"><gOS_shjz:dictValue key='${jzStandardInfoForm.standardType}'  typeName="ZCBZZLX"/></td>
          </tr> 
          <tr>
            <td width="20%" height="25" align="right" class="table_td7">政策标准子类别：</td>            
            <td width="30%" align="left" class="table_td7" id="scope1"><gOS_shjz:dictValue key='${jzStandardInfoForm.subType}'  typeName="ZCBZZLX1"/></td>
          </tr> 
          <tr>
            <td width="20%" height="25" align="right" class="table_td7">政策标准金额：</td>            
            <td width="30%" align="left" class="table_td7" id="scope1"><c:out value='${jzStandardInfoForm.sum}' /></td>
          </tr> 
          <tr>
            <td width="20%" height="25" align="right" class="table_td7">政策标准生效日期：</td>            
            <td width="30%" align="left" class="table_td7" id="scope1"><c:out value='${jzStandardInfoForm.startDateStr}'/></td>
          </tr> 
          <tr>
            <td width="20%" height="25" align="right" class="table_td7">政策标准失效日期：</td>            
            <td width="30%" align="left" class="table_td7" id="scope1"><c:out value='${jzStandardInfoForm.stopDateStr}'/></td>
          </tr> 
          <tr>
            <td width="20%" height="25" align="right" class="table_td7">政策标准是否启用：</td>            
            <td width="30%" align="left" class="table_td7" id="scope1">
            	<c:if test='${jzStandardInfoForm.stopFlag == 0}'>否</c:if>
            　<c:if test='${jzStandardInfoForm.stopFlag == 1}'>是</c:if>          　
            </td>
          </tr> 
          <tr>
            <td width="20%" height="25" align="right" class="table_td7">政策标准简单说明：</td>            
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