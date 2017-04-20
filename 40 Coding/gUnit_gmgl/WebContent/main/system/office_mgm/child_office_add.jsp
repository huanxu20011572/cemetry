<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib uri="http://www.topsuntech.com/jsptags/tree-taglib" prefix="topsuntech" %>
<%@page import="com.topsuntech.gOS.user.session.*" %>
<%@page import="com.topsuntech.gOS.user.en.user.*" %>
<%@ taglib uri="/WEB-INF/tld/gTaglib-gOS.tld" prefix="gOS" %>
<%@page import="com.topsuntech.gOS.config.user.OfficeCat.dao.*" %>
<%@page import="java.util.*" %>
<html>
<head>
<title>Untitled Document</title>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<gOS:skin />
<script src="../../../script/ua.js"></script>
<script src="../../../script/functionforcheck.js"></script>
<script>
function onSubmit() {
 	 var IsValid=true; 	

	 if(myform.name.value=="")
	 {	 
	 	document.all("deptnamelbl").innerHTML="<font color=\"ff0000\">请填写单位名称</font>";
	 	IsValid=false;
	 }
	 else
	 document.all("deptnamelbl").innerHTML="";
	 
    if(myform.shortname.value=="")
	 {	 
	 	document.all("dwjc").innerHTML="<font color=\"ff0000\">请填写单位简称</font>";
	 	IsValid=false;
	 }
	 else
	 document.all("dwjc").innerHTML="";
///////////////////////////////////////////////	 	
	 if(myform.region.value=="")
	 {	 
	 	document.all("regionlbl").innerHTML="<font color=\"ff0000\">请填写区域名称</font>";
	 	IsValid=false;
	 }
	 else
	 	document.all("regionlbl").innerHTML="";
/////////////////////////////////////////////////////	
	 if(!isNumber(myform.bzsm.value)){
	 	document.all("bzsmlbl").innerHTML="<font color=\"ff0000\">请填写正确的数字</font>";
	 	IsValid=false;
	 }
	 else
	 	document.all("bzsmlbl").innerHTML="";
	 
	 if(!isNumber(myform.syrs.value)){
	 	document.all("syrslbl").innerHTML="<font color=\"ff0000\">请填写正确的数字</font>";
	 	IsValid=false;
	 }
	 else
	 	document.all("syrslbl").innerHTML="";
	 
	 if(!isNumber(myform.ldzzs.value)){
	 	document.all("ldzzslbl").innerHTML="<font color=\"ff0000\">请填写正确的数字</font>";
	 	IsValid=false;
	 }
	 else
	 	document.all("ldzzslbl").innerHTML="";
	 
	 if(!isNumber(myform.ldfzs.value)){
	 	document.all("ldfzslbl").innerHTML="<font color=\"ff0000\">请填写正确的数字</font>";
	 	IsValid=false;
	 }
	 else
	 	document.all("ldfzslbl").innerHTML="";
	 	
	if(!checkLength(myform.description.value, 0, 150)){
		document.all("deslbl").innerHTML="<font color=\"ff0000\">单位描述过长（小于150字符）</font>";
		IsValid=false;
	} else {
		document.all("deslbl").innerHTML="";
	}
	
		if(myform.order.value=="" || !isNumber(myform.order.value) || !checkLength(myform.order.value, 1, 2)){
	 	document.all("orderlbl").innerHTML="<font color=\"ff0000\">请填写2位以内的正确数字</font>";
	 	IsValid=false;
	 }
	 else
	 	document.all("orderlbl").innerHTML="";
		 
	 if(IsValid)	 		
	 myform.submit();
}
</script>
<link href="../../../css/css.css" rel="stylesheet" type="text/css">
</head>
<%
	User user = UserSession.getUser(request);
	long creatorId = 2;
	String creatorName = "root";
	if (user!=null) {
		creatorId = user.getId().longValue();		
		creatorName = user.getName();
	}
%>
<body bgcolor="#FFFFFF" text="#000000" leftmargin="0" topmargin="0">
<form action="officeAdd.do?action=add" name="myform" method="post">
	<input type="hidden" name="addType" value="addChild">
	<input type="hidden" name="creatorId" value="<%=creatorId%>">
	<input type="hidden" name="parentid" value="<c:out value="${upoffice.id}" />">
	<input type="hidden" name="parent" value="<c:out value="${upoffice.name}" />">
<table width="100%" border="0" align="right" cellpadding="0" cellspacing="0" class="table10">
  <tr> 
       
    <td align="right" valign="top" class="td18"> 
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table7">
        <tr> 
          <td width="0%" height="20" class="list_title">&nbsp; </td>
            <td width="54%" height="20" align="left" class="list_title"><table width="300" border="0" cellpadding="0" cellspacing="0">
              <tr class="td16">
                <td width="60" class="td16"><input name="Submit" type="button" class="input_btn" value="确定" onClick="onSubmit();"></td>
                <td width="60" class="td16"><input name="Submit2" onClick="javascript:history.back();" type="button" class="input_btn" value="取消"></td>
                <td width="60" class="td16">&nbsp;</td>
                <td width="60" class="td16">&nbsp;</td>
                <td width="60" class="td16">&nbsp;</td>
              </tr>
            </table></td>
          <td width="46%" align="right" class="list_title"><strong>创建新子单位(*为必填项)：<font color="ff0000">
          <html:errors/>
          </font></strong></td>
        </tr>
      </table>
      <table width="100%" border="0" class="table5">
        <tr> 
          <td width="46%" height="18">&nbsp;</td>
          <td width="54%" align="right">创建人：<%=creatorName%> 　创建日期：<fmt:formatDate value="${upoffice.createdate}" pattern="yyyy-MM-dd" /></td>
        </tr>
      </table>
        <table width="100%" border="0" cellpadding="1" cellspacing="1" class="table_main">
          <tr> 
            <td width="12%" height="22" class="td22">上级单位*：</td>
          <td width="24%" height="22" class="td23"> <c:out value="${upoffice.name}" />
          </td>
          <td height="22" class="td22">单位显示顺序*：</td>
          	<td height="22" valign="top" class="td23">
          		<input name="order" type="text" size="20" width="150" height="18" maxlength="30">
        			<label id="orderlbl" name="orderlbl"></label>
          	</td>
        </tr>
          <tr height="22" > 
            <td height="22" class="td22">单位编号：</td>
          <td height="22" class="td23"><input name="num" type="text" size="20" width="150" height="18" maxlength="15"> 
          </td>
            <td height="22" class="td22">单位名称*：</td>
          <td height="22" valign="top" class="td23"><input name="name" type="text" size="20" width="150" height="18" maxlength="30">
          <label id="deptnamelbl" name="deptnamelbl"></label>
          </td>
        </tr>
				<tr bgcolor="#FBF7EC">          
            <td height="22" bgcolor="#FBF7EC" class="td22">单位电话：</td>
            <td height="22" valign="top" class="td23" colspan="3" >
            	<input name="bzxs" type="text" size="20" width="150" height="18" value="<c:out value="${office.bzxs}"/>" maxlength="25"> 
            </td>
            <!--
            <td height="22" bgcolor="#FBF7EC" class="td23">		           		            
		            <topsuntech:officeBZXS>
						    		<c:out value="${office.bzxs}"/>
						    </topsuntech:officeBZXS>						   
            </td>					
					    -->
					</tr>        
          <tr> 
             <td height="22" class="td22">单位属性*：</td>
            <td height="22" class="td23">
             <%
            	Collection list = OfficeCatFactory.getOfficeCatConfig().getOfficeCatbyAll();
                request.setAttribute("list", list);
            %>
            <gOS:select name="cat" keyProperty="name" valueProperty="name" items="${list}"/>
            </td>
            <td class="td22">单位级格*：</td>
            <td class="td23"> <topsuntech:officeLevel> 1,1 </topsuntech:officeLevel> 
            </td>
        </tr>
          <tr height="22" > 
            <td height="22" class="td22">编制数目：</td>
            <td height="22" class="td23"><input name="bzsm" type="text" size="20" width="150" height="18" value="<c:out value="${office.bzsm}"/>" maxlength="10"> 
              <label id="bzsmlbl" name="bzsmlbl"></label> </td>
            <td height="22" class="td22">实际人数：</td>
            <td height="22" valign="top" class="td23"><input name="syrs" type="text" size="20" width="150" height="18" value="<c:out value="${office.syrs}"/>" maxlength="10"> 
              <label id="syrslbl" name="syrslbl"></label> </td>
          </tr>
          <tr> 
            <td height="22" class="td22">编制形式：</td>
            <td height="22" class="td23"> <topsuntech:officeBZXS> <c:out value="${office.bzxs}"/> 
              </topsuntech:officeBZXS> </td>
            <td class="td22">经费形式：</td>
            <td class="td23"> <topsuntech:officeJFXS> <c:out value="${office.jfxs}"/> 
              </topsuntech:officeJFXS> </td>
          </tr>
          <tr height="22" > 
            <td height="22" class="td22">正职领导数目：</td>
            <td height="22" class="td23"><input name="ldzzs" type="text" size="20" width="150" height="18" value="<c:out value="${office.ldzzs}"/>" maxlength="10"> 
            <label id="ldzzslbl" name="numlbl"></label> </td>
            <td height="22" class="td22">副职领导数目：</td>
            <td height="22" valign="top" class="td23"><input name="ldfzs" type="text" size="20" width="150" height="18" value="<c:out value="${office.ldfzs}"/>" maxlength="10"> 
            <label id="ldfzslbl" name="ldfzslbl"></label> </td>
          </tr>        
          <tr height="22" > 
            <td height="22" class="td22">单位简称*：</td>
            <td height="22" class="td23">
              <input name="shortname" type="text" size="20" maxlength="10" width="150" height="18">
              <label id="dwjc" name="dwjc"></label>
            </td>
            <td height="22" class="td22">所属区域*：</td>
            <td height="22" class="td23">
            <input name="region" readonly type="text" size="20" maxlength="10" width="150" height="18">
              <input type="hidden" name="regionid" value=""> 
              <a href="javascript:windowWithoutToolbar('regionSelect.do?action=choose&inputBox=region', 400, 600)"><img src="../../../images/config/zoom_small.gif" width="13" height="13" border="0"></a> 
              <font color="#0000ff">单击前面的图标选择区域</font>   
              <label id="regionlbl" name="regionlbl"></label>          
            </td>
            
          </tr>
          <tr> <td height="22" bgcolor="#FBF7EC" class="td22">单位描述：<label id="deslbl" name="deslbl"></td>
            <td height="22" colspan="3" class="td23"> 
              <TEXTAREA NAME="description" height = "300" width = "300" ROWS=5 COLS=40&quot; wrap="hard"></TEXTAREA>
          </td>
        </tr>
      </table>
      
      </td>
  </tr>
</table>
</form>
</body>
</html>
