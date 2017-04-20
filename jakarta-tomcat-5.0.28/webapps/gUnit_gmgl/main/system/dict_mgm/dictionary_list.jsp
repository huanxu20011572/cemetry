<%@ page language="java" contentType="text/html;charset=GBK" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib uri="/WEB-INF/tld/gTaglib-gOS.tld" prefix="gOS" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<jsp:include page="/common/header.jsp" flush="true">
 	<jsp:param name="js" value="/lib/functionforcheck.js"/>
 	<jsp:param name="js" value="/lib/calendar.js"/>
 
</jsp:include>
<c:set var="localname" value="数据字典"/>
<head>
<script>
<!--
    function onSubmit(){
    	if(myform.node_name.value == "") {
    	    myform.node_name.focus();
    		alert("必须填写<c:out value="${localname}"/>类别名称!");
    		return false;
    	} else {
    		myform.submit();
        }
    }
//-->
</script>

<html>
<head>
<title>无标题文档</title>
<link href="../../../css/css.css" rel="stylesheet" type="text/css">
<script language="JavaScript" src="../../../script/publics.js"></script>
<script language="JavaScript" src="../../../lib/function.js"></script>
</head>
<body>
  <form name="myform" action="addParentNode.do?action=addNode&institutionid=<c:out value="${param.institutionid}"/>&institutionId=<c:out value="${param.institutionId}"/>" method="post" onSubmit="return onSubmit()">

<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="11" background="../../../images/images_32.jpg"><img src="../../../images/content_left.gif" width="11" height="51"></td>
    <td height="51" background="../../../images/images_32.jpg"><table width="70%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="22" height="16" align="center"><img src="../../../images/d.gif" width="14" height="14"></td>
        <td valign="bottom"> 当前位置：数据字典管理  → 数据字典  → <span class="text-red">数据字典</span></td>
      </tr>
    </table>
    </td>
  </tr>
  <tr>
    <td background="../../../images/images_481.jpg">&nbsp;</td>
    <td valign="top">
	<table border="0" cellspacing="0" cellpadding="0" width="100%">
		<tr>
			<td align="left">
			<table width="94%" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr> 
                <td >&nbsp; </td>
				
                <td align="right" valign="top">&nbsp;
				</td>
				
              </tr>
			</table>
				  
		  </td>
		</tr>
		<tr id="tag1">
			<td>
			<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td width="45" align="left" background="../../../images/images_49.jpg"><img src="../../../images/images_48.jpg" width="38" height="40"></td>
        <td background="../../../images/images_49.jpg" class="title"> 公用数据管理</td>
        <td width="16" align="right" background="../../../images/images_49.jpg"><img src="../../../images/images_52.jpg" width="16" height="40"></td>
      </tr>
    </table>
			<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td width="16" background="../../../images/images_55.jpg">&nbsp;</td>
          <td width="926" align="center">		
			  <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr> 
                      <td>&nbsp;</td>
                    </tr>
                    <tr> 
                      <td>
					  <table width="100%" border="0" cellpadding="1" cellspacing="1" bgcolor="a8d1eb">
<tr><td colspan=3><center><font color="red">添加<c:out value="${localname}"/>类别</font></center></td> </tr>
                           <tr>
                             <td height="25" align="right" class="td-01"><c:out value="${localname}"/>类别名称:</td>
                             <td class="td-02"> <input type="text" name="node_name" value="" maxlength="25" size="20" height="16">
                             </td>
                             <td colspan="-1" align="right" class="td-01"><c:out value="${localname}"/>类别编码</td>
                             <td colspan="2" class="td-02"><input type="text" name="node_value" value="" maxlength="10" size="12" height="16"> <input onClick="javascript:onSubmit();" type="button" class="button1" value="添加类别"></td>
                           </tr>   					                        
                        </table></td>
                    </tr>					
                    <tr> 
                      <td>
					  	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
					  <tr> 
					  <!--
						<td height="36"><img src="../../images/but-tj.gif" width="66" height="27" border="0" style="cursor:hand;" onClick="doAddPre()"> </td>
						-->
						<td align="right" valign="top">&nbsp;
						</td>
						
					  </tr>
				  </table>
					  
					  </td>
                    </tr>
                  </table>
                  <table width="100%"  border="0" cellpadding="1" cellspacing="1" bgcolor="#a8d1eb">
					  <tr align="center" class="td-04">
						<td height="24"><c:out value="${localname}"/>类别名称</td>
						<td><c:out value="${localname}"/>类别编码</td>
						<td>操作</td>						
					  </tr>
					 <c:forEach var="list" items="${dataList}" >
					  <tr align="center" class="td-02">
						<td height="24"><c:out value="${list.node_name}"/></td>
						<td><c:out value="${list.node_value}"/></td>
						<td><a href="findNode.do?action=findNode&parentCode=<c:out value="${list.node_value}"/>&localname=<c:out value="${list.node_name}"/>"> 查看子类别</a></td>
						</tr>
					</c:forEach>
					</table>
					</form>
      <table width="100%" border="0" cellpadding="0" cellspacing="0">
	  	<tr><td height="5"></td></tr>
        <tr>
          <td align="right">
		  <gOS:page name="pageForm" action="listNode.do?action=listNode" pageName="dataPage">
				     <input type="hidden" name="institutionId" value="<c:out value="${param.institutionId}"/>">
                  </gOS:page></td>
        </tr>
    </table>
          </td>
          <td width="16" background="../../../images/images_57.jpg">&nbsp;</td>
        </tr>
        <tr>
          <td><img src="../../../images/images_72.jpg" width="16" height="17"></td>
          <td background="../../../images/images_73.jpg">&nbsp;</td>
          <td><img src="../../../images/images_75.jpg" width="16" height="17"></td>
        </tr>
      </table>
			</td>
		</tr>
	</table>
    </td>
  </tr>
</form>
</table>

<script language="javascript">
<!--
    <c:if test="${result != null}">
        var result = <c:out value="${result}"/>;
        //if (result == 0) {
        //    alert('添加成功!');
        //}		    
        if (result == 1) {
            alert('添加失败!');
        }		    
        if (result == 2) {
            alert('已含有同名<c:out value="${localname}"/>类别，添加失败!');
        }		    
    </c:if>
//-->
</script>
</body>
</html>