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
<script src="../../../script/ua.js"></script>
<script src="../../../script/function.js"></script>

<link href="../../../css/css.css" rel="stylesheet" type="text/css">
</head>
<script>
	function onsubmit(){
		if(window.confirm('��ȷ��Ҫɾ����Щ��λ��')){
			myform.submit();
		}
	
	}
	function doCancel(){
		myform.action = "officeSelect.do?action=list";
		myform.submit();
	}
</script>
<body bgcolor="#FFFFFF" text="#000000" leftmargin="0" topmargin="0" scroll="no" onLoad="f_resize_main_span()" onResize="f_resize_main_span()">
<span id="_main_Span" style="width:100%;overflow:auto">

<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table_template" id="_main_table">

  <tr> 
    <td valign="top"> 
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list_toolbar">
        <tr> 
          <td height="17"><font color="#000000"><strong>��ȷ��Ҫɾ�����е�λ��</strong></font>          </td>
        </tr>
      </table>
<form action="officeDeleteAll.do?action=deleteAll" name="myform" method="post">             
      <table width="100%" border="0" cellpadding="1" cellspacing="1" class="table1">
        <tr> 
          <td width="15%" class="list_title"><div align="center">��λ���</div></td>
          <td width="19%" class="list_title"><div align="center">��λ����</div></td>
          <td width="20%" class="list_title"><div align="center">��������</div></td>
          <td width="46%" class="list_title"><div align="center">����</div></td>
        </tr>
        <% int i = 1; %>
        <c:forEach var="office" items="${officeList}" >
			<% if (i++ % 2 == 1) {%>
        <tr class="tr1" >
			<% } else {%>
        <tr class="tr3" >
			<% }%>  
	  <input name="ids" type="hidden" value="<c:out value="${office.id}"/>">			
          <td width="15%" height="21"><div align="right"><c:out value="${office.num}" /></div></td>
          <td width="19%"><div align="center"><a href="officeSelect.do?action=detail&id=<c:out value="${office.id}"/>"><c:out value="${office.name}"/></div></td>
          <td width="20%"><div align="center"><fmt:formatDate value="${office.createdate}" pattern="yyyy-MM-dd" /></div></td>
          <td width="46%"><div align="center"><c:out value="${office.description}" /></div></td>
        </tr>
        </c:forEach>           
      </table>
      <table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
              <tr >
                <td  align="right">
                	<div align="center">
                	  <input type="button" onClick="onsubmit();" value="ȷ��" class="input_btn"/>
                	  <input type="button" onClick="doCancel();" class="input_btn" value="ȡ��"/>			    
           	    </div></td>
			  </tr>
        </table>
</form>       
    </td>
  </tr>
  <tr class="tr2"> 
    <td height="32" align="left"> <font color="#FF0000">���棺�õ�λ�����ӵ�λ���û���ɾ���õ�λ��ɾ���������ӵ�λ���û��� 
      <br>
      ������ʹ��<a href="officeMove.do?action=showMove">�ƶ���λ</a>��<a href="userMove.do?action=showMove">�ƶ��û�</a>���ܽ������ӵ�λ���û��Ƶ�������λ�� 
      Ȼ���ٽ���ɾ��������</font>&nbsp;</td>
  </tr>
</table>
</body>
</html>
