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
          
        <xml id="os_toolbar_2727376791"> 
          <toolbar>	    
	        <item title="创建新用户" icon="../../../images/config/create.gif"         action="addform.submit();"/> 
	        <item title="查询用户" icon="../../../images/config/zoom_small.gif"          action="location.href='userSelect.do?action=search&amp;deptid=<%=addDeptId%>'"/>	        
	    	<item title="批量删除"   icon="../../../images/config/delete.gif"      action="myform.actionType.value='delete'; onSubmit();"/>   	
	    	<item title="批量修改权限"   icon="../../../images/config/adduser.gif"      action="myform.actionType.value='role'; onSubmit();"/>
	    	<break/> 
	    	<item title="刷新" 	icon="../../../images/config/reload_nav.gif"    action="location.reload();"/>
            <item title="返回" 	icon="../../../images/config/back.gif"    action="location.href='../office_mgm/officeSelect.do?action=list'"/>             

	    </toolbar>      
	</xml> 
	<span id="os_toolbar_2727376791_result" style="display: inline-block;"></span> 
      <script>document.all['os_toolbar_2727376791'].ondatasetcomplete = os_init_toolbar;</script> </td>
        </tr>
      </table>

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
	            	<a href="registCheck.do?action=check&type=dept&id=<c:out value="${user.id}"/>">审批</a>
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
    <td align="left">
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
		    <td width="45%" valign="bottom"> 
              <INPUT onclick=CheckAll(); type=checkbox value="Check All" 
            name=allbox>
              <A onclick="allbox.checked=!allbox.checked;" 
            href="javascript:CheckAll();">选中所有的用户</A> </td>
		 </form>     
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
