<%@ page contentType="text/html; charset=GBK" %>
<%@ page import="com.topsuntech.gOS.config.user.mpfl.dao.MpflFactory" %>
<%@ page import="java.util.Collection" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib uri="/WEB-INF/tld/gTaglib-gOS.tld" prefix="gOS" %>



<body scroll="no" onload="f_resize_main_span()" onresize="f_resize_main_span()">
<span id="_main_Span" style="width:100%;overflow:auto">
<table border="0" cellpadding="0" id="_main_table" cellspacing="0" align="right" class="table_template">
  <form action="cardAdd.do?action=add" name="myform" method="post">
  <tr>        
      <td align="right" valign="top" class="td18_1"> 
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table7">
         <tr height="20">                    
                    <td width="63%" align="left"><strong>&nbsp;�û���ѯ</strong></td>
             <td width="37%" align="right">
			     <table border="0" cellpadding="0" cellspacing="0">
                      <tr class="td16"> 
                         <td>&nbsp;</td>
                         <td>&nbsp;</td>
                         <td width="52">��<a href="javascript:myform.reset();">����</a>��</td>
                         <td width="52">��<a href="javascript:onSubmit();">ȷ��</a>��</td>
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
                    <td width="15%" class="td22">������</td>
                    <td width="35%" class="td23"><input name="name" type="text" size="20" height="16" value=""/>" maxlength="20"></td>
                    <td width="15%" class="td22">�Ա�</td>
                    <td width="35%" class="td23">
                        <gOS:select name="gender" selected="${card.gender}">
                        	<gOS:option key="" value="" />
                            <gOS:option key="��" value="��" />
                            <gOS:option key="Ů" value="Ů" />
                        </gOS:select>
                    </td>
                </tr>
                <tr height="22">
                    <td class="td22">�������ţ�</td>
                    <td class="td23"><input name="deptname" type="text" size="30" height="16" maxlength="30"></td>
                    <td class="td22">ѧ����</td>
                    <td class="td23"><input name="xueli" type="text" size="20" height="16"  maxlength="20"></td>
                </tr>
                <tr height="22">
                    <td class="td22">������ò��</td>
                    <td class="td23"><input name="zhengzhimianmao" type="text" size="30" height="16" maxlength="30"></td>
                    <td class="td22">����</td>
                    <td class="td23"><input name="nation" type="text" size="20" height="16"  maxlength="20"></td>
                </tr>
                <tr height="22">
                    <td class="td22">ְ�ƣ�</td>
                    <td class="td23"><input name="zhicheng" type="text" size="30" height="16" maxlength="30"></td>
                    <td class="td22">ְ��</td>
                    <td class="td23"><input name="zhiwu" type="text" size="20" height="16"  maxlength="20"></td>
                </tr>
                <tr height="22">
                    <td class="td22">��������-��-��</td>
                    <td class="td23">
                    	<script>
          					Calendar('startDate','<fmt:formatDate value="1900-01-01" pattern="yyyy-MM-dd" />',1900,2000,null,null,null);
          				</script>
                    </td>
                    <td class="td22">-��-</td>
                    <td class="td23">
                    	<script>
          					Calendar('endDate','<fmt:formatDate value="2000-01-01" pattern="yyyy-MM-dd" />',1900,2000,null,null,null);
          				</script>
          			</td>
                </tr>
                
                <tr> 
		          <td height="22" class="td22">��ͥ��ס��ַ��</td>
		          <td height="22" class="td23"> <input name="address" type="text" size="20" width="150" height="18" maxlength="30"></td>
		          <td class="td22"></td>
		          <td class="td23"> </td>
		        </tr>
                
            </table>
        </td>
  </tr>
</table>
</span>
</body>
</html>