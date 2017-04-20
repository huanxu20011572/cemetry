/*
 * $Log: ua_office.js,v $
 * Revision 1.3  2009/04/22 01:43:01  peiguangliang
 * *** empty log message ***
 *
 * Revision 1.1  2008/08/14 09:17:54  lxr
 * *** empty log message ***
 *
 * Revision 1.2  2007/12/26 10:15:08  liuyan
 * *** empty log message ***
 *
 * Revision 1.1  2007/12/01 08:44:08  zhoudexuan
 * *** empty log message ***
 *
 * Revision 1.2  2006/04/18 10:05:54  yanhaichao
 * *** empty log message ***
 *
 * Revision 1.1  2006/03/29 13:38:03  yanhaichao
 * *** empty log message ***
 *
 * Revision 1.1  2006/03/26 02:28:29  yanhaichao
 * *** empty log message ***
 *
 * Revision 1.1  2006/02/06 09:08:43  baiweiming
 * *** empty log message ***
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
function windowWithoutToolbar(urlStr, width, height) 
{ 
   window.open(urlStr, '_blank', 'top=0,left=0,location=no,status=no,scrollbars=yes,menubar=no,toolbar=no,directories=no,resizable=no,width=' + width + ',height=' + height) 
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
	newObj = insDoc(parentfolderObject, gLnk("R", itemLabel, "javascript:parent.op()"))

    // The trick to show checkboxes in a tree that was made to display links is to 
	// use the prependHTML. There are general instructions about this member
    // in the online documentation
  if (isCheck=="true") {
		newObj.prependHTML = "<td valign=middle><input type=checkbox id="+checkBoxDOMId+" checked></td>"
	} else {
		newObj.prependHTML = "<td valign=middle><input type=checkbox id="+checkBoxDOMId+"></td>"
	}
}

function generateCheckBox1(parentfolderObject, itemLabel, checkBoxDOMId, linkLabel) {
	var newObj;

	// Read the online documentation for an explanation of insDoc and gLnk,
    // they are the base of the simplest Treeview trees
    	itemLabel = itemLabel + "<td width='400'><table><tr>";
        itemLabel = itemLabel + "<td class='unnamed1' width='400' align='center'><a href='regionUpdate.do?action=showUpdate&id=" + checkBoxDOMId + "'>编辑区域信息</a>&nbsp;"  
        itemLabel = itemLabel + "<a href='regionAdd.do?action=createChild&id=" + checkBoxDOMId + "'>创建子区域</a>&nbsp;"  
        itemLabel = itemLabel + "<a href='regionMove.do?action=moveTo&id=" + checkBoxDOMId + "'>移动该区域</a>&nbsp;"  
        itemLabel = itemLabel + "<a href='regionDelete.do?action=deleteConfirm&id=" + checkBoxDOMId + "'>删除该区域</a>&nbsp;"  
    //    itemLabel = itemLabel + "<a href='../user_mgm/userSelect.do?action=listByDept&id=" + checkBoxDOMId + "'>显示区域用户</a></td>" 
        itemLabel = itemLabel + "</tr></table></td>"; 
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
    ////	itemLabel = itemLabel + "<td width='400'><table><tr>";
    //    itemLabel = itemLabel + "<td class='unnamed1' width='400' align='center'><a href='regionUpdate.do?action=showUpdate&id=" + checkBoxDOMId + "'>编辑区域信息</a>&nbsp;"  
   //     itemLabel = itemLabel + "<a href='regionAdd.do?action=createChild&id=" + checkBoxDOMId + "'>创建子区域</a>&nbsp;"  
    ////    itemLabel = itemLabel + "<a href='regionMove.do?action=moveTo&id=" + checkBoxDOMId + "'>移动该区域</a>&nbsp;"  
    //    itemLabel = itemLabel + "<a href='regionDelete.do?action=deleteConfirm&id=" + checkBoxDOMId + "'>删除该区域</a>&nbsp;"  
   //     itemLabel = itemLabel + "<a href='../user_mgm/userSelect.do?action=listByDept&id=" + checkBoxDOMId + "'>显示区域用户</a></td>" 
    //    itemLabel = itemLabel + "</tr></table></td>"; 
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
	return newObj;
}

function generateRadioB(parentfolderObject, itemLabel, checkBoxDOMId, isFld) {
	var newObj;

	// Read the online documentation for an explanation of insDoc and gLnk,
    // they are the base of the simplest Treeview trees
//	newObj = insDoc(parentfolderObject, gLnk("R", itemLabel, "javascript:parent.op()"))
	
	if (isFld=="true"){	
		newObj = insFld(parentfolderObject, gFld(itemLabel, "javascript:parent.op()"));
	} else {
		newObj = insDoc(parentfolderObject, gLnk("R", itemLabel, "javascript:parent.op()"));
	}

    // The trick to show checkboxes in a tree that was made to display links is to 
	// use the prependHTML. There are general instructions about this member
    // in the online documentation
	newObj.prependHTML = "<td valign=middle><input type=radio name=hourPick id="+checkBoxDOMId+"></td>"
	return newObj;
}

function generateDoc(parentfolderObject, itemLabel, linkLabel){
	itemLabel = itemLabel + "<td width='400'><table><tr>";
    itemLabel = itemLabel + "<td class='unnamed1' width='400' align='center'><a href='GUnitUpdate.do?action=showUpdatePri&id=" + linkLabel + "'>编辑</a>&nbsp;"  
    itemLabel = itemLabel + "<a href='GUnitUpdate.do?action=deletePri&id=" + linkLabel + "'>删除</a>&nbsp;"  
    itemLabel = itemLabel + "</tr></table></td>"; 
    linkLabel = "GUnitShow.do?action=showPri&id=" + linkLabel;
	insDoc(parentfolderObject, gLnk("S", itemLabel, linkLabel))
	
}

function generateFld(parentfolderObject, itemLabel, linkLabel){
	newObj = insFld(parentfolderObject, gFld("<b>" + itemLabel + "</b>", linkLabel));
	return newObj;
}