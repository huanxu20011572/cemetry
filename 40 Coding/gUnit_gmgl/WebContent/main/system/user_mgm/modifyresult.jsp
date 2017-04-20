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
          <font color="ff0000"><html:errors/></font></strong></td>
          <td width="46%" align="right"><table width="300" border="0" cellpadding="0" cellspacing="0">
              <tr class="td16"> 
                <td width="60" class="td16">&nbsp;</td>
                <td width="60" class="td16">&nbsp;</td>
                <td width="60" class="td16">【详细信息】</td>
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
          <td height="22" colspan="4" align="center" class="td23">
          <font color=red>
               <strong> 恭喜您，您已经成功修改了个人信息，以下是您的注册信息！</strong>
           </font>     
          </td>
          
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
      </table>
</body>
</html>
