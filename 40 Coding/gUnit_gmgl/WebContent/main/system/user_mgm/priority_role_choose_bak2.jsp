<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
<head>
<title>分配权限</title>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<meta http-equiv="Cache-Control" content="no-store"/>
<meta http-equiv="Pragma" content="no-cache"/>
<meta http-equiv="Expires" content="0"/>

<script src="../../../script/ua.js"></script>
<script src="../../../script/ftiens4.js"></script>
<script src="../../../js/jquery-1.2.6.js"></script>
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
	var newObj = insDoc(parentfolderObject, gLnk("S", itemLabel, "javascript:parent.op()"));
	newObj.prependHTML = "<td valign=middle><input type=checkbox id="+checkBoxDOMId+" style='display:none'>"
	newObj.prependHTML += "<a href='javascript:' style='cursor: default'><img class='checkboxImg' cid='" + checkBoxDOMId +"' id='" + checkBoxDOMId + "_c_img' src='../../../script/checkbox/chbox_a.gif' style='vertical-align: middle;' border='0'></a>"
	newObj.prependHTML += "</td>"
	
	cBoxIdAndGLnkMap[checkBoxDOMId] = newObj;
	return newObj;
}

<c:out value="${prioTree}" escapeXml="false"/>

function clearCheckBox(){
	$(":checkbox").attr( 'checked', false )
}
function initCheckBoxByIds(str, idPostfix){
	var strArr = str.split(",")
	for(var i = 0; i < strArr.length; i++){
		$("#" + strArr[i] + (idPostfix ? idPostfix : '')).attr( 'checked', true );
	}
}

var checkBoxflags = {};
function selectOneCheckBox(cboxId, checked){
	if(checked){
		if(checkBoxflags[cboxId] == null){
			checkBoxflags[cboxId] = 1;
		}else{
			checkBoxflags[cboxId]++;
		}
	}else{
		if(checkBoxflags[cboxId] != null){
			if(checkBoxflags[cboxId] > 0){
				checkBoxflags[cboxId]--;
			}
		}
	}
		
	var checkNum = checkBoxflags[cboxId];
	var checked = checkNum > 0 ? true : false;
	
	$("#" + cboxId).attr( 'checked', checked );
	var gLnk = cBoxIdAndGLnkMap[cboxId];
	if(gLnk){
		$("#itemTextLink" + gLnk.id).css('color', checked ? 'blue':'');		
	}
	changeCheckboxImg(cboxId, checkNum);
	return checked;
}
function selectCheckBoxs(cboxIds, checked){
	var cboxIdArr = cboxIds.split(",")
	for(var i = 0; i < cboxIdArr.length; i++){
		if(cboxIdArr[i]){
			selectOneCheckBox(cboxIdArr[i], checked);
		}
	}
}

function changeCheckboxImg(cboxId, checkNum){
	if(checkNum <= 0){
		$("#" + cboxId + "_c_img").attr('src', '../../../script/checkbox/chbox_a.gif');
	}else if(checkNum > 1){
		if(uPrios[cboxId]){
			$("#" + cboxId + "_c_img").attr('src', '../../../script/checkbox/chbox_c.gif');
		}else{
			$("#" + cboxId + "_c_img").attr('src', '../../../script/checkbox/chbox_d.gif');
		}
	}else if(checkNum == 1){
		if(uPrios[cboxId]){
			$("#" + cboxId + "_c_img").attr('src', '../../../script/checkbox/chbox_e.gif');	
		}else{
			$("#" + cboxId + "_c_img").attr('src', '../../../script/checkbox/chbox_b.gif');
		}
	}
}

var uPrios = {};
var uRoles = {};
var ROLE_ID_POSTFIX = '_r';

function getIdWithPostfix(idStr){
	var idAndPof = idStr.split('_');
	return idAndPof[0];
}
function initPrioAndRole(userPrios, userSystemRole){
	var prios = userPrios.split(",")
	for(var i = 0; i < prios.length; i++){
		if(prios[i] != ''){
			uPrios[prios[i]] = true;
			$("#" + prios[i]).css("background-color", "C8E2F3");
		}
	}
	selectCheckBoxs(userPrios, true);
	
	initCheckBoxByIds(userSystemRole, ROLE_ID_POSTFIX);
	var roles = userSystemRole.split(",")
	for(var i = 0; i < roles.length; i++){
		if(roles[i] != ''){
			uRoles[roles[i]] = true;
		}
	}
	
	var userRolesPriority = '<c:out value="${userRolesPriority}"/>';
	selectCheckBoxs(userRolesPriority, true);
}
function initCategory(){
	var selectLink = new SelectLink(true, 'text');
	generateExpandTreeSelectObj(foldersTree, 'expandTreeSelect', function(){
		if($('#priLink').attr('checked')){
			selectLink.changeSelectByOthSelect('category', 'expandTreeSelect', true);
		}
	});
	
	var categoryTrMap = {};
	$('.roleTBody tr').each(function(index, domEle){
		var category = $(domEle).attr('category');
		if(!category){
			category = '_p_empty';
		}
		var trArr = categoryTrMap[category]
		if(!trArr){
			trArr = [];
			categoryTrMap[category] = trArr;
		}
		trArr[trArr.length] = domEle;
	});
	
	$('#category').change(function(){
		if($('#priLink').attr('checked')){
			selectLink.changeSelectByOthSelect('expandTreeSelect', 'category', true);
		}
		var opt = this.options[this.selectedIndex];
		if(opt.value){
			for(var key in categoryTrMap){
				$(categoryTrMap[key]).css('display', 'none');
			}
			$(categoryTrMap[opt.text]).css('display', 'inline');
		}else{
			for(var key in categoryTrMap){
				$(categoryTrMap[key]).css('display', 'inline');
			}
		}
	});
	$('#priLink').click(function(){
		if(this.checked){
			selectLink.changeSelectByOthSelect('expandTreeSelect', 'category', true);
		}
	});
	selectLink.changeSelectByOthSelect('expandTreeSelect', 'category', true);
}
function doOnLoad(){
    expandTree(foldersTree);
	//clearCheckBox();
	initCategory();
	
	<c:if test="${empty param.fromOpener}">
		var userSystemRole = '<c:out value="${userSystemRole}"/>';
		var userPrios = '<c:out value="${userPrios}"/>';
	</c:if>
	<c:if test="${not empty param.fromOpener}">
		var userSystemRole = $(window.opener.document).find('#systemRole').val();
		var userPrios = $(window.opener.document).find('#priority').val();
	</c:if>
	
	initPrioAndRole(userPrios, userSystemRole)
		
	/*$(".priosTable :checkbox").click(function() {
		uPrios[this.id] = uPrios[this.id] == null ? true : !uPrios[this.id]
		if(uPrios[this.id]){
			$(this).css("background-color", "C8E2F3");
		}else{
			$(this).css("background-color", "");
		}
		
		var rCheck = selectOneCheckBox(this.id, uPrios[this.id])
		return rCheck == this.checked;
	});*/
	
	$(".priosTable .checkboxImg").click(function() {
		var priId = $(this).attr('cId');
		uPrios[priId] = uPrios[priId] == null ? true : !uPrios[priId]
		var rCheck = selectOneCheckBox(priId, uPrios[priId])
	});
	
	$(".roleTBody :checkbox").click(function() {
		var id = getIdWithPostfix(this.id);
		uRoles[id] = uRoles[id] == null ? true : !uRoles[id];
		selectCheckBoxs($(this).attr("prios"), this.checked);
	});
}
function getIdStrFromObj(obj, hasComma){
	var idStr = hasComma ? ',':'';
	for (var key in obj){
		if(obj[key]){
			idStr += (key + ',');
		}
  	}
	return hasComma ? (idStr == ',' ? '' : idStr) : idStr.substr(0, idStr.length - 1);
}
function doSubmit() {
	<c:if test="${empty param.fromOpener}">
		$('#priority').val(getIdStrFromObj(uPrios, true));
		$('#systemRole').val(getIdStrFromObj(uRoles, false));
		$('#rpForm').attr('action', 'updateSystemRoleAndPriority.do?doMethod=updateSystemRoleAndPriority');
		$('#rpForm').submit();
	</c:if>
	<c:if test="${not empty param.fromOpener}">
		$(window.opener.document).find('#priority').val(getIdStrFromObj(uPrios, true));
		$(window.opener.document).find('#systemRole').val(getIdStrFromObj(uRoles, false));
		window.close();
	</c:if>
}
</script>
</head>

<body onLoad="doOnLoad()">
<form method="post" id="rpForm" action="">
	<input name="id" type="hidden" value='<c:out value="${param.id}"/>'/>
	<input id="priority" name="priority" type="hidden" value='<c:out value="${userPrios}"/>'/>
	<input id="systemRole" name="systemRole" type="hidden" value='<c:out value="${userSystemRole}"/>'/>
</form>
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="11" background="../../../images/images_32.jpg"><img src="../../../images/content_left.gif" width="11" height="51"></td>
    <td height="51" background="../../../images/images_32.jpg">
	    <table width="70%" border="0" cellspacing="0" cellpadding="0">
	      <tr>
	        <td width="22" height="16" align="center"><img src="../../../images/d.gif" width="14" height="14"></td>
	        <td valign="bottom"> 当前位置：用户管理 → <b>分配权限</b></td>
	      </tr>		
	    </table>
    </td>
  </tr>
  <tr>
    <td background="../images/images_481.jpg">&nbsp;</td>
    <td valign="top" height="100%">
   	 	
	<table width="95%" height="100%" border="0" >
	    <tr> 
		  	<td colspan="4" align="right">
		  		<a href="javascript:doSubmit();"><img src="<c:url value="/images/but-qd.gif"/>" width="55" height="25" border="0"></a>
      			<a href="javascript:window.close();"><img src="<c:url value="/images/but0qx.jpg"/>" width="55" height="25" border="0"></a>
		  	</td>
	  	</tr>
	<tr>
		<td width="50%" valign="top"  height="100%">
		<table>
			<tr>
				<td align="left" colspan="2"><strong>请选择角色</strong></td>	
			</tr>
			<tr>
				<td>分类：</td>
				<td align="left">
					 <select id="category" style="vertical-align: middle;">
					 	<option value=''>全部</option>
						<c:forEach items="${rootChildrenPrioritys}" var="pri" varStatus="status">
							<option value='<c:out value="${pri.value}"/>'><c:out value="${pri.value}"/></option>
						</c:forEach>
						<option value='跨子系统'>跨子系统</option>
					</select>
					<span style="vertical-align: middle;">联动</span><input id="priLink" type="checkbox" checked="checked" style="vertical-align: middle;">
				</td>
			</tr>
		</table>
		<div style="overflow: auto; height:90%; width: 100%" >
			<TABLE style="border: 1px thin solid; font:12px" width="100%" cellpadding="1" cellspacing="1"  >
			  	<thead class="fixedHeader">
				  	<tr height="26" align="center" nowrap="true" >
				  		<td dataType ="VARCHAR" width="7%" class="td-04"/>
				        <td dataType ="VARCHAR" width="10%" class="td-04">序号</td>                    
				        <td dataType ="VARCHAR" width="30%" class="td-04">角色名称</td>  
				        <td dataType ="VARCHAR" width="20%" class="td-04">分类</td>
				        <td dataType ="VARCHAR" width="33%" class="td-04">角色描述</td>          
				  	</tr>   
			 	</thead>
			 
			 	<TBODY id ='listTableBody' name= "listTableBody" class="roleTBody">
			    	<c:forEach var="role" items="${roles}"  varStatus="ctIndex" >
					  	<tr height="26" class="list_tr1" category="<c:out value="${role.category}" />"> 											  		
					  	<tr height="26" align="center" class="td-01" category="<c:out value="${role.category}" />">
	              			<td width="7%" align="center">		  				
				  				<input type="checkbox" name="roleIds" id="<c:out value='${role.id}_r'/>" prios='<c:out value="${role.priority}" />'>
				  			</td>
					  		<td width="10%" align="center"><c:out value='${ctIndex.index+1}'/></td>	
		            		<td width="30%" align="left" ><c:out value="${role.name}" /></td>
		            		<td width="20%" align="left" ><c:out value="${role.category}" /><c:if test="${empty role.category}">无</c:if></td>		
							<td width="33%" align="left" ><c:out value="${role.description}" /></td>																										            									           													            								            
		         		</tr>
			    	</c:forEach>	
			  	</TBODY>
			 </TABLE>
		 </div>
		 </td>
		<td width="20px" align="center" valign="top" class="line-mid">&nbsp;</td>
		<td width="10px" align="center" valign="top">&nbsp;</td>
		<td width="43%" valign="top" height="100%" style="margin-top:2px;">
			<select id="expandTreeSelect" style="vertical-align: middle;">	
			</select>
			<div style="overflow: auto; height: 95%; width: 100%" >
				<table class="priosTable">
					
					<tr><td>
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
			              in your browser. </noscript> 
					</td></tr>
				</table>
			</div>
          </td>
		</tr>
	</table>
	</td>
		</tr>
	</table>
    
</body>
</html>