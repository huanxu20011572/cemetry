<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib uri="/WEB-INF/tld/topsuntech-tree.tld" prefix="topsuntech" %>
<%@ taglib uri="/WEB-INF/tld/gTaglib-gOS.tld" prefix="gOS" %>
<%@page import="com.topsuntech.gOS.user.session.*" %>
<%@page import="com.topsuntech.gOS.user.en.user.*" %>
<html>
<head>
<title>Untitled Document</title>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<gOS:skin />

</head>

<body bgcolor="#FFFFFF" text="#000000" leftmargin="0" topmargin="0">


      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table7">
        <tr> 
          <td width="0%" height="20">&nbsp; </td>
          <td width="54%" height="20" align="left"> <strong>
          	恭喜您，您已经注册成功！<br>
			请等候您的部门领导以及管理员对您的帐号的审批！<br>
			以下是您的注册信息:
          
          <font color="ff0000"><html:errors/></font></strong></td>
          <td width="46%" align="right"><table width="300" border="0" cellpadding="0" cellspacing="0">
              <tr class="td16"> 
                <td width="60" class="td16">&nbsp;</td>
                <td width="60" class="td16">&nbsp;</td>
                <td width="60" class="td16">【<a href="javascript:window.close();">关闭</a>】</td>
              </tr>
            </table></td>
        </tr>
      </table>

	  <table width="100%" border="0" class="table5">
        <tr> 
          <td></td>
        </tr>
      </table>
      
      <table width="100%" border="0" cellpadding="1" cellspacing="1" class="table_main">
        <tr> 
          <td width="15%" height="22" class="td22">用户ID：</td>
          <td width="31%" height="22" class="td23"> 
          	<c:out value="${user.loginid}"/>
          </td>
		  <td width="16%" align="right" class="td22">用户权限：</td>
      
          <td width="38%" class="td23">
          	<topsuntech:registStatus> 
          		<c:out value="${user.registstatus}"/>
          	</topsuntech:registStatus> 	
          </td>
          
        </tr>
        <tr> 
          <td width="15%" height="22" class="td22">邮箱ID：</td>
          <td width="31%" height="22" class="td23"> <c:out value="${user.emailid}"/></td>
          <td width="16%" align="right" class="td22">是否发短信</td>
          <td width="38%" class="td23"><c:out value="${user.cansms}"/></td>
        </tr>
        <tr height="22" > 
          <td height="22" class="td22">密码：</td>
          <td height="22" class="td23">******</td>
          <td height="22" class="td22">密码确认：</td>
          <td height="22" valign="top" class="td23">******</td>
        </tr>
        <tr> 
          <td height="22" class="td22">所属部门：</td>
		  <td height="22" class="td23">
	          <c:out value="${user.deptname}"/> 
          </td>
          <td class="td22">人员编号：</td>
          <td class="td23"><c:out value="${user.num}"/></td>
        </tr>
        <tr> 
          <td height="22" class="td22">姓名*：</td>
          <td height="22" class="td23"><c:out value="${user.name}"/></td>
          <td class="td22">性别：</td>
          <td class="td23"><c:out value="${user.gender}"/>  
          </td>
        </tr>
        <tr height="22" > 
          <td height="22" class="td22">籍贯：</td>
          <td height="22" class="td23"><c:out value="${user.jiguan}"/></td>
          <td height="22" class="td22">出生地：</td>
          <td height="22" valign="top" class="td23"><c:out value="${user.birthlocation}"/></td>
        </tr>
        <tr> 
          <td height="22" class="td22">出生年月：</td>
          <td height="22" class="td23"> 
          	<fmt:formatDate value="${user.birthday}" pattern="yyyy-MM-dd" />
          </td>
          <td class="td22">民族：</td>
          <td class="td23"><c:out value="${user.nation}"/></td>
        </tr>
        <tr> 
          <td height="22" class="td22">学历：</td>
          <td height="22" class="td23"><c:out value="${user.xueli}"/></td>
          <td class="td22">学位：</td>
          <td class="td23"> <c:out value="${user.xuewei}"/></td>
        </tr>
        <tr> 
          <td height="22" class="td22">所学专业：</td>
          <td height="22" class="td23"><c:out value="${user.zhuanye}"/></td>
          <td class="td22">毕业院校及时间：</td>
          <td class="td23"><c:out value="${user.yuanxiao}"/></td>
        </tr>
        <tr> 
          <td height="22" class="td22">政治面貌：</td>
          <td height="22" class="td23"><c:out value="${user.zhengzhimianmao}"/></td>
          <td class="td22">入党/团时间：</td>
          <td class="td23">
          	<fmt:formatDate value="${user.rudangshijian}" pattern="yyyy-MM-dd" />
          </td>
        </tr>
        <tr> 
          <td height="22" class="td22">职称：</td>
          <td height="22" class="td23"><c:out value="${user.callname}"/> 
          </td>
          <td class="td22">职务：</td>
          <td class="td23"><c:out value="${user.positionid}"/></td>
        </tr>
        <tr> 
          <td height="22" class="td22">身份证号：</td>
          <td height="22" class="td23"><c:out value="${user.identitynum}"/></td>
          <td class="td22">工作证号：</td>
          <td class="td23"><c:out value="${user.worknum}"/></td>
        </tr>
        <tr> 
          <td height="22" class="td22">家庭居住地址：</td>
          <td height="22" class="td23"><c:out value="${user.address}"/></td>
          <td class="td22">住宅电话：</td>
          <td class="td23"><c:out value="${user.homephone}"/></td>
        </tr>
        <tr> 
          <td height="22" class="td22">办公电话：</td>
          <td height="22" class="td23"><c:out value="${user.officephone}"/></td>
          <td class="td22">移动电话：</td>
          <td class="td23"><c:out value="${user.mobile}"/></td>
        </tr>
        <tr> 
          <td height="22" class="td22">公积金号：</td>
          <td height="22" class="td23"><c:out value="${user.publicmoneynum}"/></td>
          <td class="td22">养老保险号：</td>
          <td class="td23"><c:out value="${user.oldsupportnum}"/></td>
        </tr>
        <tr> 
          <td height="22" class="td22">住房补贴号：</td>
          <td height="22" class="td23"><c:out value="${user.housepaynum}"/></td>
          <td class="td22">医疗保险号：</td>
          <td class="td23"><c:out value="${user.securitynum}"/></td>
        </tr>
        <tr> 
          <td height="22" class="td22">参加工作时间：</td>
          <td height="22" class="td23"> 
          	<fmt:formatDate value="${user.workyear}" pattern="yyyy-MM-dd" />
          </td>
          <td class="td22">工作部门：</td>
          <td class="td23"><c:out value="${user.workdept.name}"/></td>
        </tr>
        <tr> 
          <td height="22" class="td22">备注： <label id="deslbl" name="deslbl"></label></td>
          <td height="22" colspan="3" class="td23"><c:out value="${user.memo}"/></td>
        </tr>
      </table>
</body>
</html>
