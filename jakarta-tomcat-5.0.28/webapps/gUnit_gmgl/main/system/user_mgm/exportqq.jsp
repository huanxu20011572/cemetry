<%@ page contentType="text/html; charset=GBK" %>
<%
	request.setCharacterEncoding("GBK");
	try {
			String filename = "D:\\out.txt";
			com.topsuntech.gOS.user.tools.UserToQQ.write(filename);
			
		} catch (Exception e) {
			e.printStackTrace();
			out.println("导出失败!");
		}
		out.println("导出成功!所导出的文件保存在服务器的\"D:\\out.txt\"");
%>
