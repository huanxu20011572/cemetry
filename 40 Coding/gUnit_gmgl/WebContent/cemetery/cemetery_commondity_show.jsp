<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ include file="../common/head.jsp"%>
<body style="background-color: transparent">
	<table width="100%" border="0" cellspacing="0" cellpadding="0" height="100%">
	  <tr>
	    <td width="11" valign="top" class="td-bg"><img src="../images/right-1.jpg" /></td>
	    <td align="center" valign="top" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
	      <tr>
	        <td height="31" align="left" valign="middle" style="background:url(../images/right-3.jpg)"><img src="../images/right-4.jpg" width="9" height="8" align="absmiddle" /> 当前位置 &gt;商品管理&gt;查看商品</td>
	      </tr>
	      <tr>
	        <td bgcolor="#FFFFFF" style="font-size:12px;">&nbsp;</td>
	      </tr>
    </table>
	 
    <table width="98%" cellpadding="0" cellspacing="1" bgcolor="#a6c6da">
		<tr>
          <td width="138" height="35" align="right" bgcolor="#D4E5F4">商品名称：</td>
          <td width="280" align="left" bgcolor="#FFFFFF">
              <c:out value='${cemeteryCommodity.commodityName}'/>
		 </td>
		  <td width="124" height="35" align="right" bgcolor="#D4E5F4">商品类别：</td>
          <td width="301" align="left" bgcolor="#FFFFFF">
            <ft:dict value='${cemeteryCommodity.commodityType}'/>
		  </td>      
        </tr>
		 
		<tr>
		  <td width="138" align="right" bgcolor="#D4E5F4">规格：</td>
          <td width="280" align="left" bgcolor="#FFFFFF">
               <c:out value='${cemeteryCommodity.specifications}'/>
			</td>
          <td width="124" height="35" align="right" bgcolor="#D4E5F4">进货价格：</td>
          <td width="301" align="left" bgcolor="#FFFFFF">
             <c:out value='${cemeteryCommodity.inPrice}'/>
		  </td>         
        </tr> 
		<tr>
		  <td width="138" align="right" bgcolor="#D4E5F4">销售价格：</td>
          <td width="280" align="left" bgcolor="#FFFFFF">
               <c:out value='${cemeteryCommodity.outPrice}'/>
			</td>
          <td width="124" height="35" align="right" bgcolor="#D4E5F4">库存量：</td>
          <td width="301" align="left" bgcolor="#FFFFFF">
             <c:out value='${cemeteryCommodity.count}'/>
		  </td>         
        </tr> 
		<tr>
		  <td width="138" align="right" bgcolor="#D4E5F4">业务员：</td>
          <td width="280" align="left" bgcolor="#FFFFFF">
              <gOS_shjz:shjzUser key="${cemeteryCommodity.createUserId}"/>
			</td>
          <td width="124" height="35" align="right" bgcolor="#D4E5F4">登记时间：</td>
          <td width="301" align="left" bgcolor="#FFFFFF">
            <fmt:formatDate value='${cemeteryCommodity.createDate}' pattern="yyyy-MM-dd"/>
		  </td>         
        </tr>
        </table>
        
        <table>
        <tr>
			<td colspan="4" align="center" bgcolor="#FFFFFF">
				&nbsp;
			</td>
		</tr>
		<tr>
			<td colspan="4" align="center" bgcolor="#FFFFFF">
				<input name="button3" type="button" onclick="javascript:location.href='cemeteryCommodityController.fj?method=getCemeteryCommodityList';" class="button-z" id="button3" value="返回" />
			</td>
	    </tr>
	</table>
</body>
</html>