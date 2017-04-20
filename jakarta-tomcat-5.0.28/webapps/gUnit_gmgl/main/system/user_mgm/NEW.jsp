<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib uri="http://www.topsuntech.com/jsptags/tree-taglib" prefix="topsuntech" %>
<%@ taglib uri="/WEB-INF/tld/gTaglib-gOS.tld" prefix="gOS" %>
<%@page import="com.topsuntech.gOS.user.session.*" %>
<%@page import="com.topsuntech.gOS.user.en.user.*" %>
<%@page import="com.topsuntech.gOS.user.en.office.Office" %>
<%@page import="com.topsuntech.gOS.config.user.userXuewei.dao.UserXueweiFactory" %>
<%@page import="com.topsuntech.gOS.config.user.userZhicheng.dao.UserZhichengFactory" %>
<%@page import="java.util.Collection" %>

<% 
	request.setCharacterEncoding("GBK");	
   	String backurl="userSelect.do?";
   	String addDeptId=request.getParameter("addDeptId"); 
   	if(addDeptId==null)
   	addDeptId="";   	
        if(addDeptId=="")
        	backurl+="action=list";
        else
       	{	backurl+="action=listByDept&id=";
        	backurl+=addDeptId;
        	}
        	
            
%>
<%
	User user = UserSession.getUser(request);
	long creatorId = 2;
	String creatorName = "root";
	if (user!=null) {
		creatorId = user.getId().longValue();		
		creatorName = user.getName();
		
	}
	
	Office off = UserSession.getUserDept(request); 	
	long regionId = off.getRegionid();
	
%>

<html>
<head>
<title>Untitled Document</title>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<link href="../../css/css.css" rel="stylesheet" type="text/css">

<script src="../../../script/ua.js"></script>
<script src="../../../script/functionforcheck.js"></script>
<script src="../../../script/calendar.js"></script>
<script src="../../../script/publics.js"></script>
<script src="../../../script/common.js"></script>

<script language="JavaScript">

function onSubmit() {	 
	 var IsValid=true;
	 if(!checkLoginid(myform.loginid.value))
	 {
	 	document.all("label0").innerHTML="<font color=\"ff0000\">用户id不正确</font>";
	 	IsValid=false;
	 }
	
	
	 if(myform.password.value.length<3)
	 {
	 	document.all("pwdlbl").innerHTML="<font color=\"ff0000\">密码长度太短</font>";
	 	IsValid=false;
	 }
	 else
	 document.all("pwdlbl").innerHTML="";
	 if(myform.cfmpwd.value!=myform.password.value)
	 {
	 	document.all("cfmpwdlbl").innerHTML="<font color=\"ff0000\">密码不一致</font>";
	 	IsValid=false;
	 }
	 else
	 document.all("cfmpwdlbl").innerHTML="";
	 if(myform.dept.value=="")
	 {
	 	document.all("deptlbl").innerHTML="<font color=\"ff0000\">请选择部门</font>";
	 	IsValid=false;
	 }
	 else
	 document.all("deptlbl").innerHTML="";
	 if(myform.workdept.value=="")
	 {
	 	document.all("workdeptlbl").innerHTML="<font color=\"ff0000\">请选择工作部门</font>";
	 	IsValid=false;
	 }
	 else
	 document.all("workdeptlbl").innerHTML="";
	 if(myform.name.value=="")
	 {	
	 	document.all("namelbl").innerHTML="<font color=\"ff0000\">请填写姓名</font>";
	 	IsValid=false;
	 }
	 else
	 document.all("namelbl").innerHTML="";
	 
	
	 if(!checkLength(myform.memo.value, 0, 150)){
		document.all("deslbl").innerHTML="<font color=\"ff0000\">用户描述过长（小于150字符）</font>";
		IsValid=false;
	 }
	 else 
	 document.all("deslbl").innerHTML="";
	 
	 if(myform.identitynum.value=="")
	 {	
	  //	document.all("namelbl").innerHTML="<font color=\"ff0000\">请填写身份证号码</font>";
	 	IsValid=false;
	 }
	 else
	 document.all("namelbl").innerHTML="";
	 
	 
	 
	 if(IsValid)	 		
	 myform.submit();
	 
}
function onSubmitPrio(){
	var prios=",";
	if(myform.prioritys.value!=""){
		prios=myform.prioritys.value;
	}
	windowWithoutToolbar('userChoose.do?action=actorChoose&prios='+prios,600, 500);
	
}

function openTree(objForm,regionId,objId,objName) {
	/*
	var strUrl = "../public/select_email_address.jsp?userId=<c:out value="${sessionScope.loginUser.id}"/>&formName=form1&objId="+objId+"&objName="+objName;
	var strBuild = "toolbar=no,width=300,height=600,directories=no,status=no,scrollbars=yes,resize=no,menubar=no";
	CreateWindow(strUrl, "treeWin", strBuild);
	*/
	
	var strBuild = "toolbar=no,width=300,height=600,directories=no,status=no,scrollbars=yes,resize=no,menubar=no";
	var treeRootId = regionId;
	var treeType = "701";
	
	var strUrl = "../../../tree/select_dept_tree.jsp?objForm=" + objForm;
	    
	    strUrl += "&treeRootId=" + treeRootId; 	     
	    strUrl += "&objId=" + objId; 	     
			strUrl += "&objName=" + objName;
			strUrl += "&treeType=" + treeType;	
			
		
	CreateWindow(strUrl, "treeWin", strBuild);
	//window.open(strUrl, '','');
	
}


</script>
</head>
<body>
	<form action="userAdd.do?action=add" name="myform" method="post">

	<input type="hidden" name="creatorid" value="<%=creatorId%>">
	<input name="users" type="hidden" value="">
	<input name="emailid" type="hidden" value="">
	<input name="cansms" type="hidden" value="">
	<input name="registstatus" type="hidden" value="2">
	
	<input type="hidden" name="parentid" value="">
	<input type="hidden" name="specifyDeptId" value="<%=addDeptId%>">
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="11" background="../../../images/images_32.jpg"><img src="../../../images/content_left.gif" width="11" height="51"></td>
    <td height="51" background="../../../images/images_32.jpg"><table width="70%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="22" height="16" align="center"><img src="../../../images/d.gif" width="14" height="14"></td>
          <td valign="bottom"> 当前位置：</td>
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
		
				<form  id="myform" name="myform" action="" method="post"  onSubmit="return templateListSubmit(this)">
					  <input type="hidden" name="prioritys" value="" >
						<table width="100%" border="0" cellpadding="0" cellspacing="0"  height="86%" style="padding-left:5px;padding-right:5px">						
							<tr>
								<td height="22" >
									
									 <table width="100%" border="0" cellpadding="0" cellspacing="0">
									  <tr id="schTable" style="display:play">
									    <td>
									   			  			 
												<span class="submenu" id="sub1">
													<div style = "width:100%;height:35;overflow:auto " id="masterdiv" class="table1">
														<table border="0" width="100%">
											   	  	<tr>
											        	<td>
											        		
																	<table  border="0" cellpadding="0" cellspacing="0" width="100%">
													        	<tr height="22" > 
													        		<td  height="23" align="right" >登录名称:</td>
								                      <td > 
								                      	<input class="input_txt" name="loginId" type="text"  value="<c:out value="${param.loginId}" />">
								                      	
								                      </td>  
															      	<td nowrap align="right" > 用户姓名：
															      	</td>
															      	<td >
														          	<input class="input_txt" name="name" type="text" size="20"  value="<c:out value="${param.name}" />" >
																      </td>   
															        <td >    															       
															       			<input class="input_btn" type="button" name="btQuery"  value="查 询"  onclick="doQuery()">
															        </td>
															        <td >    															       
															       			<input class="input_btn" type="button" name="btAdd"  value="新 增"  onclick="doAdd()">
															        </td>  
															         																      
														        </tr>
														      </table>
													     	</td>
											     		</tr>
											  		</table>
												 	</div>
												</span>
									  
									  
										 </td>
									  </tr>
									
						  <tr valign="top" width="100%"  border="0">
						    <td  valign="top" height="300">			
									
									<DIV style = "overflow:auto;width:100%;height:100%" id="tableContainer" class="tableContainer" > 
						   	 		
									<TABLE type="grid" border="0"  style="table-layout:fixed;"    name= "listTable" id = "listTable" cellpadding="1" cellspacing="1" bgcolor="a8d1eb"> 
									 <COLGROUP nowrap = "true">
									 		<COL style="width:24;height:22;display: " /> 
										  <COL style="display:;word-break:keep-all;width:30"; />
							    		<COL style="display:;word-break:keep-all;width:150"; />
							    		<COL style="display:;word-break:keep-all;width:120"; />		
							    		<COL style="display:;word-break:keep-all;width:120"; />						    		
							    		<COL style="display:;word-break:keep-all;width:100%;" />
								    </COLGROUP>
								    
									  <thead class="fixedHeader">
									  	<TR height="22" align="center" nowrap="true" class="list_title">
									    	<TD class="td-01">									        	
									        	<input type="checkbox" name="allbox" onClick="checkAll(this,ids)">
									     	</TD>
								        <TD dataType ="VARCHAR" class="td-01">序号</TD>                    
								        <TD dataType ="VARCHAR" class="td-01">所属机构名称</TD>          
								        <TD dataType ="VARCHAR" class="td-01">用户姓名</TD>
								        <TD dataType ="VARCHAR" class="td-01">登录名称</TD>
								        <TD dataType ="VARCHAR" class="td-01">操作</TD>
									  	</TR>   
									 	</thead>
									 	<TBODY id ='listTableBody' name= "listTableBody" class="scrollContent">
									    	<c:forEach var="user" items="${userList}"  varStatus="ctIndex" >
											  	<TR height="22" nowrap class="list_tr1"> 
											  		<TD align="center" class="td-02"><input type="checkbox" name="ids" value="<c:out value='${user.id}'/>"></TD>				  														  		
											  		<TD height="26" align="center" class="td-02"><c:out value='${ctIndex.index+1+(projectPage.pageSize*(projectPage.currentPage-1))}'/></TD>	
								            <TD height="26" align="center" class="td-02"><gOS_shjz:dictOrgValue key="${user.workdeptid}" /></TD>								           			
								            <TD height="26" align="center" class="td-02"><c:out value='${user.name}'/></TD>
								            <TD height="26" align="center" class="td-02"><c:out value='${user.loginid}'/></TD>	
								            <TD height="26" align="center" class="td-02">
								            	<a href="javascript: doEditUser(<c:out value='${user.id}'/>)">修改资料</a>&nbsp;&nbsp;								            
								            	<a href="javascript: doDeleteUser(<c:out value='${user.id}'/>)">删除用户</a>
								            	<a href="javascript: doEditUserRight(<c:out value='${user.id}'/>)">修改权限</a>
								            	<a href="javascript: doEditUserRightByRole(<c:out value='${user.id}'/>)">按角色修改权限</a>										
								            </TD>	
										            								            
								         	</TR>
									    	</c:forEach>	
									           	        
						
											
						  
									  </TBODY>
									  
									</TABLE>
							  	</div>				
						 
						   	</td>
						  </tr> 
						</table>
						</form> 			
			</td>
	</tr>
	

</table>
	</td>
  
	

</tr>
 </table> 
</form>
</body>
</html>
