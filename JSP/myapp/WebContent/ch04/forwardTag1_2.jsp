<%@ page  contentType="text/html; charset=EUC-KR"%>
<%
		request.setCharacterEncoding("EUC-KR");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
%>
<!--  이페이지가 클라이언트 한테 응답한다. -->
id : <%=id%><br>
pwd : <%=pwd%><BR>