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

	foldersTree = gFld("<b>所有部门</b>", "")
   t1=insFld(foldersTree, gFld("<b>所有部门</b>", ""))
      t2=generateCheckBox1(t1, "北京市民政局", "2", "officeSelect.do?action=detail&id=2", "true")
            t3=insFld(t2, gFld("<b>职能处室</b>", ""))
                  t4=generateCheckBox1(t3, "办公室", "4", "officeSelect.do?action=detail&id=4", "true")
                        t5=insFld(t4, gFld("<b>职能处室</b>", ""))
               generateCheckBox1(t5, "2科", "78", "officeSelect.do?action=detail&id=78")
               generateCheckBox1(t5, "1科", "80", "officeSelect.do?action=detail&id=80")
                        t5=insFld(t4, gFld("<b>二级单位</b>", ""))
               generateCheckBox1(t5, "3科", "82", "officeSelect.do?action=detail&id=82")
               generateCheckBox1(t5, "4科", "84", "officeSelect.do?action=detail&id=84")
                        t5=insFld(t4, gFld("<b>直属单位</b>", ""))
               generateCheckBox1(t5, "6科", "88", "officeSelect.do?action=detail&id=88")
               generateCheckBox1(t5, "5科", "86", "officeSelect.do?action=detail&id=86")
         generateCheckBox1(t3, "政策法规处", "6", "officeSelect.do?action=detail&id=6")
         generateCheckBox1(t3, "优抚处（市双拥工作领导小组办公室）", "8", "officeSelect.do?action=detail&id=8")
         generateCheckBox1(t3, "见义勇为权益保护处", "10", "officeSelect.do?action=detail&id=10")
         generateCheckBox1(t3, "安置处（市政府复退军人安置办公室）", "12", "officeSelect.do?action=detail&id=12")
         generateCheckBox1(t3, "救灾救济处", "14", "officeSelect.do?action=detail&id=14")
         generateCheckBox1(t3, "基层政权建设处", "16", "officeSelect.do?action=detail&id=16")
         generateCheckBox1(t3, "社区工作处（市社区服务工作领导小组办公室）", "18", "officeSelect.do?action=detail&id=18")
         generateCheckBox1(t3, "区划管理处", "20", "officeSelect.do?action=detail&id=20")
         generateCheckBox1(t3, "婚姻管理处（北京市人民政府婚姻登记处）", "22", "officeSelect.do?action=detail&id=22")
         generateCheckBox1(t3, "行政保卫处", "24", "officeSelect.do?action=detail&id=24")
         generateCheckBox1(t3, "计划财务处", "26", "officeSelect.do?action=detail&id=26")
         generateCheckBox1(t3, "审计处", "28", "officeSelect.do?action=detail&id=28")
         generateCheckBox1(t3, "组织人事处", "30", "officeSelect.do?action=detail&id=30")
         generateCheckBox1(t3, "宣传教育处", "32", "officeSelect.do?action=detail&id=32")
         generateCheckBox1(t3, "工会和团委（合署办公）", "34", "officeSelect.do?action=detail&id=34")
         generateCheckBox1(t3, "机关党委", "36", "officeSelect.do?action=detail&id=36")
         generateCheckBox1(t3, "老干部处", "38", "officeSelect.do?action=detail&id=38")
         generateCheckBox1(t3, "测试用例", "142", "officeSelect.do?action=detail&id=142")
         generateCheckBox1(t3, "测试单位", "144", "officeSelect.do?action=detail&id=144")
                  t4=generateCheckBox1(t3, "dd0", "162", "officeSelect.do?action=detail&id=162", "true")
                        t5=insFld(t4, gFld("<b>职能处室</b>", ""))
               generateCheckBox1(t5, "111", "202", "officeSelect.do?action=detail&id=202")
                  t4=generateCheckBox1(t3, "2", "228", "officeSelect.do?action=detail&id=228", "true")
                        t5=insFld(t4, gFld("<b>职能处室</b>", ""))
               generateCheckBox1(t5, "2", "230", "officeSelect.do?action=detail&id=230")
         generateCheckBox1(t3, "112", "232", "officeSelect.do?action=detail&id=232")
            t3=insFld(t2, gFld("<b>二级单位</b>", ""))
         generateCheckBox1(t3, "市军队离休退休干部安置办公室", "40", "officeSelect.do?action=detail&id=40")
         generateCheckBox1(t3, "市社会团体登记管理办公室", "42", "officeSelect.do?action=detail&id=42")
         generateCheckBox1(t3, "市老龄协会", "44", "officeSelect.do?action=detail&id=44")
         generateCheckBox1(t3, "市社会福利事业管理处", "46", "officeSelect.do?action=detail&id=46")
         generateCheckBox1(t3, "市殡葬管理处", "48", "officeSelect.do?action=detail&id=48")
         generateCheckBox1(t3, "民政事业建设处", "50", "officeSelect.do?action=detail&id=50")
         generateCheckBox1(t3, "市民政工业总公司", "52", "officeSelect.do?action=detail&id=52")
            t3=insFld(t2, gFld("<b>直属单位</b>", ""))
         generateCheckBox1(t3, "市福利彩票发行中心", "54", "officeSelect.do?action=detail&id=54")
         generateCheckBox1(t3, "市民政干校", "56", "officeSelect.do?action=detail&id=56")
         generateCheckBox1(t3, "市军供站", "58", "officeSelect.do?action=detail&id=58")
         generateCheckBox1(t3, "市征地超转人员管理办公室", "60", "officeSelect.do?action=detail&id=60")
         generateCheckBox1(t3, "市接收捐赠事务管理中心", "62", "officeSelect.do?action=detail&id=62")
         generateCheckBox1(t3, "市区县福利生产办公室", "64", "officeSelect.do?action=detail&id=64")
         generateCheckBox1(t3, "住宅建设办公室", "66", "officeSelect.do?action=detail&id=66")
         generateCheckBox1(t3, "劳服公司", "68", "officeSelect.do?action=detail&id=68")
         generateCheckBox1(t3, "《北京社会报》社", "70", "officeSelect.do?action=detail&id=70")
         generateCheckBox1(t3, "培训中心", "72", "officeSelect.do?action=detail&id=72")
         generateCheckBox1(t3, "骨伤科医院", "74", "officeSelect.do?action=detail&id=74")
         generateCheckBox1(t3, "市假肢矫形技术中心", "76", "officeSelect.do?action=detail&id=76")

function generateChooseValue() {
	if (getElById('32').checked) { return "宣传教育处"; }
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
		window.alert("必须首先选择单位！");
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
           	  	【<a href="officeAdd.do?action=showAdd">创建新单位</a>】
 	  		&nbsp;【<a href="#" onclick="onSubmit();">批量删除</a>】
			&nbsp;【<a href="#" onclick="location.reload();">刷新</a>】
                        &nbsp;【<a href="userMove.do?action=showMove">移动用户</a>】
                        &nbsp;【<a href="officeMove.do?action=showMove">移动单位</a>】
                        &nbsp;【<a href="#" onclick="expandTree(foldersTree);">展开</a>】
                        &nbsp;【<a href="#" onclick="collapseTree(1);">收缩</a>】</td>
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
      size=2 face="Arial, Helvetica, sans-serif">单位列表</FONT></TD>
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
        帮助：支持机构的无限级创建，后面的5个图标：编辑单位、创建子单位、移动单位、删除单位、单位用户管理。<br>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;移动单位是为了支持单位结构的调整，方便于今后进行单位重组。<br>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;单位编号才是单位的唯一标识，单位名称可能会重复。<br>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;单位用户管理可以管理此单位中的所有用户。<br>
    </font>
    </td>
  </tr>
</table>
</form>
</body>
</html>
