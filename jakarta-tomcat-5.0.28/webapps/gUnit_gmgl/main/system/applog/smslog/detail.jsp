<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib uri="/WEB-INF/tld/gTaglib-gOS.tld" prefix="gOS" %>
<%@ taglib uri="/WEB-INF/tld/gOS-applog.tld" prefix="alog" %>


<gOS:skin />
<script src="../../../script/function.js"></script>
<script src="../../../script/calendar.js"></script>
<!-- Link Tigra Hints script file to your HTML document-->
<script language="JavaScript" src="/lib/hints.js"></script>
<!-- Link Tigra Hints configuration file to your HTML document-->
<script language="JavaScript" src="/lib/hints_cfg.js"></script>

<body scroll="no" onload="f_resize_main_span()" onresize="f_resize_main_span()">
<span id="_main_Span" style="width:100%;overflow:auto">
<table id="_main_table" width="100%" border="0" cellpadding="0" cellspacing="0" class="table_template">
  <tr>        
      <td align="right" valign="top" class="td18_1"> 
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table7">
         <tr height="20">                    
                    <td width="63%" align="left"><strong>&nbsp;短信日志详细信息</strong></td>
             <td width="37%" align="right">
             <a href="javascript:history.back();">【返回】</a>
			 </td>
          </tr>
       </table>
       <table width="100%" border="0" class="table5">
          <tr>     
                    <td class="td8">
                    </td>
          </tr>
       </table>
            <table width="100%" border="0" cellpadding="1" cellspacing="1"  class="table_main">
                
                <tr height="22">
                    <td class="td22" width="20%">发送者姓名：</td>
                    <td class="td23" width="30%">
                    	<c:out value="${log.sender}"/>
                    </td>
                    <td class="td22" width="20%">接收人姓名：</td>
                    <td class="td23"  width="30%"><c:out value="${log.receiver}"/></td>
                </tr>
                <tr height="22">
                    <td class="td22">发送日期：</td>
                    <td class="td23"><fmt:formatDate value="${log.appenddate}" pattern="yyyy-MM-dd" /></td>
                    <td class="td22">短信内容:</td>
                    <td class="td23">
                    	<c:out value="${log.info}"/>
                    </td>
                </tr>
                
                <tr height="22">
                    <td class="td22">成功与否：</td>
                    <td class="td23">
                    	<c:choose>
                    		<c:when test="${log.succeed}">
                    			成功
                    		</c:when>
                    		<c:otherwise>
                    			失败
                    		</c:otherwise>
                    	</c:choose>
                    </td>
                    <td class="td22"></td>
                    <td class="td23">
          			</td>
                </tr>
                
            </table>
        </td>
  </tr>
  <tr> 
    <td align="left" valign="bottom"> 
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table7">	      
        <tr>
		  <td width="45%" height="16" valign="bottom"> 
          
            
        </td>
          <td width="55%" valign="bottom">  
          
          </td>
        </tr>
      </table></td>
  </tr>
</table>
</span>
</body>
</html>