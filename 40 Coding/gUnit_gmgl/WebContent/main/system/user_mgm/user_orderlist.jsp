<%@ page contentType="text/html; charset=GBK"%> 

<%@ include file="../../../common/taglibs.jsp"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/gTaglib-shjz.tld" prefix="shjz" %>
<%@ taglib uri="/WEB-INF/tld/gTaglib-shjz.tld" prefix="gUnit_shjz" %>
<%@ taglib uri="/WEB-INF/tld/gTaglib-mjzz.tld" prefix="gEU_mjzz" %>
<%@ taglib uri="html-el" prefix="html-el" %>
<html>
<head>
<title>用户排序</title>
<link href="../css/css.css" rel="stylesheet" type="text/css">
</head>
<script language="JavaScript" src="../script/publics.js"></script>
<script language="JavaScript" src="../lib/function.js"></script>
<script type="text/javascript" src="../script/jquery.js"></script>
<script src="<c:url value="/script/ua.js"/>"></script>


<script language="javascript">


function basicInfoList(){
var strform = document.regionInfo;
 strform.submit();
};


	//查询
	function doQuery(){
		var strForm = document.myform;
		
		
		strForm.action= "userOrder.do?method=listUserforOrder";
		strForm.submit();
		
	}	
	
function setOffice(win, id, name){
	$('#deptid').val(id);
	$('#dept').val(name);
	win.close();
}
function selectOffice() {
	<c:if test="${param.type eq 'all'}">
		windowWithoutToolbar("<c:url value="/tree/office_choose.jsp?type=1"/>", 300, 600, true);
	</c:if>
	<c:if test="${param.type eq 'sub'}">
		windowWithoutToolbar("<c:url value="/tree/office_choose.jsp?type=2"/>", 300, 600, true);
	</c:if>
}
function clearOffice(){
	$('#deptid').val('');
	$('#dept').val('');
}


function tochangeOrderItem()
{  
	  myform.submit();
		
}

function isNumber(input) {   
  var isNumber = /^[\d]+$/;   
  if(isNumber.test(input)){   
    return true;   
    }   
  return false;   
}   

</script>

<body>
<form id="myform" name="myform" method="post" action="changeOrderItem.do?doMethod=changeOrderItem">
<body>
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="11" height="31" valign="top" class="td-bg"><img src="../images/right-1.jpg" /></td>
    <td align="center" valign="top" ><table width="100%" border="0" cellpadding="0" cellspacing="0" class="word-8">
      <tr>
        <td height="31" align="left" valign="middle" style="background:url(../images/right-3.jpg)"><img src="../images/right-4.jpg" width="9" height="8" align="absmiddle" /> 当前位置 &gt; 系统管理 &gt; 用户排序</td>
      </tr>
    </table>
	</td>
  </tr>
  <tr>
    <td >&nbsp;</td>
    <td valign="top">
	<table border="0" cellspacing="0" cellpadding="0" width="100%">
		<tr>
			<td>&nbsp;</td>
		</tr>		
	</table>
	<table border="0" cellspacing="0" cellpadding="0" width="100%">
		<tr>
			<td align="left">
			<table width="94%" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
				  
                <td height="0">&nbsp; </td>
				  
                <td height="0" align="right" valign="top">&nbsp;</td>
				</tr>
			</table>
				  
		  </td>
		</tr>
		<tr id="tag1">
			<td>
			<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td width="45" align="left" background="../images/images_49.jpg"><img src="../images/images_48.jpg" width="38" height="40"></td>
        <td background="../images/images_49.jpg" class="title"><strong>用户排序</strong></td>
        
        <td width="16" align="right" background="../images/images_49.jpg"></td>
      </tr>
    </table>
   
			<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td width="16" background="../images/images_55.jpg">&nbsp;</td>
          <td align="center">
          
		  
		  			<table width="98%" border="0" cellspacing="0" cellpadding="0">
		  	
                    <tr> 
                      <td>&nbsp;
                      	<input name="type" type="hidden" value="<c:out value="${param.type}"/>">
                      </td>
                    </tr>
                    <tr> 
                      <td><table width="100%" border="0" cellpadding="1" cellspacing="1" bgcolor="a8d1eb">
                          <tr> 
                            <td width="17%" height="25" align="right" class="td-01">所在部门：</td>
                            <td width="33%" class="td-02" height="25"><input height="25" readonly id="dept" name="dept" class="input" type="text" value="<c:out value="${param.dept}"/>" size="23">
            <input id="deptid" name="deptid" type="hidden" value="<c:out value="${param.deptid}"/>">
            	 <a href="javascript:selectOffice()"  title=请选择部门><img src="../images/anniu_1_03.gif" border="0" ></a> 
            	  <a href="javascript:clearOffice()" title=清除选择部门><img src="../images/anniu_1_05.gif" border="0"></a>
         </td>
                       
                     <td class="td-02"><a href='#' onClick="doQuery();" title=查询><img src="../images/but-cx_58.jpg" width="63" height="21" border="0" style="cursor:hand;"></a></td>
		
                          </tr>						  						  
					
								  
                        </table></td>
                    </tr>
                    
                  <tr>
          <td>&nbsp;</td>
        </tr>
                  </table>

                  <table width="100%" border="0" cellpadding="1" cellspacing="1" bgcolor="a8d1eb">
                    <tr> 
                    	
                      <td width="5%" height="30" align="center" class="td-04">序号</td>
                      <td width="8%" align="center" class="td-04">用户姓名</td>
				  <td width="28%" align="center" class="td-04">所属机构</td>
					 <!--	 <td width="22%" align="center" class="td-04">所在处室</td>-->
					   <td width="20%" align="center" class="td-04">职务</td>
					    <td width="8%" align="center" class="td-04">排序顺序</td>
				         
                      <td  align="center" class="td-04">操作</td>
                    </tr>
					<c:forEach var="user" items="${userList}"  varStatus="ctIndex" >
					  							  		
								<c:if test="${ctIndex.count%2==1}">
                     <tr  height="25" align="center" class="td-02">
								</c:if>
										 <c:if test="${ctIndex.count%2==0}">
									 <tr  height="25" align="center" class="td-01">
									 </c:if>										  		
											  			  														  		
											  		<TD height="22" align="center" class="td-02"><c:out value='${ctIndex.index+1+(projectPage.pageSize*(projectPage.currentPage-1))}'/></TD>	
								            <TD height="22" align="center" class="td-02"><c:out value='${user.name}'/></TD>
								         	  <TD height="22" align="center" class="td-02"><gOS_shjz:dictOrgValue key="${user.workdeptid}" /></TD>								           			
								             	<!--<TD height="22" align="center" class="td-02"><gOS_shjz:dictOrgValue key="${user.deptid}" /></TD>		-->
								            <TD height="22" align="center" class="td-02"><c:out value='${user.positionid}'/></TD>	
								            	<TD height="22" align="center" class="td-02"><input name="orderByItem" class="input" type="text" value="<c:out value='${user.orderByItem}'/>"><input name="userid" class="input" type="hidden" value="<c:out value='${user.id}'/>"></TD>	
								            <TD height="22" align="center" class="td-02">
								           <a href='userMove.do?method=moveUp&id=<c:out value="${user.id}"/>&orderByItem=<c:out value="${user.orderByItem}"/>&deptid=<c:out value="${param.deptid}"/>&type=<c:out value="${param.type}"/>'>上移</a> 
						  <a href='userMove.do?method=moveDown&id=<c:out value="${user.id}"/>&orderByItem=<c:out value="${user.orderByItem}"/>&deptid=<c:out value="${param.deptid}"/>&type=<c:out value="${param.type}"/>'>下移</a>
													
								            </TD>	
										            								            
								         	</TR>
									    	</c:forEach>	
                  </table>
            <c:if test="${userList!=null}">
            <table>
            <tr><td height="5"></td></tr>
            	<tr>
            		<td>				    	
            			<a href="javascript:tochangeOrderItem();"><img src="../images/but-qd.gif" border="0"></a>
						   </td>
            	</tr>
            </table>
	        </c:if>		
	        
				 <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table-line">
					<tr> 
					  <td align="right" class="listTable_page">
						  <gOS:page name="test" action="userOrder.do?method=listUserforOrder" pageName="dataPage" pageSizeKey="list">          	
                <gOS:param name="dept"><c:out value="${param.dept}" /></gOS:param>
						   	<gOS:param name="deptid"><c:out value="${param.deptid}" /></gOS:param>
						   	<gOS:param name="type"><c:out value="${param.type}" /></gOS:param>
              </gOS:page>	 
			   </td>
			  </tr>
			</table>
			
		  </td>
          <td width="16" background="../images/images_57.jpg">&nbsp;</td>
        </tr>
        <tr>
          <td><img src="../images/images_72.jpg" width="16" height="17"></td>
          <td background="../images/images_73.jpg">&nbsp;</td>
          <td><img src="../images/images_75.jpg" width="16" height="17"></td>
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