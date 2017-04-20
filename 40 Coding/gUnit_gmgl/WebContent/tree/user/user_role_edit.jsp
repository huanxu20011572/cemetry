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
  
  //重置
  function doReset(){
  	var strForm = document.myform;
  	strForm.reset();  	
  }
  


  //保存
	function doSave(){	  
		var strForm = document.myform;
		var systemRole = strForm.systemRole;
		var strUrl = "";
		var priorityIdStr = strForm.priorityIdStr.value;
	  
		
		if (checkSelected(strForm, "ids")) {		
			systemRole.value = getAllCheckedValue("myform", "ids");						
			buildPriorityStr();			
								
			strUrl = "/ajjwork/tree/doUpdateUserRole.do?method=updateUserRight";
			strForm.action = strUrl;
			strForm.submit();
				
		}else{
			window.alert("请先选择相应的角色！");
		}	
		
	}	

  //建立Priority
	function buildPriorityStr(){
		
		var strForm = document.myform;
		var systemRole = strForm.systemRole.value;
		var priorityIdStr = strForm.priorityIdStr.value;
		var prioritys = strForm.priority;
		var ids = strForm.ids;
		priorityIdStr = "";
		
		for(var i=0; i<ids.length; i++){
			
				if(ids[i].checked == true){		
						var prio = prioritys[i].value;
						if(Jtrim(priorityIdStr).length == 0){
							priorityIdStr = prio;
						}else{						 
							var prioStr = priorityIdStr.split(",");
							var curPrioStr = prio.split(",");														
							
							for(var j=0; j < curPrioStr.length; j++){
								var bExist = false;
								
								for(var k=0; k< prioStr.length; k++ ){
									 if(prioStr[k] == curPrioStr[j]){
									 	  bExist = true;
									 	  break;
										}
								}	
													
								if(bExist == false){
									  priorityIdStr += curPrioStr[j] + ","; 
								}
								bExist = false;							
							}
								
						}
				}
		}
		
		strForm.priorityIdStr.value = priorityIdStr;

	}
	
	  //显示权限
  function showSelectRight(){
  	var strForm = document.myform;
  	var priorityIdStr = strForm.priorityIdStr.value;
  	var strUrl = "";
  	
  	
  	buildPriorityStr();	
  	
  	strUrl = "doShowSelectPriority.do?method=showSelectPriority";
  	strForm.target = "role_frame";
  	strForm.action = strUrl;  	
  	strForm.submit();
  	
  }
	
	
</script>

<body scroll="no" onLoad="showSelectRight()" >
<table border="0" width="98%">
	<tr>
		<td>									
			<table border="0" width="100%" >
	   	  	<tr>
	        	<td>											        		
							<table border="0" cellpadding="0" cellspacing="0" >
			        	<tr height="22" width="100" > 
					        <td >    															       
					       		<input class="input_btn" type="button" name="btSave"  value="保 存"  onclick="doSave()">
					        </td>  
					        <td>
					        	&nbsp;&nbsp;
					      	</td>														        		 										         
					        <td>    															       
					       		<input class="input_btn" type="button" name="btAdd"  value="重 置"  onclick="doReset()">
					        </td>										          															         																      
				        </tr>
				      </table>
			     	</td>
	     		</tr>
	  	</table>									  		
		<td>	
	</tr>	
	<tr>		 
			<td valign="top" >
		
				<form  id="myform" name="myform" action="" method="post"  onSubmit="return templateListSubmit(this)">					  
					  <input type="hidden" name="userId" value="<c:out value='${param.userId}' />" >	
					  <input type="hidden" name="systemRole" value="<c:out value='${param.systemRole}' />" >	
					  <input type="hidden" name="priorityIdStr" value="<c:out value='${param.priorityIdStr}' />" >								  	
					  	
						<table width="100%" border="0" cellpadding="0" cellspacing="0"  height="86%" style="padding-left:5px;padding-right:5px">						
							
									
						  <tr valign="top" width="100%"  border="0">
						    <td  valign="top" height="300">			
									
									<DIV style = "overflow:auto;width:100%;height:510" id="tableContainer" class="tableContainer" > 
						   	 		
									<TABLE type="grid" border="0"  style="table-layout:fixed;"    name= "listTable" id = "listTable" cellpadding="1" cellspacing="1" bgcolor="a8d1eb"> 
									 
									 <COLGROUP nowrap = "true">
									 		<COL style="width:24;height:22;display: " /> 
							    		<COL style="display:;word-break:keep-all;width:50"; />			
							    		<COL style="display:;word-break:keep-all;width:200"; />					    		
							    		<COL style="display:;word-break:keep-all;width:100%;" />
								    </COLGROUP>
								    
									  <thead class="fixedHeader">
									  	<TR height="22" align="center" nowrap="true" class="list_title">
									    	<TD class="td-04">									        	
									        	<input type="checkbox" name="allbox" onclick="checkAll(this,ids)">
									     	</TD>
								        <TD dataType ="VARCHAR" class="td-04">序号</TD>                    
								        <TD dataType ="VARCHAR" class="td-04">角色名称</TD>  
								        <TD dataType ="VARCHAR" class="td-04">角色描述</TD>          
									  	</TR>   
									 	</thead>
									 
									 	<TBODY id ='listTableBody' name= "listTableBody" class="scrollContent">
									    	<c:forEach var="role" items="${roleList}"  varStatus="ctIndex" >
											  	<TR height="22" nowrap class="list_tr1"> 											  		
											  		<TD align="center" class="td-02">											  				
										  				<input type="checkbox" name="ids" value="<c:out value='${role.id}'/>"
										  					<c:forEach var="systemRole" items="${userSystemRoleList}">
										  						<c:if test="${systemRole == role.id}" >checked</c:if >	
										  					</c:forEach>	
										  					onclick="showSelectRight()"
										  				 >											  					
											  		</TD>				  														  													  		
											  		<TD height="26" align="center" class="td-02"><c:out value='${ctIndex.index+1}'/></TD>	
								            <TD height="26" align="left" class="td-02"><c:out value="${role.name}" /></TD>	
								            <input type="hidden" name="priority" value="<c:out value="${role.priority}" />" >
													  <TD height="26" align="left" class="td-02"><c:out value="${role.description}" /></TD>																										            									           													            								            
								         	</TR>
									    	</c:forEach>	
									  </TBODY>
									  
									</TABLE>
							  	</div>				
						 
						   	</td>
						   	<td width="40%" >
										<iframe id="role_frame" name="role_frame" width=100% height=510 src=""  frameborder=auto></iframe>
									</td>	
						  </tr> 
						</table>
						</form> 			
			</td>
			
	</tr>
	
</table>


</body>
</html>
