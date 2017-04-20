<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ include file="../common/head.jsp"%>
<body style="background-color: transparent">
<form action="cemeteryCertificateController.fj?method=getCemeteryCertificatePageList" id="backForm" method="post">
	<input type="hidden" value="<c:out value='${cemeteryCertificate.id}'/>" name="id" id="id"/>
	<input type="hidden" value="<c:out value='${cemeteryCertificate.archivesCemeteryRegistryId}'/>" name="archivesCemeteryRegistryId" id="archivesCemeteryRegistryId"/>
	<table width="100%" border="0" cellspacing="0" cellpadding="0" height="100%" > 
  <tr>
    <td width="11" valign="top" class="td-bg"><img src="../images/right-1.jpg" /></td>
    <td align="center" valign="top" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="31" align="left" valign="middle" style="background:url(../images/right-3.jpg)"><img src="../images/right-4.jpg" width="9" height="8" align="absmiddle" /> 当前位置 &gt; 售后管理 &gt; 补证登记 &gt; 查看</td>
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
              <c:out value='${cemeteryCertificate.charge}'/>
		 </td>
		         
        </tr>
		 
		<tr>
		  <td width="15%" height="35" align="right" bgcolor="#D4E5F4">补证原因：</td>
          <td align="left" bgcolor="#FFFFFF" colspan='3'  >
		                <c:choose>
				          <c:when test="${cemeteryCertificate.reason=='1'}">
				          		证件丢失
				          </c:when>
				          <c:when test="${cemeteryCertificate.reason=='2'}">
				          		证件破损
				          </c:when>
				          <c:when test="${cemeteryCertificate.reason=='3'}">
				          		信息变更
				          </c:when>
				          <c:when test="${cemeteryCertificate.reason=='4'}">
				          		其他
				          </c:when>
				          <c:otherwise>
				          		
				          </c:otherwise>
				        </c:choose>
		  </td>
        </tr> 
    <tr>
      <td width="15%" bgColor='#d4e5f4' height='35' align='right'>备注：</td>
      <td colspan='3' bgColor='#ffffff' align='left'>
         <c:out value='${cemeteryCertificate.remark}'/>
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
                  <tr>
			<td colspan="4" align="center" bgcolor="#FFFFFF">
				&nbsp;
			</td>
	    </tr>
	    <tr>
			<td colspan="4" align="center" bgcolor="#FFFFFF">
	            <input name="button" type="button" class="button-z4" value="打印安葬证" onclick="javascript:location.href='../reprot/reprotController.fj?method=burialDetail&id=${cemeteryCertificate.archivesCemeteryRegistry.id}';" />&nbsp;
				<input name="button3" type="submit" class="button-z" id="button3" value="返回" />
			</td>
	    </tr>
      </table>
    </td>
  </tr>
</table>
	</form>
      </td>
  </tr>
</table>
</body>
</html>