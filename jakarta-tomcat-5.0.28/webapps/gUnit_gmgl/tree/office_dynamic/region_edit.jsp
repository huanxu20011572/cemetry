<%@ page contentType="text/html; charset=GBK" %>
<%@ include file="../../common/taglibs.jsp"%>
<%@page import="com.topsuntech.gOS.user.session.*" %>
<%@page import="com.topsuntech.gOS.user.en.user.*" %>
<html>
<head>
<title>Untitled Document</title>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<link href="../css/style.css" rel="stylesheet" type="text/css">
<script src="../../script/publics.js"></script>
<script type='text/javascript' src='../dwr/engine.js'></script>
<script type='text/javascript' src='../dwr/util.js'></script>
<script>

	
function onSubmit() {
 	  var IsValid=true; 	

	 if(myform.name.value=="")
	 {	 
	 	document.all("deptnamelbl").innerHTML="<font color=\"ff0000\">请填写区域名称</font>";
	 	IsValid=false;
	 }
	 else
	 document.all("deptnamelbl").innerHTML="";
		 
	if(myform.regionCode.value=="")
	 {	 
	 	document.all("regionCodelbl").innerHTML="<font color=\"ff0000\">请填写区域编码</font>";
	 	IsValid=false;
	 }
	 else
	 document.all("regionCodelbl").innerHTML="";
	 
	 if(myform.levelId.value=="-1")
	 {	 
	 	document.all("regionLevellbl").innerHTML="<font color=\"ff0000\">请选择区域级别</font>";
	 	IsValid=false;
	 }
	 else
	 document.all("regionLevellbl").innerHTML="";
		 
		 
	 if(IsValid)	 		
	 myform.submit();
}

function checkRegionName()
{  
	var regionName=myform.name.value
	
	
  if(regionName==""||regionName==null)
	 {	 
	 	alert("请输入区域名称");
	 }else{
	     checkRegion.checkRegionName(regionName,function (result){
          	if(!result){
          	alert("您新增的区域名已存在");
          	
          	document.getElementById('name').select()
          	return ;
          	}
        	}); 
	    
	}
   
}
</script>
</head>
<%
	User user = UserSession.getUser(request);
	long creatOrid = 2;
	String creatorName = "root";
	if (user!=null) {
		creatOrid = user.getId().longValue();		
		creatorName = user.getName();
	}
%>
<body >
<form action="../tree/doUpdate.do?method=update" name="myform" method="post">

	<input type="hidden" name="addType" value="add">
	<input type="hidden" name="creatOrid" value="<c:out value='${region.creatOrid}' />">
	<input type="hidden" name="id" value="<c:out value='${region.id}' />">
	<input type="hidden" name="useFlag" value="<c:out value='${region.useFlag}' />">
	
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="11" height="31" valign="top" class="td-bg"><img src="../images/right-1.jpg" /></td>
    <td align="center" valign="top" ><table width="100%" border="0" cellpadding="0" cellspacing="0" class="word-8">
      <tr>
        <td height="31" align="left" valign="middle" style="background:url(../images/right-3.jpg)"><img src="../images/right-4.jpg" width="9" height="8" align="absmiddle" /> 当前位置 &gt; 系统管理 &gt; 区域管理</td>
      </tr>
    </table>
	</td>
  </tr>
  <tr>
    <td background="../images/images_481.jpg">&nbsp;</td>
    <td valign="top">
	<table border="0" cellspacing="0" cellpadding="0" width="100%">
		<tr>
			<td>&nbsp;</td>
		</tr>
		
	</table>
	<table width="98%" cellpadding="0" cellspacing="1" bgcolor="#a6c6da" class="word-8">
	  <tr>
	    <td width="15%" height="35" align="right" bgcolor="#D4E5F4">上级区域：</td>
	    <td width="35%" align="left" bgcolor="#FFFFFF"><input name="parentName" type="text" value="<c:out value='${parentName}' />" readonly>
	      <input type="hidden" name="parentId" value="<c:out value='${region.parentId}' />"></td>
	    <td width="15%" align="right" bgcolor="#D4E5F4">区域名称：</td>
	    <td align="left" bgcolor="#FFFFFF"><input name="name" type="text" size="20" value="<c:out value='${region.name}' />" width="150" height="18" maxlength="30">
	      <br>
	      <label id="deptnamelbl" name="deptnamelbl"></label></td>
	    </tr>
	  <tr>
	    <td height="35" align="right" bgcolor="#D4E5F4">区域编码：</td>
	    <td  width="35%" align="left" bgcolor="#FFFFFF"><input name="regionCode" type="text" size="20" width="150" height="18" maxlength="15" value="<c:out value='${region.regionCode}' />">
	      <br>
	      <label id="regionCodelbl" name="regionCodelbl"></label></td>
	    <td align="right" bgcolor="#D4E5F4">区域级别：</td>
	    <td align="left" bgcolor="#FFFFFF"><select name="levelId">
	      <option value="-1">请选择机构级别</option>
	      <option value="1" 
	      <c:if test="${region.levelId == 1}" >selected </c:if>
	      >市级
	      </option>
	      <option value="2" 
	      <c:if test="${region.levelId == 2}" >selected </c:if>
	      >区县
	      </option>
	      <option value="3" 
	      <c:if test="${region.levelId == 3}" >selected </c:if>
	      >街道
	      </option>
	      <option value="4" 
	      <c:if test="${region.levelId == 4}" >selected </c:if>
	      >社区
	      </option>
	      </select>
	      <br>
	      <label id="regionLevellbl" name="regionLevellbl"></label></td>
	    </tr>
	  </table>
    <table width="98%" cellpadding="0" cellspacing="0">
      <tr>
        <td height="60" align="center"><input  type="button" class="button-z" onClick="javascript:onSubmit();"  value="保存" />
          &nbsp;&nbsp;
          <input  type="button" class="button-z" onclick="javascript:history.go(-1);" value="取消" /></td>
      </tr>
    </table></td>
  </tr>
</table>
</form>
</body>
</html>
