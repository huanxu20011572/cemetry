<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib uri="/WEB-INF/tld/gTaglib-gOS.tld" prefix="gOS" %>
<%@ taglib uri="/WEB-INF/tld/topsuntech-tree.tld" prefix="topsuntech" %>
<link href="../../css/css.css" rel="stylesheet" type="text/css">
<html>
<head>
<title>Untitled Document</title>
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
<body bgcolor="#FFFFFF" text="#000000" leftmargin="0" topmargin="0" scroll="no" onload="f_resize_main_span()" onresize="f_resize_main_span()">
<span id="_main_Span" style="width:100%;overflow:auto">

<table id="_main_table" width="100%" border="0" cellpadding="0" cellspacing="0" class="table_template">
  <tr> 
    <td valign="top"> 
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table7">
        <tr> 
          <td height="17">
          	人员删除情况管理 
		 </td>
        </tr>
      </table>
      <form action="userDeleteAll.do?action=deleteAllConfirm" name="myform" method="post">  
      <input type="hidden" name="actionType" value="">
      <input type="hidden" name="prioritys">
      <TABLE type="grid" border="0"  style="table-layout:fixed;"    name= "listTable" id = "listTable" cellpadding="1" cellspacing="1" bgcolor="a8d1eb"> 
        <tr class="tr2"> 
          <td width="15%" class="td-01"><font face="宋体">所属部门</font></td>
          <td width="10%" class="td-01"><font face="宋体">ID</font></td>
          <td width="15%" class="td-01">姓名</td>
          <td width="5%" class="td-01">性别</td>
          <td width="10%" class="td-01">职务</td>
          <td width="10%" class="td-01">出生年月</td>
          <td width="15%" class="td-01">审批情况</td>
          <td width="15%" class="td-01">删除原因</td>
          <td width="10%" class="td-01">操作</td>
        </tr>
        	<% int i = 1; %>
        <c:forEach var="user" items="${userList}" >
			<% if (i++ % 2 == 1) {%>
        <tr class="td-02" >
			<% } else {%>
        <tr class="td-02" >
			<% }%>
      
          <td class="td-02" ><a href="../office_mgm/officeSelect.do?action=detail&id=<c:out value="${user.deptid}"/>"><c:out value="${user.deptname}"/></a></td>
          <td class="td-02" ><a href="userSelect.do?action=detail&id=<c:out value="${user.id}"/>"><c:out value="${user.loginid}" /></a></td>
          <td class="td-02" ><c:out value="${user.name}" /></td>
          <td class="td-02" ><c:out value="${user.gender}"/></td>
          <td class="td-02" ><c:out value="${user.callname}"/></td>
          <td class="td-02" ><font color="#000000"><fmt:formatDate value="${user.birthday}" pattern="yyyy-MM-dd" /></font></td>          
          <td class="td-02" >
          	<topsuntech:registStatus> 
          		<c:out value="${user.registstatus}"/>
          	</topsuntech:registStatus> 	
          </td>
          <td class="td-02" ><c:out value="${user.deletereason}"/></td>
          <td width="18%" class="td-02" >
			<a href="delSelect.do?action=comeBack&id=<c:out value="${user.id}"/>">恢复</a>
          </td>
          
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

		  <td width="45%" height="16" valign="bottom"> 
        
        </td>

          <td width="55%" valign="bottom">          
          <gOS:page name="test" action="delSelect.do?action=listAll" pageName="dataPage" pageSizeKey="list">
          </gOS:page>
          </td>
        </tr>
      </table></td>
  </tr>
</table>
</span>
</body>
</html>
