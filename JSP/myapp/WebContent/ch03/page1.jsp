<%@page contentType="text/html; charset=EUC-KR"
                  import="java.util.*"   
                  import="java.net.*
                  
%>
<%@page session="true" buffer="16kb"%>
<%
		request.setCharacterEncoding("EUC-KR");
		Date d = new Date();
		//���� ����Ʈ ���ӽ� ������ ����� ���� ����id�� �ο��޴´�.
		String sessionId = session.getId();
%>
������ ��¥�� �ð���? <%=d.toLocaleString() %><br>
����id : <%=sessionId %>
