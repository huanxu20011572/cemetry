<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib uri="/WEB-INF/tld/gTaglib-gOS.tld" prefix="gOS" %>
<html>
<head>
<title>Untitled Document</title>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<gOS:skin />
<script src="../../../script/ua.js"></script>
<script language="JavaScript">
<!--



function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}
//-->
function onSubmit(){
	var IsValid=true;
	if(myform.sourceid.value==""){
		document.all("srclbl").innerHTML="<font color=\"ff0000\">请选择单位</font>";
		IsValid=false;
	}else{
		document.all("srclbl").innerHTML="";
	}
	if(myform.destid.value==""){
		document.all("destlbl").innerHTML="<font color=\"ff0000\">请选择单位</font>";
		IsValid=false;
	}else{
		document.all("destlbl").innerHTML="";
	}
	if(IsValid)
	myform.submit()
}
function doCancle(){
	myform.action="officeSelect.do?action=list";
	myform.submit();
}
</script>
<link href="../../../css/css.css" rel="stylesheet" type="text/css">
</head>

<body bgcolor="#FFFFFF" text="#000000" leftmargin="0" topmargin="0">

<table width="101%" border="0" align="right" cellpadding="0" cellspacing="0" class="table10">
  <tr> 
       
    <td width="100%" height="245" align="right" valign="top" class="td18"> 
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table7">
        <tr> 
          <td width="0%" height="20" class="list_title">&nbsp; </td>
          <td height="20" align="left" class="list_title"><strong>移动用户(*为必填项)</strong></td>
        </tr>
      </table>
      <table width="100%" border="0" class="table5">
        <tr> 
          <td width="46%" height="18">第1步：选择单位</td>
          <td width="54%" align="right">&nbsp;</td>
        </tr>
      </table>
      <form action="userMove.do?action=showAll" name="myform" method="post">      	  
        <table width="100%" border="0" cellpadding="1" cellspacing="1" class="table_main">
          <tr> 
            <td width="46%" height="22" class="td22"><div align="right">原始单位名称*：</div></td>
          <td width="54%" height="22" class="td23">
            <input readonly name="source" type="text" value=""> 
            <input name="sourceid" type="hidden" >
            <a href="javascript:windowWithoutToolbar('officeSelect.do?action=choose&inputBox=source', 400, 600)"><img src="../../../images/config/zoom_small.gif" width="13" height="13" border="0"></a> <font color="#0000ff">单击前面的图标选择单位</font>
            <label name="srclbl" id="srclbl"></label>          </td>
        </tr>
          <tr> 
            <td width="46%" height="22" class="td22"><div align="right">目的单位名称*：</div></td>
          <td width="54%" height="22" class="td23">
          <input readonly name="dest" type="text" value=""> 
          <input name="destid" type="hidden">          
            <a href="javascript:windowWithoutToolbar('officeSelect.do?action=choose&inputBox=dest', 400, 600)"><img src="../../../images/config/zoom_small.gif" width="13" height="13" border="0"></a> <font color="#0000ff">单击前面的图标选择单位</font>
            <label name="destlbl" id="destlbl"></label>          </td>
        </tr>
      </table>
        <table width="200" border="0" align="center">
          <tr>
            <td width="55"><input name="Submit" type="submit" class="input_btn" value="提交" onclick="javascript:onSubmit();"></td>
            <td width="87"><input name="Submit2" type="submit" class="input_btn" value="取消" onClick="doCancle();"></td>
          </tr>
        </table>
        <p>&nbsp;</p>
      </form>    </td>
  </tr>
  <tr>
    <td align="right" valign="top" class="td18">&nbsp;</td>
  </tr>
</table>
</body>
</html>
