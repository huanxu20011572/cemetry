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

	foldersTree = gFld("<b>���в���</b>", "")
   t1=insFld(foldersTree, gFld("<b>���в���</b>", ""))
      t2=generateCheckBox1(t1, "������������", "2", "officeSelect.do?action=detail&id=2", "true")
            t3=insFld(t2, gFld("<b>ְ�ܴ���</b>", ""))
                  t4=generateCheckBox1(t3, "�칫��", "4", "officeSelect.do?action=detail&id=4", "true")
                        t5=insFld(t4, gFld("<b>ְ�ܴ���</b>", ""))
               generateCheckBox1(t5, "2��", "78", "officeSelect.do?action=detail&id=78")
               generateCheckBox1(t5, "1��", "80", "officeSelect.do?action=detail&id=80")
                        t5=insFld(t4, gFld("<b>������λ</b>", ""))
               generateCheckBox1(t5, "3��", "82", "officeSelect.do?action=detail&id=82")
               generateCheckBox1(t5, "4��", "84", "officeSelect.do?action=detail&id=84")
                        t5=insFld(t4, gFld("<b>ֱ����λ</b>", ""))
               generateCheckBox1(t5, "6��", "88", "officeSelect.do?action=detail&id=88")
               generateCheckBox1(t5, "5��", "86", "officeSelect.do?action=detail&id=86")
         generateCheckBox1(t3, "���߷��洦", "6", "officeSelect.do?action=detail&id=6")
         generateCheckBox1(t3, "�Ÿ�������˫ӵ�����쵼С��칫�ң�", "8", "officeSelect.do?action=detail&id=8")
         generateCheckBox1(t3, "������ΪȨ�汣����", "10", "officeSelect.do?action=detail&id=10")
         generateCheckBox1(t3, "���ô������������˾��˰��ð칫�ң�", "12", "officeSelect.do?action=detail&id=12")
         generateCheckBox1(t3, "���־ȼô�", "14", "officeSelect.do?action=detail&id=14")
         generateCheckBox1(t3, "������Ȩ���账", "16", "officeSelect.do?action=detail&id=16")
         generateCheckBox1(t3, "�������������������������쵼С��칫�ң�", "18", "officeSelect.do?action=detail&id=18")
         generateCheckBox1(t3, "��������", "20", "officeSelect.do?action=detail&id=20")
         generateCheckBox1(t3, "�����������������������������ǼǴ���", "22", "officeSelect.do?action=detail&id=22")
         generateCheckBox1(t3, "����������", "24", "officeSelect.do?action=detail&id=24")
         generateCheckBox1(t3, "�ƻ�����", "26", "officeSelect.do?action=detail&id=26")
         generateCheckBox1(t3, "��ƴ�", "28", "officeSelect.do?action=detail&id=28")
         generateCheckBox1(t3, "��֯���´�", "30", "officeSelect.do?action=detail&id=30")
         generateCheckBox1(t3, "����������", "32", "officeSelect.do?action=detail&id=32")
         generateCheckBox1(t3, "�������ί������칫��", "34", "officeSelect.do?action=detail&id=34")
         generateCheckBox1(t3, "���ص�ί", "36", "officeSelect.do?action=detail&id=36")
         generateCheckBox1(t3, "�ϸɲ���", "38", "officeSelect.do?action=detail&id=38")
         generateCheckBox1(t3, "��������", "142", "officeSelect.do?action=detail&id=142")
         generateCheckBox1(t3, "���Ե�λ", "144", "officeSelect.do?action=detail&id=144")
                  t4=generateCheckBox1(t3, "dd0", "162", "officeSelect.do?action=detail&id=162", "true")
                        t5=insFld(t4, gFld("<b>ְ�ܴ���</b>", ""))
               generateCheckBox1(t5, "111", "202", "officeSelect.do?action=detail&id=202")
                  t4=generateCheckBox1(t3, "2", "228", "officeSelect.do?action=detail&id=228", "true")
                        t5=insFld(t4, gFld("<b>ְ�ܴ���</b>", ""))
               generateCheckBox1(t5, "2", "230", "officeSelect.do?action=detail&id=230")
         generateCheckBox1(t3, "112", "232", "officeSelect.do?action=detail&id=232")
            t3=insFld(t2, gFld("<b>������λ</b>", ""))
         generateCheckBox1(t3, "�о����������ݸɲ����ð칫��", "40", "officeSelect.do?action=detail&id=40")
         generateCheckBox1(t3, "���������Ǽǹ���칫��", "42", "officeSelect.do?action=detail&id=42")
         generateCheckBox1(t3, "������Э��", "44", "officeSelect.do?action=detail&id=44")
         generateCheckBox1(t3, "����ḣ����ҵ����", "46", "officeSelect.do?action=detail&id=46")
         generateCheckBox1(t3, "���������", "48", "officeSelect.do?action=detail&id=48")
         generateCheckBox1(t3, "������ҵ���账", "50", "officeSelect.do?action=detail&id=50")
         generateCheckBox1(t3, "��������ҵ�ܹ�˾", "52", "officeSelect.do?action=detail&id=52")
            t3=insFld(t2, gFld("<b>ֱ����λ</b>", ""))
         generateCheckBox1(t3, "�и�����Ʊ��������", "54", "officeSelect.do?action=detail&id=54")
         generateCheckBox1(t3, "��������У", "56", "officeSelect.do?action=detail&id=56")
         generateCheckBox1(t3, "�о���վ", "58", "officeSelect.do?action=detail&id=58")
         generateCheckBox1(t3, "�����س�ת��Ա����칫��", "60", "officeSelect.do?action=detail&id=60")
         generateCheckBox1(t3, "�н��վ��������������", "62", "officeSelect.do?action=detail&id=62")
         generateCheckBox1(t3, "�����ظ��������칫��", "64", "officeSelect.do?action=detail&id=64")
         generateCheckBox1(t3, "סլ����칫��", "66", "officeSelect.do?action=detail&id=66")
         generateCheckBox1(t3, "�ͷ���˾", "68", "officeSelect.do?action=detail&id=68")
         generateCheckBox1(t3, "��������ᱨ����", "70", "officeSelect.do?action=detail&id=70")
         generateCheckBox1(t3, "��ѵ����", "72", "officeSelect.do?action=detail&id=72")
         generateCheckBox1(t3, "���˿�ҽԺ", "74", "officeSelect.do?action=detail&id=74")
         generateCheckBox1(t3, "�м�֫���μ�������", "76", "officeSelect.do?action=detail&id=76")

function generateChooseValue() {
	if (getElById('32').checked) { return "����������"; }
	if (getElById('110').checked) { return "cshi1"; }
	if (getElById('114').checked) { return "ceshi"; }
	if (getElById('120').checked) { return "ffffffffffffffffffffffffffffff"; }
	if (getElById('112').checked) { return "1"; }
	if (getElById('118').checked) { return "11"; }
	return "";
}

function generateChooseId() {
	if (getElById('32').checked) { return "32"; }
	if (getElById('110').checked) { return "110"; }
	if (getElById('114').checked) { return "114"; }
	if (getElById('120').checked) { return "120"; }
	if (getElById('112').checked) { return "112"; }
	if (getElById('118').checked) { return "118"; }
}

function generateQueryString() {
	var retStr = ",";
	if (getElById('2').checked) { retStr = retStr + "2,"; }
	if (getElById('4').checked) { retStr = retStr + "4,"; }
	if (getElById('6').checked) { retStr = retStr + "6,"; }
	if (getElById('8').checked) { retStr = retStr + "8,"; }
	if (getElById('10').checked) { retStr = retStr + "10,"; }
	if (getElById('12').checked) { retStr = retStr + "12,"; }
	if (getElById('14').checked) { retStr = retStr + "14,"; }
	if (getElById('16').checked) { retStr = retStr + "16,"; }
	if (getElById('18').checked) { retStr = retStr + "18,"; }
	if (getElById('20').checked) { retStr = retStr + "20,"; }
	if (getElById('22').checked) { retStr = retStr + "22,"; }
	if (getElById('24').checked) { retStr = retStr + "24,"; }
	if (getElById('26').checked) { retStr = retStr + "26,"; }
	if (getElById('28').checked) { retStr = retStr + "28,"; }
	if (getElById('30').checked) { retStr = retStr + "30,"; }
	if (getElById('32').checked) { retStr = retStr + "32,"; }
	if (getElById('34').checked) { retStr = retStr + "34,"; }
	if (getElById('36').checked) { retStr = retStr + "36,"; }
	if (getElById('38').checked) { retStr = retStr + "38,"; }
	if (getElById('142').checked) { retStr = retStr + "142,"; }
	if (getElById('144').checked) { retStr = retStr + "144,"; }
	if (getElById('162').checked) { retStr = retStr + "162,"; }
	if (getElById('228').checked) { retStr = retStr + "228,"; }
	if (getElById('232').checked) { retStr = retStr + "232,"; }
	if (getElById('40').checked) { retStr = retStr + "40,"; }
	if (getElById('42').checked) { retStr = retStr + "42,"; }
	if (getElById('44').checked) { retStr = retStr + "44,"; }
	if (getElById('46').checked) { retStr = retStr + "46,"; }
	if (getElById('48').checked) { retStr = retStr + "48,"; }
	if (getElById('50').checked) { retStr = retStr + "50,"; }
	if (getElById('52').checked) { retStr = retStr + "52,"; }
	if (getElById('54').checked) { retStr = retStr + "54,"; }
	if (getElById('56').checked) { retStr = retStr + "56,"; }
	if (getElById('58').checked) { retStr = retStr + "58,"; }
	if (getElById('60').checked) { retStr = retStr + "60,"; }
	if (getElById('62').checked) { retStr = retStr + "62,"; }
	if (getElById('64').checked) { retStr = retStr + "64,"; }
	if (getElById('66').checked) { retStr = retStr + "66,"; }
	if (getElById('68').checked) { retStr = retStr + "68,"; }
	if (getElById('70').checked) { retStr = retStr + "70,"; }
	if (getElById('72').checked) { retStr = retStr + "72,"; }
	if (getElById('74').checked) { retStr = retStr + "74,"; }
	if (getElById('76').checked) { retStr = retStr + "76,"; }
	if (getElById('78').checked) { retStr = retStr + "78,"; }
	if (getElById('80').checked) { retStr = retStr + "80,"; }
	if (getElById('82').checked) { retStr = retStr + "82,"; }
	if (getElById('84').checked) { retStr = retStr + "84,"; }
	if (getElById('88').checked) { retStr = retStr + "88,"; }
	if (getElById('86').checked) { retStr = retStr + "86,"; }
	if (getElById('202').checked) { retStr = retStr + "202,"; }
	if (getElById('230').checked) { retStr = retStr + "230,"; }
	return retStr;
}


function onSubmit() {
	var queryStr = generateQueryString();
	if (queryStr==",") {
		window.alert("��������ѡ��λ��");
	} else {
		document.myform.choosed.value=queryStr;
		myform.submit();
	}
}
</script>

</head>

<body topmargin="16" marginheight="16">
<form action="officeDeleteAll.do?action=deleteAllConfirm" name="myform" method="post">
	<input name="choosed" type="hidden" value="">
  <table width="90%" border="0" align="right" cellpadding="0" cellspacing="0" class="table10">
    <tr>
    <td valign="top" class="td18">
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table7">
        <tr>
          <td width="1" height="20">&nbsp; </td>
          <td width="99%" height="20" align="left">
           	  	��<a href="officeAdd.do?action=showAdd">�����µ�λ</a>��
 	  		&nbsp;��<a href="#" onclick="onSubmit();">����ɾ��</a>��
			&nbsp;��<a href="#" onclick="location.reload();">ˢ��</a>��
                        &nbsp;��<a href="userMove.do?action=showMove">�ƶ��û�</a>��
                        &nbsp;��<a href="officeMove.do?action=showMove">�ƶ���λ</a>��
                        &nbsp;��<a href="#" onclick="expandTree(foldersTree);">չ��</a>��
                        &nbsp;��<a href="#" onclick="collapseTree(1);">����</a>��</td>
          </td>
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
      <br> <TABLE border=5 align="left" borderColor=EECCB4 borderlight="green">
        <TBODY>
          <TR>
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
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��λ�û�������Թ���˵�λ�е������û���<br>
    </font>
    </td>
  </tr>
</table>
</form>
</body>
</html>
