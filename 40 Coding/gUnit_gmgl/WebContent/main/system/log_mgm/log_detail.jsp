<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib uri="http://www.topsuntech.com/jsptags/tree-taglib" prefix="topsuntech" %>
<%@ taglib uri="/WEB-INF/tld/gTaglib-gOS.tld" prefix="gOS" %>
<html>
<jsp:include page="/common/header.jsp" flush="true" />
<body scroll="no" onload="f_resize_main_span()" onresize="f_resize_main_span()">
<span id="_main_Span" style="width:100%;overflow:auto">
<table border="0" cellpadding="0" id="_main_table" cellspacing="0" align="right" class="table_template">
    <tr>        
        <td align="right" valign="top" class="td18_1"> 
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table7">
        <tr> 
          <td width="0%" height="20">&nbsp; </td>
          <td width="54%" height="20" align="bottom">&nbsp; </td>
          <td width="46%" align="right"><table width="300" border="0" cellpadding="0" cellspacing="0">
              <tr class="td16"> 
                <td width="60" class="td16">&nbsp;</td>
                <td width="60" class="td16">&nbsp;</td>
                <td width="60" class="td16">&nbsp; </td>
                <td width="60" class="td16">&nbsp;</td>
                <td width="60" class="td16">【<a href="javascript:history.back();">确定</a>】</td>
              </tr>
            </table></td>
        </tr>
      </table>
      <table width="100%" border="0" cellpadding="1" cellspacing="1" class="table_main">
        <tr> 
          <td width="15%" height="22" class="td22">编号：</td>
          <td width="86%" height="22" class="td23"><c:out value="${log.id}" /></td>
        </tr>
        <tr> 
          <td height="22" class="td22">产生用户：</td>
          <td width="86%" height="22" class="td23"><c:out value="${log.userName}" /></td>
        </tr>
        <tr> 
          <td height="22" class="td22">包名称：</td>
          <td width="86%" height="22" class="td23"><c:out value="${log.packagename}" /></td>
        </tr>
        <tr> 
          <td height="22" class="td22">分类：</td>
          <td width="86%" height="22" class="td23"><c:out value="${log.category}" /></td>
        </tr>
        <tr> 
          <td height="22" class="td22">类名称：</td>
          <td width="86%" height="22" class="td23"><c:out value="${log.classname}" /></td>
        </tr>      
        <tr> 
          <td height="22" class="td22">时间：</td>
          <td width="86%" height="22" class="td23"><c:out value="${log.time}" /></td>
        </tr>   
        <tr> 
          <td height="22" class="td22">优先级：</td>
          <td width="86%" height="22" class="td23"><c:out value="${log.priority}" /></td>
        </tr>   
        <tr> 
          <td height="22" class="td22">信息：</td>
          <td width="86%" height="22" class="td23"><c:out value="${log.info}" /></td>
        </tr>                           
      </table>
      </td>
    </tr>
</table>      
</body>
</html>        