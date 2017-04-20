<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib uri="/WEB-INF/tld/gTaglib-gOS.tld" prefix="gOS" %>
<%@ taglib uri="/WEB-INF/tld/topsuntech-tree.tld" prefix="topsuntech" %>
<%@page import="com.topsuntech.gOS.user.session.*" %>
<%@page import="com.topsuntech.gOS.user.en.user.*" %>
<html>
<head>
<title>Untitled Document</title>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<gOS:skin />
<script src="../../../script/action.js" language="JScript"></script>
<script src="../../../script/toolbar-ie5.js" language="JScript"></script>
<link href="../../../script/toolbar-ie5.css" type="text/css" rel="stylesheet">
<xml id="xsl" src="../../../script/toolbar-ie5.xsl"></xml>

<script src="../../../script/ua.js"></script>
<script src="../../../script/function.js"></script>
<!-- Link Tigra Hints script file to your HTML document-->
<script language="JavaScript" src="../../../script/hints.js"></script>
<!-- Link Tigra Hints configuration file to your HTML document-->
<script language="JavaScript" src="../../../script/hints_cfg.js"></script>
</head>

<%
	User user = UserSession.getUser(request);
	String deptid = "" + user.getDeptid();
%>
<body bgcolor="#FFFFFF" text="#000000" leftmargin="0" topmargin="0" scroll="no" onload="f_resize_main_span()" onresize="f_resize_main_span()">
<span id="_main_Span" style="width:100%;overflow:auto">
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table11">
  <tr> 
    <td height="20" align="right">&nbsp;</td>
  </tr>
</table>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table_template" id="_main_table">
  <tr> 
    <td valign="top"> 
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table7">
        <tr> 
          <td height="17">  
          </td>
        </tr>
      </table>


      <form action="userDeleteAll.do?action=deleteAllConfirm" name="myform" method="post">        	
      <input type="hidden" name="actionType" value="">      
      <input type="hidden" name="prioritys">
     
      <table width="100%" border="0" cellpadding="1" class="ConfigTable">
        <tr class="tr2"> 
          <td width="15%" class="tr2"><font face="宋体">所属部门</font></td>
          <td width="10%" class="tr2"><font face="宋体">ID</font></td>
          <td width="15%" class="tr2">姓名</td>
          <td width="5%" class="tr2">性别</td>
          <td width="10%" class="tr2">职务</td>
          <td width="10%" class="tr2">出生年月</td>
          <td width="15%" class="tr2">审批情况</td>
          <td width="15%" class="tr2">删除原因</td>
          <td width="10%" class="tr2">操作</td>
        </tr>
        <% int i = 1; %>
        <c:forEach var="user" items="${userList}" >
			<% if (i++ % 2 == 1) {%>
        <tr class="tr1" >
			<% } else {%>
        <tr class="tr3" >
			<% }%>

          <td><a href="../office_mgm/officeSelect.do?action=detail&id=<c:out value="${user.deptid}"/>"><c:out value="${user.deptname}"/></a></td>
          <td><a href="userSelect.do?action=detail&id=<c:out value="${user.id}"/>"><c:out value="${user.loginid}" /></a></td>
          <td><c:out value="${user.name}" /></td>
          <td><c:out value="${user.gender}"/></td>
          <td><c:out value="${user.callname}"/></td>
          <td><font color="#000000"><fmt:formatDate value="${user.birthday}" pattern="yyyy-MM-dd" /></font></td>
          <td>
          	<topsuntech:registStatus> 
          		<c:out value="${user.registstatus}"/>
          	</topsuntech:registStatus> 	
          </td>
          
          <td><c:out value="${user.deletereason}"/></td>
           
          <td width="18%">
          	<a href="delSelect.do?action=comeBackByDept&id=<c:out value="${user.id}"/>">恢复</a>
          </td>
        </tr>
        </c:forEach>        
      </table>
      </form>
    </td>
  </tr>
  <tr class="tr2"> 
    <td align="left">

    </td>
  </tr>
  <tr> 
    <td align="left" valign="bottom"> 
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table7">	      
        <tr>    
          <td width="55%" valign="bottom"> 
            <gOS:page name="test1" action="delSelect.do?action=listByDeptId" pageName="dataPage" pageSizeKey="list"> 
            <gOS:param name="deptid" value="<%=deptid%>" /> 
            </gOS:page> </td>
        </tr>
      </table>
    </td>
  </tr>
</table>
</span>
</body>
</html>
