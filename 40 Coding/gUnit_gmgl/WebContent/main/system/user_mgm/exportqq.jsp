<%@ page contentType="text/html; charset=GBK" %>
<%
	request.setCharacterEncoding("GBK");
	try {
			String filename = "D:\\out.txt";
			com.topsuntech.gOS.user.tools.UserToQQ.write(filename);
			
		} catch (Exception e) {
			e.printStackTrace();
			out.println("����ʧ��!");
		}
		out.println("�����ɹ�!���������ļ������ڷ�������\"D:\\out.txt\"");
%>
