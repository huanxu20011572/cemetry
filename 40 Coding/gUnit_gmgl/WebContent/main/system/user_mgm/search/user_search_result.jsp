<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib uri="/WEB-INF/tld/gTaglib-gOS.tld" prefix="gOS" %>
      <%	    
	    request.setCharacterEncoding("GBK");
      %>
<html>
<head>
<title>Untitled Document</title>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<gOS:skin />
<script src="../../../script/action.js" language="JScript"></script>
<script src="../../../script/toolbar-ie5.js" language="JScript"></script>
<link href="../../../script/toolbar-ie5.css" type="text/css" rel="stylesheet">
<xml id="xsl" src="../../../script/toolbar-ie5.xsl"></xml>

<script src="../../../script/ua.js"></script>
<script>
function f_goto_page(form, param){
   // event.returnValue = false;    
    var va;
    if (param == "first"){
        va = "first";
    }
    else if (param == "prev"){
        va = "prev";
    }
    else if (param == "next"){
        va = "next";
    }
    else if (param == "last"){
        va = "last";
    }
    else{
        if (param == ""){
            alert("请输入您要跳转的页数");
            form.to_page.focus();
            return;            
        }
        var intParam = parseInt(param * 1);
        if (isNaN(intParam)){
            alert("请输入正确的页数");
            form.to_page.focus();
            return;
        }
        else{
            va = intParam;
        }
    }
    //alert(va);
    form.goto_page.value = va;
    form.submit();
}
</script>
</head>
<!-- Link Tigra Hints script file to your HTML document-->
<script language="JavaScript" src="../../../script/hints.js"></script>
<!-- Link Tigra Hints configuration file to your HTML document-->
<script language="JavaScript" src="../../../script/hints_cfg.js"></script>
<SCRIPT language=JavaScript>
<!--
function CheckAll()
  {
    for (var i=0;i<document.myform.elements.length;i++)
    {
      var e = document.myform.elements[i];
      if (e.name == 'ids')
        e.checked = document.checkall.allbox.checked;
    }
  }
function CheckSelected() {
    var isCheck = false;
    for (var i=0;i<document.myform.elements.length;i++)
    {
      var e = document.myform.elements[i];
      if (e.name == 'ids')
        if (e.checked == true) {
            isCheck = e.checked;
            break;
        }
    }
    return isCheck;
}
function onSubmit() {
	if (CheckSelected()) {
		myform.submit();
	} else {
		window.alert("请首先选择！");
	}
}
//-->
</SCRIPT>
<body bgcolor="#FFFFFF" text="#000000" leftmargin="0" topmargin="0" scroll="no" onload="f_resize_main_span()" onresize="f_resize_main_span()">
<span id="_main_Span" style="width:100%;overflow:auto">
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table11">
  <tr> 
    <td height="20" align="right">&nbsp;</td>
  </tr>
</table>
<table width="100%" border="0" cellpadding="0" class="table_template" id="_main_table">
  <tr> 
    <td valign="top"> 
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table7">
        <tr> 
          <td height="17">  <xml id="os_toolbar_2727376791"> 
	    <toolbar>
	        <item title="创建新用户" icon="../../../images/config/create.gif"          action="location.href='userAdd.do?action=showSearchAdd'"/>
  		<c:if test="${!empty param.deptid}">
  			<item title="查询用户" icon="../../../images/config/zoom_small.gif"          action="location.href='userSelect.do?action=search&amp;deptid=<c:out value="${param.deptid}"/>'"/>	        
		</c:if>  
  		<c:if test="${empty param.deptid}">
  			<item title="查询用户" icon="../../../images/config/zoom_small.gif"          action="location.href='userSelect.do?action=search'"/>	        
		</c:if>  

	        
	    	<item title="批量删除"   icon="../../../images/config/delete.gif"      action="myform.actionType.value='delete'; onSubmit();"/>   	
	    	<item title="批量修改权限"   icon="../../../images/config/adduser.gif"      action="myform.actionType.value='role'; onSubmit();"/>
	    	<break/> 
	    	<item title="刷新" 	icon="../../../images/config/reload_nav.gif"    action="location.reload();"/>
                <item title="返回" 	icon="../../../images/config/back.gif"    action="history.back();"/>
	    </toolbar>      
	</xml> 
	<span id="os_toolbar_2727376791_result" style="display: inline-block;"></span> 
      <script>document.all['os_toolbar_2727376791'].ondatasetcomplete = os_init_toolbar;</script> </td>
        </tr>
      </table>
      <form action="userDeleteAll.do?action=deleteAllConfirm" name="myform" method="post">  
      <input type="hidden" name="actionType" value="">
      <input type="hidden" name="prioritys">
      <table width="100%" border="0" cellpadding="1" class="ConfigTable">
        <tr class="tr2"> 
      <%com.topsuntech.gOS.query.jsp.QueryShowGenerator.generateShow(request);%>
      <td width="5%">&nbsp;</td>
      <c:forEach var="myheader" items="${headerList}" varStatus="headerStatus">
      <c:if test="${headerStatus.count!=1}">
      <td>
      <c:out value="${myheader}"/>
      </td>
      </c:if>
      </c:forEach>
    </TR>

    <c:forEach var="row" items="${rowList}" varStatus="status">
      <c:if test="${status.count % 2 == 2}">
        <TR class="tr1" >
      </c:if>
      <c:if test="${status.count % 2 != 2}">
        <TR class="tr3" >
      </c:if>
      <td>
	 <c:set var="identity">
	 	<c:out value="${row.detailKey}"/>
	 </c:set>
      <input name="ids" type="checkbox" value="<c:out value="${identity}"/>" >
      </td>
      <c:forEach var="cell" items="${row.record}" varStatus="innerStatus">
      	      <c:if test="${innerStatus.count!=2}">
	      
      <TD>
	      <c:if test="${innerStatus.count == row.detailColumn+1}">
	    	  <a href="userSelect.do?action=detail&id=<c:out value="${identity}"/>"><c:out value="${cell}"/></a>
              </c:if>
	      <c:if test="${innerStatus.count != row.detailColumn+1}">
		      <c:out value="${cell}"/>
	      </c:if>
      </TD>
      	       </c:if>
      </c:forEach>
	  <td width="18%">
	    <a href="userUpdate.do?action=showUpdate&id=<c:out value="${identity}"/>&sDeptId=<%=sDeptId%>&search=search">
	    
	    <img src="../../../images/config/zoom_small.gif" width="16" height="16" border="0" onMouseOver="myHint.show(0)" onMouseOut="myHint.hide()"></a>
	    <a href="userClone.do?action=showClone&id=<c:out value="${identity}"/>&sDeptId=<%=sDeptId%>&search=search">
	    
	    <img src="../../../images/config/clone.gif" width="16" height="16" border="0" onMouseOver="myHint.show(1)" onMouseOut="myHint.hide()"></a> 
	    <a href="userDelete.do?action=deleteConfirm&id=<c:out value="${identity}"/>&sDeptId=<%=sDeptId%>">
	    
	    <img src="../../../images/config/delete.gif" width="16" height="16" border="0" onMouseOver="myHint.show(2)" onMouseOut="myHint.hide()"></a> 
	    <a href="javascript:windowWithoutToolbar('userChoose.do?action=actorChoose&userId=<c:out value="${identity}"/>', 600, 500)">
	    
	    <img src="../../../images/config/adduser.gif" width="16" height="15" border="0" onMouseOver="myHint.show(3)" onMouseOut="myHint.hide()"></a> 
	    <c:choose>
	            <c:when test="${user.registstatus == '1'}">
	            	<a href="registCheck.do?action=check&type=alluser&id=<c:out value="${user.id}"/>">审批</a>
	            </c:when>
	            
	            <c:otherwise>
	            	审批
	            </c:otherwise>
	        </c:choose>
	  </td>

    </TR>
    </c:forEach>
      </table>
      </form>
    </td>
  </tr>
  <tr class="tr2"> 
    <td align="left"> <font color="#FF0000">操作共有4项：编辑、克隆、删除、修改权限。“修改权限”是为了修改某个用户的细粒度权限。</font> 
    </td>
  </tr>
  <tr> 
    <td align="left" valign="bottom"> 
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table7">	      
        <tr> 
           <form name="checkall">
		    <td width="45%" height="17" valign="bottom"> 
              <INPUT onclick=CheckAll(); type=checkbox value="Check All" 
            name=allbox>
              <A onclick="allbox.checked=!allbox.checked;" 
            href="javascript:CheckAll();">选中所有的用户</A> 
             
        </td>
		 </form>         
          <td width="72%" valign="bottom"> 
            <script src="../../../script/function.js"></script>
  <gOS:page name="test" action="user_search_result.jsp" pageName="queryPage" pageSizeKey="query">
      <c:if test="${!empty param.deptid}">
      <input type="hidden" name="deptid" value="<c:out value='${param.deptid}'/>">
      </c:if>  
  <c:forEach var="item" items="${itemList}" >
    <input name="<c:out value='${item.name}'/>" value="<c:out value='${item.value}'/>" type="hidden">
            </c:forEach> </gOS:page> </td>
        </tr>
      </table></td>
  </tr>
</table>
</span>
</body>
</html>
