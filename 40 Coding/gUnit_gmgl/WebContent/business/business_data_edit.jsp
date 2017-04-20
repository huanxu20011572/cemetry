<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ include file="../common/head.jsp"%>
<body style="background-color: transparent">
	<form action="businessDataController.fj?method=saveBusinessData" id="isform" method="post">
	<input type="hidden" value="<c:out value='${param.pid}'/>" name="pid" id="pid"/>
	<input type="hidden" value="<c:out value='${businessData.id}'/>" name="id" id="id"/>
	<table width="100%" border="0" cellspacing="0" cellpadding="0" height="100%">
  <tr>
    <td width="11" valign="top" class="td-bg"><img src="../images/right-1.jpg" /></td>
    <td align="center" valign="top" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="31" align="left" valign="middle" style="background:url(../images/right-3.jpg)"><img src="../images/right-4.jpg" width="9" height="8" align="absmiddle" /> 当前位置 &gt; 分类管理</td>
      </tr>
      <tr>
        <td bgcolor="#FFFFFF" style="font-size:12px;">&nbsp;</td>
      </tr>
    </table>
      <table width="98%" cellpadding="0" cellspacing="1" bgcolor="#a6c6da">

        <tr>
          <td width="15%" height="35" align="right" bgcolor="#D4E5F4">业务分类：</td>
          <td width="35%" align="left" bgcolor="#FFFFFF">
          <input name="businessName" type="text" id="businessName" class="input-1"  value="<c:out value='${businessData.businessName}'/>"/>
          <span class="word-7">*</span></td>
          <td width="15%" align="right" bgcolor="#D4E5F4">大分类：</td>
          <td width="35%" align="left" bgcolor="#FFFFFF"><ft:select name="businessType" type="ywdl" selected="${businessData.businessType}" style="width:190px"></ft:select>
          <span class="word-7">*</span></td>
        </tr>
        <tr>
          <td height="35" align="right" bgcolor="#D4E5F4">是否生效：</td>
          <td align="left" bgcolor="#FFFFFF">
          <c:choose>
          <c:when test="${businessData.isValidate==0}">
          <input name="isValidate" type="radio" id="isValidate" value="1"  />是
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <input name="isValidate" type="radio" id="isValidate"  value="0"  checked="checked" />否
          </c:when>
          <c:otherwise>
          <input name="isValidate" type="radio" id="isValidate" value="1" checked="checked"  />是
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <input name="isValidate" type="radio" id="isValidate"  value="0"  />否
          </c:otherwise>
          </c:choose>
          </td>
          <td align="right" bgcolor="#D4E5F4">排序：</td>
          <td align="left" bgcolor="#FFFFFF">
          <input name="sort" type="text" id="sort" class="input-1" value="<c:out value='${businessData.sort}'/>"/></td>
        </tr>
        <tr>
          <td height="35" align="right" bgcolor="#D4E5F4">创建人：</td>
          <td align="left" bgcolor="#FFFFFF">
		      <gOS_shjz:shjzUser key="${businessData.createUserId}"/>
		  </td>
          <td align="right" bgcolor="#D4E5F4">创建日期：</td>
          <td align="left" bgcolor="#FFFFFF">
		    <fmt:formatDate value='${businessData.createDate}' pattern="yyyy-MM-dd"/>
		  </td>
        </tr>
        <tr>
          <td height="75px" align="right" bgcolor="#D4E5F4">备注：</td>
              <td  colspan='3' align="left" bgcolor="#FFFFFF">
                <textarea id="remark" name="remark" class="input-1" style='height:60px;width:90%'><c:out value='${businessData.remark}'/></textarea></td>
            </tr>
      </table>
	  <table width="98%" cellpadding="0" cellspacing="0">
		<tr>
			<td colspan="4" align="center" bgcolor="#FFFFFF">
				&nbsp;
			</td>
		</tr>
		<tr>
			<td colspan="4" align="center" bgcolor="#FFFFFF">
				<input class="button-z" type="button" name="saveBtn" id="saveBtn" value="保存"  onclick="doSave();"/>&nbsp;&nbsp;&nbsp;
        		<input class="button-z" name="backBtn" id="backBtn" type="button" onclick="doBack();" value="返回"/>
			</td>
	    </tr>
	</table>
	</form>
	<script type="text/javascript">
		function doSave(){
			var businessName = $.trim($("#businessName").val());
			if ("" == businessName) {
				alert("业务分类不能为空");
				return;
			}  
			if(businessName.length>20){
				alert("业务分类的最大长度为20个字符");
				return;
			}
			var businessType=$("#businessType").val();
			if("-1"==businessType){
				alert("请选择大分类！");
				return;
			}
			var sort=$.trim($("#sort").val());
			if(sort!=""&&!/^[0-9]+$/g.test(sort)){
				alert("排序值必须为数字");
				return;
			}
			var remark=$.trim($("#remark").val());
			if(remark>=200){
				alert("备注最多可输入200个字符！");
				return
			}
			if(confirm("确定要保存？")){
				isform.action = "businessDataController.fj?method=saveBusinessData";
				$("#isform").submit();
			}
			//isform.submit();
		}
		function doBack(){
			//isform.action = "businessDataController.fj?method=getBusinessDataList";
			//isform.submit();
			JavaScript:history.back();
		}
	</script>
</body>
</html>