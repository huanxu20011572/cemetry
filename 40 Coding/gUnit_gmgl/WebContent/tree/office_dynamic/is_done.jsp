<%@ page contentType="text/html; charset=GBK" %>
<%@ include file="../../common/taglibs.jsp"%>
<%@ include file="../../common/js_common.jsp"%>
<link href="../../css/css.css" rel="stylesheet" type="text/css">


<%@page import="com.topsuntech.gOS.user.session.*" %>
<%@page import="com.topsuntech.gOS.user.en.user.*" %>

 		<% 


					 String   adjustType=request.getParameter( "adjustType");
					String   adjustLevel=request.getParameter( "adjustLevel"); 
					 String   stopDates=request.getParameter( "stopDates");
					 
					String   adjustCountyIds=request.getParameter( "adjustCountyIds");
					String   adjustCountyNames=request.getParameter( "adjustCountyNames");
					String   adjustStreetIds=request.getParameter( "adjustStreetIds");
					String   adjustStreetNames=request.getParameter( "adjustStreetNames");
					String   adjustCommunityIds=request.getParameter( "adjustCommunityIds");
					String   adjustCommunityNames=request.getParameter( "adjustCommunityNames");
					
					
					String   newCountyIds=request.getParameter("newCountyIds");
					String   newCountyNames=request.getParameter( "newCountyNames");
					String   newStreetIds=request.getParameter( "newStreetIds");
					String   newStreetNames=request.getParameter( "newStreetNames");
					String   newCommunityIds=request.getParameter( "newCommunityIds");
					String   newCommunityNames=request.getParameter( "newCommunityNames");
					String   warnContent = "";
					String   warnName = "";
					String   warnLevel = "";
					String   warnRegion = "";
					if(adjustType.equals("50162")){
					
							if(adjustLevel.equals("50164"))
							{
								warnName="���ز��";
								warnLevel="1";
								warnRegion="20001";
							 warnContent="���β������ͣ�"+"���ز��"+",�� "+adjustCountyNames+" ���Ϊ "+newCountyNames;
							}
							else if(adjustLevel.equals("50165"))
							{
								warnName="�ֵ����";
								warnLevel="2";
								warnRegion=adjustCountyIds;
							warnContent="���β������ͣ�"+"�ֵ����"+",�� "+adjustCountyNames+" "+adjustStreetNames+" ���Ϊ "+newCountyNames+" "+newStreetNames;
							}else if(adjustLevel.equals("50166"))
							{
								warnName="�������";
								warnLevel="3";
								warnRegion=adjustStreetIds;
							warnContent="���β������ͣ�"+"�������"+",��  "+adjustCountyNames+" "+adjustStreetNames+" "+adjustCommunityNames+" ���Ϊ "+newCountyNames+" "+newStreetNames+" "+newCommunityNames;
							}
					
					}
					
					
					if(adjustType.equals("50161")){
					
							if(adjustLevel.equals("50164"))
							{
								warnName="���غϲ�";
								warnLevel="1";
								warnRegion="20001";
							 warnContent="���β������ͣ�"+"���غϲ�"+",�� "+adjustCountyNames+" �ϲ�Ϊ "+newCountyNames;
							}
							else if(adjustLevel.equals("50165"))
							{
								warnName="�ֵ��ϲ�";
								warnLevel="2";
								warnRegion=adjustCountyIds;
							warnContent="���β������ͣ�"+"�ֵ��ϲ�"+",�� "+adjustCountyNames+" "+adjustStreetNames+" �ϲ�Ϊ "+newCountyNames+" "+newStreetNames;
							}else if(adjustLevel.equals("50166"))
							{
								warnName="�����ϲ�";
								warnLevel="3";
								warnRegion=adjustStreetIds;
							warnContent="���β������ͣ�"+"�����ϲ�"+",��  "+adjustCountyNames+" "+adjustStreetNames+" "+adjustCommunityNames+" �ϲ�Ϊ "+newCountyNames+" "+newStreetNames+" "+newCommunityNames;
							}
					
					}
					//String   effectDates=request.getParameter( "stopDates");
					
					
				%> 


<html>
<head>
<title>��������</title>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">

<script src="../../script/publics.js"></script>
<script type='text/javascript' src='../../dwr/engine.js'></script>
<script type='text/javascript' src='../../dwr/util.js'></script>
<script>

/*function testOne(){

alert("ooooooooook");
alert(adjustType);

}*/

function goBack(){

history.go(-1);

}
function doSubmit(){

	var form = document.myform;
	
	form.submit();


}

</script>
</head>

<body >
	<form action="../doAddAdjust.do?method=add" name="myform" method="post">
		<input type="hidden" name="cityId" value="20001">
		<input type="hidden" name="warnName" value="<%=warnName%>">
		<input type="hidden" name="warnLevel" value="<%=warnLevel%>">
		<input type="hidden" name="warnRegion" value="<%=warnRegion%>">
		
		<input type="hidden" name="warnContent" value="<%=warnContent%>">
		<input type="hidden" name="adjustLevel" value="<%=adjustLevel%>">
		<input type="hidden" name="adjustType" value="<%=adjustType%>">
		<input type="hidden" name="stopDates" value="<%=stopDates%>">
			
			<input type="hidden" name="adjustCountyIds" value="<%=adjustCountyIds%>">
			<input type="hidden" name="adjustCountyNames" value="<%=adjustCountyNames%>">
			<input type="hidden" name="adjustStreetIds" value="<%=adjustStreetIds%>">
			<input type="hidden" name="adjustStreetNames" value="<%=adjustStreetNames%>">
			
			<input type="hidden" name="adjustCommunityIds" value="<%=adjustCommunityIds%>">
			<input type="hidden" name="adjustCommunityNames" value="<%=adjustCommunityNames%>">
			<input type="hidden" name="newCountyIds" value="<%=newCountyIds%>">
			<input type="hidden" name="newCountyNames" value="<%=newCountyNames%>">
			
			<input type="hidden" name="newStreetIds" value="<%=newStreetIds%>">
			<input type="hidden" name="newStreetNames" value="<%=newStreetNames%>">
			<input type="hidden" name="newCommunityIds" value="<%=newCommunityIds%>">
			<input type="hidden" name="newCommunityNames" value="<%=newCommunityNames%>">
			
<table width="100%" height="80%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="11" background="../../images/images_32.jpg"><img src="../../images/content_left.gif" width="11" height="51"></td>
    <td width="899" height="51" background="../../images/images_32.jpg"><table width="70%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="22" height="16" align="center"><img src="../../images/d.gif" width="14" height="14"></td>
          <td valign="bottom"> 
		  ��ǰλ��->����<%if(adjustType.equals("50162")){%>���<%}%><%if(adjustType.equals("50161")){%>�ϲ�<%}%>->ȷ����Ϣ

 </td>
      </tr>
    </table>
    </td>
  </tr>
  <tr>
    <td background="../../images/images_481.jpg">&nbsp;</td>
    <td valign="top">
	<table border="0" cellspacing="0" cellpadding="0" width="100%">
		<tr>
			<td width="807" align="left"></td>
		</tr>
		<tr id="tag1">
			<td>
			<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td width="41" align="left" background="../../images/images_49.jpg"><img src="../../images/images_48.jpg" width="38" height="40"></td>
                <td width="595" background="../../images/images_49.jpg"><span class="title"> ȷ����Ϣ�� </span></td>
                <td width="190" align="right" background="../../images/images_49.jpg"><img src="../../images/images_52.jpg" width="16" height="40"></td>
      </tr>
    </table>
			<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td width="16" height="256" background="../../images/images_55.jpg">&nbsp;</td>
          <td width="775" align="center"><table width="98%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td height="13">&nbsp;</td>
              </tr>
            </table>
                  <table width="99%" height="307" border="0" cellpadding="1" cellspacing="1" bgcolor="a8d1eb">
                   
                     <tr width="100%" height="100%">
					 <td height="284"align="center" >
					 
					 
			
				 
				<%=warnContent%><br/> &nbsp;&nbsp;&nbsp;&nbsp; ȷ����������ɡ�,�������β���. 
					 </td>
					  </tr>
                  </table>
                  <table width="98%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td height="17">&nbsp;</td>
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
	  
	  
                  <table width="98%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  
				 <td align="center"> <input type="button" value="��һ��"  class="input_btn" onClick="goBack()" />                
				  &nbsp;&nbsp;&nbsp;&nbsp;
                                          <input type="submit" value="���"  class="input_btn" />      </td>  
                </tr>
            </table>
            </td>
          <td width="11" background="../../images/images_57.jpg">&nbsp;</td>
        </tr>
        <tr>
       <%--  // <td><img src="../../images/images_72.jpg" width="16" height="17"></td>
//          <td background="../../images/images_73.jpg">&nbsp;</td>
//          <td width="16"><img src="../../images/images_75.jpg" width="16" height="17"></td>--%>
		  
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
