<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib uri="http://www.topsuntech.com/jsptags/tree-taglib" prefix="topsuntech" %>
<%@ taglib uri="/WEB-INF/tld/gTaglib-gOS.tld" prefix="gOS" %>
<html>
<head>
<title>Untitled Document</title>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<gOS:skin />
    
<!-- Code for browser detection -->
<script src="../../../script/action.js" language="JScript"></script>
<script src="../../../script/ua.js"></script>
<script src="../../../script/function.js"></script>
<script>
	function onsubmit(){
		if(window.confirm('��ȷ��Ҫɾ���õ�λ��')){
			location.href('officeDelete.do?action=delete&id=<c:out value="${office.id}"/>');
		}
	
	}
</script>

<link href="../../../css/css.css" rel="stylesheet" type="text/css">
</head>

<body bgcolor="#FFFFFF" text="#000000" leftmargin="0" topmargin="0" scroll="no" onLoad="f_resize_main_span()" onResize="f_resize_main_span()">
<span id="_main_Span" style="width:100%;overflow:auto">

<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table_template" id="_main_table">
  <tr> 
    <td valign="top"> 
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table7">
        <tr> 
          <td width="49%" height="17" class="list_title"><table width="300" border="0" cellpadding="0" cellspacing="0">
              <tr class="td16">
                <td width="60" class="td16"><label>
                  <input name="Submit" type="button" onClick="onsubmit();" class="input_btn" value="ȷ��">
                </label></td>
                <td width="60" class="td16"><label>
                  <input name="Submit2" type="button"  onClick="javascript:history.back()" class="input_btn" value="ȡ��">
                </label></td>
                <td width="60" class="td16">&nbsp;</td>
                <td width="60" class="td16">&nbsp;</td>
                <td width="60" class="td16">&nbsp;</td>
              </tr>
            </table></td>
          <td width="51%" align="right" class="list_title"><font color="#000000"><strong>��ȷ��Ҫɾ���õ�λ��</strong></font></td>
        </tr>
      </table>
      <BR/>
      <table width="100%" border="0" cellpadding="1" class="ConfigTable">
        <tr class="tr2"> 
          <td width="15%" class="list_title"><div align="center">��λ���</div></td>
          <td width="19%" class="list_title"><div align="center">��λ����</div></td>
          <td width="20%" class="list_title"><div align="center">��������</div></td>
          <td width="46%" class="list_title"><div align="center">����</div></td>
        </tr>
        <tr class="tr1" > 
          <td width="15%" height="21"><div align="center"><c:out value="${office.num}" /></div></td>
          <td width="19%"><div align="center"><font color="#000000"><a href="officeSelect.do?action=detail&id=<c:out value="${office.id}"/>"><c:out value="${office.name}" /></a></font></div></td>
          <td width="20%"><div align="center"><fmt:formatDate value="${office.createdate}" pattern="yyyy-MM-dd" /></div></td>
          <td width="46%"><div align="center"><font color="#000000"><c:out value="${office.description}" /></font></div></td>
        </tr>
      </table>
      
    </td>
  </tr>
  <tr class="tr2"> 
    <td height="32" align="left"><font color="#FF0000">���棺�õ�λ�����ӵ�λ���û���ɾ���õ�λ��ɾ���������ӵ�λ���û��� 
      <br>
      ������ʹ��<a href="officeMove.do?action=showMove">�ƶ���λ</a>��<a href="userMove.do?action=showMove">�ƶ��û�</a>���ܽ������ӵ�λ���û��Ƶ�������λ�� 
      Ȼ���ٽ���ɾ��������</font>&nbsp; </td>
  </tr>

</table>
</span>
</body>
</html>
