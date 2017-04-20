<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib uri="/WEB-INF/tld/gTaglib-gOS.tld" prefix="gOS" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<jsp:include page="/common/header.jsp" flush="true" />

<!-- Link Tigra Hints script file to your HTML document-->
<!-- Link Tigra Hints configuration file to your HTML document-->
<body scroll="no" onload="f_resize_main_span()" onresize="f_resize_main_span()">
<span id="_main_Span" style="width:100%;overflow:auto">
<table id="_main_table" class="table_template" border="0" cellpadding="0" cellspacing="0" align="right">
  <input name="id" type="hidden" value=""> 
  <tr>      
    <td align="right" class="td18_1" valign="top"> 
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table7">
        <tr>           
                    <td width="30%"><strong>&nbsp;������־����</strong></td>
                    <td>������������<c:out value="${count[0]}" /></td>
                    <td>�ɹ�������<c:out value="${count[1]}" /></td>
                    <td>ʧ��������<c:out value="${count[2]}" /></td>
          <td width="31%" align="right">
		    <table border="0" cellpadding="0" cellspacing="0">
              <tr class="td16"> 
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td width="52">��<a href="javascript:history.back()">����</a>��</td>
              </tr>
            </table>
		  </td>
        </tr>
      </table>
            <table width="100%" border="0">
                <tr class="td19" height="22" > 
		            <td width="10%">����������</td>
                    <td width="15%">����������</td>
                    <td width="20%">��������</td>
                    <td width="30%">��������</td>
                    <td width="10%">�ɹ����</td>
                    <td width="15%">ִ�в���</td>
                </tr>
                <c:forEach var="log" items="${logList}" >
                <tr class="td2">
		            <td>
		            	<c:out value="${log.sender}"/>
		            </td>
                    <td><c:out value="${log.receiver}"/></td>
                    <td><fmt:formatDate value="${log.appenddate}" pattern="yyyy-MM-dd" /></td>
                    <td>
                    	<c:out value="${log.info}"/>
                    </td>
                    <td>
                    	<c:choose>
                    		<c:when test="${log.succeed}">
                    			�ɹ�
                    		</c:when>
                    		<c:otherwise>
                    			ʧ��
                    		</c:otherwise>
                    	</c:choose>
                    </td>
                    <td>
                    	<a href="smslog.do?action=detail&id=<c:out value="${log.id}"/>">��������</a>
                    </td>
                </tr>		
                </c:forEach>		
      </table></td>
  </tr>

  <tr> 
    <td align="left" valign="bottom"> 
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table7">
        <tr> 
             <td width="40%" valign="bottom">
             </td>
		   		<td width="60%" valign="bottom" align="right"> 	
		   			<gOS:page name="test" action="smslog.do?action=smsdetail" pageName="dataPage" pageSizeKey="list">
			            <gOS:param name="startdate"><c:out value="${sForm.startdate}" /></gOS:param>
			            <gOS:param name="enddate"><c:out value="${sForm.enddate}" /></gOS:param>
			            <gOS:param name="sender"><c:out value="${sForm.sender}" /></gOS:param>
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
