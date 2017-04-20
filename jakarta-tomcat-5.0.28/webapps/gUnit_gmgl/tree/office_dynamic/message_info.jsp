<%@ page contentType="text/html; charset=GBK" %>
<%@ include file="../../common/taglibs.jsp"%>
<%@ include file="../../common/js_common.jsp"%>
<link href="../css/css.css" rel="stylesheet" type="text/css">


<%@page import="com.topsuntech.gOS.user.session.*" %>
<%@page import="com.topsuntech.gOS.user.en.user.*" %>



<html>
<head>
<title>新增区域</title>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">

<script src="../../script/publics.js"></script>
<script type='text/javascript' src='../../dwr/engine.js'></script>
<script type='text/javascript' src='../../dwr/util.js'></script>
<script>


function goBack(){

history.go(-1);

}


</script>
</head>

<body >
	<form action="../doAddAdjust.do?method=add" name="myform" method="post">
		<input type="hidden" name="cityId" value="20001">
		
		<table width="95%" height="" border="0" cellpadding="0" cellspacing="0">	
			<tr>
		
			<td width="1225" height="31" valign="bottom" background="../images/images_32.jpg">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="14" height="25" align="center"  style="padding-bottom:5px;"><img src="../images/d.gif" width="14" height="14"></td>
							<td width="1210"> 当前位置：区划管理->区划<c:if test="${gosRegionAdjust.adjustType == 50162}">拆分</c:if><c:if test="${gosRegionAdjust.adjustType == 50161}">合并</c:if>->查看</td>
						  <td width="10" align="center"><iframe width="100%" src="../images/images_32.jpg" height="31" frameborder="0" scrolling="no"></iframe></td>
						</tr>
			  </table>			
			  </td>
		</tr>
  <tr >
    <td>&nbsp;</td>
    <td align="center" valign="top">
	</table>
	
	<table width="93%" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
            <td width="45" align="left" background="../images/images_49.jpg"><img src="../images/images_48.jpg" width="38" height="40"></td>
            <td background="../images/images_49.jpg"><span class="title"> 区划类型：</span></td>
          </tr>
      </table>
	  
        <table width="93%" border="0" align="center" cellpadding="0" cellspacing="0">
			  <tr>
				<td width="16" background="../images/images_55.jpg"></td>
				
				<td width="1204" align="center">
					<table width="98%" border="0" cellspacing="0" cellpadding="0">
						<tr>
						  <td height="14">&nbsp;</td>
						</tr>
					  </table>
					  <table width="96%" border="0" cellpadding="1" cellspacing="1" bgcolor="a8d1eb">
						<tr>
						  <td width="20%" height="30" align="center" class="td-01" align="center"><c:if test="${gosRegionAdjust.adjustType == 50162}">拆分</c:if><c:if test="${gosRegionAdjust.adjustType == 50161}">合并</c:if>类型： </td>
						  <td  class="td-02" width="89%">&nbsp;<gOS_shjz:dictValue key="${gosRegionAdjust.adjustLevel}" typeName="TZJB" />
							
						  </td>
						</tr>
					  </table>
					  
				</td>
				
				<td width="16" background="../images/images_57.jpg">&nbsp;</td>
			  </tr>
				  <tr>
					<td><img src="../images/images_72.jpg" width="16" height="17"></td>
					<td background="../images/images_73.jpg">&nbsp;</td>
					<td><img src="../images/images_75.jpg" width="16" height="17"></td>
				  </tr>
      </table>
	  
	
	<br/>
			
<table width="93%" border="0" align="center" cellpadding="0" cellspacing="0">



            <tr>
              <td width="45" align="left" background="../images/images_49.jpg"><img src="../images/images_48.jpg" width="38" height="40"></td>
              <td width="1175" background="../images/images_49.jpg"><span class="title"> 被<c:if test="${gosRegionAdjust.adjustType == 50162}">拆分</c:if><c:if test="${gosRegionAdjust.adjustType == 50161}">合并</c:if>区划信息：</span></td>
              <td width="16" align="right" background="../images/images_49.jpg"><img src="../images/images_52.jpg" width="16" height="40"></td>
            </tr>
      </table>
          <table width="93%" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
              <td width="16" background="../images/images_55.jpg">&nbsp;</td>
              <td width="1204" align="center">
			  <table width="98%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td height="14">&nbsp;</td>
                  </tr>
                </table>
                <table width="96%" border="0" cellpadding="1" cellspacing="1" bgcolor="a8d1eb">
                  <tr>
                    <td width="20%" height="30" align="center" class="td-01">原名称
                      ：</td>
                    <td  class="td-02" width="80%">&nbsp;&nbsp;
					<c:out value="${gosRegionAdjust.adjustCountyNames}"/>
					<c:if test="${gosRegionAdjust.adjustLevel == 50165}"><c:out value="${gosRegionAdjust.adjustStreetNames}"/></c:if>
					
					<c:if test="${gosRegionAdjust.adjustLevel == 50166}"><c:out value="${gosRegionAdjust.adjustStreetNames}"/>
					<c:out value="${gosRegionAdjust.adjustCommunityNames}"/></c:if>
			
					
                    </td>
                    
                  </tr>
                </table>
                <table width="98%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td>&nbsp;</td>
                  </tr>
              </table></td>
              <td width="16" background="../images/images_57.jpg">&nbsp;</td>
            </tr>
            <tr>
              <td><img src="../images/images_72.jpg" width="16" height="17"></td>
              <td background="../images/images_73.jpg">&nbsp;</td>
              <td><img src="../images/images_75.jpg" width="16" height="17"></td>
            </tr>
      </table>
          <br/>
          <table width="93%" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
              <td width="45" align="left" background="../images/images_49.jpg"><img src="../images/images_48.jpg" width="38" height="40"></td>
              <td background="../images/images_49.jpg"><span class="title"> 新区划信息：</span></td>
              <td width="16" align="right" background="../images/images_49.jpg"><img src="../images/images_52.jpg" width="16" height="40"></td>
            </tr>
      </table>
          <table width="93%" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
              <td width="16" background="../images/images_55.jpg">&nbsp;</td>
              <td width="1191" align="center">
			  <table width="98%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td height="14">&nbsp;</td>
                  </tr>
                </table>
                <table width="96%" border="0" cellpadding="1" cellspacing="1" bgcolor="a8d1eb">
                  <tr>
                    <td width="20%" height="30" align="center" class="td-01">新名称
                      ：</td>
                    <td  class="td-02" width="80%">&nbsp;&nbsp;
					<c:out value="${gosRegionAdjust.newCountyNames}"/>
					
					<c:if test="${gosRegionAdjust.adjustLevel == 50165}"><c:out value="${gosRegionAdjust.newStreetNames}"/></c:if>
					<c:if test="${gosRegionAdjust.adjustLevel == 50166}"><c:out value="${gosRegionAdjust.newStreetNames}"/>
					<c:out value="${gosRegionAdjust.newCommunityNames}"/></c:if>
					
					
                    </td>
                    
                  </tr>
                </table>
                <table width="98%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td>&nbsp;</td>
                  </tr>
              </table></td>
              <td width="16" background="../images/images_57.jpg">&nbsp;</td>
            </tr>
            <tr>
              <td><img src="../images/images_72.jpg" width="16" height="17"></td>
              <td background="../images/images_73.jpg">&nbsp;</td>
              <td><img src="../images/images_75.jpg" width="16" height="17"></td>
            </tr>
      </table>
		  <br/>
	<table width="93%" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
            <td width="45" align="left" background="../images/images_49.jpg"><img src="../images/images_48.jpg" width="38" height="40"></td>
            <td background="../images/images_49.jpg"><span class="title"> 其它信息：</span></td>
          </tr>
      </table>
	  
        <table width="93%" border="0" align="center" cellpadding="0" cellspacing="0">
			  <tr>
				<td width="16" background="../images/images_55.jpg"></td>
				
				<td width="1204" align="center">
					<table width="98%" border="0" cellspacing="0" cellpadding="0">
						<tr>
						  <td height="14">&nbsp;</td>
						</tr>
					  </table>
					  <table width="96%" border="0" cellpadding="1" cellspacing="1" bgcolor="a8d1eb">
						<tr>
						  <td width="20%" height="30"  class="td-01" align="center">原区划停用时间： </td>
						  <td  class="td-02" width="89%">&nbsp;
							<fmt:formatDate value='${gosRegionWarn.effectDate}' pattern='yyyy-MM-dd'/>	
						  </td>
						</tr>
					  </table>
					  
				</td>
				
				<td width="16" background="../images/images_57.jpg">&nbsp;</td>
			  </tr>
				  <tr>
					<td><img src="../images/images_72.jpg" width="16" height="17"></td>
					<td background="../images/images_73.jpg">&nbsp;</td>
					<td><img src="../images/images_75.jpg" width="16" height="17"></td>
				  </tr>
      </table>
	  
	  
      
	<br/>
		<table width="95%" border="0"  cellpadding="0" cellspacing="0">
          <tr>
            		<td align="center"> <input name="button" type="button" class="input_btn"  onClick="goBack()" value="返回" /></td>
					

          </tr>
        </table>
</form>
</body>
</html>
