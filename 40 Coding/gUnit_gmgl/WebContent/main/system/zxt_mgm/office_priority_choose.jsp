<%@ page contentType="text/html; charset=GBK" %>
<%@ include file="../../../common/taglibs.jsp"%>
<html>
<head>
<title>分配权限</title>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<meta http-equiv="Cache-Control" content="no-store"/>
<meta http-equiv="Pragma" content="no-cache"/>
<meta http-equiv="Expires" content="0"/>

<link href="../../../css/css.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="../../../lib/treelib/assets/skins/sam/treeview.css" />
<link rel="stylesheet" type="text/css" href="../../../lib/treelib/assets/folders/tree.css" />

<script src="../../../script/ua.js"></script>
<script src="../../../script/ftiens4.js"></script>
<script src="../../../js/jquery-1.2.6.js"></script>

<script type="text/javascript" src="../../../lib/treelib/yahoo-dom-event.js"></script>
<script type="text/javascript" src="../../../lib/treelib/treeview-min.js"></script>
<script type="text/javascript" src="../../../lib/treelib/edit-tree.js"></script>

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
function folderMstr(domObj) 
{ 
  if (!this.isRendered)
     this.renderOb(domObj)
  else
    if (browserVersion == 1 || browserVersion == 3) 
      this.navObj.style.display = "block" 
    else 
      this.navObj.visibility = "show" 
}
function generateCheckBox(parentfolderObject, itemLabel, checkBoxDOMId) {
	var newObj = insDoc(parentfolderObject, gLnk("S", itemLabel, "javascript:"));
	newObj.prependHTML = "<td valign=middle><input type=checkbox  name='prioritys' id="+checkBoxDOMId+" value='"+checkBoxDOMId+"'>"
	newObj.prependHTML += "</td>"
	
	cBoxIdAndGLnkMap[checkBoxDOMId] = newObj;
	return newObj;
}

<c:out value="${prioTree}" escapeXml="false"/>

function addErrInfo(eleId, info){
	$('#' + eleId).after("<span style='color: red;' class='errInfo'>" + info + "</span>");
}
function removeAllErrInfo(){
	$('.errInfo').remove();
}

var officeTree;
function initOfficeTree(){
	var treeData = <c:out value="${treeData}"  escapeXml="false"/>;
	var userextSubstr = '<c:out value="${userextSubstr}"/>';

	officeTree = new Topsuntech.OneSNodeCheckboxTree('officeDiv');
	officeTree.treeView.rootNodeName = "机构";
	officeTree.treeView.getChildUrl = "treeView.do?treeViewCreator=officeTreeViewCreator&doMethod=getChildNodes&type=1";
	officeTree.draw(treeData, userextSubstr.split(","));
}
function initPriorityTree(){
	expandTree(foldersTree);
	generateExpandTreeSelectObj(foldersTree, 'expandTreeSelect');
	
	var userextPriority = '<c:out value="${userextPriority}"/>';
	var strArr = userextPriority.split(",")
	for(var i = 0; i < strArr.length; i++){
		if(strArr[i]){
			$("#" + strArr[i]).attr( 'checked', true );
			var gLnk = cBoxIdAndGLnkMap[strArr[i]];
			if(gLnk){
				$("#itemTextLink" + gLnk.id).css('color', 'blue');
			}
		}
	}
	
	$(":checkbox[name='prioritys']").click(function(){
		var gLnk = cBoxIdAndGLnkMap[this.id];
		if(this.checked){
			$("#itemTextLink" + gLnk.id).css('color', 'blue');
		}else{
			$("#itemTextLink" + gLnk.id).css('color', '');
		}
	});
}
function doOnLoad(){
	initOfficeTree();
    initPriorityTree();
	
}
function getIdStrFromValue(eleName){
	var valueStr = ',';
	var chboxs = document.getElementsByName(eleName);
	for(var i = 0; i < chboxs.length; i++){
		if(chboxs[i].checked){
			valueStr += (chboxs[i].value + ',');
		}
	}
	return valueStr == ',' ? '' : valueStr;
}
function doSubmit() {
	removeAllErrInfo();
	
	var isValid = true;
	var officeIds = officeTree.getCheckedValueString();
	if(!officeIds){
		addErrInfo('officeTitle', '&nbsp;未选择');
		isValid = false;
	}
	var prioritys = getIdStrFromValue('prioritys')
	if(!prioritys){
		addErrInfo('priorityTitle', '&nbsp;未选择');
		isValid = false;
	}
	
	if(isValid){
		$('#userextSubstr').val(officeIds);
		$('#userextPriority').val(prioritys);
		//alert($('#userextSubstr').val()+'--'+$('#userextPriority').val());
		$('#opForm').attr('action', 'updateUserextSubstrAndPriority.do?doMethod=updateUserextSubstrAndPriority');
		$('#opForm').submit();
		window.close();
	}
}
</script>
</head>

<body onLoad="doOnLoad()">
<form method="post" id="opForm" >
	<input name="id" type="hidden" value='<c:out value="${id}"/>'/>
	<input id="userextSubstr" name="userextSubstr" type="hidden" />
	<input id="userextPriority" name="userextPriority" type="hidden" />
</form>

<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="11" height="31" valign="top" class="td-bg"><img src="../../../images/right-1.jpg" /></td>
    <td align="center" valign="top" ><table width="100%" border="0" cellpadding="0" cellspacing="0" class="word-8">
      <tr>
        <td height="31" align="left" valign="middle" style="background:url(../../../images/right-3.jpg)"><img src="../../../images/right-4.jpg" width="9" height="8" align="absmiddle" /> 当前位置 &gt; 子系统管理 &gt; 子管理员管理</td>
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
   
	<table width="95%" height="100%" border="0" id="allTab">
	    <tr> 
		  	<td colspan="4" align="right">
		  		<a href="javascript:" onClick="doSubmit(); return false;"><img src="<c:url value="/images/but-qd.gif"/>" width="55" height="25" border="0"></a>
      			<a href="javascript:" onClick="window.close(); return false;"><img src="<c:url value="/images/but0qx.jpg"/>" width="55" height="25" border="0"></a>
		  	</td>
	  	</tr>
	<tr>
		<td width="50%" valign="top"  height="100%">
			<strong id="officeTitle">请选择管理的机构</strong>
			<div style="overflow: auto; height: 97%; width: 100%" >
				<table>
					<tr>
						<td><div id="officeDiv" style="font-size:13px;"></div></td>
					</tr>
				</table>
			</div>
		 </td>
		<td width="20px" align="center" valign="top" class="line-mid">&nbsp;</td>
		<td width="10px" align="center" valign="top">&nbsp;</td>
		<td width="43%" valign="top" height="100%" style="margin-top:2px;">
			<strong id="priorityTitle">请选择管理的权限</strong><br/>
			<select id="expandTreeSelect" style="vertical-align: middle;">	
			</select>
			<div style="overflow: auto; height: 93%; width: 100%" >
				<table class="priosTable">
					<tr><td>
						<a href="http://www.treemenu.net/"></a>
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