<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib uri="/WEB-INF/tld/gTaglib-gOS.tld" prefix="gOS" %>
<link href="../../css/css.css" rel="stylesheet" type="text/css">
<html>
<head>
<title>����Ա�б�</title>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">

<script language="JavaScript" src="../../../script/publics.js"></script>
<script language="JavaScript" src="../../../lib/function.js"></script>
<script>
	function deleteConfirm(id){
		if(window.confirm('��ȷ��Ҫɾ����')){
			window.location.href = 'DeptSelect.do?action=delete&id=' + id;
		}
	
	}
</script>

</head>

<style>
	.row	{background: white;}
</style>

<body bgcolor="#FFFFFF" text="#000000" leftmargin="0" topmargin="0" scroll="no" >
	<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="11" background="../../../images/images_32.jpg"><img src="../../../images/content_left.gif" width="11" height="51"></td>
    <td height="51" background="../../../images/images_32.jpg"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="22" height="16" align="center"><img src="../../../images/d.gif" width="14" height="14"></td>
          <td valign="bottom"> ��ǰλ�ã�����ϵͳ����</td>
          <td align="right">��<a href="deptUserQuery.do?queryName=managedDeptUsers&resetForm=true">����</a>��</td>
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
					   
		      
     <TABLE type="grid" border="0"  style="table-layout:fixed;"    name= "listTable" id = "listTable" cellpadding="1" cellspacing="1" bgcolor="a8d1eb"> 
								
        <tr class="td-04"> 
          <td width="20%" height="24"><font face="����">��¼ID</font></td>
          <td width="20%" height="24">����</td>
          <td width="20%" height="24">�Ա�</td>
          <td width="20%" height="24">��������</td>
          <td width="20%" height="24">����</td>
        </tr>
        
	        <% int i = 1; %>
	        <c:forEach var="ue" items="${ueList}" >
					<c:if test="${ue.id!=0}"> 
       <tr>
          <td height="24" class="td-02"><a href="../user_mgm/userSelect.do?action=detail&id=<c:out value="${ue.user.id}"/>"><c:out value="${ue.user.loginid}" /></a></td>
          <td height="24" class="td-02"><c:out value="${ue.user.name}" /></td>
          <td height="24" class="td-02"><c:out value="${ue.user.gender}"/></td>
          <td height="24" class="td-02"><c:out value="${ue.user.workdept.name}"/></td>

          <td height="24" class="td-02">
				<a href="UserextSelect.do?action=view&id=<c:out value="${ue.id}"/>">�鿴��ϸ��Ϣ</a> 
				<a href="javascript:deleteConfirm(<c:out value="${ue.id}"/>)">ɾ��</a>
          </td>
          
        </tr>
      </c:if>
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
          	String creatorid = request.getParameter("creatorid");		
			String type = request.getParameter("type");
          %>         
          <gOS:page name="test" action="DeptSelect.do?action=list" pageName="dataPage" pageSizeKey="list">
          <gOS:param name="creatorid" value="<%=creatorid%>" /> 
          <gOS:param name="type" value="<%=type%>" /> 
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
