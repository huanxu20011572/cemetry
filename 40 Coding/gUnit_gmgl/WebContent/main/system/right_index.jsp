<%@ page language="java" contentType="text/html;charset=GBK" %>
<%@ taglib uri="/WEB-INF/tld/gTaglib-gOS.tld" prefix="gOS" %>
<%@page import="com.topsuntech.gOS.user.session.*" %>
<%@page import="com.topsuntech.gOS.user.en.user.*" %>
<%
	User user = UserSession.getUser(request);
	long deptId = 2;
	long creatorid = 280l;
	if (user!=null) {
		deptId = user.getDeptid();
		creatorid = user.getId().longValue();
	}
%>
<html>
<head>
<title>Untitled Document</title>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<gOS:skin />
</head>

<body bgcolor="#FFFFFF" text="#000000" leftmargin="0" topmargin="0">
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table10">
  <tr> 
    <td valign="top"> <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table7">
        <tr> 
          <td height="17"><font color="#000000"><strong>&nbsp;���ù���</strong></font>
          </td>
        </tr>
      </table>
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table11">
	  <tr> 
	    <td height="20" align="right">&nbsp;</td>
	  </tr>
	</table>	
     <table width="100%" border="0" cellpadding="1" class="ConfigTable">
        <tr class="tr2"> 
                    <td width="22%" align="center">����</td>
                    <td width="78%"><font face="����">����</font></td>
        </tr>
        
    <gOS:priority unitID="gEU_mhpz" priority="MHPZ-01,MHPZ-02,MHPZ-03,MHPZ-04,MHPZ-05,MHPZ-06">	
    	<tr class="td14">
    		<td width="15%"><img src="images/arrow_icon.gif" width="20" height="16"></td>
          	<td width="85%">�Ż����ù���</td>
    	</tr>
		<tr class="tr3" > 
                    <td height="34" align="center"><a href="<gOS:url>/allConfig/home/firstcatList.do?action=list</gOS:url>">��ҳ����</a></td>                    
          			<td height="34" align="left">��ҳ��������ҳ�����ú�ά��,��������Ԥ�����ú���������á�</td>
        </tr>
        </gOS:priority>
        
        <gOS:priority unitID="gEU_mhpz" priority="MHPZ-02"> 
			  <tr> 
                
          <td height="33" align="center"><a href="<gOS:url>/allConfig/user/eofficeList.do?action=list</gOS:url>"  target="mainFrame">������������</a></td>
                
          <td height="33" align="left">����������ҳͼƬ��������ӵ�ַ�Ķ�̬����</td>
              </tr>
       </gOS:priority>
	   
	   <gOS:priority unitID="gEU_mhpz" priority="MHPZ-02"> 
			  <tr> 
                
          <td height="33" align="center"><a href="<gOS:url>/allConfig/user/statisticsList.do?action=list</gOS:url>"  target="mainFrame">ͳ��ͼ����</a></td>
                
          <td height="33" align="left">ͳ��ͼ�Ĺ���</td>
              </tr>
       </gOS:priority>
       
       <gOS:priority unitID="gEU_mhpz" priority="MHPZ-03">
			  <tr> 
                <td height="34" align="center"><a href="<gOS:url>/allConfig/user/rlinkList.do?action=list</gOS:url>"  target="mainFrame">�����վ����</a></td>
                <td height="34" align="left">�����վ���ӵ�ַ�Ķ�̬����</td>
              </tr>
       </gOS:priority>
              
       <gOS:priority unitID="gEU_mhpz" priority="MHPZ-04">
			  <tr height="34" align="center"> 
                <td height="34" align="center"><a href="<gOS:url>/allConfig/user/topicList.do?action=list</gOS:url>"  target="mainFrame">���ϵ������</a></td>
                <td height="34" align="left">���ϵ������</td>
              </tr>
      </gOS:priority>

	  <gOS:priority unitID="gEU_mhpz" priority="MHPZ-05">
			  <tr height="34" align="center"> 
                <td height="34" align="center"><a href="<gOS:url>/allConfig/user/mzfgList.do?action=list</gOS:url>"  target="mainFrame">������������</a></td>
                <td height="34" align="left">������������ӵ�ַ�Ķ�̬����</td>
              </tr>
      </gOS:priority>
      <gOS:priority unitID="gEU_mhpz" priority="MHPZ-06">
                <tr height="34" align="center"> 
                <td height="34" align="center"><a href="<gOS:url>/allConfig/user/styleList.do?action=list</gOS:url>"  target="mainFrame">����ƽ̨���ù���</a></td>
                <td height="34" align="left">���ö���ƽ̨�Ĵ��ҽ��ܡ���λְ����������ʾ���</td>
              </tr>
	</gOS:priority>              
              
	<gOS:priority unitID="gEU_cjxt" priority="CJXT-02,CJXT-03,CJXT-04,CJXT-05,CJXT-06,CJXT-07">  
		<tr class="td14">
    		<td width="15%"><img src="images/arrow_icon.gif" width="20" height="16"></td>
          	<td width="85%">����ϵͳ����</td>
    	</tr> 
        <gOS:priority unitID="gEU_cjxt" priority="CJXT-02">
        <tr class="tr3" > 
                    <td width="22%" height="34" align="center"><a href="office_mgm/officeSelect.do?action=list">��֯��������</a></td>
                    <td width="78%" height="34" align="left">��֯����������ɶ�������Ӧ��ϵͳ�е����в��ŵĴ����͹���֧�����޼��Ĳ��Ŵ�����֧�ֲ����ƶ����û��ƶ��� 
          </td>
        </tr>
        </gOS:priority>        
        <gOS:priority unitID="gEU_cjxt" priority="CJXT-03">
        <tr class="tr3" > 
                    <td width="22%" height="34" align="center"><a href="user_mgm/userSelect.do?action=list">�����û�����</a></td>
                    <td width="78%" height="34" align="left">�����û�������ϵͳ�������û��Ĺ����ά���� 
          </td>
        </tr>        
        </gOS:priority>
        <gOS:priority unitID="gEU_cjxt" priority="CJXT-04">
        <tr class="tr3" > 
                    <td height="34" align="center"><a href="priority_mgm/actorSelect.do?action=list">��ɫ����</a></td>
                    <td height="34" align="left">����ϵͳ�еĽ�ɫ��ϸ����Ȩ�޵����ã���ɫ��һ��Ȩ�޵���ϡ�</td>
        </tr>
        </gOS:priority>
        <gOS:priority unitID="gEU_cjxt" priority="CJXT-05">
        <tr class="tr3" > 
                    <td height="34" align="center"><a href="../applog/applog.do?action=list">������־����</a></td>
                    <td height="34" align="left">������־�������������־�Ĺ����ά����</td>
        </tr>
        </gOS:priority>
        <gOS:priority unitID="gEU_cjxt" priority="CJXT-06">
        <tr class="tr3" > 
                    <td height="34" align="center"><a href="office_mgm/region_list.jsp">�������</a></td>
                    <td height="34" align="left">������������������Ĺ����ά����</td>
        </tr>
        </gOS:priority>
        <gOS:priority unitID="gEU_cjxt" priority="CJXT-07">
        <tr class="tr3" > 
        	<td height="34" align="center"><a href="../gunit/index.jsp">ģ����Ȩ��װ��</a></td>
            <td height="34" align="left">ģ����Ȩ��װ�为����ģ����Ȩ�޵Ĺ����ά����ʵ�ֹ���ģ��Ŀɲ��</td>
        </tr>
        </gOS:priority>
        
        <!--����ϵͳ����Ա��ӵ�е�Ȩ��-->
        <tr class="tr3" > 
        	<td height="34" align="center"><a href="zxt_mgm/UserextSelect.do?action=list&creatorid=<%=creatorid%>&type=subman">������ϵͳ����Ա</a></td>
            <td height="34" align="left">������ϵͳ����Ա�������ӡ�ɾ����ϵͳ����Ա��ʵ��ϵͳ�ķּ�����</td>
        </tr>
        <tr class="tr3" > 
        	<td height="34" align="center"><a href="zxt_mgm/UserextSelect.do?action=list&creatorid=<%=creatorid%>&type=deptman">���û�������Ա</a></td>
            <td height="34" align="left">���û�������Ա�������ӡ�ɾ���ӻ�������Ա��ʵ�ֻ����ķּ�����</td>
        </tr>
        
        <tr class="tr3" > 
        	<td height="34" align="center"><a href="log_mgm/log_search.jsp">������־����Ա</a></td>
            <td height="34" align="left">������־����Ա�������ӡ�ɾ������־����Ա��ʵ����־�ķּ�����</td>
        </tr>
        
	</gOS:priority> 
	
	<gOS:priority unitID="gEU_zxtgl" priority="ZXTGL-02,ZXTGL-03,ZXTGL-04">
		<tr class="td14">
    		<td width="15%"><img src="images/arrow_icon.gif" width="20" height="16"></td>
          	<td width="85%">��ϵͳ����</td>
    	</tr> 
		<!--��ϵͳ����Ա��ӵ�е�Ȩ��-->
        <gOS:priority unitID="gEU_zxtgl" priority="ZXTGL-02">
        <tr class="tr3" > 
        	<td height="34" align="center"><a href="zxt_mgm/UserextSelect.do?action=list&creatorid=<%=creatorid%>&type=subman">�����¼���ϵͳ����Ա</a></td>
       		<td height="34" align="left">�����¼���ϵͳ����Ա�������ӡ�ɾ������ϵͳ���¼���ϵͳ����Ա��ʵ��ϵͳ�ķּ�����</td>
        </tr>
        
        <tr class="tr3" > 
        	<td height="34" align="center"><a href="zxt_mgm/UserextSelect.do?action=listUser&creatorid=<%=creatorid%>&type=subman">����ϵͳ�û�����</a></td>
       		<td height="34" align="left">����ϵͳ�û�����Ա���ϵͳ�ڵ��û����й���</td>
        </tr>
        </gOS:priority>
        
       <!--�ӻ�������Ա��ӵ�е�Ȩ��-->
        <gOS:priority unitID="gEU_zxtgl" priority="ZXTGL-03">
        <tr class="tr3" > 
        	<td height="34" align="center"><a href="zxt_mgm/UserextSelect.do?action=list&creatorid=<%=creatorid%>&type=deptman">�����¼���������Ա</a></td>
       		<td height="34" align="left">�����¼���������Ա�������ӡ�ɾ������ϵͳ���¼���������Ա��ʵ�ֻ����ķּ�����</td>
        </tr>
        
        <tr class="tr3" > 
        	<td height="34" align="center"><a href="zxt_mgm/UserextSelect.do?action=listOffice&creatorid=<%=creatorid%>&type=deptman">����ϵͳ��������</a></td>
       		<td height="34" align="left">����ϵͳ��������Ա���ϵͳ�ڵĻ������й���</td>
        </tr>
        </gOS:priority>
        
        <!--����־����Ա��ӵ�е�Ȩ��-->
             	
             	<gOS:priority unitID="gEU_zxtgl" priority="ZXTGL-04">
             <tr class="tr3" >
                <td height="34" align="center"><a href="zxt_mgm/UserextSelect.do?action=list&creatorid=<%=creatorid%>&type=logman">�����¼���־����Ա</a></td>
                <td height="34" align="left">�����¼���־����Ա�������ӡ�ɾ������ϵͳ���¼�Ӧ����־����Ա��ʵ����־�ķּ�����</td>
              </tr>
              <tr class="tr3" >
              	<td height="34" align="center"><a href="../applog/applog.do?action=list">����ϵͳ��־����</a></td>
       			<td height="34" align="left">����ϵͳ��־����Ա���ϵͳ�ڵ�Ӧ����־���й���</td>
                
              </tr>
             	</gOS:priority>     
        
     </gOS:priority>
      </table> </td>
  </tr>
</table>
</body>
</html>
