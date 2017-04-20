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
<%@page import="java.util.Collection" %>
<html>
<head>
<title>Untitled Document</title>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<gOS:skin />
<link href="../../../css/css.css" rel="stylesheet" type="text/css">
<script src="../../../script/ua.js"></script>
<script src="../../../script/functionforcheck.js"></script>
<script>
function onClear(obj1, obj2, obj3) {
	obj1.value = "";
	obj2.value = "1";
	obj3.value = "";
}
function onSubmit() {
 	 var IsValid=true; 
	 
	 if(myform.name.value=="")
	 {	 
	 	document.all("deptnamelbl").innerHTML="<font color=\"ff0000\">请填写单位名称</font>";
	 	IsValid=false;
	 }
	 else
	 document.all("deptnamelbl").innerHTML="";
	 
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
</head>
<%
	User user = UserSession.getUser(request);
	long creatorId = 2;
	String creatorName = "root";
	if (user!=null) {
		creatorId = user.getId().longValue();		
		creatorName = user.getName();
	}
	
	Collection upLeaderList = (Collection)request.getAttribute("upLeaderList");
	Collection leaderList = (Collection)request.getAttribute("leaderList");
	System.out.println("---------upLeaderList.size() : " + upLeaderList.size());
	System.out.println("---------leaderList.size() : " + leaderList.size());
%>
<body bgcolor="#FFFFFF" text="#000000" leftmargin="0" topmargin="0">
<form action="officeUpdate.do?action=update" name="myform" method="post">

	<input type="hidden" name="id" value="<c:out value="${office.id}"/>">      
	<input type="hidden" name="creatorId" value="<%=creatorId%>">
<table width="100%" border="0" align="right" cellpadding="0" cellspacing="0" class="table10">
  <tr> 
       
    <td align="right" valign="top" class="td18"> 
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table7">
        <tr> 
          <td width="0%" height="20" class="list_title">&nbsp; </td>
          <td width="54%" height="20" align="left" class="list_title">
		  <input type="button" value="确定" class="input_btn" onClick="onSubmit();"/>
		  <input type="button" value="取消" class="input_btn" onClick="javascript:history.back();"/>
		   </td>
          <td width="46%" align="right" class="list_title"><table width="300" border="0" cellpadding="0" cellspacing="0" class="list_title">
              <tr class="td16"> 
                
				<td class="td16">
					<strong>修改单位信息(*为必填项 )<font color=red>
            <html:errors/></font></strong>
				</td>

              </tr>
          </table></td>
        </tr>
      </table>
      <table width="100%" border="0" class="table5">
        <tr> 
          <td width="54%" align="right">创建人：<c:out value="${creatorName}" /> 创建日期：<fmt:formatDate value="${office.createdate}" pattern="yyyy-MM-dd" /></td>
        </tr>
      </table>
      <table width="100%" border="0" cellpadding="1" cellspacing="1" bgcolor="#EECCB4" class="table5">
        <tr bgcolor="#FBF7EC"> 
          <td width="15%" height="22" class="td22">上级单位*：</td>
          <td width="31%" height="22" class="td23">  <c:out value="${parent}"/> </td>
          <input name="parent" type="hidden" value="<c:out value="${parent}"/>">
          <td height="22" class="td22">单位显示顺序*：</td>
          	<td height="22" valign="top" class="td23">
          		<input name="order" type="text" size="20" width="150" height="18" maxlength="30" value="<c:out value="${office.order}"/>">
        			<label id="orderlbl" name="orderlbl"></label>
          	</td>
        </tr>
        <tr bgcolor="#FBF7EC" height="22" > 
          <td height="22" class="td22">单位编号：</td>
          <td height="22" class="td23"><input name="num" type="text" value="<c:out value="${office.num}"/>" maxlength="15"> 
          </td>
          <td height="22" bgcolor="#FBF7EC" class="td22">单位名称*：</td>
          <td height="22" valign="top" class="td23"><input name="name" type="text" value="<c:out value="${office.name}"/>" maxlength="30">
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
        <tr bgcolor="#FBF7EC"> 
          <td height="22" bgcolor="#FBF7EC" class="td22">单位属性*：</td>
          <td height="22" bgcolor="#FBF7EC" class="td23"><c:out value="${office.cat}"/></td>
          <input type="hidden" name="cat" value="<c:out value="${office.cat}"/>">
          <td bgcolor="#FBF7EC" class="td22">单位级格*：</td>
          <td bgcolor="#FBF7EC" class="td23">
          <topsuntech:officeLevel>
          <c:out value="${parentLevel}"/>,<c:out value="${office.levelid}"/>
          </topsuntech:officeLevel>          
          </td>
        </tr>
        <tr bgcolor="#FBF7EC" height="22" > 
            <td height="22" class="td22">编制数：</td>
            <td height="22" class="td23"><input name="bzsm" type="text" size="20" width="150" height="18" value="<c:out value="${office.bzsm}"/>" maxlength="10"> 
              <label id="bzsmlbl" name="bzsmlbl"></label> </td>
            <td height="22" bgcolor="#FBF7EC" class="td22">实际人数：</td>
            <td height="22" valign="top" class="td23"><input name="syrs" type="text" size="20" width="150" height="18" value="<c:out value="${office.syrs}"/>" maxlength="10"> 
              <label id="syrslbl" name="syrslbl"></label> </td>
          </tr>
					
          <tr bgcolor="#FBF7EC"> 
            <td bgcolor="#FBF7EC" class="td22">经费形式：</td>
            <td bgcolor="#FBF7EC" class="td23">
            <topsuntech:officeJFXS>
					    <c:out value="${office.jfxs}"/>
					    </topsuntech:officeJFXS>
            </td>
           <td height="29" class="td22">单位简称：</td>
           <td height="29" colspan="3" class="td23">
              <input name="shortname" type="text" size="20" maxlength="10" width="150" height="18" value="<c:out value="${office.shortname}"/>" >
           </td>
          </tr>
          <tr bgcolor="#FBF7EC" height="22" > 
            <td height="22" class="td22">正职领导数目：</td>
            <td height="22" class="td23"><input name="ldzzs" type="text" size="20" width="150" height="18" value="<c:out value="${office.ldzzs}"/>" maxlength="10"> 
            <label id="ldzzslbl" name="numlbl"></label> </td>
            <td height="22" bgcolor="#FBF7EC" class="td22">副职领导数目：</td>
            <td height="22" valign="top" class="td23"><input name="ldfzs" type="text" size="20" width="150" height="18" value="<c:out value="${office.ldfzs}"/>" maxlength="10"> 
            <label id="ldfzslbl" name="deptnamelbl"></label> </td>
          </tr>          
           <tr bgcolor="#FBF7EC"> 
            <td height="22" class="td22">法人：</td>
            <td height="22" class="td23"> <input name="faren" type="text" value="<c:out value="${farenName}"/>" readonly> 
            <input name="farenid" type="hidden" value="<c:out value="${office.faren}"/>">
            <a href="javascript:windowWithoutToolbar('userMove.do?action=chooseUser&inputBox=faren&officeId=<c:out value="${office.id}"/>', 400, 600)"><img src="../../../images/config/zoom_small.gif" width="13" height="13" border="0"></a> 
            <font color="#0000ff">单击前面的图标选择法人</font>
            </td>
            <td height="22" class="td22">所属区域*：</td>
            <td height="22" class="td23">
            	<input readonly name="region" type="text" size="20" maxlength="10" width="150" height="18" value="<c:out value="${office.region.name}"/>">
              <input type="hidden" name="regionid" value="<c:out value="${office.region.id}"/>"> 
              <a href="javascript:windowWithoutToolbar('regionSelect.do?action=choose&inputBox=region', 400, 600)"><img src="../../../images/config/zoom_small.gif" width="13" height="13" border="0"></a> 
              <font color="#0000ff">单击前面的图标选择区域</font>    
              <label id="regionlbl" name="regionlbl"></label>         
            </td>
            
          </tr>

        <tr bgcolor="#FBF7EC"> 
          <td height="22" bgcolor="#FBF7EC" class="td22">单位描述：<label id="deslbl" name="deslbl"></td>
          <td height="22" colspan="3" bgcolor="#FBF7EC" class="td23">
          <textarea name="description" cols="60" rows="4" wrap="hard"><c:out value="${office.description}"/></textarea>
          </td>
        </tr>
      </table>      
      <table width="100%" border="0" cellpadding="1" cellspacing="1" bgcolor="#EECCB4" class="table5">
        <c:forEach var="upLeader" items="${upLeaderList}" >
        <tr bgcolor="#FBF7EC"> 
          <td width="8%" height="22" class="td22">
          <a href="javascript:onClear(document.myform.upLeader, document.myform.upLeaderid, document.myform.upLeaderdes);">移除</a>
          </td>
          <td width="18%" height="22" class="td22">
          上级分管领导：
          </td>
          <td width="13%" height="22" colspan="3" class="td23">
            <input type="text" name="upLeader" value="<c:out value="${upLeader.username}"/>" readonly>
            <input type="hidden" name="upLeaderid" value="<c:out value="${upLeader.userid}"/>">
            <input type="hidden" name="officeupLeaderid" value="<c:out value="${upLeader.id}"/>">
            <a href="javascript:windowWithoutToolbar('userMove.do?action=chooseUser&inputBox=upLeader&officeId=<c:out value="${parentId}"/>', 400, 400)"><img src="../../../images/config/zoom_small.gif" width="13" height="13" border="0"></a></td>
          </td>
          <td width="15%" align="left" class="td23">描述：</td>
          <td width="42%" class="td23">
          <textarea name="upLeaderdes" cols="35" rows="4" wrap="hard"><c:out value="${upLeader.description}"/></textarea>
          </td>
        </tr>
        </c:forEach>
        
        <%int i=0;%>
        <c:forEach var="leader" items="${leaderList}" >        
        <%i++;%>
        <tr bgcolor="#FBF7EC"> 
          <td width="8%" height="22" class="td22">
          <a href="javascript:onClear(document.myform.leader<%=i%>, document.myform.leader<%=i%>id, document.myform.leader<%=i%>des);">移除</a>
          </td>
          <td width="18%" height="22" class="td22">
          单位领导<c:out value="${leader.officeseq}"/>：</td>
          <td width="13%" height="22" class="td23">
          <input name="leader<%=i%>" type="text" size="8" value="<c:out value="${leader.username}"/>" readonly> 
          <input name="leader<%=i%>seq" type="hidden" value="<%=i%>">
          <input name="leader<%=i%>id" type="hidden" value="<c:out value="${leader.userid}"/>"> 
          <input name="officeleader<%=i%>id" type="hidden" value="<c:out value="${leader.id}"/>">
            <a href="javascript:windowWithoutToolbar('userMove.do?action=chooseUser&inputBox=leader<%=i%>&officeId=<c:out value="${office.id}"/>', 400, 400)"><img src="../../../images/config/zoom_small.gif" width="13" height="13" border="0"></a></td>
          <td width="13%" align="right" bgcolor="#FBF7EC" class="td22">职务*：</td>
          <td width="14%" class="td23">
          <select name="position<%=i%>">
          <topsuntech:officePosition1>
          	<c:out value="${office.name}"/>
	  </topsuntech:officePosition1>          	
	  </select>
          </td>          
          <td width="15%" align="left" class="td23">描述：</td>
          <td class="td23">
          <textarea name="leader<%=i%>des" cols="35" rows="4" wrap="hard"><c:out value="${leader.description}"/></textarea>
          </td>
        </tr>
        </c:forEach>
      </table> </td>
  </tr>
</table>
</form>
</body>
</html>
