<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<%@ taglib uri="/WEB-INF/tld/gTaglib-gOS.tld" prefix="gOS" %>
<%@ taglib uri="/WEB-INF/tld/gTaglib-shjz.tld" prefix="gOS_shjz" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/gTaglib-shjz.tld" prefix="shjz" %>
<%@ taglib uri="/WEB-INF/tld/gTaglib-shjz.tld" prefix="gUnit_shjz" %>
<%@ taglib uri="/WEB-INF/tld/gTaglib-mjzz.tld" prefix="gEU_mjzz" %>
<%@ taglib uri="html-el" prefix="html-el" %>

<%@page import="com.topsuntech.gOS.sso.crypto.FormCrypto"%>
<%
	FormCrypto.setInRandomString(session);
	FormCrypto formCrypto = new FormCrypto();
%>

<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<meta http-equiv="Cache-Control" content="no-store"/>
<meta http-equiv="Pragma" content="no-cache"/>
<meta http-equiv="Expires" content="0"/>

<link href="/ajjwork/css/css.css" rel="stylesheet" type="text/css">

<script src="/ajjwork/script/action.js" language="JScript"></script>
<script src="/ajjwork/script/toolbar-ie5.js" language="JScript"></script>
<link href="/ajjwork/script/toolbar-ie5.css" type="text/css" rel="stylesheet">
<xml id="xsl" src="/ajjwork/script/toolbar-ie5.xsl"></xml>
<script src="/ajjwork/script/ua.js"></script>
<script src="/ajjwork/script/function.js"></script>
<script src="/ajjwork/script/publics.js"></script>
<script src="/ajjwork/script/page.js"></script>
<script type="text/javascript" src="/ajjwork/script/jquery.js"></script>
<script type="text/javascript" src="/ajjwork/script/linkageSelect.js"></script>
<script type="text/javascript" src="/ajjwork/script/location.js"></script>	
<%@page import="com.topsuntech.gOS.user.session.*" %>
<%@page import="com.topsuntech.gOS.user.en.user.*" %>
<%
	User user = UserSession.getUser(request);
	
	String thisloginId = user.getLoginid();		
				
%>
</head>

<script language="JavaScript" src="/ajjwork/script/hints.js"></script>
<!-- Link Tigra Hints configuration file to your HTML document-->
<script language="JavaScript" src="/ajjwork/script/hints_cfg.js"></script>
<script language="javascript">

	
	//查询
	function doQuery(){
		var strForm = document.myform;
		var loginId = strForm.loginId.value;
		var name = strForm.name.value;
		
		
		
		strForm.action= "/ajjwork/tree/doQueryUserAllList.do?method=listAllUser&inputPath=allList";
		strForm.submit();
		
	}
	
	//新增
	function doAdd(){
		var strForm = document.myform;
		var strUrl = "/ajjwork/main/system/user_mgm/userAdd.do?action=showAdd&inputPath=allList";
		
		strForm.action= strUrl;
		strForm.submit();
		
		
	}	
	
	//修改用户信息
	function doEditUser(userId){
		
		var strForm = document.myform;
		var strBuild = "toolbar=no,width=800,height=500,directories=no,status=no,scrollbars=yes,resize=no,menubar=no";
		//var strUrl = "/ajjwork/main/system/user_mgm/userUpdate.do?action=showUpdate&id=" + userId;
		var strUrl = "/ajjwork/main/system/user_mgm/showUser.do?doMethod=show&idyProcessService=userManager&id=" + userId+"&inputPath=allList";
		
		//window.open(strUrl,'','');
				
		strForm.action= strUrl;
		strForm.submit();
		
		//CreateWindow(strUrl, "treeWin", strBuild);
		
	}	
	
	//删除用户
	function doDeleteUser(userId){
		var strForm = document.myform;		
		var strUrl = "/ajjwork/main/system/user_mgm/userDelete.do?action=deleteConfirm&id=" + userId+"&inputPath=allList";
						
		strForm.action= strUrl;
		strForm.submit();		
		
	}		
	
	//修改用户权限
	function doEditUserRight(userId){
		var strForm = document.myform;		
	  var strBuild = "toolbar=no,width=600,height=600,directories=no,status=no,scrollbars=yes,resize=no,menubar=no";
		var strUrl = "/ajjwork/main/system/user_mgm/userChoose.do?action=actorChoose&userId=" + userId;
						
		CreateWindow(strUrl, "treeWin", strBuild);		
		
	}		
	
	//修改用户权限通过角色
	function doEditUserRightByRole(userId){
		var strForm = document.myform;		
		
	  var strBuild = "toolbar=no,width=800,height=400,directories=no,status=no,scrollbars=yes,resize=no,menubar=no";
		var strUrl = "toUserRoleList.do?method=list&userId=" + userId;
	  
		CreateBuildBlankWindow(strUrl, 600, 800);		
		
	}			
	

		
	//编辑扩展信息--邮件用户名,邮件密码等
	function doUpdateUserEamil(userId){
		var strForm = document.myform;		
		var strUrl = "../tree/showUserEmail.do?method=userEmail&userId=" + userId;
		
    CreateBuildBlankWindowuse(strUrl, 60, 350);		
    
	}			
	
	
	
</script>
<script type="text/javascript">
$(function() {
var url='../main/system/dict_mgm/dynamicSelect.do?action=findNodes&'+new Date().getTime();
var region=$("#quId");
var childer=$("#streetId");
  region.bind("change", function(){
		var childVal=$(this).val();
		if(childVal=='' || childVal.length<1){		
		 return;
		}
	url='../main/system/dict_mgm/dynamicSelect.do?action=findChilderNodes&parentCode='+childVal+"&"+new Date().getTime();	
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



})


function openTree(objForm,regionId,objId,objName) {
	/*
	var strUrl = "../public/select_email_address.jsp?userId=<c:out value="${sessionScope.loginUser.id}"/>&formName=form1&objId="+objId+"&objName="+objName;
	var strBuild = "toolbar=no,width=300,height=600,directories=no,status=no,scrollbars=yes,resize=no,menubar=no";
	CreateWindow(strUrl, "treeWin", strBuild);
	*/
	
	var strBuild = "toolbar=no,width=300,height=600,directories=no,status=no,scrollbars=yes,resize=no,menubar=no";
	var treeRootId = regionId;
	var treeType = "701";
	
	var strUrl = "../tree/select_dept_tree.jsp?objForm=" + objForm;
	    
	    strUrl += "&treeRootId=" + treeRootId; 	     
	    strUrl += "&objId=" + objId; 	     
			strUrl += "&objName=" + objName;
			strUrl += "&treeType=" + treeType;	
			
		
	CreateWindow(strUrl, "treeWin", strBuild);
	//window.open(strUrl, '','');
	
}


function checkproperty(){
    
    var strUrl = "../main/system/user_mgm/priority_choose.jsp"
    CreateBuildBlankWindow(strUrl,'600','250','yes');	
    
}
function cleara(){
var strform = document.myform;
var deptName=strform.dept;
deptName.value="";	
strform.deptid.value="";
 
}

function clearq(){
var strform = document.myform;
var quanxian=strform.quanxian;
quanxian.value="";	
strform.quanxianid.value="";
 
}
function choosePriorityRole() {
	if (checkSelected()) {
		var pForm = document.getElementById('myform');
		openWinNoToolbarAndSubmit('<c:url value="/main/system/user_mgm/showChoosePriorityRole.do?doMethod=showChoosePriorityRole"/>', 800, 600, pForm);		
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
	
</script>
<body>
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="11" background="../images/images_32.jpg"><img src="../images/content_left.gif" width="11" height="51"></td>
    <td height="51" background="../images/images_32.jpg">
    	<table width="70%" border="0" cellspacing="0" cellpadding="0">
	      <tr>
	        <td width="22" height="16" align="center"><img src="../images/d.gif" width="14" height="14"></td>
	        <td valign="bottom"> 当前位置：超级系统管理 → <b>用户管理</b></td>
	      </tr>	
    	</table>
    </td>
  </tr>
  <tr>
    <td background="../images/images_481.jpg">&nbsp;</td>
    <td valign="top">
	<table border="0" cellspacing="0" cellpadding="0" width="100%">
		
		<tr id="tag1">
			<td>
			<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td width="45" align="left" background="../images/images_49.jpg"><img src="../images/images_48.jpg" width="38" height="40"></td>
        <td background="../images/images_49.jpg" class="title"><strong>用户管理</strong></td>
        
        <td width="16" align="right" background="../images/images_49.jpg"></td>
      </tr>
    </table>
   
<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
<tr>
<td width="16" background="../images/images_55.jpg">&nbsp;</td>
<td align="center">

	<form id="myform" name="myform" method="post">
		<input type="hidden" name="prioritys" value="" >
	
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
        
        <tr> 
          <td>&nbsp;</td>
        </tr>
        <tr> 
          <td><table width="100%" border="0" cellpadding="1" cellspacing="1" bgcolor="a8d1eb">
              	<tr  > 
										        		<td   align="right" class="td-01">所在区县：</td>
					                      <td class="td-02"> 
					                      	<html-el:select property="quId" value="${param.quId}" styleId='quId'  style="width:100px;">
            <html:option value="">请选择</html:option>
            <html:options collection="quIds" property="label" labelProperty="value"/>
        </html-el:select>
					                      </td>  
												      	<td nowrap align="right" class="td-01">所在街道：
												      	</td>
												      	<td class="td-02">
												      				<html-el:select property="streetId"  styleId='streetId' value="${param.streetId}"style="width:100px;">
            <html:option value="">请选择</html:option>
            <html:options collection="streetIds" property="label" labelProperty="value"/>
        </html-el:select>
												      	</td>   
												        <td nowrap align="right" class="td-01" >所在部门：
												      	</td>
												      	<td class="td-02" >
														      		<table>
														      			<tr>
														      				<td>
														      					<input height="25" readonly name="dept" class="input" type="text"value="<c:out value="${deptName}"/>" size="23" >
       																			 <input name="deptid" type="hidden" value="<c:out value="${param.deptid}"/>">
       																	</td>
       																<td>
														            	 <a href="javascript: openTree('myform','','deptid','dept')"  title=请选择部门><img src="../images/anniu_1_03.gif" border="0" ></a> 
														            	  <a href="javascript:cleara()" title=清除选择部门><img src="../images/anniu_1_05.gif" border="0"></a>	
														            	</td>
														            </tr>
														          </table>														      			
												      	</td> 														       										      
											        </tr>
										        	<tr height="22" > 
										        		<td  height="23" align="right" class="td-01">登录名称：</td>
					                      <td class="td-02"> 
					                      	<input class="input_txt" name="loginId" type="text"  value="<c:out value="${param.loginId}" />">
					                      	
					                      </td>  
												      	<td nowrap align="right" class="td-01" > 用户姓名：
												      	</td>
												      	<td class="td-02">
											          	<input class="input_txt" name="name" type="text" size="20"  value="<c:out value="${param.name}" />" >
													      </td>   
												        <td nowrap align="right" class="td-01" > 角色名称：
												      	</td>
												        <td class="td-02" align="left"> 
												           <gOS:select name="roleId" styleClass="table-01-tr2" items="${roleList}" keyProperty="id"  valueProperty="name" selected="${roleId}">   												
									                           <gOS:option key="-1" value="请选择角色名称" />
									                       </gOS:select>															        
													        </td> 														         													      
											        </tr>														        
											        <tr height="22" > 
										        		<td  height="23" align="right" class="td-01">权限名称：</td>
					                      <td class="td-02" colspan="5" height="23"> 
					                      	<table>
									      			<tr>
									      				<td>
									      					<input height="25" readonly id="quanxian" name="quanxian" class="input" type="text" value="<c:out value="${quanxian}"/>" size="23" >
															 <input name="quanxianid" id="quanxianid" type="hidden" value="">
													</td>
												<td>
									            	 <a href="javascript: checkproperty()"  title=请选择权限><img src="../images/anniu_1_03.gif" border="0" ></a> 
									            	  <a href="javascript:clearq()" title=清除选择权限><img src="../images/anniu_1_05.gif" border="0"></a>	
									            	</td>
									            	
									            	<td align="right">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" onClick="doQuery();"><img alt='查询' src='../images/but-serch.jpg ' border=nostyle='vertical-align:middle'></a>&nbsp;<a href="/ajjwork/main/system/user_mgm/userAdd.do?action=showAdd&inputPath=allList" ><img alt='添加用户' src='../images/but-tj.gif ' border=nostyle='vertical-align:middle'></a>
									            	</td>
									            </tr>
									          </table>	
								</td>  															         													      
							 </tr>						  				  
            </table></td>
        </tr>
        
		<tr>
			<td align="left">
				<input type="checkbox" onClick="checkAll('ids', this.checked)">全选&nbsp;
				<a href="javascript:;" onclick="choosePriorityRole();">批量授权</a>
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
					<TD height="22" align="center" ><c:out value='${ctIndex.index+1+(dataPage.pageSize*(dataPage.currentPage-1))}'/></TD>	
		            <TD height="22" align="center" ><c:out value='${user.name}'/></TD>
		            <TD height="22" align="center" ><gOS_shjz:dictOrgValue key="${user.workdeptid}" /></TD>							     		
		            <TD height="22" align="center" ><gOS_shjz:dictOrgValue key="${user.deptid}" /></TD>		
		            <TD height="22" align="center" ><c:out value='${user.positionid}'/></TD>	
		            <TD height="22" align="center" ><c:out value='${user.officephone}'/></TD>	
		            <TD height="22" align="center" >
		            	<a href="/ajjwork/main/system/user_mgm/showUser.do?doMethod=show&idyProcessService=userManager&id=<c:out value='${user.id}'/>&inputPath=allList">编辑</a>&nbsp;
						<a href="/ajjwork/main/system/user_mgm/userDelete.do?action=deleteConfirm&id=<c:out value='${user.id}'/>&inputPath=allList">删除</a>&nbsp;
						<a href="javascript:windowWithoutToolbar('<c:url value="/main/system/user_mgm/showChoosePriorityRole.do?doMethod=showChoosePriorityRole&id="/><%=formCrypto.encryptSupportEl("${user.id}", session, pageContext)%>', 800, 600)">授权</a> 
		            </TD>							            
		      </tr>
		 </c:forEach>	
      </table>
               
			</form>
				 <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table-line">
					<tr> 
					  	<td align="right" class="listTable_page">
						 <gOS:page name="test" action="doQueryUserAllList.do?method=listAllUser" pageName="dataPage" pageSizeKey="list">
				          	<gOS:param name="quId"><c:out value="${param.quId}" /></gOS:param>
				            <gOS:param name="streetId"><c:out value="${param.streetId}" /></gOS:param>
				            <gOS:param name="loginId"><c:out value="${param.loginId}" /></gOS:param>
				            <gOS:param name="name"><c:out value="${param.name}" /></gOS:param>
				            <gOS:param name="deptid"><c:out value="${param.deptid}" /></gOS:param>
				            <gOS:param name="roleId"><c:out value="${param.roleId}" /></gOS:param>
				            <gOS:param name="quanxianid"><c:out value="${param.quanxianid}" /></gOS:param>
				            <gOS:param name="quanxian"><c:out value="${param.quanxian}" /></gOS:param>
				          </gOS:page>
			   			</td>
			  		</tr>
			</table>
			
		  </td>
          <td width="16" background="../images/images_57.jpg">&nbsp;</td>
        </tr>
        <tr>
          <td><img src="../images/images_72.jpg" width="16" height="17"></td>
          <td background="../images/images_73.jpg">&nbsp;</td>
          <td><img src="../images/images_75.jpg" width="16" height="17"></td>
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