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
<title>政策参数设置</title>
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
			alert(" 请先选择<政策标准类型>！");
			strForm.standardType.focus();
			return false;
		}
		if(strForm.subType.value==-1 ){
			alert(" 请先选择<政策标准子类别>！");
			strForm.subType.focus();
			return false;
		}
		if(Jtrim(strForm.sum.value).length==0){
			window.alert(" <政策标准金额>不能为空！")
			strForm.sum.focus();
			return false;
		}else	if(strForm.sum.value==0){
			window.alert(" <政策标准金额>必须大于0！")
			strForm.sum.focus();
			return false;
		}
		if(Jtrim(strForm.startDateStr.value).length==0){
			window.alert(" 请输入<标准生效时间>")
			strForm.startDateStr.focus();
			return false;
		}
		if(Jtrim(strForm.stopDateStr.value).length==0){
			window.alert(" 请输入<标准失效时间>")
			strForm.stopDateStr.focus();
			return false;
		}
		
		if(Jtrim(strForm.stopDateStr.value) < Jtrim(strForm.startDateStr.value)){
			window.alert(" <标准失效时间>不能小于<标准生效时间>")
			strForm.stopDateStr.focus();
			return false;
		}
		
		var strUrl = "addOrEditStandardInfo.do?method=addOrEditStandardInfo";
		strForm.action = strUrl;
		strForm.submit();
	}
	
	function getSubType(typeId){
		var strForm = document.jzStandardInfoForm;
		DictUtil.getDictsSelect(typeId, "subType", "政策标准子类别", function(typeDict){document.getElementById("subTypeDiv").innerHTML=typeDict;});
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
			window.alert(" <政策标准金额>不能为空！")
			strForm.adjustSum.focus();
			return false;
		}else	if(strForm.adjustSum.value==0){
			window.alert(" <政策标准金额>必须大于0！")
			strForm.adjustSum.focus();
			return false;
		}
		if(Jtrim(strForm.startDateStr.value).length==0){
			window.alert(" 请输入<标准生效时间>")
			strForm.startDateStr.focus();
			return false;
		}
		if(Jtrim(strForm.stopDateStr.value).length==0){
			window.alert(" 请输入<标准失效时间>")
			strForm.stopDateStr.focus();
			return false;
		}
		
		if(Jtrim(strForm.stopDateStr.value) < Jtrim(strForm.startDateStr.value)){
			window.alert(" <标准失效时间>不能小于<标准生效时间>")
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
	    	政策参数<c:if test="${!(empty param.adjustFlag)}">调整</c:if>
	    </td>
	  </tr>
  </table> 
  <c:if test="${empty param.adjustFlag}">
	<table width="50%" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td align="center" bgcolor="#FFFFFF" class="biankuang1">
      	<table width="100%" border="0" cellpadding="0" cellspacing="2" class="biankuang2">
	        <tr>
            <td width="20%" height="25" align="right" class="table_td7">政策标准适用范围：</td>            
            <td width="30%" align="left" class="table_td7">
            	<gOS:select name="scopeId" items="class{com.topsuntech.gUnit.gEU_util.taglib.ShjzDictListProvide($request,BZSYFW)}" keyProperty="key" valueProperty="value" selected="${jzStandardInfoForm.scopeId}" styleClass="select"  style="width:200px" >
							</gOS:select>
            </td>
          </tr> 
          <tr>
            <td width="20%" height="25" align="right" class="table_td7">所属区域名称：</td>            
            <td width="30%" align="left" class="table_td7" id="scope1" >            	
        			<select name="areaId" id="areaId" style="width:200px" >
        				<option value="2">北京市</option>
            　　<option value="4">朝阳区</option>
            　　<option value="8">海淀区</option>
            　　<option value="463">崇文区</option>
            　　<option value="301">丰台区</option>
            　　<option value="461">东城区</option>
            　　<option value="462">西城区</option>
            　　<option value="464">宣武区</option>
            　　<option value="466">通州区</option>
            　　<option value="467">石景山区</option>
            　　<option value="468">大兴区</option>
                <option value="469">房山区</option>
            　　<option value="470">门头沟区</option>
            　　<option value="471">平谷区</option>
            　　<option value="472">密云区</option>
            　　<option value="473">怀柔区</option>
            　　<option value="474">延庆区</option>
            　　<option value="475">昌平区</option>
            　　<option value="476">顺义区</option>
            　</select>            		
            </td>
          </tr> 
          <tr>
            <td width="20%" height="25" align="right" class="table_td7">政策标准类型：</td>            
            <td width="30%" align="left" class="table_td7" >
            	<gOS:select name="standardType" items="class{com.topsuntech.gUnit.gEU_util.taglib.ShjzDictListProvide($request,ZCBZLX)}" keyProperty="key" valueProperty="value" selected="${jzStandardInfoForm.standardType}" styleClass="select"  style="width:200px" onchange="getSubType(this.value)">
								<gOS:option key="-1" value="--请选择政策标准类型--" />
							</gOS:select>
            </td>
            <input type="hidden" name="name" value=""/>
          </tr> 
          <tr>
            <td width="20%" height="25" align="right" class="table_td7">政策标准子类别：</td>            
            <td width="30%" align="left" class="table_td7" >
            	<div id="subTypeDiv">
            	<select name="subType" style="width:200px" >
            　　<option value="" >----请选择政策标准子类别----</option>            
            　</select>
              </div>
            </td>
          </tr> 
          <tr>
            <td width="20%" height="25" align="right" class="table_td7">政策标准金额：</td>            
            <td width="30%" align="left" class="table_td7" >
            	<input name="sum" type="text" class="form_text1" size="18" value="<c:out value='${jzStandardInfoForm.sum}'/>"  style="width:200px" />
            </td>
          </tr> 
          <tr>
            <td width="20%" height="25" align="right" class="table_td7">政策标准生效日期：</td>            
            <td width="30%" align="left" class="table_td7" >
            	<input name="startDateStr" value="<c:out value='${jzStandardInfoForm.startDateStr}'/>" readonly="true" type="text" class="form_text1"  size="10" onclick="calendar()" style="width:200px" >
            </td>
          </tr> 
          <tr>
            <td width="20%" height="25" align="right" class="table_td7">政策标准失效日期：</td>            
            <td width="30%" align="left" class="table_td7" >
            	<input name="stopDateStr" value="<c:out value='${jzStandardInfoForm.stopDateStr}'/>" readonly="true" type="text" class="form_text1"  size="10" onclick="calendar()" style="width:200px" >
            </td>
          </tr> 
          <tr>
            <td width="20%" height="25" align="right" class="table_td7">政策标准是否启用：</td>            
            <td width="30%" align="left" class="table_td7" >
            	<select name="stopFlag" style="width:200px" >
            　　<option value="0" <c:if test='${jzStandardInfoForm.stopFlag == 0}'>selected</c:if> >否</option>
            　　<option value="1" <c:if test='${jzStandardInfoForm.stopFlag == 1}'>selected</c:if> >是</option>            　　
            　</select>
            </td>
          </tr> 
          <tr>
            <td width="20%" height="25" align="right" class="table_td7">政策标准简单说明：</td>            
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
            <td width="20%" height="25" align="right" class="table_td7">政策标准适用范围：</td>            
            <td width="30%" align="left" class="table_td7">
            	<gOS_shjz:dictValue key='${jzStandardInfoForm.scopeId}'  typeName="BZSYFW"/>
            </td>
          </tr> 
          <tr>
            <td width="20%" height="25" align="right" class="table_td7">所属区域名称：</td>            
            <td width="30%" align="left" class="table_td7" id="scope1" >            	
        			<gOS_shjz:regionValue key='${jzStandardInfoForm.areaId}' />
            </td>
          </tr> 
          <tr>
            <td width="20%" height="25" align="right" class="table_td7">政策标准类型：</td>            
            <td width="30%" align="left" class="table_td7" >
            	<gOS_shjz:dictValue key='${jzStandardInfoForm.standardType}'  typeName="ZCBZZLX"/>
            </td>
          </tr> 
          <tr>
            <td width="20%" height="25" align="right" class="table_td7">政策标准子类别：</td>            
            <td width="30%" align="left" class="table_td7" >
            	<gOS_shjz:dictValue key='${jzStandardInfoForm.subType}'  typeName="ZCBZZLX1"/>
            </td>
          </tr>
          <tr>
            <td width="20%" height="25" align="right" class="table_td7">政策标准原金额：</td>            
            <td width="30%" align="left" class="table_td7" >
            	<c:out value='${jzStandardInfoForm.sum}' />
            </td>
          </tr> 
          <tr>
            <td width="20%" height="25" align="right" class="table_td7">调整后金额：</td>            
            <td width="30%" align="left" class="table_td7" >
            <input name="adjustSum" type="text" class="form_text1" size="18" value="<c:out value='${jzStandardInfoForm.adjustSum}'/>"  style="width:200px" />
            <input type="hidden" name="sum" value="<c:out value="${jzStandardInfoForm.sum}"/>">	
            </td>
          </tr>                       
          <tr>
            <td width="20%" height="25" align="right" class="table_td7">政策标准生效日期：</td>            
            <td width="30%" align="left" class="table_td7" >
            	<input name="startDateStr" value="<c:out value='${jzStandardInfoForm.startDateStr}'/>" readonly="true" type="text" class="form_text1"  size="10" onclick="calendar()" style="width:200px" >
            </td>
          </tr> 
          <tr>
            <td width="20%" height="25" align="right" class="table_td7">政策标准失效日期：</td>            
            <td width="30%" align="left" class="table_td7" >
            	<input name="stopDateStr" value="<c:out value='${jzStandardInfoForm.stopDateStr}'/>" readonly="true" type="text" class="form_text1"  size="10" onclick="calendar()" style="width:200px" >
            </td>
          </tr> 
          <tr>
            <td width="20%" height="25" align="right" class="table_td7">政策标准是否启用：</td>            
            <td width="30%" align="left" class="table_td7" >
            	<c:if test="${jzStandardInfoForm.stopFlag == 0}">是</c:if>
            	<c:if test="${jzStandardInfoForm.stopFlag != 0}">否</c:if>
            </td>
          </tr> 
          <tr>
            <td width="20%" height="25" align="right" class="table_td7">政策标准简单说明：</td>            
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
		//设置DWR为同步
		DWREngine.setAsync(false);
		getSubType(<c:out value="${jzStandardInfoForm.standardType}"/>);
		document.jzStandardInfoForm.subType.value=<c:out value="${jzStandardInfoForm.subType}"/>;
		//设置DWR为异步
		DWREngine.setAsync(true);	
	</script>
</c:if>
</html>