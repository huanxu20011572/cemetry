<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib uri="/WEB-INF/tld/gTaglib-gOS.tld" prefix="gOS" %>
<%@ taglib uri="/WEB-INF/tld/gOS-applog.tld" prefix="alog" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>�����������֯�����������������ƽ̨</title>
    <meta http-equiv="Content-Type" content="text/html; charset=GBK">
<gOS:skin />
    <script src="../../../script/function.js"></script>
    <%
        String[] jsFiles = request.getParameterValues("js");
        request.setAttribute("files", jsFiles);
    %>
<c:forEach var="jsFile" items="${files}" >
    <script src="<gOS:url><c:out value="${jsFile}" /></gOS:url>"></script>
</c:forEach>
</head>

<!-- Link Tigra Hints script file to your HTML document-->
<script language="JavaScript" src="/lib/hints.js"></script>
<!-- Link Tigra Hints configuration file to your HTML document-->
<script language="JavaScript" src="/lib/hints_cfg.js"></script>
<body scroll="no" onload="f_resize_main_span()" onresize="f_resize_main_span()">
<span id="_main_Span" style="width:100%;overflow:auto">
<table id="_main_table" class="table_template" border="0" cellpadding="0" cellspacing="0" align="right">
  <input name="id" type="hidden" value=""> 
  <tr>      
    <td align="right" class="td18_1" valign="top"> 
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table-line">
        <tr>           
                    <td width="69%"><strong>&nbsp;��־����</strong></td>
          <td width="31%" align="right">
		    <table border="0" cellpadding="0" cellspacing="0">
              <tr class="td16"> 
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td width="52">��<a href="applog.do?action=search">��ѯ</a>��</td>
              </tr>
            </table>
		  </td>
        </tr>
      </table>
            <table width="100%" border="0" class="table_main>
                <tr class="td-bg-left" height="22" > 
		            <td width="10%">&nbsp;ƽ̨����</td>
                    <td width="10%">&nbsp;ģ������</td>
                    <td width="10%">&nbsp;������</td>
                    <td width="15%">&nbsp;����ʱ��</td>
                    <td width="10%">&nbsp;��־����</td>
                    <td width="30%">&nbsp;��־����</td>
                    <td width="15%">&nbsp;ִ�в���</td>
                </tr>
                <c:forEach var="log" items="${logList}" >
                <tr class="td-bg-left">
		            <td>&nbsp;
		            <alog:show type="platform">
		            	<c:out value="${log.platformid}"/>
		            </alog:show>
		            </td>
                    <td>&nbsp;<c:out value="${log.modulename}"/></td>
                    <td>&nbsp;<c:out value="${log.username}"/></td>
                    <td>&nbsp;<fmt:formatDate value="${log.apenddate}" pattern="yyyy-MM-dd hh:mm:ss" /></td>
                    <td>&nbsp;
                    <alog:show type="operatetype">
                    	<c:out value="${log.operatetype}"/>
                    </alog:show>
                    </td>
                    <td>&nbsp;<c:out value="${log.info}"/></td>
                    <td>
                    	&nbsp;<a href="applog.do?action=detail&id=<c:out value="${log.id}"/>">��ϸ��Ϣ</a>
                    </td>
                </tr>		
                </c:forEach>		
      </table></td>
  </tr>

  <tr> 
    <td align="left" valign="bottom"> 
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="page">
        <tr> 
             <td width="40%" valign="bottom">
             </td>
		   	<td width="60%" valign="bottom" align="right"> 	
		   			<gOS:page name="test" action="applog.do?action=searchresult" pageName="dataPage" pageSizeKey="list">
			            <gOS:param name="platformid"><c:out value="${aForm.platformid}" /></gOS:param>
			            <gOS:param name="modulename"><c:out value="${aForm.modulename}" /></gOS:param>
			            <gOS:param name="username"><c:out value="${aForm.username}" /></gOS:param>
			            <gOS:param name="operatetype"><c:out value="${aForm.operatetype}" /></gOS:param>
			            <gOS:param name="info"><c:out value="${aForm.info}" /></gOS:param>
			            <gOS:param name="startDate"><c:out value="${aForm.startDate}" /></gOS:param>
			            <gOS:param name="endDate"><c:out value="${aForm.endDate}" /></gOS:param>
					</gOS:page> 
				</td>		           
        </tr>
      </table>
    </td>
  </tr>
</table>
</span>
</body>
</html>
