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
<topsuntech:customePriorityTree>
	<c:out value="${actor.priority}" />
</topsuntech:customePriorityTree>
<%String userId=request.getParameter("userId");%>
function onSubmit() {
	parent.opener.document.myform.prioritys.value=generateQueryString(); 
	//这里我们需要提交这个表单，修改实际的用户权限
	<%if(userId!=null){%>
	myform.prioritys.value=generateQueryString(); 	
	myform.submit();
	<%}%>
	parent.close();
}
</script>
<link href="../../../css/css.css" rel="stylesheet" type="text/css">
</head>

<body topmargin=16 marginheight=16 onLoad="javascript:expandTree(foldersTree)">
<table width="102%" border="0" align="right" cellpadding="0" cellspacing="0" class="table10">
  <tr> 
       
    <td height="459" valign="top" class="td18"> 
      <TABLE border=0 align="center" borderColor=EECCB4 class="table1" borderlight="green">
        <TBODY>
          <TR> 
            <TD align=middle><div align="center"><FONT face="Arial, Helvetica, sans-serif" 
      size=2>权限列表</FONT></div></TD>
          </TR>
          <TR> 
            <TD align=center> 
              <!-- By making any changes to this code you are violating your user agreement.
     Corporate users or any others that want to remove the link should check 
	 the online FAQ for instructions on how to obtain a version without the link -->
              <!-- Removing this link will make the script stop from working -->
              <form action="userUpdate.do?action=updatePriority" name="myform" method="post">
              	<input name="id" type="hidden" value="<%=userId%>">
              	<input name="prioritys" type="hidden" value="">
                <input name="button2" type=button class=input_btn onClick="javascript:onSubmit();" value="确定">
                <input name="button2" type=button class=input_btn onClick="javascript:parent.close()" value="取消">                     	
                <input name="button3" type=button class=input_btn onClick="javascript:expandTree(foldersTree)" value="展开">
                <!-- The next three functions have an hardcoded value. How do you figure out which value to use?
     What is the id of a node? 
     If you are not using the node.xID capability, open the tree in the browser and move your mouse 
     over the +/- nodes to the left of the folders. The numbers shown are the ids of the folders.
     Increment that number sequentially to get the ids of the "documents" inside that folder.
     If you are using the node.xID capability, then simply use the corresponding xID value (it may 
     be a string).
-->
                <input name="button3" type=button class=input_btn onClick="javascript:collapseTree(1)" value="收缩">         
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
