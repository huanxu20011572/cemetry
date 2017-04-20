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
	$(":checkbox").attr( 'checked', false )
}

function initCheckBoxById(str){
	var strArr = str.split(",")
	for(var i = 0; i < strArr.length; i++){
		$("#" + strArr[i] ).attr( 'checked', true );
	}
	/*var checkboxs = $("." + parentClass + " :checkbox").get();
	for(var i = 0; i < checkboxs.length; i++){
		checkboxs[i].checked = false;
		for(var j = 0; j < strArr.length; j++){
			if(type == 'id'){
				if(checkboxs[i].id == strArr[j]){
					checkboxs[i].checked = true;			
					break;
				}
			}else if(type == 'value'){
				if(checkboxs[i].value == strArr[j]){
					checkboxs[i].checked = true;			
					break;
				}
			}
		}
	}*/
}

function doOnLoad(){
	expandTree(foldersTree);
	clearCheckBox();
	initCheckBoxById('<c:out value="${userPrios}"/>');
	initCheckBoxById('<c:out value="${userSystemRole}"/>');

	$(".prios :checkbox").click(function() {
		if(this.checked){
			$('#selectedPriorityFrame').attr('contentWindow').document.selectOneCheckBox(this.id, true); 
		}else{
			$('#selectedPriorityFrame').attr('contentWindow').document.selectOneCheckBox(this.id, false); 
		}
	});
	
	$(".role .roleIds").click(function() {
		if(this.checked){
			$('#selectedPriorityFrame').attr('contentWindow').document.selectCheckBoxs(this.prios, true); 
		}else{
			$('#selectedPriorityFrame').attr('contentWindow').document.selectCheckBoxs(this.prios, false); 
		}
	});
}
function getIdStr(selector, hasComma){
	var objs = $(selector).get();
	var idStr = '';
	for(var i = 0; i < objs.length; i++){
		if(i == 0 && hasComma){
			idStr = ',';
		}
		idStr += objs[i].id;
		if(i != objs.length - 1 || hasComma){
			idStr += ',';
		}
	}
	return idStr
}
function doSubmit() {
	//alert(getIdStr(".prios :checked", true));
	//alert(getIdStr(".role :checked", false));
	$('#priority').val(getIdStr(".prios :checked", true));
	$('#systemRole').val(getIdStr(".role :checked", false));
	$('#rpForm').attr('action', 'updateSystemRoleAndPriority.do?doMethod=updateSystemRoleAndPriority');
	$('#rpForm').submit();
}
</script>
</head>

<body onload="doOnLoad()">
<form method="post" id="rpForm" action="">
	<input name="id" type="hidden" value='<c:out value="${param.id}"/>'/>
	<input id="priority" name="priority" type="hidden" value='<c:out value="${userPrios}"/>'/>
	<input id="systemRole" name="systemRole" type="hidden" value='<c:out value="${userSystemRole}"/>'/>
</form>
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="11" background="../../../images/images_32.jpg"><img src="../../../images/content_left.gif" width="11" height="51"></td>
    <td height="51" background="../../../images/images_32.jpg"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="22" height="16" align="center"><img src="../../../images/d.gif" width="14" height="14"></td>
        <td valign="bottom"> <span class="text-red12">当前位置：用户管理 → <b>分配权限</b></span></td>
        <td width="300" align=right></td>
        
        <td width="15">&nbsp;</td>
      </tr>
    </table>
    </td>
  </tr>
  <tr>
    <td background="../../../images/images_481.jpg">&nbsp;</td>
    <td valign="top"> 
<table border="0">
<tr>
<td width="30%">
 <TABLE border="0" width="100%" align="center" >
        <TBODY>
          <TR>
            <TD align=middle><FONT size=2 face="Arial, Helvetica, sans-serif">选择权限列表</FONT>
          </TR>
          <TR>
            <TD align=center>            
				<input type=button class=button onClick="doSubmit();" value="确定">
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
<td class="role" width="30%" valign="top">
	<TABLE  style="border: 1px thin solid; font:12px;" width="100%" cellpadding="1" cellspacing="1"  > 
	    
		  <thead class="fixedHeader">
		  	<TR height="22" align="center" nowrap="true" >
		    	<TD class="td-04">									        	
		     	</TD>
	        <TD dataType ="VARCHAR" class="td-04">序号</TD>                    
	        <TD dataType ="VARCHAR" class="td-04">角色名称</TD>  
	        <TD dataType ="VARCHAR" class="td-04">角色描述</TD>          
		  	</TR>   
		 	</thead>
		 
		 	<TBODY id ='listTableBody' name= "listTableBody" >
		    	<c:forEach var="role" items="${roles}"  varStatus="ctIndex" >
				  	<TR height="26" nowrap class="list_tr1"> 											  		
				
					  <tr  height="26" align="center" class="td-01">
              						<TD height="26" align="center">		  				
			  				<input type="checkbox" name="roleIds" class="roleIds" id="<c:out value='${role.id}'/>" prios='<c:out value="${role.priority}" />'>											  					
				  		</TD>				  														  													  		
				  		<TD height="26" align="center"><c:out value='${ctIndex.index+1}'/></TD>	
	            		<TD height="26" align="left" ><c:out value="${role.name}" /></TD>	
						<TD height="26" align="left" ><c:out value="${role.description}" /></TD>																										            									           													            								            
	         	</TR>
		    	</c:forEach>	
		  </TBODY>
		  
		</TABLE>
</td>
<td width="40%" valign="top" height="100%">
<c:if test="${isAllPriority}">
	<iframe id="selectedPriorityFrame" marginheight="0" marginwidth="0" width="100%" height="100%" frameborder="0" scrolling="no" src='showSelectedPriority.do?doMethod=showSelectedPriority&id=<c:out value="${param.id}"/>'></iframe>
</c:if>
<c:if test="${not isAllPriority}">
	<iframe id="selectedPriorityFrame" marginheight="0" marginwidth="0" width="100%" height="100%" frameborder="0" scrolling="no" src='showSubSelectedPriority.do?doMethod=showSubSelectedPriority&id=<c:out value="${param.id}"/>'></iframe>
</c:if>
</td>
</tr>
</table>
</TD>
          </TR>
        </TBODY>
</body>
</html>























