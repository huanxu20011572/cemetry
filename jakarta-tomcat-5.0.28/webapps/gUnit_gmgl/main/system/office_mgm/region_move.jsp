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
<script src="../../../script/ua1.js"></script>
</head>
<script language="JavaScript">
function onSubmit(){
	var IsValid=true;
	if(myform.parent.value==""){
		document.all("srclbl").innerHTML="<font color=\"ff0000\">请选择区域</font>";
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
          <td width="0%" height="20">&nbsp; </td>
          <td width="54%" height="20" align="left"><strong>移动区域(*为必填项)：<font color="ff0000"><html:errors/></font></strong></td>
          <td width="46%" align="right"><table width="300" border="0" cellpadding="0" cellspacing="0">
              <tr class="td16"> 
                <td width="60" class="td16">&nbsp;</td>
                <td width="60" class="td16">&nbsp;</td>
                <td width="60" class="td16">&nbsp; </td>
                <td width="60" class="td16">【<a href="javascript:onSubmit();">确定</a>】</td>
				<td width="60" class="td16">【<a href="javascript:history.back()">取消</a>】</td>

              </tr>
            </table></td>
        </tr>
      </table>
      <table width="100%" border="0" class="table5">
        <tr> 
          <td width="46%" height="18">&nbsp;</td>
          <td width="54%" align="right">创建人：<c:out value="${creatorName}" /> 创建日期：<fmt:formatDate value="${region.createdate}" pattern="yyyy-MM-dd" /></td>
        </tr>
      </table>
<form action="regionMove.do?action=move" name="myform" method="post">      
	<input type="hidden" name="id" value="<c:out value="${region.id}"/>">	
	<input type="hidden" name="errpage" value="moveToError">
        <table width="100%" border="0" cellpadding="1" cellspacing="1" class="table_main">
          <tr> 
            <td width="25%" height="22" class="td22">新的上级区域*：</td>
          <td width="75%" height="22" class="td23"> 
            <input name="parent" type="text" value="" readonly>
            <input type="hidden" name="parentid" value="">
            <a href="javascript:windowWithoutToolbar('regionSelect.do?action=choose&inputBox=parent', 400, 600)"><img src="../../../images/config/zoom_small.gif" width="13" height="13" border="0"></a> <font color="#0000ff">单击前面的图标选择区域</font>
            <label name="srclbl" id="srclbl"></label>
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
          <td height="22" class="td22">区域编号：</td>
          <td width="36%" height="22" class="td23"><c:out value="${region.num}"/></td>
          <td width="14%" height="22" class="td22">区域名称：</td>
          <td width="35%" height="22" class="td23"><c:out value="${region.name}"/></td>
        </tr>
        <tr> 
          <td height="22" class="td22">区域属性：</td>
          <td height="22" class="td23"></td>
          <td class="td22">区域级别：</td>
          <td class="td23"><c:out value="${region.level}"/></td>
        </tr>
        <tr> 
          <td height="60" class="td22">区域描述：</td>
          <td height="60" colspan="3" class="td23"><c:out value="${region.description}"/></td>
        </tr>
      </table>
      <br>
      <br>

      
    </td>
  </tr>
</table>
</body>
</html>
