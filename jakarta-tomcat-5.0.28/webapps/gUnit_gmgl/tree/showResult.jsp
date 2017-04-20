<%@ page language="java" contentType="text/html; charset=GBK" %>
<%@ include file="../common/taglibs.jsp"%>  
<%@ include file="../main_bjsj/public/css.jsp"%>

<html >
<head>
	<meta http-equiv="refresh" content="100">
</head>		
<script language="javascript">	
function refresh(){
		/*
		if(<c:out value="${adjustStatus}"/>){
			document.getElementById('dataframe').src="doStart.do?method=test";
		}
		*/
		
}

function freshTable(){
	location.reload();
}
	
//window.setTimeout("freshTable()", 5000);

</script>	
<body onload="refresh()">	
	
	 tread ok!
	 <table >
	   <c:forEach var="info" items="${times}" varStatus="statu"> 
    	<tr height="22" nowrap > 
	  		<td align="center" ><c:out value="${info}"/></td>
		  </tr>
		  
    </c:forEach>   
	</table>
 
<iframe name="dataframe" id="dataframe" src="" style="display:none"/> 
</body>    

</html>