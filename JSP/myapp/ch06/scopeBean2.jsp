<%@page contentType="text/html; charset=EUC-KR"%>
<%
		session.invalidate();//������ �������� �����Ѵ�.
		response.sendRedirect("scopeBean.jsp");
%>
