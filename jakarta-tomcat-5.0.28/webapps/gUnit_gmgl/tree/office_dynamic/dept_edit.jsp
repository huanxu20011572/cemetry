<%@ page contentType="text/html; charset=GBK" %>
<%@ include file="../../common/taglibs.jsp"%>
<%@page import="com.topsuntech.gOS.user.session.*" %>
<%@page import="com.topsuntech.gOS.user.en.user.*" %>
<%@page import="com.topsuntech.gOS.user.en.office.Office" %>

<%
	User user = UserSession.getUser(request);
	long creatOrid = 2;
	String creatorName = "root";
	if (user!=null) {
		creatOrid = user.getId().longValue();		
		creatorName = user.getName();
	}
	
	Office off = UserSession.getUserDept(request); 	
	long regionId = off.getRegionid();
%>

<html>
<head>
<title>Untitled Document</title>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<link href="../css/style.css" rel="stylesheet" type="text/css">
<link href="../css/css.css" rel="stylesheet" type="text/css">
<script src="<c:url value="/script/publics.js"/>"></script>
<script src="<c:url value="/script/ua.js"/>"></script>
<script>

function setOffice(win, id, name){
	document.getElementsByName("parentName")[0].value = name;
	document.getElementsByName("parentId")[0].value = id;
	win.close();
}
function selectOffice() {
	windowWithoutToolbar("office_choose.jsp?type=1", 300, 600, true);
}

function doCancel(){
	window.location = "office_list.jsp?idStr=" + '<c:out value="${dept.id}" />';
}
function onSubmit() {
 	 var IsValid=true; 	

	if(myform.name.value=="")
	 {	 
	 	document.all("deptnamelbl").innerHTML="<font color=\"ff0000\">请填写机构名称</font>";
	 	IsValid=false;
	 }
	 else
	 document.all("deptnamelbl").innerHTML="";
	 
	  if(myform.regionId.value=="")
	 {	 
	 	document.all("regionIdlbl").innerHTML="<font color=\"ff0000\">请选择所属区域</font>";
	 	IsValid=false;
	 }
	 else
	 document.all("regionIdlbl").innerHTML="";
	 
	
	 
	   if(myform.levelId.value=="")
	 {	 
	 	document.all("levelIdlbl").innerHTML="<font color=\"ff0000\">请选择行政级别</font>";
	 	IsValid=false;
	 }
	 else
	 document.all("levelIdlbl").innerHTML="";
		 
	
	   if(myform.parentId.value=="")
	 {	 
	 	document.all("parentIdlbl").innerHTML="<font color=\"ff0000\">请选择上级机构</font>";
	 	IsValid=false;
	 }
	 else
	 document.all("parentIdlbl").innerHTML="";

     /*if(myform.dwlx.value=="")
	 {	 
	 	document.all("dwlxlbl").innerHTML="<font color=\"ff0000\">请选择单位类型</font>";
	 	IsValid=false;
	 }
	 else
	 document.all("dwlxlbl").innerHTML="";*/
	 
	 if(myform.treeNode.value=="")
	 {	 
	 	document.all("treeNodelbl").innerHTML="<font color=\"ff0000\">请选择节点标识</font>";
	 	IsValid=false;
	 }
	 else
	 document.all("treeNodelbl").innerHTML="";
		 
		 
		 if(myform.jgmx.value=="-1")
	 {	 
	 	document.all("jgmxlbl").innerHTML="<font color=\"ff0000\">请填写机构编码</font>";
	 	IsValid=false;
	 }
	 else
	 document.all("jgmxlbl").innerHTML=""; 
	 
		 		 
	 if(IsValid)	 		
	 myform.submit();
}


</script>
</head>

<body>
<form action="doUpdateDept.do?method=update" name="myform" method="post">

	<input type="hidden" name="creatOrid" value="<%=creatOrid%>">
	<input type="hidden" name="useFlag" value="1">
	<input type="hidden" name="inputPath" value='<c:out value="${param.inputPath}"/>'>
	<input type="hidden" name="id" value="<c:out value='${dept.id}' />" >
  <input type="hidden" name="approveUnitCode" value="<c:out value='${dept.approveUnitCode}' />" >
  <input type="hidden" name="orderByItem" value="<c:out value='${dept.orderByItem}' />" >
  <input type="hidden" name="isRegion" value="<c:out value='${dept.isRegion}' />" >
  <input type="hidden" name="dwdm" value="<c:out value='${dept.dwdm}' />" >
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="11" height="31" valign="top" class="td-bg"><img src="../images/right-1.jpg" /></td>
    <td align="center" valign="top" ><table width="100%" border="0" cellpadding="0" cellspacing="0" class="word-8">
      <tr>
        <td height="31" align="left" valign="middle" style="background:url(../images/right-3.jpg)"><img src="../images/right-4.jpg" width="9" height="8" align="absmiddle" /> 当前位置 &gt; 系统管理 &gt; 机构管理</td>
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
 <table width="98%" cellpadding="0" cellspacing="1" bgcolor="#a6c6da" class="word-8">
	  <tr>
	    <td width="15%" height="35" align="right" bgcolor="#D4E5F4">所属区域：</td>
	    <td width="35%" align="left" bgcolor="#FFFFFF"><c:out value='${regionName}' />
	          				<input type="hidden" name="regionId" value="<c:out value='${dept.regionId}' />" ><label id="regionIdlbl" name="regionIdlbl"></label></td>
	    <td width="15%" align="right" bgcolor="#D4E5F4">上级机构：</td>
	    <td align="left" bgcolor="#FFFFFF" ><input name="parentName" value="<c:out value='${parentName}' />" type="text" readonly> <a href="javascript:selectOffice()" ><img src="../images/config/zoom_small.gif" width="13" height="13" border="0"></a> 
              <input type="hidden" name="parentId" value="<c:out value='${dept.parentId}' />" ><label id="parentIdlbl" name="parentIdlbl"></label> </td>
	    </tr>
	  <tr>
	    <td height="35" align="right" bgcolor="#D4E5F4">行政级别：</td>
	    <td  width="35%" align="left" bgcolor="#FFFFFF"> <select name="levelId">
		        		<option >请选择行政级别...</option>
		        		<option value="1"  <c:if test="${dept.levelId == 1}" >selected </c:if>>市级</option>
		        		<option value="2" <c:if test="${dept.levelId == 2}" >selected </c:if>>区县</option>
		        		<option value="3" <c:if test="${dept.levelId == 3}" >selected </c:if>>街道</option>
		        		<option value="4" <c:if test="${dept.levelId == 4}" >selected </c:if>>社区</option>
		        	</select><label id="levelIdlbl" name="levelIdlbl"></label></td>
	    <td align="right" bgcolor="#D4E5F4">机构名称：</td>
	    <td align="left" bgcolor="#FFFFFF"><input name="name" type="text" size="20" width="150" height="18" maxlength="30" value="<c:out value='${dept.name}' />">
	        <label id="deptnamelbl" name="deptnamelbl"></label></td>
	    </tr>
	  <tr>
	    <td height="35" align="right" bgcolor="#D4E5F4">节点标识：</td>
	    <td  width="35%" align="left" bgcolor="#FFFFFF"><select name="treeNode">
	            	<option >请选择系统标识...</option>
		        		<option value="0" <c:if test="${dept.treeNode == 0}" >selected </c:if> >根节点</option>		        	
		        		<option value="2" <c:if test="${dept.treeNode == 2}" >selected </c:if> >子节点</option>
		        	</select>	<label id="treeNodelbl" name="treeNodelbl"></label></td>
	    <td align="right" bgcolor="#D4E5F4">机构编码：</td>
	    <td align="left" bgcolor="#FFFFFF"><input name="jgmx" type="text" size="20" width="150" height="18" maxlength="30" value="<c:out value='${dept.jgmx}' />"><label id="jgmxlbl" name="jgmxlbl"></label></td>
	    </tr>
	  </table>
    <table width="98%" cellpadding="0" cellspacing="0">
      <tr>
        <td height="60" align="center"><input  type="button" class="button-z" onClick="javascript:onSubmit();"  value="保存" />
          &nbsp;&nbsp;
          <input  type="button" class="button-z" onClick="javascript:doCancel();" value="取消" /></td>
      </tr>
    </table>
 
    </td>
  </tr>
</table>
</form>
</body>
</html>
