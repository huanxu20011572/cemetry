<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ include file="../common/head.jsp"%>
<head>
<title>退墓</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/jscript/uploadify/jquery.uploadify.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jscript/uploadify/upload_cemetery_file.js"></script>
<script type="text/javascript">
function oneself(){
	var is_oneself = $("input[name='is_oneself']:checked").val();
	if(is_oneself == 1){
		 $("#no_oneself").hide();
		 $("#no_oneself2").hide();
		 $("#no_oneself3").hide();
	}
	if(is_oneself == 0){
		$("#no_oneself").show();
		$("#no_oneself2").show();
		$("#no_oneself3").show();
	}
}
</script>
</head>
<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0" height="100%">
  <tr>
    <td width="11" valign="top" class="td-bg"><img src="../images/right-1.jpg" /></td>
    <td align="center" valign="top" >
	    <table width="100%" border="0" cellspacing="0" cellpadding="0">
	      <tr>
	        <td height="31" align="left" valign="middle" style="background:url(../images/right-3.jpg)"><img src="../images/right-4.jpg" width="9" height="8" align="absmiddle" /> 当前位置  &gt; 业务办理  &gt; 租用登记  &gt; 退墓</td>
	      </tr>
	      <tr><td bgcolor="#FFFFFF" style="font-size:12px;">&nbsp;</td></tr>
	    </table>
	  <form id='saveFileForm' action="cemeteryRegistryController.fj?method=backCemeteryRegistry" method='post'>
	  <input name="id" type="hidden" id="id" value="${registry.id}"/>
		<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
		      <tr>
		        <td width="92%" bgcolor="#EBF4FA">
				<table width="200" border="0" cellspacing="0" cellpadding="0">
		          <tr>
		            <td width="20" align="right"><img src="../images/tab-01.jpg" width="8" height="27" /></td>
		            <td width="99" align="center" class="tab-img-01"> 退墓信息 </td>						
		            <td width="81" align="left" valign="bottom"><img src="../images/tab-03.jpg" /></td>
	              </tr>
	            </table>
				</td>
            </tr>
	   </table>
		<table width="98%" cellpadding="0" cellspacing="1" bgcolor="#a6c6da">

        <tr>
          <td width="15%" height="35" align="right" bgcolor="#D4E5F4">承租人本人办理：</td>
          <td  colspan='3'width="35%" align="left" bgcolor="#FFFFFF">
            <input name="is_oneself" type="radio" id="is_oneself"  checked="checked" onClick="javascirpt:oneself()"  value="1" />是
            <input name="is_oneself" type="radio" id="is_oneself"  onClick="javascirpt:oneself()"  value="0" / />否
         </td>
        </tr>
        <tr id="no_oneself">
              <td width="15%"  height="35" align="right" bgcolor="#D4E5F4">代理人姓名： </td>
              <td width="35%" align="left" bgcolor="#FFFFFF">
              <input name="agentName" type="text" id="agentName" class="input-1" />
              </td>
              <td width="15%" height="35" align="right" bgcolor="#D4E5F4">代理人电话：</td>
              <td  width="35%" align="left" bgcolor="#FFFFFF">
                <input name="agentTel" type="text" id="agentTel" class="input-1" />
              </td>
              
            </tr>
            <tr  id="no_oneself2"> 
              <td width="15%"  height="35" align="right" bgcolor="#D4E5F4">代理凭证：</td>
              <td width="35%" align="left" bgcolor="#FFFFFF">
              <input name="agentProve" type="text" id="agentProve" class="input-1" />
              </td>
              <td width="15%" height="35" align="right" bgcolor="#D4E5F4">&nbsp;</td>
              <td width="35%" align="left" bgcolor="#FFFFFF">&nbsp;</td>
              
            </tr>
            <tr  id="no_oneself3">
              <td width="15%"  height="35" align="right" bgcolor="#D4E5F4">代理原因：</td>
              <td height="35" colspan="3" align="left" bgcolor="#FFFFFF">
              <textarea name="agentReason" cols="80" rows="4" ></textarea></td>
            </tr>
			<tr>
			  <td align="right" bgcolor="#D4E5F4">退墓原因：</td>
	          <td height="35" colspan="3" align="left" bgcolor="#FFFFFF"><textarea name="backReason" cols="80" rows="4" ></textarea></td>
            </tr>
	        <tr>
	          <td height="35" align="right" bgcolor="#D4E5F4">退墓金额：</td>
	          <td height="35" colspan="3" align="left" bgcolor="#FFFFFF"><input name="backPrice" type="text" id="backPrice" class="input-1" /></td>
		    </tr>
			<tr>
			  <td align="right" bgcolor="#D4E5F4">业务员：</td>
	          <td align="left" bgcolor="#FFFFFF"><c:out value='${registry.createUserId}' /></td>
	          <td height="35" align="right" bgcolor="#D4E5F4">办理时间：</td>
	          <td align="left" bgcolor="#FFFFFF"><fmt:formatDate value='${registry.createDate}' pattern="yyyy-MM-dd" /></td>         
	        </tr>
	      </table>
          <table>
			<tr>
               <td height="35" >			    
                  <input name="button" type="submit" class="button-z" id="button" value="完成" />&nbsp;&nbsp;
                  <input name="button2" type="button" onclick="javascript:location.href='cemeteryRegistryController.fj?method=getCemeteryRegistryPageList';" class="button-z" id="button2" value="返回" />
               </td>
            </tr>
          </table>
      </form>
  </td>
  </tr>
</table>
<script type="text/javascript">
oneself();
</script>
</body>
</html>