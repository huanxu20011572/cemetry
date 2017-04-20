<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib uri="http://www.topsuntech.com/jsptags/tree-taglib" prefix="topsuntech" %>
<%@ taglib uri="/WEB-INF/tld/gTaglib-gOS.tld" prefix="gOS" %>
<html>
<head>
<title>Untitled Document</title>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<link href="../../../css/css.css" rel="stylesheet" type="text/css">
<script src="../../../script/ua.js"></script>
</head>
<script language="JavaScript">

function onSubmit(){
	var IsValid=true;
	if(myform.office.value==""){
		document.all("srclbl").innerHTML="<font color=\"ff0000\">请选择单位</font>";
		IsValid=false;
	}else{
		document.all("srclbl").innerHTML="";
	}
	if(myform.parent.value==""){
		document.all("destlbl").innerHTML="<font color=\"ff0000\">请选择单位</font>";
		IsValid=false;
	}else{
		document.all("destlbl").innerHTML="";
	}
	if(IsValid)
	myform.submit()
}
</script>
<body bgcolor="#FFFFFF" text="#000000" leftmargin="0" topmargin="0">

<table width="102%" border="0" align="right" cellpadding="0" cellspacing="0">
  <tr> 
       
    <td height="350" align="right" valign="top" class="td18"> 
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table7">
        <tr> 
          <td width="54%" height="20" align="center" class="list_title" ><strong>移动单位(*为必填项)：<font color="ff0000">
          <html:errors/></font></strong></td>
        </tr>
      </table>
      <form action="officeMove.do?action=move" name="myform" method="post">      	
        <input type="hidden" name="errpage" value="moveError">
        <table width="100%" border="0" cellpadding="1" cellspacing="1" class="table1">
          <tr> 
          <td width="45%" height="22" class="td22" align="right">单位名称*：</td>
          <td width="55%" height="22" class="td23">
          <input name="office" type="text" value="" readonly> 
          <input type="hidden" name="officeid" value="">
            <a href="javascript:windowWithoutToolbar('officeSelect.do?action=choose&inputBox=office', 400, 490)"><img src="../../../images/config/zoom_small.gif" width="13" height="13" border="0"></a> <font color="#0000ff">单击前面的图标选择单位</font>
            <label name="srclbl" id="srclbl"></label>
          </td>
        </tr>
          <tr> 
            <td width="45%" height="22" class="td22" align="right">新的上级单位*：</td>
          <td width="55%" height="22" class="td23">
          <input name="parent" type="text" value="" readonly>
          <input type="hidden" name="parentid" value=""> 
            <a href="javascript:windowWithoutToolbar('officeSelect.do?action=choose&inputBox=parent', 410, 490)"><img src="../../../images/config/zoom_small.gif" width="13" height="13" border="0"></a> <font color="#0000ff">单击前面的图标选择单位</font>
            <label name="destlbl" id="destlbl"></label>
          </td>
        </tr>
          <tr> 
            <td width="45%" height="22" class="td22" align="right">单位属性*：</td>
          <td width="55%" height="22" class="td23" align="left">
          <topsuntech:officeCat>
          职能处室
          </topsuntech:officeCat>          
          </td>
        </tr>
        <tr>
        	<td width="45%" height="46" align="right" class="td16">
                	<input type="button" class="input_btn" value="确定" onClick="onSubmit();"></input>
            </td>
			<td width="55%" class="td16" align="left">
				<input type="button" class="input_btn" value="取消" onClick="javascript:history.back();"></input>
			</td>
        	
        </tr>
      </table>
</form>
      <br>
      <br>

      <br>
      <br>

      
    </td>
  </tr>
</table>
</body>
</html>
