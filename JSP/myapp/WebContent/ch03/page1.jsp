<%@page contentType="text/html; charset=EUC-KR"
                  import="java.util.*"   
                  import="java.net.*
                  
%>
<%@page session="true" buffer="16kb"%>
<%
		request.setCharacterEncoding("EUC-KR");
		Date d = new Date();
		//최초 사이트 접속시 세션이 만들어 지고 세션id를 부여받는다.
		String sessionId = session.getId();
%>
현재의 날짜와 시간은? <%=d.toLocaleString() %><br>
세션id : <%=sessionId %>
