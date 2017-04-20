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
	 firstErrorEle = removeAndAddErrInfo(!checkLoginid(myform.loginid.value), 'loginid', 'label0', '�û�ID����ȷ', firstErrorEle);
	 firstErrorEle = removeAndAddErrInfo(!myform.deptid.value, 'dept', 'deptlbl', '��ѡ�����ڴ���', firstErrorEle);
	 firstErrorEle = removeAndAddErrInfo(!myform.workdeptid.value, 'workdeptName', 'workdeptlbl', '��ѡ����������', firstErrorEle);
	 firstErrorEle = removeAndAddErrInfo(!myform.name.value, 'name', 'namelbl', '����д����', firstErrorEle);
	 firstErrorEle = removeAndAddErrInfo(!checkLength(myform.memo.value, 0, 150), 'memo', 'deslbl', '�û�����������С��150�ַ���', firstErrorEle);
	 firstErrorEle = removeAndAddErrInfo(!myform.num.value, 'num', 'numlbl', '����д��Ա����', firstErrorEle);
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
	 	document.all("deptlbl").innerHTML="<font color=\"ff0000\">��ѡ����</font>";
	 	IsValid=false;
	 }
	 else
	 document.all("deptlbl").innerHTML="";
	 
	 if(!checkLength(myform.memo.value, 0, 150)){
		document.all("deslbl").innerHTML="<font color=\"ff0000\">�û�����������С��150�ַ���</font>";
		IsValid=false;
	 }
	 else 
	 document.all("deslbl").innerHTML="";
	 
	 if(myform.name.value=="")
	 {	
	 	document.all("namelbl").innerHTML="<font color=\"ff0000\">����д����</font>";
	 	IsValid=false;
	 }
	 else
	 document.all("namelbl").innerHTML="";
	 
	  if(myform.num.value=="")
	 {	
	 	document.all("numlbl").innerHTML="<font color=\"ff0000\">����д��Ա����</font>";
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
	 firstErrorEle = removeAndAddErrInfo(myform.password.value.length<3, 'password', 'pwdlbl', '���볤��̫��(���ڵ���3λ)', firstErrorEle);
	 firstErrorEle = removeAndAddErrInfo(myform.newpwdconfirm.value!=myform.password.value, 'newpwdconfirm', 'cfmpwdlbl', '���벻һ��', firstErrorEle);
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
	 	document.all("pwdlbl").innerHTML="<font color=\"ff0000\">���볤��̫��</font>";
	 	IsValid=false;
	 }
	 else
	 document.all("pwdlbl").innerHTML="";
	 if(myform.newpwdconfirm.value!=myform.password.value)
	 {
	 	document.all("cfmpwdlbl").innerHTML="<font color=\"ff0000\">���벻һ��</font>";
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
  	alert("������ĵ�½���Ѵ��ڣ��뻻һ����½��");
  	
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
        <td height="31" align="left" valign="middle" style="background:url(../../../images/right-3.jpg)"><img src="../../../images/right-4.jpg" width="9" height="8" align="absmiddle" /> ��ǰλ�� &gt; ϵͳ���� &gt; �û�����</td>
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
        <td background="../../../images/images_49.jpg" class="title"><strong>�û���Ϣ</strong></td>
        
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
            <td width="15%" height="22" class=td-01  align="right">�û�ID��</td>
          <td width="31%" height="22" class=td-02>
          	<c:out value="${user.loginid}"/>
          	 
          </td>
            <td width="16%" align="right" class=td-01>�û�Ȩ��:</td>
              <td width="38%" class=td-02>
          
           <a href="../../../main/system/user_mgm/showUserProAll.do?doMethod=showUserProAll&usrid=<c:out value="${user.id}"/>">�û�Ȩ���б�</a>        	</td>
        </tr>
          <tr> 
          	 <td class=td-01  align="right">�������� ��</td>
	          <td class=td-02>
		          <c:out value="${user.workdept.name}"/>
		        
	          </td> 
          
            <td height="22" class=td-01  align="right">���ڴ��ң�</td>
            <td height="22" class=td-02>
				<c:out value="${user.deptname}"/>
	          
            </td>
        </tr>
          <tr> 
            <td height="22" class=td-01  align="right">���� ��</td>
            <td height="22" class=td-02>
<c:out value="${user.name}"/></td>
            <td class=td-01  align="right">�Ա�</td>
            <td height="22" class=td-02>

 <c:out value="${user.gender}"/> 
              </td>
        </tr>
          <tr height="22" > 
            <td height="22" class=td-01  align="right">��Ա���� ��</td>
          <td height="22" class=td-02><c:out value="${user.num}"/></td>
            <td height="22" class=td-01  align="right">�����أ�</td>
          <td height="22" valign="top" class=td-02><c:out value="${user.birthlocation}"/></td>
        </tr>
          <tr> 
            <td height="22" class=td-01  align="right">�������£�</td>
            <td height="22" class=td-02>             	
           <c:out value="${user.birthday}" />
				                       </td>
            <td class=td-01  align="right">���壺</td>
            <td class=td-02> <c:out value="${user.nation}"/> </td>
        </tr>
        <tr> 
          <td height="22" class=td-01  align="right">ѧ����</td>
          <td height="22" class=td-02> 
           <c:out value="${user.xueli}"/>
          	         </td>
          <td class=td-01  align="right">ѧλ��</td>
          <td class=td-02> 
          <c:out value="${user.xuewei}"/>
          </td>
        </tr>
          <tr> 
            <td height="22" class=td-01  align="right">��ѧרҵ��</td>
            <td height="22" class=td-02>
<c:out value="${user.zhuanye}"/></td>
            <td class=td-01  align="right">��ҵԺУ��ʱ�䣺</td>
            <td class=td-02>
<c:out value="${user.yuanxiao}"/></td>
        </tr>
          <tr> 
            <td height="22" class=td-01  align="right">������ò��</td>
            <td height="22" class=td-02>
��Ա</td>
            <td class=td-01  align="right">�뵳/��ʱ�䣺</td>
            <td class=td-02>             		
           <c:out value="${user.rudangshijian}" />
				     </td>
        </tr>
        <tr> 
          <td height="22" class=td-01  align="right">ְ�ƣ�</td>
          <td height="22" class=td-02> 
           <c:out value="${user.callname}" />
          	<td class=td-01  align="right">ְ��</td>
          <td class=td-02> <c:out value="${user.positionid}"/></td>
        </tr>
          <tr> 
            <td height="22" class=td-01  align="right">���֤�ţ�</td>
            <td height="22" class=td-02>
<c:out value="${user.identitynum}"/></td>
            <td class=td-01  align="right">����֤�ţ�</td>
            <td class=td-02>
<c:out value="${user.worknum}"/></td>
        </tr>
          <tr> 
            <td height="22" class=td-01  align="right">��λ��ַ��</td>
            <td height="22" class=td-02>
<c:out value="${user.address}"/></td>
            <td class=td-01  align="right">��ϵ�绰��</td>
            <td class=td-02>
<c:out value="${user.homephone}"/></td>
        </tr>
          <tr> 
            <td height="22" class=td-01  align="right">�칫�绰��</td>
            <td height="22" class=td-02>
<c:out value="${user.officephone}"/></td>
            <td class=td-01  align="right">�ƶ��绰��</td>
            <td class=td-02>
<c:out value="${user.mobile}"/></td>
        </tr>
          <tr> 
            <td height="22" class=td-01  align="right">������ţ�</td>
            <td height="22" class=td-02>
<c:out value="${user.publicmoneynum}"/></td>
            <td class=td-01  align="right">���ϱ��պţ�</td>
            <td class=td-02>
<c:out value="${user.oldsupportnum}"/></td>
        </tr>
          <tr> 
            <td height="22" class=td-01  align="right">ס�������ţ�</td>
            <td height="22" class=td-02>
<c:out value="${user.housepaynum}"/></td>
            <td class=td-01  align="right">ҽ�Ʊ��պţ�</td>
            <td class=td-02>
<c:out value="${user.securitynum}"/></td>
        </tr>
          <tr> 
          <td class=td-01  align="right">���᣺</td>
            <td class=td-02>
<c:out value="${user.jiguan}"/></td>
            <td height="22" class=td-01  align="right">�μӹ���ʱ�䣺</td>
            <td height="22" class=td-02>            
             <c:out value="${user.workyear}" />
				    </td>
        </tr>

		
		 <tr> 
          <td class="td-01"  align="right">֤��ţ�</td>
            <td class="td-02" colspan="3">
<c:out value="${user.canumber}" /></td>
           
        </tr>
		
          <tr> 
            <td height="22" class=td-01  align="right">��ע��
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