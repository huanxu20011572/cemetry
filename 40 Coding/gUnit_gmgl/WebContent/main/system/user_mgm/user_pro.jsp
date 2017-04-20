<%@ page contentType="text/html; charset=GBK" %>
<%@ include file="../../../common/taglibs.jsp"%>

<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<meta http-equiv="Cache-Control" content="no-store"/>
<meta http-equiv="Pragma" content="no-cache"/>
<meta http-equiv="Expires" content="0"/>

<link href="<c:url value="/css/css.css"/>" rel="stylesheet" type="text/css">

</head>

<body>
	<SCRIPT LANGUAGE="JavaScript">
function html2Excel() {
	
		var strForm = document.myform;
		strForm.action = "showUserProAll.do?doMethod=expUserPro" ;
		strForm.submit();
}

</SCRIPT>
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="11" background="../../../images/images_32.jpg"><img src="../../../images/content_left.gif" width="11" height="51"></td>
    <td height="51" background="../../../images/images_32.jpg">
    	<table width="70%" border="0" cellspacing="0" cellpadding="0">
	      <tr>
	        <td width="22" height="16" align="center"><img src="../../../images/d.gif" width="14" height="14"></td>
	        <td valign="bottom"> 当前位置：用户管理 → <b>用户权限列表</b></td>
	      </tr>	
    	</table>
    </td>
  </tr>
  <tr>
    <td background="../../../images/images_481.jpg">&nbsp;</td>
    <td valign="top">
	<table border="0" cellspacing="0" cellpadding="0" width="100%">
		
		<tr id="tag1">
			<td>
			<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td width="45" align="left" background="../../../images/images_49.jpg"><img src="../../../images/images_48.jpg" width="38" height="40"></td>
        <td background="../../../images/images_49.jpg" class="title"><strong>用户权限列表</strong></td>
        <td width="30" align="right" background="../../../images/images_49.jpg"> <INPUT TYPE="button" value="导出到EXCEL" onClick="javascript:html2Excel();">

         <td width="30" align="right" background="../../../images/images_49.jpg"> <INPUT TYPE="button" value="返回" onClick="javascript:history.go(-1);">
    </td>

        <td width="10" align="right" background="../../../images/images_49.jpg"></td>
    </tr>
    </table>
   
	<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
	<tr>
	<td width="16" background="../../../images/images_55.jpg">&nbsp;</td>
	<td align="center">
		<br>
		<form id="myform" name="myform" method="post">
			<input type="hidden" name="usrid" value="<c:out value='${usrid}'/>" >
		<input type="hidden" name="userName" value="<c:out value='${userName}'/>" >
	  <input type="hidden" name="workDeptName" value="<c:out value='${userWorkDeptid}'/>" >
		<input type="hidden" name="deptName" value="<gEU_shjz:getDeptNameById deptId="${userDeptId}"/>" >

	<div id="divPage">
	
      <table width="100%" border="0" cellpadding="1" cellspacing="1" bgcolor="a8d1eb">
        
         <tr>
					<td width="100%" height="22" colspan="4" align="left" class="td-04">姓名:<c:out value='${userName}'/> &nbsp;&nbsp;&nbsp;机构名称:<c:out value='${userWorkDeptid}'/>&nbsp;&nbsp;&nbsp;所在部门:<gEU_shjz:getDeptNameById deptId="${userDeptId}"/></td>
					
					
        </tr>
        
        <tr>
					
					<td width="23%" height="22"  align="center" class="td-04">系统名称</td>
					<td width="23%" height="22"  align="center" class="td-04">功能模块名称</td>
					<td width="23%" height="22"  align="center" class="td-04">权限</td>
					<td width="23%" height="22"  align="center" class="td-04">权限设置情况</td>
			
        </tr>
        
 
       <c:forEach var="user" items="${mynewList}"  varStatus="ctIndex" >
 			<c:if test="${user.str4==1}">
 			<% String trClass = "";%>			  		
			<c:if test="${ctIndex.count%2==1}"><%trClass = "td-02";%></c:if>
			<c:if test="${ctIndex.count%2==0}"><%trClass = "td-01";%></c:if>				 
			 <tr height="25" align="center" class="<%=trClass%>">	  		
							 <TD height="22" align="center" ><c:out value='${user.str1}'/> </TD>	
		           <TD height="22" align="center" ><c:out value='${user.str2}'/> </TD>
		           <TD height="22" align="center" ><c:out value='${user.str3}'/> </TD>
		           <TD height="22" align="center" ><c:if test="${user.str4==0}">无</c:if><c:if test="${user.str4==1}">有</c:if>	</TD>
		             
		            				            
		      </tr>
		   </c:if>
		 </c:forEach>	
	
      </table>
         			</form>   
            </div>


				 <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table-line">
					<tr> 
					  	<td align="right" class="listTable_page">
					
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
<form method="post" action="excel.jsp" name="hidForm" target="hidframe">
<INPUT TYPE="hidden" NAME="CONTENT" value="">
<INPUT TYPE="hidden" NAME="filename" value="用户权限表">
</form>
<iframe src="" name="hidframe" style="display:none"/>    

	
</body>
</html>