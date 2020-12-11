<%@page contentType="text/html; charset=EUC-KR"%>
<%
		session.invalidate();//세션을 서버에서 제거한다.
		response.sendRedirect("scopeBean.jsp");
%>
