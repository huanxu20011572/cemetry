<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib uri="/WEB-INF/tld/gTaglib-gOS.tld" prefix="gOS" %>
<%@ taglib uri="/WEB-INF/tld/topsuntech-tree.tld" prefix="topsuntech" %>
<html>
<head>
<title>区域部门列表</title>
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


<body bgcolor="#FFFFFF" text="#000000" leftmargin="0" topmargin="0" scroll="no" onload="f_resize_main_span()" onresize="f_resize_main_span()">
<span id="_main_Span" style="width:100%;overflow:auto">
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table11">
  <tr> 
    <td height="20" align="right">&nbsp;</td>
  </tr>
</table>
<table id="_main_table" width="100%" border="0" cellpadding="0" cellspacing="0" class="table_template">
  <tr> 
    <td valign="top"> 
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table7">
        <tr> 
          <td width="90%" height="17">
          	区域部门列表 
		  </td>
		 <td align="center">
		 	【<a href="region_list.jsp">返回</a>】
		 </td>
        </tr>
      </table>
     
      <table width="100%" border="0" cellpadding="1" class="ConfigTable">
        <tr class="tr2"> 
          <td width="40%" class="tr2"><font face="宋体">部门名称</font></td>
          <td width="20%" class="tr2"><font face="宋体">部门编号</font></td>
          <td width="20%" class="tr2">部门简称</td>
          <td width="20%" class="tr2">创建时间</td>

        </tr>
        	<% int i = 1; %>
        <c:forEach var="office" items="${officeList}" >
			<% if (i++ % 2 == 1) {%>
        <tr class="tr1" >
			<% } else {%>
        <tr class="tr3" >
			<% }%>
      
          <td><a href="../office_mgm/officeSelect.do?action=detail&id=<c:out value="${office.id}"/>"><c:out value="${office.name}"/></a></td>
          <td><c:out value="${office.num}" /></td>
          <td><c:out value="${office.shortname}"/></td>
          <td><font color="#000000"><fmt:formatDate value="${office.createdate}" pattern="yyyy-MM-dd" /></font></td>                   
        </tr>
        </c:forEach>        
      </table>

    </td>
  </tr>

  <tr> 
    <td align="left" valign="bottom"> 
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table7">	      
        <tr>
		  <td width="45%" height="16" valign="bottom"> 
  
          </td>

          <td width="55%" valign="bottom">    
          <%
			String id = request.getParameter("id");
			%>      
          <gOS:page name="test" action="regionSelect.do?action=listoffice" pageName="dataPage" pageSizeKey="list">
          <gOS:param name="id" value="<%=id%>" /> 
          </gOS:page>
          </td>
        </tr>
      </table></td>
  </tr>
</table>
</span>
</body>
</html>
