<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib uri="/WEB-INF/tld/gTaglib-gOS.tld" prefix="gOS" %>
<%@ taglib uri="/WEB-INF/tld/gOS-applog.tld" prefix="alog" %>


<gOS:skin />
<script src="../../../script/function.js"></script>
<script src="../../../script/calendar.js"></script>

<body scroll="no" onload="f_resize_main_span()" onresize="f_resize_main_span()">
<span id="_main_Span" style="width:100%;overflow:auto">
<table id="_main_table" width="100%" border="0" cellpadding="0" cellspacing="0" class="table_template">
  <form action="smslog.do?action=searchresult" name="myform" method="post">
  <tr>        
      <td align="right" valign="top" class="td18_1"> 
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table7">
         <tr height="20">                    
                    <td width="63%" align="left"><strong>&nbsp;������־��ѯ</strong></td>
             <td width="37%" align="right">
			     <table border="0" cellpadding="0" cellspacing="0">
                      <tr class="td16"> 
                         <td>&nbsp;</td>
                         <td>&nbsp;</td>
                         <td width="52">��<a href="javascript:myform.reset();">����</a>��</td>
                         <td width="52">��<a href="javascript:myform.submit();">ȷ��</a>��</td>
                         <td width="52">��<a href="javascript:history.back();">ȡ��</a>��</td>
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

                    <td class="td22">��������-��-��</td>
                    <td class="td23">
                    	<script>
          					Calendar('startdate','2004-06-01',1960,2010,null,null,null);
          				</script>
                    </td>
                    <td class="td22">-��-</td>
                    <td class="td23">
                    	<script>
          					Calendar('enddate','',2004,2010,null,null,null);
          				</script>
          			</td>
                </tr>
                
                <tr height="22">
                    <td class="td22">��������������</td>
                    <td class="td23">
                    <select name="ordertype">
                    	<option value="-1">������</option>
                    	<option value="1">����</option>
                    	<option value="0">����</option>
                    </select>
                    </td>
                    <td class="td22">��ѯ��ʽ��</td>
                    <td class="td23">
						<input type="radio" name="querytype" value="0" checked>�����û�
						<input type="radio" name="querytype" value="1">������&nbsp;
						<input type="text" name="sender">
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
  </form>
</table>
</span>
</body>
</html>