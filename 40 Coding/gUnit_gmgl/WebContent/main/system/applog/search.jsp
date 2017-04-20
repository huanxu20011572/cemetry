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
  <form action="applog.do?action=searchresult" name="myform" method="post">
  <tr>        
      <td align="right" valign="top" class="td18_1"> 
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table-line">
         <tr height="20">                    
                    <td width="63%" align="left"><strong>&nbsp;日志查询</strong></td>
             <td width="37%" align="right">
			     <table border="0" cellpadding="0" cellspacing="0">
                      <tr class="td16"> 
                         <td>&nbsp;</td>
                         <td>&nbsp;</td>
                         <td width="52">【<a href="javascript:myform.reset();">重置</a>】</td>
                         <td width="52">【<a href="javascript:myform.submit();">确定</a>】</td>
                         <td width="52">【<a href="javascript:history.back();">取消</a>】</td>
                      </tr>
               </table>
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
                    <td class="td22">
                    <c:if test='${issuper=="true"}'>
                    平台名称：
                    </c:if>
                    </td>
                    <td class="td23">
<!--<input name="platformid" type="text" size="30" height="16" maxlength="30">-->
					<c:if test='${issuper=="true"}'>
						<alog:select type="platform" name="platformid"/>
					</c:if>
                    </td>
                    <td class="td22">模块名称：</td>
                    <td class="td23"><input name="modulename" type="text" size="20" height="16"  maxlength="20"></td>
                </tr>
                <tr height="22">
                    <td class="td22">创建者：</td>
                    <td class="td23"><input name="username" type="text" size="30" height="16" maxlength="30"></td>
                    <td class="td22">日志类型</td>
                    <td class="td23">
<!--<input name="operatetype" type="text" size="20" height="16"  maxlength="20">-->
						<alog:select type="operatetype" name="operatetype"/>
					</td>
                </tr>
                
                <tr height="22">

                    <td class="td22">产生日期-从-：</td>
                    <td class="td23">
                    	<script>
          					Calendar('startDate','2004-01-01',1900,2010,null,null,null,'');
          				</script>
                    </td>
                    <td class="td22">-到-</td>
                    <td class="td23">
                    	<script>
          					Calendar('endDate','2010-01-01',1900,2010,null,null,null,'');
          				</script>
          			</td>
                </tr>
                
                <tr height="22">
                    <td class="td22">日志内容：</td>
                    <td class="td23"><input name="info" type="text" size="30" height="16" maxlength="30"></td>
                    <td class="td22"></td>
                    <td class="td23"></td>
                </tr>
                
            </table>
        </td>
  </tr>
  <tr> 
    <td align="left" valign="bottom"> 
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="page">	      
        <tr>
		  <td width="45%" height="16" valign="bottom"> 
          
            
        </td>
          <td width="55%" valign="bottom">  
          
          </td>
        </tr>
      </table></td>
  </tr>
  </form>
</table>
</span>
</body>
</html>