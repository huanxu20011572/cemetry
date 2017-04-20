<html>
<head>
<title>Untitled Document</title>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<jsp:include page="../../../script/headScript.jsp" />
</head>

<body bgcolor="#FFFFFF" text="#000000" leftmargin="0" topmargin="0" onload="filter(this.form.test)">
<script type="text/Javascript"><!--
function filter(el) {
    var j = 0;
    var strHTML = " ";
    var v_foundarray =  new Array();
    var v_array = new Array("Linming","Hechuan","Hejia","LiHui","Zhangxia","Xiaoming","User1","User2","User3","User4","User5","User6","User7");
//    var v_regexp = new RegExp(el.value,"gi");

    for ( var i = 0; i < v_array.length; i++ ) {           
         if (v_array[i].indexOf(el.value) != -1) {
//         if ( v_regexp.test(v_array[i]) ) {
             v_foundarray[j] = v_array[i]; // Pattern found
             j++;
         }
    }
    
    strHTML += "<select size='10' multiple>";


    for ( var k = 0; k < v_foundarray.length; k++ ) {
         strHTML += "<option>" + v_foundarray[k] + "</option>";
    }
    strHTML += "</select>";
    
    if (document.all) {
        document.all.vals.innerHTML = strHTML;
    }
    else if (document.layers) {
        document.layers['vals'].document.open();
        document.layers['vals'].document.write(strHTML);
        document.layers['vals'].document.close();
    }
}
//-->

</script>

<CENTER>
<p>请在输入框中输入用户名，然后单击查询</p>
<TABLE borderColor=blue border=5 borderlight="green">
  <TBODY>
  <TR>
    <TD align=middle><FONT face="Arial, Helvetica, sans-serif" color=red 
      size=5><STRONG>用户列表</STRONG></FONT></TD></TR>
  <TR>
    <TD align=left>

<!-- By making any changes to this code you are violating your user agreement.
     Corporate users or any others that want to remove the link should check 
	 the online FAQ for instructions on how to obtain a version without the link -->
<!-- Removing this link will make the script stop from working -->
<form name="form" id="form" onSubmit="return false">
<input name="test" type="text" onKeyPress="filter(this.form.test)"> <input type="button" value="查询" onClick="filter(this.form.test)">
</form>
      <div id="vals">	
      </div>
	</TD>
      </TR>
      </TBODY>
      </TABLE>
<input type="button" value="确定" onclick="javascript:window.close();"> 
<input type="button" value="取消" onclick="javascript:window.close();"> 
</CENTER>      <br>

</body>
</html>