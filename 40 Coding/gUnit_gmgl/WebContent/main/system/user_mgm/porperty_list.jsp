<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib uri="/WEB-INF/tld/gTaglib-gOS.tld" prefix="gOS" %>
<%@ taglib uri="/WEB-INF/tld/gTaglib-shjz.tld" prefix="gOS_shjz" %>

<html>
<head>
<title>系统授权</title>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<meta http-equiv="Cache-Control" content="no-store"/>
<meta http-equiv="Pragma" content="no-cache"/>
<meta http-equiv="Expires" content="0"/>

<link href="<c:url value="/css/css.css"/>" rel="stylesheet" type="text/css">

<script src="<c:url value="/script/ua.js"/>"></script>
<script src="<c:url value="/script/publics.js"/>"></script>
<script src="<c:url value="/script/page.js"/>"></script>
<script type="text/javascript" src="<c:url value="/script/jquery.js"/>"></script>
</head>
<script language="javascript">

function submitForm(mid,flag){

	var username=document.getElementById("username").value;

if(flag==1){
	if(!confirm('你确定要给'+username+'授权全部的'+mid+'权限么')){
					return ;
	}	
	
}

if(flag==0){
	if(!confirm('你确定要把'+username+'的'+mid+'权限全部去掉么')){
					return ;
	}	
	
}
	myform.action = "updatePorperty.do?doMethod=updatePorperty&sys="+mid+"&flag="+flag;
	myform.submit();
	
}

</script>
<body>
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="11" background="../../../images/images_32.jpg"><img src="../../../images/content_left.gif" width="11" height="51"></td>
    <td height="51" background="../../../images/images_32.jpg">
    	<table width="70%" border="0" cellspacing="0" cellpadding="0">
	      <tr>
	        <td width="22" height="16" align="center"><img src="../../../images/d.gif" width="14" height="14"></td>
	        <td valign="bottom"> 当前位置：用户管理 → <b>批量授权</b></td>
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
        <td background="../../../images/images_49.jpg" class="title"><strong>批量授权</strong>&nbsp;&nbsp;</td>
        
        <td width="16" align="right" background="../../../images/images_49.jpg"><a href="#" onClick="javascript:window.close();"><img src="../../../main/zbtx/images/close.jpg" width="62" height="26" border="0"/></a></td>
      </tr>
    </table>
   
	<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
	<tr>
	<td width="16" background="../../../images/images_55.jpg">&nbsp;</td>
	<td align="center">

		<form id="myform" name="myform" method="post">
			<input type="hidden" name="id" value="<c:out value="${userid}"/>" >
					<input type="hidden" id="username" value="<c:out value="${username}"/>" >
			<br>
			<table width="100%" border="0" cellpadding="1" cellspacing="1" bgcolor="a8d1eb">
     <tr> 
			<td width="10%" height="30" align="center" class="td-04">序号</td>
			<td width="40%" align="center" class="td-04">系统名称</td>			
			<td  align="center" class="td-04">操作</td>
     </tr>
     <c:forEach var="list" items="${mylist}"  varStatus="ctIndex" >
		 	  <c:if test="${ctIndex.count%2==1}">
            <tr  height="25" align="center" class="td-02">
					</c:if>
				 <c:if test="${ctIndex.count%2==0}">
				  <tr  height="25" align="center" class="td-01">
			 </c:if>		       	
			<td width="10%" height="30" align="center" ><c:out value='${ctIndex.index+1+(projectPage.pageSize*(projectPage.currentPage-1))}'/></td>
			<td  align="center" ><c:out value='${list}'/></td>			
			<td  align="center" ><a href="javascript:submitForm('<c:out value='${list}'/>',1);">全部授权</a>&nbsp;&nbsp;<a href="javascript:submitForm('<c:out value='${list}'/>',0);">取消全部授权</a></td>
    </tr>
    </c:forEach>	
 
   </table>
               
			</form>
			
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
	<table align=center>
	<tr><td>
	
		</td>
		 <td align="center"><a href="#" onClick="javascript:window.close();"><img src="../../../main/zbtx/images/close.jpg" width="62" height="26" border="0"/></a></td>
		</tr>
</table>	
</body>
</html>