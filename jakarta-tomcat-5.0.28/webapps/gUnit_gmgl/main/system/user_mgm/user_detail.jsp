<%@ page contentType="text/html; charset=GBK" %>
<%@ include file="../../../common/taglibs.jsp"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="http://www.topsuntech.com/jsptags/tree-taglib" prefix="topsuntech" %>
<%@page import="com.topsuntech.gOS.user.session.*" %>
<%@page import="com.topsuntech.gOS.user.en.user.*" %>
<%@page import="com.topsuntech.gOS.user.en.office.Office" %>
<%@page import="com.topsuntech.gOS.config.user.userXuewei.dao.UserXueweiFactory" %>
<%@page import="com.topsuntech.gOS.config.user.userZhicheng.dao.UserZhichengFactory" %>
<%@page import="java.util.Collection" %>
<%
	String sDeptId=request.getParameter("sDeptId");
	String backurl="userSelect.do?";
	if(sDeptId==null||sDeptId.length()==0)
	{
	   backurl+="action=list";		   
	   sDeptId="";
	}else{
	   backurl+="action=listByDept&id=";
	   backurl+=sDeptId;
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

<script src="../../../script/ua.js"></script>
<script src="../../../script/functionforcheck.js"></script>
<script src="../../../script/calendar.js"></script>
<script src="../../../script/publics.js"></script>
<script src="../../../script/common.js"></script>
<script type='text/javascript' src='../../../dwr/interface/checkLognid.js'></script>
<script type='text/javascript' src='../../../dwr/engine.js'></script>
<script type='text/javascript' src='../../../dwr/util.js'></script>

<script language="JavaScript">
function selectOffice(callback, idStr){
	<c:if test="${param.inputPath eq 'allList'}">
		var type = 1;
	</c:if>
	<c:if test="${param.inputPath eq 'subUsers'}">
		var type = 2;
	</c:if>
	var url = "<c:url value="/tree/office_choose.jsp?type="/>" + type;
	url += ("&callback=" + callback + "&idStr=" + idStr );
	windowWithoutToolbar(url, 300, 600, true);
}
function setDept(win, id, name){
	document.getElementsByName('deptid')[0].value = id;
	document.getElementsByName('dept')[0].value = name;
	win.close();
}
function selectDept() {
	selectOffice("setDept", document.getElementsByName('deptid')[0].value);
}
function setWorkdept(win, id, name){
	document.getElementsByName('workdeptid')[0].value = id;
	document.getElementsByName('workdeptName')[0].value = name;
	win.close();
}
function selectWorkdept() {
	selectOffice("setWorkdept", document.getElementsByName('workdeptid')[0].value);
}
function removeAndAddErrInfo(isError, eleName, labName, info, errorEle){
	if(isError){
		document.all(labName).innerHTML = '<span style="font: 13px;color: red"> ' + info + '</span>';
		if(errorEle == null){
			return document.all(eleName);
		}
	}else{
		document.all(labName).innerHTML = '';
	}
	return errorEle;
}

function onSubmit() {	 
	myform.actionType.value="normal";
	 var IsValid=true;	 
	 
	 var firstErrorEle = null;
	 firstErrorEle = removeAndAddErrInfo(!checkLoginid(myform.loginid.value), 'loginid', 'label0', '用户ID不正确', firstErrorEle);
	 firstErrorEle = removeAndAddErrInfo(!myform.deptid.value, 'dept', 'deptlbl', '请选择所在处室', firstErrorEle);
	 firstErrorEle = removeAndAddErrInfo(!myform.workdeptid.value, 'workdeptName', 'workdeptlbl', '请选择所属机构', firstErrorEle);
	 firstErrorEle = removeAndAddErrInfo(!myform.name.value, 'name', 'namelbl', '请填写姓名', firstErrorEle);
	 firstErrorEle = removeAndAddErrInfo(!checkLength(myform.memo.value, 0, 150), 'memo', 'deslbl', '用户描述过长（小于150字符）', firstErrorEle);
	 firstErrorEle = removeAndAddErrInfo(!myform.num.value, 'num', 'numlbl', '请填写人员编码', firstErrorEle);
	 if(firstErrorEle == null){
	   	myform.action = "updateUser.do?doMethod=update&idyProcessService=userManager&inputPath=<c:out value='${param.inputPath}'/>";
	 	myform.submit();
	  }else{
	  	scroll(0, 0);
	  	firstErrorEle.focus();
	  }
	  /*	
	 if(myform.dept.value=="")
	 {
	 	document.all("deptlbl").innerHTML="<font color=\"ff0000\">请选择部门</font>";
	 	IsValid=false;
	 }
	 else
	 document.all("deptlbl").innerHTML="";
	 
	 if(!checkLength(myform.memo.value, 0, 150)){
		document.all("deslbl").innerHTML="<font color=\"ff0000\">用户描述过长（小于150字符）</font>";
		IsValid=false;
	 }
	 else 
	 document.all("deslbl").innerHTML="";
	 
	 if(myform.name.value=="")
	 {	
	 	document.all("namelbl").innerHTML="<font color=\"ff0000\">请填写姓名</font>";
	 	IsValid=false;
	 }
	 else
	 document.all("namelbl").innerHTML="";
	 
	  if(myform.num.value=="")
	 {	
	 	document.all("numlbl").innerHTML="<font color=\"ff0000\">请填写人员编码</font>";
	 	IsValid=false;
	 }
	 else
	 document.all("numlbl").innerHTML="";
	 
	 
	 if(IsValid){
	 myform.action = "updateUser.do?doMethod=update&idyProcessService=userManager&inputPath=<c:out value='${param.inputPath}'/>";
	 myform.submit();
	}
	*/
}
function onSubmitP(){
	 myform.actionType.value="password";
	 var IsValid=true;
	 
	 var firstErrorEle = null;
	 firstErrorEle = removeAndAddErrInfo(myform.password.value.length<3, 'password', 'pwdlbl', '密码长度太短(大于等于3位)', firstErrorEle);
	 firstErrorEle = removeAndAddErrInfo(myform.newpwdconfirm.value!=myform.password.value, 'newpwdconfirm', 'cfmpwdlbl', '密码不一致', firstErrorEle);
	 if(firstErrorEle == null){
	   	myform.action = "changePassword.do?doMethod=changePassword&idyProcessService=userManager&inputPath=<c:out value='${param.inputPath}'/>";
	 	myform.submit();
	 }else{
	 	scroll(0, 0);
	 	firstErrorEle.focus();
	 }
	 /*
	 if(myform.password.value.length<8)
	 {
	 	document.all("pwdlbl").innerHTML="<font color=\"ff0000\">密码长度太短</font>";
	 	IsValid=false;
	 }
	 else
	 document.all("pwdlbl").innerHTML="";
	 if(myform.newpwdconfirm.value!=myform.password.value)
	 {
	 	document.all("cfmpwdlbl").innerHTML="<font color=\"ff0000\">密码不一致</font>";
	 	IsValid=false;
	 }
	 else
	 document.all("cfmpwdlbl").innerHTML="";
	 if(IsValid){
	 		myform.action = "changePassword.do?doMethod=changePassword&idyProcessService=userManager&inputPath=<c:out value='${param.inputPath}'/>";
	 		myform.submit();
	 }
	 */
}
function onSubmitPrio(){
	//var prios=",";
	//if(myform.prioritys.value!=""){
	//	prios=myform.prioritys.value;
	//}
	//windowWithoutToolbar('userChoose.do?action=actorChoose&prios='+prios,600, 500);
	var pForm = document.getElementById('myform');
	<c:if test="${param.inputPath eq 'allList'}">
		openWinNoToolbarAndSubmit('<c:url value="/main/system/user_mgm/showChoosePriorityRole.do?doMethod=showChoosePriorityRole&fromOpener=true&usrid=${user.id}"/>', 800, 600, pForm);		
	</c:if>
	<c:if test="${param.inputPath eq 'subUsers'}">
		openWinNoToolbarAndSubmit('<c:url value="/main/system/user_mgm/showChoosePriorityRole.do?doMethod=showSubChoosePriorityRole&fromOpener=true"/>', 800, 600, pForm);		
	</c:if>
}

function checkloginida()
{  
	var loginid=myform.loginid.value
	
  checkLognid.checkUserLogid(loginid,function (result){
  	if(!result){
  	alert("您输入的登陆名已存在，请换一个登陆名");
  	
  	document.getElementById('loginid').select()
  	return ;
  	}
	}); 
   
}

</script>
<link href="../../../css/css.css" rel="stylesheet" type="text/css">
</head>

<body>
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="11" height="31" valign="top" class="td-bg"><img src="../../../images/right-1.jpg" /></td>
    <td align="center" valign="top" ><table width="100%" border="0" cellpadding="0" cellspacing="0" class="word-8">
      <tr>
        <td height="31" align="left" valign="middle" style="background:url(../../../images/right-3.jpg)"><img src="../../../images/right-4.jpg" width="9" height="8" align="absmiddle" /> 当前位置 &gt; 系统管理 &gt; 用户管理</td>
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
        <td background="../../../images/images_49.jpg" class="title"><strong>用户信息</strong></td>
        
        <td width="16" align="right" background="../../../images/images_49.jpg"></td>
      </tr>
    </table>
   
			<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td width="16" background="../../../images/images_55.jpg">&nbsp;</td>
          <td align="center"><br>  
      <form id="myform" name="myform" method="post">
       
        <TABLE width="100%" 
        border=0 cellPadding=1 cellSpacing=1 bgcolor="a8d1eb" class=table_main>
          <tr> 
            <td width="15%" height="22" class=td-01  align="right">用户ID：</td>
          <td width="31%" height="22" class=td-02>
          	<c:out value="${user.loginid}"/>
          	 
          </td>
            <td width="16%" align="right" class=td-01>用户权限:</td>
              <td width="38%" class=td-02>
          
           <a href="../../../main/system/user_mgm/showUserProAll.do?doMethod=showUserProAll&usrid=<c:out value="${user.id}"/>">用户权限列表</a>        	</td>
        </tr>
          <tr> 
          	 <td class=td-01  align="right">所属机构 ：</td>
	          <td class=td-02>
		          <c:out value="${user.workdept.name}"/>
		        
	          </td> 
          
            <td height="22" class=td-01  align="right">所在处室：</td>
            <td height="22" class=td-02>
				<c:out value="${user.deptname}"/>
	          
            </td>
        </tr>
          <tr> 
            <td height="22" class=td-01  align="right">姓名 ：</td>
            <td height="22" class=td-02>
<c:out value="${user.name}"/></td>
            <td class=td-01  align="right">性别：</td>
            <td height="22" class=td-02>

 <c:out value="${user.gender}"/> 
              </td>
        </tr>
          <tr height="22" > 
            <td height="22" class=td-01  align="right">人员编码 ：</td>
          <td height="22" class=td-02><c:out value="${user.num}"/></td>
            <td height="22" class=td-01  align="right">出生地：</td>
          <td height="22" valign="top" class=td-02><c:out value="${user.birthlocation}"/></td>
        </tr>
          <tr> 
            <td height="22" class=td-01  align="right">出生年月：</td>
            <td height="22" class=td-02>             	
           <c:out value="${user.birthday}" />
				                       </td>
            <td class=td-01  align="right">民族：</td>
            <td class=td-02> <c:out value="${user.nation}"/> </td>
        </tr>
        <tr> 
          <td height="22" class=td-01  align="right">学历：</td>
          <td height="22" class=td-02> 
           <c:out value="${user.xueli}"/>
          	         </td>
          <td class=td-01  align="right">学位：</td>
          <td class=td-02> 
          <c:out value="${user.xuewei}"/>
          </td>
        </tr>
          <tr> 
            <td height="22" class=td-01  align="right">所学专业：</td>
            <td height="22" class=td-02>
<c:out value="${user.zhuanye}"/></td>
            <td class=td-01  align="right">毕业院校及时间：</td>
            <td class=td-02>
<c:out value="${user.yuanxiao}"/></td>
        </tr>
          <tr> 
            <td height="22" class=td-01  align="right">政治面貌：</td>
            <td height="22" class=td-02>
党员</td>
            <td class=td-01  align="right">入党/团时间：</td>
            <td class=td-02>             		
           <c:out value="${user.rudangshijian}" />
				     </td>
        </tr>
        <tr> 
          <td height="22" class=td-01  align="right">职称：</td>
          <td height="22" class=td-02> 
           <c:out value="${user.callname}" />
          	<td class=td-01  align="right">职务：</td>
          <td class=td-02> <c:out value="${user.positionid}"/></td>
        </tr>
          <tr> 
            <td height="22" class=td-01  align="right">身份证号：</td>
            <td height="22" class=td-02>
<c:out value="${user.identitynum}"/></td>
            <td class=td-01  align="right">工作证号：</td>
            <td class=td-02>
<c:out value="${user.worknum}"/></td>
        </tr>
          <tr> 
            <td height="22" class=td-01  align="right">单位地址：</td>
            <td height="22" class=td-02>
<c:out value="${user.address}"/></td>
            <td class=td-01  align="right">联系电话：</td>
            <td class=td-02>
<c:out value="${user.homephone}"/></td>
        </tr>
          <tr> 
            <td height="22" class=td-01  align="right">办公电话：</td>
            <td height="22" class=td-02>
<c:out value="${user.officephone}"/></td>
            <td class=td-01  align="right">移动电话：</td>
            <td class=td-02>
<c:out value="${user.mobile}"/></td>
        </tr>
          <tr> 
            <td height="22" class=td-01  align="right">公积金号：</td>
            <td height="22" class=td-02>
<c:out value="${user.publicmoneynum}"/></td>
            <td class=td-01  align="right">养老保险号：</td>
            <td class=td-02>
<c:out value="${user.oldsupportnum}"/></td>
        </tr>
          <tr> 
            <td height="22" class=td-01  align="right">住房补贴号：</td>
            <td height="22" class=td-02>
<c:out value="${user.housepaynum}"/></td>
            <td class=td-01  align="right">医疗保险号：</td>
            <td class=td-02>
<c:out value="${user.securitynum}"/></td>
        </tr>
          <tr> 
          <td class=td-01  align="right">籍贯：</td>
            <td class=td-02>
<c:out value="${user.jiguan}"/></td>
            <td height="22" class=td-01  align="right">参加工作时间：</td>
            <td height="22" class=td-02>            
             <c:out value="${user.workyear}" />
				    </td>
        </tr>

		
		 <tr> 
          <td class="td-01"  align="right">证书号：</td>
            <td class="td-02" colspan="3">
<c:out value="${user.canumber}" /></td>
           
        </tr>
		
          <tr> 
            <td height="22" class=td-01  align="right">备注：
<label id="deslbl" name="deslbl"></label></td>
            <td height="22" colspan="3" class=td-02><c:out value="${user.memo}"/></td>
        </tr>
		
      </table>
	  <TABLE width="100%" 
        border=0 cellPadding=1 cellSpacing=1  >
	  <tr> 
            <td height="22" colspan="4"  align="center"  class=td-02><table width="300" border="0" cellpadding="0" cellspacing="0">
              <tr class="">
                <td width="60" ></td>
                <td width="60" ><label>
                  <a href="javascript:history.go(-1);"><img src="../../../images/but-fh.gif" width="66" height="27" border="0" ></a>
                </label></td>
                <td width="60" >&nbsp;</td>
                <td width="60" >&nbsp;</td>
                <td width="60">&nbsp;</td>
              </tr>
            </table>
			</td>
           
        </tr>
      </table>
      </form>
		  
		  		
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