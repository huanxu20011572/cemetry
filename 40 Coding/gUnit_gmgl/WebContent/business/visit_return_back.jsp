<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ include file="../common/head.jsp"%>
<body style="background-color: transparent">
	<form action="" id="isform" method="post">
	<input type="hidden" value="<c:out value='${visitReturn.id}'/>" name="id" id="id"/>
	<table width="100%" border="0" cellspacing="0" cellpadding="0" height="100%">
  <tr>
    <td width="11" valign="top" class="td-bg"><img src="../images/right-1.jpg" /></td>
    <td align="center" valign="top" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="31" align="left" valign="middle" style="background:url(../images/right-3.jpg)"><img src="../images/right-4.jpg" width="9" height="8" align="absmiddle" /> 当前位置 &gt; 售前管理  &gt; 来访登记  &gt; 回访  </td>
      </tr>
      <tr>
        <td bgcolor="#FFFFFF" style="font-size:12px;">&nbsp;</td>
      </tr>
    </table>
      <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
		        <tr>
		          <td width="91%" bgcolor="#EBF4FA"><table width="200" border="0" cellspacing="0" cellpadding="0">
		            <tr>
		              <td width="20" align="right"><img src="../images/tab-01.jpg" width="8" height="27" /></td>
		              <td width="99" align="center" class="tab-img-01">登记信息 </td>
		              <td width="81" align="left" valign="bottom"><img src="../images/tab-03.jpg" /></td>
	                </tr>
	              </table></td>
		          <td width="9%" align="center" bgcolor="#EBF4FA">&nbsp;</td>
	            </tr>
	          </table>
      <table width="98%" cellpadding="0" cellspacing="1" bgcolor="#a6c6da">

        <tr>
          <td width="15%" height="35" align="right" bgcolor="#D4E5F4">客户姓名：</td>
          <td width="35%" align="left" bgcolor="#FFFFFF">
          <c:out value='${visitReturn.customerName}'/></td>
          <td width="15%" align="right" bgcolor="#D4E5F4">联系电话：</td>
          <td width="35%" align="left" bgcolor="#FFFFFF">
          <c:out value='${visitReturn.customerTel}'/></td>
        </tr>
        <tr>
          <td width="15%" height="35" align="right" bgcolor="#D4E5F4">客户来源：</td>
          <td width="35%" align="left" bgcolor="#FFFFFF">
          <c:out value='${visitReturn.customerSource}'/></td>
          <td width="15%" align="right" bgcolor="#D4E5F4">来访人数：</td>
          <td width="35%" align="left" bgcolor="#FFFFFF">
          <c:out value='${visitReturn.customerNum}'/></td>
        </tr>
        <tr>
          <td height="75px" align="right" bgcolor="#D4E5F4">来访需求：</td>
          <td  colspan='3' align="left" bgcolor="#FFFFFF">
            <c:out value='${visitReturn.customerReq}'/></td>
        </tr>
        <tr>
          <td height="35" align="right" bgcolor="#D4E5F4">登记人：</td>
          <td align="left" bgcolor="#FFFFFF">
		      <gOS_shjz:shjzUser key="${visitReturn.createUserId}"/>
		  </td>
          <td align="right" bgcolor="#D4E5F4">登记时间：</td>
          <td align="left" bgcolor="#FFFFFF">
		    <fmt:formatDate value='${visitReturn.createDate}' pattern="yyyy-MM-dd"/>
		  </td>
        </tr>
        <tr>
          <td height="75px" align="right" bgcolor="#D4E5F4">备注：</td>
          <td  colspan='3' align="left" bgcolor="#FFFFFF">
            <c:out value='${visitReturn.remark}'/></td>
        </tr>
      </table>
      <br />
      <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
		        <tr>
		          <td width="91%" bgcolor="#EBF4FA"><table width="200" border="0" cellspacing="0" cellpadding="0">
		            <tr>
		              <td width="20" align="right"><img src="../images/tab-01.jpg" width="8" height="27" /></td>
		              <td width="99" align="center" class="tab-img-01">回访信息 </td>
		              <td width="81" align="left" valign="bottom"><img src="../images/tab-03.jpg" /></td>
	                </tr>
	              </table></td>
		          <td width="9%" align="center" bgcolor="#EBF4FA">&nbsp;</td>
	            </tr>
	          </table>
      <table width="98%" cellpadding="0" cellspacing="1" bgcolor="#a6c6da">

        <tr>
          <td width="15%" height="35" align="right" bgcolor="#D4E5F4">回访情况：</td>
          <td height="50px" colspan='3' align="left" bgcolor="#FFFFFF">
                <textarea id="returnRemark" name="returnRemark" class="input-1" style='height:60px;width:90%'><c:out value='${visitReturn.returnRemark}'/></textarea><span class="word-7">*</span></td>
        </tr>
        <tr>
          <td width="15%" height="35" align="right" bgcolor="#D4E5F4">登记人：</td>
          <td width="35%"  align="left" bgcolor="#FFFFFF">
          <gOS_shjz:shjzUser key="${visitReturn.returnUserId}"/>
          </td>
          <td width="15%" align="right" bgcolor="#D4E5F4">登记时间：</td>
          <td width="35%" align="left" bgcolor="#FFFFFF"><fmt:formatDate value='${visitReturn.returnDate}' pattern="yyyy-MM-dd"/></td>
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
	</td>
  </tr>
</table>
	
	</form>
	<script type="text/javascript">
		function doSave(){
			var returnRemark = $.trim($("#returnRemark").val());
			if ("" == returnRemark) {
				alert("回访情况不能为空！");
				return;
			}  
			if(returnRemark.length>300){
				alert("回访情况的最大长度为300个字符！");
				return;
			}
			if(confirm("确定要保存？")){
				isform.action = "visitReturnController.fj?method=saveVisitReturnBack";
				$("#isform").submit();
			}
		}
		function doBack(){
			JavaScript:history.back();
		}
	</script>
</body>
</html>