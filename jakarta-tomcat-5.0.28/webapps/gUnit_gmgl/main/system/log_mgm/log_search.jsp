<%@page import="java.io.*" %>
<%@page contentType="text/html;charset=GBK"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib uri="/WEB-INF/tld/gTaglib-gOS.tld" prefix="gOS" %>
<html>
<head>
<title>Query</title>
<gOS:skin />
<script src="../../../script/action.js" language="JScript"></script>
<script src="../../../script/toolbar-ie5.js" language="JScript"></script>
<link href="../../../script/toolbar-ie5.css" type="text/css" rel="stylesheet">
<xml id="xsl" src="../../../script/toolbar-ie5.xsl"></xml>

<html:base/>

</head>
<script src="../../../script/ua.js"></script>
<jsp:include page="/common/header.jsp" flush="true" />
<body scroll="no" onload="f_resize_main_span()" onresize="f_resize_main_span()">
<span id="_main_Span" style="width:100%;overflow:auto">
<table border="0" cellpadding="0" id="_main_table" cellspacing="0" align="right" class="table_template">
    <tr>        
        <td align="right" valign="top" class="td18_1"> 
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table7">
        <tr> 
          <td height="17"> 
            <xml id="os_toolbar_2727376791"> 
              <toolbar> 
                <item title="搜索" 	icon="../../../images/config/zoom_small.gif"    action="form1.submit();"/>
                <item title="取消" 	icon="../../../images/config/cancel.gif"    action="history.back();"/>
         	<item title="刷新" 	icon="../../../images/config/reload_nav.gif"    action="location.reload();"/>
              </toolbar>
            </xml> <span id="os_toolbar_2727376791_result" style="display: inline-block;"></span> 
            <script>document.all['os_toolbar_2727376791'].ondatasetcomplete = os_init_toolbar;</script>
          </td>
        </tr>
      </table>
<script language="JavaScript" src="../../../script/timestamp.js">
</script>
<FORM name="form1" action="logSelect.do?action=searchResult" method="post">
  <TABLE width="200%" border="0" cellpadding="1" cellspacing="1" bgcolor="#EECCB4" class="ConfigTable">
    <% int i = 1; %>
    <% com.topsuntech.gOS.query.jsp.QueryFormGenerator.generateForm("logSearch", 
                    new String[]{"com.topsuntech.gOS.logger.en.ApplicationLog"}, 
    	            request); %>

    <c:forEach var="item" items='${rowList}' >
			<% if (i % 4 == 1) {%>
    <TR class="tr1" >
			<% } else if(i % 4 ==3){%>
    <TR class="tr3" >
			<% }%>
    <TD>
      <c:out value='${item.show}'/>
    </TD>  
    <TD class="td41">  
      <c:choose>
        <c:when test='${item.type=="BOOLEAN"}'>
          <select width=180 name="query$column$<c:out value='${item.table}'/>$<c:out value='${item.column}'/>$0" >
            <option></option>
            <option value=true>true</option>
            <option value=false>false</option>
          </select>
        </c:when>
        
        <c:when test='${item.type=="DATE" || item.type=="SQLDATE" || item.type=="CALENDAR" || item.type=="TIME" || item.type=="TIMESTAMP" }'>
          <a href="javascript:show_timestamp('document.form1.query$column$<c:out value='${item.table}'/>$<c:out value="${item.column}"/>$5', document.form1.query$column$<c:out value='${item.table}'/>$<c:out value="${item.column}"/>$5.value);"><img src="../../../images/cal.gif" width="16" height="16" border="0" alt="点击弹出选择日期时间对话框"></a>
          <input size=20 width=180 height=16 name="query$column$<c:out value='${item.table}'/>$<c:out value='${item.column}'/>$5" readonly>
          <img src="../../../images/rights1.gif">
          <input size=20 width=180 height=16 name="query$column$<c:out value='${item.table}'/>$<c:out value='${item.column}'/>$3" readonly>
          <a href="javascript:show_timestamp('document.form1.query$column$<c:out value='${item.table}'/>$<c:out value="${item.column}"/>$3', document.form1.query$column$<c:out value='${item.table}'/>$<c:out value="${item.column}"/>$3.value);"><img src="../../../images/cal.gif" width="16" height="16" border="0" alt="点击弹出选择日期时间对话框"></a>
        </c:when>
        
        <c:when test='${item.type=="STRING" || item.type=="PASSWORD"}'>
          <input size=20 width=180 height=16 name="query$column$<c:out value='${item.table}'/>$<c:out value='${item.column}'/>$6">        
        </c:when>

        <c:when test='${item.type=="ENUMERATE"}'>
          <select width=180 name="query$column$<c:out value='${item.table}'/>$<c:out value='${item.column}'/>$0" >
          <option></option>
          <c:forEach var="field" items='${item.list}'>
          <option value="<c:out value='${field}'/>">
          <c:out value='${field}'/>
          </option>
          </c:forEach>
          </select>
        </c:when>

        <c:otherwise>
          <input size=20 width=180 height=16 name="query$column$<c:out value='${item.table}'/>$<c:out value='${item.column}'/>$5">
          <img src="../../../images/rights1.gif">
          <input size=20 width=180 height=16 name="query$column$<c:out value='${item.table}'/>$<c:out value='${item.column}'/>$3">
        </c:otherwise>
      </c:choose>
    </TD>
    <% if (i % 4 == 2 || i%4==0) {%>
    </TR><%}%>
    <% i++; %>
    </c:forEach>
  </TABLE>		
    <c:forEach var = "hidden" items="${hiddenList}">
      <input type=hidden name="<c:out value='${hidden.name}'/>" value="<c:out value='${hidden.value}'/>">
    </c:forEach>
    <tr><td>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="page">
<tr><td>
<!--
    <input type=submit name=submit value=搜索>
-->
</td></tr></table>
</td></tr>
</FORM>
    <tr><td>
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table7">
	  <tr class="tr2"> 
	    <td align="left">
	    <font color="#FF0000">
	    帮助：日志管理用于查询和管理系统中的日志。<br>
	    &nbsp;&nbsp;&nbsp;&nbsp;“分类”表示该日志是从哪个模块产生的。<br>
	    &nbsp;&nbsp;&nbsp;&nbsp;“优先级”表示该日志的严重程度。WARN表示警告，ERROR表示错误<br>
	    &nbsp;&nbsp;&nbsp;&nbsp;FATAL表示严重错误，DEBUG代表调试信息，INFO代表一般信息<br>
	    </font> 
	    </td>
	  </tr>
	</table>  
      </td>
    </tr>
</table>  
</body>
</html>
