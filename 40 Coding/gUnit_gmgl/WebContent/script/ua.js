/*
 * $Log: ua.js,v $
 * Revision 1.8  2010/01/06 21:42:55  jiangyang
 * *** empty log message ***
 *
 * Revision 1.7  2009/12/25 20:29:57  jiangyang
 * *** empty log message ***
 *
 * Revision 1.6  2009/12/24 14:29:46  jiangyang
 * *** empty log message ***
 *
 * Revision 1.5  2009/12/23 19:54:47  jiangyang
 * *** empty log message ***
 *
 * Revision 1.4  2009/12/18 16:53:59  jiangyang
 * *** empty log message ***
 *
 * Revision 1.3  2009/04/22 01:43:01  peiguangliang
 * *** empty log message ***
 *
 * Revision 1.1  2008/08/14 09:19:37  lxr
 * *** empty log message ***
 *
 * Revision 1.2  2007/12/26 10:15:26  liuyan
 * *** empty log message ***
 *
 * Revision 1.5  2007/11/23 02:43:01  pengzuocong
 * *** empty log message ***
 *
 * Revision 1.4  2007/10/26 09:06:57  lxr
 * *** empty log message ***
 *
 * Revision 1.3  2007/09/03 05:28:06  pengzuocong
 * *** empty log message ***
 *
 * Revision 1.2  2007/08/15 01:34:23  lxr
 * *** empty log message ***
 *
 * Revision 1.1  2006/05/12 15:00:32  lxr
 * *** empty log message ***
 *
 * Revision 1.1  2006/01/10 09:32:59  lxr
 * *** empty log message ***
 *
 * Revision 1.1  2005/11/29 13:56:35  sjz
 * *** empty log message ***
 *
 * Revision 1.5  2004/09/09 10:38:03  zhx
 * no message
 *
 * Revision 1.4  2003/12/29 06:50:36  zhx
 * back to 1.1
 *
 * Revision 1.1  2003/09/22 11:10:50  zhx
 * Initial revision
 *
 * Revision 1.9  2002/07/22 14:06:21  bc6ix
 * fix license path, change version reporting to use 2 digits for each level
 *
 * Revision 1.8  2002/07/07 08:23:07  bc6ix
 * fix line endings
 *
 * Revision 1.7  2002/05/14 16:52:52  bc6ix
 * use CVS Log for revision history
 *
 *
 */

/* ***** BEGIN LICENSE BLOCK *****
 * Licensed under Version: MPL 1.1/GPL 2.0/LGPL 2.1
 * Full Terms at http://bclary.com/lib/js/license/mpl-tri-license.txt
 *
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License
 * for the specific language governing rights and limitations under the
 * License.
 *
 * The Original Code is Netscape code.
 *
 * The Initial Developer of the Original Code is
 * Netscape Corporation.
 * Portions created by the Initial Developer are Copyright (C) 2001
 * the Initial Developer. All Rights Reserved.
 *
 * Contributor(s): Bob Clary <bclary@netscape.com>
 *
 * ***** END LICENSE BLOCK ***** */

function xbDetectBrowser()
{
  var oldOnError = window.onerror;
  var element = null;

  window.onerror = null;
  
  // work around bug in xpcdom Mozilla 0.9.1
  window.saveNavigator = window.navigator;

  navigator.OS    = '';
  navigator.version  = parseFloat(navigator.appVersion);
  navigator.org    = '';
  navigator.family  = '';

  var platform;
  if (typeof(window.navigator.platform) != 'undefined')
  {
    platform = window.navigator.platform.toLowerCase();
    if (platform.indexOf('win') != -1)
      navigator.OS = 'win';
    else if (platform.indexOf('mac') != -1)
      navigator.OS = 'mac';
    else if (platform.indexOf('unix') != -1 || platform.indexOf('linux') != -1 || platform.indexOf('sun') != -1)
      navigator.OS = 'nix';
  }

  var i = 0;
  var ua = window.navigator.userAgent.toLowerCase();
  
  if (ua.indexOf('safari') != -1)
  {
    i = ua.indexOf('safari');
    navigator.family = 'safari';
    navigator.org = 'safari';
    navigator.version = parseFloat('0' + ua.substr(i+7), 10);
  }
  else if (ua.indexOf('opera') != -1)
  {
    i = ua.indexOf('opera');
    navigator.family  = 'opera';
    navigator.org    = 'opera';
    navigator.version  = parseFloat('0' + ua.substr(i+6), 10);
  }
  else if ((i = ua.indexOf('msie')) != -1)
  {
    navigator.org    = 'microsoft';
    navigator.version  = parseFloat('0' + ua.substr(i+5), 10);
    
    if (navigator.version < 4)
      navigator.family = 'ie3';
    else
      navigator.family = 'ie4'
  }
  else if (ua.indexOf('gecko') != -1)
  {
    navigator.family = 'gecko';
    var rvStart = ua.indexOf('rv:');
    var rvEnd   = ua.indexOf(')', rvStart);
    var rv      = ua.substring(rvStart+3, rvEnd);
    var rvParts = rv.split('.');
    var rvValue = 0;
    var exp     = 1;

    for (var i = 0; i < rvParts.length; i++)
    {
      var val = parseInt(rvParts[i]);
      rvValue += val / exp;
      exp *= 100;
    }
    navigator.version = rvValue;

    if (ua.indexOf('netscape') != -1)
      navigator.org = 'netscape';
    else if (ua.indexOf('compuserve') != -1)
      navigator.org = 'compuserve';
    else
      navigator.org = 'mozilla';
  }
  else if ((ua.indexOf('mozilla') !=-1) && (ua.indexOf('spoofer')==-1) && (ua.indexOf('compatible') == -1) && (ua.indexOf('opera')==-1)&& (ua.indexOf('webtv')==-1) && (ua.indexOf('hotjava')==-1))
  {
    var is_major = parseFloat(navigator.appVersion);
    
    if (is_major < 4)
      navigator.version = is_major;
    else
    {
      i = ua.lastIndexOf('/')
      navigator.version = parseFloat('0' + ua.substr(i+1), 10);
    }
    navigator.org = 'netscape';
    navigator.family = 'nn' + parseInt(navigator.appVersion);
  }
  else if ((i = ua.indexOf('aol')) != -1 )
  {
    // aol
    navigator.family  = 'aol';
    navigator.org    = 'aol';
    navigator.version  = parseFloat('0' + ua.substr(i+4), 10);
  }
  else if ((i = ua.indexOf('hotjava')) != -1 )
  {
    // hotjava
    navigator.family  = 'hotjava';
    navigator.org    = 'sun';
    navigator.version  = parseFloat(navigator.appVersion);
  }

  window.onerror = oldOnError;
}

xbDetectBrowser();



// Functions called by the menu under the tree
// If you are not going to have an extra frame with action buttons, if your links
// are embedded in the documents that load in the right frame, for example,
// you should move these functions to the frameset file (in this case demoFuncs.html)
// If you are using a frameless layout, you will also have to move these functions
// to the appropriate page.
// In both cases: you will have to update the DOM paths used to access the functions
// and used by the functions themselves.

// Open all folders
// May not work with very large trees (browser may time out)
// You may call this on a node other than the root, but it must be a folder
function expandTree(folderObj)
{
    var childObj;
    var i;

    //Open folder
    if (!folderObj.isOpen)
      clickOnNodeObj(folderObj)

    //Call this function for all folder children
    for (i=0 ; i < folderObj.nChildren; i++)  {
      childObj = folderObj.children[i]
      if (typeof childObj.setState != "undefined") {//is folder
        expandTree(childObj)
      }
    }
}

// Close all folders
function collapseTree()
{
	//hide all folders
	clickOnNodeObj(foldersTree)
	//restore first level
	clickOnNodeObj(foldersTree)
}

function op() { //This function is used with folders that do not open pages themselves. See online docs.
}

//To use these functions in a frameless layout, move the functions to 
//the main page and follow the instructions in the demoFuncsNodes.js
function exampleFunction(message)
{
    alert("Treeview nodes can call JS functions\n" + message)
}
// If you rename the "windowWithoutToolbar" function, please don't give it a name that 
// starts with "op"; it will conflict with some special Treeview code.
function windowWithoutToolbar(urlStr, width, height, isInCenter) 
{ 
	var left = 0;
	if(isInCenter){
		left = (window.top.screen.availWidth - width) / 2;
	}
	return window.open(urlStr, '_blank', 'top=0,left=' + left + ',location=no,status=no,scrollbars=yes,menubar=no,toolbar=no,directories=no,resizable=no,width=' + width + ',height=' + height) 
}

// This configuration file is used to demontrate how to add checkboxes to your tree.
// If your site will not display checkboxes, picka a different configuration file as 
// the example to follow and adapt

// Notes:
// If you are going to set USEICONS = 1, then you will want to edit the gif files and 
// remove the white space on the right


// Auxiliary functions for the contruction of the tree
// You will mcertainly want to change these functions for your own purposes

// If you want to add checkboxes to the folder you will have to create a function 
// similar to this one to do that and call it below in the tree construction section

// These functions are directly realted with the additional JavaScript in the 
// page holding the tree (demoCheckbox.html), where the form handling code
// resides
function generateCheckBox(parentfolderObject, itemLabel, checkBoxDOMId) {
	var newObj;

	// Read the online documentation for an explanation of insDoc and gLnk,
    // they are the base of the simplest Treeview trees
	newObj = insDoc(parentfolderObject, gLnk("R", itemLabel, "javascript:parent.op()"))

    // The trick to show checkboxes in a tree that was made to display links is to 
	// use the prependHTML. There are general instructions about this member
    // in the online documentation
	newObj.prependHTML = "<td valign=middle><input type=checkbox id="+checkBoxDOMId+"></td>"
}

function generateCheckBox(parentfolderObject, itemLabel, checkBoxDOMId, isCheck) {
	var newObj;

	// Read the online documentation for an explanation of insDoc and gLnk,
    // they are the base of the simplest Treeview trees
	newObj = insDoc(parentfolderObject, gLnk("S", itemLabel, "javascript:parent.op()"))

    // The trick to show checkboxes in a tree that was made to display links is to 
	// use the prependHTML. There are general instructions about this member
    // in the online documentation
  if (isCheck=="true") {
		newObj.prependHTML = "<td valign=middle><input type=checkbox id="+checkBoxDOMId+" checked></td>"
	} else {
		newObj.prependHTML = "<td valign=middle><input type=checkbox id="+checkBoxDOMId+"></td>"
	}
	
	return newObj;
}

function generateCheckBox1(parentfolderObject, itemLabel, checkBoxDOMId, linkLabel) {
	var newObj;

	// Read the online documentation for an explanation of insDoc and gLnk,
    // they are the base of the simplest Treeview trees
  itemLabel = itemLabel + "<td width='400'><table><tr>";
  itemLabel = itemLabel + "<td class='unnamed1' width='400' align='center'><a href='officeUpdate.do?action=showUpdate&id=" + checkBoxDOMId + "'>编辑部门信息</a>&nbsp;"  
  itemLabel = itemLabel + "<a href='officeAdd.do?action=createChild&id=" + checkBoxDOMId + "'>创建子部门</a>&nbsp;"  
  itemLabel = itemLabel + "<a href='officeMove.do?action=moveTo&id=" + checkBoxDOMId + "'>移动该部门</a>&nbsp;"  
  itemLabel = itemLabel + "<a href='officeDelete.do?action=deleteConfirm&id=" + checkBoxDOMId + "'>删除该部门</a>&nbsp;"  
  itemLabel = itemLabel + "<a href='../user_mgm/userSelect.do?action=listByDept&id=" + checkBoxDOMId + "'>显示部门用户</a></td>" 
  itemLabel = itemLabel + "</tr></table></td>"; 
        
        //linkLabel = 'officeSelect.do?action=detail&id=' + linkLabel;
	linkLabel = 'officeSelect.do?action=detail&id=' + checkBoxDOMId;
	newObj = insDoc(parentfolderObject, gLnk("S", itemLabel, linkLabel));

    // The trick to show checkboxes in a tree that was made to display links is to 
	// use the prependHTML. There are general instructions about this member
    // in the online documentation
	newObj.prependHTML = "<td valign=middle><input type=checkbox id="+checkBoxDOMId+"></td>"
	return newObj;
}

function generateCheckBox1(parentfolderObject, itemLabel, checkBoxDOMId, linkLabel, isFld) {
	var newObj;

	// Read the online documentation for an explanation of insDoc and gLnk,
    // they are the base of the simplest Treeview trees
    	itemLabel = itemLabel + "<td width='400'><table><tr>";
        itemLabel = itemLabel + "<td class='unnamed1' width='400' align='center'>";
        itemLabel = itemLabel + "<a href='../office_mgm/officeAdd.do?action=createChild&id=" + checkBoxDOMId + "'>创建子部门</a>&nbsp;&nbsp;&nbsp;"  
        itemLabel = itemLabel + "<a href='../office_mgm/officeUpdate.do?action=showUpdate&id=" + checkBoxDOMId + "'>编辑</a>&nbsp;&nbsp;&nbsp;"  
        itemLabel = itemLabel + "<a href='../office_mgm/officeMove.do?action=moveTo&id=" + checkBoxDOMId + "'>移动</a>&nbsp;&nbsp;&nbsp;"  
        itemLabel = itemLabel + "<a href='../office_mgm/officeDelete.do?action=deleteConfirm&id=" + checkBoxDOMId + "'>删除</a>&nbsp;&nbsp;&nbsp;"  
        itemLabel = itemLabel + "<a href='../user_mgm/userSelect.do?action=listByDept&id=" + checkBoxDOMId + "'>显示部门用户</a></td>" 
        itemLabel = itemLabel + "</tr></table></td>"; 
        
        //linkLabel = 'officeSelect.do?action=detail&id=' + linkLabel;
		linkLabel = 'officeSelect.do?action=detail&id=' + checkBoxDOMId;
        if (isFld=="true"){	
		newObj = insFld(parentfolderObject, gFld(itemLabel, linkLabel));
	} else {
		newObj = insDoc(parentfolderObject, gLnk("S", itemLabel, linkLabel));
	}

    // The trick to show checkboxes in a tree that was made to display links is to 
	// use the prependHTML. There are general instructions about this member
    // in the online documentation
	newObj.prependHTML = "<td valign=middle><input type=checkbox id="+checkBoxDOMId+"></td>"
	return newObj;
}

// Function similar to the above, but instead of creating checkboxes, it creates
// radio buttons
function generateRadioB(parentfolderObject, itemLabel, checkBoxDOMId) {
	var newObj;

	// Read the online documentation for an explanation of insDoc and gLnk,
    // they are the base of the simplest Treeview trees
	newObj = insDoc(parentfolderObject, gLnk("R", itemLabel, "javascript:parent.op()"))

    // The trick to show checkboxes in a tree that was made to display links is to 
	// use the prependHTML. There are general instructions about this member
    // in the online documentation
	newObj.prependHTML = "<td valign=middle><input type=radio name=hourPick id="+checkBoxDOMId+"></td>"
}

function generateFld(parentfolderObject, itemLabel, linkLabel, menutype){
	newObj = insFld(parentfolderObject, gFld("<b>" + itemLabel + "</b>", ''));
	return newObj;
}

function generateExpandTreeSelectObj(foldersTree, selectObjId, callbackInChange){
	for(var i = 0; i < foldersTree.children.length; i++){	
		$('#' + selectObjId).append('<option value="' + i + '"> ' + foldersTree.children[i].desc + '</option>');
	}
	$('#' + selectObjId).change(function(){
		var index = this.value;
		if(index == -1){
			collapseTree();
		}else if(index == -2){
			expandTree(foldersTree);
		}else{
			collapseTree();
			expandTree(foldersTree.children[index])
		}
		
		if(callbackInChange){
			callbackInChange();
		}
	});
//	$('#' + selectObjId).append('<option value="-1">跨子系统</option>');
	$('#' + selectObjId).append('<option value="-2">全部展开</option>');
	
	collapseTree();
	expandTree(foldersTree.children[0])
}
function filterOption(selectObjId, othSelectObjId, beginIndex){
	var options = $('#' + selectObjId).get(0).options
	var othOptions = $('#' + othSelectObjId).get(0).options
	for(var i=beginIndex; i<options.length; i++) {
		var foundOpt = false;
		for(var j=0; j<othOptions.length; j++) {
			if(options[i].text == othOptions[j].text){
				foundOpt = true;
				break;
			}
		}
		if(!foundOpt){
			options.remove(i);
			i--;
		}
	}
}
function SelectLink(isMarkFired, type){
	this.isFired = false;
	this.isMarkFired = isMarkFired ? isMarkFired : true;
	this.type = type ? type : 'index';
}
SelectLink.prototype = {
	getOptIndexByPropertyName: function(option, selectObj, propertyName){
		var property = option[propertyName];
		for(var i = 0; i < selectObj.options.length; i++){
			if(property == selectObj.options[i][propertyName]){
				return i;
			}
		}
		return 0;
	},
	
	changeSelectByOthSelect: function (selectObjId, othSelectObjId, isFireOnchange){
		if(isFireOnchange && this.isFired){
			this.isFired = false;
			return;
		}
		
		var selectObj = $('#' + selectObjId).get(0);
		var index = $('#' + othSelectObjId).attr('selectedIndex');
		
		var othSelectObj = $('#' + othSelectObjId).get(0);
		if(this.type == 'text'){
			index = this.getOptIndexByPropertyName(othSelectObj.options[index], selectObj, 'text');
		}else if(this.type == 'value'){
			index = this.getOptIndexByPropertyName(othSelectObj.options[index], selectObj, 'value');
		}
		
		if(index < selectObj.options.length){
			selectObj.options[index].setAttribute('selected', true);
			if(isFireOnchange){
				this.isFired = this.isMarkFired;
				selectObj.fireEvent('onchange');
				//$(selectObj).trigger('change');
			}
		}
	}
}
function openWinNoToolbarAndSubmit(url, width, height, pform) 
{ 
    var nwin = window.open('', '_blank', 'top=0,left=0,location=no,status=no,scrollbars=yes,menubar=no,toolbar=no,directories=no,resizable=no,width=' + width + ',height=' + height) 
	nwin.name = '_nwin';
	var oTarget = pform.target;
	pform.target = nwin.name;
	var oAction = pform.action;
	pform.action = url;
	pform.submit();
	pform.target = oTarget;
	pform.action = oAction;
}
