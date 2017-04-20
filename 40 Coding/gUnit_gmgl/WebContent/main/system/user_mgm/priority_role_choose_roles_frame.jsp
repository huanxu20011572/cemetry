<%@ page contentType="text/html; charset=GBK" %>
<%@ include file="../../../common/taglibs.jsp"%>
<html>
<head>
<title>分配权限</title>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<meta http-equiv="Cache-Control" content="no-store"/>
<meta http-equiv="Pragma" content="no-cache"/>
<meta http-equiv="Expires" content="0"/>

<script src="../../../js/jquery-1.2.6.js"></script>
<link href="../../../css/css.css" rel="stylesheet" type="text/css">

<script>
function initCheckBoxByIds(str){
	var strArr = str.split(",")
	for(var i = 0; i < strArr.length; i++){
		$("#" + strArr[i]).attr( 'checked', true );
	}
}
function doOnLoad(){
	var systemRole = '<c:out value="${param.systemRole}"/>';
	initCheckBoxByIds(systemRole);
	
    $(".roleTBody :checkbox").click(function() {
		parent.clickRoleCheckbox(this);
	});
}
function doNext(){
	parent.refreshRolesFrame(null, '<c:out value='${page.currentPage + 1}'/>');
}
function doPrev(){
	parent.refreshRolesFrame(null, '<c:out value='${page.currentPage - 1}'/>');
}
</script>
</head>

<body onLoad="doOnLoad()">
	<table style="border: 1px thin solid; font:12px" width="100%" cellpadding="1" cellspacing="1">
		<thead>
		  	<tr height="26" align="center">
		  		<td width="7%" class="td-04"/>
		        <td width="10%" class="td-04">序号</td>                    
		        <td width="30%" class="td-04">角色名称</td>  
<!-- 		        <td width="20%" class="td-04">分类</td> -->
		        <td width="33%" class="td-04">角色描述</td>          
		  	</tr>   
	 	</thead>
			 
	 	<TBODY class="roleTBody">
	    	<c:forEach var="role" items="${roles}"  varStatus="status" >
			  	<% String trClass = "";%>			  		
				<c:if test="${status.count%2==1}"><%trClass = "td-02";%></c:if>
				<c:if test="${status.count%2==0}"><%trClass = "td-01";%></c:if>
<%-- 			  	<tr height="26" align="center" class="<%=trClass%>" category="<c:out value="${role.category}" />"> --%>
			  	<tr height="26" align="center" class="<%=trClass%>" >
             			<td width="7%" align="center">		  				
		  				<input type="checkbox" name="roleIds" id="<c:out value='${role.id}'/>" prios='<c:out value="${role.priority}" />'>
		  			</td>
			  		<td width="10%" align="center"><c:out value='${status.index + 1 + (page.pageSize * (page.currentPage - 1))}'/></td>	
            		<td width="30%" align="left" ><c:out value="${role.name}" /></td>
<%--             		<td width="20%" align="left" ><c:out value="${role.category}" /><c:if test="${empty role.category}">无</c:if></td>		 --%>
					<td width="33%" align="left" ><c:out value="${role.description}" /></td>																										            									           													            								            
         		</tr>
	    	</c:forEach>	
	  	</TBODY>
	</table>
    <table>
    		<tr>
    			<td>共<c:out value="${page.pageNum}"/>页<c:out value="${page.rowNum}"/>条&nbsp;第<c:out value="${page.currentPage}"/>页&nbsp;<a href="javascript:;" onClick="doPrev();return false;">上一页</a>/<a href="javascript:;" onClick="doNext();return false;" target="_self">下一页</a></td>
    		</tr>
    </table>
</body>
</html>