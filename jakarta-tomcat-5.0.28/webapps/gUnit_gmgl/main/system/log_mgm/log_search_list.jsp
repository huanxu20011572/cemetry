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
<title>Untitled Document</title>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<gOS:skin />
<script src="../../../script/action.js" language="JScript"></script>
<script src="../../../script/toolbar-ie5.js" language="JScript"></script>
<link href="../../../script/toolbar-ie5.css" type="text/css" rel="stylesheet">
<xml id="xsl" src="../../../script/toolbar-ie5.xsl"></xml>
<script src="../../../script/ua.js"></script>
<script src="../../../script/function.js"></script>
</head>
<SCRIPT language=JavaScript>

</SCRIPT>
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
          	【<a href="../user_mgm/userAdd.do?action=showAdd">创建新用户</a>】
          	【<a href="javascript:myform.actionType.value='delete'; onSubmit();">批量删除</a>】
          	【<a href="javascript:myform.actionType.value='role'; onSubmit();">批量修改权限</a>】
          	【<a href="javascript:location.reload();">刷新</a>】
      	</td>
      	<td align="center">
          	【<a href="../user_mgm/delSelect.do?action=listAll">删除用户管理</a>】
          	【<a href="javascript:history.back();">返回</a>】
      	</td>
      </tr>
      </table>
      <form action="../user_mgm/userDeleteAll.do?action=deleteAllConfirm" name="myform" method="post">  
      <input type="hidden" name="actionType" value="">
      <input type="hidden" name="prioritys">
      <table width="100%" border="0" cellpadding="1" class="ConfigTable">
        <tr class="tr2"> 
          <td width="3%">&nbsp;</td>
          <td width="15%" class="tr2"><font face="宋体">所属部门</font></td>
          <td width="10%" class="tr2"><font face="宋体">ID</font></td>
          <td width="15%" class="tr2">姓名</td>
          <td width="5%" class="tr2">性别</td>
          <td width="12%" class="tr2">职务</td>
          <td width="10%" class="tr2">出生年月</td>
          <td width="15%" class="tr2">审批情况</td>
          <td width="15%" class="tr2">操作</td>
        </tr>
        <% int i = 1; %>
        <c:forEach var="user" items="${userList}" >
			<% if (i++ % 2 == 1) {%>
        <tr class="tr1" >
			<% } else {%>
        <tr class="tr3" >
			<% }%>
          <td height="21"> <input name="ids" type="checkbox" value="<c:out value="${user.id}"/>" ></td>
          <td><a href="../office_mgm/officeSelect.do?action=detail&id=<c:out value="${user.deptid}"/>"><c:out value="${user.deptname}"/></a></td>
          <td><a href="../user_mgm/userSelect.do?action=detail&id=<c:out value="${user.id}"/>"><c:out value="${user.loginid}" /></a></td>
          <td><c:out value="${user.name}" /></td>
          <td><c:out value="${user.gender}"/></td>
          <td><c:out value="${user.callname}"/></td>
          <td><font color="#000000"><fmt:formatDate value="${user.birthday}" pattern="yyyy-MM-dd" /></font></td>          
          <td>
          	<topsuntech:registStatus> 
          		<c:out value="${user.registstatus}"/>
          	</topsuntech:registStatus> 	
          </td>
          
          <td width="18%">
            <a href="../user_mgm/userUpdate.do?action=showUpdate&id=<c:out value="${user.id}"/>">            
            <img src="../../../images/config/zoom_small.gif" width="16" height="16" border="0" onMouseOver="myHint.show(0)" onMouseOut="myHint.hide()"></a>
            <a href="../user_mgm/userClone.do?action=showClone&id=<c:out value="${user.id}"/>">                        
            <img src="../../../images/config/clone.gif" width="16" height="16" border="0" onMouseOver="myHint.show(1)" onMouseOut="myHint.hide()"></a> 
            <a href="../user_mgm/userDelete.do?action=deleteConfirm&id=<c:out value="${user.id}"/>">            
            <img src="../../../images/config/delete.gif" width="16" height="16" border="0" onMouseOver="myHint.show(2)" onMouseOut="myHint.hide()"></a> 
            <a href="javascript:windowWithoutToolbar('../zxt_mgm/UserextSelect.do?action=priorityChoose&id=<c:out value="${user.id}"/>', 300, 500)">            
            <img src="../../../images/config/adduser.gif" width="16" height="16" border="0" onMouseOver="myHint.show(3)" onMouseOut="myHint.hide()"></a> 
            <c:choose>
	            <c:when test="${user.registstatus == '0'}">
	            	<a href="../user_mgm/registCheck.do?action=check&type=alluser&id=<c:out value="${user.id}"/>">审批</a>
	            </c:when>
	            
	            <c:otherwise>
	            	审批
	            </c:otherwise>
	        </c:choose>
          </td>
          
        </tr>
        </c:forEach>        
      </table>
      </form>
    </td>
  </tr>
  <tr class="tr2"> 
    <td height="16" align="left">
    <font color="#FF0000">
    帮助：操作共有4项：编辑、克隆、删除、修改权限。<br>
    &nbsp;&nbsp;&nbsp;&nbsp;“修改权限”是为了修改某个用户的细粒度权限。<br>
    </font> 
    </td>
  </tr>
  <tr> 
    <td align="left" valign="bottom"> 
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table7">	      
        <tr>
           <form name="checkall">
		  <td width="45%" height="16" valign="bottom"> 
          
            <INPUT onclick=CheckAll(); type=checkbox value="Check All" 
            name=allbox>
              <A onclick="allbox.checked=!allbox.checked;" 
            href="javascript:CheckAll();">选中所有的用户</A> 
        
        </td>
		</form> 
          
        </tr>
      </table></td>
  </tr>
</table>
</span>
</body>
</html>
