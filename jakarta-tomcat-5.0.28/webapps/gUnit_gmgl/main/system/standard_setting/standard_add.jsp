<%@ page contentType="text/html; charset=GBK" %>
<%@ include file="../../../common/taglibs.jsp"%>
<style>
	<!--
	select {width:100%}
	-->
</style>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
<title>���߲�������</title>
<link href="../../../css/css.css" rel="stylesheet" type="text/css">
<script language="JavaScript" src="../../../script/publics.js"></script>
<script language="JavaScript" src="../../../script/calendar.js"></script>
<script language="JavaScript" src="../../../script/area.js"></script>
<script type="text/javascript" src="../../../dwr/engine.js"></script>
<script type="text/javascript" src="../../../dwr/util.js"></script>
<script type="text/javascript" src="../../../dwr/interface/DictUtil.js"></script>
<style type="text/css">
<!--
body {
	background-color: #F3FBFD;
}
-->
</style></head>

<script language="javascript">
	
	function addStandard(){
		var strForm = document.jzStandardInfoForm;
		
		if(strForm.standardType.value==-1 ){
			alert(" ����ѡ��<���߱�׼����>��");
			strForm.standardType.focus();
			return false;
		}
		if(strForm.subType.value==-1 ){
			alert(" ����ѡ��<���߱�׼�����>��");
			strForm.subType.focus();
			return false;
		}
		if(Jtrim(strForm.sum.value).length==0){
			window.alert(" <���߱�׼���>����Ϊ�գ�")
			strForm.sum.focus();
			return false;
		}else	if(strForm.sum.value==0){
			window.alert(" <���߱�׼���>�������0��")
			strForm.sum.focus();
			return false;
		}
		if(Jtrim(strForm.startDateStr.value).length==0){
			window.alert(" ������<��׼��Чʱ��>")
			strForm.startDateStr.focus();
			return false;
		}
		if(Jtrim(strForm.stopDateStr.value).length==0){
			window.alert(" ������<��׼ʧЧʱ��>")
			strForm.stopDateStr.focus();
			return false;
		}
		
		if(Jtrim(strForm.stopDateStr.value) < Jtrim(strForm.startDateStr.value)){
			window.alert(" <��׼ʧЧʱ��>����С��<��׼��Чʱ��>")
			strForm.stopDateStr.focus();
			return false;
		}
		
		var strUrl = "addOrEditStandardInfo.do?method=addOrEditStandardInfo";
		strForm.action = strUrl;
		strForm.submit();
	}
	
	function getSubType(typeId){
		var strForm = document.jzStandardInfoForm;
		DictUtil.getDictsSelect(typeId, "subType", "���߱�׼�����", function(typeDict){document.getElementById("subTypeDiv").innerHTML=typeDict;});
		if(strForm.standardType.selectedIndex == 0)
		{
			strForm.name.value="";
		} else {
			strForm.name.value = strForm.standardType[strForm.standardType.selectedIndex].text;
		}
	}
	
	function adjustStandard(){
		var strForm = document.jzStandardInfoForm;
		
		if(Jtrim(strForm.adjustSum.value).length==0){
			window.alert(" <���߱�׼���>����Ϊ�գ�")
			strForm.adjustSum.focus();
			return false;
		}else	if(strForm.adjustSum.value==0){
			window.alert(" <���߱�׼���>�������0��")
			strForm.adjustSum.focus();
			return false;
		}
		if(Jtrim(strForm.startDateStr.value).length==0){
			window.alert(" ������<��׼��Чʱ��>")
			strForm.startDateStr.focus();
			return false;
		}
		if(Jtrim(strForm.stopDateStr.value).length==0){
			window.alert(" ������<��׼ʧЧʱ��>")
			strForm.stopDateStr.focus();
			return false;
		}
		
		if(Jtrim(strForm.stopDateStr.value) < Jtrim(strForm.startDateStr.value)){
			window.alert(" <��׼ʧЧʱ��>����С��<��׼��Чʱ��>")
			strForm.stopDateStr.focus();
			return false;
		}
		var strUrl = "addOrEditStandardInfo.do?method=addOrEditStandardInfo&adjustFlag=true";
		strForm.action = strUrl;
		strForm.submit();
	}
	
	function init(){
		<c:if test="${empty param.adjustFlag}">
		var areaId = '<c:out value="${jzStandardInfoForm.scopeId}"/>';
		var areaObj = document.getElementById('areaId');
		if(areaId!=''){
			for(var i=0,j=areaObj.length;i<j;i++){
				if(areaId==areaObj.options[i].value){
					areaObj.options[i].selected=true;
					break;
				}	
			}
		}
		</c:if>
	}
</script>

<body onload="init()">
<form name="jzStandardInfoForm" method="post" action="">
<input name="id" type="hidden" value="<c:out value='${jzStandardInfoForm.id}'/>"/>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
	  <tr>
	    <td height="45" align="center" class="biaoti_3">
	    	���߲���<c:if test="${!(empty param.adjustFlag)}">����</c:if>
	    </td>
	  </tr>
  </table> 
  <c:if test="${empty param.adjustFlag}">
	<table width="50%" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td align="center" bgcolor="#FFFFFF" class="biankuang1">
      	<table width="100%" border="0" cellpadding="0" cellspacing="2" class="biankuang2">
	        <tr>
            <td width="20%" height="25" align="right" class="table_td7">���߱�׼���÷�Χ��</td>            
            <td width="30%" align="left" class="table_td7">
            	<gOS:select name="scopeId" items="class{com.topsuntech.gUnit.gEU_util.taglib.ShjzDictListProvide($request,BZSYFW)}" keyProperty="key" valueProperty="value" selected="${jzStandardInfoForm.scopeId}" styleClass="select"  style="width:200px" >
							</gOS:select>
            </td>
          </tr> 
          <tr>
            <td width="20%" height="25" align="right" class="table_td7">�����������ƣ�</td>            
            <td width="30%" align="left" class="table_td7" id="scope1" >            	
        			<select name="areaId" id="areaId" style="width:200px" >
        				<option value="2">������</option>
            ����<option value="4">������</option>
            ����<option value="8">������</option>
            ����<option value="463">������</option>
            ����<option value="301">��̨��</option>
            ����<option value="461">������</option>
            ����<option value="462">������</option>
            ����<option value="464">������</option>
            ����<option value="466">ͨ����</option>
            ����<option value="467">ʯ��ɽ��</option>
            ����<option value="468">������</option>
                <option value="469">��ɽ��</option>
            ����<option value="470">��ͷ����</option>
            ����<option value="471">ƽ����</option>
            ����<option value="472">������</option>
            ����<option value="473">������</option>
            ����<option value="474">������</option>
            ����<option value="475">��ƽ��</option>
            ����<option value="476">˳����</option>
            ��</select>            		
            </td>
          </tr> 
          <tr>
            <td width="20%" height="25" align="right" class="table_td7">���߱�׼���ͣ�</td>            
            <td width="30%" align="left" class="table_td7" >
            	<gOS:select name="standardType" items="class{com.topsuntech.gUnit.gEU_util.taglib.ShjzDictListProvide($request,ZCBZLX)}" keyProperty="key" valueProperty="value" selected="${jzStandardInfoForm.standardType}" styleClass="select"  style="width:200px" onchange="getSubType(this.value)">
								<gOS:option key="-1" value="--��ѡ�����߱�׼����--" />
							</gOS:select>
            </td>
            <input type="hidden" name="name" value=""/>
          </tr> 
          <tr>
            <td width="20%" height="25" align="right" class="table_td7">���߱�׼�����</td>            
            <td width="30%" align="left" class="table_td7" >
            	<div id="subTypeDiv">
            	<select name="subType" style="width:200px" >
            ����<option value="" >----��ѡ�����߱�׼�����----</option>            
            ��</select>
              </div>
            </td>
          </tr> 
          <tr>
            <td width="20%" height="25" align="right" class="table_td7">���߱�׼��</td>            
            <td width="30%" align="left" class="table_td7" >
            	<input name="sum" type="text" class="form_text1" size="18" value="<c:out value='${jzStandardInfoForm.sum}'/>"  style="width:200px" />
            </td>
          </tr> 
          <tr>
            <td width="20%" height="25" align="right" class="table_td7">���߱�׼��Ч���ڣ�</td>            
            <td width="30%" align="left" class="table_td7" >
            	<input name="startDateStr" value="<c:out value='${jzStandardInfoForm.startDateStr}'/>" readonly="true" type="text" class="form_text1"  size="10" onclick="calendar()" style="width:200px" >
            </td>
          </tr> 
          <tr>
            <td width="20%" height="25" align="right" class="table_td7">���߱�׼ʧЧ���ڣ�</td>            
            <td width="30%" align="left" class="table_td7" >
            	<input name="stopDateStr" value="<c:out value='${jzStandardInfoForm.stopDateStr}'/>" readonly="true" type="text" class="form_text1"  size="10" onclick="calendar()" style="width:200px" >
            </td>
          </tr> 
          <tr>
            <td width="20%" height="25" align="right" class="table_td7">���߱�׼�Ƿ����ã�</td>            
            <td width="30%" align="left" class="table_td7" >
            	<select name="stopFlag" style="width:200px" >
            ����<option value="0" <c:if test='${jzStandardInfoForm.stopFlag == 0}'>selected</c:if> >��</option>
            ����<option value="1" <c:if test='${jzStandardInfoForm.stopFlag == 1}'>selected</c:if> >��</option>            ����
            ��</select>
            </td>
          </tr> 
          <tr>
            <td width="20%" height="25" align="right" class="table_td7">���߱�׼��˵����</td>            
            <td width="30%" align="left" class="table_td7" >
            	<textarea id="description" name="description" cols="26" rows="4" ><c:out value='${jzStandardInfoForm.description}' /></textarea>
            </td>
          </tr>           
	      </table>
	    </td>
    </tr>
  </table>
	</c:if>  
	 <c:if test="${!empty param.adjustFlag}">
	<table width="50%" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td align="center" bgcolor="#FFFFFF" class="biankuang1">
      	<table width="100%" border="0" cellpadding="0" cellspacing="2" class="biankuang2">
	        <tr>
            <td width="20%" height="25" align="right" class="table_td7">���߱�׼���÷�Χ��</td>            
            <td width="30%" align="left" class="table_td7">
            	<gOS_shjz:dictValue key='${jzStandardInfoForm.scopeId}'  typeName="BZSYFW"/>
            </td>
          </tr> 
          <tr>
            <td width="20%" height="25" align="right" class="table_td7">�����������ƣ�</td>            
            <td width="30%" align="left" class="table_td7" id="scope1" >            	
        			<gOS_shjz:regionValue key='${jzStandardInfoForm.areaId}' />
            </td>
          </tr> 
          <tr>
            <td width="20%" height="25" align="right" class="table_td7">���߱�׼���ͣ�</td>            
            <td width="30%" align="left" class="table_td7" >
            	<gOS_shjz:dictValue key='${jzStandardInfoForm.standardType}'  typeName="ZCBZZLX"/>
            </td>
          </tr> 
          <tr>
            <td width="20%" height="25" align="right" class="table_td7">���߱�׼�����</td>            
            <td width="30%" align="left" class="table_td7" >
            	<gOS_shjz:dictValue key='${jzStandardInfoForm.subType}'  typeName="ZCBZZLX1"/>
            </td>
          </tr>
          <tr>
            <td width="20%" height="25" align="right" class="table_td7">���߱�׼ԭ��</td>            
            <td width="30%" align="left" class="table_td7" >
            	<c:out value='${jzStandardInfoForm.sum}' />
            </td>
          </tr> 
          <tr>
            <td width="20%" height="25" align="right" class="table_td7">�������</td>            
            <td width="30%" align="left" class="table_td7" >
            <input name="adjustSum" type="text" class="form_text1" size="18" value="<c:out value='${jzStandardInfoForm.adjustSum}'/>"  style="width:200px" />
            <input type="hidden" name="sum" value="<c:out value="${jzStandardInfoForm.sum}"/>">	
            </td>
          </tr>                       
          <tr>
            <td width="20%" height="25" align="right" class="table_td7">���߱�׼��Ч���ڣ�</td>            
            <td width="30%" align="left" class="table_td7" >
            	<input name="startDateStr" value="<c:out value='${jzStandardInfoForm.startDateStr}'/>" readonly="true" type="text" class="form_text1"  size="10" onclick="calendar()" style="width:200px" >
            </td>
          </tr> 
          <tr>
            <td width="20%" height="25" align="right" class="table_td7">���߱�׼ʧЧ���ڣ�</td>            
            <td width="30%" align="left" class="table_td7" >
            	<input name="stopDateStr" value="<c:out value='${jzStandardInfoForm.stopDateStr}'/>" readonly="true" type="text" class="form_text1"  size="10" onclick="calendar()" style="width:200px" >
            </td>
          </tr> 
          <tr>
            <td width="20%" height="25" align="right" class="table_td7">���߱�׼�Ƿ����ã�</td>            
            <td width="30%" align="left" class="table_td7" >
            	<c:if test="${jzStandardInfoForm.stopFlag == 0}">��</c:if>
            	<c:if test="${jzStandardInfoForm.stopFlag != 0}">��</c:if>
            </td>
          </tr> 
          <tr>
            <td width="20%" height="25" align="right" class="table_td7">���߱�׼��˵����</td>            
            <td width="30%" align="left" class="table_td7" >
            	<textarea id="description" name="description" cols="26" rows="4" ><c:out value='${jzStandardInfoForm.description}' /></textarea>
            </td>
          </tr>           
	      </table>
	    </td>
    </tr>
  </table>
	</c:if>  
	
  <table width="80%" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td>&nbsp;</td>
    </tr>
  </table>  
  <table width="96%" border="0" align="center" cellpadding="0" cellspacing="0">
    
    <tr>
      <td align="center" bgcolor="#FFFFFF" class="biankuang1">
      </td>
    </tr>
  </table>
  <table width="30%" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td height="60" align="center"><label>
        <img name="imageField" src="../../../images/bt_submit.gif" onClick="<c:if test="${empty param.adjustFlag}">addStandard();</c:if><c:if test="${!empty param.adjustFlag}">adjustStandard()</c:if>" style="cursor:hand"/>
      </label></td>
      <td align="center"><label>
         <img src="../../../images/bt_back.gif"  onclick="javascript:window.history.back();" style="cursor:hand">
      </label></td>
    </tr>
  </table>
</form>    
</body>
<c:if test="${editFlag == 1&&empty param.adjustFlag}">
	<script language="javascript">
		//����DWRΪͬ��
		DWREngine.setAsync(false);
		getSubType(<c:out value="${jzStandardInfoForm.standardType}"/>);
		document.jzStandardInfoForm.subType.value=<c:out value="${jzStandardInfoForm.subType}"/>;
		//����DWRΪ�첽
		DWREngine.setAsync(true);	
	</script>
</c:if>
</html>