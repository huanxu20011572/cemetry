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
          	��ϲ�������Ѿ�ע��ɹ���<br>
			��Ⱥ����Ĳ����쵼�Լ�����Ա�������ʺŵ�������<br>
			����������ע����Ϣ:
          
          <font color="ff0000"><html:errors/></font></strong></td>
          <td width="46%" align="right"><table width="300" border="0" cellpadding="0" cellspacing="0">
              <tr class="td16"> 
                <td width="60" class="td16">&nbsp;</td>
                <td width="60" class="td16">&nbsp;</td>
                <td width="60" class="td16">��<a href="javascript:window.close();">�ر�</a>��</td>
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
          <td width="15%" height="22" class="td22">�û�ID��</td>
          <td width="31%" height="22" class="td23"> 
          	<c:out value="${user.loginid}"/>
          </td>
		  <td width="16%" align="right" class="td22">�û�Ȩ�ޣ�</td>
      
          <td width="38%" class="td23">
          	<topsuntech:registStatus> 
          		<c:out value="${user.registstatus}"/>
          	</topsuntech:registStatus> 	
          </td>
          
        </tr>
        <tr> 
          <td width="15%" height="22" class="td22">����ID��</td>
          <td width="31%" height="22" class="td23"> <c:out value="${user.emailid}"/></td>
          <td width="16%" align="right" class="td22">�Ƿ񷢶���</td>
          <td width="38%" class="td23"><c:out value="${user.cansms}"/></td>
        </tr>
        <tr height="22" > 
          <td height="22" class="td22">���룺</td>
          <td height="22" class="td23">******</td>
          <td height="22" class="td22">����ȷ�ϣ�</td>
          <td height="22" valign="top" class="td23">******</td>
        </tr>
        <tr> 
          <td height="22" class="td22">�������ţ�</td>
		  <td height="22" class="td23">
	          <c:out value="${user.deptname}"/> 
          </td>
          <td class="td22">��Ա��ţ�</td>
          <td class="td23"><c:out value="${user.num}"/></td>
        </tr>
        <tr> 
          <td height="22" class="td22">����*��</td>
          <td height="22" class="td23"><c:out value="${user.name}"/></td>
          <td class="td22">�Ա�</td>
          <td class="td23"><c:out value="${user.gender}"/>  
          </td>
        </tr>
        <tr height="22" > 
          <td height="22" class="td22">���᣺</td>
          <td height="22" class="td23"><c:out value="${user.jiguan}"/></td>
          <td height="22" class="td22">�����أ�</td>
          <td height="22" valign="top" class="td23"><c:out value="${user.birthlocation}"/></td>
        </tr>
        <tr> 
          <td height="22" class="td22">�������£�</td>
          <td height="22" class="td23"> 
          	<fmt:formatDate value="${user.birthday}" pattern="yyyy-MM-dd" />
          </td>
          <td class="td22">���壺</td>
          <td class="td23"><c:out value="${user.nation}"/></td>
        </tr>
        <tr> 
          <td height="22" class="td22">ѧ����</td>
          <td height="22" class="td23"><c:out value="${user.xueli}"/></td>
          <td class="td22">ѧλ��</td>
          <td class="td23"> <c:out value="${user.xuewei}"/></td>
        </tr>
        <tr> 
          <td height="22" class="td22">��ѧרҵ��</td>
          <td height="22" class="td23"><c:out value="${user.zhuanye}"/></td>
          <td class="td22">��ҵԺУ��ʱ�䣺</td>
          <td class="td23"><c:out value="${user.yuanxiao}"/></td>
        </tr>
        <tr> 
          <td height="22" class="td22">������ò��</td>
          <td height="22" class="td23"><c:out value="${user.zhengzhimianmao}"/></td>
          <td class="td22">�뵳/��ʱ�䣺</td>
          <td class="td23">
          	<fmt:formatDate value="${user.rudangshijian}" pattern="yyyy-MM-dd" />
          </td>
        </tr>
        <tr> 
          <td height="22" class="td22">ְ�ƣ�</td>
          <td height="22" class="td23"><c:out value="${user.callname}"/> 
          </td>
          <td class="td22">ְ��</td>
          <td class="td23"><c:out value="${user.positionid}"/></td>
        </tr>
        <tr> 
          <td height="22" class="td22">���֤�ţ�</td>
          <td height="22" class="td23"><c:out value="${user.identitynum}"/></td>
          <td class="td22">����֤�ţ�</td>
          <td class="td23"><c:out value="${user.worknum}"/></td>
        </tr>
        <tr> 
          <td height="22" class="td22">��ͥ��ס��ַ��</td>
          <td height="22" class="td23"><c:out value="${user.address}"/></td>
          <td class="td22">סլ�绰��</td>
          <td class="td23"><c:out value="${user.homephone}"/></td>
        </tr>
        <tr> 
          <td height="22" class="td22">�칫�绰��</td>
          <td height="22" class="td23"><c:out value="${user.officephone}"/></td>
          <td class="td22">�ƶ��绰��</td>
          <td class="td23"><c:out value="${user.mobile}"/></td>
        </tr>
        <tr> 
          <td height="22" class="td22">������ţ�</td>
          <td height="22" class="td23"><c:out value="${user.publicmoneynum}"/></td>
          <td class="td22">���ϱ��պţ�</td>
          <td class="td23"><c:out value="${user.oldsupportnum}"/></td>
        </tr>
        <tr> 
          <td height="22" class="td22">ס�������ţ�</td>
          <td height="22" class="td23"><c:out value="${user.housepaynum}"/></td>
          <td class="td22">ҽ�Ʊ��պţ�</td>
          <td class="td23"><c:out value="${user.securitynum}"/></td>
        </tr>
        <tr> 
          <td height="22" class="td22">�μӹ���ʱ�䣺</td>
          <td height="22" class="td23"> 
          	<fmt:formatDate value="${user.workyear}" pattern="yyyy-MM-dd" />
          </td>
          <td class="td22">�������ţ�</td>
          <td class="td23"><c:out value="${user.workdept.name}"/></td>
        </tr>
        <tr> 
          <td height="22" class="td22">��ע�� <label id="deslbl" name="deslbl"></label></td>
          <td height="22" colspan="3" class="td23"><c:out value="${user.memo}"/></td>
        </tr>
      </table>
</body>
</html>
