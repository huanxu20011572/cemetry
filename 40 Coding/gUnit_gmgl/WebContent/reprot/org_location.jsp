<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ include file="../common/head.jsp"%>
<link href="<c:url value='/css/css.css'/>" rel="stylesheet" type="text/css">
<script src="<c:url value='/script/ua.js'/>"></script>
<script src="<c:url value='/script/publics.js'/>"></script>
<script src="<c:url value='/script/page.js'/>"></script>
<head>
<title>北京公墓管理系统</title>
<script type="text/javascript">

function autoIframe() {
	var ifm= document.getElementById("iframepage");
	var subWeb = document.frames ? document.frames["iframepage"].document : ifm.contentDocument;
	if(ifm != null && subWeb != null) {
		ifm.height = subWeb.body.scrollHeight;
	}
} 

function doSubmit(){
	var ifm= document.getElementById("iframepage");
	var action = "../reportJsp/showReport.jsp?raq=/org_location.raq";
	action += "&org_id="+$('#deptid').val();
	var code = $("#businessType").val();
	if(code > 0){
		action += "&code="+code;
	}
	ifm.src = action;
}

function selectOffice() {
	var deptid =$('#deptid').val();
 	windowWithoutToolbar("../tree/office_choose.jsp?type=1&idStr=" + deptid, 300, 600, true);
}
function setOffice(win, id, name){
	$('#deptid').val(id);
	$('#dept').val(name);
	win.close();
}

function clearOffice(){
	$('#deptid').val('');
	$('#dept').val('');
}
</script>
</head>
 
<body style="background-color:transparent">
<table width="100%" border="0" cellspacing="0" cellpadding="0" height="100%">
  <tr>
    <td width="11" valign="top" class="td-bg"><img src="../images/right-1.jpg" /></td>
    <td align="center" valign="top" >
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="31" align="left" valign="middle" style="background:url(../images/right-3.jpg)"><img src="../images/right-4.jpg" width="9" height="8" align="absmiddle" /> 当前位置  &gt; 综合统计 &gt; 墓区信息一览</td>
      </tr>
      <tr>
        <td bgcolor="#FFFFFF" style="font-size:12px;">&nbsp;</td>
      </tr>
    </table>
	<table width="98%" cellpadding="0" cellspacing="1" bgcolor="#a6c6da">
          <tr>
              <td align="right" height="35" bgcolor="#D4E5F4">公墓机构：</td>
              <td align="left"   bgcolor="#FFFFFF">
              	<input id="dept" name="dept" height="25"  type="text" readonly value="" size="20" >
				<input id="deptid" name="deptid" type="hidden" value="" />
            	<a href="javascript:" onClick="selectOffice()" title=请选择部门><img src="../images/anniu_1_03.gif" border="0" ></a> 
            	<a href="javascript:" onClick="clearOffice()" title=清除选择部门><img src="../images/anniu_1_05.gif" border="0"></a>
              </td>
              <td align="right" height="35" bgcolor="#D4E5F4">业务分类：</td>
              <td align="left" bgcolor="#FFFFFF">
               	<ft:select name="businessType" type="ywdl" selected="${param.businessType}" style="width:190px"></ft:select>
              </td>
          </tr>
          <tr>
              <td height="35" colspan="4" align="center" bgcolor="#FFFFFF">
                  <input name="button" type="button" onclick="doSubmit();" class="button-z" id="button3" value="查询"/>
              </td>
          </tr>
      </table><br/>
	  <iframe onLoad="autoIframe();" id="iframepage" name="iframepage" frameBorder=0 scrolling=no width="98%" 
      		src="../reportJsp/showReport.jsp?raq=/org_location.raq" ></iframe>
</body>
</html>