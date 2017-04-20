<%@ page contentType="text/html; charset=GBK" %>
<%@ include file="../../common/taglibs.jsp"%>
<link href="/ajjwork/css/css.css" rel="stylesheet" type="text/css">




<html>
<head>
<title></title>
<script language="JavaScript" src="/shjz/script/publics.js"></script>
<script language="JavaScript" src="/shjz/script/common.js"></script>
<script language="JavaScript" src="/shjz/script/movetable.js"></script>
<script language="JavaScript" src="/shjz/script/move.js"></script>
<script language="JavaScript" src="/shjz/script/toolbar.js"></script>
<script language="JavaScript" src="/shjz/script/page.js"></script>
<script language="JavaScript" src="/shjz/script/selectTree.js"></script>

</head>

<script language="javascript">
<!--
	   var servletPath = "/bjdb/main_bjsj"
	//-->		
</script>

<script language="javascript">
  
 
</script>

<body scroll="no" >
		
<table border="0" >
	<tr>
			<td  valign="top"  width="100%" height="100%">		
				<form  id="myform" name="myform" action="" method="post"  onSubmit="return templateListSubmit(this)">					  
					  	
						<table width="100%" border="0" cellpadding="0" cellspacing="0"  height="100%" style="padding-left:5px;padding-right:5px">						
																
						  <tr valign="top" width="100%"  border="0">
						    <td  valign="top" >			
									
									<DIV style = "overflow:auto;width:100%;height:510" id="tableContainer" class="tableContainer" > 
						   	 		
									<TABLE type="grid" border="0"  style="table-layout:fixed;"    name= "listTable" id = "listTable" cellpadding="1" cellspacing="1" bgcolor="a8d1eb"> 
									 
									 <COLGROUP nowrap = "true">
									 		<COL style="width:50;height:22;display: " /> 
							    		<COL style="display:;word-break:keep-all;width:100%;" />
								    </COLGROUP>
								    
									  <thead class="fixedHeader">
									  	<TR height="22" align="center" nowrap="true" class="list_title">
								        <TD dataType ="VARCHAR" class="td-04">ÐòºÅ</TD>                    
								        <TD dataType ="VARCHAR" class="td-04">È¨ÏÞÃû³Æ</TD>          
									  	</TR>   
									 	</thead>
									 
									 	<TBODY id ='listTableBody' name= "listTableBody" class="scrollContent">
									    	<c:forEach var="gUnit" items="${priorityList}"  varStatus="ctIndex" >
											  	<TR height="22" nowrap class="list_tr1"> 											  				  														  													  		
											  		<TD height="26" align="center" class="td-02"><c:out value='${ctIndex.index+1}'/></TD>	
								            <TD height="26" align="left" class="td-02"><c:out value="${gUnit.name}" /></TD>	
								         	</TR>
									    	</c:forEach>	
									  </TBODY>
									  
									</TABLE>
							  	</div>				
						 
						   	</td>
						  </tr> 
						</table>
						</form> 			
			</td>
			<td width="30%" >
				<iframe id="import_frame" name="import_frame" width=100% height=90% src=""  frameborder=auto></iframe>
			</td>	
	</tr>
	
</table>


</body>
</html>
