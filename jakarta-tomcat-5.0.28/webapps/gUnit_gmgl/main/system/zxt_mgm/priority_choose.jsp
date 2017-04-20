<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/gTaglib-gOS.tld" prefix="gOS" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<link href="../../css/css.css" rel="stylesheet" type="text/css">
<html>
<head>
<title>修改用户权限</title>


<!-- Code for browser detection -->
<script src="../../../script/ua.js"></script>

<!-- Infrastructure code for the tree -->
<script src="../../../script/ftiens4.js"></script>

<script>
// Decide if the names are links or just the icons
USETEXTLINKS = 1  //replace 0 with 1 for hyperlinks

// Decide if the tree is to start all open or just showing the root folders
STARTALLOPEN = 1 //replace 0 with 1 to show the whole tree

HIGHLIGHT = 1
USEFRAMES = 0
USEICONS = 0

<%
	out.print(request.getAttribute("jsPriority"));
%>


function onSubmit() {
	myform.prioritys.value=generateQueryString(); 	
	<c:if test='${priosType=="all"}'>
		myform.ids.value='<c:out value="${ids}"/>';
		myform.priosType.value='all';
	</c:if>
	myform.submit();
}
</script>

</head>

<body topmargin="16" marginheight="16">
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="11" background="../../../images/images_32.jpg"><img src="../../../images/content_left.gif" width="11" height="51"></td>
    <td height="51" background="../../../images/images_32.jpg"><table width="70%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="22" height="16" align="center"><img src="../../../images/d.gif" width="14" height="14"></td>
          <td valign="bottom"> 当前位置：</td>
      </tr>
    </table>
    </td>
  </tr>
  <tr>
    <td background="../../../images/images_481.jpg">&nbsp;</td>
    <td valign="top">

<form action="UserextSelect.do?action=setPriority" name="myform" method="post">
	<input name="ids" type="hidden" value="">
	<input name="priosType" type="hidden" value="">

  <table width="90%" border="0" align="right" cellpadding="0" cellspacing="0" class="table10">
    <tr>
    <td valign="top" class="td18">
      
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table7">
        <tr>
			 	  <td width="600" align="left">
						请选择权限
				  </td>
        </tr>
      </table>
      <br>       
      <TABLE border=5 width=220 align="center" borderColor=#3399FF  borderlight="green">
        <TBODY>
          <TR>
            <TD align=middle><FONT
      size=2 face="Arial, Helvetica, sans-serif">权限列表</FONT>
      

          </TR>
          <TR>
            <TD align=center>            
				<input name="prioritys" type="hidden" value="">
				<input name="button2" type=button class=button onClick="javascript:onSubmit();" value="确定">
				<input name="button2" type=button class=button onClick="javascript:window.close()" value="取消">   
                <input name="button3" type=button class=button onClick="javascript:expandTree(foldersTree)" value="展开">
                <input name="button3" type=button class=button onClick="javascript:collapseTree(1)" value="收缩">
             </td>
           </tr>
           <tr>
           	<td>
              <div style="position:opposite; top:0; left:0; ">
                <table border=0>
                  <tr>
                    <td><font size=-2> <a style="font-size:7pt;text-decoration:none;color:silver" href="http://www.treemenu.net/" target=_blank></a></font>
                    </td>
                  </tr>
                </table>
              </div>

              <script>initializeDocument()</script> <noscript>
              A tree for site navigation will open here if you enable JavaScript
              in your browser. </noscript> 
           </TD>
          </TR>
        </TBODY>
      </TABLE>
    </td>
  </tr>
</table>
</form>
</td>
  </tr>
</table>
</body>
</html>
