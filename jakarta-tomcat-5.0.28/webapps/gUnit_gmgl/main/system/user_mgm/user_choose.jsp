<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="http://www.topsuntech.com/jsptags/tree-taglib" prefix="topsuntech" %>
<%@ taglib uri="/WEB-INF/tld/gTaglib-gOS.tld" prefix="gOS" %>
<html>
<%
	String inputBox = request.getParameter("inputBox");
	String officeId = request.getParameter("officeId");
	if (inputBox == null) {
		inputBox = "parent";
	}
%>
<head>
<title>选择用户</title>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<gOS:skin />
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

<topsuntech:officeUserTree>
	<%=officeId%>
</topsuntech:officeUserTree>

function onSubmit() {
	window.opener.document.myform.<%=inputBox%>.value=generateChooseValue();
	window.opener.document.myform.<%=inputBox%>id.value=generateChooseId();
	window.close();
}
</script>

</head>

<body topmargin=16 marginheight=16 onload="javascript:expandTree(foldersTree)">

<table width="102%" border="0" align="right" cellpadding="0" cellspacing="0" class="table10">
  <tr> 
       
    <td height="459" valign="top" class="td18"> 
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table7">
        <tr> 
          <td width="0%" height="20">&nbsp; </td>
          <td width="54%" height="20" align="left">&nbsp;</td>
          <td width="46%" align="right"><table width="300" border="0" cellpadding="0" cellspacing="0">
              <tr class="td16"> 
                <td width="60" class="td16">&nbsp;</td>
                <td width="60" class="td16">&nbsp;</td>
                <td width="60" class="td16">&nbsp; </td>
                <td width="60" class="td16">&nbsp;</td>
                <td width="60" class="td16">&nbsp;</td>
              </tr>
            </table></td>
        </tr>
      </table>
      <br>
      <TABLE border=5 align="center" borderColor=EECCB4 borderlight="green">
        <TBODY>
          <TR> 
            <TD align=center><FONT face="Arial, Helvetica, sans-serif" 
      size=2>请选择：部门</FONT></TD>
          </TR>
          <TR> 
            <TD align=center> 
              <!-- By making any changes to this code you are violating your user agreement.
     Corporate users or any others that want to remove the link should check 
	 the online FAQ for instructions on how to obtain a version without the link -->
              <!-- Removing this link will make the script stop from working -->
              <form>
                <input name="button3" type=button class=button onClick="onSubmit();" value="确定">
                <input name="button3" type=button class=button onClick="javascript:window.close()" value="取消">              
                <input name="button3" type=button class=button onClick="javascript:expandTree(foldersTree)" value="展开">
                <!-- The next three functions have an hardcoded value. How do you figure out which value to use?
     What is the id of a node? 
     If you are not using the node.xID capability, open the tree in the browser and move your mouse 
     over the +/- nodes to the left of the folders. The numbers shown are the ids of the folders.
     Increment that number sequentially to get the ids of the "documents" inside that folder.
     If you are using the node.xID capability, then simply use the corresponding xID value (it may 
     be a string).
-->
                <input name="button3" type=button class=button onClick="javascript:collapseTree(1)" value="收缩">
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
      </TABLE></td>
  </tr>
</table>
</body>
</html>
