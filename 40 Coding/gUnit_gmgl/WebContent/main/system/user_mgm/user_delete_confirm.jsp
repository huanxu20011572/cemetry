<%@ page contentType="text/html; charset=GBK" %>
<%@ include file="../../../common/taglibs.jsp"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="http://www.topsuntech.com/jsptags/tree-taglib" prefix="topsuntech" %>
<%@page import="com.topsuntech.gOS.user.session.*" %>
<%@page import="com.topsuntech.gOS.user.en.user.*" %>
<%@page import="com.topsuntech.gOS.config.user.DeleteReason.dao.DeleteReasonFactory" %>
<%@page import="java.util.Collection" %>

<html>
<head>
<title>Untitled Document</title>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">

<script language="JavaScript">
<!--



function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}
//-->
</script>
<link href="../../css/css.css" rel="stylesheet" type="text/css">
</head>
<script>
	function onsubmit(){
		if(window.confirm('��ȷ��Ҫɾ����')){
			deleteConfirmForm.submit();
		}
	
	}
</script>

<%
	String sDeptId=request.getParameter("sDeptId");	
	if(sDeptId==null||sDeptId.length()==0)
	sDeptId="";
%>
<body bgcolor="#FFFFFF" text="#000000" leftmargin="0" topmargin="0">
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="11" height="31" valign="top" class="td-bg"><img src="../../../images/right-1.jpg" /></td>
    <td align="center" valign="top" ><table width="100%" border="0" cellpadding="0" cellspacing="0" class="word-8">
      <tr>
        <td height="31" align="left" valign="middle" style="background:url(../../../images/right-3.jpg)"><img src="../../../images/right-4.jpg" width="9" height="8" align="absmiddle" /> ��ǰλ�� &gt; ϵͳ���� &gt; �û�����</td>
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
		
		<tr id="tag1">
		  <td>
			<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td width="38" align="left" background="../../../images/images_49.jpg"><img src="../../../images/images_48.jpg" width="38" height="40"></td>
                <td background="../../../images/images_49.jpg"><span class="title">ɾ���û�
                  </span></td>
                <td align="right" background="../../../images/images_49.jpg">�����ˣ�
                <c:out value="${user.creatorname}"/>��ά�����ڣ�<fmt:formatDate value="${user.createdate}" pattern="yyyy-MM-dd"/></td>
                <td width="16" align="right" background="../../../images/images_49.jpg"><img src="../../../images/images_52.jpg" width="16" height="40"></td>
      </tr>
    </table>
			<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td width="16" background="../../../images/images_55.jpg">&nbsp;</td>
          <td align="center"><table width="98%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td height="14">&nbsp;</td>
              </tr>
            </table>
                  <TABLE width="100%" 
        border=0 cellPadding=1 cellSpacing=1 bgcolor="a8d1eb" class=table_main>
                    <TBODY>
                    	
                    	<TR>
                        <TD  colspan="4" height=30 align="right" class=td-01>                        	
                        	<table width="100%" border="0" class="table5">
											      <form name="deleteConfirmForm" action="deleteUser.do?&idyProcessService=userManager&doMethod=delete&id=<c:out value="${user.id}"/>&sDeptId=<%=sDeptId%>&inputPath=<c:out value='${param.inputPath}'/>" method="post">
											        <tr> 
											          <td class=td-01>��ѡ��ɾ��ԭ��
											          			<%
										                        Collection list = DeleteReasonFactory.getDeleteReasonConfig().getDeleteReasonbyAll();
										                        request.setAttribute("list", list);
										                    	%>
                                                <select id="deletereason" name="deletereason">
                                                    <c:forEach var="deletereason" items="${list}">
                                                        <option value='<c:out value="${deletereason.name}"/>' ><c:out value="${deletereason.name}"/></option>                                                
                                                    </c:forEach>
                                                </select><strong>��ȷ��Ҫɾ�����û���</strong>										              </td>
				              </tr>
											           
											           <tr>
											           		 <td align="center"><a href="javascript:onsubmit();"><img src="../../../images/but-qd.gif" width="66" height="27" border="0" ></a>��<a href="javascript:history.go(-1);"><img src="../../../images/but0qx.jpg" width="66" height="27" border="0" ></a></td>
											          </tr>
											        </form>
					      </table>                        </TD>
                   </tr>
                    	
                      <TR>
                        <TD width="15%" height=30 align="right" class=td-01>�û�ID��</TD>
                        <TD class=td-02 width="31%" height=30> <c:out value="${user.loginid}"/> </TD>
                         <td width="16%" align="right" class=td-01>��Ա��ţ� </td>       
                         <td width="38%" class=td-02><c:out value="${user.num}"/>			          	</td>
			          </tr>
                      <TR height=30>
                        <TD height=30 align="right" class=td-01>���᣺</TD>
                        <TD class=td-02 height=30><c:out value="${user.jiguan}"/></TD>
                        <TD height=30 align="right" class=td-01>�����أ�</TD>
                        <TD class=td-02 vAlign=top height=30><c:out value="${user.birthlocation}"/></TD>
                      </TR>
                      <TR>
                        <TD height=30 align="right" class=td-01>���ڴ��ң�</TD>
                       
          <td height=30 class=td-02 >          </td>
          <TD height=30 align="right" class=td-01>���ڵ�λ��</TD>
                       
          <td height=30 class=td-02 >          </td>
                      </TR>
                      <TR>
                        <TD height=30 align="right" class=td-01>������</TD>
                        <TD class=td-02 height=30><c:out value="${user.name}"/></TD>
                        <TD align="right" class=td-01>�Ա�</TD>
                        <TD class=td-02><c:out value="${user.gender}"/></TD>
                      </TR>
                      <TR height=30>
                        <TD height=30 align="right" class=td-01>�����أ�</TD>
                        <TD class=td-02 height=30><c:out value="${user.birthlocation}"/></TD>
                        <TD height=30 align="right" class=td-01>�μӹ���ʱ�䣺</TD>
                        <TD class=td-02 vAlign=top height=30><c:out value="${user.workyear}"/></TD>
                      </TR>
                      <TR>
                        <TD height=30 align="right" class=td-01>�������£�</TD>
                        <TD class=td-02 height=30><fmt:formatDate value="${user.birthday}" pattern="yyyy-MM-dd" /></TD>
                             
                        <TD height=30 align="right" class=td-01>���壺</TD>
                        <TD height=30 class=td-02>����                        </TD>
                      </TR>
                     <tr> 
          <td height=30 class=td-01 align="right">ѧ����</td>
          <td height=30 class=td-02>����</td>
          <td class=td-01 align="right">ѧλ��</td>
          <td class=td-02>ѧʿ</td>
        </tr>
        <tr> 
          <td height=30 class=td-01 align="right">ѧ����</td>
          <td height=30 class=td-02><c:out value="${user.xueli}"/></td>
          <td class=td-01 align="right">ѧλ��</td>
          <td class=td-02><c:out value="${user.xuewei}"/></td>
        </tr>
        <tr> 
          <td height=30 class=td-01 align="right">��ѧרҵ��</td>
          <td height=30 class=td-02><c:out value="${user.zhuanye}"/></td>
          <td class=td-01 align="right">��ҵԺУ��ʱ�䣺</td>
          <td class=td-02><c:out value="${user.yuanxiao}"/></td>
        </tr>
        <tr> 
          <td height=30 class=td-01 align="right">������ò��</td>
          <td height=30 class=td-02><c:out value="${user.zhengzhimianmao}"/></td>
          <td class=td-01 align="right">�뵳/��ʱ�䣺</td>
          <td class=td-02><c:out value="${user.rudangshijian}"/></td>
        </tr>
        <tr> 
          <td height=30 class=td-01 align="right">ְ�ƣ�</td>
          <td height=30 class=td-02><c:out value="${user.callname}"/></td>
          <td class=td-01 align="right">ְ��</td>
          <td class=td-02><c:out value="${user.positionid}"/></td>
        </tr>
        <tr> 
          <td height=30 class=td-01 align="right">���֤�ţ�</td>
          <td height=30 class=td-02><c:out value="${user.identitynum}"/></td>
          <td class=td-01 align="right">����֤�ţ�</td>
          <td class=td-02><c:out value="${user.worknum}"/></td>
        </tr>
        <tr> 
          <td height=30 class=td-01 align="right">��ͥ��ס��ַ��</td>
          <td height=30 class=td-02><c:out value="${user.address}"/></td>
          <td class=td-01 align="right">סլ�绰��</td>
          <td class=td-02><c:out value="${user.homephone}"/></td>
        </tr>
        <tr> 
          <td height=30 class=td-01 align="right">�칫�绰��</td>
          <td height=30 class=td-02><c:out value="${user.officephone}"/></td>
          <td class=td-01 align="right">�ƶ��绰��</td>
          <td class=td-02><c:out value="${user.mobile}"/></td>
        </tr>
        <tr> 
          <td height=30 class=td-01 align="right">������ţ�</td>
          <td height=30 class=td-02><c:out value="${user.publicmoneynum}"/></td>
          <td class=td-01 align="right">���ϱ��պţ�</td>
          <td class=td-02><c:out value="${user.oldsupportnum}"/></td>
        </tr>
        <tr> 
          <td height=30 class=td-01 align="right">ס�������ţ�</td>
          <td height=30 class=td-02><c:out value="${user.housepaynum}"/></td>
          <td class=td-01 align="right">ҽ�Ʊ��պţ�</td>
          <td class=td-02><c:out value="${user.securitynum}"/></td>
        </tr>
       
        <tr> 
          <td height="54" class=td-01 align="right">��ע��</td>
          <td height="54" colspan="3" class=td-02><c:out value="${user.memo}"/></td>
        </tr>
                    </TBODY>
                  </TABLE>                
                  <table width="98%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td height="14">&nbsp;</td>
                    </tr>
                  </table></td>
		  <td width="16" align="center" background="../../../images/images_57.jpg">&nbsp;</td>
        </tr>
            </table>
            <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
                <td width="16"><img src="../../../images/images_72.jpg" width="16" height="17"></td>
                <td background="../../../images/images_73.jpg">&nbsp;</td>
                <td width="16" align="right"><img src="../../../images/images_75.jpg" width="16" height="17"></td>
              </tr>
            </table></td>
          <td width="16">&nbsp;</td>
        </tr>
        <tr>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
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
