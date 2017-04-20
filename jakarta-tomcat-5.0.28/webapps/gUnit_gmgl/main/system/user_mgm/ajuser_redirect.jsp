<%@page contentType="text/html; charset=GBK" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<c:redirect url="/tree/userOrder.do?method=listUserforOrder&deptid=${param.deptid}&dept=${param.dept}&type=${param.type}" />
   
