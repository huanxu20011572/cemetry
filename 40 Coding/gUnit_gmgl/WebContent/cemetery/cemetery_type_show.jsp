<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ include file="../common/head.jsp"%>
<body style="background-color: transparent">
<form action="cemeteryTypeController.fj?method=getCemeteryTypeList" id="backForm" method="post">
	<table width="100%" border="0" cellspacing="0" cellpadding="0" height="100%" > 
  <tr>
    <td width="11" valign="top" class="td-bg"><img src="../images/right-1.jpg" /></td>
    <td align="center" valign="top" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="31" align="left" valign="middle" style="background:url(../images/right-3.jpg)"><img src="../images/right-4.jpg" width="9" height="8" align="absmiddle" /> 当前位置 &gt; 墓区管理 &gt; 墓型管理 &gt;查看</td>
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
            <c:out value='${cemeteryType.cemeteryTypeCode}'/></td>
          <td width="15%" rowspan="2" align="right" bgcolor="#D4E5F4">墓型图片：</td>
          <td width="35%" rowspan="2" align="left" bgcolor="#FFFFFF"><img onerror="this.src='${pageContext.request.contextPath}/images/mx-min.jpg'" src="../upload/pic/<c:out value='${cemeteryType.cemeteryFile.filePath}'/>" width="110" height="70" />
          	
          </td>
        </tr>
        <tr>
          <td height="35" align="right" bgcolor="#D4E5F4">业务分类：</td>
          <td align="left" bgcolor="#FFFFFF">
            <c:out value='${cemeteryType.businessData.businessName}'/></td>
        </tr>
        <tr>
				<td height="35" align="right" bgcolor="#D4E5F4">墓型名称：</td>
		              <td align="left" bgcolor="#FFFFFF">
					    <c:out value='${cemeteryType.cemeteryTypeName}'/>
		                </td>
					  <td height="35" align="right" bgcolor="#D4E5F4">墓型类别：</td>
		              <td align="left" bgcolor="#FFFFFF">
		              <ft:dict value='${cemeteryType.cemeteryProperty}'/>
		              </td>
	                </tr>
					<tr>
		              <td height="35" align="right" bgcolor="#D4E5F4">墓型规格：</td>
		              <td align="left" bgcolor="#FFFFFF">
	                  <c:out value='${cemeteryType.specification}'/></td>
		              <td align="right" bgcolor="#D4E5F4">面积：</td>
		              <td align="left" bgcolor="#FFFFFF">
		                <c:out value='${cemeteryType.area}'/></td>
	                </tr>
		            <tr>
		              <td height="35" align="right" bgcolor="#D4E5F4">穴别：</td>
		              <td align="left" bgcolor="#FFFFFF">
		                <c:choose>
				          <c:when test="${cemeteryType.cave=='1'}">单穴</c:when>
				          <c:when test="${cemeteryType.cave=='2'}">双穴</c:when>
				          <c:when test="${cemeteryType.cave=='3'}">多穴</c:when>
						</c:choose>
		              </td>
		              <td align="right" bgcolor="#D4E5F4">护盒尺寸：</td>
		              <td align="left" bgcolor="#FFFFFF">
	                  <c:out value='${cemeteryType.boxsize}'/></td>
	                </tr>
		            <tr>
		              <td height="35" align="right" bgcolor="#D4E5F4">墓型总价格：</td>
		              <td align="left" bgcolor="#FFFFFF">
		                <c:out value='${cemeteryType.totalPrice}'/></td>
		              <td align="right" bgcolor="#D4E5F4">石料供应商：</td>
		              <td align="left" bgcolor="#FFFFFF">
		                <c:out value='${cemeteryType.stoneprovider}'/></td>
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
            <c:out value='${cemeteryType.remark}'/></td>
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
            <c:out value='${cemeteryType.groundPrice}'/></td>
          <td width="15%" align="right" bgcolor="#D4E5F4">管理费：</td>
          <td width="35%" align="left" bgcolor="#FFFFFF">
            <c:out value='${cemeteryType.managePrice}'/></td>
        </tr>
        <tr>
          <td height="35" align="right" bgcolor="#D4E5F4">工程费：</td>
          <td align="left" bgcolor="#FFFFFF"  colspan='3' >
            <c:out value='${cemeteryType.constructionPrice}'/></td>
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
				<input name="button3" type="submit" class="button-z" id="button3" value="返回" />
			</td>
	    </tr>
      </table>
	</form>
      </td>
  </tr>
</table>
</body>
</html>