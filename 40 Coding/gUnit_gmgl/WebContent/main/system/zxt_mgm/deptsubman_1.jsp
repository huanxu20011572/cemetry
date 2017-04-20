<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib uri="/WEB-INF/tld/gTaglib-gOS.tld" prefix="gOS" %>
<%@ taglib uri="/WEB-INF/tld/topsuntech-tree.tld" prefix="topsuntech" %>
<%@ taglib uri="/WEB-INF/tld/gTaglib-shjz.tld" prefix="gOS_shjz" %>
<link href="../../css/css.css" rel="stylesheet" type="text/css">
<html>
<head>
<title>请选择人员</title>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">

<script src="../../../script/action.js" language="JScript"></script>
<script src="../../../script/toolbar-ie5.js" language="JScript"></script>
<link href="../../../script/toolbar-ie5.css" type="text/css" rel="stylesheet">
<xml id="xsl" src="../../../script/toolbar-ie5.xsl"></xml>
<script src="../../../script/ua.js"></script>
<script src="../../../script/function.js"></script>
<script src="../../../script/page.js"></script>
</head>
<SCRIPT language=JavaScript>

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
		window.alert("请首先选择用户！");
	}
}

</SCRIPT>
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
          <td valign="bottom"> 当前位置：设置下级机构管理员</td>
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
						第一步：请选择人员
	  			</td>
				  <td align="center">
				  【<a href="javascript:history.back()">上一步</a>】
				  【<a href="javascript:onSubmit()">下一步</a>】
				  【<a href="UserextCreate.do?action=cancel">取消</a>】
				  </td>
        </tr>
			</table>

      <form action="UserextDeptCreate.do?action=step2" name="myform" method="post">  
      <TABLE type="grid" border="0"  style="table-layout:fixed;"    name= "listTable" id = "listTable" cellpadding="1" cellspacing="1" bgcolor="a8d1eb"> 
		   <tr class="td-04"> 
          <td width="3%"  height="22">&nbsp;</td>
          <td width="10%" height="22"><font face="宋体">IDs</font></td>
          <td width="20%" height="22"><font face="宋体">所属部门</font></td>
          <td width="20%" height="22">姓名</td>
          <td width="5%"  height="22">性别</td>
          <td width="18%" height="22">职务</td>
          <td width="10%" height="22">出生年月</td>
          <td width="15%" height="22">审批情况</td>          
        </tr>
        <% int i = 1; %>
        <c:forEach var="user" items="${userList}" >
			<% if (i++ % 2 == 1) {%>
        <tr  >
			<% } else {%>
        <tr  >
			<% }%>
          <td class="td-02" height="21"> <input name="ids" type="radio" value="<c:out value="${user.id}"/>" ></td>
          <td class="td-02" height="21"><a href="../user_mgm/userSelect.do?action=detail&id=<c:out value="${user.id}"/>"><c:out value="${user.loginid}" /></a></td>
          <td class="td-02" height="21"><a href="../office_mgm/officeSelect.do?action=detail&id=<c:out value="${user.deptid}"/>"><gOS_shjz:dictOrgValue key="${user.deptid}" /></a></td>
          <td class="td-02" height="21"><c:out value="${user.name}" /></td>
          <td class="td-02" height="21"><c:out value="${user.gender}"/></td>
          <td class="td-02" height="21"><c:out value="${user.callname}"/></td>
          <td class="td-02" height="21"><font color="#000000"><fmt:formatDate value="${user.birthday}" pattern="yyyy-MM-dd" /></font></td>          
          <td class="td-02" height="21">
          	<topsuntech:registStatus> 
          		<c:out value="${user.registstatus}"/>
          	</topsuntech:registStatus> 	
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
           <form name="search" action="deptUserQuery.do?queryName=managedDeptUsers" method="post">
		  	<td width="45%" height="16" valign="bottom"> 
          	按姓名：
          	<input type="text" name="userName" size="10" value="<c:out value='${userQueryForm.map.userName}' />"/>
      		<input type="submit" value="查询"/>
        	</td>
		</form> 
          <td width="55%" valign="bottom">          
          <gOS:page name="test" action="deptUserQuery.do?queryName=managedDeptUsers" pageName="pageBean" pageSizeKey="list">
          	<gOS:param name="userName"><c:out value='${userQueryForm.map.userName}' /></gOS:param>
          </gOS:page>
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
