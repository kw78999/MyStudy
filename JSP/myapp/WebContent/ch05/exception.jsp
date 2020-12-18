
<%@ page  contentType="text/html; charset=EUC-KR"
			   errorPage="error.jsp"
%>
<%
		request.setCharacterEncoding("EUC-KR");
		int a = Integer.parseInt(request.getParameter("num"));
		
%>
num : <%= a%>