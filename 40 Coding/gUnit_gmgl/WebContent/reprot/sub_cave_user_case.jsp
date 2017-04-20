<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="../common/taglibs.jsp"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
<title>北京公墓管理系统</title>
<link rel="icon" href="${pageContext.request.contextPath}/favicon.ico" type="image/x-icon" media="screen" />
<link rel="shortcut icon" href="${pageContext.request.contextPath}/favicon.ico" type="image/x-icon" media="screen" />
<script type="text/javascript" src="${pageContext.request.contextPath}/jscript/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jscript/jquery-easyui-1.3.2/jquery-1.8.0.min.js"></script>
<link href="../css/css.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">

function autoIframe() {
	var ifm= document.getElementById("iframepage");
	var subWeb = document.frames ? document.frames["iframepage"].document : ifm.contentDocument;
	if(ifm != null && subWeb != null) {
		ifm.height = subWeb.body.scrollHeight;
	}
} 

function doSubmit(){
	var ifm= document.getElementById("iframepage");
	var action = "../reportJsp/showReport.jsp?raq=/sub_cave_user_case.raq";
	action += "&org_id="+"<c:out value='${param.org_id}' />";
	action += "&org_name="+"<c:out value='${param.org_name}' />";
	var selectdate = $("#selectdate").val();
	if(selectdate != ''){
		action += "&create_date="+selectdate;
	}
	ifm.src = action;
}
</script>
</head>
 
<body style="background-color:transparent">
<table width="100%" border="0" cellspacing="0" cellpadding="0" height="100%">
  <tr>
    <td width="11" valign="top" class="td-bg"><img src="../images/right-1.jpg" /></td>
    <td align="center" valign="top" >
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="31" align="left" valign="middle" style="background:url(../images/right-3.jpg)"><img src="../images/right-4.jpg" width="9" height="8" align="absmiddle" /> 当前位置  &gt; 综合统计 &gt; 土地使用情况统计</td>
      </tr>
      <tr>
        <td bgcolor="#FFFFFF" style="font-size:12px;">&nbsp;</td>
      </tr>
    </table>
	<table width="98%" cellpadding="0" cellspacing="1" bgcolor="#a6c6da">
          <tr>
              <td align="right" height="35" bgcolor="#D4E5F4">统计月份：</td>
              <td align="left" bgcolor="#FFFFFF">
              	<input name="selectdate" type="text" class="Wdate" id="selectdate" onfocus="WdatePicker({dateFmt:'yyyy-MM',isShowWeek:true,readOnly:true})" 
					            		value="<fmt:formatDate value='${param.selectdate}' pattern="yyyy-MM" />" />
              </td>
          </tr>
          <tr>
              <td colspan="2"  height="35" colspan="4" align="center" bgcolor="#FFFFFF">
                  <input name="button" type="button" onclick="doSubmit();" class="button-z" id="button3" value="查询"/>
              </td>
          </tr>
      </table><br/>
	  <iframe onLoad="autoIframe();" id="iframepage" name="iframepage" frameBorder=0 scrolling=no width="98%" 
      		src="../reportJsp/showReport.jsp?raq=/sub_cave_user_case.raq&org_id=<c:out value='${param.org_id}' />&org_name=<c:out value='${param.org_name}' />" ></iframe>
</body>
</html>