<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ include file="../common/head.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/jscript/uploadify/jquery.uploadify.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jscript/uploadify/upload_cemetery_pic.js"></script>
<script>
</script>
<body style="background-color: transparent">
	<form action="" id="isform" method="post" >
	<input type="hidden" value="<c:out value='${cemeteryCertificate.id}'/>" name="id" id="id"/>
	<input type="hidden" value="<c:out value='${cemeteryCertificate.archivesCemeteryRegistryId}'/>" name="archivesCemeteryRegistryId" id="archivesCemeteryRegistryId"/>
	<table width="100%" border="0" cellspacing="0" cellpadding="0" height="100%" > 
  <tr>
    <td width="11" valign="top" class="td-bg"><img src="../images/right-1.jpg" /></td>
    <td align="center" valign="top" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="31" align="left" valign="middle" style="background:url(../images/right-3.jpg)"><img src="../images/right-4.jpg" width="9" height="8" align="absmiddle" /> 当前位置 &gt; 售后管理 &gt; 补证登记 </td>
      </tr>
      <tr>
        <td bgcolor="#FFFFFF" style="font-size:12px;">&nbsp;</td>
      </tr>
    </table>
	<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
    <td width="92%" bgcolor="#EBF4FA"><table border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td><table border="0" cellspacing="0" cellpadding="0" >
          <tr>
            <td width="20" align="right"><img src="../images/tab-01.jpg" width="8" height="27" /></td>
            <td width="99" align="center" class="tab-img-01" id="new_label">补证信息</td>
            <td width="10" align="left" valign="bottom"><img src="../images/tab-03.jpg" /></td>
          </tr>
        </table></td>
       
      </tr>
    </table></td>
  </tr>
</table>
      <table width="98%" cellpadding="0" cellspacing="1" bgcolor="#a6c6da">
	  
       <tr>
          <td width="15%" height="35" align="right" bgcolor="#D4E5F4">补证费用：</td>
          <td align="left" bgcolor="#FFFFFF" colspan='3'>
              <input name="charge" type="text" id="charge" class="input-1" 
              value="<c:out value='${cemeteryCertificate.charge}'/>"/>
              <span class="word-7">*</span>
		 </td>
		         
        </tr>
		 
		<tr>
		  <td width="15%" height="35" align="right" bgcolor="#D4E5F4">补证原因：</td>
          <td align="left" bgcolor="#FFFFFF" colspan='3'  >
			   <select name="reason" id="reason" style="width:184px;" >
		                <option value="-1">--请选择--</option>
		                <c:choose>
				          <c:when test="${cemeteryCertificate.reason=='1'}">
				          	<option value="1" selected="selected">证件丢失</option>
				            <option value="2">证件破损</option>
				            <option value="3">信息变更</option>
				            <option value="4">其他</option>
				          </c:when>
				          <c:when test="${cemeteryCertificate.reason=='2'}">
				          	<option value="1">证件丢失</option>
				            <option value="2" selected="selected">证件破损</option>
				            <option value="3">信息变更</option>
				            <option value="4">其他</option>
				          </c:when>
				          <c:when test="${cemeteryCertificate.reason=='3'}">
				          	<option value="1">证件丢失</option>
				            <option value="2">证件破损</option>
				            <option value="3" selected="selected">信息变更</option>
				            <option value="4">其他</option>
				          </c:when>
				          <c:when test="${cemeteryCertificate.reason=='4'}">
				          	<option value="1">证件丢失</option>
				            <option value="2">证件破损</option>
				            <option value="3">信息变更</option>
				            <option value="4" selected="selected">其他</option>
				          </c:when>
				          <c:otherwise>
				          	<option value="1">证件丢失</option>
				            <option value="2">证件破损</option>
				            <option value="3">信息变更</option>
				            <option value="4">其他</option>
				          </c:otherwise>
				        </c:choose>
			            </select><span class="word-7">*</span>
		  </td>
        </tr> 
    <tr>
      <td width="15%" bgColor='#d4e5f4' height='35' align='right'>备注：</td>
      <td colspan='3' bgColor='#ffffff' align='left'>
         <textarea name="remark" style='height:60px;width:50%' id="remark" ><c:out value='${cemeteryCertificate.remark}'/></textarea> 
     </td>     
    </tr>
     <tr>
		  <td width="15%" align="right" bgcolor="#D4E5F4">业务员：</td>
          <td width="35%" align="left" bgcolor="#FFFFFF">
              <gOS_shjz:shjzUser key="${cemeteryCertificate.createUserId}"/>
		  </td>
          <td width="15%" height="35" align="right" bgcolor="#D4E5F4">登记时间：</td>
          <td width="35%" align="left" bgcolor="#FFFFFF">
            <fmt:formatDate value='${cemeteryCertificate.createDate}' pattern="yyyy-MM-dd"/>
		  </td>         
        </tr>
      
      </table>
<table>
                  <td width="80" height="35" align="middle" >
			      	<input name="saveBtn" type="button" class="button-z" id="saveBtn" value="完成"  onclick="doSave();"/> 
				  </td>
				  <td width="80" height="35"  align="middle" >
					<input class="button-z" name="backBtn" id="backBtn" type="button" onclick="doBack();" value="返回" />
				  </td>
      </table>
    </td>
  </tr>
</table>
	</form>
	<script type="text/javascript">
		function doSave(){
			var charge=$.trim($("#charge").val());
			if (charge.length<=0 || charge=='') {
				alert("请填写补证费用");
				return;
			}
			var patrn=/^(([1-9]{1}\d*)|([0]{1}))(\.(\d){1,2})?$/;
			if(!patrn.exec(charge)){
				alert("补证费用只能为货币");
				return;
			}
			var reason = $.trim($("#reason").val());
			if ("-1" == reason) {
				alert("请选择补证原因！");
				return;
			}
			if(confirm("确定要保存？")){
				isform.action = "cemeteryCertificateController.fj?method=saveCemeteryCertificate";
				//isform.submit();
				$("#isform").submit();
			} 
		}
		function doBack(){
			JavaScript:history.back();
		}
	</script>
</body>
</html>