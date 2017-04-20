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
	<TITLE> New Document </TITLE>
<style type="text/css">
     A {
         font-family:Verdana, Arial,Helvetica;
         font-size:11px;
         font-weight:normal;
         color:blue;
         text-decoration:none;
     }

     A:hover {
         font-family:Verdana, Arial,Helvetica;
         font-size:11px;
         font-weight:normal;
         color:blue;
         text-decoration:underline;
     }
</style>



<!-- Code for browser detection -->
<script src="../../../script/ua.js"></script>

<!-- Infrastructure code for the tree -->
<script src="../../../script/ftiens4.js"></script>

<script>
// Decide if the names are links or just the icons
USETEXTLINKS = 1  //replace 0 with 1 for hyperlinks

// Decide if the tree is to start all open or just showing the root folders
STARTALLOPEN = 0 //replace 0 with 1 to show the whole tree

HIGHLIGHT = 1
USEFRAMES = 0
USEICONS = 0

<%
	String prios = request.getParameter("prios");
	String userId= request.getParameter("userId");
%>
<topsuntech:roleTree>
	<%if(prios==null || prios.trim().equals("")){%>
	<%=userId%>
	<%}else{%>
	<%=prios%>
	<%}%>
</topsuntech:roleTree>
</script>
<link href="../../../css/css.css" rel="stylesheet" type="text/css">
</head>

<body topmargin=16 marginheight=16 onLoad="javascript:expandTree(foldersTree)">
	<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="11" background="../../../images/images_32.jpg"><img src="../../../images/content_left.gif" width="11" height="51"></td>
    <td height="51" background="../../../images/images_32.jpg"><table width="70%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="22" height="16" align="center"><img src="../../../images/d.gif" width="14" height="14"></td>
          <td valign="bottom"> ��ǰλ�ã�</td>
      </tr>
    </table>
    </td>
  </tr>
  <tr>
    <td background="../../../images/images_481.jpg">&nbsp;</td>
    <td valign="top">
<table width="102%" border="0" align="right" cellpadding="0" cellspacing="0" class="table10">
  <tr> 
    <td height="459" valign="top" class="td18"> 

      <TABLE height="100%" border=0 align="center" cellspacing="1" borderColor=EECCB4 class="table1" borderlight="green">
        <TBODY>
          <TR> 
            <TD height="22" align=middle><FONT 
      size=2 face="Arial, Helvetica, sans-serif">��ѡ�񣺽�ɫ</FONT></TD>
          </TR>
          <TR> 
            <TD align=center> 
              <!-- By making any changes to this code you are violating your user agreement.
     Corporate users or any others that want to remove the link should check 
	 the online FAQ for instructions on how to obtain a version without the link -->
              <!-- Removing this link will make the script stop from working -->
              <form>
                <input name="button" type=button class=input_btn onClick="javascript:expandTree(foldersTree)" value="չ��">
                <!-- The next three functions have an hardcoded value. How do you figure out which value to use?
     What is the id of a node? 
     If you are not using the node.xID capability, open the tree in the browser and move your mouse 
     over the +/- nodes to the left of the folders. The numbers shown are the ids of the folders.
     Increment that number sequentially to get the ids of the "documents" inside that folder.
     If you are using the node.xID capability, then simply use the corresponding xID value (it may 
     be a string).
-->		
                <input name="button2" type=button class=input_btn onClick="javascript:collapseTree(1)" value="����">
              </form>
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
    </td>
  </tr>
</table>
</body>
</html>
