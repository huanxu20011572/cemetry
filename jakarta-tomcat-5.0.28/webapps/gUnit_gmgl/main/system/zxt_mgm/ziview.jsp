<%@ page contentType="text/html; charset=GBK" %>
<%@ include file="../../../common/taglibs.jsp"%>
<%@ taglib uri="/WEB-INF/tld/topsuntech-tree.tld" prefix="topsuntech" %>
<link href="../../css/css.css" rel="stylesheet" type="text/css">
<html>
<head>
<title>��ѡ����Ա</title>
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
<span id="_main_Span" style="width:100%;overflow:auto">

<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="11" height="31" valign="top" class="td-bg"><img src="../../../images/right-1.jpg" /></td>
    <td align="center" valign="top" ><table width="100%" border="0" cellpadding="0" cellspacing="0" class="word-8">
      <tr>
        <td height="31" align="left" valign="middle" style="background:url(../../../images/right-3.jpg)"><img src="../../../images/right-4.jpg" width="9" height="8" align="absmiddle" /> ��ǰλ�� &gt; ��ϵͳ���� &gt; �ӹ���Ա����</td>
      </tr>
    </table>
	</td>
  </tr>
  <tr>
    <td >&nbsp;</td>
    <td valign="top">
	<table border="0" cellspacing="0" cellpadding="0" width="100%">
		<tr>
			<td>&nbsp;</td>
		</tr>		
	</table>
<table id="_main_table" width="100%" border="0" cellpadding="0" cellspacing="0" class="table_template">
  <tr> 
    <td valign="top"> 
    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table7">
    
        <tr>
 	  <td width="600" align="left">
				�鿴��ϸ��Ϣ
	  </td>
	  <td align="right">
	  	  ��<a href="javascript:history.back()">����</a>��
	  </td>
        </tr>

      </table>

      <form action="UserextCreate.do?action=finish" name="myform" method="post">  
      <table width="100%" border="0" cellpadding="1" cellspacing="1" class="table_main">
      	<tr>
      		<td>
      			����Ա��Ϣ:
      		</td>
      	</tr>
      </table>
       <TABLE type="grid" border="0"  style="table-layout:fixed;"    name= "listTable" id = "listTable" cellpadding="1" cellspacing="1" bgcolor="a8d1eb"> 								
	     	
	       <tr>
	       	<td width="15%" height="22" class="td-01">�û�ID��</td>
	       	<td class="td-02"><c:out value="${user.loginid}" /></td>
	       </tr>
	       <tr>
	       	<td class="td-01">������</td><td class="td-02"><c:out value="${user.name}" /></td>
	       </tr>
	       <tr>
	       	<td class="td-01">�������ţ�</td><td class="td-02"><!-- <a href="../office_mgm/officeSelect.do?action=detail&id=<c:out value="${user.deptid}"/>"> --><c:out value="${user.deptname}"/><!-- </a> --></td>
	       </tr>
	       <tr>
	       	<td class="td-01">�Ա�</td><td class="td-02"><c:out value="${user.gender}"/></td>
	       </tr>
	       <tr>
	       	<td class="td-01">�����ˣ�</td><td class="td-02"><c:out value="${user.creatorname}"/></td>
	       </tr>
       </table>
      <br>
      
      <table width="100%" border="0" cellpadding="1" cellspacing="1" class="table_main">
      	<tr>
      		<td>
      			����Ͻ�Ĳ���:
      		</td>
      	</tr>
      </table>
       
    <TABLE type="grid" border="0"  style="table-layout:fixed;"    name= "listTable" id = "listTable" cellpadding="1" cellspacing="1" bgcolor="a8d1eb"> 								
	     	
        <tr class="tr2"> 
          <td class="td-01"><font face="����">��������</font></td>
          <td class="td-01"><font face="����">���ű��</font></td>
          <td class="td-01">���ż��</td>   
          <td class="td-01">����ʱ��</td>    
        </tr>
        <% int i = 1; %>
        <c:forEach var="office" items="${officeList}" >
				<% if (i++ % 2 == 1) {%>
        <tr class="td-02" >
				<% } else {%>
        <tr class="td-02" >
				<% }%>
          <td class="td-02"><c:out value="${office.name}" /></td>
          <td class="td-02"><c:out value="${office.num}"/></td>
          <td class="td-02"><c:out value="${office.shortname}"/></td>
          <td class="td-02"><font color="#000000"><fmt:formatDate value="${office.createdate}" pattern="yyyy-MM-dd" /></font></td>          
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
      			��ӵ�е�Ȩ����:
      		</td>
      	</tr>
      </table>
       
       <TABLE type="grid" border="0"  style="table-layout:fixed;"    name= "listTable" id = "listTable" cellpadding="1" cellspacing="1" bgcolor="a8d1eb"> 								
	  
        <tr class="tr2"> 
          <td class="td-01"><font face="����">Ȩ�ޱ�ʶ</font></td>
          <td class="td-01"><font face="����">Ȩ������</font></td>
          <td class="td-01">Ȩ������</td>   
          <td class="td-01">·��(url)</td>    
        </tr>
        <%i = 1; %>
        <c:forEach var="gunit" items="${priList}" >
				<% if (i++ % 2 == 1) {%>
        <tr class="td-02" >
				<% } else {%>
        <tr class="td-02" >
				<% }%>
          <td class="td-02"><c:out value="${gunit.privilege_id}" /></td>
          <td class="td-02"><c:out value="${gunit.name}"/></td>
          <td class="td-02"><c:out value="${gunit.description}"/></td>
          <td class="td-02"><c:out value="${gunit.url}"/></td>
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
</td>
  </tr>
</table>
</span>
</body>
</html>
