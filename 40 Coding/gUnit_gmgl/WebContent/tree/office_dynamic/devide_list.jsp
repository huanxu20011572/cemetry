<%@ page contentType="text/html; charset=GBK" %>
<%@ include file="../../common/taglibs.jsp"%>
<%@ include file="../../common/js_common.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<link href="../css/css.css" rel="stylesheet" type="text/css">
<script src="../../script/calendar.js" language="javascript"></script>
<title></title>
<script>
function doQuery(){
	var form = document.queryForm;
	var startAdjustDate = form.startAdjustDate.value;
	var endAdjustDate = form.endAdjustDate.value;
	var startEffectDate = form.startEffectDate.value;
	var endEffectDate = form.endEffectDate.value;
	if(Date.parse(startAdjustDate.replace("-","/"))> Date.parse(endAdjustDate.replace("-","/"))){
		alert("调整开始时间大于调整结束时间，请检查!");
		  return false;
	}
	
	
	if(Date.parse(startEffectDate.replace("-","/"))> Date.parse(endEffectDate.replace("-","/"))){
		alert("生效开始时间大于生效结束时间，请检查!");
		  return false;
	}
	

	
	form.action = "../tree/doAddAdjust.do?method=list&adjustType=50162";
	form.submit();
}
function doMerger(){

	var url = "office_dynamic/devide_info.jsp";
	
	 location.replace(url);
	
	
}


</script>
</head>


<body>
<form name="queryForm" id="queryForm" action="" method="post">

		<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
						<td width="14" height="25" align="center"  style="padding-bottom:5px;" background="../images/images_49.jpg"><img src="../images/d.gif" width="14" height="14"></td>
						<td width="1191" background="../images/images_49.jpg">当前位置：区划管理->区划拆分->查询</span> </td>
					<%--	<td width="1219"> 当前位置：区划管理->区划合并->查询</td>--%>
					  <td width="10" align="center"><iframe width="100%" src="../images/images_32.jpg" height="31" frameborder="0" scrolling="no"></iframe></td>
				</tr>
		</table>	
		
	</table>	

	<br>

	   <table width="99%" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
            <td width="45" align="left" background="../images/images_49.jpg"><img src="../images/images_48.jpg" width="38" height="40"></td>
            <td width="1191" background="../images/images_49.jpg"><span class="title"> 查询部分：</span> </td>
            <td width="16" align="right" background="../images/images_49.jpg"><img src="../images/images_52.jpg" width="16" height="40"></td>
          </tr>
      </table>

             
	 <table width="99%" border="0" cellpadding="1" cellspacing="1" bgcolor="a8d1eb">
	 
                <tr>
                  <td height="41" align="center" class="td-01" width="13%">调整级别：</td>
                  <td class="td-02" width="32%">  &nbsp;   <gOS:select name="adjustLevel" items="class{com.topsuntech.gUnit.gEU_bzhhUtil.taglib.BzhhDictListProvide($request,TZJB)}" 
		  keyProperty="key" valueProperty="value" selected="${queryBean.adjustLevel}" styleClass="select"  style="width:88%" onchange="changeType()" >
									<gOS:option key="0" value="---请选择---" />
                  </gOS:select>             </td>
				  <td height="41" align="center" class="td-01" width="12%">调整时间：</td>
			      <td class="td-02" width="43%">  &nbsp; <input name="startAdjustDate" type="text" class="input_txt" size="20" onClick="WdatePicker()" value="<c:out value='${queryBean.startAdjustDate}'/>">至  <input name="endAdjustDate" type="text" class="input_txt" size="20" onClick="WdatePicker()" value="<c:out value='${queryBean.endAdjustDate}'/>">                </td>
                </tr>
				
				<tr>
                  <td height="40" align="center" class="td-01" width="13%">生效时间：</td>
                  <td class="td-02" width="32%" >  &nbsp;  <input name="startEffectDate" type="text" class="input_txt" size="20" onClick="WdatePicker()" value="<c:out value='${queryBean.startEffectDate}'/>">至     <input name="endEffectDate" type="text" class="input_txt" size="20" onClick="WdatePicker()" value="<c:out value='${queryBean.endEffectDate}'/>">            </td>
				  
                
				<td class="td-02" width="43%"  align="center" bordercolorlight="" colspan="2"><input type="button" class="input_btn" value="查询"  onclick="doQuery()"/> &nbsp;&nbsp;&nbsp;     </td>
				 
                </tr>
  </table>


</form>
		
		<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
            		<input name="button" type="button" class="input_btn"  onClick="doMerger()" value="拆分" align="left"/>

          </tr>
        </table>
<br/>
		<table width="99%" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
            <td width="45" align="left" background="../images/images_49.jpg"><img src="../images/images_48.jpg" width="38" height="40"></td>
            <td width="1191" background="../images/images_49.jpg"><span class="title"> 列表部分：</span> </td>
            <td width="16" align="right" background="../images/images_49.jpg"><img src="../images/images_52.jpg" width="16" height="40"></td>
          </tr>
      </table>

					<table width="99%" border="0" cellpadding="1" cellspacing="1" class="td-02">
						<tr>
							<td width="3%" height="26"  align="center" class="td-01">序号</td>
							<td width="9%" align="center" class="td-01">调整级别</td>
							<td width="12%" align="center" class="td-01">调整时间</td>
							<td width="15%" align="center" class="td-01">生效时间</td>
							<td width="10%" align="center" class="td-01">调整人</td>
							<td width="14%" align="center" class="td-01">操作</td>
						</tr>

			<c:forEach var="bean" items="${list}" varStatus="ctIndex">
			<c:if test="${ctIndex.count % 2 == 0}">
			<TR class="td-01">			</c:if>
			<c:if test="${ctIndex.count % 2 != 0}">
			<TR class="td-02">			</c:if>
				<td width="3%" height="37" align="center"><c:out value='${ctIndex.index+1+(page.pageSize*(page.currentPage-1))}'/></td>

				<td width="3%" height="37" align="center"><gOS_shjz:dictValue key="${bean.adjustLevel}" typeName="TZJB" />
				
				
				</td>

				
				
				<td width="14%" align="center">
						<fmt:formatDate value='${bean.adjustDate}' pattern='yyyy-MM-dd'/>				</td>
				<td width="13%" align="center">
					
					<fmt:formatDate value='${bean.effectDate}' pattern='yyyy-MM-dd'/>				</td>
				<td width="14%" align="center">
					<gOS_shjz:shjzUser key="${bean.createUserId}"/>	</td>

				<td width="14%" align="center" valign="middle" class="word-7">
					<a  href="../tree/doAddAdjust.do?method=detail&id=<c:out value='${bean.id}'/>" target="_self">查看</a>				  </td>
		</tr>
	</c:forEach>
</table>
<table width="98%" border="0" cellpadding="0" cellspacing="0" >
      <tr>
        <td align="center"    class="page">
        		<gOS:page name="page" pageName="page" action="../tree/doAddAdjust.do?method=list&adjustType=50162" pageSizeKey="list">
					<gOS:param name="warnLevel"><c:out value="${queryBean.warnLevel}"/></gOS:param> 
					<gOS:param name="startAdjustDate"><c:out value="${queryBean.startAdjustDate}"/></gOS:param> 
				<gOS:param name="endAdjustDate"><c:out value="${queryBean.endAdjustDate}"/></gOS:param> 
					<gOS:param name="startEffectDate"><c:out value="${queryBean.startEffectDate}"/></gOS:param> 
					<gOS:param name="endEffectDate"><c:out value="${queryBean.endEffectDate}"/></gOS:param> 
					<gOS:param name="createUserId"><c:out value="${queryBean.createUserId}"/></gOS:param> 
					
					
				</gOS:page>		</td>
      </tr>
    </table></td>
  </tr>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="28">&nbsp;</td>
  </tr>
</table>
</table>
</body>
</html>