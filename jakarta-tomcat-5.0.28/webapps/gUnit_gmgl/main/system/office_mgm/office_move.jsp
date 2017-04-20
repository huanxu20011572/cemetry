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
<gOS:skin />
<script src="../../../script/ua.js"></script>
<link href="../../../css/css.css" rel="stylesheet" type="text/css">
</head>
<script language="JavaScript">
function onSubmit(){
	var IsValid=true;
	if(myform.parent.value==""){
		document.all("srclbl").innerHTML="<font color=\"ff0000\">请选择单位</font>";
		IsValid=false;
	}else{
		document.all("srclbl").innerHTML="";
	}
	if(IsValid)
	myform.submit()
}
</script>
<body bgcolor="#FFFFFF" text="#000000" leftmargin="0" topmargin="0">

<table width="100%" border="0" align="right" cellpadding="0" cellspacing="0" class="table10">
  <tr> 
       
    <td align="right" valign="top" class="td18"> 
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table7">
        <tr> 
          <td width="0%" height="20" class="list_title">&nbsp; </td>
          <td width="54%" height="20" align="left" class="list_title"><table width="300" border="0" cellpadding="0" cellspacing="0">
            <tr class="td16">
              <td width="60" class="td16"><label>
              <input name="Submit" type="button" class="input_btn" onClick="onSubmit();" value="提交">
</label></td>
              <td width="60" class="td16"><label>
                <input name="Submit2" type="button" onclick="javascript:history.back();" class="input_btn" value="取消">
              </label></td>
              <td width="60" class="td16">&nbsp;</td>
              <td width="60" class="td16">&nbsp;</td>
              <td width="60" class="td16">&nbsp;</td>
            </tr>
          </table>
          </td>
          <td width="46%" align="right" class="list_title"><strong>移动单位(*为必填项)：<font color="ff0000">
            <html:errors/>
            </font></strong></td>
        </tr>
      </table>
      <table width="100%" border="0" class="table5">
        <tr> 
          <td width="46%" height="18">&nbsp;</td>
          <td width="54%" align="right">创建人：<c:out value="${creatorName}" /> 创建日期：<fmt:formatDate value="${office.createdate}" pattern="yyyy-MM-dd" /></td>
        </tr>
      </table>
<form action="officeMove.do?action=move" name="myform" method="post">      
	<input type="hidden" name="officeid" value="<c:out value="${office.id}"/>">	
	<input type="hidden" name="errpage" value="moveToError">
        <table width="100%" border="0" cellpadding="1" cellspacing="1" class="table_main">
          <tr> 
            <td width="25%" height="22" class="td22">新的上级单位*：</td>
          <td width="75%" height="22" class="td23"> 
            <input name="parent" type="text" value="" readonly>
            <input type="hidden" name="parentid" value="">
            <a href="javascript:windowWithoutToolbar('officeSelect.do?action=choose', 400, 600)"><img src="../../../images/config/zoom_small.gif" width="13" height="13" border="0"></a> <font color="#0000ff">单击前面的图标选择单位</font>
            <label name="srclbl" id="srclbl"></label>
          </td>
        </tr>
          <tr> 
            <td width="25%" height="22" class="td22">单位属性*：</td>
          <td width="75%" height="22" class="td23">
          <topsuntech:officeCat>
          <c:out value="${office.cat}"/>
          </topsuntech:officeCat>          
          </td>
        </tr>
      </table>
</form>     
      <br>
      <br>
      <table width="100%" border="0" cellpadding="1" cellspacing="1" class="table_main">
        <tr> 
          <td width="15%" height="22" class="td22">上级单位：</td>
          <td height="22" colspan="3" class="td23"> <c:out value="${parent}"/> </td>
        </tr>
        <tr height="22" > 
          <td height="22" class="td22">单位编号：</td>
          <td width="36%" height="22" class="td23"><c:out value="${office.num}"/></td>
          <td width="14%" height="22" class="td22">单位名称*：</td>
          <td width="35%" height="22" class="td23"><c:out value="${office.name}"/></td>
        </tr>
        <tr> 
          <td height="22" class="td22">单位属性：</td>
          <td height="22" class="td23"><c:out value="${office.cat}"/></td>
          <td class="td22">单位级别*：</td>
          <td class="td23"><c:out value="${level}"/></td>
        </tr>
        <tr> 
          <td height="60" class="td22">单位描述：</td>
          <td height="60" colspan="3" class="td23"><c:out value="${office.description}"/></td>
        </tr>
      </table>
      <br>
      <br>

      
    </td>
  </tr>
</table>
</body>
</html>
