<%@page contentType="text/html; charset=EUC-KR" 
                  errorPage="error.jsp"
%>
<%
		request.setCharacterEncoding("EUC-KR");
		int a = 10, b= 0;
%>
사칙연산<br>
a + b = <%=a+b %><br>
a - b = <%=a-b %><br>
a * b = <%=a*b %><br>
a / b = <%=a/b %><br>
