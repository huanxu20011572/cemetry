<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib uri="/WEB-INF/tld/gTaglib-gOS.tld" prefix="gOS" %>
<%@ taglib uri="/WEB-INF/tld/topsuntech-tree.tld" prefix="topsuntech" %>
<link href="../../css/css.css" rel="stylesheet" type="text/css">
<html>
<head>
<title>���</title>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">

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
<body bgcolor="#FFFFFF" text="#000000" leftmargin="0" topmargin="0" scroll="no" >
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="11" background="../../../images/images_32.jpg"><img src="../../../images/content_left.gif" width="11" height="51"></td>
    <td height="51" background="../../../images/images_32.jpg"><table width="70%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="22" height="16" align="center"><img src="../../../images/d.gif" width="14" height="14"></td>
          <td valign="bottom"> ��ǰλ�ã������¼���������Ա</td>
      </tr>
    </table>
    </td>
  </tr>
  <tr>
    <td background="../../../images/images_481.jpg">&nbsp;</td>
    <td valign="top">
		<table border="0" >
			<tr>
			<td valign="top">


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
	  ��<a href="UserextDeptCreate.do?action=cancel">ȡ��</a>��
	  </td>
        </tr>

      </table>

      <form action="UserextDeptCreate.do?action=finish" name="myform" method="post">  
      <table width="100%" border="0" cellpadding="1" cellspacing="1" class="table_main">
      	<tr>
      		<td>
      			��ѡ����û��ǣ�
      		</td>
      	</tr>
      </table>
       <TABLE type="grid" border="0"  style="table-layout:fixed;"    name= "listTable" id = "listTable" cellpadding="1" cellspacing="1" bgcolor="a8d1eb"> 
									
       	     	
	       <tr class="td-04">
	       	<td width="15%" height="22" >�û�ID��</td>
	       	<td class="td-02"  height="22"><c:out value="${user.loginid}" /></td>
	       </tr>
	       <tr class="td-04">
	       	<td  height="22">������</td><td class="td-02"  height="22"><c:out value="${user.name}" /></td>
	       </tr>
	       <tr class="td-04">
	       	<td  height="22">�������ţ�</td><td class="td-02"  height="22"><a href="../office_mgm/officeSelect.do?action=detail&id=<c:out value="${user.deptid}"/>"><c:out value="${user.deptname}"/></a></td>
	       </tr>
	       <tr class="td-04">
	       	<td  height="22">�Ա�</td><td class="td-02"  height="22"><c:out value="${user.gender}"/></td>
	       </tr>
       </table>
      <br>
      
      <table width="100%" border="0" cellpadding="1" cellspacing="1" class="table_main">
      	<tr>
      		<td>
      			��ѡ��Ĳ�����:
      		</td>
      	</tr>
      </table>
       
     <TABLE type="grid" border="0"  style="table-layout:fixed;"    name= "listTable" id = "listTable" cellpadding="1" cellspacing="1" bgcolor="a8d1eb"> 
				
        <tr class="td-04"> 
          <td height="22"><font face="����">��������</font></td>
          <td height="22"><font face="����">���ű��</font></td>
          <td height="22">���ż��</td>   
          <td height="22">����ʱ��</td>    
        </tr>
        <% int i = 1; %>
        <c:forEach var="office" items="${officeList}" >
				<% if (i++ % 2 == 1) {%>
        <tr >
				<% } else {%>
        <tr >
				<% }%>
          <td class="td-02"  height="22"><c:out value="${office.name}" /></td>
          <td class="td-02"  height="22"><c:out value="${office.num}"/></td>
          <td class="td-02" height="22"><c:out value="${office.shortname}"/></td>
          <td class="td-02" height="22"><font color="#000000"><fmt:formatDate value="${office.createdate}" pattern="yyyy-MM-dd" /></font></td>          
        </tr>
        </c:forEach>        
      </table>
     <br>
     <%
     		if(request.getAttribute("priList") != null){
     %>
     <table width="100%" border="0" cellpadding="1" cellspacing="1" class="table_main">
      	<tr>
      		<td>
      			��ѡ���Ȩ����:
      		</td>
      	</tr>
      </table>
       
     <TABLE type="grid" border="0"  style="table-layout:fixed;"    name= "listTable" id = "listTable" cellpadding="1" cellspacing="1" bgcolor="a8d1eb"> 
				
        <tr class="td-04"> 
          <td  height="22"><font face="����">Ȩ�ޱ�ʶ</font></td>
          <td  height="22"><font face="����">Ȩ������</font></td>
          <td  height="22">Ȩ������</td>   
          <td  height="22">·��(url)</td>    
        </tr>
        <% i = 1; %>
        <c:forEach var="gunit" items="${priList}" >
				<% if (i++ % 2 == 1) {%>
        <tr  >
				<% } else {%>
        <tr  >
				<% }%>
          <td class="td-02" height="22"><c:out value="${gunit.privilege_id}" /></td>
          <td class="td-02" height="22"><c:out value="${gunit.name}"/></td>
          <td class="td-02" height="22"><c:out value="${gunit.description}"/></td>
          <td class="td-02" height="22"><c:out value="${gunit.url}"/></td>
        </tr>
        </c:forEach>        
      </table>
      <%
      	}
      %>
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
    </td>
  </tr>
 </table> 
</body>
</html>
