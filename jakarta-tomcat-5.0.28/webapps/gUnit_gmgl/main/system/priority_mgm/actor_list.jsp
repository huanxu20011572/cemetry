<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<%@ taglib uri="/WEB-INF/tld/gTaglib-gOS.tld" prefix="gOS" %>
<%@ taglib uri="/WEB-INF/tld/gTaglib-shjz.tld" prefix="gOS_shjz" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/gTaglib-shjz.tld" prefix="shjz" %>
<%@ taglib uri="/WEB-INF/tld/gTaglib-shjz.tld" prefix="gUnit_shjz" %>
<%@ taglib uri="/WEB-INF/tld/gTaglib-mjzz.tld" prefix="gEU_mjzz" %>
<%@ taglib uri="html-el" prefix="html-el" %>
<link href="../../css/css.css" rel="stylesheet" type="text/css">





<html>
<head>
<title></title>
<script src="../../../script/action.js" language="JScript"></script>
<script src="../../../script/toolbar-ie5.js" language="JScript"></script>
<link href="../../../script/toolbar-ie5.css" type="text/css" rel="stylesheet">
<xml id="xsl" src="../../../script/toolbar-ie5.xsl"></xml>
<script src="../../../script/ua.js"></script>
<script src="../../../script/function.js"></script>
<script src="../../../script/publics.js"></script>
<script src="../../../script/page.js"></script>
<script type="text/javascript" src="../../../script/jquery.js"></script>
<script type="text/javascript" src="../../../script/linkageSelect.js"></script>
<script type="text/javascript" src="../../../script/location.js"></script>	

</head>


<script language="JavaScript" src="../../../script/hints.js"></script>
<!-- Link Tigra Hints configuration file to your HTML document-->
<script language="JavaScript" src="../../../script/hints_cfg.js"></script>
<script language="javascript">
	//查询
	function doQuery(){
		var strForm = document.myform;				
		strForm.action= "../../../tree/roleList.do?method=getRolelist";
		strForm.submit();		
	}
	</script>
<body>
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="11" background="../../../images/images_32.jpg"><img src="../../../images/content_left.gif" width="11" height="51"></td>
    <td height="51" background="../../../images/images_32.jpg"><table width="70%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="22" height="16" align="center"><img src="../../../images/d.gif" width="14" height="14"></td>
        <td valign="bottom"> 当前位置：超级系统管理 → <b>角色维护</b></td>
      </tr></td>		
    </table>
    </td>
  </tr>
  <tr>
    <td background="../../../images/images_481.jpg">&nbsp;</td>
    <td valign="top">
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
        <td width="45" align="left" background="../../../images/images_49.jpg"><img src="../../../images/images_48.jpg" width="38" height="40"></td>
        <td background="../../../images/images_49.jpg" class="title"><strong>角色维护</strong></td>
        
        <td width="16" align="right" background="../../../images/images_49.jpg"></td>
      </tr>
    </table>
   
			<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td width="16" background="../../../images/images_55.jpg">&nbsp;</td>
          <td align="center">
          <br>
		  <form  method="post"  name="myform">
		  			
		<table width="100%" border="0" cellpadding="1" cellspacing="1" bgcolor="a8d1eb">
                      
													        		
													        	<tr height="22" > 
													        		<td  height="23" align="right" class="td-01">角色名称：</td>
								                      <td class="td-02"> 
								                      	<input class="input_txt" name="rolename" type="text"  value="<c:out value="${param.rolename}" />" >
								                      	
								                      </td>  
															      	<td nowrap align="right" class="td-01" >角色描述：
															      	</td>
															      	<td class="td-02">
														          	<input class="input_txt" name="roleman" type="text" size="20"  value="<c:out value="${param.roleman}" />" >
																      </td> 
																      
																      <td nowrap align="right" class="td-01" >子系统：
															      	</td>
															      	<td class="td-02">
														          	<select name="rolefl">
          	 	<option value="协同与办公">请选择</option>
          	 	<option value="协同与办公">协同与办公</option>
          	 	<option value="综合指标">综合指标</option>
          	 	<option value="综合指标">监管与执法</option>
          	 	<option value="隐患排查">隐患排查</option>
          	 	<option value="举报投诉">举报投诉</option>
          	 	<option value="监测与预警">监测与预警</option>
          	 	<option value="行政许可管理">行政许可管理</option>
          	 	<option value="宣传与培训">宣传与培训</option>
          	 	<option value="综合知识服务">综合知识服务</option>
          	 </select>
																      </td>     
															        
															        <td class="td-02" colspan="2" align="center"> 
															        	<a href="#" onClick="doQuery();"><img alt='查询' src='../images/but-serch.jpg ' border=no style='vertical-align:middle'></a>&nbsp;
		                                   <a href="../../../main/system/priority_mgm/actor_add.jsp" ><img alt='添加角色' src='../images/but-tj.gif ' border=no style='vertical-align:middle'></a>&nbsp;
	
															        </td>  
															         																      
														        </tr>
						  				  
                        </table>
                        <br>
                  <table width="100%" border="0" cellpadding="1" cellspacing="1" bgcolor="a8d1eb">
                    <tr> 
                    	<TD  width="5%" align="center" class="td-04">									        	
									        	序号
									     	</TD>
									     	 <td width="16%" height="30" align="center" class="td-04">子系统</td>
                      <td width="16%" height="30" align="center" class="td-04">名称</td>
                     
					            <td width="14%"align="center" class="td-04">创建日期</td>
					            <td width="33%" align="center" class="td-04">描述</td>
	                    <td  width="18%" align="center" class="td-04">操作</td>
                    </tr>
				
				<c:forEach var="actor" items="${roleList}"  varStatus="ctIndex" >
					  							  		
								<c:if test="${ctIndex.count%2==1}">
                     <tr  height="25" align="center" class="td-02">
								</c:if>
										 <c:if test="${ctIndex.count%2==0}">
									 <tr  height="25" align="center" class="td-01">
									 </c:if>					
          <td width="5%" height="26" align="center"><c:out value='${ctIndex.index+1+(projectPage.pageSize*(projectPage.currentPage-1))}'/>   </td>
            <td width="14%">
           <gOS:subString><c:out value="${actor.DESCRIPTION}" /></gOS:subString></div></td>
          <td width="16%"><div align="center"><a href="../main/system/priority_mgm/actorSelect.do?action=detail&id=<c:out value="${actor.ID}"/>"><gOS:subString><c:out value="${actor.NAME}"/></gOS:subString></a></div></td>
          
          <td width="14%"><div align="center"><fmt:formatDate value="${actor.CREATEDATE}" pattern="yyyy-MM-dd" /></div></td>
          <td width="33%"><div align="center"></td>
          <td width="18%">
		<a href="../main/system/priority_mgm/actorUpdate.do?action=showUpdate&id=<c:out value="${actor.ID}"/>">
		<img src="../../../images/config/zoom_small.gif"  border="0"  onMouseOver="myHint.show(4)" onMouseOut="myHint.hide()"></a>&nbsp;
	
		<a href="../main/system/priority_mgm/actorDelete.do?action=deleteConfirm&id=<c:out value="${actor.ID}"/>">
			<img src="../../../images/config/delete.gif"  border="0"  onMouseOver="myHint.show(6)" onMouseOut="myHint.hide()">
		</a></td>
        </tr>
        </c:forEach>
                  </table>
                    
               
			</form>
				 <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table-line">
					<tr> 
					  <td align="right" class="listTable_page">
						<gOS:page name="test" action="../../../tree/roleList.do?method=getRolelist" pageName="dataPage" pageSizeKey="list"> </gOS:page>
			   </td>
			  </tr>
			 
			</table>
			
		  </td>
          <td width="16" background="../../../images/images_57.jpg">&nbsp;</td>
        </tr>
        <tr>
          <td><img src="../../../images/images_72.jpg" width="16" height="17"></td>
          <td background="../../../images/images_73.jpg">&nbsp;</td>
          <td><img src="../../../images/images_75.jpg" width="16" height="17"></td>
        </tr>
      </table>
			</td>
		</tr>
	</table>
    </td>
  </tr>
</table>
</body>
</html>