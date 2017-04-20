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
<style type="text/css">
.list_title  /*列表标题*/
{
  background-color:#81BEF6; 
	word-break:keep-all;
}
.input_btn1  /*按钮适用于2～3个字*/
{
	font-size:12px;
	width:55px;
	height: 21px;
	background-image:url(../../../../images/but.gif); 
	border: 0px;
}
</style>
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
<SCRIPT language=JavaScript>
<!--
function CheckAll()
  {
    for (var i=0;i<document.myform.elements.length;i++)
    {
      var e = document.myform.elements[i];
      if (e.name == 'ids')
        e.checked = document.checkall.allbox.checked;
    }
  }
function CheckSelected() {
    var isCheck = false;
    for (var i=0;i<document.myform.elements.length;i++)
    {
      var e = document.myform.elements[i];
      if (e.name == 'ids')
        if (e.checked == true) {
            isCheck = e.checked;
            break;
        }
    }
    return isCheck;
}
function onSubmit() {
	if (CheckSelected()) {
		myform.submit();
	} else {
		window.alert("请首先选择！");
	}
}
//-->
</SCRIPT>
      <%	    
	    String addDeptId=request.getParameter("id");
      %>
<body bgcolor="#FFFFFF" text="#000000" leftmargin="0" topmargin="0" scroll="no" onLoad="f_resize_main_span()" onResize="f_resize_main_span()">
<span id="_main_Span" style="width:100%;overflow:auto">

<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table_template" id="_main_table">
  <tr> 
    <td valign="top"> 
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table7">
        <tr align="left"> 
          <td align="left" width="10%" class="list_title"><label>
            <input name="Submit" type="button" onClick="javascript:history.back();" class="input_btn1" value="返回">
          </label></td>
          <td width="70%" class="list_title"></td>
          <td align="right" width="20%" class="list_title"><b>显示部门用户</b></td>
        </tr>
      </table>
	  <br/>

      <form action="userAdd.do?action=showAdd" name="addform" method="post">            
      <input type="hidden" name="addDeptId" value="<%=addDeptId%>">
      <input type="hidden" name="addDeptname" value="<c:out value="${thisdeptname}"/>">
      </form>
      <form action="userDeleteAll.do?action=deleteAllConfirm" name="myform" method="post">        	
      <input type="hidden" name="actionType" value="">      
      <input type="hidden" name="prioritys">
      <input type="hidden" name="sDeptId" value="<%=addDeptId%>">
      <table width="100%" border="0" cellpadding="1" class="ConfigTable">
        <tr class="tr2"> 
          <td width="15%" class="list_title"><div align="center"><font face="宋体">所属部门1111</font></div></td>
          <td width="10%" class="list_title"><div align="center"><font face="宋体">ID</font></div></td>
          <td width="15%" class="list_title"><div align="center">姓名</div></td>
          <td width="5%" class="list_title"><div align="center">性别</div></td>
          <td width="12%" class="list_title"><div align="center">职务</div></td>
          <td width="10%" class="list_title"><div align="center">出生年月</div></td>
          <td width="15%" class="list_title"><div align="center">审批情况</div></td>
          <td width="15%" class="list_title"><div align="center">操作</div></td>
        </tr>
        <% int i = 1; %>
        <c:forEach var="user" items="${userList}" >
			<% if (i++ % 2 == 1) {%>
        <tr class="tr1" >
			<% } else {%>
        <tr class="tr3" >
			<% }%>
           <!--
          <td height="21"> <input name="ids" type="checkbox" value="<c:out value="${user.id}"/>" ></td>
          -->
          <td><div align="center"><a href="../office_mgm/officeSelect.do?action=detail&id=<c:out value="${user.deptid}"/>"><c:out value="${user.deptname}"/></a></div></td>
          <td><div align="center"><a href="userSelect.do?action=detail&id=<c:out value="${user.id}"/>"><c:out value="${user.loginid}" /></a></div></td>
          <td><div align="center"><c:out value="${user.name}" /></div></td>
          <td><div align="center"><c:out value="${user.gender}"/></div></td>
          <td><div align="center"><c:out value="${user.callname}"/></div></td>
          <td><div align="center"><font color="#000000"><fmt:formatDate value="${user.birthday}" pattern="yyyy-MM-dd" /></font></div></td>
          <td>
          	          <div align="center"><topsuntech:registStatus> 
          		<c:out value="${user.registstatus}"/>
          	</topsuntech:registStatus></div></td>
           
          <td width="18%">
            <a href="userUpdate.do?action=showUpdate&id=<c:out value="${user.id}"/>&sDeptId=<%=addDeptId%>">            
            <img src="../../../images/config/zoom_small.gif" width="16" height="16" border="0" onMouseOver="myHint.show(0)" onMouseOut="myHint.hide()"></a>
            <a href="userClone.do?action=showClone&id=<c:out value="${user.id}"/>&sDeptId=<%=addDeptId%>">            
            <img src="../../../images/config/clone.gif" width="16" height="16" border="0" onMouseOver="myHint.show(1)" onMouseOut="myHint.hide()"></a> 
            <a href="userDelete.do?action=deleteConfirm&id=<c:out value="${user.id}"/>&sDeptId=<%=addDeptId%>">            
            <img src="../../../images/config/delete.gif" width="16" height="16" border="0" onMouseOver="myHint.show(2)" onMouseOut="myHint.hide()"></a> 
            <a href="javascript:windowWithoutToolbar('userChoose.do?action=actorChoose&userId=<c:out value="${user.id}"/>', 600, 500)">            
            <img src="../../../images/config/adduser.gif" width="16" height="16" border="0" onMouseOver="myHint.show(3)" onMouseOut="myHint.hide()"></a> 
            <c:choose>
	            <c:when test="${user.registstatus == '0'}">
	            	<a href="registCheck.do?action=check&type=dept&id=<c:out value="${user.id}"/>">审批</a>	            </c:when>
	            
	            <c:otherwise>
	            	审批	            </c:otherwise>
	        </c:choose>          </td>
        </tr>
        </c:forEach>        
      </table>
      </form>
    </td>
  </tr>
  <tr class="tr2"> 
    <td align="left">
    <font color="#FF0000">
    帮助：操作共有4项：编辑、克隆、删除、修改权限。<br>
    &nbsp;&nbsp;&nbsp;&nbsp;“修改权限”是为了修改某个用户的细粒度权限。<br>
    </font> 
    </td>
  </tr>
  <tr> 
    <td align="left" valign="bottom"> 
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list_title">	      
        <tr> 
        <!--
        <form name="checkall">
		    <td width="45%" valign="bottom"> 
              <INPUT onclick=CheckAll(); type=checkbox value="Check All" 
            name=allbox>
              <A onclick="allbox.checked=!allbox.checked;" 
            href="javascript:CheckAll();">选中所有的用户</A> </td>
		 </form>    
		 --> 
		 <td width="45%" valign="bottom"> 
          </td>
          <td width="55%" valign="bottom"> 
            <%String dept_id=request.getParameter("id");%>
            <gOS:page name="test1" action="userSelect.do?action=listByDept" pageName="dataPage" pageSizeKey="list"> 
            <gOS:param name="id" value="<%=dept_id%>" /> 
            </gOS:page> </td>
        </tr>
      </table>
    </td>
  </tr>
</table>
</span>
</body>
</html>
