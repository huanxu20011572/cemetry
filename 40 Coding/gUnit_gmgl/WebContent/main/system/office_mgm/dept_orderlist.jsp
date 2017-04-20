<%@ page language="java" contentType="text/html;charset=GBK" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib uri="/WEB-INF/tld/gTaglib-gOS.tld" prefix="gOS" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib uri="/WEB-INF/tld/gTaglib-mjzz.tld" prefix="gEU_mjzz" %>
<%@ taglib uri="struts-html" prefix="html" %>
<%@ taglib uri="html-el" prefix="html-el" %>
<html>
<head>
<title>无标题文档</title>
<link href="../css/css.css" rel="stylesheet" type="text/css">
</head>
<script language="JavaScript" src="../script/publics.js"></script>
<script language="JavaScript" src="../lib/function.js"></script>
<script type="text/javascript" src="../script/jquery.js"></script>
<script src="<c:url value="/script/ua.js"/>"></script>

<script language="javascript">


function basicInfoList(){
var strform = document.deptInfo;
 strform.submit();
};

function setOffice(win, id, name){
	$('#deptid').val(id);
	$('#dept').val(name);
	win.close();
}
function selectOffice() {
	windowWithoutToolbar("<c:url value="/tree/office_choose.jsp?type=1"/>", 300, 600, true);
}
function clearOffice(){
	$('#deptid').val('');
	$('#dept').val('');
}

</script>
<body>
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="11" background="../images/images_32.jpg"><img src="../images/content_left.gif" width="11" height="51"></td>
    <td height="51" background="../images/images_32.jpg"><table width="70%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="22" height="16" align="center"><img src="../images/d.gif" width="14" height="14"></td>
        <td valign="bottom"> 当前位置：超级系统管理 → <b>部门排序</b></td>
      </tr></td>		
    </table>
    </td>
  </tr>
  <tr>
    <td background="../images/images_481.jpg">&nbsp;</td>
    <td valign="top">
	<table border="0" cellspacing="0" cellpadding="0" width="100%">
		<tr>
			<td align="left">
			<table width="94%" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
				  
                <td height="0">&nbsp; </td>
				  
                <td height="0" align="right" valign="top">&nbsp;</td>
				</tr>
			</table>
				  
		  </td>
		</tr>
		<tr id="tag1">
			<td>
			<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td width="45" align="left" background="../images/images_49.jpg"><img src="../images/images_48.jpg" width="38" height="40"></td>
        <td background="../images/images_49.jpg" class="title"><strong>部门排序</strong></td>
        
        <td background="../images/images_49.jpg"  align="right"><a href="office_list.jsp"><img alt='返回' src='../images/but-fh.gif' border=no style='vertical-align:middle'></a></td>
      </tr>
    </table>
   
			<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td width="16" background="../images/images_55.jpg">&nbsp;</td>
          <td align="center">
          
		  
		  			<table width="98%" border="0" cellspacing="0" cellpadding="0">
		  			<form  method="post" action="deptOrder.do?method=deptList" name="deptInfo">
                    <tr> 
                      <td>&nbsp;</td>
                    </tr>
                    <tr> 
                      <td><!--<table width="100%" border="0" cellpadding="1" cellspacing="1" bgcolor="a8d1eb">
                          <tr> 
                            <td width="17%" height="25" align="right" class="td-01">所在部门：</td>
                            <td width="33%" class="td-02" height="25"><input height="25" readonly id="dept" name="dept" class="input" type="text" value="<c:out value="${param.dept}"/>" size="23">
            <input id="deptid" name="deptid" type="hidden" value="<c:out value="${param.deptid}"/>">
            	 <a href="javascript:selectOffice()"  title=请选择部门><img src="../images/anniu_1_03.gif" border="0" ></a> 
            	  <a href="javascript:clearOffice()" title=清除选择部门><img src="../images/anniu_1_05.gif" border="0"></a>
         </td>
                       
                     <td class="td-02"><a href='#' onClick="basicInfoList();" title=查询><img src="../images/but-cx_58.jpg" width="63" height="21" border="0" style="cursor:hand;"></a></td>
		
                          </tr>						  						  
					
						  		  
                        </table>--></td>
                    </tr>
                    </form>		
                  <tr>
          <td>&nbsp;</td>
        </tr>
                  </table>
		  
                  <table width="98%" border="0" cellpadding="1" cellspacing="1" bgcolor="a8d1eb">
                    <tr> 
                      <td width="10%" height="30" align="center" class="td-04">序号</td>
                      <td width="30%" align="center" class="td-04">区域名称</td>
					  <td width="20%" align="center" class="td-04">区域级别</td>
					  <td width="20%" align="center" class="td-04">显示顺序</td>
				         
                      <td  align="center" class="td-04">操作</td>
                    </tr>
					<c:forEach var="bean" items="${dataList}"  varStatus="ctIndex" >
                     <c:if test="${ctIndex.count%2==1}">
                     <tr  height="25" align="center" class="td-02">
					</c:if>
					 <c:if test="${ctIndex.count%2==0}">
						 <tr  height="25" align="center" class="td-01">
					 </c:if>
                      <td  height="25" align="center"><c:out value='${ctIndex.index+1}'/></td>
					  <td  align="center"><c:out value='${bean.NAME}'/></td>
					  <td  align="center"> <c:if test="${bean.LEVELID==1}">市级</c:if> <c:if test="${bean.LEVELID==2}">区级</c:if> <c:if test="${bean.LEVELID==3}">街道</c:if></td>
				    <td  align="center"><c:out value='${bean.ORDERBY_ITEM}'/></td>          
            <td  align="center"> <a href='deptMove.do?method=moveUp&id=<c:out value="${bean.ID}"/>&orderByItem=<c:out value="${bean.ORDERBY_ITEM}"/>&deptId=<c:out value="${deptid}"/>&dept=<c:out value="${dept}"/>'>上移</a> 
						  <a href='deptMove.do?method=moveDown&id=<c:out value="${bean.ID}"/>&orderByItem=<c:out value="${bean.ORDERBY_ITEM}"/>&deptId=<c:out value="${deptid}"/>&dept=<c:out value="${dept}"/>'>下移</a>
						</td>
                    </tr>
					</c:forEach>
                  </table>
			</form>
				 <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table-line">
					<tr> 
					  <td align="right" class="listTable_page">
						<gOS:page name="listpageForm" pageName="page"  action="deptOrder.do?method=deptList">
							<gOS:param name="dept"><c:out value="${param.dept}" /></gOS:param>
							<gOS:param name="deptid"><c:out value="${param.deptid}" /></gOS:param>
						</gOS:page>				 
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
			</td>
		</tr>
	</table>
    </td>
  </tr>
</table>
</body>
</html>