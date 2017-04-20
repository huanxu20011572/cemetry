<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib uri="/WEB-INF/tld/gTaglib-gOS.tld" prefix="gOS" %>

<%@page import="com.topsuntech.gOS.user.session.*" %>
<%@page import="com.topsuntech.gOS.user.en.user.*" %>
<%@page import="com.topsuntech.gOS.config.user.DeleteReason.dao.DeleteReasonFactory" %>
<%@page import="java.util.Collection" %>
<link href="../../css/css.css" rel="stylesheet" type="text/css">
<html>
<head>
<title>Untitled Document</title>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">

<script src="../../../script/action.js" language="JScript"></script>
<script src="../../../script/toolbar-ie5.js" language="JScript"></script>
<link href="../../../script/toolbar-ie5.css" type="text/css" rel="stylesheet">
<xml id="xsl" src="../../../script/toolbar-ie5.xsl"></xml>
 
<!-- Code for browser detection -->
<script src="../../../script/ua.js"></script>

<link href="../../../css/css.css" rel="stylesheet" type="text/css">
</head>
<script>
	function onsubmit(){
		if(window.confirm('您确定要删除吗？')){
			myform.submit();
		}
	
	}
</script>

<%
	String sDeptId=request.getParameter("sDeptId");
	String backurl="userSelect.do?";
	if(sDeptId==null||sDeptId.length()==0)
	{
	   backurl+="action=list";	
	   sDeptId="";
	}else{
	   backurl+="action=listByDept&id=";
	   backurl+=sDeptId;
	}
	
%>	
<body bgcolor="#FFFFFF" text="#000000" leftmargin="0" topmargin="0">
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="11" background="../../../images/images_32.jpg"><img src="../../../images/content_left.gif" width="11" height="51"></td>
    <td height="51" background="../../../images/images_32.jpg"><table width="70%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="22" height="16" align="center"><img src="../../../images/d.gif" width="14" height="14"></td>
          <td valign="bottom"> 当前位置：批量删除</td>
      </tr>
    </table>
    </td>
  </tr>
  <tr>
    <td background="../../../images/images_481.jpg">&nbsp;</td>
    <td valign="top">
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table1">
  <tr> 
    <td valign="top"> <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table7">
        <tr class="list_title"> 
     
          <td width="100%" align="right"> <table width="100%" border="0" cellpadding="0" cellspacing="0">
              <tr class="list_title"> 
                <td width="30" class="td16">&nbsp;</td>
                <td width="30" class="td16">&nbsp;</td>
                <td width="30" class="td16">&nbsp; </td>
                <td width="30" class="td16">
					
				</td>
                <td width="270" class="td16">
					
					<font color="#000000"><strong>你确定要删除下列用户吗？</strong></font> 
				</td>
				<td width="100" class="td16">
					<input type="button" value="确定" onClick="onsubmit();" class="input_btn"/>
		  <input type="button" value="取消" onClick="javascript:history.back();" class="input_btn"/>					
				</td>
              </tr>
              
            </table></td>
        </tr>
      </table>
     <form action="userDeleteAll.do?action=deleteAll" name="myform" method="post">   
     <table width="100%" border="0" class="table5">

	        <tr> 
	          <td>请选择删除原因：
	          			<%
                        Collection list = DeleteReasonFactory.getDeleteReasonConfig().getDeleteReasonbyAll();
                        request.setAttribute("list", list);
                    	%>
                    	<gOS:select name="deletereason" keyProperty="name" valueProperty="name" items="${list}"/>
              </td>
	        </tr>
	 </table>
	      
     <input type="hidden" name="sDeptId" value="<%=sDeptId%>">
     <TABLE type="grid" border="0"  style="table-layout:fixed;"    name= "listTable" id = "listTable" cellpadding="1" cellspacing="1" bgcolor="a8d1eb"> 								
					<tr class="td-04"> 
          <td width="18%"  height="22"><div align="center">所属部门</div></td>
          <td width="17%" height="22"><div align="center">ID</div></td>
          <td width="18%"  height="22"><div align="center">姓名</div></td>
          <td width="12%"  height="22"><div align="center">性别</div></td>
          <td width="15%" height="22"><div align="center">职务</div></td>
          <td width="20%"  height="22"><div align="center">出生年月</div></td>
        </tr>
         <% int i = 1; %>
        <c:forEach var="user" items="${userList}" >
			<% if (i++ % 2 == 1) {%>
        <tr>
			<% } else {%>
        <tr>
			<% }%>    
	  <input name="ids" type="hidden" value="<c:out value="${user.id}"/>">      
          <td width="15%" height="21" class="td-02"><div align="center"><a href="../office_mgm/officeSelect.do?action=detail&id=<c:out value="${user.deptid}"/>"><c:out value="${user.deptname}" /></a></div></td>
          <td width="17%" height="21" class="td-02"><div align="center"><a href="userSelect.do?action=detail&id=<c:out value="${user.id}"/>"><c:out value="${user.loginid}" /></a></div></td>
          <td width="18%" height="21" class="td-02"><div align="center"><c:out value="${user.name}" /></div></td>
          <td width="12%" height="21" class="td-02"><div align="center"><c:out value="${user.gender}" /></div></td>
          <td width="15%" height="21" class="td-02"><div align="center"><c:out value="${user.callname}" /></div></td>
          <td width="20%" height="21" class="td-02"><div align="center"><fmt:formatDate value="${user.birthday}" pattern="yyyy-MM-dd" /></div></td>
        </tr>
        </c:forEach>
  </table>
      <form>
    </td>
  </tr>
  
</table></td>
  </tr>
</table>
</td>
  </tr>
</table>
</body>
</html>
