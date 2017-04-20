<%@ page contentType="text/html; charset=GBK" %>
<%@ include file="../../../common/taglibs.jsp"%>

<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<meta http-equiv="Cache-Control" content="no-store"/>
<meta http-equiv="Pragma" content="no-cache"/>
<meta http-equiv="Expires" content="0"/>

<link href="<c:url value='/css/css.css'/>" rel="stylesheet" type="text/css">
<script src="<c:url value='/script/function.js'/>"></script>
<script src="<c:url value='/script/publics.js'/>"></script>
<script src="<c:url value='/script/page.js'/>"></script>
<script language="javascript">
	//查询
	function doQuery(){
		var strForm = document.myform;
		<c:if test="${not subRoleList}">
			strForm.action = 'roleList.do?doMethod=roleList';
		</c:if>
		<c:if test="${subRoleList}">
			strForm.action = 'roleList.do?doMethod=subRoleList';
		</c:if>
		strForm.submit();		
	}
	function doAdd(){
		<c:if test="${not subRoleList}">
			window.location = 'showRole.do?doMethod=showRole';
		</c:if>
		<c:if test="${subRoleList}">
			window.location = 'showRole.do?doMethod=showSubRole';
		</c:if>
	}
	function delectRole(roleId, roleName){
		if(window.confirm('确定删除"' + roleName + '"吗？')){
			var strForm = document.myform;
			<c:if test="${not subRoleList}">
				strForm.action = 'deleteRole.do?doMethod=deleteRole&id=' + roleId;
			</c:if>
			<c:if test="${subRoleList}">
				strForm.action = 'deleteSubRole.do?doMethod=deleteRole&id=' + roleId;
			</c:if>
			strForm.submit();
		}
	}
</script>
</head>
<body>
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="11" height="31" valign="top" class="td-bg"><img src="../../../images/right-1.jpg" /></td>
    <td align="center" valign="top" ><table width="100%" border="0" cellpadding="0" cellspacing="0" class="word-8">
      <tr>
        <td height="31" align="left" valign="middle" style="background:url(../../../images/right-3.jpg)"><img src="../../../images/right-4.jpg" width="9" height="8" align="absmiddle" /> 当前位置 &gt; 系统管理 &gt; 角色管理</td>
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
		        <td width="45" align="left" background="<c:url value='/images/images_49.jpg'/>"><img src="<c:url value='/images/images_48.jpg'/>" width="38" height="40"></td>
		        <td background="<c:url value='/images/images_49.jpg'/>" class="title">
		        	<c:if test="${not subRoleList}"><strong>角色管理</strong></c:if>
	       			<c:if test="${subRoleList}"><strong>角色管理</strong></c:if>
		        </td>    
		        <td width="16" align="right" background="<c:url value='/images/images_49.jpg'/>"></td>
		      </tr>
		    </table>
   
			<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
		        <tr>
		          <td width="16" background="<c:url value='/images/images_55.jpg'/>">&nbsp;</td>
		          <td align="center">
		          <br>
				  <form  method="post"  name="myform">
				  			
					<table width="100%" border="0" cellpadding="1" cellspacing="1" bgcolor="a8d1eb">	        		
						<tr height="22" > 
							<td  height="23" align="right" class="td-01">角色名称：</td>
	                      	<td class="td-02"> 
	                      		<input class="input_txt" name="roleName" type="text"  value="<c:out value="${param.roleName}" />" >	
	                      	</td>
<!-- 							<td nowrap align="right" class="td-01" >子系统：</td> -->
<!-- 					      	<td class="td-02"> -->
<!-- 				          		<select id="category" name="category" style="vertical-align: middle;"> -->
<!-- 				          			<option value=''>全部</option> -->
<%-- 				          			<c:forEach items="${rootChildrenPrioritys}" var="pri" varStatus="status"> --%>
<%-- 				          				<option value='<c:out value="${pri.value}"/>' <c:if test='${pri.value eq param.category }'>selected="true"</c:if> ><c:out value="${pri.value}"/></option> --%>
<%-- 				          			</c:forEach> --%>
<%-- 				          			<option value='跨子系统' <c:if test='${"跨子系统" eq param.category }'>selected="true"</c:if>>跨子系统</option> --%>
<!-- 				          		</select> -->
<!-- 						    </td>     								         -->
					        <td class="td-02" colspan="2" align="center"> 
					       		<a href="javascript:doQuery()"><img alt='查询' src='<c:url value="/images/but-serch.jpg"/>' border=no style='vertical-align:middle'></a>&nbsp;
                           		<a href="javascript:doAdd()"><img alt='添加角色' src='<c:url value="/images/but-tj.gif"/>' border=no style='vertical-align:middle'></a>&nbsp;
					        </td>  															      
				        </tr>
						  				  
                    </table>
                    <br>
                  	<table width="100%" border="0" cellpadding="1" cellspacing="1" bgcolor="a8d1eb">
                    <tr> 
                    	<td width="5%" align="center" class="td-04">序号</TD>
                    	<td width="25%" height="30" align="center" class="td-04">名称</td>
<!-- 						<td width="15%" align="center" class="td-04">子系统</td> -->
<!-- 						<td width="10%" align="center" class="td-04">创建人</td> -->
					    <td width="10%" align="center" class="td-04">创建日期</td>
					    <td width="20%" align="center" class="td-04">描述</td>
	                    <td width="15%" align="center" class="td-04">操作</td>
                    </tr>
					<c:forEach var="role" items="${roles}"  varStatus="ctIndex" >
						<% String trClass = "";%>			  		
						<c:if test="${ctIndex.count%2==1}"><%trClass = "td-02";%></c:if>
						<c:if test="${ctIndex.count%2==0}"><%trClass = "td-01";%></c:if>
						<tr height="25" align="center" class="<%=trClass%>">
				          	<td height="26" align="center"><c:out value='${ctIndex.index+1+(projectPage.pageSize*(projectPage.currentPage-1))}'/>   </td>
				          	<td>
				          		<c:if test="${not subRoleList}">
				          			<a href="showRole.do?doMethod=showRoleDetail&id=<c:out value="${role.id}"/>"><gOS:subString><c:out value="${role.name}"/></gOS:subString></a>
				          		</c:if>
	        					<c:if test="${subRoleList}">
									<a href="showRole.do?doMethod=showSubRoleDetail&id=<c:out value="${role.id}"/>"><gOS:subString><c:out value="${role.name}"/></gOS:subString></a>	        					
	        					</c:if>
				          	</td>
<!-- 				          	<td> -->
<%-- 				          		<c:out value="${role.category}" /> --%>
<%-- 				          		<c:if test="${empty role.category}">无</c:if> --%>
<!-- 				          	</td> -->
<%-- 				          	<td><c:out value="${role.creatorId}" /></td> --%>
				          	<td align="center"><fmt:formatDate value="${role.createDate}" pattern="yyyy-MM-dd" /></td>
				          	<td><gOS:subString><c:out value="${role.description}" /></gOS:subString></td>
	          				<td>
	          					<c:if test="${not subRoleList}">
									<a href="showRole.do?doMethod=showRole&id=<c:out value="${role.id}"/>">编辑</a>&nbsp;          					
	          					</c:if>
	        					<c:if test="${subRoleList}">
	        						<a href="showRole.do?doMethod=showSubRole&id=<c:out value="${role.id}"/>">编辑</a>&nbsp;
	        					</c:if>
								<a href="javascript:delectRole('<c:out value="${role.id}" />', '<c:out value="${role.name}" />')">删除</a>
							</td>
	        			</tr>
	        		</c:forEach>
                  </table>
			</form>
				 <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table-line">
					<tr> 
					  	<td align="right" class="listTable_page">
					  		<c:if test="${not subRoleList}">
								<gOS:page name="test" action="roleList.do?doMethod=roleList" pageName="dataPage" pageSizeKey="list"> 
									<gOS:param name="roleName"><c:out value="${param.roleName}"/></gOS:param>
<%-- 							  		<gOS:param name="category" ><c:out value="${param.category}"/></gOS:param> --%>
								</gOS:page>					  		
					  		</c:if>
	        				<c:if test="${subRoleList}">
	        					<gOS:page name="test" action="roleList.do?doMethod=subRoleList" pageName="dataPage" pageSizeKey="list"> 
	        						<gOS:param name="roleName"><c:out value="${param.roleName}"/></gOS:param>
<%-- 							  		<gOS:param name="category" ><c:out value="${param.category}"/></gOS:param> --%>
	        					</gOS:page>
	        				</c:if>
							
			   			</td>
			  		</tr>
			</table>
			
		  </td>
          <td width="16" background="<c:url value='/images/images_57.jpg'/>">&nbsp;</td>
        </tr>
        <tr>
          <td><img src="<c:url value='/images/images_72.jpg'/>" width="16" height="17"></td>
          <td background="<c:url value='/images/images_73.jpg'/>">&nbsp;</td>
          <td><img src="<c:url value='/images/images_75.jpg'/>" width="16" height="17"></td>
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