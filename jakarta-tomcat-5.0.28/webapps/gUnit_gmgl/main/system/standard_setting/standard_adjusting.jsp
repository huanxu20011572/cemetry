<%@ page contentType="text/html; charset=GBK" %>
<%@ include file="../../../common/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
<title>���߲�������</title>
<link href="../../../css/css.css" rel="stylesheet" type="text/css">
<style type="text/css">
<!--
.hidden_div {
	background-image: url(../../../images/jindu.gif);
	background-repeat: no-repeat;
	background-position: center bottom;
	width: 100%;
}
-->
</style></head>
<script language="javascript">
function confirmAdjust(){
	if(confirm('ȷ�ϵ����ϵͳ�Զ�����ؾ���������б�����Ƿ�ȷ�ϵ��ꣿ'	)){
		event.srcElement.disabled=true;
		document.URL='confirmAdjust.do?method=confirmAdjust';	
	}
}	
function getAdjustInfo(){
			document.URL='getAdjustInfo.do?method=getAdjustInfo'
}
</script>
<body>
<table  style="width:100%" border=0>
	<tr><td>
<div id="hidden_div">
  <table width="100%"  border="0" cellspacing="0" cellpadding="0">
	<tr>
	  <td height="150" class="hidden_div">&nbsp;</td>
	</tr>
	<tr>
	  <td align="center" class="text">��ȴ�...ϵͳ���ڳ�ʼ���������ݣ�</td>
	</tr>
  </table>
</div>
<div id="hidden_div1" style="display:none">
  <table width="100%"  border="0" cellspacing="0" cellpadding="0">
	<tr>
	  <td height="150">&nbsp;</td>
	</tr>
	<tr>
	  <td align="center" class="text">��������׼����ϣ��Ƿ�ʼ���ꣿ</td>
	</tr>
	<tr>
	  <td align="center" class="text">
	  	<input class="input_btn02" type="Submit" name="Submit2"  value="ȷ�ϵ���"  onclick="confirmAdjust()">
	  	<input class="input_btn02" type="button" name="Submit3" value="�����������" onclick="getAdjustInfo()">	
	  </td>
	</tr>
  </table>
</div>
<iframe src="startAdjust.do?method=startAdjust" style="display:none"/>

	</td></tr>
</table>
</body>