<%@ page contentType="text/html; charset=GBK" %>
<%@ include file="../../../common/taglibs.jsp"%>
<%@page import="com.topsuntech.gOS.sso.crypto.FormCrypto"%>
<%
	FormCrypto.setInRandomString(session);
	FormCrypto formCrypto = new FormCrypto();
%>
<html>
<head>
<title>����Ա�б�</title>
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
	if(window.confirm('��ȷ��Ҫɾ����')){
		window.location = 'UserextSelectZi.do?action=delete&id=' + id;
	}
}
function chooseOfficePriority(id){
	windowWithoutToolbar('showChoosOfficePriority.do?doMethod=showSubChoosOfficePriority&id=' + id, 800, 600)
}
</script>

</head>

<style>
	.row	{background: white;}
</style>

<body>
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="11" height="31" valign="top" class="td-bg"><img src="../../../images/right-1.jpg" /></td>
    <td align="center" valign="top" ><table width="100%" border="0" cellpadding="0" cellspacing="0" class="word-8">
      <tr>
        <td height="31" align="left" valign="middle" style="background:url(../../../images/right-3.jpg)"><img src="../../../images/right-4.jpg" width="9" height="8" align="absmiddle" /> ��ǰλ�� &gt; ��ϵͳ���� &gt; �ӹ���Ա����</td>
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
        <td background="../../../images/images_49.jpg" class="title"><strong>�ӹ���Ա����</strong></td>
         
        <td  align="right" background="../../../images/images_49.jpg"><a href="javascript:"><img alt='����ӹ���Ա' src='../../../images/but-tj.gif ' border="0" onClick="location='subUserQuery.do?queryName=managedSubUsers&resetForm=true';return false;" ></a><span style="margin-right: 20px"/></td>
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
                      <td width="4%" height="30" align="center" class="td-04">���</td>
                      <td width="8%" align="center" class="td-04">��¼ID</td>
					  <td width="12%" align="center" class="td-04">����</td>
					  <td width="8%" align="center" class="td-04">�Ա�</td>
					  <td width="23%" align="center" class="td-04">��������</td>
					  <td width="23%" align="center" class="td-04">���ڴ���</td>
					 
                      <td  align="center" class="td-04">����</td>
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
					            	<a href="UserextSelectZi.do?action=view&id=<c:out value="${ue.id}"/>">�鿴��ϸ��Ϣ</a>
									<a href="javascript:" onClick="chooseOfficePriority('<%=formCrypto.encryptSupportEl("${ue.id}", session, pageContext) %>')">�޸�</a>
                           			<a href="javascript:" onClick="deleteConfirm(<c:out value="${ue.id}"/>);return false;">ɾ��</a>
					            </TD>	
										            								            
			         		</tr>
			    	</c:forEach>	
                  </table>

				 <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table-line">
					<tr> 
					  <td align="right" class="listTable_page">
					 <%
          	String creatorid = request.getParameter("creatorid");   		
          	
			      String type = request.getParameter("type");
          %>         
          <gOS:page name="test" action="UserextSelectZi.do?action=list" pageName="dataPage" pageSizeKey="list">
          <gOS:param name="creatorid" value="<%=creatorid%>" /> 
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
