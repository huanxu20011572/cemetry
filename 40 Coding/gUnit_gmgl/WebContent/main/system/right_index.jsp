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
          <td height="17"><font color="#000000"><strong>&nbsp;配置管理：</strong></font>
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
                    <td width="22%" align="center">功能</td>
                    <td width="78%"><font face="宋体">描述</font></td>
        </tr>
        
    <gOS:priority unitID="gEU_mhpz" priority="MHPZ-01,MHPZ-02,MHPZ-03,MHPZ-04,MHPZ-05,MHPZ-06">	
    	<tr class="td14">
    		<td width="15%"><img src="images/arrow_icon.gif" width="20" height="16"></td>
          	<td width="85%">门户配置管理</td>
    	</tr>
		<tr class="tr3" > 
                    <td height="34" align="center"><a href="<gOS:url>/allConfig/home/firstcatList.do?action=list</gOS:url>">首页管理</a></td>                    
          			<td height="34" align="left">首页管理负责首页的配置和维护,包括天气预报设置和跑马灯设置。</td>
        </tr>
        </gOS:priority>
        
        <gOS:priority unitID="gEU_mhpz" priority="MHPZ-02"> 
			  <tr> 
                
          <td height="33" align="center"><a href="<gOS:url>/allConfig/user/eofficeList.do?action=list</gOS:url>"  target="mainFrame">数字民政管理</a></td>
                
          <td height="33" align="left">数字民政首页图片和相关链接地址的动态配置</td>
              </tr>
       </gOS:priority>
	   
	   <gOS:priority unitID="gEU_mhpz" priority="MHPZ-02"> 
			  <tr> 
                
          <td height="33" align="center"><a href="<gOS:url>/allConfig/user/statisticsList.do?action=list</gOS:url>"  target="mainFrame">统计图管理</a></td>
                
          <td height="33" align="left">统计图的管理</td>
              </tr>
       </gOS:priority>
       
       <gOS:priority unitID="gEU_mhpz" priority="MHPZ-03">
			  <tr> 
                <td height="34" align="center"><a href="<gOS:url>/allConfig/user/rlinkList.do?action=list</gOS:url>"  target="mainFrame">相关网站管理</a></td>
                <td height="34" align="left">相关网站链接地址的动态配置</td>
              </tr>
       </gOS:priority>
              
       <gOS:priority unitID="gEU_mhpz" priority="MHPZ-04">
			  <tr height="34" align="center"> 
                <td height="34" align="center"><a href="<gOS:url>/allConfig/user/topicList.do?action=list</gOS:url>"  target="mainFrame">网上调查管理</a></td>
                <td height="34" align="left">网上调查管理</td>
              </tr>
      </gOS:priority>

	  <gOS:priority unitID="gEU_mhpz" priority="MHPZ-05">
			  <tr height="34" align="center"> 
                <td height="34" align="center"><a href="<gOS:url>/allConfig/user/mzfgList.do?action=list</gOS:url>"  target="mainFrame">民政法规库管理</a></td>
                <td height="34" align="left">民政法规库链接地址的动态配置</td>
              </tr>
      </gOS:priority>
      <gOS:priority unitID="gEU_mhpz" priority="MHPZ-06">
                <tr height="34" align="center"> 
                <td height="34" align="center"><a href="<gOS:url>/allConfig/user/styleList.do?action=list</gOS:url>"  target="mainFrame">二级平台配置管理</a></td>
                <td height="34" align="left">配置二级平台的处室介绍、岗位职责描述、显示风格</td>
              </tr>
	</gOS:priority>              
              
	<gOS:priority unitID="gEU_cjxt" priority="CJXT-02,CJXT-03,CJXT-04,CJXT-05,CJXT-06,CJXT-07">  
		<tr class="td14">
    		<td width="15%"><img src="images/arrow_icon.gif" width="20" height="16"></td>
          	<td width="85%">超级系统管理</td>
    	</tr> 
        <gOS:priority unitID="gEU_cjxt" priority="CJXT-02">
        <tr class="tr3" > 
                    <td width="22%" height="34" align="center"><a href="office_mgm/officeSelect.do?action=list">组织机构管理</a></td>
                    <td width="78%" height="34" align="left">组织机构管理完成对于整个应用系统中的所有部门的创建和管理。支持无限级的部门创建，支持部门移动，用户移动。 
          </td>
        </tr>
        </gOS:priority>        
        <gOS:priority unitID="gEU_cjxt" priority="CJXT-03">
        <tr class="tr3" > 
                    <td width="22%" height="34" align="center"><a href="user_mgm/userSelect.do?action=list">所有用户管理</a></td>
                    <td width="78%" height="34" align="left">所有用户管理负责系统中所有用户的管理和维护。 
          </td>
        </tr>        
        </gOS:priority>
        <gOS:priority unitID="gEU_cjxt" priority="CJXT-04">
        <tr class="tr3" > 
                    <td height="34" align="center"><a href="priority_mgm/actorSelect.do?action=list">角色管理</a></td>
                    <td height="34" align="left">管理系统中的角色和细粒度权限的设置，角色是一组权限的组合。</td>
        </tr>
        </gOS:priority>
        <gOS:priority unitID="gEU_cjxt" priority="CJXT-05">
        <tr class="tr3" > 
                    <td height="34" align="center"><a href="../applog/applog.do?action=list">所有日志管理</a></td>
                    <td height="34" align="left">所有日志管理负责该所有日志的管理和维护。</td>
        </tr>
        </gOS:priority>
        <gOS:priority unitID="gEU_cjxt" priority="CJXT-06">
        <tr class="tr3" > 
                    <td height="34" align="center"><a href="office_mgm/region_list.jsp">区域管理</a></td>
                    <td height="34" align="left">区域管理负责该所有区域的管理和维护。</td>
        </tr>
        </gOS:priority>
        <gOS:priority unitID="gEU_cjxt" priority="CJXT-07">
        <tr class="tr3" > 
        	<td height="34" align="center"><a href="../gunit/index.jsp">模块与权限装配</a></td>
            <td height="34" align="left">模块与权限装配负责功能模块与权限的管理和维护，实现功能模块的可插拔</td>
        </tr>
        </gOS:priority>
        
        <!--超级系统管理员所拥有的权限-->
        <tr class="tr3" > 
        	<td height="34" align="center"><a href="zxt_mgm/UserextSelect.do?action=list&creatorid=<%=creatorid%>&type=subman">设置子系统管理员</a></td>
            <td height="34" align="left">设置子系统管理员可以增加、删除子系统管理员，实现系统的分级管理</td>
        </tr>
        <tr class="tr3" > 
        	<td height="34" align="center"><a href="zxt_mgm/UserextSelect.do?action=list&creatorid=<%=creatorid%>&type=deptman">设置机构管理员</a></td>
            <td height="34" align="left">设置机构管理员可以增加、删除子机构管理员，实现机构的分级管理</td>
        </tr>
        
        <tr class="tr3" > 
        	<td height="34" align="center"><a href="log_mgm/log_search.jsp">设置日志管理员</a></td>
            <td height="34" align="left">设置日志管理员可以增加、删除子日志管理员，实现日志的分级管理</td>
        </tr>
        
	</gOS:priority> 
	
	<gOS:priority unitID="gEU_zxtgl" priority="ZXTGL-02,ZXTGL-03,ZXTGL-04">
		<tr class="td14">
    		<td width="15%"><img src="images/arrow_icon.gif" width="20" height="16"></td>
          	<td width="85%">子系统管理</td>
    	</tr> 
		<!--子系统管理员所拥有的权限-->
        <gOS:priority unitID="gEU_zxtgl" priority="ZXTGL-02">
        <tr class="tr3" > 
        	<td height="34" align="center"><a href="zxt_mgm/UserextSelect.do?action=list&creatorid=<%=creatorid%>&type=subman">设置下级子系统管理员</a></td>
       		<td height="34" align="left">设置下级子系统管理员可以增加、删除本子系统的下级子系统管理员，实现系统的分级管理</td>
        </tr>
        
        <tr class="tr3" > 
        	<td height="34" align="center"><a href="zxt_mgm/UserextSelect.do?action=listUser&creatorid=<%=creatorid%>&type=subman">本子系统用户管理</a></td>
       		<td height="34" align="left">本子系统用户管理对本子系统内的用户进行管理</td>
        </tr>
        </gOS:priority>
        
       <!--子机构管理员所拥有的权限-->
        <gOS:priority unitID="gEU_zxtgl" priority="ZXTGL-03">
        <tr class="tr3" > 
        	<td height="34" align="center"><a href="zxt_mgm/UserextSelect.do?action=list&creatorid=<%=creatorid%>&type=deptman">设置下级机构管理员</a></td>
       		<td height="34" align="left">设置下级机构管理员可以增加、删除本子系统的下级机构管理员，实现机构的分级管理</td>
        </tr>
        
        <tr class="tr3" > 
        	<td height="34" align="center"><a href="zxt_mgm/UserextSelect.do?action=listOffice&creatorid=<%=creatorid%>&type=deptman">本子系统机构管理</a></td>
       		<td height="34" align="left">本子系统机构管理对本子系统内的机构进行管理</td>
        </tr>
        </gOS:priority>
        
        <!--子日志管理员所拥有的权限-->
             	
             	<gOS:priority unitID="gEU_zxtgl" priority="ZXTGL-04">
             <tr class="tr3" >
                <td height="34" align="center"><a href="zxt_mgm/UserextSelect.do?action=list&creatorid=<%=creatorid%>&type=logman">设置下级日志管理员</a></td>
                <td height="34" align="left">设置下级日志管理员可以增加、删除本子系统的下级应用日志管理员，实现日志的分级管理</td>
              </tr>
              <tr class="tr3" >
              	<td height="34" align="center"><a href="../applog/applog.do?action=list">本子系统日志管理</a></td>
       			<td height="34" align="left">本子系统日志管理对本子系统内的应用日志进行管理</td>
                
              </tr>
             	</gOS:priority>     
        
     </gOS:priority>
      </table> </td>
  </tr>
</table>
</body>
</html>
