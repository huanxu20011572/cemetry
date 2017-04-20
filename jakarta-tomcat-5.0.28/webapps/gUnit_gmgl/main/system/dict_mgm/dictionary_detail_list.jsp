<%@ page language="java" contentType="text/html;charset=GBK" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib uri="/WEB-INF/tld/gTaglib-gOS.tld" prefix="gOS" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<c:if test="${localname == null}">
 <c:set var="localname" value="${param.localname}"/>
 <c:if test="${param.hassub == null}">
     <c:set var="linksuffix" value="&localname=${localname}&institutionId=${institutionId}&preffix=${preffix}"/>
     <c:set var="displayname" value="${localname}"/>
 </c:if>
 <c:if test="${param.hassub != null}">
     <c:set var="linksuffix" value="&localname=${localname}&hassub=${param.hassub}&institutionId=${institutionId}&preffix=${preffix}"/>
     <c:set var="linksuffixsub" value="&localname=${localname}&institutionId=${institutionId}"/>
     <c:set var="displayname" value="${param.hassub}"/>
 </c:if>
</c:if>

<head>
<script language="javaScript">

<%--=======================add by lixl start========================--%>
// If you rename the "windowWithoutToolbar" function, please don't give it a name that 
// starts with "op"; it will conflict with some special Treeview code.
function windowWithoutToolbar(urlStr, width, height) 
{ 
   window.open(urlStr, '_blank', 'top=0,left=0,location=no,status=no,scrollbars=yes,menubar=no,toolbar=no,directories=no,resizable=no,width=' + width + ',height=' + height) 
}
<%--=======================add by lixl end========================--%>


    //新添<c:out value="${displayname}"/>
    function onSubmit(){
    	var code = myform.node_value.value;
    	    	
    	if(myform.node_name.value == "") {
    	    myform.node_name.focus();
    		alert("必须填写<c:out value="${displayname}"/>名称!");
    		return false;
    	}
    	myform.submit();
    }
    //更新<c:out value="${displayname}"/>
    function submitModify() {
        if(editform.node_name.value == "") {
    	    editform.node_name.focus();
    		alert("必须填写<c:out value="${displayname}"/>名称!");
    		return false;
    	} else {
    		editform.submit();
        }
    }
    //取消更新
    function cancelModify() {
        editform.node_name.value = '';
        editform.node_value.value = '';
        editform.id.value = '';
        editDiv.style.display = 'none';
    }
    //显示更新
    function editNode(nodeID,nodeName,node_value) {
        editform.node_name.value = nodeName;
        editform.id.value = nodeID;
        editDiv.style.display = 'block';
        editform.node_value.value = node_value;
    }


</script>


<html>
<head>
<title>无标题文档</title>
<link href="../../../css/css.css" rel="stylesheet" type="text/css">
</head>
<body>

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
					  <form name="myform" action="addNode.do?action=addNode&parentID=<c:out value="${bean.id}"/><c:out value="${linksuffix}"/>" method="post" onSubmit="return onSubmit()">
            <input name="parentCode" value="<c:out value='${param.parentCode}'/>" type="hidden">
			  <input type="hidden" name="parentid" value="<c:out value="${bean.id}"/>">
<tr><td colspan=3><center><font color="red">添加<c:out value="${localname}"/>类别:</font></center></td> </tr>
                           <tr>
                             <td height="25" align="right" class="td-01"><c:out value="${localname}"/>类别名称:</td>
                             <td class="td-02">   <input type="text" name="node_name" value="" maxlength="1000" size="20" height="16" >
                             </td>
                             <td colspan="-1" align="right" class="td-01"><c:out value="${localname}"/>类别编码</td>
                             <td colspan="2" class="td-02"> <input type="text" name="node_value" value="<c:out value="${preffix}"/>" maxlength="16" size="12" height="16"> <input onClick="javascript:onSubmit();" type="button" class="button" value="添加"></td>
                           </tr>  
						   </form>
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
						<td>状态及调整</td>						
						<td>操作</td>						
					  </tr>
					      <c:forEach var="list" items="${dataList}" >
					  <tr align="center" class="td-02">
						<td height="24"><c:out value="${list.node_name}"/></td>
						<td><c:out value="${list.node_value}"/></td>
						<td> <c:if test="${list.state == 1}">
                 新建
                 <a href="opearteNode.do?action=changeState&id=<c:out value="${list.id}"/>&parentID=<c:out value="${list.parentid}"/><c:out value="${linksuffix}&parentCode=${param.parentCode}"/>&newstate=2">
                 启用</a>
            </c:if>
            <c:if test="${list.state == 2}">
                 已启用
                 <a href="opearteNode.do?action=changeState&id=<c:out value="${list.id}"/>&parentID=<c:out value="${list.parentid}"/><c:out value="${linksuffix}&parentCode=${param.parentCode}"/>&newstate=3">
                 停用</a>
            </c:if>
            <c:if test="${list.state == 3}">
                 已停用
                 <a href="opearteNode.do?action=changeState&id=<c:out value="${list.id}"/>&parentID=<c:out value="${list.parentid}"/><c:out value="${linksuffix}&parentCode=${param.parentCode}"/>&newstate=2">
                 启用
            </c:if></td>
						<td><c:if test="${param.hassub != null}">
           	         <a href="findNode.do?action=findNode&parentID=<c:out value="${list.id}"/><c:out value="${linksuffixsub}&preffix=${list.node_value}-"/>">
           	         查看该类<c:out value="${localname}"/></a>
           	    </c:if>
           	    <a href="moveUpNode.do?action=moveUpNode&parentID=<c:out value="${list.parentid}&parentCode=${param.parentCode}"/>&index=<c:out value="${list.node_index}"/><c:out value="${linksuffix}"/>">上移</a>&nbsp;
           	    <a href="moveDownNode.do?action=moveDownNode&parentID=<c:out value="${list.parentid}&parentCode=${param.parentCode}"/>&index=<c:out value="${list.node_index}"/><c:out value="${linksuffix}"/>">下移</a>&nbsp;
           	    
	            <a href="javascript:editNode('<c:out value="${list.id}"/>','<c:out value="${list.node_name}"/>','<c:out value="${list.node_value}"/>')">编辑</a>&nbsp;
	            
	            <c:if test="${list.state == 1}">
	            <a href="opearteNode.do?action=deleteNode&id=<c:out value="${list.id}"/>&parentID=<c:out value="${list.parentid}&parentCode=${param.parentCode}"/><c:out value="${linksuffix}"/>">删除</a>&nbsp;           	    
                </c:if></td>
						</tr>
					</c:forEach>
					</table>
					</form>
      <table width="100%" border="0" cellpadding="0" cellspacing="0">
	  	<tr><td height="5"></td></tr>
        <tr>
          <td align="right">
		 </td>
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

</table>

<script language="javascript">
<!--
    <c:if test="${result != null}">
        var result = <c:out value="${result}"/>;		    
        if (result == 1) {
            alert('操作失败!');
        }		    
        if (result == 2) {
            alert('已含有相同名称或属性值的<c:out value="${displayname}"/>，操作失败!');
        }
    </c:if>
//-->
</script>
</body>
</html>