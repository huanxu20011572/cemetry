package org.apache.jsp.reportJsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.*;

public final class myError2_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  public java.util.List getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    JspFactory _jspxFactory = null;
    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;


    try {
      _jspxFactory = JspFactory.getDefaultFactory();
      response.setContentType("text/html;charset=GBK");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n\n<head>\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=GBK\" />\n<title>错误信息</title>\n<style>\n* { margin:0; padding:0;}\nbody { text-align:center; font:75% Verdana, Arial, Helvetica, sans-serif;}\nh1 { font:125% Arial, Helvetica, sans-serif; text-align:left; font-weight:bolder; background:#333;  padding:3px; display:block; color:#99CC00}\n.class1 { width:90%; background:#CCC; position:relative; margin:0 auto; padding:5px;}\nspan { position:absolute; right:10px; top:8px; cursor:pointer; color:yellow;}\np { text-align:left; line-height:20px; background:#333; padding:3px; margin-top:5px; color:#99CC00}\n#class1content { height:400px;overflow:auto}\n</style>\n<script>\nfunction $(element){\nreturn element = document.getElementById(element);\n}\nfunction $D(){\nvar d=$('class1content');\nvar h=d.offsetHeight;\nvar maxh=400;\nfunction dmove(){\nh+=50; //设置层展开的速度\nif(h>=maxh){\nd.style.height='400px';\nclearInterval(iIntervalId);\n}else{\nd.style.display='block';\nd.style.height=h+'px';\n}\n}\niIntervalId=setInterval(dmove,2);\n}\nfunction $D2(){\n");
      out.write("var d=$('class1content');\nvar h=d.offsetHeight;\nvar maxh=400;\nfunction dmove(){\nh-=50;//设置层收缩的速度\nif(h<=0){\nd.style.display='none';\nclearInterval(iIntervalId);\n}else{\nd.style.height=h+'px';\n}\n}\niIntervalId=setInterval(dmove,2);\n}\nfunction $use(){\nvar d=$('class1content');\nvar sb=$('stateBut');\nif(d.style.display=='none'){\n$D();\nsb.innerHTML='收缩';\n}else{\n$D2();\nsb.innerHTML='查看详细信息';\n}\n}\n</script>\n</head>\n<body >\n<div class=\"class1\">\n");

	Exception e = ( Exception ) request.getAttribute( "exception" );
	out.println( "<h1>信息：</h1><div style='color:red'>" + e.getMessage() + "</div>" );
	

      out.write("\n<span id=\"stateBut\" onclick=\"$use()\">查看详细信息</span>\n<p id=\"class1content\" style=\"display:none\">\n");
 //e.printStackTrace(new PrintWriter(out)); 
java.io.StringWriter jsOutput = new StringWriter(); 
PrintWriter jsContentWriter = new PrintWriter(jsOutput); 
e.printStackTrace(jsContentWriter);
java.util.StringTokenizer st = new java.util.StringTokenizer(jsOutput.toString(),"\t");
while (st.hasMoreTokens()) {
	out.println(st.nextToken()+"<br>&nbsp;&nbsp;&nbsp;&nbsp;");
}

      out.write("</p>\n</div>\n</body>\n</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (pageContext != null) pageContext.handlePageException(t);
      }
    } finally {
      if (_jspxFactory != null) _jspxFactory.releasePageContext(pageContext);
    }
  }
}
