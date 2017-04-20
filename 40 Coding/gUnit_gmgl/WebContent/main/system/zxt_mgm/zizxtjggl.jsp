<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/gTaglib-gOS.tld" prefix="gOS" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib uri="http://www.topsuntech.com/jsptags/tree-taglib" prefix="topsuntech" %>
<%@page import="com.topsuntech.gOS.user.session.*" %>
<%@page import="com.topsuntech.gOS.user.en.user.*" %>
<%
	User user = UserSession.getUser(request);
	long deptid = 2;
	if (user!=null) {
		deptid = user.getDeptid();
	}
%>
<html>
<head>
<gOS:skin />

<!-- Code for browser detection -->
<script src="../../../script/ua_zxt.js"></script>

<!-- Infrastructure code for the tree -->
<script src="../../../script/ftiens4.js"></script>
<%
	String depts = (String)request.getAttribute("depts");
	System.out.println("----------depts in jsp: " + depts);
%>
<script>
// Decide if the names are links or just the icons
USETEXTLINKS = 1  //replace 0 with 1 for hyperlinks

// Decide if the tree is to start all open or just showing the root folders
STARTALLOPEN = 1 //replace 0 with 1 to show the whole tree

HIGHLIGHT = 1
USEFRAMES = 0
USEICONS = 0


	<topsuntech:TreeByDeptids>
		<%=depts%>
	</topsuntech:TreeByDeptids>




function onSubmit() {    
	var queryStr = generateQueryString();	
	if (queryStr==",") {
		window.alert("必须首先选择单位！");
	} else {
		document.myform.choosed.value=queryStr;
		myform.submit();
	}
}
</script>

</head>

<body topmargin="16" marginheight="16">


<form action="UserextCreate.do?action=step3" name="myform" method="post">
	<input name="choosed" type="hidden" value="">

  <table width="90%" border="0" align="right" cellpadding="0" cellspacing="0" class="table10">
    <tr>
    <td valign="top" class="td18">
      
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table7">
        <tr>
			 	  <td width="600" align="left">
						子系统机构管理
				  </td>
				  <td align="center">

				  </td>
        </tr>
      </table>
            
      	
      <br> <TABLE border=5 align="left" borderColor=EECCB4 borderlight="green">
        <TBODY>
          <TR>
            <TD align=middle><FONT
      size=2 face="Arial, Helvetica, sans-serif">单位列表</FONT>
      	&nbsp;【<a href="#" onclick="location.reload();">刷新</a>】
       	&nbsp;【<a href="#" onclick="expandTree(foldersTree);">展开</a>】
       	&nbsp;【<a href="#" onclick="collapseTree(1);">收缩</a>】</TD>

          </TR>
          <TR>
            <TD height="95" align=center>
              <!-- By making any changes to this code you are violating your user agreement.
     Corporate users or any others that want to remove the link should check
	 the online FAQ for instructions on how to obtain a version without the link -->
              <!-- Removing this link will make the script stop from working -->

              <div style="position:absolute; top:0; left:0; ">
                <table border=0>
                  <tr>
                    <td><font size=-2> <a style="font-size:7pt;text-decoration:none;color:silver" href="http://www.treemenu.net/" target=_blank></a></font>
                    </td>
                  </tr>
                </table>
              </div>
              <!-- Build the browser's objects and display default view of the
     tree. -->
              <script>initializeDocument()</script> <noscript>
              A tree for site navigation will open here if you enable JavaScript
              in your browser. </noscript> </TD>
          </TR>
        </TBODY>
      </TABLE>
    </td>
  </tr>
</table>
</form>
</body>
</html>
