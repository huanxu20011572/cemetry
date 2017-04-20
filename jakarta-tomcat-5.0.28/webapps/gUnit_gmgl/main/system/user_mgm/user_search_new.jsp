<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib uri="/WEB-INF/tld/gTaglib-gOS.tld" prefix="gOS" %>
<link href="../../css/css.css" rel="stylesheet" type="text/css">


<script src="../../../script/function.js"></script>
<script src="../../../script/calendar.js"></script>

<body  >
	<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="11" background="../../../images/images_32.jpg"><img src="../../../images/content_left.gif" width="11" height="51"></td>
    <td height="51" background="../../../images/images_32.jpg"><table width="70%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="22" height="16" align="center"><img src="../../../images/d.gif" width="14" height="14"></td>
          <td valign="bottom"> 当前位置：查询用户</td>
      </tr>
    </table>
    </td>
  </tr>
  <tr>
    <td background="../../../images/images_481.jpg">&nbsp;</td>
    <td valign="top">
<span id="_main_Span" style="width:100%;overflow:auto">

<table id="_main_table" width="100%" border="0" cellpadding="0" cellspacing="0" class="table_template">
  <form action="userSearch.do?action=searchresult" name="myform" method="post">
  <tr>        
      <td align="right" valign="top" class="td18_1"> 
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table7">
         <tr height="20">                    
                    <td width="63%" align="left" class="list_title"><strong>&nbsp;用户查询</strong></td>
             <td width="37%" align="right" class="list_title">			 </td>
        </tr>
       </table>
       <table width="100%" border="0" class="table5">
          <tr>     
                    <td class="td8">
                    </td>
          </tr>
       </table>
           <TABLE width="100%" 
        border=0 cellPadding=1 cellSpacing=1 bgcolor="a8d1eb" class=table_main>
                
                <tr height="22">
                    <td width="15%" class="td-01">姓名：</td>
                    <td width="35%" class="td-02"><input name="name" type="text" size="20" height="16" maxlength="20"></td>
                    <td width="15%" class="td-01">性别：</td>
                    <td width="35%" class="td-02">
                        <gOS:select name="gender" selected="${card.gender}">
                        	<gOS:option key="" value="" />
                            <gOS:option key="男" value="男" />
                            <gOS:option key="女" value="女" />
                        </gOS:select>
                    </td>
                </tr>
                <tr height="22">
                    <td class="td-01">所属部门：</td>
                    <td class="td-02"><input name="deptname" type="text" size="30" height="16" maxlength="30"></td>
                    <td class="td-01">学历：</td>
                    <td class="td-02"><input name="xueli" type="text" size="20" height="16"  maxlength="20"></td>
                </tr>
                <tr height="22">
                    <td class="td-01">政治面貌：</td>
                    <td class="td-02"><input name="zhengzhimianmao" type="text" size="30" height="16" maxlength="30"></td>
                    <td class="td-01">民族</td>
                    <td class="td-02"><input name="nation" type="text" size="20" height="16"  maxlength="20"></td>
                </tr>
                <tr height="22">
                    <td class="td-01">职称：</td>
                    <td class="td-02"><input name="zhicheng" type="text" size="30" height="16" maxlength="30"></td>
                    <td class="td-01">职务：</td>
                    <td class="td-02"><input name="zhiwu" type="text" size="20" height="16"  maxlength="20"></td>
                </tr>
                <tr height="22">

                    <td class="td-01">出生日期-从-：</td>
                    <td class="td-02">
                
          					 <input name="startDate" readonly="true" type="text" height="16"  size="16" onClick="calendar()">
				              <input name="button2" type="button" class="input_clean" onClick="javascript:startDate.value='';" value=""/>
		
                    </td>
                    <td class="td-01">-到-</td>
                    <td class="td-02"> 
          				 <input name="endDate" readonly="true" type="text" height="16" size="16" onClick="calendar()">
				           <input name="button2" type="button" class="input_clean" onClick="javascript:endDate.value='';" value=""/>
		
          			</td>
                </tr>
                
                <tr> 
		          <td height="22" class="td-01">家庭居住地址：</td>
		          <td height="22" class="td-02"> <input name="address" type="text" size="20" width="150" height="18" maxlength="30"></td>
		          <td class="td-01">专业：</td>
		          <td class="td-02"><input name="zhuanye" type="text" size="20" width="150" height="18" maxlength="30"> </td>
		        </tr>
                <table border="0" cellpadding="0" cellspacing="0" align="center">
								    <tr class="td-02"> 
								       <td>&nbsp;</td>
								       <td>&nbsp;</td>
								       <td width="52">

								       	<input type="button" value="重置" onClick="javascript:myform.reset();" class="input_btn"/>
								       </td>
								       <td width="52">
								       	<input type="button" value="确定" onClick="javascript:myform.submit();" class="input_btn"/>
								       </td>
								       <td width="52">
								       <input type="button" value="取消" onClick="javascript:history.back();" class="input_btn"/>
								       </td>
								    </tr>
			  </table>
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
</form>
</td>
  </tr>
</table>
</body>
</html>