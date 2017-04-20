<%@ page contentType="text/html; charset=GBK" %>
<%@ include file="../../../common/taglibs.jsp"%>
<%@ taglib uri="/WEB-INF/tld/topsuntech-tree.tld" prefix="topsuntech" %>
<link href="../../css/css.css" rel="stylesheet" type="text/css">
<html>
<head>
<title>完成</title>
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
<body bgcolor="#FFFFFF" text="#000000" leftmargin="0" topmargin="0" scroll="no">
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="11" height="31" valign="top" class="td-bg"><img src="../../../images/right-1.jpg" /></td>
    <td align="center" valign="top" ><table width="100%" border="0" cellpadding="0" cellspacing="0" class="word-8">
      <tr>
        <td height="31" align="left" valign="middle" style="background:url(../../../images/right-3.jpg)"><img src="../../../images/right-4.jpg" width="9" height="8" align="absmiddle" /> 当前位置 &gt; 子系统管理 &gt; 子管理员管理</td>
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
				完成
	  </td>
	  <td align="center">
	  【<a href="javascript:history.back()">上一步</a>】
	  【<a href="javascript:myform.submit()">完成</a>】
	  【<a href="UserextNewCreate.do?action=cancel">取消</a>】
	  </td>
        </tr>

      </table>

      <form action="UserextNewCreate.do?action=finish" name="myform" method="post">  
      <table width="100%" border="0" cellpadding="1" cellspacing="1" class="table_main">
      	<tr>
      		<td>
      			您选择的用户是：
      		</td>
      	</tr>
      </table>
       <TABLE type="grid" border="0"  style="table-layout:fixed;"    name= "listTable" id = "listTable" cellpadding="1" cellspacing="1" bgcolor="a8d1eb"> 
									
       	     	
	       <tr class="td-04">
	       	<td width="15%" height="22" >用户ID：</td>
	       	<td class="td-02" height="22" ><c:out value="${user.loginid}" /></td>
	       </tr> 
	       <tr class="td-04">
	       	<td height="22" >姓名：</td><td class="td-02" height="22"><c:out value="${user.name}" /></td>
	       </tr>
	       <tr class="td-04">
	       	<td height="22" >所属部门：</td><td class="td-02" height="22"><a href="../office_mgm/officeSelect.do?action=detail&id=<c:out value="${user.deptid}"/>"><c:out value="${user.deptname}"/></a></td>
	       </tr>
	       <tr class="td-04">
	       	<td height="22" >性别：</td><td class="td-02" height="22"><c:out value="${user.gender}"/></td>
	       </tr>
       </table>
      <br>
      
      <table width="100%" border="0" cellpadding="1" cellspacing="1" class="table_main">
      	<tr>
      		<td>
      			您选择的部门是:
      		</td>
      	</tr>
      </table>
       
       <TABLE type="grid" border="0"  style="table-layout:fixed;"    name= "listTable" id = "listTable" cellpadding="1" cellspacing="1" bgcolor="a8d1eb"> 
			
        <tr class="td-04">
          <td height="22" ><font face="宋体">部门名称</font></td>
          <td height="22" ><font face="宋体">部门编号</font></td>
          <td height="22" >部门简称</td>   
          <td height="22" >创建时间</td>    
        </tr>
        <% int i = 1; %>
        <c:forEach var="office" items="${officeList}" >
				<% if (i++ % 2 == 1) {%>
        <tr>
				<% } else {%>
        <tr>
				<% }%>
          <td class="td-02" height="22"><c:out value="${office.name}" /></td>
          <td class="td-02" height="22"><c:out value="${office.num}"/></td>
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
      			您选择的权限是:
      		</td>
      	</tr>
      </table>
       
       <TABLE type="grid" border="0"  style="table-layout:fixed;"    name= "listTable" id = "listTable" cellpadding="1" cellspacing="1" bgcolor="a8d1eb"> 
			
        <tr class="td-04"> 
          <td height="22"><font face="宋体">权限标识</font></td>
          <td height="22"><font face="宋体">权限名称</font></td>
          <td height="22">权限描述</td>   
          <td height="22">路径(url)</td>    
        </tr>
        <% i = 1; %>
        <c:forEach var="gunit" items="${priList}" >
				<% if (i++ % 2 == 1) {%>
        <tr >
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
