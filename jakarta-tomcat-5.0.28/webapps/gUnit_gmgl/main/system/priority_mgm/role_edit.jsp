<%@ page contentType="text/html; charset=GBK" %>
<%@ include file="../../../common/taglibs.jsp"%>
<html>
<head>
<title>Untitled Document</title>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<meta http-equiv="Cache-Control" content="no-store"/>
<meta http-equiv="Pragma" content="no-cache"/>
<meta http-equiv="Expires" content="0"/>

<link href="../../../css/css.css" rel="stylesheet" type="text/css">
<style type="text/css">
     A {
         font-family:Verdana, Arial,Helvetica;
         font-size:11px;
         font-weight:normal;
         text-decoration:none;
         color: black;
     }
</style>
<script src="../../../script/functionforcheck.js" language="JScript"></script>
<script src="../../../js/jquery-1.2.6.js"></script>

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

var cBoxIdAndGLnkMap = {};

function generateCheckBox(parentfolderObject, itemLabel, checkBoxDOMId) {
	var newObj = insDoc(parentfolderObject, gLnk("S", itemLabel, "javascript:"));
	newObj.prependHTML = "<td valign=middle><input type=checkbox id="+checkBoxDOMId+"></td>"
	
	cBoxIdAndGLnkMap[checkBoxDOMId] = newObj;
	return newObj;
}

<c:out value="${prioTree}" escapeXml="false"/>

function addErrInfo(eleId, info){
	$('#' + eleId).after("<span style='color: red;' class='errInfo'>" + info + "</span>");
}
function removeErrInfo(eleId){
	$('#' + eleId + ' ~ .errInfo').remove();
}
function removeAndAddErrInfo(eleId, info){
	removeErrInfo(eleId);
	addErrInfo(eleId, info);
}
function doSubmit() {
	var IsValid = true;
	if(isEmpty(myform.name.value)){
		removeAndAddErrInfo('name', '未填写角色名称');
		IsValid = false;
	}else if(!checkLength(myform.name.value, 0, 15)){
		removeAndAddErrInfo('name', '角色名称过长（小于15字符)');
		IsValid = false;
	}else{
		removeErrInfo('name');
	}
	
	if(!checkLength(myform.description.value, 0, 150)){
		removeAndAddErrInfo('description', '角色描述过长（小于150字符）');
		IsValid = false;
	} else {
		removeErrInfo('description');
	}
	
	var pri = ',';
	$('.prios :checkbox:checked').each(function(index, domEle){
		pri += (domEle.id + ',');
	});
	if(pri == ','){
		pri = '';
		removeAndAddErrInfo('prilbl', '未选择权限');
		IsValid = false;
	}else{
		removeErrInfo('prilbl');
	}
	document.myform.priority.value = pri;
	if(IsValid){
		<c:if test="${not subRole}">
			document.myform.action = "saveOrUpdateRole.do?doMethod=saveOrUpdateRole";
		</c:if>
		<c:if test="${subRole}">
			document.myform.action = "saveOrUpdateSubRole.do?doMethod=saveOrUpdateRole";
		</c:if>
		myform.submit();
	}
}
function doCancel(){
	<c:if test="${not subRole}">
		window.location = "roleList.do?doMethod=roleList";
	</c:if>
	<c:if test="${subRole}">
		window.location = "roleList.do?doMethod=subRoleList";
	</c:if>
}

function doOnLoad(){
	
    expandTree(foldersTree);
    var selectLink = new SelectLink(true, 'text');
	generateExpandTreeSelectObj(foldersTree, 'expandTreeSelect', function(){
		if($('#priLink').attr('checked')){
			selectLink.changeSelectByOthSelect('category', 'expandTreeSelect', true);
		}
	});
	$('#category').change(function(){
		if($('#priLink').attr('checked')){
			selectLink.changeSelectByOthSelect('expandTreeSelect', 'category', true);
		}
	});
	$('#priLink').click(function(){
		if(this.checked){
			selectLink.changeSelectByOthSelect('expandTreeSelect', 'category', true);
		}
	});
	
	<c:if test="${not readonly}">
		selectLink.changeSelectByOthSelect('expandTreeSelect', 'category', true);
	</c:if>
	<c:if test="${readonly}">
		var ops = $('#expandTreeSelect').attr('options');
		for(var i = 0; i < ops.length; i++){
			if(ops[i].text == '<c:out value="${ajRole.category}"/>'){
		 		ops[i].setAttribute('selected', true);
		 		break;
		 	}
		}
		$('#expandTreeSelect').get(0).fireEvent('onchange');
	</c:if>
	
	var pri = '<c:out value="${ajRole.priority}"/>';
	var strArr = pri.split(",")
	for(var i = 0; i < strArr.length; i++){
		if(strArr[i]){
			$("#" + strArr[i]).attr( 'checked', true );
			var gLnk = cBoxIdAndGLnkMap[strArr[i]];
			if(gLnk){
				$("#itemTextLink" + gLnk.id).css('color', 'blue');
			}
		}
	}
	
	$('.prios :checkbox').click(function(){
		var gLnk = cBoxIdAndGLnkMap[this.id];
		if(this.checked){
			$("#itemTextLink" + gLnk.id).css('color', 'blue');
		}else{
			$("#itemTextLink" + gLnk.id).css('color', '');
		}
	});
}
</script>
</head>

<body  leftmargin="0" topmargin="0" onLoad="doOnLoad()">
<form name="myform" method="post">
<body>
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="11" height="31" valign="top" class="td-bg"><img src="../../../images/right-1.jpg" /></td>
    <td align="center" valign="top" ><table width="100%" border="0" cellpadding="0" cellspacing="0" class="word-8">
      <tr>
        <td height="31" align="left" valign="middle" style="background:url(../../../images/right-3.jpg)"><img src="../../../images/right-4.jpg" width="9" height="8" align="absmiddle" /> 当前位置 &gt; 系统管理 &gt; 角色管理</td>
      </tr>
    </table>
	</td>
  </tr>
  <tr>
    <td >&nbsp;</td>
    <td valign="top">
	<table border="0" cellspacing="0" cellpadding="0" width="100%">
		<tr>
			<td>&nbsp;</td>
		</tr>		
	</table>
    <input type="hidden" name="id" value="<c:out value="${ajRole.id}" />">
	<input name="priority" type="hidden" value="">
	
<table width="90%" border="0" align="left" cellpadding="0" cellspacing="0">
		<tr>
      		<td align="right" colspan="4" style="vertical-align: middle;">
      			<table cellpadding="0" cellspacing="0">
	      			<tr>
	      				<td>
	      					<c:if test="${not readonly}">
					        	<a href="javascript:doSubmit();"><img src="<c:url value="/images/but-qd.gif"/>" width="55" height="25" border="0"></a>
	      						<a href="javascript:doCancel();"><img src="<c:url value="/images/but0qx.jpg"/>" width="55" height="25" border="0"></a>
				          	</c:if>
				          	<c:if test="${readonly}">
					        	<a href="javascript:doCancel();"><img src="<c:url value="/images/but0qx.jpg"/>" width="55" height="25" border="0"></a>
				          	</c:if>
	      				</td>
	      				<td width="50px">&nbsp;</td>
	      			</tr>
      			</table>
      		</td>
      	</tr>
  	<tr>
       <td height="459" width="45%" align="right" valign="top" class="td18">
      <table width="100%" border="0" cellpadding="0" cellspacing="0" >
      	
        <tr>
          <td align="left">
            <strong>创建新角色：(<font color="red">*</font>为必填项)
            </strong>
          </td>
        </tr>
      </table>
      <table width="100%" border="0" cellpadding="1" cellspacing="1" bgcolor="a8d1eb">
      	<tr>
          <td height="20" class="td-01" colspan="2">创建人：
          	<c:out value="${ajRole.creatorName}" />
          	<c:if test="${empty ajRole.creatorId}"><c:out value="${loginUser.name}" /></c:if>
          </td>          
        </tr>
        <tr >
          <td width="20%" height="22" class="td-01" align="center">名称<font color="red">*</font>：</td>
          <td width="80%" class="td-02"> 
          	<c:if test="${not readonly}">
	          	<input id="name" name="name" type="text" value="<c:out value="${ajRole.name}" />" maxlength="15" class="input">
          	</c:if>
          	<c:if test="${readonly}">
	        	<c:out value="${ajRole.name}"/>
          	</c:if>
          </td>
        </tr>
        <tr >
          <td class="td-01" height="22" align="center">子系统：</td>
          <td class="td-02">
          		<c:if test="${not readonly}">
	          		<select id="category" name="category" style="vertical-align: middle;">
	          			<c:forEach items="${rootChildrenPrioritys}" var="pri" varStatus="status">
	          				<option value='<c:out value="${pri.value}"/>' <c:if test='${pri.value eq ajRole.category }'>selected="true"</c:if> ><c:out value="${pri.value}"/></option>
	          			</c:forEach>
	          			<option value='跨子系统' <c:if test='${"跨子系统" eq ajRole.category }'>selected="true"</c:if>>跨子系统</option>
	          		</select>
	          		<span style="vertical-align: middle;">联动</span><input id="priLink" type="checkbox" style="vertical-align: middle;" checked="checked">
          		</c:if>
          		<c:if test="${readonly}">
          			<c:if test="${empty ajRole.category}">无</c:if>
	          		<c:out value="${ajRole.category}"/>
          		</c:if>
        	</td>
        </tr>
        <tr >
          <td class="td-01" align="center">描述：</td>
          <td valign="top" class="td-02"> 
          	<textarea id="description" name="description" cols="30" rows="8" wrap="hard" class="textarea" <c:if test='${readonly}'>readonly="readonly"</c:if>><c:out value="${ajRole.description}" /></textarea>
           </td>
        </tr>
        
      </table>
      </td>
      <td width="10" align="center" valign="top" class="line-mid">&nbsp;</td>
      <td width="10" align="center" valign="top">&nbsp;</td>
      <td valign="top" width="43%">
			<TABLE  border=0 width="100%">
                <TR>
                  <TD><strong id="prilbl">请选择：权限<font color="red">*</font>&nbsp;</strong></TD>
                </TR>
                <TR><td>
	                  <select id="expandTreeSelect" style="vertical-align: middle;" >
	                  </select>
				 </td>
                </TR>
                <TR>
                	<TD align=center class="prios">
	                    <a href="http://www.treemenu.net/"/>
	                    <script>initializeDocument()</script> 
                	</TD>
                </TR>
            </TABLE>
      </td>
  </tr>
</table>
      </td>
  </tr>
</table>
</form>
</body>
</html>
