<%@ page contentType="text/html; charset=GBK" %>
<%@ include file="../../common/taglibs.jsp"%>
<%@ include file="../../common/js_common.jsp"%>
<link href="../../css/css.css" rel="stylesheet" type="text/css">
<%
	String cityId = request.getParameter("cityId");
	String countyId = request.getParameter("countyId");
	String streetId = request.getParameter("streetId");
	String communityId= request.getParameter("communityId");
%>

<%@page import="com.topsuntech.gOS.user.session.*" %>
<%@page import="com.topsuntech.gOS.user.en.user.*" %>
<html>
<head>
<title>新增区域</title>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">

<script src="../../script/publics.js"></script>
<script type='text/javascript' src='../../dwr/engine.js'></script>
<script type='text/javascript' src='../../dwr/util.js'></script>
<script>

function changeType(){
		var adjustLevel=document.getElementById("adjustLevel").value;
		
		if(adjustLevel==0){
		document.getElementById("divOne").style.display='none';
		document.getElementById("divTwo").style.display='none';
		document.getElementById("divThree").style.display='none';;
		}
		
		if(adjustLevel==50164){
		document.getElementById("divOne").style.display='block';
		document.getElementById("divTwo").style.display='none';
		document.getElementById("divThree").style.display='none';;
		}
		
		if(adjustLevel==50165){
		
		document.getElementById("divOne").style.display='none';
		document.getElementById("divTwo").style.display='block';
		document.getElementById("divThree").style.display='none';;
		}
		
		if(adjustLevel==50166){
		document.getElementById("divOne").style.display='none';
		document.getElementById("divTwo").style.display='none';
		document.getElementById("divThree").style.display='block';
		}


}

function setSelectCounty(text,value){
//alert("oooooooook");
	var obj=document.getElementById("adjustCountyIdsOne");
	obj.options.add(new Option(text,value));
}
function setSelectStreet(text,value){
	
	var obj=document.getElementById("adjustStreetIdsTwo");
//	alert(obj.options.length);
	obj.options.add(new Option(text,value));
}
function setSelectCommunity(text,value){
//alert("oooooooook");
	var obj=document.getElementById("adjustCommunityIdsThree");
	obj.options.add(new Option(text,value));
}

function doDelSelectCounty () {
  	var s = document.getElementById("adjustCountyIdsOne");
	var seleIndex=s.selectedIndex;
	if(seleIndex!=-1){
		s.options.remove(seleIndex);
		return;
	}else{
		alert("请选择一个区划。");
	}
}

function doDelSelectStreet () {
//alert("streetId")
  	var s = document.getElementById("adjustStreetIdsTwo");
	var seleIndex=s.selectedIndex;
	if(seleIndex!=-1){
		s.options.remove(seleIndex);
		return;
	}else{
		alert("请选择一个区划。");
	}
}

function doDelSelectCommunity () {
  	var s = document.getElementById("adjustCommunityIdsThree");
	var seleIndex=s.selectedIndex;
	if(seleIndex!=-1){
		s.options.remove(seleIndex);
		return;
	}else{
		alert("请选择一个区划。");
	}
}
function goBack(){

history.go(-1);

}

function goNext(){

	var adjustType=document.getElementById("adjustType").value;
		var adjustLevel=document.getElementById("adjustLevel").value;
		var stopDates=document.getElementById("stopDates").value;
		//alert(adjustLevel);
		if(adjustLevel==0){
		
		alert("请选择合并类型");
		return;
		}		
		else if(adjustLevel==50164){
	//	alert("ooooook");
		var newCountyIds=document.getElementById("newCountyIdsOne").value;
		var newCountyNames=document.getElementById("newCountyNamesOne").value;
		var adjustCountyIds =document.getElementById("adjustCountyIdsOne");
				if(adjustCountyIds.length==0){
						
						alert("请选择被合并区县");
						return;
						}		
				if(newCountyIds==""){
						
						alert("请选择新合并区县");
						return;
						}

		
		//alert(url);
				if(stopDates==""){
		
					alert("请选择原区划停用时间");
					return;
					}
		//	var adjustCountyIds =document.getElementById("adjustCountyIdsOne");		
		var adjustCountyId="";
		var adjustCountyName="";
		for (var i=0;i<adjustCountyIds.length ;i++ )
			{	

			      adjustCountyId += adjustCountyIds.options[i].value +",";
				  adjustCountyName+=adjustCountyIds.options[i].innerText+",";

		}
				var url = "is_done.jsp?cityId="+20001
							+"&adjustLevel="+adjustLevel
							+"&adjustType="+adjustType
							+"&adjustCountyIds="+adjustCountyId
							+"&adjustCountyNames="+adjustCountyName
							+"&newCountyIds="+newCountyIds
							+"&newCountyNames="+newCountyNames
							+"&stopDates="+stopDates
							+"";
		
      //  msgWindow=window.open(url,"protypeWindow","toolbar=no,width=600,height=600,directories=no,status=no,scrollbars=yes,resize=no,menubar=no")
      
	 //   msgWindow.focus();
		 replaceRegion(url);
		}
		else if(adjustLevel==50165){
		//alert("oooooooooooooooooook");
		var adjustCountyIds=document.getElementById("adjustCountyIdsTwo").value;
		var adjustCountyNames=document.getElementById("adjustCountyNamesTwo").value;
		var newStreetIds=document.getElementById("newStreetIdsTwo").value;
		var newStreetNames=document.getElementById("newStreetNamesTwo").value;
		var newCountyIds=document.getElementById("newCountyIdsTwo").value;
		var newCountyNames=document.getElementById("newCountyNamesTwo").value;
		var adjustStreetIds =document.getElementById("adjustStreetIdsTwo");	
		
				if(adjustCountyIds==""){
						
						alert("请选择被合并区县");
						return;
						}
						if(adjustStreetIds.length==0){
						
						alert("请选择被合并街道");
						return;
						}
					if(newCountyIds==""){
						
						alert("请选择新区县");
						return;
						}
						if(newCountyIds!=adjustCountyIds){
						
						alert("新区划街道所属区县应与被合并街道所属区县一致");
						return;
						}
						if(newStreetIds==""){
						
						alert("请选择新街道");
						return;
						}
		//				var adjustStreetIds =document.getElementById("adjustStreetIdsOne");		
		var adjustStreetId="";
		var adjustStreetName="";
		for (var i=0;i<adjustStreetIds.length ;i++ )
			{	

			      adjustStreetId += adjustStreetIds.options[i].value +",";
				  adjustStreetName+=adjustStreetIds.options[i].innerText+",";

		}

		var url = "is_done.jsp?cityId="+20001
							+"&adjustLevel="+adjustLevel
							+"&adjustType="+adjustType
							+"&adjustCountyIds="+adjustCountyIds
							+"&adjustCountyNames="+adjustCountyNames
							+"&adjustStreetIds="+adjustStreetId
							+"&adjustStreetNames="+adjustStreetName
							+"&newCountyIds="+adjustCountyIds
							+"&newCountyNames="+adjustCountyNames
							+"&newStreetIds="+newStreetIds
							+"&newStreetNames="+newStreetNames
							+"&stopDates="+stopDates
							+"";
		if(stopDates==""){
		
					alert("请选择原区划停用时间");
					return;
					}
		
     //   msgWindow=window.open(url,"protypeWindow","toolbar=no,width=600,height=600,directories=no,status=no,scrollbars=yes,resize=no,menubar=no")
      
	  //  msgWindow.focus();
		 replaceRegion(url);
		}
		else if(adjustLevel==50166){
		
		var adjustCountyIds=document.getElementById("adjustCountyIdsThree").value;
		var adjustCountyNames=document.getElementById("adjustCountyNamesThree").value;
		var adjustStreetIds=document.getElementById("adjustStreetIdsThree").value;
		var adjustStreetNames=document.getElementById("adjustStreetNamesThree").value;
		
		var newCommunityIds=document.getElementById("newCommunityIdsThree").value;
		var newCommunityNames=document.getElementById("newCommunityNamesThree").value;
		
		
		var newCountyIds=document.getElementById("newCountyIdsThree").value;
		var newCountyNames=document.getElementById("newCountyNamesThree").value;
		var newStreetIds=document.getElementById("newStreetIdsThree").value;
		var newStreetNames=document.getElementById("newStreetNamesThree").value;
		var adjustCommunityIds =document.getElementById("adjustCommunityIdsThree");	
						if(adjustCountyIds==""){
						
						alert("请选择被合并区县");
						return;
						}
						if(adjustStreetIds==""){
						
						alert("请选择被合并街道");
						return;
						}
						if(adjustCommunityIds.length==0){
						
						alert("请选择被合并社区");
						return;
						}
						if(newCountyIds==""){
						
						alert("请选择新区县");
						return;
						
						}
						
						if(newCountyIds!=adjustCountyIds){
						
						alert("新区划社区所属区县应与被合并社区所属区县一致");
						return;
						}
						if(newStreetIds==""){
						
						alert("请选择新街道");
						return;
						
						}
						if(newStreetIds!=adjustStreetIds){
						
						alert("新区划社区所属街道应与被合并社区所属街道一致");
						return;
						}
						if(newCommunityIds==""){
						
						alert("请选择新社区");
						return;
						
						}
							
		var adjustCommunityId="";
		var adjustCommunityName="";
		for (var i=0;i<adjustCommunityIds.length ;i++ )
			{	

			      adjustCommunityId += adjustCommunityIds.options[i].value +",";
				  adjustCommunityName+=adjustCommunityIds.options[i].innerText+",";

		}
		var url = "is_done.jsp?cityId="+20001
							+"&adjustLevel="+adjustLevel
							+"&adjustType="+adjustType
							+"&adjustCountyIds="+adjustCountyIds
							+"&adjustCountyNames="+adjustCountyNames
							+"&adjustStreetIds="+adjustStreetIds
							+"&adjustStreetNames="+adjustStreetNames
							+"&adjustCommunityIds="+adjustCommunityId
							+"&adjustCommunityNames="+adjustCommunityName
							+"&newCountyIds="+adjustCountyIds
							+"&newCountyNames="+adjustCountyNames
							
							+"&newStreetIds="+adjustStreetIds
							+"&newStreetNames="+adjustStreetNames
							+"&newCommunityIds="+newCommunityIds
							+"&newCommunityNames="+newCommunityNames
							
							+"&stopDates="+stopDates
							+"";
		if(stopDates==""){
		
					alert("请选择原区划停用时间");
					return;
					}
		
       // msgWindow=window.open(url,"protypeWindow","toolbar=no,width=600,height=600,directories=no,status=no,scrollbars=no,resize=no,menubar=no")
      
	  //  msgWindow.focus();
		 replaceRegion(url);
		}
		

}
function openRegion(url){
	 window.opener.document.getElementById("frame1").src = url;
}

function replaceRegion(url){
	 location.replace(url);
}
</script>
</head>

<body onLoad="">
	<form action=" " name="myForm" method="post">
	<input type="hidden" name="cityId" value="20001">
	<input type="hidden" name="adjustType" value="50161">
<input type="hidden" name="org.apache.struts.taglib.html.TOKEN" value="<c:out value="${sessionScope['org.apache.struts.action.TOKEN']}"/>">
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="11" background="../../images/images_32.jpg"><img src="../../images/content_left.gif" width="11" height="51"></td>
    <td height="51" background="../../images/images_32.jpg"><table width="70%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="22" height="16" align="center"><img src="../../images/d.gif" width="14" height="14"></td>
          <td valign="bottom"> 当前位置—>区划合并->选择现有区划</td>
      </tr>
    </table>
    </td>
  </tr>
  <tr>
    <td background="../../images/images_481.jpg">&nbsp;</td>
    <td valign="top">
	<table border="0" cellspacing="0" cellpadding="0" width="100%">
		<tr>
			<td align="left"></td>
		</tr>
		<tr id="tag1">
			<td>
			<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td width="45" align="left" background="../../images/images_49.jpg"><img src="../../images/images_48.jpg" width="38" height="40"></td>
                <td background="../../images/images_49.jpg"><span class="title"> 合并类型：</span> </td>
                <td width="16" align="right" background="../../images/images_49.jpg"><img src="../../images/images_52.jpg" width="16" height="40"></td>
      </tr>
    </table>
			<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td width="16" background="../../images/images_55.jpg">&nbsp;</td>
          <td align="center"><table width="98%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td height="14">&nbsp;</td>
              </tr>
            </table>
                  <table width="98%" border="0" cellpadding="1" cellspacing="1" bgcolor="a8d1eb">
                    <tr>
                      
                      <td height="30" align="right" class="td-01" width="20%">请选择合并类型：</td>
                      <td class="td-02" width="89%">&nbsp;<gOS:select name="adjustLevel" items="class{com.topsuntech.gUnit.gEU_bzhhUtil.taglib.BzhhDictListProvide($request,TZJB)}" 
		  keyProperty="key" valueProperty="value" selected="${queryBean.adjustLevel}" styleClass="select"  style="width:44%" onchange="changeType()" >
									<gOS:option key="0" value="---请选择---" />
                              </gOS:select></td>
                    </tr>
                    
                  </table>
                  <table width="98%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td>&nbsp;</td>
                </tr>
            </table>
            </td>
          <td width="16" background="../../images/images_57.jpg">&nbsp;</td>
        </tr>
        <tr>
          <td><img src="../../images/images_72.jpg" width="16" height="17"></td>
          <td background="../../images/images_73.jpg">&nbsp;</td>
          <td><img src="../../images/images_75.jpg" width="16" height="17"></td>
        </tr>
      </table>
	  <br/><br/>
	  
	  <div id="divOne" style="display:none;">
	  <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td width="45" align="left" background="../../images/images_49.jpg"><img src="../../images/images_48.jpg" width="38" height="40"></td>
                <td background="../../images/images_49.jpg"><span class="title"> 被合并区划信息：</span></td>
                <td width="16" align="right" background="../../images/images_49.jpg"><img src="../../images/images_52.jpg" width="16" height="40"></td>
      </tr>
    </table>
			<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td width="16" background="../../images/images_55.jpg">&nbsp;</td>
          <td align="center"><table width="98%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td height="14">&nbsp;</td>
              </tr>
            </table>
                  <table width="98%" border="0" cellpadding="1" cellspacing="1" bgcolor="a8d1eb">
                    <tr>
                      <td width="20%" height="30" align="right" class="td-01">区县名称
                        ：</td>
                      <td  class="td-02" width="36%"><jsp:include page="../../common/area_info_many.jsp">  
					  <jsp:param name="path" value="../../common/"/>
					  <jsp:param name="formName" value="myForm"/>
					  <jsp:param name="level" value="2"/>
					  <jsp:param name="strParentId" value="cityId"/>
					  <jsp:param name="strObjId" value="adjustCountyIdsOne"/>
					  <jsp:param name="strObjName" value="adjustCountyNamesOne"/>
					 
					  <jsp:param name="canClear" value="yes"/>
					  <jsp:param name="strClears" value="adjustCountyIdsOne,adjustCountyNamesOne"/>
					  </jsp:include>
              </td>
			 <td height="30" align="left" class="td-02" width="53%"></td>   
                    </tr>   
					
					 
                  </table>  
                  <table width="98%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td>&nbsp;</td>
                </tr>
            </table>
            </td>
          <td width="16" background="../../images/images_57.jpg">&nbsp;</td>
        </tr>
        <tr>
          <td><img src="../../images/images_72.jpg" width="16" height="17"></td>
          <td background="../../images/images_73.jpg">&nbsp;</td>
          <td><img src="../../images/images_75.jpg" width="16" height="17"></td>
        </tr>
      </table>
		<br/>
	  <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td width="45" align="left" background="../../images/images_49.jpg"><img src="../../images/images_48.jpg" width="38" height="40"></td>
                <td background="../../images/images_49.jpg"><span class="title"> 新区划信息：</span></td>
                <td width="16" align="right" background="../../images/images_49.jpg"><img src="../../images/images_52.jpg" width="16" height="40"></td>
      </tr>
    </table>
			<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td width="16" background="../../images/images_55.jpg">&nbsp;</td>
          <td align="center"><table width="98%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td height="14">&nbsp;</td>
              </tr>
            </table>
                  <table width="98%" border="0" cellpadding="1" cellspacing="1" bgcolor="a8d1eb">
                    <tr>
                      <td width="20%" height="30" align="right" class="td-01">区县名称
                        ：</td>
                      <td  class="td-02" width="36%">
				<jsp:include page="../../common/area_info.jsp">  
					  <jsp:param name="path" value="../../common/"/>
					  <jsp:param name="formName" value="myForm"/>
					  <jsp:param name="level" value="2"/>
					  <jsp:param name="strParentId" value="cityId"/>
					  <jsp:param name="strObjId" value="newCountyIdsOne"/>
					  <jsp:param name="strObjName" value="newCountyNamesOne"/>
					  <jsp:param name="objId" value="<%=countyId%>"/>
					  <jsp:param name="canClear" value="yes"/>
					  <jsp:param name="strClears" value="newCountyIdsOne,newCountyNamesOne"/>
					  </jsp:include>
					  
             		 </td>
					 <td height="30" align="left" class="td-02" width="53%">
					 </td>
                      </tr>  
                  </table>
                  <table width="98%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td>&nbsp;</td>
                </tr>
            </table>
            </td>
          <td width="16" background="../../images/images_57.jpg">&nbsp;</td>
        </tr>
        <tr>
          <td><img src="../../images/images_72.jpg" width="16" height="17"></td>
          <td background="../../images/images_73.jpg">&nbsp;</td>
          <td><img src="../../images/images_75.jpg" width="16" height="17"></td>
        </tr>
      </table>
	  <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0"> 
    </table>
	</div>  
	  <div id="divTwo" style="display:none;">
	  <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td width="45" align="left" background="../../images/images_49.jpg"><img src="../../images/images_48.jpg" width="38" height="40"></td>
                <td background="../../images/images_49.jpg"><span class="title"> 被合并区划信息：</span></td>
                <td width="16" align="right" background="../../images/images_49.jpg"><img src="../../images/images_52.jpg" width="16" height="40"></td>
      </tr>
    </table>
			<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td width="16" background="../../images/images_55.jpg">&nbsp;</td>
          <td align="center"><table width="98%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td height="14">&nbsp;</td>
              </tr>
            </table>
                  <table width="98%" border="0" cellpadding="1" cellspacing="1" bgcolor="a8d1eb">
                    <tr>
                      <td width="20%" height="30" align="right" class="td-01">区县名称
                        ：</td>
                      <td  class="td-02" width="36%">
					  <jsp:include page="../../common/area_info.jsp">  
					  <jsp:param name="path" value="../../common/"/>
					  <jsp:param name="formName" value="myForm"/>
					  <jsp:param name="level" value="2"/>
					  <jsp:param name="strParentId" value="cityId"/>
					  <jsp:param name="strObjId" value="adjustCountyIdsTwo"/>
					  <jsp:param name="strObjName" value="adjustCountyNamesTwo"/>
					  <jsp:param name="objId" value="<%=countyId%>"/>
					  <jsp:param name="canClear" value="yes"/>
					  <jsp:param name="strClears" value="adjustCountyIdsTwo,adjustCountyNamesTwo"/>
					  </jsp:include>
              </td>
			 <td height="30" align="left" class="td-02" width="53%"></td>    
                    </tr>
					<tr>
                      <td width="20%" height="30" align="right" class="td-01">街道名称
                       ：</td>
                      <td  class="td-02" width="36%"><jsp:include page="../../common/area_info_many.jsp">
										<jsp:param name="path" value="../../common/"/>
										<jsp:param name="formName" value="myForm"/>
										<jsp:param name="level" value="3"/>
										<jsp:param name="strParentId" value="adjustCountyIdsTwo"/>
										<jsp:param name="strObjId" value="adjustStreetIdsTwo"/>
										<jsp:param name="strObjName" value="adjustStreetNamesTwo"/>
											
										<jsp:param name="canClear" value="yes"/>
										<jsp:param name="strClears" value="adjustStreetIdsTwo,adjustStreetNamesTwo"/>
									</jsp:include>
              </td>
			 <td height="30" align="left" class="td-02" width="53%"></td>
                      </tr> 
					  
                  </table> 
                  <table width="98%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td>&nbsp;</td>
                </tr>
            </table>
            </td>
          <td width="16" background="../../images/images_57.jpg">&nbsp;</td>
        </tr>
        <tr>
          <td><img src="../../images/images_72.jpg" width="16" height="17"></td>
          <td background="../../images/images_73.jpg">&nbsp;</td>
          <td><img src="../../images/images_75.jpg" width="16" height="17"></td>
        </tr>
      </table>
		<br/>
	  <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td width="45" align="left" background="../../images/images_49.jpg"><img src="../../images/images_48.jpg" width="38" height="40"></td>
                <td background="../../images/images_49.jpg"><span class="title"> 新区划信息：</span></td>
                <td width="16" align="right" background="../../images/images_49.jpg"><img src="../../images/images_52.jpg" width="16" height="40"></td>
      </tr>
    </table>
			<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td width="16" background="../../images/images_55.jpg">&nbsp;</td>
          <td align="center"><table width="98%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td height="14">&nbsp;</td>
              </tr>
            </table>
                  <table width="98%" border="0" cellpadding="1" cellspacing="1" bgcolor="a8d1eb">
                    <tr>
                      <td width="20%" height="30" align="right" class="td-01">区县名称
                        ：</td>
                      <td  class="td-02" width="36%"> 
					  <jsp:include page="../../common/area_info.jsp">  
					  <jsp:param name="path" value="../../common/"/>
					  <jsp:param name="formName" value="myForm"/>
					  <jsp:param name="level" value="2"/>
					  <jsp:param name="strParentId" value="cityId"/>
					  <jsp:param name="strObjId" value="newCountyIdsTwo"/>
					  <jsp:param name="strObjName" value="newCountyNamesTwo"/>
					  <jsp:param name="objId" value="<%=countyId%>"/>
					  <jsp:param name="canClear" value="yes"/>
					  <jsp:param name="strClears" value="newCountyIdsTwo,newCountyNamesTwo,newStreetIdsTwo,newStreetNamesTwo"/>
					  </jsp:include>
              </td>
			 <td height="30" align="left" class="td-02" width="53%"></td>
                      </tr>
					  <tr>
                      <td width="20%" height="30" align="right" class="td-01">街道名称
                       ：</td>
                      <td  class="td-02" width="36%">
					  <jsp:include page="../../common/area_info.jsp">
										<jsp:param name="path" value="../../common/"/>
										<jsp:param name="formName" value="myForm"/>
										<jsp:param name="level" value="3"/>
										<jsp:param name="strParentId" value="newCountyIdsTwo"/>
										<jsp:param name="strObjId" value="newStreetIdsTwo"/>
										<jsp:param name="strObjName" value="newStreetNamesTwo"/>
										<jsp:param name="objId" value="<%=streetId%>"/>		
										<jsp:param name="canClear" value="yes"/>
										<jsp:param name="strClears" value="newStreetIdsTwo,newStreetNamesTwo"/>
									</jsp:include>
              </td>
			 <td height="30" align="left" class="td-02" width="53%"></td>
                      </tr>              
                  </table>  
                  <table width="98%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td>&nbsp;</td>
                </tr>
            </table>
            </td>
          <td width="16" background="../../images/images_57.jpg">&nbsp;</td>
        </tr>
        <tr>
          <td><img src="../../images/images_72.jpg" width="16" height="17"></td>
          <td background="../../images/images_73.jpg">&nbsp;</td>
          <td><img src="../../images/images_75.jpg" width="16" height="17"></td>
        </tr>
      </table>
	  <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
    </table>
	</div> 
		  <div id="divThree" style="display:none;">
	  <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td width="45" align="left" background="../../images/images_49.jpg"><img src="../../images/images_48.jpg" width="38" height="40"></td>
                <td background="../../images/images_49.jpg"><span class="title"> 被合并区划信息：</span></td>
                <td width="16" align="right" background="../../images/images_49.jpg"><img src="../../images/images_52.jpg" width="16" height="40"></td>
      </tr>
    </table>
			<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td width="16" background="../../images/images_55.jpg">&nbsp;</td>
          <td align="center"><table width="98%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td height="14">&nbsp;</td>
              </tr>
            </table>
                  <table width="98%" border="0" cellpadding="1" cellspacing="1" bgcolor="a8d1eb">
                    <tr>
                      <td width="20%" height="30" align="right" class="td-01">区县名称
                        ：</td>
                      <td  class="td-02" width="36%">
					  <jsp:include page="../../common/area_info.jsp">  
					  <jsp:param name="path" value="../../common/"/>
					  <jsp:param name="formName" value="myForm"/>
					  <jsp:param name="level" value="2"/>
					  <jsp:param name="strParentId" value="cityId"/>
					  <jsp:param name="strObjId" value="adjustCountyIdsThree"/>
					  <jsp:param name="strObjName" value="adjustCountyNamesThree"/>
					  <jsp:param name="objId" value="<%=countyId%>"/>
					  <jsp:param name="canClear" value="yes"/>
					  <jsp:param name="strClears" value="adjustCountyIdsThree,adjustCountyNamesThree,adjustStreetIdsThree,adjustStreetNamesThree,newCommunityIdsThree,newCommunityNamesThree"/>
					  </jsp:include>
					  
              </td>
			 <td height="30" align="left" class="td-02" width="53%"></td>   
                    </tr>
					<tr>
                      <td width="20%" height="30" align="right" class="td-01">街道名称
                       ：</td>
                      <td  class="td-02" width="36%"><jsp:include page="../../common/area_info.jsp">
										<jsp:param name="path" value="../../common/"/>
										<jsp:param name="formName" value="myForm"/>
										<jsp:param name="level" value="3"/>
										<jsp:param name="strParentId" value="adjustCountyIdsThree"/>
										<jsp:param name="strObjId" value="adjustStreetIdsThree"/>
										<jsp:param name="strObjName" value="adjustStreetNamesThree"/>
										<jsp:param name="objId" value="<%=streetId%>"/>		
										<jsp:param name="canClear" value="yes"/>
										<jsp:param name="strClears" value="adjustStreetIdsThree,adjustStreetNamesThree,newCommunityIdsThree,newCommunityNamesThree"/>
									</jsp:include> 
              </td>
			 <td height="30" align="left" class="td-02" width="53%"></td>
                      </tr>
					  <tr>
                      <td width="20%" height="30" align="right" class="td-01">社区名称
                       ：</td>
                      <td  class="td-02" width="36%"><jsp:include page="../../common/area_info_many.jsp" >
                    <jsp:param name="path" value="../../common/" />              
                    <jsp:param name="formName" value="myForm" />              
                    <jsp:param name="level" value="4" />              
                    <jsp:param name="strParentId" value="adjustStreetIdsThree"/>              
                    <jsp:param name="strObjId" value="adjustCommunityIdsThree"/>              
                    <jsp:param name="strObjName" value="adjustCommunityNamesThree"/>              
                                 
                    <jsp:param name="canClear" value="yes"/>              
                    <jsp:param name="strClears" value="adjustCommunityIdsThree,adjustCommunityNamesThree" />              
                    </jsp:include>
             </td>
			 <td height="30" align="left" class="td-02" width="53%"></td>
                      </tr>
					  
                  </table> 
                  <table width="98%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td>&nbsp;</td>
                </tr>
            </table>
            </td>
          <td width="16" background="../../images/images_57.jpg">&nbsp;</td>
        </tr>
        <tr>
          <td><img src="../../images/images_72.jpg" width="16" height="17"></td>
          <td background="../../images/images_73.jpg">&nbsp;</td>
          <td><img src="../../images/images_75.jpg" width="16" height="17"></td>
        </tr>
      </table>
		<br/>
	  <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td width="45" align="left" background="../../images/images_49.jpg"><img src="../../images/images_48.jpg" width="38" height="40"></td>
                <td background="../../images/images_49.jpg"><span class="title"> 新区划信息：</span></td>
                <td width="16" align="right" background="../../images/images_49.jpg"><img src="../../images/images_52.jpg" width="16" height="40"></td>
      </tr>
    </table>
			<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td width="16" background="../../images/images_55.jpg">&nbsp;</td>
          <td align="center"><table width="98%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td height="14">&nbsp;</td>
              </tr>
            </table>
                  <table width="98%" border="0" cellpadding="1" cellspacing="1" bgcolor="a8d1eb">
                    <tr>
                      <td width="20%" height="30" align="right" class="td-01">区县名称
                        ：</td>
                      <td  class="td-02" width="36%">
					  <jsp:include page="../../common/area_info.jsp">  
					  <jsp:param name="path" value="../../common/"/>
					  <jsp:param name="formName" value="myForm"/>
					  <jsp:param name="level" value="2"/>
					  <jsp:param name="strParentId" value="cityId"/>
					  <jsp:param name="strObjId" value="newCountyIdsThree"/>
					  <jsp:param name="strObjName" value="newCountyNamesThree"/>
					  <jsp:param name="objId" value="<%=countyId%>"/>
					  <jsp:param name="canClear" value="yes"/>
					  <jsp:param name="strClears" value="newCountyIdsThree,newCountyNamesThree,newStreetIdsThree,newStreetNamesThree,newCommunityIdsThree,newCommunityNamesThree"/>
					  </jsp:include>
              </td>
			 <td height="30" align="left" class="td-02" width="53%"></td>
                      </tr>
					  <tr>
                      <td width="20%" height="30" align="right" class="td-01">街道名称
                       ：</td>
                      <td  class="td-02" width="36%"> 
					  <jsp:include page="../../common/area_info.jsp">
										<jsp:param name="path" value="../../common/"/>
										<jsp:param name="formName" value="myForm"/>
										<jsp:param name="level" value="3"/>
										<jsp:param name="strParentId" value="newCountyIdsThree"/>
										<jsp:param name="strObjId" value="newStreetIdsThree"/>
										<jsp:param name="strObjName" value="newStreetNamesThree"/>
										<jsp:param name="objId" value="<%=streetId%>"/>		
										<jsp:param name="canClear" value="yes"/>
										<jsp:param name="strClears" value="newStreetIdsThree,newStreetNamesThree,newCommunityIdsThree,newCommunityNamesThree"/>
									</jsp:include>
              </td>
			 <td height="30" align="left" class="td-02" width="53%"></td>
                      </tr>
					  <tr>
                      <td width="20%" height="30" align="right" class="td-01">社区名称
                       ：</td>
                      <td  class="td-02" width="36%"> 
					  <jsp:include page="../../common/area_info.jsp" >
                    <jsp:param name="path" value="../../common/" />              
                    <jsp:param name="formName" value="myForm" />              
                    <jsp:param name="level" value="4" />              
                    <jsp:param name="strParentId" value="newStreetIdsThree"/>              
                    <jsp:param name="strObjId" value="newCommunityIdsThree"/>              
                    <jsp:param name="strObjName" value="newCommunityNamesThree"/>              
                    <jsp:param name="objId" value="<%=communityId%>"/>              
                    <jsp:param name="canClear" value="yes"/>              
                    <jsp:param name="strClears" value="newCommunityIdsThree,newCommunityNamesThree" />              
                    </jsp:include>  
              </td>
			 <td height="30" align="left" class="td-02" width="53%"></td>
                      </tr>
					  
                    
                  </table> 
                  <table width="98%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td>&nbsp;</td>
                </tr>
            </table>
            </td>
          <td width="16" background="../../images/images_57.jpg">&nbsp;</td>
        </tr>
        <tr>
          <td><img src="../../images/images_72.jpg" width="16" height="17"></td>
          <td background="../../images/images_73.jpg">&nbsp;</td>
          <td><img src="../../images/images_75.jpg" width="16" height="17"></td>
        </tr>
      </table>
	  <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
    </table>
	</div>
	  <br/>
	  <br/>	  
	  <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td width="45" align="left" background="../../images/images_49.jpg"><img src="../../images/images_48.jpg" width="38" height="40"></td>
                <td background="../../images/images_49.jpg"><span class="title"> 其它信息：</span></td>
                
      </tr>
    </table>
			<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td width="16" background="../../images/images_55.jpg"></td>
          <td align="center"><table width="98%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td height="14">&nbsp;</td>
              </tr>
            </table>
			
                  <table width="98%" border="0" cellpadding="1" cellspacing="1" bgcolor="a8d1eb">
                    <tr>
                      <td width="20%" height="30" align="right" class="td-01">原区划停用时间：                        </td>
                      <td  class="td-02" width="89%">
					  &nbsp;<input   name="stopDates" id="stopDates" type="text" size="27" onClick="WdatePicker();" value=""  readOnly/>
					  
					  
              </td>
                    </tr>
					           
                  </table>
                  <table width="98%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  
				  <td width="11%" height="30" align="right" class="td-02"><input  class="input_btn" type="button" value="上一步"  onclick="goBack()"/>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                                          <td width="11%" height="30" align="left" class="td-02">&nbsp;&nbsp;&nbsp;&nbsp;<input type="button"  class="input_btn" value="下一步" onClick="goNext()"/>                    </td>
                </tr>
            </table>
            </td>
          <td width="16" background="../../images/images_57.jpg">&nbsp;</td>
        </tr>
        <tr>
          <td><img src="../../images/images_72.jpg" width="16" height="17"></td>
          <td background="../../images/images_73.jpg">&nbsp;</td>
          <td><img src="../../images/images_75.jpg" width="16" height="17"></td>
		  
        </tr>
      </table>
			</td>
		</tr>
	</table>
    </td>
  </tr>
</table>

</form>
</body>
</html>
