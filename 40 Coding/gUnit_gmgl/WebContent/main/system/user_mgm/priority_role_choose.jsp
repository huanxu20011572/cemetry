<%@ page contentType="text/html; charset=GBK" %>
<%@ include file="../../../common/taglibs.jsp"%>
<html>
<head>
<title>����Ȩ��</title>
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
     .va-middle{
	     vertical-align: middle
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
	newObj.prependHTML += "<a href='javascript:;' style='cursor: default'><img class='checkboxImg' cid='" + checkBoxDOMId +"' id='" + checkBoxDOMId + "_c_img' src='../../../script/checkbox/chbox_a.gif' style='vertical-align: middle;' border='0'></a>"
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
	
	//$("#" + cboxId).attr( 'checked', checked );
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
function refreshRolesFrame(systemRole, currentPage){
	if(systemRole == null){
		systemRole = getIdStrFromObj(uRoles, false);
	}
	$('#rfSystemRole').val(systemRole);
// 	$('#rfCategory').val($('#category').val());
	$('#rfIsSetCreatorId').val(<c:out value='${isSetCreatorId}'/>);
	if(currentPage){
		$('#rfCurrentPage').val(currentPage);
	}
	$('#rolesFrameForm').attr('action', 'showChoosePriorityRole.do?doMethod=showRolesFrame');
	$('#rolesFrameForm').submit();
}
function initPrioAndRole(userPrios, systemRole){
	var prios = userPrios.split(",")
	for(var i = 0; i < prios.length; i++){
		if(prios[i] != ''){
			uPrios[prios[i]] = true;
			$("#" + prios[i]).css("background-color", "C8E2F3");
		}
	}
	selectCheckBoxs(userPrios, true);
	
	//initCheckBoxByIds(systemRole, ROLE_ID_POSTFIX);
	refreshRolesFrame(systemRole);
	
	var roles = systemRole.split(",")
	for(var i = 0; i < roles.length; i++){
		if(roles[i] != ''){
			uRoles[roles[i]] = true;
		}
	}
	
	var userRolesPriority = '<c:out value="${userRolesPriority}"/>';
	selectCheckBoxs(userRolesPriority, true);
}
function initCategory(){
// 	var selectLink = new SelectLink(true, 'text');
	generateExpandTreeSelectObj(foldersTree, 'expandTreeSelect', function(){
// 		if($('#priLink').attr('checked')){
// 			selectLink.changeSelectByOthSelect('category', 'expandTreeSelect', true);
// 		}
	});
	
// 	$('#category').change(function(){
// 		if($('#priLink').attr('checked')){
// 			selectLink.changeSelectByOthSelect('expandTreeSelect', 'category', true);
// 		}
		
// 		refreshRolesFrame(null, 1);
// 	});
// 	$('#priLink').click(function(){
// 		if(this.checked){
// 			selectLink.changeSelectByOthSelect('expandTreeSelect', 'category', true);
// 		}
// 	});
}
function clickRoleCheckbox(chBoxDom){
	var roleId = chBoxDom.id;
	uRoles[roleId] = uRoles[roleId] == null ? true : !uRoles[roleId];
	selectCheckBoxs($(chBoxDom).attr("prios"), chBoxDom.checked);
	//refreshRolesFrame(null, 1);
}
function doOnLoad(){
    expandTree(foldersTree);
	//clearCheckBox();
	initCategory();
	
	var systemRole = '<c:out value="${systemRole}"/>';
	var userPrios = '<c:out value="${userPrios}"/>';
	
	initPrioAndRole(userPrios, systemRole)
	
	$(".priosTable .checkboxImg").click(function() {
		var priId = $(this).attr('cId');
		uPrios[priId] = uPrios[priId] == null ? true : !uPrios[priId]
		var rCheck = selectOneCheckBox(priId, uPrios[priId])
		return false;
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
		$('#systemRole').val(getIdStrFromObj(uRoles, true));
		$('#isAppend').val($(":radio:checked[name='isAppend']").val());
		$('#rpForm').attr('action', 'updateSystemRoleAndPriority.do?doMethod=updateSystemRoleAndPriority');
		$.ajax({
        type: "POST",
        url:"updateSystemRoleAndPriority.do?doMethod=updateSystemRoleAndPriority",
        data:$('#rpForm').serialize(),
        success: function(data) {
              window.close();
          }
      });
	</c:if>
	<c:if test="${not empty param.fromOpener}">
		$(window.opener.document).find('#priority').val(getIdStrFromObj(uPrios, true));
		$(window.opener.document).find('#systemRole').val(getIdStrFromObj(uRoles, false));
		window.close();
	</c:if>
}

function openthis(myurl) {  
window.open(myurl,'newwindow',"height=650,width=1024,left=0,top=0,status=yes,toolbar=no,menubar=no,location=yes,scrollbars=yes");
} 
</script>
</head>

<body onLoad="doOnLoad()">
<form method="post" id="rpForm" >
	<input name="ids" type="hidden" value='<c:out value="${ids}"/>'/>
	<input id="priority" name="priority" type="hidden" />
	<input id="systemRole" name="systemRole" type="hidden"/>
	<input id="isAppend" name="isAppend" type="hidden"/>
</form>
<form method="post" id="rolesFrameForm" target="rolesFrame">
	<input id="rfSystemRole" name="systemRole" type="hidden" />
<!-- 	<input id="rfCategory" name="category" type="hidden" /> -->
	<input id="rfIsSetCreatorId" name="isSetCreatorId" type="hidden" />
	<input id="rfCurrentPage" name="currentPage" type="hidden" />
	<input id="rfPageSize" name="pageSize" type="hidden" value="10"/>
</form>
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="11" background="../../../images/images_32.jpg"><img src="../../../images/content_left.gif" width="11" height="51"></td>
    <td height="51" background="../../../images/images_32.jpg">
	    <table width="70%" border="0" cellspacing="0" cellpadding="0">
	      <tr>
	        <td width="22" height="16" align="center"><img src="../../../images/d.gif" width="14" height="14"></td>
	        <td valign="bottom"> ��ǰλ�ã��û����� �� <b>����Ȩ��</b></td>
	      </tr>		
	    </table>
    </td>
  </tr>
  <tr>
    <td background="../images/images_481.jpg">&nbsp;</td>
    <td valign="top" height="100%">
   	 	
	<table width="95%" height="100%" border="0" >
	    <tr>
		  	<td colspan="4" align="right"  >
		  		<table>
		  			<tr>
		  				<td>
			  				<c:if test="${not empty param.showAppend}">
			  					<input type="radio" name="isAppend" value="true" checked="checked"/>׷��<input type="radio" name="isAppend" value="false"/>����
					    		<span style="margin-left: 10px"/>
			  				</c:if>
				    	</td>
				    	<td>
							<a href="javascript:" onClick="doSubmit(); return false;"><img src="<c:url value="/images/but-qd.gif"/>" width="55" height="25" border="0"></a>
      						<a href="javascript:" onClick="window.close(); return false;"><img src="<c:url value="/images/but0qx.jpg"/>" width="55" height="25" border="0"></a>				    		
				    	</td>
		  			</tr>
		  		</table>
		  	</td>
	  	</tr>
	<tr>
		<td width="50%" valign="top"  height="100%">
			<table>
				<tr>
					<td>ѡ���ɫ:</td>
					<td align="left">
<!-- 						 <select id="category" style="vertical-align: middle;"> -->
<!-- 						 	<option value=''>ȫ��</option> -->
<%-- 							<c:forEach items="${rootChildrenPrioritys}" var="pri" varStatus="status"> --%>
<%-- 								<option value='<c:out value="${pri.value}"/>'><c:out value="${pri.value}"/></option> --%>
<%-- 							</c:forEach> --%>
<!-- 							<option value='����ϵͳ'>����ϵͳ</option> -->
<!-- 						</select> -->
<!-- 						<span style="vertical-align: middle;">����</span><input id="priLink" type="checkbox" checked="checked" style="vertical-align: middle;">&nbsp;&nbsp;&nbsp;<a href="javascript:openthis('showSysList.do?doMethod=showSys&ids=<c:out value="${ids}"/>')">ϵͳ��Ȩ</a> -->
					</td>
				</tr>
			</table>
			<iframe id="rolesFrame" name="rolesFrame" style="overflow: auto; height:70%; width: 100%" marginheight="0" marginwidth="0" frameborder="0" ></iframe>
			<div>
		    	1��<img src="../../../script/checkbox/chbox_b.gif"/ class="va-middle">��ʾ��Ȩ��Ϊ��ɫ������Ȩ�ޣ������Ҫ�޸ģ����޸Ľ�ɫȨ��<br/>
		    	2��<img src="../../../script/checkbox/chbox_e.gif"/ class="va-middle">��ʾ��Ȩ��Ϊֱ����Ȩ��Ȩ�ޣ�����ֱ�����ӻ���ɾ��<br/>
				3��<img src="../../../script/checkbox/chbox_c.gif"/ class="va-middle">��ʾ��Ȩ�޼��ǽ�ɫ����Ȩ��Ҳ��ֱ�������Ȩ��<br/>
				4��<img src="../../../script/checkbox/chbox_d.gif"/ class="va-middle">��ʾ��Ȩ�����������������Ͻ�ɫ����ͬӵ�е�Ȩ��<br/>
				ֻҪ�û�Ȩ�޸�ѡ�����������ĸ���־�����ʾ���û��������Ȩ��
			</div>
		
		<!-- div style="overflow: auto; height:90%; width: 100%" >
			<TABLE style="border: 1px thin solid; font:12px" width="100%" cellpadding="1" cellspacing="1"  >
			  	<thead class="fixedHeader">
				  	<tr height="26" align="center" nowrap="true" >
				  		<td dataType ="VARCHAR" width="7%" class="td-04"/>
				        <td dataType ="VARCHAR" width="10%" class="td-04">���</td>                    
				        <td dataType ="VARCHAR" width="30%" class="td-04">��ɫ����</td>  
				        <td dataType ="VARCHAR" width="20%" class="td-04">����</td>
				        <td dataType ="VARCHAR" width="33%" class="td-04">��ɫ����</td>          
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
		            		<td width="20%" align="left" ><c:out value="${role.category}" /><c:if test="${empty role.category}">��</c:if></td>		
							<td width="33%" align="left" ><c:out value="${role.description}" /></td>																										            									           													            								            
		         		</tr>
			    	</c:forEach>	
			  	</TBODY>
			 </TABLE>
		 </div -->
		 </td>
		<td width="20px" align="center" valign="top" class="line-mid">&nbsp;</td>
		<td width="10px" align="center" valign="top">&nbsp;</td>
		<td width="43%" valign="top" height="100%" style="margin-top:2px;">
			<select id="expandTreeSelect" style="vertical-align: middle;">	
			</select>
			<div style="overflow: auto; height: 95%; width: 100%" >
				<table class="priosTable">
					<tr><td>
						<a href="http://www.treemenu.net/"/>
			            <script>initializeDocument()</script>
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