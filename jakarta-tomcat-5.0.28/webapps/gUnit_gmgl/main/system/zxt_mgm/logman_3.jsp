<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib uri="/WEB-INF/tld/gTaglib-gOS.tld" prefix="gOS" %>
<%@ taglib uri="/WEB-INF/tld/topsuntech-tree.tld" prefix="topsuntech" %>
<html>
<head>
<title>���</title>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<gOS:skin />
<script src="../../../script/action.js" language="JScript"></script>
<script src="../../../script/toolbar-ie5.js" language="JScript"></script>
<link href="../../../script/toolbar-ie5.css" type="text/css" rel="stylesheet">
<xml id="xsl" src="../../../script/toolbar-ie5.xsl"></xml>
<script src="../../../script/ua.js"></script>
<script src="../../../script/function.js"></script>
</head>
<style>
	.row	{background: white;}
</style>

<!-- Link Tigra Hints script file to your HTML document-->
<script language="JavaScript" src="../../../script/hints.js"></script>
<!-- Link Tigra Hints configuration file to your HTML document-->
<script language="JavaScript" src="../../../script/hints_cfg.js"></script>
<body bgcolor="#FFFFFF" text="#000000" leftmargin="0" topmargin="0" scroll="no" onload="f_resize_main_span()" onresize="f_resize_main_span()">
<span id="_main_Span" style="width:100%;overflow:auto">

<table id="_main_table" width="100%" border="0" cellpadding="0" cellspacing="0" class="table_template">
  <tr> 
    <td valign="top"> 
    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table7">
    
        <tr>
 	  <td width="600" align="left">
				���
	  </td>
	  <td align="center">
	  ��<a href="javascript:history.back()">��һ��</a>��
	  ��<a href="javascript:myform.submit()">���</a>��
	  ��<a href="UserextCreate.do?action=cancel">ȡ��</a>��
	  </td>
        </tr>

      </table>

      <form action="UserextCreate.do?action=finish" name="myform" method="post">  
      <table width="100%" border="0" cellpadding="1" cellspacing="1" class="table_main">
      	<tr>
      		<td>
      			��ѡ����û��ǣ�
      		</td>
      	</tr>
      </table>
       <table width="100%" border="0" cellpadding="1" cellspacing="1" class="table_main">
       	     	
	       <tr>
	       	<td width="15%" height="22" class="td22">�û�ID��</td>
	       	<td class="td23"><c:out value="${user.loginid}" /></td>
	       </tr>
	       <tr>
	       	<td class="td22">������</td><td class="td23"><c:out value="${user.name}" /></td>
	       </tr>
	       <tr>
	       	<td class="td22">�������ţ�</td><td class="td23"><a href="../office_mgm/officeSelect.do?action=detail&id=<c:out value="${user.deptid}"/>"><c:out value="${user.deptname}"/></a></td>
	       </tr>
	       <tr>
	       	<td class="td22">�Ա�</td><td class="td23"><c:out value="${user.gender}"/></td>
	       </tr>
       </table>
      <br>
      

     <table width="100%" border="0" cellpadding="1" cellspacing="1" class="table_main">
      	<tr>
      		<td>
      			��ѡ���ģ����:
      		</td>
      	</tr>
      </table>
       
      <table width="100%" border="0" cellpadding="1" class="ConfigTable">
        <tr class="tr2"> 
          <td class="tr2"><font face="����">Ȩ�ޱ�ʶ</font></td>
          <td class="tr2"><font face="����">Ȩ������</font></td>
          <td class="tr2">Ȩ������</td>   
          <td class="tr2">·��(url)</td>    
        </tr>
        <% int i = 1; %>
        <c:forEach var="gunit" items="${priList}" >
				<% if (i++ % 2 == 1) {%>
        <tr class="tr1" >
				<% } else {%>
        <tr class="tr3" >
				<% }%>
          <td><c:out value="${gunit.privilege_id}" /></td>
          <td><c:out value="${gunit.name}"/></td>
          <td><c:out value="${gunit.description}"/></td>
          <td><c:out value="${gunit.url}"/></td>
        </tr>
        </c:forEach>        
      </table>

      </form>
    </td>
  </tr>

  <tr> 
    <td align="left" valign="bottom"> 
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table7">	      
        <tr>
     <td>
          </td>
        </tr>
      </table></td>
  </tr>
</table>
</span>
</body>
</html>
