<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib uri="/WEB-INF/tld/gTaglib-gOS.tld" prefix="gOS" %>
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
<script src="../../../script/function.js"></script>
<!-- Link Tigra Hints script file to your HTML document-->
<script language="JavaScript" src="../../../script/hints.js"></script>
<!-- Link Tigra Hints configuration file to your HTML document-->
<script language="JavaScript" src="../../../script/hints_cfg.js"></script>
</head>
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
      <%	    
	    String addDeptId=request.getParameter("deptid");
	    String deptName=request.getParameter("deptName");
      %>
<body bgcolor="#FFFFFF" text="#000000" leftmargin="0" topmargin="0" scroll="no" onload="f_resize_main_span()" onresize="f_resize_main_span()">
<span id="_main_Span" style="width:100%;overflow:auto">
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table_template" id="_main_table">
  <tr> 
    <td align="right" class="td18_1" valign="top"> 
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table7">
        <tr>           
             <td width="90%">&nbsp;<strong>部门人员列表</strong>： 北京市民政局 - <%=deptName%> 　</td>          
			 <td width="10%" align="right"><table border="0" cellpadding="0" cellspacing="0">
                            <tr align="right" class="td16"> 
                                <td width="52" class="td16">【<a href="javascript:history.back();" >返回</a>】</td>
                            </tr>
             </table></td>
        </tr>
      </table>

     
      <table width="100%" border="0" cellpadding="1" class="ConfigTable">
        <tr class="tr2"> 
 
      <%com.topsuntech.gOS.query.jsp.QueryShowGenerator.generateResult(request);%>
      <c:forEach var="myheader" items="${headerList}" varStatus="status">
	<c:if test="${status.count!=2}">
	      <td  class="tr2">
	      <c:out value="${myheader}"/>
	      </td>
      	</c:if>
      </c:forEach>
        </tr>

        <c:forEach var="row" items="${rowList}" varStatus="outterstatus">
	<c:if test="${outterstatus.count % 2 == 1}">
        	<tr class="tr1" >
        </c:if>
        <c:if test="${outterstatus.count % 2 != 1}">
        	<tr class="tr3" >
        </c:if>
	      <c:forEach var="cell" items="${row}" varStatus="innerstatus">
	      <c:if test="${innerstatus.count==2}">
		         <c:set var="identity">
		         	<c:out value="${cell}"/>
		         </c:set>	     	
	      </c:if>
	      <c:if test="${innerstatus.count!=2}">
	      	<TD>
	      	<c:if test="${innerstatus.count==3}">
	      		<a href="userSelect.do?action=detail&id=<c:out value="${identity}"/>">
        	</c:if>
        		<c:out value="${cell}"/>
	      	<c:if test="${innerstatus.count==3}">
	      	</a>
        	</c:if>
        	</TD>
	      </c:if>
	      </c:forEach>
         
        </tr>
        </c:forEach>
      </table>
 
    </td>
  </tr>  
  <tr> 
    <td align="left" valign="bottom"> 
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table7">	      
        <tr>
         <form name="sform" action=userSelect.do?action=find method="post">            
          <td width="55%" valign="bottom">            	            
	        <input name="key" type="text" value="输入关键字" size="15" height="16">
	        <input name="id" type="hidden" value="<c:out value="${param['id']}"/>">
	        <select name="type" size="1">
	            <option selected value="姓名">姓名</option>
	            <option value="性别">性别</option>
	            <option value="职务">职务</option>
	            <option value="职称">职称</option>
	            <option value="学历">学历</option>
	        </select>
	        <input name="search" type="button" class="button" id="search2" value="搜索" onClick="sform.submit();">
	        <input name="search2" type="button" class="button1" id="search" value="高级搜索" onClick="parent.mainFrame.location.href='bmry_user_search.jsp?deptid=<%=addDeptId%>&deptName=<%=deptName%>'; return true;">	              	    
      	    
            </td>    
            </form>
            <td width="45%" valign="bottom" align="right"> 
            <%String dept_id=request.getParameter("id");%>
            <gOS:page name="test1" action="userSelect.do?action=viewByDept" pageName="dataPage" pageSizeKey="list"> 
            <gOS:param name="id" value="<%=dept_id%>" /> 
            <c:forEach var="item" items="${itemList}" >
                <input name="<c:out value='${item.name}'/>" value="<c:out value='${item.value}'/>" type="hidden">
            </c:forEach>            
            </gOS:page> 
            </td>
        </tr>
      </table>
    </td>
  </tr>
</table>
</span>
</body>
</html>
