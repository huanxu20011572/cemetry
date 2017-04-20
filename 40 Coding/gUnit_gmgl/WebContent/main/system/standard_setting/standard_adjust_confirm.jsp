<%@ page contentType="text/html; charset=GBK" %>
<%@ include file="../../../common/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
<title>���߱�׼��ѯ�޸�</title>
<link href="../../../css/css.css" rel="stylesheet" type="text/css">
<script language="JavaScript" src="../../../script/page.js"></script>
<style type="text/css">
<!--
body {
	background-color: #F3FBFD;
}
-->
</style></head>
<script language="javascript">
function goNext(id){
	var url=document.URL;
	if(<c:out value="${empty cityId}"/>){
		url+="&cityId="+id; 
	}else{		 
		if(<c:out value="${empty countyId}"/>){
				url+="&countyId="+id; 
		}else{ 
			if(<c:out value="${empty streetId}"/>){
				url+="&streetId="+id; 
			}else{
				if(<c:out value="${empty communityId}"/>){
					url+="&communityId="+id; 
				}
			}
		}
	}
	document.URL=url;
}

function deleteAdjust(id){
	if(confirm('ɾ���ô�������ͥ�󣬸ü�ͥ�������������仯���Ƿ�ȷ��ɾ����'	)){
		document.URL='deleteAdjustInfo.do?method=deleteAdjustInfo&adjustId='+id+'&countyId=<c:out value="${param.countyId}"/>&streetId=<c:out value="${param.streetId}"/>&communityId=<c:out value="${param.communityId}"/>';	
	}
}
function confirmAdjust(){
	if(confirm('ȷ�ϵ����ϵͳ�Զ�����ؾ���������б�����Ƿ�ȷ�ϵ��ꣿ'	)){
		event.srcElement.disabled=true;
		document.URL='confirmAdjust.do?method=confirmAdjust';	
	}
}

function freshTable(){
	location.reload();
}

function refresh(){
		if(<c:out value="${adjustStatus}"/>){
			document.getElementById('dataframe').src="getAdjustInfo.do?method=getAdjustInfo&data=true";
		}
}
<c:if test="${param.data=='true'}">
	<c:if test="${adjustStatus}">
	  	<c:forEach var="info" items="${infos}" varStatus="statu">
	  	window.setTimeout("freshTable()", 5000);
	  	if(parent){
	  			parent.document.getElementById('info_<c:out value="${info[0]}"/>_1').innerHTML= '<c:out value="${info[1]}"/>';
				  parent.document.getElementById('info_<c:out value="${info[0]}"/>_2').innerHTML= '<c:out value="${info[2]}"/>';
				  parent.document.getElementById('info_<c:out value="${info[0]}"/>_3').innerHTML= '<c:out value="${info[3]}"/>';
			}
	    </c:forEach>    
	</c:if>
</c:if>

</script>
<c:if test="${param.data!='true'}">
<body onload="refresh()">
<table width="96%" border="0" align="center" cellpadding="1" cellspacing="1">
	<tr>
		<td align="center" height=30><span class="biaoti_3">��������</span></td>
	</tr>
</table>
<c:if test="${!adjustStatus}">
  <c:if test="${!detail}">  
  <table width="96%" border="0" align="center" cellpadding="1" cellspacing="1" bgcolor="#CCCCCC">
    <tr>
    	<td width="10%" align="center" class="tabel_td1">���</td>
      <td width="20%" align="center" class="tabel_td1">����</td>
      <td width="20%" align="center" class="tabel_td1">������Ӱ���ͥ���� </td>
    </tr>
    <c:forEach var="info" items="${infos}" varStatus="statu"> 
    	<tr height="22" nowrap class="<c:if test="${statu.count%2==0}">list_tr</c:if><c:if test="${statu.count%2!=0}">list_tr1</c:if>"> 
			  <td height="26" align="center" ><c:out value="${statu.count}"/></td>
			  <td height="26" align="center" ><a href="javascript:goNext(<c:out value="${info[0]}"/>)"><gOS_shjz:regionValue key='${info[0]}'/></a></td>	  		
	  		<td align="center" ><c:out value="${info[1]}"/></td>
		  </tr>
    </c:forEach>    
  </table>
	</c:if>
	<c:if test="${detail}">
	<table width="96%" border="0" align="center" cellpadding="1" cellspacing="1" bgcolor="#CCCCCC">
    <tr>
      <td width="4%" align="center" class="tabel_td1">���</td>
      <td width="10%" align="center" class="tabel_td1">����</td>
      <td width="8%" align="center" class="tabel_td1">�ֵ�</td>
      <td width="10%" align="center" class="tabel_td1">����</td>
      <td width="25%" align="center" class="tabel_td1">����������</td>
      <td width="30%" align="center" class="tabel_td1">����</td>
    </tr>
    <c:forEach var="info" items="${infos}" varStatus="statu"> 
    	<tr height="22" nowrap class="<c:if test="${statu.count%2==0}">list_tr</c:if><c:if test="${statu.count%2!=0}">list_tr1</c:if>"> 
			  <td height="26" align="center" ><c:out value="${statu.count}"/></td>
			  <td height="26" align="center" ><gOS_shjz:regionValue key='${info[0].countyId}'/></td>	  		
	  		<td align="center" ><gOS_shjz:regionValue key='${info[0].streetId}'/></td>
	  		<td align="center" ><gOS_shjz:regionValue key='${info[0].communityId}'/></td>	
			  <td align="center" ><c:out value="${info[0].applyName}"/></td>	
			  <td align="center"><a href="javascript:deleteAdjust(<c:out value="${info[1]}"/>)">ɾ��</a></td>		
		  </tr>
    </c:forEach>  
  </table>	
	</c:if>
</c:if>
<c:if test="${adjustStatus}">
  <table width="96%" border="0" align="center" cellpadding="1" cellspacing="1" bgcolor="#CCCCCC">
    <tr>
    	<td width="10%" align="center" class="tabel_td1">���</td>
      <td width="20%" align="center" class="tabel_td1">����</td>
      <td width="10%" align="center" class="tabel_td1">������</td>
      <td width="10%" align="center" class="tabel_td1">����ʧ��</td>
      <td width="10%" align="center" class="tabel_td1">�����ɹ�</td>
    </tr>
    <c:forEach var="info" items="${infos}" varStatus="statu"> 
    	<tr height="22" nowrap class="<c:if test="${statu.count%2==0}">list_tr</c:if><c:if test="${statu.count%2!=0}">list_tr1</c:if>"> 
			  <td height="26" align="center" ><c:out value="${statu.count}"/></td>
			  <td height="26" align="center" ><gOS_shjz:regionValue key='${info[0]}'/></td>	  		
	  		<td align="center" id="info_<c:out value='${info[0]}'/>_1"><c:out value="${info[1]}"/></td>
	  		<td align="center" id="info_<c:out value='${info[0]}'/>_2"><c:out value="${info[2]}"/></td>
	  		<td align="center" id="info_<c:out value='${info[0]}'/>_3"><c:out value="${info[3]}"/></td>
		  </tr>
    </c:forEach>    
  </table>
</c:if>
<table width="96%" border="0" align="center" cellpadding="1" cellspacing="1">
	<tr>
		<td align="center" height=30>
			<input  class="input_btn02" type="Submit" name="Submit2"  value="������ҳ"  onclick="history.go(-1)">
      <input  class="input_btn02" type="Submit" name="Submit2"  value="ȷ�ϵ���"  onclick="confirmAdjust()" <c:if test="${adjustStatus}">disabled</c:if>>
		</td>
	</tr>
</table>	
</body>
<iframe name="dataframe" id="dataframe" src="" style="display:none"/>
</c:if>
</html>