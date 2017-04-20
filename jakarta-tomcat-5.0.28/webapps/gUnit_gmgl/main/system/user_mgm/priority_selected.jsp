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

<c:out value="${prioTree}" escapeXml="false"/>

function clearCheckBox(){
	 $(".prios :checkbox").attr( 'checked', false ).click(function() { return false});
}
var checkBoxflags = {};
document.selectOneCheckBox = function(cboxId, checked){
	if(checked){
		if(checkBoxflags[cboxId] == null){
		checkBoxflags[cboxId] = 1;
		}else{
			checkBoxflags[cboxId]++;
		}
		$("#" + cboxId).attr( 'checked', checked );
	}else{
		if(checkBoxflags[cboxId] != null){
			if(checkBoxflags[cboxId] > 0){
				if((--checkBoxflags[cboxId]) == 0){
					$("#" + cboxId ).attr( 'checked', checked );
				}
			}
		}
	}
}
document.selectCheckBoxs = function(cboxIds, checked){
	var cboxIdArr = cboxIds.split(",")
	for(var i = 0; i < cboxIdArr.length; i++){
		document.selectOneCheckBox(cboxIdArr[i], checked);
	}
	/*var checkboxs = $(".prios :checkbox").get();
	for(var i = 0; i < checkboxs.length; i++){
		for(var j = 0; j < cboxIdArr.length; j++){
			if(checkboxs[i].id == cboxIdArr[j]){
				if(checked){
					if(checkBoxflags[checkboxs[i].id] == null){
						checkBoxflags[checkboxs[i].id] = 1;
					}else{
						checkBoxflags[checkboxs[i].id]++;
					}
					checkboxs[i].checked = true;
					break;
				}else{
					if(checkBoxflags[checkboxs[i].id] != null){
						if(checkBoxflags[checkboxs[i].id] > 0){
							if((--checkBoxflags[checkboxs[i].id]) == 0){
								checkboxs[i].checked = false;
							}
						}
					}
					break;
				}
			}
		}
	}*/
}
function doOnLoad(){
	expandTree(foldersTree);
	clearCheckBox();
	document.selectCheckBoxs('<c:out value="${userPrios}"/>' ,true);
	document.selectCheckBoxs('<c:out value="${userRolePrios}"/>' ,true);
}
</script>
</head>

<body onload="doOnLoad()">
	
<table border="0" align="center">
<tr>
<td width="100%">
 <TABLE border="0" width="100%" align="center" >
        <TBODY>
          <TR>
            <TD align=middle><FONT size=2 face="Arial, Helvetica, sans-serif">所有权限列表</FONT>
          </TR>
          <TR>
            <TD align=center>
                <input type=button class=button onClick="javascript:expandTree(foldersTree)" value="展开">
                <input type=button class=button onClick="javascript:collapseTree(1)" value="收缩">
             </td>
           </tr>
           <tr>
           	<td class="prios">
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
           </TD>
          </TR>
        </TBODY>
      </TABLE>

</td>
</tr>
</table>

</body>
</html>

