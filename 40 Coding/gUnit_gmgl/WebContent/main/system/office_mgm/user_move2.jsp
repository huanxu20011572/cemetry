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
     optionsIn.options[optionsIn.length-1].id=1-optionsOut.options[i].id;
     //alert(optionsIn.options[optionsIn.length-1].id);
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
   vsrcids="";   
   for(var i=0;i<myform.srcSelect.length;i++){
   	if(myform.srcSelect.options[i].id==1)
   	vsrcids+=myform.srcSelect.options[i].value+",";
   	
   }  
   myform.srcids.value=vsrcids;
   vdestids="";
   for(var i=0;i<myform.destSelect.length;i++){
   	if(myform.destSelect.options[i].id==1)
   	vdestids+=myform.destSelect.options[i].value+",";
   }   
   myform.destids.value=vdestids;
   //alert(myform.srcids.value);
   //alert(myform.destids.value);
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
				<td width="60" class="td16">【<a href="officeSelect.do?action=list">取消</a>】</td>

              </tr>
            </table></td>
        </tr>
      </table>
      <table width="100%" border="0" class="table5">
        <tr> 
          <td width="46%" height="18">第2步：移动用户</td>
          <td width="54%" align="right">&nbsp;</td>
        </tr>
      </table>
      <form  action="userMove.do?action=move" method="post" name="myform">
        <table width="100%" border="0" cellpadding="1" cellspacing="1" class="table_main">
          <tr> 
            <td width="40%" height="151" valign="top" class="td22"> <br>
            <table width="40%" border="0">
              <tr>
                <td align="center" class="td1"><a href="../office_mgm/officeSelect.do?action=detail&id=<c:out value="${srcDept}"/>"><c:out value="${srcOffice.name}"/></a></td>
                <input type="hidden" value="<c:out value="${srcDept}"/>" name="srcDept">
              </tr>
              <tr>
                <td align="center">
                  <input name="srcids" type="hidden">
		  <select name="srcSelect" size="10" multiple>			  
		  <c:forEach var="user" items="${userList1}" >
                   <option value="<c:out value="${user.id}"/>" id=0><c:out value="${user.name}"/>(<c:out value="${user.loginid}"/>)</option>
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
                <td align="center" class="td1"><a href="../office_mgm/officeSelect.do?action=detail&id=<c:out value="${destDept}"/>"><c:out value="${destOffice.name}"/></a></td>
                <input type="hidden" value="<c:out value="${destDept}"/>" name="destDept">
              </tr>
              <tr> 
                <td align="center"> 
                <input name="destids" type="hidden">
                <select name="destSelect" size="10" multiple > 
                   <c:forEach var="user" items="${userList2}" >
                   <option value="<c:out value="${user.id}"/>" id=0><c:out value="${user.name}"/>(<c:out value="${user.loginid}"/>)</option>
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
  
</table>
</body>
</html>
