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
	var strForm ;
	function doEditStandard(standardId, stopFlag){
		if(stopFlag != 0){
			alert(" �����޸������û���ͣ�õı�׼��");
			return;
		}
		strForm.action = "prepEditStandardInfo.do?method=prepEditStandard&standardId="+standardId;
		strForm.submit();
	}
	
	function doDelStandard(standardId, stopFlag){
		if(stopFlag != 0){
			alert(" ����ɾ�������û���ͣ�õı�׼��");
			return;
		}
		if(window.confirm("ȷ��ɾ����")){
			strForm.action = "standardInfoDel.do?method=delStandard&standardId="+standardId;
			strForm.submit();
	  }
	}
	
	function doShowStandard(standardId){
		strForm.action = "prepEditStandardInfo.do?method=prepEditStandard&stardardDetail=1&standardId="+standardId;
		strForm.submit();
	}
	
	function doAdjustStandard(standardId){
		if(<c:out value="${adjustingStatus}"/>){
			alert('�Բ���ϵͳ���ڵ��꣬����������߲��������ڱ��ε����������е�����');
			return;
		}else{
			strForm.action = "prepEditStandardInfo.do?method=prepEditStandard&adjustFlag=true&standardId="+standardId;
			strForm.submit();
		}
	}
	
	function init(){
		strForm = document.form1;
		var areaId = '<c:out value="${areaId}"/>';
		var stopFlag = '<c:out value="${stopFlag}"/>';
		
		if(areaId!=''){
			var areaObj = document.getElementById('areaId');
			for(var i=0,j=areaObj.length;i<j;i++){
				if(areaId==areaObj.options[i].value){
					areaObj.options[i].selected=true;
					break;
				}	
			}
		}
		if(stopFlag!=''){
			var stopFlagObj = document.getElementById('stopFlag');
			for(var i=0,j=stopFlagObj.length;i<j;i++){
				if(stopFlag==stopFlagObj.options[i].value){
					stopFlagObj.options[i].selected=true;
					break;
				}	
			}	
		}
	}
	
	function endAdjust(){
			if(confirm('�Ƿ�ȷ�����߲���������')){
				document.URL='perEndAdjust.do?method=perEndAdjust';	
			}	
	}
	
	function getAdjustInfo(){
			document.URL='getAdjustInfo.do?method=getAdjustInfo'
	}
</script>
<body onload="init()">
<form name="form1" method="post" action="standardInfoList.do?method=getList<c:if test="${!empty param.adjustFlag}">&adjustFlag=true</c:if>">
  <table width="96%" border="0" align="center" cellpadding="0" cellspacing="0">    
    <tr>
    	<c:if test="${!empty param.adjustFlag}">
 	    	<td height="45" align="center" class="biaoti_3">���߱�׼����</td>   		
    	</c:if>
    	<c:if test="${empty param.adjustFlag}">
	    	<td height="45" align="center" class="biaoti_3">���߱�׼��ѯ</td>    		
    	</c:if>
	  </tr>
    <tr>
      <td align="center" bgcolor="#FFFFFF" class="biankuang1"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="biankuang2">
         <tr height="22">
					  <td nowrap align="right" width="10%" class="table_td7">��׼����:</td>
					  <td width="25%" class="table_td7">
						  <gOS:select name="standardType" items="class{com.topsuntech.gUnit.gEU_util.taglib.ShjzDictListProvide($request,ZCBZLX)}" keyProperty="key" valueProperty="value" styleClass="select"  style="width:100%" selected="${standardType}">
								<gOS:option key="" value="����" />
							</gOS:select>
					  </td>
					  <td width="11%" align="right" class="table_td7">����</td>
					  <td width="19%" class="table_td7">
					  	<select id="areaId" name="areaId" style="width:100px">
					  		<option value="">����</option>
			  				<option value="2" >������</option>
            ����<option value="4" >������</option>
            ����<option value="8" >������</option>
            ����<option value="463" >������</option>
            ����<option value="301" >��̨��</option>
            ����<option value="461" >������</option>
            ����<option value="462" >������</option>
            ����<option value="464" >������</option>
            ����<option value="466" >ͨ����</option>
            ����<option value="467" >ʯ��ɽ��</option>
            ����<option value="468" >������</option>
                <option value="469" >��ɽ��</option>
            ����<option value="470" >��ͷ����</option>
            ����<option value="471" >ƽ����</option>
            ����<option value="472" >������</option>
            ����<option value="473" >������</option>
            ����<option value="474" >������</option>
            ����<option value="475" >��ƽ��</option>
            ����<option value="476" >˳����</option>
            ��</select>
					  </td>
					  <c:if test="${empty param.adjustFlag}">  
					  <td width="10%" align="right" class="table_td7">�Ƿ�����:</td>
					  <td width="13%" class="table_td7">
					  	<select id="stopFlag" name="stopFlag" >
						    <option value="">����</option>
						    <option value="0"  >δ����</option>
						    <option value="1"  >����</option>
						    <option value="-1">��ͣ��</option>
				      </select>
				    </td>
				  	</c:if>
				  	<c:if test="${empty param.adjustFlag}">
				  	<input type="hidden" name="stopFlag" value="1">	
				  	</c:if>
					  <td width="30%" class="table_td7"><input  class="input_btn01" type="Submit" name="Submit2"  value="�� ѯ"  >
					  <c:if test="${!empty param.adjustFlag}">
					  	<c:if test="${adjustStatus==1}">
					  		<input class="input_btn02" type="button" name="Submit3" value="������������" onclick="endAdjust()" >
					  	</c:if>
					  	<c:if test="${adjustStatus!=1}">
					  		<input class="input_btn02" type="button" name="Submit3" disabled value="������������" onclick="endAdjust()" >
					  	</c:if>
							<input class="input_btn02" type="button" name="Submit3" value="�����������" onclick="getAdjustInfo()">				  	
				  	</c:if>	
					  </td>
				 </tr>
          
      </table></td>
    </tr>
  </table>
  </form>
  <c:if test="${empty param.adjustFlag}">  
  <table width="96%" border="0" align="center" cellpadding="1" cellspacing="1" bgcolor="#CCCCCC">
    <tr>
      <td width="10%" height="27"  colspan="10"  nowrap = "true" class="table_td7"><input  class="input_btn" type="button" name="Submit2"  onClick="javascript:window.location='standard_add.jsp'"  value="����"  ></td>
    </tr>
    <tr>
      <td width="4%" align="center" class="tabel_td1">���</td>
      <td width="10%" align="center" class="tabel_td1">���÷�Χ</td>
      <td width="8%" align="center" class="tabel_td1">����</td>
      <td width="10%" align="center" class="tabel_td1">����</td>
      <td width="30%" align="center" class="tabel_td1">������</td>
      <td width="5%" align="center" class="tabel_td1">���</td>
      <td width="5%" align="center" class="tabel_td1">״̬</td>
      <td width="5%" align="center" class="tabel_td1">�鿴</td>
      <td width="5%" align="center" class="tabel_td1">�޸�</td>
      <td width="5%" align="center" class="tabel_td1">ɾ��</td>
    </tr>
    <c:forEach var="standardInfo" items="${standardList}" varStatus="statu"> 
    	<tr height="22" nowrap class="<c:if test="${statu.count%2==0}">list_tr</c:if><c:if test="${statu.count%2!=0}">list_tr1</c:if>"> 
			  <td height="26" align="center" ><c:out value="${statu.count}"/></td>
			  <td height="26" align="center" ><gOS_shjz:dictValue key='${standardInfo.scopeId}'  typeName="BZSYFW"/></td>	  		
	  		<td align="center" ><gOS_shjz:regionValue key='${standardInfo.areaId}' /></td>
	  		<td align="center" ><gOS_shjz:dictValue key='${standardInfo.standardType}'  typeName="ZCBZZLX"/></td>	
			  <td align="center" ><gOS_shjz:dictValue key='${standardInfo.subType}'  typeName="ZCBZZLX1"/></td>	
			  <td align="center" ><c:out value='${standardInfo.sum}' /></td>				  	 	  			 
	  		<td align="center">
				<c:choose>
					<c:when test="${standardInfo.stopFlag == 1 }">						
							<c:if test="${!standardInfo.stop}"><B>����</B></c:if>
							<c:if test="${standardInfo.stop}"><B>ͣ��</B></c:if>						
					</c:when>
					<c:when test="${standardInfo.stopFlag == 0 }">
						<B>δ����</B>
					</c:when>					
				</c:choose>
			  </td>
			  <td align="center" ><a href="javascript:doShowStandard(<c:out value='${standardInfo.id}' />);"><font color="blue">�鿴</font></a></td>
			  <td align="center" ><a href="javascript:doEditStandard(<c:out value='${standardInfo.id}' />, <c:out value='${standardInfo.stopFlag}' />);"><font color="blue">�޸�</font></a></td>
			  <td align="center" ><a href="javascript:doDelStandard(<c:out value='${standardInfo.id}' />, <c:out value='${standardInfo.stopFlag}' />);"><font color="blue">ɾ��</font></a></td>
		  </tr>
    </c:forEach>    
  </table>
	</c:if>
	<c:if test="${!empty param.adjustFlag}">
	<table width="96%" border="0" align="center" cellpadding="1" cellspacing="1" bgcolor="#CCCCCC">
    <tr>
      <td width="4%" align="center" class="tabel_td1">���</td>
      <td width="10%" align="center" class="tabel_td1">���÷�Χ</td>
      <td width="8%" align="center" class="tabel_td1">����</td>
      <td width="10%" align="center" class="tabel_td1">����</td>
      <td width="25%" align="center" class="tabel_td1">������</td>
      <td width="7%" align="center" class="tabel_td1">����ǰ���</td>
      <td width="8%" align="center" class="tabel_td1">��������</td>
      <td width="5%" align="center" class="tabel_td1">�������</td>
      <td width="5%" align="center" class="tabel_td1">��������</td>
    </tr>
    <c:forEach var="standardInfo" items="${standardList}" varStatus="statu"> 
    	<tr height="22" nowrap class="<c:if test="${statu.count%2==0}">list_tr</c:if><c:if test="${statu.count%2!=0}">list_tr1</c:if>"> 
			  <td height="26" align="center" ><c:out value="${statu.count}"/></td>
			  <td height="26" align="center" ><gOS_shjz:dictValue key='${standardInfo.scopeId}'  typeName="BZSYFW"/></td>	  		
	  		<td align="center" ><gOS_shjz:regionValue key='${standardInfo.areaId}' /></td>
	  		<td align="center" ><gOS_shjz:dictValue key='${standardInfo.standardType}'  typeName="ZCBZZLX"/></td>	
			  <td align="center" ><gOS_shjz:dictValue key='${standardInfo.subType}'  typeName="ZCBZZLX1"/></td>	
			  <td align="left" ><c:out value='${standardInfo.sum}' /></td>		
			  <td align="left" ><c:out value='${standardInfo.adjustSum}' /></td>	
			  <td align="center"><c:if test="${standardInfo.adjustFlag==1}"><font color="red">�ѵ���</font></c:if><c:if test="${standardInfo.adjustFlag==0}">δ����</c:if><c:if test="${standardInfo.adjustFlag==2}"><font color="blue">������...</font></c:if></td>		  	 	  			 
			  <td align="center" ><a href="javascript:doAdjustStandard(<c:out value='${standardInfo.id}' />);"><font color="blue">��������</font></a></td>
		  </tr>
    </c:forEach>  
  </table>	
  
	</c:if>
  <table>
   <tr class="list_tr3">
   	<td >
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table-line">
				<tr>          
					<td align="right" class="listTable_page" >										         			   
						<gOS:page name="dataPage" pageName="dataPage" action="standardInfoList.do?method=getList">         			   
						<gOS:param name="standardType"><c:out value="${param.standardType}" /></gOS:param>
						<gOS:param name="areaId"><c:out value="${param.areaId}" /></gOS:param>
						<gOS:param name="stopFlag"><c:out value="${param.stopFlag}" /></gOS:param>
						<gOS:param name="adjustFlag"><c:out value="${param.adjustFlag}" /></gOS:param>
						</gOS:page>							
			    </td>
			  </tr>		
      </table>	
   	</td>
   </tr>
 </table>
</body>
</html>