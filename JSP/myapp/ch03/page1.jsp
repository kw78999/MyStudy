<%@page import="java.util.Date"%>
<%@ page  contentType="text/html; charset=EUC-KR"
						import="java.util.*,java.sql.*"
						import="java.net.*"
	%>					
	<%@page session="true" buffer="16kb" %>
<%
		request.setCharacterEncoding("EUC-KR");
		Date d = new Date();
		//최초 사이트 접속시 세션이 만들어지고 세션id를 부여받는다
		String sessionId = session.getId();
%>
현재의 날짜와 시간은? <%=d.toLocaleString()%><br>
세션 아이디는 :  <%=sessionId%>