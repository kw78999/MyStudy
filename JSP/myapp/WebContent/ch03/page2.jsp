<%@page contentType="text/html; charset=EUC-KR" 
                  errorPage="error.jsp"
%>
<%
		request.setCharacterEncoding("EUC-KR");
		int a = 10, b= 0;
%>
��Ģ����<br>
a + b = <%=a+b %><br>
a - b = <%=a-b %><br>
a * b = <%=a*b %><br>
a / b = <%=a/b %><br>
