<%@ page contentType="text/html; charset=GBK" %>
<%@ include file="../../../common/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
<title>政策参数设置</title>
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
	if(confirm('确认调标后，系统自动对相关救助对象进行变更，是否确认调标？'	)){
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
	  <td align="center" class="text">请等待...系统正在初始化调标数据！</td>
	</tr>
  </table>
</div>
<div id="hidden_div1" style="display:none">
  <table width="100%"  border="0" cellspacing="0" cellpadding="0">
	<tr>
	  <td height="150">&nbsp;</td>
	</tr>
	<tr>
	  <td align="center" class="text">调标数据准备完毕，是否开始调标？</td>
	</tr>
	<tr>
	  <td align="center" class="text">
	  	<input class="input_btn02" type="Submit" name="Submit2"  value="确认调标"  onclick="confirmAdjust()">
	  	<input class="input_btn02" type="button" name="Submit3" value="参数调整情况" onclick="getAdjustInfo()">	
	  </td>
	</tr>
  </table>
</div>
<iframe src="startAdjust.do?method=startAdjust" style="display:none"/>

	</td></tr>
</table>
</body>