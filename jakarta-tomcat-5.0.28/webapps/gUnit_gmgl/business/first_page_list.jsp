<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ include file="../common/head.jsp"%>

<body   style="background-color: transparent">
 
	<table width="100%" border="0" cellspacing="0" cellpadding="0"
		height="100%">
		<tr>
			<td width="11" valign="top" class="td-bg"><img src="../images/right-1.jpg" /></td>
			<td align="left">
			  <table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td height="31" align="left" valign="middle"
							style="background: url(../images/right-3.jpg)"><img
							src="../images/right-4.jpg" width="9" height="8"
							align="absmiddle" /> 当前位置：首页</td>
					</tr>
			  </table> 
              
		      <table width="100%" border="0" cellspacing="0" cellpadding="0">
			       <tr>
			         <td>&nbsp;</td>
	            </tr>
	          </table>
              
			<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
			        <td width="46%">
                    
			  <!-- Begin 待回访提醒  -->
			  <table width="200" border="0" cellspacing="0" cellpadding="0">
			    <tr>
			      <td width="20" align="right"><img src="../images/tab-01.jpg" width="8" height="27" /></td>
			      <td width="99" align="center" class="tab-img-01"> 待回访提醒 </td>
			      <td width="81" align="left" valign="bottom"><img src="../images/tab-03.jpg" /></td>
		        </tr>
			    </table>
			  <table width="98%" border="0" cellspacing="0" cellpadding="3">
			  <tr>
		          <td bgcolor="#C4DEEE"><table id="baseInfo" width="100%" cellpadding="0" cellspacing="1" bgcolor="#a6c6da">
		        <c:if test="${visitReturnList==null || visitReturnListSize==0}">
		        	<tr>
						<td height="30" align="center" bgcolor="#FFFFFF">&nbsp;</td>
						<td align="center" bgcolor="#FFFFFF">&nbsp;</td>
						<td align="center" bgcolor="#FFFFFF">&nbsp;</td>
						<td align="center" bgcolor="#FFFFFF">&nbsp;</td>
					</tr>
		        	<tr>
						<td height="30" align="center" bgcolor="#FFFFFF">&nbsp;</td>
						<td align="center" bgcolor="#FFFFFF">&nbsp;</td>
						<td align="center" bgcolor="#FFFFFF">&nbsp;</td>
						<td align="center" bgcolor="#FFFFFF">&nbsp;</td>
					</tr>
		        	<tr>
						<td height="30" align="center" bgcolor="#FFFFFF">&nbsp;</td>
						<td align="center" bgcolor="#FFFFFF">&nbsp;</td>
						<td align="center" bgcolor="#FFFFFF">&nbsp;</td>
						<td align="center" bgcolor="#FFFFFF">&nbsp;</td>
					</tr>
		        	<tr>
						<td height="30" align="center" bgcolor="#FFFFFF">&nbsp;</td>
						<td align="center" bgcolor="#FFFFFF">&nbsp;</td>
						<td align="center" bgcolor="#FFFFFF">&nbsp;</td>
						<td align="center" bgcolor="#FFFFFF">&nbsp;</td>
					</tr>
		        </c:if>
		        <c:forEach  var="en" items="${visitReturnList}" varStatus="status">
			        <c:choose>
			          	<c:when test="${status.count<=4}">
							<tr>
								<td height="30" align="center" bgcolor="#FFFFFF"><c:out value='${en.customerName}'/></td>
								<td align="center" bgcolor="#FFFFFF"><c:out value='${en.customerSource}'/></td>
								<td align="center" bgcolor="#FFFFFF"><c:out value='${en.customerTel}'/></td>
								<td align="center" bgcolor="#FFFFFF"><c:out value='${en.createDate}'/></td>
							</tr>
						</c:when>
					</c:choose>
				</c:forEach>
				<c:if test="${visitReturnListSize>0 && visitReturnListSize<4}">
					<c:forEach var="i" begin="${visitReturnListSize}" end="3" varStatus="status">
						<tr>
							<td height="30" align="center" bgcolor="#FFFFFF">&nbsp;</td>
							<td align="center" bgcolor="#FFFFFF">&nbsp;</td>
							<td align="center" bgcolor="#FFFFFF">&nbsp;</td>
							<td align="center" bgcolor="#FFFFFF">&nbsp;</td>
						</tr>
					</c:forEach>
				</c:if>
	          </table></td>
	            </tr>
		      </table>
	          <!-- End 待回访提醒  -->
		      
              
              </td>
	            
			         <td width="46%" align="left">
                     
				<!-- Begin 待安放提醒  -->
				<table width="200" border="0" cellspacing="0" cellpadding="0">
				  <tr>
				    <td width="20" align="right"><img src="../images/tab-01.jpg" width="8" height="27" /></td>
				    <td width="99" align="center" class="tab-img-01"> 待安放提醒 </td>
				    <td width="81" align="left" valign="bottom"><img src="../images/tab-03.jpg" /></td>
			      </tr>
				  </table>

				<table width="98%" border="0" cellspacing="0" cellpadding="3">
				<tr>
		          <td bgcolor="#C4DEEE"><table id="baseInfo" width="100%" cellpadding="0" cellspacing="1" bgcolor="#a6c6da">
		        <c:if test="${waitingPlaceList==null || waitingPlaceListSize==0}">
		        	<tr>
						<td height="30" align="center" bgcolor="#FFFFFF">&nbsp;</td>
						<td align="center" bgcolor="#FFFFFF">&nbsp;</td>
						<td align="center" bgcolor="#FFFFFF">&nbsp;</td>
						<td align="center" bgcolor="#FFFFFF">&nbsp;</td>
					</tr>
		        	<tr>
						<td height="30" align="center" bgcolor="#FFFFFF">&nbsp;</td>
						<td align="center" bgcolor="#FFFFFF">&nbsp;</td>
						<td align="center" bgcolor="#FFFFFF">&nbsp;</td>
						<td align="center" bgcolor="#FFFFFF">&nbsp;</td>
					</tr>
		        	<tr>
						<td height="30" align="center" bgcolor="#FFFFFF">&nbsp;</td>
						<td align="center" bgcolor="#FFFFFF">&nbsp;</td>
						<td align="center" bgcolor="#FFFFFF">&nbsp;</td>
						<td align="center" bgcolor="#FFFFFF">&nbsp;</td>
					</tr>
		        	<tr>
						<td height="30" align="center" bgcolor="#FFFFFF">&nbsp;</td>
						<td align="center" bgcolor="#FFFFFF">&nbsp;</td>
						<td align="center" bgcolor="#FFFFFF">&nbsp;</td>
						<td align="center" bgcolor="#FFFFFF">&nbsp;</td>
					</tr>
		        </c:if>
		        <c:forEach  var="en" items="${waitingPlaceList}" varStatus="status">
			        <c:choose>
			          	<c:when test="${status.count<=4}">
							<tr>
								<td height="30" align="center" bgcolor="#FFFFFF"><c:out value='${en.cemeteryLocation.cemeteryZone.parent.cemeteryZoneName}'/></td>
								<td align="center" bgcolor="#FFFFFF">
								<c:choose>
								   <c:when test="${en.cemeteryLocation.cemeteryType.cave=='1'}">单穴 </c:when>
								   <c:when test="${en.cemeteryLocation.cemeteryType.cave=='2'}">双穴 </c:when>
								   <c:when test="${en.cemeteryLocation.cemeteryType.cave=='3'}">多穴 </c:when>
			  					</c:choose>
								</td>
								<td align="center" bgcolor="#FFFFFF"><c:out value='${en.name}'/></td>
								<td align="center" bgcolor="#FFFFFF"><c:out value='${en.mobilePhone}'/></td>
							</tr>
						</c:when>
					</c:choose>
				</c:forEach>
				<c:if test="${waitingPlaceListSize>0 && waitingPlaceListSize<4}">
					<c:forEach var="i" begin="${waitingPlaceListSize}" end="3" varStatus="status">
						<tr>
							<td height="30" align="center" bgcolor="#FFFFFF">&nbsp;</td>
							<td align="center" bgcolor="#FFFFFF">&nbsp;</td>
							<td align="center" bgcolor="#FFFFFF">&nbsp;</td>
							<td align="center" bgcolor="#FFFFFF">&nbsp;</td>
						</tr>
					</c:forEach>
				</c:if>
	          </table></td>
	            </tr>
		      </table>
				<!-- End 待安放提醒  -->
			  </td>
				</tr>
                </table>
                
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
			       <tr>
			         <td>&nbsp;</td>
	               </tr>
	          </table>
              
              <!-- Begin 快捷办公  -->

              <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                  <td><!-- Begin 待归档提醒  -->
                    <table width="200" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td width="20" align="right"><img src="../images/tab-01.jpg" width="8" height="27" /></td>
                        <td width="99" align="center" class="tab-img-01"> 快捷办公 </td>
                        <td width="81" align="left" valign="bottom"><img src="../images/tab-03.jpg" /></td>
                      </tr>
                    </table>
                    <table width="99%" border="0" cellspacing="0" cellpadding="3">
                      <tr>
                        <td bgcolor="#C4DEEE"><table id="baseInfo3" width="100%" cellpadding="0" cellspacing="0" bgcolor="#a6c6da">
                          <tr>
                            <td bgcolor="#FFFFFF" colspan="4">&nbsp;</td>
                          </tr>
                          <tr>
                            <td align="right" bgcolor="#FFFFFF"><input name="button1" type="button" onclick="javascript:location.href='../cemetery/cemetery_location_fast_tree.jsp';" class="button-z4" id="button1" value="墓区查询" /></td>
                            <td align="center" bgcolor="#FFFFFF"><input name="button2" type="button" onclick="javascript:location.href='../business/cemeteryRegistryController.fj?method=getCemeteryRegistryPageList&cemeteryRegistryType=1';" class="button-z4" id="button2" value="租用登记" /></td>
                            <td align="center" bgcolor="#FFFFFF"><input name="button3" type="button" onclick="javascript:location.href='../business/cemeteryRegistryController.fj?method=getCemeteryRegistryPageList&cemeteryRegistryType=3';" class="button-z4" id="button3" value="合葬登记" /></td>
                            <td align="left" bgcolor="#FFFFFF"><input name="button4" type="button" onclick="javascript:location.href='../business/cemeteryRegistryController.fj?method=getCemeteryRegistryPageList&cemeteryRegistryType=4';" class="button-z4" id="button4" value="迁出登记" /></td>
                          </tr>
                          <tr> 
                       	    <td bgcolor="#FFFFFF" colspan="4">&nbsp;</td>
                          </tr>
                        </table></td>
                      </tr>
                    </table>                    <!-- End 待归档提醒  -->                  <!-- Begin 待续租提醒  --><!-- End 待续租提醒  --></td>
                </tr>
              </table>
              <!-- End 快捷办公  -->
                    
               <table width="100%" border="0" cellspacing="0" cellpadding="0">
			       <tr>
			         <td>&nbsp;</td>
	               </tr>
	          </table>     
              
              <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
			        <td width="46%">
                    
			  <!-- Begin 待归档提醒  -->
			  <table width="200" border="0" cellspacing="0" cellpadding="0">
			    <tr>
			      <td width="20" align="right"><img src="../images/tab-01.jpg" width="8" height="27" /></td>
			      <td width="99" align="center" class="tab-img-01"> 待归档提醒 </td>
			      <td width="81" align="left" valign="bottom"><img src="../images/tab-03.jpg" /></td>
		        </tr>
			    </table>

			  <table width="98%" border="0" cellspacing="0" cellpadding="3">
			  <tr>
		          <td bgcolor="#C4DEEE"><table id="baseInfo" width="100%" cellpadding="0" cellspacing="1" bgcolor="#a6c6da">
		        <c:if test="${waitingArchivesList==null || waitingArchivesListSize==0}">
		        	<tr>
						<td height="30" align="center" bgcolor="#FFFFFF">&nbsp;</td>
						<td align="center" bgcolor="#FFFFFF">&nbsp;</td>
						<td align="center" bgcolor="#FFFFFF">&nbsp;</td>
						<td align="center" bgcolor="#FFFFFF">&nbsp;</td>
					</tr>
		        	<tr>
						<td height="30" align="center" bgcolor="#FFFFFF">&nbsp;</td>
						<td align="center" bgcolor="#FFFFFF">&nbsp;</td>
						<td align="center" bgcolor="#FFFFFF">&nbsp;</td>
						<td align="center" bgcolor="#FFFFFF">&nbsp;</td>
					</tr>
		        	<tr>
						<td height="30" align="center" bgcolor="#FFFFFF">&nbsp;</td>
						<td align="center" bgcolor="#FFFFFF">&nbsp;</td>
						<td align="center" bgcolor="#FFFFFF">&nbsp;</td>
						<td align="center" bgcolor="#FFFFFF">&nbsp;</td>
					</tr>
		        	<tr>
						<td height="30" align="center" bgcolor="#FFFFFF">&nbsp;</td>
						<td align="center" bgcolor="#FFFFFF">&nbsp;</td>
						<td align="center" bgcolor="#FFFFFF">&nbsp;</td>
						<td align="center" bgcolor="#FFFFFF">&nbsp;</td>
					</tr>
		        </c:if>
		        <c:forEach  var="en" items="${waitingArchivesList}" varStatus="status">
			        <c:choose>
			          	<c:when test="${status.count<=4}">
							<tr>
								<td height="30" align="center" bgcolor="#FFFFFF"><c:out value='${en.cemeteryLocation.cemeteryZone.parent.cemeteryZoneName}'/></td>
								<td align="center" bgcolor="#FFFFFF">
								<c:choose>
								   <c:when test="${en.cemeteryLocation.cemeteryType.cave=='1'}">单穴 </c:when>
								   <c:when test="${en.cemeteryLocation.cemeteryType.cave=='2'}">双穴 </c:when>
								   <c:when test="${en.cemeteryLocation.cemeteryType.cave=='3'}">多穴 </c:when>
			  					</c:choose>
								</td>
								<td align="center" bgcolor="#FFFFFF"><c:out value='${en.name}'/></td>
								<td align="center" bgcolor="#FFFFFF"><c:out value='${en.mobilePhone}'/></td>
							</tr>
						</c:when>
					</c:choose>
				</c:forEach>
				<c:if test="${waitingArchivesListSize>0 && waitingArchivesListSize<4}">
					<c:forEach var="i" begin="${waitingArchivesListSize}" end="3" varStatus="status">
						<tr>
							<td height="30" align="center" bgcolor="#FFFFFF">&nbsp;</td>
							<td align="center" bgcolor="#FFFFFF">&nbsp;</td>
							<td align="center" bgcolor="#FFFFFF">&nbsp;</td>
							<td align="center" bgcolor="#FFFFFF">&nbsp;</td>
						</tr>
					</c:forEach>
				</c:if>
	          </table></td>
	            </tr>
		      </table>
	          <!-- End 待归档提醒  -->
		      
              
              </td>
	            
			         <td width="46%" align="left">
                     
				<!-- Begin 待续租提醒  -->
				<table width="200" border="0" cellspacing="0" cellpadding="0">
				  <tr>
				    <td width="20" align="right"><img src="../images/tab-01.jpg" width="8" height="27" /></td>
				    <td width="99" align="center" class="tab-img-01"> 待续租提醒 </td>
				    <td width="81" align="left" valign="bottom"><img src="../images/tab-03.jpg" /></td>
			      </tr>
				  </table>

				<table width="98%" border="0" cellspacing="0" cellpadding="3">
				<tr>
		          <td bgcolor="#C4DEEE"><table id="baseInfo" width="100%" cellpadding="0" cellspacing="1" bgcolor="#a6c6da">
		        <c:if test="${waitingReletList==null || waitingReletListSize==0}">
		        	<tr>
						<td height="30" align="center" bgcolor="#FFFFFF">&nbsp;</td>
						<td align="center" bgcolor="#FFFFFF">&nbsp;</td>
						<td align="center" bgcolor="#FFFFFF">&nbsp;</td>
						<td align="center" bgcolor="#FFFFFF">&nbsp;</td>
					</tr>
		        	<tr>
						<td height="30" align="center" bgcolor="#FFFFFF">&nbsp;</td>
						<td align="center" bgcolor="#FFFFFF">&nbsp;</td>
						<td align="center" bgcolor="#FFFFFF">&nbsp;</td>
						<td align="center" bgcolor="#FFFFFF">&nbsp;</td>
					</tr>
		        	<tr>
						<td height="30" align="center" bgcolor="#FFFFFF">&nbsp;</td>
						<td align="center" bgcolor="#FFFFFF">&nbsp;</td>
						<td align="center" bgcolor="#FFFFFF">&nbsp;</td>
						<td align="center" bgcolor="#FFFFFF">&nbsp;</td>
					</tr>
		        	<tr>
						<td height="30" align="center" bgcolor="#FFFFFF">&nbsp;</td>
						<td align="center" bgcolor="#FFFFFF">&nbsp;</td>
						<td align="center" bgcolor="#FFFFFF">&nbsp;</td>
						<td align="center" bgcolor="#FFFFFF">&nbsp;</td>
					</tr>
		        </c:if>
		        <c:forEach  var="en" items="${waitingReletList}" varStatus="status">
			        <c:choose>
			          	<c:when test="${status.count<=4}">
							<tr>
								<td height="30" align="center" bgcolor="#FFFFFF"><c:out value='${en.cemeteryLocation.cemeteryZone.parent.cemeteryZoneName}'/></td>
								<td align="center" bgcolor="#FFFFFF">
								<c:choose>
								   <c:when test="${en.cemeteryLocation.cemeteryType.cave=='1'}">单穴 </c:when>
								   <c:when test="${en.cemeteryLocation.cemeteryType.cave=='2'}">双穴 </c:when>
								   <c:when test="${en.cemeteryLocation.cemeteryType.cave=='3'}">多穴 </c:when>
			  					</c:choose>
								</td>
								<td align="center" bgcolor="#FFFFFF"><c:out value='${en.name}'/></td>
								<td align="center" bgcolor="#FFFFFF"><c:out value='${en.mobilePhone}'/></td>
							</tr>
						</c:when>
					</c:choose>
				</c:forEach>
				<c:if test="${waitingReletListSize>0 && waitingReletListSize<4}">
					<c:forEach var="i" begin="${waitingReletListSize}" end="3" varStatus="status">
						<tr>
							<td height="30" align="center" bgcolor="#FFFFFF">&nbsp;</td>
							<td align="center" bgcolor="#FFFFFF">&nbsp;</td>
							<td align="center" bgcolor="#FFFFFF">&nbsp;</td>
							<td align="center" bgcolor="#FFFFFF">&nbsp;</td>
						</tr>
					</c:forEach>
				</c:if>
	          </table></td>
	            </tr>
		      </table>
				<!-- End 待续租提醒  -->
				</td>
				</tr>
                </table>
              
		 </td>
		</tr>
	</table>
</body>
</html>
