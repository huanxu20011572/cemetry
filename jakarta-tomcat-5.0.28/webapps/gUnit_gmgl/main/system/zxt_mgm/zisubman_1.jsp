<%@ page contentType="text/html; charset=GBK" %>
<%@ include file="../../../common/taglibs.jsp"%>
<%@ taglib uri="/WEB-INF/tld/topsuntech-tree.tld" prefix="topsuntech" %>
<link href="../../css/css.css" rel="stylesheet" type="text/css">
<html>
<head>
<title>请选择人员</title>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">

<script src="../../../script/action.js" language="JScript"></script>
<script src="../../../script/toolbar-ie5.js" language="JScript"></script>
<link href="../../../script/toolbar-ie5.css" type="text/css" rel="stylesheet">
<xml id="xsl" src="../../../script/toolbar-ie5.xsl"></xml>
<script src="../../../script/ua.js"></script>
<script src="../../../script/function.js"></script>
<script src="../../../script/page.js"></script>
<script src="../../../script/publics.js"></script>
</head>
<SCRIPT language=JavaScript>

function CheckAll()
  {
    for (var i=0;i<document.myform.elements.length;i++)
    {
      var e = document.myform.elements[i];
      if (e.name == 'ids')
        e.checked = document.checkall.allbox.checked;
    }
  }
function CheckSelected() {
    var isCheck = false;
    for (var i=0;i<document.myform.elements.length;i++)
    {
      var e = document.myform.elements[i];
      if (e.name == 'ids')
        if (e.checked == true) {
            isCheck = e.checked;
            break;
        }
    }
    return isCheck;
}
function onSubmit() {
	if (CheckSelected()) {
		myform.submit();
	} else {
		window.alert("请首先选择用户！");
	}
}

	//查询
	function doQuery(){
		var strForm = document.search;
		strForm.action= 'subUserQuery.do?queryName=managedSubUsersr';
		strForm.submit();
		
	}


</SCRIPT>
<style>
	.row	{background: white;}
</style>

<!-- Link Tigra Hints script file to your HTML document-->
<script language="JavaScript" src="../../../script/hints.js"></script>
<!-- Link Tigra Hints configuration file to your HTML document-->
<script language="JavaScript" src="../../../script/hints_cfg.js"></script>
<body>
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="11" height="31" valign="top" class="td-bg"><img src="../../../images/right-1.jpg" /></td>
    <td align="center" valign="top" ><table width="100%" border="0" cellpadding="0" cellspacing="0" class="word-8">
      <tr>
        <td height="31" align="left" valign="middle" style="background:url(../../../images/right-3.jpg)"><img src="../../../images/right-4.jpg" width="9" height="8" align="absmiddle" /> 当前位置 &gt; 子系统管理 &gt; 子管理员管理</td>
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
        <td background="../../../images/images_49.jpg" class="title"><strong>第一步：请选择人员</strong></td>
        
        <td  align="right" background="../../../images/images_49.jpg"><a href="javascript:history.back()">上一步</a>&nbsp;<a href="javascript:onSubmit()">下一步</a>&nbsp;<a href="UserextNewCreate.do?action=cancel">取消</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
      </tr>
    </table>
   
			<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td width="16" background="../../../images/images_55.jpg">&nbsp;</td>
          <td align="center">
          
		  
		  			<table width="98%" border="0" cellspacing="0" cellpadding="0">
		  			  
		  		
		  			 <form name="search" action="subUserQuery.do?queryName=managedSubUsers" method="post">
                    <tr> 
                      <td>&nbsp;</td>
                    </tr>
                    <tr> 
                      <td><table width="100%" border="0" cellpadding="1" cellspacing="1" bgcolor="a8d1eb">
                          	
													        	<tr height="22" > 
													        	
															      	<td nowrap align="right" class="td-01" > 姓名：
															      	</td>
															      	<td class="td-02">
														          		<input type="text" class="input" name="userName" size="10" value="<c:out value='${userQueryForm.map.userName}' />"/>
																      </td>   
															        
															        <td class="td-02" > 
															        		<input type="submit" value="查询"/>
															        	
	
															        </td>  
															         																      
														        </tr>
						  </form>				  
                        </table></td>
                    </tr>                
              
                  </table>
		  <form action="UserextNewCreate.do?action=step2" name="myform" method="post">  
                  <table width="100%" border="0" cellpadding="1" cellspacing="1" bgcolor="a8d1eb">
                    <tr> 
                    	<TD  width="4%"align="center" class="td-04">&nbsp;</TD>
                      <td width="4%" height="30" align="center" class="td-04">序号</td>
                      <td width="8%" align="center" class="td-04">登陆名</td>
					  <td width="22%" align="center" class="td-04">所属部门</td>
					  <td width="22%" align="center" class="td-04">姓名</td>
					  <td width="8%" align="center" class="td-04">性别</td>
					  <td width="8%" align="center" class="td-04">职务</td>
					  <td width="8%" align="center" class="td-04">出生年月</td>
				 
                    </tr>
					<c:forEach var="user" items="${userList}"  varStatus="ctIndex" >
					  							  		
								<c:if test="${ctIndex.count%2==1}">
                     <tr  height="25" align="center" class="td-02">
								</c:if>
										 <c:if test="${ctIndex.count%2==0}">
									 <tr  height="25" align="center" class="td-01">
									 </c:if>										  		
											  		<TD align="center" class="td-02"><input name="ids" type="radio" value="<c:out value="${user.id}"/>" ></TD>												  		
											  		<TD height="22" align="center" class="td-02"><c:out value='${ctIndex.index+1+(projectPage.pageSize*(projectPage.currentPage-1))}'/></TD>	
								            <TD height="22" align="center" class="td-02"><a href="../user_mgm/userSelect.do?action=detail&id=<c:out value="${user.id}"/>"><c:out value="${user.loginid}" /></a></TD>
								            <TD height="22" align="center" class="td-02"><a href="../office_mgm/officeSelect.do?action=detail&id=<c:out value="${user.deptid}"/>"><gOS_shjz:dictOrgValue key="${user.deptid}" /></a></TD>								           			
								            <TD height="22" align="center" class="td-02"><c:out value="${user.name}" /></TD>		
								            <TD height="22" align="center" class="td-02"><c:out value="${user.gender}"/></TD>	
								            <TD height="22" align="center" class="td-02"><c:out value="${user.callname}"/></TD>	
								            <TD height="22" align="center" class="td-02"><font color="#000000"><fmt:formatDate value="${user.birthday}" pattern="yyyy-MM-dd" /></font></TD>	
										            								            
								         	</TR>
									    	</c:forEach>	
                  </table>
      </form>
				 <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table-line">
					<tr> 
					  <td align="right" class="listTable_page">
					
          <td width="55%" valign="bottom">          
          <gOS:page name="test" action="subUserQuery.do?queryName=managedSubUsers" pageName="pageBean" pageSizeKey="list">
          	<gOS:param name="userName"><c:out value='${userQueryForm.map.userName}' /></gOS:param>
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