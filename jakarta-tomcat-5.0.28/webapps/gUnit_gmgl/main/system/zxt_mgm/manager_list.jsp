<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib uri="/WEB-INF/tld/gTaglib-gOS.tld" prefix="gOS" %>
<%@ taglib uri="/WEB-INF/tld/gTaglib-shjz.tld" prefix="gOS_shjz" %>
<%@page import="com.topsuntech.gOS.sso.crypto.FormCrypto"%>
<%
	FormCrypto.setInRandomString(session);
	FormCrypto formCrypto = new FormCrypto();
%>

<html>
<head>
<title>管理员列表</title>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<meta http-equiv="Cache-Control" content="no-store"/>
<meta http-equiv="Pragma" content="no-cache"/>
<meta http-equiv="Expires" content="0"/>
<link href="../../css/css.css" rel="stylesheet" type="text/css">
<script language="JavaScript" src="../../../script/publics.js"></script>
<script language="JavaScript" src="../../../lib/function.js"></script>
<script src="<c:url value="/script/ua.js"/>"></script>
<script>
function deleteConfirm(id){
	if(window.confirm('您确定要删除吗？')){
		window.location = 'UserextSelect.do?action=delete&id=' + id;
	}

}
function chooseOfficePriority(id){
	windowWithoutToolbar('showChoosOfficePriority.do?doMethod=showChoosOfficePriority&id=' + id, 800, 600)
}
</script>

</head>

<style>
	.row	{background: white;}
</style>

<body>
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="11" background="../../../images/images_32.jpg"><img src="../../../images/content_left.gif" width="11" height="51"></td>
    <td height="51" background="../../../images/images_32.jpg"><table width="70%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="22" height="16" align="center"><img src="../../../images/d.gif" width="14" height="14"></td>
        <td valign="bottom"> 当前位置：超级系统管理 → <b>子管理员管理</b></td>
      </tr>	
    </table>
    </td>
  </tr>
  <tr>
    <td background="../../../images/images_481.jpg">&nbsp;</td>
    <td valign="top">
	<table border="0" cellspacing="0" cellpadding="0" width="100%">
		<tr>
			<td align="left">
			<table width="94%" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
				  
                <td height="0">&nbsp; </td>
				  
                <td height="0" align="right" valign="top">&nbsp;</td>
				</tr>
			</table>
				  
		  </td>
		</tr>
		<tr id="tag1">
			<td>
			<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td width="45" align="left" background="../../../images/images_49.jpg"><img src="../../../images/images_48.jpg" width="38" height="40"></td>
        <td background="../../../images/images_49.jpg" class="title"><strong>子管理员管理</strong></td>
         
        <td  align="right" background="../../../images/images_49.jpg"><a href="javascript:"><img alt='添加子管理员' src='../../../images/but-tj.gif ' border="0" onclick="location='UserListAll.do?method=listAllUser';return false;" ></a><span style="margin-right: 20px"/></td>
      </tr>
    </table>
   
			<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td width="16" background="../../../images/images_55.jpg">&nbsp;</td>
          <td align="center">
       <br>

		  
                  <table width="100%" border="0" cellpadding="1" cellspacing="1" bgcolor="a8d1eb">
                    <tr> 
                    <!--	<TD>									        	
									        	<input type="checkbox" name="allbox" onClick="checkAll(this,ids)">
									     	</TD>-->
                      <td width="4%" height="30" align="center" class="td-04">序号</td>
                      <td width="8%" align="center" class="td-04">登录ID</td>
					  <td width="12%" align="center" class="td-04">姓名</td>
					  <td width="8%" align="center" class="td-04">性别</td>
					  <td width="23%" align="center" class="td-04">所属机构</td>
					  <td width="23%" align="center" class="td-04">所在处室</td>
					  
                      <td  align="center" class="td-04">操作</td>
                    </tr>
					<c:forEach var="ue" items="${ueList}"  varStatus="ctIndex" >		  		
							<% String trClass = "";%>
							<c:if test="${ctIndex.count%2==1}"><%trClass = "td-02";%></c:if>
							<c:if test="${ctIndex.count%2==0}"><%trClass = "td-01";%></c:if>
							<tr height="25" align="center" class="<%=trClass%>">								  		
						  		<!--	<TD align="center" class="td-02"><input type="checkbox" name="ids" value="<c:out value='${user.id}'/>"></TD>	-->													  		
						  		<TD height="22" align="center" class="td-02"><c:out value='${ctIndex.index+1+(projectPage.pageSize*(projectPage.currentPage-1))}'/></TD>	
					            <TD height="22" align="center" class="td-02"><c:out value="${ue.user.loginid}" /></TD>
					            <TD height="22" align="center" class="td-02"><c:out value="${ue.user.name}" /></TD>								           			
					            <TD height="22" align="center" class="td-02"><c:out value="${ue.user.gender}"/></TD>		
					            <TD height="22" align="center" class="td-02"><gOS_shjz:dictOrgValue key="${ue.user.workdeptid}"/></TD>	
					           	<TD height="22" align="center" class="td-02"><gOS_shjz:dictOrgValue key="${ue.user.deptid}" /></TD>	
					            <TD height="22" align="center" class="td-02">
		            				<a href="UserextSelect.do?action=view&id=<c:out value="${ue.id}"/>">查看详细信息</a>
		            				<a href="javascript:" onclick="chooseOfficePriority('<%=formCrypto.encryptSupportEl("${ue.id}", session, pageContext) %>')">修改</a> 		            
	                         				<a href="javascript:" onclick="deleteConfirm(<c:out value="${ue.id}"/>);return false;">删除</a>
					            </TD>	
										            						
							</tr>
						</c:forEach>	
                  </table>

				 <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table-line">
					<tr> 
					  <td align="right" class="listTable_page">
						<%
			String type = request.getParameter("type");
          %>
          <gOS:page name="test" action="UserextSelect.do?action=list" pageName="dataPage" pageSizeKey="list">
          	<gOS:param name="type" value="<%=type%>" />
          </gOS:page>
			   </td>
			  </tr>
			 
			</table>
			
		  </td>
          <td width="16" background="../../../images/images_57.jpg">&nbsp;</td>
        </tr>
        <tr>
          <td><img src="../../../images/images_72.jpg" width="16" height="17"></td>
          <td background="../../../images/images_73.jpg">&nbsp;</td>
          <td><img src="../../../images/images_75.jpg" width="16" height="17"></td>
        </tr>
      </table>
			</td>
		</tr>
	</table>
    </td>
  </tr>
</table>
</body>
</html>