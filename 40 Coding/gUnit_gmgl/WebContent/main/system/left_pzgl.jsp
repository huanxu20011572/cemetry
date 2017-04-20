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
<title>���ù���</title>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<gOS:skin />
<script src="../../../script/function.js" ></script>
</head>

<body  marginwidth="0" marginheight="0" onresize="f_resize_table()">

<table border="0" cellpadding="0" cellspacing="0" class="table9" id="_main_table">
	<tr> 
		<td valign="top">
			<table width="100%" border="0" cellpadding="0" cellspacing="0"  class="table6" >
		
	<gOS:priority unitID="gEU_cjxt" priority="CJXT-02,CJXT-03,CJXT-04,CJXT-05,CJXT-06,CJXT-07">   
	
		<tr class="td14"> 
          <td width="15%"><img src="images/arrow_icon.gif" width="20" height="16"></td>
          <td width="85%">����ϵͳ����</td>
        </tr>
        
        <tr> 
          <td colspan="2" align="right"> 
			<table width="100%" border="0"  class="table8">
	            <gOS:priority unitID="gEU_cjxt" priority="CJXT-02">
	            <tr> 
                <td width="15%"  class="td8"><img src="images/arrow_red.gif" width="8" height="7"></td>
                <td width="85%"><a href="office_mgm/officeSelect.do?action=list" target="mainFrame">��֯��������</a></td>
              </tr>
             	</gOS:priority>             
             	<gOS:priority unitID="gEU_cjxt" priority="CJXT-03">
              <tr> 
                <td  class="td8"><img src="images/arrow_red.gif" width="8" height="7"></td>
                <td><a href="user_mgm/userSelect.do?action=list" target="mainFrame">�����û�����</a></td>
              </tr>
              </gOS:priority>               
              <gOS:priority unitID="gEU_cjxt" priority="CJXT-04">
              <tr> 
                <td  class="td8"><img src="images/arrow_red.gif" width="8" height="7"></td>
                <td><a href="priority_mgm/actorSelect.do?action=list" target="mainFrame">��ɫ����</a></td>
              </tr>
              </gOS:priority>
              <gOS:priority unitID="gEU_cjxt" priority="CJXT-05">
              <tr> 
                <td  class="td8"><img src="images/arrow_red.gif" width="8" height="7"></td>
                <td><a href="../applog/applog.do?action=list" target="mainFrame">������־����</a></td>
              </tr> 
              </gOS:priority>
			  <gOS:priority unitID="gEU_cjxt" priority="CJXT-06">
              <tr> 
                <td  class="td8"><img src="images/arrow_red.gif" width="8" height="7"></td>
                <td><a href="office_mgm/region_list.jsp" target="mainFrame">�������</a></td>
              </tr> 
              </gOS:priority>
             <gOS:priority unitID="gEU_cjxt" priority="CJXT-07">
              <tr> 
                <td  class="td8"><img src="images/arrow_red.gif" width="8" height="7"></td>
                <td><a href="../gunit/index.jsp" target="mainFrame">ģ����Ȩ��װ��</a></td>
              </tr> 
              </gOS:priority>
              
              <!--����ϵͳ����Ա��ӵ�е�Ȩ��-->
              
              <tr> 
                <td width="15%"  class="td8"><img src="images/arrow_red.gif" width="8" height="7"></td>
                <td width="85%"><a href="zxt_mgm/UserextSelect.do?action=list&creatorid=<%=creatorid%>&type=subman" target="mainFrame">������ϵͳ����Ա</a></td>
              </tr>
              <tr> 
                <td width="15%"  class="td8"><img src="images/arrow_red.gif" width="8" height="7"></td>
                <td width="85%"><a href="zxt_mgm/UserextSelect.do?action=list&creatorid=<%=creatorid%>&type=deptman" target="mainFrame">���û�������Ա</a></td>
              </tr>
              
              <tr> 
                <td width="15%"  class="td8"><img src="images/arrow_red.gif" width="8" height="7"></td>
                <td width="85%"><a href="zxt_mgm/UserextSelect.do?action=list&creatorid=<%=creatorid%>&type=logman" target="mainFrame">������־����Ա</a></td>
              </tr>
              
            </table>
          </td>
        </tr>
        </gOS:priority> 
        
        <gOS:priority unitID="gEU_zxtgl" priority="ZXTGL-02,ZXTGL-03,ZXTGL-04">
        <tr class="td14"> 
          <td width="15%"><img src="images/arrow_icon.gif" width="20" height="16"></td>
          <td width="85%">��ϵͳ����</td>
        </tr>
        <tr> 
          <td colspan="2" align="right"> 
            <table width="100%" border="0"  class="table8">
             	<!--��ϵͳ����Ա��ӵ�е�Ȩ��-->
				<gOS:priority unitID="gEU_zxtgl" priority="ZXTGL-02">
              <tr> 
                <td width="15%"  class="td8"><img src="images/arrow_red.gif" width="8" height="7"></td>
                <td width="85%"><a href="zxt_mgm/UserextSelect.do?action=list&creatorid=<%=creatorid%>&type=subman" target="mainFrame">�����¼���ϵͳ����Ա</a></td>
              </tr>

              <tr> 
                <td width="15%"  class="td8"><img src="images/arrow_red.gif" width="8" height="7"></td>
                <td width="85%"><a href="zxt_mgm/UserextSelect.do?action=listUser&creatorid=<%=creatorid%>&type=subman" target="mainFrame">����ϵͳ�û�����</a></td>
              </tr>
             	</gOS:priority>   
             	<!--�ӻ�������Ա��ӵ�е�Ȩ��-->
             	<gOS:priority unitID="gEU_zxtgl" priority="ZXTGL-03">
              <tr> 
                <td width="15%"  class="td8"><img src="images/arrow_red.gif" width="8" height="7"></td>
                <td width="85%"><a href="zxt_mgm/UserextSelect.do?action=list&creatorid=<%=creatorid%>&type=deptman" target="mainFrame">�����¼���������Ա</a></td>
              </tr>
              <tr> 
                <td width="15%"  class="td8"><img src="images/arrow_red.gif" width="8" height="7"></td>
                <td width="85%"><a href="zxt_mgm/UserextSelect.do?action=listOffice&creatorid=<%=creatorid%>&type=deptman" target="mainFrame">���ӻ�������</a></td>
              </tr>
              <tr> 
                <td width="15%"  class="td8"><img src="images/arrow_red.gif" width="8" height="7"></td>
                <td width="85%"><a href="zxt_mgm/UserextSelect.do?action=listUser&creatorid=<%=creatorid%>&type=deptman" target="mainFrame">���ӻ����û�����</a></td>
              </tr>
             	</gOS:priority>  
             	
             	<!--����־����Ա��ӵ�е�Ȩ��-->
             	
             	<gOS:priority unitID="gEU_zxtgl" priority="ZXTGL-04">
              <tr> 
                <td width="15%"  class="td8"><img src="images/arrow_red.gif" width="8" height="7"></td>
                <td width="85%"><a href="zxt_mgm/UserextSelect.do?action=list&creatorid=<%=creatorid%>&type=logman" target="mainFrame">�����¼���־����Ա</a></td>
              </tr>
              <tr> 
                <td width="15%"  class="td8"><img src="images/arrow_red.gif" width="8" height="7"></td>
                <td width="85%"><a href="../applog/applog.do?action=list" target="mainFrame">����ϵͳ��־����</a></td>
              </tr>
             	</gOS:priority>     
             	       
            </table>
          </td>
        </tr>
		</gOS:priority> 
				
      </table>
    </td>
  </tr>
</table>
<script>
    f_resize_table();
</script>
</body>
</html>
