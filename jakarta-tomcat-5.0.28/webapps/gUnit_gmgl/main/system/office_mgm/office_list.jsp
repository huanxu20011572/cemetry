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
<title>Untitled Document</title>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<link href="../../../css/css.css" rel="stylesheet" type="text/css">
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
	<topsuntech:officeTree/>
function onSubmit() {    
	var queryStr = generateQueryString();	
	if (queryStr==",") {
		window.alert("��������ѡ��λ��");
	} else {
		document.myform.choosed.value=queryStr;
		myform.submit();
	}
}
function createNewUnit(action){
	myform.action = action;
	myform.submit();
}
function closeAllNode(){
	collapseTree(1);
}
</script>
</head>
<body >

<body topmargin="16" marginheight="16">
<form action="officeDeleteAll.do?action=deleteAllConfirm" name="myform" method="post">
	<input name="choosed" type="hidden" value="">
  <table width="100%" border="0"  cellpadding="0"  cellspacing="1" class="table1">
    <tr>
    <td valign="top" class="td18">
      <table width="100%" border="0" cellpadding="0" cellspacing="1"  class="table7">
        <tr>
 	  		<td width="600" align="left" class="list_title">
 	  		<input name="Submit" type="submit" class="input-btu3" onClick="createNewUnit('officeAdd.do?action=showAdd');"  value="�����µ�λ"/>
 	  		<input name="Submit" type="button" class="input-btu3" onClick="onSubmit();"  value="����ɾ��"/>
 	  		<input name="Submit" type="button" class="input_btn" onClick="javascript:location.reload();"  value="ˢ��"/>
 	  		<input name="Submit" type="submit" class="input-btu3" onClick="createNewUnit('userMove.do?action=showMove');"  value="�ƶ��û�"/>
 	  		<input name="Submit" type="submit" class="input-btu3" onClick="createNewUnit('officeMove.do?action=showMove');"  value="�ƶ���λ"/>
 	  		<input name="Submit" type="button" class="input_btn" onClick="javascript:expandTree(foldersTree);"  value="չ��"/>
 	  		<input name="Submit" type="button" class="input_btn" onClick="closeAllNode();"  value="����"/>
	   </td>
       </tr>

      </table>
      <br> <TABLE border='0' align="left"  class="table1" width="100%">
        <TBODY>
          <TR class="list_title">
            <TD align=middle><FONT
      size=2 face="Arial, Helvetica, sans-serif">��λ�б�</FONT></TD>
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
  <tr>
    <td height="55" align="left" valign="top" class="td2">
    <font color="#FF0000">
        ������֧�ֻ��������޼������������5��ͼ�꣺�༭��λ�������ӵ�λ���ƶ���λ��ɾ����λ����λ�û�����<br>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;�ƶ���λ��Ϊ��֧�ֵ�λ�ṹ�ĵ����������ڽ����е�λ���顣<br>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��λ��Ų��ǵ�λ��Ψһ��ʶ����λ���ƿ��ܻ��ظ���<br>
    </font>
    </td>
  </tr>
</table>
</form>
</body>
</html>
