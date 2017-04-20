<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib uri="http://www.topsuntech.com/jsptags/tree-taglib" prefix="topsuntech" %>
<%@ taglib uri="/WEB-INF/tld/gTaglib-gOS.tld" prefix="gOS" %>
<%@page import="com.topsuntech.gOS.user.session.*" %>
<%@page import="com.topsuntech.gOS.user.en.user.*" %>
<%@page import="java.util.*" %>
<html>
<head>
<title>Untitled Document</title>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<link href="../../../css/css.css" rel="stylesheet" type="text/css">
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
<script src="../../../script/action.js" language="JScript"></script>
<script src="../../../script/functionforcheck.js" language="JScript"></script>
<script src="../../../script/toolbar-ie5.js" language="JScript"></script>
<link href="../../../script/toolbar-ie5.css" type="text/css" rel="stylesheet">
<xml id="xsl" src="../../../script/toolbar-ie5.xsl"></xml>

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

<topsuntech:priorityTree/>
function onSubmit() {
	var IsValid=true;
	if(isEmpty(myform.name.value)){
		document.all("namelbl").innerHTML="<font color=\"ff0000\">����д��ɫ����</font>";
		IsValid=false;
	}else if(!checkLength(myform.name.value, 0, 15)){
		document.all("namelbl").innerHTML="<font color=\"ff0000\">��ɫ���ƹ�����С��15�ַ���</font>";
		IsValid=false;
	}else{
		document.all("namelbl").innerHTML="";
	}
	
	if(!checkLength(myform.description.value, 0, 150)){
		document.all("deslbl").innerHTML="<font color=\"ff0000\">��ɫ����������С��150�ַ���</font>";
		IsValid=false;
	} else {
		document.all("deslbl").innerHTML="";
	}
	document.myform.prioritys.value=generateQueryString(); 
	if(IsValid)
	myform.submit();
}
function doCancel(){
		myform.action="../../../tree/roleList.do?method=getRolelist";
	myform.submit();
}
</script>
</head>
<%
	Date current = new Date(System.currentTimeMillis());
	request.setAttribute("current", current);
%>
<body  leftmargin="0" topmargin="0" onLoad="javascript:expandTree(foldersTree)">
<form action="actorAdd.do?action=add" name="myform" method="post">
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="11" background="../../../images/images_32.jpg"><img src="../../../images/content_left.gif" width="11" height="51"></td>
    <td height="51" background="../../../images/images_32.jpg"><table width="70%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="22" height="16" align="center"><img src="../../../images/d.gif" width="14" height="14"></td>
          <td valign="bottom"> ��ǰλ�ã���ɫά�� �� <b>��ӽ�ɫ</b></td>
      </tr>
    </table>
    </td>
  </tr>
  <tr>
    <td background="../../../images/images_481.jpg">&nbsp;</td>
    <td valign="top">
	<input type="hidden" name="creatorId" value="<c:out value="${loginUser.id}" />">
	<input name="prioritys" type="hidden" value="">
<table width="100%" border="0" align="right" cellpadding="0" cellspacing="0" class="table1">
  <tr>
       <td height="459" align="right" valign="top" class="td18">
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table1">
        <tr>
          <td width="0%" height="20">&nbsp; </td>
          <td width="54%" height="20" align="left"><table width="100%" border="0" cellpadding="0" cellspacing="0">
            <tr >
              <td  align="right"><div align="left">
                <input name="button2" type="button" class="input_btn" onClick="onSubmit();" value="ȷ��">
                </input>
                <input name="button2" type="button" class="input_btn" onClick="doCancel();" value="ȡ��">
                  </input>
              </div></td>
            </tr>
          </table></td>
          <td width="56%" align="left">
            <strong>�����½�ɫ��(*Ϊ������)<font color="ff0000">
            <html:errors/>
            </font></strong></td>
        </tr>
      </table>
      <table width="100%" border="0" class="table5">
        <tr>
          <td height="14"  class="td8" align="left">�����ˣ�<c:out value="${loginUser.name}" /> �������ڣ�<fmt:formatDate value="${current}" pattern="yyyy-MM-dd" /></td>          
        </tr>
      </table>
      <table width="100%" border="0" cellpadding="1" cellspacing="1" class="table5">
        <tr >
          <td width="15%" height="22" class="td22" align="right">����*��</td>
          <td width="86%" height="22" class="td23"> <input name="name" type="text" value="<c:out value="${actor.name}" />" maxlength="15">
          <label id="namelbl" name="namelbl"></label>
          </td>
        </tr>
        <tr >
          <td width="15%" height="22" class="td22" align="right">��ϵͳ*��</td>
          <td width="86%" height="22" class="td23">
          	 <select name="rolefl">
          	 	<option value="Эͬ��칫">��ѡ��</option>
          	 	<option value="Эͬ��칫">Эͬ��칫</option>
          	 	<option value="">�ۺ�ָ��</option>
          	 	<option value="�ۺ�ָ��">�����ִ��</option>
          	 	<option value="�����Ų�">�����Ų�</option>
          	 	<option value="�ٱ�Ͷ��">�ٱ�Ͷ��</option>
          	 	<option value="�����Ԥ��">�����Ԥ��</option>
          	 	<option value="������ɹ���">������ɹ���</option>
          	 	<option value="��������ѵ">��������ѵ</option>
          	 	<option value="�ۺ�֪ʶ����">�ۺ�֪ʶ����</option>
          	 </select>
          <label id="namelbl" name="namelbl"></label>
          </td>
        </tr>
        <tr >
          <td class="td22" align="right">������</td>
          <td valign="top"> <textarea name="description" cols="60" rows="8" wrap="hard"><c:out value="${actor.description}" /></textarea>
            <span class="input_txt">
            <label id="deslbl" name="deslbl"></label>
            </span></td>
        </tr>
        <tr >
          <td height="127" valign="top" class="td22" align="right">Ȩ���б�</td>
          <td valign="top"  class="td23"> &nbsp;
<TABLE  border=0 borderlight="green">
              <TBODY>
                <TR>
                  <TD align=middle><FONT face="Arial, Helvetica, sans-serif" color=#000000
      size=2><strong>��ѡ��Ȩ��</strong></FONT></TD>
                </TR>
                <TR>
                  <TD align=center>
<form>
  <div align="center">
    <input name="button" type=button class="input_btn" onClick="javascript:expandTree(foldersTree)" value="չ��">
    <input name="button" type=button class="input_btn" onClick="javascript:collapseTree(1)" value="����">
    </div>
</form>
                    <div style="position:absolute; top:0; left:0; ">
                      <table border=0>
                        <tr>
                          <td><font size=-2> <a style="font-size:7pt;text-decoration:none;color:silver" href="http://www.treemenu.net/" target=_blank></a></font>
                          </td>
                        </tr>
                      </table>
                    </div>
                    <script>initializeDocument()</script> <noscript>
                    A tree for site navigation will open here if you enable JavaScript
                    in your browser. </noscript> </TD>
                </TR>
              </TBODY>
            </TABLE></td>
        </tr>
      </table>
      </td>
  </tr>
</table>
      </td>
  </tr>
</table>
</form>
</body>
</html>
