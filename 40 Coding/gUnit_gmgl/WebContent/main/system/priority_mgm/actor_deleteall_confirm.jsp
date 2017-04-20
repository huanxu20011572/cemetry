<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib uri="/WEB-INF/tld/gTaglib-gOS.tld" prefix="gOS" %>
<link href="../../../css/css.css" rel="stylesheet" type="text/css">
<html>
<head>
<title>Untitled Document</title>

<script src="../../../script/action.js" language="JScript"></script>
<link href="../../../css/css.css" rel="stylesheet" type="text/css">
<script src="../../../script/toolbar-ie5.js" language="JScript"></script>
<link href="../../../script/toolbar-ie5.css" type="text/css" rel="stylesheet">
<xml id="xsl" src="../../../script/toolbar-ie5.xsl"></xml>
<script language="javascript">
function doCancel(){
	myform.action = "actorSelect.do?action=list";
	myform.submit();	
}
</script>
</head>

<body>
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="11" background="../../../images/images_32.jpg"><img src="../../../images/content_left.gif" width="11" height="51"></td>
    <td height="51" background="../../../images/images_32.jpg"><table width="70%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="22" height="16" align="center"><img src="../../../images/d.gif" width="14" height="14"></td>
          <td valign="bottom"> 当前位置：</td>
      </tr>
    </table>
    </td>
  </tr>
  <tr>
    <td background="../../../images/images_481.jpg">&nbsp;</td>
    <td valign="top">
<TABLE type="grid" border="0"  style="table-layout:fixed;"    name= "listTable" id = "listTable" cellpadding="1" cellspacing="1"> 
									
  <!--DWLayoutTable-->
  <tr>
    <td valign="top">
      <table width="100%" border="0" cellpadding="0" cellspacing="0" >
        <tr>
          <td height="17" class="list_title"><strong>你确认要删除下列角色吗？ </strong>          </td>
        </tr>
      </table><br/>
      <form action="actorDeleteAll.do?action=deleteAll" name="myform" method="post">        
    	<TABLE type="grid" border="0"  style="table-layout:fixed;"    name= "listTable" id = "listTable" cellpadding="1" cellspacing="1" bgcolor="a8d1eb"> 
				 <tr class="td-04">
          <td width="36%" height="22" ><div align="center">名称</div></td>
          <td width="21%" height="22" ><div align="center">创建人</div></td>
          <td width="13%" height="22" ><div align="center">创建日期</div></td>
          <td width="30%" height="22" ><div align="center">描述</div></td>
        </tr>
        <% int i = 1; %>
        <c:forEach var="actor" items="${actorList}" >
			<% if (i++ % 2 == 1) {%>
        <tr  >
			<% } else {%>
        <tr  >
			<% }%>  
	  <input name="ids" type="hidden" value="<c:out value="${actor.id}"/>">
          <td width="36%" class="td-02" height="22">
            <div align="center"><a href="actorSelect.do?action=detail&id=<c:out value="${actor.id}"/>">
            <c:out value="${actor.name}"/></a></div>
            </td>
          <td width="21%" class="td-02" height="22">
            <div align="center"><c:out value="${actor.creatorname}" /></div></td>
          <td width="13%" class="td-02" height="22">
            <div align="center"><fmt:formatDate value="${actor.createdate}" pattern="yyyy-MM-dd" /></div></td>
          <td width="30%" class="td-02" height="22">
            <div align="center"><c:out value="${actor.description}" /></div></td>
        </tr>
        </c:forEach>        
      </table>
      <table width="100%" border="0" cellpadding="0" cellspacing="0" align="center>
              <tr class="td16">
        <!--DWLayoutTable-->
                <td width="1555" align="right" class="td-02">
                	<input type="button" value="确定" class="input_btn" onClick="javascript:myform.submit();"/>                </td>
                <td width="1555" align="left" class="td-02">
                  <input type="button" value="取消" class="input_btn" onClick="doCancel();"/>                </td>
              </tr>  <tr>
                  <td height="125"></td>
                  <td></td>
                </tr>
        </table>
</form>    </td>
  </tr>
  <tr>
    <td height="400">&nbsp;</td>
  </tr>
</table>
</td>
  </tr>
</table>
</body>
</html>
