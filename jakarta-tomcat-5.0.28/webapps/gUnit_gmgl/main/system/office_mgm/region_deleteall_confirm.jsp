<%@ page contentType="text/html; charset=GBK" %>
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
<!-- Code for browser detection -->
<script src="../../../script/action.js" language="JScript"></script>
<script src="../../../script/ua1.js"></script>
<script src="../../../script/function.js"></script>

</head>
<script>
	function onsubmit(){
		if(window.confirm('��ȷ��Ҫɾ����Щ��λ��')){
			myform.submit();
		}
	
	}
</script>
<body bgcolor="#FFFFFF" text="#000000" leftmargin="0" topmargin="0" scroll="no" onload="f_resize_main_span()" onresize="f_resize_main_span()">
<span id="_main_Span" style="width:100%;overflow:auto">

<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table_template" id="_main_table">

  <tr> 
    <td valign="top"> 
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table7">
        <tr> 
          <td width="49%" height="17"><font color="#000000"><strong>��ȷ��Ҫɾ�����е�λ��</strong></font> 
          </td>
          <td width="51%" align="right">
<table width="300" border="0" cellpadding="0" cellspacing="0">
              <tr class="td16"> 
                <td width="60" class="td16">&nbsp;</td>
                <td width="60" class="td16">&nbsp;</td>
                <td width="60" class="td16">&nbsp; </td>
                <td width="60" class="td16">��<a href="javascript:onsubmit();">ȷ��</a>��</td>
								<td width="60" class="td16">��<a href="javascript:history.back()">ȡ��</a>��</td>

              </tr>
            </table>
          </td>
        </tr>
      </table>
<form action="regionDeleteAll.do?action=deleteAll" name="myform" method="post">             
      <table width="100%" border="0" cellpadding="1" class="ConfigTable">
        <tr class="tr2"> 
          <td width="15%" class="tr2">������</td>
          <td width="19%" class="tr2">��������</td>
          <td width="20%" class="tr2">��������</td>
          <td width="46%" class="tr2">����</td>
        </tr>
        <% int i = 1; %>
        <c:forEach var="region" items="${regionList}" >
			<% if (i++ % 2 == 1) {%>
        <tr class="tr1" >
			<% } else {%>
        <tr class="tr3" >
			<% }%>  
	  	<input name="ids" type="hidden" value="<c:out value="${region.id}"/>">			
         <td width="15%" height="21"><c:out value="${region.num}" /></td>
          <td width="19%"><font color="#000000"><a href="regionSelect.do?action=detail&id=<c:out value="${region.id}"/>"><c:out value="${region.name}" /></a></font></td>
          <td width="20%"><fmt:formatDate value="${region.createdate}" pattern="yyyy-MM-dd" /></td>
          <td width="46%"><font color="#000000"><c:out value="${region.description}" /></font></td>
        </tr>
        </c:forEach>           
      </table>
</form>       
    </td>
  </tr>
  <tr class="tr2"> 
    <td height="32" align="left"><font color="#FF0000">���棺���������������ɾ��������ɾ�������������� 
      <br>
      ������ʹ��<a href="regionMove.do?action=showMove">�ƶ�����</a>���ܽ������������Ƶ��������� 
      Ȼ���ٽ���ɾ��������</font>&nbsp; </td>
  </tr>
</table>
</body>
</html>
