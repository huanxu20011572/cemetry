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
	<input type="hidden" value="<c:out value='${cemeteryType.id}'/>" name="id" id="id"/>
	<table width="100%" border="0" cellspacing="0" cellpadding="0" height="100%" > 
  <tr>
    <td width="11" valign="top" class="td-bg"><img src="../images/right-1.jpg" /></td>
    <td align="center" valign="top" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="31" align="left" valign="middle" style="background:url(../images/right-3.jpg)"><img src="../images/right-4.jpg" width="9" height="8" align="absmiddle" /> 当前位置 &gt; 墓区管理 &gt; 墓型管理 &gt;编辑</td>
      </tr>
      <tr>
        <td bgcolor="#FFFFFF" style="font-size:12px;">&nbsp;</td>
      </tr>
    </table>
	 
      <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td width="92%" bgcolor="#EBF4FA"><table width="200" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td width="20" align="right"><img src="../images/tab-01.jpg" width="8" height="27"/></td>
              <td width="99" align="center" class="tab-img-01"> 业务信息</td>
              <td width="81" align="left" valign="bottom"><img src="../images/tab-03.jpg"/></td>
            </tr>
          </table></td>
        </tr>
      </table>
      <table width="98%" cellpadding="0" cellspacing="1" bgcolor="#a6c6da">
        <tr>
          <td width="15%" height="35" align="right" bgcolor="#D4E5F4">墓型编号：</td>
          <td width="35%" align="left" bgcolor="#FFFFFF">
            <input name="cemeteryTypeCode" type="text" class="input-1" id="cemeteryTypeCode" value="<c:out value='${cemeteryType.cemeteryTypeCode}'/>" /><span class="word-7">*</span></td>
          <td width="15%" rowspan="2"  align="right" bgcolor="#D4E5F4">墓型图片：</td>
          <td width="35%" rowspan="2" align="left" bgcolor="#FFFFFF">
	          <table cellpadding="0" cellspacing="0" border="0"><tr>
	          <td><div id="cemeteryFilePic_td" name="cemeteryFilePic_td" ><img id="cemeteryFilePic" name="cemeteryFilePic" onerror="this.src='${pageContext.request.contextPath}/images/mx-min.jpg'" src="../upload/pic/<c:out value='${cemeteryType.cemeteryFile.filePath}'/>" width="110" height="70" /></div></td>
	          <td><img src="../images/right-ico.jpg" id="cemeteryFile" name="cemeteryFile" />图片大小不能超过2M</td></tr></table>
			  <input type="hidden" id="cemeteryFileId" name="cemeteryFileId" />
          </td>
        </tr>
        <tr>
          <td height="35" align="right" bgcolor="#D4E5F4">业务分类：</td>
          <td align="left" bgcolor="#FFFFFF">
          	<select name="businessDataId" id="businessDataId" style="width:184px;" >
	            <option value="-1">--请选择--</option>
	            <c:forEach  var="en" items="${businessDataList}" varStatus="status">
		            	<c:choose>
				          <c:when test="${cemeteryType.businessData.id==en.id}">
				          	<option value="<c:out value='${en.id}'/>" selected="selected"><c:out value='${en.businessName}'/></option>
				          </c:when>
				          <c:otherwise>
				          	<option value="<c:out value='${en.id}'/>"><c:out value='${en.businessName}'/></option>
				          </c:otherwise>
			            </c:choose>
				</c:forEach>
            </select>
            <span class="word-7">*</span>
            </td>
        </tr>
        <tr>
				<td height="35" align="right" bgcolor="#D4E5F4">墓型名称：</td>
		              <td align="left" bgcolor="#FFFFFF">
					    <input name="cemeteryTypeName" type="text" class="input-1" id="cemeteryTypeName" value="<c:out value='${cemeteryType.cemeteryTypeName}'/>" />
		                <span class="word-7">*</span>
		                </td>
					  <td height="35" align="right" bgcolor="#D4E5F4">墓型类别：</td>
		              <td align="left" bgcolor="#FFFFFF">
		              <ft:select name="cemeteryProperty" type="mxlb" selected="${cemeteryType.cemeteryProperty}" style="width:190px"></ft:select>
		              <span class="word-7">*</span>
		              </td>
	                </tr>
					<tr>
		              <td height="35" align="right" bgcolor="#D4E5F4">墓型规格：</td>
		              <td align="left" bgcolor="#FFFFFF">
	                  <input name="specification" type="text" class="input-1" id="specification" value="<c:out value='${cemeteryType.specification}'/>" />
	                  <span class="word-7">*</span></td>
		              <td align="right" bgcolor="#D4E5F4">面积：</td>
		              <td align="left" bgcolor="#FFFFFF">
		                <input name="area" type="text" class="input-1" id="area" value="<c:out value='${cemeteryType.area}'/>" />
		                <span class="word-7">*</span></td>
	                </tr>
		            <tr>
		              <td height="35" align="right" bgcolor="#D4E5F4">穴别：</td>
		              <td align="left" bgcolor="#FFFFFF">
		                <select name="cave" id="cave" style="width:184px;" >
		                <option value="-1">--请选择--</option>
		                <c:choose>
				          <c:when test="${cemeteryType.cave=='1'}">
				          	<option value="1" selected="selected">单穴</option>
				            <option value="2">双穴</option>
				            <option value="3">多穴</option>
				          </c:when>
				          <c:when test="${cemeteryType.cave=='2'}">
				          	<option value="1">单穴</option>
				            <option value="2" selected="selected">双穴</option>
				            <option value="3">多穴</option>
				          </c:when>
				          <c:when test="${cemeteryType.cave=='3'}">
				          	<option value="1">单穴</option>
				            <option value="2">双穴</option>
				            <option value="3" selected="selected">多穴</option>
				          </c:when>
				          <c:otherwise>
				          	<option value="1">单穴</option>
				            <option value="2">双穴</option>
				            <option value="3">多穴</option>
				          </c:otherwise>
				        </c:choose>
			            </select>
			            <span class="word-7">*</span>
		               </td>
		              <td align="right" bgcolor="#D4E5F4">护盒尺寸：</td>
		              <td align="left" bgcolor="#FFFFFF">
	                  <input name="boxsize" type="text" class="input-1" id="boxsize" value="<c:out value='${cemeteryType.boxsize}'/>" />
	                  <span class="word-7">*</span></td>
	                </tr>
		            <tr>
		              <td height="35" align="right" bgcolor="#D4E5F4">墓型总价格：</td>
		              <td align="left" bgcolor="#FFFFFF">
		                <input name="totalPrice" type="text" readonly="readonly" class="input-1" id="totalPrice" value="<c:out value='${cemeteryType.totalPrice}'/>" />
		                <span class="word-7">*</span></td>
		              <td align="right" bgcolor="#D4E5F4">石料供应商：</td>
		              <td align="left" bgcolor="#FFFFFF">
		                <input name="stoneprovider" type="text" class="input-1" id="stoneprovider" value="<c:out value='${cemeteryType.stoneprovider}'/>" /></td>
        </tr>
        
        <tr>
          <td height="35" align="right" bgcolor="#D4E5F4">登记人：</td>
          <td align="left" bgcolor="#FFFFFF">
          <gOS_shjz:shjzUser key="${cemeteryType.createUserId}"/>
          </td>
          <td align="right" bgcolor="#D4E5F4">登记时间：</td>
          <td align="left" bgcolor="#FFFFFF">
			<fmt:formatDate value='${cemeteryType.createDate}' pattern="yyyy-MM-dd"/>
		  </td>
        </tr>
        <tr>
          <td height="50" align="right" bgcolor="#D4E5F4">墓型说明：</td>
          <td  colspan='3' align="left" bgcolor="#FFFFFF">
            <textarea name="remark" id="remark" class="input-1" style='height:40px;width:90%'><c:out value='${cemeteryType.remark}'/></textarea></td>
        </tr>
      </table>
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td>&nbsp;</td>
        </tr>
      </table>
      <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td width="92%" bgcolor="#EBF4FA"><table width="200" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td width="20" align="right"><img src="../images/tab-01.jpg" width="8" height="27"/></td>
              <td width="99" align="center" class="tab-img-01"> 费用信息</td>
              <td width="81" align="left" valign="bottom"><img src="../images/tab-03.jpg"/></td>
            </tr>
          </table></td>
        </tr>
      </table>
      <table width="98%" cellpadding="0" cellspacing="1" bgcolor="#a6c6da">
        <tr>
          <td width="15%" height="35" align="right" bgcolor="#D4E5F4">土地租赁费：</td>
          <td width="35%" align="left" bgcolor="#FFFFFF">
            <input name="groundPrice" onkeyup="javascript:bulidPrice();"  type="text" class="input-1" id="groundPrice" value="<c:out value='${cemeteryType.groundPrice}'/>" />
            <span class="word-7">*</span></td>
          <td width="15%" align="right" bgcolor="#D4E5F4">管理费：</td>
          <td width="35%" align="left" bgcolor="#FFFFFF">
            <input name="managePrice" onkeyup="javascript:bulidPrice();"  type="text" class="input-1" id="managePrice" value="<c:out value='${cemeteryType.managePrice}'/>" />
            <span class="word-7">*</span></td>
        </tr>
        <tr>
          <td height="35" align="right" bgcolor="#D4E5F4">工程费：</td>
          <td align="left" bgcolor="#FFFFFF"  colspan='3' >
            <input name="constructionPrice" onkeyup="javascript:bulidPrice();"  type="text" class="input-1" id="constructionPrice" value="<c:out value='${cemeteryType.constructionPrice}'/>" />
            <span class="word-7">*</span></td>
        </tr>
       
      </table>
      <table width="98%" cellpadding="0" cellspacing="0">
        <tr>
			<td colspan="4" align="center" bgcolor="#FFFFFF">&nbsp;
				
			</td>
	    </tr>
        <tr>
			<td colspan="4" align="center" bgcolor="#FFFFFF">
				<input class="button-z" type="button" name="saveBtn" id="saveBtn" value="保存"  onclick="doSave();"/>&nbsp;&nbsp;&nbsp;
        		<input class="button-z" name="backBtn" id="backBtn" type="button" onclick="doBack();" value="返回"/>
			</td>
	    </tr>
      </table></td>
  </tr>
</table>
	</form>
	<script type="text/javascript">
		function doSave(){
			var cemeteryTypeCode = $.trim($("#cemeteryTypeCode").val());
			if ("" == cemeteryTypeCode) {
				alert("墓型编号不能为空");
				return;
			}  
			if(cemeteryTypeCode.length>20){
				alert("墓型编号的最大长度为20个字符");
				return;
			}
			var businessDataId=$("#businessDataId").val();
			if("-1"==businessDataId){
				alert("请选择业务分类！");
				return;
			}
			var cemeteryTypeName = $.trim($("#cemeteryTypeName").val());
			if ("" == cemeteryTypeName) {
				alert("墓型名称不能为空！");
				return;
			}
			if(cemeteryTypeName.length>20){
			    alert("墓型名称的最大长度为20个字符");
				return;
			}
			var cemeteryProperty = $.trim($("#cemeteryProperty").val());
			if ("-1" == cemeteryProperty) {
				alert("请选择墓型类别！");
				return;
			}
 			var specification = $.trim($("#specification").val());
			if(specification.length<=0){
			    alert("墓型规格为空");
				return;
			}
			if(specification.length>20){
			    alert("墓型规格的最大长度为20个字符");
				return;
			}
			var area=$.trim($("#area").val());
			if(area.length<=0){
				alert("面积为空");
				return;
			}
			var patrn=/^(([1-9]{1}\d*)|([0]{1}))(\.(\d){1,2})?$/;
			if(area!=""&&!patrn.exec(area)){
				alert("面积只能为数值");
				return;
			}
			var cave=$("#cave").val();
			if("-1"==cave){
				alert("请选择穴别！");
				return;
			}
 			var boxsize = $.trim($("#boxsize").val());
			if(boxsize.length<=0){
			    alert("护盒尺寸为空");
				return;
			}
			if(boxsize.length>50){
			    alert("护盒尺寸的最大长度为50个字符");
				return;
			}
			var totalPrice=$.trim($("#totalPrice").val());
			if(totalPrice.length<=0){
				alert("墓型总价格为空");
				return;
			}
			var patrn=/^(([1-9]{1}\d*)|([0]{1}))(\.(\d){1,2})?$/;
			if(totalPrice!=""&&!patrn.exec(totalPrice)){
				alert("墓型总价格只能为货币");
				return;
			}
 			var stoneprovider = $.trim($("#stoneprovider").val());
			if(stoneprovider.length>200){
			    alert("石料供应商的最大长度为200个字符");
				return;
			}
			var groundPrice =$.trim($("#groundPrice").val());
			if(groundPrice.length<=0){
				alert("土地租赁费为空");
				return;
			}
			var patrn=/^(([1-9]{1}\d*)|([0]{1}))(\.(\d){1,2})?$/;
			if(groundPrice!=""&&!patrn.exec(groundPrice)){
				alert("土地租赁费只能为货币");
				return;
			}
			var managePrice=$.trim($("#managePrice").val());
			if(managePrice.length<=0){
				alert("管理费为空");
				return;
			}
			var patrn=/^(([1-9]{1}\d*)|([0]{1}))(\.(\d){1,2})?$/;
			if(managePrice!=""&&!patrn.exec(managePrice)){
				alert("管理费只能为货币");
				return;
			}
			var constructionPrice=$.trim($("#constructionPrice").val());
			if(constructionPrice.length<=0){
				alert("工程费为空");
				return;
			}
			var patrn=/^(([1-9]{1}\d*)|([0]{1}))(\.(\d){1,2})?$/;
			if(constructionPrice!=""&&!patrn.exec(constructionPrice)){
				alert("工程费只能为货币");
				return;
			}
			var remark=$.trim($("#remark").val());
			if(remark.length>200){
			    alert("墓型说明的最大长度为200个字符");
				return;
			}
			if(confirm("确定要保存？")){
				isform.action = "cemeteryTypeController.fj?method=saveCemeteryType";
				$("#isform").submit();
			}
		}
		function doBack(){
			//isform.action = "cemeteryTypeController.fj?method=getCemeteryTypeList";
			//isform.submit();
			JavaScript:history.back();
		}
		function bulidPrice(){
			//墓位价格=工程费+土地租赁费+管理费
			$("#totalPrice").val(parseFloat($("#groundPrice").val())+parseFloat($("#constructionPrice").val())+parseFloat($("#managePrice").val()));
			if(isNaN(parseFloat($("#totalPrice").val()))){
				$("#totalPrice").val(0);
			}
	   }
	</script>
</body>
</html>