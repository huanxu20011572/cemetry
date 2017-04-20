<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ include file="../common/head.jsp"%>
<head>
<title>上传文件</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/jscript/uploadify/jquery.uploadify.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jscript/uploadify/upload_archives_cemetery_file.js"></script>
<script type="text/javascript">
	function doBack(){
		var redirect_url = $.base64.decode('${param.redirect_url}');
		location.href=redirect_url;
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
	        <td height="31" align="left" valign="middle" style="background:url(../images/right-3.jpg)"><img src="../images/right-4.jpg" width="9" height="8" align="absmiddle" /> 当前位置  &gt; 文件上传</td>
	      </tr>
	      <tr><td bgcolor="#FFFFFF" style="font-size:12px;">&nbsp;</td></tr>
	    </table>
	  <form id='saveFileForm' action="archivesCemeteryRegistryController.fj?method=saveCemeteryFile" method='post'>
	      <input type='hidden' name='cemeteryRegistryType' value="<c:out value='${param.cemeteryRegistryType}'/>"/>
	      <input  type="hidden" id="isSupply"  name="isSupply" value="<c:out value='${param.isSupply}'/>"></input>
		  <input  type="hidden" id="cemeteryRegistryId"  name="cemeteryRegistryId" value="<c:out value='${param.id}'/>"></input>
		  <input  type="hidden" id="fileId"  name="fileId"></input>
	      <table width="98%" cellpadding="0" cellspacing="1" bgcolor="#a6c6da">
	        <tr>
		      <td width="20%" height='35' align='right' bgColor='#d4e5f4'>文件名称：</td>
		      <td bgColor='#ffffff'><span id="filename"></span></td>
		      <td colspan="2" align='left' bgColor='#ffffff'><table><tr><td><input type="button" id="archivesCemeteryFile" name="archivesCemeteryFile" class="button-z" value="上传" /></td></tr></table></td>
		      </tr>
	        <tr>
		      <td width="20%" height='35' align='right' bgColor='#d4e5f4'>文件描述：</td>
		      <td colspan="3" align='left' bgColor='#ffffff'><textarea   name='remark' cols="50" rows="4" id='remark' ></textarea></td>
	        </tr>
	        <tr>
		      <td bgColor='#d4e5f4' height='35' align='right'>登记人：</td>
		      <td width="30%" align='left' bgColor='#ffffff'><gOS_shjz:shjzUser key="${cemeteryFile.createUserId}"/> </td>
		      <td width="18%" align='right' bgColor='#d4e5f4' >登记日期：</td>
		      <td width="32%" align='left' bgColor='#ffffff' ><fmt:formatDate value='${cemeteryFile.createDate}' pattern="yyyy-MM-dd"/></td>
		    </tr>
		 </table>
      <table>
        	<td height="35"></td>
	          <td>
	            <input name="saveCemeteryFileBtn" type="submit" class="button-z" id="button" value="完成" />
	            &nbsp;&nbsp;
	            <input name="button2" type="button" onclick="javascirpt:doBack();" class="button-z" id="button2" value="返回" />
	          </td>
	        </tr>
      </table>
     </form>
  </td>
  </tr>
</table>
</body>
</html>