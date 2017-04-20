<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ include file="../common/head.jsp"%>
<head>
 
</head>

<body style="background-color: transparent">
	<table width="100%" border="0" cellspacing="0" cellpadding="0"
		height="100%">
		<tr>
			<td width="11" valign="top" class="td-bg"><img
				src="../images/right-1.jpg" />
			</td>
			<td align="center" valign="top">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td height="31" align="left" valign="middle"
							style="background: url(../images/right-3.jpg)"><img
							src="../images/right-4.jpg" width="9" height="8"
							align="absmiddle" /> 当前位置 &gt; 售后管理 &gt; 承租人信息变更</td>
					</tr>
					<tr>
						<td bgcolor="#FFFFFF" style="font-size: 12px;">&nbsp;</td>
					</tr>
				</table> <!-- 输入域 --> <!-- Begin 承租人信息  -->
				<table width="98%" border="0" align="center" cellpadding="0"
					cellspacing="0">
					<tr>
						<td width="92%" bgcolor="#EBF4FA"><table width="200"
								border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td width="20" align="right"><img
										src="../images/tab-01.jpg" width="8" height="27" />
									</td>
									<td width="99" align="center" class="tab-img-01">承租人信息</td>
									<td width="81" align="left" valign="bottom"><img
										src="../images/tab-03.jpg" />
									</td>
								</tr>
							</table>
						</td>

					</tr>
				</table>
               <form action="cemeteryTenantryController.fj?method=saveCemeteryTenantryEdit" method='post'>
				<table width="98%" border="0" cellspacing="0" cellpadding="3">
					<tr>
						<td bgcolor="#C4DEEE"><table id="baseInfo" width="100%"
								cellpadding="0" cellspacing="1" bgcolor="#a6c6da">
								<tr>
									<tr>
										<td height="35" align="right" bgcolor="#D4E5F4">姓名：</td>
										<td align="left" bgcolor="#FFFFFF">&nbsp;&nbsp;<c:out value='${entity.name}'/><span class="word-7">*</span> 
										</td>
										<td align="right" bgcolor="#D4E5F4">性别：</td>
										<td align="left" bgcolor="#FFFFFF">&nbsp; 
										   <c:if test="${entity.sex=='1'}">男</c:if>   
		                                     <c:if test="${entity.sex=='0'}">女</c:if> 
		                                     &nbsp;&nbsp;<span class="word-7">*</span>   
                                        </td>

									</tr>

									<tr>
										<td height="35" align="right" bgcolor="#D4E5F4">民族：</td>
										<td align="left" bgcolor="#FFFFFF">&nbsp; 
										  <ft:dict value='${entity.nation}'/> 
										</td>
										<td align="right" bgcolor="#D4E5F4">国籍：</td>
										<td align="left" bgcolor="#FFFFFF">&nbsp; 
										
										<ft:dict value='${entity.nationality}'/>
										    
										</td>
									</tr>
									<tr>
										<td height="35" align="right" bgcolor="#D4E5F4">证件类型：</td>
										<td align="left" bgcolor="#FFFFFF">&nbsp; 
										    <ft:dict value='${entity.cardType}'/>
                                            <span class="word-7">*</span> 
										</td>
										<td align="right" bgcolor="#D4E5F4">证件证号：</td>
										<td align="left" bgcolor="#FFFFFF">&nbsp; <c:out value='${entity.cardNum}'/><span class="word-7">*</span> 
                                         </td>
									</tr>



									<tr>
										<td height="35" align="right" bgcolor="#D4E5F4">户口所在地：</td>
										<td align="left" colspan="3" bgcolor="#FFFFFF">&nbsp; 
										   <ft:dict value='${entity.province}'/> &nbsp;&nbsp;&nbsp;
										   <ft:dict value='${entity.county}'/>
										</td>

									</tr>
									<tr>
										<td height="35" align="right" bgcolor="#D4E5F4">家庭地址：</td>
										<td align="left" bgcolor="#FFFFFF">&nbsp; <c:out value='${entity.famliyAddress}'/>
										</td>
										<td align="right" bgcolor="#D4E5F4">家庭邮编：</td>
										<td align="left" bgcolor="#FFFFFF">&nbsp;  <c:out value='${entity.famliyZip}'/>
										</td>
									</tr>
									<tr>
										<td height="35" align="right" bgcolor="#D4E5F4">单位地址：</td>
										<td align="left" bgcolor="#FFFFFF">&nbsp; <c:out value='${entity.companyAddress}'/>
										</td>
										<td align="right" bgcolor="#D4E5F4">单位邮编：</td>
										<td align="left" bgcolor="#FFFFFF">&nbsp; <c:out value='${entity.companyZip}'/>
										</td>
									</tr>
									<tr>
										<td height="35" align="right" bgcolor="#D4E5F4">固定电话：</td>
										<td align="left" bgcolor="#FFFFFF">&nbsp;   <c:out value='${entity.famliyTel}'/>
										</td>
										<td align="right" bgcolor="#D4E5F4">移动电话：</td>
										<td align="left" bgcolor="#FFFFFF">&nbsp; <c:out value='${entity.mobilePhone}'/>
										 &nbsp;&nbsp;<span class="word-7">*</span> 
										</td>
									</tr>
									<tr>
										<td height="35" align="right" bgcolor="#D4E5F4">单位电话：</td>
										<td align="left" bgcolor="#FFFFFF">&nbsp; <c:out value='${entity.companyTel}'/>
										</td>
										<td align="right" bgcolor="#D4E5F4">电子邮件：</td>
										<td align="left" bgcolor="#FFFFFF">&nbsp; <c:out value='${entity.email}'/>
										</td>
									</tr>
									<tr>
										<td width="15%" height="35" align="right" bgcolor="#D4E5F4">变更人：</td>
										<td width="35%" align="left" bgcolor="#FFFFFF">&nbsp;&nbsp;<gOS_shjz:shjzUser key="${entity.createUserId}"/></td>
										<td width="15%" align="right" bgcolor="#D4E5F4">变更日期：</td>
										<td width="35%" align="left" bgcolor="#FFFFFF">&nbsp;&nbsp;<fmt:formatDate value='${entity.createDate}' pattern="yyyy-MM-dd"/></td>
									</tr>
									<tr>
										<td height="50px" align="right" bgcolor="#D4E5F4">变更原因：</td>
										<td colspan='3' align="left" bgcolor="#FFFFFF">&nbsp; <c:out value="${entity.changeResone}"/></td>
									</tr>
									<tr>
										<td height="50px" align="right" bgcolor="#D4E5F4">备注：</td>
										<td colspan='3' align="left" bgcolor="#FFFFFF">&nbsp;<c:out value='${entity.changeRemark}'/></textarea>
										</td>
									</tr>
									<tr>
										<td height="50px" align="left" bgcolor="#FFFFFF" colspan='4'><font
											color='red'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;变更内容：<c:out value='${entity.changeContent}'/></font>
										</td>

									</tr>
							</table>
						</td>

					</tr>
				</table> <!-- End 承租人信息  --> <!-- 保存 -->
					<table width="98%" cellpadding="0" cellspacing="0">
						<tr>
							<td height="60" width="44%" align="right"></td>
							 
							<td height="60" width="6%" align="center">&nbsp;&nbsp; <input
								name="button" type="button" class="button-z" id="button"
								onclick="javascirpt:location.href='archivesCemeteryRegistryController.fj?method=getArchivesCemeteryRegistryPageList'" 
								
								value="返回"  /></td>
							<td height="60" width="44%" align="right"></td>
						</tr>
					</table>
				</form>
				</td>
		</tr>
	</table>
</body>
</html>
