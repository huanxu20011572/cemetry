<%@ page contentType="text/html; charset=gb2312" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib uri="/WEB-INF/tld/gTaglib-gOS.tld" prefix="gOS" %>
<%
/**
 *  ���ã����ڸ���ҳ�������ɶ�̬HTML
 */
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head></head>
<body>
<form name="iFrameForm" method="post">
<html:errors />
    <!--���С��-->
    <c:if test="${param.type == 'typeB'}">
        <textarea name="iFrameValue">
            <gOS:select name="type_b" items="${nodeList}" keyProperty="node_value" valueProperty="node_name" onchange="getSpecification()">
                <gOS:option key="" value="ѡ��С������" />
            </gOS:select>
        </textarea>
        <script language="javaScript">
            var str = iFrameForm.iFrameValue.value;
            if (str != '') {
                parent.makeTypeB(str);
            }
        </script>
    </c:if>
    <!--��ӹ��-->
    <c:if test="${param.type == 'specification'}">
        <textarea name="iFrameValue">
            <gOS:select name="specification" items="${nodeList}" keyProperty="node_value" valueProperty="node_name"/>
        </textarea>
        <script language="javaScript">
            var str = iFrameForm.iFrameValue.value;
            if (str != '') {
                parent.makeSpecification(str);
            }
        </script>
    </c:if>
</form>
</body>
</html>