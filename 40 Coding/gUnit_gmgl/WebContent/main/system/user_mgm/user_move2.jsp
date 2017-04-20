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

function moveOptions(optionsOut,optionsIn) {
 var dump= new Array();
 for (var i=0; i < optionsOut.length; i++) {
   if (optionsOut.options[i].selected) {
     optionsIn.options[optionsIn.length]= new Option(optionsOut.options[i].text, optionsOut.options[i].value);
     dump[dump.length]= optionsOut.options[i].text;
   }
 }
 for (var i=0; i < dump.length; i++) {
   for (var j=0; j < optionsOut.length; j++) {
     if (optionsOut.options[j].text == dump[i]) {
       optionsOut.options[j]= null;
     }
   }
 }
}
function onSubmit(){
   for(var i=0;i<myform.srcSelect.length;i++){
   	myform.srcSelect.options[i].selected=true;
   }
   for(var i=0;i<myform.destSelect.length;i++){
   	myform.destSelect.options[i].selected=true;
   }
   myform.submit();
}
//-->
</script>
</head>

<body bgcolor="#FFFFFF" text="#000000" leftmargin="0" topmargin="0">
<table width="100%" border="0" align="right" cellpadding="0" cellspacing="0" class="table10">
  <tr> 
    <td align="right" valign="top" > 
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table7">
        <tr> 
          <td width="0%" height="20">&nbsp; </td>
          <td width="54%" height="20" align="left"><strong>移动用户</strong></td>
          <td width="46%" align="right"><table width="300" border="0" cellpadding="0" cellspacing="0">
              <tr class="td16"> 
                <td width="60" class="td16">&nbsp;</td>
                <td width="60" class="td16">&nbsp;</td>
                <td width="60" class="td16">&nbsp; </td>
                <td width="60" class="td16">【<a href="javascript:onSubmit();">确定</a>】</td>
                <td width="60" class="td16">【<a href="javascript:history.back();">取消</a>】</td>
              </tr>
            </table></td>
        </tr>
      </table>
      <table width="100%" border="0" class="table5">
        <tr> 
          <td width="46%" height="18">第1步：移动用户</td>
          <td width="54%" align="right">&nbsp;</td>
        </tr>
      </table>
      <form  action="userMove.do?action=move" method="post" name="myform">
        <table width="100%" border="0" cellpadding="1" cellspacing="1" class="table_main">
          <tr> 
            <td width="40%" height="151" valign="top" class="td22"> <br>
            <table width="40%" border="0">
              <tr>
                <td align="center"><a href="detail_office.htm"><c:out value="${srcDept}"/></a></td>
                <input type="hidden" value="<c:out value="${srcDept}"/>" name="srcDept">
              </tr>
              <tr>
                <td align="center">
		  <select name="srcSelect" size="10" multiple>	
		  <c:forEach var="user" items="${userList1}" >
                   <option value="<c:out value="${user.id}"/>"><c:out value="${user.loginid}"/></option>
                   </c:forEach> 	                                      
                  </select></td>
              </tr>
            </table>
            
          </td>
            <td width="18%" align="center" class="td_forum"> 
              <table width="75%">
              <tr> 
                <td>&nbsp;</td>
              </tr>
              <tr> 
                <td><div align="center"> 
                    <input type="button" name="b1" value="&lt;&lt;" onClick="moveOptions(this.form.destSelect,this.form.srcSelect)">
                  </div></td>
              </tr>
              <tr> 
                <td><div align="center"> 
                    <input type="button" name="b2" value="&gt;&gt;" onClick="moveOptions(this.form.srcSelect,this.form.destSelect)">
                  </div></td>
              </tr>
              <tr> 
                <td>&nbsp;</td>
              </tr>
            </table></td>
            <td width="42%" valign="top" class="td23"> <br>
            <table width="40%" border="0">
              <tr> 
                <td align="center"><a href="detail_office.htm"><c:out value="${destDept}"/></a></td>
                <input type="hidden" value="<c:out value="${destDept}"/>" name="destDept">
              </tr>
              <tr> 
                <td align="center"> <select name="destSelect" size="10" multiple > 
                   <c:forEach var="user" items="${userList2}" >
                   <option value="<c:out value="${user.id}"/>"><c:out value="${user.loginid}"/></option>
                   </c:forEach> 	                    
                  </select></td>
              </tr>
            </table> </td>
        </tr>
      </table>
      </form>
      <br>
    </td>
  </tr>
  <tr>
    <td align="left" valign="top" class="td18"><font color="#FF0000">如果用户数量不多，就直接用两个list移动；如果用户多，就提供查询移动的功能。 
      这个要做到自动配置之中。</font> </td>
  </tr>
  <tr>
    <td align="left" valign="bottom" class="td18"> 
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table7">
        <tr> 
          <td height="20" valign="bottom">&nbsp;<img src="../../../images/config/moveUp.gif" width="16" height="16"><a href="#">上一页</a> 
            <img src="../../../images/config/moveDown.gif" width="16" height="16"><a href="#">下一页</a> 
            <img src="../../../images/config/goto.gif" width="16" height="16"> 跳转至： 
            <input type="text" name="textfield">
          </td>
        </tr>
      </table>
      
    </td>
  </tr>
</table>
</body>
</html>
