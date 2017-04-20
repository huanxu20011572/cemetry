<%@ page contentType="text/html; charset=GBK" %>
<%@ include file="../../../common/taglibs.jsp"%>
<%@page import="com.topsuntech.gUnit.gEU_dict.service.DynamicSelectDao" %>
<%@page import="com.topsuntech.gUnit.gEU_system.service.RoleService" %>
<%@page import="com.topsuntech.gOS.user.en.userext.Userext"%>
<%@page import="com.topsuntech.gOS.query.DBUtility"%>
<%@page import="com.topsuntech.gOS.user.session.UserSession"%>
<%@page import="com.topsuntech.gOS.sso.crypto.FormCrypto"%>
<%@ page import="com.topsuntech.gUnit.gEU_system.service.UserService" %>
<%@ page import="com.topsuntech.gOS.user.en.user.User" %>
<%
	FormCrypto.setInRandomString(session);
	FormCrypto formCrypto = new FormCrypto();
%>
<c:set value="${userQueryForm.map.quCode}" var="tQuCode" scope="page"/>
<%
	
	/*DynamicSelectDao dynamic = new DynamicSelectDao();
	String quCode = (String)pageContext.getAttribute("tQuCode");
	if(quCode != null && quCode.length() != 0){
		pageContext.setAttribute("streets", dynamic.queryBasicInfoChiler(quCode));
	}
	pageContext.setAttribute("qus", dynamic.getRegionByParentIdImp(Long.valueOf(2)));*/
	
	pageContext.setAttribute("roleList", new RoleService().findRolesByCreatorId(UserSession.getUser(request).getId()));
	
	Userext userExt = (Userext) DBUtility.load(Userext.class, UserSession.getUser(request).getId());
	request.setAttribute("rootChildrenPrioritys", RoleService.getRootChildrenPrioritysIncludeIds(userExt.getPriority()));
%>
<%    
	User user = UserSession.getUser(request);

	 UserService userService = UserService.getInstance();	 
	  String userLevel = ""; 
		    userLevel = userService.getUseLevel(user); 

%>
<html>
<head>
<title></title>
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

function submitForm(formId, action){
	var pForm = document.getElementById(formId);
	var oAction = pForm.action;
	pForm.action = action;
	pForm.submit();
	pForm.action = oAction;
}
//查询
function doQuery(){
	submitForm('myform', 'subUserQueryList.do?queryName=managedSubUsers&inputPath=subUsers');
}
//新增
function doAdd(){
	submitForm('myform', '../user_mgm/userAdd.do?action=showAdd&inputPath=subUsers');
}	
//修改用户信息
function doEditUser(userId){
	document.getElementsByName("id")[0].value = userId;
	submitForm('myform', '../user_mgm/showUser.do?doMethod=show&idyProcessService=userManager&inputPath=subUsers');
}	
//删除用户
function doDeleteUser(userId){
	document.getElementsByName("id")[0].value = userId;
	submitForm('myform', '../user_mgm/userDelete.do?action=deleteConfirm&inputPath=subUsers');
}
function singleChoosePriorityRole(userId){
	windowWithoutToolbar('../user_mgm/showChoosePriorityRole.do?doMethod=showSubChoosePriorityRole&id=' + userId, 800, 600)
}
function choosePriorityRole() {
	if (checkSelected()) {
		var pForm = document.getElementById('myform');
		openWinNoToolbarAndSubmit('../user_mgm/showChoosePriorityRole.do?doMethod=showSubChoosePriorityRole&showAppend=true', 800, 600, pForm);		
	} else {
		window.alert("请选择用户！");
	}
}
function checkSelected() {
	var idDoms = document.getElementsByName("ids");
    for (var i = 0; i < idDoms.length;i++){
    	if(idDoms[i].checked){
    		 return true;
    	}
    }
    return false;
}

function checkAll(checkDomsName, checked){
	var checkDoms = document.getElementsByName(checkDomsName);
    for (var i = 0; i < checkDoms.length;i++){
    	checkDoms[i].checked = checked;
    }
}

function setOffice(win, id, name){
	$('#deptid').val(id);
	$('#dept').val(name);
	win.close();
}
function selectOffice() {
	windowWithoutToolbar("<c:url value="/tree/office_choose.jsp?type=2&idStr="/>" + $('#deptid').val(), 300, 600, true);
}
function clearOffice(){
	$('#deptid').val('');
	$('#dept').val('');
}

function setPriority(priorityId, priorityName){
	$('#priorityId').val(priorityId);
	$('#priorityName').val(priorityName);
}
function selectPriority(){
    windowWithoutToolbar("../user_mgm/priority_choose.jsp", 300, 600, true);
}
function clearPriority(){
	$('#priorityId').val('');
	$('#priorityName').val('');
}
/*$(function() {
var url = '<c:url value="/main/system/dict_mgm/dynamicSelect.do?action=findNodes&"/>' + new Date().getTime();
var region=$("select[name=quCode]");
var childer=$("select[name=streetCode]");
  region.bind("change", function(){
		var childVal=$(this).val();
		if(childVal=='' || childVal.length<1){		
		 return;
		}
	url = '<c:url value="/main/system/dict_mgm/dynamicSelect.do?action=findChilderNodes&parentCode="/>' + childVal+"&"+new Date().getTime();	
	childer.empty();
	childer.append('<option  value="">请选择</option>');
	 $.getJSON(url, function(data){
		$.each(data, function(i,item){
		 var option	= $('<option value="' + item.regionCode + '">' + item.name + '</option>');
			childer.append(option);
		  });
	  childer.attr('selectedIndex' , 0);	  
	});
	 	
 });
})*/
var roles = [];
function changeCategory(categoryDom, roleId){
	var roleSelect = $('#roleIdSelect').get(0);
	roleSelect.options.length = 0;
	roleSelect.options.add(new Option('请选择角色名称', ''));
	if(categoryDom.value){
		for(var i = 0; i < roles.length; i++){
			if(roles[i].category == categoryDom.value){
				var opt = new Option(roles[i].name, roles[i].id);
				roleSelect.options.add(opt);
				if(roleId == roles[i].id){
					opt.selected = true;
				}
			}
		}
	}
}
function doOnLoad(){
	<c:forEach var="role" items="${roleList}">
    	roles[roles.length] = {id:'<c:out value="${role.id}"/>', name:'<c:out value="${role.name}"/>', category:'<c:out value="${role.category}"/>'};
 	</c:forEach>
 	$('#category').change(function(){
 		changeCategory(this);
 	});
 	changeCategory($('#category').get(0), '<c:out value="${userQueryForm.map.roleId}"/>');
}
</script>
<body onLoad="doOnLoad()">
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="11" height="31" valign="top" class="td-bg"><img src="../../../images/right-1.jpg" /></td>
    <td align="center" valign="top" ><table width="100%" border="0" cellpadding="0" cellspacing="0" class="word-8">
      <tr>
        <td height="31" align="left" valign="middle" style="background:url(../../../images/right-3.jpg)"><img src="../../../images/right-4.jpg" width="9" height="8" align="absmiddle" /> 当前位置 &gt; 子系统管理 &gt; 下属子系统管理员</td>
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
	<td>
		<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
	      <tr>
	        <td width="45" align="left" background="../../../images/images_49.jpg"><img src="../../../images/images_48.jpg" width="38" height="40"></td>
	        <td background="../../../images/images_49.jpg" class="title"><strong>用户管理</strong>&nbsp;&nbsp;&nbsp;&nbsp;<!-- <a href="../../../download/xmjs.zip"><font color="#FF3300" size="3">用户及权限管理系统建设情况简介</font></a>&nbsp;&nbsp;<a href="../../../download/ca.zip"><font color="#FF3300" size="3">数字证书系统培训材料</font></a>&nbsp;&nbsp;<a href="../../../download/yhsc.zip"><font color="#FF3300" size="3">用户权限系统培训材料</font></a>&nbsp;<a href="../../../download/video.zip"><font color="#FF3300" size="3">系统管理视频</font></a> --></td>
	       
	        <td width="16" align="right" background="../../../images/images_49.jpg"></td>
	      </tr>
	    </table>
   
		<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td width="16" background="../../../images/images_55.jpg">&nbsp;</td>
          <td align="center">
          
		  <form  id="myform" name="myform" method="post">
		  	<input type="hidden" name="id" value="" >
		  		<table width="100%" border="0" cellspacing="0" cellpadding="0">
		  			<tr><td>&nbsp;</td></tr>
                    <tr> 
          				<td>
		          			<table width="100%" border="0" cellpadding="1" cellspacing="1" bgcolor="a8d1eb">
		              		<tr> 
		              			<td nowrap align="right" class="td-01" >用户姓名：</td>
						      	<td class="td-02">
					          		<input class="input_txt" name="userName" type="text" size="20"  value="<c:out value="${userQueryForm.map.userName}" />" >
							    </td>
						        <td nowrap align="right" class="td-01" >所属机构：</td>
						      	<td class="td-02">
							      	<table>
							      		<tr>
							      			<td>
						      					<input id="dept" name="dept" height="25" class="input" type="text" readonly value="<c:out value="${userQueryForm.map.dept}"/>" size="20" >
												<input id="deptid" name="deptid" type="hidden" value="<c:out value="${userQueryForm.map.deptid}"/>">
											</td>
											<td>
							            	 <a href="javascript:" onClick="selectOffice()" title=请选择部门><img src="../../../images/anniu_1_03.gif" border="0" ></a> 
							            	  <a href="javascript:" onClick="clearOffice()" title=清除选择部门><img src="../../../images/anniu_1_05.gif" border="0"></a>	
							            	</td>
							            </tr>
							          </table>														      			
						      	</td>
						      	<td  height="23" align="right" class="td-01">权限名称：</td>
							     <td class="td-02" height="25"> 
				                      	<table>
								      		<tr>
							      				<td>
							      					<input height="25" readonly id="priorityName" name="priorityName" class="input" type="text" value="<c:out value="${userQueryForm.map.priorityName}"/>" size="20" >
													 <input id="priorityId" name="priorityId" type="hidden" value="<c:out value="${userQueryForm.map.priorityId}"/>">
												</td>
												<td>
								            	  	<a href="javascript:" onClick="selectPriority()" title=请选择权限><img src="../../../images/anniu_1_03.gif" border="0" ></a> 
								            	  	<a href="javascript:" onClick="clearPriority()" title=清除选择权限><img src="../../../images/anniu_1_05.gif" border="0"></a>	
								            	</td>
								            	
								            </tr>
								          </table>	
								  </td>  										       										      
							</tr>													        
						    <tr height="22" >
						    	
							    	<td nowrap align="right" class="td-01" >子系统：</td>
							        <td class="td-02" align="left"> 
							        	<select id="category" name="category" style="vertical-align: middle;">
						          			<option value=''>请选择子系统</option>
						          			<c:forEach items="${rootChildrenPrioritys}" var="pri" varStatus="status">
						          				<option value='<c:out value="${pri.value}"/>' <c:if test='${pri.value eq userQueryForm.map.category }'>selected="true"</c:if> ><c:out value="${pri.value}"/></option>
						          			</c:forEach>
						          			<option value='跨子系统' <c:if test='${"跨子系统" eq userQueryForm.map.category }'>selected="true"</c:if>>跨子系统</option>
				          				</select>
								     </td>
									<td nowrap="nowrap" align="right" class="td-01" >角色名称：</td>
							        <td class="td-02" align="left">
							        	<select id="roleIdSelect" name="roleId" style="vertical-align: middle;"></select>															        
								     </td>
								     <td align="right" class="td-02" colspan="2">
					            		<a href="javascript:"><img alt='查询' src='../../../images/but-serch.jpg ' border="0" onClick="doQuery();return false;"></a>
					            		   <%if(userLevel != null && !userLevel.equals("")){%>
                                               <%if(userLevel.equals("2")){%>
											   <a href="javascript:"><img alt='添加用户' src='../../../images/but-tj.gif ' border="0" onClick="doAdd();return false;" ></a> <%}%>
										  <%}%>
					            	</td>
							</tr>
		           			</table>
		            </td>
		        </tr>
		        <tr>					       
					<td align="left">
						<input type="checkbox" onClick="checkAll('ids', this.checked)">全选&nbsp;
						<a href="javascript:" onClick="choosePriorityRole();">批量授权</a>
					</td>
				</tr>
           </table>
           <table width="100%" border="0" cellpadding="1" cellspacing="1" bgcolor="a8d1eb">
             <tr> 
             	<TD  width="4%" align="center" class="td-04">&nbsp;									        	
		        	
		     	</TD>
               <td width="4%" height="30" align="center" class="td-04">序号</td>
               <td width="12%" align="center" class="td-04">用户姓名</td>
				<td width="23%" align="center" class="td-04">所属机构</td>
				<td width="23%" align="center" class="td-04">所在处室</td>
				 <td width="8%" align="center" class="td-04">职务</td>
				  <td width="8%" align="center" class="td-04">联系电话</td>
      
               <td  align="center" class="td-04">操作</td>
             </tr>
				<c:forEach var="user" items="${userList}"  varStatus="ctIndex" >
					<% String trClass = "";%>
					<c:if test="${ctIndex.count%2==1}"><%trClass = "td-02";%></c:if>
					<c:if test="${ctIndex.count%2==0}"><%trClass = "td-01";%></c:if>
				 	<tr height="25" align="center" class="<%=trClass%>">
						<TD align="center" ><input type="checkbox" name="ids" value="<%=formCrypto.encryptSupportEl("${user.id}", session, pageContext)%>"></TD>												  		
						<TD height="22" align="center" ><c:out value='${ctIndex.index + 1 + (pageBean.pageSize * (pageBean.currentPage - 1))}'/></TD>	
			            <TD height="22" align="center" ><c:out value='${user.name}'/></TD>
			            <TD height="22" align="center" ><gOS_shjz:dictOrgValue key="${user.workdeptid}" /></TD>								           			
			            <TD height="22" align="center" ><gOS_shjz:dictOrgValue key="${user.deptid}" /></TD>		
			            <TD height="22" align="center" ><c:out value='${user.positionid}'/></TD>	
		           		<TD height="22" align="center" ><c:out value='${user.officephone}'/></TD>	
		           		<TD height="22" align="center" >
				          <%if(userLevel != null && !userLevel.equals("")){%>
                              <%if(userLevel.equals("2")){%>
							 <a href="javascript:" onClick="doEditUser('<c:out value='${user.id}'/>');return false;">修改</a>&nbsp;
							<a href="javascript:" onClick="doDeleteUser('<c:out value='${user.id}'/>');return false;">删除</a>&nbsp;
							<%}%>
						<%}%>
							<a href="javascript:" onClick="singleChoosePriorityRole('<%=formCrypto.encryptSupportEl("${user.id}", session, pageContext)%>');">授权</a> 	
            			</TD>       								            
		         	</TR>
			    </c:forEach>	
         </table>
           
       
			
		</form>	
				 <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table-line">
					<tr> 
					  <td align="right" class="listTable_page">
						  <gOS:page name="test" action="subUserQueryList.do?queryName=managedSubUsers" pageName="pageBean" pageSizeKey="list">
							  <gOS:param name="quCode"><c:out value="${userQueryForm.map.quCode}"/></gOS:param>
							  <gOS:param name="streetCode" ><c:out value="${userQueryForm.map.streetCode}"/></gOS:param>
							  <gOS:param name="loginId"><c:out value="${userQueryForm.map.loginId}"/></gOS:param>
							  <gOS:param name="userName"><c:out value="${userQueryForm.map.userName}"/></gOS:param>
							  <gOS:param name="dept"><c:out value="${userQueryForm.map.dept}"/></gOS:param>
							  <gOS:param name="deptid"><c:out value="${userQueryForm.map.deptid}"/></gOS:param>
							  <gOS:param name="priorityId"><c:out value="${userQueryForm.map.priorityId}" /></gOS:param>
				              <gOS:param name="priorityName"><c:out value="${userQueryForm.map.priorityName}" /></gOS:param>
				              <gOS:param name="category"><c:out value="${userQueryForm.map.category}"/></gOS:param>
				              <gOS:param name="roleId"><c:out value="${userQueryForm.map.roleId}" /></gOS:param>
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