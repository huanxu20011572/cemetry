<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib uri="http://www.topsuntech.com/jsptags/tree-taglib" prefix="topsuntech" %>
<%@ taglib uri="/WEB-INF/tld/gTaglib-gOS.tld" prefix="gOS" %>
<html>
<head>
<title>Untitled Document</title>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<link href="../../../css/css.css" rel="stylesheet" type="text/css">

<script language="JavaScript">
<!--



function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}
//-->
</script>
</head>

<body bgcolor="#FFFFFF" text="#000000" leftmargin="0" topmargin="0">
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="11" background="../../../images/images_32.jpg"><img src="../../../images/content_left.gif" width="11" height="51"></td>
    <td height="51" background="../../../images/images_32.jpg"><table width="70%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="22" height="16" align="center"><img src="../../../images/d.gif" width="14" height="14"></td>
          <td valign="bottom"> 当前位置：机构信息查看</td>
      </tr>
    </table>
    </td>
  </tr>
  <tr>
    <td background="../../../images/images_481.jpg">&nbsp;</td>
    <td valign="top">


<table width="100%" border="0" cellpadding="1" cellspacing="1" class="table_main">									
  <tr> 
       
    <td align="right" valign="top" class="td18"> 
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table7">
        <tr> 
          <td width="0%" height="20" class="list_title">&nbsp; </td>
          <td width="54%" height="20" align="left" class="td-02"><input name="button" type="button" class="input_btn" onClick="javascript:history.back();" value="返回"/></td>
          <td width="46%" align="right" class="list_title">&nbsp;</td>
        </tr>
      </table>
      <table width="100%" border="0" class="table5">
        <tr> 
          <td width="46%" height="18">&nbsp;</td>
          <td width="54%" align="right">创建人：<c:out value="${creatorName}" /> 创建日期：<fmt:formatDate value="${office.createdate}" pattern="yyyy-MM-dd" /></td>
        </tr>
      </table>
     <TABLE type="grid" border="0"  style="table-layout:fixed;"    name= "listTable" id = "listTable" cellpadding="1" cellspacing="1" bgcolor="a8d1eb"> 
        <tr> 
          <td width="15%" height="22" class="td-01">上级单位：</td>
          <td height="22" class="td-02"> <c:out value="${parent}"/> 
          </td>
          <td height="22" class="td-01">单位显示顺序*：</td>
          	<td height="22" valign="top" class="td-02">
          		<c:out value="${office.order}"/>
          	</td>
        </tr>
        
        <tr height="22" > 
          <td height="22" class="td-01">单位编号：</td>
          <td width="36%" height="22" class="td-02"><c:out value="${office.num}"/></td>
          <td width="14%" height="22" class="td-01">单位名称*：</td>
          <td width="35%" height="22" class="td-02"><c:out value="${office.name}"/></td>
        </tr>
        <tr> 
          <td height="22" class="td-01">单位属性：</td>
          <td height="22" class="td-02"><c:out value="${office.cat}"/></td>
          <td class="td-01">单位级格*：</td>
          <td class="td-02"><c:out value="${level}"/></td>
        </tr>
        <tr height="22" > 
          <td height="22" class="td-01">编制数目：</td>
          <td height="22" class="td-02"><c:out value="${office.bzsm}"/></td>
          <td height="22" class="td-01">实际人数：</td>
          <td height="22" class="td-02"><c:out value="${office.syrs}"/></td>
        </tr>
        <tr> 
          <td height="22" class="td-01">单位简称：</td>
          <td height="22" class="td-02"><c:out value="${office.shortname}"/></td>
          <td class="td-01">经费形式：</td>
          <td class="td-02"><c:out value="${office.jfxs}"/></td>
        </tr>
        <tr height="22" > 
          <td height="22" class="td-01">正职领导数目：</td>
          <td height="22" class="td-02"><c:out value="${office.ldzzs}"/></td>
          <td height="22" class="td-01">副职领导数目：</td>
          <td height="22" class="td-02"><c:out value="${office.ldfzs}"/></td>
        </tr>
        <tr> 
          <td height="22" class="td-01">法人：</td>
          <td height="22" class="td-02"><c:out value="${farenName}"/></td>
          <td height="22" class="td-01">所属区域：</td>
          <td height="22" class="td-02"><c:out value="${office.region.name}"/></td>
        </tr>
        <tr> 
          <td height="60" class="td-01">单位描述：</td>
          <td height="60" colspan="3" class="td-02"><c:out value="${office.description}"/></td>
        </tr>
      </table>
      <br>
      <br>
      <table width="100%" border="0" cellpadding="1" cellspacing="1" class="table_main">
        <c:forEach var="upLeader" items="${upLeaderList}" > 
        <tr height="22" > 
          <td width="10%" align="right" class="td-01">上级分管领导<c:out value="${upLeader.officeseq}"/>：</td>
          <td width="13%" class="td-02"><a href="../user_mgm/userSelect.do?action=detail&id=<c:out value="${upLeader.userid}"/>"><c:out value="${upLeader.username}"/></a></td>
          <td width="10%" align="right" class="td-01">职务：</td>
          <td width="13%" class="td-02"><c:out value="${upLeader.position}"/></td>
          <td width="10%" align="right" class="td-01">描述：</td>
          <td class="td-02"><c:out value="${upLeader.description}"/></td>
        </tr>
        </c:forEach>

        <c:forEach var="leader" items="${leaderList}" >
        <tr height="22" > 
          <td width="10%" align="right" class="td-01">单位领导<c:out value="${leader.officeseq}"/>：</td>
          <td width="13%" class="td-02"><a href="../user_mgm/userSelect.do?action=detail&id=<c:out value="${leader.userid}"/>"><c:out value="${leader.username}"/></a></td>
          <td width="10%" align="right" class="td-01">职务：</td>
          <td width="13%" class="td-02"><c:out value="${leader.position}"/></td>
          <td width="10%" align="right" class="td-01">描述：</td>
          <td class="td-02"><c:out value="${leader.description}"/></td>
        </tr>
        </c:forEach>
      </table> 
      
	    </td>
	  </tr>
	</table>

    </td>
  </tr>
</table>
</body>
</html>
